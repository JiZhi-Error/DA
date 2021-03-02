package kotlinx.a.b;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B#\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0010\u001a\u00028\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u00028\u00022\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00028\u0000*\u00028\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00028\u0001*\u00028\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u0001\u0002\u001b\u001c¨\u0006\u001d"}, hxF = {"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-runtime"})
public abstract class ac<K, V, R> implements h<R> {
    private final h<K> TYu;
    private final h<V> TYv;

    public abstract R aa(K k, V v);

    public abstract V getValue(R r);

    public abstract K go(R r);

    private ac(h<K> hVar, h<V> hVar2) {
        this.TYu = hVar;
        this.TYv = hVar2;
    }

    public /* synthetic */ ac(h hVar, h hVar2, byte b2) {
        this(hVar, hVar2);
    }

    @Override // kotlinx.a.f
    public final R a(c cVar, R r) {
        p.h(cVar, "decoder");
        return (R) h.a.a(this, cVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlinx.a.g */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.a.v
    public final void a(g gVar, R r) {
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        b b2 = gVar.b(fWv(), this.TYu, this.TYv);
        b2.a(fWv(), 0, this.TYu, go(r));
        b2.a(fWv(), 1, this.TYv, getValue(r));
        b2.a(fWv());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlinx.a.b.ac<K, V, R> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlinx.a.c */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.a.f
    public final R a(c cVar) {
        p.h(cVar, "decoder");
        a a2 = cVar.a(fWv(), this.TYu, this.TYv);
        Object obj = bh.NULL;
        Object obj2 = bh.NULL;
        while (true) {
            int b2 = a2.b(fWv());
            if (b2 == -1) {
                a2.a(fWv());
                if (obj == bh.NULL) {
                    throw new t("Element 'key' is missing", (byte) 0);
                } else if (obj2 != bh.NULL) {
                    return (R) aa(obj, obj2);
                } else {
                    throw new t("Element 'value' is missing", (byte) 0);
                }
            } else if (b2 == 0) {
                obj = a2.a(fWv(), 0, this.TYu);
            } else if (b2 == 1) {
                obj2 = a2.a(fWv(), 1, this.TYv);
            } else {
                throw new t("Invalid index: ".concat(String.valueOf(b2)), (byte) 0);
            }
        }
    }
}
