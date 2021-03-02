package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.c;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

public final class n implements c {
    private int scene;

    public n() {
        this(0);
    }

    public n(int i2) {
        this.scene = i2;
    }

    @Override // com.tencent.mm.av.a.c.c
    public final b OV(String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(124382);
        Log.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", str);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            h hVar = h.Kew;
            b a2 = h.a(str, false, new k(this.scene));
            if (a2 != null) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                Object[] objArr = new Object[5];
                objArr[0] = a2.contentType;
                objArr[1] = Integer.valueOf(a2.jbH);
                objArr[2] = Integer.valueOf(a2.data != null ? a2.data.length : -1);
                objArr[3] = str;
                objArr[4] = Long.valueOf(currentTimeMillis2);
                Log.d("MicroMsg.ChattingBizImgDownloader", "alvinluo BizImage download responseContentType: %s, contentLength: %d, dataLength: %d, url: %s, download used %d ms", objArr);
                g gVar = g.Kev;
                String str2 = a2.contentType;
                p.h(str, "url");
                if (!com.tencent.mm.api.b.Ut() || !g.beK(str2) || !com.tencent.mm.api.b.fo(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    g gVar2 = g.Kev;
                    if (g.mA(str, a2.contentType)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Log.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b, used %d ms", Boolean.valueOf(z2), Long.valueOf(currentTimeMillis2));
                    h.INSTANCE.idkeyStat(86, 4, currentTimeMillis2, false);
                    if (z2) {
                        h.INSTANCE.idkeyStat(86, 17, currentTimeMillis2, false);
                    }
                } else if (a2.data == null) {
                    Log.e("MicroMsg.ChattingBizImgDownloader", "response.data is null");
                    gpv();
                    b beO = beO(str);
                    AppMethodBeat.o(124382);
                    return beO;
                } else if (a2.jbH <= 0 || a2.jbH == a2.data.length) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeByteArray(a2.data, 0, a2.data.length, options);
                    if (options.outHeight <= 0 || options.outWidth <= 0) {
                        Log.e("MicroMsg.ChattingBizImgDownloader", "decode wxpic fail");
                        String str3 = a2.contentType;
                        g gVar3 = g.Kev;
                        if (g.aif(this.scene)) {
                            f fVar = f.Ket;
                            f.da(str3, false);
                        }
                        g gVar4 = g.Kev;
                        if (g.beK(str3)) {
                            f fVar2 = f.Ket;
                            f.aL(str, 1, this.scene);
                        }
                        b beO2 = beO(str);
                        AppMethodBeat.o(124382);
                        return beO2;
                    }
                    g gVar5 = g.Kev;
                    if (g.aif(this.scene)) {
                        f fVar3 = f.Ket;
                        f.zS(true);
                    }
                    Log.d("MicroMsg.ChattingBizImgDownloader", "decode wxpic success");
                } else {
                    gpv();
                    b beO3 = beO(str);
                    AppMethodBeat.o(124382);
                    return beO3;
                }
            }
            AppMethodBeat.o(124382);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", e2.toString());
            b bVar = new b(null, null, (byte) 0);
            AppMethodBeat.o(124382);
            return bVar;
        }
    }

    private b beN(String str) {
        AppMethodBeat.i(124383);
        Log.d("MicroMsg.ChattingBizImgDownloader", "getNormalImageData from url:%s", str);
        try {
            System.currentTimeMillis();
            h hVar = h.Kew;
            b a2 = h.a(str, true, new k(this.scene));
            if (a2 != null) {
                System.currentTimeMillis();
            }
            AppMethodBeat.o(124383);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", e2.toString());
            b bVar = new b(null, null, (byte) 0);
            AppMethodBeat.o(124383);
            return bVar;
        }
    }

    private void gpv() {
        AppMethodBeat.i(124384);
        g gVar = g.Kev;
        if (g.aif(this.scene)) {
            f fVar = f.Ket;
            f.zS(false);
        }
        AppMethodBeat.o(124384);
    }

    private b beO(String str) {
        AppMethodBeat.i(124385);
        Log.i("MicroMsg.ChattingBizImgDownloader", "alvinluo tryToGetNormalImage after get WxPic failed");
        b beN = beN(str);
        AppMethodBeat.o(124385);
        return beN;
    }
}
