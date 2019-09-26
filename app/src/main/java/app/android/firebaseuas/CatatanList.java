package app.android.firebaseuas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CatatanList extends ArrayAdapter<Catatan> {
    private Activity context;
    private List<Catatan>listCatatan;

    public CatatanList(Activity context , List<Catatan> listKelas){
        super(context,R.layout.list_data_kelas,listKelas);
        this.context = context;
        this.listCatatan = listKelas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewKelas = inflater.inflate(R.layout.list_data_kelas,null);

        TextView txtNamaKelas = (TextView) listViewKelas.findViewById(R.id.txtNamaKelas);
        TextView txtTingkatanKelas = (TextView) listViewKelas.findViewById(R.id.txtNamaTingkatan);

        Catatan catatan = listCatatan.get(position);
        txtNamaKelas.setText(catatan.getJudul());
        txtTingkatanKelas.setText(catatan.getDesc());

        return  listViewKelas;
    }
}
