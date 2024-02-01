package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class DateBeforeAndAfterJavaEight {

    //Before Java 8 version
    @Temporal(TemporalType.DATE)
    private Date dirtOfDate;


    //Since 8 version Java don't need put annotation @Temporal
    private Date dateOfDied;
}
