package com.bnhp.compliance.aqua.test;

import com.bnhp.compliance.api.model.AdmissionReview;
import com.bnhp.compliance.api.utils.JsonUtils;
import com.bnhp.compliance.aqua.ComplianceApp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ComplianceApp.class)
@WebAppConfiguration
public abstract class AbstractTest {
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() throws IOException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    public AdmissionReview getAdmissionReviewFile(String name) throws IOException {
        ClassPathResource resource = new ClassPathResource(name, this.getClass().getClassLoader());
        return JsonUtils.getObjectFromJsonString(AdmissionReview.class, StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset()));
    }

    public Map getArtiResponse(String name) throws IOException {
        ClassPathResource resource = new ClassPathResource(name, this.getClass().getClassLoader());
        return JsonUtils.getObjectFromJsonString(Map.class, StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset()));
    }


//
//    protected String mapToJson(Object obj) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(obj);
//    }
//
//    protected <T> T mapFromJson(String json, Class<T> clazz)
//            throws JsonParseException, JsonMappingException, IOException {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(json, clazz);
//    }

// /
}