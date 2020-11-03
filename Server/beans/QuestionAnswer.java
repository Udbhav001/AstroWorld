package beans;

import java.io.Serializable;

public class QuestionAnswer implements Serializable {
    public String uid,astroid,question,ans,dateans,dateques,status;

    public QuestionAnswer(String uid, String astroid, String question, String ans, String dateans, String dateques) {
        this.uid = uid;
        this.astroid = astroid;
        this.question = question;
        this.ans = ans;
        this.dateans = dateans;
        this.dateques = dateques;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAstroid() {
        return astroid;
    }

    public void setAstroid(String astroid) {
        this.astroid = astroid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getDateans() {
        return dateans;
    }

    public void setDateans(String dateans) {
        this.dateans = dateans;
    }

    public String getDateques() {
        return dateques;
    }

    public void setDateques(String dateques) {
        this.dateques = dateques;
    }
    public QuestionAnswer()
    {
    	
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
