package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.k;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"})
public final class cf extends i implements bp {
    @Override // kotlinx.coroutines.bp
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.bp
    public final cf hMX() {
        return this;
    }

    public final String getString(String str) {
        AppMethodBeat.i(118248);
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        boolean z = true;
        cf cfVar = this;
        Object hNI = cfVar.hNI();
        if (hNI == null) {
            t tVar = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            AppMethodBeat.o(118248);
            throw tVar;
        }
        k kVar = (k) hNI;
        while (!p.j(kVar, cfVar)) {
            if (kVar instanceof bz) {
                bz bzVar = (bz) kVar;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(bzVar);
            }
            kVar = kVar.hNJ();
            z = z;
        }
        sb.append("]");
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(118248);
        return sb2;
    }

    @Override // kotlinx.coroutines.internal.k
    public final String toString() {
        AppMethodBeat.i(118249);
        if (an.getDEBUG()) {
            String string = getString("Active");
            AppMethodBeat.o(118249);
            return string;
        }
        String iVar = super.toString();
        AppMethodBeat.o(118249);
        return iVar;
    }
}
