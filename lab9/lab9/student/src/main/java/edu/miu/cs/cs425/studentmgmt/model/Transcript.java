package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;

@Entity
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transcriptId;
    private String degreeTitle;
    @OneToOne(mappedBy ="transcript")
    private Student student;



    public Transcript(Integer transcriptId, String degreeTitle) {
        this.transcriptId = transcriptId;
        this.degreeTitle = degreeTitle;
    }
    public Transcript(){}

    public Integer getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Integer transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "Transcript{" +
                "transcriptId=" + transcriptId +
                ", degreeTitle='" + degreeTitle + '\'' +
                '}';
    }
}
