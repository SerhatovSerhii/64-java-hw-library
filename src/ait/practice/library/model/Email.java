package ait.practice.library.model;

import java.util.Objects;

public class Email {
    private String email;   //  email - адрес
    private String subject; //  subject - тема
    private String text;    //  text - текст

    public Email(String email, String subject, String text) {
        this.email = email;
        this.subject = subject;
        this.text = text;
    }

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email1 = (Email) o;

        if (!Objects.equals(email, email1.email)) return false;
        if (!Objects.equals(subject, email1.subject)) return false;
        return Objects.equals(text, email1.text);
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
