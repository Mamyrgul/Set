package service;

import models.Group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface GroupService {
    Group getGroupById(Long id);
    void saveGroup(Group group);
    ArrayList<Group> getAllGroups();
    Group getGroupByName(String name);
    Group updateGroupName(Long id,Group group);
    String deleteGroup(Long id);

}
