package edu.miu.cs.cs425.studentmgmt.service.studentserviceimpl;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {
   @Autowired
   TranscriptRepository transcriptRepository;

  @Override
  public Transcript createNewTranscript(Transcript newTranscript) {
    return transcriptRepository.save(newTranscript);
  }
}
