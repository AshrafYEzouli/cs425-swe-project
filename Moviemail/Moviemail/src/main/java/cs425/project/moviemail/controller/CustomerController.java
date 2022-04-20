package cs425.project.moviemail.controller;

import cs425.project.moviemail.model.Record;
import cs425.project.moviemail.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/movie"})
public class CustomerController {

    @Autowired
    private RecordService recordService;

    @PostMapping(value = {"/checkout"})
    public void checkout(@Valid @ModelAttribute("record") Record record, BindingResult bindingResult, Model model) {
        recordService.checkOut(record);
        System.out.println("save record!");
    }

    public List<Record> getAllRecords() {
        return recordService.getAllRecords();
    }

    public List<Record> getAllRecordsByCustomerId(@PathVariable Long customerId, Model model) {
        return recordService.getAllRecordsByCustomerId(customerId);
    }
}
