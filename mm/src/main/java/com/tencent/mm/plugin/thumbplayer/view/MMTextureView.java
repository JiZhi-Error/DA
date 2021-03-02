package com.tencent.mm.plugin.thumbplayer.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmediacodec.hook.THookTextureView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(14)
public class MMTextureView extends THookTextureView {
    private Field Gis;
    boolean weu = false;
    private Object wev;
    private Object wew;

    public MMTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MMTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMTextureView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @TargetApi(14)
    public void onDetachedFromWindow() {
        AppMethodBeat.i(238589);
        if (this.weu) {
            dFv();
            AppMethodBeat.o(238589);
            return;
        }
        try {
            super.onDetachedFromWindow();
            AppMethodBeat.o(238589);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMTextureView", e2, "unkown error", new Object[0]);
            AppMethodBeat.o(238589);
        }
    }

    public void destroyDrawingCache() {
        AppMethodBeat.i(238590);
        super.destroyDrawingCache();
        if (this.weu) {
            dFw();
        }
        AppMethodBeat.o(238590);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(238591);
        if (this.weu) {
            dFv();
        }
        super.onAttachedToWindow();
        if (this.weu) {
            dFw();
        }
        AppMethodBeat.o(238591);
    }

    @TargetApi(16)
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(238592);
        super.setSurfaceTexture(surfaceTexture);
        if (d.oE(16)) {
            Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(Build.VERSION.SDK_INT));
            AppMethodBeat.o(238592);
        } else if (d.oF(20)) {
            Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(Build.VERSION.SDK_INT));
            AppMethodBeat.o(238592);
        } else if (ae.gKE.gHF == 2) {
            Log.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
            AppMethodBeat.o(238592);
        } else {
            Log.i("MicroMsg.MMTextureView", "detect texture problem, sly");
            try {
                if (this.Gis == null) {
                    this.Gis = TextureView.class.getDeclaredField("mSurface");
                    this.Gis.setAccessible(true);
                }
                SurfaceTexture surfaceTexture2 = (SurfaceTexture) this.Gis.get(this);
                if (surfaceTexture2 == null) {
                    Log.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
                    AppMethodBeat.o(238592);
                } else if (!(surfaceTexture2 instanceof b)) {
                    b bVar = new b();
                    bVar.mSurfaceTexture = surfaceTexture2;
                    this.Gis.set(this, bVar);
                    Log.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
                    AppMethodBeat.o(238592);
                } else {
                    Log.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
                    AppMethodBeat.o(238592);
                }
            } catch (NoSuchFieldException e2) {
                Log.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
                Log.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
                AppMethodBeat.o(238592);
            } catch (IllegalArgumentException e3) {
                Log.printErrStackTrace("MicroMsg.MMTextureView", e3, "", new Object[0]);
                Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
                AppMethodBeat.o(238592);
            } catch (IllegalAccessException e4) {
                Log.printErrStackTrace("MicroMsg.MMTextureView", e4, "", new Object[0]);
                Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
                AppMethodBeat.o(238592);
            }
        }
    }

    public void setInterceptDetach(boolean z) {
        this.weu = z;
    }

    private void dFv() {
        AppMethodBeat.i(238593);
        try {
            Log.i("MicroMsg.MMTextureView", "hookInnerDetach");
            Field declaredField = TextureView.class.getDeclaredField("mLayer");
            declaredField.setAccessible(true);
            this.wev = declaredField.get(this);
            declaredField.set(this, null);
            Field declaredField2 = TextureView.class.getDeclaredField("mSurface");
            declaredField2.setAccessible(true);
            this.wew = declaredField2.get(this);
            declaredField2.set(this, null);
            AppMethodBeat.o(238593);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
            AppMethodBeat.o(238593);
        }
    }

    private void dFw() {
        AppMethodBeat.i(238594);
        try {
            Log.i("MicroMsg.MMTextureView", "unHookInnerDetach");
            if (this.wev != null) {
                Field declaredField = TextureView.class.getDeclaredField("mLayer");
                declaredField.setAccessible(true);
                declaredField.set(this, this.wev);
                this.wev = null;
            }
            if (this.wew != null) {
                Field declaredField2 = TextureView.class.getDeclaredField("mSurface");
                declaredField2.setAccessible(true);
                declaredField2.set(this, this.wew);
                this.wew = null;
            }
            AppMethodBeat.o(238594);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
            AppMethodBeat.o(238594);
        }
    }

    public final void fxg() {
        AppMethodBeat.i(238595);
        try {
            setInterceptDetach(false);
            dFw();
            Method method = TextureView.class.getMethod("destroyHardwareLayer", new Class[0]);
            method.setAccessible(true);
            method.invoke(this, new Object[0]);
            Method method2 = TextureView.class.getMethod("releaseSurfaceTexture", new Class[0]);
            method2.setAccessible(true);
            method2.invoke(this, new Object[0]);
            AppMethodBeat.o(238595);
        } catch (Exception e2) {
            AppMethodBeat.o(238595);
        }
    }
}
