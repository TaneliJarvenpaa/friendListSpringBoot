package exercise.domain;

public class newStudent {
    private String nimi;

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String[] jaaNimi() {
        if (nimi != null && !nimi.trim().isEmpty()) {
            String[] names = nimi.split(" ");
            if (names.length == 2) {
                return names;
            }
        }
        return null;
    }
}

