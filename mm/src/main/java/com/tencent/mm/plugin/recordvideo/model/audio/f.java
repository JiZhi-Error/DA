package com.tencent.mm.plugin.recordvideo.model.audio;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.dqi;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "searchRequestId", "", SearchIntents.EXTRA_QUERY, "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-recordvideo_release"})
public final class f extends c<clk> {
    private f(long j2, String str, int i2, long j3) {
        p.h(str, SearchIntents.EXTRA_QUERY);
        AppMethodBeat.i(75423);
        clj clj = new clj();
        clk clk = new clk();
        clk.setBaseResponse(new BaseResponse());
        clk.getBaseResponse().ErrMsg = new dqi();
        clj.MqH = j2;
        clj.query = str;
        clj.offset = i2;
        clj.Ler = 10;
        clj.MqI = j3;
        d.a aVar = new d.a();
        aVar.c(clj);
        aVar.d(clk);
        aVar.MB("/cgi-bin/spr-bin/mmsprbgmsearch");
        aVar.sG(3554);
        c(aVar.aXF());
        AppMethodBeat.o(75423);
    }

    public /* synthetic */ f(long j2, String str, int i2, long j3, byte b2) {
        this(j2, str, i2, j3);
    }
}
