package com.company.data;

import com.company.dto.AuthorDTO;
import com.company.dto.BookDTO;

public class AuthorBookData {
    private AuthorDTO authorDTO;
    private BookDTO bookDTO;

    public AuthorBookData(AuthorDTO authorDTO, BookDTO bookDTO) {
        this.authorDTO = authorDTO;
        this.bookDTO = bookDTO;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }
}
