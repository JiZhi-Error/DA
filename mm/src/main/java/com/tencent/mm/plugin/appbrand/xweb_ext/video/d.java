package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;

public final class d {

    public static class a implements h {
        private static a oHz;

        private a() {
        }

        public static a cdQ() {
            AppMethodBeat.i(50048);
            if (oHz == null) {
                synchronized (a.class) {
                    try {
                        if (oHz == null) {
                            oHz = new a();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(50048);
                        throw th;
                    }
                }
            }
            a aVar = oHz;
            AppMethodBeat.o(50048);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.h
        public final c a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, Handler handler) {
            f NN;
            int i2;
            int i3;
            int i4;
            int i5 = CommonUtils.MAX_TIMEOUT_MS;
            int i6 = 15000;
            int i7 = 2500;
            AppMethodBeat.i(227870);
            com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a aVar2 = null;
            if ((aVar instanceof b) && (NN = aVar.NN()) != null && "wxfe02ecfe70800f46".equalsIgnoreCase(NN.getAppId())) {
                if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null) {
                    int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_video_weishi_loadcontrol_minbufferms, 15000);
                    Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiMinBufferMS, expt is %s", Integer.valueOf(a2));
                    i2 = a2;
                } else {
                    i2 = 15000;
                }
                if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null) {
                    int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_video_weishi_loadcontrol_maxbufferms, CommonUtils.MAX_TIMEOUT_MS);
                    Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiMaxBufferMS, expt is %s", Integer.valueOf(a3));
                    i3 = a3;
                } else {
                    i3 = 30000;
                }
                if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null) {
                    i4 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_video_weishi_loadcontrol_bufferforplaybackms, 2500);
                    Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoWeishiBufferForPlaybackMS, expt is %s", Integer.valueOf(i4));
                } else {
                    i4 = 2500;
                }
                Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, weishi use weishi exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                aVar2 = new m(handler, i2, i3, i4);
            }
            if (aVar2 == null) {
                if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null) {
                    i6 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_video_loadcontrol_minbufferms, 15000);
                    Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoMinBufferDuration, expt is %s", Integer.valueOf(i6));
                }
                if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null) {
                    i5 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_video_loadcontrol_maxbufferms, CommonUtils.MAX_TIMEOUT_MS);
                    Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoMaxBufferMS, expt is %s", Integer.valueOf(i5));
                }
                if (g.af(com.tencent.mm.plugin.expt.b.b.class) != null) {
                    i7 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_video_loadcontrol_bufferforplaybackms, 2500);
                    Log.i("MicroMsg.SameLayer.AppBrandXWebVideoABTests", "getXWebVideoBufferForPlaybackMS, expt is %s", Integer.valueOf(i7));
                }
                Log.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "createMediaPlayer, use exo media player, minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i7));
                aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a(handler, i6, i5, i7);
            }
            AppMethodBeat.o(227870);
            return aVar2;
        }
    }
}
