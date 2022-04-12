public class Teacher {
  private String name;
  private String favoriteLanguage;
  private int yearsExperience;

  public Teacher(String name, String favoriteLanguage, int yearsExperience) {
    this.name = name;
    this.favoriteLanguage = favoriteLanguage;
    this.yearsExperience = yearsExperience;
  }

  public String getName() {
    return name;
  }

  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public int getYearsExperience() {
    return yearsExperience;
  }
}
