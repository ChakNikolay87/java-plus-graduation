package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.repository.ParticipationRequestRepository;

@Service
@RequiredArgsConstructor
public class ParticipationServiceImpl implements ParticipationService {

    private final ParticipationRequestRepository requestRepository;

    @Override
    public boolean isUserParticipatedInEvent(Long eventId, Long userId) {
        return requestRepository.findByUserIdAndEventId(userId, eventId).isPresent();
    }
}
