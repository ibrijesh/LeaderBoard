package com.football.leaderboard.utils;


import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class ReflectionPatch {

    /**
     * Modifies multiple private fields using Reflection.
     *
     * @param patchData The target object.
     * @param oldData   A Object of field names to their new values.
     */
    public static void performPatch(Object oldData, Object patchData) throws IllegalAccessException {

        try {
            Class<?> oldClass = Hibernate.getClass(oldData);
            Class<?> patchclass = Hibernate.getClass(oldData);

            Field[] fields = oldClass.getDeclaredFields();

            for (Field oldField : fields) {
                System.out.println(oldField);

                String fieldName = oldField.getName();

                if (fieldName.toLowerCase().contains("id") || fieldName.toLowerCase().contains("player")) {
                    continue;
                }

                Field patchField = patchclass.getDeclaredField(fieldName);


                // CANT ACCESS IF THE FIELD IS PRIVATE
                oldField.setAccessible(true);
                patchField.setAccessible(true);


                // CHECK IF THE VALUE OF THE FIELD IS NOT NULL, IF NOT UPDATE EXISTING OBJECT
                Object patchValue = patchField.get(patchData);

                if (patchValue != null)
                    oldField.set(oldData, patchValue);

                //MAKE THE FIELD PRIVATE AGAIN
                oldField.setAccessible(false);
                patchField.setAccessible(false);
            }

        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("Error modifying field");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Modifies multiple private fields using Reflection.
     *
     * @param patchData The target object.
     * @param oldData   A Object of field names to their new values.
     *                  Here not create result , Hibernate track change if we create new object Hibernate will not able to track.
     */
    public static void performAddition(Object oldData, Object patchData) throws IllegalAccessException {

        try {

            Class<?> oldClass = Hibernate.getClass(oldData);
            Class<?> patchClass = Hibernate.getClass(patchData);


            Field[] fields = oldClass.getDeclaredFields();
            System.out.println("Fields count: " + fields.length);
            for (Field oldField : fields) {


                // CANT ACCESS IF THE FIELD IS PRIVATE
                oldField.setAccessible(true);

                System.out.println(oldField.getName());

                String fieldName = oldField.getName();

                if (fieldName.toLowerCase().contains("id") || fieldName.toLowerCase().contains("player") || fieldName.toLowerCase().contains("updatedat")) {
                    oldField.setAccessible(false);
                    continue;
                }

                Field patchField = patchClass.getDeclaredField(fieldName);
                patchField.setAccessible(true);

                // CHECK IF THE VALUE OF THE FIELD IS NOT NULL, IF NOT UPDATE EXISTING OBJECT
                Object oldValue = oldField.get(oldData);
                Object patchValue = patchField.get(patchData);

                if (oldValue instanceof Number && patchValue instanceof Number) {
                    Number sum = ((Number) oldValue).longValue() + ((Number) patchValue).longValue();
                    oldField.set(oldData, sum);
                } else if (oldValue == null && patchValue == null) {
                    oldField.set(oldData, 0L);
                } else if (oldValue == null) oldField.set(oldData, patchValue);
                else oldField.set(oldData, oldValue);


                //MAKE THE FIELD PRIVATE AGAIN
                oldField.setAccessible(false);
                patchField.setAccessible(false);
            }

        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("Illegal Exception Error modifying field");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Modifies multiple private fields using Reflection.
     *
     * @param patchData The target object.
     * @param oldData   A Object of field names to their new values.
     */

    public static void performSubtraction(Object oldData, Object patchData) throws IllegalAccessException {

        try {

            Class<?> oldClass = Hibernate.getClass(oldData);
            Class<?> patchClass = Hibernate.getClass(patchData);


            Field[] fields = oldClass.getDeclaredFields();
            System.out.println("Fields count: " + fields.length);
            for (Field oldField : fields) {


                // CANT ACCESS IF THE FIELD IS PRIVATE
                oldField.setAccessible(true);

                System.out.println(oldField.getName());

                String fieldName = oldField.getName();

                if (fieldName.toLowerCase().contains("id") || fieldName.toLowerCase().contains("player") || fieldName.toLowerCase().contains("updatedat")) {
                    oldField.setAccessible(false);
                    continue;
                }

                Field patchField = patchClass.getDeclaredField(fieldName);
                patchField.setAccessible(true);

                // CHECK IF THE VALUE OF THE FIELD IS NOT NULL, IF NOT UPDATE EXISTING OBJECT
                Object oldValue = oldField.get(oldData);
                Object patchValue = patchField.get(patchData);

                if (oldValue instanceof Number && patchValue instanceof Number) {
                    Number sum = ((Number) oldValue).longValue() - ((Number) patchValue).longValue();
                    oldField.set(oldData, sum);
                } else if (oldValue == null && patchValue == null) {
                    oldField.set(oldData, 0L);
                } else if (oldValue == null) oldField.set(oldData, patchValue);
                else oldField.set(oldData, oldValue);


                //MAKE THE FIELD PRIVATE AGAIN
                oldField.setAccessible(false);
                patchField.setAccessible(false);
            }

        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("Illegal Exception Error modifying field");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
