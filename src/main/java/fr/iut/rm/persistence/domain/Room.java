package fr.iut.rm.persistence.domain;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    @Min(0)
    private int capacity;

    final int MAX_CAPACITY = 33;


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



    public int tauxRemplissage (int capacity) {
        float taux;
        taux = (capacity / MAX_CAPACITY);
        if (taux < 40 / 100)
            return 1;
        else if (taux < 70 / 100)
            return 2;
        else
            return 3;

    }

}
