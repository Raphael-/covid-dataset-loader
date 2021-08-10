package gr.rm.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryRestrictionNormalized {
	@JsonProperty("CountryName")
	public String countryName;
	@JsonProperty("CountryCode")
	public String countryCode;
	@JsonProperty("RegionName")
	public String regionName;
	@JsonProperty("RegionCode")
	public String regionCode;
	@JsonProperty("Jurisdiction")
	public String jurisdiction;
	@JsonProperty("Date")
	public Instant date;
	@JsonProperty("C1_School closing")
	public Double c1_School_closing;
	@JsonProperty("C1_Flag")
	public Double c1_Flag;
	@JsonProperty("C2_Workplace closing")
	public Double c2_Workplace_closing;
	@JsonProperty("C2_Flag")
	public Double c2_Flag;
	@JsonProperty("C3_Cancel public events")
	public Double c3_Cancel_public_events;
	@JsonProperty("C3_Flag")
	public Double c3_Flag;
	@JsonProperty("C4_Restrictions on gatherings")
	public Double c4_Restrictions_on_gatherings;
	@JsonProperty("C4_Flag")
	public Double c4_Flag;
	@JsonProperty("C5_Close public transport")
	public Double c5_Close_public_transport;
	@JsonProperty("C5_Flag")
	public Double c5_Flag;
	@JsonProperty("C6_Stay at home requirements")
	public Double c6_Stay_at_home_requirements;
	@JsonProperty("C6_Flag")
	public Double c6_Flag;
	@JsonProperty("C7_Restrictions on internal movement")
	public Double c7_Restrictions_on_internal_movement;
	@JsonProperty("C7_Flag")
	public Double c7_Flag;
	@JsonProperty("C8_International travel controls")
	public Double c8_International_travel_controls;
	@JsonProperty("E1_Income support")
	public Double e1_Income_support;
	@JsonProperty("E1_Flag")
	public Double e1_Flag;
	@JsonProperty("E2_Debt/contract relief")
	public Double e2_Debt_contract_relief;
	@JsonProperty("E3_Fiscal measures")
	public Double e3_Fiscal_measures;
	@JsonProperty("E4_International support")
	public Double e4_International_support;
	@JsonProperty("H1_Public information campaigns")
	public Double h1_Public_information_campaigns;
	@JsonProperty("H1_Flag")
	public Double h1_Flag;
	@JsonProperty("H2_Testing policy")
	public Double h2_Testing_policy;
	@JsonProperty("H3_Contact tracing")
	public Double h3_Contact_tracing;
	@JsonProperty("H4_Emergency investment in healthcare")
	public Double h4_Emergency_investment_in_healthcare;
	@JsonProperty("H5_Investment in vaccines")
	public Double h5_Investment_in_vaccines;
	@JsonProperty("H6_Facial Coverings")
	public Double h6_Facial_Coverings;
	@JsonProperty("H6_Flag")
	public Double h6_Flag;
	@JsonProperty("H7_Vaccination policy")
	public Double h7_Vaccination_policy;
	@JsonProperty("H7_Flag")
	public Double h7_Flag;
	@JsonProperty("M1_Wildcard")
	public Double m1_Wildcard;
	@JsonProperty("ConfirmedCases")
	public Integer confirmedCases;
	@JsonProperty("ConfirmedDeaths")
	public Integer confirmedDeaths;
	@JsonProperty("StringencyIndex")
	public Double stringencyIndex;
	@JsonProperty("StringencyIndexForDisplay")
	public Double stringencyIndexForDisplay;
	@JsonProperty("StringencyLegacyIndex")
	public Double stringencyLegacyIndex;
	@JsonProperty("StringencyLegacyIndexForDisplay")
	public Double stringencyLegacyIndexForDisplay;
	@JsonProperty("GovernmentResponseIndex")
	public Double governmentResponseIndex;
	@JsonProperty("GovernmentResponseIndexForDisplay")
	public Double governmentResponseIndexForDisplay;
	@JsonProperty("ContainmentHealthIndex")
	public Double containmentHealthIndex;
	@JsonProperty("ContainmentHealthIndexForDisplay")
	public Double containmentHealthIndexForDisplay;
	@JsonProperty("EconomicSupportIndex")
	public Double economicSupportIndex;
	@JsonProperty("EconomicSupportIndexForDisplay")
	public Double economicSupportIndexForDisplay;
}
