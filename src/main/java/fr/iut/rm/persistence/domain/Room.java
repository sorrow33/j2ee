package fr.iut.rm.persistence.domain;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A classic room
 */
@Entity
@Table(name = "room")
public class Room {
    /**
     * sequence generated id
     */
    @Id
    @GeneratedValue
    private long id;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.folks = 0;
    }

    /**
     * Room's name
     */
    @Column(nullable = false, unique = true)
    private String name;


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Room's capacity
     */
    @Column(nullable = false)
    private int capacity;

    public int getFolks() {
        return folks;
    }

    public void setFolks(int folks) {
        this.folks = folks;
    }

    private int folks;


    /**
     * Default constructor (do nothing)
     */
    public Room() {
        // do nothing
    }

    /**
     * anemic getter
     *
     * @return the room's id
     */
    public long getId() {
        return id;
    }

    /**
     * anemic setter
     *
     * @param id the new id
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * anemic getter
     *
     * @return the calling number
     */
    public String getName() {
        return name;
    }

    /**
     * anemic setter
     *
     * @param name the new calling number to set
     */
    public void setName(final String name) {
        this.name = name;
    }



    public int getTaux(){
        float result = ((float)folks/(float)capacity)*100;
        return (int)result;
    }

}
