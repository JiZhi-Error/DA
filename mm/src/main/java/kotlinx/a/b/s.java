package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.a;
import kotlinx.a.a.e;
import kotlinx.a.b;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0014J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\rH\u0014J\f\u0010\u0016\u001a\u00020\r*\u00020\u0002H\u0014J\f\u0010\u0017\u001a\u00020\u0005*\u00020\u0002H\u0014¨\u0006\u0018"}, hxF = {"Lkotlinx/serialization/internal/FloatArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/FloatArrayBuilder;", "()V", "empty", "readElement", "", "decoder", "Lkotlinx/serialization/CompositeDecoder;", FirebaseAnalytics.b.INDEX, "", "builder", "checkIndex", "", "writeContent", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/CompositeEncoder;", "content", "size", "collectionSize", "toBuilder", "kotlinx-serialization-runtime"})
public final class s extends ax<Float, float[], r> implements h<float[]> {
    public static final s TYq = new s();

    static {
        AppMethodBeat.i(225450);
        AppMethodBeat.o(225450);
    }

    private s() {
        super(e.a(kotlin.g.b.l.SYx));
        AppMethodBeat.i(225449);
        AppMethodBeat.o(225449);
    }

    @Override // kotlinx.a.b.a, kotlinx.a.b.ai
    public final /* synthetic */ void a(a aVar, int i2, Object obj, boolean z) {
        AppMethodBeat.i(225447);
        r rVar = (r) obj;
        p.h(aVar, "decoder");
        p.h(rVar, "builder");
        float g2 = aVar.g(this.TXo, i2);
        rVar.ensureCapacity(rVar.getPosition() + 1);
        float[] fArr = rVar.TYp;
        int i3 = rVar.position;
        rVar.position = i3 + 1;
        fArr[i3] = g2;
        AppMethodBeat.o(225447);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.a.b, java.lang.Object, int] */
    @Override // kotlinx.a.b.ax
    public final /* synthetic */ void a(b bVar, float[] fArr, int i2) {
        AppMethodBeat.i(225448);
        float[] fArr2 = fArr;
        p.h(bVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(fArr2, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            bVar.a(this.TXo, i3, fArr2[i3]);
        }
        AppMethodBeat.o(225448);
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gj(Object obj) {
        AppMethodBeat.i(225445);
        float[] fArr = (float[]) obj;
        p.h(fArr, "$this$collectionSize");
        int length = fArr.length;
        AppMethodBeat.o(225445);
        return length;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gn(Object obj) {
        AppMethodBeat.i(225446);
        float[] fArr = (float[]) obj;
        p.h(fArr, "$this$toBuilder");
        r rVar = new r(fArr);
        AppMethodBeat.o(225446);
        return rVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlinx.a.b.ax
    public final /* bridge */ /* synthetic */ float[] hOF() {
        return new float[0];
    }
}
