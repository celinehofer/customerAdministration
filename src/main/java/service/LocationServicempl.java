package service;
import entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.LocationRepository;
import java.util.List;

@Service
public class LocationServicempl {

        @Autowired
        private LocationRepository repository;

        @Override
        public Location saveLocation(Location location) {
            return repository.save(location);
        }

        @Override
        public Location updateLocation(Location location) {
            return repository.save(location);
        }

        @Override
        public void deleteLocation(Location location) {
            repository.delete(location);
        }

        @Override
        public Location getLocationById(int id) {
            return repository.getOne(id);
        }

        @Override
        public List<Location> getAllLocations() {
            return null;
        }
    }

