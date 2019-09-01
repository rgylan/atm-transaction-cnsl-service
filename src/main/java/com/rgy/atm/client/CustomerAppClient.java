package com.rgy.atm.client;

import com.rgy.atm.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("customer-cnsl-service")
public interface CustomerAppClient {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/customers/{id}")
    CustomerDTO getCustomer(@PathVariable Long id);
}
