package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewThirdAdReporter;", "", "()V", "TAG", "", "TYPE_PAGE_LOAD_FINISHED", "", "TYPE_PAGE_LOAD_START", "errCode", "getErrCode", "()I", "setErrCode", "(I)V", "doThirdAdReport", "", "intent", "Landroid/content/Intent;", "url", "done", "", "plugin-webview_release"})
public final class n {
    public static final n JhS = new n();
    private static int errCode;

    static {
        AppMethodBeat.i(82544);
        AppMethodBeat.o(82544);
    }

    private n() {
    }

    public static void setErrCode(int i2) {
        errCode = i2;
    }

    public static void a(Intent intent, String str, boolean z) {
        String str2;
        AppMethodBeat.i(82543);
        p.h(str, "url");
        if (intent == null) {
            AppMethodBeat.o(82543);
            return;
        }
        Bundle bundle = (Bundle) intent.getParcelableExtra("ad_report_bundle");
        if (bundle != null && bundle.getBoolean("ad_need_report", false)) {
            Log.i("MicroMsg.WebViewThirdAdReporter", "adReportArgs is not null and isADReport is true");
            String string = bundle.getString("ad_report_ux_info");
            int i2 = bundle.getInt("ad_report_scene", 0);
            int i3 = bundle.getInt("ad_report_source", 0);
            String string2 = TextUtils.isEmpty(bundle.getString("ad_report_sns_id")) ? bundle.getString("ad_report_sns_id") : "";
            try {
                str2 = q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                p.g(str2, "URLEncoder.encode(url, \"UTF-8\")");
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.WebViewThirdAdReporter", "url encode error url = %s", str);
                str2 = "";
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = z ? 1 : 0;
            h.INSTANCE.a(16972, string2, Integer.valueOf(i2), string, Integer.valueOf(i3), "", str2, Integer.valueOf(i4), Integer.valueOf(errCode), Long.valueOf(currentTimeMillis));
            Log.i("MicroMsg.WebViewThirdAdReporter", "%s,%s,%s,%s,%s,%s,%s,%s,%s", string2, Integer.valueOf(i2), string, Integer.valueOf(i3), "", str2, Integer.valueOf(i4), Integer.valueOf(errCode), Long.valueOf(currentTimeMillis));
        }
        AppMethodBeat.o(82543);
    }
}
