package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.f.h;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class b implements c.a {
    private final float cIO;
    private final float cIP;
    final WeakReference<TextureImageViewLikeImpl> cIQ;

    public b(j jVar, TextureImageViewLikeImpl textureImageViewLikeImpl) {
        AppMethodBeat.i(215677);
        this.cIO = jVar.cJT.cJD;
        this.cIP = jVar.cJT.cJE;
        Log.i("MicroMsg.AppBrand.TextureScaleLogic", "<init>, originWidthScale: %f, originHeightScale: %f", Float.valueOf(this.cIO), Float.valueOf(this.cIP));
        this.cIQ = new WeakReference<>(textureImageViewLikeImpl);
        AppMethodBeat.o(215677);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.c.a
    public final void a(boolean z, float f2, float f3) {
        final float f4;
        final boolean z2;
        final float f5;
        AppMethodBeat.i(215678);
        Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged: %b, widthScale: %f, heightScale: %f", Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3));
        if (z) {
            Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged");
            AppMethodBeat.o(215678);
        } else if (this.cIQ.get() == null) {
            Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, textureImageViewLike already release");
            AppMethodBeat.o(215678);
        } else {
            float f6 = f2 / this.cIO;
            float f7 = f3 / this.cIP;
            if (f6 >= f7) {
                f5 = (f7 / f6) * 1.0f;
                z2 = false;
                f4 = 1.0f;
            } else {
                f4 = (f6 / f7) * 1.0f;
                z2 = true;
                f5 = 1.0f;
            }
            Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, fixedWidthScale: %f, fixedHeightScale: %f, finalWidthScale: %f, finalHeightScale: %f, willScaleWidth: %b", Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(z2));
            h.RTc.aV(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(215676);
                    TextureImageViewLikeImpl textureImageViewLikeImpl = b.this.cIQ.get();
                    if (textureImageViewLikeImpl == null) {
                        Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale#ui, textureImageViewLike already release");
                        AppMethodBeat.o(215676);
                    } else if (z2) {
                        textureImageViewLikeImpl.setTextureViewWidthWeight(f4);
                        AppMethodBeat.o(215676);
                    } else {
                        textureImageViewLikeImpl.setTextureViewHeightWeight(f5);
                        AppMethodBeat.o(215676);
                    }
                }
            });
            AppMethodBeat.o(215678);
        }
    }
}
