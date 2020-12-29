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
import com.ucreates.client.behaviour.TextureBehaviour11;
import com.ucreates.client.behaviour.TextureBehaviour3;
import com.ucreates.renderer.entity.GLESColor;
import com.ucreates.renderer.renderer.GLES1Renderer;
import com.ucreates.renderer.timer.TimeInterval;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
public class TextureActivity11 extends AppCompatActivity implements GLSurfaceView.Renderer {
    private GLES1Renderer renderer;
    private ArrayList<TextureBehaviour11> behaviours;
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
        this.behaviours = new ArrayList<TextureBehaviour11>();
        this.behaviours.add(new TextureBehaviour11(context, 0));
        this.behaviours.add(new TextureBehaviour11(context, 1));
        this.renderer = new GLES1Renderer();
        this.renderer.create();
        this.renderer.camera.setClear(GLESColor.white);
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
        TimeInterval timer = TimeInterval.getInstance();
        timer.update();
        this.renderer.clear();
        this.renderer.transform(gl, GLES1Renderer.DIMENSION2D);
        for (int i = 0; i < this.behaviours.size(); i++) {
            TextureBehaviour11 behaviour = this.behaviours.get(i);
            behaviour.onUpdate(timer.getDelta());
            this.renderer.render(behaviour.asset);
        }
        return;
    }
}
