package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.v;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i;
import com.tencent.mm.plugin.backup.bakoldlogic.d.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b implements j {
    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(is isVar, ca caVar, String str, LinkedList<u> linkedList) {
        int length;
        int length2;
        AppMethodBeat.i(231597);
        switch (caVar.getType()) {
            case 1048625:
                if (Util.isNullOrNil(caVar.field_content)) {
                    length = 0;
                } else {
                    length = caVar.field_content.getBytes().length;
                }
                if (caVar.field_content == null) {
                    AppMethodBeat.o(231597);
                    return -1;
                }
                String trim = be.bkr(caVar.field_content).Oph.trim();
                if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.agB(trim)) {
                    trim = caVar.field_content;
                    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.agB(trim)) {
                        Log.e("MicroMsg.BakOldItemAppMsg", "get xml error ".concat(String.valueOf(trim)));
                        AppMethodBeat.o(231597);
                        return 0;
                    }
                }
                if (!Util.isNullOrNil(trim)) {
                    dqi dqi = new dqi();
                    dqi.bhy(Util.nullAs(trim, ""));
                    isVar.KHn = dqi;
                    k.b HD = k.b.HD(trim);
                    String aTd = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().aTd();
                    String R = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgM().R(caVar.field_imgPath, true);
                    String str2 = aTd + HD.iwK;
                    if (s.boW(R) <= 0) {
                        AppMethodBeat.o(231597);
                        return -1;
                    }
                    length = length + i.a(new i.a(R, isVar, linkedList, 6, false, "_thumb", false)) + i.a(new i.a(str2, isVar, linkedList, false, false, com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgN().blk(be.bkr(z.a(isVar.KHn)).md5)));
                }
                AppMethodBeat.o(231597);
                return length;
            case 285212721:
                if (Util.isNullOrNil(caVar.field_content)) {
                    length2 = 0;
                } else {
                    length2 = caVar.field_content.getBytes().length;
                }
                String agF = a.agF(caVar.field_content);
                if (Util.isNullOrNil(agF)) {
                    AppMethodBeat.o(231597);
                    return 0;
                }
                dqi dqi2 = new dqi();
                dqi2.bhy(Util.nullAs(agF, ""));
                isVar.KHn = dqi2;
                AppMethodBeat.o(231597);
                return length2;
            default:
                int b2 = b(isVar, false, caVar, str, linkedList, null, false, 0);
                AppMethodBeat.o(231597);
                return b2;
        }
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(String str, is isVar, ca caVar) {
        String str2;
        int Kr;
        AppMethodBeat.i(21837);
        String str3 = isVar.KHl.MTo;
        String str4 = isVar.KHn.MTo;
        if (str4 == null) {
            AppMethodBeat.o(21837);
            return 0;
        }
        caVar.setContent(str4);
        if (!(caVar.field_isSend == 1 || !d.Eq(str3) || (Kr = d.Kr(isVar.KHn.MTo)) == -1)) {
            str4 = (isVar.KHn.MTo + " ").substring(Kr + 2).trim();
        }
        String processXml = Util.processXml(str4);
        k.b HD = k.b.HD(processXml);
        if (HD == null) {
            Log.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
            AppMethodBeat.o(21837);
            return 0;
        } else if (HD.type == 2000) {
            caVar.setType(419430449);
            d.x(caVar);
            AppMethodBeat.o(21837);
            return 0;
        } else if (HD.type == 19 || HD.type == 24) {
            caVar.setType(m.g(HD));
            d.x(caVar);
            qg qgVar = new qg();
            qgVar.dWB.xml = HD.ixl;
            qgVar.dWB.dFm = caVar.field_msgId;
            EventCenter.instance.publish(qgVar);
            Log.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", qgVar.dWC.dWD);
            String[] split = qgVar.dWC.dWD.split(":");
            for (int i2 = 0; i2 < split.length; i2++) {
                String a2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(isVar, 7, ".".concat(String.valueOf(i2)));
                if (!Util.isNullOrNil(a2)) {
                    Log.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", a2, Integer.valueOf(i2));
                    s.nw(com.tencent.mm.plugin.backup.bakoldlogic.a.a.agM(a2), split[i2]);
                }
            }
            AppMethodBeat.o(21837);
            return 0;
        } else {
            g gVar = new g();
            gVar.field_appId = HD.appId;
            c chx = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx();
            if (chx.uin == 0) {
                com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
                AppMethodBeat.o(21837);
                throw bVar;
            }
            if (chx.oQF.get(gVar, new String[0]) && gVar.field_appVersion < HD.appVersion) {
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chy().j(1, HD.appId);
            }
            caVar.setType(m.g(HD));
            byte[] b2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(isVar, 6);
            if (b2 != null && caVar.field_msgId == 0) {
                String a3 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgM().a(b2, HD.type == 2, Bitmap.CompressFormat.PNG);
                Log.d("MicroMsg.BakOldItemAppMsg", f.apq() + " thumbData MsgInfo path:" + a3);
                if (!Util.isNullOrNil(a3)) {
                    caVar.Cz(a3);
                    Log.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:".concat(String.valueOf(a3)));
                }
            }
            String a4 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(isVar, 8);
            int c2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(isVar, 8);
            if (Util.isNullOrNil(a4)) {
                a4 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(isVar, 7);
                c2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(isVar, 7);
            }
            String agM = com.tencent.mm.plugin.backup.bakoldlogic.a.a.agM(a4);
            d.x(caVar);
            k kVar = new k();
            HD.a(kVar);
            kVar.field_msgId = caVar.field_msgId;
            c chx2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx();
            if (chx2.uin == 0) {
                com.tencent.mm.model.b bVar2 = new com.tencent.mm.model.b();
                AppMethodBeat.o(21837);
                throw bVar2;
            }
            chx2.oQE.insert(kVar);
            if (!Util.isNullOrNil(a4)) {
                com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().aSQ();
                if (str.equals(isVar.KHl.MTo)) {
                    str2 = isVar.KHm.MTo;
                } else {
                    str2 = isVar.KHl.MTo;
                }
                ca aJ = aSQ.aJ(str2, isVar.Brn);
                com.tencent.mm.pluginsdk.model.app.c bdx = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(HD.dCK);
                if (bdx == null) {
                    Log.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
                    long j2 = aJ.field_msgId;
                    k.b HD2 = k.b.HD(processXml);
                    if (HD2 != null) {
                        String aB = m.aB(com.tencent.mm.loader.j.b.aKM(), HD2.title, HD2.iwJ);
                        int i3 = HD2.sdkVer;
                        String str5 = HD2.appId;
                        String str6 = HD2.dCK;
                        int i4 = HD2.iwI;
                        com.tencent.mm.pluginsdk.model.app.c cVar = new com.tencent.mm.pluginsdk.model.app.c();
                        cVar.field_fileFullPath = aB;
                        cVar.field_appId = str5;
                        cVar.field_sdkVer = (long) i3;
                        cVar.field_mediaSvrId = str6;
                        cVar.field_totalLen = (long) i4;
                        cVar.field_status = 101;
                        cVar.field_isUpload = false;
                        cVar.field_createTime = Util.nowMilliSecond();
                        cVar.field_lastModifyTime = Util.nowSecond();
                        cVar.field_msgInfoId = j2;
                        cVar.field_netTimes = 0;
                        if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().insert(cVar)) {
                            Log.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", Long.valueOf(j2));
                        }
                    }
                    bdx = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(HD.dCK);
                    if (bdx == null) {
                        Log.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", HD.dCK);
                        AppMethodBeat.o(21837);
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
                s.ny(agM, bdx.field_fileFullPath);
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().a(bdx, new String[0]);
            }
            AppMethodBeat.o(21837);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public static String INVALID_TAG = "]]>";
        public static String oJw = "<msg>";
        public static String oJx = "</msg>";

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.b$a$b  reason: collision with other inner class name */
        public static class C0838b {
            StringBuffer sb = new StringBuffer();

            C0838b() {
                AppMethodBeat.i(21826);
                AppMethodBeat.o(21826);
            }

            public final void startTag(String str) {
                AppMethodBeat.i(21827);
                this.sb.append("<" + str + ">");
                AppMethodBeat.o(21827);
            }

            public final void endTag(String str) {
                AppMethodBeat.i(21828);
                this.sb.append("</" + str + ">");
                AppMethodBeat.o(21828);
            }

            private void setText(String str) {
                AppMethodBeat.i(21829);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(21829);
                } else if (str.contains(a.INVALID_TAG)) {
                    this.sb.append("<![CDATA[" + Util.escapeStringForXml(str) + "]]>");
                    AppMethodBeat.o(21829);
                } else {
                    this.sb.append("<![CDATA[" + str + "]]>");
                    AppMethodBeat.o(21829);
                }
            }

            private void setText(int i2) {
                AppMethodBeat.i(21830);
                this.sb.append(i2);
                AppMethodBeat.o(21830);
            }

            public final void addTag(String str, String str2) {
                AppMethodBeat.i(21831);
                startTag(str);
                setText(str2);
                endTag(str);
                AppMethodBeat.o(21831);
            }

            public final void addTag(String str, int i2) {
                AppMethodBeat.i(21832);
                startTag(str);
                setText(i2);
                endTag(str);
                AppMethodBeat.o(21832);
            }

            public final void startTag(String str, Map<String, String> map) {
                AppMethodBeat.i(21833);
                this.sb.append("<".concat(String.valueOf(str)));
                for (String str2 : map.keySet()) {
                    this.sb.append(" " + str2 + " =  \"" + map.get(str2) + "\" ");
                }
                this.sb.append(">");
                map.clear();
                AppMethodBeat.o(21833);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.b$a$a  reason: collision with other inner class name */
        public static class C0837a {
            boolean daZ = true;
            Map<String, String> oND = null;

            public C0837a(String str) {
                AppMethodBeat.i(21824);
                this.oND = SemiXml.decode(str);
                if (this.oND == null) {
                    this.daZ = false;
                    this.oND = new HashMap();
                }
                AppMethodBeat.o(21824);
            }

            /* access modifiers changed from: package-private */
            public final int getInt(String str) {
                AppMethodBeat.i(21825);
                if (!this.oND.containsKey(str)) {
                    AppMethodBeat.o(21825);
                    return 0;
                }
                int i2 = Util.getInt(this.oND.get(str), 0);
                AppMethodBeat.o(21825);
                return i2;
            }
        }

        public static String agF(String str) {
            String str2;
            String str3;
            String str4;
            AppMethodBeat.i(21834);
            com.tencent.mm.ag.u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(0, str);
            C0837a aVar = new C0837a(str);
            if (!aVar.daZ) {
                Log.e("MicroMsg.AppmsgConvert", "buffer error");
                AppMethodBeat.o(21834);
                return "";
            }
            C0838b bVar = new C0838b();
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
            AppMethodBeat.o(21834);
            return stringBuffer;
        }
    }

    private static int b(is isVar, boolean z, ca caVar, String str, LinkedList<u> linkedList, HashMap<Long, Object> hashMap, boolean z2, long j2) {
        com.tencent.mm.pluginsdk.model.app.c bdx;
        int indexOf;
        AppMethodBeat.i(231598);
        int length = Util.isNullOrNil(caVar.field_content) ? 0 : caVar.field_content.getBytes().length;
        String str2 = caVar.field_content;
        if (!(caVar.field_isSend == 1 || !d.Eq(caVar.field_talker) || (indexOf = caVar.field_content.indexOf(58)) == -1)) {
            str2 = caVar.field_content.substring(indexOf + 1);
        }
        String processXml = Util.processXml(str2);
        k.b HD = processXml != null ? k.b.HD(processXml) : null;
        if (HD == null) {
            Log.e("MicroMsg.BakOldItemAppMsg", "content is null");
            AppMethodBeat.o(231598);
            return 0;
        }
        Log.d("MicroMsg.BakOldItemAppMsg", "content type " + HD.type);
        String R = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgM().R(caVar.field_imgPath, true);
        if (s.YS(R)) {
            length += i.a(new i.a(R, isVar, linkedList, 6, false, "_thumb", false));
        } else if (HD.type == 2) {
            AppMethodBeat.o(231598);
            return -1;
        }
        switch (HD.type) {
            case 2:
                if (!Util.isNullOrNil(HD.dCK) && (((bdx = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(HD.dCK)) != null && bdx.deQ()) || (caVar.field_isSend == 1 && bdx != null && bdx.field_isUpload))) {
                    String str3 = bdx.field_fileFullPath;
                    if (s.YS(str3)) {
                        Log.d("MicroMsg.BakOldItemAppMsg", "image ".concat(String.valueOf(str3)));
                        length += i.a(new i.a(str3, isVar, linkedList, 8, false, false, (u) null));
                        break;
                    }
                }
                break;
            case 6:
                com.tencent.mm.pluginsdk.model.app.c bdx2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(HD.dCK);
                if ((bdx2 != null && bdx2.deQ()) || (caVar.field_isSend == 1 && bdx2 != null && bdx2.field_isUpload)) {
                    Log.d("MicroMsg.BakOldItemAppMsg", "full path " + bdx2.field_fileFullPath);
                    if (s.YS(bdx2.field_fileFullPath)) {
                        if (com.tencent.mm.plugin.backup.b.d.ceP() != 1 || ((long) (HD.iwI / 1024)) < 0 || HD.filemd5 == null) {
                            length += i.a(new i.a(bdx2.field_fileFullPath, isVar, linkedList, 7, false, false, (u) null));
                            break;
                        } else {
                            length += i.a(new i.a(bdx2.field_fileFullPath, isVar, linkedList, 7, false, true, new u()));
                            break;
                        }
                    }
                }
                break;
            case 7:
                com.tencent.mm.pluginsdk.model.app.c bdx3 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().cgO().bdx(HD.dCK);
                if ((bdx3 != null && bdx3.deQ()) || (caVar.field_isSend == 1 && bdx3 != null && bdx3.field_isUpload)) {
                    Log.d("MicroMsg.BakOldItemAppMsg", "full path " + bdx3.field_fileFullPath);
                    if (s.YS(bdx3.field_fileFullPath)) {
                        length += i.a(new i.a(bdx3.field_fileFullPath, isVar, linkedList, 7, false, false, (u) null));
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
                Log.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", qgVar.dWC.dWD);
                String[] split = qgVar.dWC.dWD.split(":");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (s.YS(split[i2])) {
                        Log.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", split[i2], Integer.valueOf(i2));
                        length += i.a(new i.a(split[i2], isVar, linkedList, 7, false, "_fav.".concat(String.valueOf(i2)), false));
                    }
                }
                break;
        }
        AppMethodBeat.o(231598);
        return length;
    }
}
