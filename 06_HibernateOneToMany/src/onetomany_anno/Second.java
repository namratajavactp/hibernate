/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetomany_anno;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

 
@Entity
@Table(name = "second")
@NamedQueries({@NamedQuery(name = "Second.findAll", query = "SELECT s FROM Second s"), @NamedQuery(name = "Second.findBySecondid", query = "SELECT s FROM Second s WHERE s.secondid = :secondid"), @NamedQuery(name = "Second.findByAnother", query = "SELECT s FROM Second s WHERE s.another = :another")})
public class Second implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "secondid")
    private Integer secondid;
    @Column(name = "another")
    private String another;
  @JoinColumn(name = "fk_firstid", referencedColumnName = "firstid")
  //default name of joincol firstid_firstid
    @ManyToOne(cascade=CascadeType.REMOVE)
    private First firstid;

    public Second() {
    }

    public Second(Integer secondid) {
        this.secondid = secondid;
    }

    public Integer getSecondid() {
        return secondid;
    }

    public void setSecondid(Integer secondid) {
        this.secondid = secondid;
    }

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }

    public First getFirstid() {
        return firstid;
    }

    public void setFirstid(First firstid) {
        this.firstid = firstid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secondid != null ? secondid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Second)) {
            return false;
        }
        Second other = (Second) object;
        if ((this.secondid == null && other.secondid != null) || (this.secondid != null && !this.secondid.equals(other.secondid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Second[secondid=" + secondid + "]";
    }

}
