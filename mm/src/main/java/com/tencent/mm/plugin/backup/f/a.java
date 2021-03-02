package com.tencent.mm.plugin.backup.f;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.v;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.f.i;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class a implements l {
    @Override // com.tencent.mm.plugin.backup.f.l
    public final int a(is isVar, boolean z, ca caVar, String str, LinkedList<u> linkedList, HashMap<Long, h.a> hashMap, boolean z2, long j2) {
        int length;
        int length2;
        String str2;
        String str3;
        c bdx;
        int indexOf;
        AppMethodBeat.i(21506);
        switch (caVar.getType()) {
            case 1048625:
                if (Util.isNullOrNil(caVar.field_content)) {
                    length = 0;
                } else {
                    length = caVar.field_content.getBytes().length;
                }
                if (caVar.field_content == null) {
                    AppMethodBeat.o(21506);
                    return -1;
                }
                String str4 = caVar.field_content;
                if (!g.agB(str4)) {
                    str4 = caVar.field_content;
                    if (!g.agB(str4)) {
                        Log.e("MicroMsg.BackupItemAppMsg", "get xml error ".concat(String.valueOf(str4)));
                        AppMethodBeat.o(21506);
                        return 0;
                    }
                }
                if (!Util.isNullOrNil(str4)) {
                    dqi dqi = new dqi();
                    dqi.bhy(Util.nullAs(str4, ""));
                    isVar.KHn = dqi;
                }
                AppMethodBeat.o(21506);
                return length;
            case 285212721:
                if (Util.isNullOrNil(caVar.field_content)) {
                    length2 = 0;
                } else {
                    length2 = caVar.field_content.getBytes().length;
                }
                if (z) {
                    AppMethodBeat.o(21506);
                    return length2;
                }
                String agF = C0845a.agF(caVar.field_content);
                if (Util.isNullOrNil(agF)) {
                    AppMethodBeat.o(21506);
                    return 0;
                }
                dqi dqi2 = new dqi();
                dqi2.bhy(Util.nullAs(agF, ""));
                isVar.KHn = dqi2;
                AppMethodBeat.o(21506);
                return length2;
            default:
                int length3 = Util.isNullOrNil(caVar.field_content) ? 0 : caVar.field_content.getBytes().length;
                String str5 = caVar.field_content;
                if (!(caVar.field_isSend == 1 || !com.tencent.mm.plugin.backup.h.c.Eq(caVar.field_talker) || (indexOf = caVar.field_content.indexOf(58)) == -1)) {
                    str5 = caVar.field_content.substring(indexOf + 1);
                }
                String processXml = Util.processXml(str5);
                k.b HD = processXml != null ? k.b.HD(processXml) : null;
                if (HD == null) {
                    Log.e("MicroMsg.BackupItemAppMsg", "content is null");
                    AppMethodBeat.o(21506);
                    return 0;
                }
                Log.d("MicroMsg.BackupItemAppMsg", "content type " + HD.type);
                String R = d.cgP().cgQ().cgM().R(caVar.field_imgPath, true);
                if (s.YS(R)) {
                    length3 += i.a(new i.a(R, isVar, linkedList, 6, z, "_thumb", z2));
                } else if (HD.type == 2) {
                    AppMethodBeat.o(21506);
                    return -1;
                }
                switch (HD.type) {
                    case 2:
                        if (!Util.isNullOrNil(HD.dCK) && (((bdx = d.cgP().cgQ().cgO().bdx(HD.dCK)) != null && bdx.deQ()) || (caVar.field_isSend == 1 && bdx != null && bdx.field_isUpload))) {
                            String str6 = bdx.field_fileFullPath;
                            if (s.YS(str6)) {
                                Log.d("MicroMsg.BackupItemAppMsg", "image ".concat(String.valueOf(str6)));
                                length3 += i.a(new i.a(str6, isVar, linkedList, 8, z, z2, (u) null));
                                break;
                            }
                        }
                        break;
                    case 6:
                        c bdx2 = d.cgP().cgQ().cgO().bdx(HD.dCK);
                        if ((bdx2 != null && bdx2.deQ()) || (caVar.field_isSend == 1 && bdx2 != null && bdx2.field_isUpload)) {
                            Log.d("MicroMsg.BackupItemAppMsg", "full path " + bdx2.field_fileFullPath);
                            if (s.YS(bdx2.field_fileFullPath)) {
                                if (!z) {
                                    if (com.tencent.mm.plugin.backup.b.d.ceP() != 1 || ((long) (HD.iwI / 1024)) < j2 || HD.filemd5 == null) {
                                        length3 += i.a(new i.a(bdx2.field_fileFullPath, isVar, linkedList, 7, z, z2, (u) null));
                                        break;
                                    } else {
                                        if (caVar.field_isSend == 1) {
                                            str2 = str;
                                            str3 = caVar.field_talker;
                                        } else {
                                            str2 = caVar.field_talker;
                                            str3 = str;
                                        }
                                        u uVar = new u();
                                        length3 += i.a(new i.a(bdx2.field_fileFullPath, isVar, linkedList, 7, z, true, uVar));
                                        if (hashMap != null) {
                                            h.a aVar = new h.a();
                                            aVar.oNI = uVar;
                                            aVar.md5 = HD.filemd5;
                                            aVar.oNK = str2 + "_" + str3 + "_" + caVar.field_msgSvrId + "_backup";
                                            aVar.oNJ = caVar.field_msgSvrId;
                                            hashMap.put(Long.valueOf(caVar.field_msgSvrId), aVar);
                                            break;
                                        }
                                    }
                                } else {
                                    length3 += i.a(new i.a(bdx2.field_fileFullPath, isVar, linkedList, 7, z, z2, (u) null));
                                    break;
                                }
                            }
                        }
                        break;
                    case 7:
                        c bdx3 = d.cgP().cgQ().cgO().bdx(HD.dCK);
                        if ((bdx3 != null && bdx3.deQ()) || (caVar.field_isSend == 1 && bdx3 != null && bdx3.field_isUpload)) {
                            Log.d("MicroMsg.BackupItemAppMsg", "full path " + bdx3.field_fileFullPath);
                            if (s.YS(bdx3.field_fileFullPath)) {
                                length3 += i.a(new i.a(bdx3.field_fileFullPath, isVar, linkedList, 7, z, z2, (u) null));
                                break;
                            }
                        }
                        break;
                    case 19:
                    case 24:
                        qg qgVar = new qg();
                        qgVar.dWB.xml = HD.ixl;
                        qgVar.dWB.dFm = caVar.field_msgId;
                        EventCenter.instance.publish(qgVar);
                        Log.i("MicroMsg.BackupItemAppMsg", "pathList:%s", qgVar.dWC.dWD);
                        String[] split = qgVar.dWC.dWD.split(":");
                        for (int i2 = 0; i2 < split.length; i2++) {
                            if (s.YS(split[i2])) {
                                Log.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", split[i2], Integer.valueOf(i2));
                                length3 += i.a(new i.a(split[i2], isVar, linkedList, 7, z, "_fav.".concat(String.valueOf(i2)), z2));
                            }
                        }
                        break;
                }
                AppMethodBeat.o(21506);
                return length3;
        }
    }

    @Override // com.tencent.mm.plugin.backup.f.l
    public final int a(String str, is isVar, ca caVar) {
        String str2;
        int Kr;
        AppMethodBeat.i(21507);
        String str3 = isVar.KHl.MTo;
        String str4 = isVar.KHn.MTo;
        if (str4 == null) {
            AppMethodBeat.o(21507);
            return 0;
        }
        caVar.setContent(str4);
        if (!(caVar.field_isSend == 1 || !com.tencent.mm.plugin.backup.h.c.Eq(str3) || (Kr = com.tencent.mm.plugin.backup.h.c.Kr(isVar.KHn.MTo)) == -1)) {
            str4 = (isVar.KHn.MTo + " ").substring(Kr + 2).trim();
        }
        String processXml = Util.processXml(str4);
        k.b HD = k.b.HD(processXml);
        if (HD == null) {
            Log.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
            AppMethodBeat.o(21507);
            return 0;
        } else if (HD.type == 2000) {
            caVar.setType(419430449);
            com.tencent.mm.plugin.backup.h.c.x(caVar);
            AppMethodBeat.o(21507);
            return 0;
        } else if (HD.type == 19 || HD.type == 24) {
            caVar.setType(m.g(HD));
            com.tencent.mm.plugin.backup.h.c.x(caVar);
            qg qgVar = new qg();
            qgVar.dWB.xml = HD.ixl;
            qgVar.dWB.dFm = caVar.field_msgId;
            EventCenter.instance.publish(qgVar);
            Log.d("MicroMsg.BackupItemAppMsg", "pathList:%s", qgVar.dWC.dWD);
            String[] split = qgVar.dWC.dWD.split(":");
            for (int i2 = 0; i2 < split.length; i2++) {
                String a2 = g.a(isVar, 7, ".".concat(String.valueOf(i2)));
                if (!Util.isNullOrNil(a2)) {
                    Log.d("MicroMsg.BackupItemAppMsg", "record mediaId:%s, index:%d", a2, Integer.valueOf(i2));
                    s.nx(g.agy(a2) + a2, split[i2]);
                }
            }
            AppMethodBeat.o(21507);
            return 0;
        } else {
            com.tencent.mm.pluginsdk.model.app.g gVar = new com.tencent.mm.pluginsdk.model.app.g();
            gVar.field_appId = HD.appId;
            b cgQ = d.cgP().cgQ();
            if (cgQ.uin == 0) {
                com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
                AppMethodBeat.o(21507);
                throw bVar;
            }
            if (cgQ.oQF.get(gVar, new String[0]) && gVar.field_appVersion < HD.appVersion) {
                d.cgP().cgR().i(1, HD.appId);
            }
            caVar.setType(m.g(HD));
            byte[] b2 = g.b(isVar, 6);
            if (b2 != null && caVar.field_msgId == 0) {
                String ap = d.cgP().cgQ().cgM().ap(b2);
                Log.d("MicroMsg.BackupItemAppMsg", "thumbData MsgInfo path:".concat(String.valueOf(ap)));
                if (!Util.isNullOrNil(ap)) {
                    caVar.Cz(ap);
                }
            }
            String a3 = g.a(isVar, 8);
            int c2 = g.c(isVar, 8);
            if (Util.isNullOrNil(a3)) {
                a3 = g.a(isVar, 7);
                c2 = g.c(isVar, 7);
            }
            String str5 = g.agy(a3) + a3;
            com.tencent.mm.plugin.backup.h.c.x(caVar);
            k kVar = new k();
            HD.a(kVar);
            kVar.field_msgId = caVar.field_msgId;
            b cgQ2 = d.cgP().cgQ();
            if (cgQ2.uin == 0) {
                com.tencent.mm.model.b bVar2 = new com.tencent.mm.model.b();
                AppMethodBeat.o(21507);
                throw bVar2;
            }
            cgQ2.oQE.insert(kVar);
            if (!Util.isNullOrNil(a3)) {
                com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ = d.cgP().cgQ().aSQ();
                if (str.equals(isVar.KHl.MTo)) {
                    str2 = isVar.KHm.MTo;
                } else {
                    str2 = isVar.KHl.MTo;
                }
                ca aJ = aSQ.aJ(str2, isVar.Brn);
                c bdx = d.cgP().cgQ().cgO().bdx(HD.dCK);
                if (bdx == null) {
                    Log.d("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
                    long j2 = aJ.field_msgId;
                    k.b HD2 = k.b.HD(processXml);
                    if (HD2 != null) {
                        String aB = m.aB(com.tencent.mm.loader.j.b.aKM(), HD2.title, HD2.iwJ);
                        int i3 = HD2.sdkVer;
                        String str6 = HD2.appId;
                        String str7 = HD2.dCK;
                        int i4 = HD2.iwI;
                        c cVar = new c();
                        cVar.field_fileFullPath = aB;
                        cVar.field_appId = str6;
                        cVar.field_sdkVer = (long) i3;
                        cVar.field_mediaSvrId = str7;
                        cVar.field_totalLen = (long) i4;
                        cVar.field_status = 101;
                        cVar.field_isUpload = false;
                        cVar.field_createTime = Util.nowMilliSecond();
                        cVar.field_lastModifyTime = Util.nowSecond();
                        cVar.field_msgInfoId = j2;
                        cVar.field_netTimes = 0;
                        if (!d.cgP().cgQ().cgO().insert(cVar)) {
                            Log.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", Long.valueOf(j2));
                        }
                    }
                    bdx = d.cgP().cgQ().cgO().bdx(HD.dCK);
                    if (bdx == null) {
                        Log.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", HD.dCK);
                        AppMethodBeat.o(21507);
                        return 0;
                    } else if (!(HD.iwI == 0 || c2 == 0)) {
                        if (c2 >= HD.iwI) {
                            bdx.field_status = 199;
                        } else if (caVar.field_isSend == 1) {
                            bdx.field_status = 105;
                        } else {
                            bdx.field_status = 102;
                        }
                    }
                }
                long j3 = (long) c2;
                bdx.field_offset = j3;
                bdx.field_totalLen = j3;
                s.nx(str5, bdx.field_fileFullPath);
                d.cgP().cgQ().cgO().a(bdx, new String[0]);
            }
            AppMethodBeat.o(21507);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.backup.f.a$a  reason: collision with other inner class name */
    public static class C0845a {
        public static String INVALID_TAG = "]]>";
        public static String oJw = "<msg>";
        public static String oJx = "</msg>";

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.backup.f.a$a$b */
        public static class b {
            StringBuffer sb = new StringBuffer();

            b() {
                AppMethodBeat.i(21497);
                AppMethodBeat.o(21497);
            }

            public final void startTag(String str) {
                AppMethodBeat.i(21498);
                this.sb.append("<" + str + ">");
                AppMethodBeat.o(21498);
            }

            public final void endTag(String str) {
                AppMethodBeat.i(21499);
                this.sb.append("</" + str + ">");
                AppMethodBeat.o(21499);
            }

            private void setText(String str) {
                AppMethodBeat.i(21500);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(21500);
                } else if (str.contains(C0845a.INVALID_TAG)) {
                    this.sb.append("<![CDATA[" + Util.escapeStringForXml(str) + "]]>");
                    AppMethodBeat.o(21500);
                } else {
                    this.sb.append("<![CDATA[" + str + "]]>");
                    AppMethodBeat.o(21500);
                }
            }

            private void setText(int i2) {
                AppMethodBeat.i(21501);
                this.sb.append(i2);
                AppMethodBeat.o(21501);
            }

            public final void addTag(String str, String str2) {
                AppMethodBeat.i(21502);
                startTag(str);
                setText(str2);
                endTag(str);
                AppMethodBeat.o(21502);
            }

            public final void addTag(String str, int i2) {
                AppMethodBeat.i(21503);
                startTag(str);
                setText(i2);
                endTag(str);
                AppMethodBeat.o(21503);
            }

            public final void startTag(String str, Map<String, String> map) {
                AppMethodBeat.i(21504);
                this.sb.append("<".concat(String.valueOf(str)));
                for (String str2 : map.keySet()) {
                    this.sb.append(" " + str2 + " =  \"" + map.get(str2) + "\" ");
                }
                this.sb.append(">");
                map.clear();
                AppMethodBeat.o(21504);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.backup.f.a$a$a  reason: collision with other inner class name */
        public static class C0846a {
            boolean daZ = true;
            Map<String, String> oND = null;

            public C0846a(String str) {
                AppMethodBeat.i(21495);
                this.oND = SemiXml.decode(str);
                if (this.oND == null) {
                    this.daZ = false;
                    this.oND = new HashMap();
                }
                AppMethodBeat.o(21495);
            }

            /* access modifiers changed from: package-private */
            public final int getInt(String str) {
                AppMethodBeat.i(21496);
                if (!this.oND.containsKey(str)) {
                    AppMethodBeat.o(21496);
                    return 0;
                }
                int i2 = Util.getInt(this.oND.get(str), 0);
                AppMethodBeat.o(21496);
                return i2;
            }
        }

        public static String agF(String str) {
            String str2;
            String str3;
            String str4;
            AppMethodBeat.i(21505);
            com.tencent.mm.ag.u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(0, str);
            C0846a aVar = new C0846a(str);
            if (!aVar.daZ) {
                Log.e("MicroMsg.AppmsgConvert", "buffer error");
                AppMethodBeat.o(21505);
                return "";
            }
            b bVar = new b();
            LinkedList linkedList = a2.iAd;
            HashMap hashMap = new HashMap();
            bVar.startTag("msg");
            hashMap.put("appid", aVar.oND.get(".msg.appmsg.$appid"));
            hashMap.put("sdkver", aVar.oND.get(".msg.appmsg.$sdkver"));
            bVar.startTag("appmsg", hashMap);
            if (linkedList == null) {
                linkedList = new LinkedList();
            }
            if (linkedList.size() == 0) {
                str2 = "";
                str3 = "";
                str4 = "";
            } else {
                str2 = ((v) linkedList.get(0)).title;
                str3 = ((v) linkedList.get(0)).url;
                linkedList.get(0);
                str4 = ((v) linkedList.get(0)).iAq;
            }
            bVar.addTag("title", str2);
            bVar.addTag("des", aVar.oND.get(".msg.appmsg.des"));
            bVar.addTag(NativeProtocol.WEB_DIALOG_ACTION, aVar.oND.get(".msg.appmsg.action"));
            bVar.addTag("type", aVar.getInt(".msg.appmsg.type"));
            bVar.addTag("showtype", aVar.getInt(".msg.appmsg.showtype"));
            bVar.addTag("content", aVar.oND.get(".msg.appmsg.content"));
            bVar.addTag("url", str3);
            bVar.addTag("lowurl", aVar.oND.get(".msg.appmsg.lowurl"));
            bVar.startTag("appattach");
            bVar.addTag("totallen", aVar.getInt(".msg.appmsg.appattach.totallen"));
            bVar.addTag("attachid", aVar.oND.get(".msg.appmsg.appattach.attachid"));
            bVar.addTag("fileext", aVar.oND.get(".msg.appmsg.appattach.fileext"));
            bVar.endTag("appattach");
            bVar.startTag("mmreader");
            hashMap.put("type", new StringBuilder().append(a2.type).toString());
            hashMap.put("convMsgCount", new StringBuilder().append(linkedList.size()).toString());
            bVar.startTag("category", hashMap);
            bVar.addTag("name", a2.eah);
            bVar.startTag("topnew");
            bVar.addTag("cover", aVar.oND.get(".msg.appmsg.mmreader.category.topnew.cover"));
            bVar.addTag("width", aVar.oND.get(".msg.appmsg.mmreader.category.topnew.width"));
            bVar.addTag("height", aVar.oND.get(".msg.appmsg.mmreader.category.topnew.height"));
            bVar.addTag("digest", str4);
            bVar.endTag("topnew");
            int i2 = 0;
            while (i2 < linkedList.size()) {
                bVar.startTag("item");
                if (linkedList.get(i2) != null) {
                    String str5 = ((v) linkedList.get(i2)).title;
                    String str6 = ((v) linkedList.get(i2)).url;
                    String str7 = ((v) linkedList.get(i2)).iAm;
                    String str8 = ((v) linkedList.get(i2)).iAn;
                    String sb = new StringBuilder().append(((v) linkedList.get(i2)).time).toString();
                    String str9 = ((v) linkedList.get(i2)).iAo;
                    String str10 = ((v) linkedList.get(i2)).iAp;
                    String str11 = ((v) linkedList.get(i2)).iAq;
                    bVar.addTag("title", str5);
                    bVar.addTag("url", str6);
                    bVar.addTag("shorturl", str7);
                    bVar.addTag("longurl", str8);
                    bVar.addTag("pub_time", sb);
                    bVar.addTag("cover", str9);
                    bVar.addTag("tweetid", str10);
                    bVar.addTag("digest", str11);
                    bVar.addTag("fileid", aVar.oND.get((".msg.appmsg.mmreader.category.item" + (i2 == 0 ? "" : String.valueOf(i2))) + ".fileid"));
                    bVar.startTag("source");
                    bVar.startTag("source");
                    bVar.addTag("name", a2.eah);
                    bVar.endTag("source");
                    bVar.endTag("source");
                    bVar.endTag("item");
                }
                i2++;
            }
            bVar.endTag("category");
            bVar.startTag(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
            bVar.addTag("convName", a2.eag);
            bVar.addTag("nickname", a2.eah);
            bVar.endTag(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
            bVar.endTag("mmreader");
            bVar.endTag("appmsg");
            bVar.addTag("fromusername", a2.eag);
            bVar.addTag("scene", aVar.getInt(".msg.scene"));
            bVar.startTag("appinfo");
            bVar.addTag("version", aVar.oND.get(".msg.appinfo.appname"));
            bVar.addTag("appname", aVar.oND.get(".msg.appinfo.version"));
            bVar.endTag("appinfo");
            bVar.addTag("commenturl", a2.fQR);
            bVar.endTag("msg");
            Log.d("MicroMsg.AppmsgConvert", "xml " + bVar.sb.toString());
            String stringBuffer = bVar.sb.toString();
            AppMethodBeat.o(21505);
            return stringBuffer;
        }
    }
}
