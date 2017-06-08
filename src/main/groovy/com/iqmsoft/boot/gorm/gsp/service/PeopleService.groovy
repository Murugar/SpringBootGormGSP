package com.iqmsoft.boot.gorm.gsp.service

import groovy.util.logging.Log4j
import com.iqmsoft.boot.gorm.gsp.domain.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Log4j
@Service
public class PeopleService {

    @Autowired
    AgeService ageService

    @Transactional
    public List findPeople() {
        def list = Person.listOrderByAge()
        log.info("Found people: ${list.size()}")
        return list
    }

    @Transactional
    public int getBirthdayYear(Person person) {
        return ageService.calcBirthdayYear(person.age)
    }

}
