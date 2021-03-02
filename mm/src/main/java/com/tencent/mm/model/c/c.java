package com.tencent.mm.model.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0013\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0003&'(B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010!\u001a\u00020\u001a*\u00020\u00162\u0006\u0010\"\u001a\u00020\u0005H\u0002J\f\u0010#\u001a\u00020\n*\u00020$H\u0002J\u0014\u0010%\u001a\u00020\u001a*\u00020\u00162\u0006\u0010\"\u001a\u00020\u0005H\u0002R\u001c\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006)"}, hxF = {"Lcom/tencent/mm/model/newabtest/NewABTestMMKV;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/plugin/IPin;", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_NAME", "", "PROVIDER", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "getPROVIDER", "()Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "PROVIDER$delegate", "Lkotlin/Lazy;", "TAG", "mmAbTestStorageChangeListener", "com/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1;", "getAbTestItem", "Lcom/tencent/mm/storage/ABTestItem;", "id", "getLayerKey", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "resetAllExp", "storage", "Lcom/tencent/mm/storage/ABTestStorage;", "marshallFrom", "mmkv", "toUinString", "", "unmarshallTo", "ClientProvider", "MMProvider", "Provider", "plugin-abtest_release"})
public final class c implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c {
    private static final e iHh = new e();
    private static final f iHi = g.ah(C0446c.iHm);
    public static final c iHj = new c();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "", "provideUIN", "", "plugin-abtest_release"})
    public interface d {
        int aXs();
    }

    private static d aXr() {
        AppMethodBeat.i(153180);
        d dVar = (d) iHi.getValue();
        AppMethodBeat.o(153180);
        return dVar;
    }

    static {
        AppMethodBeat.i(153176);
        AppMethodBeat.o(153176);
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onNotifyChange", "", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "plugin-abtest_release"})
    public static final class e implements MStorage.IOnStorageChange {
        e() {
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(153175);
            if (p.j("event_updated", str)) {
                c cVar = c.iHj;
                com.tencent.mm.storage.d aXu = d.aXu();
                p.g(aXu, "SubCoreNewABTest.getABTestStorage()");
                cVar.a(aXu);
            }
            AppMethodBeat.o(153175);
        }
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(153177);
        StringBuilder sb = new StringBuilder("onAccountInitialized uin[");
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        Log.i("MicroMsg.PluginABTest.NewABTestMMKV", sb.append(sB(com.tencent.mm.kernel.a.getUin())).append(']').toString());
        d.aXu().add("MicroMsg.PluginABTest.NewABTestMMKV", iHh);
        com.tencent.mm.storage.d aXu = d.aXu();
        p.g(aXu, "SubCoreNewABTest.getABTestStorage()");
        a(aXu);
        AppMethodBeat.o(153177);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(153178);
        d.aXu().remove(iHh);
        AppMethodBeat.o(153178);
    }

    public final void a(com.tencent.mm.storage.d dVar) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(153179);
        p.h(dVar, "storage");
        MultiProcessMMKV VQ = VQ();
        VQ.clear();
        Cursor all = dVar.getAll();
        if (all != null) {
            Cursor cursor = all;
            try {
                Cursor cursor2 = cursor;
                if (!cursor2.moveToFirst()) {
                    kotlin.f.b.a(cursor, null);
                    AppMethodBeat.o(153179);
                    return;
                }
                com.tencent.mm.storage.c cVar = new com.tencent.mm.storage.c();
                do {
                    cVar.convertFrom(cursor2);
                    String str = cVar.field_layerId;
                    if (!(str == null || str.length() == 0)) {
                        p.g(VQ, "mmkv");
                        String str2 = "layer_" + cVar.field_layerId;
                        VQ.putString(str2 + "_rawXML", cVar.field_rawXML);
                        VQ.putLong(str2 + "_startTime", cVar.field_startTime);
                        VQ.putLong(str2 + "_endTime", cVar.field_endTime);
                    }
                } while (cursor2.moveToNext());
                x xVar = x.SXb;
                kotlin.f.b.a(cursor, null);
                AppMethodBeat.o(153179);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                kotlin.f.b.a(cursor, th2);
                AppMethodBeat.o(153179);
                throw th;
            }
        } else {
            AppMethodBeat.o(153179);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$MMProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "provideUIN", "", "plugin-abtest_release"})
    static final class b implements d {
        @Override // com.tencent.mm.model.c.c.d
        public final int aXs() {
            AppMethodBeat.i(153172);
            p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
            int uin = com.tencent.mm.kernel.a.getUin();
            AppMethodBeat.o(153172);
            return uin;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, hxF = {"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$ClientProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "UIN", "", "getUIN", "()I", "UIN$delegate", "Lkotlin/Lazy;", "provideUIN", "plugin-abtest_release"})
    static final class a implements d {
        private final f iHk = g.ah(C0445a.iHl);

        public a() {
            AppMethodBeat.i(153171);
            AppMethodBeat.o(153171);
        }

        @Override // com.tencent.mm.model.c.c.d
        public final int aXs() {
            AppMethodBeat.i(153170);
            int intValue = ((Number) this.iHk.getValue()).intValue();
            AppMethodBeat.o(153170);
            return intValue;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.model.c.c$a$a  reason: collision with other inner class name */
        static final class C0445a extends q implements kotlin.g.a.a<Integer> {
            public static final C0445a iHl = new C0445a();

            static {
                AppMethodBeat.i(153168);
                AppMethodBeat.o(153168);
            }

            C0445a() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Integer invoke() {
                AppMethodBeat.i(153167);
                Integer valueOf = Integer.valueOf(com.tencent.mm.kernel.a.azs());
                AppMethodBeat.o(153167);
                return valueOf;
            }
        }
    }

    private static MultiProcessMMKV VQ() {
        AppMethodBeat.i(153181);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sB(aXr().aXs()) + "_PluginABTest_NewABTestMMKV");
        AppMethodBeat.o(153181);
        return mmkv;
    }

    public static com.tencent.mm.storage.c Lg(String str) {
        AppMethodBeat.i(153182);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(153182);
            return null;
        }
        com.tencent.mm.storage.c cVar = new com.tencent.mm.storage.c();
        cVar.field_layerId = str;
        MultiProcessMMKV VQ = VQ();
        p.g(VQ, "MMKV");
        String str3 = "layer_" + cVar.field_layerId;
        cVar.field_rawXML = VQ.getString(str3 + "_rawXML", "");
        cVar.field_startTime = VQ.getLong(str3 + "_startTime", Util.nowSecond());
        cVar.field_endTime = VQ.getLong(str3 + "_endTime", Util.nowSecond());
        AppMethodBeat.o(153182);
        return cVar;
    }

    private static String sB(int i2) {
        AppMethodBeat.i(153183);
        String pVar = new com.tencent.mm.b.p(i2).toString();
        p.g(pVar, "com.tencent.mm.algorithm.UIN(this).toString()");
        AppMethodBeat.o(153183);
        return pVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "invoke"})
    /* renamed from: com.tencent.mm.model.c.c$c  reason: collision with other inner class name */
    static final class C0446c extends q implements kotlin.g.a.a<d> {
        public static final C0446c iHm = new C0446c();

        static {
            AppMethodBeat.i(153174);
            AppMethodBeat.o(153174);
        }

        C0446c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ d invoke() {
            AppMethodBeat.i(153173);
            h azG = com.tencent.mm.kernel.g.aAe().azG();
            p.g(azG, "MMKernel.process().current()");
            if (azG.aBb()) {
                b bVar = new b();
                AppMethodBeat.o(153173);
                return bVar;
            }
            a aVar = new a();
            AppMethodBeat.o(153173);
            return aVar;
        }
    }
}
