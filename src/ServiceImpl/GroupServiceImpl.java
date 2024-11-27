package ServiceImpl;

import database.Database;
import models.Group;
import service.GroupService;

import java.util.ArrayList;
import java.util.HashSet;

import static database.Database.groups;

public class GroupServiceImpl implements GroupService {
    @Override
    public Group getGroupById(Long id) {
         for (Group group : groups) {
            if (group.getId().equals(id)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public void saveGroup(Group group) {
        for (Group group1 : groups) {
            if (group1.getGroupName().equals(group.getGroupName())) {
                throw new IllegalArgumentException("Group with this name already exists");
            }
        }
        groups.add(group);
        System.out.println(group);
    }


    @Override
    public ArrayList<Group> getAllGroups() {
        return groups;
    }

    @Override
    public Group getGroupByName(String name) {
      for (Group group: groups){
          if (group.getGroupName().equalsIgnoreCase(name)){
              return group;
          }
      }
      return null;
    }

    @Override
    public Group updateGroupName(Long id, Group group) {
            Group groupToUpdate = getGroupById(id);
        if (groupToUpdate == null) {
            throw new IllegalArgumentException("Group with ID " + id + " doesn't exist");
        }
            for (Group group1: groups){
                if (group1.getGroupName().equalsIgnoreCase(group.getGroupName()) && !group1.getId().equals(id)){
                    throw new IllegalArgumentException("Like this group already exist");
                }
            }
       groupToUpdate.setGroupName(group.getGroupName());
            return groupToUpdate;
    }

    @Override
    public String deleteGroup(Long id) {
        for (Group group: groups){
            if (group.getId().equals(id)){
                groups.remove(group);
                return "Successfully deleted";
            }
        }
        return "Try again";
    }
}
