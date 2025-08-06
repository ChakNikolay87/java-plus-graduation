package ru.practicum.service;

public interface ParticipationService {
    boolean isUserParticipatedInEvent(Long eventId, Long userId);
}
