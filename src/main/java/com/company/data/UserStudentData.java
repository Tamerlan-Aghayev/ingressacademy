package com.company.data;

import com.company.dto.StudentDTO;
import com.company.dto.UserDTO;

public class UserStudentData {
    private UserDTO userDTO;
    private StudentDTO studentDTO;

    public UserStudentData(UserDTO userDTO, StudentDTO studentDTO) {
        this.userDTO = userDTO;
        this.studentDTO = studentDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }
}
