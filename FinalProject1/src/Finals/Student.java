package Finals;

public class Student {
	private String name, id, course, yearLevel;

    public Student(String name, String id, String course, String yearLevel) {
        this.name = name;
        this.id = id;
        this.course = course;
        this.yearLevel = yearLevel;
    }
    // Setter
    public void setName(String name) {
		this.name = name;
	}
    public void setId(String id) {
		this.id = id;
	}
    public void setCourse(String course) {
		this.course = course;
	}
    public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}
    
    // Getter
    public String getName() {
		return this.name;
	}
    public String getId() {
		return this.id;
	}
    public String getCourse() {
		return this.course;
	}
    public String getYearLevel() {
		return this.yearLevel;
	}
	
    public String toString() {
        return "ID: " + id + " | Name: " + name +
        		" | Course: " + course + " | Year: " + yearLevel;
    }
}
    
