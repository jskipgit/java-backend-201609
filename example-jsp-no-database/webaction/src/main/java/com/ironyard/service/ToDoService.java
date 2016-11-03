package com.ironyard.service;

import com.ironyard.data.ToDoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 9/15/16.
 */
public class ToDoService {

    public List<ToDoItem> getAllToDoItems(){
        List<ToDoItem> foundAll = new ArrayList<>();
        foundAll.add(new ToDoItem("Take dog for a walk.", "Dog name:Tilly", 1));
        foundAll.add(new ToDoItem("Wash dishes.","Use soap",2));
        foundAll.add(new ToDoItem("Play video game.","On the XBOX",3));
        foundAll.add(new ToDoItem("Do homework.", "Copy from friend",4));
        return foundAll;
    }

}
