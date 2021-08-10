package gr.rm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryRestrictionPojo {
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
	public String date;
	@JsonProperty("C1_School closing")
	public String c1_School_closing;
	@JsonProperty("C1_Flag")
	public String c1_Flag;
	@JsonProperty("C2_Workplace closing")
	public String c2_Workplace_closing;
	@JsonProperty("C2_Flag")
	public String c2_Flag;
	@JsonProperty("C3_Cancel public events")
	public String c3_Cancel_public_events;
	@JsonProperty("C3_Flag")
	public String c3_Flag;
	@JsonProperty("C4_Restrictions on gatherings")
	public String c4_Restrictions_on_gatherings;
	@JsonProperty("C4_Flag")
	public String c4_Flag;
	@JsonProperty("C5_Close public transport")
	public String c5_Close_public_transport;
	@JsonProperty("C5_Flag")
	public String c5_Flag;
	@JsonProperty("C6_Stay at home requirements")
	public String c6_Stay_at_home_requirements;
	@JsonProperty("C6_Flag")
	public String c6_Flag;
	@JsonProperty("C7_Restrictions on internal movement")
	public String c7_Restrictions_on_internal_movement;
	@JsonProperty("C7_Flag")
	public String c7_Flag;
	@JsonProperty("C8_International travel controls")
	public String c8_International_travel_controls;
	@JsonProperty("E1_Income support")
	public String e1_Income_support;
	@JsonProperty("E1_Flag")
	public String e1_Flag;
	@JsonProperty("E2_Debt/contract relief")
	public String e2_Debt_contract_relief;
	@JsonProperty("E3_Fiscal measures")
	public String e3_Fiscal_measures;
	@JsonProperty("E4_International support")
	public String e4_International_support;
	@JsonProperty("H1_Public information campaigns")
	public String h1_Public_information_campaigns;
	@JsonProperty("H1_Flag")
	public String h1_Flag;
	@JsonProperty("H2_Testing policy")
	public String h2_Testing_policy;
	@JsonProperty("H3_Contact tracing")
	public String h3_Contact_tracing;
	@JsonProperty("H4_Emergency investment in healthcare")
	public String h4_Emergency_investment_in_healthcare;
	@JsonProperty("H5_Investment in vaccines")
	public String h5_Investment_in_vaccines;
	@JsonProperty("H6_Facial Coverings")
	public String h6_Facial_Coverings;
	@JsonProperty("H6_Flag")
	public String h6_Flag;
	@JsonProperty("H7_Vaccination policy")
	public String h7_Vaccination_policy;
	@JsonProperty("H7_Flag")
	public String h7_Flag;
	@JsonProperty("M1_Wildcard")
	public String m1_Wildcard;
	@JsonProperty("ConfirmedCases")
	public String confirmedCases;
	@JsonProperty("ConfirmedDeaths")
	public String confirmedDeaths;
	@JsonProperty("StringencyIndex")
	public String stringencyIndex;
	@JsonProperty("StringencyIndexForDisplay")
	public String stringencyIndexForDisplay;
	@JsonProperty("StringencyLegacyIndex")
	public String stringencyLegacyIndex;
	@JsonProperty("StringencyLegacyIndexForDisplay")
	public String stringencyLegacyIndexForDisplay;
	@JsonProperty("GovernmentResponseIndex")
	public String governmentResponseIndex;
	@JsonProperty("GovernmentResponseIndexForDisplay")
	public String governmentResponseIndexForDisplay;
	@JsonProperty("ContainmentHealthIndex")
	public String containmentHealthIndex;
	@JsonProperty("ContainmentHealthIndexForDisplay")
	public String containmentHealthIndexForDisplay;
	@JsonProperty("EconomicSupportIndex")
	public String economicSupportIndex;
	@JsonProperty("EconomicSupportIndexForDisplay")
	public String economicSupportIndexForDisplay;
}
