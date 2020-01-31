package com.p.alphabetforkids.Model;

public class ItemModel {
    int id;
    int id_word_count;
    int row;
    String image;
    String title;
    String first_alphabet_word;
    String end_alphabet_word;
    String second_alphabet_words;
    String third_alphabet_words;
    String exampleOne;
    String exampleTwo;
    String exampleThree;
    String exampleEnd;
    String img_one;
    String img_two;
    String img_three;
    String img_four;
    String Poetry;


    public ItemModel() {

    }


    public ItemModel(int id, int id_word_count, int row, String image, String title, String first_alphabet_word, String end_alphabet_word, String second_alphabet_words, String third_alphabet_words, String exampleOne, String exampleTwo, String exampleThree, String exampleEnd, String img_one, String img_two, String img_three, String img_four, String poetry) {
        this.id = id;
        this.id_word_count = id_word_count;
        this.row = row;
        this.image = image;
        this.title = title;
        this.first_alphabet_word = first_alphabet_word;
        this.end_alphabet_word = end_alphabet_word;
        this.second_alphabet_words = second_alphabet_words;
        this.third_alphabet_words = third_alphabet_words;
        this.exampleOne = exampleOne;
        this.exampleTwo = exampleTwo;
        this.exampleThree = exampleThree;
        this.exampleEnd = exampleEnd;
        this.img_one = img_one;
        this.img_two = img_two;
        this.img_three = img_three;
        this.img_four = img_four;
        Poetry = poetry;
    }

    public String getPoetry() {
        return Poetry;
    }

    public void setPoetry(String poetry) {
        Poetry = poetry;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getImg_one() {
        return img_one;
    }

    public void setImg_one(String img_one) {
        this.img_one = img_one;
    }

    public String getImg_two() {
        return img_two;
    }

    public void setImg_two(String img_two) {
        this.img_two = img_two;
    }

    public String getImg_three() {
        return img_three;
    }

    public void setImg_three(String img_three) {
        this.img_three = img_three;
    }

    public String getImg_four() {
        return img_four;
    }

    public void setImg_four(String img_four) {
        this.img_four = img_four;
    }

    public String getExampleOne() {
        return exampleOne;
    }

    public void setExampleOne(String exampleOne) {
        this.exampleOne = exampleOne;
    }

    public String getExampleTwo() {
        return exampleTwo;
    }

    public void setExampleTwo(String exampleTwo) {
        this.exampleTwo = exampleTwo;
    }

    public String getExampleThree() {
        return exampleThree;
    }

    public void setExampleThree(String exampleThree) {
        this.exampleThree = exampleThree;
    }

    public String getExampleEnd() {
        return exampleEnd;
    }

    public void setExampleEnd(String exampleEnd) {
        this.exampleEnd = exampleEnd;
    }

    public String getThird_alphabet_words() {
        return third_alphabet_words;
    }

    public void setThird_alphabet_words(String third_alphabet_words) {
        this.third_alphabet_words = third_alphabet_words;
    }

    public String getSecond_alphabet_words() {
        return second_alphabet_words;
    }

    public void setSecond_alphabet_words(String second_alphabet_words) {
        this.second_alphabet_words = second_alphabet_words;
    }

    public String getEnd_alphabet_word() {
        return end_alphabet_word;
    }

    public void setEnd_alphabet_word(String end_alphabet_word) {
        this.end_alphabet_word = end_alphabet_word;
    }

    public String getFirst_alphabet_word() {
        return first_alphabet_word;
    }

    public void setFirst_alphabet_word(String first_alphabet_word) {
        this.first_alphabet_word = first_alphabet_word;
    }

    public int getId() {
        return id;
    }

    public int getId_word_count() {
        return id_word_count;
    }

    public void setId_word_count(int id_word_count) {
        this.id_word_count = id_word_count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
