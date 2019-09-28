package com.tanvir.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DataService {

    private ArrayList<DataModel> list = new ArrayList<DataModel>(Arrays.asList(
            new DataModel(1,"name1", "job1"),
            new DataModel(2,"name2", "job2"),
            new DataModel(3, "name3", "job3")
    ));
    public ArrayList<DataModel> getAll(){
        return list;
    }
    public DataModel getOne(int id){
        return list.stream()
                .filter((dataModel) -> dataModel.getId() == id)
                .findFirst()
                .get();
    }
    public String getName(int id){
        return list.stream()
                .filter((dataModel -> dataModel.getId() == id))
                .findFirst()
                .get()
                .getName();
    }

    public String getJobDescription(int id){
        return list.stream()
                .filter((dataModel -> dataModel.getId() == id))
                .findFirst()
                .get()
                .getJobDescription();
    }
    public void updateOne(DataModel model){
        DataModel data = list.stream()
                .filter((dataModel -> dataModel.getId() == model.getId()))
                .findFirst()
                .get();
        data.setName(model.getName());
        data.setJobDescription(model.getJobDescription());
    }

    public void addOne(DataModel model){
        list.add(model);
    }

    public void updateName(int id, String name){
        DataModel data = list.stream()
                .filter((dataModel -> dataModel.getId() == id))
                .findFirst()
                .get();
        data.setName(name);
    }

    public void updateJobDescription(int id, String jobDescription){
        DataModel data = list.stream()
                .filter((dataModel -> dataModel.getId() == id))
                .findFirst()
                .get();
        data.setJobDescription(jobDescription);
    }
    public void deleteOne(DataModel model){
        list.removeIf(dataModel -> dataModel.getId() == model.getId());
    }
    public void deleteById(int id){
        list.removeIf(dataModel -> dataModel.getId() == id);
    }
}
