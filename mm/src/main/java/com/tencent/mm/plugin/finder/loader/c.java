package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.plugin.finder.utils.y;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "Companion", "plugin-finder_release"})
public final class c extends com.tencent.mm.loader.e.a.c {
    public static final a uIi = new a((byte) 0);

    static {
        AppMethodBeat.i(166301);
        AppMethodBeat.o(166301);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.loader.d.d, com.tencent.mm.loader.e.a.c
    public final e<Bitmap> a(g<?> gVar, f<?, Bitmap> fVar, com.tencent.mm.loader.h.b.a aVar) {
        AppMethodBeat.i(166300);
        p.h(gVar, "targetView");
        p.h(fVar, "reaper");
        p.h(aVar, "input");
        Bitmap bitmap = null;
        com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c("FinderBitmapProducer");
        InputStream aKu = aVar.aKu();
        if (aKu != null) {
            int i2 = fVar.hXX.hZz;
            int i3 = fVar.hXX.hZA;
            y yVar = y.vXH;
            bitmap = y.c(aKu, i2, i3);
            x xVar = x.SXb;
        }
        cVar.aBw();
        e<Bitmap> eVar = new e<>(bitmap);
        AppMethodBeat.o(166300);
        return eVar;
    }
}
