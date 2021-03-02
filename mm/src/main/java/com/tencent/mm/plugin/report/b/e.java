package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.utils.TbsLog;

public final class e extends q implements m {
    private aak CxP = null;
    private a CxQ = new a();
    private i callback;
    int channel = 0;
    private d rr;
    private boolean sPq = false;

    public e(byte[] bArr, int i2) {
        AppMethodBeat.i(143791);
        if (bArr == null) {
            NullPointerException nullPointerException = new NullPointerException("data must not be null");
            AppMethodBeat.o(143791);
            throw nullPointerException;
        }
        this.channel = i2;
        g.aAf();
        this.sPq = a.azo();
        if (i2 == 1) {
            try {
                com.tencent.mm.protocal.a.a.i iVar = new com.tencent.mm.protocal.a.a.i();
                iVar.parseFrom(bArr);
                this.CxP = SmcProtoBufUtil.toMMReportKvReq(iVar);
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.aAi();
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.report.b.e.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(143789);
                        SmcLogic.OnReportResp(3, -1, null, e.this.channel);
                        AppMethodBeat.o(143789);
                    }
                });
            }
        } else if (i2 == 2) {
            try {
                com.tencent.mm.protocal.a.a.g gVar = new com.tencent.mm.protocal.a.a.g();
                gVar.parseFrom(bArr);
                this.CxP = SmcProtoBufUtil.toMMReportIdkeyReq(gVar);
            } catch (Exception e3) {
                Log.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.aAi();
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.report.b.e.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(143790);
                        SmcLogic.OnReportResp(3, -1, null, e.this.channel);
                        AppMethodBeat.o(143790);
                    }
                });
            }
        }
        if (this.CxP != null) {
            this.CxP.LlD = new cbh();
            this.CxP.LlD.Mha = a.Wi(this.channel);
            AppMethodBeat.o(143791);
            return;
        }
        Log.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", Util.getStack());
        AppMethodBeat.o(143791);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(143792);
        if (g.aAg().hqi == null || g.aAg().hqi.iMw == null) {
            Log.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(143792);
        } else if (i3 != 0) {
            Log.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + i3 + ", errCode:" + i4);
            SmcLogic.OnReportResp(i3, i4, null, this.channel);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(143792);
        } else {
            Log.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.channel);
            aal aal = (aal) this.rr.iLL.iLR;
            this.CxQ.a(aal.LlN, this.channel);
            try {
                if (this.channel == 1) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(aal).toByteArray(), this.channel);
                } else if (this.channel == 2) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(aal).toByteArray(), this.channel);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), Util.stackTraceToString(e2));
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(143792);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        if (!this.sPq) {
            if (1 == this.channel) {
                return TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR;
            }
            return 987;
        } else if (1 == this.channel) {
            return TbsLog.TBSLOG_CODE_SDK_SELF_MODE;
        } else {
            return 986;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(143793);
        this.callback = iVar;
        if (this.CxP == null) {
            Log.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
            AppMethodBeat.o(143793);
            return -2;
        }
        if (!this.sPq) {
            this.CxP.LlC = b.cD(Util.getUuidRandom());
        }
        d.a aVar = new d.a();
        aVar.iLQ = false;
        aVar.iLN = this.CxP;
        aVar.iLO = new aal();
        String str = 1 == this.channel ? "/cgi-bin/micromsg-bin/newreportkvcomm" : "/cgi-bin/micromsg-bin/newreportidkey";
        String str2 = 1 == this.channel ? "/cgi-bin/micromsg-bin/newreportkvcommrsa" : "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        if (!this.sPq) {
            str = str2;
        }
        aVar.uri = str;
        aVar.funcId = getType();
        this.rr = aVar.aXF();
        if (!this.sPq) {
            this.rr.setRsaInfo(ac.gtS());
            this.rr.option = 1;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        if (dispatch < 0) {
            Log.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", Integer.valueOf(dispatch));
            try {
                SmcLogic.OnReportResp(3, -1, null, this.channel);
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(143793);
        return dispatch;
    }
}
