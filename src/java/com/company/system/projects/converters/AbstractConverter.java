/**
 * The package for persisting converters. They are necessary for working with
 * POJO objects. We keep person's Primary Keys in the ERID table (as Foreign
 * keys)
 * 
*/
package com.company.system.projects.converters;

import com.company.system.projects.mapping.AbstractPerson;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Abstract class for converting data.
 * It's converting SelectOneMenu (ListBox) for saving 
 * persons ID's in the ERID table.
 * Realize pattern 'Template method'. 
 * 
 * @author ---GPL---
 */
@FacesConverter(value = "abstractConverter")
public abstract class AbstractConverter implements Converter {
    
    /**
     * String's constant for using JNDI in the Converters. 
     */
    public static final String pathFacade = "com.company.system.projects.facade";
    
    

    /**
     * Convert the specified string value, which is associated with
     * the specified UIComponent, into a model data object that is appropriate 
     * for being stored during the Apply Request Values phase of the request processing lifecycle.
     * 
     * @param context  - FacesContext for the request being processed
     * @param component - UIComponent with which this model object value is associated
     * @param value   - String value to be converted (may be null)
     * @return null if the value to convert is null, otherwise the result of the conversion
     * @throws ConverterException - if conversion cannot be successfully performed
     *  java.lang.NullPointerException - if context or component is null
     */
    @Override
    public final Object getAsObject(FacesContext context, UIComponent component, String value) {
        //If value isEmpty or it's default value 'Select', do nothing
        if (value == null || (value.trim().length() == 0) || value.equals("") || value.equals("Select")) {
            return null;
        } else {
            try { 
                Integer id = getIdFromStringPerson(value);  //Get ID the String
                AbstractPerson person = findPersonById(id); // Find Person by Id
                return person;
                
            } catch (NumberFormatException ex) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Person "));
            }
        }
    }
    
    //Get id from the StringValue. (Use pattern 'Template Method') - concrete operation
      final Integer getIdFromStringPerson(String selectedValue) {
        String [] tokens = selectedValue.split(":"); //Split our String
        int idPosition = 1; // ID's position in the our String(See getAsString())
        return Integer.parseInt(tokens[idPosition]); //Extract Id from the string
    }
     //Get Concrete Person. ('Template Method') - primitive operation
     abstract AbstractPerson findPersonById(Integer id);
             
             
     /**
      * Convert the specified model object value, 
      * which is associated with the specified UIComponent, 
      * into a String that is suitable for being included in the 
      * response generated during the Render Response phase of the 
      * request processing lifeycle.
      * 
      * @param context - FacesContext for the request being processed
      * @param component - UIComponent with which this model object value is associated
      * @param value - Model object value to be converted (may be null)
      * @return a zero-length String if value is null, otherwise the result of the conversion
      * @throws ConverterException - if conversion cannot be successfully performed
      *     java.lang.NullPointerException - if context or component is null
      */
     @Override
    public final String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value == null || value.equals("")) {
             return null;
         } else {
             //Get ID from the Person Object (primitive operation in the subclass)
             Integer id = getIdFromObjectPerson(value);
             //Create an Array for persisting personal Info (FirstName, LastName, E-mail - 3 fields)
             String [] personalInfo = getPersonalInfo(value);
             //Create String from the Person object
             String toString = getNewStringFromPerson(id, personalInfo[0], personalInfo[1], personalInfo[2]);
             
             return toString;
         }
    }
    
    /** 
     * Concrete Method which extracts 'ID' from the person
     * @param value - Concrete Person's object
     * @return Integer id
     */
       final Integer  getIdFromObjectPerson(Object value) {
          Integer id = (Integer) ((AbstractPerson) value).getId();
          return id;
      }
    
    
    /**
     * Method returns the Array with personal Info, which
     * will be using to create String's presentation of the object
     * 
     * @param value - Concrete Person Object
     * @return String [] personalInfo : [0] - firstName, [1] - lastName, [2] - email
     */
    final String [] getPersonalInfo(Object value) {
        int countInfo = 3; //Cound of the personal information fields
        String toString [] = new String[countInfo];
        //Extract some information
        toString[0]  = (String) ((AbstractPerson) value).getFirstName();
        toString[1]  = (String) ((AbstractPerson) value).getLastName();
        toString[2]  = (String) ((AbstractPerson) value).getEmail();
        return toString;
    }
  
    /**
     * 
     * @param id - ID of the Person
     * @param firstName - Person's First Name
     * @param lastName - Person's Last Name
     * @param email  - - Person's E-mail
     * @return toString - String's presentation of the Person
     */
    final String getNewStringFromPerson(Integer id, String firstName, String lastName, String email) {
          //Create the String's presentation of the object in StringBuilder
                StringBuilder builder = new StringBuilder("Person ");
                builder.append(" [ ID = :").append(id).append(":, First Name = :").
                        append(firstName).append(":, Last Name = :").append(lastName).
                        append(":, E-mail = :").append(email).append(":]");   
                return builder.toString();
    }
}
