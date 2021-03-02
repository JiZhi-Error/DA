package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00052 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006B#\b\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\u000bJ-\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0004¢\u0006\u0002\u0010\u001eJ-\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00028\u00032\u0006\u0010!\u001a\u00020\"H\u0004¢\u0006\u0002\u0010#J\u001d\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010(J)\u0010)\u001a\u00020\u0017*\u00028\u00032\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010*\u001a\u00028\u00002\u0006\u0010'\u001a\u00028\u0001H&¢\u0006\u0002\u0010+R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0006X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\t0\u0011¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000\u0001\u0002,-¨\u0006."}, hxF = {"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", "", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "[Lkotlinx/serialization/KSerializer;", "readAll", "", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/util/Map;II)V", "readElement", FirebaseAnalytics.b.INDEX, "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "insertKeyValuePair", "key", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "Lkotlinx/serialization/internal/HashMapSerializer;", "kotlinx-serialization-runtime"})
public abstract class ao<Key, Value, Collection, Builder extends Map<Key, Value>> extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {
    public final h<Key> TYu;
    public final h<Value> TYv;
    private final h<? extends Object>[] TYx;

    @Override // kotlinx.a.h, kotlinx.a.f
    public abstract n fWv();

    private ao(h<Key> hVar, h<Value> hVar2) {
        super((byte) 0);
        this.TYu = hVar;
        this.TYv = hVar2;
        this.TYx = new h[]{this.TYu, this.TYv};
    }

    public /* synthetic */ ao(h hVar, h hVar2, byte b2) {
        this(hVar, hVar2);
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ void a(a aVar, int i2, Object obj, boolean z) {
        Object a2;
        Map map = (Map) obj;
        p.h(aVar, "decoder");
        p.h(map, "builder");
        Object a3 = aVar.a(fWv(), i2, this.TYu);
        int b2 = aVar.b(fWv());
        if (!(b2 == i2 + 1)) {
            throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i2 + ", returned index for value: " + b2).toString());
        }
        if (!map.containsKey(a3) || (this.TYv.fWv().hOA() instanceof kotlinx.a.l)) {
            a2 = aVar.a(fWv(), b2, this.TYv);
        } else {
            a2 = aVar.a(fWv(), b2, this.TYv, ae.e(map, a3));
        }
        map.put(a3, a2);
    }

    @Override // kotlinx.a.v
    public final void a(g gVar, Collection collection) {
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        gj(collection);
        n fWv = fWv();
        h<? extends Object>[] hVarArr = this.TYx;
        b c2 = gVar.c(fWv, (h[]) Arrays.copyOf(hVarArr, hVarArr.length));
        Iterator<Element> gk = gk(collection);
        int i2 = 0;
        while (gk.hasNext()) {
            Element next = gk.next();
            Object key = next.getKey();
            Object value = next.getValue();
            int i3 = i2 + 1;
            c2.a(fWv(), i2, this.TYu, key);
            i2 = i3 + 1;
            c2.a(fWv(), i3, this.TYv, value);
        }
        c2.a(fWv());
    }
}
