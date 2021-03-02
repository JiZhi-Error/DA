package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u0013\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\bH\u0002J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher;", "Lcom/tencent/mm/plugin/finder/report/IReportWatcher;", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedRecord;", "()V", "isWatch", "", "objAllocateMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$ReportRecord;", "watchedLogId", "calc", "", "getObjHashCode", "", "obj", "", "getRecord", "logId", "isBlock", "onAllocate", "record", "onRelease", "printBriefLog", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "prefixLog", "startWatch", "stopWatch", "vertify", "Companion", "ReportRecord", "plugin-finder_release"})
public final class b implements aa<p> {
    public static final a vcY = new a((byte) 0);
    private boolean vcV;
    private int vcW;
    private final ConcurrentHashMap<Integer, List<C1266b>> vcX = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(250516);
        AppMethodBeat.o(250516);
    }

    public b() {
        AppMethodBeat.i(250515);
        AppMethodBeat.o(250515);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.report.aa
    public final void dnC() {
        boolean z;
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            z = true;
        } else {
            z = false;
        }
        this.vcV = z;
        this.vcW = 0;
    }

    @Override // com.tencent.mm.plugin.finder.report.aa
    public final void dnD() {
        AppMethodBeat.i(250508);
        if (!Kb(0)) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, List<C1266b>> entry : this.vcX.entrySet()) {
                int intValue = entry.getKey().intValue();
                entry.getValue();
                int size = entry.getValue().size();
                ArrayList arrayList = new ArrayList();
                for (T t : entry.getValue()) {
                    if (t.isReleased) {
                        arrayList.add(t);
                    }
                }
                int size2 = arrayList.size();
                int i2 = size - size2;
                String str = "logId:" + intValue + " -- allocateCount:" + size + " releasedCount:" + size2 + " unReleaseCount:" + i2;
                if (i2 > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (T t2 : entry.getValue()) {
                        if (!t2.isReleased) {
                            arrayList2.add(t2);
                        }
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        Log.w("FeedReportWatcher", "not released logId:" + intValue + " -- " + ((C1266b) it.next()).vda);
                    }
                }
                sb.append(str + "\n");
            }
            Log.i("FeedReportWatcher", dl(this) + " calc result:\n" + ((Object) sb));
            this.vcX.clear();
            this.vcV = false;
        }
        AppMethodBeat.o(250508);
    }

    public final void a(p pVar) {
        AppMethodBeat.i(250510);
        if (Kb(18054)) {
            AppMethodBeat.o(250510);
            return;
        }
        StringBuilder sb = new StringBuilder("feedId:");
        k kVar = k.vfA;
        dnE().add(new C1266b(pVar.hashCode(), sb.append(k.Fg(pVar.feedId)).append("  obj:").append(dl(pVar)).toString()));
        AppMethodBeat.o(250510);
    }

    public final void b(p pVar) {
        AppMethodBeat.i(250511);
        if (Kb(18054)) {
            AppMethodBeat.o(250511);
        } else if (pVar != null) {
            ArrayList arrayList = new ArrayList();
            for (T t : dnE()) {
                if (t.vcZ == pVar.hashCode()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!(!arrayList2.isEmpty())) {
                arrayList2 = null;
            }
            C1266b bVar = arrayList2 != null ? (C1266b) arrayList2.get(0) : null;
            if (bVar != null) {
                bVar.isReleased = true;
                AppMethodBeat.o(250511);
                return;
            }
            AppMethodBeat.o(250511);
        } else {
            AppMethodBeat.o(250511);
        }
    }

    private final List<C1266b> dnE() {
        AppMethodBeat.i(250512);
        ArrayList arrayList = this.vcX.get(18054);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.vcX.put(18054, arrayList);
        }
        AppMethodBeat.o(250512);
        return arrayList;
    }

    static String dl(Object obj) {
        AppMethodBeat.i(250513);
        k kVar = k.vfA;
        String Fg = k.Fg((long) obj.hashCode());
        AppMethodBeat.o(250513);
        return Fg;
    }

    static /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(250514);
        boolean Kb = bVar.Kb(0);
        AppMethodBeat.o(250514);
        return Kb;
    }

    private final boolean Kb(int i2) {
        return !this.vcV && (this.vcW == 0 || this.vcW != i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FeedReportWatcher$ReportRecord;", "", "objHashCode", "", "isReleased", "", "simpleDesc", "", "complexDesc", "(IZLjava/lang/String;Ljava/lang/String;)V", "getComplexDesc", "()Ljava/lang/String;", "setComplexDesc", "(Ljava/lang/String;)V", "()Z", "setReleased", "(Z)V", "getObjHashCode", "()I", "setObjHashCode", "(I)V", "getSimpleDesc", "setSimpleDesc", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.report.b$b  reason: collision with other inner class name */
    public static final class C1266b {
        boolean isReleased;
        int vcZ;
        String vda;
        private String vdb;

        public /* synthetic */ C1266b(int i2, String str) {
            this(i2, str, "");
            AppMethodBeat.i(250507);
            AppMethodBeat.o(250507);
        }

        private C1266b(int i2, String str, String str2) {
            p.h(str, "simpleDesc");
            p.h(str2, "complexDesc");
            AppMethodBeat.i(250506);
            this.vcZ = i2;
            this.isReleased = false;
            this.vda = str;
            this.vdb = str2;
            AppMethodBeat.o(250506);
        }
    }

    public final void a(bo boVar, String str, p pVar) {
        String str2;
        AppMethodBeat.i(250509);
        p.h(str, "prefixLog");
        p.h(pVar, "record");
        if (Kb(0)) {
            AppMethodBeat.o(250509);
            return;
        }
        if (boVar instanceof BaseFinderFeed) {
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar;
            k kVar = k.vfA;
            String Fg = k.Fg(baseFinderFeed.lT());
            g gVar = baseFinderFeed.contact;
            if (gVar == null || (str2 = gVar.field_nickname) == null) {
                str2 = "";
            }
            Log.i("FeedReportWatcher", str + " --- nickName:" + str2 + " feedId:" + Fg + "        record obj:" + dl(pVar));
        }
        AppMethodBeat.o(250509);
    }
}
