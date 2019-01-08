package com.example.consocio.bibliospaz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.consocio.bibliospaz.Adapter.RecycleAdapter;
import com.example.consocio.bibliospaz.Models.Login;
import com.example.consocio.bibliospaz.Models.Responso;
import com.google.gson.Gson;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<BookItem> bookArr = new ArrayList<>();
    private static final BibliospazApi bibliospazApi = new ApiService().init();
    private String token;
    private String method = "application/json";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BookFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookFragment newInstance(String param1, String param2) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book, container, false);
        getActivity().setTitle("Elenco Libri");
        recyclerView = v.findViewById(R.id.recycler_books);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        getBooks();
        bookArr.clear();
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));
        bookArr.add(new BookItem("jfjfd","fbcfdb","fbbgdbdb","xbfxfbx"));

        mAdapter = new RecycleAdapter(getContext(),bookArr);
        recyclerView.setAdapter(mAdapter);



        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void getBooks(){
        Log.d("prova", "in getbooks");
        token = "Bearer ";
        token += Prefs.getString("token", null);

        Log.d("prova",token);
        Call<ResponseBody> call = bibliospazApi.getBookResponse(token,method);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Codice errore:" + response.code(), Toast.LENGTH_SHORT).show();
                }
                Log.d("prova", "response " + new Gson().toJson(response.body()) + " code " + response.code());

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
