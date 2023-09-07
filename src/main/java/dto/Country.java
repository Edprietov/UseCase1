package dto;

public class Country {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String name;

    Integer population;

    String content;

    public Country(String name, Integer population, String content) {
        this.name = name;
        this.population = population;
        this.content = content;
    }

    public Country(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Country(Integer population, String content) {
        this.population = population;
        this.content = content;
    }

    public Country(String content) {
        this.content = content;
    }
}
