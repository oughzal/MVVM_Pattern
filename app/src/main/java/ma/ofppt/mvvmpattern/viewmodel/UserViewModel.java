package ma.ofppt.mvvmpattern.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ma.ofppt.mvvmpattern.model.User;

public class UserViewModel {
    // CRUD
    public MutableLiveData<List<User>> mutableUserList = new MutableLiveData<>();
    private List<User> userList = new ArrayList<>();


    public List<User> getUsers() {
        return this.userList;

    }

    public void add(User user) {
        userList.add(user);
        mutableUserList.setValue(userList);
        }

    public void add(String nom, String prenom) {
        userList.add(new User(nom, prenom));
        mutableUserList.setValue(userList);
    }

    public void update(User user, int position) {
        userList.set(position, user);
    }
}
