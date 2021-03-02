package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.appbrand.jsapi.p.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.k.f;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.protocal.protobuf.eav;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class v extends q implements m {
    private static List<bb> DIN = new LinkedList();
    private static c DIP;
    private static boolean DIQ = true;
    private a DIO = new a();
    i callback;
    private String gna = "";
    d rr;

    static {
        AppMethodBeat.i(95647);
        AppMethodBeat.o(95647);
    }

    public v() {
        AppMethodBeat.i(95630);
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "NetSceneSnsSync %d", 256);
        d.a aVar = new d.a();
        aVar.iLN = new eau();
        aVar.iLO = new eav();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnssync";
        aVar.funcId = 214;
        aVar.iLP = 102;
        aVar.respCmdId = 1000000102;
        this.rr = aVar.aXF();
        ((eau) this.rr.iLK.iLR).Leu = 256;
        this.gna = z.aTY();
        if (DIQ) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            g.aAi();
            String sb2 = sb.append(g.aAh().cachePath).append("ad_1100007").toString();
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  ".concat(String.valueOf(sb2)));
            byte[] aW = s.aW(sb2, 0, -1);
            if (aW != null) {
                try {
                    DIP = (c) new c().parseFrom(aW);
                    Log.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (DIP == null) {
                        Log.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
                    } else {
                        Log.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + DIP.DRK.size());
                    }
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
                    s.deleteFile(sb2);
                }
            }
            DIQ = false;
        }
        AppMethodBeat.o(95630);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(95631);
        g.aAi();
        byte[] decodeHexString = Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8195, (Object) null)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(decodeHexString);
        ((eau) this.rr.iLK.iLR).Lev = sKBuiltinBuffer_t;
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95631);
        return dispatch;
    }

    public static void Jl(long j2) {
        AppMethodBeat.i(95632);
        if (DIP == null) {
            DIP = new c();
        }
        DIP.DRK.add(Long.valueOf(j2));
        AppMethodBeat.o(95632);
    }

    public static void Jm(long j2) {
        AppMethodBeat.i(95633);
        if (DIP != null) {
            DIP.DRK.remove(Long.valueOf(j2));
        }
        AppMethodBeat.o(95633);
    }

    public static boolean Jn(long j2) {
        AppMethodBeat.i(95634);
        if (DIP == null) {
            AppMethodBeat.o(95634);
            return false;
        } else if (DIP.DRK.contains(Long.valueOf(j2))) {
            AppMethodBeat.o(95634);
            return true;
        } else {
            AppMethodBeat.o(95634);
            return false;
        }
    }

    public static void fah() {
        AppMethodBeat.i(95635);
        if (DIP == null) {
            AppMethodBeat.o(95635);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().cachePath).append("ad_1100007").toString();
        Log.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  ".concat(String.valueOf(sb2)));
        try {
            byte[] byteArray = DIP.toByteArray();
            s.f(sb2, byteArray, byteArray.length);
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + DIP.DRK.size());
            AppMethodBeat.o(95635);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "listToFile failed: ".concat(String.valueOf(sb2)), new Object[0]);
            AppMethodBeat.o(95635);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 214;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        byte[] l;
        AppMethodBeat.i(95636);
        Log.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            eav eav = (eav) ((d) sVar).iLL.iLR;
            LinkedList<abn> linkedList = eav.Ley.oTA;
            if (linkedList == null || linkedList.size() <= 0) {
                if (!(eav.Lev == null || eav.Lev.getBuffer() == null || (l = ad.l(((eau) ((d) sVar).iLK.iLR).Lev.getBuffer().toByteArray(), eav.Lev.getBuffer().toByteArray())) == null || l.length <= 0)) {
                    g.aAi();
                    g.aAh().azQ().set(8195, Util.encodeHexString(l));
                }
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(95636);
                return;
            }
            Log.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + linkedList.size());
            a aVar = this.DIO;
            aVar.sKS = linkedList;
            aVar.tby.sendEmptyMessage(0);
            AppMethodBeat.o(95636);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95636);
    }

    public final boolean a(abn abn, final MMHandler mMHandler) {
        AppMethodBeat.i(95637);
        try {
            final SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(abn.Lmt.getBuffer().toByteArray());
            String str = new String(snsObject.ObjectDesc.getBuffer().toByteArray());
            boolean z = str.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0 || str.indexOf("<contentStyle>1</contentStyle>") >= 0;
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + snsObject.Id + " " + r.Jb(snsObject.Id) + " isPhoto " + z);
            if (z) {
                String Jb = r.Jb(snsObject.Id);
                l aQr = aj.faS().aQr(snsObject.Username);
                if (!Util.isNullOrNil(aQr.field_newerIds)) {
                    String[] split = aQr.field_newerIds.split(",");
                    boolean z2 = true;
                    for (String str2 : split) {
                        if (Jb.equals(str2)) {
                            z2 = false;
                        }
                    }
                    int i2 = 0;
                    String str3 = Jb;
                    while (i2 < 2 && i2 < split.length && z2) {
                        str3 = str3 + "," + split[i2];
                        i2++;
                    }
                    Log.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + snsObject.Id + " S: " + Jb + " list " + aQr.field_newerIds + " newer " + str3);
                    if (z2) {
                        aj.faS().kK(snsObject.Username, str3);
                    }
                } else {
                    aj.faS().kK(snsObject.Username, Jb);
                }
            }
            if (aj.faO().JF(snsObject.Id)) {
                Log.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
                AppMethodBeat.o(95637);
                return false;
            }
            EventCenter.instance.publish(new vv());
            aj.dRd().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.v.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(95624);
                    if (!snsObject.Username.equals(v.this.gna)) {
                        g.aAi();
                        if (!g.aAf().azp()) {
                            Log.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                            AppMethodBeat.o(95624);
                            return;
                        }
                        g.aAi();
                        String str = (String) g.aAh().azQ().get(68377, (Object) null);
                        g.aAi();
                        if (Util.nullAs((Integer) g.aAh().azQ().get(68400, (Object) null), 0) != snsObject.CreateTime || (!Util.isNullOrNil(str) && !str.equals(snsObject.Username))) {
                            g.aAi();
                            g.aAh().azQ().set(68377, snsObject.Username);
                            g.aAi();
                            g.aAh().azQ().set(68400, Integer.valueOf(snsObject.CreateTime));
                            g.aAi();
                            g.aAh().azQ().set(68418, r.Jb(snsObject.Id));
                            g.aAi();
                            g.aAh().azQ().set(68419, (Object) 0);
                            f.s(1, r.Jb(snsObject.Id), 0);
                        }
                        for (bb bbVar : v.DIN) {
                            bbVar.aVt();
                        }
                    }
                    mMHandler.sendEmptyMessage(0);
                    AppMethodBeat.o(95624);
                }
            });
            AppMethodBeat.o(95637);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
            AppMethodBeat.o(95637);
            return false;
        }
    }

    public final boolean b(abn abn, final MMHandler mMHandler) {
        AppMethodBeat.i(95638);
        try {
            dzj dzj = (dzj) new dzj().parseFrom(abn.Lmt.getBuffer().toByteArray());
            long j2 = dzj.Id;
            long j3 = dzj.MZa;
            final dzi dzi = dzj.MZb;
            String str = dzj.izX;
            if (str == null) {
                str = "";
            }
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + dzi.oUv + " " + j2 + " " + str);
            switch (dzi.oUv) {
                case 9:
                    h i2 = aj.faT().i(j2, (long) dzi.MYT, dzi.oUv);
                    if (i2 == null) {
                        an.c(j2, dzj);
                        break;
                    } else {
                        i2.feD();
                        Log.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  ".concat(String.valueOf(aj.faT().update(i2.systemRowid, i2))));
                        break;
                    }
                case 10:
                    h i3 = aj.faT().i(j2, dzi.MYV, dzi.oUv);
                    if (i3 != null) {
                        i3.feD();
                        boolean update = aj.faT().update(i3.systemRowid, i3);
                        an.b(j2, dzj);
                        Log.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  ".concat(String.valueOf(update)));
                        break;
                    }
                    break;
                case 11:
                    com.tencent.mm.plugin.sns.storage.i faT = aj.faT();
                    String concat = " update SnsComment set commentflag = 2 where snsID = ".concat(String.valueOf(j2));
                    Log.i("MicroMsg.SnsCommentStorage", "set sns del ".concat(String.valueOf(concat)));
                    boolean execSQL = faT.iFy.execSQL("SnsComment", concat);
                    if (execSQL) {
                        faT.doNotify();
                    }
                    Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction ".concat(String.valueOf(execSQL)));
                    break;
                case 12:
                    com.tencent.mm.plugin.sns.storage.i faT2 = aj.faT();
                    String str2 = " update SnsComment set commentflag = 1 where snsID = " + j2 + " and talker = '" + Util.escapeSqlValue(dzi.MKC) + "'";
                    Log.i("MicroMsg.SnsCommentStorage", "set sns del  by username ".concat(String.valueOf(str2)));
                    boolean execSQL2 = faT2.iFy.execSQL("SnsComment", str2);
                    if (execSQL2) {
                        faT2.doNotify();
                    }
                    Log.i("MicroMsg.NetSceneNewSyncAlbum", "processAdSnsDelAction ".concat(String.valueOf(execSQL2)));
                    an.b(j2, dzj);
                    break;
                case 13:
                    a(dzj, dzi, j2, j3, str);
                    break;
                case 14:
                    b(dzj, dzi, j2, j3, str);
                    break;
                case 15:
                    com.tencent.mm.plugin.sns.storage.g.JG(j2);
                    SnsInfo JJ = aj.faO().JJ(j2);
                    TimeLineObject timeLine = JJ.getTimeLine();
                    timeLine.showFlag = 1;
                    JJ.setTimeLine(timeLine);
                    aj.faO().b(j2, JJ);
                    break;
                case 16:
                    dmo dmo = dzi.KHJ;
                    if (m.Jh(j2)) {
                        m mVar = new m(j2, dmo);
                        g.aAi();
                        g.aAg().hqi.a(mVar, 0);
                    }
                    try {
                        dzi dzi2 = dzj.MZb;
                        String nullAsNil = Util.nullAsNil(dzj.izX);
                        long j4 = dzj.MZa;
                        int i4 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLimit"), 0);
                        int i5 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLikeTimeLimit"), 0);
                        int i6 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyCommentTimeLimit"), 0);
                        if (dmo != null) {
                            Log.i("MicroMsg.NetSceneNewSyncAlbum", "processAdAtAction clientId %s, snsId %s, aid64 %s, aid %s, commentId %s, actionLimit %s", nullAsNil, Long.valueOf(j2), Long.valueOf(dmo.MQh), Integer.valueOf(dmo.MQc), Integer.valueOf(dzi2.MYT), Integer.valueOf(i4));
                            if (dmo.MQh == 0 && dmo.MQc == 0) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 4);
                            }
                        } else {
                            Log.i("MicroMsg.NetSceneNewSyncAlbum", "remindFriendsInfo is null!");
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 3);
                        }
                        if (!aj.faT().a(j2, dzi2.MKC, dzi2.CreateTime, nullAsNil)) {
                            dzi dzi3 = dzj.MZc;
                            h hVar = new h();
                            hVar.field_snsID = j2;
                            hVar.field_parentID = j4;
                            hVar.field_createTime = dzi2.CreateTime;
                            hVar.field_talker = dzi2.MKC;
                            hVar.field_type = dzi2.oUv;
                            hVar.field_curActionBuf = dzi2.toByteArray();
                            hVar.field_refActionBuf = dzi3.toByteArray();
                            hVar.field_clientId = nullAsNil;
                            hVar.field_isSilence = e.iY(dzi2.MYX, 2) ? 1 : 0;
                            hVar.field_commentSvrID = dzi2.MYV;
                            if (aj.faR().JF(j2)) {
                                if ((i4 <= 0 && i5 <= 0 && i6 <= 0) || a.a(j2, dzj, i4, i5, i6, true)) {
                                    if (!a.a(j2, dzj)) {
                                        Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + hVar.field_snsID + " " + hVar.field_commentSvrID);
                                        break;
                                    }
                                } else {
                                    Log.i("MicroMsg.NetSceneNewSyncAlbum", "check comment fail, pass comment ID " + hVar.field_snsID + " " + hVar.field_commentSvrID);
                                    break;
                                }
                            }
                            if (!Util.isNullOrNil(dzi2.MYY) && dzi2.MYY.get(0) != null) {
                                EmojiInfo a2 = an.a(dzi2.MYY.get(0));
                                if (bj.gCJ().OpN.blk(a2.field_md5) == null) {
                                    bj.gCJ().OpN.K(a2);
                                    if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG || ((b) g.af(b.class)).a(b.a.clicfg_sns_emoji_auto_download, 0) == 1) {
                                        com.tencent.mm.emoji.loader.e eVar = com.tencent.mm.emoji.loader.e.gVM;
                                        com.tencent.mm.emoji.loader.e.a(a2, (i.a) null);
                                    }
                                }
                            }
                            aj.faT().insert(hVar);
                            aj.faT().L(j2, e.iY(dzi2.MYX, 2));
                            break;
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
                        break;
                    }
                    break;
                case 17:
                    String str3 = "";
                    ADInfo aDInfo = null;
                    ADXml aDXml = null;
                    boolean z = false;
                    try {
                        str3 = r.Jb(j2);
                        Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=".concat(String.valueOf(str3)));
                        AdSnsInfo JE = aj.faR().JE(j2);
                        if (JE != null) {
                            aDInfo = JE.getAdInfo();
                            aDXml = JE.getAdXml();
                        }
                        z = aj.faR().delete(j2);
                        aj.faT().JI(j2);
                        com.tencent.mm.plugin.sns.storage.g.JH(j2);
                        Log.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction snsId=" + str3 + ", delSucc=" + z + ", adSnsInfo==null?" + (JE == null));
                    } catch (Throwable th) {
                        Log.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction exp=" + th.toString() + ", snsId=" + str3);
                    }
                    try {
                        com.tencent.mm.plugin.sns.data.i.a(3, j2, aDInfo, aDXml);
                        if (z) {
                            com.tencent.mm.plugin.sns.data.i.a(4, j2, aDInfo, aDXml);
                            break;
                        }
                    } catch (Throwable th2) {
                        Log.e("MicroMsg.NetSceneNewSyncAlbum", "processSnsAdFeedsForceDelAction report exp=" + th2.toString() + ", snsId=" + str3);
                        break;
                    }
                    break;
                default:
                    a(dzj);
                    break;
            }
            final boolean z2 = !e.iY(dzi.MYX, 2);
            aj.dRd().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.v.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(95625);
                    if (z2) {
                        for (bb bbVar : v.DIN) {
                            Log.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                            bbVar.aVs();
                        }
                    }
                    mMHandler.sendEmptyMessage(0);
                    AppMethodBeat.o(95625);
                }
            });
            AppMethodBeat.o(95638);
            return true;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e3, "", new Object[0]);
            AppMethodBeat.o(95638);
            return false;
        }
    }

    public static boolean Jo(long j2) {
        AppMethodBeat.i(95639);
        try {
            boolean a2 = a.a(j2, null, Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLimit"), 0), Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLikeTimeLimit"), 0), Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
            AppMethodBeat.o(95639);
            return a2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
            AppMethodBeat.o(95639);
            return true;
        }
    }

    private static boolean a(dzj dzj) {
        AppMethodBeat.i(95640);
        try {
            dzi dzi = dzj.MZb;
            long j2 = dzj.Id;
            String nullAsNil = Util.nullAsNil(dzj.izX);
            long j3 = dzj.MZa;
            int i2 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLimit"), 0);
            int i3 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyLikeTimeLimit"), 0);
            int i4 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsAdNotifyCommentTimeLimit"), 0);
            if ((i2 > 0 || i3 > 0 || i4 > 0) && ((dzi.oUv == 8 || dzi.oUv == 7) && !a.a(j2, dzj, i2, i3, i4, true))) {
                Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + nullAsNil + " snsId: " + j2 + " " + dzi.MYV + " " + dzi.MYT + " actionLimit:" + i2 + " actionLikeTimeLimit:" + i3 + " actionCommentTimeLimit:" + i4);
                a.a(j2, dzj);
                AppMethodBeat.o(95640);
                return false;
            }
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + nullAsNil + " snsId: " + j2 + " " + dzi.MYV + " " + dzi.MYT + " actionLimit: " + i2);
            if (!aj.faT().a(j2, dzi.MKC, dzi.CreateTime, nullAsNil)) {
                dzi dzi2 = dzj.MZc;
                h hVar = new h();
                hVar.field_snsID = j2;
                hVar.field_parentID = j3;
                hVar.field_createTime = dzi.CreateTime;
                hVar.field_talker = dzi.MKC;
                hVar.field_type = dzi.oUv;
                hVar.field_curActionBuf = dzi.toByteArray();
                hVar.field_refActionBuf = dzi2.toByteArray();
                hVar.field_clientId = nullAsNil;
                hVar.field_isSilence = e.iY(dzi.MYX, 2) ? 1 : 0;
                if (dzi.oUv == 8 || dzi.oUv == 7) {
                    hVar.field_commentSvrID = dzi.MYV;
                    if (!a.a(j2, dzj)) {
                        Log.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + hVar.field_snsID + " " + hVar.field_commentSvrID);
                        AppMethodBeat.o(95640);
                        return false;
                    }
                } else {
                    hVar.field_commentSvrID = (long) dzi.MYT;
                    if (!an.a(j2, dzj)) {
                        AppMethodBeat.o(95640);
                        return false;
                    }
                }
                if (!Util.isNullOrNil(dzi.MYY) && dzi.MYY.get(0) != null) {
                    EmojiInfo a2 = an.a(dzi.MYY.get(0));
                    if (bj.gCJ().OpN.blk(a2.field_md5) == null) {
                        bj.gCJ().OpN.K(a2);
                        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG || ((b) g.af(b.class)).a(b.a.clicfg_sns_emoji_auto_download, 0) == 1) {
                            com.tencent.mm.emoji.loader.e eVar = com.tencent.mm.emoji.loader.e.gVM;
                            com.tencent.mm.emoji.loader.e.a(a2, (i.a) null);
                        }
                    }
                }
                aj.faT().insert(hVar);
                aj.faT().L(j2, e.iY(dzi.MYX, 2));
                AppMethodBeat.o(95640);
                return true;
            }
            AppMethodBeat.o(95640);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
            AppMethodBeat.o(95640);
            return false;
        }
    }

    private static boolean a(dzj dzj, dzi dzi, long j2, long j3, String str) {
        AppMethodBeat.i(95641);
        try {
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + str + " snsId: " + j2 + " " + dzi.MYV + " " + dzi.MYT);
            if (!com.tencent.mm.plugin.sns.lucky.a.g.eZL()) {
                Log.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
                AppMethodBeat.o(95641);
                return false;
            } else if (!aj.faT().a(j2, dzi.MKC, dzi.CreateTime, str)) {
                dzi dzi2 = dzj.MZc;
                h hVar = new h();
                hVar.field_snsID = j2;
                hVar.field_parentID = j3;
                hVar.field_createTime = dzi.CreateTime;
                hVar.field_talker = dzi.MKC;
                hVar.field_type = dzi.oUv;
                hVar.field_curActionBuf = dzi.toByteArray();
                hVar.field_refActionBuf = dzi2.toByteArray();
                hVar.field_clientId = str;
                hVar.field_commentSvrID = (long) dzi.MYT;
                Log.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + dzi.MYW);
                an.d(j2, dzj);
                aVu();
                aj.faT().insert(hVar);
                AppMethodBeat.o(95641);
                return true;
            } else {
                AppMethodBeat.o(95641);
                return false;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
            AppMethodBeat.o(95641);
            return false;
        }
    }

    private static boolean b(dzj dzj, dzi dzi, long j2, long j3, String str) {
        AppMethodBeat.i(95642);
        try {
            Log.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + str + " snsId: " + j2 + " " + dzi.MYV + " " + dzi.MYT);
            if (!aj.faT().a(j2, dzi.MKC, dzi.CreateTime, str)) {
                dzi dzi2 = dzj.MZc;
                h hVar = new h();
                hVar.field_snsID = j2;
                hVar.field_parentID = j3;
                hVar.field_createTime = dzi.CreateTime;
                hVar.field_talker = dzi.MKC;
                hVar.field_type = dzi.oUv;
                hVar.field_curActionBuf = dzi.toByteArray();
                hVar.field_refActionBuf = dzi2.toByteArray();
                hVar.field_clientId = str;
                hVar.field_commentSvrID = (long) dzi.MYT;
                cbd cbd = new cbd();
                Log.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + dzi.MYW);
                cbd.parseFrom(com.tencent.mm.platformtools.z.a(dzi.MYW));
                Log.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + cbd.eht);
                aj.faT().insert(hVar);
                AppMethodBeat.o(95642);
                return true;
            }
            AppMethodBeat.o(95642);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
            AppMethodBeat.o(95642);
            return false;
        }
    }

    class a {
        LinkedList<abn> sKS;
        MMHandler tby = new MMHandler() {
            /* class com.tencent.mm.plugin.sns.model.v.a.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(95628);
                g.aAi();
                if (!g.aAf().azp()) {
                    AppMethodBeat.o(95628);
                } else if (a.this.sKS == null || a.this.sKS.isEmpty()) {
                    v vVar = v.this;
                    eav eav = (eav) vVar.rr.iLL.iLR;
                    eau eau = (eau) vVar.rr.iLK.iLR;
                    byte[] l = ad.l(eau.Lev.getBuffer().toByteArray(), eav.Lev.getBuffer().toByteArray());
                    if (l != null && l.length > 0) {
                        g.aAi();
                        g.aAh().azQ().set(8195, Util.encodeHexString(l));
                    }
                    eau.Lev.setBuffer(l);
                    if ((eav.KZh & eau.Leu) == 0) {
                        vVar.callback.onSceneEnd(0, 0, "", vVar);
                        AppMethodBeat.o(95628);
                        return;
                    }
                    vVar.doScene(vVar.dispatcher(), vVar.callback);
                    AppMethodBeat.o(95628);
                } else {
                    final abn first = a.this.sKS.getFirst();
                    Log.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + first.Lms);
                    a.this.sKS.removeFirst();
                    switch (first.Lms) {
                        case 45:
                            aj.eJP().post(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.model.v.a.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(95626);
                                    if (!v.this.a(first, a.this.tby)) {
                                        a.this.tby.sendEmptyMessage(0);
                                    }
                                    AppMethodBeat.o(95626);
                                }
                            });
                            AppMethodBeat.o(95628);
                            return;
                        case 46:
                            aj.eJP().post(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.model.v.a.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(95627);
                                    if (!v.this.b(first, a.this.tby)) {
                                        a.this.tby.sendEmptyMessage(0);
                                    }
                                    AppMethodBeat.o(95627);
                                }
                            });
                            AppMethodBeat.o(95628);
                            return;
                        default:
                            a.this.tby.sendEmptyMessage(0);
                            AppMethodBeat.o(95628);
                            return;
                    }
                }
            }
        };

        a() {
            AppMethodBeat.i(95629);
            AppMethodBeat.o(95629);
        }
    }

    public static void fai() {
        AppMethodBeat.i(95643);
        for (bb bbVar : DIN) {
            if (bbVar != null) {
                bbVar.aVv();
            }
        }
        AppMethodBeat.o(95643);
    }

    private static void aVu() {
        AppMethodBeat.i(95644);
        for (bb bbVar : DIN) {
            if (bbVar != null) {
                bbVar.aVu();
            }
        }
        AppMethodBeat.o(95644);
    }

    public static void a(bb bbVar) {
        AppMethodBeat.i(95645);
        if (!DIN.contains(bbVar)) {
            DIN.add(bbVar);
        }
        AppMethodBeat.o(95645);
    }

    public static void b(bb bbVar) {
        AppMethodBeat.i(95646);
        DIN.remove(bbVar);
        AppMethodBeat.o(95646);
    }
}
