package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ath;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eB\u000f\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J4\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMsgSessionIdResponse;", "scene", "", ch.COL_USERNAME, "", "(ILjava/lang/String;)V", "toLotteryId", "toObjectId", "", "(ILjava/lang/String;Ljava/lang/String;J)V", "objectId", "commentId", "(ILjava/lang/String;JJ)V", "fansId", "(Ljava/lang/String;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class ai extends an<ati> {
    public static final a tuq = new a((byte) 0);

    static {
        AppMethodBeat.i(242312);
        AppMethodBeat.o(242312);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, ati ati, q qVar) {
        Integer num = null;
        AppMethodBeat.i(242307);
        ati ati2 = ati;
        p.h(ati2, "resp");
        StringBuilder append = new StringBuilder("[onCgiBack] errType=").append(i2).append(" errCode=").append(i3).append(" errMsg=").append(str).append(" session_id=");
        azj azj = ati2.LEk;
        StringBuilder append2 = append.append(azj != null ? azj.sessionId : null).append(" enable_action=");
        azj azj2 = ati2.LEk;
        if (azj2 != null) {
            num = Integer.valueOf(azj2.LJf);
        }
        Log.i("Finder.CgiGetMsgSessionId", append2.append(num).toString());
        if (!(i2 == 0 && i3 == 0)) {
            h.INSTANCE.a(20492, 5L, new StringBuilder().append(i2).append(',').append(i3).toString());
            h.INSTANCE.n(1473, 5, 1);
        }
        AppMethodBeat.o(242307);
    }

    public ai(int i2, String str) {
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(242308);
        d.a aVar = new d.a();
        ath ath = new ath();
        am amVar = am.tuw;
        ath.LBM = am.cXY();
        ath.scene = i2;
        ath.pPz = str;
        aVar.c(ath);
        ati ati = new ati();
        ati.setBaseResponse(new BaseResponse());
        ati.getBaseResponse().ErrMsg = new dqi();
        aVar.d(ati);
        aVar.MB("/cgi-bin/micromsg-bin/findergetmsgsessionid");
        aVar.sG(3828);
        c(aVar.aXF());
        Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + i2 + " username=" + str);
        AppMethodBeat.o(242308);
    }

    public ai(int i2, String str, String str2, long j2) {
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "toLotteryId");
        AppMethodBeat.i(242309);
        d.a aVar = new d.a();
        ath ath = new ath();
        am amVar = am.tuw;
        ath.LBM = am.cXY();
        ath.scene = i2;
        ath.pPz = str;
        ath.LEf = str2;
        ath.LEd = j2;
        ath.LEg = 1;
        aVar.c(ath);
        ati ati = new ati();
        ati.setBaseResponse(new BaseResponse());
        ati.getBaseResponse().ErrMsg = new dqi();
        aVar.d(ati);
        aVar.MB("/cgi-bin/micromsg-bin/findergetmsgsessionid");
        aVar.sG(3828);
        c(aVar.aXF());
        Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + i2 + " username=" + str);
        AppMethodBeat.o(242309);
    }

    public ai(int i2, String str, long j2, long j3) {
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(242310);
        d.a aVar = new d.a();
        ath ath = new ath();
        am amVar = am.tuw;
        ath.LBM = am.cXY();
        ath.scene = i2;
        ath.LEd = j2;
        ath.LEe = j3;
        ath.pPz = str;
        aVar.c(ath);
        ati ati = new ati();
        ati.setBaseResponse(new BaseResponse());
        ati.getBaseResponse().ErrMsg = new dqi();
        aVar.d(ati);
        aVar.MB("/cgi-bin/micromsg-bin/findergetmsgsessionid");
        aVar.sG(3828);
        c(aVar.aXF());
        Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] scene=" + i2 + " username=" + str + " objectId=" + j2 + " commentId=" + j3);
        AppMethodBeat.o(242310);
    }

    public ai(String str) {
        p.h(str, "fansId");
        AppMethodBeat.i(242311);
        d.a aVar = new d.a();
        ath ath = new ath();
        am amVar = am.tuw;
        ath.LBM = am.cXY();
        ath.scene = 1;
        ath.LEc = str;
        aVar.c(ath);
        ati ati = new ati();
        ati.setBaseResponse(new BaseResponse());
        ati.getBaseResponse().ErrMsg = new dqi();
        aVar.d(ati);
        aVar.MB("/cgi-bin/micromsg-bin/findergetmsgsessionid");
        aVar.sG(3828);
        c(aVar.aXF());
        Log.i("Finder.CgiGetMsgSessionId", "[CgiGetMsgSessionId] fansId=".concat(String.valueOf(str)));
        AppMethodBeat.o(242311);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetMsgSessionId$Companion;", "", "()V", "MSG_SCENE_FINDER", "", "MSG_SCENE_STRANGER", "MSG_SOURCE_TYPE_FINDER", "MSG_SOURCE_TYPE_FINDER_LIVE_LOTTERY", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
