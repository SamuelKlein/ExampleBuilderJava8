import java.util.function.Consumer;

public class Example {

  static class Person {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    @Override
    public String toString() {
      return "firstName=" + firstName + ";lastName=" + lastName;
    }
  }

  static class PersonBuilder {
    public String firstName;
    public String lastName;

    public PersonBuilder with(
            Consumer<PersonBuilder> builderFunction) {
      builderFunction.accept(this);
      return this;
    }


    public Person createPerson() {
      return new Person(firstName, lastName);
    }

  }

  public static void main(String[] args) {
    Person p = new PersonBuilder().with((personBuilder) -> {
      personBuilder.firstName = "Samuel";
      personBuilder.lastName = "Klein";

    }).createPerson();
    System.out.println(p);
  }
}