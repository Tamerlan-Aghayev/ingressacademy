package com.company.service;

import com.company.entity.Authors;
import com.company.entity.Students;
import com.company.entity.Subscriptions;
import com.company.repository.SubscriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubscriptionsService {
    @Autowired
    private SubscriptionsRepository subscriptionsRepository;
    public void addSubscription(Subscriptions subscription){
        subscriptionsRepository.saveAndFlush(subscription);
    }
    public void removeSubscription(Subscriptions subscription){
        subscriptionsRepository.delete(subscription);
    }
    public List<Students> getStudentsByAuthor(Authors author){
        return subscriptionsRepository.getStudentsByAuthors(author);
    }
    public Subscriptions getSubscription(Authors author, Students student){
        return subscriptionsRepository.getByStudentAndAuthor(author, student);
    }
}
