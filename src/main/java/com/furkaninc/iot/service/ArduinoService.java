package com.furkaninc.iot.service;

import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.springframework.stereotype.Service;

/**
 *
 * @author furkaninc
 */
@Service
public class ArduinoService implements IArduinoService {

    // Arduinoya yüklenen firmata yazılımı ile kontrol bağlantı sağlar ve led yakar.
    @Override
    public void ledOn() {
        IODevice device = new FirmataDevice("COM5"); // port adini kullanildi
        try {
            device.start(); // device ile baglanti baslatiliyor
            device.ensureInitializationIsDone(); // baglantinin kurulmasi bekleniyor
            Pin pin = device.getPin(13);
            pin.setMode(Pin.Mode.OUTPUT); // listenerlara degisiklik eventi ataniyor
            pin.setValue(1); // pin value'su 1 olarak degistirildi
            device.stop(); // device ile baglanti kesildi
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Arduinoya yüklenen firmata yazılımı ile kontrol bağlantı sağlar ve ledi söndürür.
    @Override
    public void ledOff() {
        IODevice device = new FirmataDevice("COM5"); // port adi kullanildi
        try {
            device.start(); // device ile baglanti baslatiliyor
            device.ensureInitializationIsDone(); // baglantinin kurulmasi bekleniyor
            Pin pin = device.getPin(13);
            pin.setMode(Pin.Mode.OUTPUT); // listenerlara degisiklik eventi ataniyor
            pin.setValue(0); // pin value su 0 olarak degistirildi
            device.stop(); // device ile baglanti kesildi
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
