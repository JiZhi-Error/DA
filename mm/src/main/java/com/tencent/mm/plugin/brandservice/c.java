package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.q;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 z2\u00020\u0001:\u0001zB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J9\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'\"\u00020(H\u0016¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001fH\u0016J.\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J \u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H\u0002J0\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u00042\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0016J\u0012\u0010;\u001a\u00020#2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0014\u0010>\u001a\u0004\u0018\u00010?2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010>\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u001fH\u0016J\u001e\u0010A\u001a\u00020#2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010%\u001a\u00020\u001fH\u0016J\u001e\u0010E\u001a\u00020#2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010%\u001a\u00020\u001fH\u0016J\b\u0010F\u001a\u00020\u001fH\u0016J\b\u0010G\u001a\u00020\u0004H\u0016J\u0010\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u0004H\u0016J\b\u0010J\u001a\u00020\u0004H\u0016J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010L\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u001fH\u0016J\b\u0010M\u001a\u00020\u0006H\u0016J\b\u0010N\u001a\u00020\u0006H\u0016J\u0012\u0010O\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010P\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010Q\u001a\u00020\u0006H\u0016J$\u0010R\u001a\u00020\u00062\b\u0010S\u001a\u0004\u0018\u00010(2\b\u0010T\u001a\u0004\u0018\u00010(2\u0006\u0010U\u001a\u00020\u001fH\u0016J\u0010\u0010V\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u001fH\u0016J@\u0010X\u001a\u00020#2\b\u0010Y\u001a\u0004\u0018\u00010Z2\b\u0010/\u001a\u0004\u0018\u00010[2\"\u0010\\\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(0]j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(`^H\u0016J\u0010\u0010_\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001fH\u0016J$\u0010`\u001a\u00020#2\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040C0C2\u0006\u0010%\u001a\u00020\u001fH\u0016J$\u0010a\u001a\u00020#2\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0C2\u0006\u0010%\u001a\u00020\u001fH\u0016J\b\u0010b\u001a\u00020#H\u0016J \u0010c\u001a\u00020#2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004H\u0016J\b\u0010d\u001a\u00020#H\u0016J\u0016\u0010e\u001a\u00020#2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020#0gH\u0002J\u0016\u0010h\u001a\u00020#2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020#0gH\u0002J\u0012\u0010i\u001a\u00020#2\b\u0010j\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010k\u001a\u00020#2\u0006\u0010I\u001a\u00020\u0004H\u0016J$\u0010l\u001a\u00020#2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010o\u001a\u00020\u001fH\u0016J@\u0010p\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020Z2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010q\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010r\u001a\u00020sH\u0016JP\u0010p\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020Z2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010q\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001f2\u0006\u0010u\u001a\u00020vH\u0016J\b\u0010w\u001a\u00020#H\u0016J\u0012\u0010x\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u00010yH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R#\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001a¨\u0006{"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "()V", "TAG", "", "bizNativeVideoOpen", "", "getBizNativeVideoOpen", "()Ljava/lang/Boolean;", "setBizNativeVideoOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "chatSessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "minPreloadTime", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "addReportParamForBizUrl", "url", "scene", "", "subScene", "clickTime", "addToPreload", "", "itemShowType", "openScene", "vals", "", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "appMsgPaySuccess", "canPreloadIn", "dispatchEvent", "appId", "event", "data", "doPreloadTimelineRecCard", "path", "canvasId", "doSendMpShareVideoMsg", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "appendText", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "favMpVideo", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/BaseMpShareVideoInfo;", "getAppMsgRelatedInfo", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "reqType", "getAppMsgRelatedInfoForAppMsg", "items", "", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getBizTimeLineSessionId", "getChannelFeeds", "getChatSession", "chatName", "getHardCodeUrl", "getUrlKey", "isBizNativePageOpen", "isBizNativeVideoOpen", "isBizTimeLineOpen", "isMpArticle", "isMpUrl", "isPayReadingOpen", "isShowBigPic", "baseInfo", "baseTopItem", "count", "isSupportStyle", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "openWebViewUseFastLoad", "context", "Landroid/content/Context;", "Lorg/json/JSONObject;", "ret", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "preCreateWebView", "preloadByIdAndUrls", "preloadByInfoIdAndBuffer", "preloadTimelineCanvas", "preloadTimelineRecCard", "preloadTimelineVideoChannel", "safeExecute", "block", "Lkotlin/Function0;", "safePreload", "saveChannelFeeds", "channelFeeds", "setChatSession", "shareMpVideoToSns", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "currentEnterId", "startPreloadWebView", "isNative", "intent", "Landroid/content/Intent;", "openType", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "tryPreloadTmplWebview", "updateChannelFeeds", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "Companion", "plugin-brandservice_release"})
public final class c implements com.tencent.mm.plugin.brandservice.a.b {
    private static final MMCacheSlotManager pmj = new MMCacheSlotManager();
    private static final MMCacheSlotManager pmk = new MMCacheSlotManager();
    private static final MMCacheSlotManager pml = new MMCacheSlotManager();
    public static final a pmm = new a((byte) 0);
    private final String TAG = "MicroMsg.BrandServiceImpl";
    private final kotlin.f iBW = kotlin.g.ah(new i(this));
    private final kotlin.f lhN = kotlin.g.ah(h.pmt);
    private Boolean pmg;
    private final ConcurrentHashMap<String, Long> pmh = new ConcurrentHashMap<>();
    private final long pmi = 15000;

    private final MultiProcessMMKV aTI() {
        AppMethodBeat.i(195093);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) this.iBW.getValue();
        AppMethodBeat.o(195093);
        return multiProcessMMKV;
    }

    private MMHandler bkj() {
        AppMethodBeat.i(195107);
        MMHandler mMHandler = (MMHandler) this.lhN.getValue();
        AppMethodBeat.o(195107);
        return mMHandler;
    }

    public c() {
        AppMethodBeat.i(6486);
        AppMethodBeat.o(6486);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean isMpUrl(String str) {
        AppMethodBeat.i(6453);
        if (str != null) {
            boolean isMpUrl = UrlExKt.isMpUrl(str);
            AppMethodBeat.o(6453);
            return isMpUrl;
        }
        AppMethodBeat.o(6453);
        return false;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean ahv(String str) {
        AppMethodBeat.i(195094);
        if (str != null) {
            boolean isMpArticleUrl = UrlExKt.isMpArticleUrl(str);
            AppMethodBeat.o(195094);
            return isMpArticleUrl;
        }
        AppMethodBeat.o(195094);
        return false;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final String d(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(6457);
        String d2 = com.tencent.mm.ag.m.d(str, i2, i3, i4);
        AppMethodBeat.o(6457);
        return d2;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean clc() {
        AppMethodBeat.i(6458);
        boolean clc = ab.clc();
        AppMethodBeat.o(6458);
        return clc;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean CQ(int i2) {
        AppMethodBeat.i(6459);
        if (i2 != 5 || !cld()) {
            AppMethodBeat.o(6459);
            return false;
        }
        AppMethodBeat.o(6459);
        return true;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean cld() {
        AppMethodBeat.i(6460);
        if (this.pmg == null) {
            this.pmg = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_native_video_v2, 1) == 1);
            Log.i(this.TAG, "bizNativeVideoOpen: " + this.pmg);
        }
        Boolean bool = this.pmg;
        if (bool == null) {
            kotlin.g.b.p.hyc();
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(6460);
        return booleanValue;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void a(String str, int i2, int i3, Object... objArr) {
        AppMethodBeat.i(6461);
        kotlin.g.b.p.h(str, "url");
        kotlin.g.b.p.h(objArr, "vals");
        String ahW = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW(str);
        if (pmj.contains(ahW)) {
            AppMethodBeat.o(6461);
            return;
        }
        pmj.add(ahW);
        Log.v(this.TAG, "preloadData: addToPreload:".concat(String.valueOf(ahW)));
        com.tencent.f.h.RTc.b(new b(str, i2, i3, objArr), "tmplPreload");
        AppMethodBeat.o(6461);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ String mkH;
        final /* synthetic */ int pmn;
        final /* synthetic */ int pmo;
        final /* synthetic */ Object[] pmp;

        b(String str, int i2, int i3, Object[] objArr) {
            this.mkH = str;
            this.pmn = i2;
            this.pmo = i3;
            this.pmp = objArr;
        }

        public final void run() {
            AppMethodBeat.i(6448);
            String str = this.mkH;
            int i2 = this.pmn;
            int i3 = this.pmo;
            Object[] objArr = this.pmp;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(str, i2, i3, Arrays.copyOf(objArr, objArr.length));
            AppMethodBeat.o(6448);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void j(List<? extends List<String>> list, int i2) {
        boolean z;
        AppMethodBeat.i(6469);
        kotlin.g.b.p.h(list, "items");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            String ahW = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW((String) t.get(0));
            if (pmj.contains(ahW)) {
                z = false;
            } else {
                pmj.add(ahW);
                z = true;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            if (Log.getLogLevel() == 0) {
                String str = this.TAG;
                StringBuilder sb = new StringBuilder("preloadData: preloadByIdAndUrls:");
                ArrayList<List> arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(arrayList3, 10));
                for (List list2 : arrayList3) {
                    arrayList4.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW((String) list2.get(0)));
                }
                Log.v(str, sb.append(arrayList4).toString());
            }
            com.tencent.f.h.RTc.b(new j(arrayList2, this, i2), "tmplPreload");
        }
        AppMethodBeat.o(6469);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByIdAndUrls$2$2"})
    static final class j implements Runnable {
        final /* synthetic */ List oaN;
        final /* synthetic */ c pmu;
        final /* synthetic */ int pmv;

        j(List list, c cVar, int i2) {
            this.oaN = list;
            this.pmu = cVar;
            this.pmv = i2;
        }

        public final void run() {
            AppMethodBeat.i(6451);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.j(this.oaN, this.pmv);
            AppMethodBeat.o(6451);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void k(List<String[]> list, int i2) {
        boolean z;
        AppMethodBeat.i(6470);
        kotlin.g.b.p.h(list, "items");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            String ahW = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW(((String[]) t)[0]);
            if (pmj.contains(ahW)) {
                z = false;
            } else {
                pmj.add(ahW);
                z = true;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            if (Log.getLogLevel() == 0) {
                String str = this.TAG;
                StringBuilder sb = new StringBuilder("preloadData: preloadByInfoIdAndBuffer:");
                ArrayList<String[]> arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(arrayList3, 10));
                for (String[] strArr : arrayList3) {
                    arrayList4.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahW(strArr[0]));
                }
                Log.v(str, sb.append(arrayList4).toString());
            }
            com.tencent.f.h.RTc.b(new k(arrayList2, this, i2), "tmplPreload");
        }
        AppMethodBeat.o(6470);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByInfoIdAndBuffer$2$2"})
    static final class k implements Runnable {
        final /* synthetic */ List oaN;
        final /* synthetic */ c pmu;
        final /* synthetic */ int pmv;

        k(List list, c cVar, int i2) {
            this.oaN = list;
            this.pmu = cVar;
            this.pmv = i2;
        }

        public final void run() {
            AppMethodBeat.i(6452);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.k(this.oaN, this.pmv);
            AppMethodBeat.o(6452);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void l(List<? extends q> list, int i2) {
        AppMethodBeat.i(6471);
        kotlin.g.b.p.h(list, "items");
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(6471);
            return;
        }
        com.tencent.f.h.RTc.b(new g(list, i2), "getAppMsgRelatedInfo");
        AppMethodBeat.o(6471);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ List jAe;
        final /* synthetic */ int pmo;

        g(List list, int i2) {
            this.jAe = list;
            this.pmo = i2;
        }

        public final void run() {
            boolean isMpArticleUrl;
            AppMethodBeat.i(6450);
            com.tencent.mm.plugin.brandservice.b.g gVar = com.tencent.mm.plugin.brandservice.b.g.pnw;
            List<q> list = this.jAe;
            int i2 = this.pmo;
            kotlin.g.b.p.h(list, "items");
            com.tencent.mm.plugin.brandservice.b.g.pnu = 0;
            com.tencent.mm.plugin.brandservice.b.g.pnv.clear();
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            for (q qVar : list) {
                kotlin.a.j.a((Collection) arrayList, (Iterable) ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(qVar.msgId, qVar.iAc).iAd);
            }
            ArrayList<v> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                v vVar = (v) obj;
                if (vVar.url == null) {
                    isMpArticleUrl = false;
                } else {
                    String str = vVar.url;
                    kotlin.g.b.p.g(str, "it.url");
                    isMpArticleUrl = UrlExKt.isMpArticleUrl(str);
                }
                if (isMpArticleUrl) {
                    arrayList2.add(obj);
                }
            }
            for (v vVar2 : arrayList2) {
                gg ggVar = new gg();
                ggVar.Url = vVar2.url;
                String str2 = ggVar.Url;
                kotlin.g.b.p.g(str2, "appMsgUrlInfo.Url");
                ggVar.izX = com.tencent.mm.plugin.brandservice.b.g.ahJ(str2);
                ggVar.iAb = vVar2.type;
                ggVar.KKb = vVar2.iAH;
                if (i2 != 0) {
                    if (vVar2.iwf == 1) {
                        com.tencent.mm.plugin.brandservice.b.a aVar = com.tencent.mm.plugin.brandservice.b.a.pmT;
                        if (com.tencent.mm.plugin.brandservice.b.a.cle()) {
                            ggVar.ReqType = 3;
                            linkedList.add(ggVar);
                        }
                    }
                    ggVar.ReqType = 1;
                    linkedList.add(ggVar);
                } else if (vVar2.iwf == 1) {
                    com.tencent.mm.plugin.brandservice.b.a aVar2 = com.tencent.mm.plugin.brandservice.b.a.pmT;
                    if (com.tencent.mm.plugin.brandservice.b.a.cle()) {
                        ggVar.ReqType = 2;
                        linkedList.add(ggVar);
                    }
                }
            }
            Log.v(com.tencent.mm.plugin.brandservice.b.g.TAG, "getAppMsgRelatedInfoForBizMsg size:" + linkedList.size());
            com.tencent.mm.plugin.brandservice.b.g.b(linkedList, i2);
            AppMethodBeat.o(6450);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void cD(String str, int i2) {
        AppMethodBeat.i(175441);
        if (str == null) {
            AppMethodBeat.o(175441);
            return;
        }
        com.tencent.f.h.RTc.b(new e(str, i2), "getAppMsgRelatedInfo");
        AppMethodBeat.o(175441);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ String mkH;
        final /* synthetic */ int pmn;
        final /* synthetic */ int pmo = 0;
        final /* synthetic */ int pms = 2;

        e(String str, int i2) {
            this.mkH = str;
            this.pmn = i2;
        }

        public final void run() {
            AppMethodBeat.i(6449);
            com.tencent.mm.plugin.brandservice.b.g gVar = com.tencent.mm.plugin.brandservice.b.g.pnw;
            com.tencent.mm.plugin.brandservice.b.g.j(this.mkH, this.pmn, this.pmo, this.pms);
            AppMethodBeat.o(6449);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final com.tencent.mm.ag.p ahw(String str) {
        AppMethodBeat.i(6473);
        g.a aVar = g.a.pnx;
        com.tencent.mm.ag.p ahL = g.a.ahL(str);
        AppMethodBeat.o(6473);
        return ahL;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void ct(List<? extends q> list) {
        AppMethodBeat.i(195095);
        kotlin.g.b.p.h(list, "items");
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(195095);
            return;
        }
        com.tencent.f.h.RTc.b(new f(list), "getAppMsgRelatedInfo");
        AppMethodBeat.o(195095);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ List jAe;
        final /* synthetic */ int pmo = 90;

        f(List list) {
            this.jAe = list;
        }

        public final void run() {
            boolean isMpArticleUrl;
            AppMethodBeat.i(195083);
            com.tencent.mm.plugin.brandservice.b.g gVar = com.tencent.mm.plugin.brandservice.b.g.pnw;
            List list = this.jAe;
            int i2 = this.pmo;
            kotlin.g.b.p.h(list, "items");
            com.tencent.mm.plugin.brandservice.b.g.pnu = 0;
            com.tencent.mm.plugin.brandservice.b.g.pnv.clear();
            LinkedList linkedList = new LinkedList();
            ArrayList<q> arrayList = new ArrayList();
            for (Object obj : list) {
                q qVar = (q) obj;
                if (qVar.Url == null) {
                    isMpArticleUrl = false;
                } else {
                    String str = qVar.Url;
                    kotlin.g.b.p.g(str, "it.Url");
                    isMpArticleUrl = UrlExKt.isMpArticleUrl(str);
                }
                if (isMpArticleUrl) {
                    arrayList.add(obj);
                }
            }
            for (q qVar2 : arrayList) {
                gg ggVar = new gg();
                ggVar.Url = qVar2.Url;
                String str2 = ggVar.Url;
                kotlin.g.b.p.g(str2, "appMsgUrlInfo.Url");
                ggVar.izX = com.tencent.mm.plugin.brandservice.b.g.ahJ(str2);
                ggVar.iAb = qVar2.iAb;
                ggVar.ReqType = qVar2.ReqType;
                if (ggVar.ReqType > 0) {
                    linkedList.add(ggVar);
                }
            }
            Log.v(com.tencent.mm.plugin.brandservice.b.g.TAG, "getAppMsgRelatedInfoForAppMsg size:" + list.size());
            com.tencent.mm.plugin.brandservice.b.g.b(linkedList, i2);
            AppMethodBeat.o(195083);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean cle() {
        AppMethodBeat.i(6474);
        com.tencent.mm.plugin.brandservice.b.a aVar = com.tencent.mm.plugin.brandservice.b.a.pmT;
        boolean cle = com.tencent.mm.plugin.brandservice.b.a.cle();
        AppMethodBeat.o(6474);
        return cle;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void c(jo joVar) {
        AppMethodBeat.i(195096);
        com.tencent.mm.plugin.webview.ui.tools.media.f fVar = com.tencent.mm.plugin.webview.ui.tools.media.f.JwB;
        com.tencent.mm.plugin.webview.ui.tools.media.f.d(joVar);
        AppMethodBeat.o(195096);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void a(jo joVar, MMActivity mMActivity, int i2) {
        AppMethodBeat.i(195097);
        com.tencent.mm.plugin.webview.ui.tools.media.c cVar = com.tencent.mm.plugin.webview.ui.tools.media.c.Jwu;
        com.tencent.mm.plugin.webview.ui.tools.media.c.b(joVar, mMActivity, i2);
        AppMethodBeat.o(195097);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void cE(String str, int i2) {
        AppMethodBeat.i(6475);
        kotlin.g.b.p.h(str, "url");
        com.tencent.mm.plugin.brandservice.b.a.pmT.cE(str, i2);
        AppMethodBeat.o(6475);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean CR(int i2) {
        AppMethodBeat.i(6476);
        boolean CR = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.CR(i2);
        AppMethodBeat.o(6476);
        return CR;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean a(Context context, String str, int i2, int i3, int i4, Intent intent) {
        AppMethodBeat.i(195098);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "url");
        kotlin.g.b.p.h(intent, "intent");
        boolean a2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(context, str, i2, i3, i4, intent, 0, null, false, com.tencent.mm.plugin.appbrand.jsapi.aa.e.CTRL_INDEX);
        AppMethodBeat.o(195098);
        return a2;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean a(Context context, String str, int i2, int i3, int i4, Intent intent, int i5, b.a aVar) {
        AppMethodBeat.i(195099);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "url");
        kotlin.g.b.p.h(intent, "intent");
        kotlin.g.b.p.h(aVar, "result");
        boolean a2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(context, str, i2, i3, i4, intent, i5, aVar, false, 512);
        AppMethodBeat.o(195099);
        return a2;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void CS(int i2) {
        AppMethodBeat.i(6479);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.run(i2);
        AppMethodBeat.o(6479);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final String clf() {
        AppMethodBeat.i(6480);
        String coT = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coT();
        AppMethodBeat.o(6480);
        return coT;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void clg() {
        AppMethodBeat.i(6481);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.cpJ();
        AppMethodBeat.o(6481);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void a(String str, y yVar, String str2, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
        AppMethodBeat.i(6482);
        kotlin.g.b.p.h(str, "toUser");
        kotlin.g.b.p.h(yVar, "msgInfo");
        kotlin.g.b.p.h(dVar, "callback");
        com.tencent.mm.plugin.webview.ui.tools.media.d dVar2 = com.tencent.mm.plugin.webview.ui.tools.media.d.Jwx;
        com.tencent.mm.plugin.webview.ui.tools.media.d.b(str, yVar, str2, dVar);
        AppMethodBeat.o(6482);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void ahx(String str) {
        AppMethodBeat.i(6483);
        kotlin.g.b.p.h(str, "chatName");
        this.pmh.put(str, Long.valueOf(MMSlotKt.now()));
        AppMethodBeat.o(6483);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final long ahy(String str) {
        AppMethodBeat.i(6484);
        kotlin.g.b.p.h(str, "chatName");
        Long l2 = this.pmh.get(str);
        if (l2 != null) {
            long longValue = l2.longValue();
            AppMethodBeat.o(6484);
            return longValue;
        }
        AppMethodBeat.o(6484);
        return -1;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final int clh() {
        AppMethodBeat.i(195100);
        int sessionId = ab.getSessionId();
        AppMethodBeat.o(195100);
        return sessionId;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final String ahz(String str) {
        AppMethodBeat.i(175443);
        kotlin.g.b.p.h(str, "url");
        String aie = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aie(str);
        AppMethodBeat.o(175443);
        return aie;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl$Companion;", "", "()V", "KEY_BIZ_CANVAS_PRELOAD_CANVAS_LAST_TIME", "", "KEY_BIZ_CANVAS_PRELOAD_CRASH_TIMES", "preauthLimiter", "Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "getPreauthLimiter", "()Lcom/tencent/mm/sdk/platformtools/MMCacheSlotManager;", "prednsLimiter", "getPrednsLimiter", "preloadLimiter", "getPreloadLimiter", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(6487);
        AppMethodBeat.o(6487);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean L(Object obj, Object obj2) {
        Object obj3;
        v vVar = null;
        AppMethodBeat.i(6485);
        if (!(obj instanceof z)) {
            obj3 = null;
        } else {
            obj3 = obj;
        }
        z zVar = (z) obj3;
        if (obj2 instanceof v) {
            vVar = obj2;
        }
        boolean a2 = com.tencent.mm.plugin.brandservice.ui.b.a.a(zVar, vVar);
        AppMethodBeat.o(6485);
        return a2;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final String cli() {
        AppMethodBeat.i(175447);
        String string = aTI().getString("video_channel_feeds_data", "");
        if (string == null) {
            string = "";
        }
        AppMethodBeat.o(175447);
        return string;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void ahA(String str) {
        AppMethodBeat.i(175448);
        Log.d(this.TAG, "alvinluo saveChannelFeeds %s", str);
        aTI().putString("video_channel_feeds_data", str);
        AppMethodBeat.o(175448);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void a(b.AbstractC0862b bVar) {
        AppMethodBeat.i(175449);
        com.tencent.mm.plugin.brandservice.b.c cVar = com.tencent.mm.plugin.brandservice.b.c.pne;
        com.tencent.mm.plugin.brandservice.b.c.b(bVar);
        AppMethodBeat.o(175449);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void a(Context context, JSONObject jSONObject, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(175450);
        kotlin.g.b.p.h(hashMap, "ret");
        if (jSONObject == null) {
            AppMethodBeat.o(175450);
            return;
        }
        int optInt = jSONObject.optInt("item_show_type");
        String c2 = com.tencent.mm.plugin.webview.h.g.c(optInt, jSONObject);
        if (!Util.isNullOrNil(c2)) {
            hashMap.put("success", Boolean.FALSE);
            hashMap.put("desc", c2);
            AppMethodBeat.o(175450);
            return;
        }
        Bundle bundle = new Bundle();
        if (optInt != 5 || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CQ(optInt)) {
            bundle.putString("url", jSONObject.optString("url"));
            bundle.putInt("item_show_type", jSONObject.optInt("item_show_type"));
            bundle.putInt("scene", jSONObject.optInt("scene"));
            bundle.putInt("subscene", jSONObject.optInt("subscene"));
            bundle.putInt("openType", jSONObject.optInt("openType"));
            bundle.putString("biz_video_channel_session_id", jSONObject.optString("channelSessionId"));
        } else {
            com.tencent.mm.plugin.webview.h.g.a(bundle, optInt, jSONObject);
            com.tencent.mm.plugin.webview.ui.tools.video.a aVar = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
            if (com.tencent.mm.plugin.webview.ui.tools.video.a.gic() && jSONObject != null) {
                Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload");
                String optString = jSONObject.optString("vid");
                if (Util.isNullOrNil(optString)) {
                    Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload vid null");
                } else {
                    int i2 = (int) Util.getFloat(jSONObject.optString("videoInitialTime"), 0.0f);
                    String optString2 = jSONObject.optString("videoInitialSnapshot");
                    if (Util.isNullOrNil(optString2)) {
                        Log.i("MicroMsg.MPVideoPreviewDataMgr", "saveVideo openwebviewusefastload bitmap null");
                    } else {
                        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) com.tencent.mm.plugin.webview.ui.tools.video.a.JxM.getSlot();
                        multiProcessMMKV.encode("MicroMsg.MPVideoPreviewDataMgr_" + optString + "_playTime", i2);
                        multiProcessMMKV.encode("MicroMsg.MPVideoPreviewDataMgr_" + optString + "_expire", (System.currentTimeMillis() / 1000) + 600);
                        multiProcessMMKV.encode("MicroMsg.MPVideoPreviewDataMgr_" + optString + "_bitmap", optString2);
                        com.tencent.mm.plugin.webview.ui.tools.video.a.bbi(optString);
                    }
                }
            }
        }
        b.a aVar2 = new b.a();
        Intent intent = new Intent();
        if (bundle.getBoolean("isNativePage") && context != null) {
            intent.putExtras(bundle);
            com.tencent.mm.plugin.webview.h.g.a(context, bundle.getString("currentInfo"), com.tencent.mm.cc.a.gvp(), intent, false);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1061, 21, 1, false);
        }
        int i3 = bundle.getInt("scene");
        int i4 = bundle.getInt("subscene", 10000);
        String string = bundle.getString("url");
        if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(string)) {
            string = ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(string, i3, i4, (int) (System.currentTimeMillis() / 1000));
        }
        int i5 = bundle.getInt("item_show_type");
        bundle.getBoolean("isNativePage");
        hashMap.put("success", Boolean.valueOf(((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(context, string, i5, i3, i4, intent, bundle.getInt("openType"), aVar2)));
        if (!aVar2.success && aVar2.message != null) {
            String str = aVar2.message;
            kotlin.g.b.p.g(str, "result.message");
            hashMap.put("desc", str);
        }
        AppMethodBeat.o(175450);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final boolean CT(int i2) {
        AppMethodBeat.i(195101);
        boolean CT = com.tencent.mm.plugin.brandservice.ui.timeline.item.l.CT(i2);
        AppMethodBeat.o(195101);
        return CT;
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void P(String str, String str2, String str3) {
        AppMethodBeat.i(195102);
        kotlin.g.b.p.h(str2, "event");
        D(new C0865c(str, str2, str3));
        AppMethodBeat.o(195102);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void Q(String str, String str2, String str3) {
        AppMethodBeat.i(195103);
        kotlin.g.b.p.h(str, "path");
        kotlin.g.b.p.h(str2, "canvasId");
        kotlin.g.b.p.h(str3, "data");
        r rVar = r.NPl;
        if (r.gzQ()) {
            D(new m(this, str, str2, str3));
        }
        AppMethodBeat.o(195103);
    }

    private final void D(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(195104);
        long currentTimeMillis = System.currentTimeMillis() - PluginBiz.startTime;
        if (currentTimeMillis >= this.pmi || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            aVar.invoke();
            AppMethodBeat.o(195104);
            return;
        }
        com.tencent.f.h.RTc.o(new o(aVar), Math.max(this.pmi - currentTimeMillis, 5000L));
        AppMethodBeat.o(195104);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class o implements Runnable {
        final /* synthetic */ kotlin.g.a.a hvp;

        o(kotlin.g.a.a aVar) {
            this.hvp = aVar;
        }

        public final void run() {
            AppMethodBeat.i(195091);
            this.hvp.invoke();
            AppMethodBeat.o(195091);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void clj() {
        AppMethodBeat.i(195105);
        r rVar = r.NPl;
        if (r.gzQ()) {
            E(new l(this));
        }
        AppMethodBeat.o(195105);
    }

    @Override // com.tencent.mm.plugin.brandservice.a.b
    public final void clk() {
        AppMethodBeat.i(195106);
        r rVar = r.NPl;
        if (r.gzQ()) {
            com.tencent.mm.plugin.brandservice.b.c cVar = com.tencent.mm.plugin.brandservice.b.c.pne;
            if (com.tencent.mm.plugin.brandservice.b.c.clF()) {
                E(n.pmw);
            }
        }
        AppMethodBeat.o(195106);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class p implements Runnable {
        final /* synthetic */ kotlin.g.a.a hvp;
        final /* synthetic */ c pmu;

        p(c cVar, kotlin.g.a.a aVar) {
            this.pmu = cVar;
            this.hvp = aVar;
        }

        public final void run() {
            AppMethodBeat.i(195092);
            com.tencent.mm.plugin.biz.b.c cVar = com.tencent.mm.plugin.biz.b.c.pfv;
            int decodeInt = com.tencent.mm.plugin.biz.b.c.cks().decodeInt("biz_canvas_card_preload_crash_times", 0);
            com.tencent.mm.plugin.biz.b.c cVar2 = com.tencent.mm.plugin.biz.b.c.pfv;
            if (!com.tencent.mm.plugin.biz.b.c.a(decodeInt, 0, "biz_canvas_card_preload_last_time", 10)) {
                AppMethodBeat.o(195092);
                return;
            }
            com.tencent.mm.plugin.biz.b.c cVar3 = com.tencent.mm.plugin.biz.b.c.pfv;
            com.tencent.mm.plugin.biz.b.c.cks().encode("biz_canvas_card_preload_crash_times", decodeInt + 1);
            Log.i(this.pmu.TAG, "safePreload set crash flag");
            this.hvp.invoke();
            com.tencent.mm.plugin.biz.b.c cVar4 = com.tencent.mm.plugin.biz.b.c.pfv;
            com.tencent.mm.plugin.biz.b.c.cks().encode("biz_canvas_card_preload_crash_times", 0);
            Log.i(this.pmu.TAG, "safePreload reset crash flag");
            AppMethodBeat.o(195092);
        }
    }

    private final void E(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(195108);
        bkj().post(new p(this, aVar));
        AppMethodBeat.o(195108);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        final /* synthetic */ c pmu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(c cVar) {
            super(0);
            this.pmu = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(195086);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV(this.pmu.TAG);
            AppMethodBeat.o(195086);
            return singleMMKV;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.c$c  reason: collision with other inner class name */
    static final class C0865c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ String kPQ;
        final /* synthetic */ String mkH = null;
        final /* synthetic */ String oBM;
        final /* synthetic */ String pmq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0865c(String str, String str2, String str3) {
            super(0);
            this.kPQ = str;
            this.oBM = str2;
            this.pmq = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195081);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.y yVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.pFf;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.y.k(this.kPQ, this.mkH, this.oBM, this.pmq);
            x xVar = x.SXb;
            AppMethodBeat.o(195081);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ String lCM;
        final /* synthetic */ String pmq;
        final /* synthetic */ String pmr;
        final /* synthetic */ c pmu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(c cVar, String str, String str2, String str3) {
            super(0);
            this.pmu = cVar;
            this.lCM = str;
            this.pmr = str2;
            this.pmq = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195088);
            c.a(this.pmu, this.lCM, this.pmr, this.pmq);
            x xVar = x.SXb;
            AppMethodBeat.o(195088);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ c pmu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(c cVar) {
            super(0);
            this.pmu = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195087);
            r.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.item.r.puL;
            r.a.cmU();
            Log.i(this.pmu.TAG, "preloadTimelineCanvas");
            x xVar = x.SXb;
            AppMethodBeat.o(195087);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final n pmw = new n();

        static {
            AppMethodBeat.i(195090);
            AppMethodBeat.o(195090);
        }

        n() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195089);
            r.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.item.r.puL;
            com.tencent.mm.plugin.brandservice.ui.timeline.item.x cmU = r.a.cmU();
            com.tencent.mm.plugin.brandservice.b.c cVar = com.tencent.mm.plugin.brandservice.b.c.pne;
            com.tencent.mm.plugin.webcanvas.c.a(cmU, "vc", "__biz_video_channel_canvas_id__", com.tencent.mm.plugin.brandservice.b.c.clG());
            x xVar = x.SXb;
            AppMethodBeat.o(195089);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<MMHandler> {
        public static final h pmt = new h();

        static {
            AppMethodBeat.i(195085);
            AppMethodBeat.o(195085);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(195084);
            MMHandler mMHandler = new MMHandler("WebCanvasPreload");
            AppMethodBeat.o(195084);
            return mMHandler;
        }
    }

    public static final /* synthetic */ void a(c cVar, String str, String str2, String str3) {
        AppMethodBeat.i(195109);
        if (!Util.isNullOrNil(str)) {
            cVar.E(new d(str, str2, str3));
        }
        AppMethodBeat.o(195109);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ String lCM;
        final /* synthetic */ String pmq;
        final /* synthetic */ String pmr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, String str2, String str3) {
            super(0);
            this.lCM = str;
            this.pmr = str2;
            this.pmq = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195082);
            r.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.item.r.puL;
            com.tencent.mm.plugin.webcanvas.c.a(r.a.cmU(), this.lCM, this.pmr, this.pmq);
            x xVar = x.SXb;
            AppMethodBeat.o(195082);
            return xVar;
        }
    }
}
