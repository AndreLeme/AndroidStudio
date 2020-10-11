package com.example.android.grades;

public class Grades {
    private String mName;
    private double mEnglishGrade, mMathGrade, mHistoryGrade, mBiologyGrade, mChemistryGrade;

    public Grades(String name, double englishGrade, double mathGrade, double historyGrade, double biologyGrade, double chemestryGrade) {
        mName = name;
        mEnglishGrade = englishGrade;
        mMathGrade = mathGrade;
        mHistoryGrade = historyGrade;
        mBiologyGrade = biologyGrade;
        mChemistryGrade = chemestryGrade;
    }

    public void setName(String name) {mName = name;}
    public void setEnglishGrade(double grade) {mEnglishGrade = grade;}
    public void setMathGrade(double grade) {mMathGrade = grade;}
    public void setHistoryGrade(double grade) {mHistoryGrade = grade;}
    public void setBiologyGrade(double grade) {mBiologyGrade = grade;}
    public void setChemistryGrade(double grade) {mChemistryGrade = grade;}

    public String getName() {return mName;}
    public double getEnglishGrade() {return mEnglishGrade;}
    public double getMathGrade() {return mMathGrade;}
    public double getHistoryGrade() {return mHistoryGrade;}
    public double getBiologyGrade() {return mBiologyGrade;}
    public double getChemistryGrade() {return mChemistryGrade;}

    @Override
    public String toString() {
        //Your code here!  Return a representation of
        //the report card rather than the empty string
        return "Name " + mName + "; English grade: " + mEnglishGrade + "; Math grade: " + mMathGrade
                + "; History grade: " + mHistoryGrade + "; Biology grade: " + mBiologyGrade +  "; Chemistry grade: "
                + mChemistryGrade;
    }

}
