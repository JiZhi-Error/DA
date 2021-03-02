package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/WebViewTeenModeInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "isHostAllow", "", "host", "", "isHostBlock", "overrideStartLoadBefore", "url", "intent", "Landroid/content/Intent;", "Companion", "plugin-webview_release"})
public final class av extends k {
    private static final ArrayList<String> IZx = j.ac("weixin.qq.com", "inews.qq.com", "tenpay.com", "pay.weixin.qq.com", "payapp.weixin.qq.com", "wx.tenpay.com", "support.weixin.qq.com", "action.weixin.qq.com", "log.weixin.qq.com", "api.mch.weixin.qq.com", "act.weixin.qq.com", "res.wx.qq.com", "res2.wx.qq.com", "pingjs.qq.com", "badjs.weixinbridge.com", "mmbiz.qpic.cn", "wx.qlogo.cn", "wx.gtimg.com");
    private static final ArrayList<String> IZy = j.ac("game.weixin.qq.com");
    public static final a IZz = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/WebViewTeenModeInterceptor$Companion;", "", "()V", "BIZ_TEEN_MODE_ENABLE_CHECK", "", "TAG", "", "allowDomainList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "blockDomainList", "addAllowList", "", "configString", "addBlockList", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static void aYU(String str) {
            AppMethodBeat.i(210359);
            for (T t : n.a(str, new String[]{";"})) {
                if ((t.length() > 0) && !av.IZx.contains(t)) {
                    av.IZx.add(t);
                }
            }
            AppMethodBeat.o(210359);
        }

        static void aYV(String str) {
            AppMethodBeat.i(210360);
            for (T t : n.a(str, new String[]{";"})) {
                if ((t.length() > 0) && !av.IZy.contains(t)) {
                    av.IZy.add(t);
                }
            }
            AppMethodBeat.o(210360);
        }
    }

    static {
        AppMethodBeat.i(210364);
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_teen_mode_h5_domain_allow_list_1, "");
        p.g(a2, "allowConfig1");
        a.aYU(a2);
        String a3 = ((b) g.af(b.class)).a(b.a.clicfg_teen_mode_h5_domain_allow_list_2, "");
        p.g(a3, "allowConfig2");
        a.aYU(a3);
        String a4 = ((b) g.af(b.class)).a(b.a.clicfg_teen_mode_h5_domain_block_list_1, "");
        p.g(a4, "blockConfig1");
        a.aYV(a4);
        String a5 = ((b) g.af(b.class)).a(b.a.clicfg_teen_mode_h5_domain_block_list_2, "");
        p.g(a5, "blockConfig2");
        a.aYV(a5);
        Log.i("MicroMsg.WebViewTeenModeInterceptor", "alvinluo initWebViewTeenModeInterceptor blockList size: %d, %s, allowList size: %d, %s", Integer.valueOf(IZy.size()), IZy, Integer.valueOf(IZx.size()), IZx);
        AppMethodBeat.o(210364);
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean e(String str, Intent intent) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(210361);
        p.h(str, "url");
        if (intent != null) {
            try {
                z = intent.getBooleanExtra("key_enable_teen_mode_check", false);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebViewTeenModeInterceptor", e2, "overrideStartLoadBefore get enableTeenModeCheck exception", new Object[0]);
                z = false;
            }
        } else {
            z = false;
        }
        if (!z) {
            Log.d("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore not enableTeenModeCheck");
            AppMethodBeat.o(210361);
            return false;
        }
        com.tencent.mm.kernel.c.a af = g.af(q.class);
        p.g(af, "MMKernel.service(IBizTeenModeService::class.java)");
        boolean Vt = ((q) af).Vt();
        Log.d("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore url: %s, isTeenMode: %s", str, Boolean.valueOf(Vt));
        if (!Vt) {
            AppMethodBeat.o(210361);
            return false;
        }
        Uri parse = Uri.parse(str);
        p.g(parse, ShareConstants.MEDIA_URI);
        String host = parse.getHost();
        String str2 = host;
        if (str2 == null || str2.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(210361);
            return false;
        }
        Log.i("MicroMsg.WebViewTeenModeInterceptor", "overrideStartLoadBefore host: %s, allow: %b, block: %b", host, Boolean.valueOf(aYT(host)), Boolean.valueOf(aYS(host)));
        if (!aYT(host) || aYS(host)) {
            BaseWebViewController.a(getController(), "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode", true, 0, 4);
            AppMethodBeat.o(210361);
            return true;
        }
        AppMethodBeat.o(210361);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean aYS(java.lang.String r4) {
        /*
            r3 = 210362(0x335ba, float:2.9478E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.ArrayList<java.lang.String> r0 = com.tencent.mm.plugin.webview.model.av.IZy
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r1 = r0.iterator()
        L_0x000e:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0036
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = kotlin.g.b.p.j(r4, r0)
            if (r2 != 0) goto L_0x0031
            java.lang.String r2 = "."
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r2.concat(r0)
            boolean r0 = kotlin.n.n.nm(r4, r0)
            if (r0 == 0) goto L_0x000e
        L_0x0031:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0035:
            return r0
        L_0x0036:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.model.av.aYS(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean aYT(java.lang.String r4) {
        /*
            r3 = 210363(0x335bb, float:2.94781E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.ArrayList<java.lang.String> r0 = com.tencent.mm.plugin.webview.model.av.IZx
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r1 = r0.iterator()
        L_0x000e:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0036
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = kotlin.g.b.p.j(r4, r0)
            if (r2 != 0) goto L_0x0031
            java.lang.String r2 = "."
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r2.concat(r0)
            boolean r0 = kotlin.n.n.nm(r4, r0)
            if (r0 == 0) goto L_0x000e
        L_0x0031:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0035:
            return r0
        L_0x0036:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.model.av.aYT(java.lang.String):boolean");
    }
}
