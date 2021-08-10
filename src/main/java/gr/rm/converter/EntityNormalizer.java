package gr.rm.converter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gr.rm.model.CountryRestrictionNormalized;
import gr.rm.model.CountryRestrictionPojo;

@Component
public class EntityNormalizer implements Converter<CountryRestrictionPojo, CountryRestrictionNormalized> {
	private static final DateTimeFormatter ENTITY_DATE_FORMATTER = new DateTimeFormatterBuilder()
			.appendPattern("yyyyMMdd").parseDefaulting(ChronoField.NANO_OF_DAY, 0).toFormatter()
			.withZone(ZoneId.of("UTC"));

	@Override
	public CountryRestrictionNormalized convert(CountryRestrictionPojo source) {
		return normalize(source);
	}

	private CountryRestrictionNormalized normalize(CountryRestrictionPojo pojo) {
		CountryRestrictionNormalized normalized = new CountryRestrictionNormalized();
		if (pojo == null) {
			return normalized;
		}
		normalized.countryName = pojo.countryName;
		normalized.countryCode = pojo.countryCode;
		normalized.regionName = pojo.regionName;
		normalized.regionCode = pojo.regionCode;
		normalized.jurisdiction = pojo.jurisdiction;
		normalized.date = parseDate(pojo);
		normalized.c1_School_closing = toDouble(pojo.c1_School_closing);
		normalized.c1_Flag = toDouble(pojo.c1_Flag);
		normalized.c2_Workplace_closing = toDouble(pojo.c2_Workplace_closing);
		normalized.c2_Flag = toDouble(pojo.c2_Flag);
		normalized.c3_Cancel_public_events = toDouble(pojo.c3_Cancel_public_events);
		normalized.c3_Flag = toDouble(pojo.c3_Flag);
		normalized.c4_Restrictions_on_gatherings = toDouble(pojo.c4_Restrictions_on_gatherings);
		normalized.c4_Flag = toDouble(pojo.c4_Flag);
		normalized.c5_Close_public_transport = toDouble(pojo.c5_Close_public_transport);
		normalized.c5_Flag = toDouble(pojo.c5_Flag);
		normalized.c6_Stay_at_home_requirements = toDouble(pojo.c6_Stay_at_home_requirements);
		normalized.c6_Flag = toDouble(pojo.c6_Flag);
		normalized.c7_Restrictions_on_internal_movement = toDouble(pojo.c7_Restrictions_on_internal_movement);
		normalized.c7_Flag = toDouble(pojo.c7_Flag);
		normalized.c8_International_travel_controls = toDouble(pojo.c8_International_travel_controls);
		normalized.e1_Income_support = toDouble(pojo.e1_Income_support);
		normalized.e1_Flag = toDouble(pojo.e1_Flag);
		normalized.e2_Debt_contract_relief = toDouble(pojo.e2_Debt_contract_relief);
		normalized.e3_Fiscal_measures = toDouble(pojo.e3_Fiscal_measures);
		normalized.e4_International_support = toDouble(pojo.e4_International_support);
		normalized.h1_Public_information_campaigns = toDouble(pojo.h1_Public_information_campaigns);
		normalized.h1_Flag = toDouble(pojo.h1_Flag);
		normalized.h2_Testing_policy = toDouble(pojo.h2_Testing_policy);
		normalized.h3_Contact_tracing = toDouble(pojo.h3_Contact_tracing);
		normalized.h4_Emergency_investment_in_healthcare = toDouble(pojo.h4_Emergency_investment_in_healthcare);
		normalized.h5_Investment_in_vaccines = toDouble(pojo.h5_Investment_in_vaccines);
		normalized.h6_Facial_Coverings = toDouble(pojo.h6_Facial_Coverings);
		normalized.h6_Flag = toDouble(pojo.h6_Flag);
		normalized.h7_Vaccination_policy = toDouble(pojo.h7_Vaccination_policy);
		normalized.h7_Flag = toDouble(pojo.h7_Flag);
		normalized.m1_Wildcard = toDouble(pojo.m1_Wildcard);
		normalized.confirmedCases = toInteger(pojo.confirmedCases);
		normalized.confirmedDeaths = toInteger(pojo.confirmedDeaths);
		normalized.stringencyIndex = toDouble(pojo.stringencyIndex);
		normalized.stringencyIndexForDisplay = toDouble(pojo.stringencyIndexForDisplay);
		normalized.stringencyLegacyIndex = toDouble(pojo.stringencyLegacyIndex);
		normalized.stringencyLegacyIndexForDisplay = toDouble(pojo.stringencyLegacyIndexForDisplay);
		normalized.governmentResponseIndex = toDouble(pojo.governmentResponseIndex);
		normalized.governmentResponseIndexForDisplay = toDouble(pojo.governmentResponseIndexForDisplay);
		normalized.containmentHealthIndex = toDouble(pojo.containmentHealthIndex);
		normalized.containmentHealthIndexForDisplay = toDouble(pojo.containmentHealthIndexForDisplay);
		normalized.economicSupportIndex = toDouble(pojo.economicSupportIndex);
		normalized.economicSupportIndexForDisplay = toDouble(pojo.economicSupportIndexForDisplay);
		return normalized;
	}

	private Instant parseDate(CountryRestrictionPojo pojo) {
		if (pojo.date == null) {
			return null;
		}
		try {
			return Instant.from(ENTITY_DATE_FORMATTER.parse(pojo.date));
		}
		catch(DateTimeParseException e) {
			return null;
		}
	}

	private Double toDouble(String value) {
		try {
			return value == null || value.isEmpty() ? null : Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private Integer toInteger(String value) {
		try {
			return value == null || value.isEmpty() ? null : Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
