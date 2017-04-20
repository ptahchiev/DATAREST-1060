package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestproblemApplicationTests {

    protected final MediaType MEDIA_TYPE = MediaType.parseMediaType("application/hal+json;charset=UTF-8");

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext wac;

    @Resource(name = ProductRepository.NAME)
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1);
        productEntity.setTest("test");
        productRepository.save(productEntity);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    @Transactional
    public void testGetAllRestHttp() throws Exception {

        assertEquals(1, productRepository.findAll().size());

        testGetAll();
    }

    protected void testGetAll() throws Exception {
        mockMvc.perform(get("/product").accept(MEDIA_TYPE).contentType(MEDIA_TYPE)).andExpect(status().isOk()).andExpect(content().contentType(MEDIA_TYPE));
    }

}
