package com.tencent.mm.ui.base;

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
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView extends TextureView {
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
        AppMethodBeat.i(142222);
        if (this.weu) {
            dFv();
            AppMethodBeat.o(142222);
            return;
        }
        try {
            super.onDetachedFromWindow();
            AppMethodBeat.o(142222);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMTextureView", e2, "unkown error", new Object[0]);
            AppMethodBeat.o(142222);
        }
    }

    public void destroyDrawingCache() {
        AppMethodBeat.i(164149);
        super.destroyDrawingCache();
        if (this.weu) {
            dFw();
        }
        AppMethodBeat.o(164149);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(164150);
        if (this.weu) {
            dFv();
        }
        super.onAttachedToWindow();
        if (this.weu) {
            dFw();
        }
        AppMethodBeat.o(164150);
    }

    public final void gLi() {
        AppMethodBeat.i(142223);
        if (d.oE(16)) {
            Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(Build.VERSION.SDK_INT));
            AppMethodBeat.o(142223);
        } else if (d.oF(20)) {
            Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(Build.VERSION.SDK_INT));
            AppMethodBeat.o(142223);
        } else if (ae.gKE.gHF == 2) {
            Log.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
            AppMethodBeat.o(142223);
        } else {
            Log.i("MicroMsg.MMTextureView", "detect texture problem, sly");
            try {
                if (this.Gis == null) {
                    this.Gis = TextureView.class.getDeclaredField("mSurface");
                    this.Gis.setAccessible(true);
                }
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.Gis.get(this);
                if (surfaceTexture == null) {
                    Log.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
                    AppMethodBeat.o(142223);
                } else if (!(surfaceTexture instanceof s)) {
                    s sVar = new s();
                    sVar.mSurfaceTexture = surfaceTexture;
                    this.Gis.set(this, sVar);
                    Log.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
                    AppMethodBeat.o(142223);
                } else {
                    Log.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
                    AppMethodBeat.o(142223);
                }
            } catch (NoSuchFieldException e2) {
                Log.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
                Log.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
                AppMethodBeat.o(142223);
            } catch (IllegalArgumentException e3) {
                Log.printErrStackTrace("MicroMsg.MMTextureView", e3, "", new Object[0]);
                Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
                AppMethodBeat.o(142223);
            } catch (IllegalAccessException e4) {
                Log.printErrStackTrace("MicroMsg.MMTextureView", e4, "", new Object[0]);
                Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
                AppMethodBeat.o(142223);
            }
        }
    }

    @TargetApi(16)
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(142224);
        super.setSurfaceTexture(surfaceTexture);
        gLi();
        AppMethodBeat.o(142224);
    }

    public void setInterceptDetach(boolean z) {
        this.weu = z;
    }

    private void dFv() {
        AppMethodBeat.i(164151);
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
            AppMethodBeat.o(164151);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
            AppMethodBeat.o(164151);
        }
    }

    private void dFw() {
        AppMethodBeat.i(164152);
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
            AppMethodBeat.o(164152);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
            AppMethodBeat.o(164152);
        }
    }
}
