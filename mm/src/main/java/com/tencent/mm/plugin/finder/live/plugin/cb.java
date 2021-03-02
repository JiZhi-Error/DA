package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.widget.aa;
import com.tencent.mm.plugin.finder.live.widget.w;
import com.tencent.mm.plugin.finder.live.widget.y;
import com.tencent.mm.plugin.finder.live.widget.z;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0013J4\u0010\u0014\u001a\u00020\u00132\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0017`\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "widgetsMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "Lkotlin/collections/HashMap;", "canClearScreen", "", "hideLinkMicBottomBar", "", "onAudienceMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "showLinkMicBottomBar", "Companion", "plugin-finder_release"})
public final class cb extends d {
    private static final String TAG = TAG;
    public static final a UMN = new a((byte) 0);
    private final HashMap<String, z> UMI;
    private final com.tencent.mm.live.c.b hOp;

    public /* synthetic */ cb(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        this(viewGroup, bVar, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cb(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, bbn bbn) {
        super(viewGroup, bVar, bbn);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(260684);
        this.hOp = bVar;
        this.UMI = new HashMap<>();
        AppMethodBeat.o(260684);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicDecoratePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260685);
        AppMethodBeat.o(260685);
    }

    public final void hTD() {
        AppMethodBeat.i(260681);
        com.tencent.mm.ac.d.h(new d(this));
        AppMethodBeat.o(260681);
    }

    public final void hTE() {
        AppMethodBeat.i(260682);
        com.tencent.mm.ac.d.h(new b(this));
        AppMethodBeat.o(260682);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.live.c.a
    public final void a(LinkedHashMap<String, Rect> linkedHashMap, boolean z) {
        AppMethodBeat.i(260683);
        p.h(linkedHashMap, "micUserMap");
        Log.i(TAG, "onMicUserChanged widegtMap.size:" + this.UMI.size() + " audienceLinkMicUserList.size:" + getLiveData().UPZ.size() + " micUserMap:" + linkedHashMap);
        com.tencent.mm.ac.d.h(new c(this, z, linkedHashMap));
        AppMethodBeat.o(260683);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ cb UMO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(cb cbVar) {
            super(0);
            this.UMO = cbVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260680);
            this.UMO.rg(0);
            x xVar = x.SXb;
            AppMethodBeat.o(260680);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ cb UMO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(cb cbVar) {
            super(0);
            this.UMO = cbVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260678);
            this.UMO.rg(8);
            x xVar = x.SXb;
            AppMethodBeat.o(260678);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean UML;
        final /* synthetic */ LinkedHashMap UMM;
        final /* synthetic */ cb UMO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(cb cbVar, boolean z, LinkedHashMap linkedHashMap) {
            super(0);
            this.UMO = cbVar;
            this.UML = z;
            this.UMM = linkedHashMap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v24, types: [com.tencent.mm.plugin.finder.live.widget.z] */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            y yVar;
            ArrayList arrayList;
            String str;
            AppMethodBeat.i(260679);
            if (this.UML) {
                if (this.UMO.getLiveData().uEB == null) {
                    HashMap hashMap = this.UMO.UMI;
                    synchronized (hashMap) {
                        try {
                            for (Map.Entry entry : hashMap.entrySet()) {
                                ((z) entry.getValue()).hTE();
                            }
                            x xVar = x.SXb;
                        } catch (Throwable th) {
                            AppMethodBeat.o(260679);
                            throw th;
                        }
                    }
                    this.UMO.UMI.clear();
                } else {
                    e eVar = this.UMO.getLiveData().uEB;
                    if (!(eVar == null || (str = eVar.uCo) == null)) {
                        if (this.UMO.UMI.get(str) == null) {
                            Log.i(cb.TAG, "new mic pk user:" + eVar.nickname + " micId:" + eVar.sessionId + " sdkUserId:" + eVar.uCo + " added");
                            aa aaVar = new aa(this.UMO.hwr, this.UMO);
                            aaVar.g(eVar);
                            Rect rect = (Rect) this.UMM.get(str);
                            if (rect == null) {
                                rect = new Rect();
                            }
                            aaVar.x(rect);
                            this.UMO.UMI.put(str, aaVar);
                            x xVar2 = x.SXb;
                        } else {
                            z zVar = (z) this.UMO.UMI.get(str);
                            if (zVar != null) {
                                Rect rect2 = (Rect) this.UMM.get(str);
                                if (rect2 == null) {
                                    rect2 = new Rect();
                                }
                                zVar.y(rect2);
                                x xVar3 = x.SXb;
                            }
                        }
                    }
                }
            } else if (this.UMO.getLiveData().UPZ.isEmpty()) {
                HashMap hashMap2 = this.UMO.UMI;
                synchronized (hashMap2) {
                    try {
                        for (Map.Entry entry2 : hashMap2.entrySet()) {
                            ((z) entry2.getValue()).hTE();
                        }
                        x xVar4 = x.SXb;
                    } catch (Throwable th2) {
                        AppMethodBeat.o(260679);
                        throw th2;
                    }
                }
                this.UMO.UMI.clear();
            } else {
                ArrayList<String> arrayList2 = new ArrayList();
                HashMap hashMap3 = this.UMO.UMI;
                synchronized (hashMap3) {
                    try {
                        for (Map.Entry entry3 : hashMap3.entrySet()) {
                            String str2 = (String) entry3.getKey();
                            List<e> list = this.UMO.getLiveData().UPZ;
                            p.g(list, "liveData.audienceLinkMicUserList");
                            List<e> list2 = list;
                            synchronized (list2) {
                                try {
                                    ArrayList arrayList3 = new ArrayList();
                                    for (T t : list2) {
                                        if (Util.isEqual(str2, t.uCo)) {
                                            arrayList3.add(t);
                                        }
                                    }
                                    arrayList = arrayList3;
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                            if (arrayList.isEmpty()) {
                                Log.i(cb.TAG, "old mic " + ((z) entry3.getValue()) + " removed");
                                arrayList2.add(str2);
                            }
                        }
                        x xVar5 = x.SXb;
                    } finally {
                        AppMethodBeat.o(260679);
                    }
                }
                for (String str3 : arrayList2) {
                    z zVar2 = (z) this.UMO.UMI.remove(str3);
                    if (zVar2 != null) {
                        zVar2.hTE();
                        x xVar6 = x.SXb;
                    }
                }
                if (this.UMO.UMI.get(this.UMO.getLiveData().hIv.Mop) == null) {
                    c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                    g asG = c.a.asG(this.UMO.getLiveData().hwd);
                    w wVar = new w(this.UMO.hwr, this.UMO);
                    wVar.g(new e(this.UMO.getLiveData().hIv.Mop, "", this.UMO.getLiveData().hwd, asG != null ? asG.getNickname() : null, 0, null, null, false, 0, null, null, 0, 0, 8128));
                    Rect rect3 = (Rect) this.UMM.get(this.UMO.getLiveData().hIv.Mop);
                    if (rect3 == null) {
                        rect3 = new Rect();
                    }
                    wVar.x(rect3);
                    String str4 = this.UMO.getLiveData().hIv.Mop;
                    p.g(str4, "liveData.liveSdkInfo.sdk_create_user_id");
                    this.UMO.UMI.put(str4, wVar);
                } else {
                    z zVar3 = (z) this.UMO.UMI.get(this.UMO.getLiveData().hIv.Mop);
                    if (zVar3 != null) {
                        Rect rect4 = (Rect) this.UMM.get(this.UMO.getLiveData().hIv.Mop);
                        if (rect4 == null) {
                            rect4 = new Rect();
                        }
                        zVar3.y(rect4);
                        x xVar7 = x.SXb;
                    }
                }
                List<e> list3 = this.UMO.getLiveData().UPZ;
                p.g(list3, "liveData.audienceLinkMicUserList");
                List<e> list4 = list3;
                synchronized (list4) {
                    try {
                        for (T t2 : list4) {
                            String str5 = t2.uCo;
                            if (str5 != null) {
                                if (this.UMO.UMI.get(str5) == null) {
                                    Log.i(cb.TAG, "new mic user:" + t2.nickname + " micId:" + t2.sessionId + " sdkUserId:" + t2.uCo + " added");
                                    if (t2.uCx == 2) {
                                        yVar = new aa(this.UMO.hwr, this.UMO);
                                    } else {
                                        yVar = new y(this.UMO.hwr, this.UMO);
                                    }
                                    p.g(t2, LocaleUtil.ITALIAN);
                                    yVar.g(t2);
                                    Rect rect5 = (Rect) this.UMM.get(str5);
                                    if (rect5 == null) {
                                        rect5 = new Rect();
                                    }
                                    yVar.x(rect5);
                                    this.UMO.UMI.put(str5, yVar);
                                    x xVar8 = x.SXb;
                                } else {
                                    z zVar4 = (z) this.UMO.UMI.get(str5);
                                    if (zVar4 != null) {
                                        Rect rect6 = (Rect) this.UMM.get(str5);
                                        if (rect6 == null) {
                                            rect6 = new Rect();
                                        }
                                        zVar4.y(rect6);
                                        x xVar9 = x.SXb;
                                    }
                                }
                            }
                        }
                        x xVar10 = x.SXb;
                    } catch (Throwable th4) {
                        AppMethodBeat.o(260679);
                        throw th4;
                    }
                }
            }
            x xVar11 = x.SXb;
            AppMethodBeat.o(260679);
            return xVar11;
        }
    }
}
