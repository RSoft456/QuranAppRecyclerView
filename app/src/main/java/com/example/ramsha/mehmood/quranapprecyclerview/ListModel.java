package com.example.ramsha.mehmood.quranapprecyclerview;

public class ListModel {
    String SurahName;
    int SurahNum;

    public ListModel(String surahName, int surahNum) {
        SurahName = surahName;
        SurahNum = surahNum;
    }

    public String getSurahName() {
        return SurahName;
    }

    public void setSurahName(String surahName) {
        SurahName = surahName;
    }

    public int getSurahNum() {
        return SurahNum;
    }

    public void setSurahNum(int surahNum) {
        SurahNum = surahNum;
    }
}
