package digipodium.authenticationdemo.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import digipodium.authenticationdemo.FirstFragment;
import digipodium.authenticationdemo.R;
import digipodium.authenticationdemo.databinding.FragmentAuthChoiceBinding;


public class AuthChoiceFragment extends Fragment {

    FragmentAuthChoiceBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auth_choice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentAuthChoiceBinding.bind(view);

        binding.btnLogin.setOnClickListener(v1 -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_authChoiceFragment_to_loginFragment);
        });
        binding.btnRegister.setOnClickListener(v2 -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_authChoiceFragment_to_registerFragment);
        });
    }
}