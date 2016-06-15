package com.example.udit.myapplication.model;

/**
 * Created by udit on 6/14/2016.
 */
public class Page {
   private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    boolean mIsFinal=false;


    public boolean isFinal() {
        return mIsFinal;
    }

    public Page(int imageid, String text, Choice choice1, Choice choice2)
    {
        mImageId = imageid;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }
    public Page(int imageid,String text)
    {

        mImageId = imageid;
        mText = text;
        mChoice1=null;
        mChoice2=null;
        mIsFinal=true;
    }




    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }
}
