package com.company.data;

import com.company.dto.AuthorDTO;
import com.company.dto.StudentDTO;

public class StudentAuthorData {
    private StudentDTO studentDTO;
    private AuthorDTO authorDTO;

    public StudentAuthorData(StudentDTO studentDTO, AuthorDTO authorDTO) {
        this.studentDTO = studentDTO;
        this.authorDTO = authorDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}
