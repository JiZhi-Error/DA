package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.a;
import kotlinx.a.b;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004B\u0015\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0004¢\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0014¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010#J!\u0010$\u001a\u00020\u0012*\u00028\u00022\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010%\u001a\u00028\u0000H&¢\u0006\u0002\u0010&R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0001\u0005'()*+¨\u0006,"}, hxF = {"Lkotlinx/serialization/internal/ListLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "[Lkotlinx/serialization/KSerializer;", "readAll", "", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", FirebaseAnalytics.b.INDEX, "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/lang/Object;Z)V", "serialize", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "insert", "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "Lkotlinx/serialization/internal/ArrayListSerializer;", "Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "Lkotlinx/serialization/internal/HashSetSerializer;", "kotlinx-serialization-runtime"})
public abstract class ai<Element, Collection, Builder> extends a<Element, Collection, Builder> {
    final h<?>[] TYx;
    private final h<Element> TYy;

    public abstract void a(Builder builder, int i2, Element element);

    @Override // kotlinx.a.h, kotlinx.a.f
    public abstract n fWv();

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: kotlinx.a.h<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    private ai(h<Element> hVar) {
        super((byte) 0);
        this.TYy = hVar;
        this.TYx = new h[]{this.TYy};
    }

    public /* synthetic */ ai(h hVar, byte b2) {
        this(hVar);
    }

    @Override // kotlinx.a.v
    public void a(g gVar, Collection collection) {
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        int gj = gj(collection);
        n fWv = fWv();
        h<?>[] hVarArr = this.TYx;
        b c2 = gVar.c(fWv, (h[]) Arrays.copyOf(hVarArr, hVarArr.length));
        Iterator<Element> gk = gk(collection);
        for (int i2 = 0; i2 < gj; i2++) {
            c2.a(fWv(), i2, this.TYy, gk.next());
        }
        c2.a(fWv());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.a.b.ai<Element, Collection, Builder> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // kotlinx.a.b.a
    public void a(a aVar, int i2, Builder builder, boolean z) {
        p.h(aVar, "decoder");
        a(builder, i2, aVar.a(fWv(), i2, this.TYy));
    }
}
