package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, hxF = {"elementDescriptors", "", "Lkotlinx/serialization/SerialDescriptor;", "elementNames", "", "getElementIndexOrThrow", "", "name", "kotlinx-serialization-runtime"})
public final class r {
    public static final List<n> d(n nVar) {
        AppMethodBeat.i(225847);
        p.h(nVar, "$this$elementDescriptors");
        int hOC = nVar.hOC();
        ArrayList arrayList = new ArrayList(hOC);
        for (int i2 = 0; i2 < hOC; i2++) {
            arrayList.add(nVar.awd(i2));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(225847);
        return arrayList2;
    }
}
