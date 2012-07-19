package com.mindpin_translate_animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView imageview_test_icon;
	
	private ImageView imageview_add_icon ; 
	
	private ImageView imageview_camera_icon ;
	private ImageView imageview_people_icon ;
	private ImageView imageview_place_icon ;
	private ImageView imageview_music_icon ;
	private ImageView imageview_thought_icon ;
	private ImageView imageview_sleep_icon ;
	
	
	
	Animation rotate_Animation = null;
	Animation add_from_rotate_Animation = null;
	Animation add_to_rotate_Animation = null;
	
	AnimationSet camera_from_Animation_set = new AnimationSet(false);
	
	Animation camera_from_Animation=null;
	Animation people_from_Animation=null;
	Animation place_from_Animation=null;
	Animation music_from_Animation=null;
	Animation thought_from_Animation=null;
	Animation sleep_from_Animation=null;
	
	Animation camera_to_Animation=null;
	Animation people_to_Animation=null;
	Animation place_to_Animation=null;
	Animation music_to_Animation=null;
	Animation thought_to_Animation=null;
	Animation sleep_to_Animation=null;
	
	boolean isFrom = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        load_ui();
        add_from_rotate_Animation = AnimationUtils.loadAnimation(this, R.anim.add_rotate_from);
        add_from_rotate_Animation.setFillAfter(true);
        add_to_rotate_Animation = AnimationUtils.loadAnimation(this, R.anim.add_rotate_to);
        add_to_rotate_Animation.setFillAfter(true);
        
        rotate_Animation = new RotateAnimation(360.0f, 0.0f,  
        	    Animation.RELATIVE_TO_SELF, 0.5f,    
        	    Animation.RELATIVE_TO_SELF, 0.5f); 
        rotate_Animation.setDuration(2000);
        rotate_Animation.setFillAfter(true);
        
        load_from_animation();  
        load_to_animation();
        load_from_animation_set();
        imageview_add_icon.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if(isFrom){
					start_animation_from();	
					imageview_add_icon.startAnimation(add_from_rotate_Animation);
				}else{
					start_animation_to();	
					imageview_add_icon.startAnimation(add_to_rotate_Animation);
				}
				isFrom = !isFrom;
				
			}
		});     
    }
    
	

	private void load_from_animation_set() {
		camera_from_Animation_set.addAnimation(rotate_Animation);
		camera_from_Animation_set.addAnimation(camera_from_Animation);
		camera_from_Animation_set.setFillAfter(true);
	}



	private void load_ui() {
		imageview_test_icon = (ImageView)findViewById(R.id.imageview_test_icon);
		
    	imageview_add_icon = (ImageView)findViewById(R.id.imageview_add_icon);
    	
        imageview_camera_icon = (ImageView)findViewById(R.id.imageview_camera_icon);
        imageview_people_icon = (ImageView)findViewById(R.id.imageview_people_icon);
        imageview_place_icon = (ImageView)findViewById(R.id.imageview_place_icon);
        imageview_music_icon = (ImageView)findViewById(R.id.imageview_music_icon);
        imageview_thought_icon = (ImageView)findViewById(R.id.imageview_thought_icon);
        imageview_sleep_icon = (ImageView)findViewById(R.id.imageview_sleep_icon);
    
	}
	private void load_from_animation() {

		camera_from_Animation = AnimationUtils.loadAnimation(this, R.anim.camera_from);
		camera_from_Animation.setFillAfter(true);
		camera_from_Animation.setStartOffset(10);
		
		people_from_Animation = AnimationUtils.loadAnimation(this, R.anim.people_from);
		people_from_Animation.setFillAfter(true);
		people_from_Animation.setStartOffset(20);
		
		place_from_Animation = AnimationUtils.loadAnimation(this, R.anim.place_from);
		place_from_Animation.setFillAfter(true);
		place_from_Animation.setStartOffset(30);
		
		music_from_Animation = AnimationUtils.loadAnimation(this, R.anim.music_from);
		music_from_Animation.setFillAfter(true);
		music_from_Animation.setStartOffset(40);
		
		thought_from_Animation = AnimationUtils.loadAnimation(this, R.anim.thought_from);
		thought_from_Animation.setFillAfter(true);
		thought_from_Animation.setStartOffset(50);
		
		sleep_from_Animation = AnimationUtils.loadAnimation(this, R.anim.sleep_from);
		sleep_from_Animation.setFillAfter(true);
		sleep_from_Animation.setStartOffset(60);
	}
	private void load_to_animation() {
		camera_to_Animation = AnimationUtils.loadAnimation(this, R.anim.camera_to);
		camera_to_Animation.setFillAfter(true);
		camera_to_Animation.setStartOffset(60);
		
		people_to_Animation = AnimationUtils.loadAnimation(this, R.anim.people_to);
		people_to_Animation.setFillAfter(true);
		people_to_Animation.setStartOffset(50);
		
		place_to_Animation = AnimationUtils.loadAnimation(this, R.anim.place_to);
		place_to_Animation.setFillAfter(true);
		place_to_Animation.setStartOffset(40);
		
		music_to_Animation = AnimationUtils.loadAnimation(this, R.anim.music_to);
		music_to_Animation.setFillAfter(true);
		music_to_Animation.setStartOffset(30);
		
		thought_to_Animation = AnimationUtils.loadAnimation(this, R.anim.thought_to);
		thought_to_Animation.setFillAfter(true);
		thought_to_Animation.setStartOffset(20);
		
		sleep_to_Animation = AnimationUtils.loadAnimation(this, R.anim.sleep_to);
		sleep_to_Animation.setFillAfter(true);
		sleep_to_Animation.setStartOffset(10);
	}
	
	
	
	private void start_animation_from() {
		
		AnimationSet set = new AnimationSet(false);
		set.addAnimation(rotate_Animation);
		set.addAnimation(sleep_from_Animation);
		
		set.setFillAfter(true);
		imageview_test_icon.setAnimation(set);
		set.startNow();
//		imageview_test_icon.startAnimation(rotate_Animation);
		
		
		imageview_camera_icon.startAnimation(camera_from_Animation);	
//		imageview_camera_icon.setAnimation(camera_from_Animation_set);
//		camera_from_Animation_set.setFillAfter(true);
//		camera_from_Animation_set.startNow();		
//		
		imageview_people_icon.startAnimation(people_from_Animation);
		imageview_place_icon.startAnimation(place_from_Animation);
		imageview_music_icon.startAnimation(music_from_Animation);
		imageview_thought_icon.startAnimation(thought_from_Animation);
		imageview_sleep_icon.startAnimation(sleep_from_Animation);
	}
	private void start_animation_to() {
		imageview_sleep_icon.startAnimation(sleep_to_Animation);
		imageview_thought_icon.startAnimation(thought_to_Animation);
		imageview_music_icon.startAnimation(music_to_Animation);
		imageview_place_icon.startAnimation(place_to_Animation);
		imageview_people_icon.startAnimation(people_to_Animation);
		
		imageview_camera_icon.startAnimation(camera_to_Animation);	
		
	}
	
	
	private void start_animation(ImageView imageView , Animation animation){
		imageView.startAnimation(animation);
	}
	private void load_animation(Animation animation , int rId){
		animation = AnimationUtils.loadAnimation(this, rId);
		animation.setFillAfter(true);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		Display display = getWindowManager().getDefaultDisplay();
//		if( x > 0 && y > ( display.getHeight() - 150 ) && isFrom == false){
//			start_animation_to();
//			imageview_add_icon.startAnimation(add_rotate_Animation);
//		}
		return super.onTouchEvent(event);
	}
}