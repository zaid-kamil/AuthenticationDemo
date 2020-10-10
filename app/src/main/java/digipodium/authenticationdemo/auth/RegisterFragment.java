package digipodium.authenticationdemo.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import digipodium.authenticationdemo.R;
import digipodium.authenticationdemo.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {

    private digipodium.authenticationdemo.databinding.FragmentRegisterBinding binding;
    private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentRegisterBinding.bind(view);

        // FirebaseAuth object
        auth = FirebaseAuth.getInstance();

        binding.btnRegister.setOnClickListener(v1 -> {
            String email = binding.editEmail.getText().toString();
            String password = binding.editPassword.getText().toString();
            String cpassword = binding.editCPassword.getText().toString();
            if (email.length() >= 11 && email.contains("@")) {
                if (password.equals(cpassword)) {
                    binding.pb.setVisibility(View.VISIBLE);
                    auth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(task -> {
                                if(task.isSuccessful()){
                                    updateUI(task.getResult());
                                }else{
                                    String error = task.getException().getMessage();
                                    // todo display error
                                }
                            });
                }else{
                    // todo password match failed

                }
            }else{
                // todo email is invalid

            }

        });


    }

    private void updateUI(AuthResult result) {
        binding.pb.setVisibility(View.GONE);
        NavHostFragment.findNavController(this)
                .navigate(R.id.action_registerFragment_to_loginFragment);
    }
}