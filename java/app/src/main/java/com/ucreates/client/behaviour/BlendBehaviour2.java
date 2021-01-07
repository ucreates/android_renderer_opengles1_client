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
import com.ucreates.renderer.asset.polygon.GLES1TriangleAsset1;
import com.ucreates.renderer.entity.GLES1Blend;
import com.ucreates.renderer.entity.GLES1Color;
public class BlendBehaviour2 extends BlendBehaviour {
    public BlendBehaviour2(Context context) {
        super(context);
        GLES1Blend blend = new GLES1Blend();
        blend.normal();
        this.asset = new GLES1TriangleAsset1(1, 1, GLES1Color.green(0.5f));
        this.asset.blend = blend;
        this.asset.create();
        return;
    }
    @Override
    public void onCreate() {
        return;
    }
    @Override
    public void onUpdate(double delta) {
        this.asset.transform.setPosition(-0.25f, 0.0f, -0.5f);
        this.asset.transform.setScale(1.0f, 1.0f, 1.0f);
        this.asset.transform.setRotation(0.0f, 0.0f, 0.0f);
        return;
    }
}