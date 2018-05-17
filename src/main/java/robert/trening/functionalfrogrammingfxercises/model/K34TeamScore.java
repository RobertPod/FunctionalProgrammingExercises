package robert.trening.functionalfrogrammingfxercises.model;

import java.io.Serializable;
import java.time.Duration;

public class K34TeamScore implements Serializable {
    private String name;
    private int distance;
    private int duration;
    //    private Duration duration;
    private String competitionCity;

    public K34TeamScore(String name, int distance, int duration, String competitionCity) {
        this.name = name;
        this.distance = distance;
        this.duration = duration;
        this.competitionCity = competitionCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCompetitionCity() {
        return competitionCity;
    }

    public void setCompetitionCity(String competitionCity) {
        this.competitionCity = competitionCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        K34TeamScore that = (K34TeamScore) o;

        if (distance != that.distance) return false;
        if (duration != that.duration) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return competitionCity != null ? competitionCity.equals(that.competitionCity) : that.competitionCity == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + distance;
        result = 31 * result + duration;
        result = 31 * result + (competitionCity != null ? competitionCity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "K34TeamScore{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                ", competitionCity='" + competitionCity + '\'' +
                '}';
    }
}
