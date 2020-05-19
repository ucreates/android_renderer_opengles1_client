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
import com.ucreates.renderer.asset.mesh.ObjAsset;
import com.ucreates.renderer.entity.Mesh;
import java.util.Random;
public class ObjBehaviour extends BaseBehaviour {
    public BaseAsset asset;
    private float rotate;
    private int objType;
    public ObjBehaviour(Context context) {
        super(context);
        Random random = new Random();
        this.objType = random.nextInt(3);
        String objName = "";
        if (0 == this.objType) {
            objName = "apple.obj";
        } else if (1 == this.objType) {
            objName = "android.obj";
        } else {
            objName = "tank.obj";
        }
        this.asset = new ObjAsset();
        this.asset.create(objName, context);
        return;
    }
    @Override
    public void onCreate() {
        return;
    }
    @Override
    public void onUpdate(double delta) {
        ObjAsset asset = (ObjAsset) this.asset;
        for (Mesh mesh : asset.subMeshes) {
            if (0 == this.objType) {
                mesh.transform.setPosition(0.0f, -0.1f, 0.0f);
                mesh.transform.setScale(0.025f, 0.025f, 0.025f);
                mesh.transform.setRotation(0.0f, this.rotate, 0.0f);
            } else if (1 == this.objType) {
                mesh.transform.setPosition(0.0f, -0.1f, 0.0f);
                mesh.transform.setScale(1.5f, 1.5f, 1.5f);
                mesh.transform.setRotation(0.0f, this.rotate, 0.0f);
            } else {
                mesh.transform.setPosition(0.0f, 0.0f, 0.0f);
                mesh.transform.setScale(0.0015f, 0.0015f, 0.0015f);
                mesh.transform.setRotation(270.0f, 0.0f, this.rotate);
            }
        }
        this.rotate += 1.0f;
        return;
    }
}