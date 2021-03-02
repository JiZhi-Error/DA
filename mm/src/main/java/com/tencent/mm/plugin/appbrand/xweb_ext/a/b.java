package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048DX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "", "()V", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"})
public abstract class b {
    private final f mJQ = g.ah(a.oGL);

    /* access modifiers changed from: protected */
    public final o cdJ() {
        return (o) this.mJQ.getValue();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<o> {
        public static final a oGL = new a();

        static {
            AppMethodBeat.i(229710);
            AppMethodBeat.o(229710);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ o invoke() {
            AppMethodBeat.i(229709);
            o oVar = new o(com.tencent.mm.loader.j.b.aKJ(), "wxacache");
            s.boN(oVar.getAbsolutePath());
            o oVar2 = new o(oVar, "sticker");
            s.boN(oVar2.getAbsolutePath());
            AppMethodBeat.o(229709);
            return oVar2;
        }
    }
}
