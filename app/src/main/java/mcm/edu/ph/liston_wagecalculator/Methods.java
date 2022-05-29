package mcm.edu.ph.liston_wagecalculator;

public class Methods {


    public double solveRegular(String employeeType, double more, double effort){
        double regular;
        if (employeeType.equals("Regular")){
            regular = (more - effort) * 99;
        } else if (employeeType.equals("Probationary")){
            regular = (more - effort) * 68;
        } else {
            regular = (more - effort) * 50;
        }
        return regular;
    }
    public double solveTime(String employeeType, double effort){
        double overWage;
        if (employeeType.equals("Regular")){
            overWage = effort * 140;
        } else if (employeeType.equals("Probationary")){
            overWage = effort * 120;
        } else {
            overWage = effort * 99;
        }
        return overWage;
    }
    public double solveEF(double more){
        double effort;
        if (more > 20) {
            effort = more - 20;
        } else {
            effort = 0;
        }
        return effort;
    }


    public double solveTotal(double regularWage, double overWage){
        return regularWage + overWage;
    }
}
