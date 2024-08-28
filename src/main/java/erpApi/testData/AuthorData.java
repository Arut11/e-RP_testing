package erpApi.testData;

import dto.Author;

public class AuthorData {

    public Author getAuthor() {
        return new Author()
                .setSurname("Безкруглова")
                .setName("Ирина")
                .setPatronymic("Константиновна")
                .setSnils("06950154572")
                .setPhone("89511112323");

    }

}
