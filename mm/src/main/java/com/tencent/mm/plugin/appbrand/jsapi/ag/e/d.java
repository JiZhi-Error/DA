package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class d implements c {
    private c.a mLd;

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c
    public final void a(c.a aVar) {
        this.mLd = aVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c
    public final void cd(int i2, int i3) {
        String str;
        AppMethodBeat.i(139580);
        Log.i("MicroMsg.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.mLd != null) {
            c.a aVar = this.mLd;
            if (i2 == -1024) {
                str = "VIDEO_ERROR";
            } else if (i2 == -1010) {
                str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
            } else if (i2 == -1007) {
                str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
            } else if (i2 == -1004) {
                if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                    str = "MEDIA_ERR_NETWORK";
                } else {
                    str = "MEDIA_ERR_DECODE";
                }
            } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                str = "MEDIA_ERR_NETWORK";
            } else {
                str = "MEDIA_ERR_DECODE";
            }
            aVar.h(str, i2, i3);
        }
        AppMethodBeat.o(139580);
    }
}
