package com.tencent.mm.plugin.finder.nearby.video;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.cgi.interceptor.d;
import com.tencent.mm.plugin.finder.cgi.interceptor.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.tabPreload.FinderStreamTabPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006JJ\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\b2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#J0\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u001a\u001a\u00020\u001bJD\u0010-\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010 2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0002J\u0006\u0010/\u001a\u00020)R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "isGetHistory", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "pageDataBuffer", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "getPageDataBuffer", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "getTabType", "()I", "fetch", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "isPreloadMore", "unreadList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "fetchHotRelatedList", "feedId", "", "nonceId", "", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "innerFetch", "lb", "uniqueId", "Companion", "plugin-finder_release"})
public final class b extends com.tencent.mm.plugin.finder.life.a {
    public static final a uTr = new a((byte) 0);
    final int dLS;
    com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK = new com.tencent.mm.vending.e.c<>();
    private final bbn ttO;
    private volatile boolean twZ;
    private final com.tencent.mm.plugin.finder.feed.model.internal.l<bo, com.tencent.mm.plugin.finder.feed.model.b> txr = new com.tencent.mm.plugin.finder.feed.model.internal.l<>(null, String.valueOf(this.dLS), 1);

    static {
        AppMethodBeat.i(249365);
        AppMethodBeat.o(249365);
    }

    public b(int i2, bbn bbn) {
        AppMethodBeat.i(249364);
        this.dLS = i2;
        this.ttO = bbn;
        AppMethodBeat.o(249364);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(b bVar, ab.a aVar, int i2, ab.c cVar, boolean z, List list) {
        AppMethodBeat.i(249362);
        p.h(aVar, "callback");
        Log.i("Finder.NearbyVideoFeedFetcher", "[fetch] pullType=" + i2 + " tabType=" + bVar.dLS + " isPreloadMore=" + z + ", isGetHistory=" + bVar.twZ);
        bVar.a(new C1248b(aVar), i2, cVar, list);
        AppMethodBeat.o(249362);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.nearby.video.b$b  reason: collision with other inner class name */
    public static final class C1248b implements ab.a {
        final /* synthetic */ ab.a txo;

        C1248b(ab.a aVar) {
            this.txo = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.ab.a
        public final void a(com.tencent.mm.plugin.finder.feed.model.b bVar, int i2) {
            AppMethodBeat.i(249357);
            p.h(bVar, "info");
            this.txo.a(bVar, i2);
            AppMethodBeat.o(249357);
        }
    }

    private final void a(ab.a aVar, int i2, ab.c cVar, List<? extends BaseFinderFeed> list) {
        int i3;
        int i4;
        ArrayList arrayList = null;
        AppMethodBeat.i(249363);
        if (i2 == 0 || i2 == 1) {
            this.twZ = false;
        }
        Log.i("Finder.NearbyVideoFeedFetcher", "[innerFetch] use tabType=" + this.dLS + " GlobalLastBuffer");
        if (i2 == 0) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            ao azQ = aAh.azQ();
            y yVar = y.vXH;
            azQ.set(y.LK(this.dLS), (Object) null);
        }
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        ao azQ2 = aAh2.azQ();
        y yVar2 = y.vXH;
        Object obj = azQ2.get(y.LK(this.dLS), "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(249363);
            throw tVar;
        }
        com.tencent.mm.bw.b cD = com.tencent.mm.bw.b.cD(Util.decodeHexString((String) obj));
        int i5 = this.dLS;
        bbn bbn = this.ttO;
        if (list != null) {
            List<? extends BaseFinderFeed> list2 = list;
            ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().feedObject.getFeedObject());
            }
            arrayList = arrayList2;
            i3 = i2;
            i4 = i5;
        } else {
            i3 = i2;
            i4 = i5;
        }
        new aa(i4, i3, cD, bbn, arrayList).a(new com.tencent.mm.plugin.finder.cgi.interceptor.a(), 0).a(new d(), 1).a(new com.tencent.mm.plugin.finder.cgi.interceptor.c(), 2).a(new com.tencent.mm.plugin.finder.cgi.interceptor.b(), 3).a(this.ttK, new c(this, cVar, i2, true, aVar));
        AppMethodBeat.o(249363);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J8\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedFetcher$innerFetch$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
    public static final class c implements aa.b {
        final /* synthetic */ ab.c txj;
        final /* synthetic */ int txl;
        final /* synthetic */ ab.a txo;
        final /* synthetic */ boolean txw = true;
        final /* synthetic */ b uTs;

        c(b bVar, ab.c cVar, int i2, boolean z, ab.a aVar) {
            this.uTs = bVar;
            this.txj = cVar;
            this.txl = i2;
            this.txo = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.aa.b
        public final boolean cXU() {
            AppMethodBeat.i(249358);
            boolean z = this.uTs.twZ;
            AppMethodBeat.o(249358);
            return z;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.aa.b
        public final boolean a(dpc dpc) {
            AppMethodBeat.i(249359);
            p.h(dpc, "resp");
            ab.c cVar = this.txj;
            if (cVar != null) {
                boolean b2 = cVar.b(dpc);
                AppMethodBeat.o(249359);
                return b2;
            }
            AppMethodBeat.o(249359);
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.aa.b
        public final void a(bcz bcz) {
            AppMethodBeat.i(249360);
            p.h(bcz, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            AppMethodBeat.o(249360);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.aa.b
        public final void a(int i2, int i3, String str, aa.f fVar, List<? extends f> list) {
            boolean z;
            String encodeHexString;
            AppMethodBeat.i(249361);
            p.h(fVar, "resp");
            p.h(list, "interceptors");
            if (i2 == 0 && i3 == 0) {
                if (this.txl == 0) {
                    Log.i("Finder.NearbyVideoFeedFetcher", "tabType=" + this.uTs.dLS + " headWording=" + fVar.LME + " endWording=" + fVar.LMF + " prefetch_last_feed_count=" + fVar.LMI + " continueFlag:" + fVar.continueFlag);
                    e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    aAh.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_HEADER_WORDING_STRING_SYNC, fVar.LME);
                    e aAh2 = g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_FOOTER_WORDING_STRING_SYNC, fVar.LMF);
                    e aAh3 = g.aAh();
                    p.g(aAh3, "MMKernel.storage()");
                    aAh3.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_NUM_INT_SYNC, Integer.valueOf(fVar.LMI));
                }
                if (fVar.LMO != null) {
                    e aAh4 = g.aAh();
                    p.g(aAh4, "MMKernel.storage()");
                    ao azQ = aAh4.azQ();
                    ar.a aVar = ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_REFRESH_CONFIG_STRING_SYNC;
                    bcy bcy = fVar.LMO;
                    azQ.set(aVar, Util.encodeHexString(bcy != null ? bcy.toByteArray() : null));
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    ((FinderStreamTabPreloadCore) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamTabPreloadCore.class)).JM(this.uTs.dLS);
                }
                String string = MMApplicationContext.getResources().getString(R.string.da3);
                p.g(string, "MMApplicationContext.get…eline_history_header_tip)");
                e aAh5 = g.aAh();
                p.g(aAh5, "MMKernel.storage()");
                Object obj = aAh5.azQ().get(ar.a.USERINFO_FINDER_TIMELINE_HEADER_WORDING_STRING_SYNC, string);
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(249361);
                    throw tVar;
                }
                String str2 = (String) obj;
                String string2 = MMApplicationContext.getResources().getString(R.string.da2);
                p.g(string2, "MMApplicationContext.get…eline_history_footer_tip)");
                e aAh6 = g.aAh();
                p.g(aAh6, "MMKernel.storage()");
                Object obj2 = aAh6.azQ().get(ar.a.USERINFO_FINDER_TIMELINE_FOOTER_WORDING_STRING_SYNC, string2);
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(249361);
                    throw tVar2;
                }
                String str3 = (String) obj2;
                LinkedList linkedList = fVar.object;
                p.g(linkedList, "resp.`object`");
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : linkedList) {
                    FinderObject finderObject = (FinderObject) obj3;
                    y yVar = y.vXH;
                    p.g(finderObject, LocaleUtil.ITALIAN);
                    if (y.s(finderObject)) {
                        arrayList.add(obj3);
                    }
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2.size() < fVar.object.size()) {
                    Log.e("Finder.NearbyVideoFeedFetcher", "[onCgiBack] has filter some feed. valid=" + arrayList2.size() + " raw=" + fVar.object.size());
                }
                boolean z2 = fVar.LMG > 0;
                c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                y yVar2 = y.vXH;
                List<FinderItem> a2 = c.a.a(arrayList2, y.LL(this.uTs.dLS), this.uTs.ttO);
                ArrayList arrayList3 = new ArrayList(j.a(a2, 10));
                Iterator<T> it = a2.iterator();
                while (it.hasNext()) {
                    c.a aVar4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList3.add(c.a.s(it.next()));
                }
                LinkedList linkedList2 = new LinkedList(arrayList3);
                com.tencent.mm.plugin.finder.feed.model.b bVar = new com.tencent.mm.plugin.finder.feed.model.b(linkedList2, i2, i3, str);
                bVar.dLS = this.uTs.dLS;
                bVar.ttV = fVar.ttV;
                bVar.kxF = fVar.kxF;
                bVar.ttW = fVar.ttW;
                bVar.pullType = this.txl;
                bVar.tUI = str2;
                bVar.tQU = str3;
                bVar.tUC = fVar.continueFlag;
                bVar.tUA = arrayList2;
                bVar.tUD = fVar.ttX;
                bVar.twZ = this.uTs.twZ;
                bVar.lastBuffer = fVar.lastBuffer;
                bVar.preloadInfo = fVar.preloadInfo;
                bVar.tUF = fVar.LMM;
                bVar.tUB = fVar.tUB;
                if (fVar.LMG != 0) {
                    z = true;
                } else {
                    z = false;
                }
                bVar.isNeedClear = z;
                bVar.tUH = fVar.tUH;
                if (this.txl != 2) {
                    c.a aVar5 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    y yVar3 = y.vXH;
                    c.a.b(linkedList2, y.LL(this.uTs.dLS), z2);
                }
                if (this.txl == 0 || this.txl == 1) {
                    as asVar = as.uOL;
                    as.h(this.uTs.dLS, arrayList2);
                }
                if (this.txw) {
                    e aAh7 = g.aAh();
                    p.g(aAh7, "MMKernel.storage()");
                    ao azQ2 = aAh7.azQ();
                    y yVar4 = y.vXH;
                    ar.a LK = y.LK(this.uTs.dLS);
                    if (fVar.lastBuffer == null) {
                        encodeHexString = null;
                    } else {
                        com.tencent.mm.bw.b bVar2 = fVar.lastBuffer;
                        encodeHexString = Util.encodeHexString(bVar2 != null ? bVar2.toByteArray() : null);
                    }
                    azQ2.set(LK, encodeHexString);
                }
                this.uTs.twZ = fVar.ttX;
                this.txo.a(bVar, this.txl);
                AppMethodBeat.o(249361);
                return;
            }
            com.tencent.mm.plugin.finder.feed.model.b bVar3 = new com.tencent.mm.plugin.finder.feed.model.b(new LinkedList(), i2, i3, str);
            bVar3.dLS = this.uTs.dLS;
            bVar3.pullType = this.txl;
            bVar3.tUC = 1;
            bVar3.tUD = fVar.ttX;
            bVar3.lastBuffer = fVar.lastBuffer;
            this.txo.a(bVar3, this.txl);
            AppMethodBeat.o(249361);
        }
    }
}
