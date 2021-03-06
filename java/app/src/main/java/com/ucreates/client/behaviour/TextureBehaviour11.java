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
import com.ucreates.renderer.asset.polygon.GLES1RectangleAsset1;
import com.ucreates.renderer.entity.GLES1Blend;
import com.ucreates.renderer.entity.GLES1Color;
public class TextureBehaviour11 extends BaseBehaviour {
    public GLES1BaseAsset asset;
    public int type;
    public TextureBehaviour11(Context context, int type) {
        super(context);
        GLES1Blend blend = new GLES1Blend();
        blend.normal();
        this.type = type;
        this.asset = new GLES1RectangleAsset1(1, 1, GLES1Color.white);
        this.asset.blend = blend;
        this.asset.create("texture03.png", context);
        this.timeLine.rate = 0.05f;
        return;
    }
    @Override
    public void onCreate() {
        return;
    }
    @Override
    public void onUpdate(double delta) {
        float alpha = (float) Math.abs(Math.cos(this.timeLine.currentFrame));
        if (0 == this.type) {
            float x = (float) Math.sin(this.timeLine.currentFrame);
            this.asset.transform.setPosition(x, 0.0f, 0.0f);
        } else {
            float y = (float) Math.sin(this.timeLine.currentFrame);
            this.asset.transform.setPosition(0.0f, y, 0.0f);
        }
        this.asset.transform.setScale(1.0f, 1.0f, 1.0f);
        this.asset.transform.setRotation(0.0f, 0.0f, 0.0f);
        this.asset.vertex.setAlpha(alpha);
        this.timeLine.next((float) delta);
        return;
    }
}