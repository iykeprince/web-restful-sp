package com.thinkltp.webrestful.controller;

import com.thinkltp.webrestful.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorAPIService {

    CloudVendor cloudVendor;

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendor(String vendorId) {
        return cloudVendor;
//        return new CloudVendor("c1", "Vendor 1", "Address One", "+238999382893");
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor = cloudVendor;
        return "Cloud vendor created successfully.";
    }

    @PutMapping
    public String updateCloudVendorDetail(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendor = cloudVendor;
        return "Cloud vendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetail(String vendorId) {
        this.cloudVendor = null;
        return "Cloud vendor deleted successfully";
    }
}
