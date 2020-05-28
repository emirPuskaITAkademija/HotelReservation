/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grupa2
 */
@Entity
@Table(name = "reservation_guest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservationGuest.findAll", query = "SELECT r FROM ReservationGuest r")
    , @NamedQuery(name = "ReservationGuest.findByIdReservation", query = "SELECT r FROM ReservationGuest r WHERE r.reservationGuestPK.idReservation = :idReservation")
    , @NamedQuery(name = "ReservationGuest.findByIdGuest", query = "SELECT r FROM ReservationGuest r WHERE r.reservationGuestPK.idGuest = :idGuest")})
public class ReservationGuest implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationGuestPK reservationGuestPK;
    @JoinColumn(name = "id_guest", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Guest guest;

    public ReservationGuest() {
    }

    public ReservationGuest(ReservationGuestPK reservationGuestPK) {
        this.reservationGuestPK = reservationGuestPK;
    }

    public ReservationGuest(int idReservation, int idGuest) {
        this.reservationGuestPK = new ReservationGuestPK(idReservation, idGuest);
    }

    public ReservationGuestPK getReservationGuestPK() {
        return reservationGuestPK;
    }

    public void setReservationGuestPK(ReservationGuestPK reservationGuestPK) {
        this.reservationGuestPK = reservationGuestPK;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationGuestPK != null ? reservationGuestPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationGuest)) {
            return false;
        }
        ReservationGuest other = (ReservationGuest) object;
        if ((this.reservationGuestPK == null && other.reservationGuestPK != null) || (this.reservationGuestPK != null && !this.reservationGuestPK.equals(other.reservationGuestPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.business.model.ReservationGuest[ reservationGuestPK=" + reservationGuestPK + " ]";
    }
    
}
