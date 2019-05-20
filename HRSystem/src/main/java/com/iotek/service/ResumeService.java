package com.iotek.service;

import com.iotek.model.Resume;

public interface ResumeService {
    Resume getResume(Resume resume);
    Resume getResumeById(Resume resume);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean deleteResume(Resume resume);
}
