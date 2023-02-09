package edu.miu.cs.cs425.studentmgmt.service.studentserviceimpl;

import edu.miu.cs.cs425.studentmgmt.model.ClassRoom;
import edu.miu.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassRoomService {
    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public ClassRoom createNewClassRoom(ClassRoom newClassRoom) {
        return classroomRepository.save(newClassRoom);
    }
}
