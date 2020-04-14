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
import com.ucreates.renderer.asset.polygon.TriangleAsset1;
import com.ucreates.renderer.entity.GLESBlend;
import com.ucreates.renderer.entity.GLESColor;
public class BlendBehaviour3 extends BlendBehaviour {
    public BlendBehaviour3(Context context) {
        super(context);
        GLESBlend blend = new GLESBlend();
        blend.normal();
        this.asset = new TriangleAsset1(1, 1, GLESColor.blue(0.5f));
        this.asset.blend = blend;
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
        float z = (float) Math.sin(this.timeLine.currentFrame);
        this.asset.transform.setPosition(0.0f, 0.0f, z);
        this.asset.transform.setScale(0.5f, 0.5f, 0.5f);
        this.asset.transform.setRotation(0.0f, 0.0f, 0.0f);
        this.timeLine.next((float) delta);
        return;
    }
}