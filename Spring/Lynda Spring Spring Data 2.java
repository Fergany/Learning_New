Simple Spring Data query methods

1. Return Type.
	ex: List<Object>, Collection<Object>, Optional<Object>, ...
	note: be careful when choosing the return type, if used Optional<Object> and the return was Collection. it will throws IncorrectResultSizeDataAccessException ...
2. findBy.
3. Entity attribute name (camel case).
   note: can throws PropertyReferenceExcpetion, ex: findByRejoin
4. Optionally, chain some attribute name (ie. findByAttendeeLastName)
5. Parameter with datatype of the entity attribute.

- Unlike regular sql, syntax error are find at startup not runtime.
PropertyRerenceException.


Query Method: Conditional Expressions:
- List<Student> findByAttendeeFirstNameAttendeeLastName(String firstName, String lastName)
- findByFullTimeOrAgeLessThan(boolean fullTime, int maxAge)
GreaterThan, ...


		if (allowExplicitDosingTimes == null)
		{
		return ((FrequencyCodeRepository) baseRepository).findAllByNameContainingOrderByName(name);
		}
		else if (allowExplicitDosingTimes == true)
		{
		return ((FrequencyCodeRepository) baseRepository).findAllByNameContainingAndAllowExplicitDosingTimesTrueOrderByName(name);
		}
		else if (allowExplicitDosingTimes == false)
		{
		return ((FrequencyCodeRepository) baseRepository).findAllByNameContainingAndAllowExplicitDosingTimesFalseOrderByName(name);
		}

		return null;