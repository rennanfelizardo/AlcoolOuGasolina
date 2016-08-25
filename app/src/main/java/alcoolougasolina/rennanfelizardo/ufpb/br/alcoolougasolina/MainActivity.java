package alcoolougasolina.rennanfelizardo.ufpb.br.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText gasolinaPreco;
    private EditText alcoolPreco;
    private Button botaoVerificar;
    private TextView resultadoTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolinaPreco = (EditText) findViewById(R.id.gasolinaPrecoId);
        alcoolPreco = (EditText) findViewById(R.id.alcoolPrecoId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        resultadoTexto = (TextView) findViewById(R.id.resultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoAlcoolPreco = alcoolPreco.getText().toString();
                String textoGasolinaPreco = gasolinaPreco.getText().toString();
                View focus = null;

                if (textoAlcoolPreco.isEmpty()){
                    alcoolPreco.setError("Digite o preço");
                    focus = alcoolPreco;
                }
                if (textoGasolinaPreco.isEmpty()){
                    gasolinaPreco.setError("Digite o preço");
                    focus = gasolinaPreco;
                }

                if (focus != null){
                    focus.requestFocus();
                }else{
                    Double valorAlcool = Double.parseDouble(textoAlcoolPreco);
                    Double valorGasolina = Double.parseDouble(textoGasolinaPreco);
                    Double resultado = valorAlcool / valorGasolina;

                    if (resultado >= 0.7){
                        resultadoTexto.setText("É melhor utilizar gasolina");
                    }else{
                        resultadoTexto.setText("É melhor utilizar álcool");
                    }

                }


            }
        });
    }
}
