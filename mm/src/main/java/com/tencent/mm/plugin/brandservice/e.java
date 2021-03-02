package com.tencent.mm.plugin.brandservice;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J#\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016JH\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0012H\u0016J\u001e\u0010%\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00152\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u0015H\u0016J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/WebPrefetchServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "()V", "TAG", "", "clearPrefetchContent", "", "url", "debugPreloadWebInfo", "", "(Ljava/lang/String;)[[Ljava/lang/String;", "getPreAuthUrl", "getPrefetchContentResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "getPrefetchResResp", "referer", "appId", "getReportScene", "", "getRespUrl", "getUrlCookie", "", "getWebId", "isDnsCached", "", "isEntranceOpen", "bit", "isUrlPreAuthed", "isWebUrlEqual", "rawUrl", "targetUrl", "preAuth", "openScene", "title", "desc", "from", "entranceBit", "preAuths", "auths", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PreAuthInfo;", "prefetchWebPage", "preAuthInfoList", "setUrlToScene", "scene", "plugin-brandservice_release"})
public final class e implements com.tencent.mm.plugin.brandservice.a.e {
    private final String TAG = "MicroMsg.WebPrefetchServiceImpl";

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0086  */
    @Override // com.tencent.mm.plugin.brandservice.a.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean fd(java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.e.fd(java.lang.String, java.lang.String):boolean");
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final boolean ahB(String str) {
        AppMethodBeat.i(195111);
        if (str != null) {
            v vVar = v.pDG;
            boolean ahB = v.ahB(str);
            AppMethodBeat.o(195111);
            return ahB;
        }
        AppMethodBeat.o(195111);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r0 == null) goto L_0x001f;
     */
    @Override // com.tencent.mm.plugin.brandservice.a.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String ahC(java.lang.String r3) {
        /*
            r2 = this;
            r1 = 195112(0x2fa28, float:2.7341E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            if (r3 == 0) goto L_0x001f
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.v r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.pDG
            java.lang.String r0 = "url"
            kotlin.g.b.p.h(r3, r0)
            com.tencent.mm.protocal.protobuf.fak r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.aiq(r3)
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = r0.pFJ
            if (r0 != 0) goto L_0x001d
        L_0x001a:
            java.lang.String r0 = ""
        L_0x001d:
            if (r0 != 0) goto L_0x0022
        L_0x001f:
            java.lang.String r0 = ""
        L_0x0022:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.e.ahC(java.lang.String):java.lang.String");
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final boolean ahD(String str) {
        AppMethodBeat.i(195113);
        if (str != null) {
            if (!(n.aL(str))) {
                Uri parse = Uri.parse(str);
                p.g(parse, "Uri.parse(url)");
                String host = parse.getHost();
                if (host != null) {
                    c.a aVar = c.pmm;
                    MMCacheSlotManager mMCacheSlotManager = c.pml;
                    p.g(host, LocaleUtil.ITALIAN);
                    boolean contains = mMCacheSlotManager.contains(host);
                    AppMethodBeat.o(195113);
                    return contains;
                }
            }
        }
        AppMethodBeat.o(195113);
        return false;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final void cF(String str, int i2) {
        AppMethodBeat.i(195114);
        p.h(str, "url");
        v vVar = v.pDG;
        v.cK(str, i2);
        AppMethodBeat.o(195114);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final int ahE(String str) {
        AppMethodBeat.i(195115);
        v vVar = v.pDG;
        int ahE = v.ahE(str);
        AppMethodBeat.o(195115);
        return ahE;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final e.b ahF(String str) {
        AppMethodBeat.i(195116);
        p.h(str, "url");
        v vVar = v.pDG;
        e.b ahF = v.ahF(str);
        AppMethodBeat.o(195116);
        return ahF;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final e.b R(String str, String str2, String str3) {
        AppMethodBeat.i(195117);
        p.h(str, "referer");
        p.h(str2, "url");
        v vVar = v.pDG;
        e.b R = v.R(str, str2, str3);
        AppMethodBeat.o(195117);
        return R;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final void ahG(String str) {
        AppMethodBeat.i(195118);
        p.h(str, "url");
        v vVar = v.pDG;
        v.ahG(str);
        AppMethodBeat.o(195118);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final String ahH(String str) {
        AppMethodBeat.i(195119);
        p.h(str, "url");
        String ahY = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahY(str);
        AppMethodBeat.o(195119);
        return ahY;
    }

    private boolean aC(int i2, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(195120);
        boolean z3 = (((b) g.af(b.class)).a(b.a.clicfg_webview_async_entrance, 65531) & i2) > 0;
        if (!z3 && i2 == 4) {
            String str2 = str;
            if (str2 == null || n.aL(str2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                try {
                    Uri parse = Uri.parse(str);
                    p.g(parse, "Uri.parse(url)");
                    z = p.j(parse.getHost(), "wzq.tenpay.com");
                } catch (Exception e2) {
                    Log.e(this.TAG, "isEntranceOpen ex=" + e2.getMessage());
                }
                AppMethodBeat.o(195120);
                return z;
            }
        }
        z = z3;
        AppMethodBeat.o(195120);
        return z;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final void a(String str, int i2, String str2, String str3, String str4, String str5, int i3) {
        String str6;
        String str7;
        String str8;
        AppMethodBeat.i(195121);
        p.h(str, "url");
        com.tencent.mm.plugin.webview.i.b.a(i2, str, true, false, false, false, false, 240);
        v vVar = v.pDG;
        v.Dy(i3);
        if (!aC(i3, str)) {
            Log.v(this.TAG, "[TRACE_PREFETCH] preAuth isEntranceOpen false, entranceBit = ".concat(String.valueOf(i3)));
            AppMethodBeat.o(195121);
        } else if (UrlExKt.isMpUrl(str) || (n.a((CharSequence) str, (CharSequence) ":", false) && !n.J(str, "http", false))) {
            AppMethodBeat.o(195121);
        } else {
            String ahW = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW(str);
            c.a aVar = c.pmm;
            if (c.pmk.contains(ahW)) {
                v vVar2 = v.pDG;
                if (!v.cou()) {
                    AppMethodBeat.o(195121);
                    return;
                }
            }
            c.a aVar2 = c.pmm;
            c.pmk.add(ahW);
            Log.v(this.TAG, "preauth: ".concat(String.valueOf(ahW)));
            if (str2 == null) {
                str6 = "";
            } else {
                str6 = str2;
            }
            if (str3 == null) {
                str7 = "";
            } else {
                str7 = str3;
            }
            if (str4 == null) {
                str8 = "";
            } else {
                str8 = str4;
            }
            v.a(str, str6, str7, str8, str5, i2);
            AppMethodBeat.o(195121);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0079, code lost:
        if (kotlin.n.n.J(r1, "http", false) == false) goto L_0x007b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a A[SYNTHETIC] */
    @Override // com.tencent.mm.plugin.brandservice.a.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(java.util.List<? extends com.tencent.mm.plugin.brandservice.a.e.a> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.e.m(java.util.List, int):void");
    }

    @Override // com.tencent.mm.plugin.brandservice.a.e
    public final void cu(List<? extends e.a> list) {
        boolean z;
        AppMethodBeat.i(195123);
        p.h(list, "preAuthInfoList");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            b bVar = (b) g.af(b.class);
            Log.i(this.TAG, "prefetchWebPage, scene: " + t2.pmM);
            switch (t2.pmM) {
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5 /*{ENCODED_INT: 175}*/:
                    z = bVar.a(b.a.clicfg_webview_prefetch_api_wechat_pay_open, 1) == 1;
                    Log.i(this.TAG, "clicfg_webview_prefetch_api_wechat_pay_open:".concat(String.valueOf(z)));
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 /*{ENCODED_INT: 176}*/:
                    z = bVar.a(b.a.clicfg_webview_prefetch_api_web_open, 1) == 1;
                    Log.i(this.TAG, "clicfg_webview_prefetch_api_web_open:".concat(String.valueOf(z)));
                    break;
                case TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING /*{ENCODED_INT: 177}*/:
                    z = bVar.a(b.a.clicfg_webview_prefetch_api_app_brand_open, 1) == 1;
                    Log.i(this.TAG, "clicfg_webview_prefetch_api_app_brand_open:".concat(String.valueOf(z)));
                    break;
                case 181:
                    z = bVar.a(b.a.clicfg_webview_prefetch_api_sns_ad_open, 1) == 1;
                    Log.i(this.TAG, "clicfg_webview_prefetch_api_sns_ad_open:".concat(String.valueOf(z)));
                    break;
                case TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR /*{ENCODED_INT: 998}*/:
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        ArrayList<e.a> arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            Log.e(this.TAG, "result is null after filter");
            AppMethodBeat.o(195123);
            return;
        }
        for (e.a aVar : arrayList2) {
            String str = aVar.url;
            p.g(str, "it.url");
            cF(str, aVar.pmM);
            int i2 = aVar.pmM;
            String str2 = aVar.url;
            p.g(str2, "it.url");
            com.tencent.mm.plugin.webview.i.b.a(i2, str2, true, false, false, false, false, 240);
        }
        for (e.a aVar2 : arrayList2) {
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.e eVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.pAN;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.F(aVar2.url, -1, aVar2.extInfo);
        }
        v.cF(arrayList2);
        AppMethodBeat.o(195123);
    }
}
