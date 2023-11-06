package com.company.data;

import com.company.dto.AuthorDTO;
import com.company.dto.UserDTO;

public class UserAuthorData {
   private UserDTO userDTO;
   private AuthorDTO authorDTO;

    public UserAuthorData(UserDTO userDTO, AuthorDTO authorDTO) {
        this.userDTO = userDTO;
        this.authorDTO = authorDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}
