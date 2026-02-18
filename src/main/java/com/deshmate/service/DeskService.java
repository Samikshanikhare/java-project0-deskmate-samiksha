package com.deshmate.service;

import com.deskmate.Dao.DeskDao;
//import com.deskmate.Dao;
import com.deskmate.exception.EntityNotFoundException;
import com.deskmate.exception.ValidationException;
import com.deskmate.model.Desk;
import com.deskmate.utils.ValidationUtility;

import java.util.List;

public class DeskService {
    private final DeskDao deskDao;

    public DeskService(DeskDao deskDao) {
        this.deskDao = deskDao;
    }

    public long addDesk(String code, String name) {
        ValidationUtility.requireNonBlank(code, "deskCode");
        ValidationUtility.requireNonBlank(name, "name");

        if (deskDao.findByCode(code).isPresent()) {
            throw new ValidationException("Desk code already exists: " + code);
        }
        return deskDao.insertDesk(code, name);
    }

    public void deactivateDesk(String code) {
        Desk d = deskDao.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Desk not found: " + code));
        deskDao.deactivateDesk(d.getDeskId());
    }

    public List<Desk> listActive() {
        return deskDao.listActive();
    }

    public Desk getByCodeOrThrow(String code) {
        return deskDao.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Desk not found: " + code));
    }
}