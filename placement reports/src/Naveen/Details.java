package naveen;

public class Details {
 private String usn;
 private String name;
 private String branch;
 private String company;
 int Package;
 int sem;

    public Details(String usn, String name, String branch, String company, int Package, int sem) {
        this.usn = usn;
        this.name = name;
        this.branch = branch;
        this.company = company;
        this.Package = Package;
        this.sem = sem;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPackage() {
        return Package;
    }

    public void setPackage(int Package) {
        this.Package = Package;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }
 
 
 
 
}