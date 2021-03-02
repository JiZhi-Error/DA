package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.g;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0003H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0005H\u0000¨\u0006\n"}, hxF = {"verify", "", "decoder", "Lkotlinx/serialization/Decoder;", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "asJsonInput", "Lkotlinx/serialization/json/JsonInput;", "asJsonOutput", "Lkotlinx/serialization/json/JsonOutput;", "kotlinx-serialization-runtime"})
public final class h {
    static final void a(g gVar) {
        g gVar2;
        AppMethodBeat.i(225812);
        p.h(gVar, "$this$asJsonOutput");
        if (!(gVar instanceof u)) {
            gVar2 = null;
        } else {
            gVar2 = gVar;
        }
        if (((u) gVar2) == null) {
            IllegalStateException illegalStateException = new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonOutput, got " + aa.bp(gVar.getClass()));
            AppMethodBeat.o(225812);
            throw illegalStateException;
        }
        AppMethodBeat.o(225812);
    }

    public static final m b(c cVar) {
        c cVar2;
        AppMethodBeat.i(225813);
        p.h(cVar, "$this$asJsonInput");
        if (!(cVar instanceof m)) {
            cVar2 = null;
        } else {
            cVar2 = cVar;
        }
        m mVar = (m) cVar2;
        if (mVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonInput, got " + aa.bp(cVar.getClass()));
            AppMethodBeat.o(225813);
            throw illegalStateException;
        }
        AppMethodBeat.o(225813);
        return mVar;
    }
}
