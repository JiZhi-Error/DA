package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class h implements b {
    private Map<String, Set<CollectSession>> lbn = new a();
    private Map<String, CollectSession> mMap = new a();

    public h() {
        AppMethodBeat.i(146110);
        AppMethodBeat.o(146110);
    }

    private boolean a(String str, CollectSession collectSession) {
        AppMethodBeat.i(146111);
        if (str == null || str.length() == 0 || collectSession == null) {
            AppMethodBeat.o(146111);
            return false;
        }
        Set<CollectSession> set = this.lbn.get(str);
        if (set == null) {
            set = new LinkedHashSet<>();
            this.lbn.put(str, set);
        }
        boolean add = set.add(collectSession);
        AppMethodBeat.o(146111);
        return add;
    }

    private Set<CollectSession> WR(String str) {
        AppMethodBeat.i(146112);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(146112);
            return null;
        }
        Set<CollectSession> set = this.lbn.get(str);
        AppMethodBeat.o(146112);
        return set;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final void clear() {
        AppMethodBeat.i(146113);
        this.mMap.clear();
        this.lbn.clear();
        AppMethodBeat.o(146113);
    }

    private CollectSession WS(String str) {
        AppMethodBeat.i(146114);
        CollectSession collectSession = this.mMap.get(str);
        if (collectSession == null) {
            collectSession = new CollectSession(str);
            this.mMap.put(str, collectSession);
        }
        AppMethodBeat.o(146114);
        return collectSession;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final void a(CollectSession collectSession) {
        AppMethodBeat.i(146115);
        String str = collectSession.id;
        CollectSession collectSession2 = this.mMap.get(str);
        if (collectSession2 == null) {
            this.mMap.put(str, collectSession);
            a(collectSession.groupId, collectSession);
            AppMethodBeat.o(146115);
            return;
        }
        TimePoint timePoint = collectSession.lbd;
        if (collectSession2.lbd == null) {
            collectSession2.lbd = timePoint;
            AppMethodBeat.o(146115);
            return;
        }
        while (timePoint != null) {
            String str2 = timePoint.name;
            long j2 = timePoint.lbp.get();
            if (!(str == null || str.length() == 0)) {
                CollectSession WS = WS(str);
                if (WS.lbd == null) {
                    WS.EL(str2);
                    WS.lbd.lbp.set(j2);
                } else {
                    TimePoint timePoint2 = WS.lbf.get(str2);
                    if (timePoint2 == null) {
                        WS.WI(str2);
                        WS.lbe.lbp.set(j2);
                    } else {
                        timePoint2.lbp.set((j2 + (timePoint2.lbp.get() * ((long) timePoint2.lbo.get()))) / ((long) (timePoint2.lbo.get() + 1)));
                        timePoint2.lbo.getAndIncrement();
                    }
                }
            }
            timePoint = timePoint.lbq.get();
        }
        AppMethodBeat.o(146115);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final CollectSession cP(String str, String str2) {
        AppMethodBeat.i(146116);
        if (str == null || str.length() == 0) {
            Log.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", str2);
            AppMethodBeat.o(146116);
            return null;
        }
        CollectSession WS = WS(str);
        if (WS.lbd == null) {
            WS.EL(str2);
        } else {
            WS.WI(str2);
        }
        AppMethodBeat.o(146116);
        return WS;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final void k(String str, String str2, boolean z) {
        AppMethodBeat.i(146117);
        if (!z) {
            AppMethodBeat.o(146117);
        } else if (str == null || str.length() == 0) {
            Log.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", str2);
            AppMethodBeat.o(146117);
        } else {
            CollectSession WS = WS(str);
            if (WS.lbd == null) {
                WS.EL(str2);
                AppMethodBeat.o(146117);
                return;
            }
            WS.WI(str2);
            AppMethodBeat.o(146117);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final void c(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(146118);
        if (!z) {
            AppMethodBeat.o(146118);
        } else if (str2 == null || str2.length() == 0) {
            Log.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", str3);
            AppMethodBeat.o(146118);
        } else if (str == null || str.length() == 0) {
            Log.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", str3);
            AppMethodBeat.o(146118);
        } else {
            CollectSession WS = WS(str2);
            if (WS.lbd == null) {
                WS.groupId = str;
                a(str, WS);
                WS.EL(str3);
                AppMethodBeat.o(146118);
                return;
            }
            WS.WI(str3);
            AppMethodBeat.o(146118);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final CollectSession WJ(String str) {
        AppMethodBeat.i(146119);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(146119);
            return null;
        }
        CollectSession collectSession = this.mMap.get(str);
        AppMethodBeat.o(146119);
        return collectSession;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final CollectSession WK(String str) {
        AppMethodBeat.i(146120);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(146120);
            return null;
        }
        CollectSession remove = this.mMap.remove(str);
        AppMethodBeat.o(146120);
        return remove;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final void cQ(String str, String str2) {
        AppMethodBeat.i(146121);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            Log.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", str, str2);
            AppMethodBeat.o(146121);
            return;
        }
        CollectSession collectSession = this.mMap.get(str);
        if (collectSession == null) {
            Log.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", str, str2);
            AppMethodBeat.o(146121);
            return;
        }
        collectSession.lbg = str2;
        AppMethodBeat.o(146121);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final void print(String str) {
        AppMethodBeat.i(146122);
        CollectSession collectSession = this.mMap.get(str);
        if (collectSession == null) {
            Log.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", str);
            AppMethodBeat.o(146122);
            return;
        }
        TimePoint timePoint = collectSession.lbd;
        if (timePoint == null) {
            Log.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", str);
            AppMethodBeat.o(146122);
            return;
        }
        StringBuilder a2 = e.a(timePoint);
        a2.insert(0, String.format("session : %s\n", collectSession.id));
        Log.i("MicroMsg.SumCostTimeCollector", "%s", a2.toString());
        AppMethodBeat.o(146122);
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final StringBuilder WL(String str) {
        AppMethodBeat.i(146123);
        Set<CollectSession> WR = WR(str);
        if (WR == null || WR.isEmpty()) {
            Log.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", str);
            StringBuilder append = new StringBuilder().append(String.format("GroupId : %s, size : 0\n", str));
            AppMethodBeat.o(146123);
            return append;
        }
        LinkedHashSet<CollectSession> linkedHashSet = new LinkedHashSet(WR);
        TimePoint timePoint = new TimePoint();
        for (CollectSession collectSession : linkedHashSet) {
            if (collectSession.lbe == null || (collectSession.lbg != null && !collectSession.lbe.name.equals(collectSession.lbg))) {
                Log.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", collectSession.id);
            } else {
                TimePoint timePoint2 = collectSession.lbd;
                TimePoint timePoint3 = timePoint;
                while (timePoint2 != null) {
                    timePoint3.lbp.set(((timePoint3.lbp.get() * ((long) timePoint3.lbo.get())) + timePoint2.lbp.get()) / ((long) timePoint3.lbo.incrementAndGet()));
                    timePoint3.name = timePoint2.name;
                    timePoint2 = timePoint2.lbq.get();
                    if (timePoint3.lbq.get() == null && timePoint2 != null) {
                        timePoint3.lbq.set(new TimePoint());
                    }
                    timePoint3 = timePoint3.lbq.get();
                }
            }
        }
        StringBuilder a2 = e.a(timePoint);
        a2.insert(0, String.format("GroupId : %s, size : %d\n", str, Integer.valueOf(linkedHashSet.size())));
        AppMethodBeat.o(146123);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.b
    public final int cR(String str, String str2) {
        AppMethodBeat.i(146124);
        Set<CollectSession> WR = WR(str);
        if (WR == null || WR.isEmpty()) {
            Log.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", str);
            AppMethodBeat.o(146124);
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        for (CollectSession collectSession : new LinkedHashSet(WR)) {
            int i4 = collectSession.dNV.getInt(str2);
            if (i4 != 0) {
                i3 += i4;
                i2++;
            }
        }
        if (i2 == 0) {
            AppMethodBeat.o(146124);
            return 0;
        }
        int i5 = i3 / i2;
        AppMethodBeat.o(146124);
        return i5;
    }
}
