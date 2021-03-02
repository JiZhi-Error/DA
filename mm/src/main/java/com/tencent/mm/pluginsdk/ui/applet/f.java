package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rJ(\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDownloadReporter;", "", "()V", "TAG", "", "reportDownloadImageType", "", "requestImageType", "", "responseContentType", "reportDownloadResult", "imageType", "success", "", "reportDownloadTime", DownloadInfo.CONTENTTYPE, "downloadTime", "", "reportImageDecodeResult", "reportImageDecodeTime", "decodeTime", "reportImageRequestResult", "reportImageRequestTime", "requestTime", "reportRequestDownload", "reportRequestDownloadByImageType", "reportRequestImageDecode", "reportRequestNormalAfterGetWxPicFailed", "reportRequestNormalResultAfterGetWxPicFailed", "reportWxPicDataValid", "valid", "reportWxPicDecodeFailed", "url", "type", "errCode", "fromScene", "WxPicDecodeErrCode", "plugin-biz_release"})
public final class f {
    public static final f Ket = new f();

    static {
        AppMethodBeat.i(124852);
        AppMethodBeat.o(124852);
    }

    private f() {
    }

    public static void gph() {
        AppMethodBeat.i(124839);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestDownload");
        h.INSTANCE.n(1111, 0, 1);
        AppMethodBeat.o(124839);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void aid(int i2) {
        AppMethodBeat.i(124840);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestDownloadByImageType imageType: %d", Integer.valueOf(i2));
        switch (i2) {
            case 0:
                h.INSTANCE.n(1111, 1, 1);
                AppMethodBeat.o(124840);
                return;
            case 1:
                h.INSTANCE.n(1111, 2, 1);
                AppMethodBeat.o(124840);
                return;
            case 2:
                h.INSTANCE.n(1111, 31, 1);
                break;
        }
        AppMethodBeat.o(124840);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void bw(int i2, boolean z) {
        AppMethodBeat.i(124841);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadResult imageType: %d, success: %b", Integer.valueOf(i2), Boolean.valueOf(z));
        switch (i2) {
            case 0:
                h.INSTANCE.n(1111, z ? 3 : 4, 1);
                AppMethodBeat.o(124841);
                return;
            case 1:
                h.INSTANCE.n(1111, z ? 5 : 6, 1);
                AppMethodBeat.o(124841);
                return;
            case 2:
                h.INSTANCE.n(1111, z ? 32 : 33, 1);
                break;
        }
        AppMethodBeat.o(124841);
    }

    public static void zS(boolean z) {
        AppMethodBeat.i(124842);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportWxPicDataValid valid: %b", Boolean.valueOf(z));
        h.INSTANCE.n(1111, z ? 9 : 10, 1);
        AppMethodBeat.o(124842);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void beH(String str) {
        AppMethodBeat.i(124843);
        g gVar = g.Kev;
        int beL = g.beL(str);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestImageDecode contentType: %s, imageType: %d", str, Integer.valueOf(beL));
        switch (beL) {
            case 0:
                h.INSTANCE.n(1111, 47, 1);
                AppMethodBeat.o(124843);
                return;
            case 1:
                h.INSTANCE.n(1111, 11, 1);
                AppMethodBeat.o(124843);
                return;
            case 2:
                h.INSTANCE.n(1111, 43, 1);
                break;
        }
        AppMethodBeat.o(124843);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void da(String str, boolean z) {
        AppMethodBeat.i(124844);
        g gVar = g.Kev;
        int beL = g.beL(str);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportImageDecodeResult contentType: %s, imageType: %d, success: %b", str, Integer.valueOf(beL), Boolean.valueOf(z));
        switch (beL) {
            case 0:
                h.INSTANCE.n(1111, z ? 48 : 49, 1);
                AppMethodBeat.o(124844);
                return;
            case 1:
                h.INSTANCE.n(1111, z ? 12 : 13, 1);
                AppMethodBeat.o(124844);
                return;
            case 2:
                h.INSTANCE.n(1111, z ? 44 : 45, 1);
                break;
        }
        AppMethodBeat.o(124844);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void aie(int i2) {
        AppMethodBeat.i(124845);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestNormalAfterGetWxPicFailed requestImageType: %d", Integer.valueOf(i2));
        switch (i2) {
            case 0:
                h.INSTANCE.n(1111, 14, 1);
                AppMethodBeat.o(124845);
                return;
            case 2:
                h.INSTANCE.n(1111, 40, 1);
                break;
        }
        AppMethodBeat.o(124845);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void bx(int i2, boolean z) {
        AppMethodBeat.i(124846);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportRequestNormalResultAfterGetWxPicFailed requestImageType: %d, success: %b", Integer.valueOf(i2), Boolean.valueOf(z));
        switch (i2) {
            case 0:
                h.INSTANCE.n(1111, z ? 22 : 23, 1);
                AppMethodBeat.o(124846);
                return;
            case 2:
                h.INSTANCE.n(1111, z ? 41 : 42, 1);
                break;
        }
        AppMethodBeat.o(124846);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(int i2, boolean z, long j2) {
        AppMethodBeat.i(124847);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo requestImageRequestTime imageType: %d, success: %b, requestTime: %d", Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2));
        switch (i2) {
            case 0:
                h.INSTANCE.n(1111, z ? 15 : 24, j2);
                AppMethodBeat.o(124847);
                return;
            case 1:
                h.INSTANCE.n(1111, z ? 16 : 25, j2);
                AppMethodBeat.o(124847);
                return;
            case 2:
                h.INSTANCE.n(1111, z ? 34 : 35, j2);
                break;
        }
        AppMethodBeat.o(124847);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void by(int i2, boolean z) {
        AppMethodBeat.i(124848);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo requestImageRequestResult imageType: %d, success: %b", Integer.valueOf(i2), Boolean.valueOf(z));
        switch (i2) {
            case 0:
                h.INSTANCE.n(1111, z ? 26 : 28, 1);
                AppMethodBeat.o(124848);
                return;
            case 1:
                h.INSTANCE.n(1111, z ? 27 : 29, 1);
                AppMethodBeat.o(124848);
                return;
            case 2:
                h.INSTANCE.n(1111, z ? 38 : 39, 1);
                break;
        }
        AppMethodBeat.o(124848);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void bR(String str, long j2) {
        AppMethodBeat.i(124849);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadTime contentType: %s, downloadTime: %d", str, Long.valueOf(j2));
        if (j2 < 0) {
            AppMethodBeat.o(124849);
            return;
        }
        g gVar = g.Kev;
        switch (g.beL(str)) {
            case 0:
                h.INSTANCE.n(1111, 18, j2);
                AppMethodBeat.o(124849);
                return;
            case 1:
                h.INSTANCE.n(1111, 20, j2);
                AppMethodBeat.o(124849);
                return;
            case 2:
                h.INSTANCE.n(1111, 37, j2);
                break;
        }
        AppMethodBeat.o(124849);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void bS(String str, long j2) {
        AppMethodBeat.i(124850);
        if (j2 < 0) {
            AppMethodBeat.o(124850);
            return;
        }
        g gVar = g.Kev;
        int beL = g.beL(str);
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportImageDecodeTime contentType: %s, imageType: %d, decodeTime: %d", str, Integer.valueOf(beL), Long.valueOf(j2));
        switch (beL) {
            case 0:
                h.INSTANCE.n(1111, 50, j2);
                AppMethodBeat.o(124850);
                return;
            case 1:
                h.INSTANCE.n(1111, 21, j2);
                AppMethodBeat.o(124850);
                return;
            case 2:
                h.INSTANCE.n(1111, 46, j2);
                break;
        }
        AppMethodBeat.o(124850);
    }

    public static void aL(String str, int i2, int i3) {
        AppMethodBeat.i(124851);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(124851);
        } else if (i3 == 1 || i3 == 2 || i3 == 3) {
            Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportWxPicDecodeFailed type: %d, errCode: %d, fromScene: %d", 2, Integer.valueOf(i2), Integer.valueOf(i3));
            h.INSTANCE.a(17492, str, 2, Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(124851);
        } else {
            AppMethodBeat.o(124851);
        }
    }
}
