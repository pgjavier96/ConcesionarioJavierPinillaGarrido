package es.pinillagarrido.coches;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import es.pinillagarrido.coches.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "jdbc:mysql://146.59.237.189:3306/dam208_jpgconcesionario";
    private static final String USER ="dam208_jpg";
    private static final String PASSWORD = "dam208jpg";
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    public static ArrayList<Car> car = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();


        getCar();
    }


    public Connection dbConexion()  throws Exception  {
        Connection cnn=null;

            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("org.gjt.mm.mysql.Driver").newInstance();

            cnn = DriverManager.getConnection(URL,USER,PASSWORD);



        return cnn;

    }



    public void getCar(){
        try{
            Statement stm = dbConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM coches");


            while(rs.next()){

                Car cars = new Car();

                cars.setRef(Integer.parseInt(rs.getString(1)));
                cars.setCombustible(rs.getString(2));
                cars.setKm(Integer.parseInt(rs.getString(3)));
                cars.setCambio(rs.getString(4));
                cars.setPotencia(Integer.parseInt(rs.getString(5)));
                cars.setNpuertas(Integer.parseInt(rs.getString(6)));
                cars.setColor(rs.getString(7));
                cars.setAno(2011);
                cars.setTitulo(rs.getString(9));
                cars.setDescripcion(rs.getString(10));
                cars.setUrl(rs.getString(11));
                cars.setImagenes(rs.getString(12));
                cars.setPrecio(Integer.parseInt(rs.getString(13)));
                cars.setLocalizacion(rs.getString(14));

                car.add(cars);
                Log.v("adad",car.toString()+"huooñhuiñou");

            }

        }catch(Exception e){

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}