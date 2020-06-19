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
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES11;
import android.renderscript.Float2;
import android.util.Log;
import com.frontend.behaviour.BaseBehaviour;
import com.ucreates.renderer.asset.BaseAsset;
import com.ucreates.renderer.asset.mesh.CubeAsset1;
import com.ucreates.renderer.asset.polygon.RectangleAsset1;
import com.ucreates.renderer.entity.GLESBlend;
import com.ucreates.renderer.entity.GLESColor;
import com.ucreates.renderer.io.memory.Allocator;
import com.ucreates.renderer.math.GLES1Exponentiation;
import com.ucreates.renderer.renderer.GLES1Renderer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
public class TextureBehaviour12 extends BaseBehaviour {
    public BaseAsset asset;
    private float rotate;
    public TextureBehaviour12(Context context) {
        super(context);
        ArrayList<String> paths = new ArrayList<String>();
        for (int i = 0; i < 8; i++) {
            String path = String.format("mipmap%02d.jpg", i + 1);
            paths.add(path);
        }
        this.asset = new CubeAsset1(1, 1, 1, GLESColor.white);
        this.asset.createMipmap(paths, context);
        this.timeLine.rate = 0.01f;
        return;
    }
    @Override
    public void onCreate() {
        return;
    }
    @Override
    public void onUpdate(double delta) {
        float z = (float) Math.abs(Math.sin(this.timeLine.currentFrame)) * 100.0f;
        z = Math.abs(z);
        this.asset.transform.setPosition(0.0f, 0.0f, z);
        this.asset.transform.setScale(1.0f, 1.0f, 1.0f);
        this.asset.transform.setRotation(this.rotate, this.rotate, this.rotate);
        this.timeLine.next((float) delta);
        this.rotate += 1.0f;
        return;
    }
}