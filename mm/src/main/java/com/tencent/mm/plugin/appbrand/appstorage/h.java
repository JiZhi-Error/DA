package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u000212B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J2\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J%\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010$J\"\u0010%\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\t2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\bJ\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tJ$\u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J9\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002J \u0010+\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\tH\u0002J \u0010/\u001a\u0002002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", OpenSDKTool4Assistant.EXTRA_UIN, "", "(J)V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "luggage-wechat-full-sdk_release"})
public final class h implements p {
    private static final Map<Long, h> kSk = new LinkedHashMap();
    public static final a kSl = new a((byte) 0);
    private final kotlin.g.a.b<String, String> kRJ;
    private final m<String, String, x> kRK;
    private MultiProcessMMKV kSj;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "key", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ h kSn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar) {
            super(1);
            this.kSn = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(147864);
            String str2 = str;
            p.h(str2, "key");
            this.kSn.kSj.remove(str2);
            x xVar = x.SXb;
            AppMethodBeat.o(147864);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "key", "invoke"})
    static final class d extends q implements kotlin.g.a.b<String, String> {
        final /* synthetic */ h kSn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar) {
            super(1);
            this.kSn = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(147865);
            String str2 = str;
            p.h(str2, "key");
            String string = this.kSn.kSj.getString(str2, "");
            if (string == null) {
                string = "";
            }
            AppMethodBeat.o(147865);
            return string;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class e extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ z.d kSo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(z.d dVar) {
            super(1);
            this.kSo = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(147866);
            p.h(str, LocaleUtil.ITALIAN);
            this.kSo.SYE++;
            x xVar = x.SXb;
            AppMethodBeat.o(147866);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<no name provided>", "", "key", "", "value", "invoke"})
    static final class f extends q implements m<String, String, x> {
        final /* synthetic */ h kSn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(h hVar) {
            super(2);
            this.kSn = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(String str, String str2) {
            AppMethodBeat.i(147867);
            String str3 = str;
            String str4 = str2;
            p.h(str3, "key");
            p.h(str4, "value");
            this.kSn.kSj.putString(str3, str4);
            x xVar = x.SXb;
            AppMethodBeat.o(147867);
            return xVar;
        }
    }

    private h(long j2) {
        AppMethodBeat.i(147885);
        Log.i("AppBrandMMKVStorage", "getMMKV uin:".concat(String.valueOf(j2)));
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("AppBrandMMKVStorage".concat(String.valueOf(j2)));
        p.g(mmkv, "MultiProcessMMKV.getMMKV(NAME + uin)");
        this.kSj = mmkv;
        this.kRJ = new d(this);
        this.kRK = new f(this);
        AppMethodBeat.o(147885);
    }

    public /* synthetic */ h(long j2, byte b2) {
        this(j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object[] l(int r7, java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.h.l(int, java.lang.String, java.lang.String):java.lang.Object[]");
    }

    public final p.a c(int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(147869);
        kotlin.g.b.p.h(str4, "dataType");
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            p.a aVar = p.a.MISSING_PARAMS;
            AppMethodBeat.o(147869);
            return aVar;
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        if (str2 == null) {
            kotlin.g.b.p.hyc();
        }
        String c2 = t.c(i2, str, str2, "__");
        int VM = VM(c2);
        int cF = t.cF(str2, str3);
        int i3 = cF - VM;
        if (i(i2, str, i3)) {
            p.a aVar2 = p.a.QUOTA_REACHED;
            AppMethodBeat.o(147869);
            return aVar2;
        }
        this.kSj.putString(c2, s(str3, str4, cF));
        h(i2, str, i3);
        t.a(str, i2, this.kRJ, this.kRK);
        p.a aVar3 = p.a.NONE;
        AppMethodBeat.o(147869);
        return aVar3;
    }

    private final void g(int i2, String str, int i3) {
        AppMethodBeat.i(147870);
        this.kSj.putString(t.c(i2, str, "@@@TOTAL@DATA@SIZE@@@", "++"), String.valueOf(i3));
        AppMethodBeat.o(147870);
    }

    private final int h(int i2, String str, int i3) {
        AppMethodBeat.i(147871);
        int max = Math.max(0, aa(i2, str) + i3);
        g(i2, str, max);
        AppMethodBeat.o(147871);
        return max;
    }

    private final int VM(String str) {
        int i2;
        AppMethodBeat.i(147872);
        String string = this.kSj.getString(str, "");
        if (string == null) {
            string = "";
        }
        try {
            i2 = Integer.parseInt(VT(string).kSm);
        } catch (NumberFormatException e2) {
            i2 = 0;
        }
        AppMethodBeat.o(147872);
        return i2;
    }

    private static String s(String str, String str2, int i2) {
        AppMethodBeat.i(147873);
        String str3 = str2 + "#" + i2 + "#" + str;
        AppMethodBeat.o(147873);
        return str3;
    }

    private static b VT(String str) {
        AppMethodBeat.i(147874);
        Object[] array = new k("#").q(str, 3).toArray(new String[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(147874);
            throw tVar;
        }
        String[] strArr = (String[]) array;
        if (strArr.length == 3) {
            b bVar = new b(strArr[2], strArr[0], strArr[1]);
            AppMethodBeat.o(147874);
            return bVar;
        }
        b bVar2 = new b("", "", "");
        AppMethodBeat.o(147874);
        return bVar2;
    }

    public final p.a m(int i2, String str, String str2) {
        AppMethodBeat.i(147875);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            p.a aVar = p.a.MISSING_PARAMS;
            AppMethodBeat.o(147875);
            return aVar;
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        if (str2 == null) {
            kotlin.g.b.p.hyc();
        }
        String c2 = t.c(i2, str, str2, "__");
        int h2 = h(i2, str, -VM(c2));
        this.kSj.remove(c2);
        if (h2 <= 0) {
            t.b(str, i2, this.kRJ, this.kRK);
        }
        p.a aVar2 = p.a.NONE;
        AppMethodBeat.o(147875);
        return aVar2;
    }

    public final void Y(int i2, String str) {
        AppMethodBeat.i(147876);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(147876);
            return;
        }
        String I = i2 == 0 ? kotlin.g.b.p.I(str, "__") : String.valueOf(i2) + "__" + str + "__";
        String[] allKeys = this.kSj.allKeys();
        if (allKeys == null) {
            allKeys = new String[0];
        }
        for (String str2 : allKeys) {
            kotlin.g.b.p.g(str2, "key");
            if (n.J(str2, I, false)) {
                this.kSj.remove(str2);
            }
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        g(i2, str, 0);
        t.b(str, i2, this.kRJ, this.kRK);
        AppMethodBeat.o(147876);
    }

    public final void VJ(String str) {
        AppMethodBeat.i(147877);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(147877);
            return;
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        for (int i2 : VK(str)) {
            g(i2, str, 0);
        }
        d(str, new c(this));
        t.b(str, this.kRJ, this.kRK);
        AppMethodBeat.o(147877);
    }

    public final Object[] Z(int i2, String str) {
        AppMethodBeat.i(147878);
        if (str == null) {
            Object[] objArr = {v.SXr, 0, 0};
            AppMethodBeat.o(147878);
            return objArr;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = i2 == 0 ? str + "__" : String.valueOf(i2) + "__" + str + "__";
        String[] allKeys = this.kSj.allKeys();
        if (allKeys == null) {
            allKeys = new String[0];
        }
        for (String str3 : allKeys) {
            kotlin.g.b.p.g(str3, "key");
            if (n.J(str3, str2, false)) {
                arrayList.add(n.j(str3, str2, "", false));
            }
        }
        Object[] objArr2 = {arrayList, Integer.valueOf(aa(i2, str)), Integer.valueOf(t.ab(i2, str))};
        AppMethodBeat.o(147878);
        return objArr2;
    }

    private final int aa(int i2, String str) {
        AppMethodBeat.i(147879);
        int i3 = Util.getInt(this.kSj.getString(t.c(i2, str, "@@@TOTAL@DATA@SIZE@@@", "++"), ""), 0);
        AppMethodBeat.o(147879);
        return i3;
    }

    private void d(String str, kotlin.g.a.b<? super String, x> bVar) {
        String[] strArr;
        AppMethodBeat.i(147880);
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(bVar, "block");
        k kVar = new k("^([1-9]\\d*__)?" + str + "__.+$");
        String[] allKeys = this.kSj.allKeys();
        if (allKeys == null) {
            strArr = new String[0];
        } else {
            strArr = allKeys;
        }
        for (String str2 : strArr) {
            kotlin.g.b.p.g(str2, "key");
            if (kVar.aJ(str2)) {
                bVar.invoke(str2);
            }
        }
        AppMethodBeat.o(147880);
    }

    public final int VU(String str) {
        AppMethodBeat.i(147881);
        kotlin.g.b.p.h(str, "appId");
        z.d dVar = new z.d();
        dVar.SYE = 0;
        d(str, new e(dVar));
        int i2 = dVar.SYE;
        AppMethodBeat.o(147881);
        return i2;
    }

    public final int VL(String str) {
        AppMethodBeat.i(147882);
        kotlin.g.b.p.h(str, "appId");
        int[] a2 = t.a(str, this.kRJ, this.kRK);
        int length = a2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            i2++;
            i3 = aa(a2[i2], str) + i3;
        }
        AppMethodBeat.o(147882);
        return i3;
    }

    private final boolean i(int i2, String str, int i3) {
        AppMethodBeat.i(147883);
        if (aa(i2, str) + i3 >= t.ab(i2, str)) {
            AppMethodBeat.o(147883);
            return true;
        }
        AppMethodBeat.o(147883);
        return false;
    }

    private int[] VK(String str) {
        AppMethodBeat.i(147884);
        kotlin.g.b.p.h(str, "appId");
        int[] a2 = t.a(str, this.kRJ, this.kRK);
        AppMethodBeat.o(147884);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "luggage-wechat-full-sdk_release"})
    public static final class b {
        final String data;
        final String kSm;
        final String type;

        public b(String str, String str2, String str3) {
            kotlin.g.b.p.h(str, "data");
            kotlin.g.b.p.h(str2, "type");
            kotlin.g.b.p.h(str3, "size");
            AppMethodBeat.i(147863);
            this.data = str;
            this.type = str2;
            this.kSm = str3;
            AppMethodBeat.o(147863);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", OpenSDKTool4Assistant.EXTRA_UIN, "onAccountRelease", "", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h AY(long j2) {
            AppMethodBeat.i(147862);
            synchronized (h.kSk) {
                try {
                    if (!h.kSk.keySet().contains(Long.valueOf(j2))) {
                        h.kSk.put(Long.valueOf(j2), new h(j2, (byte) 0));
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(147862);
                    throw th;
                }
            }
            Object obj = h.kSk.get(Long.valueOf(j2));
            if (obj == null) {
                kotlin.g.b.p.hyc();
            }
            h hVar = (h) obj;
            AppMethodBeat.o(147862);
            return hVar;
        }
    }

    static {
        AppMethodBeat.i(147886);
        AppMethodBeat.o(147886);
    }
}
