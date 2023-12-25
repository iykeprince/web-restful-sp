package com.thinkltp.webrestful.controller;

import com.thinkltp.webrestful.model.CloudVendor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorAPIService {

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendor(String vendorId) {
        return new CloudVendor("c1", "Vendor 1", "Address One", "+238999382893");
    }
}
