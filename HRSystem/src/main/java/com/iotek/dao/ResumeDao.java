package com.iotek.dao;

import com.iotek.model.Resume;

public interface ResumeDao {
    Resume getResume(Resume resume);
    Resume getResumeById(Resume resume);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean deleteResume(Resume resume);
}
