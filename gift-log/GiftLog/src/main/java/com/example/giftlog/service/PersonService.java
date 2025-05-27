package com.example.giftlog.service;

import com.example.giftlog.entity.Person;
import com.example.giftlog.model.PersonCreateRequest;
import com.example.giftlog.model.PersonItem;
import com.example.giftlog.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;


    public void setPerson(PersonCreateRequest request) {
        if (personRepository.findByPhoneAndName(request.getPhone(), request.getName()).isEmpty()) {
            Person person = new Person();
            person.setName(request.getName());
            person.setPhone(request.getPhone());

            personRepository.save(person);
        }

    }

    public List<PersonItem> getPersons() {
        List<Person> target = personRepository.findAll();
        List<PersonItem> result = new LinkedList<>();

        target.forEach(item->{
            PersonItem addItem = new PersonItem();
            addItem.setId(item.getId());
            String[] str = item.getPhone().split("-");
            addItem.setNameInfo(item.getName()+"("+str[2]+")");
            result.add(addItem);
        });
        return result;
    }
}
