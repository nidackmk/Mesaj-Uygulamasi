package com.example.smsuygulama5.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smsuygulama5.Adapter.GrupSecAdapter;
import com.example.smsuygulama5.Adapter.KisilerAdapter;
import com.example.smsuygulama5.Adapter.MesajSecHomeAdapter;
import com.example.smsuygulama5.Modals.GrupSecModals;
import com.example.smsuygulama5.Modals.KisilerModals;
import com.example.smsuygulama5.Modals.MesajSecHomeModals;
import com.example.smsuygulama5.R;
import com.example.smsuygulama5.databinding.FragmentHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    ArrayList<GrupSecModals> grupSec;
    ArrayList<KisilerModals> kisiSec;
    GrupSecAdapter grupSecAdapter;
    KisilerAdapter kisiSecAdapter;
    RecyclerView grupSecRv;
    RecyclerView kisiSecRv;


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_gruba_uye_ekle, container, false);
        grupSecRv= root.findViewById(R.id.grup_sec);
        kisiSecRv=root.findViewById(R.id.kisi_sec);
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.HORIZONTAL);
        llm.setReverseLayout(false);
        grupSecRv.setLayoutManager(llm);

        grupSec = new ArrayList<>();
        grupSecAdapter= new GrupSecAdapter(grupSec, getActivity());
        grupSecRv.setAdapter(grupSecAdapter);

        kisiSecRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        kisiSec=new ArrayList<>();
        kisiSecAdapter=new KisilerAdapter(kisiSec, getActivity());
        kisiSecRv.setAdapter(kisiSecAdapter);

        getCloudData();
        getCloudKisiData();

        return root;
    }


    private void getCloudData() {
        db.collection("mesajgonder_grupsec")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isComplete()){
                            for (QueryDocumentSnapshot doc: task.getResult()){
                                GrupSecModals gsm= doc.toObject(GrupSecModals.class);
                                grupSec.add(gsm);
                                grupSecAdapter.notifyDataSetChanged();
                            }
                        }

                    }
                });
    }

    private void getCloudKisiData() {
        db.collection("Kisiler")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isComplete()){
                            for (QueryDocumentSnapshot doc: task.getResult()){
                                KisilerModals gsm= doc.toObject(KisilerModals.class);
                                kisiSec.add(gsm);
                                kisiSecAdapter.notifyDataSetChanged();
                            }
                        }

                    }
                });
    }
}