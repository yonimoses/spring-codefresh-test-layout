package com.bnhp.compliance.aqua.test;

import com.bnhp.compliance.aqua.ComplianceAquaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ComplianceAquaServiceTest extends AbstractTest {
    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
    }


    @Autowired
    ComplianceAquaService  service;

    @Test
    public void test_ParseImages() throws IOException {
        Assert.assertTrue(service.getImages(getAdmissionReviewFile("admission-review.json")).size() > 0);
    }
    @Test
    public void test_ParseArtiReponseImages() throws IOException {
        Assert.assertTrue(getArtiResponse("artifactory-response-no-aqua.json").size() > 0);
    }

    @Test
    public void test_IsValid_ok() throws IOException {
        service.isValid(getAdmissionReviewFile("admission-review.json"));
        Assert.assertTrue(true);
    }

}