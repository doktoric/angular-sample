package com.acme.doktoric.web;

import com.acme.doktoric.dto.Person;
import com.acme.doktoric.dto.ResponseMessage;
import com.acme.doktoric.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
public class PersonController {
    @Inject
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPersons() {
        return personService.getAllPersons();
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addPerson(@RequestBody Person person) {
        if (person.getFirstName().length() <= 3 || person.getLastName().length() <= 3) {
            throw new IllegalArgumentException("moreThan3Chars");
        }
        personService.addPerson(person);
        return new ResponseMessage(ResponseMessage.Type.success, "personAdded");
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return new ResponseMessage(ResponseMessage.Type.success, "personDeleted");
    }

}
