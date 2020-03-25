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
    File teacherProfilesJson = new File(TeacherProfile.class.getResource("profiles.json").getFile());
    List<HashMap<String, String>> teachers;
    ObjectMapper mapper = new ObjectMapper();
    teachers = mapper.readValue(teacherProfilesJson, ArrayList.class);

    // put the teachers in a structured ArrayList of teacher objects
    List<Teacher> teacherList = new ArrayList<Teacher>();
    for (Map<String, String> teacherMap : teachers) {
      Teacher teacher = new Teacher(teacherMap.get("name"), teacherMap.get("favorite_language"),
          Integer.parseInt(teacherMap.get("years_experience")));
      teacherList.add(teacher);
    }

    // list out all of the teachers names
    for (Teacher teacher : teacherList) {
      System.out.println(teacher.getName());
    }

    // list out favorite languages
    Set<String> favoriteLanguages = new HashSet<String>();
    for (Teacher teacher : teacherList) {
      favoriteLanguages.add(teacher.getFavoriteLanguage());
    }
    System.out.println(String.join(", ", favoriteLanguages));

    // sum up the years of experience on the team
    int totalYearsExperience = 0;
    for (Teacher teacher : teacherList) {
      totalYearsExperience += teacher.getYearsOfExperience();
    }
    System.out.println(totalYearsExperience);
  }
}
