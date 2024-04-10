package org.booking.core.domain.entity.reservation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.booking.core.domain.entity.base.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

@Entity(name = ReservationSchedule.ENTITY_NAME)
@Table(name = ReservationSchedule.TABLE_NAME)
@Getter
@Setter
public class ReservationSchedule extends AbstractEntity {

	public static final String ENTITY_NAME = "ReservationSchedule";
	public static final String TABLE_NAME = "reservation_schedule";

	private Long businessId;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "reservation_schedule_reservations",
			joinColumns = {@JoinColumn(name = "reservation_schedule_reservation_id")},
			inverseJoinColumns = {@JoinColumn(name = "reservation_id")}
	)
	private Set<Reservation> reservations = new HashSet<>();

	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
}
