package model;

import org.springframework.stereotype.Component;

@Component
public class Theatre {
    private Long theatreId;  //using long type to hold larger numbers unlike int
    private String theatreName; //theatre name
    private String location; //location name (Dubai mall, MOE)
    private int totalScreens; //no. of screens at the location

    public Theatre() {}

    public Long getTheatreId() { //allows other classes to read the theatreId value
        return theatreId;
    }

    public void setTheatreId(Long theatreId) { //allows other classes to se a value
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalScreens() {
        return totalScreens;
    }

    public void setTotalScreens(int totalScreens) {
        this.totalScreens = totalScreens;
    }
}

