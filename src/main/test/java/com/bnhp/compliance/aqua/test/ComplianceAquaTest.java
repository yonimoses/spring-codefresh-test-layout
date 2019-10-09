package com.bnhp.compliance.aqua.test;

import com.bnhp.compliance.api.model.AdmissionReview;
import com.bnhp.compliance.api.model.ComplianceType;
import com.bnhp.compliance.api.utils.JsonUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ComplianceAquaTest extends AbstractTest {
    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
    }


    @Test
    public void test_verify() throws Exception {
        AdmissionReview admissionReview = getAdmissionReviewFile("admission-review.json");
        MvcResult mvcResult = mvc.perform(post("/verify")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.serialize(admissionReview))
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", CoreMatchers.equalTo("SUCCESS")))
                .andExpect(jsonPath("$.type", CoreMatchers.equalTo(ComplianceType.LABELS.toString())))
                .andExpect(jsonPath("$.allowed", CoreMatchers.equalTo(true))).andReturn();
    }


//    @Test
//    public void test_verify_post_type_deployment_and_no_matching_labels() throws Exception {
//        AdmissionReview admissionReview = getAdmissionReviewFile("admission-review-deployment-no-labels.json");
//        MvcResult mvcResult = mvc.perform(post("/verify")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtils.serialize(admissionReview))
//                .characterEncoding("utf-8")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is(412))
//                .andExpect(jsonPath("$.code", CoreMatchers.equalTo("FAILED")))
//                .andExpect(jsonPath("$.type", CoreMatchers.equalTo(ComplianceType.LABELS.toString())))
//                .andExpect(jsonPath("$.allowed", CoreMatchers.equalTo(false))).andReturn();
//    }
//
//    @Test
//    public void test_verify_post_type_deployment_and_matching_labels() throws Exception {
//        AdmissionReview admissionReview = getAdmissionReviewFile("admission-review-deployment-with-labels.json");
//        MvcResult mvcResult = mvc.perform(post("/verify")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtils.serialize(admissionReview))
//                .characterEncoding("utf-8")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.code", CoreMatchers.equalTo("SUCCESS")))
//                .andExpect(jsonPath("$.type", CoreMatchers.equalTo(ComplianceType.LABELS.toString())))
//                .andExpect(jsonPath("$.allowed", CoreMatchers.equalTo(true))).andReturn();
//    }
//
//    @Test
//    public void createProduct() throws Exception {
//        String uri = "/products";
//        Product product = new Product();
//        product.setId("3");
//        product.setName("Ginger");
//        String inputJson = super.mapToJson(product);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(201, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is created successfully");
//    }
//
//    @Test
//    public void updateProduct() throws Exception {
//        String uri = "/products/2";
//        Product product = new Product();
//        product.setName("Lemon");
//        String inputJson = super.mapToJson(product);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is updated successsfully");
//    }
//
//    @Test
//    public void deleteProduct() throws Exception {
//        String uri = "/products/2";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is deleted successsfully");
//    }
}