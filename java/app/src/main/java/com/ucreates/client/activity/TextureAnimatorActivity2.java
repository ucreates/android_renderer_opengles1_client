// ======================================================================
// Project Name    : android_renderer_opengles1_client
//
// Copyright © 2020 U-CREATES. All rights reserved.
//
// This source code is the property of U-CREATES.
// If such findings are accepted at any time.
// We hope the tips and helpful in developing.
// ======================================================================
package com.ucreates.client.activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ucreates.client.R;
import com.ucreates.client.behaviour.TextureAnimatorBehaviour2;
import com.ucreates.renderer.asset.GLES1BaseAsset;
import com.ucreates.renderer.asset.GLES1TextureAtlasAnimatorAsset;
import com.ucreates.renderer.entity.GLES1Color;
import com.ucreates.renderer.renderer.GLES1Renderer;
import com.ucreates.renderer.timer.GLES1TimeInterval;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
public class TextureAnimatorActivity2 extends AppCompatActivity implements GLSurfaceView.Renderer {
    private GLES1Renderer renderer;
    private ArrayList<TextureAnimatorBehaviour2> behaviours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        GLSurfaceView view = (GLSurfaceView) this.findViewById(R.id.view);
        view.setEGLContextClientVersion(1);
        view.setPreserveEGLContextOnPause(true);
        view.setRenderer(this);
        return;
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Context context = this.getApplicationContext();
        this.behaviours = new ArrayList<TextureAnimatorBehaviour2>();
        this.behaviours.add(new TextureAnimatorBehaviour2(context));
        this.renderer = new GLES1Renderer();
        this.renderer.create();
        this.renderer.camera.setClear(GLES1Color.white);
        this.renderer.camera.setClippingPlane(-1.0f, 1.0f, GLES1Renderer.DIMENSION2D);
        return;
    }
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        this.renderer.rebind(this.getApplicationContext(), width, height);
        return;
    }
    @Override
    public void onDrawFrame(GL10 gl) {
        GLES1TimeInterval timer = GLES1TimeInterval.getInstance();
        timer.update();
        this.renderer.clear();
        this.renderer.transform(gl, GLES1Renderer.DIMENSION2D);
        for (int i = 0; i < this.behaviours.size(); i++) {
            TextureAnimatorBehaviour2 behaviour = this.behaviours.get(i);
            behaviour.onUpdate(timer.getDelta());
            GLES1TextureAtlasAnimatorAsset asset = (GLES1TextureAtlasAnimatorAsset) behaviour.asset;
            GLES1BaseAsset currentFrame = asset.getCurrentFrame();
            this.renderer.render(currentFrame);
        }
        return;
    }
}
