package com.tencent.mm.plugin.finder.cgi.fetcher;

import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.cgi.n;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u0003234B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J,\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&JR\u0010'\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00032\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\b\u0002\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0002J*\u0010-\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "getHistory", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getStream", "originPullType", "showErrorToast", "tip", "", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class b extends com.tencent.mm.plugin.finder.life.a {
    public static final c txc = new c((byte) 0);
    public final int dLS = 2;
    public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK;
    public final bbn ttO;
    public final C1092b twY;
    private volatile boolean twZ;
    public boolean txa;
    public boolean txb;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "plugin-finder_release"})
    public interface a {
        void a(FinderLbsLoader.a aVar);
    }

    static {
        AppMethodBeat.i(242595);
        AppMethodBeat.o(242595);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetHistoryResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "invoke"})
    public static final class e extends q implements s<Integer, Integer, String, ask, com.tencent.mm.ak.q, x> {
        final /* synthetic */ b txh;
        final /* synthetic */ List txk;
        final /* synthetic */ int txl;
        final /* synthetic */ boolean txm;
        final /* synthetic */ boolean txn;
        final /* synthetic */ ab.a txo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar, List list, int i2, boolean z, boolean z2, ab.a aVar) {
            super(5);
            this.txh = bVar;
            this.txk = list;
            this.txl = i2;
            this.txm = z;
            this.txn = z2;
            this.txo = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ x a(Integer num, Integer num2, String str, ask ask, com.tencent.mm.ak.q qVar) {
            List<FinderItem> list;
            ArrayList arrayList;
            com.tencent.mm.bw.b bVar;
            int i2;
            AppMethodBeat.i(242588);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            String str2 = str;
            ask ask2 = ask;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_TIMELINE_HEADER_WORDING_STRING_SYNC, "headWording");
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str3 = (String) obj;
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            Object obj2 = aAh2.azQ().get(ar.a.USERINFO_FINDER_TIMELINE_FOOTER_WORDING_STRING_SYNC, "endWording");
            if (!(obj2 instanceof String)) {
                obj2 = null;
            }
            String str4 = (String) obj2;
            if (intValue == 0 && intValue2 == 0) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 3, 1, false);
                LinkedList<FinderObject> linkedList = ask2 != null ? ask2.object : null;
                if (linkedList == null) {
                    p.hyc();
                }
                LinkedList linkedList2 = new LinkedList();
                List list2 = this.txk;
                if (list2 != null) {
                    linkedList2.addAll(list2);
                }
                linkedList2.addAll(linkedList);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : linkedList2) {
                    y yVar = y.vXH;
                    if (y.r((FinderObject) obj3)) {
                        arrayList2.add(obj3);
                    }
                }
                c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                y yVar2 = y.vXH;
                list = c.a.a(arrayList2, y.LL(this.txh.dLS), this.txh.ttO);
                if (this.txl != 2) {
                    c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    List<FinderItem> list3 = list;
                    ArrayList arrayList3 = new ArrayList(j.a(list3, 10));
                    Iterator<T> it = list3.iterator();
                    while (it.hasNext()) {
                        c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        arrayList3.add(c.a.s(it.next()));
                    }
                    y yVar3 = y.vXH;
                    c.a.b(arrayList3, y.LL(this.txh.dLS), this.txm);
                }
            } else {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 4, 1, false);
                list = null;
            }
            if (list != null) {
                List<FinderItem> list4 = list;
                ArrayList arrayList4 = new ArrayList(j.a(list4, 10));
                Iterator<T> it2 = list4.iterator();
                while (it2.hasNext()) {
                    c.a aVar4 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList4.add(c.a.s(it2.next()));
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            StringBuilder append = new StringBuilder("[getHistory] tabType=").append(this.txh.dLS).append(" list ").append(list != null ? Integer.valueOf(list.size()) : null).append(',').append("isFirstPage=").append(this.txn).append(" extraList=");
            List list5 = this.txk;
            Log.i("Finder.FinderLbsFeedFetcher", append.append(list5 != null ? Integer.valueOf(list5.size()) : null).append(" pullType=").append(this.txl).append(" continue_flag=").append(ask2 != null ? Integer.valueOf(ask2.tUC) : null).append(" errType=").append(intValue).append(" errCode=").append(intValue2).toString());
            com.tencent.mm.plugin.finder.feed.model.b bVar2 = new com.tencent.mm.plugin.finder.feed.model.b(arrayList, intValue, intValue2, str2);
            if (ask2 != null) {
                bVar = ask2.LDs;
            } else {
                bVar = null;
            }
            bVar2.lastBuffer = bVar;
            bVar2.tUI = str3;
            bVar2.tQU = str4;
            if (intValue == 0 && intValue2 == 0) {
                if (ask2 != null) {
                    i2 = ask2.tUC;
                } else {
                    i2 = 1;
                }
                bVar2.tUC = i2;
            } else {
                bVar2.tUC = 1;
            }
            this.txo.a(bVar2, this.txl);
            x xVar = x.SXb;
            AppMethodBeat.o(242588);
            return xVar;
        }
    }

    public b(bbn bbn) {
        AppMethodBeat.i(242594);
        this.ttO = bbn;
        this.twY = new C1092b(this.dLS);
        this.ttK = new com.tencent.mm.vending.e.c<>();
        this.txa = true;
        this.txb = true;
        AppMethodBeat.o(242594);
    }

    public static final /* synthetic */ void asO(String str) {
        AppMethodBeat.i(242597);
        asN(str);
        AppMethodBeat.o(242597);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "curCgi", "getCurCgi", "()I", "setCurCgi", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "remainLbsData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getRemainLbsData", "()Ljava/util/LinkedList;", "setRemainLbsData", "(Ljava/util/LinkedList;)V", "streamLastBuffer", "getStreamLastBuffer", "setStreamLastBuffer", "getTabType", "switchToHistory", "", "switchToStream", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.cgi.fetcher.b$b  reason: collision with other inner class name */
    public static final class C1092b {
        private final int dLS;
        public int txd = 1;
        public com.tencent.mm.bw.b txe;
        public com.tencent.mm.bw.b txf;
        LinkedList<com.tencent.mm.plugin.finder.model.c> txg = new LinkedList<>();

        public C1092b(int i2) {
            AppMethodBeat.i(242586);
            this.dLS = i2;
            AppMethodBeat.o(242586);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
    public static final class d implements n.a {
        final /* synthetic */ b txh;
        final /* synthetic */ a txi;
        final /* synthetic */ ab.c txj;

        public d(b bVar, a aVar, ab.c cVar) {
            this.txh = bVar;
            this.txi = aVar;
            this.txj = cVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.n.a
        public final void a(int i2, int i3, String str, atm atm, int i4) {
            ArrayList arrayList;
            AppMethodBeat.i(242587);
            p.h(atm, "resp");
            FinderLbsLoader.a aVar = new FinderLbsLoader.a(i2, i3, str);
            if (i2 == 0 && i3 == 0) {
                this.txh.twY.txe = atm.lastBuffer;
                LinkedList<azm> linkedList = atm.LEm;
                if (linkedList != null) {
                    LinkedList<azm> linkedList2 = linkedList;
                    ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
                    for (T t : linkedList2) {
                        w wVar = w.tOM;
                        p.g(t, "section");
                        arrayList2.add(w.a(t));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = v.SXr;
                }
                com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
                com.tencent.mm.plugin.finder.report.h.gd(this.txh.dLS, arrayList.size());
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList = aVar.getIncrementList();
                Log.i("Finder.FinderLbsFeedFetcher", sb.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
                aVar.setIncrementList(arrayList);
                aVar.setPullType(i4);
                aVar.setLastBuffer(atm.lastBuffer);
                aVar.setHasMore(atm.continueFlag == 1);
                this.txi.a(aVar);
                AppMethodBeat.o(242587);
                return;
            }
            aVar.setHasMore(true);
            AppMethodBeat.o(242587);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$streamCgiCallback$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    public static final class g implements ab.a {
        final /* synthetic */ b txh;
        final /* synthetic */ a txi;
        final /* synthetic */ int txq;

        public g(b bVar, int i2, a aVar) {
            this.txh = bVar;
            this.txq = i2;
            this.txi = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.ab.a
        public final void a(com.tencent.mm.plugin.finder.feed.model.b bVar, int i2) {
            AppMethodBeat.i(242590);
            p.h(bVar, "info");
            if (bVar.errType == 0 && bVar.errCode == 0) {
                this.txh.twY.txf = bVar.lastBuffer;
            }
            Log.i("Finder.FinderLbsFeedFetcher", "[call] onFetchDone... pullType=".concat(String.valueOf(i2)));
            boolean z = bVar.tUC != 0;
            FinderLbsLoader.a aVar = new FinderLbsLoader.a(bVar.errType, bVar.errCode, bVar.errMsg);
            LinkedList linkedList = new LinkedList();
            if (!Util.isNullOrNil(this.txh.twY.txg)) {
                linkedList.addAll(this.txh.twY.txg);
                this.txh.twY.txg.clear();
            }
            for (T t : bVar.tUz) {
                if (t instanceof BaseFinderFeed) {
                    w wVar = w.tOM;
                    linkedList.add(w.m(t));
                }
            }
            aVar.setIncrementList(linkedList);
            StringBuilder sb = new StringBuilder("incrementList size: ");
            List incrementList = aVar.getIncrementList();
            Log.i("Finder.FinderLbsFeedFetcher", sb.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
            aVar.setPullType(this.txq);
            aVar.setLastBuffer(bVar.lastBuffer);
            aVar.setHasMore(z);
            this.txi.a(aVar);
            AppMethodBeat.o(242590);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
    public static final class f implements ab.a {
        final /* synthetic */ b txh;
        final /* synthetic */ g txp;

        public f(b bVar, g gVar) {
            this.txh = bVar;
            this.txp = gVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.ab.a
        public final void a(com.tencent.mm.plugin.finder.feed.model.b bVar, int i2) {
            boolean z;
            AppMethodBeat.i(242589);
            p.h(bVar, "info");
            this.txh.twZ = bVar.tUB > 0;
            b bVar2 = this.txh;
            if (bVar.tUB == 1) {
                z = true;
            } else {
                z = false;
            }
            bVar2.txb = z;
            boolean z2 = bVar.tUD;
            boolean z3 = bVar.isNeedClear;
            Log.i("Finder.FinderLbsFeedFetcher", "[getStream] tabType=" + this.txh.dLS + " isGetHistory=" + this.txh.twZ + " isShowHistoryTip=" + this.txh.txb + " ret_flag=" + bVar.tUB + ' ' + "pullType=" + i2 + " isNeedClear=" + z3 + " isFetchHistoryNow=" + bVar.tUD + ' ' + "size=" + bVar.tUz.size() + " errorType=" + bVar.errType + " errorCode=" + bVar.errCode);
            b.b(bVar.isNeedClear, bVar.tUz.size(), bVar.tUB, i2);
            if (bVar.errType != 0 || bVar.errCode != 0 || !this.txh.twZ || !z2) {
                if (bVar.errType == 0 && bVar.errCode == 0) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 1, 1, false);
                    if (!bVar.tUz.isEmpty() || this.txh.twZ) {
                        bVar.tUz.isEmpty();
                        bVar.tUC = 1;
                    } else {
                        bVar.tUC = 1;
                        b.asO("[finderstream]tabType=" + this.txh.dLS + " server error[list=0:ret_flag=0]");
                    }
                    Log.i("Finder.FinderLbsFeedFetcher", "tabType=" + this.txh.dLS + " this time get finderstream return list=" + bVar.tUz.size() + " continue_flag=" + bVar.tUC + " pullType=" + i2);
                } else {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 2, 1, false);
                    bVar.tUC = 1;
                }
                this.txp.a(bVar, i2);
                AppMethodBeat.o(242589);
                return;
            }
            this.txh.txa = true;
            this.txh.twY.txd = 3;
            b.a(this.txh, this.txp, this.txh.txa, i2, bVar.tUA, z3);
            Log.i("Finder.FinderLbsFeedFetcher", "get history to fill... tabType=" + this.txh.dLS + " pullType=" + i2 + " isHistoryFirstPage=" + this.txh.txa);
            this.txh.txa = false;
            AppMethodBeat.o(242589);
        }
    }

    private static void asN(String str) {
        AppMethodBeat.i(242593);
        Log.e("Finder.FinderLbsFeedFetcher", str);
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            com.tencent.mm.ac.d.h(new h(str));
        }
        AppMethodBeat.o(242593);
    }

    public static /* synthetic */ void a(b bVar, ab.a aVar, boolean z, int i2, List list, boolean z2) {
        AppMethodBeat.i(242592);
        new m(i2, bVar.dLS, new e(bVar, list, i2, z2, z, aVar), null, bVar.twY.txf, bVar.ttO).aYI().a(bVar.ttK);
        AppMethodBeat.o(242592);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String hRn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str) {
            super(0);
            this.hRn = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242591);
            Toast.makeText(MMApplicationContext.getContext(), "debug info " + this.hRn, 1).show();
            x xVar = x.SXb;
            AppMethodBeat.o(242591);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(242596);
        if (!z || i2 > 0 || i3 != 0) {
            if (!z && i2 > 0 && i4 != 2) {
                asN("!isNeedClear && incrementSize > 0 pullType=".concat(String.valueOf(i4)));
            }
            AppMethodBeat.o(242596);
            return;
        }
        asN("isNeedClear && incrementSize <= 0 && retFlag == 0");
        AppMethodBeat.o(242596);
    }
}
