import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeacherProfile {
  public static void main(String[] args) throws IOException {
    // put the teachers in an unstructured/String based ArrayList
    List<HashMap<String, String>> teachers;
    // get access to our file
//    String filePath = TeacherProfile.class.getResource("profiles.json").getFile();
//    File teacherProfilesJson = new File(filePath);
    // read our file
    // map our file to our data structure
    File teacherProfilesJson = new File(TeacherProfile.class.getResource("profiles.json").getFile());
    ObjectMapper mapper = new ObjectMapper();
    teachers = mapper.readValue(teacherProfilesJson, ArrayList.class);
    System.out.println(teachers);

    // put the teachers in a structured ArrayList of Teacher objects
    List<Teacher> teacherObjects = new ArrayList<>();
    // iterate through my `teachers` ArrayList
    for(Map<String, String> teacher : teachers) {
    // for each teacher, create a Teacher object
      System.out.println(teacher);
      Teacher newTeacher = new Teacher(teacher.get("name"), teacher.get("favorite_language"), Integer.parseInt(teacher.get("years_experience")));
    // put it into my `teacherObjects` array
      teacherObjects.add(newTeacher);
    }

    System.out.println(teacherObjects);


    // list out all of the teachers names
    List<String> teacherNames = new ArrayList<>();
    for(Teacher teacher : teacherObjects) {
      teacherNames.add(teacher.getName());
    }

    System.out.println(String.join(",", teacherNames));



    // list out UNIQUE favorite languages
    Set<String> favoriteLanguages = new HashSet<>();
    for(Teacher teacher : teacherObjects) {
      favoriteLanguages.add(teacher.getFavoriteLanguage());
    }

    System.out.println(String.join(",", favoriteLanguages));

    // sum up the years of experience on the team
    int totalYearsExperience = 0;
    for(Teacher teacher : teacherObjects) {
      totalYearsExperience += teacher.getYearsExperience();
    }

    System.out.println("Total years experience on the team: " + totalYearsExperience);
  }

//  public List<String> getFruits() {
//    List<String> fruitList = new LinkedList<>();
//    fruitList.add("banana");
//    fruitList.add("apple");
//    return fruitList;
//
//    ["Brianna", "Jess", "Alice", "Lauren"]
//  }
}
