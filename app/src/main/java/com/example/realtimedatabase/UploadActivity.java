package com.example.realtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UploadActivity extends AppCompatActivity {

    EditText editTextTitle, editTextDesc;
    Button saveButton;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        editTextTitle = findViewById(R.id.edit_text_name);
        editTextDesc = findViewById(R.id.edit_text_desc);

        saveButton = findViewById(R.id.save_button);

        databaseReference = FirebaseDatabase.getInstance().getReference("Articles");
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String desc = editTextDesc.getText().toString();

                if(title.isEmpty()) editTextTitle.setError("sdjfb");
                if(desc.isEmpty()) editTextDesc.setError("fdggfh");

                uploadData(title, desc);

            }
        });
    }

    /**
     *
     * -Articles
     *  -- key (unique)
     *      -- title .....
     *      -- desc
     */
    private void uploadData(String title, String desc) {
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("title", title);
        hashMap.put("desc", desc);

        String key = databaseReference.push().getKey();

        databaseReference.child(key).setValue(hashMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UploadActivity.this, "Data uploaded", Toast.LENGTH_SHORT).show();
                            editTextDesc.getText().clear();
                            editTextTitle.getText().clear();
                        }
                    }
                });


    }
}