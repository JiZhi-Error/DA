package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.dtu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class i extends q implements m {
    private static final List<Object> jcO = new ArrayList();
    private com.tencent.mm.ak.i callback;
    private int jcN = 15;
    private final List<ca> jcP = new LinkedList();
    private int jcQ = 3;
    private boolean jcR = false;
    private final List<ca> jcS = new ArrayList();
    private ca jcT = null;
    public o jcU = null;
    public long msgId;
    private d rr;

    static /* synthetic */ g a(i iVar) {
        AppMethodBeat.i(43039);
        g dispatcher = iVar.dispatcher();
        AppMethodBeat.o(43039);
        return dispatcher;
    }

    static /* synthetic */ void a(i iVar, String str) {
        AppMethodBeat.i(43040);
        iVar.Pk(str);
        AppMethodBeat.o(43040);
    }

    static {
        AppMethodBeat.i(43043);
        AppMethodBeat.o(43043);
    }

    public i(String str, String str2, int i2, int i3, Object obj) {
        AppMethodBeat.i(43024);
        if (Log.getLogLevel() <= 1) {
            Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", Util.getStack());
        }
        if (!Util.isNullOrNil(str)) {
            ca caVar = new ca();
            caVar.setStatus(1);
            caVar.Cy(str);
            caVar.setCreateTime(bp.Kw(str));
            caVar.nv(1);
            caVar.setContent(str2);
            caVar.setType(i2);
            String a2 = a(((w) com.tencent.mm.kernel.g.af(w.class)).Z(caVar), obj, i3);
            if (!Util.isNullOrNil(a2)) {
                caVar.BB(a2);
                Log.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", caVar.fqK);
            }
            if (!((i3 & 4) == 0 && (i3 & 8) == 0)) {
                int i4 = (i3 & 4) != 0 ? 2 : 3;
                Log.i("MicroMsg.NetSceneSendMsg", "has paste fully flag, %d", Integer.valueOf(i4));
                HashMap hashMap = new HashMap();
                hashMap.put(".msgsource.alnode.cf", String.valueOf(i4));
                br.b(caVar, br.B(hashMap));
            }
            try {
                this.msgId = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().c(caVar, true);
            } catch (SQLiteException e2) {
                e.INSTANCE.idkeyStat(111, 255, 1, false);
                if (e2.toString().contains("UNIQUE constraint failed")) {
                    Log.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().eiI();
                    this.msgId = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().c(caVar, true);
                } else {
                    AppMethodBeat.o(43024);
                    throw e2;
                }
            } catch (IllegalStateException e3) {
                Log.printErrStackTrace("MicroMsg.NetSceneSendMsg", e3, "", new Object[0]);
            }
            if (this.msgId == -1) {
                e.INSTANCE.idkeyStat(111, 255, 1, false);
            } else if (((j) com.tencent.mm.kernel.g.af(j.class)).aBf(str)) {
                ((j) com.tencent.mm.kernel.g.af(j.class)).a(str, z.aTY(), str2, this.msgId);
            }
            Assert.assertTrue(this.msgId != -1);
            Log.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        }
        AppMethodBeat.o(43024);
    }

    public i(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(43025);
        if (Log.getLogLevel() <= 1) {
            Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", Util.getStack());
        }
        if (!Util.isNullOrNil(str)) {
            ca caVar = new ca();
            caVar.setStatus(1);
            caVar.Cy(str);
            caVar.setCreateTime(bp.Kw(str));
            caVar.nv(1);
            caVar.setContent(str2);
            caVar.setType(i2);
            if (i3 == 1 && i2 == 42) {
                caVar.gDE();
            }
            String Z = ((w) com.tencent.mm.kernel.g.af(w.class)).Z(caVar);
            if (!Util.isNullOrNil(Z)) {
                caVar.BB(Z);
                Log.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", caVar.fqK);
            }
            try {
                this.msgId = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().c(caVar, true);
            } catch (SQLiteException e2) {
                e.INSTANCE.idkeyStat(111, 255, 1, false);
                if (e2.toString().contains("UNIQUE constraint failed")) {
                    Log.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
                    ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().eiI();
                    this.msgId = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().c(caVar, true);
                } else {
                    AppMethodBeat.o(43025);
                    throw e2;
                }
            } catch (IllegalStateException e3) {
                Log.printErrStackTrace("MicroMsg.NetSceneSendMsg", e3, "", new Object[0]);
            }
            if (this.msgId != -1 && ((j) com.tencent.mm.kernel.g.af(j.class)).aBf(str)) {
                ((j) com.tencent.mm.kernel.g.af(j.class)).a(str, z.aTY(), str2, this.msgId);
            }
            Assert.assertTrue(this.msgId != -1);
            Log.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        }
        AppMethodBeat.o(43025);
    }

    public i(long j2) {
        AppMethodBeat.i(43026);
        Log.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(j2)));
        this.msgId = j2;
        this.jcT = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2);
        if (this.jcT == null) {
            Log.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", Long.valueOf(j2));
        }
        AppMethodBeat.o(43026);
    }

    public i() {
        AppMethodBeat.i(43027);
        Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", Util.getStack());
        Log.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
        AppMethodBeat.o(43027);
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean securityLimitCountReach() {
        AppMethodBeat.i(43028);
        boolean securityLimitCountReach = super.securityLimitCountReach();
        if (securityLimitCountReach) {
            e.INSTANCE.idkeyStat(111, 254, 1, false);
        }
        AppMethodBeat.o(43028);
        return securityLimitCountReach;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(43029);
        if (this.jcP.size() > 0) {
            q.b bVar = q.b.EOk;
            AppMethodBeat.o(43029);
            return bVar;
        }
        q.b bVar2 = q.b.EFailed;
        AppMethodBeat.o(43029);
        return bVar2;
    }

    private static String a(String str, Object obj, int i2) {
        AppMethodBeat.i(163517);
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(i2);
        Log.i("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", objArr);
        if (!Util.isNullOrNil(str) && !str.startsWith("<msgsource>")) {
            Log.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", str);
            AppMethodBeat.o(163517);
            return str;
        } else if ((i2 & 1) == 0 || !(obj instanceof HashMap)) {
            AppMethodBeat.o(163517);
            return str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            if (Util.isNullOrNil(str)) {
                stringBuffer.append("<msgsource>");
            }
            for (Map.Entry entry : ((HashMap) obj).entrySet()) {
                String str2 = (String) entry.getValue();
                String str3 = (String) entry.getKey();
                if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
                    Log.w("MicroMsg.NetSceneSendMsg", "%s %s", str3, str2);
                } else {
                    stringBuffer.append("<").append(str3).append(">");
                    stringBuffer.append(str2);
                    stringBuffer.append("</").append(str3).append(">");
                }
            }
            if (Util.isNullOrNil(str)) {
                stringBuffer.append("</msgsource>");
                String stringBuffer2 = stringBuffer.toString();
                AppMethodBeat.o(163517);
                return stringBuffer2;
            }
            String replace = str.replace("<msgsource>", "<msgsource>" + stringBuffer.toString());
            AppMethodBeat.o(163517);
            return replace;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        ArrayList arrayList;
        AppMethodBeat.i(43031);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new dtt();
        aVar.iLO = new dtu();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.funcId = 522;
        aVar.iLP = TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS;
        aVar.respCmdId = 1000000237;
        this.rr = aVar.aXF();
        dtt dtt = (dtt) this.rr.iLK.iLR;
        if (this.jcT == null) {
            arrayList = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Qp(this.jcN);
        } else {
            if (this.jcT.field_status != 5) {
                Log.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", Long.valueOf(this.jcT.field_msgId), Integer.valueOf(this.jcT.field_status));
            }
            this.jcT.setStatus(1);
            ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.msgId, this.jcT);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.jcT);
            this.jcT = null;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.size() == 0) {
            Log.w("MicroMsg.NetSceneSendMsg", "no sending message");
            AppMethodBeat.o(43031);
            return -2;
        }
        this.jcP.clear();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ca caVar = (ca) arrayList.get(i2);
            if (caVar.field_isSend == 1) {
                cot cot = new cot();
                cot.KHm = new dqi().bhy(caVar.field_talker);
                cot.CreateTime = (int) (caVar.field_createTime / 1000);
                cot.oUv = caVar.getType();
                cot.iAc = caVar.field_content;
                cot.MuU = x.x(z.aTY(), caVar.field_createTime).hashCode();
                if (((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(caVar.field_talker)) {
                    cot.LbN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(caVar.field_talker);
                }
                if (this.jcU == null) {
                    this.jcU = ((w) com.tencent.mm.kernel.g.af(w.class)).bdO();
                }
                Log.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", this.jcU);
                this.jcU.a(cot, caVar);
                Log.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", cot.KHq);
                dtt.oTA.add(cot);
                dtt.oTz = dtt.oTA.size();
                this.jcP.add(caVar);
            }
        }
        int dispatch = dispatch(gVar, this.rr, this);
        if (dispatch < 0) {
            Log.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", Integer.valueOf(dispatch));
            bdK();
        }
        AppMethodBeat.o(43031);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 522;
    }

    private void bdJ() {
        AppMethodBeat.i(225960);
        for (int i2 = 0; i2 < this.jcP.size(); i2++) {
            tB(i2);
        }
        AppMethodBeat.o(225960);
    }

    private void tB(int i2) {
        AppMethodBeat.i(43032);
        if (this.jcP == null) {
            Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
            AppMethodBeat.o(43032);
        } else if (i2 >= this.jcP.size() || i2 < 0) {
            Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", Integer.valueOf(i2), Integer.valueOf(this.jcP.size()));
            AppMethodBeat.o(43032);
        } else {
            X(this.jcP.get(i2));
            AppMethodBeat.o(43032);
        }
    }

    private static void X(ca caVar) {
        AppMethodBeat.i(43033);
        tx txVar = new tx();
        txVar.ear.dCM = caVar;
        EventCenter.instance.publish(txVar);
        Log.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", Long.valueOf(caVar.field_msgId));
        AppMethodBeat.o(43033);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, final String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(43034);
        if (i3 == 0 && i4 == 0) {
            dtu dtu = (dtu) this.rr.iLL.iLR;
            LinkedList<cou> linkedList = dtu.oTA;
            ((com.tencent.mm.plugin.messenger.foundation.a.s) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(dtu.LbO);
            ArrayList arrayList = new ArrayList();
            if (this.jcP.size() == linkedList.size()) {
                int i5 = 0;
                while (i5 < linkedList.size()) {
                    cou cou = linkedList.get(i5);
                    if (cou.Ret != 0 || ac.jPl) {
                        e.INSTANCE.idkeyStat(111, 252, 1, false);
                        if (cou.Ret == -49 || ac.jPl) {
                            Log.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", Integer.valueOf(cou.Ret), Integer.valueOf(i5), Boolean.valueOf(ac.jPl), Integer.valueOf(this.jcQ));
                            if (this.jcR) {
                                this.jcS.add(this.jcP.get(i5));
                            } else if (this.jcQ < 0) {
                                tC(i5);
                                this.callback.onSceneEnd(4, cou.Ret, str, this);
                                tB(i5);
                                AppMethodBeat.o(43034);
                                return;
                            } else {
                                this.jcR = true;
                                this.jcQ--;
                                this.jcS.add(this.jcP.get(i5));
                                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                                    /* class com.tencent.mm.modelmulti.i.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(43023);
                                        new ad(5, "", "", "", "", false, 1, false).doScene(i.a(i.this), new com.tencent.mm.ak.i() {
                                            /* class com.tencent.mm.modelmulti.i.AnonymousClass1.AnonymousClass1 */

                                            @Override // com.tencent.mm.ak.i
                                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                                AppMethodBeat.i(43022);
                                                qVar.setHasCallbackToQueue(true);
                                                Log.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i.this.jcS.size()), str, Boolean.valueOf(i.this.jcR), Integer.valueOf(i.this.jcQ));
                                                if (i2 == 0 && i3 == 0) {
                                                    i.this.jcS.clear();
                                                    i.a(i.this, str);
                                                } else {
                                                    i.ax(i.this.jcS);
                                                    i.this.callback.onSceneEnd(4, -49, str, i.this);
                                                    i.ay(i.this.jcS);
                                                    i.this.jcS.clear();
                                                }
                                                i.this.jcR = false;
                                                ac.jPl = false;
                                                AppMethodBeat.o(43022);
                                            }
                                        });
                                        AppMethodBeat.o(43023);
                                    }
                                });
                            }
                        } else {
                            tC(i5);
                            this.callback.onSceneEnd(4, cou.Ret, str, this);
                            tB(i5);
                            AppMethodBeat.o(43034);
                            return;
                        }
                    } else {
                        long j2 = this.jcP.get(i5).field_msgId;
                        Log.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j2 + ", SvrId = " + cou.Brn + " sent successfully!");
                        ca Hb = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j2);
                        Hb.yF(cou.Brn);
                        Log.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(cou.Brn), Integer.valueOf(ac.jOD));
                        if (10007 == ac.jOC && ac.jOD != 0) {
                            Hb.yF((long) ac.jOD);
                            ac.jOD = 0;
                        }
                        Hb.setStatus(2);
                        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(j2, Hb);
                        if (this.jcP == null) {
                            Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
                        } else if (i5 >= this.jcP.size() || i5 < 0) {
                            Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", Integer.valueOf(i5), Integer.valueOf(this.jcP.size()));
                        } else {
                            long j3 = this.jcP.get(i5).field_msgId;
                            Log.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", Long.valueOf(j3));
                            ca Hb2 = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(j3);
                            tz tzVar = new tz();
                            tzVar.eat.dCM = Hb2;
                            EventCenter.instance.publish(tzVar);
                        }
                        arrayList.add(Integer.valueOf(i5));
                        if (1 == cou.oUv) {
                            e.INSTANCE.a(11942, true, false, Long.valueOf(cou.Brn));
                            e.INSTANCE.a(11945, false, true, Long.valueOf(cou.Brn));
                            e.INSTANCE.a(11946, false, false, Long.valueOf(cou.Brn));
                            e.INSTANCE.idkeyStat(90, 0, 1, false);
                            e.INSTANCE.idkeyStat(90, 1, 1, true);
                        }
                    }
                    i5++;
                }
                Log.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", Integer.valueOf(i5 - this.jcS.size()), Integer.valueOf(this.jcS.size()));
            }
            Log.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", Boolean.valueOf(this.jcR));
            if (this.jcR) {
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(43034);
                return;
            }
            Pk(str);
            AppMethodBeat.o(43034);
            return;
        }
        Log.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        e.INSTANCE.idkeyStat(111, (long) (i3 + 40), 1, true);
        e.INSTANCE.idkeyStat(111, 253, 1, false);
        if (i4 == 413) {
            int computeSize = this.rr.iLK.iLR.computeSize();
            int i6 = this.jcN / 2;
            Log.e("MicroMsg.NetSceneSendMsg", "send msgs req exceed max limit, size %s, sendMsgMaxNum %s, newSendMsgMaxNum %s", Integer.valueOf(computeSize), Integer.valueOf(this.jcN), Integer.valueOf(i6));
            if (this.jcN == 1) {
                Log.e("MicroMsg.NetSceneSendMsg", "one msg exceed?????");
                bdK();
                this.callback.onSceneEnd(i3, i4, str, this);
                bdJ();
                AppMethodBeat.o(43034);
                return;
            }
            this.jcN = i6;
            Pk(str);
            Log.d("MicroMsg.NetSceneSendMsg", "resend SENDING msg");
            AppMethodBeat.o(43034);
        } else if (i3 == 3 || i3 == 9 || i3 == 7 || i3 == 8 || i3 == 1) {
            this.callback.onSceneEnd(i3, i4, str, this);
            Log.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
            AppMethodBeat.o(43034);
        } else {
            bdK();
            this.callback.onSceneEnd(i3, i4, str, this);
            bdJ();
            Log.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
            Pk(str);
            AppMethodBeat.o(43034);
        }
    }

    private void Pk(String str) {
        AppMethodBeat.i(43035);
        Log.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
        int doScene = doScene(dispatcher(), this.callback);
        if (doScene == -2) {
            this.callback.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(43035);
            return;
        }
        if (doScene < 0) {
            this.callback.onSceneEnd(3, -1, str, this);
        }
        AppMethodBeat.o(43035);
    }

    private void bdK() {
        AppMethodBeat.i(43036);
        for (int i2 = 0; i2 < this.jcP.size(); i2++) {
            tC(i2);
        }
        AppMethodBeat.o(43036);
    }

    private void tC(int i2) {
        AppMethodBeat.i(43037);
        ca caVar = this.jcP.get(i2);
        Log.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", Long.valueOf(caVar.field_msgId));
        Y(caVar);
        AppMethodBeat.o(43037);
    }

    private static void Y(ca caVar) {
        AppMethodBeat.i(43038);
        caVar.setStatus(5);
        e.INSTANCE.idkeyStat(111, 30, 1, true);
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(caVar.field_msgId, caVar);
        Iterator<Object> it = jcO.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(43038);
    }

    static /* synthetic */ void ax(List list) {
        AppMethodBeat.i(43041);
        for (int i2 = 0; i2 < list.size(); i2++) {
            Y((ca) list.get(i2));
        }
        AppMethodBeat.o(43041);
    }

    static /* synthetic */ void ay(List list) {
        AppMethodBeat.i(43042);
        for (int i2 = 0; i2 < list.size(); i2++) {
            X((ca) list.get(i2));
        }
        AppMethodBeat.o(43042);
    }
}
