package com.tencent.luggage.xweb_ext.extendplugin;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkView;

public final class c extends XWalkExtendPluginClient {
    com.tencent.luggage.xweb_ext.extendplugin.b.c cDJ;

    public c(XWalkView xWalkView) {
        super(xWalkView);
    }

    @Override // org.xwalk.core.XWalkExtendPluginClient
    public final void onPluginReady(String str, int i2, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(138804);
        super.onPluginReady(str, i2, surfaceTexture);
        if (this.cDJ != null) {
            this.cDJ.onPluginReady(str, i2, surfaceTexture);
        }
        AppMethodBeat.o(138804);
    }

    @Override // org.xwalk.core.XWalkExtendPluginClient
    public final void onPluginDestroy(String str, int i2) {
        AppMethodBeat.i(138805);
        super.onPluginDestroy(str, i2);
        if (this.cDJ != null) {
            this.cDJ.onPluginDestroy(str, i2);
        }
        AppMethodBeat.o(138805);
    }

    @Override // org.xwalk.core.XWalkExtendPluginClient
    public final void onPluginTouch(String str, int i2, MotionEvent motionEvent) {
        AppMethodBeat.i(138806);
        super.onPluginTouch(str, i2, motionEvent);
        if (this.cDJ != null) {
            this.cDJ.onPluginTouch(str, i2, motionEvent);
        }
        AppMethodBeat.o(138806);
    }

    @Override // org.xwalk.core.XWalkExtendPluginClient
    public final void onPluginScreenshotTaken(String str, int i2, Bitmap bitmap) {
        AppMethodBeat.i(178798);
        super.onPluginScreenshotTaken(str, i2, bitmap);
        if (this.cDJ != null) {
            this.cDJ.onPluginScreenshotTaken(str, i2, bitmap);
        }
        AppMethodBeat.o(178798);
    }

    @Override // org.xwalk.core.XWalkExtendPluginClient
    public final void setPluginTextureScale(String str, int i2, float f2, float f3) {
        AppMethodBeat.i(138807);
        super.setPluginTextureScale(str, i2, f2, f3);
        AppMethodBeat.o(138807);
    }
}
