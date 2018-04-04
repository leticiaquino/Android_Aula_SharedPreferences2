package br.com.fiap.persistncia2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText senha;
    CheckBox manterConectado;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        senha = findViewById(R.id.senha);
        manterConectado = findViewById(R.id.manterConectado);

        sp = getPreferences(MODE_PRIVATE);

        String nm = sp.getString("nome", "");
        String snh = sp.getString("senha", "");
        Boolean manter = sp.getBoolean("manter", false);

        nome.setText(nm);
        senha.setText(snh);
        manterConectado.setChecked(manter);

    }

    public void salvar(View view) {
        SharedPreferences.Editor e = sp.edit();

        if(manterConectado.isChecked()){

            String nm = nome.getText().toString();
            String snh = senha.getText().toString();

            e.putString("nome", nm);
            e.putString("senha", snh);
            e.putBoolean("manter", true);

            e.commit();
        }else {
            e.remove("nome");
            e.remove("senha");
            e.remove("manter");

            e.commit();
        }
        Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
