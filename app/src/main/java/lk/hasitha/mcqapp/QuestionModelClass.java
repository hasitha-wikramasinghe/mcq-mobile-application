package lk.hasitha.mcqapp;

public class QuestionModelClass {
    private int id;
    private String Question, Answer, w1, w2, w3, w4;

    public QuestionModelClass(){

    }

    public QuestionModelClass(int id, String question, String answer, String w1, String w2, String w3, String w4) {
        this.id = id;
        Question = question;
        Answer = answer;
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.w4 = w4;
    }

    public QuestionModelClass(String question, String answer, String w1, String w2, String w3, String w4) {
        Question = question;
        Answer = answer;
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.w4 = w4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getW1() {
        return w1;
    }

    public void setW1(String w1) {
        this.w1 = w1;
    }

    public String getW2() {
        return w2;
    }

    public void setW2(String w2) {
        this.w2 = w2;
    }

    public String getW3() {
        return w3;
    }

    public void setW3(String w3) {
        this.w3 = w3;
    }

    public String getW4() {
        return w4;
    }

    public void setW4(String w4) {
        this.w4 = w4;
    }
}
