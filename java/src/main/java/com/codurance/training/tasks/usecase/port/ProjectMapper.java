package com.codurance.training.tasks.usecase.port;

import com.codurance.training.tasks.entity.Project;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ProjectDto;

import java.util.List;

public class ProjectMapper {
    public static ProjectDto toDto (Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(project.getName().value());
        projectDto.setTaskDtos(TaskMapper.toDto(project.getTasks()));
        return projectDto;
    }

    public static List<ProjectDto> toDto (List<Project> projects) {
        return projects.stream()
                .map(ProjectMapper::toDto)
                .toList();
    }
}
