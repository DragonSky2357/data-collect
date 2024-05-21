package com.example.datacollection.deviceGroup.controller;

import com.example.datacollection.deviceGroup.dto.request.AddDeviceGroup;
import com.example.datacollection.deviceGroup.service.DeviceGroupService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device-group")
public class DeviceGroupController {

    private final DeviceGroupService deviceGroupService;

    @PostMapping
    public ResponseEntity addDeviceGroup(@RequestBody AddDeviceGroup request) throws BadRequestException {
        return ResponseEntity.ok(deviceGroupService.addDeviceGroup(request));
    }
}
