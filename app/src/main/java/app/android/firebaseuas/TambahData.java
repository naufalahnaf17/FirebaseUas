package app.android.firebaseuas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahData extends AppCompatActivity {

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        databaseReference = FirebaseDatabase.getInstance().getReference("Note");

        final EditText eJudul = (EditText)findViewById(R.id.eJudul);
        final EditText eDesc = (EditText)findViewById(R.id.eDesc);
        Button buttonAdd = (Button)findViewById(R.id.btnAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String judul = eJudul.getText().toString().trim();
                String desc = eDesc.getText().toString().trim();

                String idnote = databaseReference.push().getKey();
                Catatan catatan = new Catatan(idnote , judul , desc );
                databaseReference.child(idnote).setValue(catatan);

                Toast.makeText(TambahData.this, "Berhasil Add Data", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }
}
