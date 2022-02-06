package es.pinillagarrido.coches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import es.pinillagarrido.coches.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    private Car car;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getCar();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getCar() {
        Bundle bundle = new Bundle();
        bundle = getArguments();
        car = bundle.getParcelable("car");
        binding.tvRef.getText().toString().trim();
        binding.tvCombustible.getText().toString().trim();
        binding.tvKm.getText().toString().trim();
        binding.tvCombio.getText().toString().trim();
        binding.tvPotencia.getText().toString().trim();
        binding.tvPuertas.getText().toString().trim();
        binding.tvColor.getText().toString().trim();
        binding.tvAno.getText().toString().trim();
        binding.tvDescripcion.getText().toString().trim();
        binding.imageView.getDrawable().toString().trim();
        binding.tvPrecio.getText().toString().trim();
        binding.tvLocalizacion.getText().toString().trim();
        Glide.with(this).load(car.getImagenes()).into(binding.imageView);



    }

}