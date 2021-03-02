package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.g;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

public final class m extends k<avp> {
    private static final int ukU;
    private static final int ukV = 1;
    public static final b ukW = new b((byte) 0);
    private final String TAG = "CgiFinderLiveCreateLottery";
    private avo ukS = new avo();
    private a ukT;

    public interface a {
        void a(int i2, int i3, String str, avp avp);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(long j2, long j3, String str, int i2, String str2, int i3, String str3, int i4, int i5, a aVar) {
        super((byte) 0);
        Integer num;
        String str4;
        p.h(str, "nonceId");
        p.h(str2, "desc");
        p.h(str3, "attendWording");
        p.h(aVar, "callback");
        AppMethodBeat.i(246321);
        this.ukT = aVar;
        this.ukS.liveId = j2;
        this.ukS.hFK = j3;
        this.ukS.LGk = d.Ga(str);
        this.ukS.LGl = i2 * 60;
        this.ukS.LGm = str2;
        avo avo = this.ukS;
        awg awg = new awg();
        awg.LGY = i3;
        awg.LGZ = str3;
        avo.LGn = awg;
        this.ukS.LGo = i5;
        this.ukS.opType = i4;
        avo avo2 = this.ukS;
        am amVar = am.tuw;
        avo2.LAI = am.cXY();
        this.ukS.hwg = str;
        d.a aVar2 = new d.a();
        aVar2.c(this.ukS);
        avp avp = new avp();
        avp.setBaseResponse(new BaseResponse());
        avp.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(avp);
        aVar2.MB("/cgi-bin/micromsg-bin/finderlivecreatelottery");
        aVar2.sG(6645);
        c(aVar2.aXF());
        String str5 = this.TAG;
        StringBuilder append = new StringBuilder("FinderLiveLottery,init liveId:").append(this.ukS.liveId).append(",objectId:").append(this.ukS.hFK).append(",nonceId:").append(this.ukS.hwg).append(",lotteryDuration:").append(this.ukS.LGl).append(",lotteryDescription:").append(this.ukS.LGm).append(",lotteryAttendType:");
        awg awg2 = this.ukS.LGn;
        if (awg2 != null) {
            num = Integer.valueOf(awg2.LGY);
        } else {
            num = null;
        }
        StringBuilder append2 = append.append(num).append(",attendWording:");
        awg awg3 = this.ukS.LGn;
        if (awg3 != null) {
            str4 = awg3.LGZ;
        } else {
            str4 = null;
        }
        Log.i(str5, append2.append(str4).append(",lotteryWinnerCnt:").append(this.ukS.LGo).append(",opType:").append(this.ukS.opType).toString());
        AppMethodBeat.o(246321);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246320);
        avp avp = (avp) dpc;
        p.h(avp, "resp");
        Log.i(this.TAG, "FinderLiveLottery [onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread() + ",result:" + g.bN(avp));
        this.ukT.a(i2, i3, str, avp);
        AppMethodBeat.o(246320);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246322);
        AppMethodBeat.o(246322);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
        return com.tencent.mm.plugin.finder.cgi.report.b.Enable;
    }
}
