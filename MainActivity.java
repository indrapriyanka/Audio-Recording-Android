package com.example.audiorectest;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	MediaRecorder mRecord;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity); 
		
		
		
		mRecord=new MediaRecorder();
		
		
		
		Button btnStart=(Button)findViewById(R.id.btnStart);
		Button btnStop=(Button)findViewById(R.id.btnStop);
		
		
		btnStart.setOnClickListener(new OnClickListener()
		{	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				mRecord.setAudioSource(MediaRecorder.AudioSource.MIC); 
				mRecord.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB); 
				mRecord.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				
				mRecord.setOutputFile("/storage/sdcard0/"+System.currentTimeMillis()+".mp3");
				try {
					mRecord.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mRecord.start();
			}
		});
        
        
        btnStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 mRecord.stop();	
			}
		});
		
		
	}
}