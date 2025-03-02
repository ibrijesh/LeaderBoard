package com.football.leaderboard.utils;


import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class ReflectionPatch {

    /**
     * Modifies multiple private fields using Reflection.
     *
     * @param patchData The target object.
     * @param target    A Object of field names to their new values.
     */
    public static void performPatch(Object target, Object patchData) throws IllegalAccessException {

        try {
            Class<?> clazz = target.getClass();
            Field[] fields = clazz.getFields();

            for (Field field : fields) {
                System.out.println(field);

                // CANT ACCESS IF THE FIELD IS PRIVATE
                field.setAccessible(true);

                // CHECK IF THE VALUE OF THE FIELD IS NOT NULL, IF NOT UPDATE EXISTING OBJECT
                Object value = field.get(patchData);

                if (value != null) {
                    field.set(target, value);
                }

                //MAKE THE FIELD PRIVATE AGAIN
                field.setAccessible(false);
            }

        } catch (IllegalAccessException e) {
            throw new IllegalAccessException("Error modifying field");
        }

    }

}
