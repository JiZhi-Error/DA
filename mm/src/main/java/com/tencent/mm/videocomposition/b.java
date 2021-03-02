package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/videocomposition/CompositionLabelRetrieverFactoryProxy;", "Lcom/tencent/mm/videocomposition/ICompositionLabelRetrieverFactory;", "()V", "factory", "getLabelRetriever", "Lcom/tencent/mm/videocomposition/ICompositionLabelRetriever;", "setImpl", "", "factoryImpl", "video_composition_release"})
public final class b implements f {
    private static f RgP;
    public static final b RgQ = new b();

    static {
        AppMethodBeat.i(216718);
        AppMethodBeat.o(216718);
    }

    private b() {
    }

    public static void a(f fVar) {
        RgP = fVar;
    }

    @Override // com.tencent.mm.videocomposition.f
    public final e fEd() {
        AppMethodBeat.i(216717);
        f fVar = RgP;
        if (fVar != null) {
            e fEd = fVar.fEd();
            AppMethodBeat.o(216717);
            return fEd;
        }
        AppMethodBeat.o(216717);
        return null;
    }
}
