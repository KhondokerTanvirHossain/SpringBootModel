package com.tanvir.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DataService {

//    private ArrayList<DataModel> list = new ArrayList<DataModel>(Arrays.asList(
//            new DataModel(1,"name1", "job1"),
//            new DataModel(2,"name2", "job2"),
//            new DataModel(3, "name3", "job3")
//    ));

    @Autowired
    private DataRepository dataRepository;

    public ArrayList<DataModel> getAll(){
        ArrayList<DataModel> dataModels = new ArrayList<DataModel>();
        dataRepository.findAll().forEach(dataModels::add);
        return dataModels;
    }
    public DataModel getOne(int id){
        return dataRepository.
                findById(id).
                get();
//        return list.stream()
//                .filter((dataModel) -> dataModel.getId() == id)
//                .findFirst()
//                .get();
    }
    public String getName(int id){
        return dataRepository
                .findById(id)
                .get()
                .getName();
//        return list.stream()
//                .filter((dataModel -> dataModel.getId() == id))
//                .findFirst()
//                .get()
//                .getName();
    }

    public String getJobDescription(int id){
        return dataRepository
                .findById(id)
                .get()
                .getJobDescription();
//        return list.stream()
//                .filter((dataModel -> dataModel.getId() == id))
//                .findFirst()
//                .get()
//                .getJobDescription();
    }

    public void addOne(DataModel model){
        dataRepository.save(model);
//        list.add(model);
    }

    public void updateOne(DataModel model){
        dataRepository.save(model);
//        DataModel data = list.stream()
//                .filter((dataModel -> dataModel.getId() == model.getId()))
//                .findFirst()
//                .get();
//        data.setName(model.getName());
//        data.setJobDescription(model.getJobDescription());
    }

    public void updateName(int id, String name){
        DataModel model = dataRepository.findById(id).get();
        dataRepository.save(new DataModel(id, name, model.getJobDescription()));
//        DataModel data = list.stream()
//                .filter((dataModel -> dataModel.getId() == id))
//                .findFirst()
//                .get();
//        data.setName(name);
    }

    public void updateJobDescription(int id, String jobDescription){
        DataModel model = dataRepository.findById(id).get();
        dataRepository.save(new DataModel(id, model.getName(), jobDescription));
//        DataModel data = list.stream()
//                .filter((dataModel -> dataModel.getId() == id))
//                .findFirst()
//                .get();
//        data.setJobDescription(jobDescription);
    }
    public void deleteOne(DataModel model){
        dataRepository.delete(model);
//        list.removeIf(dataModel -> dataModel.getId() == model.getId());
    }
    public void deleteById(int id){
        dataRepository.delete(dataRepository.findById(id).get());
//        list.removeIf(dataModel -> dataModel.getId() == id);
    }
}
