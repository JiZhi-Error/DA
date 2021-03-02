package kotlinx.a.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.o;
import kotlinx.a.w;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003:\u0001\u0014B!\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\bJ)\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, hxF = {"Lkotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "key", "getKey", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "MapEntry", "kotlinx-serialization-runtime"})
public final class am<K, V> extends ac<K, V, Map.Entry<? extends K, ? extends V>> {
    private final n TXo;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "K", "V", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<o, x> {
        final /* synthetic */ h TYC;
        final /* synthetic */ h TYD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar, h hVar2) {
            super(1);
            this.TYC = hVar;
            this.TYD = hVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(o oVar) {
            AppMethodBeat.i(225459);
            o oVar2 = oVar;
            p.h(oVar2, "$receiver");
            o.a(oVar2, "key", this.TYC.fWv());
            o.a(oVar2, "value", this.TYD.fWv());
            x xVar = x.SXb;
            AppMethodBeat.o(225459);
            return xVar;
        }
    }

    @Override // kotlinx.a.b.ac
    public final /* synthetic */ Object getValue(Object obj) {
        AppMethodBeat.i(225393);
        Map.Entry entry = (Map.Entry) obj;
        p.h(entry, "$this$value");
        Object value = entry.getValue();
        AppMethodBeat.o(225393);
        return value;
    }

    @Override // kotlinx.a.b.ac
    public final /* synthetic */ Object go(Object obj) {
        AppMethodBeat.i(225392);
        Map.Entry entry = (Map.Entry) obj;
        p.h(entry, "$this$key");
        Object key = entry.getKey();
        AppMethodBeat.o(225392);
        return key;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00022\b\b\u0002\u0010\u0005\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0004\u001a\u00028\u0002X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0003X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, hxF = {"Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "", "kotlinx-serialization-runtime"})
    static final class a<K, V> implements Map.Entry<K, V>, kotlin.g.b.a.a {
        private final K key;
        private final V value;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
            if (kotlin.g.b.p.j(getValue(), r4.getValue()) != false) goto L_0x002a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 225578(0x3712a, float:3.16102E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002a
                boolean r0 = r4 instanceof kotlinx.a.b.am.a
                if (r0 == 0) goto L_0x002f
                kotlinx.a.b.am$a r4 = (kotlinx.a.b.am.a) r4
                java.lang.Object r0 = r3.getKey()
                java.lang.Object r1 = r4.getKey()
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002f
                java.lang.Object r0 = r3.getValue()
                java.lang.Object r1 = r4.getValue()
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002f
            L_0x002a:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002e:
                return r0
            L_0x002f:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002e
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.a.b.am.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(225577);
            K key2 = getKey();
            int hashCode = (key2 != null ? key2.hashCode() : 0) * 31;
            V value2 = getValue();
            if (value2 != null) {
                i2 = value2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(225577);
            return i3;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            AppMethodBeat.i(225579);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(225579);
            throw unsupportedOperationException;
        }

        public final String toString() {
            AppMethodBeat.i(225576);
            String str = "MapEntry(key=" + ((Object) getKey()) + ", value=" + ((Object) getValue()) + ")";
            AppMethodBeat.o(225576);
            return str;
        }

        public a(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public am(h<K> hVar, h<V> hVar2) {
        super(hVar, hVar2, (byte) 0);
        p.h(hVar, "keySerializer");
        p.h(hVar2, "valueSerializer");
        AppMethodBeat.i(225395);
        this.TXo = kotlinx.a.p.a("kotlin.collections.Map.Entry", w.c.TXU, new b(hVar, hVar2));
        AppMethodBeat.o(225395);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    @Override // kotlinx.a.b.ac
    public final /* synthetic */ Object aa(Object obj, Object obj2) {
        AppMethodBeat.i(225394);
        a aVar = new a(obj, obj2);
        AppMethodBeat.o(225394);
        return aVar;
    }
}
