package kg.amanturov.doska.repository;

import kg.amanturov.doska.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    List<Tickets> findAllByTicketNumber(Integer number);
    @Query("SELECT DISTINCT t.ticketNumber FROM Tickets t")
    List<Integer> findDistinctTicketNumbers();

}
