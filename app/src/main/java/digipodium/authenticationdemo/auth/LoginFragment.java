package digipodium.authenticationdemo.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import digipodium.authenticationdemo.R;
import digipodium.authenticationdemo.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentLoginBinding.bind(view);

        binding.btnCreateAcc .setOnClickListener(v1 ->{
            NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_registerFragment);
        });

        binding.btnForgot.setOnClickListener(v2->{
            NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_forgotPassFragment);
        });

        binding.btnLogin2.setOnClickListener(v3->{
            binding.progressBar.setVisibility(View.VISIBLE);
            String email = binding.editEmail.getText().toString();
            String password = binding.editPassword.getText().toString();
            Snackbar.make(v3,"still working", Snackbar.LENGTH_LONG).show();
        });


    }
}