package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import android.view.View;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.video.b;
import com.tencent.mm.plugin.webview.ui.tools.video.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u0016J\u0017\u0010#\u001a\u0004\u0018\u00010\u00162\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%¢\u0006\u0002\u0010&J\u0006\u0010(\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020\u0016J\u0012\u0010*\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0003J\u001a\u0010-\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/IWebViewUIProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "activityLifecycleCallbacks", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "kotlin.jvm.PlatformType", "", "getContext", "()Landroid/content/Context;", "setContext", "webViewFullscreenImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "getWebViewFullscreenImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;", "setWebViewFullscreenImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenImpl;)V", "addFullScreenListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "addWebViewLifeCycleCallback", "callback", "exitFullScreen", "", "force", UserDataStore.CITY, "getWebViewPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "isInFullScreen", "onDestroy", "onKeyBoardHide", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)Lkotlin/Unit;", "onKeyBoardShow", "onPause", "onResume", "removeFullScreenListener", "removeWebViewLifeCycleCallback", "resetContext", "webviewEnterFullscreen", "view", "Landroid/view/View;", TencentLocation.EXTRA_DIRECTION, "", "webviewExitFullscreen", "plugin-webview_release"})
public final class h implements e {
    private final Set<a.AbstractC0188a> JxU = Collections.newSetFromMap(new ConcurrentHashMap());
    public b JxV;
    private final String TAG = "MicroMsg.WebViewUIProxyImpl";
    public Context context;

    public h(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(210697);
        this.context = context2;
        AppMethodBeat.o(210697);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.d
    public final synchronized void c(a.AbstractC0188a aVar) {
        AppMethodBeat.i(210685);
        p.h(aVar, "callback");
        if (!this.JxU.contains(aVar)) {
            this.JxU.add(aVar);
        }
        AppMethodBeat.o(210685);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.d
    public final synchronized void d(a.AbstractC0188a aVar) {
        AppMethodBeat.i(210686);
        p.h(aVar, "callback");
        this.JxU.remove(aVar);
        AppMethodBeat.o(210686);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.c
    public final void b(c cVar) {
        AppMethodBeat.i(210687);
        hX(this.context).d(cVar);
        AppMethodBeat.o(210687);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.c
    public final void a(c cVar) {
        AppMethodBeat.i(210688);
        hX(this.context).c(cVar);
        AppMethodBeat.o(210688);
    }

    public final synchronized void onResume() {
        AppMethodBeat.i(210689);
        for (a.AbstractC0188a aVar : this.JxU) {
            aVar.onForeground();
        }
        AppMethodBeat.o(210689);
    }

    public final synchronized void onPause() {
        AppMethodBeat.i(210690);
        for (a.AbstractC0188a aVar : this.JxU) {
            aVar.hU(0);
        }
        AppMethodBeat.o(210690);
    }

    public final synchronized void onDestroy() {
        AppMethodBeat.i(210691);
        try {
            for (a.AbstractC0188a aVar : this.JxU) {
                aVar.onDestroy();
            }
        } catch (Exception e2) {
            Log.e(this.TAG, "onDestroy ex " + e2.getMessage());
        }
        this.JxU.clear();
        b bVar = this.JxV;
        if (bVar != null) {
            bVar.release();
            AppMethodBeat.o(210691);
        } else {
            AppMethodBeat.o(210691);
        }
    }

    private final b hX(Context context2) {
        AppMethodBeat.i(210692);
        if (this.JxV == null) {
            this.JxV = new b(context2);
        }
        b bVar = this.JxV;
        if (bVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(210692);
        return bVar;
    }

    public final boolean zs(boolean z) {
        AppMethodBeat.i(210693);
        if (this.JxV != null) {
            b bVar = this.JxV;
            if (bVar == null) {
                p.hyc();
            }
            if (bVar.bJb()) {
                try {
                    boolean zr = hX(this.context).zr(z);
                    AppMethodBeat.o(210693);
                    return zr;
                } catch (Exception e2) {
                    Log.e(this.TAG, "exitFullScreen ex=" + e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(210693);
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b
    public final void aB(View view, int i2) {
        AppMethodBeat.i(210694);
        hX(this.context).N(view, i2);
        AppMethodBeat.o(210694);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b
    public final boolean gfl() {
        AppMethodBeat.i(210695);
        boolean zr = hX(this.context).zr(false);
        AppMethodBeat.o(210695);
        return zr;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.video.samelayer.a
    public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy() {
        return null;
    }

    public final boolean bJb() {
        AppMethodBeat.i(210696);
        b bVar = this.JxV;
        if (bVar != null) {
            boolean bJb = bVar.bJb();
            AppMethodBeat.o(210696);
            return bJb;
        }
        AppMethodBeat.o(210696);
        return false;
    }
}
