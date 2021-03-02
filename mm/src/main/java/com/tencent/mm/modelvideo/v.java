package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.an.c;
import com.tencent.mm.an.f;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class v implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        String str;
        int i2;
        int i3;
        boolean z;
        AppMethodBeat.i(127030);
        de deVar = aVar.heO;
        if (deVar == null) {
            Log.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            AppMethodBeat.o(127030);
            return null;
        }
        String str2 = (String) g.aAh().azQ().get(2, "");
        String a2 = z.a(deVar.KHm);
        String a3 = z.a(deVar.KHl);
        boolean z2 = ((l) g.af(l.class)).aSW().has(a3) || str2.equals(a3);
        Log.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", a3, a2, str2, Boolean.valueOf(z2));
        i eiy = ((l) g.af(l.class)).eiy();
        if (str2.equals(a3)) {
            str = a2;
        } else {
            str = a3;
        }
        ca aJ = eiy.aJ(str, deVar.Brn);
        Log.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", Long.valueOf(deVar.Brn), Long.valueOf(aJ.field_msgId), Integer.valueOf(aJ.field_flag), Long.valueOf(aJ.field_msgSeq), aVar);
        if (aJ.field_msgId != 0 && aJ.field_createTime + 604800000 < bp.C(a3, (long) deVar.CreateTime)) {
            Log.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(deVar.Brn), Long.valueOf(aJ.field_msgId));
            bp.Ad(aJ.field_msgId);
            aJ.setMsgId(0);
        }
        if (aJ.field_msgId != 0) {
            Log.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", Long.valueOf(deVar.Brn));
            AppMethodBeat.o(127030);
            return null;
        }
        String a4 = z.a(deVar.KHn);
        final s sVar = new s();
        if (z2) {
            a3 = a2;
        }
        sVar.dWq = a3;
        sVar.createTime = (long) deVar.CreateTime;
        sVar.dTS = deVar.Brn;
        sVar.jst = deVar.KHn.MTo;
        Log.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", a4, deVar.KHq);
        Map<String, String> parseXml = XmlParser.parseXml(a4, "msg", null);
        if (parseXml == null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 216, 1, false);
            AppMethodBeat.o(127030);
            return null;
        }
        ca caVar = new ca();
        caVar.BB(deVar.KHq);
        bp.b Ky = bp.Ky(deVar.KHq);
        if (Ky != null) {
            caVar.CH(Ky.iEs);
            caVar.nM(Ky.iEt);
        }
        try {
            sVar.iKP = Util.getInt(parseXml.get(".msg.videomsg.$length"), 0);
            sVar.iFw = Util.getInt(parseXml.get(".msg.videomsg.$playlength"), 0);
            Log.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", Integer.valueOf(sVar.iKP), Integer.valueOf(sVar.iFw));
            sVar.jsh = parseXml.get(".msg.videomsg.$fromusername");
            if (str2.equals(sVar.bhs())) {
                sVar.jsh = a2;
            }
            sVar.ean = parseXml.get(".msg.statextstr");
            String str3 = parseXml.get(".msg.videomsg.$cdnthumbaeskey");
            final String str4 = parseXml.get(".msg.videomsg.$cdnthumburl");
            final int i4 = Util.getInt(parseXml.get(".msg.videomsg.$cdnthumblength"), 0);
            String str5 = parseXml.get(".msg.videomsg.$tpvideourl");
            final String str6 = parseXml.get(".msg.videomsg.$tpthumburl");
            String str7 = parseXml.get(".msg.videomsg.$tpauthkey");
            String str8 = parseXml.get(".msg.videomsg.$tpthumbaeskey");
            final int i5 = Util.getInt(parseXml.get(".msg.videomsg.$tpthumblength"), 0);
            int i6 = Util.getInt(parseXml.get(".msg.videomsg.$type"), 0);
            Log.d("MicroMsg.VideoMsgExtension", "video msg exportType :".concat(String.valueOf(i6)));
            if (i6 == 44) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            sVar.jsr = i2;
            if (62 == deVar.xKb) {
                sVar.jsu = 3;
            } else if (i6 > 0) {
                sVar.jsu = 2;
            } else {
                sVar.jsu = 1;
            }
            sVar.a(Util.nullAs(parseXml.get(".msg.streamvideo.streamvideourl"), ""), Util.getInt(parseXml.get(".msg.streamvideo.streamvideototaltime"), 0), Util.nullAs(parseXml.get(".msg.streamvideo.streamvideotitle"), ""), Util.nullAs(parseXml.get(".msg.streamvideo.streamvideowording"), ""), Util.nullAs(parseXml.get(".msg.streamvideo.streamvideoweburl"), ""), Util.nullAs(parseXml.get(".msg.streamvideo.streamvideoaduxinfo"), ""), Util.nullAs(parseXml.get(".msg.streamvideo.streamvideopublishid"), ""));
            if (sVar.bhs().equals((String) g.aAh().azQ().get(2, ""))) {
                AppMethodBeat.o(127030);
                return null;
            }
            String str9 = parseXml.get(".msg.commenturl");
            Map<String, String> parseXml2 = XmlParser.parseXml(a4, "msgoperation", null);
            if (parseXml2 != null) {
                caVar.CI(parseXml2.get(".msgoperation.expinfo.expidstr"));
                caVar.nL(Util.getInt(parseXml2.get(".msgoperation.sightmsg.downloadcontroltype"), 0));
                Log.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", caVar.fRa, Integer.valueOf(caVar.fRb));
            }
            String Qv = t.Qv(sVar.bhs());
            sVar.fileName = Qv;
            caVar.yF(sVar.dTS);
            caVar.Cz(sVar.getFileName());
            caVar.setCreateTime(bp.C(sVar.getUser(), sVar.createTime));
            caVar.Cy(sVar.getUser());
            caVar.setStatus(deVar.oTW);
            caVar.nv(z2 ? 1 : 0);
            if (deVar.xKb == 62) {
                caVar.setType(62);
            } else {
                caVar.setType(43);
            }
            caVar.setContent(q.b(sVar.bhs(), 0, false));
            caVar.CA(a4);
            caVar.CG(str9);
            caVar.BB(deVar.KHq);
            bp.a(caVar, aVar);
            long x = bp.x(caVar);
            if (x <= 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 215, 1, false);
                Log.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", Long.valueOf(x), Long.valueOf(sVar.dTS));
                AppMethodBeat.o(127030);
                return null;
            }
            sVar.jso = (int) x;
            sVar.jsm = Util.nowSecond();
            sVar.jsp = 0;
            sVar.status = 111;
            Log.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + sVar.getFileName() + "] size:" + sVar.iKP + " svrid:" + sVar.dTS + " timelen:" + sVar.iFw + " user:" + sVar.getUser() + " human:" + sVar.bhs());
            if (!o.bhj().b(sVar)) {
                Log.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + sVar.getFileName());
                AppMethodBeat.o(127030);
                return null;
            }
            o.bhj();
            final String Qx = t.Qx(Qv);
            byte[] a5 = z.a(deVar.KHp);
            Log.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", Integer.valueOf(Util.getLength(a5)));
            if (ac.jOI) {
                Log.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                a5 = null;
            }
            if (!Util.isNullOrNil(a5)) {
                t.a(Qx, 0, a5);
            } else if (!Util.isNullOrNil(str5)) {
                final long j2 = sVar.dTS;
                Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j2), sVar.getUser(), str6, Qx);
                final long nowMilliSecond = Util.nowMilliSecond();
                final String str10 = Qx + ".tmp";
                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                gVar.taskName = "task_VideoMsgExtension_1";
                gVar.field_mediaId = c.a("downvideothumb", sVar.createTime, sVar.getUser(), String.valueOf(j2));
                gVar.field_fullpath = str10;
                gVar.field_fileType = 19;
                gVar.field_aesKey = str8;
                gVar.field_authKey = str7;
                gVar.gqB = str6;
                gVar.gqy = new g.a() {
                    /* class com.tencent.mm.modelvideo.v.AnonymousClass1 */

                    @Override // com.tencent.mm.i.g.a
                    public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                        AppMethodBeat.i(127028);
                        int a2 = v.a(i2, dVar, j2, sVar, Qx, str6, i5, str10, nowMilliSecond);
                        AppMethodBeat.o(127028);
                        return a2;
                    }

                    @Override // com.tencent.mm.i.g.a
                    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                    }

                    @Override // com.tencent.mm.i.g.a
                    public final byte[] f(String str, byte[] bArr) {
                        return new byte[0];
                    }
                };
                f.baQ().b(gVar, -1);
            } else {
                final long j3 = sVar.dTS;
                Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j3), sVar.getUser(), str4, Qx);
                final long nowMilliSecond2 = Util.nowMilliSecond();
                final String str11 = Qx + ".tmp";
                com.tencent.mm.i.g gVar2 = new com.tencent.mm.i.g();
                gVar2.taskName = "task_VideoMsgExtension_2";
                gVar2.field_mediaId = c.a("downvideothumb", sVar.createTime, sVar.getUser(), String.valueOf(j3));
                gVar2.field_fullpath = str11;
                gVar2.field_fileType = a.MediaType_THUMBIMAGE;
                gVar2.field_totalLen = i4;
                gVar2.field_aesKey = str3;
                gVar2.field_fileId = str4;
                gVar2.field_priority = a.gpN;
                gVar2.field_chattype = ab.Eq(sVar.getUser()) ? 1 : 0;
                Log.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", Integer.valueOf(gVar2.field_chattype), sVar.getUser());
                gVar2.gqy = new g.a() {
                    /* class com.tencent.mm.modelvideo.v.AnonymousClass2 */

                    @Override // com.tencent.mm.i.g.a
                    public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
                        AppMethodBeat.i(127029);
                        int a2 = v.a(i2, dVar, j3, sVar, Qx, str4, i4, str11, nowMilliSecond2);
                        AppMethodBeat.o(127029);
                        return a2;
                    }

                    @Override // com.tencent.mm.i.g.a
                    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                    }

                    @Override // com.tencent.mm.i.g.a
                    public final byte[] f(String str, byte[] bArr) {
                        return null;
                    }
                };
                f.baQ().b(gVar2, -1);
            }
            if (caVar.cWL()) {
                com.tencent.mm.modelcontrol.d.baW();
                if (caVar.fRb == 1) {
                    z = true;
                } else if (caVar.fRb == 2) {
                    z = false;
                } else if (!com.tencent.mm.modelcontrol.d.T(caVar)) {
                    Log.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
                    z = false;
                } else {
                    String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("C2CSightNotAutoDownloadTimeRange");
                    Log.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: ".concat(String.valueOf(value)));
                    if (b.Of(value)) {
                        Log.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
                        z = false;
                    } else {
                        String str12 = caVar.field_talker;
                        Log.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: ".concat(String.valueOf(str12)));
                        int i7 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("SIGHTSessionAutoLoadNetwork"), 1);
                        if (i7 == 3) {
                            Log.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
                            z = false;
                        } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                            Log.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId), caVar.field_imgPath);
                            as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str12);
                            if (Kn == null || ((int) Kn.gMZ) <= 0 || ((!ab.Eq(str12) || Kn.fuH != 0) && !Kn.Zx())) {
                                z = true;
                            } else {
                                Log.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
                                z = false;
                            }
                        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                            Log.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId), caVar.field_imgPath);
                            z = false;
                        } else {
                            as Kn2 = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(caVar.field_talker);
                            if (ab.Eq(caVar.field_talker)) {
                                if (Kn2.fuH == 0) {
                                    Log.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId), caVar.field_imgPath);
                                    z = false;
                                } else if ((NetStatusUtil.is3G(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext())) && i7 == 1) {
                                    Log.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId), caVar.field_imgPath);
                                    z = true;
                                } else {
                                    Log.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
                                    z = false;
                                }
                            } else if (Kn2.Zx()) {
                                Log.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId), caVar.field_imgPath);
                                z = false;
                            } else if ((NetStatusUtil.is3G(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext())) && i7 == 1) {
                                Log.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId), caVar.field_imgPath);
                                z = true;
                            } else {
                                Log.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
                                z = false;
                            }
                        }
                    }
                }
                if (z) {
                    u.QI(caVar.field_imgPath);
                    f.baQ().iRE.add("video_" + caVar.field_msgId);
                }
            }
            int i8 = 1;
            if (ab.Eq(sVar.getUser())) {
                int Ie = com.tencent.mm.model.v.Ie(sVar.getUser());
                if (ab.JJ(sVar.getUser()) || !ab.JI(sVar.getUser())) {
                    i8 = 2;
                    i3 = Ie;
                } else {
                    i8 = 3;
                    i3 = Ie;
                }
            } else {
                i3 = 0;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14388, Long.valueOf(caVar.field_msgSvrId), Integer.valueOf(i8), "", Integer.valueOf(i3));
            i bhl = o.bhl();
            synchronized (bhl.jra) {
                try {
                    bhl.jra.offerFirst(caVar);
                } catch (Throwable th) {
                    AppMethodBeat.o(127030);
                    throw th;
                }
            }
            bhl.startDownload();
            h.b bVar = new h.b(caVar, true);
            AppMethodBeat.o(127030);
            return bVar;
        } catch (Exception e2) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 216, 1, false);
            Log.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
            Log.e("MicroMsg.VideoMsgExtension", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(127030);
            return null;
        }
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
        AppMethodBeat.i(127031);
        ca caVar = cVar.dTX;
        if (caVar == null) {
            AppMethodBeat.o(127031);
            return;
        }
        u.QM(caVar.field_imgPath);
        AppMethodBeat.o(127031);
    }

    public static int a(int i2, d dVar, long j2, s sVar, String str, String str2, int i3, String str3, long j3) {
        String str4;
        s Qq;
        AppMethodBeat.i(127032);
        if (i2 != 0) {
            Log.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i2), Long.valueOf(j2), sVar.getUser(), str2, str);
            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(i2), 2, Long.valueOf(j3), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(a.MediaType_THUMBIMAGE), Integer.valueOf(i3), "")).bfK();
            AppMethodBeat.o(127032);
            return i2;
        } else if (dVar == null) {
            AppMethodBeat.o(127032);
            return 0;
        } else {
            if (dVar.field_retCode != 0) {
                Log.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(dVar.field_retCode), Long.valueOf(j2), sVar.getUser(), str2, str);
            } else {
                new o(str3).am(new o(str));
                Log.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j2), sVar.getUser(), str2, str);
                if (sVar.jsu == 3) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 6, (long) i3, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 7, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, ab.Eq(sVar.getUser()) ? 9 : 8, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 11, (long) i3, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, 12, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(198, ab.Eq(sVar.getUser()) ? 14 : 13, 1, false);
                }
            }
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(dVar == null ? -1 : dVar.field_retCode);
            objArr[1] = 2;
            objArr[2] = Long.valueOf(j3);
            objArr[3] = Long.valueOf(Util.nowMilliSecond());
            objArr[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
            objArr[5] = Integer.valueOf(a.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(i3);
            objArr[7] = dVar == null ? "" : dVar.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            if (dVar == null) {
                str4 = "";
            } else {
                str4 = dVar.gqk;
            }
            objArr[15] = str4;
            new y(com.tencent.mm.plugin.report.a.t(objArr)).bfK();
            if (!(dVar == null || dVar.field_retCode == 0)) {
                Object[] objArr2 = new Object[16];
                objArr2[0] = Integer.valueOf(dVar == null ? -1 : dVar.field_retCode);
                objArr2[1] = 2;
                objArr2[2] = Long.valueOf(j3);
                objArr2[3] = Long.valueOf(Util.nowMilliSecond());
                objArr2[4] = Integer.valueOf(c.cY(MMApplicationContext.getContext()));
                objArr2[5] = Integer.valueOf(a.MediaType_THUMBIMAGE);
                objArr2[6] = Integer.valueOf(i3);
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
            t bhj = o.bhj();
            String fileName = sVar.getFileName();
            t.a.c cVar = t.a.c.NORMAL;
            if (!Util.isNullOrNil(fileName) && (Qq = bhj.Qq(fileName)) != null) {
                bhj.iKx.event(new t.a.C0460a(Qq.getFileName(), t.a.b.UPDATE, cVar, Qq.jsu, Qq.jqz));
                bhj.iKx.doNotify();
            }
            AppMethodBeat.o(127032);
            return 0;
        }
    }
}
