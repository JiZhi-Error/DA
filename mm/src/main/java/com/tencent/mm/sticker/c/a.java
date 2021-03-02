package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.dqi;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/sticker/task/CgiGetLensInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensInfoResponse;", "lensId", "", "(Ljava/lang/String;)V", "getLensId", "()Ljava/lang/String;", "plugin-sticker_release"})
public final class a extends c<bpg> {
    private final String rnS;

    public a(String str) {
        p.h(str, "lensId");
        AppMethodBeat.i(105981);
        this.rnS = str;
        bpf bpf = new bpf();
        bpg bpg = new bpg();
        bpf.Lso = this.rnS;
        bpg.setBaseResponse(new BaseResponse());
        bpg.BaseResponse.ErrMsg = new dqi();
        d.a aVar = new d.a();
        aVar.c(bpf);
        aVar.d(bpg);
        aVar.MB("/cgi-bin/micromsg-bin/getlensinfo");
        aVar.sG(3903);
        c(aVar.aXF());
        AppMethodBeat.o(105981);
    }
}
