package com.shablobank.app.service;
import nl.martijndwars.webpush.Subscription;

import javax.websocket.ClientEndpoint;
import javax.websocket.server.ServerEndpoint;

@ClientEndpoint
public class MessageEndpoint {

    private MessageService messageService;

    public MessageEndpoint(MessageService messageService) {
        this.messageService = messageService;
    }

    public String getPublicKey() {
        return messageService.getPublicKey();
    }

    public void subscribe(Subscription subscription) {
        messageService.subscribe(subscription);
    }

    public void unsubscribe(String endpoint) {
        messageService.unsubscribe(endpoint);
    }
}
