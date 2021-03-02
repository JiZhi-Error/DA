package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003*\u0002\u0005\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u001a\u0010\u0014\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0014\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "scanBeforeA8KeyListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1;", "wxaQRScanSheetPreloadListener", "com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1;", "canSyncWxaUsername", "", ch.COL_USERNAME, "", "checkIfWaitWxaAttrsPreloadDone", "block", "Lkotlin/Function0;", "", "onRegister", "onUnregister", "triggerPreDownload", "scene", "", "appId", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchMallIndexWeAppV2", "prefetchUsernameList", "", "triggerPrefetchWeAppQRCode", "Companion", "plugin-appbrand-integration_release"})
public final class d implements com.tencent.mm.kernel.c.b, w {
    @Deprecated
    public static final a kPb = new a((byte) 0);
    private final C0552d kOZ = new C0552d(this);
    private final b kPa = new b();

    static {
        AppMethodBeat.i(180434);
        AppMethodBeat.o(180434);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$Companion;", "", "()V", "PRE_FETCH_DATA_MONITOR_ID", "", "PRE_FETCH_DATA_MONITOR_KEY_CHATTING_ITEM", "PRE_FETCH_DATA_MONITOR_KEY_MALL_INDEX", "PRE_FETCH_DATA_MONITOR_KEY_QRCODE_LONG_PRESS_DETECT", "PRE_FETCH_DATA_MONITOR_KEY_WEISHI", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d() {
        AppMethodBeat.i(228016);
        AppMethodBeat.o(228016);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void bb(String str, int i2) {
        String[] strArr;
        AppMethodBeat.i(228009);
        String[] strArr2 = AppBrandGlobalSystemConfig.bzP().ldm;
        if (strArr2 == null) {
            strArr = new String[0];
        } else {
            strArr = strArr2;
        }
        for (String str2 : strArr) {
            String str3 = str2;
            if (!(str3 == null || str3.length() == 0) && str2.equals(str)) {
                Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "username[" + str + "] blacklist, just return");
                AppMethodBeat.o(228009);
                return;
            }
        }
        c.a(new c(str, i2, 2), false, 3);
        AppMethodBeat.o(228009);
    }

    static boolean VB(String str) {
        AppMethodBeat.i(228010);
        String str2 = str;
        if ((str2 == null || str2.length() == 0) || !as.HF(str) || !aa.XB(str)) {
            AppMethodBeat.o(228010);
            return false;
        }
        AppMethodBeat.o(228010);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void bg(List<String> list) {
        AppMethodBeat.i(228011);
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                try {
                    String queryParameter = Uri.parse(str).getQueryParameter(ch.COL_USERNAME);
                    if (VB(queryParameter)) {
                        if (queryParameter == null) {
                            p.hyc();
                        }
                        linkedList.add(queryParameter);
                    }
                } catch (Throwable th) {
                }
            }
        }
        if (linkedList.size() > 0) {
            h.INSTANCE.dN(1342, 1);
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_prefetch_weapp_data_mall_index_functions, BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED)) {
                Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppLinks list.size:" + linkedList.size());
                h hVar = h.kPo;
                h.a(linkedList, o.a.WALLET_MALL_INDEX);
            }
        }
        AppMethodBeat.o(228011);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void bh(List<String> list) {
        boolean z = false;
        AppMethodBeat.i(228012);
        if (!(list.isEmpty())) {
            h.INSTANCE.dN(1342, 1);
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
                z = true;
            }
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_prefetch_weapp_data_mall_index_functions, z)) {
                Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchMallIndexWeAppV2 list.size:" + list.size());
                h hVar = h.kPo;
                h.a(list, o.a.WALLET_MALL_INDEX);
            }
        }
        AppMethodBeat.o(228012);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void VA(String str) {
        AppMethodBeat.i(228013);
        if (!VB(str)) {
            AppMethodBeat.o(228013);
            return;
        }
        h.INSTANCE.dN(1342, 2);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_prefetch_weapp_data_chat_item, false)) {
            Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemAppBrandPiece username:".concat(String.valueOf(str)));
            h hVar = h.kPo;
            if (str == null) {
                p.hyc();
            }
            h.a(j.listOf(str), o.a.CHATTING);
        }
        AppMethodBeat.o(228013);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void bwL() {
        AppMethodBeat.i(180433);
        if (!VB("gh_8c10d2f0f25e@app")) {
            AppMethodBeat.o(180433);
            return;
        }
        h.INSTANCE.dN(1342, 4);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_prefetch_weapp_data_weishi_chat_item, false)) {
            Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchChattingItemWeishiVideoFakeNative");
            h hVar = h.kPo;
            h.a(j.listOf("gh_8c10d2f0f25e@app"), o.a.CHATTING);
        }
        AppMethodBeat.o(180433);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$wxaQRScanSheetPreloadListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeSheetPreloadWxaAttrs;", "callback", "", "event", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.d$d  reason: collision with other inner class name */
    public static final class C0552d extends IListener<com.tencent.mm.plugin.scanner.b> {
        final /* synthetic */ d kPe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0552d(d dVar) {
            this.kPe = dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.plugin.scanner.b bVar) {
            String str;
            AppMethodBeat.i(228008);
            com.tencent.mm.plugin.scanner.b bVar2 = bVar;
            if (!(bVar2 == null || (str = bVar2.username) == null || !d.VB(str))) {
                h.INSTANCE.dN(1342, 3);
                if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_prefetch_weapp_data_qrcode_detect, false)) {
                    long nowMilliSecond = Util.nowMilliSecond();
                    Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchWeAppQRCode username:" + str + ", timestamp:" + nowMilliSecond);
                    h hVar = h.kPo;
                    if (str == null) {
                        p.hyc();
                    }
                    h.a(j.listOf(str), o.a.QRCODE, new c(str, nowMilliSecond));
                }
            }
            AppMethodBeat.o(228008);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportImpl$scanBeforeA8KeyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/scanner/EventScanCodeTryPreloadWxaAttrsBeforeA8Key;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class b extends IListener<com.tencent.mm.plugin.scanner.c> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
            if (r0 != false) goto L_0x007e;
         */
        @Override // com.tencent.mm.sdk.event.IListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean callback(com.tencent.mm.plugin.scanner.c r8) {
            /*
            // Method dump skipped, instructions count: 202
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.predownload.d.b.callback(com.tencent.mm.sdk.event.IEvent):boolean");
        }
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(228014);
        this.kOZ.alive();
        this.kPa.alive();
        AppMethodBeat.o(228014);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        AppMethodBeat.i(228015);
        this.kOZ.dead();
        this.kPa.dead();
        AppMethodBeat.o(228015);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String hLl;
        final /* synthetic */ long kPc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, long j2) {
            super(0);
            this.hLl = str;
            this.kPc = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(228007);
            com.tencent.mm.ac.d.i(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.d.c.AnonymousClass1 */
                final /* synthetic */ c kPd;

                {
                    this.kPd = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(228006);
                    WxaAttributes d2 = n.buC().d(this.kPd.hLl, "appInfo");
                    WxaAttributes.a bAn = d2 != null ? d2.bAn() : null;
                    if (bAn != null) {
                        if (bAn.NA()) {
                            a unused = d.kPb;
                            Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchWeAppQRCode tryPreload WAGAME username:" + this.kPd.hLl + ", timestamp:" + this.kPd.kPc);
                            com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WAGAME, z.QRCODE_LONG_PRESS);
                        } else if (bAn.bAt()) {
                            a unused2 = d.kPb;
                            Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchWeAppQRCode tryPreload FAKE NATIVE username:" + this.kPd.hLl + ", timestamp:" + this.kPd.kPc);
                            com.tencent.mm.plugin.appbrand.task.h.bWb().e(z.QRCODE_LONG_PRESS);
                        } else {
                            a unused3 = d.kPb;
                            Log.i("MicroMsg.AppBrand.PreDownloadServiceExportImpl", "triggerPrefetchWeAppQRCode tryPreload WASERVICE username:" + this.kPd.hLl + ", timestamp:" + this.kPd.kPc);
                            com.tencent.mm.plugin.appbrand.task.h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.WASERVICE, z.QRCODE_LONG_PRESS);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(228006);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(228007);
            return xVar;
        }
    }
}
