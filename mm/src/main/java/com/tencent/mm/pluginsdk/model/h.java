package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.aj.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.n.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class h {
    public static boolean a(cz czVar, Intent intent) {
        AppMethodBeat.i(30940);
        if (czVar == null) {
            Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
            AppMethodBeat.o(30940);
            return false;
        }
        double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
        int intExtra = intent.getIntExtra("kwebmap_scale", 0);
        String nullAs = Util.nullAs(intent.getStringExtra("Kwebmap_locaion"), "");
        String stringExtra = intent.getStringExtra("kPoiName");
        intent.getCharSequenceExtra("kRemark");
        intent.getStringArrayListExtra("kTags");
        ams ams = new ams();
        ams.bgW(nullAs);
        ams.C(doubleExtra);
        ams.B(doubleExtra2);
        ams.aji(intExtra);
        ams.bgX(stringExtra);
        anb anb = new anb();
        anh anh = new anh();
        String aTY = z.aTY();
        anh.bhf(aTY);
        anh.bhg(aTY);
        anh.ajm(6);
        anh.MA(Util.nowMilliSecond());
        anb.d(ams);
        anb.a(anh);
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 6;
        AppMethodBeat.o(30940);
        return true;
    }

    public static boolean a(cz czVar, int i2, String str, String str2, int i3, String str3, String str4, boolean z) {
        AppMethodBeat.i(232140);
        if (czVar == null || Util.isNullOrNil(str)) {
            Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(232140);
            return false;
        }
        Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", str3, str4, str, Integer.valueOf(i2));
        if (new o(str).length() > ((long) ((af) g.ah(af.class)).getVideoSizeLimit(z))) {
            if (z) {
                czVar.dFZ.dGe = R.string.ccw;
            } else {
                czVar.dFZ.dGe = R.string.ccv;
            }
            AppMethodBeat.o(232140);
            return false;
        }
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        aml.bgt(str);
        aml.ajd(4);
        aml.bgp(s.akC(str));
        aml.bgu(str2);
        aml.ajc(i3);
        aml.bgf(str3);
        aml.bgg(str4);
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(i2);
        anh.MA(Util.nowMilliSecond());
        anb.a(anh);
        anb.ppH.add(aml);
        czVar.dFZ.title = aml.title;
        czVar.dFZ.desc = aml.title;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 4;
        AppMethodBeat.o(232140);
        return true;
    }

    public static boolean a(cz czVar, int i2, String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(232141);
        if (czVar == null || Util.isNullOrNil(str)) {
            Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(232141);
            return false;
        }
        Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", str2, str3, str, Integer.valueOf(i2));
        if (new o(str).length() > ((long) ((af) g.ah(af.class)).getFileSizeLimit(z))) {
            if (z) {
                czVar.dFZ.dGe = R.string.ccw;
            } else {
                czVar.dFZ.dGe = R.string.ccv;
            }
            AppMethodBeat.o(232141);
            return false;
        }
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        aml.bgt(str);
        aml.ajd(8);
        aml.bgp(s.akC(str));
        aml.At(true);
        aml.bgf(str2);
        aml.bgg(str3);
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(i2);
        anh.MA(Util.nowMilliSecond());
        anb.a(anh);
        anb.ppH.add(aml);
        czVar.dFZ.title = aml.title;
        czVar.dFZ.desc = aml.title;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 8;
        AppMethodBeat.o(232141);
        return true;
    }

    public static boolean b(cz czVar, String str, int i2) {
        AppMethodBeat.i(30942);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            czVar.dFZ.dGe = R.string.c_2;
            AppMethodBeat.o(30942);
            return false;
        }
        Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", str, Integer.valueOf(i2));
        anb anb = new anb();
        anh anh = new anh();
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(i2);
        anh.MA(Util.nowMilliSecond());
        anb.a(anh);
        czVar.dFZ.desc = str;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 1;
        AppMethodBeat.o(30942);
        return true;
    }

    public static boolean a(cz czVar, int i2, String str) {
        AppMethodBeat.i(30943);
        if (czVar == null || Util.isNullOrNil(str)) {
            Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(30943);
            return false;
        }
        Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", str, Integer.valueOf(i2));
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        aml.ajd(2);
        aml.bgt(str);
        aml.bgs(com.tencent.mm.b.g.getMessageDigest((aml.toString() + 2 + System.currentTimeMillis()).getBytes()));
        hb hbVar = new hb();
        hbVar.dLm.type = 27;
        hbVar.dLm.dLo = aml;
        EventCenter.instance.publish(hbVar);
        String str2 = hbVar.dLn.thumbPath;
        BitmapUtil.createThumbNail(str, 150, 150, Bitmap.CompressFormat.JPEG, 90, str2, true);
        aml.bgu(str2);
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(i2);
        anh.MA(Util.nowMilliSecond());
        anb.a(anh);
        anb.ppH.add(aml);
        czVar.dFZ.title = aml.title;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 2;
        AppMethodBeat.o(30943);
        return true;
    }

    public static boolean a(cz czVar, long j2) {
        AppMethodBeat.i(30944);
        boolean d2 = d(czVar, ((l) g.af(l.class)).eiy().Hb(j2));
        AppMethodBeat.o(30944);
        return d2;
    }

    public static boolean d(cz czVar, ca caVar) {
        boolean z = false;
        AppMethodBeat.i(30945);
        if (czVar == null || caVar == null) {
            Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(30945);
        } else {
            ca aZ = ca.aZ(caVar);
            if (aZ.isText()) {
                z = e(czVar, aZ);
            } else if (aZ.gAy()) {
                z = g(czVar, aZ);
            } else if (aZ.dOS()) {
                z = a(czVar, aZ);
            } else if (aZ.gAz()) {
                z = f(czVar, aZ);
            } else if (aZ.cWJ() || aZ.cWL()) {
                z = i(czVar, aZ);
            } else if (aZ.cWK()) {
                z = h(czVar, aZ);
            } else if (aZ.gAt()) {
                z = c(czVar, aZ);
            } else if (!aZ.gDl() && aZ.dOQ() && !aZ.gDo()) {
                z = j(czVar, aZ);
            } else {
                czVar.dFZ.dGe = R.string.c__;
            }
            czVar.dFZ.dFN = aZ.field_content;
            if (z || czVar.dFZ.dGe == 0) {
                e.a(aZ, czVar, z);
            }
            AppMethodBeat.o(30945);
        }
        return z;
    }

    private static anh aR(ca caVar) {
        String str;
        AppMethodBeat.i(30946);
        anh anh = new anh();
        if (caVar.field_isSend == 1) {
            anh.bhf(z.aTY());
            anh.bhg(caVar.field_talker);
            if (ab.Eq(caVar.field_talker)) {
                anh.bhi(anh.dRL);
            }
        } else {
            anh.bhf(caVar.field_talker);
            anh.bhg(z.aTY());
            if (ab.Eq(caVar.field_talker)) {
                if (caVar.field_content != null) {
                    str = caVar.field_content.substring(0, Math.max(0, caVar.field_content.indexOf(58)));
                } else {
                    str = "";
                }
                anh.bhi(str);
                if (!Util.isNullOrNil(anh.LxA) && !caVar.gAy()) {
                    caVar.setContent(caVar.field_content.substring(anh.LxA.length() + 1));
                    if (caVar.field_content.length() > 0 && '\n' == caVar.field_content.charAt(0)) {
                        caVar.setContent(caVar.field_content.substring(1));
                    }
                    if (caVar.gDz()) {
                        if (!Util.isNullOrNil(caVar.field_transContent) && caVar.field_transContent.startsWith(anh.LxA)) {
                            caVar.CB(caVar.field_transContent.substring(anh.LxA.length() + 1));
                        }
                        if (caVar.field_transContent.length() > 0 && '\n' == caVar.field_transContent.charAt(0)) {
                            caVar.CB(caVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        anh.ajm(1);
        anh.MA(caVar.field_createTime);
        anh.bhj(new StringBuilder().append(caVar.field_msgSvrId).toString());
        if (caVar.field_msgSvrId > 0) {
            anh.bhh(new StringBuilder().append(caVar.field_msgSvrId).toString());
        }
        AppMethodBeat.o(30946);
        return anh;
    }

    private static boolean e(cz czVar, ca caVar) {
        AppMethodBeat.i(30947);
        anb anb = new anb();
        anb.a(aR(caVar));
        czVar.dFZ.dGb = anb;
        czVar.dFZ.desc = caVar.field_content;
        czVar.dFZ.type = 1;
        if (f.bnP(czVar.dFZ.desc) > c.aql()) {
            czVar.dFZ.dGe = R.string.cct;
            AppMethodBeat.o(30947);
            return false;
        }
        AppMethodBeat.o(30947);
        return true;
    }

    private static boolean f(cz czVar, ca caVar) {
        AppMethodBeat.i(30948);
        com.tencent.mm.av.g gVar = null;
        if (caVar.field_msgId > 0) {
            gVar = q.bcR().H(caVar.field_talker, caVar.field_msgId);
        }
        if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
            gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
        }
        if (gVar == null) {
            Log.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
            czVar.dFZ.dGe = R.string.c_8;
            AppMethodBeat.o(30948);
            return false;
        }
        anb anb = new anb();
        anb.a(aR(caVar));
        aml aml = new aml();
        a(aml, caVar);
        aml.ajd(2);
        aml.bgt(q.bcR().o(com.tencent.mm.av.h.c(gVar), "", ""));
        if (gVar.bcv()) {
            com.tencent.mm.av.g tl = q.bcR().tl(gVar.iXx);
            if (tl.iKP > tl.offset) {
                aml.bgt(q.bcR().o("SERVERID://" + caVar.field_msgSvrId, "", ""));
            }
        }
        aml.bgu(q.bcR().R(caVar.field_imgPath, true));
        aml.bgN(br.KB(caVar.fqK));
        LinkedList<aml> linkedList = new LinkedList<>();
        linkedList.add(aml);
        anb.bH(linkedList);
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 2;
        AppMethodBeat.o(30948);
        return true;
    }

    private static boolean a(cz czVar, ca caVar) {
        AppMethodBeat.i(30949);
        anb anb = new anb();
        anb.a(aR(caVar));
        Map<String, String> parseXml = XmlParser.parseXml(caVar.field_content, "msg", null);
        if (parseXml != null) {
            try {
                ams ams = new ams();
                ams.bgW(parseXml.get(".msg.location.$label"));
                ams.C(Double.parseDouble(parseXml.get(".msg.location.$x")));
                ams.B(Double.parseDouble(parseXml.get(".msg.location.$y")));
                ams.aji(Integer.valueOf(parseXml.get(".msg.location.$scale")).intValue());
                ams.bgX(parseXml.get(".msg.location.$poiname"));
                anb.d(ams);
                czVar.dFZ.type = 6;
                czVar.dFZ.dGb = anb;
                AppMethodBeat.o(30949);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.GetFavDataSource", "parse failed, %s", e2.getStackTrace().toString());
            }
        }
        czVar.dFZ.dGe = R.string.c_b;
        AppMethodBeat.o(30949);
        return false;
    }

    private static boolean g(cz czVar, ca caVar) {
        AppMethodBeat.i(30951);
        anb anb = new anb();
        anb.a(aR(caVar));
        aml aml = new aml();
        a(aml, caVar);
        if (ab.Jp(caVar.field_talker)) {
            aml.bgt(bdo(caVar.field_imgPath));
        } else {
            aml.bgt(com.tencent.mm.modelvoice.s.getFullPath(caVar.field_imgPath));
        }
        aml.ajd(3);
        aml.At(true);
        b Rf = com.tencent.mm.modelvoice.s.Rf(caVar.field_imgPath);
        if (Rf == null) {
            AppMethodBeat.o(30951);
            return false;
        }
        aml.bgp(ahD(Rf.getFormat()));
        aml.ajc((int) new p(caVar.field_content).time);
        LinkedList<aml> linkedList = new LinkedList<>();
        linkedList.add(aml);
        anb.bH(linkedList);
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 3;
        AppMethodBeat.o(30951);
        return true;
    }

    private static String bdo(String str) {
        AppMethodBeat.i(30952);
        String genPath = FilePathGenerator.genPath(com.tencent.mm.plugin.record.b.aTb(), "recbiz_", str, ".rec", 2);
        if (Util.isNullOrNil(genPath)) {
            AppMethodBeat.o(30952);
            return null;
        } else if (new o(genPath).exists()) {
            AppMethodBeat.o(30952);
            return genPath;
        } else {
            AppMethodBeat.o(30952);
            return genPath;
        }
    }

    public static String ahD(int i2) {
        if (i2 == 1) {
            return "speex";
        }
        if (i2 == 4) {
            return "silk";
        }
        return "amr";
    }

    private static boolean i(cz czVar, ca caVar) {
        AppMethodBeat.i(30954);
        anb anb = new anb();
        anb.a(aR(caVar));
        aml aml = new aml();
        a(aml, caVar);
        com.tencent.mm.modelvideo.o.bhj();
        aml.bgu(t.Qx(caVar.field_imgPath));
        aml.bgp(s.akC(aml.LvL));
        if (caVar.cWL()) {
            czVar.dFZ.type = 16;
            aml.ajd(15);
        } else {
            czVar.dFZ.type = 4;
            aml.ajd(4);
        }
        com.tencent.mm.modelvideo.s QN = u.QN(caVar.field_imgPath);
        if (QN == null) {
            Log.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
            czVar.dFZ.dGe = R.string.c_1;
            AppMethodBeat.o(30954);
            return false;
        }
        Log.i("MicroMsg.GetFavDataSource", "video length is %d", Integer.valueOf(QN.iKP));
        if (QN.iKP > ((af) g.ah(af.class)).getVideoSizeLimit(true)) {
            czVar.dFZ.dGe = R.string.ccw;
            AppMethodBeat.o(30954);
            return false;
        } else if (!caVar.cWL() || !u.QO(QN.getFileName())) {
            if (QN.bhy()) {
                com.tencent.mm.modelvideo.o.bhj();
                String Qw = t.Qw(caVar.field_imgPath);
                Log.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", Qw);
                aml.bgt(Qw);
            } else {
                Log.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
                aml.bgt("");
            }
            aml.ajc(QN.iFw);
            aml.bgN(br.KB(caVar.fqK));
            LinkedList<aml> linkedList = new LinkedList<>();
            linkedList.add(aml);
            anb.bH(linkedList);
            czVar.dFZ.dGb = anb;
            com.tencent.mm.modelvideo.s QN2 = u.QN(caVar.field_imgPath);
            aml.bgD(QN2.ean);
            eeq eeq = QN2.jsw;
            if (eeq != null && !Util.isNullOrNil(eeq.izf)) {
                amo amo = new amo();
                amo.iyZ = eeq.iyZ;
                amo.LxJ = eeq.LxJ;
                amo.izc = eeq.izc;
                amo.izd = eeq.izd;
                amo.izb = eeq.izb;
                amo.ize = eeq.ize;
                amo.izf = eeq.izf;
                amo.izg = eeq.izg;
                aml.a(amo);
            }
            AppMethodBeat.o(30954);
            return true;
        } else {
            czVar.dFZ.dGe = R.string.c_1;
            AppMethodBeat.o(30954);
            return false;
        }
    }

    private static aml a(ca caVar, k.b bVar, int i2) {
        AppMethodBeat.i(30955);
        aml aml = new aml();
        a(aml, caVar);
        aml.bgm(bVar.ixd);
        aml.bgn(bVar.ixe);
        aml.bgl(bVar.url);
        aml.As(true);
        o oVar = new o(Util.nullAs(q.bcR().R(caVar.field_imgPath, true), ""));
        if (oVar.exists()) {
            aml.bgu(aa.z(oVar.her()));
        } else {
            aml.At(true);
        }
        aml.bgf(bVar.title);
        aml.bgg(bVar.description);
        aml.bgE(bVar.canvasPageXml);
        aml.ajd(i2);
        aml.bgD(bVar.ean);
        com.tencent.mm.pluginsdk.ui.tools.b bVar2 = (com.tencent.mm.pluginsdk.ui.tools.b) bVar.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
        if (bVar2 != null) {
            aml.bgL(bVar2.songAlbumUrl);
            aml.bgM(bVar2.songLyric);
            if (i2 == 29) {
                amm amm = new amm();
                css css = new css();
                css.Ktn = bVar2.Ktn;
                css.Kto = bVar2.Kto;
                css.Ktp = bVar2.Ktp;
                css.Ktq = bVar2.Ktq;
                css.singerName = bVar2.Ktr;
                css.albumName = bVar2.Kts;
                css.musicGenre = bVar2.Ktt;
                css.issueDate = Util.safeParseLong(bVar2.Ktu);
                css.identification = bVar2.Ktv;
                css.Alz = bVar2.Alz;
                css.extraInfo = bVar2.Ktw;
                amm.e(css);
                aml.a(amm);
            }
        }
        AppMethodBeat.o(30955);
        return aml;
    }

    private static void a(boolean z, ca caVar, k.b bVar, cz czVar, anb anb) {
        int i2;
        int i3;
        AppMethodBeat.i(232142);
        if (z) {
            i2 = 29;
            i3 = 21;
        } else {
            i2 = 7;
            i3 = 7;
        }
        anb.ppH.add(a(caVar, bVar, i2));
        czVar.dFZ.type = i3;
        AppMethodBeat.o(232142);
    }

    private static boolean j(cz czVar, ca caVar) {
        AppMethodBeat.i(30956);
        anb anb = new anb();
        anb.a(aR(caVar));
        String str = caVar.field_content;
        if (str == null) {
            czVar.dFZ.dGe = R.string.c_b;
            AppMethodBeat.o(30956);
            return false;
        }
        k.b HD = k.b.HD(str);
        if (HD == null) {
            czVar.dFZ.dGe = R.string.c_b;
            AppMethodBeat.o(30956);
            return false;
        }
        czVar.dFZ.dGb = anb;
        anh anh = anb.Lya;
        anh.bhl(HD.appId);
        anh.bhn(HD.eag);
        switch (HD.type) {
            case 1:
            case 53:
            case n.CTRL_INDEX:
            case 60:
                czVar.dFZ.dGb = anb;
                czVar.dFZ.desc = HD.title;
                czVar.dFZ.type = 1;
                AppMethodBeat.o(30956);
                return true;
            case 2:
                if (!g.aAh().isSDCardAvailable()) {
                    czVar.dFZ.dGe = R.string.c_h;
                    AppMethodBeat.o(30956);
                    return false;
                }
                com.tencent.mm.pluginsdk.model.app.c bdx = a.cgO().bdx(HD.dCK);
                aml aml = new aml();
                a(aml, caVar);
                if (bdx != null) {
                    aml.bgt(bdx.field_fileFullPath);
                }
                String R = q.bcR().R(caVar.field_imgPath, true);
                if (s.YS(R)) {
                    aml.bgu(R);
                }
                aml.ajd(2);
                aml.bgf(HD.title);
                aml.bgg(HD.description);
                aml.bgN(br.KB(caVar.fqK));
                anb.ppH.add(aml);
                czVar.dFZ.type = 2;
                AppMethodBeat.o(30956);
                return true;
            case 3:
                a(false, caVar, HD, czVar, anb);
                AppMethodBeat.o(30956);
                return true;
            case 4:
                aml a2 = a(caVar, HD, 4);
                anb.bhd(a2.title);
                anb.bhe(a2.desc);
                a2.bgN(br.KB(caVar.fqK));
                anb.ppH.add(a2);
                czVar.dFZ.type = 4;
                AppMethodBeat.o(30956);
                return true;
            case 5:
                if (HD.url == null || HD.url.equals("")) {
                    czVar.dFZ.dGe = R.string.c_6;
                    AppMethodBeat.o(30956);
                    return false;
                }
                anb.Lya.bhm(HD.url);
                anq anq = new anq();
                anq.bhv(HD.thumburl);
                aj ajVar = (aj) HD.as(aj.class);
                if (ajVar != null && !Util.isNullOrNil(ajVar.IEy)) {
                    StringBuilder sb = new StringBuilder();
                    ajVar.a(sb, null, null, null, 0, 0);
                    anq.bhx(sb.toString());
                }
                anb.b(anq);
                a(caVar, anb, anq);
                aml a3 = a(caVar, HD, 5);
                anb.ppH.add(a3);
                anb.bhd(a3.title);
                anb.bhe(a3.desc);
                czVar.dFZ.type = 5;
                AppMethodBeat.o(30956);
                return true;
            case 6:
                if (!g.aAh().isSDCardAvailable()) {
                    czVar.dFZ.dGe = R.string.c_h;
                    AppMethodBeat.o(30956);
                    return false;
                }
                com.tencent.mm.pluginsdk.model.app.c bdx2 = a.cgO().bdx(HD.dCK);
                aml aml2 = new aml();
                if (bdx2 != null) {
                    aml2.bgt(bdx2.field_fileFullPath);
                }
                a(aml2, caVar);
                aml2.ajd(8);
                aml2.bgp(HD.iwJ);
                String R2 = q.bcR().R(caVar.field_imgPath, true);
                if (Util.isNullOrNil(R2)) {
                    aml2.At(true);
                }
                if (s.YS(R2)) {
                    aml2.bgu(R2);
                }
                aml2.bgf(HD.title);
                aml2.bgg(HD.description);
                anb.ppH.add(aml2);
                czVar.dFZ.desc = HD.title;
                czVar.dFZ.type = 8;
                AppMethodBeat.o(30956);
                return true;
            case 7:
                if (HD.dCK == null || HD.dCK.length() == 0) {
                    czVar.dFZ.dGe = R.string.c_3;
                } else if (!g.aAh().isSDCardAvailable()) {
                    czVar.dFZ.dGe = R.string.c_h;
                    AppMethodBeat.o(30956);
                    return false;
                }
                czVar.dFZ.dGe = R.string.c__;
                AppMethodBeat.o(30956);
                return false;
            case 10:
                ana ana = new ana();
                ana.bgY(HD.title);
                ana.bgZ(HD.description);
                ana.ajj(HD.ixg);
                ana.bhb(HD.ixh);
                ana.bha(HD.thumburl);
                czVar.dFZ.title = HD.title;
                czVar.dFZ.desc = HD.description;
                czVar.dFZ.type = 10;
                anb.b(ana);
                AppMethodBeat.o(30956);
                return true;
            case 13:
                ana ana2 = new ana();
                ana2.bgY(HD.title);
                ana2.bgZ(HD.description);
                ana2.ajj(HD.ixm);
                ana2.bhb(HD.ixn);
                ana2.bha(HD.thumburl);
                czVar.dFZ.title = HD.title;
                czVar.dFZ.desc = HD.description;
                czVar.dFZ.type = 11;
                anb.b(ana2);
                AppMethodBeat.o(30956);
                return true;
            case 19:
                czVar.dFZ.dGc = new anp();
                boolean a4 = a(czVar, HD, anb, caVar, false);
                AppMethodBeat.o(30956);
                return a4;
            case 20:
                ank ank = new ank();
                ank.bho(HD.title);
                ank.bhp(HD.description);
                ank.bhr(HD.ixk);
                ank.bhq(HD.thumburl);
                czVar.dFZ.title = HD.title;
                czVar.dFZ.desc = HD.description;
                czVar.dFZ.type = 15;
                anb.b(ank);
                AppMethodBeat.o(30956);
                return true;
            case 24:
                czVar.dFZ.dGc = new anp();
                boolean a5 = a(czVar, HD, anb, caVar, true);
                AppMethodBeat.o(30956);
                return a5;
            case 33:
            case 36:
                amj amj = new amj();
                amj.username = HD.izi;
                amj.appId = HD.izj;
                amj.dMe = HD.izz;
                amj.iconUrl = HD.izB;
                amj.dCx = HD.izh;
                amj.Lve = HD.eah;
                amj.lyE = HD.izr;
                amj.type = HD.izk;
                com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class);
                if (aVar != null) {
                    amj.leb = aVar.ivc;
                    amj.eda = aVar.ive;
                    amj.subType = aVar.ivf;
                }
                amj.version = HD.izA;
                aml aml3 = new aml();
                a(aml3, caVar);
                aml3.ajd(19);
                String R3 = q.bcR().R(caVar.field_imgPath, true);
                if (Util.isNullOrNil(R3)) {
                    aml3.At(true);
                }
                if (s.YS(R3)) {
                    aml3.bgu(R3);
                }
                aml3.bgf(HD.title);
                aml3.bgg(HD.description);
                anb.ppH.add(aml3);
                anb.bhd(HD.title);
                anh.ajm(ab.Eq(caVar.field_talker) ? 22 : 21);
                czVar.dFZ.title = HD.title;
                czVar.dFZ.desc = HD.description;
                czVar.dFZ.type = 19;
                anb.c(amj);
                AppMethodBeat.o(30956);
                return true;
            case 51:
                com.tencent.mm.plugin.i.a.f fVar = (com.tencent.mm.plugin.i.a.f) HD.as(com.tencent.mm.plugin.i.a.f.class);
                if (fVar != null) {
                    bcj bcj = fVar.jlg;
                    anb.bhd(bcj.nickname + MMApplicationContext.getContext().getString(R.string.cce));
                    anb.bhe(bcj.desc);
                    anb.d(bcj);
                    czVar.dFZ.type = 20;
                    AppMethodBeat.o(30956);
                    return true;
                }
                AppMethodBeat.o(30956);
                return false;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                a(true, caVar, HD, czVar, anb);
                AppMethodBeat.o(30956);
                return true;
            default:
                czVar.dFZ.dGe = R.string.c__;
                AppMethodBeat.o(30956);
                return false;
        }
    }

    private static boolean c(cz czVar, ca caVar) {
        i Mx;
        AppMethodBeat.i(30957);
        anb anb = new anb();
        anh aR = aR(caVar);
        anb.a(aR);
        try {
            com.tencent.mm.ag.u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content);
            LinkedList linkedList = a2.iAd;
            aR.bhn(a2.eag);
            if (linkedList != null && linkedList.size() > czVar.dFZ.dGd) {
                Log.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", Integer.valueOf(czVar.dFZ.dGd));
                v vVar = (v) linkedList.get(czVar.dFZ.dGd);
                if (m.HF(vVar.iAt)) {
                    czVar.dFZ.dGe = R.string.c__;
                    AppMethodBeat.o(30957);
                    return false;
                }
                aR.bhm(vVar.url);
                if (czVar.dFZ.dGd > 0) {
                    aR.bhh("");
                }
                aml aml = new aml();
                aml.bgf(vVar.title);
                aml.bgg(vVar.iAq);
                a(aml, caVar);
                String a3 = m.a(vVar);
                if (Util.isNullOrNil(a3) && (Mx = com.tencent.mm.aj.p.aYB().Mx(caVar.field_talker)) != null) {
                    a3 = Mx.aYt();
                }
                if (!Util.isNullOrNil(a3)) {
                    aml.bgu(s.bdu(a3));
                    aml.At(false);
                    if (Util.isNullOrNil(aml.LvN) || !s.YS(aml.LvN)) {
                        aml.bgo(a3);
                        aml.At(true);
                    }
                } else {
                    aml.At(true);
                }
                aml.As(true);
                aml.ajd(5);
                anb.ppH.add(aml);
                czVar.dFZ.dGb = anb;
                czVar.dFZ.desc = vVar.title;
                czVar.dFZ.type = 5;
                anq anq = new anq();
                anq.bhv(a3);
                anq.bhs(vVar.title);
                anq.bht(vVar.iAq);
                anb.b(anq);
                anb.f(m.a(vVar, anq, a2.eag, a2.eah));
                AppMethodBeat.o(30957);
                return true;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GetFavDataSource", e2, "", new Object[0]);
            Log.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", e2.getLocalizedMessage());
        }
        czVar.dFZ.dGe = R.string.c_b;
        AppMethodBeat.o(30957);
        return false;
    }

    private static void a(ca caVar, anb anb, anq anq) {
        AppMethodBeat.i(30958);
        anb.f(m.a(caVar, anq));
        AppMethodBeat.o(30958);
    }

    private static boolean a(cz czVar, k.b bVar, anb anb, ca caVar, boolean z) {
        aml aml;
        String format;
        AppMethodBeat.i(30959);
        rc rcVar = new rc();
        rcVar.dXF.type = 0;
        rcVar.dXF.dXH = bVar.ixl;
        EventCenter.instance.publish(rcVar);
        com.tencent.mm.protocal.b.a.c cVar = rcVar.dXG.dXP;
        if (cVar == null) {
            Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
            czVar.dFZ.dGe = R.string.c_b;
            AppMethodBeat.o(30959);
            return false;
        }
        int i2 = 0;
        anb.bhd(cVar.title);
        Iterator<aml> it = cVar.iAd.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            switch (next.dataType) {
                case 1:
                    aml a2 = a(next, z);
                    a2.ajd(1);
                    a2.bgg(next.desc);
                    czVar.dFZ.dGc.Lyp++;
                    aml = a2;
                    break;
                case 2:
                    long j2 = caVar.field_msgId;
                    aml a3 = a(next, z);
                    a3.ajd(2);
                    rc rcVar2 = new rc();
                    rcVar2.dXF.type = 1;
                    rcVar2.dXF.dKT = next;
                    rcVar2.dXF.msgId = j2;
                    EventCenter.instance.publish(rcVar2);
                    if (Util.isNullOrNil(rcVar2.dXG.dataPath) && Util.isNullOrNil(rcVar2.dXG.thumbPath)) {
                        Log.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                    }
                    a3.bgt(rcVar2.dXG.dataPath);
                    a3.bgu(rcVar2.dXG.thumbPath);
                    a3.At(false);
                    a3.As(false);
                    czVar.dFZ.dGc.Lyq++;
                    aml = a3;
                    break;
                case 3:
                    long j3 = caVar.field_msgId;
                    aml a4 = a(next, z);
                    a4.ajd(3);
                    if (!Util.isNullOrNil(next.Lwp)) {
                        rc rcVar3 = new rc();
                        rcVar3.dXF.type = 1;
                        rcVar3.dXF.dKT = next;
                        rcVar3.dXF.msgId = j3;
                        EventCenter.instance.publish(rcVar3);
                        if (Util.isNullOrNil(rcVar3.dXG.dataPath) && Util.isNullOrNil(rcVar3.dXG.thumbPath)) {
                            Log.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                        }
                        a4.bgt(rcVar3.dXG.dataPath);
                        a4.ajc(next.duration);
                        a4.At(true);
                        a4.As(false);
                        a4.bgp(next.LvC);
                    }
                    czVar.dFZ.dGc.Lyr++;
                    aml = a4;
                    break;
                case 4:
                case 15:
                    long j4 = caVar.field_msgId;
                    aml a5 = a(next, z);
                    a(a5, next);
                    if (next.dataType == 15) {
                        a5.ajd(15);
                    } else {
                        a5.ajd(4);
                    }
                    rc rcVar4 = new rc();
                    rcVar4.dXF.type = 1;
                    rcVar4.dXF.dKT = next;
                    rcVar4.dXF.msgId = j4;
                    EventCenter.instance.publish(rcVar4);
                    if (Util.isNullOrNil(rcVar4.dXG.dataPath) && Util.isNullOrNil(rcVar4.dXG.thumbPath)) {
                        Log.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
                    }
                    a5.As(false);
                    a5.bgt(rcVar4.dXG.dataPath);
                    a5.a(next.Lwh);
                    a5.At(false);
                    a5.bgu(rcVar4.dXG.thumbPath);
                    a5.ajc(next.duration);
                    czVar.dFZ.dGc.xiP++;
                    aml = a5;
                    break;
                case 5:
                    long j5 = caVar.field_msgId;
                    aml a6 = a(next, z);
                    a(a6, next);
                    a6.ajd(5);
                    rc rcVar5 = new rc();
                    rcVar5.dXF.type = 1;
                    rcVar5.dXF.dKT = next;
                    rcVar5.dXF.msgId = j5;
                    EventCenter.instance.publish(rcVar5);
                    if (Util.isNullOrNil(rcVar5.dXG.dataPath) && Util.isNullOrNil(rcVar5.dXG.thumbPath)) {
                        Log.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
                    }
                    a6.bgu(rcVar5.dXG.thumbPath);
                    a6.At(false);
                    if (!(next.Lwh == null || next.Lwh.LwS == null)) {
                        anq anq = new anq();
                        anq.bhs(next.Lwh.LwS.title);
                        anq.bht(next.Lwh.LwS.desc);
                        anq.bhv(next.Lwh.LwS.thumbUrl);
                        anq.ajn(next.Lwh.LwS.LyE);
                        anq.bhu(next.Lwh.LwS.LyC);
                        a6.Lwh.a(anq);
                    }
                    czVar.dFZ.dGc.Lys++;
                    aml = a6;
                    break;
                case 6:
                    aml a7 = a(next, z);
                    a7.ajd(6);
                    if (!(next.Lwh == null || next.Lwh.LwQ == null)) {
                        ams ams = new ams();
                        ams.bgW(next.Lwh.LwQ.label);
                        ams.C(next.Lwh.LwQ.lat);
                        ams.B(next.Lwh.LwQ.lng);
                        ams.aji(next.Lwh.LwQ.dRt);
                        ams.bgX(next.Lwh.LwQ.dWi);
                        a7.Lwh.c(ams);
                    }
                    czVar.dFZ.dGc.Lyt++;
                    aml = a7;
                    break;
                case 7:
                    long j6 = caVar.field_msgId;
                    aml a8 = a(next, z);
                    a(a8, next);
                    a8.bgL(next.songAlbumUrl);
                    a8.bgM(next.songLyric);
                    a8.ajd(7);
                    rc rcVar6 = new rc();
                    rcVar6.dXF.type = 1;
                    rcVar6.dXF.dKT = next;
                    rcVar6.dXF.msgId = j6;
                    EventCenter.instance.publish(rcVar6);
                    if (Util.isNullOrNil(rcVar6.dXG.dataPath) && Util.isNullOrNil(rcVar6.dXG.thumbPath)) {
                        Log.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
                    }
                    a8.bgu(rcVar6.dXG.thumbPath);
                    a8.At(false);
                    czVar.dFZ.dGc.Lyu++;
                    aml = a8;
                    break;
                case 8:
                    long j7 = caVar.field_msgId;
                    aml a9 = a(next, z);
                    a(a9, next);
                    a9.ajd(8);
                    rc rcVar7 = new rc();
                    rcVar7.dXF.type = 1;
                    rcVar7.dXF.dKT = next;
                    rcVar7.dXF.msgId = j7;
                    EventCenter.instance.publish(rcVar7);
                    if (Util.isNullOrNil(rcVar7.dXG.dataPath) && Util.isNullOrNil(rcVar7.dXG.thumbPath)) {
                        Log.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
                    }
                    a9.bgt(rcVar7.dXG.dataPath);
                    a9.bgu(rcVar7.dXG.thumbPath);
                    a9.As(false);
                    a9.bgp(next.LvC);
                    czVar.dFZ.dGc.fileCount++;
                    aml = a9;
                    break;
                case 9:
                case 13:
                case 18:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                default:
                    aml = null;
                    break;
                case 10:
                    aml b2 = b(next, next.dataType, z);
                    czVar.dFZ.dGc.Lyw++;
                    aml = b2;
                    break;
                case 11:
                    aml b3 = b(next, next.dataType, z);
                    czVar.dFZ.dGc.Lyx++;
                    aml = b3;
                    break;
                case 12:
                case 14:
                    aml a10 = a(next, z);
                    a10.ajd(14);
                    if (!(next.Lwh == null || next.Lwh.LwW == null)) {
                        ank ank = new ank();
                        ank.bho(next.Lwh.LwW.title);
                        ank.bhp(next.Lwh.LwW.desc);
                        ank.bhr(next.Lwh.LwW.info);
                        ank.bhq(next.Lwh.LwW.thumbUrl);
                        a10.Lwh.a(ank);
                    }
                    czVar.dFZ.dGc.LyA++;
                    aml = a10;
                    break;
                case 16:
                    aml a11 = a(next, z);
                    a11.ajd(16);
                    a11.bgg(next.desc);
                    czVar.dFZ.dGc.LyB++;
                    aml = a11;
                    break;
                case 17:
                    aml a12 = a(next, z);
                    a12.bgf(next.title);
                    a12.bgg(next.desc);
                    a12.ajd(17);
                    a12.bgF(next.Lwx);
                    aml = a12;
                    break;
                case 19:
                    long j8 = caVar.field_msgId;
                    aml a13 = a(next, z);
                    a13.bgf(next.title);
                    a13.bgg(next.desc);
                    a13.ajd(19);
                    rc rcVar8 = new rc();
                    rcVar8.dXF.type = 1;
                    rcVar8.dXF.dKT = next;
                    rcVar8.dXF.msgId = j8;
                    EventCenter.instance.publish(rcVar8);
                    if (Util.isNullOrNil(rcVar8.dXG.thumbPath)) {
                        Log.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
                    } else {
                        a13.At(false);
                        a13.bgu(rcVar8.dXG.thumbPath);
                    }
                    if (!(next.Lwh == null || next.Lwh.Lxf == null)) {
                        amj amj = new amj();
                        amj.username = next.Lwh.Lxf.username;
                        amj.appId = next.Lwh.Lxf.appId;
                        amj.dMe = next.Lwh.Lxf.dMe;
                        amj.iconUrl = next.Lwh.Lxf.iconUrl;
                        amj.type = next.Lwh.Lxf.type;
                        amj.dCx = next.Lwh.Lxf.dCx;
                        amj.Lve = next.Lwh.Lxf.Lve;
                        amj.version = next.Lwh.Lxf.version;
                        amj.leb = next.Lwh.Lxf.leb;
                        amj.lyE = next.Lwh.Lxf.lyE;
                        amj.eda = next.Lwh.Lxf.eda;
                        a13.Lwh.b(amj);
                    }
                    aml = a13;
                    break;
                case 20:
                    aml a14 = a(next, z);
                    a14.ajd(20);
                    a14.ajc(next.duration);
                    aml = a14;
                    break;
                case 22:
                    aml a15 = a(next, z);
                    a15.bgf(next.title);
                    a15.bgg(next.desc);
                    a15.Lwh.c(next.Lwh.Lxk);
                    a15.ajd(22);
                    aml = a15;
                    break;
                case 29:
                    long j9 = caVar.field_msgId;
                    aml a16 = a(next, z);
                    a(a16, next);
                    if (!(next == null || next.Lwh == null)) {
                        a16.Lwh.e(next.Lwh.Lxs);
                    }
                    a16.bgL(next.songAlbumUrl);
                    a16.bgM(next.songLyric);
                    a16.ajd(29);
                    rc rcVar9 = new rc();
                    rcVar9.dXF.type = 1;
                    rcVar9.dXF.dKT = next;
                    rcVar9.dXF.msgId = j9;
                    EventCenter.instance.publish(rcVar9);
                    if (Util.isNullOrNil(rcVar9.dXG.dataPath) && Util.isNullOrNil(rcVar9.dXG.thumbPath)) {
                        Log.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
                    }
                    a16.bgu(rcVar9.dXG.thumbPath);
                    a16.At(false);
                    czVar.dFZ.dGc.Lyu++;
                    aml = a16;
                    break;
            }
            if (aml != null) {
                int i3 = i2 + 1;
                if (caVar.field_isSend != 1) {
                    format = String.format("%d$%d", Long.valueOf(caVar.field_msgSvrId), Integer.valueOf(i2));
                } else if (ab.Eq(caVar.field_talker) || caVar.field_talker.equals("filehelper")) {
                    format = String.format("%d$%d", Long.valueOf(caVar.field_msgSvrId), Integer.valueOf(i2));
                } else {
                    format = String.format("%s#%d$%d", caVar.field_talker, Long.valueOf(caVar.field_msgSvrId), Integer.valueOf(i2));
                }
                aml.bgx(format);
                aml.bgN(next.jsz);
                anb.ppH.add(aml);
                i2 = i3;
            } else {
                i2 = i2;
            }
        }
        if (com.tencent.mm.plugin.fav.ui.l.j(cVar.iAd.get(0))) {
            czVar.dFZ.type = 18;
        } else {
            czVar.dFZ.type = 14;
        }
        AppMethodBeat.o(30959);
        return true;
    }

    private static amn q(aml aml) {
        AppMethodBeat.i(30960);
        amn amn = new amn();
        amn amn2 = aml.Lwh.LwO;
        if (amn2.Lxx) {
            amn.bgO(amn2.dRL);
        }
        if (amn2.Lxy) {
            amn.bgP(amn2.toUser);
        }
        if (amn2.LxB) {
            amn.bgR(amn2.LxA);
        }
        amn.ajh(1);
        amn.Mx(Util.nowMilliSecond());
        AppMethodBeat.o(30960);
        return amn;
    }

    private static aml a(aml aml, boolean z) {
        AppMethodBeat.i(30961);
        aml aml2 = new aml();
        amm amm = new amm();
        amm.c(q(aml));
        amm.d(aml.Lwh.IXu);
        aml2.a(amm);
        aml2.bgA(aml.Lwj);
        aml2.bgB(aml.Lwl);
        aml2.bgJ(aml.LwI);
        aml2.bgK(aml.LwK);
        aml2.At(true);
        aml2.As(true);
        aml2.bgC(aml.Lwp);
        aml2.ajf(aml.Lwv);
        aml2.bgq(aml.LvE);
        aml2.bgr(aml.LvG);
        aml2.Mu(aml.LvI);
        aml2.bgv(aml.LvP);
        aml2.bgw(aml.LvR);
        aml2.Mv(aml.LvT);
        if (z) {
            aml2.bgs(aml.dLl);
        }
        AppMethodBeat.o(30961);
        return aml2;
    }

    private static aml b(aml aml, int i2, boolean z) {
        AppMethodBeat.i(30963);
        aml a2 = a(aml, z);
        a2.ajd(i2);
        if (!(aml.Lwh == null || aml.Lwh.LwU == null)) {
            ana ana = new ana();
            ana.bgY(aml.Lwh.LwU.title);
            ana.bgZ(aml.Lwh.LwU.desc);
            ana.ajj(aml.Lwh.LwU.type);
            ana.bhb(aml.Lwh.LwU.info);
            ana.bha(aml.Lwh.LwU.thumbUrl);
            a2.Lwh.a(ana);
        }
        AppMethodBeat.o(30963);
        return a2;
    }

    private static void a(aml aml, ca caVar) {
        AppMethodBeat.i(30950);
        if (caVar.field_isSend != 1) {
            aml.bgx(String.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(30950);
        } else if (ab.Eq(caVar.field_talker) || caVar.field_talker.equals("filehelper")) {
            aml.bgx(String.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(30950);
        } else {
            aml.bgx(caVar.field_talker + "#" + String.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(30950);
        }
    }

    private static boolean h(cz czVar, ca caVar) {
        AppMethodBeat.i(30953);
        k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
        if (aD == null) {
            Log.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo content is null");
            AppMethodBeat.o(30953);
            return false;
        }
        anb anb = new anb();
        anb.a(aR(caVar));
        aml aml = new aml();
        a(aml, caVar);
        com.tencent.mm.modelvideo.o.bhj();
        aml.bgu(t.Qx(caVar.field_imgPath));
        aml.bgp(s.akC(aml.LvL));
        aml.bgt("");
        aml.bgo(aD.thumburl);
        amt v = m.v(caVar);
        if (v == null) {
            Log.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo favMpMsgItem is null");
            AppMethodBeat.o(30953);
            return false;
        }
        aml.ajc(v.duration);
        aml.bgf(aD.title);
        aml.bgl(aD.url);
        aml.As(true);
        aml.At(true);
        amm amm = new amm();
        if (caVar.cWK()) {
            amm.e(v);
        }
        aml.a(amm);
        LinkedList<aml> linkedList = new LinkedList<>();
        linkedList.add(aml);
        anb.bH(linkedList);
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 4;
        aml.ajd(4);
        AppMethodBeat.o(30953);
        return true;
    }

    private static void a(aml aml, aml aml2) {
        AppMethodBeat.i(30962);
        aml.bgm(aml2.Lvw);
        aml.bgn(aml2.Lvy);
        aml.bgl(aml2.Lvu);
        aml.bgf(aml2.title);
        aml.bgg(aml2.desc);
        AppMethodBeat.o(30962);
    }
}
