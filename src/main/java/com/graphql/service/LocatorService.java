package com.graphql.service;

import com.graphql.dao.LocatorDAO;
import com.graphql.domain.Atm;
import com.graphql.domain.Office;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class LocatorService {

    public List<Office> getOffices() {
        LocatorDAO dao = new LocatorDAO();
        List<Office> results = new ArrayList<>();
        try {
            results = dao.getOffices();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<Atm> getAtms() {
        LocatorDAO dao = new LocatorDAO();
        List<Atm> results = new ArrayList<>();
        try {
            results = dao.getAtms();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    public Office getOffice(String pir) {
        LocatorDAO dao = new LocatorDAO();
        Office office = null;
        try {
            office = dao.getOffice(pir);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return office;
    }
}
