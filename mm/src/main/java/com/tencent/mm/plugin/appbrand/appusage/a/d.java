package com.tencent.mm.plugin.appbrand.appusage.a;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.h;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0014H\u0003J \u00100\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00142\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J,\u00104\u001a&\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r 5*\u0012\u0012\f\u0012\n 5*\u0004\u0018\u00010\r0\r\u0018\u00010\f0\fH\u0002J\u000e\u00106\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0014J\u0006\u00107\u001a\u00020\u001cJ\u000e\u00108\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0014J\u0006\u00109\u001a\u00020\u0014J\u0006\u0010:\u001a\u00020\u0014J\u0006\u0010;\u001a\u00020\u0014J\u0006\u0010<\u001a\u00020\u0004J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0002J\u0006\u0010@\u001a\u00020\"J\u0006\u0010A\u001a\u00020\"J\u0018\u0010B\u001a\u00020\"2\u0006\u0010>\u001a\u00020?2\u0006\u0010'\u001a\u00020\u0014H\u0002J*\u0010C\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00142\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u001b\u001a\u00020\u0014H\u0002J\u0006\u0010E\u001a\u00020\u001cJ\u0006\u0010F\u001a\u00020\u001cJ\u000e\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0014J\u000e\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\"J\u0006\u0010K\u001a\u00020\"J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000Rg\u0010\u0015\u001aO\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\f8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b)\u0010\u000fR\u000e\u0010+\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "", "()V", "cache_seconds", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getDataList", "()Ljava/util/LinkedList;", "dataList$delegate", "Lkotlin/Lazy;", "lastUpdateTime", "lastVisiblePos", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "result", "recommendCardList", "remainCount", "", "getListener", "()Lkotlin/jvm/functions/Function3;", "setListener", "(Lkotlin/jvm/functions/Function3;)V", "loadFromMemory", "", "locationGet", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLocationGet;", "mockData", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "pageNum", "rList", "getRList", "rList$delegate", "remain_count", "sessionId", "strategy", "testData", "delAllDB", "doGetRecommendCard", "fLongitude", "", "fLatitude", "fetchFromDB", "kotlin.jvm.PlatformType", "fetchPageData", "fetchPageDataFromMemory", "forceRefreshPageData", "getLastVisiblePos", "getPageNum", "getRemainCount", "getSessionId", "handleResponse", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "isDataEmpty", "isDataTimeOut", "needStoreToDB", "onFetchFinish", "list", "removeListener", "resetStrategy", "setLastVisiblePos", "pos", "setLoadFromMemory", "fromMemory", "shouldLoadFromMemory", "storeToDB", "Companion", "plugin-appbrand-integration_release"})
public final class d {
    private static d kXg;
    public static final a kXh = new a((byte) 0);
    public int eeE;
    private final k kWU;
    public final c kWV;
    private final kotlin.f kWW;
    long kWX;
    public int kWY;
    public int kWZ;
    public boolean kXa;
    public int kXb;
    private final kotlin.f kXc;
    private boolean kXd;
    private h.a kXe;
    public q<? super Integer, ? super LinkedList<dko>, ? super Integer, x> kXf;
    long lastUpdateTime;
    public long sessionId;

    static {
        AppMethodBeat.i(50317);
        AppMethodBeat.o(50317);
    }

    private final LinkedList<Integer> byJ() {
        AppMethodBeat.i(50318);
        LinkedList<Integer> linkedList = (LinkedList) this.kWW.getValue();
        AppMethodBeat.o(50318);
        return linkedList;
    }

    public final LinkedList<dko> byK() {
        AppMethodBeat.i(50319);
        LinkedList<dko> linkedList = (LinkedList) this.kXc.getValue();
        AppMethodBeat.o(50319);
        return linkedList;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 2>", "invoke"})
    static final class g extends kotlin.g.b.q implements q<Integer, LinkedList<dko>, Integer, x> {
        public static final g kXl = new g();

        static {
            AppMethodBeat.i(50314);
            AppMethodBeat.o(50314);
        }

        g() {
            super(3);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Integer num, LinkedList<dko> linkedList, Integer num2) {
            AppMethodBeat.i(50313);
            num.intValue();
            num2.intValue();
            p.h(linkedList, "<anonymous parameter 1>");
            x xVar = x.SXb;
            AppMethodBeat.o(50313);
            return xVar;
        }
    }

    private d() {
        AppMethodBeat.i(50323);
        this.kWU = new k();
        this.kWV = new c();
        this.kWW = kotlin.g.ah(h.kXm);
        this.kXb = 1;
        this.kXc = kotlin.g.ah(c.kXj);
        this.kXe = new b(this);
        this.kXf = g.kXl;
        AppMethodBeat.o(50323);
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public static final /* synthetic */ void a(d dVar, int i2, float f2, float f3) {
        AppMethodBeat.i(50328);
        dVar.a(i2, f2, f3);
        AppMethodBeat.o(50328);
    }

    public static final /* synthetic */ void a(d dVar, LinkedList linkedList, int i2) {
        AppMethodBeat.i(50325);
        dVar.a(3, linkedList, i2);
        AppMethodBeat.o(50325);
    }

    public static final /* synthetic */ LinkedList f(d dVar) {
        AppMethodBeat.i(50326);
        LinkedList<dko> byK = dVar.byK();
        AppMethodBeat.o(50326);
        return byK;
    }

    public static final /* synthetic */ LinkedList g(d dVar) {
        AppMethodBeat.i(50327);
        LinkedList<Integer> byJ = dVar.byJ();
        AppMethodBeat.o(50327);
        return byJ;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$Companion;", "", "()V", "RESULT_FAIL", "", "RESULT_FROM_DB", "RESULT_FROM_MEMORY_CACHE", "RESULT_SUCCESS", "TAG", "", "instance", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "setInstance", "(Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;)V", "get", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final synchronized d byM() {
            d dVar;
            AppMethodBeat.i(50305);
            if (d.kXg == null) {
                d.kXg = new d((byte) 0);
            }
            dVar = d.kXg;
            if (dVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(50305);
            return dVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/CgiGetRecommendWxa$IGetRecommendWxaCallback;", "onFail", "", "onSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/GetRecommendWxaResponse;", "plugin-appbrand-integration_release"})
    public static final class b implements h.a {
        final /* synthetic */ d kXi;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(d dVar) {
            this.kXi = dVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.a.h.a
        public final void a(bud bud) {
            AppMethodBeat.i(50306);
            p.h(bud, "response");
            d.a(this.kXi, bud);
            AppMethodBeat.o(50306);
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.a.h.a
        public final void byN() {
            AppMethodBeat.i(50307);
            d.a(this.kXi, 1, (LinkedList) null, 6);
            AppMethodBeat.o(50307);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.appbrand.appusage.a.d */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(d dVar, int i2, LinkedList linkedList, int i3) {
        AppMethodBeat.i(50321);
        if ((i3 & 2) != 0) {
            linkedList = new LinkedList();
        }
        dVar.a(i2, linkedList, 0);
        AppMethodBeat.o(50321);
    }

    private final void a(int i2, LinkedList<dko> linkedList, int i3) {
        AppMethodBeat.i(50320);
        q<? super Integer, ? super LinkedList<dko>, ? super Integer, x> qVar = this.kXf;
        if (qVar != null) {
            qVar.d(Integer.valueOf(i2), linkedList, Integer.valueOf(i3));
            AppMethodBeat.o(50320);
            return;
        }
        AppMethodBeat.o(50320);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "fLongitude", "", "fLatitude", "onCallbackLocation"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.d$d  reason: collision with other inner class name */
    public static final class C0555d implements c.a {
        final /* synthetic */ d kXi;

        C0555d(d dVar) {
            this.kXi = dVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.appusage.a.c.a
        public final void J(float f2, float f3) {
            AppMethodBeat.i(50310);
            Iterator it = d.g(this.kXi).iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                d dVar = this.kXi;
                p.g(num, "item");
                d.a(dVar, num.intValue(), f2, f3);
            }
            d.g(this.kXi).clear();
            AppMethodBeat.o(50310);
        }
    }

    private final void a(int i2, float f2, float f3) {
        AppMethodBeat.i(50322);
        if (!com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(50322);
            return;
        }
        aat aat = new aat();
        aat.Lmb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        aat.longitude = (double) f2;
        aat.latitude = (double) f3;
        if (!BuildInfo.DEBUG || i2 == 0 || !this.kXd) {
            h.a(i2, aat, this.sessionId, this.kXe, this.kXb);
            AppMethodBeat.o(50322);
            return;
        }
        k kVar = this.kWU;
        LinkedList<dko> linkedList = new LinkedList<>();
        dko dko = new dko();
        kVar.a(dko);
        dko.qGI = "####客户端mock数据####大视频";
        dko.nHh = 6;
        dko.MOv = "http://221.228.226.23/11/t/j/v/b/tjvbwspwhqdmgouolposcsfafpedmb/sh.yinyuetai.com/691201536EE4912BF7E4F1E2C67B8119.mp4";
        dko.MOx = "http://ent.chinadaily.com.cn/att/site1/20140818/0023ae72898c155ba5db5b.jpeg";
        linkedList.addLast(dko);
        LinkedList<dko> linkedList2 = linkedList;
        dko[] dkoArr = new dko[4];
        for (int i3 = 0; i3 < 4; i3++) {
            dko dko2 = new dko();
            kVar.a(dko2);
            dko2.MOz = new bzt();
            dko2.MOz.Mfp = 1500;
            dko2.MOz.Mfo = 1750;
            dko2.nHh = 5;
            switch (i3) {
                case 0:
                    dko2.qGI = "####客户端mock数据####商品tt";
                    dko2.MOz.Mfr = true;
                    dko2.MOz.Mfq = true;
                    break;
                case 1:
                    dko2.qGI = "####客户端mock数据####商品tf";
                    dko2.MOz.Mfr = true;
                    dko2.MOz.Mfq = false;
                    break;
                case 2:
                    dko2.qGI = "####客户端mock数据####商品ff";
                    dko2.MOz.Mfr = false;
                    dko2.MOz.Mfq = false;
                    break;
                default:
                    dko2.qGI = "####客户端mock数据####商品ft";
                    dko2.MOz.Mfr = false;
                    dko2.MOz.Mfq = true;
                    break;
            }
            dko2.qGI += i2;
            dkoArr[i3] = dko2;
        }
        p.h(linkedList2, "$this$addAll");
        p.h(dkoArr, MessengerShareContentUtility.ELEMENTS);
        linkedList2.addAll(kotlin.a.e.asList(dkoArr));
        int size = i2 == 2 ? 0 : linkedList.size();
        Thread.sleep(2000);
        a(0, linkedList, size);
        AppMethodBeat.o(50322);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<LinkedList<Integer>> {
        public static final h kXm = new h();

        static {
            AppMethodBeat.i(50316);
            AppMethodBeat.o(50316);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinkedList<Integer> invoke() {
            AppMethodBeat.i(50315);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(50315);
            return linkedList;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<LinkedList<dko>> {
        public static final c kXj = new c();

        static {
            AppMethodBeat.i(50309);
            AppMethodBeat.o(50309);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinkedList<dko> invoke() {
            AppMethodBeat.i(50308);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(50308);
            return linkedList;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ d kXi;
        final /* synthetic */ int kXk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar, int i2) {
            super(0);
            this.kXi = dVar;
            this.kXk = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50311);
            d.a(this.kXi, this.kXk);
            x xVar = x.SXb;
            AppMethodBeat.o(50311);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ d kXi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d dVar) {
            super(0);
            this.kXi = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            AppMethodBeat.i(50312);
            d dVar = this.kXi;
            if (Util.nowSecond() - dVar.lastUpdateTime > dVar.kWX) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.Recommend.AppBrandRecommendLogic", "data is timeout, need to update from server");
                this.kXi.kWY = 0;
                this.kXi.kWZ = 0;
                this.kXi.eeE = 0;
                d.a(this.kXi, this.kXi.kWZ);
                com.tencent.mm.plugin.appbrand.ui.recommend.g.zz(2);
            } else {
                d.a(this.kXi, d.f(this.kXi), this.kXi.kWY);
                com.tencent.mm.plugin.appbrand.ui.recommend.g.zz(1);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(50312);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(d dVar, int i2) {
        AppMethodBeat.i(50324);
        if (com.tencent.mm.kernel.g.aAc()) {
            if (i2 == 0) {
                Object W = n.W(b.class);
                p.g(W, "SubCoreAppBrand.getStora…dCardStorage::class.java)");
                LinkedList<dko> byD = ((b) W).byD();
                p.g(byD, "dataFetchFromDB");
                if (!byD.isEmpty()) {
                    a(dVar, 2, byD, 4);
                }
            }
            if (c.byF()) {
                dVar.a(i2, c.getLongitude(), c.getLatitude());
                AppMethodBeat.o(50324);
                return;
            }
            dVar.byJ().add(Integer.valueOf(i2));
            if (!dVar.kWV.byE()) {
                dVar.kWV.a(new C0555d(dVar));
            }
            dVar.kWV.byG();
        }
        AppMethodBeat.o(50324);
    }

    public static final /* synthetic */ void a(d dVar, bud bud) {
        int size;
        boolean z;
        AppMethodBeat.i(50329);
        dVar.sessionId = bud.clK;
        dVar.kWX = (long) bud.MaS;
        dVar.kWY = bud.kWY;
        dVar.lastUpdateTime = Util.nowSecond();
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(bud.clK);
        objArr[1] = Integer.valueOf(bud.kWY);
        if (bud.MaR == null) {
            size = 0;
        } else {
            size = bud.MaR.size();
        }
        objArr[2] = Integer.valueOf(size);
        objArr[3] = Long.valueOf(dVar.kWX);
        Log.i("MicroMsg.Recommend.AppBrandRecommendLogic", "success sessionId:%d, remain_count:%d, size:%d, cache_seconds:%d", objArr);
        if (dVar.kWZ != 0 || bud.MaR == null || bud.MaR.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            Log.i("MicroMsg.Recommend.AppBrandRecommendLogic", "save to database");
            b bVar = (b) n.W(b.class);
            bVar.byC();
            bVar.u(bud.MaR);
            dVar.byK().clear();
        } else if (dVar.kWZ == 0 && (bud.MaR == null || bud.MaR.isEmpty())) {
            Log.i("MicroMsg.Recommend.AppBrandRecommendLogic", "page num is 0, recommend_card_list is empty, delete all data");
            dVar.byK().clear();
            ((b) n.W(b.class)).byC();
        }
        if (BuildInfo.DEBUG && dVar.kXd) {
            bud.kWY = bud.kWY == 0 ? 20 : bud.kWY;
        }
        if (bud.MaR != null && bud.MaR.size() > 0) {
            k kVar = dVar.kWU;
            dko dko = bud.MaR.get(0);
            p.g(dko, "response.recommend_card_list[0]");
            dko dko2 = dko;
            p.h(dko2, "<set-?>");
            kVar.kXH = dko2;
            dVar.byK().addAll(bud.MaR);
            dVar.kWZ++;
        }
        LinkedList<dko> linkedList = bud.MaR;
        p.g(linkedList, "response.recommend_card_list");
        dVar.a(0, linkedList, bud.kWY);
        AppMethodBeat.o(50329);
    }
}
