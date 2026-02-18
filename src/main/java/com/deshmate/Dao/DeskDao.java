package com.deshmate.Dao;

import java.util.List;
import java.util.Optional;

import com.deskmate.model.Desk;

public interface DeskDao {
    long insertDesk(String code, String name);
    void deactivateDesk(long deskId);
    Optional<Desk> findByCode(String code);
    List<Desk> listActive();
}