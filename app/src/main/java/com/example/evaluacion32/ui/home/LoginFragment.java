package com.example.evaluacion32.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.evaluacion32.MainActivity;
import com.example.evaluacion32.R;
import com.example.evaluacion32.SharedPreferencesHelper;

public class LoginFragment extends Fragment {

    private EditText emailLogin;
    private EditText passwordLogin;
    private Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        emailLogin = view.findViewById(R.id.email_login);
        passwordLogin = view.findViewById(R.id.password_login);
        loginButton = view.findViewById(R.id.login_btn);

        loginButton.setOnClickListener(v -> {
            String email = emailLogin.getText().toString().trim();
            String password = passwordLogin.getText().toString().trim();

            if (authenticate(email, password)) {
                SharedPreferencesHelper.setAdminLoggedIn(getActivity(), true);

                // Notificar a la actividad principal para que actualice el menú
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).updateMenu();
                }

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_administrador);
            } else {
                Toast.makeText(getActivity(), "Credenciales inválidas", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private boolean authenticate(String email, String password) {
        return "admin@gmail.com".equals(email) && "admin123".equals(password);
    }
}

