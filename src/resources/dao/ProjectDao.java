package resources.dao;

import resources.bean.Project;

import java.util.List;

public interface ProjectDao {
    //增加
    public void add(Project project);

    //修改
    public void update(Project project);

    //按ID获取
    public Project getProjectById(int id);

    //获取所有项目
    public List<Project> ProjectList();

    //分页查询
    public List<Project> ProjectList(int start, int count);
}
