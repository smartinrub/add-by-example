package com.sergiomartinrubio.tddbyexample.controller;

import com.sergiomartinrubio.tddbyexample.model.Transaction;
import com.sergiomartinrubio.tddbyexample.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {

    @MockBean
    private TransactionService transactionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenTransactionWhenPostRequestToTransactionThenCreateTransactionIsCalledAndReturnIsCreated() throws Exception {
        // GIVEN
        String requestBody = "{\"id\":\"f8145c28-4730-4afc-8cf5-11934d94b06f\"," +
                "\"ibanNumber\":\"ES9820385778983000760236\"," +
                "\"amount\":193.38}";

        // WHEN
        mockMvc.perform(post("/transaction")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andDo(print())
                .andExpect(status().isCreated());

        // THEN
        verify(transactionService).save(new Transaction(UUID.fromString("f8145c28-4730-4afc-8cf5-11934d94b06f"),
                "ES9820385778983000760236", 193.38));
    }

}
