package vn.hust.edu.appram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link activity_list#newInstance} factory method to
 * create an instance of this fragment.
 */
public class activity_list extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    ArrayList<String> list_data = new ArrayList<>();
    ArrayList<String> list_display = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private static final String ARG_PARAM = "param";
    private String mParam;

    public activity_list() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment activity_list.
     */
    // TODO: Rename and change types and number of parameters
    public static activity_list newInstance(String param) {
        activity_list fragment = new activity_list();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity_list, container, false);

        ListView listView = view.findViewById(R.id.list_view);


        list_data.clear();
        File folderFile = new File(mParam);
        File[] files = folderFile.listFiles();
        for (File f : files) {
            Log.v("TAG", f.getAbsolutePath());
            list_data.add(f.getAbsolutePath());

            String folder = f.getAbsolutePath();
            int pos = folder.length() - 1;
            while (folder.charAt(pos) != '/') pos--;
            folder = folder.substring(pos + 1);
            list_display.add(folder);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list_display);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((OnClickListener)getActivity()).updateData(list_data.get(i));
            }
        });
        return view;
    }
}