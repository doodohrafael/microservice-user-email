package com.rafael.email.consumer;

import com.rafael.email.dto.EmailRecordDTO;
import com.rafael.email.model.Email;
import com.rafael.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO) {
        var email = new Email();
        BeanUtils.copyProperties(emailRecordDTO, email);
        emailService.sendEmail(email);

    }
}
