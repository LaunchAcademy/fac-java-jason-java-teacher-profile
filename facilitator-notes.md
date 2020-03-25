## Prep

- Review the provided, implemented classes
- Delete everything under the comments
- Delete the `Teacher` class
- Delete the dependencies in `pom.xml`

## During the Session

- Discuss our object - start with showing the JSON file and walking them through it
- Discuss a bit of context - we're starting with very simple JSON files because Java is pretty rigid in how we ingest JSON files. Starting with basic key/value pairs is easiest to get comfortable with Jackson
- Add Jackson to Maven - demonstrate how this is done via going to the Maven Registry
- Discuss structured data vs. unstructured data when shifting from the ArrayList of hashmaps vs. an ArrayList of Teacher instances

  - As Java Programmers, we generally like structured data - object oriented design allows us to carry on the metaphor
  - We can add behavior to Teacher that we can easily add to a HashMap
  - We can cast our integer `years_experience` to its proper data type

- Model Intellij Shortcuts - when creating the `Teacher` class, you can:

  - create a constructor that takes in the three teacher properties (be sure to use an int for years experience)
  - put your cursor inside the constructor, press option+enter
  - select: bind constructor parameters to fields
  - put your cursor over the fields, type option+enter, then "Create getter...."
  - Caveat that while using these tools are great, they are not an excuse for not knowing what they're doing for us. We must understand what is happening when we take advantage of them. With great poweerrrrrrr...

- Point out why we use a `Set` to identify the favorite languages

  - remember: sets are used to put together a "bag" of data - we don't want duplicates in this case
  - perfect use case for a `Set`
  - Also point out here that we program to an interface. We assign to a `Map`, and we instantiate a `HashMap`
  - `String.join` can be used on any `Collection` object