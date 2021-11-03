package by.karas.firstcrud.dao;

import by.karas.firstcrud.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<Person>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 14, "bob@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike",  55, "mike@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 34, "katy@email.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId()==id);
    }
}
