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
import com.ucreates.renderer.asset.mesh.CubeAsset1;
import com.ucreates.renderer.entity.GLESColor;
import com.ucreates.renderer.entity.Material;
public class MaterialBehaviour1 extends BaseBehaviour {
    public BaseAsset asset;
    private float rotate;
    public MaterialBehaviour1(Context context) {
        super(context);
        Material material = new Material();
        material.setAmbient(new GLESColor(1.0f, 0.0f, 0.0f, 1.0f));
        material.setDiffuse(new GLESColor(0.0f, 1.0f, 0.0f, 1.0f));
        material.setSpecular(new GLESColor(1.0f, 1.0f, 1.0f, 1.0f));
        this.asset = new CubeAsset1(1, 1, 1, GLESColor.white);
        this.asset.setMaterial(material);
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
        this.asset.vertex.setRandomColor();
        this.rotate += 1.0f;
        return;
    }
}