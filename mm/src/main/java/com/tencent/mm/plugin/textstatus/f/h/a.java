package com.tencent.mm.plugin.textstatus.f.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/upload/PostTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;)V", "lastPostTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "statusPost", "Companion", "plugin-textstatus_release"})
public final class a implements i {
    public static final C1822a FZS = new C1822a((byte) 0);
    private final v FYQ;
    private long FZR;

    static {
        AppMethodBeat.i(216303);
        AppMethodBeat.o(216303);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/upload/PostTask$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.f.h.a$a  reason: collision with other inner class name */
    public static final class C1822a {
        private C1822a() {
        }

        public /* synthetic */ C1822a(byte b2) {
            this();
        }
    }

    public a(v vVar) {
        p.h(vVar, "postInfo");
        AppMethodBeat.i(216302);
        this.FYQ = vVar;
        AppMethodBeat.o(216302);
    }

    public final void fwb() {
        AppMethodBeat.i(216300);
        d.h(new b(this));
        AppMethodBeat.o(216300);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(216301);
        Log.i("MicroMsg.TxtStatus.PostTask", "[doPost] end cost:" + (System.currentTimeMillis() - this.FZR) + ",errType" + i2 + ",errCode" + i3);
        g.azz().b(5293, this);
        if (!(i2 == 0 && i3 == 0)) {
            c cVar = c.FZX;
            v vVar = this.FYQ;
            p.h(vVar, "postInfo");
            Log.i("MicroMsg.TxtStatus.UploadManager", "makeCgiFail " + vVar.Gba + ' ' + str + ' ' + vVar.GaY + "  " + vVar.GaZ);
            if (Util.isNullOrNil(str)) {
                vVar.GaZ++;
                c.a(vVar);
                com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.c(vVar.VdX, 2L);
                c.dYH();
                AppMethodBeat.o(216301);
                return;
            }
            vVar.errMsg = str;
            c.a(vVar);
            f fVar = f.FXJ;
            f.c(Long.valueOf(vVar.Gba), 6);
            com.tencent.mm.plugin.textstatus.k.a aVar2 = com.tencent.mm.plugin.textstatus.k.a.VeA;
            com.tencent.mm.plugin.textstatus.k.a.c(vVar.VdX, 5L);
        }
        AppMethodBeat.o(216301);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ a FZT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.FZT = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(216299);
            this.FZT.FZR = System.currentTimeMillis();
            com.tencent.mm.plugin.textstatus.f.b bVar = new com.tencent.mm.plugin.textstatus.f.b(this.FZT.FYQ);
            g.azz().a(bVar.getType(), this.FZT);
            g.azz().b(bVar);
            x xVar = x.SXb;
            AppMethodBeat.o(216299);
            return xVar;
        }
    }
}
