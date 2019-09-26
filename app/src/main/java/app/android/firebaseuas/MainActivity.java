package app.android.firebaseuas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //inisialisasi awal untuk item yang ada di xml
    DatabaseReference databaseReference;
    private FloatingActionButton fab;
    List<Catatan> listCatatan;
    ListView listViewKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi ulang untuk item yang ada di xml
        fab = (FloatingActionButton) findViewById(R.id.addBtn);
        databaseReference = FirebaseDatabase.getInstance().getReference("Note");
        listCatatan = new ArrayList<>();
        listViewKelas = (ListView)findViewById(R.id.listDataKelas);

        //membuat floating action button bekerja saat di pencet
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TambahData.class));
            }
        });


    }


    //overide method onStart sangat penting agar saat data ada perubahan langsung listview bertambah
    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listCatatan.clear();

                for (DataSnapshot CatatanSnapShot : dataSnapshot.getChildren()){
                    Catatan catatan = CatatanSnapShot.getValue(Catatan.class);
                    listCatatan.add(catatan);
                }

                CatatanList Adapter = new CatatanList(MainActivity.this,listCatatan);
                listViewKelas.setAdapter(Adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

