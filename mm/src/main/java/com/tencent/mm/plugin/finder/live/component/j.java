package com.tencent.mm.plugin.finder.live.component;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.component.i;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.aq;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.protocal.protobuf.fgu;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u0016\u0010\"\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\b\u0010&\u001a\u00020\u001bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "bindMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;)V", "luckyMoneyShowInfoList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$LuckyMoneyShowInfo;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "getRedPacketType", "", "handleRecvLuckyMoneyErr", "", "errCode", "", "onAttach", "callback", "onBubbleClick", "onBubbleShownChange", "showing", "", "onDetach", "openLuckyMoney", "showInfo", "removeLuckyMoneyBySendId", "sendId", "removeLuckyMoneyShowInfo", "updateLuckyMoneyShowList", "luckyMoneyList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "updateStatus", "Companion", "LuckyMoneyShowInfo", "plugin-finder_release"})
public final class j implements i.b {
    public static final a UJU = new a((byte) 0);
    private i.c UJR;
    private final ConcurrentLinkedDeque<b> UJS = new ConcurrentLinkedDeque<>();
    private final com.tencent.mm.plugin.finder.live.viewmodel.e UJT;
    private final com.tencent.mm.live.c.b hOp;
    private final g liveData;
    private final s ujx;

    static {
        AppMethodBeat.i(260414);
        AppMethodBeat.o(260414);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "errCode", "", "invoke", "com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$openLuckyMoney$1$2"})
    static final class c extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ j UJY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j jVar) {
            super(1);
            this.UJY = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(260400);
            j.a(this.UJY, num.intValue());
            x xVar = x.SXb;
            AppMethodBeat.o(260400);
            return xVar;
        }
    }

    public j(g gVar, com.tencent.mm.live.c.b bVar, s sVar, com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
        p.h(gVar, "liveData");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(260413);
        this.liveData = gVar;
        this.hOp = bVar;
        this.ujx = sVar;
        this.UJT = eVar;
        AppMethodBeat.o(260413);
    }

    public static final /* synthetic */ void a(j jVar, b bVar) {
        AppMethodBeat.i(260415);
        jVar.a(bVar);
        AppMethodBeat.o(260415);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(i.c cVar) {
        AppMethodBeat.i(260411);
        a(cVar);
        AppMethodBeat.o(260411);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$Companion;", "", "()V", "TAG", "", "clearCache", "", "liveId", "", "initCache", "saveCache", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void RI(long j2) {
            aq aqVar;
            byte[] bArr = null;
            AppMethodBeat.i(260394);
            ar liveLuckyMoneyStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveLuckyMoneyStorage();
            Log.i("Finder.FinderLiveLuckyMoneyStorage", "initCache: liveId:".concat(String.valueOf(j2)));
            Cursor rawQuery = liveLuckyMoneyStorage.db.rawQuery("SELECT * FROM FinderLiveLuckyMoneyInfo where FinderLiveLuckyMoneyInfo.liveId=" + com.tencent.mm.ac.d.zs(j2), null, 2);
            if (rawQuery.moveToNext()) {
                aq aqVar2 = new aq();
                aqVar2.convertFrom(rawQuery);
                aqVar = aqVar2;
            } else {
                aqVar = null;
            }
            fgu fgu = new fgu();
            fgu fgu2 = fgu;
            if (aqVar != null) {
                bArr = aqVar.field_luckyMoneyData;
            }
            try {
                fgu2.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
            }
            Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet());
            LinkedList<String> linkedList = fgu.Vjj;
            p.g(linkedList, "luckyMoneyData.openedIdList");
            synchronizedSet.addAll(linkedList);
            Long valueOf = Long.valueOf(j2);
            p.g(synchronizedSet, "set");
            liveLuckyMoneyStorage.tVA.put(valueOf, synchronizedSet);
            rawQuery.close();
            AppMethodBeat.o(260394);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$LuckyMoneyShowInfo;", "", "originData", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;)V", "micId", "", "getMicId", "()Ljava/lang/String;", "getOriginData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketInfo;", "sendId", "getSendId", "state", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "getState", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "setState", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;)V", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-finder_release"})
    public static final class b {
        private i.a UJV;
        final fgy UJW;
        final String hFz;
        final String yQE;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(260398);
            if (this == obj || ((obj instanceof b) && p.j(this.UJW, ((b) obj).UJW))) {
                AppMethodBeat.o(260398);
                return true;
            }
            AppMethodBeat.o(260398);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(260397);
            fgy fgy = this.UJW;
            if (fgy != null) {
                int hashCode = fgy.hashCode();
                AppMethodBeat.o(260397);
                return hashCode;
            }
            AppMethodBeat.o(260397);
            return 0;
        }

        public b(fgy fgy) {
            p.h(fgy, "originData");
            AppMethodBeat.i(260396);
            this.UJW = fgy;
            String str = this.UJW.ViT;
            str = str == null ? "" : str;
            p.g(str, "originData.send_id ?: \"\"");
            this.yQE = str;
            String str2 = this.UJW.ViX;
            str2 = str2 == null ? "" : str2;
            p.g(str2, "originData.refer_live_mic_id ?: \"\"");
            this.hFz = str2;
            this.UJV = i.a.NEW;
            AppMethodBeat.o(260396);
        }

        public final String toString() {
            AppMethodBeat.i(260395);
            String str = ("id = " + this.yQE) + ", " + ("micId = " + this.hFz) + ", " + ("state = " + this.UJV) + "\n";
            p.g(str, "StringBuilder().append(\"…              .toString()");
            AppMethodBeat.o(260395);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c A[Catch:{ all -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x004b A[SYNTHETIC] */
    @Override // com.tencent.mm.plugin.finder.live.component.i.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hSY() {
        /*
        // Method dump skipped, instructions count: 213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.component.j.hSY():boolean");
    }

    private final boolean la(List<? extends fgy> list) {
        boolean z;
        T t;
        AppMethodBeat.i(260404);
        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateLuckyMoneyShowList: filtered remote luckyMoneyList.size:" + list.size() + ", local list size:" + this.UJS.size());
        List<fgy> m = kotlin.a.j.m(list);
        synchronized (m) {
            try {
                z = false;
                for (fgy fgy : m) {
                    Iterator<T> it = this.UJS.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (next.yQE.equals(fgy.ViT)) {
                            t = next;
                            break;
                        }
                    }
                    T t2 = t;
                    if (t2 != null) {
                        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateLuckyMoneyShowList: update local info: ".concat(String.valueOf(t2)));
                    } else {
                        ConcurrentLinkedDeque<b> concurrentLinkedDeque = this.UJS;
                        b bVar = new b(fgy);
                        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "updateLuckyMoneyShowList: add local info: ".concat(String.valueOf(bVar)));
                        concurrentLinkedDeque.offerFirst(bVar);
                        z = true;
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(260404);
            }
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.b
    public final void bxC(String str) {
        T t;
        AppMethodBeat.i(260405);
        p.h(str, "sendId");
        Iterator<T> it = this.UJS.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.yQE.equals(str)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            a((b) t2);
            AppMethodBeat.o(260405);
            return;
        }
        AppMethodBeat.o(260405);
    }

    private final void a(b bVar) {
        AppMethodBeat.i(260406);
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLiveLuckyMoneyStorage().U(this.liveData.liveInfo.liveId, bVar.yQE);
        this.UJS.remove(bVar);
        com.tencent.mm.ac.d.h(new d(this));
        AppMethodBeat.o(260406);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.b
    public final void deZ() {
        String str;
        s.bg bgVar;
        MMFragmentActivity mMFragmentActivity;
        com.tencent.mm.plugin.finder.live.model.s sVar;
        AppMethodBeat.i(260407);
        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "onBubbleClick: current size:" + this.UJS.size());
        b peekFirst = this.UJS.peekFirst();
        m mVar = m.vli;
        s.bh bhVar = s.bh.CLICK_RED_PACKET;
        if (peekFirst != null) {
            str = peekFirst.hFz;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            bgVar = s.bg.ANCHOR;
        } else {
            bgVar = s.bg.LINKMIC_VISITOR;
        }
        mVar.a(bhVar, bgVar);
        i.c cVar = this.UJR;
        if (cVar != null) {
            mMFragmentActivity = cVar.dcl();
        } else {
            mMFragmentActivity = null;
        }
        if (peekFirst == null || mMFragmentActivity == null || (sVar = this.ujx) == null) {
            AppMethodBeat.o(260407);
            return;
        }
        sVar.a(mMFragmentActivity, peekFirst.UJW, new FinderLiveLuckyMoneyBubblePresenter$openLuckyMoney$$inlined$multiLet$lambda$1(peekFirst, MMHandler.createFreeHandler(Looper.getMainLooper()), this), new c(this));
        AppMethodBeat.o(260407);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.b
    public final String hSZ() {
        AppMethodBeat.i(260408);
        if (this.UJS.isEmpty()) {
            AppMethodBeat.o(260408);
            return null;
        }
        b peekFirst = this.UJS.peekFirst();
        if (peekFirst != null) {
            String str = peekFirst.hFz;
            AppMethodBeat.o(260408);
            return str;
        }
        AppMethodBeat.o(260408);
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.live.component.i.b
    public final void Fu(boolean z) {
        String str;
        AppMethodBeat.i(260409);
        String str2 = this.liveData.hIv.Mop;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = this.UJT;
        if (eVar != null) {
            str = eVar.uCo;
        } else {
            str = null;
        }
        if (!Util.isEqual(str2, str)) {
            AppMethodBeat.o(260409);
        } else if (z) {
            b.C0376b.a(this.hOp, b.c.vSh);
            AppMethodBeat.o(260409);
        } else {
            b.C0376b.a(this.hOp, b.c.vSi);
            AppMethodBeat.o(260409);
        }
    }

    public final void a(i.c cVar) {
        AppMethodBeat.i(260410);
        p.h(cVar, "callback");
        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "onAttach");
        this.UJR = cVar;
        i.c cVar2 = this.UJR;
        if (cVar2 != null) {
            cVar2.initView();
            AppMethodBeat.o(260410);
            return;
        }
        AppMethodBeat.o(260410);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(260412);
        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "onDetach " + Util.getStack());
        this.UJR = null;
        AppMethodBeat.o(260412);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j UJY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(j jVar) {
            super(0);
            this.UJY = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260402);
            i.c cVar = this.UJY.UJR;
            if (cVar != null) {
                cVar.awL(this.UJY.UJS.size());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260402);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ j UJY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(j jVar) {
            super(0);
            this.UJY = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260401);
            i.c cVar = this.UJY.UJR;
            if (cVar != null) {
                cVar.awL(this.UJY.UJS.size());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(260401);
            return xVar;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(j jVar, int i2) {
        AppMethodBeat.i(260416);
        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "handleRecvLuckyMoneyErr errCode:".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                AppMethodBeat.o(260416);
                return;
            case 1:
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 1);
                jVar.hOp.statusChange(b.c.wlu, bundle);
                AppMethodBeat.o(260416);
                return;
            case 2:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 2);
                jVar.hOp.statusChange(b.c.wlu, bundle2);
                break;
        }
        AppMethodBeat.o(260416);
    }
}
