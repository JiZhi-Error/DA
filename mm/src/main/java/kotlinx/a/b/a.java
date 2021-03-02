package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\r\u0010\n\u001a\u00028\u0002H$¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00028\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u00028\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0002\u0010\u0012J-\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\n\u001a\u00028\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H$¢\u0006\u0002\u0010\u0019J/\u0010\u001a\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\n\u001a\u00028\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u001dH$¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\n\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010 J\u001d\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0001H&¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020\u0017*\u00028\u0002H$¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u0018\u001a\u00020\u0017H$¢\u0006\u0002\u0010)J\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+*\u00028\u0001H$¢\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020\u0017*\u00028\u0001H$¢\u0006\u0002\u0010'J\u0011\u0010.\u001a\u00028\u0002*\u00028\u0001H$¢\u0006\u0002\u0010/J\u0011\u00100\u001a\u00028\u0001*\u00028\u0002H$¢\u0006\u0002\u0010/R\u001c\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0001\u000212¨\u00063"}, hxF = {"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "()V", "typeParams", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "builder", "()Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "patch", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "readAll", "", "Lkotlinx/serialization/CompositeDecoder;", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", FirebaseAnalytics.b.INDEX, "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/lang/Object;Z)V", "readSize", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;)I", "serialize", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "builderSize", "(Ljava/lang/Object;)I", "checkCapacity", "(Ljava/lang/Object;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "collectionSize", "toBuilder", "(Ljava/lang/Object;)Ljava/lang/Object;", "toResult", "Lkotlinx/serialization/internal/ListLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-runtime"})
public abstract class a<Element, Collection, Builder> implements h<Collection> {
    /* access modifiers changed from: protected */
    public abstract void a(kotlinx.a.a aVar, int i2, Builder builder, boolean z);

    /* access modifiers changed from: protected */
    public abstract int gj(Collection collection);

    /* access modifiers changed from: protected */
    public abstract Iterator<Element> gk(Collection collection);

    /* access modifiers changed from: protected */
    public abstract int gl(Builder builder);

    /* access modifiers changed from: protected */
    public abstract Collection gm(Builder builder);

    /* access modifiers changed from: protected */
    public abstract Builder gn(Collection collection);

    /* access modifiers changed from: protected */
    public abstract Builder hOE();

    private a() {
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    @Override // kotlinx.a.f
    public final Collection a(c cVar, Collection collection) {
        p.h(cVar, "decoder");
        Builder gn = gn(collection);
        int gl = gl(gn);
        kotlinx.a.a a2 = cVar.a(fWv(), new h[0]);
        while (true) {
            int b2 = a2.b(fWv());
            if (b2 != -1) {
                a(a2, b2 + gl, gn, true);
            } else {
                a2.a(fWv());
                return gm(gn);
            }
        }
    }

    @Override // kotlinx.a.f
    public Collection a(c cVar) {
        p.h(cVar, "decoder");
        return a(cVar, gm(hOE()));
    }
}
