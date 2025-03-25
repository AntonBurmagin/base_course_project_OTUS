package data;

public enum CourseCategoryData {
    TESTING("Тестирование");

    private String name;

    CourseCategoryData(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
