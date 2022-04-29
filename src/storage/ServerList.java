package storage;

import model.Server;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServerList implements IServerStorage {

    List<Server> source = new ArrayList<>();

    @Override
    public synchronized void update(Server serverData) {
        source.remove(serverData);
        source.add(serverData);
    }

    @Override
    public synchronized Server getOptimal() {

        return source.stream()
                .min(Comparator.comparingInt(Server::getLoad))
                .orElse(null);
    }


    @Override
    public synchronized void clear(int millis) {
        source.removeIf(serverData ->
                ChronoUnit.MILLIS.between(serverData.getTimeLastUpdate(), LocalDateTime.now()) > millis
        );
    }
}
