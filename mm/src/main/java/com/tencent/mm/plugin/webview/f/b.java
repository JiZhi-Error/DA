package com.tencent.mm.plugin.webview.f;

import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/webview/permission/GetA8KeyReasonManager;", "", "()V", "TAG", "", "forceGetA8keyPaths", "", "getForceGetA8keyPaths", "()Ljava/util/List;", "forceGetA8keyPaths$delegate", "Lkotlin/Lazy;", "hasForceGetA8keyList", "Ljava/util/LinkedList;", "shouldForceGetA8key", "", "url", "webview-sdk_release"})
public final class b {
    private static final LinkedList<String> JbF = new LinkedList<>();
    private static final f JbG = g.ah(a.JbI);
    public static final b JbH = new b();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(225127);
        AppMethodBeat.o(225127);
    }

    private b() {
    }

    public static final boolean aZA(String str) {
        AppMethodBeat.i(225126);
        p.h(str, "url");
        if (JbF.contains(str)) {
            AppMethodBeat.o(225126);
            return true;
        }
        for (String str2 : (List) JbG.getValue()) {
            Log.i(TAG, "force geta8key path = %s", str2);
            if (c.a(str, str2, false)) {
                JbF.add(str);
                AppMethodBeat.o(225126);
                return true;
            }
        }
        AppMethodBeat.o(225126);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<List<? extends String>> {
        public static final a JbI = new a();

        static {
            AppMethodBeat.i(225125);
            AppMethodBeat.o(225125);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends String> invoke() {
            AppMethodBeat.i(225124);
            String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_geta8key_force_sync_host, "");
            p.g(a2, "MMKernel.service(IExptSe…8key_force_sync_host, \"\")");
            List<String> a3 = n.a(a2, new String[]{";"});
            AppMethodBeat.o(225124);
            return a3;
        }
    }
}
