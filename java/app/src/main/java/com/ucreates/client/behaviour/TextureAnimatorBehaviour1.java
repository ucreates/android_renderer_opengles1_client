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
import com.ucreates.renderer.asset.GLES1TextureAnimatorAsset;
import com.ucreates.renderer.asset.polygon.GLES1RectangleAsset1;
import com.ucreates.renderer.asset.polygon.GLES1TriangleAsset1;
import com.ucreates.renderer.entity.GLES1Blend;
import com.ucreates.renderer.entity.GLES1Color;
public class TextureAnimatorBehaviour1 extends BaseBehaviour {
    public GLES1BaseAsset asset;
    public TextureAnimatorBehaviour1(Context context) {
        super(context);
        GLES1Blend blend = new GLES1Blend();
        blend.normal();
        GLES1TextureAnimatorAsset animatorAsset = new GLES1TextureAnimatorAsset();
        for (int i = 0; i < 10; i++) {
            String path = String.format("number%02d.png", i);
            GLES1BaseAsset frame = new GLES1RectangleAsset1(1, 1, GLES1Color.white);
            frame.create(path, context);
            frame.blend = blend;
            animatorAsset.add(frame);
        }
        animatorAsset.setFrameSpan(30);
        this.asset = animatorAsset;
        this.timeLine.rate = 0.01f;
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
        this.asset.transform.setRotation(0.0f, 0.0f, 0.0f);
        return;
    }
}