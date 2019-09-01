package com.rgy.atm.client;

import com.rgy.atm.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("account-cnsl-service")
public interface AccountAppClient {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/v1/accounts")
    void saveAccount(@RequestBody AccountDTO accountDTO);

    @RequestMapping(method = RequestMethod.GET, path = "/v1/accounts/{id}")
    AccountDTO getAccount(@PathVariable Long id);
}
