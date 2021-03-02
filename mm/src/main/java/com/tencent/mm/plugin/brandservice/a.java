package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.w;
import com.tencent.mm.vfs.s;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0012R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", ch.COL_USERNAME, "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    private static final String TAG = TAG;
    private static final String plZ = plZ;
    public static final C0860a pma = new C0860a((byte) 0);
    private final f iBW = g.ah(b.pmc);

    private MultiProcessMMKV aTI() {
        AppMethodBeat.i(195079);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) this.iBW.getValue();
        AppMethodBeat.o(195079);
        return multiProcessMMKV;
    }

    public a() {
        AppMethodBeat.i(195080);
        AppMethodBeat.o(195080);
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        boolean z;
        Map<String, String> map;
        boolean z2 = false;
        AppMethodBeat.i(6446);
        if (strArr != null && p.j(plZ, strArr[0])) {
            if (p.j("openrectimeline", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineOpenStatus", Util.getInt(strArr[2], -1));
                aTI().apply();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("recFeed", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineRecFeedStatus", Util.getInt(strArr[2], -1));
                aTI().apply();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("biztlbold", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineTitleBold", Util.getInt(strArr[2], -1));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("showbottomnav", strArr[1]) && strArr.length > 2) {
                MultiProcessMMKV.getMMKV("WebViewUIShowBottom").encode("WebViewUIShowBottomNav", Util.getInt(strArr[2], -1));
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("checkWebviewId", strArr[1]) && strArr.length > 2) {
                MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MicroMsg.BizVideoDetailUI");
                mmkv.encode("CheckWebviewId", Util.getInt(strArr[2], -1));
                mmkv.apply();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("deleteolddata", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineDeleteOldData", Util.getInt(strArr[2], -1));
                aTI().apply();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("addRecCard", strArr[1]) && strArr.length > 2) {
                byte[] decode = Base64.decode(strArr[2], 2);
                p.g(decode, "Base64.decode(args[2], Base64.NO_WRAP)");
                String str2 = new String(decode, kotlin.n.d.UTF_8);
                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                StringBuilder sb = new StringBuilder("BizLatestRecommendCardInfo");
                p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
                String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).toString();
                if (singleMMKV == null) {
                    p.hyc();
                }
                singleMMKV.encode(sb2, str2);
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("addPayAlbum", strArr[1]) && strArr.length > 2) {
                byte[] decode2 = Base64.decode(strArr[2], 2);
                p.g(decode2, "Base64.decode(args[2], Base64.NO_WRAP)");
                String str3 = new String(decode2, kotlin.n.d.UTF_8);
                int a2 = n.a((CharSequence) str3, "<sysmsg", 0, false, 6);
                if (a2 != -1) {
                    String substring = str3.substring(a2);
                    p.g(substring, "(this as java.lang.String).substring(startIndex)");
                    map = XmlParser.parseXml(substring, "sysmsg", null);
                    if (map == null) {
                        Log.e(plZ, "XmlParser values is null, msgContent %s", str3);
                        AppMethodBeat.o(6446);
                        return true;
                    }
                } else {
                    map = null;
                }
                com.tencent.mm.plugin.biz.b.b bVar = com.tencent.mm.plugin.biz.b.b.pfn;
                com.tencent.mm.plugin.biz.b.b.g(map, str3);
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("paySuccess", strArr[1]) && strArr.length > 2) {
                byte[] decode3 = Base64.decode(strArr[2], 2);
                p.g(decode3, "Base64.decode(args[2], Base64.NO_WRAP)");
                Map<String, String> parseXml = XmlParser.parseXml(new String(decode3, kotlin.n.d.UTF_8), "sysmsg", null);
                com.tencent.mm.plugin.brandservice.b.a aVar = com.tencent.mm.plugin.brandservice.b.a.pmT;
                p.g(parseXml, "values");
                aVar.ab(parseXml);
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("profileCrash", strArr[1]) && strArr.length > 2) {
                MultiProcessMMKV singleMMKV2 = MultiProcessMMKV.getSingleMMKV("ProfileCrashCheck");
                singleMMKV2.encode("testCrash", Util.getInt(strArr[2], 1));
                singleMMKV2.apply();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("updateAppInfo", strArr[1]) && strArr.length > 2) {
                String str4 = strArr[2];
                if (Util.isNullOrNil(str4)) {
                    AppMethodBeat.o(6446);
                    return true;
                }
                h.RTc.b(new c(str4), "GetAppInfoASyncThread");
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("resortbizmsgcheck", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineReSortMsgCheck", Util.getInt(strArr[2], 1));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("recycleCardCheck", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineRecycleCardCheck", Util.getInt(strArr[2], 1));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("updateCard", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineUpdateCard", Util.getInt(strArr[2], 1));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("showdigest", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineShowDigest", Util.getInt(strArr[2], -1));
                aTI().apply();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("oftenread", strArr[1]) && strArr.length > 2) {
                if (Util.getInt(strArr[2], -1) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                com.tencent.mm.plugin.biz.b.c.kc(z);
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("videochannel", strArr[1]) && strArr.length > 2) {
                if (Util.getInt(strArr[2], -1) == 0) {
                    z2 = true;
                }
                com.tencent.mm.plugin.biz.b.c.kd(z2);
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("sl", strArr[1]) && strArr.length > 2) {
                MultiProcessMMKV mmkv2 = MultiProcessMMKV.getMMKV("bizCommand");
                mmkv2.encode("sameLayerOpen", Util.getInt(strArr[2], -1));
                mmkv2.apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("resortbizmsgtest", strArr[1]) && strArr.length > 2) {
                w wVar = w.NPK;
                w.ajS(Util.getInt(strArr[2], -1));
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("adtest", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineAdTestMode", Util.getInt(strArr[2], 0));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("adtestext", strArr[1]) && strArr.length > 2) {
                MultiProcessMMKV singleMMKV3 = MultiProcessMMKV.getSingleMMKV("brandService");
                singleMMKV3.encode("BizTimeLineAdTestExtInfo", strArr[2]);
                singleMMKV3.apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("adtestaction", strArr[1]) && strArr.length > 2) {
                ((b) com.tencent.mm.kernel.g.af(b.class)).P("wxa06c02b5c00ff39b", "adTestExtAction", "data:" + strArr[2]);
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("ad", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineAdOpen", Util.getInt(strArr[2], 0));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("adprefetch", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineAdPrefetcherOpen", Util.getInt(strArr[2], 0));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("adInsertPos", strArr[1]) && strArr.length > 2) {
                aTI().encode("BizAdInsertPos", Util.getInt(strArr[2], 3));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("clearpkg", strArr[1])) {
                m mVar = m.IAG;
                m.yK(true);
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("adpreview", strArr[1]) && strArr.length > 2) {
                MultiProcessMMKV mmkv3 = MultiProcessMMKV.getMMKV("WebCanvasStorage");
                mmkv3.encode("BizTimeLineAdPreviewMode", Util.getInt(strArr[2], 0));
                mmkv3.apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j(APMidasPayAPI.ENV_TEST, strArr[1]) && strArr.length > 2) {
                aTI().encode("BizTimeLineTestMode", Util.getInt(strArr[2], 0));
                aTI().apply();
                C0860a.onSuccess();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("videofetchdebug", strArr[1])) {
                com.tencent.mm.plugin.biz.b.c.ckx();
                Log.i(TAG, "mpManifestPath=" + com.tencent.mm.plugin.biz.b.c.ckv());
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("clearsubscribemsg", strArr[1])) {
                com.tencent.mm.msgsubscription.d.c.jAF.biY();
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("clearimg", strArr[1])) {
                h.RTc.aX(d.pmf);
                AppMethodBeat.o(6446);
                return true;
            } else if (p.j("timel", strArr[1])) {
                af.akc(Integer.parseInt(strArr[2]));
                AppMethodBeat.o(6446);
                return true;
            }
        }
        AppMethodBeat.o(6446);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ String pmd;

        c(String str) {
            this.pmd = str;
        }

        public final void run() {
            AppMethodBeat.i(6443);
            if (com.tencent.mm.pluginsdk.model.app.h.cX(this.pmd, true) != null) {
                MMHandlerThread.postToMainThread(AnonymousClass1.pme);
            }
            AppMethodBeat.o(6443);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        public static final d pmf = new d();

        static {
            AppMethodBeat.i(6445);
            AppMethodBeat.o(6445);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(6444);
            s.deleteDir(com.tencent.mm.plugin.image.d.dZF());
            AppMethodBeat.o(6444);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/BizProcessorCommand$Companion;", "", "()V", "COMMAND_BIZ", "", "TAG", "getAdTestInfo", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onSuccess", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.a$a  reason: collision with other inner class name */
    public static final class C0860a {
        private C0860a() {
        }

        public /* synthetic */ C0860a(byte b2) {
            this();
        }

        public static void onSuccess() {
            AppMethodBeat.i(195076);
            Toast.makeText(MMApplicationContext.getContext(), "Success! WeChat will kill self in 1 second...", 1).show();
            h.RTc.n(RunnableC0861a.pmb, 1000);
            AppMethodBeat.o(195076);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.a$a$a  reason: collision with other inner class name */
        public static final class RunnableC0861a implements Runnable {
            public static final RunnableC0861a pmb = new RunnableC0861a();

            static {
                AppMethodBeat.i(195075);
                AppMethodBeat.o(195075);
            }

            RunnableC0861a() {
            }

            public final void run() {
                AppMethodBeat.i(195074);
                ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).bCm();
                AppMethodBeat.o(195074);
            }
        }
    }

    static {
        AppMethodBeat.i(6447);
        AppMethodBeat.o(6447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final b pmc = new b();

        static {
            AppMethodBeat.i(195078);
            AppMethodBeat.o(195078);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(195077);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(195077);
            return singleMMKV;
        }
    }
}
