package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.a;
import kotlinx.a.a.e;
import kotlinx.a.b;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0014J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\rH\u0014J\f\u0010\u0016\u001a\u00020\r*\u00020\u0002H\u0014J\f\u0010\u0017\u001a\u00020\u0005*\u00020\u0002H\u0014¨\u0006\u0018"}, hxF = {"Lkotlinx/serialization/internal/CharArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/CharArrayBuilder;", "()V", "empty", "readElement", "", "decoder", "Lkotlinx/serialization/CompositeDecoder;", FirebaseAnalytics.b.INDEX, "", "builder", "checkIndex", "", "writeContent", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/CompositeEncoder;", "content", "size", "collectionSize", "toBuilder", "kotlinx-serialization-runtime"})
public final class m extends ax<Character, char[], l> implements h<char[]> {
    public static final m TYk = new m();

    static {
        AppMethodBeat.i(225504);
        AppMethodBeat.o(225504);
    }

    private m() {
        super(e.a(f.SYo));
        AppMethodBeat.i(225503);
        AppMethodBeat.o(225503);
    }

    @Override // kotlinx.a.b.a, kotlinx.a.b.ai
    public final /* synthetic */ void a(a aVar, int i2, Object obj, boolean z) {
        AppMethodBeat.i(225501);
        l lVar = (l) obj;
        p.h(aVar, "decoder");
        p.h(lVar, "builder");
        char c2 = aVar.c(this.TXo, i2);
        lVar.ensureCapacity(lVar.getPosition() + 1);
        char[] cArr = lVar.aZS;
        int i3 = lVar.position;
        lVar.position = i3 + 1;
        cArr[i3] = c2;
        AppMethodBeat.o(225501);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlinx.a.b, java.lang.Object, int] */
    @Override // kotlinx.a.b.ax
    public final /* synthetic */ void a(b bVar, char[] cArr, int i2) {
        AppMethodBeat.i(225502);
        char[] cArr2 = cArr;
        p.h(bVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(cArr2, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            bVar.a(this.TXo, i3, cArr2[i3]);
        }
        AppMethodBeat.o(225502);
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gj(Object obj) {
        AppMethodBeat.i(225499);
        char[] cArr = (char[]) obj;
        p.h(cArr, "$this$collectionSize");
        int length = cArr.length;
        AppMethodBeat.o(225499);
        return length;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gn(Object obj) {
        AppMethodBeat.i(225500);
        char[] cArr = (char[]) obj;
        p.h(cArr, "$this$toBuilder");
        l lVar = new l(cArr);
        AppMethodBeat.o(225500);
        return lVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlinx.a.b.ax
    public final /* bridge */ /* synthetic */ char[] hOF() {
        return new char[0];
    }
}
