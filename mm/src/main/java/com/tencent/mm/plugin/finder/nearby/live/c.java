package com.tencent.mm.plugin.finder.nearby.live;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.d;
import com.tencent.mm.plugin.finder.nearby.live.NearbyLiveFeedLoader;
import com.tencent.mm.plugin.finder.nearby.live.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J4\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0003R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "commentScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$CgiSwitcher;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "fetch", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "callback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "pullType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "memoryCacheFlag", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class c extends com.tencent.mm.plugin.finder.life.a {
    public static final C1239c uQG = new C1239c((byte) 0);
    private final int dLS;
    final int tCE;
    com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK = new com.tencent.mm.vending.e.c<>();
    final bbn ttO;
    final b uQF = new b(this.dLS);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsResponse;", "plugin-finder_release"})
    public interface a {
        void a(NearbyLiveFeedLoader.b bVar);
    }

    static {
        AppMethodBeat.i(249031);
        AppMethodBeat.o(249031);
    }

    public c(int i2, int i3, bbn bbn) {
        AppMethodBeat.i(249030);
        this.dLS = i2;
        this.tCE = i3;
        this.ttO = bbn;
        AppMethodBeat.o(249030);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getTabType", "()I", "plugin-finder_release"})
    public static final class b {
        private final int dLS;
        com.tencent.mm.bw.b txe;

        public b(int i2) {
            this.dLS = i2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.nearby.live.c$c  reason: collision with other inner class name */
    public static final class C1239c {
        private C1239c() {
        }

        public /* synthetic */ C1239c(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "pullType", "plugin-finder_release"})
    public static final class d implements a.AbstractC1237a {
        final /* synthetic */ c uQH;
        final /* synthetic */ int uQI;
        final /* synthetic */ a uQJ;

        d(c cVar, int i2, a aVar) {
            this.uQH = cVar;
            this.uQI = i2;
            this.uQJ = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.nearby.live.a.AbstractC1237a
        public final void a(int i2, int i3, String str, auj auj, int i4) {
            AppMethodBeat.i(249029);
            p.h(auj, "resp");
            d.a aVar = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
            d.a.JA(this.uQI).uQp = System.currentTimeMillis();
            NearbyLiveFeedLoader.b bVar = new NearbyLiveFeedLoader.b(i2, i3, str, (byte) 0);
            if (i2 == 0 && i3 == 0) {
                this.uQH.uQF.txe = auj.LDs;
                LinkedList<FinderObject> linkedList = auj.object;
                p.g(linkedList, "resp.`object`");
                ArrayList arrayList = new ArrayList();
                for (T t : linkedList) {
                    T t2 = t;
                    y yVar = y.vXH;
                    p.g(t2, LocaleUtil.ITALIAN);
                    if (y.a((FinderObject) t2, "Finder.FinderLiveFriendsFeedFetcher")) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2.size() < auj.object.size()) {
                    Log.e("Finder.FinderLiveFriendsFeedFetcher", "[onCgiBack] has filter some feed. valid=" + arrayList2.size() + " raw=" + auj.object.size());
                }
                c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                y yVar2 = y.vXH;
                List<FinderItem> a2 = c.a.a(arrayList2, y.LL(this.uQH.dLS), this.uQH.ttO);
                ArrayList arrayList3 = new ArrayList(j.a(a2, 10));
                Iterator<T> it = a2.iterator();
                while (it.hasNext()) {
                    c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    arrayList3.add(c.a.s(it.next()));
                }
                LinkedList linkedList2 = new LinkedList(arrayList3);
                com.tencent.mm.plugin.finder.nearby.report.c cVar = com.tencent.mm.plugin.finder.nearby.report.c.uTk;
                com.tencent.mm.plugin.finder.nearby.report.c.j(this.uQH.tCE, linkedList2);
                StringBuilder sb = new StringBuilder("incrementList size: ");
                List incrementList = bVar.getIncrementList();
                Log.i("Finder.FinderLiveFriendsFeedFetcher", sb.append(incrementList != null ? Integer.valueOf(incrementList.size()) : null).toString());
                bVar.setIncrementList(linkedList2);
                bVar.setPullType(i4);
                bVar.setLastBuffer(auj.LDs);
                bVar.setHasMore(auj.tUC != 0);
                bVar.uQN = auj.LFi;
                this.uQJ.a(bVar);
                AppMethodBeat.o(249029);
                return;
            }
            bVar.setHasMore(true);
            AppMethodBeat.o(249029);
        }
    }
}
