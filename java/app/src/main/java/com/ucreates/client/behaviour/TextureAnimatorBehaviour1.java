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
import com.ucreates.renderer.asset.TextureAnimatorAsset;
import com.ucreates.renderer.asset.polygon.RectangleAsset1;
import com.ucreates.renderer.asset.polygon.TriangleAsset1;
import com.ucreates.renderer.entity.GLESBlend;
import com.ucreates.renderer.entity.GLESColor;
public class TextureAnimatorBehaviour1 extends BaseBehaviour {
    public BaseAsset asset;
    public TextureAnimatorBehaviour1(Context context) {
        super(context);
        GLESBlend blend = new GLESBlend();
        blend.normal();
        TextureAnimatorAsset animatorAsset = new TextureAnimatorAsset();
        for (int i = 0; i < 10; i++) {
            String path = String.format("number%02d.png", i);
            BaseAsset frame = new RectangleAsset1(1, 1, GLESColor.white);
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