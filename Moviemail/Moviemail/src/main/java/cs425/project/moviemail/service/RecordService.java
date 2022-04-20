package cs425.project.moviemail.service;

import cs425.project.moviemail.model.Record;

import java.util.List;

public interface RecordService {
    Record checkOut(Record r);
    List<Record> getAllRecords();
    List<Record> getAllRecordsByCustomerId(Long customerId);
}
