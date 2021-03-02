package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00042\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR'\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionStore;", "", "()V", "store", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyFunction;", "getStore", "()Landroid/util/SparseArray;", "removeReturns", "V", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
final class a {
    private static final SparseArray<b<MMActivity, x>> nbj = new SparseArray<>();
    public static final a nbk = new a();

    static {
        AppMethodBeat.i(228890);
        AppMethodBeat.o(228890);
    }

    private a() {
    }

    public static SparseArray<b<MMActivity, x>> bOJ() {
        return nbj;
    }

    public static <V> V c(SparseArray<V> sparseArray, int i2) {
        AppMethodBeat.i(228889);
        p.h(sparseArray, "$this$removeReturns");
        V v = sparseArray.get(i2);
        if (v != null) {
            sparseArray.remove(i2);
        }
        AppMethodBeat.o(228889);
        return v;
    }
}
