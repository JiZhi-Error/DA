package com.tencent.mm.model;

import android.app.Notification;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.h;
import com.tencent.mm.al.a.e;
import com.tencent.mm.api.y;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.d;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.ca;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class f implements p {
    private long iBJ = -1;
    public a iBK;
    private final LinkedHashMap<String, b> iBL = new LinkedHashMap<>();

    public interface a {
        void gt(String str);
    }

    public interface b extends p {
        String getSubType();
    }

    public f() {
        AppMethodBeat.i(CdnLogic.kMediaTypeNearEvent);
        h hVar = new h();
        this.iBL.put(hVar.getSubType(), hVar);
        AppMethodBeat.o(CdnLogic.kMediaTypeNearEvent);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, final Map<String, String> map, h.a aVar) {
        h.b bVar;
        String str2;
        int length;
        String str3;
        String str4;
        b bVar2;
        AppMethodBeat.i(20312);
        de deVar = aVar.heO;
        String a2 = z.a(deVar.KHn);
        h.b bVar3 = null;
        if (!(str == null || (bVar2 = this.iBL.get(str)) == null)) {
            try {
                h.b a3 = bVar2.a(str, map, aVar);
                AppMethodBeat.o(20312);
                return a3;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", th, "consumeNewXml dispatch handle subType [%s] error", str);
            }
        }
        if (str != null && str.equals("addcontact")) {
            deVar.KHn = z.Su(map.get(".sysmsg.addcontact.content"));
            deVar.xKb = 1;
            h ck = h.d.ck(1);
            bVar3 = ck == null ? null : ck.b(aVar);
        }
        if (str != null && str.equals("dynacfg")) {
            com.tencent.mm.n.h.aqJ().a(a2, map, false);
            com.tencent.mm.n.h.aqK();
            if (d.aqw() == 2) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10879, "");
            }
            Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(Util.getInt(com.tencent.mm.n.h.aqJ().getValue("MuteRoomDisable"), 0)));
        }
        if (str != null && str.equals("dynacfg_split")) {
            com.tencent.mm.n.h.aqJ().a(a2, map, true);
        }
        if (str != null && str.equals("banner")) {
            String str5 = map.get(".sysmsg.mainframebanner.$type");
            String str6 = map.get(".sysmsg.mainframebanner.showtype");
            String str7 = map.get(".sysmsg.mainframebanner.data");
            if (str5 != null && str5.length() > 0) {
                try {
                    bo.aVL().a(new bn(Util.getInt(str5, 0), Util.getInt(str6, 0), str7));
                } catch (Exception e2) {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", e2.toString());
                }
            }
            String str8 = map.get(".sysmsg.friendrecommand.fromuser");
            String str9 = map.get(".sysmsg.friendrecommand.touser");
            if (!(str8 == null || str9 == null)) {
                try {
                    bg.aVF().aTm().a(str9, true, null);
                } catch (Exception e3) {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", e3.toString());
                }
            }
            String str10 = map.get(".sysmsg.banner.securitybanner.chatname");
            String str11 = map.get(".sysmsg.banner.securitybanner.wording");
            String str12 = map.get(".sysmsg.banner.securitybanner.linkname");
            String str13 = map.get(".sysmsg.banner.securitybanner.linksrc");
            String str14 = map.get(".sysmsg.banner.securitybanner.showtype");
            if (!Util.isNullOrNil(str10) && !Util.isNullOrNil(str14)) {
                try {
                    bg.aVF().aTn().a(str10, str14.equals("1"), new String[]{str11, str12, str13});
                } catch (Exception e4) {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + e4.toString());
                }
            }
            bg.aVF().aTo().C(map);
        }
        if (!Util.isNullOrNil(str) && str.equals("midinfo")) {
            String str15 = map.get(".sysmsg.midinfo.json_buffer");
            String str16 = map.get(".sysmsg.midinfo.time_interval");
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", str16, str15, a2);
            int i2 = Util.getInt(str16, 0);
            if (((long) i2) > 86400 && ((long) i2) < 864000) {
                bg.aVF();
                c.azQ().set(331777, Long.valueOf(Util.nowSecond() + ((long) i2)));
            }
            if (!Util.isNullOrNil(str15)) {
                com.tencent.mm.plugin.report.b.d.aMs(str15);
            }
        }
        if (str != null && str.equals("revokemsg")) {
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
            String str17 = map.get(".sysmsg.revokemsg.session");
            String str18 = map.get(".sysmsg.revokemsg.newmsgid");
            String str19 = map.get(".sysmsg.revokemsg.replacemsg");
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", str18, str19);
            try {
                long j2 = Util.getLong(str18, 0);
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "xmlSrvMsgId=%d talker=%s isGet=%s", Long.valueOf(j2), str17, Boolean.valueOf(aVar.iLV));
                ca aJ = ((l) g.af(l.class)).eiy().aJ(str17, j2);
                final ca aZ = ca.aZ(aJ);
                bg.aVF();
                az bjY = c.aST().bjY(str17);
                if (aVar != null && aVar.iLV) {
                    de deVar2 = aVar.heO;
                    String a4 = z.a(deVar2.KHn);
                    bt btVar = new bt();
                    btVar.field_originSvrId = j2;
                    if (aJ.field_msgId == 0) {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", Long.valueOf(j2));
                        btVar.field_content = a4;
                        btVar.field_createTime = (long) deVar2.CreateTime;
                        btVar.field_flag = bp.d(aVar);
                        btVar.field_fromUserName = z.a(deVar2.KHl);
                        btVar.field_toUserName = z.a(deVar2.KHm);
                        btVar.field_newMsgId = deVar2.Brn;
                        com.tencent.mm.modelmulti.p.bdT();
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", Boolean.valueOf(com.tencent.mm.modelmulti.p.bdR().insert(btVar)), Long.valueOf(btVar.systemRowid));
                        AppMethodBeat.o(20312);
                        return null;
                    }
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", Long.valueOf(j2));
                    com.tencent.mm.modelmulti.p.bdT();
                    com.tencent.mm.modelmulti.p.bdR().delete(btVar, true, new String[0]);
                    if (!(bjY == null || aVar.heO == null || bjY.field_lastSeq != ((long) aVar.heO.KHs))) {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", Long.valueOf(bjY.field_lastSeq), Long.valueOf(bjY.field_firstUnDeliverSeq));
                        bg.aVF();
                        ca aEz = c.aSQ().aEz(bjY.field_username);
                        if (aEz != null) {
                            bjY.yC(aEz.field_msgSeq);
                            bg.aVF();
                            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", Long.valueOf(aEz.field_msgSvrId), Long.valueOf(aEz.field_msgSeq), Long.valueOf(bjY.field_lastSeq), Long.valueOf(bjY.field_firstUnDeliverSeq), Integer.valueOf(c.aST().a(bjY, bjY.field_username)));
                        }
                    }
                }
                if (aJ.field_msgId == 0) {
                    if (((PluginPatMsg) g.ah(PluginPatMsg.class)).getRecvRecord(j2) != null) {
                        ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).bd(str17, j2);
                    } else {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke newxml, but original msg has not been found, originSvrId[%d]", Long.valueOf(j2));
                        bg.aVF();
                        c.aSQ().Hf(j2);
                    }
                } else if (aJ.getType() == 922746929) {
                    ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).bd(str17, j2);
                } else {
                    sw swVar = new sw();
                    swVar.dZp.msgId = aJ.field_msgId;
                    swVar.dZp.dZq = str19;
                    swVar.dZp.dTX = aJ;
                    swVar.dZp.dZr = aZ;
                    swVar.dZp.dZs = j2;
                    EventCenter.instance.publish(swVar);
                    if (aZ != null) {
                        g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.model.f.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(20308);
                                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", Long.valueOf(aZ.field_msgId), Integer.valueOf(aZ.getType()));
                                switch (aZ.getType()) {
                                    case 3:
                                    case 34:
                                    case 43:
                                    case 44:
                                    case 49:
                                    case 62:
                                    case 268435505:
                                        bp.z(aZ);
                                        break;
                                }
                                AppMethodBeat.o(20308);
                            }
                        });
                    }
                    if ((aJ.fqJ & 4) != 4) {
                        aJ.setContent(str19);
                        aJ.setType(10000);
                        bp.a(aJ, aVar);
                        bg.aVF();
                        c.aSQ().a(aJ.field_msgId, aJ);
                    }
                    ((com.tencent.mm.plugin.msgquote.a) g.ah(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySvrId(j2);
                    if (bjY != null && bjY.field_unReadCount > 0) {
                        bg.aVF();
                        if (bjY.field_unReadCount >= c.aSQ().aB(aJ)) {
                            bjY.nt(bjY.field_unReadCount - 1);
                            bg.aVF();
                            c.aST().a(bjY, bjY.getUsername());
                        }
                    }
                    if (aa.i(aZ)) {
                        nv nvVar = new nv();
                        nvVar.dTW.dTX = aZ;
                        EventCenter.instance.publish(nvVar);
                    }
                }
            } catch (Exception e5) {
                Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e5, "[oneliang][revokeMsg] msgId:%d,error:%s", 0L, e5.toString());
            }
            AppMethodBeat.o(20312);
            return null;
        } else if (str == null || !str.equals("clouddelmsg")) {
            if (str == null || !str.equals("updatepackage")) {
                bVar = bVar3;
            } else {
                h ck2 = h.d.ck(-1879048175);
                if (ck2 == null) {
                    bVar = null;
                } else {
                    bVar = ck2.b(aVar);
                }
            }
            if (str != null && str.equals("deletepackage")) {
                h ck3 = h.d.ck(-1879048174);
                if (ck3 == null) {
                    bVar = null;
                } else {
                    bVar = ck3.b(aVar);
                }
            }
            if (str != null && str.equals("delchatroommember")) {
                String a5 = z.a(deVar.KHl);
                bg.aVF();
                ca aJ2 = c.aSQ().aJ(a5, deVar.Brn);
                boolean z = false;
                if (aJ2.ajL() > 0) {
                    z = true;
                }
                aJ2.yF(deVar.Brn);
                if (aVar == null || !aVar.iLV || !aVar.iLX) {
                    aJ2.setCreateTime(bp.C(a5, (long) deVar.CreateTime));
                }
                aJ2.setType(10002);
                aJ2.setContent(a2);
                aJ2.nv(0);
                aJ2.Cy(a5);
                aJ2.BB(deVar.KHq);
                bp.a(aJ2, aVar);
                if (!z) {
                    bp.x(aJ2);
                } else {
                    bg.aVF();
                    c.aSQ().b(deVar.Brn, aJ2);
                }
            }
            if (!(str == null || !str.equals("WakenPush") || this.iBJ == deVar.Brn)) {
                this.iBJ = deVar.Brn;
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                cq cqVar = new cq(map);
                String str20 = cqVar.izF.get(".sysmsg.WakenPush.PushContent");
                String str21 = cqVar.izF.get(".sysmsg.WakenPush.Jump");
                String str22 = cqVar.izF.get(".sysmsg.WakenPush.Username");
                Log.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", str20, str21, cqVar.izF.get(".sysmsg.WakenPush.ExpiredTime"));
                String value = com.tencent.mm.n.h.aqJ().getValue("WakenPushDeepLinkBitSet");
                Log.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", value);
                Notification a6 = bg.getNotification().a(cqVar.F(str21, !Util.isNullOrNil(value) ? Util.getLong(value, 0) : 0), MMApplicationContext.getContext().getString(R.string.wx), str20, str20, c.a(str22, false, -1, null), str22);
                a6.flags |= 16;
                bg.getNotification().a(a6, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 31, 1, true);
                bVar = null;
            }
            if (str != null && str.equals("DisasterNotice")) {
                final String str23 = map.get(".sysmsg.NoticeId");
                String str24 = map.get(".sysmsg.Content");
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", str23, str24);
                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.aps());
                String string = sharedPreferences.getString("disaster_noticeid_list_key", "");
                if (!string.contains(str23)) {
                    String[] split = string.split(";");
                    if (split == null || split.length <= 10) {
                        str3 = string;
                    } else {
                        str3 = "";
                        for (String str25 : split) {
                            String[] split2 = str25.split(",");
                            try {
                                if (Util.secondsToNow(Util.getLong(split2[0], 0)) < 1296000) {
                                    str3 = str3 + split2[0] + "," + split2[1] + ";";
                                }
                            } catch (Exception e6) {
                                Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", e6);
                            }
                        }
                    }
                    String str26 = str3 + Util.nowSecond() + "," + str23 + ";";
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", string, str26);
                    sharedPreferences.edit().putString("disaster_noticeid_list_key", str26).commit();
                }
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.model.f.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(20306);
                        if (f.this.iBK != null) {
                            f.this.iBK.gt(str23);
                        }
                        AppMethodBeat.o(20306);
                    }
                });
                deVar.KHn = z.Su(str24);
                deVar.xKb = 1;
                h ck4 = h.d.ck(1);
                if (ck4 == null) {
                    bVar = null;
                } else {
                    bVar = ck4.b(aVar);
                }
            }
            if (str != null && str.equals("EmotionKv")) {
                String str27 = map.get(".sysmsg.EmotionKv.K");
                String str28 = map.get(".sysmsg.EmotionKv.I");
                if (str27 == null) {
                    str2 = "";
                } else {
                    str2 = str27;
                }
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", Integer.valueOf(str2.length()), str2, str28);
                byte[] bytes = ac.gtR().KAw.getBytes();
                byte[] bytes2 = ac.gtR().KAx.getBytes();
                byte[] bArr = null;
                try {
                    bArr = bg.azz().azD().aZh().aZc();
                } catch (Exception e7) {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", Util.stackTraceToString(e7));
                }
                if (Util.isNullOrNil(bArr)) {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                }
                byte[] gtA = com.tencent.mm.protocal.f.gtA();
                if (Util.isNullOrNil(gtA)) {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                }
                PByteArray pByteArray = new PByteArray();
                if (Util.isNullOrNil(str2) || Util.isNullOrNil(bytes2) || Util.isNullOrNil(bytes) || Util.isNullOrNil(bArr) || Util.isNullOrNil(gtA)) {
                    Object[] objArr = new Object[5];
                    if (str2 == null) {
                        length = -1;
                    } else {
                        length = str2.length();
                    }
                    objArr[0] = Integer.valueOf(length);
                    objArr[1] = Integer.valueOf(bytes2 == null ? -1 : bytes2.length);
                    objArr[2] = Integer.valueOf(bytes == null ? -1 : bytes.length);
                    objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                    objArr[4] = Integer.valueOf(gtA == null ? -1 : gtA.length);
                    Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d", objArr);
                } else {
                    bg.aVF();
                    MMProtocalJni.genClientCheckKVRes(c.getUin(), str2, bytes, bytes2, bArr, gtA, pByteArray);
                }
                byte[] bArr2 = pByteArray.value;
                cgc cgc = new cgc();
                if (pByteArray.value != null) {
                    cgc.Cyk = new String(pByteArray.value);
                } else {
                    cgc.Cyk = "";
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                objArr2[1] = Integer.valueOf(cgc.Cyk.length());
                objArr2[2] = com.tencent.mm.b.g.getMessageDigest(cgc.Cyk.getBytes());
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", objArr2);
                cgc.MlO = str28;
                bg.aVF();
                c.aSM().d(new k.a(59, cgc));
                AppMethodBeat.o(20312);
                return null;
            } else if (str != null && str.equals("globalalert")) {
                String str29 = map.get(".sysmsg.uuid");
                int i3 = Util.getInt(map.get(".sysmsg.id"), -1);
                int i4 = Util.getInt(map.get(".sysmsg.important"), -1);
                if (Util.isNullOrNil(str29) || i3 < 0 || i4 < 0) {
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", str29, Integer.valueOf(i3), Integer.valueOf(i4));
                    AppMethodBeat.o(20312);
                    return null;
                }
                String str30 = map.get(".sysmsg.title");
                String str31 = map.get(".sysmsg.msg");
                if (!Util.isNullOrNil(str30) || !Util.isNullOrNil(str31)) {
                    String str32 = map.get(".sysmsg.btnlist.btn.$title");
                    int i5 = Util.getInt(map.get(".sysmsg.btnlist.btn.$id"), -1);
                    int i6 = Util.getInt(map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                    String str33 = map.get(".sysmsg.btnlist.btn");
                    if (Util.isNullOrNil(str32) || i5 < 0 || i6 < 0) {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", str32, Integer.valueOf(i5), Integer.valueOf(i6));
                        AppMethodBeat.o(20312);
                        return null;
                    }
                    String str34 = map.get(".sysmsg.btnlist.btn1.$title");
                    int i7 = Util.getInt(map.get(".sysmsg.btnlist.btn1.$id"), -1);
                    int i8 = Util.getInt(map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                    String str35 = map.get(".sysmsg.btnlist.btn1");
                    boolean z2 = true;
                    if (Util.isNullOrNil(str34) || i7 < 0 || i8 < 0) {
                        z2 = false;
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", str32, Integer.valueOf(i5), Integer.valueOf(i6));
                    }
                    kk kkVar = new kk();
                    com.tencent.mm.protocal.b.a.b bVar4 = new com.tencent.mm.protocal.b.a.b();
                    kkVar.dPw.dPx = bVar4;
                    bVar4.id = i3;
                    bVar4.title = str30;
                    bVar4.msg = str31;
                    bVar4.KBq = new LinkedList<>();
                    com.tencent.mm.protocal.b.a.a aVar2 = new com.tencent.mm.protocal.b.a.a();
                    aVar2.id = i5;
                    aVar2.actionType = i6;
                    aVar2.KBo = str32;
                    aVar2.KBp = str33;
                    bVar4.KBq.add(aVar2);
                    if (z2) {
                        com.tencent.mm.protocal.b.a.a aVar3 = new com.tencent.mm.protocal.b.a.a();
                        aVar3.id = i7;
                        aVar3.actionType = i8;
                        aVar3.KBo = str34;
                        aVar3.KBp = str35;
                        bVar4.KBq.add(aVar3);
                    }
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", str29, Integer.valueOf(i3), Integer.valueOf(i4), str30, str31, Boolean.valueOf(z2), Boolean.valueOf(EventCenter.instance.publish(kkVar)));
                    AppMethodBeat.o(20312);
                    return null;
                }
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", str30, str31);
                AppMethodBeat.o(20312);
                return null;
            } else if (str != null && str.equals("yybsigcheck")) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 14, 1, false);
                long currentTimeMillis = System.currentTimeMillis();
                String str36 = map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                String str37 = map.get(".sysmsg.yybsigcheck.yybsig.wording");
                String str38 = map.get(".sysmsg.yybsigcheck.yybsig.url");
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", str36, str37, str38);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4014, String.format("%s|%s|%s", str36, str37, str38));
                if (Util.isNullOrNil(str36)) {
                    Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 15, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4015, String.format("%s|%s", str37, str38));
                    AppMethodBeat.o(20312);
                    return null;
                }
                String[] split3 = str36.split(";");
                Object[] objArr3 = new Object[1];
                objArr3[0] = Integer.valueOf(split3 == null ? -1 : split3.length);
                Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", objArr3);
                if (split3 == null || split3.length == 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 16, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4016, str36);
                    AppMethodBeat.o(20312);
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i9 = 0; i9 < split3.length; i9++) {
                    String str39 = split3[i9];
                    if (Util.isNullOrNil(str39)) {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", Integer.valueOf(i9));
                    } else {
                        String[] split4 = str39.split(",");
                        Object[] objArr4 = new Object[1];
                        objArr4[0] = Integer.valueOf(split4 == null ? -1 : split4.length);
                        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", objArr4);
                        if (split4 == null || split4.length != 3) {
                            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", Integer.valueOf(i9));
                        } else {
                            try {
                                arrayList.add(new ag.c(split4[0], Util.getInt(split4[1], 0), split4[2]));
                            } catch (Exception e8) {
                                Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", Integer.valueOf(i9), e8.getMessage());
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 17, 1, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4017, str39);
                            }
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 18, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4018, String.format("%s|%s|%s", str36, str37, str38));
                    AppMethodBeat.o(20312);
                    return null;
                }
                boolean z3 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0;
                boolean a7 = ag.a(MMApplicationContext.getContext(), arrayList, z3);
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", Integer.valueOf(arrayList.size()), Boolean.valueOf(z3), Boolean.valueOf(a7), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (!a7) {
                    bg.aVD().setInt(46, 4);
                    lg lgVar = new lg();
                    lgVar.dQw.dQx = str37;
                    lgVar.dQw.url = str38;
                    EventCenter.instance.publish(lgVar);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 20, 1, true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4020, String.format("%s|%s|%s", str36, str37, str38));
                } else {
                    bg.aVD().setInt(46, 0);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 19, 1, true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4019, String.format("%s|%s|%s", str36, str37, str38));
                }
                AppMethodBeat.o(20312);
                return null;
            } else if (str == null || !str.equals("qy_status_notify")) {
                if (str != null && str.equals("qy_chat_update")) {
                    e.n(map.get(".sysmsg.brand_username"), map.get(".sysmsg.chat_id"), map.get(".sysmsg.ver"));
                }
                if (str == null || !str.equals("bindmobiletip")) {
                    if (str != null && str.equals("ClientCheckConsistency")) {
                        cvd cvd = new cvd();
                        cvd.xuz = map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                        cvd.MAA = Util.getInt(map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                        cvd.MAB = Util.getInt(map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                        cvd.KXP = Util.getInt(map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                        cvd.MAC = k(cvd.xuz, (long) cvd.MAA, (long) cvd.MAB);
                        cvd.FileSize = (int) HN(cvd.xuz);
                        cvd.MAD = com.tencent.mm.plugin.normsg.a.d.INSTANCE.exH() ? 1 : 0;
                        cvd.Llx = ab.ape();
                        cvd.MAE = g(cvd.xuz, Integer.valueOf(cvd.MAA), Integer.valueOf(cvd.MAB), Integer.valueOf(cvd.KXP), cvd.MAC, Integer.valueOf(cvd.FileSize), Integer.valueOf(cvd.MAD), Integer.valueOf(cvd.Llx));
                        bg.aVF();
                        c.aSM().d(new k.a(61, cvd));
                    }
                    if (str != null && str.equals("ClientCheckHook")) {
                        cvf cvf = new cvf();
                        cvf.KXP = Util.getInt(map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                        cvf.MAG = com.tencent.mm.plugin.normsg.a.d.INSTANCE.sv(false);
                        cvf.MAD = com.tencent.mm.plugin.normsg.a.d.INSTANCE.exH() ? 1 : 0;
                        cvf.Llx = ab.ape();
                        cvf.MAE = g(Integer.valueOf(cvf.KXP), cvf.MAG, Integer.valueOf(cvf.MAD), Integer.valueOf(cvf.Llx));
                        bg.aVF();
                        c.aSM().d(new k.a(62, cvf));
                    }
                    if (str != null && str.equals("ClientCheckGetAppList")) {
                        cve cve = new cve();
                        cve.KXP = Util.getInt(map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                        cve.MAF = com.tencent.mm.plugin.normsg.a.d.INSTANCE.exG();
                        cve.MAD = com.tencent.mm.plugin.normsg.a.d.INSTANCE.exH() ? 1 : 0;
                        cve.Llx = ab.ape();
                        cve.MAE = g(Integer.valueOf(cve.KXP), cve.MAF, Integer.valueOf(cve.MAD), Integer.valueOf(cve.Llx));
                        bg.aVF();
                        c.aSM().d(new k.a(63, cve));
                    }
                    if (str != null && str.equals("ClientCheckGetExtInfo")) {
                        ThreadPool.postAtFront(new Runnable() {
                            /* class com.tencent.mm.model.f.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(20307);
                                int i2 = Util.getInt((String) map.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                                if (Util.getInt((String) map.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0) {
                                    com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.ik(i2, 0);
                                    AppMethodBeat.o(20307);
                                    return;
                                }
                                com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.ik(i2, 63);
                                AppMethodBeat.o(20307);
                            }
                        }, "syscmd_rpt_cc");
                    }
                    if (!Util.isNullOrNil(str) && str.equals("functionmsg")) {
                        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                        ((y) g.ah(y.class)).getReceiver().a(deVar, map);
                    }
                    if (!Util.isNullOrNil(str) && str.equals("paymsg")) {
                        int i10 = Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), 0);
                        String str40 = map.get(".sysmsg.paymsg.appmsgcontent");
                        String str41 = map.get(".sysmsg.paymsg.fromusername");
                        String str42 = map.get(".sysmsg.paymsg.tousername");
                        String str43 = map.get(".sysmsg.paymsg.paymsgid");
                        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", Integer.valueOf(i10), Long.valueOf(deVar.Brn), str41, str42, str43, str40);
                        try {
                            String decode = URLDecoder.decode(str40, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                            if (!Util.isNullOrNil(decode)) {
                                qq qqVar = new qq();
                                qqVar.dXe.type = i10;
                                qqVar.dXe.content = decode;
                                qqVar.dXe.dRL = str41;
                                qqVar.dXe.toUser = str42;
                                qqVar.dXe.dXf = str43;
                                EventCenter.instance.publish(qqVar);
                            }
                        } catch (Exception e9) {
                            Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e9, "", new Object[0]);
                            Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", e9.getMessage());
                        }
                    }
                    AppMethodBeat.o(20312);
                    return bVar;
                }
                int i11 = Util.getInt(map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                String nullAsNil = Util.nullAsNil(map.get(".sysmsg.bindmobiletip.deviceid"));
                String nullAsNil2 = Util.nullAsNil(map.get(".sysmsg.bindmobiletip.wording"));
                String str44 = new String(Base64.decode(nullAsNil.getBytes(), 0));
                String str45 = new String(com.tencent.mm.bw.b.cD(q.aoG().getBytes()).aiU(16).zy);
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", Integer.valueOf(i11), str44, str45, nullAsNil2);
                if (Util.isNullOrNil(str44) || str44.equals(str45)) {
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.TRUE);
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(i11 == 1));
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, nullAsNil2);
                }
                AppMethodBeat.o(20312);
                return null;
            } else {
                String str46 = map.get(".sysmsg.chat_id");
                map.get(".sysmsg.last_create_time");
                String str47 = map.get(".sysmsg.brand_username");
                long NM = e.NM(str46);
                if (NM == -1) {
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", str46);
                    AppMethodBeat.o(20312);
                    return null;
                }
                int i12 = com.tencent.mm.al.ag.bak().Al(NM).field_newUnReadCount;
                com.tencent.mm.al.ag.bak().An(NM);
                com.tencent.mm.al.a.c bs = com.tencent.mm.al.ag.baj().bs(NM);
                bg.aVF();
                az bjY2 = c.aST().bjY(str47);
                if (bjY2 == null) {
                    Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", str47);
                    AppMethodBeat.o(20312);
                    return null;
                } else if (bs.iE(1)) {
                    if (bjY2.ajH() <= i12) {
                        bjY2.nz(0);
                        bg.aVF();
                        c.aST().a(bjY2, str47);
                        bg.getNotification().cancelNotification(str47);
                    } else {
                        bjY2.nz(bjY2.ajH() - i12);
                        bg.aVF();
                        c.aST().a(bjY2, str47);
                    }
                    AppMethodBeat.o(20312);
                    return null;
                } else {
                    if (bjY2.ajG() <= i12) {
                        bg.aVF();
                        c.aST().bka(str47);
                        bg.getNotification().cancelNotification(str47);
                    } else {
                        bjY2.ny(0);
                        bjY2.nB(0);
                        bjY2.nt(bjY2.ajG() - i12);
                        bg.aVF();
                        c.aST().a(bjY2, str47);
                    }
                    AppMethodBeat.o(20312);
                    return null;
                }
            }
        } else {
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
            String str48 = map.get(".sysmsg.clouddelmsg.delcommand");
            String str49 = map.get(".sysmsg.clouddelmsg.msgid");
            String str50 = map.get(".sysmsg.clouddelmsg.fromuser");
            int indexOf = a2.indexOf("<msg>");
            int indexOf2 = a2.indexOf("</msg>");
            if (indexOf == -1 || indexOf2 == -1) {
                str4 = "";
            } else {
                str4 = SemiXml.encode(XmlParser.parseXml(a2.substring(indexOf, indexOf2 + 6), "msg", null));
            }
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", str48, str49, str50, str4);
            try {
                bg.aVF();
                LinkedList<ca> iJ = c.aSQ().iJ(str50, str49);
                if (iJ == null || iJ.size() <= 0) {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                    AppMethodBeat.o(20312);
                    return null;
                }
                Iterator<ca> it = iJ.iterator();
                while (it.hasNext()) {
                    ca next = it.next();
                    if (next == null) {
                        Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                    } else if (next.ajM() < 0) {
                        Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", Long.valueOf(next.ajL()), Long.valueOf(next.ajM()));
                    } else {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", Long.valueOf(next.ajL()), Long.valueOf(next.ajM()));
                        ca aZ2 = ca.aZ(next);
                        int i13 = Util.getInt(str48, 0);
                        if (i13 == 1) {
                            bg.aVF();
                            c.aSQ().aT(next.ajO(), next.ajM());
                        } else if (i13 == 2 && next.gAt()) {
                            next.setContent(str4);
                            bp.a(next, aVar);
                            bg.aVF();
                            c.aSQ().b(next.ajM(), next);
                            bg.aVF();
                            az bjY3 = c.aST().bjY(next.ajO());
                            if (bjY3 != null && bjY3.ajG() > 0) {
                                bg.aVF();
                                if (bjY3.ajG() >= c.aSQ().aB(next)) {
                                    bjY3.nt(bjY3.ajG() - 1);
                                    bg.aVF();
                                    c.aST().a(bjY3, bjY3.getUsername());
                                }
                            }
                        }
                        sw swVar2 = new sw();
                        swVar2.dZp.msgId = next.ajL();
                        swVar2.dZp.dZq = str4;
                        swVar2.dZp.dTX = next;
                        EventCenter.instance.publish(swVar2);
                        if (aa.i(aZ2)) {
                            nv nvVar2 = new nv();
                            nvVar2.dTW.dTX = aZ2;
                            EventCenter.instance.publish(nvVar2);
                        }
                    }
                }
                AppMethodBeat.o(20312);
                return null;
            } catch (Exception e10) {
                Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e10, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", str49, e10.toString());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008c A[SYNTHETIC, Splitter:B:35:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0091 A[SYNTHETIC, Splitter:B:38:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009d A[SYNTHETIC, Splitter:B:44:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a2 A[SYNTHETIC, Splitter:B:47:0x00a2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String k(java.lang.String r11, long r12, long r14) {
        /*
        // Method dump skipped, instructions count: 191
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.f.k(java.lang.String, long, long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A[SYNTHETIC, Splitter:B:22:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[SYNTHETIC, Splitter:B:28:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long HN(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.f.HN(java.lang.String):long");
    }

    private static String g(Object... objArr) {
        AppMethodBeat.i(20315);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    byteArrayOutputStream.write(((String) obj).getBytes());
                } else if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    for (int i2 = 0; i2 < 4; i2++) {
                        byteArrayOutputStream.write(intValue & 255);
                        intValue >>= 8;
                    }
                } else if (obj instanceof Long) {
                    long longValue = ((Long) obj).longValue();
                    for (int i3 = 0; i3 < 8; i3++) {
                        byteArrayOutputStream.write((int) (255 & longValue));
                        longValue >>= 8;
                    }
                } else if (obj instanceof Boolean) {
                    byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 0);
                } else {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", obj);
                    AppMethodBeat.o(20315);
                    return "";
                }
            }
            String encodeHexString = Util.encodeHexString(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
            AppMethodBeat.o(20315);
            return encodeHexString;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e2, "", new Object[0]);
            AppMethodBeat.o(20315);
            return "";
        }
    }
}
