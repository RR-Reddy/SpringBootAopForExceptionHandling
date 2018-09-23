package com.rr.daoImpl;

import org.springframework.stereotype.Repository;

import com.rr.annotation.HandleErrorMessage;
import com.rr.dao.EmpDao;

@Repository
public class EmpDaoImpl implements EmpDao {

	@SuppressWarnings("unused")
	@Override
	@HandleErrorMessage("erroe msg in annotation")
	public String getEmp() {

		if (true) {
			throw new NullPointerException("my null exception");
		}

		return "Emp Data";

	}

}
