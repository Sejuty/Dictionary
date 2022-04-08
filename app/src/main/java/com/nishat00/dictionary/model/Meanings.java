package com.nishat00.dictionary.model;

import java.util.List;

public class Meanings {
    String partOfSpeech = "";
    List<Definitions> definitions = null;
    List<String>synonyms = null;
    List<String> antonyms = null;

    public List<String> getAntonyms() {
        return antonyms;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<Definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definitions> definitions) {
        this.definitions = definitions;
    }
}
