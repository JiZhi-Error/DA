package com.tencent.mm.plugin.finder.report;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.cb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.storage.ar;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J&\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "getCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "dequeReportData", "", "feedId", "everclosed", "", "everopened", "expocnt", "expotimes", "is_open", "value", "", "report20353", "mediaType", NativeProtocol.WEB_DIALOG_ACTION, "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "start", "totalcnt", "FeedBulletData", "plugin-finder_release"})
public final class c {
    private static final ConcurrentHashMap<Long, a> cache = new ConcurrentHashMap<>();
    public static final c vdc = new c();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "", "()V", "everclosed", "", "getEverclosed", "()I", "setEverclosed", "(I)V", "everopened", "getEveropened", "setEveropened", "expocnt", "getExpocnt", "setExpocnt", "expotimes", "getExpotimes", "setExpotimes", "is_open", "set_open", "totalcnt", "getTotalcnt", "setTotalcnt", "plugin-finder_release"})
    public static final class a {
        int vdd;
        int vde;
        int vdf;
        int vdg = 1;
        int vdh;
        int vdi;
    }

    static {
        AppMethodBeat.i(250526);
        AppMethodBeat.o(250526);
    }

    private c() {
    }

    public static void EU(long j2) {
        AppMethodBeat.i(250517);
        a aVar = cache.get(Long.valueOf(j2));
        if (aVar != null) {
            aVar.vdd++;
            AppMethodBeat.o(250517);
            return;
        }
        AppMethodBeat.o(250517);
    }

    public static void EV(long j2) {
        AppMethodBeat.i(250518);
        a aVar = cache.get(Long.valueOf(j2));
        if (aVar != null) {
            aVar.vde++;
            AppMethodBeat.o(250518);
            return;
        }
        AppMethodBeat.o(250518);
    }

    public static void E(long j2, int i2) {
        AppMethodBeat.i(250519);
        a aVar = cache.get(Long.valueOf(j2));
        if (aVar != null) {
            aVar.vdf = i2;
            AppMethodBeat.o(250519);
            return;
        }
        AppMethodBeat.o(250519);
    }

    public static void F(long j2, int i2) {
        AppMethodBeat.i(250520);
        a aVar = cache.get(Long.valueOf(j2));
        if (aVar != null) {
            aVar.vdg = i2;
            AppMethodBeat.o(250520);
            return;
        }
        AppMethodBeat.o(250520);
    }

    public static void EW(long j2) {
        AppMethodBeat.i(250521);
        a aVar = cache.get(Long.valueOf(j2));
        if (aVar != null) {
            aVar.vdh = 1;
            AppMethodBeat.o(250521);
            return;
        }
        AppMethodBeat.o(250521);
    }

    public static void EX(long j2) {
        AppMethodBeat.i(250522);
        a aVar = cache.get(Long.valueOf(j2));
        if (aVar != null) {
            aVar.vdi = 1;
            AppMethodBeat.o(250522);
            return;
        }
        AppMethodBeat.o(250522);
    }

    public static void start(long j2) {
        AppMethodBeat.i(250523);
        if (!cache.containsKey(Long.valueOf(j2))) {
            cache.put(Long.valueOf(j2), new a());
        }
        AppMethodBeat.o(250523);
    }

    public static String EY(long j2) {
        int i2 = 1;
        AppMethodBeat.i(250524);
        a aVar = cache.get(Long.valueOf(j2));
        if (aVar == null) {
            AppMethodBeat.o(250524);
            return "";
        }
        p.g(aVar, "cache[feedId] ?: return \"\"");
        cache.remove(Long.valueOf(j2));
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (!aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_SWITCH_BOOLEAN, true)) {
            i2 = 0;
        }
        aVar.vdg = i2;
        String str = "{expocnt:" + aVar.vdd + ";expotimes:" + aVar.vde + ";totalcnt:" + aVar.vdf + ';' + "is_open:" + aVar.vdg + ";everclosed:" + aVar.vdh + ";everopened:" + aVar.vdi + '}';
        AppMethodBeat.o(250524);
        return str;
    }

    public static void a(long j2, int i2, int i3, bbn bbn) {
        AppMethodBeat.i(250525);
        p.h(bbn, "contextObj");
        cb cbVar = new cb();
        cbVar.kM(d.zs(j2));
        cbVar.fm((long) i2);
        cbVar.fn((long) bbn.tCE);
        cbVar.fo((long) i3);
        cbVar.kN(bbn.sessionId);
        cbVar.kO(bbn.sGQ);
        cbVar.kP(bbn.sGE);
        cbVar.bfK();
        k kVar = k.vfA;
        k.a(cbVar);
        AppMethodBeat.o(250525);
    }
}
