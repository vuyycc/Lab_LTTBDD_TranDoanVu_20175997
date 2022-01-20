package vn.hust.edu.appram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link activity_item#newInstance} factory method to
 * create an instance of this fragment.
 */
public class activity_item extends Fragment {
    TextView textView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "param";

    // TODO: Rename and change types of parameters
    private String ramParam;

    public activity_item() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment activity_item.
     */
    // TODO: Rename and change types and number of parameters
    public static activity_item newInstance(String param) {
        activity_item fragment = new activity_item();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ramParam = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity_item, container, false);

        textView = view.findViewById(R.id.text_view);

        try {
            String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
            FileInputStream fis = new FileInputStream(ramParam);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null)
                builder.append(line + "\n");
            reader.close();
            textView.setText(builder.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return view;
    }
}