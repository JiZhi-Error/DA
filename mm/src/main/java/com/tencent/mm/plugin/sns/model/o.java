package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public final class o extends q implements m {
    private static Vector<String> DIh = new Vector<>();
    private boolean DIe;
    private long DIf = 0;
    private long DIg = 0;
    public int DIi = 0;
    public int DIj = 0;
    public i callback;
    private String desc = "";
    private ArrayList<SnsInfo> dtS = new ArrayList<>();
    private boolean idt = false;
    private d rr;
    final int sourceType;

    static {
        AppMethodBeat.i(95585);
        AppMethodBeat.o(95585);
    }

    public static synchronized boolean aPa(String str) {
        boolean z;
        synchronized (o.class) {
            AppMethodBeat.i(95579);
            if (DIh.contains(str)) {
                z = false;
                AppMethodBeat.o(95579);
            } else {
                DIh.add(str);
                z = true;
                AppMethodBeat.o(95579);
            }
        }
        return z;
    }

    public static synchronized boolean aPb(String str) {
        synchronized (o.class) {
            AppMethodBeat.i(95580);
            DIh.remove(str);
            AppMethodBeat.o(95580);
        }
        return true;
    }

    public o(String str) {
        AppMethodBeat.i(95581);
        d.a aVar = new d.a();
        aVar.iLN = new dzm();
        aVar.iLO = new dzn();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
        aVar.funcId = 601;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.DIf = 0;
        this.DIe = 0 == 0;
        this.sourceType = 2;
        dzm dzm = (dzm) this.rr.iLK.iLR;
        dzm.MZg = "";
        dzm.MZh = 0;
        dzm.MZi = str;
        dzm.MZj = 1;
        Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", r.Jb(0), str, 0);
        AppMethodBeat.o(95581);
    }

    private SnsInfo c(SnsObject snsObject) {
        AppMethodBeat.i(95582);
        SnsInfo snsInfo = new SnsInfo();
        String str = new String(snsObject.ObjectDesc.getBuffer().toByteArray());
        Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", Long.valueOf(snsObject.Id));
        if (!snsInfo.setContent(str)) {
            AppMethodBeat.o(95582);
            return null;
        }
        snsObject.ObjectDesc.setBuffer(new byte[0]);
        snsInfo.setUserName(snsObject.Username);
        snsInfo.setCreateTime(snsObject.CreateTime);
        snsInfo.setLikeFlag(snsObject.LikeFlag);
        snsInfo.setSnsId(snsObject.Id);
        snsInfo.setStringSeq(snsObject.Id);
        snsInfo.addSourceFlag(this.sourceType);
        try {
            snsInfo.setAttrBuf(snsObject.toByteArray());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", e2, "", new Object[0]);
        }
        TimeLineObject timeLine = snsInfo.getTimeLine();
        timeLine.UserName = snsObject.Username;
        snsInfo.setPravited(timeLine.Privated);
        Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + snsObject.ExtFlag);
        snsInfo.setExtFlag();
        snsInfo.setTimeLine(timeLine);
        snsInfo.setTypeFlag(timeLine.ContentObj.LoU);
        snsInfo.setSubTypeFlag(timeLine.ContentObj.LoW);
        AppMethodBeat.o(95582);
        return snsInfo;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95583);
        Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        dzn dzn = (dzn) ((d) sVar).iLL.iLR;
        if (sVar.getRespObj().getRetCode() == 207 || sVar.getRespObj().getRetCode() == 0 || sVar.getRespObj().getRetCode() == 212) {
            this.idt = sVar.getRespObj().getRetCode() == 212;
            this.DIi = dzn.MZk;
            this.desc = dzn.KHk;
            r.Jc(this.DIf);
            Log.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", Integer.valueOf(dzn.MvM), this.desc);
            Iterator<SnsObject> it = dzn.KOH.iterator();
            while (it.hasNext()) {
                SnsInfo c2 = c(it.next());
                if (c2 != null) {
                    this.dtS.add(c2);
                }
            }
            aPb("@__classify_timeline");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95583);
            return;
        }
        aPb("@__classify_timeline");
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95583);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 601;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95584);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95584);
        return dispatch;
    }
}
