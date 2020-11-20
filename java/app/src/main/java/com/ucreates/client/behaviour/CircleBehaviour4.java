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
import com.ucreates.renderer.asset.mesh.CircleAsset4;
import com.ucreates.renderer.entity.GLESColor;
public class CircleBehaviour4 extends BaseBehaviour {
    public BaseAsset asset;
    public CircleBehaviour4(Context context) {
        super(context);
        this.asset = new CircleAsset4(0.5f, 100, GLESColor.white);
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
        this.asset.transform.setRotation(0.0f, 0.0f, 0.0f);
        this.asset.vertex.setRandomColor();
        return;
    }
}