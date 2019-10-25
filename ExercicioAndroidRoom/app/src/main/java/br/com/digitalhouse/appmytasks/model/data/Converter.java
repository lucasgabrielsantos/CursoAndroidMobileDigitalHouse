package br.com.digitalhouse.appmytasks.model.data;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converter {

    @TypeConverter
    public Date converteDateJava(Long timeTemsp){
        if (timeTemsp == null){
            return null;
        }else {
            return new Date(timeTemsp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date){
        return date.getTime();
    }
}
