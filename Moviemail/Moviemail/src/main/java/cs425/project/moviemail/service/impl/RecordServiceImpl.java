package cs425.project.moviemail.service.impl;

import cs425.project.moviemail.model.Record;
import cs425.project.moviemail.repository.RecordRepository;
import cs425.project.moviemail.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Record checkOut(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public List<Record> getAllRecordsByCustomerId(Long customerId) {
        return recordRepository.getAllRecordsByCustomerId(customerId);
    }
}
