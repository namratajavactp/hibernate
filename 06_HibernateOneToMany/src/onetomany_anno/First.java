/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetomany_anno;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 
@Entity
@Table(name = "first")
@NamedQueries({@NamedQuery(name = "First.findAll", query = "SELECT f FROM First f"), @NamedQuery(name = "First.findByFirstid", query = "SELECT f FROM First f WHERE f.firstid = :firstid"), @NamedQuery(name = "First.findByName", query = "SELECT f FROM First f WHERE f.name = :name")})
public class First implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "firstid")
    private Integer firstid;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "firstid", cascade=CascadeType.REMOVE)
    private Collection<Second> secondCollection;

    public First() {
    }

    public First(Integer firstid) {
        this.firstid = firstid;
    }

    public Integer getFirstid() {
        return firstid;
    }

    public void setFirstid(Integer firstid) {
        this.firstid = firstid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Second> getSecondCollection() {
        return secondCollection;
    }

    public void setSecondCollection(Collection<Second> secondCollection) {
        this.secondCollection = secondCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (firstid != null ? firstid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof First)) {
            return false;
        }
        First other = (First) object;
        if ((this.firstid == null && other.firstid != null) || (this.firstid != null && !this.firstid.equals(other.firstid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.First[firstid=" + firstid + "]";
    }

}
