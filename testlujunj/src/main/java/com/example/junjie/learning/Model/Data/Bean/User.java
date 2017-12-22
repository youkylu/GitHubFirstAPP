package com.example.junjie.learning.Model.Data.Bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.example.junjie.learning.BR;

/**
 * <p>Class: com.example.junjie.learning.Model.Data.Bean.User</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author lujunjie
 * @date 2017/12/21/16:53
 */


public class User extends BaseObservable {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> age = new ObservableField<>();
    public ObservableField<String> sex = new ObservableField<>();

    public User(String pName, String pAge, String pSex){
        name.set(pName);
        age.set(pAge);
        sex.set(pSex);
    }

    @Bindable
    public String getName(){
        return name.get();
    }

    public void setName(String name){
        this.name.set(name);
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public  String getAge(){
        return age.get();
    }

    public void setAge(String age){
        this.name.set(age);
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getSex(){
        return sex.get();
    }

    public void setSex(String sex){
        this.sex.set(sex);
        notifyPropertyChanged(BR.sex);
    }

}
