package com.todoapp.repo;

import com.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findByEventId(int postId);

    List<Task> findByAssignedPersonsId(int id);

}
