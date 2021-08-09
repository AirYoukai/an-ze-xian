package com.anzexian.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class InsuranceApplicantController {
    @RequestMapping("/toApplicantList")
    public String toApplicantList() {
        return "insurance/applicant_list";
    }
}
