package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.widget.z;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J4\u0010\u0012\u001a\u00020\u00112\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "widgetsMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "Lkotlin/collections/HashMap;", "hideLinkMicBottomBar", "", "onAudienceMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "", "showLinkMicBottomBar", "Companion", "plugin-finder_release"})
public final class bl extends d {
    private static final String TAG = TAG;
    public static final a UMJ = new a((byte) 0);
    private final HashMap<String, z> UMI;
    private final com.tencent.mm.live.c.b hOp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bl(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar, null);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(260676);
        this.hOp = bVar;
        this.UMI = new HashMap<>();
        AppMethodBeat.o(260676);
    }

    public /* synthetic */ bl(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, byte b2) {
        this(viewGroup, bVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMicAudioPreviewPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260677);
        AppMethodBeat.o(260677);
    }

    public final void hTD() {
        AppMethodBeat.i(260673);
        com.tencent.mm.ac.d.h(new d(this));
        AppMethodBeat.o(260673);
    }

    public final void hTE() {
        AppMethodBeat.i(260674);
        com.tencent.mm.ac.d.h(new b(this));
        AppMethodBeat.o(260674);
    }

    @Override // com.tencent.mm.live.c.a
    public final void a(LinkedHashMap<String, Rect> linkedHashMap, boolean z) {
        AppMethodBeat.i(260675);
        p.h(linkedHashMap, "micUserMap");
        Log.i(TAG, "onMicUserChanged widegtMap.size:" + this.UMI.size() + " audienceLinkMicUserList.size:" + getLiveData().UPZ.size() + " micUserMap:" + linkedHashMap);
        com.tencent.mm.ac.d.h(new c(this, z, linkedHashMap));
        AppMethodBeat.o(260675);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bl UMK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(bl blVar) {
            super(0);
            this.UMK = blVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260672);
            this.UMK.rg(0);
            x xVar = x.SXb;
            AppMethodBeat.o(260672);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bl UMK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bl blVar) {
            super(0);
            this.UMK = blVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260670);
            this.UMK.rg(8);
            x xVar = x.SXb;
            AppMethodBeat.o(260670);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bl UMK;
        final /* synthetic */ boolean UML;
        final /* synthetic */ LinkedHashMap UMM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bl blVar, boolean z, LinkedHashMap linkedHashMap) {
            super(0);
            this.UMK = blVar;
            this.UML = z;
            this.UMM = linkedHashMap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            ArrayList arrayList;
            AppMethodBeat.i(260671);
            if (!this.UML) {
                if (this.UMK.getLiveData().UPZ.isEmpty()) {
                    HashMap hashMap = this.UMK.UMI;
                    synchronized (hashMap) {
                        try {
                            for (Map.Entry entry : hashMap.entrySet()) {
                                ((z) entry.getValue()).hTE();
                            }
                            x xVar = x.SXb;
                        } catch (Throwable th) {
                            AppMethodBeat.o(260671);
                            throw th;
                        }
                    }
                    this.UMK.UMI.clear();
                } else {
                    ArrayList<String> arrayList2 = new ArrayList();
                    HashMap hashMap2 = this.UMK.UMI;
                    synchronized (hashMap2) {
                        try {
                            for (Map.Entry entry2 : hashMap2.entrySet()) {
                                String str = (String) entry2.getKey();
                                List<e> list = this.UMK.getLiveData().UPZ;
                                p.g(list, "liveData.audienceLinkMicUserList");
                                List<e> list2 = list;
                                synchronized (list2) {
                                    try {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (T t : list2) {
                                            if (Util.isEqual(str, t.uCo)) {
                                                arrayList3.add(t);
                                            }
                                        }
                                        arrayList = arrayList3;
                                    } catch (Throwable th2) {
                                        AppMethodBeat.o(260671);
                                        throw th2;
                                    }
                                }
                                if (arrayList.isEmpty()) {
                                    Log.i(bl.TAG, "old mic " + ((z) entry2.getValue()) + " removed");
                                    arrayList2.add(str);
                                }
                            }
                            x xVar2 = x.SXb;
                        } finally {
                            AppMethodBeat.o(260671);
                        }
                    }
                    for (String str2 : arrayList2) {
                        z zVar = (z) this.UMK.UMI.remove(str2);
                        if (zVar != null) {
                            zVar.hTE();
                        }
                    }
                    List<e> list3 = this.UMK.getLiveData().UPZ;
                    p.g(list3, "liveData.audienceLinkMicUserList");
                    List<e> list4 = list3;
                    synchronized (list4) {
                        try {
                            for (T t2 : list4) {
                                String str3 = t2.uCo;
                                if (str3 != null && t2.uCx == 1) {
                                    if (this.UMK.UMI.get(str3) == null) {
                                        Log.i(bl.TAG, "new mic user:" + t2.nickname + " micId:" + t2.sessionId + " sdkUserId:" + t2.uCo + " added");
                                        com.tencent.mm.plugin.finder.live.widget.x xVar3 = new com.tencent.mm.plugin.finder.live.widget.x(this.UMK.hwr, this.UMK);
                                        p.g(t2, LocaleUtil.ITALIAN);
                                        xVar3.g(t2);
                                        Rect rect = (Rect) this.UMM.get(str3);
                                        if (rect == null) {
                                            rect = new Rect();
                                        }
                                        xVar3.x(rect);
                                        this.UMK.UMI.put(str3, xVar3);
                                    } else {
                                        z zVar2 = (z) this.UMK.UMI.get(str3);
                                        if (zVar2 != null) {
                                            Rect rect2 = (Rect) this.UMM.get(str3);
                                            if (rect2 == null) {
                                                rect2 = new Rect();
                                            }
                                            zVar2.y(rect2);
                                        }
                                    }
                                }
                            }
                            x xVar4 = x.SXb;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            }
            x xVar5 = x.SXb;
            AppMethodBeat.o(260671);
            return xVar5;
        }
    }
}
