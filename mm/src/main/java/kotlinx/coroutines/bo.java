package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, hxF = {"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"})
public final class bo implements bp {
    final cf TUL;

    public bo(cf cfVar) {
        AppMethodBeat.i(118136);
        this.TUL = cfVar;
        AppMethodBeat.o(118136);
    }

    @Override // kotlinx.coroutines.bp
    public final cf hMX() {
        return this.TUL;
    }

    @Override // kotlinx.coroutines.bp
    public final boolean isActive() {
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(118135);
        if (an.getDEBUG()) {
            String string = this.TUL.getString("New");
            AppMethodBeat.o(118135);
            return string;
        }
        String obj = super.toString();
        AppMethodBeat.o(118135);
        return obj;
    }
}
