public class Teacher {

  private final String name;
  private final String favoriteLanguage;
  private final int yearsOfExperience;

  public Teacher(String name, String favoriteLanguage, int yearsOfExperience) {
    this.name = name;
    this.favoriteLanguage = favoriteLanguage;
    this.yearsOfExperience = yearsOfExperience;
  }

  public String getName() {
    return name;
  }

  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public int getYearsOfExperience() {
    return yearsOfExperience;
  }
}
