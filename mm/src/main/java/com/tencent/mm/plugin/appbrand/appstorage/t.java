package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0006H\u0007J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J>\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0007JF\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J>\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appstorage/KVStorageUtil;", "", "()V", "INTERNAL_KEY_SEPARATOR", "", "MAX_STORAGE_ID", "", "NORMAL_KEY_SEPARATOR", "RET_GET_NO_SUCH_KEY", "", "[Ljava/lang/Object;", "TOTAL_DATA_SIZE_KEY", "TOTAL_STORAGE_ID_KEY", "addStorageId", "", "appId", "storageId", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "calculateDataSize", "key", "data", "checkStorageIdInvalid", "", "generateInternalRecordKey", "generateRecordKey", "separator", "getAllStorageId", "", "getQuota", "removeStorageId", "removeStorageIdAll", "luggage-wechat-full-sdk_release"})
public final class t {
    public static final Object[] kSW = {p.a.NO_SUCH_KEY};
    public static final t kSX = new t();

    static {
        AppMethodBeat.i(147897);
        AppMethodBeat.o(147897);
    }

    private t() {
    }

    public static final boolean vU(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            return false;
        }
        return true;
    }

    public static final String c(int i2, String str, String str2, String str3) {
        AppMethodBeat.i(147888);
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(str2, "key");
        kotlin.g.b.p.h(str3, "separator");
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            sb.append(i2).append(str3);
        }
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        String sb2 = sb.toString();
        kotlin.g.b.p.g(sb2, "sb.toString()");
        AppMethodBeat.o(147888);
        return sb2;
    }

    public static final int cF(String str, String str2) {
        AppMethodBeat.i(147889);
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (str2 == null) {
            str2 = "";
        }
        int length2 = length + str2.length();
        AppMethodBeat.o(147889);
        return length2;
    }

    public static final String n(int i2, String str, String str2) {
        AppMethodBeat.i(147890);
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(str2, "key");
        String c2 = c(i2, str, str2, "++");
        AppMethodBeat.o(147890);
        return c2;
    }

    private static String cG(String str, String str2) {
        AppMethodBeat.i(147891);
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(str2, "key");
        String c2 = c(0, str, str2, "++");
        AppMethodBeat.o(147891);
        return c2;
    }

    public static final int[] a(String str, b<? super String, String> bVar, m<? super String, ? super String, x> mVar) {
        AppMethodBeat.i(147892);
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(bVar, "getter");
        kotlin.g.b.p.h(mVar, "setter");
        String cG = cG(str, "@@@TOTAL@STORAGE@ID@@@");
        if (Util.isNullOrNil(cG)) {
            int[] iArr = {0};
            AppMethodBeat.o(147892);
            return iArr;
        }
        String invoke = bVar.invoke(cG);
        if (Util.isNullOrNil(invoke)) {
            int[] iArr2 = {0};
            AppMethodBeat.o(147892);
            return iArr2;
        }
        JSONArray jSONArray = new JSONArray(invoke);
        if (jSONArray.length() <= 0) {
            int[] iArr3 = {0};
            AppMethodBeat.o(147892);
            return iArr3;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i2)));
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.contains(0)) {
            arrayList2.add(0);
        }
        int[] u = j.u((Collection<Integer>) arrayList2);
        AppMethodBeat.o(147892);
        return u;
    }

    public static final void a(String str, int i2, b<? super String, String> bVar, m<? super String, ? super String, x> mVar) {
        AppMethodBeat.i(147893);
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(bVar, "getter");
        kotlin.g.b.p.h(mVar, "setter");
        int[] a2 = a(str, bVar, mVar);
        if (e.contains(a2, i2)) {
            AppMethodBeat.o(147893);
            return;
        }
        JSONArray jSONArray = new JSONArray((Collection) e.W(a2));
        jSONArray.put(i2);
        String cG = cG(str, "@@@TOTAL@STORAGE@ID@@@");
        String jSONArray2 = jSONArray.toString();
        kotlin.g.b.p.g(jSONArray2, "json.toString()");
        mVar.invoke(cG, jSONArray2);
        AppMethodBeat.o(147893);
    }

    public static final void b(String str, int i2, b<? super String, String> bVar, m<? super String, ? super String, x> mVar) {
        AppMethodBeat.i(147894);
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(bVar, "getter");
        kotlin.g.b.p.h(mVar, "setter");
        List<Integer> Z = e.Z(a(str, bVar, mVar));
        Z.remove(Integer.valueOf(i2));
        String cG = cG(str, "@@@TOTAL@STORAGE@ID@@@");
        String jSONArray = new JSONArray((Collection) Z).toString();
        kotlin.g.b.p.g(jSONArray, "JSONArray(list).toString()");
        mVar.invoke(cG, jSONArray);
        AppMethodBeat.o(147894);
    }

    public static final void b(String str, b<? super String, String> bVar, m<? super String, ? super String, x> mVar) {
        AppMethodBeat.i(147895);
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(bVar, "getter");
        kotlin.g.b.p.h(mVar, "setter");
        mVar.invoke(cG(str, "@@@TOTAL@STORAGE@ID@@@"), "");
        AppMethodBeat.o(147895);
    }

    public static final int ab(int i2, String str) {
        AppMethodBeat.i(147896);
        kotlin.g.b.p.h(str, "appId");
        if (kotlin.g.b.p.j("wxGlobal", str)) {
            int i3 = AppBrandGlobalSystemConfig.bzP().lcP;
            AppMethodBeat.o(147896);
            return i3;
        } else if (i2 == 0 || i2 == 2) {
            int Xg = n.Xg(str);
            AppMethodBeat.o(147896);
            return Xg;
        } else {
            int Xh = n.Xh(str);
            AppMethodBeat.o(147896);
            return Xh;
        }
    }
}
