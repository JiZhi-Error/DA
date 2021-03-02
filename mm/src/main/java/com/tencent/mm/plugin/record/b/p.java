package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.al.a.e;
import com.tencent.mm.av.q;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class p {
    private static final f<Integer, c> gAU = new com.tencent.mm.memory.a.c(32);

    static /* synthetic */ void b(long j2, long j3, String str, k.b bVar, c cVar, anb anb, boolean z) {
        AppMethodBeat.i(215201);
        a(j2, j3, str, bVar, cVar, anb, z);
        AppMethodBeat.o(215201);
    }

    static /* synthetic */ void c(long j2, String str, String str2, String str3, anb anb) {
        AppMethodBeat.i(215197);
        a(j2, str, str2, str3, anb);
        AppMethodBeat.o(215197);
    }

    static /* synthetic */ void d(long j2, String str, String str2, String str3, anb anb) {
        AppMethodBeat.i(215203);
        b(j2, str, str2, str3, anb);
        AppMethodBeat.o(215203);
    }

    public static String a(String str, String str2, anb anb, String str3, long j2) {
        AppMethodBeat.i(9519);
        if (anb == null || anb.ppH == null) {
            Log.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
            AppMethodBeat.o(9519);
            return "";
        }
        LinkedList<aml> linkedList = anb.ppH;
        StringBuilder sb = new StringBuilder();
        sb.append("<recordinfo>");
        sb.append("<title>").append(Util.escapeStringForXml(str)).append("</title>");
        sb.append("<desc>").append(Util.escapeStringForXml(str2)).append("</desc>");
        a(sb, anb);
        sb.append(q.dE(linkedList));
        sb.append("<favusername>").append(Util.escapeStringForXml(str3)).append("</favusername>");
        sb.append("</recordinfo>");
        k.b bVar = new k.b();
        bVar.title = str;
        bVar.description = str2;
        if (linkedList.size() <= 0 || !l.j(linkedList.get(0))) {
            bVar.type = 19;
            bVar.url = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            bVar.type = 24;
            bVar.url = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        bVar.action = "view";
        bVar.ixl = sb.toString();
        k GL = a.eAT().GL(j2);
        if (GL != null) {
            bVar.appId = GL.field_appId;
        }
        String a2 = k.b.a(bVar, null, null);
        AppMethodBeat.o(9519);
        return a2;
    }

    private static List<a.b> b(String str, anb anb) {
        AppMethodBeat.i(215189);
        List<a.b> synchronizedList = Collections.synchronizedList(new ArrayList());
        if (anb != null) {
            Iterator<aml> it = anb.ppH.iterator();
            while (it.hasNext()) {
                aml next = it.next();
                if (next.LvI > 26214400) {
                    a.b bVar = new a.b();
                    String str2 = next.LvL;
                    String bhK = s.bhK(str2);
                    bVar.filePath = str2;
                    bVar.toUser = str;
                    bVar.fileSize = next.LvI;
                    bVar.gCr = next.LvC;
                    if (!Util.isNullOrNil(next.LvE)) {
                        bhK = next.LvE;
                    }
                    bVar.pkL = bhK;
                    bVar.aesKey = next.Lvp;
                    bVar.fileName = next.title;
                    synchronizedList.add(bVar);
                }
            }
        }
        AppMethodBeat.o(215189);
        return synchronizedList;
    }

    private static final b f(k.b bVar) {
        AppMethodBeat.i(215190);
        if (bVar == null) {
            Log.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse appmsg error");
            AppMethodBeat.o(215190);
            return null;
        }
        c aKY = aKY(bVar.ixl);
        if (aKY == null) {
            Log.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse record data error");
            AppMethodBeat.o(215190);
            return null;
        }
        anb anb = new anb();
        anb.ppH = new LinkedList<>();
        anb.a(aKY.KBr);
        anb.Mz(aKY.rnM);
        anb.bhd(aKY.title);
        String string = MMApplicationContext.getContext().getString(R.string.hf);
        String string2 = MMApplicationContext.getContext().getString(R.string.ve);
        ArrayList arrayList = new ArrayList();
        Iterator<aml> it = aKY.iAd.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (next.dataType == 8 && next.LvI > 26214400) {
                next.ajd(1);
                next.bgg(string);
                arrayList.add(string2 + next.title);
                next.bgf(null);
                next.bgp(null);
                next.bgk(null);
                next.bgj(null);
                next.Lvr = 0;
                next.Lvs = true;
                next.Mu((long) string.length());
            }
            anb.ppH.add(next);
        }
        String[] split = aKY.desc.split("\n");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            String[] split2 = str.split(":");
            if (split2.length != 2) {
                Log.e("MicroMsg.RecordMsgLogic", "parse str(%s) of desc(%s) fail", str, aKY.desc);
            } else {
                if (arrayList.contains(split2[1])) {
                    stringBuffer.append(split2[0] + ":" + string);
                } else {
                    stringBuffer.append(str);
                }
                stringBuffer.append('\n');
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        String substring = stringBuffer2.substring(0, stringBuffer2.length() - 1);
        anb.bhe(substring);
        b bVar2 = new b(substring, aKY.BGs, anb);
        AppMethodBeat.o(215190);
        return bVar2;
    }

    private static void a(long j2, String str, String str2, String str3, anb anb) {
        AppMethodBeat.i(215191);
        com.tencent.mm.plugin.record.a.k kVar = new com.tencent.mm.plugin.record.a.k();
        kVar.field_msgId = j2;
        kVar.field_title = str;
        kVar.field_desc = str2;
        kVar.field_toUser = str3;
        kVar.field_dataProto = anb;
        kVar.field_type = 3;
        kVar.field_localId = new Random().nextInt(2147483645) + 1;
        Log.i("MicroMsg.RecordMsgLogic", "summerrecord Download RecordMsgStorage insert ret:%b, id:%d, localid:%d", Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(kVar)), Long.valueOf(j2), Integer.valueOf(kVar.field_localId));
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(kVar);
        AppMethodBeat.o(215191);
    }

    private static void a(long j2, long j3, String str, k.b bVar, c cVar, anb anb, boolean z) {
        AppMethodBeat.i(215192);
        com.tencent.mm.plugin.record.a.k kVar = new com.tencent.mm.plugin.record.a.k();
        kVar.field_msgId = j2;
        kVar.field_oriMsgId = j3;
        kVar.field_toUser = str;
        kVar.field_title = bVar.title;
        kVar.field_desc = Util.nullAs(cVar.desc, bVar.description);
        kVar.field_dataProto = anb;
        kVar.field_type = 0;
        kVar.field_favFrom = cVar.BGs;
        kVar.field_localId = new Random().nextInt(2147483645) + 1;
        Log.i("MicroMsg.RecordMsgLogic", "summerrecord Normal RecordMsgStorage insert ret:%b, id:%d, oriMsgId:%d localid:%d", Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(kVar)), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(kVar.field_localId));
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(kVar, z);
        AppMethodBeat.o(215192);
    }

    private static void b(long j2, String str, String str2, String str3, anb anb) {
        AppMethodBeat.i(215193);
        com.tencent.mm.plugin.record.a.k kVar = new com.tencent.mm.plugin.record.a.k();
        kVar.field_msgId = j2;
        kVar.field_title = str;
        kVar.field_desc = str2;
        kVar.field_toUser = str3;
        kVar.field_dataProto = anb;
        kVar.field_type = 1;
        kVar.field_localId = new Random().nextInt(2147483645) + 1;
        Log.i("MicroMsg.RecordMsgLogic", "summerrecord Fav RecordMsgStorage insert ret:%b, id:%d, localid:%d", Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(kVar)), Long.valueOf(j2), Integer.valueOf(kVar.field_localId));
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(kVar);
        AppMethodBeat.o(215193);
    }

    public static Pair<Long, Boolean> a(Context context, final String str, String str2, List<ca> list, cz czVar, d dVar, String str3) {
        final cz czVar2;
        boolean z;
        String ap;
        AppMethodBeat.i(215194);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            Pair<Long, Boolean> pair = new Pair<>(-1L, Boolean.FALSE);
            AppMethodBeat.o(215194);
            return pair;
        } else if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            Pair<Long, Boolean> pair2 = new Pair<>(-1L, Boolean.FALSE);
            AppMethodBeat.o(215194);
            return pair2;
        } else {
            if (czVar == null || dVar == null) {
                czVar2 = new cz();
                if (!c.a(context, czVar2, str2, list, -1)) {
                    Pair<Long, Boolean> pair3 = new Pair<>(-1L, Boolean.FALSE);
                    AppMethodBeat.o(215194);
                    return pair3;
                }
                dVar = a(context, czVar2, str2);
            } else {
                czVar2 = czVar;
            }
            final k.b a2 = a(dVar.title, dVar.desc, czVar2.dFZ.dGb);
            final ca caVar = new ca();
            byte[] bArr = null;
            if (!Util.isNullOrNil(dVar.thumbPath)) {
                bArr = Util.readFromFile(dVar.thumbPath);
            } else if (dVar.dXJ == 0 && !Util.isNullOrNil(dVar.tfO)) {
                bArr = BitmapUtil.Bitmap2Bytes(com.tencent.mm.aj.c.a(dVar.tfO, false, -1, null));
            }
            if (bArr != null) {
                if (bArr.length > 65536) {
                    ap = q.bcR().a(bArr, false, Bitmap.CompressFormat.JPEG);
                } else {
                    ap = q.bcR().ap(bArr);
                }
                Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData MsgInfo path:" + ap);
                if (!Util.isNullOrNil(ap)) {
                    caVar.Cz(ap);
                }
            }
            caVar.setContent(k.b.a(a2, null, null));
            caVar.setStatus(1);
            caVar.Cy(str);
            caVar.setCreateTime(bp.Kw(str));
            caVar.nv(1);
            caVar.setType(49);
            if (com.tencent.mm.al.g.DQ(str)) {
                caVar.BB(e.ajw());
            }
            final long aC = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
            Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + aC);
            if (aC < 0) {
                Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + aC);
                Pair<Long, Boolean> pair4 = new Pair<>(Long.valueOf((long) (0 - com.tencent.mm.compatible.util.f.getLine())), Boolean.FALSE);
                AppMethodBeat.o(215194);
                return pair4;
            }
            Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + aC);
            caVar.setMsgId(aC);
            k kVar = new k();
            kVar.field_xml = caVar.field_content;
            kVar.field_title = a2.title;
            kVar.field_type = a2.type;
            kVar.field_description = a2.description;
            kVar.field_msgId = aC;
            kVar.field_appId = a2.appId;
            com.tencent.mm.plugin.r.a.eAT().insert(kVar);
            Iterator<aml> it = czVar2.dFZ.dGb.ppH.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                aml next = it.next();
                if (Util.isNullOrNil(next.dLl)) {
                    next.bgs(ds(next.toString(), next.dataType));
                }
                if (z2 || s.YS(next.LvL) || s.YS(next.LvN) || !Util.isNullOrNil(next.KuR) || !Util.isNullOrNil(next.iwX) || !Util.isNullOrNil(next.LwF) || !Util.isNullOrNil(next.iwO)) {
                    z2 = true;
                }
            }
            Log.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", Boolean.valueOf(z2));
            if (z2) {
                if (!ab.IO(str) || Util.isNullOrNil(str3)) {
                    str3 = str;
                }
                List<a.b> b2 = b(str3, czVar2.dFZ.dGb);
                if (b2.size() > 0) {
                    g.azz().a(new com.tencent.mm.pluginsdk.g.a(b2, new a.AbstractC2016a() {
                        /* class com.tencent.mm.plugin.record.b.p.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.g.a.AbstractC2016a
                        public final void bS(int i2, String str) {
                            AppMethodBeat.i(215186);
                            if (i2 == 0) {
                                p.c(aC, a2.getTitle(), a2.getDescription(), str, czVar2.dFZ.dGb);
                                AppMethodBeat.o(215186);
                            } else if (-3200 == i2) {
                                p.c(aC, caVar);
                                p.a(aC, caVar, str);
                                ((com.tencent.mm.plugin.record.a.f) g.af(com.tencent.mm.plugin.record.a.f.class)).C(aC, str);
                                AppMethodBeat.o(215186);
                            } else {
                                caVar.setStatus(5);
                                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(aC, caVar);
                                if (!p.a(str, aC, false, str)) {
                                    p.dZ(str, str);
                                }
                                AppMethodBeat.o(215186);
                            }
                        }
                    }), 0);
                } else {
                    a(aC, a2.getTitle(), a2.getDescription(), str, czVar2.dFZ.dGb);
                }
            } else {
                Log.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", Long.valueOf(aC));
                if (!ab.IO(str)) {
                    ((com.tencent.mm.plugin.record.a.g) g.af(com.tencent.mm.plugin.record.a.g.class)).HR(aC);
                }
            }
            Long valueOf = Long.valueOf(aC);
            if (!z2) {
                z = true;
            } else {
                z = false;
            }
            Pair<Long, Boolean> pair5 = new Pair<>(valueOf, Boolean.valueOf(z));
            AppMethodBeat.o(215194);
            return pair5;
        }
    }

    public static d a(Context context, cz czVar, String str) {
        LinkedList<aml> linkedList;
        String str2;
        boolean z = false;
        AppMethodBeat.i(9523);
        d dVar = new d();
        SparseIntArray sparseIntArray = new SparseIntArray();
        if (com.tencent.mm.al.g.DQ(str)) {
            dVar.title = czVar.dFZ.dGb.title;
        } else if (ab.Eq(str)) {
            dVar.title = context.getString(R.string.fvq);
        } else {
            String aUa = z.aUa();
            Object Ir = ((b) g.af(b.class)).Ir(str);
            if (aUa.equals(Ir)) {
                dVar.title = context.getString(R.string.cb7, aUa);
            } else {
                dVar.title = context.getString(R.string.cb6, aUa, Ir);
            }
        }
        Log.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", dVar.title);
        LinkedList linkedList2 = new LinkedList();
        if (czVar.dFZ.dGb != null) {
            linkedList = czVar.dFZ.dGb.ppH;
        } else {
            linkedList = new LinkedList<>();
        }
        for (aml aml : linkedList) {
            sparseIntArray.put(aml.dataType, sparseIntArray.get(aml.dataType) + 1);
            switch (aml.dataType) {
                case 1:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + aml.desc + "\n");
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.xr) + "\n");
                    }
                    if (!z) {
                        a(dVar, aml, (int) R.drawable.bxc);
                        z = true;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.zz) + "\n");
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.zv) + "\n");
                    }
                    if (!z) {
                        a(dVar, aml, (int) R.raw.app_attach_file_icon_video);
                        z = true;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.zp) + aml.title + "\n");
                    }
                    if (!z) {
                        a(dVar, aml, (int) R.raw.app_attach_file_icon_webpage);
                        z = true;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (linkedList2.size() < 5) {
                        ams ams = aml.Lwh.LwQ;
                        StringBuilder append = new StringBuilder().append(aml.Lwj).append(":").append(context.getString(R.string.we));
                        if (Util.isNullOrNil(ams.dWi) || ams.dWi.equals(context.getString(R.string.we))) {
                            str2 = ams.label;
                        } else {
                            str2 = ams.dWi;
                        }
                        linkedList2.add(append.append(str2).append("\n").toString());
                    }
                    if (!z) {
                        dVar.dXJ = R.raw.app_attach_file_icon_location;
                        z = true;
                        break;
                    } else {
                        break;
                    }
                    break;
                case 7:
                case 29:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.wv) + aml.title + "\n");
                    }
                    if (!z) {
                        a(dVar, aml, (int) R.raw.app_attach_file_icon_music);
                        z = true;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.ve) + aml.title + "\n");
                    }
                    if (!z) {
                        a(dVar, aml, (int) R.raw.app_attach_file_icon_unknow);
                        z = true;
                        break;
                    } else {
                        break;
                    }
                case 10:
                case 11:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.xz) + aml.Lwh.LwU.title + "\n");
                    }
                    if (!z) {
                        a(dVar, aml, (int) R.raw.app_attach_file_icon_unknow);
                        z = true;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.hb) + "\n");
                    }
                    if (!z) {
                        a(dVar, aml, (int) R.raw.app_attach_file_icon_unknow);
                        z = true;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.zv) + "\n");
                    }
                    if (!z) {
                        a(dVar, aml, (int) R.raw.app_attach_file_icon_video);
                        z = true;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (aml == null) {
                        Log.e("MicroMsg.RecordMsgLogic", "favDataItem is null!");
                        break;
                    } else {
                        if (linkedList2.size() < 5) {
                            linkedList2.add(aml.Lwj + ":" + context.getString(R.string.vp) + "\n");
                        }
                        if (!z) {
                            dVar.tfO = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(aml.desc).dkU;
                            z = true;
                            break;
                        } else {
                            break;
                        }
                    }
                case 17:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.yc) + "\n");
                        break;
                    } else {
                        break;
                    }
                case 19:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.hc) + aml.title + "\n");
                        break;
                    } else {
                        break;
                    }
                case 22:
                case 23:
                case 26:
                case 27:
                case 28:
                    if (linkedList2.size() < 5) {
                        linkedList2.add(aml.Lwj + ":" + context.getString(R.string.zp) + aml.title + "\n");
                        break;
                    } else {
                        break;
                    }
            }
        }
        String str3 = "";
        dVar.desc = "";
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            str3 = str3 + ((String) it.next());
        }
        String trim = str3.trim();
        if (linkedList2.size() >= 5) {
            trim = trim + "...";
        }
        dVar.desc = trim;
        AppMethodBeat.o(9523);
        return dVar;
    }

    public static int a(String str, String str2, ca caVar) {
        AppMethodBeat.i(9525);
        int a2 = a(str, str2, caVar, false);
        AppMethodBeat.o(9525);
        return a2;
    }

    public static int a(String str, String str2, final ca caVar, final boolean z) {
        AppMethodBeat.i(9526);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            AppMethodBeat.o(9526);
            return -1;
        } else if (caVar == null || Util.isNullOrNil(caVar.field_content)) {
            Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            AppMethodBeat.o(9526);
            return -1;
        } else if (1 == caVar.field_status) {
            Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
            AppMethodBeat.o(9526);
            return -1;
        } else {
            for (final String str3 : Util.stringsToList(str.split(","))) {
                Log.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", str3, Long.valueOf(caVar.field_msgId), Integer.valueOf(caVar.field_status));
                String Kt = bp.Kt(caVar.field_content);
                final k.b HD = k.b.HD(Kt);
                if (HD == null) {
                    Log.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
                    AppMethodBeat.o(9526);
                    return -1;
                }
                final c aKY = aKY(HD.ixl);
                if (aKY == null) {
                    Log.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
                    AppMethodBeat.o(9526);
                    return -1;
                }
                final ca caVar2 = new ca();
                if (!Util.isNullOrNil(caVar.field_imgPath)) {
                    String ap = q.bcR().ap(Util.readFromFile(q.bcR().R(caVar.field_imgPath, true)));
                    Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData from msg MsgInfo path:" + ap);
                    if (!Util.isNullOrNil(ap)) {
                        caVar2.Cz(ap);
                    }
                }
                caVar2.setContent(Kt);
                caVar2.setStatus(1);
                caVar2.Cy(str3);
                caVar2.setCreateTime(bp.Kw(str3));
                caVar2.nv(1);
                caVar2.setType(49);
                final long aC = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar2);
                Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + aC);
                if (aC < 0) {
                    Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + aC);
                    int line = 0 - com.tencent.mm.compatible.util.f.getLine();
                    AppMethodBeat.o(9526);
                    return line;
                }
                Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + aC);
                caVar2.setMsgId(aC);
                yl ylVar = new yl();
                ylVar.eeI.eeJ = caVar.field_msgId;
                ylVar.eeI.eeK = aC;
                EventCenter.instance.publish(ylVar);
                k kVar = new k();
                kVar.field_xml = caVar2.field_content;
                kVar.field_title = HD.title;
                kVar.field_type = HD.type;
                kVar.field_description = HD.description;
                kVar.field_msgId = aC;
                kVar.field_appId = HD.appId;
                com.tencent.mm.plugin.r.a.eAT().insert(kVar);
                if (k(aKY.iAd, z)) {
                    final anb anb = new anb();
                    anb.ppH.addAll(aKY.iAd);
                    List<a.b> b2 = b(str3, anb);
                    if (b2.size() > 0) {
                        g.azz().a(new com.tencent.mm.pluginsdk.g.a(b2, new a.AbstractC2016a() {
                            /* class com.tencent.mm.plugin.record.b.p.AnonymousClass2 */

                            @Override // com.tencent.mm.pluginsdk.g.a.AbstractC2016a
                            public final void bS(int i2, String str) {
                                AppMethodBeat.i(215187);
                                if (i2 == 0) {
                                    p.b(aC, caVar.field_msgId, str3, HD, aKY, anb, z);
                                    AppMethodBeat.o(215187);
                                } else if (-3200 == i2) {
                                    Log.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", Integer.valueOf(i2), str, Long.valueOf(aC), str3);
                                    p.c(aC, caVar2);
                                    p.a(aC, caVar.field_msgId, caVar2, str3, z);
                                    ((com.tencent.mm.plugin.record.a.f) g.af(com.tencent.mm.plugin.record.a.f.class)).C(aC, str3);
                                    AppMethodBeat.o(215187);
                                } else {
                                    caVar2.setStatus(5);
                                    ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(aC, caVar2);
                                    p.dZ(str3, str);
                                    AppMethodBeat.o(215187);
                                }
                            }
                        }), 0);
                    } else {
                        a(aC, caVar.field_msgId, str3, HD, aKY, anb, z);
                    }
                } else {
                    Log.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
                    ((com.tencent.mm.plugin.record.a.g) g.af(com.tencent.mm.plugin.record.a.g.class)).HR(aC);
                }
                if (!Util.isNullOrNil(str2)) {
                    com.tencent.mm.plugin.messenger.a.g.eir().ad(str3, str2, ab.JG(str3));
                }
            }
            AppMethodBeat.o(9526);
            return 0;
        }
    }

    private static boolean k(List<aml> list, boolean z) {
        boolean z2;
        AppMethodBeat.i(9527);
        Iterator<aml> it = list.iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z2 = z3;
                break;
            }
            aml next = it.next();
            int i2 = next.dataType;
            if (z && i2 == 17) {
                c aKY = aKY(next.Lwx);
                if (aKY != null) {
                    z2 = k(aKY.iAd, z);
                    if (z2) {
                        break;
                    }
                    z3 = z2;
                } else {
                    continue;
                }
            } else if (!Util.isNullOrNil(next.KuR) || !Util.isNullOrNil(next.iwX) || !Util.isNullOrNil(next.LwF) || !Util.isNullOrNil(next.iwO)) {
                z2 = true;
            }
        }
        z2 = true;
        AppMethodBeat.o(9527);
        return z2;
    }

    public static int a(final String str, final anb anb, String str2, String str3, String str4, int i2, String str5) {
        String ap;
        AppMethodBeat.i(9528);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            AppMethodBeat.o(9528);
            return -1;
        } else if (anb == null || anb.ppH.isEmpty()) {
            Log.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
            AppMethodBeat.o(9528);
            return -1;
        } else {
            final k.b a2 = a(str2, str3, anb);
            final ca caVar = new ca();
            byte[] bArr = null;
            if (!Util.isNullOrNil(str4)) {
                bArr = Util.readFromFile(str4);
            } else if (i2 != 0) {
                bArr = BitmapUtil.Bitmap2Bytes(BitmapUtil.getBitmapNative(i2));
            } else if (!Util.isNullOrNil(str5)) {
                bArr = BitmapUtil.Bitmap2Bytes(com.tencent.mm.aj.c.a(str5, false, -1, null));
            }
            if (bArr != null) {
                if (bArr.length > 65536) {
                    ap = q.bcR().a(bArr, false, Bitmap.CompressFormat.JPEG);
                } else {
                    ap = q.bcR().ap(bArr);
                }
                Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData MsgInfo path:" + ap);
                if (!Util.isNullOrNil(ap)) {
                    caVar.Cz(ap);
                }
            }
            caVar.setContent(k.b.a(a2, null, null));
            caVar.setStatus(1);
            caVar.Cy(str);
            caVar.setCreateTime(bp.Kw(str));
            caVar.nv(1);
            caVar.setType(49);
            if (com.tencent.mm.al.g.DQ(str)) {
                caVar.BB(e.ajw());
            }
            final long aC = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
            Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + aC);
            if (aC < 0) {
                Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + aC);
                int line = 0 - com.tencent.mm.compatible.util.f.getLine();
                AppMethodBeat.o(9528);
                return line;
            }
            Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + aC);
            caVar.setMsgId(aC);
            k kVar = new k();
            kVar.field_xml = caVar.field_content;
            kVar.field_title = a2.title;
            kVar.field_type = a2.type;
            kVar.field_description = a2.description;
            kVar.field_msgId = aC;
            kVar.field_appId = a2.appId;
            com.tencent.mm.plugin.r.a.eAT().insert(kVar);
            Iterator<aml> it = anb.ppH.iterator();
            while (it.hasNext()) {
                aml next = it.next();
                if (Util.isNullOrNil(next.KuR)) {
                    if (!Util.isNullOrNil(next.iwX)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            List<a.b> b2 = b(str, anb);
            if (b2.size() > 0) {
                g.azz().a(new com.tencent.mm.pluginsdk.g.a(b2, new a.AbstractC2016a() {
                    /* class com.tencent.mm.plugin.record.b.p.AnonymousClass3 */

                    @Override // com.tencent.mm.pluginsdk.g.a.AbstractC2016a
                    public final void bS(int i2, String str) {
                        AppMethodBeat.i(215188);
                        if (i2 == 0) {
                            p.d(aC, a2.getTitle(), a2.getDescription(), str, anb);
                            AppMethodBeat.o(215188);
                        } else if (-3200 == i2) {
                            Log.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", Integer.valueOf(i2), str, Long.valueOf(aC), str);
                            p.c(aC, caVar);
                            p.b(aC, caVar, str);
                            ((com.tencent.mm.plugin.record.a.f) g.af(com.tencent.mm.plugin.record.a.f.class)).C(aC, str);
                            AppMethodBeat.o(215188);
                        } else {
                            caVar.setStatus(5);
                            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(aC, caVar);
                            p.dZ(str, str);
                            AppMethodBeat.o(215188);
                        }
                    }
                }), 0);
            } else {
                b(aC, a2.getTitle(), a2.getDescription(), str, anb);
            }
            AppMethodBeat.o(9528);
            return 0;
        }
    }

    public static String ds(String str, int i2) {
        AppMethodBeat.i(9529);
        String messageDigest = com.tencent.mm.b.g.getMessageDigest((str + i2 + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(9529);
        return messageDigest;
    }

    private static o HU(long j2) {
        AppMethodBeat.i(174299);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        o oVar = new o(String.format("%s/%d/", sb.append(g.aAh().hqG).append("record/").toString(), Long.valueOf(j2)));
        if (!oVar.exists() || !oVar.isDirectory()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(174299);
        return oVar;
    }

    public static void HV(long j2) {
        AppMethodBeat.i(9531);
        o HU = HU(j2);
        Log.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", aa.z(HU.her()), Boolean.valueOf(s.dy(aa.z(HU.mUri), true)));
        AppMethodBeat.o(9531);
    }

    public static String a(aml aml, long j2, int i2) {
        boolean z = true;
        AppMethodBeat.i(9532);
        if (aml == null) {
            AppMethodBeat.o(9532);
            return "";
        }
        String fj = fj(aml.dLl, i2);
        if (Util.isNullOrNil(fj) || !MMApplicationContext.isMMProcess() || !g.aAc()) {
            AppMethodBeat.o(9532);
            return "";
        }
        o HU = HU(j2);
        if (aml.dataType != 8 || Util.isNullOrNil(aml.title)) {
            z = false;
        } else {
            fj = aml.title;
            StringBuilder sb = new StringBuilder();
            g.aAi();
            HU = new o(String.format("%s/%d/%d/", sb.append(g.aAh().hqG).append("record/").toString(), Long.valueOf(j2), Integer.valueOf(aml.dLl.hashCode() & 255)));
            if (!HU.exists() || !HU.isDirectory()) {
                HU.mkdirs();
            }
        }
        if (aml.LvC != null && aml.LvC.trim().length() > 0 && !z) {
            fj = fj + "." + aml.LvC;
        }
        String z2 = aa.z(new o(HU, fj).her());
        AppMethodBeat.o(9532);
        return z2;
    }

    public static String c(aml aml, long j2) {
        AppMethodBeat.i(9533);
        String a2 = a(aml, j2, 1);
        AppMethodBeat.o(9533);
        return a2;
    }

    public static String b(aml aml, long j2, int i2) {
        AppMethodBeat.i(9536);
        if (aml == null || Util.isNullOrNil(aml.dLl)) {
            AppMethodBeat.o(9536);
            return "";
        }
        String z = aa.z(new o(HU(j2), fj(arI(aml.dLl), i2)).her());
        AppMethodBeat.o(9536);
        return z;
    }

    public static String f(aml aml, long j2) {
        AppMethodBeat.i(261902);
        String b2 = b(aml, j2, 1);
        AppMethodBeat.o(261902);
        return b2;
    }

    public static String arI(String str) {
        AppMethodBeat.i(9538);
        String str2 = str + "_t";
        AppMethodBeat.o(9538);
        return str2;
    }

    public static String fj(String str, int i2) {
        AppMethodBeat.i(9539);
        if (Util.isEqual(i2, 1)) {
            AppMethodBeat.o(9539);
            return str;
        }
        String str2 = i2 + "_" + str;
        AppMethodBeat.o(9539);
        return str2;
    }

    public static String g(String str, long j2, boolean z) {
        AppMethodBeat.i(9540);
        if (z) {
            String str2 = str + "@record_download@" + j2;
            AppMethodBeat.o(9540);
            return str2;
        }
        String str3 = str + "@record_upload@" + j2;
        AppMethodBeat.o(9540);
        return str3;
    }

    static {
        AppMethodBeat.i(9549);
        AppMethodBeat.o(9549);
    }

    public static c aKY(String str) {
        Map<String, String> parseXml;
        AppMethodBeat.i(9541);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.RecordMsgLogic", "xml is null");
            AppMethodBeat.o(9541);
            return null;
        }
        int hashCode = str.hashCode();
        c cVar = gAU.get(Integer.valueOf(hashCode));
        if (cVar != null) {
            Log.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
            AppMethodBeat.o(9541);
            return cVar;
        }
        if (str.trim().contains("<recordinfo>")) {
            parseXml = XmlParser.parseXml(str, "recordinfo", null);
        } else {
            parseXml = XmlParser.parseXml("<recordinfo>" + str + "</recordinfo>", "recordinfo", null);
        }
        if (parseXml == null) {
            Log.e("MicroMsg.RecordMsgLogic", "values is null: %s", str);
            AppMethodBeat.o(9541);
            return null;
        }
        c cVar2 = new c();
        cVar2.title = parseXml.get(".recordinfo.title");
        cVar2.desc = parseXml.get(".recordinfo.desc");
        cVar2.BGs = parseXml.get(".recordinfo.favusername");
        if (parseXml.get(".recordinfo.noteinfo") != null) {
            amv amv = new amv();
            amv.LxU = parseXml.get(".recordinfo.noteinfo.noteeditor");
            amv.LxT = parseXml.get(".recordinfo.noteinfo.noteauthor");
            cVar2.KBr = amv;
            cVar2.rnM = Util.getLong(parseXml.get(".recordinfo.edittime"), 0);
        }
        a(str, cVar2);
        gAU.put(Integer.valueOf(hashCode), cVar2);
        AppMethodBeat.o(9541);
        return cVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:148:0x1166  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af A[Catch:{ Exception -> 0x0d98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e2 A[Catch:{ Exception -> 0x0d6f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r18, com.tencent.mm.protocal.b.a.c r19) {
        /*
        // Method dump skipped, instructions count: 4460
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.b.p.a(java.lang.String, com.tencent.mm.protocal.b.a.c):void");
    }

    public static String a(c cVar, String str) {
        AppMethodBeat.i(9543);
        if (cVar == null || cVar.iAd == null) {
            Log.e("MicroMsg.RecordMsgLogic", "buildRecordInfoXML error: msgData or msgData.items is null");
            String nullAs = Util.nullAs(str, "");
            AppMethodBeat.o(9543);
            return nullAs;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<recordinfo>");
        sb.append("<title>").append(Util.escapeStringForXml(cVar.title)).append("</title>");
        sb.append("<desc>").append(Util.escapeStringForXml(cVar.desc)).append("</desc>");
        amv amv = cVar.KBr;
        if (amv != null) {
            sb.append("<noteinfo>");
            sb.append("<noteauthor>").append(Util.escapeStringForXml(amv.LxT)).append("</noteauthor>");
            sb.append("<noteeditor>").append(Util.escapeStringForXml(amv.LxU)).append("</noteeditor>");
            sb.append("</noteinfo>");
            sb.append("<editusr>").append(Util.escapeStringForXml(amv.LxU)).append("</editusr>");
        }
        sb.append("<edittime>").append(cVar.rnM).append("</edittime>");
        sb.append(q.dE(cVar.iAd));
        sb.append("<favusername>").append(Util.escapeStringForXml(cVar.BGs)).append("</favusername>");
        sb.append("</recordinfo>");
        String sb2 = sb.toString();
        AppMethodBeat.o(9543);
        return sb2;
    }

    public static int hR(int i2, int i3) {
        if (2 == i2) {
            return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
        }
        if (4 == i2) {
            return com.tencent.mm.i.a.MediaType_VIDEO;
        }
        if (i3 > 26214400) {
            return com.tencent.mm.i.a.gpO;
        }
        return com.tencent.mm.i.a.MediaType_FILE;
    }

    public static boolean b(aml aml, long j2, boolean z) {
        j jVar;
        AppMethodBeat.i(9544);
        if (aml == null) {
            Log.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
            AppMethodBeat.o(9544);
            return false;
        }
        String g2 = g(aml.dLl, j2, true);
        j aKX = ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(g2);
        if (aKX == null) {
            jVar = new j();
            jVar.field_cdnKey = aml.Lvp;
            jVar.field_cdnUrl = aml.KuR;
            jVar.field_dataId = aml.dLl;
            jVar.field_mediaId = g2;
            jVar.field_totalLen = (int) aml.LvI;
            jVar.field_localId = new Random().nextInt(2147483645) + 1;
            jVar.field_path = a(aml, j2, 1);
            jVar.field_type = 1;
            jVar.field_fileType = hR(aml.dataType, (int) aml.LvI);
            jVar.field_isThumb = false;
            jVar.field_tpaeskey = aml.LwC;
            jVar.field_tpauthkey = aml.iwT;
            jVar.field_tpdataurl = aml.LwF;
            Log.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(jVar.field_localId), Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(jVar)));
            if (!Util.isNullOrNil(aml.Lwp) && aml.Lwp.equals("WeNoteHtmlFile")) {
                ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(jVar);
            }
        } else {
            jVar = aKX;
        }
        Log.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", jVar);
        if (4 == jVar.field_status) {
            Log.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", Integer.valueOf(jVar.field_errCode));
            AppMethodBeat.o(9544);
            return false;
        }
        if (3 == jVar.field_status) {
            Log.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(jVar.field_errCode), Boolean.valueOf(z));
            if (z) {
                jVar.field_status = 1;
                ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(jVar, ch.COL_LOCALID);
            } else {
                AppMethodBeat.o(9544);
                return false;
            }
        }
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9544);
        return true;
    }

    public static boolean g(aml aml, long j2) {
        AppMethodBeat.i(9545);
        if (aml == null) {
            Log.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
            AppMethodBeat.o(9545);
            return true;
        }
        j aKX = ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(g(aml.dLl, j2, true));
        if (aKX == null) {
            Log.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
            AppMethodBeat.o(9545);
            return false;
        } else if (4 == aKX.field_status) {
            Log.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", Integer.valueOf(aKX.field_errCode));
            AppMethodBeat.o(9545);
            return true;
        } else {
            Log.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", Integer.valueOf(aKX.field_status));
            AppMethodBeat.o(9545);
            return false;
        }
    }

    public static boolean c(aml aml, long j2, boolean z) {
        j jVar;
        AppMethodBeat.i(9546);
        if (aml == null) {
            Log.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
            AppMethodBeat.o(9546);
            return false;
        }
        String arI = arI(aml.dLl);
        String g2 = g(arI, j2, true);
        j aKX = ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(g2);
        if (aKX == null) {
            jVar = new j();
            jVar.field_cdnKey = aml.Lvk;
            jVar.field_cdnUrl = aml.iwX;
            jVar.field_dataId = arI;
            jVar.field_mediaId = g2;
            jVar.field_totalLen = (int) aml.LvT;
            jVar.field_localId = new Random().nextInt(2147483645) + 1;
            jVar.field_path = b(aml, j2, 1);
            jVar.field_type = 1;
            jVar.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
            jVar.field_isThumb = true;
            jVar.field_tpdataurl = aml.iwO;
            jVar.field_tpauthkey = aml.iwT;
            jVar.field_tpaeskey = aml.iwU;
            Log.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(jVar.field_localId), Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(jVar)));
        } else {
            jVar = aKX;
        }
        Log.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", jVar);
        if (4 == jVar.field_status) {
            Log.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", Integer.valueOf(jVar.field_errCode));
            AppMethodBeat.o(9546);
            return false;
        }
        if (3 == jVar.field_status) {
            Log.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(jVar.field_errCode), Boolean.valueOf(z));
            if (z) {
                jVar.field_status = 1;
                ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(jVar, ch.COL_LOCALID);
            } else {
                AppMethodBeat.o(9546);
                return false;
            }
        }
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9546);
        return true;
    }

    public static String Is(String str) {
        AppMethodBeat.i(9547);
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
        if (Kn == null) {
            Log.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", str);
            AppMethodBeat.o(9547);
            return "";
        }
        String arJ = Kn.arJ();
        if (ab.Eq(arJ)) {
            List<String> Ic = v.Ic(str);
            String aTY = z.aTY();
            if (Ic == null || Ic.isEmpty()) {
                Log.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
            } else {
                Ic.remove(aTY);
                Ic.add(0, aTY);
                arJ = v.e(Ic, 3);
            }
        }
        AppMethodBeat.o(9547);
        return arJ;
    }

    public static boolean a(String str, long j2, boolean z, String str2) {
        AppMethodBeat.i(215196);
        if (ab.IO(str)) {
            rb rbVar = new rb();
            rbVar.dXE.msgId = j2;
            rbVar.dXE.dQA = z;
            rbVar.dXE.errMsg = Util.nullAs(str2, "");
            EventCenter.instance.publish(rbVar);
            AppMethodBeat.o(215196);
            return true;
        }
        AppMethodBeat.o(215196);
        return false;
    }

    public static k.b a(String str, String str2, anb anb) {
        AppMethodBeat.i(9520);
        LinkedList<aml> linkedList = anb.ppH;
        StringBuilder sb = new StringBuilder();
        sb.append("<recordinfo>");
        sb.append("<title>").append(Util.escapeStringForXml(str)).append("</title>");
        sb.append("<desc>").append(Util.escapeStringForXml(str2)).append("</desc>");
        a(sb, anb);
        sb.append(q.dE(linkedList));
        sb.append("<favusername>").append(Util.escapeStringForXml(z.aTY())).append("</favusername>");
        sb.append("</recordinfo>");
        k.b bVar = new k.b();
        bVar.title = str;
        if (str2 != null && str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        bVar.description = str2;
        if (Util.isNullOrNil(linkedList) || !l.j(linkedList.get(0))) {
            bVar.type = 19;
            bVar.url = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            bVar.type = 24;
            bVar.url = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        bVar.action = "view";
        bVar.ixl = sb.toString();
        AppMethodBeat.o(9520);
        return bVar;
    }

    private static void a(StringBuilder sb, anb anb) {
        AppMethodBeat.i(9521);
        if (anb.KBr != null) {
            sb.append("<noteinfo>");
            sb.append("<noteauthor>").append(Util.escapeStringForXml(anb.KBr.LxT)).append("</noteauthor>");
            sb.append("<noteeditor>").append(Util.escapeStringForXml(anb.KBr.LxU)).append("</noteeditor>");
            sb.append("</noteinfo>");
            sb.append("<edittime>").append(anb.rnM).append("</edittime>");
            sb.append("<editusr>").append(Util.escapeStringForXml(anb.KBr.LxU)).append("</editusr>");
        }
        AppMethodBeat.o(9521);
    }

    private static void a(d dVar, aml aml, int i2) {
        AppMethodBeat.i(9524);
        String str = aml.LvN;
        if (s.YS(str)) {
            dVar.thumbPath = str;
            AppMethodBeat.o(9524);
            return;
        }
        dVar.dXJ = i2;
        AppMethodBeat.o(9524);
    }

    public static boolean d(aml aml, long j2) {
        AppMethodBeat.i(9534);
        boolean exists = new o(a(aml, j2, 1)).exists();
        AppMethodBeat.o(9534);
        return exists;
    }

    public static boolean e(aml aml, long j2) {
        AppMethodBeat.i(9535);
        boolean exists = new o(b(aml, j2, 1)).exists();
        AppMethodBeat.o(9535);
        return exists;
    }

    public static boolean h(aml aml, long j2) {
        AppMethodBeat.i(9548);
        boolean isGif = ImgUtil.isGif(a(aml, j2, 1));
        AppMethodBeat.o(9548);
        return isGif;
    }

    static /* synthetic */ void c(long j2, ca caVar) {
        anb anb;
        String str;
        AppMethodBeat.i(215198);
        k.b HD = k.b.HD(caVar.field_content);
        b f2 = f(HD);
        if (f2 != null) {
            str = f2.desc;
            anb = f2.dGb;
        } else {
            anb = null;
            str = null;
        }
        if (anb == null) {
            caVar.setStatus(5);
            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(j2, caVar);
            AppMethodBeat.o(215198);
            return;
        }
        caVar.setContent(k.b.a(a(HD.title, str, anb), null, null));
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(j2, caVar);
        AppMethodBeat.o(215198);
    }

    static /* synthetic */ void a(long j2, ca caVar, String str) {
        AppMethodBeat.i(215199);
        k.b HD = k.b.HD(caVar.field_content);
        String str2 = "";
        anb anb = null;
        b f2 = f(HD);
        if (f2 != null) {
            str2 = f2.desc;
            anb = f2.dGb;
        }
        a(j2, HD.getTitle(), str2, str, anb);
        AppMethodBeat.o(215199);
    }

    static /* synthetic */ void dZ(String str, String str2) {
        AppMethodBeat.i(215200);
        ca caVar = new ca();
        caVar.setCreateTime(bp.Kw(str));
        caVar.Cy(str);
        caVar.setContent(str2);
        caVar.setType(10000);
        caVar.setStatus(6);
        caVar.nv(0);
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
        AppMethodBeat.o(215200);
    }

    static /* synthetic */ void a(long j2, long j3, ca caVar, String str, boolean z) {
        AppMethodBeat.i(215202);
        k.b HD = k.b.HD(caVar.field_content);
        String str2 = "";
        String str3 = "";
        anb anb = null;
        b f2 = f(HD);
        if (f2 != null) {
            str2 = f2.desc;
            str3 = f2.BGs;
            anb = f2.dGb;
        }
        com.tencent.mm.plugin.record.a.k kVar = new com.tencent.mm.plugin.record.a.k();
        kVar.field_msgId = j2;
        kVar.field_oriMsgId = j3;
        kVar.field_toUser = str;
        kVar.field_title = HD.title;
        kVar.field_desc = str2;
        kVar.field_dataProto = anb;
        kVar.field_type = 0;
        kVar.field_favFrom = str3;
        kVar.field_localId = new Random().nextInt(2147483645) + 1;
        Log.i("MicroMsg.RecordMsgLogic", "summerrecord Normal RecordMsgStorage insert ret:%b, id:%d, oriMsgId:%d localid:%d", Boolean.valueOf(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(kVar)), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(kVar.field_localId));
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(kVar, z);
        AppMethodBeat.o(215202);
    }

    static /* synthetic */ void b(long j2, ca caVar, String str) {
        AppMethodBeat.i(215204);
        k.b HD = k.b.HD(caVar.field_content);
        String str2 = "";
        anb anb = null;
        b f2 = f(HD);
        if (f2 != null) {
            str2 = f2.desc;
            anb = f2.dGb;
        }
        b(j2, HD.getTitle(), str2, str, anb);
        AppMethodBeat.o(215204);
    }
}
