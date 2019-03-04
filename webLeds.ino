#include "Adafruit_FONA.h"
#define FONA_RX 11
#define FONA_TX 10
#define FONA_RST 4
int led1=5;
int led2=6;
char replybuffer[255];
#include <SoftwareSerial.h>
SoftwareSerial fonaSS = SoftwareSerial(FONA_TX, FONA_RX);
SoftwareSerial *fonaSerial = &fonaSS;
Adafruit_FONA fona = Adafruit_FONA(FONA_RST);
uint8_t type;
void setup() {
   // Initi serial
  while (!Serial);
  Serial.begin(115200);
  Serial.println(F("FONA reading SMS"));
  Serial.println(F("Initializing....(May take 3 seconds)"));

  fonaSerial->begin(4800);
  if (! fona.begin(*fonaSerial)) {
    Serial.println(F("Couldn't find FONA"));
    while (1);
  }
  type = fona.type();
  Serial.println(F("FONA is OK"));
  Serial.print(F("Found "));
  switch (type) {
    case FONA800L:
      Serial.println(F("FONA 800L")); break;
    case FONA800H:
      Serial.println(F("FONA 800H")); break;
    case FONA808_V1:
      Serial.println(F("FONA 808 (v1)")); break;
    case FONA808_V2:
      Serial.println(F("FONA 808 (v2)")); break;
    case FONA3G_A:
      Serial.println(F("FONA 3G (American)")); break;
    case FONA3G_E:
      Serial.println(F("FONA 3G (European)")); break;
    default: 
      Serial.println(F("???")); break;
  }
  
  // Print module IMEI number.
  char imei[15] = {0}; // MUST use a 16 character buffer for IMEI!
  uint8_t imeiLen = fona.getIMEI(imei);
  if (imeiLen > 0) {
    Serial.print("Module IMEI: "); Serial.println(imei);
  }

  // Setup GPRS settings
  fona.setGPRSNetworkSettings(F("web.tigo.rw"));
  //fona.setGPRSNetworkSettings(F("your_APN"), F("your_username"), F("your_password"));

  delay(1000);

  // Turn GPRS off & on again
  if (!fona.enableGPRS(false))
    Serial.println(F("Failed to turn off"));

  delay(1000);
 
  if (!fona.enableGPRS(true))
    Serial.println(F("Failed to turn on"));

  delay(1000);
  
  pinMode(led1,OUTPUT);
  pinMode(led2,OUTPUT);

}


void loop() {
        // read website URL
        uint16_t statuscode;
        int16_t length;
        //char url[80]="niyobuhungiroyv.000webhostapp.com/lamps/arduino.php";
        char url[80]="logggy0o-site.btempurl.com/arduino.php";
        Serial.println(F("****"));
        if (!fona.HTTP_GET_start(url, &statuscode, (uint16_t *)&length)) {
          Serial.print("Failed!");
          Serial.println(url);
        }
        String phrase;
        char ser;
        while (length > 0) {
          while (fona.available()) {
            char c = fona.read();
            // Serial.write is too slow, we'll write directly to Serial register!            
            //Serial.println(c);
            length--;                     
              phrase=String(phrase + c);        
            if (! length) break;
          }
        }
        Serial.println(phrase);
        Serial.println(F("\n****"));
        fona.HTTP_GET_end();
        if(phrase.indexOf("lamp1")!=-1){
          Serial.println("Lamp 1 Found");
          digitalWrite(led1,HIGH);
          digitalWrite(led2,LOW);
        }else if(phrase.indexOf("lamp2")!=-1){
          Serial.println("lamp2 Found");
          digitalWrite(led1,LOW);
          digitalWrite(led2,HIGH);
        }else if(phrase.indexOf("all_on")!=-1){
          Serial.println("All lamps should light");
          digitalWrite(led1,HIGH);
          digitalWrite(led2,HIGH);
        }else if(phrase.indexOf("all_off")!=-1){
          Serial.println("All lamps Should go off");
          digitalWrite(led1,LOW);
          digitalWrite(led2,LOW);
        }else{
          Serial.println("Sorry Nothing Supportable");
        }     
      delay(3000);
}
