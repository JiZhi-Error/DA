package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import org.xwalk.core.Log;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/webview/util/WebViewLongClickReportHelper;", "", "()V", "currentOpResult", "", "getCurrentOpResult", "()I", "setCurrentOpResult", "(I)V", "getA8KeyScene", "getGetA8KeyScene", "setGetA8KeyScene", "hasQrCode", "", "getHasQrCode", "()Z", "setHasQrCode", "(Z)V", "imageId", "", "getImageId", "()Ljava/lang/String;", "setImageId", "(Ljava/lang/String;)V", "opScene", "getOpScene", "setOpScene", "scanResult", "getScanResult", "setScanResult", "scanType", "getScanType", "setScanType", "startLongClickTime", "", "getStartLongClickTime", "()J", "setStartLongClickTime", "(J)V", "url", "getUrl", "setUrl", "initScanType", "", "codeType", "report", "opResult", "reset", "Companion", "webview-sdk_release"})
public final class i {
    public static final a JBH = new a((byte) 0);
    private static final String TAG = TAG;
    private long JBC;
    public boolean JBD;
    private int JBE;
    private String JBF = "";
    private int JBG = -1;
    public int ehX;
    public String scanResult = "";
    public String url = "";
    public String zfq = "";

    public final void reset(int i2) {
        AppMethodBeat.i(177334);
        this.JBE = i2;
        this.JBC = System.currentTimeMillis();
        AppMethodBeat.o(177334);
    }

    public final void ahn(int i2) {
        String str;
        if (i2 == 22) {
            str = "WX_CODE";
        } else {
            str = "QR_CODE";
        }
        this.JBF = str;
    }

    public final void pl(int i2) {
        int i3;
        AppMethodBeat.i(177335);
        if (this.JBG > 0) {
            AppMethodBeat.o(177335);
            return;
        }
        this.JBG = i2;
        long currentTimeMillis = System.currentTimeMillis() - this.JBC;
        if (currentTimeMillis < 0 || currentTimeMillis > Util.MILLSECONDS_OF_DAY) {
            currentTimeMillis = 0;
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[10];
        objArr[0] = z.bfG(this.url);
        objArr[1] = a.aie(this.url);
        if (this.JBD) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(this.ehX);
        objArr[4] = Integer.valueOf(this.JBE);
        objArr[5] = Long.valueOf(currentTimeMillis);
        objArr[6] = z.bfG(this.scanResult);
        objArr[7] = this.JBF;
        objArr[8] = Integer.valueOf(i2);
        objArr[9] = this.zfq;
        hVar.a(19208, objArr);
        AppMethodBeat.o(177335);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webview/util/WebViewLongClickReportHelper$Companion;", "", "()V", "TAG", "", "opResultCancel", "", "opResultFav", "opResultRecQrCode", "opResultSavePic", "opResultSendToFriend", "opResultTranslate", "getUrlId", "url", "webview-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String aie(String str) {
            AppMethodBeat.i(177333);
            if (str == null) {
                AppMethodBeat.o(177333);
                return "";
            }
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("__biz");
                long j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                int i2 = Util.getInt(parse.getQueryParameter("idx"), 0);
                if (Util.isNullOrNil(queryParameter) || j2 < 0) {
                    AppMethodBeat.o(177333);
                    return "";
                }
                String str2 = "id://local/i.html?__biz=" + queryParameter + "&mid=" + j2 + "&idx=" + i2;
                Log.d(i.TAG, "urlId=".concat(String.valueOf(str2)));
                AppMethodBeat.o(177333);
                return str2;
            } catch (Exception e2) {
                Log.e(i.TAG, "getUrlId ex " + e2.getMessage());
                AppMethodBeat.o(177333);
                return "";
            }
        }
    }

    static {
        AppMethodBeat.i(177336);
        AppMethodBeat.o(177336);
    }
}
