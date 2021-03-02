package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.component.i;
import com.tencent.mm.plugin.finder.live.component.j;
import com.tencent.mm.plugin.finder.live.component.k;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J4\u0010\u000f\u001a\u00020\u00102\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\tH\u0002J\u001a\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\u0010R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "canClearScreen", "", "onAudienceMicUserChanged", "", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "register", "refPoint", "Landroid/graphics/PointF;", "sdkUserId", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unregister", "updateRedPacket", "Companion", "plugin-finder_release"})
public final class as extends d {
    public static final a UME = new a((byte) 0);
    private final ConcurrentHashMap<String, o<i.b, i.c>> cCB = new ConcurrentHashMap<>();
    private final b hOp;

    static {
        AppMethodBeat.i(260664);
        AppMethodBeat.o(260664);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public as(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(260663);
        this.hOp = bVar;
        AppMethodBeat.o(260663);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        String string;
        B b2;
        B b3;
        AppMethodBeat.i(260659);
        p.h(cVar, "status");
        switch (bk.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                PointF pointF = new PointF(0.0f, (float) at.fromDPToPix(this.hwr.getContext(), r.CTRL_INDEX));
                String str = getLiveData().hIv.Mop;
                if (str == null) {
                    str = "";
                }
                a(pointF, str);
                AppMethodBeat.o(260659);
                return;
            case 2:
                j.a aVar = j.UJU;
                long j2 = getLiveData().liveInfo.liveId;
                ar liveLuckyMoneyStorage = ((PluginFinder) g.ah(PluginFinder.class)).getLiveLuckyMoneyStorage();
                Log.i("Finder.FinderLiveLuckyMoneyStorage", "clearCache liveId:".concat(String.valueOf(j2)));
                liveLuckyMoneyStorage.tVA.clear();
                liveLuckyMoneyStorage.db.delete("FinderLiveLuckyMoneyInfo", "liveId=?", new String[]{d.zs(j2)});
                AppMethodBeat.o(260659);
                return;
            case 3:
                if (bundle == null || !bundle.containsKey("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE")) {
                    o<i.b, i.c> oVar = this.cCB.get(getLiveData().hIv.Mop);
                    if (oVar == null || (b3 = oVar.second) == null) {
                        AppMethodBeat.o(260659);
                        return;
                    }
                    b3.Fv(true);
                    AppMethodBeat.o(260659);
                    return;
                }
                AppMethodBeat.o(260659);
                return;
            case 4:
                o<i.b, i.c> oVar2 = this.cCB.get(getLiveData().hIv.Mop);
                if (oVar2 == null || (b2 = oVar2.second) == null) {
                    AppMethodBeat.o(260659);
                    return;
                }
                b2.Fv(false);
                AppMethodBeat.o(260659);
                return;
            case 5:
                if (!(bundle == null || (string = bundle.getString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID")) == null)) {
                    for (Map.Entry<String, o<i.b, i.c>> entry : this.cCB.entrySet()) {
                        p.g(string, "sendId");
                        entry.getValue().first.bxC(string);
                    }
                    AppMethodBeat.o(260659);
                    return;
                }
        }
        AppMethodBeat.o(260659);
    }

    private final void a(PointF pointF, String str) {
        e bxR;
        AppMethodBeat.i(260660);
        Log.i("FinderLiveLuckyMoneyBubblePlugin", "register sdkUserId:".concat(String.valueOf(str)));
        if (this.cCB.containsKey(str)) {
            AppMethodBeat.o(260660);
            return;
        }
        if (p.j(str, getLiveData().hIv.Mop)) {
            bxR = new e(str, null, null, null, 0, "", null, false, 0, null, null, 0, 0, 8064);
        } else {
            bxR = getLiveData().bxR(str);
        }
        Log.i("FinderLiveLuckyMoneyBubblePlugin", "register bindMicUser:".concat(String.valueOf(bxR)));
        if (bxR != null) {
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
            b bVar = this.hOp;
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            j jVar = new j(liveData, bVar, com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant(), bxR);
            ViewGroup viewGroup = this.hwr;
            Context context = this.hwr.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(260660);
                throw tVar;
            }
            k kVar = new k(viewGroup, (MMActivity) context, jVar, pointF);
            jVar.a(kVar);
            this.cCB.put(str, new o<>(jVar, kVar));
            AppMethodBeat.o(260660);
            return;
        }
        AppMethodBeat.o(260660);
    }

    public final void hTC() {
        s.bg bgVar;
        boolean z;
        AppMethodBeat.i(260661);
        String str = "";
        boolean z2 = false;
        for (Map.Entry<String, o<i.b, i.c>> entry : this.cCB.entrySet()) {
            if (entry.getValue().first.hSY()) {
                str = entry.getValue().first.hSZ();
                if (str == null) {
                    str = "";
                }
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        if (z2) {
            rg(0);
            m mVar = m.vli;
            s.bh bhVar = s.bh.EXPOSE_RIGHT_UP_CORNER_RED_PACKET_;
            if (TextUtils.isEmpty(str)) {
                bgVar = s.bg.ANCHOR;
            } else {
                bgVar = s.bg.LINKMIC_VISITOR;
            }
            mVar.a(bhVar, bgVar);
            AppMethodBeat.o(260661);
            return;
        }
        rg(8);
        AppMethodBeat.o(260661);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.live.c.a
    public final void a(LinkedHashMap<String, Rect> linkedHashMap, boolean z) {
        B b2;
        T t;
        AppMethodBeat.i(260662);
        p.h(linkedHashMap, "micUserMap");
        ArrayList<String> arrayList = new ArrayList();
        ConcurrentHashMap<String, o<i.b, i.c>> concurrentHashMap = this.cCB;
        synchronized (concurrentHashMap) {
            try {
                for (Map.Entry<String, o<i.b, i.c>> entry : concurrentHashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!key.equals(getLiveData().hIv.Mop)) {
                        List<e> list = getLiveData().UPZ;
                        p.g(list, "liveData.audienceLinkMicUserList");
                        List<e> list2 = list;
                        synchronized (list2) {
                            try {
                                Iterator<T> it = list2.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        t = null;
                                        break;
                                    }
                                    t = it.next();
                                    if (Util.isEqual(key, t.uCo)) {
                                        break;
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(260662);
                                throw th;
                            }
                        }
                        if (t == null) {
                            Log.i("FinderLiveLuckyMoneyBubblePlugin", "old mic " + entry.getValue() + " removed");
                            arrayList.add(key);
                        }
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(260662);
            }
        }
        for (String str : arrayList) {
            p.h(str, "sdkUserId");
            Log.i("FinderLiveLuckyMoneyBubblePlugin", "unregister sdkUserId:".concat(String.valueOf(str)));
            o<i.b, i.c> oVar = this.cCB.get(str);
            if (oVar != null) {
                p.g(oVar, "map[sdkUserId] ?: return");
                oVar.first.onDetach();
                oVar.second.release();
                this.cCB.remove(str);
            }
        }
        List<e> list3 = getLiveData().UPZ;
        p.g(list3, "liveData.audienceLinkMicUserList");
        List<e> list4 = list3;
        synchronized (list4) {
            try {
                for (T t2 : list4) {
                    String str2 = t2.uCo;
                    if (str2 != null) {
                        if (this.cCB.get(str2) == null) {
                            Log.i("FinderLiveLuckyMoneyBubblePlugin", "new mic user:" + t2.nickname + " micId:" + t2.sessionId + " sdkUserId:" + t2.uCo + " added");
                            Rect rect = linkedHashMap.get(str2);
                            float f2 = rect != null ? (float) rect.left : 0.0f;
                            Rect rect2 = linkedHashMap.get(str2);
                            a(new PointF(f2, rect2 != null ? (float) rect2.top : 0.0f), str2);
                        } else {
                            o<i.b, i.c> oVar2 = this.cCB.get(str2);
                            if (!(oVar2 == null || (b2 = oVar2.second) == null)) {
                                Rect rect3 = linkedHashMap.get(str2);
                                float f3 = rect3 != null ? (float) rect3.left : 0.0f;
                                Rect rect4 = linkedHashMap.get(str2);
                                b2.f(new PointF(f3, rect4 != null ? (float) rect4.top : 0.0f));
                            }
                        }
                    }
                }
                x xVar2 = x.SXb;
            } finally {
                AppMethodBeat.o(260662);
            }
        }
    }
}
