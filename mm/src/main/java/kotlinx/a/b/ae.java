package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\t\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022B\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u00060\u0003B!\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0002\u0010\nJ$\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J(\u0010\u0010\u001a\u00020\u0011*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J0\u0010\u0012\u001a\u00020\u0013*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u0014\u001a\u00020\u0011H\u0014J*\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00170\u0016*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J\u0018\u0010\u0018\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014JE\u0010\u0019\u001a\u00020\u0013*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ4\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J4\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, hxF = {"Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "kSerializer", "Lkotlinx/serialization/KSerializer;", "vSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "", "collectionSize", "insertKeyValuePair", FirebaseAnalytics.b.INDEX, "key", "value", "(Ljava/util/LinkedHashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class ae<K, V> extends ao<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>> {
    private final n TXo;

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gj(Object obj) {
        AppMethodBeat.i(225438);
        Map map = (Map) obj;
        p.h(map, "$this$collectionSize");
        int size = map.size();
        AppMethodBeat.o(225438);
        return size;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Iterator gk(Object obj) {
        AppMethodBeat.i(225439);
        Map map = (Map) obj;
        p.h(map, "$this$collectionIterator");
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        AppMethodBeat.o(225439);
        return it;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gl(Object obj) {
        AppMethodBeat.i(225441);
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        p.h(linkedHashMap, "$this$builderSize");
        int size = linkedHashMap.size();
        AppMethodBeat.o(225441);
        return size;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gm(Object obj) {
        AppMethodBeat.i(225442);
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        p.h(linkedHashMap, "$this$toResult");
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        AppMethodBeat.o(225442);
        return linkedHashMap2;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gn(Object obj) {
        AppMethodBeat.i(225443);
        Map map = (Map) obj;
        p.h(map, "$this$toBuilder");
        LinkedHashMap linkedHashMap = (LinkedHashMap) (!(map instanceof LinkedHashMap) ? null : map);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap(map);
        }
        AppMethodBeat.o(225443);
        return linkedHashMap;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ae(h<K> hVar, h<V> hVar2) {
        super(hVar, hVar2, (byte) 0);
        p.h(hVar, "kSerializer");
        p.h(hVar2, "vSerializer");
        AppMethodBeat.i(225444);
        this.TXo = new ad(hVar.fWv(), hVar2.fWv());
        AppMethodBeat.o(225444);
    }

    @Override // kotlinx.a.h, kotlinx.a.b.ao, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object hOE() {
        AppMethodBeat.i(225440);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AppMethodBeat.o(225440);
        return linkedHashMap;
    }
}
