package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.coc;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003¨\u0006\u0006"}, hxF = {"toFinder", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoExtendedReading;", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLocation;", "toMega", "plugin-finder_release"})
public final class aj {
    public static final coc a(axt axt) {
        AppMethodBeat.i(253798);
        p.h(axt, "$this$toMega");
        coc coc = new coc();
        coc.dTj = axt.dTj;
        coc.latitude = axt.latitude;
        coc.fuK = axt.fuK;
        coc.kHV = axt.kHV;
        coc.ErZ = axt.ErZ;
        coc.LIb = axt.LIb;
        coc.Esb = axt.Esb;
        coc.fuJ = axt.fuJ;
        coc.jlI = axt.jlI;
        coc.country = axt.country;
        AppMethodBeat.o(253798);
        return coc;
    }
}
