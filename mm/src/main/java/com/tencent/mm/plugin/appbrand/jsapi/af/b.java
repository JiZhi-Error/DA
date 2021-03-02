package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebViewStore;", "", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "add", "", "webview", "get", "binderID", "", "remove", "plugin-appbrand-integration_release"})
public final class b {
    private static final SparseArray<a> mHa = new SparseArray<>();
    public static final b mHb = new b();

    static {
        AppMethodBeat.i(175192);
        AppMethodBeat.o(175192);
    }

    private b() {
    }

    public static void j(a aVar) {
        AppMethodBeat.i(175189);
        p.h(aVar, "webview");
        synchronized (mHa) {
            try {
                mHa.put(aVar.getBinderID(), aVar);
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(175189);
            }
        }
    }

    public static void k(a aVar) {
        AppMethodBeat.i(175190);
        p.h(aVar, "webview");
        synchronized (mHa) {
            try {
                mHa.remove(aVar.getBinderID());
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(175190);
            }
        }
    }

    public static a xL(int i2) {
        a aVar;
        AppMethodBeat.i(175191);
        synchronized (mHa) {
            try {
                aVar = mHa.get(i2);
            } finally {
                AppMethodBeat.o(175191);
            }
        }
        return aVar;
    }
}
