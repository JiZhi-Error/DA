package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a;

import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.util.ArrayMap;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.t;

/* JADX WARN: Init of enum mja can be incorrect */
/* JADX WARN: Init of enum mjb can be incorrect */
/* JADX WARN: Init of enum mjc can be incorrect */
/* JADX WARN: Init of enum mjd can be incorrect */
/* JADX WARN: Init of enum mje can be incorrect */
/* JADX WARN: Init of enum mjf can be incorrect */
/* JADX WARN: Init of enum mjg can be incorrect */
/* JADX WARN: Init of enum mjh can be incorrect */
@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0001\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002 !B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J7\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00032\"\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u0014\"\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015¢\u0006\u0002\u0010\u0017R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rj\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "", "techName", "", "techClassName", "techLogic", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;)V", "hasMethodCache", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "getTechClassName", "()Ljava/lang/String;", "getTechLogic", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCTechLogic;", "getTechName", "hasMethod", "name", "parameterTypes", "", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Ljava/lang/Class;)Z", "NFC_A", "NFC_B", "ISO_DEP", "NFC_F", "NFC_V", "MIFARE_CLASSIC", "MIFARE_ULTRALIGHT", "NDEF", "Companion", "MethodSignature", "luggage-commons-jsapi-nfc-ext_release"})
public enum b {
    NFC_A("NFC-A", r4, f.miY),
    NFC_B("NFC-B", r4, null),
    ISO_DEP("ISO-DEP", r4, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.b.miy),
    NFC_F("NFC-F", r4, null),
    NFC_V("NFC-V", r4, null),
    MIFARE_CLASSIC("MIFARE Classic", r4, null),
    MIFARE_ULTRALIGHT("MIFARE Ultralight", r4, null),
    NDEF("NDEF", r4, null);
    
    private static final Map<String, b> mjm;
    private static final Map<String, String> mjn;
    public static final a mjo = new a((byte) 0);
    public final String mhN;
    public final ArrayMap<C0687b, Boolean> mjj = new ArrayMap<>();
    public final String mjk;
    public final com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a mjl;

    public static b valueOf(String str) {
        AppMethodBeat.i(183698);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(183698);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$hasMethod$1$1"})
    public static final class c extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ C0687b mjq;
        final /* synthetic */ b mjr;
        final /* synthetic */ String mjs;
        final /* synthetic */ Class[] mjt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(C0687b bVar, b bVar2, String str, Class[] clsArr) {
            super(0);
            this.mjq = bVar;
            this.mjr = bVar2;
            this.mjs = str;
            this.mjt = clsArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(207169);
            Boolean valueOf = Boolean.valueOf(ij());
            AppMethodBeat.o(207169);
            return valueOf;
        }

        private boolean ij() {
            boolean z;
            AppMethodBeat.i(207170);
            try {
                Class<?> cls = Class.forName(this.mjr.mjk);
                String str = this.mjs;
                Class[] clsArr = this.mjt;
                cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
                z = true;
            } catch (Exception e2) {
                StringBuilder append = new StringBuilder("get ").append(this.mjr.mjk).append('.').append(this.mjs).append('(');
                String arrays = Arrays.toString(this.mjt);
                p.g(arrays, "java.util.Arrays.toString(this)");
                Log.i("MicroMsg.AppBrand.NFCTech", append.append(arrays).append(") failed since ").append(e2).toString());
                z = false;
            }
            this.mjr.mjj.put(this.mjq, Boolean.valueOf(z));
            AppMethodBeat.o(207170);
            return z;
        }
    }

    private b(String str, String str2, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.a aVar) {
        AppMethodBeat.i(207171);
        this.mhN = str;
        this.mjk = str2;
        this.mjl = aVar;
        AppMethodBeat.o(207171);
    }

    static {
        AppMethodBeat.i(183696);
        p.g(NfcA.class.getName(), "NfcA::class.java.name");
        p.g(NfcB.class.getName(), "NfcB::class.java.name");
        p.g(IsoDep.class.getName(), "IsoDep::class.java.name");
        p.g(NfcF.class.getName(), "NfcF::class.java.name");
        p.g(NfcV.class.getName(), "NfcV::class.java.name");
        p.g(MifareClassic.class.getName(), "MifareClassic::class.java.name");
        p.g(MifareUltralight.class.getName(), "MifareUltralight::class.java.name");
        p.g(Ndef.class.getName(), "Ndef::class.java.name");
        b[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (b bVar : values) {
            arrayList.add(s.U(bVar.mhN, bVar));
        }
        mjm = ae.E(arrayList);
        b[] values2 = values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (b bVar2 : values2) {
            arrayList2.add(s.U(bVar2.mjk, bVar2.mhN));
        }
        mjn = ae.E(arrayList2);
        AppMethodBeat.o(183696);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001e\u0010\u000e\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ2\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "name", "", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "luggage-commons-jsapi-nfc-ext_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b$b  reason: collision with other inner class name */
    public static final class C0687b {
        private final Class<? extends Object>[] mjp;
        private final String name;

        public final String toString() {
            AppMethodBeat.i(207168);
            String str = "MethodSignature(name=" + this.name + ", parameterTypes=" + Arrays.toString(this.mjp) + ")";
            AppMethodBeat.o(207168);
            return str;
        }

        public C0687b(String str, Class<? extends Object>[] clsArr) {
            p.h(str, "name");
            p.h(clsArr, "parameterTypes");
            AppMethodBeat.i(207167);
            this.name = str;
            this.mjp = clsArr;
            AppMethodBeat.o(207167);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(207165);
            if (this == obj) {
                AppMethodBeat.o(207165);
                return true;
            }
            if (!p.j(getClass(), obj != null ? obj.getClass() : null)) {
                AppMethodBeat.o(207165);
                return false;
            } else if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
                AppMethodBeat.o(207165);
                throw tVar;
            } else if (!p.j(this.name, ((C0687b) obj).name)) {
                AppMethodBeat.o(207165);
                return false;
            } else if (!Arrays.equals(this.mjp, ((C0687b) obj).mjp)) {
                AppMethodBeat.o(207165);
                return false;
            } else {
                AppMethodBeat.o(207165);
                return true;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(207166);
            int hashCode = (this.name.hashCode() * 31) + Arrays.hashCode(this.mjp);
            AppMethodBeat.o(207166);
            return hashCode;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$Companion;", "", "()V", "TAG", "", "techClassName2TechNameMap", "", "getTechClassName2TechNameMap", "()Ljava/util/Map;", "techName2TechMap", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "getTechName2TechMap", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
