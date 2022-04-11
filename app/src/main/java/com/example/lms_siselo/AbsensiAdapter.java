package com.example.lms_siselo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AbsensiAdapter extends RecyclerView.Adapter<AbsensiAdapter.AbsenAdapterVH> {

    private List<AbsensiResponse> absenResponseList;
    private Context context;
    private AbsensiAdapter.ClickedItem clickedItem;

    public AbsensiAdapter(AbsensiAdapter.ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    public void setData(List<AbsensiResponse> absenResponseList) {
        this.absenResponseList = absenResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AbsensiAdapter.AbsenAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new AbsensiAdapter.AbsenAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_absensi,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AbsensiAdapter.AbsenAdapterVH holder, int position) {

        AbsensiResponse absenResponse = absenResponseList.get(position);

        //Post Absensi Siswa
        SiseloService serviceAPI=ApiClient.getMapelService();
        String absen_id = absenResponse.getId_absen();

        String matpel  = absenResponse.getNama_matpel();
        String kelas  = absenResponse.getNama_kelas();

            holder.nama_matpel.setText(matpel);
            holder.nama_kelas.setText(kelas);
            holder.imageMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickedItem.ClickedAbsen(absenResponse);
                }
            });
            holder.absen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickedItem.ClickedAbsen(absenResponse);
                }
            });
    }

    public interface ClickedItem{
        public void ClickedAbsen(AbsensiResponse absenResponse);
    }

    @Override
    public int getItemCount() {
        return absenResponseList.size();
    }

    public class AbsenAdapterVH extends RecyclerView.ViewHolder {

        TextView nama_matpel;
        TextView nama_kelas;
        TextView absen;
        ImageView prefix;
        ImageView imageMore;

        public AbsenAdapterVH(@NonNull View itemView) {
            super(itemView);
            nama_matpel = itemView.findViewById(R.id.nama_matpel);
            nama_kelas = itemView.findViewById(R.id.nama_kelas);
            prefix = itemView.findViewById(R.id.prefix);
            absen = itemView.findViewById(R.id.selengkapnya);
            imageMore = itemView.findViewById(R.id.imageMore);
        }
    }
}