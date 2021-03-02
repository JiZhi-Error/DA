package com.tencent.mm.ac;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0006H\u0002¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0006H\u0002¢\u0006\u0002\u0010\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/kt/AndroidPairKTX;", "", "()V", "component1", "K", "V", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "libktcomm_release"})
public final class a {
    public static final a hvd = new a();

    static {
        AppMethodBeat.i(153442);
        AppMethodBeat.o(153442);
    }

    private a() {
    }

    public static <K, V> K a(Pair<K, V> pair) {
        AppMethodBeat.i(153440);
        p.h(pair, "$this$component1");
        K k = (K) pair.first;
        AppMethodBeat.o(153440);
        return k;
    }

    public static <K, V> V b(Pair<K, V> pair) {
        AppMethodBeat.i(153441);
        p.h(pair, "$this$component2");
        V v = (V) pair.second;
        AppMethodBeat.o(153441);
        return v;
    }
}
