package jp.os.kz.android.FlashLight;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.hardware.Camera;;

public class FlashLightActivity extends Activity {
    /** Called when the activity is first created. */
	
	private Camera camera=Camera.open(); 
	private Button button1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		button1 = (Button)findViewById(R.id.button1);
		button1.setText(R.string.button_on);
		button1.setOnClickListener(new OnClickListener(){  
            @Override  
            public void onClick(View v) {
            	button1_onClick();
            }

			private void button1_onClick() {
				// TODO Auto-generated method stub

		        Camera.Parameters params= camera.getParameters();
				
				if(button1.getText()==getString(R.string.button_on)){
			        //params.setFlashMode("on");
			        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);			
					button1.setText(R.string.button_off);
				}else{
					params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
					button1.setText(R.string.button_on);
				}
		        camera.setParameters(params);
		        camera.startPreview();       	
			}  
        });  
            
    }
    
    @Override
    public void onStop(){
    	super.onStop();
    	camera.release();
    	}
    
    @Override
    public void onPause(){
    	super.onPause();
    	//finish();
    	}
    
    
}