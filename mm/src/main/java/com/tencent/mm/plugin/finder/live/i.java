package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u0002XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/MiniProgramReceiver;", "Landroid/webkit/ValueCallback;", "", "pluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "appId", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getAppId", "setAppId", "(Ljava/lang/String;)V", "rPluginLayout", "Ljava/lang/ref/WeakReference;", "getRPluginLayout", "()Ljava/lang/ref/WeakReference;", "setRPluginLayout", "(Ljava/lang/ref/WeakReference;)V", "onReceiveValue", "", "value", "plugin-finder_release"})
public final class i implements ValueCallback<String> {
    final String TAG = "Finder.LiveMiniProgramReceiver";
    private String appId;
    private WeakReference<FinderBaseLivePluginLayout> ugd;

    public i(FinderBaseLivePluginLayout finderBaseLivePluginLayout, String str) {
        p.h(finderBaseLivePluginLayout, "pluginLayout");
        p.h(str, "appId");
        AppMethodBeat.i(245881);
        this.ugd = new WeakReference<>(finderBaseLivePluginLayout);
        this.appId = str;
        AppMethodBeat.o(245881);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        AppMethodBeat.i(245880);
        String str2 = str;
        Log.i(this.TAG, "onReceiveValue value".concat(String.valueOf(str2)));
        if (!Util.isNullOrNil(str2)) {
            WeakReference<FinderBaseLivePluginLayout> weakReference = this.ugd;
            FinderBaseLivePluginLayout finderBaseLivePluginLayout = weakReference != null ? weakReference.get() : null;
            if (finderBaseLivePluginLayout != null) {
                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i(str2);
                int optInt = iVar.optInt("scene");
                String optString = iVar.optString("appId");
                String optString2 = iVar.optString("path");
                iVar.optString("shopWindowId");
                switch (optInt) {
                    case 0:
                        m mVar = m.vVH;
                        FinderBaseLivePluginLayout finderBaseLivePluginLayout2 = m.dBP() & p.j(optString, this.appId) ? finderBaseLivePluginLayout : null;
                        if (finderBaseLivePluginLayout2 != null) {
                            b.C0376b.a(finderBaseLivePluginLayout2, b.c.hNc);
                            AppMethodBeat.o(245880);
                            return;
                        }
                        AppMethodBeat.o(245880);
                        return;
                    case 1:
                        h.RTc.n(new a(optString, optString2, this, finderBaseLivePluginLayout), 250);
                        break;
                }
            } else {
                Log.i(this.TAG, "pluginLayout is null!");
                AppMethodBeat.o(245880);
                return;
            }
        }
        AppMethodBeat.o(245880);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/MiniProgramReceiver$onReceiveValue$1$2"})
    static final class a implements Runnable {
        final /* synthetic */ String kPQ;
        final /* synthetic */ String mXY;
        final /* synthetic */ i uge;
        final /* synthetic */ FinderBaseLivePluginLayout ugf;

        a(String str, String str2, i iVar, FinderBaseLivePluginLayout finderBaseLivePluginLayout) {
            this.kPQ = str;
            this.mXY = str2;
            this.uge = iVar;
            this.ugf = finderBaseLivePluginLayout;
        }

        public final void run() {
            AppMethodBeat.i(245879);
            g gVar = new g();
            gVar.appId = this.kPQ;
            gVar.kHw = this.mXY;
            m mVar = m.vVH;
            gVar.scene = m.dBP() ? 1176 : 1177;
            s finderLiveAssistant = this.ugf.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                Context context = this.ugf.getContext();
                p.g(context, "pluginLayout.context");
                finderLiveAssistant.a(context, gVar, false);
                AppMethodBeat.o(245879);
                return;
            }
            Log.i(this.uge.TAG, "finderLiveAssistant is null!");
            AppMethodBeat.o(245879);
        }
    }
}
