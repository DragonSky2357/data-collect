package com.example.datacollection.device.controller;

import com.example.datacollection.device.dto.request.AddDevice;
import com.example.datacollection.device.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class DeviceController {
    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity addDevice(@RequestBody AddDevice request){
        return ResponseEntity.ok(deviceService.addDevice(request));
    }
}
