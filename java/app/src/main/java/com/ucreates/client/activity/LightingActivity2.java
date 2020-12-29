// ======================================================================
// Project Name    : android_renderer_client
//
// Copyright © 2020 U-CREATES. All rights reserved.
//
// This source code is the property of U-CREATES.
// If such findings are accepted at any time.
// We hope the tips and helpful in developing.
// ======================================================================
package com.ucreates.client.activity;
import android.content.Context;
import android.opengl.GLES11;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.renderscript.Float3;
import android.support.v7.app.AppCompatActivity;
import com.ucreates.client.R;
import com.ucreates.client.behaviour.CubeBehaviour1;
import com.ucreates.renderer.entity.GLESColor;
import com.ucreates.renderer.enviroment.GLES1Light;
import com.ucreates.renderer.renderer.GLES1Renderer;
import com.ucreates.renderer.timer.TimeInterval;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
public class LightingActivity2 extends AppCompatActivity implements GLSurfaceView.Renderer {
    private GLES1Renderer renderer;
    private ArrayList<CubeBehaviour1> behaviours;
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
        this.behaviours = new ArrayList<CubeBehaviour1>();
        for (int i = 0; i < 1; i++) {
            this.behaviours.add(new CubeBehaviour1(context));
        }
        GLES1Light light1 = new GLES1Light(GLES11.GL_LIGHT0);
        light1.setPosition(3, 0, 0.0f);
        light1.setDirection(-1, 0, 0.0f);
        light1.setAmbient(GLESColor.black);
        light1.setDiffuse(new GLESColor(0.0f, 0f, 1.0f, 1.0f));
        GLES1Light light2 = new GLES1Light(GLES11.GL_LIGHT1);
        light2.setPosition(-3, 0, 0.0f);
        light2.setDirection(1, 0, 0.0f);
        light2.setAmbient(GLESColor.black);
        light2.setDiffuse(new GLESColor(1.0f, 0f, 0.0f, 1.0f));
        this.renderer = new GLES1Renderer();
        this.renderer.create();
        this.renderer.camera.setClear(GLESColor.black);
        this.renderer.camera.setClippingPlane(0.1f, 100.0f, GLES1Renderer.DIMENSION3D);
        this.renderer.camera.setFOV(60.0f);
        this.renderer.camera.setLookAt(new Float3(0.0f, 0.0f, -5.0f), new Float3(0.0f, 0.0f, 0.0f), new Float3(0.0f, 1.0f, 0.0f));
        this.renderer.addLight(light1);
        this.renderer.addLight(light2);
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
        this.renderer.transform(gl, GLES1Renderer.DIMENSION3D);
        for (int i = 0; i < this.behaviours.size(); i++) {
            CubeBehaviour1 behaviour = this.behaviours.get(i);
            behaviour.onUpdate(timer.getDelta());
            this.renderer.render(behaviour.asset);
        }
        return;
    }
}
