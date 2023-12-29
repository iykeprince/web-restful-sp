package com.thinkltp.webrestful.controller;

import com.thinkltp.webrestful.model.CloudVendor;
import com.thinkltp.webrestful.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendor(@PathVariable("vendorId") String vendorId) {
        return this.cloudVendorService.getCloudVendor(vendorId);
//        return ResponseHandler.responseBuilder(
//                "Requested Vendor Details are given here",
//                HttpStatus.OK,
//                this.cloudVendorService.getCloudVendor(vendorId)
//        );
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendors() {
        return this.cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud vendor created successfully.";
    }

    @PutMapping
    public String updateCloudVendorDetail(@RequestBody CloudVendor cloudVendor) {
        this.cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud vendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetail(@PathVariable("vendorId") String vendorId) {
        this.cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully";
    }
}
