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
import com.ucreates.renderer.asset.polygon.GLES1TriangleAsset1;
import com.ucreates.renderer.entity.GLES1Color;
public class BlendBehaviour extends BaseBehaviour {
    public GLES1BaseAsset asset;
    public BlendBehaviour(Context context) {
        super(context);
        return;
    }
}