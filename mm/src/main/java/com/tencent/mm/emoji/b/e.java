package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.tavkit.component.TAVExporter;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/model/CgiGetPersonalDesigner;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetPersonalDesignerResponse;", "designerUin", "", "reqBuff", "", "(I[B)V", "getDesignerUin", "()I", "getReqBuff", "()[B", "plugin-emojisdk_release"})
public final class e extends c<bsp> {
    private final int gWW;
    private final byte[] gWX;

    public e(int i2, byte[] bArr) {
        AppMethodBeat.i(183955);
        this.gWW = i2;
        this.gWX = bArr;
        bso bso = new bso();
        bsp bsp = new bsp();
        bso.DesignerUin = this.gWW;
        if (this.gWX == null) {
            bso.ReqBuf = new SKBuiltinBuffer_t();
        } else {
            bso.ReqBuf = z.aC(this.gWX);
        }
        bso.Scene = 0;
        d.a aVar = new d.a();
        aVar.c(bso);
        aVar.d(bsp);
        aVar.MB("/cgi-bin/micromsg-bin/mmgetpersonaldesigner");
        aVar.sG(TAVExporter.VIDEO_EXPORT_WIDTH);
        c(aVar.aXF());
        AppMethodBeat.o(183955);
    }
}
