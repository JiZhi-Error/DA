package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.report.g;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b*\u0001\u001b\u0018\u0000 ;2\u00020\u0001:\u0005:;<=>BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0003J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\"H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020&H\u0002J\u001a\u0010,\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020/H\u0002J*\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020*H\u0002J\u000e\u00106\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0014J \u00107\u001a\u00020!2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u000204H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;", "", "tabType", "", "pullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isPreload", "", "(IILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/util/List;Z)V", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "interceptors", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/OrderInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "streamCgi", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1;", "addInterceptor", "interceptor", "order", "buildBaseRequest", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "buildPartialExposeRequest", "buildRedDotRequest", "buildResponse", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "buildStatsRequest", "buildUnreadRequest", "createFinderStreamResponseEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", LocaleUtil.ITALIAN, "mergeResp", "streamResponse", "historyResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "onCgiBack", "errType", "errCode", "errMsg", "", "resp", "removeInterceptor", "run", "showErrorToast", "tip", "Callback", "Companion", "FinderStreamHistoryCgi", "FinderStreamRequestEx", "FinderStreamResponseEx", "plugin-finder_release"})
public final class aa {
    public static final c ttP = new c((byte) 0);
    private final int dLS;
    private final com.tencent.mm.bw.b lastBuffer;
    private final boolean ltW;
    private final int pullType;
    private final List<FinderObject> tsE;
    private b ttJ;
    private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK;
    private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.cgi.interceptor.g<com.tencent.mm.plugin.finder.cgi.interceptor.f>> ttL;
    private final e ttM;
    private final j ttN;
    private final bbn ttO;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J8\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
    public interface b {
        void a(int i2, int i3, String str, f fVar, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> list);

        void a(bcz bcz);

        boolean a(dpc dpc);

        boolean cXU();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "()V", "historyRequest", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "getHistoryRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;", "setHistoryRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryRequest;)V", "isBeginHistory", "", "()Z", "setBeginHistory", "(Z)V", "plugin-finder_release"})
    public static final class e extends bcz {
        asj ttT;
        boolean ttU;
    }

    static {
        AppMethodBeat.i(242278);
        AppMethodBeat.o(242278);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.tencent.mm.protocal.protobuf.FinderObject> */
    /* JADX WARN: Multi-variable type inference failed */
    public aa(int i2, int i3, com.tencent.mm.bw.b bVar, bbn bbn, List<? extends FinderObject> list, boolean z) {
        AppMethodBeat.i(242277);
        this.dLS = i2;
        this.pullType = i3;
        this.lastBuffer = bVar;
        this.ttO = bbn;
        this.tsE = list;
        this.ltW = z;
        this.ttL = new ConcurrentLinkedQueue<>();
        com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, this.dLS, this.pullType, this.ttO);
        this.ttM = new e();
        this.ttN = new j(this, this.ttO);
        AppMethodBeat.o(242277);
    }

    public static final /* synthetic */ f a(aa aaVar, bda bda) {
        AppMethodBeat.i(242284);
        f a2 = aaVar.a(bda);
        AppMethodBeat.o(242284);
        return a2;
    }

    public static final /* synthetic */ void a(aa aaVar, int i2, int i3, String str, f fVar) {
        AppMethodBeat.i(242281);
        aaVar.a(i2, i3, str, fVar);
        AppMethodBeat.o(242281);
    }

    public static final /* synthetic */ b b(aa aaVar) {
        AppMethodBeat.i(242279);
        b bVar = aaVar.ttJ;
        if (bVar == null) {
            p.btv("callback");
        }
        AppMethodBeat.o(242279);
        return bVar;
    }

    public static final /* synthetic */ com.tencent.mm.vending.e.c f(aa aaVar) {
        AppMethodBeat.i(242283);
        com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> cVar = aaVar.ttK;
        if (cVar == null) {
            p.btv("lifeCycleKeeper");
        }
        AppMethodBeat.o(242283);
        return cVar;
    }

    public /* synthetic */ aa(int i2, int i3, com.tencent.mm.bw.b bVar, bbn bbn, List list) {
        this(i2, i3, bVar, bbn, list, false);
    }

    public final aa a(com.tencent.mm.plugin.finder.cgi.interceptor.f fVar, int i2) {
        AppMethodBeat.i(242273);
        p.h(fVar, "interceptor");
        this.ttL.add(new com.tencent.mm.plugin.finder.cgi.interceptor.g<>(fVar, i2));
        AppMethodBeat.o(242273);
        return this;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000e¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "()V", "afterFeedIdHistory", "", "getAfterFeedIdHistory", "()J", "setAfterFeedIdHistory", "(J)V", "continueFlag", "", "getContinueFlag", "()I", "setContinueFlag", "(I)V", "historySize", "getHistorySize", "setHistorySize", "isFetchHistory", "", "()Z", "setFetchHistory", "(Z)V", "requestEx", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "getRequestEx", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;", "setRequestEx", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamRequestEx;)V", "streamSize", "getStreamSize", "setStreamSize", "plugin-finder_release"})
    public static final class f extends bda {
        public int continueFlag = 1;
        public int kxF = -1;
        public int ttV;
        public long ttW = -1;
        public boolean ttX;
        public e ttY;

        public final void a(e eVar) {
            AppMethodBeat.i(242266);
            p.h(eVar, "<set-?>");
            this.ttY = eVar;
            AppMethodBeat.o(242266);
        }

        public final e cXX() {
            AppMethodBeat.i(242265);
            e eVar = this.ttY;
            if (eVar == null) {
                p.btv("requestEx");
            }
            AppMethodBeat.o(242265);
            return eVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(242261);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.order), Integer.valueOf(t2.order));
            AppMethodBeat.o(242261);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class g<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(242267);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.order), Integer.valueOf(t2.order));
            AppMethodBeat.o(242267);
            return a2;
        }
    }

    private final void a(int i2, int i3, String str, f fVar) {
        AppMethodBeat.i(242274);
        Log.i("Finder.FinderStream", "onCgiBack tabType=" + this.dLS + " pullType:" + this.pullType);
        com.tencent.mm.plugin.finder.preload.a aVar = com.tencent.mm.plugin.finder.preload.a.uTO;
        baw baw = fVar.preloadInfo;
        LinkedList linkedList = fVar.object;
        p.g(linkedList, "resp.`object`");
        com.tencent.mm.plugin.finder.preload.a.a(baw, linkedList, 3901);
        List<com.tencent.mm.plugin.finder.cgi.interceptor.g> a2 = kotlin.a.j.a((Iterable) this.ttL, (Comparator) new a());
        ArrayList<com.tencent.mm.plugin.finder.cgi.interceptor.f> arrayList = new ArrayList(kotlin.a.j.a(a2, 10));
        for (com.tencent.mm.plugin.finder.cgi.interceptor.g gVar : a2) {
            arrayList.add(gVar.txH);
        }
        for (com.tencent.mm.plugin.finder.cgi.interceptor.f fVar2 : arrayList) {
            fVar2.a(fVar);
        }
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.d(this.dLS, this.ttO);
        }
        b bVar = this.ttJ;
        if (bVar == null) {
            p.btv("callback");
        }
        List<com.tencent.mm.plugin.finder.cgi.interceptor.g> a3 = kotlin.a.j.a((Iterable) this.ttL, (Comparator) new g());
        ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(a3, 10));
        for (com.tencent.mm.plugin.finder.cgi.interceptor.g gVar2 : a3) {
            arrayList2.add(gVar2.txH);
        }
        bVar.a(i2, i3, str, fVar, kotlin.a.j.p(arrayList2));
        AppMethodBeat.o(242274);
    }

    public final void a(com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> cVar, b bVar) {
        f JP;
        boolean z;
        AppMethodBeat.i(242275);
        p.h(bVar, "callback");
        com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, this.dLS, true, null, 12);
        this.ttJ = bVar;
        if (cVar == null) {
            cVar = new com.tencent.mm.vending.e.c<>();
        }
        this.ttK = cVar;
        this.ttM.ttU = bVar.cXU();
        if (this.ttM.ttU) {
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.ao(this.dLS, true);
            com.tencent.mm.co.f aYI = new d(null, this.lastBuffer).aYI();
            com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> cVar2 = this.ttK;
            if (cVar2 == null) {
                p.btv("lifeCycleKeeper");
            }
            aYI.a(cVar2);
            AppMethodBeat.o(242275);
            return;
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.preload.tabPreload.f JL = ((FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).JL(this.dLS);
        boolean z2 = (this.pullType == 1 || this.pullType == 0) ? false : true;
        if (this.ltW || z2) {
            if (z2 && JL != null) {
                JL.nM(true);
            }
            bVar.a(this.ttM);
            com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, this.dLS);
            this.ttN.aYI();
            AppMethodBeat.o(242275);
        } else if (JL == null || (JP = JL.JP(this.pullType)) == null) {
            aa aaVar = this;
            bVar.a(aaVar.ttM);
            com.tencent.mm.plugin.finder.report.h.a(com.tencent.mm.plugin.finder.report.h.veu, aaVar.dLS);
            aaVar.ttN.aYI();
            AppMethodBeat.o(242275);
        } else {
            MediaPreloadCore.a aVar2 = MediaPreloadCore.uTV;
            if (MediaPreloadCore.dlF()) {
                com.tencent.mm.ac.d.h(new h(this));
            }
            Log.i("Finder.FinderStream", "[run] use preload cache. tabType=" + this.dLS + ' ');
            com.tencent.mm.plugin.finder.report.h hVar2 = com.tencent.mm.plugin.finder.report.h.veu;
            h.a Kd = com.tencent.mm.plugin.finder.report.h.Kd(this.dLS);
            if (Kd != null) {
                if (!Kd.ZA || Kd.vev || Kd.vfh != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    Kd = null;
                }
                if (Kd != null) {
                    Kd.vfc = 1;
                }
            }
            a(0, 0, null, JP);
            AppMethodBeat.o(242275);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J4\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, hxF = {"com/tencent/mm/plugin/finder/cgi/CgiFinderStream$streamCgi$1", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "actionExt", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class j extends an<bda> {
        private final JSONObject ttQ = new JSONObject();
        final /* synthetic */ aa ttS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(aa aaVar, bbn bbn) {
            super(bbn);
            Integer num;
            String mD5String;
            byte[] bArr = null;
            this.ttS = aaVar;
            AppMethodBeat.i(242272);
            aa.a(aaVar, (bcz) aaVar.ttM);
            aa.b(aaVar, aaVar.ttM);
            aa.a(aaVar, aaVar.ttM);
            aa.c(aaVar, aaVar.ttM);
            aa.d(aaVar, aaVar.ttM);
            d.a aVar = new d.a();
            aVar.c(aaVar.ttM);
            aVar.d(aa.cXT());
            aVar.MB("/cgi-bin/micromsg-bin/finderstream");
            aVar.sG(3901);
            com.tencent.mm.ak.d aXF = aVar.aXF();
            StringBuilder append = new StringBuilder("[CgiFetchFinderTimeline#init] tabType=").append(aaVar.dLS).append(" pullType=").append(aaVar.pullType).append(" lastBuffer=");
            com.tencent.mm.bw.b bVar = aaVar.ttM.lastBuffer;
            if (bVar != null) {
                num = Integer.valueOf(bVar.zy.length);
            } else {
                num = null;
            }
            StringBuilder append2 = append.append(num).append(", ");
            if (aaVar.ttM.lastBuffer == null) {
                mD5String = BuildConfig.COMMAND;
            } else {
                com.tencent.mm.bw.b bVar2 = aaVar.ttM.lastBuffer;
                mD5String = MD5Util.getMD5String(bVar2 != null ? bVar2.zy : bArr);
            }
            Log.i("Finder.FinderStream", append2.append(mD5String).append(" longitude=").append(aaVar.ttM.dTj).append(" latitude=").append(aaVar.ttM.latitude).toString());
            c(aXF);
            AppMethodBeat.o(242272);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.finder.cgi.an
        public final /* synthetic */ void b(int i2, int i3, String str, bda bda, q qVar) {
            LinkedList<bcu> linkedList;
            String str2;
            AppMethodBeat.i(242271);
            bda bda2 = bda;
            p.h(bda2, "resp");
            com.tencent.mm.plugin.finder.report.h.b(com.tencent.mm.plugin.finder.report.h.veu, this.ttS.dLS);
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.a(this.ttS.dLS, false, bda2.LCV);
            boolean a2 = aa.b(this.ttS).a(bda2);
            boolean z = bda2.LMH != 0;
            boolean z2 = bda2.tUB > 0;
            boolean z3 = bda2.LMG > 0;
            int size = bda2.object.size();
            com.tencent.mm.plugin.finder.report.h hVar2 = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.gd(this.ttS.dLS, size);
            Log.i("Finder.FinderStream", "[onCgiBack#streamCgi] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + ' ' + "isGetHistory=" + z2 + " isNeedClear=" + z3 + " isFetchHistoryNow=" + z + " list=" + size + " isPreload=" + this.ttS.ltW + " tabType=" + this.ttS.dLS + " pullType=" + this.ttS.pullType + " isConsume=" + a2 + ' ' + "interval_conf=" + (bda2.LMO != null));
            this.ttQ.put("getHistoryNow", bda2.LMH);
            this.ttQ.put("isGetHistory", z2);
            this.ttQ.put("needClear", bda2.LMG);
            this.ttQ.put("size", size);
            if (!a2) {
                if (i2 == 0 && i3 == 0) {
                    if (size <= 0 && !z2) {
                        aa.asM("size <= 0 && !isGetHistory");
                    }
                    if (!z3 && size > 0 && this.ttS.pullType != 2) {
                        aa.asM("!isNeedClear && size > 0 && pullType != PULL_TYPE_BOTTOM");
                    }
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 150, 1, false);
                } else if (i2 == 4) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 151, 1, false);
                } else {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 152, 1, false);
                }
                StringBuilder append = new StringBuilder("[onCgiBack#streamCgi] isPreload=").append(this.ttS.ltW).append(" tabType=").append(this.ttS.dLS).append(", tabTipsObjectId=").append(this.ttS.ttM.LMx).append(", ");
                al alVar = al.tuv;
                Log.i("Finder.FinderStream", append.append(al.dQ(bda2.object)).append('}').toString());
                bcx bcx = bda2.tUH;
                if (!(bcx == null || (linkedList = bcx.LEy) == null)) {
                    for (T t : linkedList) {
                        switch (t.tQR) {
                            case 0:
                                str2 = "hotTabList";
                                break;
                            case 1:
                                str2 = "liveList";
                                break;
                            case 2:
                                str2 = "albumList";
                                break;
                            default:
                                str2 = "others";
                                break;
                        }
                        StringBuilder append2 = new StringBuilder("[onCgiBack#streamCgi] layoutType:").append(t.tQR).append(", ").append(str2).append(':');
                        al alVar2 = al.tuv;
                        Log.i("Finder.FinderStream", append2.append(al.dQ(t.object)).toString());
                    }
                }
                if (i2 != 0 || i3 != 0 || !z2 || !z) {
                    f a3 = aa.a(this.ttS, bda2);
                    a3.continueFlag = 1;
                    aa.a(this.ttS, i2, i3, str, a3);
                } else {
                    com.tencent.mm.plugin.finder.report.h hVar3 = com.tencent.mm.plugin.finder.report.h.veu;
                    com.tencent.mm.plugin.finder.report.h.ao(this.ttS.dLS, true);
                    com.tencent.mm.plugin.finder.report.h hVar4 = com.tencent.mm.plugin.finder.report.h.veu;
                    com.tencent.mm.plugin.finder.report.h.ap(this.ttS.dLS, true);
                    new d(bda2, bda2.lastBuffer).aYI().a(aa.f(this.ttS));
                    AppMethodBeat.o(242271);
                    return;
                }
            }
            AppMethodBeat.o(242271);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
        public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
            return com.tencent.mm.plugin.finder.cgi.report.b.Enable;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
        public final JSONObject cXV() {
            AppMethodBeat.i(242270);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tabType", this.ttS.dLS);
            jSONObject.put("pullType", this.ttS.pullType);
            AppMethodBeat.o(242270);
            return jSONObject;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
        public final JSONObject cXW() {
            return this.ttQ;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.an
        public final boolean cXQ() {
            return true;
        }
    }

    private final f a(bda bda) {
        AppMethodBeat.i(242276);
        f fVar = new f();
        fVar.a(this.ttM);
        fVar.LMF = bda.LMF;
        fVar.LME = bda.LME;
        fVar.object.addAll(bda.object);
        fVar.liveObjects.addAll(bda.liveObjects);
        fVar.tUB = bda.tUB;
        fVar.LMG = bda.LMG;
        fVar.LMH = bda.LMH;
        fVar.preloadInfo = bda.preloadInfo;
        fVar.LMK = bda.LMK;
        fVar.LMI = bda.LMI;
        fVar.LMM = bda.LMM;
        fVar.LMJ = bda.LMJ;
        fVar.LML = bda.LML;
        fVar.lastBuffer = bda.lastBuffer;
        fVar.ttV = bda.object.size();
        fVar.LMN = bda.LMN;
        fVar.tvs = bda.tvs;
        fVar.LMO = bda.LMO;
        fVar.tUH = bda.tUH;
        AppMethodBeat.o(242276);
        return fVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J4\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamHistoryCgi;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream;Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;Lcom/tencent/mm/protobuf/ByteString;)V", "resultExt", "Lorg/json/JSONObject;", "getResultExt", "()Lorg/json/JSONObject;", "actionExt", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public final class d extends an<ask> {
        private final JSONObject ttQ = new JSONObject();
        private bda ttR;

        public d(bda bda, com.tencent.mm.bw.b bVar) {
            AppMethodBeat.i(242264);
            this.ttR = bda;
            d.a aVar = new d.a();
            asj asj = new asj();
            aa.this.ttM.ttT = asj;
            asj.LAt = z.aUg();
            asj.dLS = aa.this.dLS;
            asj.LDs = bVar;
            Log.i("Finder.FinderStream", "[request#historyCgi] isPreload=" + aa.this.ltW + " tabType=" + aa.this.dLS + " pullType=" + aa.this.pullType + " lastBuffer=" + (bVar == null ? BuildConfig.COMMAND : MD5Util.getMD5String(bVar.zy)));
            am amVar = am.tuw;
            asj.uli = am.a(this.ttO);
            aVar.c(asj);
            ask ask = new ask();
            ask.setBaseResponse(new BaseResponse());
            ask.getBaseResponse().ErrMsg = new dqi();
            aVar.d(ask);
            aVar.MB("/cgi-bin/micromsg-bin/findergethistory");
            aVar.sG(3814);
            c(aVar.aXF());
            AppMethodBeat.o(242264);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.finder.cgi.an
        public final /* synthetic */ void b(int i2, int i3, String str, ask ask, q qVar) {
            long j2;
            LinkedList<FinderObject> linkedList;
            FinderObject finderObject;
            AppMethodBeat.i(242262);
            ask ask2 = ask;
            p.h(ask2, "resp");
            com.tencent.mm.plugin.finder.report.h.b(com.tencent.mm.plugin.finder.report.h.veu, aa.this.dLS);
            this.ttQ.put("size", ask2.object.size());
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.ao(aa.this.dLS, false);
            boolean a2 = aa.b(aa.this).a(ask2);
            if (a2) {
                Log.w("Finder.FinderStream", "[onCgiBack#historyCgi] return! isPreload=" + aa.this.ltW + " tabType=" + aa.this.dLS + " pullType=" + aa.this.pullType + " errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " isConsume=" + a2);
                AppMethodBeat.o(242262);
                return;
            }
            f a3 = aa.a(aa.this, this.ttR, ask2);
            if (!aa.this.ttM.ttU) {
                bda bda = this.ttR;
                if (bda == null || (linkedList = bda.object) == null || (finderObject = (FinderObject) kotlin.a.j.kv(linkedList)) == null) {
                    j2 = -1;
                } else {
                    j2 = finderObject.id;
                }
                a3.ttW = j2;
            }
            a3.kxF = ask2.object.size();
            com.tencent.mm.plugin.finder.report.h hVar2 = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.gd(aa.this.dLS, a3.kxF);
            a3.ttX = true;
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 153, 1, false);
            } else if (i2 == 4) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 154, 1, false);
            } else {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 155, 1, false);
            }
            StringBuilder append = new StringBuilder("[onCgiBack#historyCgi] errCode=").append(i3).append(" errMsg=").append(str).append(" isConsume=").append(a2).append(", isPreload=").append(aa.this.ltW).append(" tabType=").append(aa.this.dLS).append(" pullType=").append(aa.this.pullType).append(", historySize=").append(a3.kxF).append(" continue_flag=").append(ask2.tUC).append(' ');
            al alVar = al.tuv;
            Log.i("Finder.FinderStream", append.append(al.dQ(ask2.object)).toString());
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            int i4 = aa.this.dLS;
            LinkedList<FinderObject> linkedList2 = ask2.object;
            p.g(linkedList2, "resp.`object`");
            e.a.m(i4, linkedList2);
            aa.a(aa.this, i2, i3, str, a3);
            AppMethodBeat.o(242262);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
        public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
            return com.tencent.mm.plugin.finder.cgi.report.b.Enable;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
        public final JSONObject cXV() {
            AppMethodBeat.i(242263);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tabType", aa.this.dLS);
            jSONObject.put("pullType", aa.this.pullType);
            AppMethodBeat.o(242263);
            return jSONObject;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
        public final JSONObject cXW() {
            return this.ttQ;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.an
        public final boolean cXQ() {
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/cgi/CgiFinderStream$run$1$1"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ aa ttS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(aa aaVar) {
            super(0);
            this.ttS = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242268);
            if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                Context context = MMApplicationContext.getContext();
                StringBuilder sb = new StringBuilder("[run] use preload cache. tabType=");
                y yVar = y.vXH;
                u.makeText(context, sb.append(y.LP(this.ttS.dLS)).toString(), 1).show();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(242268);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ String hRn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(String str) {
            super(0);
            this.hRn = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242269);
            Toast.makeText(MMApplicationContext.getContext(), String.valueOf(this.hRn), 1).show();
            x xVar = x.SXb;
            AppMethodBeat.o(242269);
            return xVar;
        }
    }

    public static final /* synthetic */ f a(aa aaVar, bda bda, ask ask) {
        f fVar;
        LinkedList<bax> linkedList;
        baw baw;
        LinkedList<bax> linkedList2;
        AppMethodBeat.i(242280);
        if (bda != null) {
            fVar = aaVar.a(bda);
        } else {
            fVar = new f();
        }
        fVar.a(aaVar.ttM);
        fVar.object.addAll(ask.object);
        fVar.continueFlag = ask.tUC;
        fVar.lastBuffer = ask.LDs;
        baw baw2 = fVar.preloadInfo;
        if (baw2 == null) {
            baw2 = new baw();
        }
        fVar.preloadInfo = baw2;
        baw baw3 = fVar.preloadInfo;
        if (baw3 != null) {
            baw baw4 = ask.preloadInfo;
            baw3.uUw = baw4 != null ? baw4.uUw : 0;
        }
        baw baw5 = fVar.preloadInfo;
        if (baw5 != null) {
            baw baw6 = ask.preloadInfo;
            baw5.LKz = baw6 != null ? baw6.LKz : null;
        }
        baw baw7 = ask.preloadInfo;
        if (!(baw7 == null || (linkedList = baw7.LKA) == null || (baw = fVar.preloadInfo) == null || (linkedList2 = baw.LKA) == null)) {
            linkedList2.addAll(linkedList);
        }
        AppMethodBeat.o(242280);
        return fVar;
    }

    public static final /* synthetic */ void asM(String str) {
        AppMethodBeat.i(242282);
        Log.e("Finder.FinderStream", str);
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            com.tencent.mm.ac.d.h(new i(str));
        }
        AppMethodBeat.o(242282);
    }

    public static final /* synthetic */ void a(aa aaVar, bcz bcz) {
        AppMethodBeat.i(242285);
        bcz.lastBuffer = aaVar.lastBuffer;
        bcz.pullType = aaVar.pullType;
        bcz.dLS = aaVar.dLS;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        bcz.dTj = dHP.first.floatValue();
        bcz.latitude = dHP.second.floatValue();
        bcz.LMw = 1;
        AppMethodBeat.o(242285);
    }

    public static final /* synthetic */ void b(aa aaVar, bcz bcz) {
        AppMethodBeat.i(242286);
        if ((aaVar.pullType == 1 || aaVar.pullType == 0) && (aaVar.dLS == 1 || aaVar.dLS == 3 || aaVar.dLS == 4)) {
            FinderStreamPartialExposeUIC.a aVar = FinderStreamPartialExposeUIC.wAt;
            long MH = FinderStreamPartialExposeUIC.a.MH(aaVar.dLS);
            e.a aVar2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            boolean al = e.a.al(aaVar.dLS, MH);
            if (!al) {
                bcz.LMz = MH;
            }
            Log.i("Finder.FinderStream", "[request] tabType=" + aaVar.dLS + " isHistoryFeed=" + al + " partialExposedObjectId=" + bcz.LMz);
        }
        AppMethodBeat.o(242286);
    }

    public static final /* synthetic */ void a(aa aaVar, e eVar) {
        boolean z;
        AppMethodBeat.i(242287);
        if (aaVar.pullType == 1 || aaVar.pullType == 0 || aaVar.pullType == 5 || aaVar.pullType == 7 || aaVar.pullType == 8 || aaVar.pullType == 6) {
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.f redDotManager = ((PluginFinder) ah).getRedDotManager();
            String Ix = com.tencent.mm.plugin.finder.extension.reddot.f.Ix(aaVar.dLS);
            bbj ata = redDotManager.ata(Ix);
            boolean z2 = ata != null;
            if (ata != null) {
                eVar.LMx = ata.object_id;
                eVar.LMy = ata.object_nonce_id;
                eVar.LMC = ata.username;
                eVar.tabTipsByPassInfo = ata.tabTipsByPassInfo;
                eVar.LFm = "FinderEntrance";
            } else {
                k asX = redDotManager.asX("FinderEntrance");
                if (asX != null) {
                    bbj bbj = asX.tLm;
                    eVar.LMx = bbj.object_id;
                    eVar.LMy = bbj.object_nonce_id;
                    eVar.LMC = bbj.username;
                    eVar.tabTipsByPassInfo = bbj.tabTipsByPassInfo;
                    eVar.LFm = "FinderEntrance";
                } else {
                    k asX2 = redDotManager.asX(Ix);
                    if (asX2 != null) {
                        bbj bbj2 = asX2.tLm;
                        eVar.LMx = bbj2.object_id;
                        eVar.LMy = bbj2.object_nonce_id;
                        eVar.LMC = bbj2.username;
                        eVar.tabTipsByPassInfo = bbj2.tabTipsByPassInfo;
                        eVar.LFm = Ix;
                    }
                }
            }
            StringBuilder append = new StringBuilder("[buildRedDotRequest] tabType=").append(aaVar.dLS).append(" isEnterRequest=").append(z2).append(" tab_tips_path=").append(eVar.LFm).append(' ').append("tabTipsUsername=").append(eVar.LMC).append(" tabTipsByPassInfo=");
            if (eVar.tabTipsByPassInfo != null) {
                z = true;
            } else {
                z = false;
            }
            Log.i("Finder.FinderStream", append.append(z).append(' ').append("objectId=").append(com.tencent.mm.ac.d.zs(eVar.LMx)).append(' ').toString());
        }
        AppMethodBeat.o(242287);
    }

    public static final /* synthetic */ void c(aa aaVar, bcz bcz) {
        ArrayList arrayList;
        StringBuilder sb;
        ArrayList arrayList2;
        List<FinderObject> value;
        Integer num = null;
        AppMethodBeat.i(242288);
        am amVar = am.tuw;
        bcz.uli = am.a(aaVar.ttO);
        String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        bcz.sessionId = cMD;
        apc apc = new apc();
        apc.osName = com.tencent.mm.protocal.d.KyL;
        apc.osVersion = com.tencent.mm.protocal.d.KyM;
        apc.deviceBrand = com.tencent.mm.protocal.d.KyI;
        apc.deviceModel = com.tencent.mm.protocal.d.KyJ;
        apc.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        apc.netType = com.tencent.mm.plugin.finder.report.k.dod();
        apc.LBf = CdnLogic.getRecentAverageSpeed(2);
        b.a aVar = com.tencent.mm.plugin.finder.video.reporter.b.whK;
        apc.LBg = com.tencent.mm.plugin.finder.video.reporter.b.dFY();
        apc.LBh.add("h264");
        if (com.tencent.mm.modelcontrol.e.sX(4)) {
            apc.LBh.add("h265");
        }
        if (aaVar.dLS == 4) {
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            FinderStreamCardVM finderStreamCardVM = (FinderStreamCardVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class);
            Map.Entry<String, List<FinderObject>> entry = null;
            for (Map.Entry<String, List<FinderObject>> entry2 : finderStreamCardVM.wuD.entrySet()) {
                if (!(!entry2.getValue().isEmpty())) {
                    entry2 = entry;
                }
                entry = entry2;
            }
            StringBuilder append = new StringBuilder("[getThisReadStats] entry is null? ").append(entry == null).append(" list=");
            if (entry == null || (value = entry.getValue()) == null) {
                arrayList = null;
                sb = append;
            } else {
                List<FinderObject> list = value;
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList3.add(com.tencent.mm.ac.d.zs(it.next().id));
                }
                arrayList = arrayList3;
                sb = append;
            }
            Log.i("Finder.StreamCardVM", sb.append(arrayList).toString());
            if (entry != null) {
                finderStreamCardVM.wuD.put(entry.getKey(), new LinkedList());
                List<FinderObject> value2 = entry.getValue();
                if (value2 != null) {
                    List<FinderObject> list2 = value2;
                    ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(list2, 10));
                    for (T t : list2) {
                        cmm cmm = new cmm();
                        cmm.hFK = t.id;
                        cmm.MrI = 20;
                        cmm.sessionBuffer = t.sessionBuffer;
                        cmm.scene = 6;
                        cmm.pHw = 4;
                        arrayList4.add(cmm);
                    }
                    arrayList2 = arrayList4;
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList2 = null;
            }
            StringBuilder append2 = new StringBuilder("[buildStatsRequest] pullType=").append(aaVar.pullType).append(" readStats=");
            if (arrayList2 != null) {
                num = Integer.valueOf(arrayList2.size());
            }
            Log.i("Finder.FinderStream", append2.append(num).toString());
            if (arrayList2 == null) {
                as asVar = as.uOL;
                bcz.LIs = as.Jt(aaVar.dLS);
            } else {
                bcz.LIs = new LinkedList<>(arrayList2);
                bcz.LMB = 1;
            }
        } else {
            bbn bbn = aaVar.ttO;
            int i2 = bbn != null ? bbn.tCE : -1;
            com.tencent.mm.plugin.finder.nearby.report.c cVar = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
            if (!com.tencent.mm.plugin.finder.nearby.report.c.JG(i2) || aaVar.pullType != 1) {
                as asVar2 = as.uOL;
                bcz.LIs = as.Jt(aaVar.dLS);
            } else {
                LinkedList<cmm> linkedList = bcz.LIs;
                com.tencent.mm.plugin.finder.nearby.report.c cVar2 = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
                linkedList.addAll(com.tencent.mm.plugin.finder.nearby.report.c.JF(i2));
            }
        }
        bcz.LAv = apc;
        g.a aVar3 = com.tencent.mm.plugin.finder.report.g.vek;
        LinkedList<ecq> Kc = g.a.Kc(aaVar.dLS);
        if (Kc != null) {
            bcz.LEw = Kc;
            AppMethodBeat.o(242288);
            return;
        }
        AppMethodBeat.o(242288);
    }

    public static final /* synthetic */ void d(aa aaVar, bcz bcz) {
        String str;
        FinderObjectDesc finderObjectDesc;
        AppMethodBeat.i(242289);
        if (aaVar.tsE != null) {
            StringBuilder append = new StringBuilder("[buildUnreadRequest] tabType=").append(aaVar.dLS).append(" unreadList=");
            List<FinderObject> list = aaVar.tsE;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
            for (T t : list) {
                StringBuilder append2 = new StringBuilder().append(com.tencent.mm.ac.d.zs(t.id)).append(' ');
                y yVar = y.vXH;
                if (t == null || (finderObjectDesc = t.objectDesc) == null || (str = finderObjectDesc.description) == null) {
                    str = "";
                }
                arrayList.add(append2.append(y.awq(str)).toString());
            }
            Log.i("Finder.FinderStream", append.append(arrayList).toString());
            LinkedList<bdv> linkedList = bcz.LMA;
            List<FinderObject> list2 = aaVar.tsE;
            ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list2, 10));
            for (T t2 : list2) {
                bdv bdv = new bdv();
                bdv.hFK = t2.id;
                bdv.objectNonceId = t2.objectNonceId;
                bdv.dLS = aaVar.dLS;
                bdv.sessionBuffer = t2.sessionBuffer;
                arrayList2.add(bdv);
            }
            linkedList.addAll(arrayList2);
            AppMethodBeat.o(242289);
            return;
        }
        bbn bbn = aaVar.ttO;
        int i2 = bbn != null ? bbn.tCE : -1;
        com.tencent.mm.plugin.finder.nearby.report.c cVar = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
        if (com.tencent.mm.plugin.finder.nearby.report.c.JG(i2) && aaVar.pullType == 1) {
            LinkedList<bdv> linkedList2 = bcz.LMA;
            com.tencent.mm.plugin.finder.nearby.report.c cVar2 = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
            linkedList2.addAll(com.tencent.mm.plugin.finder.nearby.report.c.gb(i2, aaVar.dLS));
        }
        AppMethodBeat.o(242289);
    }

    public static final /* synthetic */ bda cXT() {
        AppMethodBeat.i(242290);
        bda bda = new bda();
        bda.setBaseResponse(new BaseResponse());
        bda.getBaseResponse().ErrMsg = new dqi();
        AppMethodBeat.o(242290);
        return bda;
    }
}
