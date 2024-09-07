package src.main;
/*
 * Name: Huy Truong
 * netID: htruon5
 * G#: 01452512
 * Lecture section: 003
 * Lab section: 205
 */
import java.util.List;


public record MemorySnapshot(List<SystemWhole> emulationMemory,
                             List<SystemWhole> simulacraMemory,
                             List<SystemWhole> simulationMemory) {}
