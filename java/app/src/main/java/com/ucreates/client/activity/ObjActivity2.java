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
import android.opengl.GLES11;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.renderscript.Float3;
import android.support.v7.app.AppCompatActivity;
import com.ucreates.client.R;
import com.ucreates.client.behaviour.BackgroundBehaviour1;
import com.ucreates.client.behaviour.ObjBehaviour;
import com.ucreates.client.behaviour.UIBehaviour1;
import com.ucreates.renderer.asset.BaseAsset;
import com.ucreates.renderer.asset.TextureAnimatorAsset;
import com.ucreates.renderer.asset.TextureAtlasAnimatorAsset;
import com.ucreates.renderer.asset.mesh.ObjAsset;
import com.ucreates.renderer.entity.GLESColor;
import com.ucreates.renderer.enviroment.GLES1Light;
import com.ucreates.renderer.renderer.GLES1Renderer;
import com.ucreates.renderer.timer.TimeInterval;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
public class ObjActivity2 extends AppCompatActivity implements GLSurfaceView.Renderer {
    private GLES1Renderer renderer;
    private ArrayList<ObjBehaviour> behaviours;
    private ArrayList<BackgroundBehaviour1> behavioursBG;
    private ArrayList<UIBehaviour1> behavioursUI;
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
        this.behaviours = new ArrayList<ObjBehaviour>();
        this.behavioursBG = new ArrayList<BackgroundBehaviour1>();
        this.behavioursUI = new ArrayList<UIBehaviour1>();
        for (int i = 0; i < 1; i++) {
            this.behaviours.add(new ObjBehaviour(context));
            this.behavioursBG.add(new BackgroundBehaviour1(context));
            this.behavioursUI.add(new UIBehaviour1(context));
        }
        GLES1Light light = new GLES1Light(GLES11.GL_LIGHT0);
        light.setPosition(-5.0f, 0, -5.0f);
        light.setAmbient(GLESColor.black);
        light.setDiffuse(GLESColor.white);
        light.setSpecular(GLESColor.white);
        this.renderer = new GLES1Renderer();
        this.renderer.create();
        this.renderer.camera.setClear(GLESColor.black);
        this.renderer.camera.setClippingPlane(-1.0f, 1.0f, GLES1Renderer.DIMENSION2D);
        this.renderer.camera.setClippingPlane(0.1f, 100.0f, GLES1Renderer.DIMENSION3D);
        this.renderer.camera.setFOV(60.0f);
        this.renderer.camera.setLookAt(new Float3(0.0f, 0.0f, -1.0f), new Float3(0.0f, 0.0f, 0.0f), new Float3(0.0f, 1.0f, 0.0f));
        this.renderer.addLight(light);
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
        for (int i = 0; i < this.behavioursBG.size(); i++) {
            BackgroundBehaviour1 behaviour = this.behavioursBG.get(i);
            behaviour.onUpdate(timer.getDelta());
            this.renderer.render(behaviour.asset);
        }
        this.renderer.clear(true);
        this.renderer.transform(gl, GLES1Renderer.DIMENSION3D);
        for (int i = 0; i < this.behaviours.size(); i++) {
            ObjBehaviour behaviour = this.behaviours.get(i);
            behaviour.onUpdate(timer.getDelta());
            ObjAsset asset = (ObjAsset) behaviour.asset;
            this.renderer.render(asset.subMeshes);
        }
        this.renderer.transform(gl, GLES1Renderer.DIMENSION2D);
        for (int i = 0; i < this.behavioursUI.size(); i++) {
            UIBehaviour1 behaviour = this.behavioursUI.get(i);
            behaviour.onUpdate(timer.getDelta());
            TextureAnimatorAsset asset = (TextureAnimatorAsset) behaviour.asset;
            BaseAsset currentFrame = asset.getCurrentFrame();
            this.renderer.render(currentFrame);
        }
        return;
    }
}
