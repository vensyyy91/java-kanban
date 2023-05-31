package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

/** Класс подзадачи */
public class SubTask extends Task {
    /** Поле Идентификатор эпика, которому принадлежит подзадача */
    private int masterTaskId;

    public SubTask(String name, String description, EpicTask masterTask) {
        super(name, description);
        this.startTime = LocalDateTime.of(2099, 12, 31, 0, 0);
        this.duration = Duration.ofMinutes(0);
        this.masterTaskId = masterTask.getId();
        this.status = TaskStatus.NEW;
        this.type = TaskType.SUBTASK;
    }

    public SubTask(String name, String description, String startTime, long duration, EpicTask masterTask) {
        super(name, description, startTime, duration);
        this.masterTaskId = masterTask.getId();
        this.status = TaskStatus.NEW;
        this.type = TaskType.SUBTASK;
    }

    public int getMasterTaskId() {
        return masterTaskId;
    }

    public void setMasterTaskId(int masterTaskId) {
        this.masterTaskId = masterTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubTask subtask = (SubTask) o;
        return id == subtask.id && Objects.equals(name, subtask.name)
                && Objects.equals(description, subtask.description)
                && Objects.equals(status, subtask.status)
                && Objects.equals(type, subtask.type)
                && masterTaskId == subtask.masterTaskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, type, masterTaskId);
    }

    @Override
    public String toString() {
        return String.format("%d,%s,\"%s\",%s,\"%s\",%s,%s,%d",
                id, type, name, status, description,
                startTime.format(formatter), getEndTime().format(formatter), masterTaskId);
    }
}
