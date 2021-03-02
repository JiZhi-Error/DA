package com.tencent.mm.plugin.appbrand.jsapi.ag.e.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigInteger;

public final class a {
    public static final BigInteger mNl = BigInteger.valueOf(1024);
    public C0623a mNm = new C0623a();

    static {
        AppMethodBeat.i(139618);
        AppMethodBeat.o(139618);
    }

    public a() {
        AppMethodBeat.i(139616);
        AppMethodBeat.o(139616);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] mNn = new int[b.values().length];

        static {
            AppMethodBeat.i(215906);
            try {
                mNn[b.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mNn[b.EXTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mNn[b.EXTRACT_NOT_SUPPORT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                mNn[b.DECODE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                mNn[b.DECODE_NOT_SUPPORT.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                mNn[b.RENDER.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                mNn[b.ILLEGAL.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                mNn[b.OTHER.ordinal()] = 8;
                AppMethodBeat.o(215906);
            } catch (NoSuchFieldError e9) {
                AppMethodBeat.o(215906);
            }
        }
    }

    public static void a(e eVar, f.b bVar) {
        AppMethodBeat.i(215907);
        if (eVar != null) {
            if (bVar.mCy) {
                eVar.c(1234, 134, 1);
            }
            if (bVar.mCz) {
                eVar.c(1234, 135, 1);
            }
        }
        AppMethodBeat.o(215907);
    }

    public final void a(e eVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar, c cVar, String str) {
        String str2;
        int i2;
        int i3;
        AppMethodBeat.i(215908);
        if (this.mNm.mNr < this.mNm.mNq) {
            Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
            this.mNm.reset();
            AppMethodBeat.o(215908);
            return;
        }
        if (aVar != null) {
            str2 = aVar.getAppId();
        } else {
            str2 = "";
        }
        if (cVar instanceof f) {
            i2 = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a) cVar).bKD();
        } else {
            i2 = 0;
        }
        if (cVar instanceof f) {
            i3 = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a) cVar).bKE();
        } else {
            i3 = 0;
        }
        int bKF = cVar instanceof f ? ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a) cVar).bKF() : 0;
        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s", str, str2, Boolean.valueOf(j.bJE().mwX), Integer.valueOf(this.mNm.mEJ), Long.valueOf(this.mNm.mNo), this.mNm.videoPath, Long.valueOf(this.mNm.mNp), Long.valueOf(this.mNm.duration), Long.valueOf(this.mNm.mNs), Integer.valueOf(this.mNm.mNt), Long.valueOf(this.mNm.mNu), Integer.valueOf(this.mNm.mNz), Integer.valueOf(this.mNm.mNA), this.mNm.errorMsg, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bKF));
        Object[] objArr = new Object[21];
        objArr[0] = str2;
        objArr[1] = Integer.valueOf(this.mNm.mEJ);
        objArr[2] = this.mNm.videoPath;
        objArr[3] = Long.valueOf(this.mNm.mNs);
        objArr[4] = Long.valueOf(this.mNm.duration);
        objArr[5] = Long.valueOf(this.mNm.mNp);
        objArr[6] = Integer.valueOf(this.mNm.mNz);
        objArr[7] = Integer.valueOf(this.mNm.mNA);
        objArr[8] = this.mNm.errorMsg;
        objArr[9] = 1;
        objArr[10] = Integer.valueOf(j.bJE().mwX ? 1 : 0);
        objArr[11] = Integer.valueOf(this.mNm.mNt);
        objArr[12] = Long.valueOf(this.mNm.mNu);
        objArr[13] = Long.valueOf(this.mNm.mNo);
        objArr[14] = Long.valueOf(this.mNm.mNq);
        objArr[15] = Long.valueOf(this.mNm.mNr);
        objArr[16] = Long.valueOf(this.mNm.mNx);
        objArr[17] = Long.valueOf(this.mNm.mNy);
        objArr[18] = Integer.valueOf(i2);
        objArr[19] = Integer.valueOf(i3);
        objArr[20] = Integer.valueOf(bKF);
        eVar.e(objArr);
        this.mNm.reset();
        AppMethodBeat.o(215908);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a$a  reason: collision with other inner class name */
    public class C0623a {
        public long duration = 0;
        public String errorMsg = "";
        public int mEJ = 0;
        public int mNA = 0;
        public long mNo = 0;
        public long mNp = 0;
        public long mNq = 0;
        public long mNr = 0;
        public long mNs = 0;
        public int mNt = 0;
        public long mNu = 0;
        public long mNv = 0;
        public long mNw = 0;
        public long mNx = 0;
        public long mNy = 0;
        public int mNz = 0;
        public String videoPath = "";

        C0623a() {
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.videoPath = "";
            this.mEJ = 0;
            this.mNo = 0;
            this.duration = 0;
            this.mNp = 0;
            this.mNq = 0;
            this.mNr = 0;
            this.mNs = 0;
            this.mNt = 0;
            this.mNv = 0;
            this.mNw = 0;
            this.mNu = 0;
            this.mNx = 0;
            this.mNy = 0;
            this.mNz = 0;
            this.mNA = 0;
            this.errorMsg = "";
        }
    }
}
