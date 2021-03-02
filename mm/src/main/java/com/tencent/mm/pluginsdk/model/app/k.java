package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.t;
import com.tencent.mm.ag.y;
import com.tencent.mm.ak.h;
import com.tencent.mm.av.q;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.g;
import com.tencent.mm.g.a.ze;
import com.tencent.mm.g.a.zf;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.live.b.c.b;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Random;

public final class k implements h {

    public interface a {
        void gmY();
    }

    public static String mx(String str, String str2) {
        int Kp;
        AppMethodBeat.i(31008);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(31008);
            return null;
        }
        if (ab.Eq(str) && (Kp = bp.Kp(str2)) != -1) {
            str2 = (str2 + " ").substring(Kp + 2).trim();
        }
        String processXml = Util.processXml(str2);
        AppMethodBeat.o(31008);
        return processXml;
    }

    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        String str;
        StringBuilder sb;
        String str2;
        String sb2;
        String str3;
        y yVar;
        y yVar2;
        AppMethodBeat.i(31009);
        Log.d("MicroMsg.AppMessageExtension", "process add app message");
        de deVar = aVar.heO;
        String a2 = z.a(deVar.KHl);
        String a3 = z.a(deVar.KHm);
        if (Util.isNullOrNil(a2) || Util.isNullOrNil(a3)) {
            Log.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
            str = null;
        } else {
            str = mx(a2, z.a(deVar.KHn));
        }
        k.b HD = k.b.HD(str);
        if (HD == null) {
            Log.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
            AppMethodBeat.o(31009);
            return null;
        } else if (HD.iyx) {
            bg.aVF();
            c.azQ().set(352273, str);
            bg.aVF();
            c.azQ().set(352274, Long.valueOf(System.currentTimeMillis()));
            new b(str).gmP();
            AppMethodBeat.o(31009);
            return null;
        } else {
            g bdG = ao.eAS().bdG(HD.appId);
            Object[] objArr = new Object[3];
            objArr[0] = HD.appId;
            objArr[1] = Integer.valueOf(HD.appVersion);
            objArr[2] = bdG == null ? BuildConfig.COMMAND : Integer.valueOf(bdG.field_appVersion);
            Log.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", objArr);
            if (bdG == null || bdG.field_appVersion < HD.appVersion) {
                ao.eAR().bdF(HD.appId);
            }
            h.b a4 = a(aVar, z.a(deVar.KHn), HD);
            if (a4.dCM == null) {
                AppMethodBeat.o(31009);
                return null;
            }
            ca caVar = a4.dCM;
            if (caVar.gAt()) {
                AppMethodBeat.o(31009);
                return a4;
            } else if (caVar.getType() == 301989937) {
                AppMethodBeat.o(31009);
                return a4;
            } else {
                if (caVar.getType() == -1879048190) {
                    zf zfVar = new zf();
                    zfVar.efq.xml = str;
                    zfVar.efq.description = HD.description;
                    zfVar.efq.dCM = caVar;
                    EventCenter.instance.publish(zfVar);
                }
                if (caVar.getType() == 49 && !Util.isNullOrNil(HD.canvasPageXml)) {
                    g gVar = new g();
                    gVar.dBU.dBV = HD.canvasPageXml;
                    EventCenter.instance.publish(gVar);
                }
                if (caVar.cWK()) {
                    String str4 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
                    String a5 = z.a(deVar.KHm);
                    String a6 = z.a(deVar.KHl);
                    boolean z = ((l) com.tencent.mm.kernel.g.af(l.class)).aSW().has(a6) || str4.equals(a6);
                    s sVar = new s();
                    if (z) {
                        str3 = a5;
                    } else {
                        str3 = a6;
                    }
                    sVar.dWq = str3;
                    sVar.jsh = a6;
                    sVar.createTime = (long) deVar.CreateTime;
                    sVar.dTS = deVar.Brn;
                    sVar.jst = deVar.KHn.MTo;
                    sVar.jso = (int) caVar.field_msgId;
                    if (caVar.gDd()) {
                        yVar2 = new y().a(caVar.OqD);
                    } else {
                        k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
                        if (aD == null) {
                            Log.w("MicroMsg.AppMessageExtension", "getVideoInfo content is null");
                            yVar2 = null;
                        } else {
                            e eVar = (e) aD.as(e.class);
                            if (eVar == null || eVar.iwi == null) {
                                yVar = null;
                            } else {
                                yVar = eVar.iwi;
                            }
                            yVar2 = yVar;
                        }
                    }
                    if (yVar2 != null) {
                        sVar.fileName = caVar.field_imgPath;
                        sVar.a(yVar2.videoUrl, yVar2.videoDuration, yVar2.title, yVar2.KOe, "", "", "");
                        sVar.status = 111;
                    }
                    o.bhj().b(sVar);
                }
                if (HD.type == 53) {
                    Log.i("MicroMsg.AppMessageExtension", "process MM_APP_SOLITAIRE_TEXT");
                    String str5 = deVar.KHr;
                    String str6 = HD.title;
                    if (Util.isNullOrNil(str5)) {
                        sb2 = "";
                    } else {
                        String processXml = Util.processXml(str5);
                        if (Util.isNullOrNil(processXml)) {
                            sb2 = "";
                        } else {
                            int indexOf = processXml.indexOf("<pushcontent");
                            StringBuilder sb3 = new StringBuilder();
                            if (indexOf > 0) {
                                str2 = processXml.substring(indexOf);
                                sb = sb3.append(processXml.substring(0, indexOf));
                            } else {
                                sb = sb3;
                                str2 = processXml;
                            }
                            Map<String, String> parseXml = XmlParser.parseXml(str2, "pushcontent", null);
                            if (parseXml == null) {
                                Log.e("MicroMsg.AppMessageExtension", "inval xml");
                                sb2 = str5;
                            } else {
                                String str7 = parseXml.get(".pushcontent.$nickname");
                                sb.append("<pushcontent content=\"").append(str7).append(" : ").append(str6).append("\"nickname=\"").append(str7).append("\" />\n");
                                sb2 = sb.toString();
                            }
                        }
                    }
                    deVar.KHr = sb2;
                    String Ks = bp.Ks(caVar.field_content);
                    if (Ks == null || Ks.length() <= 0) {
                        Ks = "";
                    }
                    if (aVar.iLV) {
                        ((j) com.tencent.mm.kernel.g.af(j.class)).b(z.a(deVar.KHl), Ks, HD.title, (String) HD.izx.second, caVar.field_msgId, caVar.field_createTime / 1000);
                    } else {
                        ((j) com.tencent.mm.kernel.g.af(j.class)).a(z.a(deVar.KHl), Ks, HD.title, (String) HD.izx.second, caVar.field_msgId, caVar.field_createTime / 1000);
                    }
                } else if (HD.type == 57) {
                    Log.i("MicroMsg.AppMessageExtension", "process MM_APP_MSG_QUOTE");
                    ((com.tencent.mm.plugin.msgquote.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.msgquote.a.class)).handleReceivedQuoteMsg(caVar.field_msgId, caVar.field_msgSvrId, caVar.field_talker, HD.izy.zFI);
                } else if (HD.type == 60) {
                    String str8 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
                    String a7 = z.a(deVar.KHl);
                    boolean z2 = ((l) com.tencent.mm.kernel.g.af(l.class)).aSW().has(a7) || str8.equals(a7);
                    String str9 = z2 ? str8 : HD.dRL;
                    Log.i("MicroMsg.AppMessageExtension", "process MM_APP_MMLIVE_SHARE, isSender%b, anchor:%s", Boolean.valueOf(z2), str9);
                    if (!z2) {
                        com.tencent.mm.live.b.y yVar3 = (com.tencent.mm.live.b.y) HD.as(com.tencent.mm.live.b.y.class);
                        long parseLong = Long.parseLong(yVar3.hJs);
                        String str10 = yVar3.hwb;
                        String str11 = yVar3.thumbUrl;
                        com.tencent.mm.live.b.c.c liveTipsBarStorage = ((com.tencent.mm.live.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
                        Boolean bool = Boolean.FALSE;
                        Log.i("MicroMsg.LiveTipsBarStorage", "addLiveToTipsBar, hostRoomId:%s, liveId:%d", a7, Long.valueOf(parseLong));
                        b bVar = new b();
                        bVar.field_hostRoomId = a7;
                        bVar.field_liveId = parseLong;
                        bVar.field_liveName = str10;
                        bVar.field_thumbUrl = str11;
                        bVar.field_anchorUsername = str9;
                        bVar.field_isSender = bool.booleanValue();
                        bVar.field_timeStamp = (long) deVar.CreateTime;
                        liveTipsBarStorage.a(bVar);
                    }
                }
                if (ab.Ix(caVar.field_talker) && com.tencent.mm.chatroom.d.y.ama()) {
                    ((com.tencent.mm.chatroom.plugin.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.chatroom.plugin.a.class)).handleGroupTodoByReceiverAppMsg(caVar);
                }
                if (ab.Ix(caVar.field_talker) && aa.ame()) {
                    ((com.tencent.mm.chatroom.plugin.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(caVar);
                }
                com.tencent.mm.ag.k kVar = new com.tencent.mm.ag.k();
                HD.a(kVar);
                kVar.field_msgId = caVar.field_msgId;
                if (ao.gnf().GL(caVar.field_msgId) != null || !ao.gnf().insert(kVar)) {
                    AppMethodBeat.o(31009);
                    return null;
                }
                if (HD.type == 40) {
                    c Mp = ao.cgO().Mp(caVar.field_msgId);
                    t HI = t.HI(str);
                    if (Mp == null) {
                        m.a((String) null, caVar.field_msgId, 0, (String) null, (String) null, HI.iAk, HD.type, 0);
                    }
                    bg.azz().a(new f(caVar.field_msgId, caVar.field_msgSvrId, (com.tencent.mm.ak.j) null), 0);
                }
                AppMethodBeat.o(31009);
                return a4;
            }
        }
    }

    static String a(byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.i(232149);
        String a2 = q.bcR().a(bArr, z, Bitmap.CompressFormat.PNG, z2);
        AppMethodBeat.o(232149);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x04ef  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x06df  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x07c4  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x07e3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.ak.h.b a(com.tencent.mm.ak.h.a r23, java.lang.String r24, com.tencent.mm.ag.k.b r25) {
        /*
        // Method dump skipped, instructions count: 2040
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.app.k.a(com.tencent.mm.ak.h$a, java.lang.String, com.tencent.mm.ag.k$b):com.tencent.mm.ak.h$b");
    }

    private static void N(boolean z, String str) {
        AppMethodBeat.i(31012);
        if (!Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", Boolean.valueOf(z), str);
            bg.aVF();
            az bjY = c.aST().bjY(str);
            if (bjY != null) {
                if (z) {
                    bjY.oT(TPMediaCodecProfileLevel.HEVCMainTierLevel62);
                } else {
                    bjY.oU(TPMediaCodecProfileLevel.HEVCMainTierLevel62);
                }
                bg.aVF();
                c.aST().a(bjY, str);
            }
        }
        AppMethodBeat.o(31012);
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
        String str;
        k.b HD;
        String str2 = null;
        AppMethodBeat.i(31013);
        ca caVar = cVar.dTX;
        if (caVar == null) {
            Log.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
            AppMethodBeat.o(31013);
            return;
        }
        Log.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + caVar.field_imgPath);
        ze zeVar = new ze();
        zeVar.efp.path = caVar.field_imgPath;
        EventCenter.instance.publish(zeVar);
        String str3 = caVar.field_content;
        if (str3 == null || (HD = k.b.HD(str3)) == null || HD.type != 6) {
            str = null;
        } else {
            str = com.tencent.mm.loader.j.b.aKM() + HD.title;
            com.tencent.mm.vfs.s.deleteFile(str);
            com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.loader.j.b.aKM() + HD.title + "_tmp");
        }
        c Mp = com.tencent.mm.plugin.r.a.cgO().Mp(caVar.field_msgId);
        if (Mp != null) {
            str2 = Mp.field_fileFullPath;
            com.tencent.mm.vfs.s.deleteFile(str2);
            com.tencent.mm.plugin.r.a.cgO().delete(Mp, "msgInfoId");
        }
        Log.w("MicroMsg.AppMessageExtension", "onPreDelMessage, clean file, %s, %s", str, str2);
        AppMethodBeat.o(31013);
    }

    private boolean a(final long j2, ca caVar, final String str, String str2, final String str3, final int i2, final boolean z, k.b bVar, String str4, boolean z2) {
        AppMethodBeat.i(31014);
        Log.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", Long.valueOf(caVar.field_msgSvrId), str2, Integer.valueOf(i2), str3, str, Boolean.valueOf(z));
        final long nowMilliSecond = Util.nowMilliSecond();
        final int i3 = bVar != null ? bVar.type : 0;
        final String str5 = "wcf://temp/appmsgext-cdnthumb-" + new Random().nextLong();
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.taskName = "task_AppMessageExtension_1";
        gVar.field_mediaId = com.tencent.mm.an.c.a("downappthumb", caVar.field_createTime, str, String.valueOf(j2));
        gVar.field_fullpath = str5;
        if (z2) {
            gVar.field_fileType = 19;
            gVar.gqB = str3;
        } else {
            gVar.field_fileId = str3;
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
        }
        gVar.field_totalLen = i2;
        gVar.field_aesKey = str2;
        gVar.field_priority = com.tencent.mm.i.a.gpN;
        gVar.field_authKey = str4;
        gVar.field_chattype = ab.Eq(str) ? 1 : 0;
        Log.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", Integer.valueOf(gVar.field_chattype), str);
        gVar.gqy = new g.a() {
            /* class com.tencent.mm.pluginsdk.model.app.k.AnonymousClass1 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                String str2;
                long j2;
                AppMethodBeat.i(31005);
                if (i2 != 0) {
                    Log.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", Long.valueOf(j2), Integer.valueOf(i2), str3);
                    new com.tencent.mm.g.b.a.y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 2, Long.valueOf(nowMilliSecond), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(i2), "")).bfK();
                    AppMethodBeat.o(31005);
                    return i2;
                } else if (dVar == null) {
                    AppMethodBeat.o(31005);
                    return 0;
                } else {
                    if (dVar.field_retCode != 0) {
                        Log.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", Long.valueOf(j2), Integer.valueOf(dVar.field_retCode), str3);
                        com.tencent.mm.vfs.s.deleteFile(str5);
                    } else {
                        bg.aVF();
                        ca aJ = c.aSQ().aJ(str, j2);
                        if (aJ.field_msgSvrId != j2) {
                            Log.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", Long.valueOf(j2));
                            AppMethodBeat.o(31005);
                            return 0;
                        }
                        Log.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", Long.valueOf(j2), Integer.valueOf(aJ.getType()));
                        byte[] aW = com.tencent.mm.vfs.s.aW(str5, 0, -1);
                        if (i3 == 33 || i3 == 36 || i3 == 46 || i3 == 44 || i3 == 48) {
                            str2 = q.bcR().a(aW, Bitmap.CompressFormat.JPEG);
                            com.tencent.mm.vfs.s.deleteFile(str5);
                        } else {
                            str2 = k.a(aW, z, aJ.gDo());
                        }
                        if (!Util.isNullOrNil(str2)) {
                            aJ.Cz(str2);
                            bg.aVF();
                            c.aSQ().b(aJ.field_msgSvrId, aJ);
                        }
                        Log.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", Long.valueOf(j2), str, str3, str2);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 16, (long) i2, false);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 17, 1, false);
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        if (ab.Eq(str)) {
                            j2 = 19;
                        } else {
                            j2 = 18;
                        }
                        hVar.idkeyStat(198, j2, 1, false);
                    }
                    Object[] objArr = new Object[16];
                    objArr[0] = Integer.valueOf(dVar == null ? -1 : dVar.field_retCode);
                    objArr[1] = 2;
                    objArr[2] = Long.valueOf(nowMilliSecond);
                    objArr[3] = Long.valueOf(Util.nowMilliSecond());
                    objArr[4] = Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext()));
                    objArr[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
                    objArr[6] = Integer.valueOf(i2);
                    objArr[7] = dVar == null ? "" : dVar.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    objArr[15] = dVar == null ? "" : dVar.gqk;
                    new com.tencent.mm.g.b.a.y(com.tencent.mm.plugin.report.a.t(objArr)).bfK();
                    if (!(dVar == null || dVar.field_retCode == 0)) {
                        Object[] objArr2 = new Object[16];
                        objArr2[0] = Integer.valueOf(dVar == null ? -1 : dVar.field_retCode);
                        objArr2[1] = 2;
                        objArr2[2] = Long.valueOf(nowMilliSecond);
                        objArr2[3] = Long.valueOf(Util.nowMilliSecond());
                        objArr2[4] = Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext()));
                        objArr2[5] = Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE);
                        objArr2[6] = Integer.valueOf(i2);
                        objArr2[7] = dVar == null ? "" : dVar.field_transInfo;
                        objArr2[8] = "";
                        objArr2[9] = "";
                        objArr2[10] = "";
                        objArr2[11] = "";
                        objArr2[12] = "";
                        objArr2[13] = "";
                        objArr2[14] = "";
                        objArr2[15] = dVar == null ? "" : dVar.gqk;
                        new w(com.tencent.mm.plugin.report.a.t(objArr2)).bfK();
                    }
                    q.bcR().doNotify();
                    AppMethodBeat.o(31005);
                    return 0;
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return null;
            }
        };
        com.tencent.mm.an.f.baQ().b(gVar, -1);
        AppMethodBeat.o(31014);
        return true;
    }
}
