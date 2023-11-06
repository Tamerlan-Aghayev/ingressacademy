package com.company.service;

import com.company.entity.Notification;
import com.company.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    public List<Notification> getAll(){
        return notificationRepository.findAll();
    }
    public void addNotifications(List<Notification> notifications){
        notificationRepository.saveAllAndFlush(notifications);
    }
}
