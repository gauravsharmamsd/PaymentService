package org.payment.gui.controller;

import com.equens.bil.core.BilException;
import org.payment.gui.model.request.PaymentMessageOverviewRequest;
import org.payment.gui.model.response.PaymentMessageOverviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")

//@Controller
public class MessageOverviewController {

   @Autowired
    private org.payment.gui.service.PaymentMessageService messageOverviewService;

     @CrossOrigin
     @RequestMapping("/overview")
     public PaymentMessageOverviewResponse overview(@RequestBody PaymentMessageOverviewRequest request) throws BilException {
         return messageOverviewService.getPaymentMessagesOverview(request);

     }
    @QueryMapping
    public PaymentMessageOverviewResponse overviewviaGraphQL(@Argument PaymentMessageOverviewRequest request) throws BilException {
        return messageOverviewService.getPaymentMessagesOverview(request);

    }
}
