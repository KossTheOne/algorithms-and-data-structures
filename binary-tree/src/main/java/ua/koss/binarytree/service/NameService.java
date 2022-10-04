package ua.koss.binarytree.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.koss.binarytree.model.Person;

import java.io.IOException;

public class NameService {
    private static final String API_URL = "https://api.namefake.com/";
    private final NameFake nameFake;

    public NameService() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd").create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        nameFake = retrofit.create(NameFake.class);
    }

    public Person getRandomPerson() throws IOException {
        Call<Person> response = nameFake.persons();
        Response<Person> personResponse = response.execute();
        return personResponse.body();
    }
}
