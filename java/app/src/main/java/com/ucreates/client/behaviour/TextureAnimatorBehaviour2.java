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
import com.ucreates.renderer.asset.TextureAtlasAnimatorAsset;
import com.ucreates.renderer.asset.polygon.RectangleAsset1;
import com.ucreates.renderer.entity.GLESBlend;
import com.ucreates.renderer.entity.GLESColor;
public class TextureAnimatorBehaviour2 extends BaseBehaviour {
    public BaseAsset asset;
    public TextureAnimatorBehaviour2(Context context) {
        super(context);
        GLESBlend blend = new GLESBlend();
        blend.normal();
        BaseAsset frame = new RectangleAsset1(1, 1, GLESColor.white);
        frame.create("animation.png", context);
        frame.blend = blend;
        TextureAtlasAnimatorAsset animatorAsset = new TextureAtlasAnimatorAsset();
        float u[] = {
            0.0f,
            0.084f,
            0.1f,
            0.189f,
            0.2f,
            0.289f,
            0.3f,
            0.389f,
            0.39f,
            0.493f,
            0.50f,
            0.589f,
            0.60f,
            0.689f,
            0.69f,
            0.795f,
            0.80f,
            0.895f,
            0.90f,
            0.995f,
        };
        for (int i = 0; i < u.length; i += 2) {
            float sx = u[i];
            float ex = u[i + 1];
            float uvs[] = {
                // left down
                sx,
                1.0f,
                // right down
                ex,
                1.0f,
                // left up
                sx,
                0.88f,
                // right down
                ex,
                1.0f,
                // right up
                ex,
                0.88f,
                // left up
                sx,
                0.88f,
            };
            animatorAsset.addFrameUVs(uvs);
        }
        animatorAsset.setTextureAtlas(frame);
        animatorAsset.setFrameSpan(2);
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
        float x = (float) Math.cos(this.timeLine.currentFrame) * -0.25f;
        float y = (float) Math.sin(this.timeLine.currentFrame) * 0.25f;
        this.asset.transform.setPosition(x, y, 0.0f);
        this.asset.transform.setScale(1.0f, 1.0f, 1.0f);
        this.asset.transform.setRotation(0.0f, 0.0f, 0.0f);
        this.timeLine.next((float) delta);
        return;
    }
}