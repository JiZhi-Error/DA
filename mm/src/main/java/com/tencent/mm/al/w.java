package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;

public final class w extends q implements m {
    private i callback;
    private d rr;

    public w(String str, String str2) {
        this(str, str2, (byte) 0);
    }

    private w(String str, String str2, byte b2) {
        this(str, 1, str2, null, 0, null, null);
    }

    public w(String str, int i2, String str2, LinkedList<aam> linkedList, int i3, dvm dvm, dws dws) {
        AppMethodBeat.i(124120);
        d.a aVar = new d.a();
        aVar.iLN = new aan();
        aVar.iLO = new aao();
        aVar.uri = "/cgi-bin/micromsg-bin/clickcommand";
        aVar.funcId = 359;
        aVar.iLP = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
        aVar.respCmdId = 1000000176;
        this.rr = aVar.aXF();
        aan aan = (aan) this.rr.iLK.iLR;
        aan.LlO = i2;
        aan.LlP = str2;
        aan.KSV = str;
        aan.KHq = br.ajw();
        aan.scene = i3;
        aan.KRg = ab.getSessionId();
        if (linkedList != null) {
            aan.LlQ = linkedList;
        }
        if (dvm != null) {
            aan.LlR = dvm;
            Log.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", Integer.valueOf(dvm.MWy), Integer.valueOf(dvm.MWA), Integer.valueOf(dvm.MWz), Integer.valueOf(dvm.MWC), Integer.valueOf(dvm.MWB), Integer.valueOf(dvm.MWD), Integer.valueOf(dvm.MWE));
        }
        if (dws != null) {
            aan.LlS = dws;
            Log.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", Integer.valueOf(dws.Scene), Integer.valueOf(dws.MWN));
        }
        Log.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", str, Integer.valueOf(i2), str2, aan.KHq, Integer.valueOf(aan.LlQ.size()), Integer.valueOf(i3));
        AppMethodBeat.o(124120);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124121);
        if (i3 == 0 && i4 == 0) {
            aan aan = (aan) this.rr.iLK.iLR;
            aao aao = (aao) this.rr.iLL.iLR;
            if (!(aan.LlO != 10 || aan.KSV == null || aao.LlT == null || ((l) g.af(l.class)).aST().bjY(aan.KSV) == null)) {
                fby fby = aao.LlT;
                String str2 = aan.KSV;
                if (fby == null || Util.isNullOrNil(fby.Nyb) || Util.isNullOrNil(fby.Nya)) {
                    Log.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
                } else if (fby.NxZ != 1) {
                    Log.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", Integer.valueOf(fby.NxZ));
                } else {
                    String str3 = fby.Nya;
                    String str4 = fby.Nyb;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("<sysmsg type=\"biz_services_mute\">");
                    stringBuffer.append("<biz_services_mute>");
                    stringBuffer.append("<text><![CDATA[").append(str3).append("]]></text>");
                    stringBuffer.append("<link>");
                    stringBuffer.append("<scene>biz_services_mute</scene>");
                    stringBuffer.append("<text><![CDATA[").append(str4).append("]]></text>");
                    stringBuffer.append("</link>");
                    stringBuffer.append("</biz_services_mute>");
                    stringBuffer.append("</sysmsg>");
                    ca caVar = new ca();
                    caVar.Cy(str2);
                    caVar.nv(2);
                    caVar.setType(10002);
                    caVar.setCreateTime(bp.aVP());
                    caVar.setContent(stringBuffer.toString());
                    bp.x(caVar);
                }
            }
            if (aao.LlT != null) {
                Log.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", Integer.valueOf(aan.LlO));
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(124121);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 359;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(124122);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124122);
        return dispatch;
    }
}
