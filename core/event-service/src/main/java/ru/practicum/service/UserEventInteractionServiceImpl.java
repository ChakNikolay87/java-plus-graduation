package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.controller.UserActionClient;
import ru.practicum.ewm.stats.proto.ActionTypeProto;
import ru.practicum.request_service.client.PrivateRequestsClient;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserEventInteractionServiceImpl implements UserEventInteractionService {

    private final PrivateRequestsClient privateRequestsClient;
    private final UserActionClient collectorClient;

    @Override
    public void likeEvent(Long userId, Long eventId) {
        if (privateRequestsClient.isUserParticipatedInEvent(userId, eventId)) {
            collectorClient.sendUserAction(userId, eventId, ActionTypeProto.ACTION_LIKE, Instant.now());
        }
    }
}
