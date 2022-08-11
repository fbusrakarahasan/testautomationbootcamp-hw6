### 1. Aşağıdaki flightTicketFromList metodundaki flightList dizisini stream kullanarak List'e çeviriniz.
---

```java
public List<String> flightTicketFromList(String kw) throws UnirestException, IOException {
	HttpResponse<JsonNode> response = Unirest.get("https://www.enuygun.com/ucak-bileti/trip-autocomplete/?term="+kw)
	.header("cookie", "SERVERID-SH=shwww7; SERVERID-SAG=rdwww10")
	.asJson();
  
	ObjectMapper mapper = new ObjectMapper();
	Root[] flightList = mapper.readValue(response.getBody().toString(), Root[].class);
	List<String> city_name_code_airport_country = new ArrayList<>();
	for(int i=0;i<flightList.length;i++){
		city_name_code_airport_country.add
		(flightList[i].getCity_code()+","+
		flightList[i].getCountry_name()+":"+
		flightList[i].getAirport()+":"+
		flightList[i].getCity_name()
		);
	}
	return city_name_code_airport_country; 
}
```

```java
public List<String> flightTicketFromListStream(String kw) throws UnirestException, IOException {
    HttpResponse<JsonNode> response = Unirest.get("https://www.enuygun.com/ucak-bileti/trip-autocomplete/?term=" + kw)
        .header("cookie", "SERVERID-SH=shwww7; SERVERID-SAG=rdwww10")
        .asJson();

    ObjectMapper mapper = new ObjectMapper();
    Root[] flightList = mapper.readValue(response.getBody().toString(), Root[].class);

    return Arrays.stream(flightList).map(e -> e.getCity_code() + "," +
        e.getCountry_name() + ":" +
        e.getAirport() + ":" +
        e.getCity_name()).toList();
}
```

### 2. Aşağıdaki restAssured ile yazılmış flightTiketFromListByRest metodunu parametrik yapıp stream kullanınız.
---

```java
public void flightTiketFromListByRest(){

    response = given()
        .header("content-type","application/json")
        .when()
        .get("https://www.enuygun.com/ucak-bileti/trip-autocomplete/?term=mer")
        .then()
        .statusCode(200)
        .extract().response(); 
}
``` 

```java
public List<String> flightTiketFromListByRest(String kw) throws JsonProcessingException {
        response = given()
        .header("content-type", "application/json")
        .when()
        .get("https://www.enuygun.com/ucak-bileti/trip-autocomplete/?term="+ kw)
        .then()
        .statusCode(200)
        .extract().response();

    ObjectMapper mapper = new ObjectMapper();
    Root[] flightList = mapper.readValue(response.asString(), Root[].class);

    return Arrays.stream(flightList).map(e -> e.getCity_code() + "," +
        e.getCountry_name() + ":" +
        e.getAirport() + ":" +
        e.getCity_name()).toList();
}
``` 
