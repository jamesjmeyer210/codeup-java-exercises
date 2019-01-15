class ArrayExercises {

  public static Person[] addPerson(Person[] array, Person elem){
    int alloc = array.length + 1;
    Person[] self = new Person[alloc];

    {
      int i = 0;
      for(Person person : array){
        self[i] = person;
        i++;
      }
    }

    self[self.length - 1] = elem;
    return self;
  }

  public static void main(String[] args){

    /*Create an array that holds 3 Person objects. Assign a new instance of the Person class to each element. Iterate through the array and print out the name of each person in the array.
    */
    Person[] people = new Person[3];
    people[0] = new Person("Alice");
    people[1] = new Person("Bob");
    people[2] = new Person("Charlie");
    /*
    Create a static method named addPerson. It should accept an array of Person objects, as well as a single person object to add to the passed array. It should return an array whose length is 1 greater than the passed array, with the passed person object at the end of the array.*/
    people = addPerson(people, new Person("David"));
    for(Person person : people){
      System.out.println(person.getName());
    }
  }
}
