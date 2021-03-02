package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

public final class d {
    private static boolean a(b bVar, b bVar2) {
        AppMethodBeat.i(59318);
        p.h(bVar, "$this$isSubpackageOf");
        p.h(bVar2, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        if (p.j(bVar, bVar2)) {
            AppMethodBeat.o(59318);
            return true;
        } else if (bVar2.isRoot()) {
            AppMethodBeat.o(59318);
            return true;
        } else {
            String sG = bVar.sG();
            p.g(sG, "this.asString()");
            String sG2 = bVar2.sG();
            p.g(sG2, "packageName.asString()");
            if (!n.J(sG, sG2, false) || sG.charAt(sG2.length()) != '.') {
                AppMethodBeat.o(59318);
                return false;
            }
            AppMethodBeat.o(59318);
            return true;
        }
    }

    public static final b b(b bVar, b bVar2) {
        AppMethodBeat.i(59319);
        p.h(bVar, "$this$tail");
        p.h(bVar2, "prefix");
        if (!a(bVar, bVar2) || bVar2.isRoot()) {
            AppMethodBeat.o(59319);
            return bVar;
        } else if (p.j(bVar, bVar2)) {
            b bVar3 = b.TCQ;
            p.g(bVar3, "FqName.ROOT");
            AppMethodBeat.o(59319);
            return bVar3;
        } else {
            String sG = bVar.sG();
            p.g(sG, "asString()");
            int length = bVar2.sG().length() + 1;
            if (sG == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(59319);
                throw tVar;
            }
            String substring = sG.substring(length);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            b bVar4 = new b(substring);
            AppMethodBeat.o(59319);
            return bVar4;
        }
    }
}
