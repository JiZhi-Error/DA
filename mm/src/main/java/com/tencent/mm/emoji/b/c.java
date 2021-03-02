package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.protocal.protobuf.bmw;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/emoji/model/CgiGetEmojiWordList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "()V", "plugin-emojisdk_release"})
public final class c extends com.tencent.mm.ak.c<bmw> {
    public c() {
        AppMethodBeat.i(199910);
        bmv bmv = new bmv();
        bmw bmw = new bmw();
        d.a aVar = new d.a();
        aVar.c(bmv);
        aVar.d(bmw);
        aVar.MB("/cgi-bin/micromsg-bin/getemotionwordlist");
        aVar.sG(3628);
        aVar.sI(0);
        aVar.sJ(0);
        c(aVar.aXF());
        AppMethodBeat.o(199910);
    }
}
