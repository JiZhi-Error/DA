package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004J\u001f\u0010\r\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000f\"\u00020\u0007¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/WebViewSnsAdReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "errCode", "", "loadReportInfo", "Ljava/util/ArrayList;", "", "snsAdClick", "Lcom/tencent/mm/modelsns/SnsAdClick;", "report", "", "setErrorCode", "setLoadReportInfo", "loadReports", "", "([Ljava/lang/String;)V", "setSnsAdClick", "adClick", "plugin-webview_release"})
public final class au {
    public SnsAdClick Bfh;
    private final ArrayList<String> IZv = new ArrayList<>();
    public int errCode;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    public static final class a<InputType, ResultType> implements b<Bundle, IPCVoid> {
        public static final a IZw = new a();

        static {
            AppMethodBeat.i(210355);
            AppMethodBeat.o(210355);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, d<IPCVoid> dVar) {
            boolean z;
            AppMethodBeat.i(210354);
            Bundle bundle2 = bundle;
            ArrayList<String> stringArrayList = bundle2.getStringArrayList("reportAdH5Load");
            if (stringArrayList != null) {
                p.g(stringArrayList, "reportInfo");
                if (!stringArrayList.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    rs rsVar = new rs();
                    rsVar.dYm.dYl = (SnsAdClick) bundle2.getParcelable("snsAdClick");
                    rsVar.dYm.url = q.encode(stringArrayList.get(0), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    rsVar.dYm.dYn = Util.safeParseInt(stringArrayList.get(1));
                    rsVar.dYm.timestamp = Util.safeParseLong(stringArrayList.get(2));
                    rsVar.dYm.uxInfo = stringArrayList.get(3);
                    rsVar.dYm.errorCode = bundle2.getInt("errCode", 0);
                    EventCenter.instance.publish(rsVar);
                }
                AppMethodBeat.o(210354);
                return;
            }
            AppMethodBeat.o(210354);
        }
    }

    public au() {
        AppMethodBeat.i(210358);
        AppMethodBeat.o(210358);
    }

    public final void U(String... strArr) {
        AppMethodBeat.i(210356);
        p.h(strArr, "loadReports");
        for (int i2 = 0; i2 < 4; i2++) {
            this.IZv.add(strArr[i2]);
        }
        AppMethodBeat.o(210356);
    }

    public final void report() {
        AppMethodBeat.i(210357);
        try {
            if (!this.IZv.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("reportAdH5Load", new ArrayList<>(this.IZv));
                bundle.putInt("errCode", this.errCode);
                bundle.putParcelable("snsAdClick", this.Bfh);
                h.a(MainProcessIPCService.dkO, bundle, a.IZw.getClass(), null);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebviewReporter", e2, "", new Object[0]);
        }
        this.Bfh = null;
        this.IZv.clear();
        AppMethodBeat.o(210357);
    }
}
