package resources.dao;

import resources.bean.Project;

import java.util.List;

public interface ProjectDao {
    //增加
    void add(Project project);

    //修改
    void update(Project project);

    //按ID获取
    Project getProjectById(int id);

    //获取所有项目
    List<Project> ProjectList();

    //分页查询
    List<Project> ProjectList(int start, int count);
}
