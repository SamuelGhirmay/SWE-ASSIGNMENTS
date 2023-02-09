package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import org.springframework.boot.CommandLineRunner;

public interface TranscriptService {
    Transcript createNewTranscript(Transcript newTranscript);
}
