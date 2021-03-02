package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b;
import kotlinx.a.b.av;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u0015\b\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\r\u0010\r\u001a\u00028\u0002H\u0004¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u0013\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00028\u00022\u0006\u0010\u001a\u001a\u00020\u001bH$¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u0001¢\u0006\u0002\u0010!J%\u0010\"\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010$\u001a\u00028\u00012\u0006\u0010%\u001a\u00020\u0019H$¢\u0006\u0002\u0010&J\u0011\u0010'\u001a\u00020\u0019*\u00028\u0002H\u0004¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020\u0016*\u00028\u00022\u0006\u0010%\u001a\u00020\u0019H\u0004¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000,*\u00028\u0001H\u0004¢\u0006\u0002\u0010-J\u001f\u0010.\u001a\u00020\u0016*\u00028\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010/\u001a\u00028\u0000¢\u0006\u0002\u00100J\u0011\u00101\u001a\u00028\u0001*\u00028\u0002H\u0004¢\u0006\u0002\u00102R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00063"}, hxF = {"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Builder", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlinx/serialization/internal/ListLikeSerializer;", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "empty", "()Ljava/lang/Object;", "readElement", "", "Lkotlinx/serialization/CompositeDecoder;", FirebaseAnalytics.b.INDEX, "", "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILkotlinx/serialization/internal/PrimitiveArrayBuilder;Z)V", "serialize", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "writeContent", "Lkotlinx/serialization/CompositeEncoder;", "content", "size", "(Lkotlinx/serialization/CompositeEncoder;Ljava/lang/Object;I)V", "builderSize", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "checkCapacity", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "insert", "element", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract class ax<Element, Array, Builder extends av<Array>> extends ai<Element, Array, Builder> {
    final n TXo;

    /* access modifiers changed from: protected */
    public abstract void a(b bVar, Array array, int i2);

    /* access modifiers changed from: protected */
    public abstract Array hOF();

    @Override // kotlinx.a.b.ai
    public final /* synthetic */ void a(Object obj, int i2, Object obj2) {
        p.h((av) obj, "$this$insert");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gl(Object obj) {
        av avVar = (av) obj;
        p.h(avVar, "$this$builderSize");
        return avVar.getPosition();
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gm(Object obj) {
        av avVar = (av) obj;
        p.h(avVar, "$this$toResult");
        return avVar.build();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ax(h<Element> hVar) {
        super(hVar, (byte) 0);
        p.h(hVar, "primitiveSerializer");
        this.TXo = new aw(hVar.fWv());
    }

    @Override // kotlinx.a.h, kotlinx.a.b.ai, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.a.b.a
    public final Iterator<Element> gk(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override // kotlinx.a.b.ai, kotlinx.a.v
    public final void a(g gVar, Array array) {
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        int gj = gj(array);
        n nVar = this.TXo;
        h<?>[] hVarArr = this.TYx;
        b c2 = gVar.c(nVar, (h[]) Arrays.copyOf(hVarArr, hVarArr.length));
        a(c2, array, gj);
        c2.a(this.TXo);
    }

    @Override // kotlinx.a.b.a, kotlinx.a.f
    public final Array a(c cVar) {
        p.h(cVar, "decoder");
        return (Array) a(cVar, hOF());
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object hOE() {
        throw new IllegalStateException("Use empty().toBuilder() instead".toString());
    }
}
