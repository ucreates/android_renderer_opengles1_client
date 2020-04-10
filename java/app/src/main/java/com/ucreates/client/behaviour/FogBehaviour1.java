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
public class FogBehaviour1 extends BaseBehaviour {
    public BaseAsset asset;
    private float rotate;
    public FogBehaviour1(Context context) {
        super(context);
        this.asset = new CubeAsset1(1, 1, 1, GLESColor.white);
        this.asset.create();
        this.timeLine.rate = 0.05f;
        return;
    }
    @Override
    public void onCreate() {
        return;
    }
    @Override
    public void onUpdate(double delta) {
        float z = (float) Math.abs(Math.sin(this.timeLine.currentFrame)) * 5.0f - 2.0f;
        this.asset.transform.setPosition(0.0f, 0.0f, z);
        this.asset.transform.setScale(1.0f, 1.0f, 1.0f);
        this.asset.transform.setRotation(this.rotate, this.rotate, this.rotate);
        this.asset.vertex.setRandomColor();
        this.rotate += 1.0f;
        this.timeLine.next((float) delta);
        return;
    }
}