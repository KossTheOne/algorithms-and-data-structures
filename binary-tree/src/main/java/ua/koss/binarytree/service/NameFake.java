package ua.koss.binarytree.service;

import retrofit2.Call;
import retrofit2.http.GET;
import ua.koss.binarytree.model.Person;

public interface NameFake {
    @GET("/")
    Call<Person> persons();
}
