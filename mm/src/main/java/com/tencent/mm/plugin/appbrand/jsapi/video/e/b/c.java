package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ContentContentTypeInferer3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "()V", "infer", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "inferInner", "inputStream", "Lcom/google/android/exoplayer2/upstream/DataSourceInputStream;", "luggage-commons-jsapi-video-ext_release"})
public final class c implements h {
    public static final c mBV = new c();

    static {
        AppMethodBeat.i(235241);
        AppMethodBeat.o(235241);
    }

    private c() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h
    public final int r(Uri uri) {
        g wG;
        int r;
        boolean z;
        AppMethodBeat.i(235240);
        Log.i("MicroMsg.InferContentTypeLogic", "infer#ContentContentTypeInferer3, uri: ".concat(String.valueOf(uri)));
        if (uri == null) {
            AppMethodBeat.o(235240);
            return 3;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.c bJr = com.tencent.mm.plugin.appbrand.jsapi.video.c.bJr();
        p.g(bJr, "ExoVideoCacheHandler.getInstance()");
        g.a bJs = bJr.bJs();
        if (bJs == null || (wG = bJs.wG()) == null) {
            int r2 = l.mCK.r(uri);
            AppMethodBeat.o(235240);
            return r2;
        }
        i iVar = new i(wG, new j(uri));
        try {
            byte[] bArr = new byte[32768];
            boolean z2 = false;
            int read = iVar.read(bArr, 0, 512);
            int i2 = 0;
            while (true) {
                if (-1 == read) {
                    break;
                }
                int i3 = i2 + read;
                String str = new String(bArr, 0, i3, d.UTF_8);
                if (z2) {
                    z = z2;
                } else if (!n.J(str, "#EXTM3U", false)) {
                    Log.i("MicroMsg.InferContentTypeLogic", "inferInner#ContentContentTypeInferer3, magicChecked fail");
                    r = 3;
                    break;
                } else {
                    z = true;
                }
                if (!n.e(str, "#EXT-X-STREAM-INF:") && !n.e(str, "#EXT-X-TARGETDURATION:") && !n.e(str, "#EXT-X-MEDIA-SEQUENCE:")) {
                    int i4 = 32768 - i3;
                    if (i4 <= 0) {
                        i2 = i3;
                        break;
                    }
                    z2 = z;
                    read = iVar.read(bArr, i3, i4);
                    i2 = i3;
                } else {
                    Log.i("MicroMsg.InferContentTypeLogic", "inferInner#ContentContentTypeInferer3, infer done, hadReadLen: ".concat(String.valueOf(i3)));
                    r = 2;
                }
            }
            Log.i("MicroMsg.InferContentTypeLogic", "inferInner#ContentContentTypeInferer3, infer done, hadReadLen: " + i2 + ", curReadLen: " + read);
            r = 3;
            try {
                iVar.close();
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            Log.w("MicroMsg.InferContentTypeLogic", "infer#ContentContentTypeInferer3, inferInner fail since ".concat(String.valueOf(e3)));
            r = l.mCK.r(uri);
            try {
                iVar.close();
            } catch (Exception e4) {
            }
        } catch (Throwable th) {
            try {
                iVar.close();
            } catch (Exception e5) {
            }
            AppMethodBeat.o(235240);
            throw th;
        }
        Log.i("MicroMsg.InferContentTypeLogic", "infer#ContentContentTypeInferer3, type: ".concat(String.valueOf(r)));
        AppMethodBeat.o(235240);
        return r;
    }
}
