package service;
import entities.Communication;
import java.util.List;

public interface CommunicationService {
    Communication saveCommunication(Communication communication);
    Communication updateCommunication(Communication communication);
    void deleteCommunication(Communication communication);
    Communication getCommunicationById(int id);
    List<Communication> getAllCommunications();
}
