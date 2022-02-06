package es.pinillagarrido.coches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import es.pinillagarrido.coches.databinding.FragmentFirstBinding;
import es.pinillagarrido.coches.viewholder.CarAdapter;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CarAdapter carAdapter = new CarAdapter(getContext());
        binding.recyclerView.setAdapter(carAdapter);
        ArrayList<Car> listaCars = MainActivity.car;
        carAdapter.setCarList(listaCars);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}