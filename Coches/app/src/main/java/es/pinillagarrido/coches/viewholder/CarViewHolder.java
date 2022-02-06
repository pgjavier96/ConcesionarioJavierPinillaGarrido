package es.pinillagarrido.coches.viewholder;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import es.pinillagarrido.coches.Car;
import es.pinillagarrido.coches.R;


public class CarViewHolder extends RecyclerView.ViewHolder {

    public TextView tvName, tvAño, tvKm, tvCv , tvCombustible, tvCambio, tvREF ;
    public ImageView ivCar;
    public Car car;
    public Bundle bundle;
    public CarViewHolder(@NonNull View itemView) {
        super(itemView);
        tvREF = itemView.findViewById(R.id.tvREF);
        tvCombustible = itemView.findViewById(R.id.tvCombustible);
        tvKm  = itemView.findViewById(R.id.tvKm);
        tvCambio = itemView.findViewById(R.id.tvCambio);
        tvCv = itemView.findViewById(R.id.tvCV);
        tvAño = itemView.findViewById(R.id.tvAno);
        tvName= itemView.findViewById(R.id.tvName);
        ivCar = itemView.findViewById(R.id.ivCar);

        itemView.setOnClickListener(v -> {
            Log.v("xyzyx", "onclick" + car.getTitulo());
            bundle = new Bundle();
            bundle.putParcelable("car", (Parcelable) car);
            Navigation.findNavController(itemView).navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);


        });
    }
}