package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Delivery {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

private String name;
private Date date;
private String status;

public Delivery(){}

public Delivery(String name, Date date, String status)
{
this.name=name;
this.date=date;
this.status=status;
}

}
