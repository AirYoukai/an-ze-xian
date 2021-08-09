package com.anzexian.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class InsuranceInsuredController {
    @RequestMapping("/toInsuredList")
    public String toInsuredList() {
        return "insurance/insured_list";
    }

}
