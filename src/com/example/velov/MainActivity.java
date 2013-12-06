package com.example.velov;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends Activity {
	
	private EditText depart = null;
	private EditText arrivee = null;
	private TextView prixTag = null;
	private boolean age = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		depart = (EditText) findViewById(R.id.editText1);
		arrivee = (EditText) findViewById(R.id.arrivee);
		prixTag = (TextView) findViewById(R.id.prix);
		final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
		final Context context = this;
		
		
		final Button button = (Button) findViewById(R.id.button1);
        
		button.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	if(!depart.getText().toString().matches("") && !arrivee.getText().toString().matches("")) {
	        		if(isInteger(depart.getText().toString()) && isInteger(arrivee.getText().toString())) {	
	        			Velo utilisateur = new Velo(depart.getText().toString(), arrivee.getText().toString(), checkBox.isChecked());
	        			prixTag.setText(utilisateur.calculatePrice());
	        		}
	        		else {
	        			new AlertDialog.Builder(context).setTitle("ERREUR").setMessage("Merci de renseigner des nombres valides").setNeutralButton("Fermer", null).show();
	        		}
	        	}
	        	else {
	        		new AlertDialog.Builder(context).setTitle("ERREUR").setMessage("Merci de renseigner une heure de départ et d'arrivée").setNeutralButton("Fermer", null).show();
	        	}
	        }
	    });
	
	}
	
	
		//ACTIVATION PAR LA TOUCHE ENTER
		
		/*TextWatcher inputTextWatcher = new TextWatcher() {
		    public void afterTextChanged(Editable s) { 
		    	arrivee.setOnKeyListener(new View.OnKeyListener() {
				      @Override
				      public boolean onKey(View v, int keyCode, KeyEvent event) {
				        if(event.getAction() == 0)
				          if(keyCode == 66) {
				        	  if (checkBox.isChecked()) {
				        		  age = true;
				        	  }
				        	// INSTANCIATION OBJET
				        	//calculatePrice(depart.getText().toString(), arrivee.getText().toString());
				        	  Velo utilisateur = new Velo(depart.getText().toString(), arrivee.getText().toString(), age);
				        	  prixTag.setText(utilisateur.calculatePrice());
				        	  return true;
				          }
						return false;
				      }
				    });
		        }

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				
			}

		
		};

		arrivee.addTextChangedListener(inputTextWatcher);
	}*/
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId()) {
	    case R.id.index:
	        Intent intent = new Intent(this, MainActivity.class);
	        this.startActivity(intent);
	        break;
	    case R.id.about:
	        Intent intent2 = new Intent(this, AboutActivity.class);
	        this.startActivity(intent2);
	        overridePendingTransition(R.anim.rotate_out,R.anim.rotate_in);
	        break;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	    return true;
	}
	
	

}
