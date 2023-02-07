package com.arsen.services;

import com.arsen.entity.NewsMS;
import com.arsen.repositories.NewsMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsMSService {
    private final NewsMSRepository newMSRepository;

    @Autowired
    public NewsMSService(NewsMSRepository newMSRepository) {
        this.newMSRepository = newMSRepository;
    }

    public List<NewsMS> getAll() {
        return newMSRepository.findAll();
    }

    public NewsMS getById(long id) {
        return newMSRepository.findById(id).orElse(null);
    }

    public void save(NewsMS newsMS) {
        newMSRepository.save(newsMS);
    }


    public void update(long id, NewsMS updatedNewsMS) {
        NewsMS newsMS = newMSRepository.findById(id).orElse(null);
        if(newsMS == null) return;

        newsMS.setTitle(updatedNewsMS.getTitle());
        newsMS.setBrief(updatedNewsMS.getBrief());
        newsMS.setContent(updatedNewsMS.getContent());

        newMSRepository.save(newsMS);
    }

    public void delete(long id)  {
        newMSRepository.deleteById(id);
    }
}
