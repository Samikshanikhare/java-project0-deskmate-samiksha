package com.deshmate.service;


import com.deskmate.Dao.ReportDao;
import com.deskmate.model.report.DailyRevenueRow;
import com.deskmate.model.report.DeskUtilizationRow;

import java.time.LocalDate;
import java.util.List;

public class ReportService {
    private final ReportDao reportDao;

    public ReportService(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    public DailyRevenueRow dailyRevenue(LocalDate date) {
        return reportDao.dailyRevenue(date);
    }

    public List<DeskUtilizationRow> deskUtilization(LocalDate date) {
        return reportDao.deskUtilization(date);
    }
}
