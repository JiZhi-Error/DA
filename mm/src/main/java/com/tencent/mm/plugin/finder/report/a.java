package com.tencent.mm.plugin.finder.report;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\b\u0016\u0018\u0000 /*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001/B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0006J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0006J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u001d\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020\u000e2\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010#J\u0018\u0010%\u001a\u00020\u00142\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016H\u0002J\u001b\u0010'\u001a\u00020\u00142\u0006\u0010 \u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0002\u0010!J,\u0010'\u001a\u00020\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u001e\u0010'\u001a\u00020\u00142\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0006J\u0016\u0010+\u001a\u00020\u00142\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fJ\u0016\u0010,\u001a\u00020\u00142\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010J\u0006\u0010-\u001a\u00020\u0014J\u0006\u0010.\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "ID", "", "()V", "browserExposeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "clickChatExposeMap", "clickExposeSet", "", "curBrowseExposeSet", "diffDataListener", "Lcom/tencent/mm/plugin/finder/report/IDiffData;", "isStatistic", "", "statisticCondition", "Lcom/tencent/mm/plugin/finder/report/IStatisticCondition;", "threadName", "", "copySet", "", "src", "", "dst", "getExposeContainer", "type", "getExposePv", "", "getExposeSet", "getExposeUV", "getMapContainer", "incExpose", "id", "(Ljava/lang/Object;I)V", "isIdLegal", "(Ljava/lang/Object;)Z", "isShouldExecute", "onDiffData", "diffData", "record", "exposedSet", "curSet", "idSet", "setOnDiffDataListener", "setStatisticCondition", "startStatistic", "stopStatistic", "Companion", "plugin-finder_release"})
public final class a<ID> {
    private static final String TAG = TAG;
    public static final C1265a vcS = new C1265a((byte) 0);
    private final String threadName = "ExposeStatisticUtil";
    volatile boolean vcL;
    public z<ID> vcM;
    ab<ID> vcN;
    private final Set<ID> vcO = new HashSet();
    private final ConcurrentHashMap<ID, Integer> vcP = new ConcurrentHashMap<>();
    private final Set<ID> vcQ = new HashSet();
    private final ConcurrentHashMap<ID, Integer> vcR = new ConcurrentHashMap<>();

    public a() {
        AppMethodBeat.i(250504);
        AppMethodBeat.o(250504);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TYPE_EXPOSE_BROWSE", "", "TYPE_EXPOSE_CLICK", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.report.a$a  reason: collision with other inner class name */
    public static final class C1265a {
        private C1265a() {
        }

        public /* synthetic */ C1265a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(250505);
        AppMethodBeat.o(250505);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0014 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(java.util.Set<? extends ID> r7) {
        /*
            r6 = this;
            r5 = 250502(0x3d286, float:3.51028E-40)
            r2 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r3 = r7.iterator()
        L_0x0014:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x0037
            java.lang.Object r4 = r3.next()
            boolean r1 = r6.vcL
            if (r1 == 0) goto L_0x0035
            com.tencent.mm.plugin.finder.report.ab<ID> r1 = r6.vcN
            if (r1 == 0) goto L_0x0033
            boolean r1 = r1.dm(r4)
        L_0x002a:
            if (r1 == 0) goto L_0x0035
            r1 = r2
        L_0x002d:
            if (r1 == 0) goto L_0x0014
            r0.add(r4)
            goto L_0x0014
        L_0x0033:
            r1 = r2
            goto L_0x002a
        L_0x0035:
            r1 = 0
            goto L_0x002d
        L_0x0037:
            java.util.List r0 = (java.util.List) r0
            java.util.Set<ID> r1 = r6.vcO
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r0 = kotlin.a.j.r(r0)
            r6.a(r1, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.a.m(java.util.Set):void");
    }

    private final void a(Set<? extends ID> set, Set<? extends ID> set2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(250503);
        if (!this.vcL) {
            AppMethodBeat.o(250503);
            return;
        }
        Set a2 = ak.a(set2, set);
        Set<ID> set3 = this.vcO;
        set3.clear();
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            set3.add(it.next());
        }
        if (a2 != null && !a2.isEmpty()) {
            h.RTc.b(new b(this, a2), this.threadName);
        }
        Log.i(TAG, "newExposeRecords" + a2 + "，size:" + (a2 != null ? Integer.valueOf(a2.size()) : null) + ')');
        if (a2 != null) {
            if (!a2.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Iterator it2 = a2.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof Integer) {
                        z2 = ((Number) next).intValue() >= 0;
                    } else if (next instanceof String) {
                        z2 = !Util.isNullOrNil((String) next);
                    } else {
                        z2 = next != null;
                    }
                    if (z2) {
                        ConcurrentHashMap<ID, Integer> concurrentHashMap = this.vcP;
                        if (concurrentHashMap.keySet().contains(next)) {
                            Integer num = concurrentHashMap.get(next);
                            if (num != null) {
                                concurrentHashMap.put(next, Integer.valueOf(num.intValue() + 1));
                            }
                        } else {
                            concurrentHashMap.put(next, 1);
                        }
                    }
                }
            }
            AppMethodBeat.o(250503);
            return;
        }
        AppMethodBeat.o(250503);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "ID", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ a vcT;
        final /* synthetic */ Set vcU;

        b(a aVar, Set set) {
            this.vcT = aVar;
            this.vcU = set;
        }

        public final void run() {
            AppMethodBeat.i(250501);
            z zVar = this.vcT.vcM;
            if (zVar != null) {
                zVar.doO();
                AppMethodBeat.o(250501);
                return;
            }
            AppMethodBeat.o(250501);
        }
    }
}
