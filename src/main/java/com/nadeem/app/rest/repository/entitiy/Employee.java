package com.nadeem.app.rest.repository.entitiy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="employees")
public class Employee implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    public static final int MAX_LENGTH_NAME = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "creation_time", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationTime;

    @Column(name = "modification_time", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;

    @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;
    
    @Column(name = "email", nullable = false)
    private String email;

    @Version
    private long version;
    
    
    public static Builder getBuilder(String name, String email) {
        return new Builder(name, email);
    }

    public Employee()
    {

    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }
    
    public DateTime getCreationTime()
    {
        return creationTime;
    }

    public DateTime getModificationTime()
    {
        return modificationTime;
    }

    public long getVersion()
    {
        return version;
    }

    public void update(final String newEmail)
    {
        this.email = newEmail;
    }

    @PrePersist
    public void prePersist() {
        DateTime now = DateTime.now();
        creationTime = now;
        modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        modificationTime = DateTime.now();
    }

    public static class Builder {

        private Employee built;

        public Builder(String name, String email) {
            built = new Employee();
            built.email = email;
            this.built.name = name;
        }

        public Builder name(String name) {
            built.name = name;
            return this;
        }

        public Employee build() {
            return built;
        }

    }
}
