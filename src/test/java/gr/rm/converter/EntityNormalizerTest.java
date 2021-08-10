package gr.rm.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;

import gr.rm.model.CountryRestrictionNormalized;
import gr.rm.model.CountryRestrictionPojo;

public class EntityNormalizerTest {

	Converter<CountryRestrictionPojo, CountryRestrictionNormalized> converter;

	@BeforeEach
	void setUp() {
		converter = new EntityNormalizer();
	}

	@Test
	void convertValid() {
		CountryRestrictionPojo toConvert = validRestrictionPojo();
		CountryRestrictionNormalized converted = converter.convert(toConvert);
		assertEquals(Instant.parse("2020-02-01T00:00:00.00Z"), converted.date);
		assertEquals(21.21, converted.containmentHealthIndex);
		assertEquals(1234, converted.confirmedCases);
	}
	
	@Test
	void convertingNullCase() {
		CountryRestrictionNormalized converted = converter.convert(null);
		assertNotNull(converted);
	}
	
	@Test
	void convertingInvalidValueForField() {
		CountryRestrictionPojo toConvert = invalidDataValues();
		CountryRestrictionNormalized converted = converter.convert(toConvert);
		assertNull(converted.c1_Flag);
		assertNull(converted.confirmedCases);
		assertNull(converted.c1_School_closing);
		assertNull(converted.confirmedDeaths);
		assertNull(converted.confirmedCases);
		assertNull(converted.date);
		assertNull(converted.c2_Workplace_closing);
	}
	
	@Test
	void convertingInvalidDatePattern() {
		CountryRestrictionPojo toConvert = invalidDatePattern();
		CountryRestrictionNormalized converted = converter.convert(toConvert);
		assertNull(converted.date);
	}
	
	private CountryRestrictionPojo validRestrictionPojo() {
		CountryRestrictionPojo toConvert = new CountryRestrictionPojo();
		toConvert.date = "20200201";
		toConvert.containmentHealthIndex = "21.21";
		toConvert.confirmedCases = "1234";
		return toConvert;
	}

	private CountryRestrictionPojo invalidDatePattern() {
		CountryRestrictionPojo toConvert = new CountryRestrictionPojo();
		toConvert.date = "invalid";
		return toConvert;
	}

	private CountryRestrictionPojo invalidDataValues() {
		CountryRestrictionPojo toConvert = new CountryRestrictionPojo();
		toConvert.c1_Flag = "invalid";
		toConvert.confirmedCases = "invalid";
		toConvert.confirmedDeaths = "";
		toConvert.c1_School_closing = "";
		toConvert.c2_Workplace_closing = null;
		toConvert.governmentResponseIndex = "0.2";
		toConvert.date = null;
		return toConvert;
	}
	
}
