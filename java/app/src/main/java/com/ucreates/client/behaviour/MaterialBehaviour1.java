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
import com.ucreates.renderer.asset.GLES1BaseAsset;
import com.ucreates.renderer.asset.mesh.GLES1CubeAsset1;
import com.ucreates.renderer.entity.GLES1Color;
import com.ucreates.renderer.entity.GLES1Material;
public class MaterialBehaviour1 extends BaseBehaviour {
    public GLES1BaseAsset asset;
    private float rotate;
    public MaterialBehaviour1(Context context) {
        super(context);
        GLES1Material material = new GLES1Material();
        material.setAmbient(new GLES1Color(1.0f, 0.0f, 0.0f, 1.0f));
        material.setDiffuse(new GLES1Color(0.0f, 1.0f, 0.0f, 1.0f));
        material.setSpecular(new GLES1Color(1.0f, 1.0f, 1.0f, 1.0f));
        this.asset = new GLES1CubeAsset1(1, 1, 1, GLES1Color.white);
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