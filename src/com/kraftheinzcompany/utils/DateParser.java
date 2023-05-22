package com.kraftheinzcompany.utils;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public abstract class DateParser {
	public static Date localDateToSQl(LocalDate date) {
		Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
		return new Date(instant.toEpochMilli());
	}
}
