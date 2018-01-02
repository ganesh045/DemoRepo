package com.finaptics.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.finaptics.entity.Mobile;

public interface MobileRepository extends  CrudRepository<Mobile , Integer> {

	
    Mobile	getMobileBymarketEntryDate(Date date);
    
    List<Mobile> getMobileByMarketEntryDateBetween(Date date1,Date date2);
}
