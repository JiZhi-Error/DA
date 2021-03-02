package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/TopStoryWebViewVisitReporter;", "Lcom/tencent/mm/plugin/webview/model/IWebviewReporter;", "()V", "enterTime", "", "getEnterTime", "()J", "lastResumeTime", "maxScrollY", "", "publishId", "", "scene", "stayTime", "totalScrollY", "onPause", "", "onResume", "report", "setMaxScrollY", "setPublishId", "setScene", "setTotalScrollY", "plugin-webview_release"})
public final class ak {
    public int EOU = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
    public int IZc = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
    public long dUy;
    public final long enterTime = System.currentTimeMillis();
    public String iAh;
    public long lastResumeTime = -1;
    public int scene;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    public static final class a<InputType, ResultType> implements b<Bundle, IPCVoid> {
        public static final a IZd = new a();

        static {
            AppMethodBeat.i(210352);
            AppMethodBeat.o(210352);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, d<IPCVoid> dVar) {
            AppMethodBeat.i(210351);
            i.aTw(bundle.getString("reportString"));
            AppMethodBeat.o(210351);
        }
    }

    public ak() {
        AppMethodBeat.i(210353);
        AppMethodBeat.o(210353);
    }
}
