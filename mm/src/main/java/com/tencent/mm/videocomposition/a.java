package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.n;
import java.util.ArrayList;
import java.util.Set;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, hxF = {"VideoEnhancementScenes", "", "", "getVideoEnhancementScenes", "()Ljava/util/Set;", "video_composition_release"})
public final class a {
    private static final Set<Integer> RgO;

    static {
        AppMethodBeat.i(216716);
        n.a[] values = n.a.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (n.a aVar : values) {
            arrayList.add(Integer.valueOf(aVar.ordinal()));
        }
        RgO = j.r((Iterable) arrayList);
        AppMethodBeat.o(216716);
    }

    public static final Set<Integer> hfg() {
        return RgO;
    }
}
