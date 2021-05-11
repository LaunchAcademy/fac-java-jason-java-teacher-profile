import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeacherProfile {
//  public static void main(String[] args) throws IOException {
//  // look at my data and figure out what its data structure should be
//    List<HashMap<String, String>> teachers;
//  // Set up our ObjectMapper
//    ObjectMapper mapper = new ObjectMapper();
//    // Use our mapper to get the JSON data into our `teachers` nested ArrayList
//    // readValue wants the file information, and the data structure we want to use
//    // from there, it does some magic to take the file and turn it into the data structure
//
//    // put the teachers in an unstructured/String based ArrayList
//
//    // we can either read the file contents and THEN pass it into our ObjectMapper
////    byte[] fileContents = Files.readAllBytes(Paths.get("profiles.json"));
////    teachers = mapper.readValue(fileContents, ArrayList.class);
//
//    // Our other option is to just access the file, and hand the entire File object into our ObjectMapper (rather than reading it into memory
//
//    ClassLoader classLoader = TeacherProfile.class.getClassLoader();
//    File profilesFile = new File(classLoader.getResource("profiles.json").getFile());
//    teachers = mapper.readValue(profilesFile, ArrayList.class);
//
//    System.out.println(teachers);
//
//
//
//    // put the teachers in an structured ArrayList of teacher objects
//
//
//    // list out all of the teachers names
//    // iterate through the `teachers` ArrayList
//    for(HashMap<String, String> teacher : teachers) {
//      // print out the name of the teacher
//      // for each teacher, get the name
////      System.out.println(teacher);
//      System.out.println(teacher.get("name"));
//    }
//
//    System.out.println("---");
//
//    // list out favorite languages
//    // make sure they're unique
//    // make a brand new HashSet
//    Set<String> favoriteLanguages = new HashSet<>();
//    for(HashMap<String, String> teacher : teachers) {
//      Set<String> keys = teacher.keySet();
//      // print out the name of the teacher
//      // for each teacher, get the name
////      System.out.println(teacher);
//      favoriteLanguages.add(teacher.get("favorite_language"));
//    }
//    System.out.println(favoriteLanguages);
//    System.out.println(String.join(", ", favoriteLanguages));
//
//
//    // sum up the years of experience on the team
//    double totalYearsExperience = 0.00;
//    for(HashMap<String, String> teacher : teachers) {
//      // add the years of experience to a `totalYearsExperience` variable
//      totalYearsExperience += Double.parseDouble(teacher.get("years_experience"));
//    }
//
//    System.out.println("There are " +totalYearsExperience + " total years of experience on the team");
//  }

  public static void main(String[] args) throws IOException {
    List<HashMap<String, String>> teachers;
    ObjectMapper mapper = new ObjectMapper();
    ClassLoader classLoader = TeacherProfile.class.getClassLoader();
    File profilesFile = new File(classLoader.getResource("profiles.json").getFile());
    teachers = mapper.readValue(profilesFile, ArrayList.class);
    System.out.println(teachers);
    List<Teacher> teacherObjects = new ArrayList<>();
    for(HashMap<String, String> teacher: teachers) {
      teacherObjects.add(new Teacher(
          teacher.get("name"),
          teacher.get("favorite_language"),
          Integer.parseInt(teacher.get("years_experience"))
      ));
    }
    System.out.println(teacherObjects);

    Teacher nick;
    ObjectMapper mapper = new ObjectMapper();
    ClassLoader classLoader = TeacherProfile.class.getClassLoader();
    File teacherFile = new File(classLoader.getResource("teacher.json").getFile());

    nick = mapper.readValue(teacherFile, Teacher.class);
    System.out.println(nick);
  }
}
