package com.tencent.mm.plugin.expansions;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.b;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J#\u0010\b\u001a\u00020\t2\u001b\b\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/expansions/expansions;", "", "()V", "isEnabled", "", "module", "", "isInstalled", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "setUpBlock", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "Lkotlin/ExtensionFunctionType;", "tryGetAssets", "Landroid/content/res/AssetManager;", "tryLoadLibrary", "libName", "expansions-visitor_release"})
public final class d {
    public static final d rNG = new d();

    static {
        AppMethodBeat.i(152987);
        AppMethodBeat.o(152987);
    }

    private d() {
    }

    public static void z(b<? super b, x> bVar) {
        AppMethodBeat.i(152983);
        b bVar2 = new b();
        if (bVar != null) {
            bVar.invoke(bVar2);
        }
        if (bVar2.rNC != null) {
            a.a(new b.a(bVar2));
            AppMethodBeat.o(152983);
            return;
        }
        a.a(new b.C1007b(bVar2));
        AppMethodBeat.o(152983);
    }

    public static boolean aob(String str) {
        AppMethodBeat.i(152984);
        p.h(str, "module");
        boolean cMq = a.cMq();
        AppMethodBeat.o(152984);
        return cMq;
    }

    public static boolean aoc(String str) {
        AppMethodBeat.i(152985);
        p.h(str, "module");
        boolean cMr = a.cMr();
        AppMethodBeat.o(152985);
        return cMr;
    }

    public static boolean aoa(String str) {
        AppMethodBeat.i(152986);
        p.h(str, "libName");
        boolean aoa = a.aoa(str);
        AppMethodBeat.o(152986);
        return aoa;
    }
}
