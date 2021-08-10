package gr.rm.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.InputStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;

import gr.rm.model.CountryRestrictionPojo;

public class CsvToEntityConverterTest {

	Converter<InputStream, Stream<CountryRestrictionPojo>> converter;

	@BeforeEach
	void setUp() {
		converter = new CsvToEntityConverter();
	}

	@Test
	void dataSliceStreamCase() {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("data_slice.csv");
		try (Stream<CountryRestrictionPojo> actualStream = converter.convert(inputStream)) {
			assertEquals(actualStream.count(), 1L);
		}
	}
	
	@Test
	void unknownPropertiesCase() {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("unknown_data.csv");
		try (Stream<CountryRestrictionPojo> actualStream = converter.convert(inputStream)) {
			assertFalse(actualStream.findAny().isPresent());
		}
	}

	@Test
	void emptyStreamCase() {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("empty.csv");
		assertThrows(RuntimeException.class, () -> {
			converter.convert(inputStream);
		});
	}

	@Test
	void inputStreamNullCase() {
		Stream<CountryRestrictionPojo> actualStream = converter.convert(null);
		assertFalse(actualStream.findAny().isPresent());
	}
}
