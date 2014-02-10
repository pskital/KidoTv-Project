package mp.agencja.apsik.kidotv.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import mp.agencja.apsik.kidotv.R;

public class MainManuScene extends Activity {

    private boolean lock = false;
    private ImageButton btnStart;
    private ImageButton btnGoogle;
    private ImageButton btnRate;
    private ImageButton btnFacebook;
    private ImageButton btnSettings;
    private ImageButton btnFx;
    private ImageButton btnVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_scene);
        btnStart = (ImageButton) findViewById(R.id.btnStart);
        btnGoogle = (ImageButton) findViewById(R.id.btnGoogle);
        btnRate = (ImageButton) findViewById(R.id.btnRate);
        btnFacebook = (ImageButton) findViewById(R.id.btnFacebook);
        btnSettings = (ImageButton) findViewById(R.id.btnSettings);
        final ImageButton btnLock = (ImageButton) findViewById(R.id.btnLock);
        btnFx = (ImageButton) findViewById(R.id.btnFx);
        btnVolume = (ImageButton) findViewById(R.id.btnVolume);

        btnStart.setOnTouchListener(onStartTouchListener);
        btnGoogle.setOnTouchListener(onGoogleTouchListener);
        btnRate.setOnTouchListener(onRateTouchListener);
        btnFacebook.setOnTouchListener(onFacebookTouchListener);

        btnSettings.setOnTouchListener(onSettingsTouchListener);
        btnLock.setOnTouchListener(onLockTouchListener);
        btnFx.setOnTouchListener(onFxTouchListener);
        btnVolume.setOnTouchListener(onVolumeTouchListener);

        RelativeLayout menuLayout = (RelativeLayout) findViewById(R.id.menuLayout);

        AnimationSet animationSetLeft = new AnimationSet(false);

        Animation alfaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alfaAnimation.setDuration(500);
        animationSetLeft.addAnimation(alfaAnimation);

        Animation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1.5f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        translateAnimation.setDuration(1000);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        animationSetLeft.addAnimation(translateAnimation);
        animationSetLeft.setStartOffset(400);

        menuLayout.startAnimation(animationSetLeft);
        findViewById(R.id.tv_image).startAnimation(animationSetLeft);
    }

    private final ImageButton.OnTouchListener onSettingsTouchListener = new ImageButton.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                scaleAnimation(1f, 0.75f, view, "none");
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                scaleAnimation(0.75f, 1f, view, "none");
            }
            return false;
        }
    };
    private final ImageButton.OnTouchListener onLockTouchListener = new ImageButton.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                if (isLock()) {
                    btnStart.setEnabled(false);
                    btnGoogle.setEnabled(false);
                    btnRate.setEnabled(false);
                    btnFacebook.setEnabled(false);
                    btnSettings.setEnabled(false);
                    btnFx.setEnabled(false);
                    btnVolume.setEnabled(false);
                    setLock(true);
                } else {
                    btnStart.setEnabled(true);
                    btnGoogle.setEnabled(true);
                    btnRate.setEnabled(true);
                    btnFacebook.setEnabled(true);
                    btnSettings.setEnabled(true);
                    btnFx.setEnabled(true);
                    btnVolume.setEnabled(true);
                    setLock(false);
                }
                scaleAnimation(1f, 0.75f, view, "none");
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                scaleAnimation(0.75f, 1f, view, "none");
            }
            return false;
        }
    };
    private final ImageButton.OnTouchListener onFxTouchListener = new ImageButton.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                scaleAnimation(1f, 0.75f, view, "none");
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                scaleAnimation(0.75f, 1f, view, "none");
            }
            return false;
        }
    };
    private final ImageButton.OnTouchListener onVolumeTouchListener = new ImageButton.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                scaleAnimation(1f, 0.75f, view, "none");
                AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                scaleAnimation(0.75f, 1f, view, "none");
            }
            return false;
        }
    };

    private final ImageButton.OnTouchListener onStartTouchListener = new ImageButton.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                scaleAnimation(1f, 0.75f, view, "none");
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                scaleAnimation(0.75f, 1f, view, "start");

            }
            return false;
        }
    };
    private final ImageButton.OnTouchListener onGoogleTouchListener = new ImageButton.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                scaleAnimation(1f, 0.75f, view, "none");
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                scaleAnimation(0.75f, 1f, view, "none");
            }
            return false;
        }
    };
    private final ImageButton.OnTouchListener onRateTouchListener = new ImageButton.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                scaleAnimation(1f, 0.75f, view, "none");
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                scaleAnimation(0.75f, 1f, view, "none");
            }
            return false;
        }
    };
    private final ImageButton.OnTouchListener onFacebookTouchListener = new ImageButton.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                scaleAnimation(1f, 0.75f, view, "none");
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                scaleAnimation(0.75f, 1f, view, "none");
            }
            return false;
        }
    };

    private void scaleAnimation(float from, float to, View view, final String action) {
        final ScaleAnimation scaleAnimation = new ScaleAnimation(
                from, to, from, to,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim) {
            }

            public void onAnimationRepeat(Animation anim) {
            }

            public void onAnimationEnd(Animation anim) {
                if (action.equals("start")) {
                    final Intent intent = new Intent(MainManuScene.this, PlayListScene.class);
                    MainManuScene.this.startActivity(intent);
                }
            }
        });
        view.startAnimation(scaleAnimation);
    }

    private boolean isLock() {
        return !lock;
    }

    private void setLock(boolean lock) {
        this.lock = lock;
    }
}