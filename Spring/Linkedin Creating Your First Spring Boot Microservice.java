- java -version
- mvn -version
- java -jar tagret/snanan.jar
- java -Dserver.port=9090 -jar tagrget/sdssss.jar

Declare Spring Data JPA repository interfaces
---------------------------------------------
CRUD repository

public interface CRUDRepository<T, ID>

T  ==> Domain type the repository manage.
ID ==> Type of the entity ID.



Simple Spring Data query methods

1. Return Type.
	ex: List<Object>, Collection<Object>, Optional<Object>, ...
	note: be careful when choosing the return type, if used Optional<Object> and the return was Collection. it will throws IncorrectResultSizeDataAccessException ...
2. findBy.
3. Entity attribute name (camel case).
   note: can throws PropertyReferenceExcpetion, ex: findByRejoin
4. Optionally, chain some attribute name (ie. findByAttendeeLastName)
5. Parameter with datatype of the entity attribute.

integrate example:
List<Tour> findbyTourPackageCodeAndDifficultyAndPriceLessThan(Long tourPackageCode, Difficulty difficulty, Integer maxPrice)

Advanced example
@Query("Select t from Tour t where t.tourPackage.code = ?1 and t.difficulty = ?2 and t.region = ?3 and t.price <= ?4")
List<Tour> loopupTour(Long code, Difficulty difficulty, Region region, Integer maxPrice)

Paging and sorting
==================
URL Path Parameter
- size: number of per page.
- page: (defaut 0 ==> first page).
- sort: attributes by which  to sort search results.
	default is id,
	asc,
	desc	
	
how?
- using PagingAndSortingRepository<T, ID> instead of CrudRepository<T, ID>	
- if you need to add paging in a particular method, use Page<Tour> - instead of List<Tour>, and add additional parameter (, Pageable pageable)

in the get parameters:
http://localhost:8080/tours?size=3&page=1&sort=title.asc















