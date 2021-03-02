package com.tencent.mm.storage;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\u0006R#\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/storage/BizTimeLineRecCardLogic;", "", "()V", "MAX_INSERT_COUNT", "", "getMAX_INSERT_COUNT", "()I", "MAX_SAVE_COUNT", "getMAX_SAVE_COUNT", "MAX_SAVE_COUNT$delegate", "Lkotlin/Lazy;", "MIN_NEW_COUNT", "getMIN_NEW_COUNT", "MIN_NEW_COUNT$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "idKey1577", "", "key", "", "insertRecCardUnderLine", "saveRecCardUnderLine", "msgContent", "", "plugin-biz_release"})
public final class ac {
    private static final f NQZ = g.ah(a.NRd);
    static final f NRa = g.ah(b.NRe);
    private static final int NRb = gBf();
    public static final ac NRc = new ac();
    private static final f iBW = g.ah(d.NRg);

    public static MultiProcessMMKV aTI() {
        AppMethodBeat.i(212612);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(212612);
        return multiProcessMMKV;
    }

    public static int gBf() {
        AppMethodBeat.i(212613);
        int intValue = ((Number) NQZ.getValue()).intValue();
        AppMethodBeat.o(212613);
        return intValue;
    }

    static {
        AppMethodBeat.i(212617);
        AppMethodBeat.o(212617);
    }

    private ac() {
    }

    public static int gBg() {
        return NRb;
    }

    public static void bjb(String str) {
        AppMethodBeat.i(212614);
        if (str == null) {
            AppMethodBeat.o(212614);
            return;
        }
        h.RTc.b(new e(str), "RecCardUnderLineThread");
        AppMethodBeat.o(212614);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ String kWI;

        e(String str) {
            this.kWI = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 288
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ac.e.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        public static final c NRf = new c();

        static {
            AppMethodBeat.i(212608);
            AppMethodBeat.o(212608);
        }

        c() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0072  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 400
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ac.c.run():void");
        }
    }

    public static void gBh() {
        AppMethodBeat.i(212615);
        h.RTc.b(c.NRf, "RecCardUnderLineThread");
        AppMethodBeat.o(212615);
    }

    public static void Nd(long j2) {
        AppMethodBeat.i(212616);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1577, j2, 1);
        AppMethodBeat.o(212616);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final d NRg = new d();

        static {
            AppMethodBeat.i(212610);
            AppMethodBeat.o(212610);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212609);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(212609);
            return singleMMKV;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Integer> {
        public static final a NRd = new a();

        static {
            AppMethodBeat.i(212604);
            AppMethodBeat.o(212604);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(212603);
            ac acVar = ac.NRc;
            Integer valueOf = Integer.valueOf(j.na(j.mZ(ac.aTI().decodeInt("RecCardMaxKeepMsgCount", 3), 1), 10));
            AppMethodBeat.o(212603);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Integer> {
        public static final b NRe = new b();

        static {
            AppMethodBeat.i(212606);
            AppMethodBeat.o(212606);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(212605);
            ac acVar = ac.NRc;
            Integer valueOf = Integer.valueOf(j.na(j.mZ(ac.aTI().decodeInt("RecCardMinNewMsgCount", 3), 1), 10));
            AppMethodBeat.o(212605);
            return valueOf;
        }
    }
}
