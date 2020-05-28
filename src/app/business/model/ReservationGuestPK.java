/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReservationGuestPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_reservation")
    private int idReservation;
    @Basic(optional = false)
    @Column(name = "id_guest")
    private int idGuest;

    public ReservationGuestPK() {
    }

    public ReservationGuestPK(int idReservation, int idGuest) {
        this.idReservation = idReservation;
        this.idGuest = idGuest;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idReservation;
        hash += (int) idGuest;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationGuestPK)) {
            return false;
        }
        ReservationGuestPK other = (ReservationGuestPK) object;
        if (this.idReservation != other.idReservation) {
            return false;
        }
        if (this.idGuest != other.idGuest) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.business.model.ReservationGuestPK[ idReservation=" + idReservation + ", idGuest=" + idGuest + " ]";
    }
    
}
