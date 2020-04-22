// ======================================================================
// Project Name    : android_renderer_opengles1_client
//
// Copyright © 2020 U-CREATES. All rights reserved.
//
// This source code is the property of U-CREATES.
// If such findings are accepted at any time.
// We hope the tips and helpful in developing.
// ======================================================================
package com.ucreates.client.behaviour;
import android.content.Context;
import com.frontend.behaviour.BaseBehaviour;
import com.ucreates.renderer.asset.BaseAsset;
import com.ucreates.renderer.asset.GLES1ShaderAsset;
import com.ucreates.renderer.asset.mesh.SphereAsset1;
import com.ucreates.renderer.entity.GLESColor;
public class ShaderBehaviour1 extends BaseBehaviour {
    public BaseAsset asset;
    private float rotate;
    public ShaderBehaviour1(Context context) {
        super(context);
        GLES1ShaderAsset shader = new GLES1ShaderAsset();
        shader.setFlat();
        this.asset = new SphereAsset1(1, 30, GLESColor.red);
        this.asset.shader = shader;
        this.asset.create();
        return;
    }
    @Override
    public void onCreate() {
        return;
    }
    @Override
    public void onUpdate(double delta) {
        this.asset.transform.setPosition(0.0f, 0.0f, 0.0f);
        this.asset.transform.setScale(1.0f, 1.0f, 1.0f);
        this.asset.transform.setRotation(this.rotate, this.rotate, this.rotate);
        this.rotate += 1.0f;
        return;
    }
}