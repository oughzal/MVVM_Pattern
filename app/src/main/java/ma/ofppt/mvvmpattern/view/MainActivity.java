package ma.ofppt.mvvmpattern.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import ma.ofppt.mvvmpattern.R;
import ma.ofppt.mvvmpattern.model.User;
import ma.ofppt.mvvmpattern.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel = new UserViewModel();
    Button btnAdd;
    EditText txtNom,txtPrenom;
    TextView txtUserList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPrenom = findViewById(R.id.txtPrenom);
        txtNom = findViewById(R.id.txtNom);
        btnAdd = findViewById(R.id.btnAdd);
        txtUserList = findViewById(R.id.txtUserList);
        // observe les changement depuis ViewModel
        userViewModel.mutableUserList.observe(this, new Observer<List<User>>() {  //exécuté chaque fois que les données change
            @Override
            public void onChanged(List<User> users) {
                showUsers(users);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userViewModel.add(txtNom.getText().toString(),txtPrenom.getText().toString());
                //showUsers(userViewModel.getUsers());
            }
        });
    }
    private void showUsers(List<User> users){
        String out="";
        for(User user : users){
            out += user + "\n";
        }
        txtUserList.setText(out);
    }
}