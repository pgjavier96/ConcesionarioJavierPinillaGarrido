package es.pinillagarrido.coches.viewholder;



import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import es.pinillagarrido.coches.Car;
import es.pinillagarrido.coches.R;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private static ArrayList<Car> CarList;
    private Context context;
    private Object Car;

    public CarAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        /*view.setOnClickListener(v -> {
            Log.v("xyzyx", "onclick create ");
            Pokemon p = (Pokemon) view.getTag();
            Log.v("xyzyx", p.name);
        });*/
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        Car car = CarList.get(position);
        holder.car = car;
        holder.tvREF.setText(String.valueOf(car.getRef()));
        //holder.tvAño.setText(String.valueOf(car.getAno()));
        holder.tvName.setText(String.valueOf(car.getTitulo()));
        //holder.tvKm.setText(car.getKm());
        //holder.tvCv.setText(car.getPotencia());
        holder.tvCombustible.setText(car.getCombustible());
        holder.tvCambio.setText(car.getCambio());



        //Picasso.get().load(player.url).into(holder.ivPokemon);
        Glide.with(context).load(car.getImagenes()).into(holder.ivCar);
    }

    @Override
    public int getItemCount() {
        if (CarList == null) {
            return 0;
        }
        return CarList.size();


    }
    public void setCarList(ArrayList<Car> carList){
        this.CarList = carList;
    }

}