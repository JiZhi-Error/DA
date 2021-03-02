package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class f {
    public static final a sHi = new a((byte) 0);

    static {
        AppMethodBeat.i(221082);
        AppMethodBeat.o(221082);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0006\u0010\u0018\u001a\u00020\u000bJ\b\u0010\u0019\u001a\u00020\u000bH\u0007J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fH\u0007J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fJ\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao$Companion;", "", "()V", "MMKV_KEY", "", "MMKV_KEY_WITHOUT_78EVENT", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/PageStatisticsMap;", "_readWith78Event", "_write", "", "pageMap", "_writeWith78Event", "getLastStatics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "getLastStaticsWith78Event", "read", "sPageName", "hashCode", "", "readWith78Event", "remove", "removeWith78Event", "reset", "resetWith78Event", "update", "statics", "updateWith78Event", "write", "writeWith78Event", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final synchronized void a(cym cym) {
            cyo cyo;
            boolean z;
            AppMethodBeat.i(221066);
            p.h(cym, "statics");
            cyo cPp = cPp();
            if (cPp == null) {
                cyo = new cyo();
            } else {
                cyo = cPp;
            }
            String str = cym.dMl + cym.aHK;
            LinkedList<cyn> linkedList = cyo.Mlv;
            p.g(linkedList, "pageMap.map");
            Iterator<T> it = linkedList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (p.j(str, it.next().key)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                cyn cyn = new cyn();
                cyn.key = str;
                cyn.MDw = cym;
                cyo.Mlv.add(cyn);
                a(cyo);
            }
            AppMethodBeat.o(221066);
        }

        public final synchronized void b(cym cym) {
            cyo cyo;
            boolean z;
            AppMethodBeat.i(221067);
            p.h(cym, "statics");
            cyo cPp = cPp();
            if (cPp == null) {
                cyo = new cyo();
            } else {
                cyo = cPp;
            }
            String str = cym.dMl + cym.aHK;
            LinkedList<cyn> linkedList = cyo.Mlv;
            p.g(linkedList, "pageMap.map");
            Iterator<T> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                T next = it.next();
                if (p.j(str, next.key)) {
                    next.MDw = cym;
                    z = true;
                    break;
                }
            }
            if (!z) {
                cyn cyn = new cyn();
                cyn.key = str;
                cyn.MDw = cym;
                cyo.Mlv.add(cyn);
            }
            a(cyo);
            AppMethodBeat.o(221067);
        }

        public final synchronized cym dk(String str, int i2) {
            cym cym;
            AppMethodBeat.i(221068);
            if (str != null) {
                cyo cPp = cPp();
                if (cPp != null) {
                    String str2 = str + String.valueOf(i2);
                    LinkedList<cyn> linkedList = cPp.Mlv;
                    p.g(linkedList, "pageMap.map");
                    Iterator<T> it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            AppMethodBeat.o(221068);
                            cym = null;
                            break;
                        }
                        T next = it.next();
                        if (p.j(str2, next.key)) {
                            cym = next.MDw;
                            AppMethodBeat.o(221068);
                            break;
                        }
                    }
                } else {
                    AppMethodBeat.o(221068);
                    cym = null;
                }
            } else {
                AppMethodBeat.o(221068);
                cym = null;
            }
            return cym;
        }

        public final synchronized void dl(String str, int i2) {
            boolean z;
            AppMethodBeat.i(221069);
            if (str == null) {
                AppMethodBeat.o(221069);
            } else {
                cyo cPp = cPp();
                if (cPp == null) {
                    AppMethodBeat.o(221069);
                } else {
                    String str2 = str + i2;
                    LinkedList<cyn> linkedList = cPp.Mlv;
                    p.g(linkedList, "pageMap.map");
                    Iterator<T> it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        T next = it.next();
                        if (p.j(str2, next.key)) {
                            cPp.Mlv.remove(next);
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        if (cPp.Mlv.isEmpty()) {
                            b.o("hell_pge_sttics_d_1", new byte[0]);
                            AppMethodBeat.o(221069);
                        } else {
                            a(cPp);
                        }
                    }
                    AppMethodBeat.o(221069);
                }
            }
        }

        public final synchronized cym cPo() {
            cym cym = null;
            synchronized (this) {
                AppMethodBeat.i(221070);
                cyo cPp = cPp();
                if (cPp == null) {
                    AppMethodBeat.o(221070);
                } else if (cPp.Mlv.isEmpty()) {
                    AppMethodBeat.o(221070);
                } else {
                    LinkedList<cyn> linkedList = cPp.Mlv;
                    p.g(linkedList, "pageMap.map");
                    cym = linkedList.getLast().MDw;
                    AppMethodBeat.o(221070);
                }
            }
            return cym;
        }

        public final synchronized void reset() {
            AppMethodBeat.i(221071);
            if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
                Log.i("HABBYGE-MALI.PageStatisticsDao", "reset");
                b.o("hell_pge_sttics_d_1", new byte[0]);
            }
            AppMethodBeat.o(221071);
        }

        private static cyo cPp() {
            AppMethodBeat.i(221072);
            byte[] bytes = b.getBytes("hell_pge_sttics_d_1");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    cyo cyo = new cyo();
                    try {
                        cyo.parseFrom(bytes);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", e2, "_read, exception: " + e2.getMessage(), new Object[0]);
                        cyo = null;
                    }
                    AppMethodBeat.o(221072);
                    return cyo;
                }
            }
            AppMethodBeat.o(221072);
            return null;
        }

        private static void a(cyo cyo) {
            AppMethodBeat.i(221073);
            try {
                b.o("hell_pge_sttics_d_1", cyo.toByteArray());
                AppMethodBeat.o(221073);
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", e2, "_write, exception: " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(221073);
            }
        }

        public final synchronized void c(cym cym) {
            cyo cyo;
            boolean z;
            AppMethodBeat.i(221074);
            p.h(cym, "statics");
            cyo cPs = cPs();
            if (cPs == null) {
                cyo = new cyo();
            } else {
                cyo = cPs;
            }
            String str = cym.dMl + cym.aHK;
            LinkedList<cyn> linkedList = cyo.Mlv;
            p.g(linkedList, "pageMap.map");
            Iterator<T> it = linkedList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (p.j(str, it.next().key)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                cyn cyn = new cyn();
                cyn.key = str;
                cyn.MDw = cym;
                cyo.Mlv.add(cyn);
                b(cyo);
            }
            AppMethodBeat.o(221074);
        }

        public final synchronized void d(cym cym) {
            cyo cyo;
            boolean z;
            AppMethodBeat.i(221075);
            p.h(cym, "statics");
            cyo cPs = cPs();
            if (cPs == null) {
                cyo = new cyo();
            } else {
                cyo = cPs;
            }
            String str = cym.dMl + cym.aHK;
            LinkedList<cyn> linkedList = cyo.Mlv;
            p.g(linkedList, "pageMap.map");
            Iterator<T> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                T next = it.next();
                if (p.j(str, next.key)) {
                    next.MDw = cym;
                    z = true;
                    break;
                }
            }
            if (!z) {
                cyn cyn = new cyn();
                cyn.key = str;
                cyn.MDw = cym;
                cyo.Mlv.add(cyn);
            }
            b(cyo);
            AppMethodBeat.o(221075);
        }

        public final synchronized cym dm(String str, int i2) {
            cym cym;
            AppMethodBeat.i(221076);
            if (str != null) {
                cyo cPs = cPs();
                if (cPs != null) {
                    String str2 = str + String.valueOf(i2);
                    LinkedList<cyn> linkedList = cPs.Mlv;
                    p.g(linkedList, "pageMap.map");
                    Iterator<T> it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            AppMethodBeat.o(221076);
                            cym = null;
                            break;
                        }
                        T next = it.next();
                        if (p.j(str2, next.key)) {
                            cym = next.MDw;
                            AppMethodBeat.o(221076);
                            break;
                        }
                    }
                } else {
                    AppMethodBeat.o(221076);
                    cym = null;
                }
            } else {
                AppMethodBeat.o(221076);
                cym = null;
            }
            return cym;
        }

        public final synchronized void dn(String str, int i2) {
            boolean z;
            AppMethodBeat.i(221077);
            if (str == null) {
                AppMethodBeat.o(221077);
            } else {
                cyo cPs = cPs();
                if (cPs == null) {
                    AppMethodBeat.o(221077);
                } else {
                    String str2 = str + i2;
                    LinkedList<cyn> linkedList = cPs.Mlv;
                    p.g(linkedList, "pageMap.map");
                    Iterator<T> it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        T next = it.next();
                        if (p.j(str2, next.key)) {
                            cPs.Mlv.remove(next);
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        if (cPs.Mlv.isEmpty()) {
                            b.o("hell_pge_sttics_d_3", new byte[0]);
                            AppMethodBeat.o(221077);
                        } else {
                            b(cPs);
                        }
                    }
                    AppMethodBeat.o(221077);
                }
            }
        }

        public final synchronized cym cPq() {
            cym cym = null;
            synchronized (this) {
                AppMethodBeat.i(221078);
                cyo cPs = cPs();
                if (cPs == null) {
                    AppMethodBeat.o(221078);
                } else if (cPs.Mlv.isEmpty()) {
                    AppMethodBeat.o(221078);
                } else {
                    LinkedList<cyn> linkedList = cPs.Mlv;
                    p.g(linkedList, "pageMap.map");
                    cym = linkedList.getLast().MDw;
                    AppMethodBeat.o(221078);
                }
            }
            return cym;
        }

        public final synchronized void cPr() {
            AppMethodBeat.i(221079);
            if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
                Log.i("HABBYGE-MALI.PageStatisticsDao", "resetWith78Event");
                b.o("hell_pge_sttics_d_3", new byte[0]);
            }
            AppMethodBeat.o(221079);
        }

        private static cyo cPs() {
            AppMethodBeat.i(221080);
            byte[] bytes = b.getBytes("hell_pge_sttics_d_3");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    cyo cyo = new cyo();
                    try {
                        cyo.parseFrom(bytes);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", e2, "_readWith78Event, exception: " + e2.getMessage(), new Object[0]);
                        cyo = null;
                    }
                    AppMethodBeat.o(221080);
                    return cyo;
                }
            }
            AppMethodBeat.o(221080);
            return null;
        }

        private static void b(cyo cyo) {
            AppMethodBeat.i(221081);
            try {
                b.o("hell_pge_sttics_d_3", cyo.toByteArray());
                AppMethodBeat.o(221081);
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", e2, "_writeWith78Event, exception: " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(221081);
            }
        }
    }
}
