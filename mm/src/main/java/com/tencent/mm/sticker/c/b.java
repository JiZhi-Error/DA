package com.tencent.mm.sticker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.dqi;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/sticker/task/CgiGetLensList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "type", "", "pageBuff", "", "lensCtx", "(I[B[B)V", "plugin-sticker_release"})
public final class b extends c<bpi> {
    public b(int i2, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(105982);
        bph bph = new bph();
        bph.ReqType = i2;
        bph.LXB = new com.tencent.mm.bw.b(bArr == null ? new byte[0] : bArr);
        bph.LXC = new com.tencent.mm.bw.b(bArr2 == null ? new byte[0] : bArr2);
        bpi bpi = new bpi();
        bpi.setBaseResponse(new BaseResponse());
        bpi.getBaseResponse().ErrMsg = new dqi();
        d.a aVar = new d.a();
        aVar.c(bph);
        aVar.d(bpi);
        aVar.MB("/cgi-bin/micromsg-bin/getlenslist");
        aVar.sG(3847);
        c(aVar.aXF());
        AppMethodBeat.o(105982);
    }
}
