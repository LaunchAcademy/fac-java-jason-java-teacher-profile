import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TeacherProfile {
  public static void main(String[] args) throws IOException {
    // put the teachers in an unstructured/String based ArrayList
    File profilesJson = new File("src/main/resources/profiles.json");
    List<HashMap<String, String>> teachers;
    teachers = new ArrayList<HashMap<String, String>>();

    ObjectMapper mapper = new ObjectMapper();
    teachers = mapper.readValue(profilesJson, ArrayList.class);

    System.out.println("Unstructured: " + teachers);
    System.out.println("=======");

    // put the teachers in a structured ArrayList of teacher objects
    List<Teacher> teachersObj = new ArrayList<Teacher>();
    for(Map<String, String> curTeacher : teachers) {
      Teacher singleTeacher = new Teacher(curTeacher.get("name"), curTeacher.get("favorite_language"),
        Integer.parseInt(curTeacher.get("years_experience")));
      teachersObj.add(singleTeacher);
    }

    System.out.println("Structured: " + teachersObj);
    System.out.println("=======");

    // list out all of the teachers names
    for(Teacher teacher : teachersObj){
      System.out.println(teacher.getName());
    }

    System.out.println("=======");
    // list out favorite languages
    Set<String> favoriteLanguageSet = new HashSet<String>();
    for(Teacher teacher : teachersObj){
//      System.out.println(teacher.getFavoriteLanguage());
        favoriteLanguageSet.add(teacher.getFavoriteLanguage());
    }
    System.out.println(favoriteLanguageSet);


    // sum up the years of experience on the team
    int yearsSummation = 0;
    for(Teacher teacher : teachersObj){
      yearsSummation += teacher.getYearsExperience();
    }
    System.out.println(yearsSummation);

  }
}
