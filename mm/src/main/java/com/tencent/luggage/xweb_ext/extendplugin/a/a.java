package com.tencent.luggage.xweb_ext.extendplugin.a;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.luggage.xweb_ext.extendplugin.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a implements b {
    protected c cDJ;
    protected volatile boolean cJY;
    protected int id;
    public String type;

    public final String Lb() {
        AppMethodBeat.i(139353);
        String o = d.o(this.type, this.id);
        AppMethodBeat.o(139353);
        return o;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public void e(SurfaceTexture surfaceTexture) {
        this.cJY = true;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public void PQ() {
        this.cJY = false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public void o(MotionEvent motionEvent) {
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public void s(Bitmap bitmap) {
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public String h(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return null;
    }

    public final int getId() {
        return this.id;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public final void setId(int i2) {
        this.id = i2;
    }

    public final String getType() {
        return this.type;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public final void setType(String str) {
        this.type = str;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b
    public final void a(c cVar) {
        this.cDJ = cVar;
    }

    public final c QJ() {
        return this.cDJ;
    }
}
