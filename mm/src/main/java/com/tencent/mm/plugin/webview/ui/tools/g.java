package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqvideo.proxy.api.IUtils;
import java.util.ArrayList;

public final class g extends a implements IUtils {
    public g(WebViewUI webViewUI) {
        super(webViewUI);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.qqvideo.proxy.api.IUtils
    public final void javaUtilLog(int i2, String str, String str2) {
        AppMethodBeat.i(79799);
        switch (i2) {
            case 2:
                Log.v(str, str2);
                AppMethodBeat.o(79799);
                return;
            case 3:
                Log.d(str, str2);
                AppMethodBeat.o(79799);
                return;
            case 4:
                Log.i(str, str2);
                AppMethodBeat.o(79799);
                return;
            case 5:
                Log.w(str, str2);
                break;
            case 6:
                Log.e(str, str2);
                AppMethodBeat.o(79799);
                return;
        }
        AppMethodBeat.o(79799);
    }

    @Override // com.tencent.qqvideo.proxy.api.IUtils
    public final void httpproxyReport(String... strArr) {
        AppMethodBeat.i(79800);
        az.i gdi = geo().IMs.gdi();
        if (!(strArr == null || strArr.length == 0)) {
            if (gdi.Jal == null) {
                gdi.Jal = new ArrayList();
            } else {
                gdi.Jal.clear();
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                Log.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", strArr[i2]);
                gdi.Jal.add(strArr[i2]);
            }
        }
        az.i gdi2 = geo().IMs.gdi();
        if (gdi2.Jal == null || gdi2.Jal.size() == 0) {
            AppMethodBeat.o(79800);
            return;
        }
        h hVar = h.INSTANCE;
        h.r(12033, gdi2.Jal);
        gdi2.Jal.clear();
        AppMethodBeat.o(79800);
    }

    @Override // com.tencent.qqvideo.proxy.api.IUtils
    public final void idKeyReport(String str, String str2, String str3) {
        AppMethodBeat.i(79801);
        Log.i("MicroMsg.WebViewUI.UtilsImpl", "idkey report, id = %s, key = %s, value = %s", str, str2, str3);
        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2) && !Util.isNullOrNil(str3)) {
            h.INSTANCE.idkeyStat((long) Util.getInt(str, 0), (long) Util.getInt(str2, 0), (long) Util.getInt(str3, 0), false);
        }
        AppMethodBeat.o(79801);
    }

    @Override // com.tencent.qqvideo.proxy.api.IUtils
    public final void kvReport(String... strArr) {
        AppMethodBeat.i(79802);
        az.h gdj = geo().IMs.gdj();
        if (!(strArr == null || strArr.length == 0)) {
            if (gdj.Jal == null) {
                gdj.Jal = new ArrayList();
            } else {
                gdj.Jal.clear();
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                Log.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", strArr[i2]);
                gdj.Jal.add(strArr[i2]);
            }
        }
        az.h gdj2 = geo().IMs.gdj();
        if (gdj2.Jal == null || gdj2.Jal.size() == 0) {
            AppMethodBeat.o(79802);
            return;
        }
        h hVar = h.INSTANCE;
        h.r(12666, gdj2.Jal);
        gdj2.Jal.clear();
        AppMethodBeat.o(79802);
    }
}
