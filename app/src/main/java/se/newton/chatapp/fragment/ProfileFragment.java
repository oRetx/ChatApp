package se.newton.chatapp.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import se.newton.chatapp.R;
import se.newton.chatapp.service.Database;
import se.newton.chatapp.viewmodel.ProfileViewModel;
import se.newton.chatapp.databinding.ProfileFragmentBinding;

/**
 * Created by fr9b on 2018-02-21.
 */

public class ProfileFragment extends Fragment {

    private String fUserUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private ProfileViewModel viewModel= new ProfileViewModel(fUserUid);
    private static final String TAG = "ProfileFragment";

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        Log.d(TAG, "Creating profile fragment");
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ProfileFragmentBinding binding = DataBindingUtil.inflate(inflater,R.layout.profile_fragment, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

}