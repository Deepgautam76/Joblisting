package com.kamal.joblisting.repository;

import com.kamal.joblisting.model.PostModel;

import java.util.List;

public interface SearchRepository {

    List<PostModel> findByText(String text);
}
