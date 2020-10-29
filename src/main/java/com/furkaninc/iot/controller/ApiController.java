package com.furkaninc.iot.controller;

import com.furkaninc.iot.service.IArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author furkaninc
 */

 //Rest mantigi ile ledi acip kapatmak icin controllerlar olusturuldu.
@RestController
public class ApiController {

    //<=======================================================================>
    private IArduinoService arduinoService;

    @Autowired
    public ApiController(IArduinoService arduinoService) {
        this.arduinoService = arduinoService;
    }//<=======================================================================>

    // Ledi yakan buton için controller.
    @PostMapping(value = "/ledOn")
    public ResponseEntity<String> ledOn() {
        arduinoService.ledOn();
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    // Ledi söndüren buton için controller.
    @PostMapping(value = "/ledOff")
    public ResponseEntity<String> ledOff() {
        arduinoService.ledOff();
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
