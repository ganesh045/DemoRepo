package com.finaptics.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.finaptics.entity.Mobile;

public interface MobileRepository extends  CrudRepository<Mobile , Integer> {

	
    Mobile	getMobileBymarketEntryDate(LocalDate date);
    
    List<Mobile> getMobileByMarketEntryDateBetween(LocalDate date1,LocalDate date2);
}
