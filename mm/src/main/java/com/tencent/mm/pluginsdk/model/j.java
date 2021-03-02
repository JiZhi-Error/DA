package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.g;
import com.tencent.mm.av.h;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.c;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
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
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class j {
    private static final SimpleDateFormat BGt = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS);

    static {
        AppMethodBeat.i(30988);
        AppMethodBeat.o(30988);
    }

    public static boolean a(Context context, cz czVar, String str, List<ca> list, boolean z) {
        AppMethodBeat.i(30969);
        if (list == null || list.isEmpty() || context == null) {
            Log.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
            czVar.dFZ.dGe = R.string.c_2;
            AppMethodBeat.o(30969);
            return false;
        }
        for (ca caVar : list) {
            if (br.B(caVar)) {
                switch (caVar.getType() & 65535) {
                    case 1:
                        caVar.setContent(context.getString(R.string.z_));
                        continue;
                    case 3:
                        caVar.setContent(context.getString(R.string.xr));
                        caVar.setType(1);
                        continue;
                    case 43:
                        caVar.setContent(context.getString(R.string.zv));
                        caVar.setType(1);
                        continue;
                    case 49:
                        caVar.setContent(context.getString(R.string.zj));
                        caVar.setType(1);
                        continue;
                }
            }
        }
        boolean DQ = g.DQ(str);
        if (list.size() != 1 || z) {
            czVar.dFZ.dGb = new anb();
            czVar.dFZ.dGc = new anp();
            if (context != null) {
                if (DQ) {
                    String At = e.At(list.get(0).field_bizChatId);
                    if (e.NG(At)) {
                        czVar.dFZ.dGb.bhd(context.getString(R.string.fvq));
                    } else {
                        k NJ = e.NJ(str);
                        if (NJ != null) {
                            czVar.dFZ.dGb.bhd(context.getString(R.string.cb6, NJ.field_userName, e.NH(At)));
                        }
                    }
                } else if (ab.Eq(str)) {
                    czVar.dFZ.dGb.bhd(context.getString(R.string.fvq));
                } else {
                    String nullAsNil = Util.nullAsNil(z.aUa());
                    if (nullAsNil.equals(Util.nullAsNil(aa.Ir(str)))) {
                        czVar.dFZ.dGb.bhd(context.getString(R.string.cb7, nullAsNil));
                    } else {
                        czVar.dFZ.dGb.bhd(context.getString(R.string.cb6, z.aUa(), aa.Ir(str)));
                    }
                }
                Log.d("MicroMsg.GetFavRecordDataSource", "title %s", czVar.dFZ.dGb.title);
            }
            czVar.dFZ.dGb.a(bdp(str));
            czVar.dFZ.type = 14;
            boolean z2 = true;
            boolean z3 = false;
            for (ca caVar2 : list) {
                if (b(context, czVar, caVar2)) {
                    z3 = true;
                } else {
                    z2 = false;
                }
            }
            if (z3 && czVar.dFZ.dGe > 0) {
                czVar.dFZ.dGe = 0;
            }
            AppMethodBeat.o(30969);
            return z2;
        }
        ca caVar3 = list.get(0);
        if (caVar3.gAt()) {
            u a2 = ((a) com.tencent.mm.kernel.g.af(a.class)).a(caVar3.field_msgId, caVar3.field_content);
            if (a2.iAd == null || a2.iAd.size() != 1) {
                czVar.dFZ.dGb = new anb();
                czVar.dFZ.dGc = new anp();
                czVar.dFZ.dGb.a(bdp(str));
                czVar.dFZ.type = 14;
                boolean b2 = b(context, czVar, caVar3);
                AppMethodBeat.o(30969);
                return b2;
            }
            boolean d2 = h.d(czVar, caVar3);
            AppMethodBeat.o(30969);
            return d2;
        }
        boolean d3 = h.d(czVar, caVar3);
        AppMethodBeat.o(30969);
        return d3;
    }

    private static boolean b(Context context, cz czVar, ca caVar) {
        boolean z = false;
        AppMethodBeat.i(30970);
        if (czVar == null || caVar == null) {
            Log.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
            if (czVar != null) {
                czVar.dFZ.dGe = R.string.c_2;
            }
            AppMethodBeat.o(30970);
        } else {
            ca aZ = ca.aZ(caVar);
            if (aZ.isText()) {
                z = e(czVar, aZ);
            } else if (aZ.gAy()) {
                z = b(czVar, aZ, false);
            } else if (aZ.dOS()) {
                z = a(czVar, aZ);
            } else if (aZ.gAz()) {
                z = a(czVar, aZ, false);
            } else if (aZ.cWJ()) {
                z = c(czVar, aZ, false);
            } else if (aZ.cWL()) {
                z = c(czVar, aZ, false);
            } else if (aZ.cWK()) {
                z = c.b(czVar, aZ);
            } else if (aZ.gAt()) {
                z = c(czVar, aZ);
            } else if (aZ.gDl()) {
                z = c(context, czVar, aZ);
            } else if (!aZ.dOQ() || aZ.gDo()) {
                czVar.dFZ.dGe = R.string.c__;
            } else {
                z = a(context, czVar, aZ, false);
            }
            com.tencent.mm.plugin.fav.ui.e.a(aZ, czVar, z);
            AppMethodBeat.o(30970);
        }
        return z;
    }

    private static anh bdp(String str) {
        AppMethodBeat.i(30971);
        anh anh = new anh();
        anh.bhf(str);
        anh.ajm(1);
        anh.MA(Util.nowMilliSecond());
        anh.bhh("");
        AppMethodBeat.o(30971);
        return anh;
    }

    private static amn aL(ca caVar) {
        String str;
        AppMethodBeat.i(30972);
        amn amn = new amn();
        if (caVar == null) {
            AppMethodBeat.o(30972);
            return amn;
        }
        if (caVar.field_isSend == 0) {
            amn.bgO(caVar.field_talker);
            amn.bgP(z.aTY());
            if (ab.Eq(caVar.field_talker)) {
                if (caVar.field_content != null) {
                    str = caVar.field_content.substring(0, Math.max(0, caVar.field_content.indexOf(58)));
                } else {
                    str = "";
                }
                amn.bgR(str);
                if (!Util.isNullOrNil(amn.LxA) && !caVar.gAy()) {
                    caVar.setContent(caVar.field_content.substring(amn.LxA.length() + 1));
                    if (caVar.field_content.length() > 0 && '\n' == caVar.field_content.charAt(0)) {
                        caVar.setContent(caVar.field_content.substring(1));
                    }
                    if (caVar.gDz()) {
                        if (!Util.isNullOrNil(caVar.field_transContent) && caVar.field_transContent.startsWith(amn.LxA)) {
                            caVar.CB(caVar.field_transContent.substring(amn.LxA.length() + 1));
                        }
                        if (caVar.field_transContent.length() > 0 && '\n' == caVar.field_transContent.charAt(0)) {
                            caVar.CB(caVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        } else {
            amn.bgO(z.aTY());
            amn.bgP(caVar.field_talker);
            if (ab.Eq(caVar.field_talker)) {
                amn.bgR(amn.dRL);
            }
        }
        if (g.DQ(caVar.field_talker)) {
            String str2 = caVar.field_bizChatUserId;
            if (str2 == null) {
                str2 = bp.Ky(caVar.fqK).userId;
            }
            amn.bgR(str2);
        }
        amn.ajh(1);
        amn.Mx(caVar.field_createTime);
        amn.bgS(new StringBuilder().append(caVar.field_msgSvrId).toString());
        if (caVar.field_msgSvrId > 0) {
            amn.bgQ(new StringBuilder().append(caVar.field_msgSvrId).toString());
        }
        AppMethodBeat.o(30972);
        return amn;
    }

    private static String b(amn amn) {
        AppMethodBeat.i(30974);
        String format = BGt.format(new Date(amn.createTime));
        AppMethodBeat.o(30974);
        return format;
    }

    private static boolean e(cz czVar, ca caVar) {
        String str;
        AppMethodBeat.i(30976);
        amm amm = new amm();
        amm.c(aL(caVar));
        aml aml = new aml();
        aml.bgx(aM(caVar));
        aml.ajd(1);
        if (caVar.gDV()) {
            str = MMApplicationContext.getContext().getString(R.string.g8d, "@") + '\n';
        } else {
            str = "";
        }
        aml.bgg(str + caVar.field_content);
        aml.At(true);
        aml.As(true);
        aml.a(amm);
        aml.bgA(a(amm.LwO));
        aml.bgB(b(amm.LwO));
        if (as.bjp(amm.LwO.LxA)) {
            String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
            if (!Util.isNullOrNil(O)) {
                aml.bgJ(O);
            }
        }
        czVar.dFZ.dGb.ppH.add(aml);
        czVar.dFZ.dGc.Lyp++;
        AppMethodBeat.o(30976);
        return true;
    }

    private static boolean a(cz czVar, ca caVar, boolean z) {
        AppMethodBeat.i(232145);
        com.tencent.mm.av.g gVar = null;
        if (caVar.field_msgId > 0) {
            gVar = q.bcR().H(caVar.field_talker, (long) ((int) caVar.field_msgId));
        }
        if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
            gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
        }
        if (gVar == null) {
            Log.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
            czVar.dFZ.dGe = R.string.c_8;
            AppMethodBeat.o(232145);
            return false;
        }
        amm amm = new amm();
        amm.c(aL(caVar));
        aml aml = new aml();
        aml.bgx(aM(caVar));
        aml.ajd(2);
        aml.bgt(q.bcR().o(h.c(gVar), "", ""));
        if (gVar.bcv()) {
            com.tencent.mm.av.g tl = q.bcR().tl(gVar.iXx);
            if (tl.iKP > tl.offset) {
                aml.bgt(q.bcR().o("SERVERID://" + caVar.field_msgSvrId, "", ""));
            }
        }
        aml.bgu(q.bcR().R(caVar.field_imgPath, true));
        aml.a(amm);
        aml.bgA(a(amm.LwO));
        aml.bgB(b(amm.LwO));
        aml.Mw(caVar.field_msgId);
        aml.bgN(br.KB(caVar.fqK));
        if (as.bjp(amm.LwO.LxA)) {
            String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
            if (!Util.isNullOrNil(O)) {
                aml.bgJ(O);
            }
        }
        czVar.dFZ.dGb.ppH.add(aml);
        czVar.dFZ.dGc.Lyq++;
        AppMethodBeat.o(232145);
        return true;
    }

    private static boolean a(cz czVar, ca caVar) {
        AppMethodBeat.i(30978);
        amm amm = new amm();
        amm.c(aL(caVar));
        Map<String, String> parseXml = XmlParser.parseXml(caVar.field_content, "msg", null);
        if (parseXml != null) {
            try {
                ams ams = new ams();
                ams.bgW(parseXml.get(".msg.location.$label"));
                ams.C(Double.parseDouble(parseXml.get(".msg.location.$x")));
                ams.B(Double.parseDouble(parseXml.get(".msg.location.$y")));
                ams.aji(Integer.valueOf(parseXml.get(".msg.location.$scale")).intValue());
                ams.bgX(parseXml.get(".msg.location.$poiname"));
                amm.c(ams);
                aml aml = new aml();
                aml.bgx(aM(caVar));
                aml.ajd(6);
                aml.At(true);
                aml.As(true);
                aml.a(amm);
                aml.bgA(a(amm.LwO));
                aml.bgB(b(amm.LwO));
                if (as.bjp(amm.LwO.LxA)) {
                    String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O)) {
                        aml.bgJ(O);
                    }
                }
                czVar.dFZ.dGb.ppH.add(aml);
                czVar.dFZ.dGc.Lyt++;
                AppMethodBeat.o(30978);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", e2.getStackTrace().toString());
            }
        }
        czVar.dFZ.dGe = R.string.c_b;
        AppMethodBeat.o(30978);
        return false;
    }

    private static boolean b(cz czVar, ca caVar, boolean z) {
        AppMethodBeat.i(232146);
        amm amm = new amm();
        amm.c(aL(caVar));
        aml aml = new aml();
        aml.bgx(aM(caVar));
        aml.ajd(3);
        if (ab.Jp(caVar.field_talker)) {
            aml.bgt(bdo(caVar.field_imgPath));
        } else {
            aml.bgt(s.getFullPath(caVar.field_imgPath));
        }
        aml.At(true);
        b Rf = s.Rf(caVar.field_imgPath);
        if (Rf == null) {
            AppMethodBeat.o(232146);
            return false;
        }
        aml.bgp(h.ahD(Rf.getFormat()));
        aml.ajc((int) new p(caVar.field_content).time);
        aml.a(amm);
        aml.bgA(a(amm.LwO));
        aml.bgB(b(amm.LwO));
        if (as.bjp(amm.LwO.LxA)) {
            String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
            if (!Util.isNullOrNil(O)) {
                aml.bgJ(O);
            }
        }
        czVar.dFZ.dGb.ppH.add(aml);
        czVar.dFZ.dGc.Lyr++;
        AppMethodBeat.o(232146);
        return true;
    }

    private static String bdo(String str) {
        AppMethodBeat.i(30980);
        bg.aVF();
        String genPath = FilePathGenerator.genPath(com.tencent.mm.model.c.aTb(), "recbiz_", str, ".rec", 2);
        if (Util.isNullOrNil(genPath)) {
            AppMethodBeat.o(30980);
            return null;
        } else if (new o(genPath).exists()) {
            AppMethodBeat.o(30980);
            return genPath;
        } else {
            AppMethodBeat.o(30980);
            return genPath;
        }
    }

    private static boolean c(cz czVar, ca caVar, boolean z) {
        AppMethodBeat.i(232147);
        amm amm = new amm();
        amm.c(aL(caVar));
        aml aml = new aml();
        aml.bgx(aM(caVar));
        com.tencent.mm.modelvideo.o.bhj();
        aml.bgt(t.Qw(caVar.field_imgPath));
        com.tencent.mm.modelvideo.o.bhj();
        aml.bgu(t.Qx(caVar.field_imgPath));
        aml.bgp(com.tencent.mm.vfs.s.akC(aml.LvL));
        if (caVar.cWL()) {
            aml.ajd(15);
        } else {
            aml.ajd(4);
        }
        com.tencent.mm.modelvideo.s QN = com.tencent.mm.modelvideo.u.QN(caVar.field_imgPath);
        if (QN == null) {
            Log.i("MicroMsg.GetFavRecordDataSource", "video info null");
            czVar.dFZ.dGe = R.string.c_1;
            AppMethodBeat.o(232147);
            return false;
        }
        Log.i("MicroMsg.GetFavRecordDataSource", "video length is %d", Integer.valueOf(QN.iKP));
        if (QN.iKP > ((af) com.tencent.mm.kernel.g.ah(af.class)).getVideoSizeLimit(false)) {
            czVar.dFZ.dGe = R.string.ccv;
            AppMethodBeat.o(232147);
            return false;
        } else if (!caVar.cWL() || !com.tencent.mm.modelvideo.u.QO(QN.getFileName())) {
            aml.ajc(QN.iFw);
            aml.a(amm);
            aml.bgA(a(amm.LwO));
            aml.bgB(b(amm.LwO));
            if (as.bjp(amm.LwO.LxA)) {
                String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                if (!Util.isNullOrNil(O)) {
                    aml.bgJ(O);
                }
            }
            aml.Mw(caVar.field_msgId);
            aml.bgN(br.KB(caVar.fqK));
            aml.Mu((long) QN.iKP);
            czVar.dFZ.dGb.ppH.add(aml);
            czVar.dFZ.dGc.xiP++;
            com.tencent.mm.modelvideo.s QN2 = com.tencent.mm.modelvideo.u.QN(caVar.field_imgPath);
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
            AppMethodBeat.o(232147);
            return true;
        } else {
            czVar.dFZ.dGe = R.string.c_1;
            AppMethodBeat.o(232147);
            return false;
        }
    }

    private static boolean c(Context context, cz czVar, ca caVar) {
        aml a2;
        String format;
        AppMethodBeat.i(30982);
        bg.aVF();
        ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
        amm amm = new amm();
        amm.c(aL(caVar));
        if (aEK != null && ab.rR(aEK.IOs)) {
            aml aml = new aml();
            aml.bgx(aM(caVar));
            aml.ajd(16);
            aml.bgg(caVar.field_content);
            aml.At(true);
            aml.As(true);
            aml.a(amm);
            aml.bgA(a(amm.LwO));
            aml.bgB(b(amm.LwO));
            if (as.bjp(amm.LwO.LxA)) {
                String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                if (!Util.isNullOrNil(O)) {
                    aml.bgJ(O);
                }
                a2 = aml;
            } else {
                a2 = aml;
            }
        } else if (aEK == null || !as.bjp(aEK.dkU)) {
            a2 = a(caVar, context.getString(R.string.vr), amm);
        } else {
            String a3 = ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(aEK.OqO, "openim_card_type_name", a.EnumC0497a.TYPE_WORDING);
            if (TextUtils.isEmpty(a3)) {
                format = context.getResources().getString(R.string.vr);
            } else {
                format = String.format("[%s]", a3);
            }
            a2 = a(caVar, format, amm);
        }
        czVar.dFZ.dGb.ppH.add(a2);
        czVar.dFZ.dGc.LyB++;
        AppMethodBeat.o(30982);
        return true;
    }

    private static aml a(ca caVar, k.b bVar, int i2) {
        AppMethodBeat.i(30983);
        aml aml = new aml();
        aml.bgx(aM(caVar));
        aml.bgm(bVar.ixd);
        aml.bgn(bVar.ixe);
        aml.bgl(bVar.url);
        aml.As(true);
        o oVar = new o(Util.nullAs(q.bcR().R(caVar.field_imgPath, true), ""));
        if (oVar.exists()) {
            aml.bgu(com.tencent.mm.vfs.aa.z(oVar.her()));
        } else {
            aml.At(true);
        }
        aml.bgf(bVar.title);
        aml.bgg(bVar.description);
        aml.ajd(i2);
        aml.bgE(bVar.canvasPageXml);
        AppMethodBeat.o(30983);
        return aml;
    }

    private static aml a(ca caVar, String str, amm amm) {
        AppMethodBeat.i(30984);
        aml aml = new aml();
        aml.bgx(aM(caVar));
        aml.ajd(1);
        aml.bgg(str);
        aml.At(true);
        aml.As(true);
        aml.a(amm);
        aml.bgA(a(amm.LwO));
        aml.bgB(b(amm.LwO));
        if (as.bjp(amm.LwO.LxA)) {
            String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
            if (!Util.isNullOrNil(O)) {
                aml.bgJ(O);
            }
        }
        AppMethodBeat.o(30984);
        return aml;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean a(Context context, cz czVar, ca caVar, boolean z) {
        String str;
        AppMethodBeat.i(232148);
        amm amm = new amm();
        amm.c(aL(caVar));
        String str2 = caVar.field_content;
        if (str2 == null) {
            czVar.dFZ.dGe = R.string.c_b;
            AppMethodBeat.o(232148);
            return false;
        }
        k.b HD = k.b.HD(str2);
        if (HD == null) {
            czVar.dFZ.dGe = R.string.c_b;
            AppMethodBeat.o(232148);
            return false;
        }
        amm.LwO.bgT(HD.appId);
        amm.LwO.bgV(HD.eag);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, true, false);
        if (o != null) {
            o.NA();
        }
        switch (HD.type) {
            case 1:
            case 53:
            case n.CTRL_INDEX:
                aml aml = new aml();
                aml.bgx(aM(caVar));
                aml.ajd(1);
                aml.bgg(HD.title);
                aml.At(true);
                aml.As(true);
                aml.a(amm);
                aml.bgA(a(amm.LwO));
                aml.bgB(b(amm.LwO));
                if (as.bjp(amm.LwO.LxA)) {
                    String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O)) {
                        aml.bgJ(O);
                    }
                }
                czVar.dFZ.dGb.ppH.add(aml);
                czVar.dFZ.dGc.Lyp++;
                AppMethodBeat.o(232148);
                return true;
            case 2:
                bg.aVF();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    czVar.dFZ.dGe = R.string.c_h;
                    AppMethodBeat.o(232148);
                    return false;
                }
                com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD.dCK);
                aml aml2 = new aml();
                aml2.bgx(aM(caVar));
                if (bdx != null) {
                    aml2.bgt(bdx.field_fileFullPath);
                }
                String R = q.bcR().R(caVar.field_imgPath, true);
                if (com.tencent.mm.vfs.s.YS(R)) {
                    aml2.bgu(R);
                }
                aml2.ajd(2);
                aml2.bgf(HD.title);
                aml2.bgg(HD.description);
                aml2.a(amm);
                aml2.bgA(a(amm.LwO));
                aml2.bgB(b(amm.LwO));
                aml2.Mw(caVar.field_msgId);
                aml2.bgN(br.KB(caVar.fqK));
                if (as.bjp(amm.LwO.LxA)) {
                    String O2 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O2)) {
                        aml2.bgJ(O2);
                    }
                }
                czVar.dFZ.dGb.ppH.add(aml2);
                czVar.dFZ.dGc.Lyq++;
                AppMethodBeat.o(232148);
                return true;
            case 3:
                aml a2 = a(caVar, HD, 7);
                a2.a(amm);
                a2.bgA(a(amm.LwO));
                a2.bgB(b(amm.LwO));
                if (as.bjp(amm.LwO.LxA)) {
                    String O3 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O3)) {
                        a2.bgJ(O3);
                    }
                }
                czVar.dFZ.dGb.ppH.add(a2);
                czVar.dFZ.dGc.Lyu++;
                AppMethodBeat.o(232148);
                return true;
            case 4:
                aml a3 = a(caVar, HD, 4);
                a3.a(amm);
                a3.bgA(a(amm.LwO));
                a3.bgB(b(amm.LwO));
                a3.Mw(caVar.field_msgId);
                a3.bgN(br.KB(caVar.fqK));
                if (as.bjp(amm.LwO.LxA)) {
                    String O4 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O4)) {
                        a3.bgJ(O4);
                    }
                }
                czVar.dFZ.dGb.ppH.add(a3);
                czVar.dFZ.dGc.xiP++;
                AppMethodBeat.o(232148);
                return true;
            case 5:
                if (HD.url == null || HD.url.equals("")) {
                    czVar.dFZ.dGe = R.string.c_6;
                    AppMethodBeat.o(232148);
                    return false;
                }
                amm.LwO.bgU(HD.url);
                aml a4 = a(caVar, HD, 5);
                a4.a(amm);
                a4.bgA(a(amm.LwO));
                a4.bgB(b(amm.LwO));
                if (as.bjp(amm.LwO.LxA)) {
                    String O5 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O5)) {
                        a4.bgJ(O5);
                    }
                }
                anq anq = new anq();
                if (!Util.isNullOrNil(HD.title)) {
                    anq.bhs(HD.title);
                }
                if (!Util.isNullOrNil(HD.description)) {
                    anq.bht(HD.description);
                }
                if (!Util.isNullOrNil(HD.thumburl)) {
                    anq.bhv(HD.thumburl);
                }
                if (!Util.isNullOrNil(HD.canvasPageXml)) {
                    anq.bhw(HD.canvasPageXml);
                }
                if (anq.computeSize() > 0) {
                    anq.ajn(1);
                    amm.a(anq);
                }
                czVar.dFZ.dGb.ppH.add(a4);
                czVar.dFZ.dGc.Lys++;
                a(caVar, amm, anq);
                AppMethodBeat.o(232148);
                return true;
            case 6:
                bg.aVF();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    czVar.dFZ.dGe = R.string.c_h;
                    AppMethodBeat.o(232148);
                    return false;
                }
                com.tencent.mm.pluginsdk.model.app.c bdx2 = ao.cgO().bdx(HD.dCK);
                aml aml3 = new aml();
                if (bdx2 != null) {
                    aml3.bgt(bdx2.field_fileFullPath);
                }
                aml3.bgx(aM(caVar));
                aml3.ajd(8);
                aml3.bgp(HD.iwJ);
                String R2 = q.bcR().R(caVar.field_imgPath, true);
                if (Util.isNullOrNil(R2)) {
                    aml3.At(true);
                }
                if (com.tencent.mm.vfs.s.YS(R2)) {
                    aml3.bgu(R2);
                }
                aml3.bgf(HD.title);
                aml3.bgg(HD.description);
                aml3.a(amm);
                aml3.bgA(a(amm.LwO));
                aml3.bgB(b(amm.LwO));
                aml3.Mw(caVar.field_msgId);
                if (as.bjp(amm.LwO.LxA)) {
                    String O6 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O6)) {
                        aml3.bgJ(O6);
                    }
                }
                czVar.dFZ.dGb.ppH.add(aml3);
                czVar.dFZ.dGc.fileCount++;
                AppMethodBeat.o(232148);
                return true;
            case 7:
                if (HD.dCK == null || HD.dCK.length() == 0) {
                    czVar.dFZ.dGe = R.string.c_3;
                } else {
                    bg.aVF();
                    if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                        czVar.dFZ.dGe = R.string.c_h;
                        AppMethodBeat.o(232148);
                        return false;
                    }
                }
                czVar.dFZ.dGe = R.string.c__;
                AppMethodBeat.o(232148);
                return false;
            case 10:
                ana ana = new ana();
                ana.bgY(HD.title);
                ana.bgZ(HD.description);
                ana.ajj(HD.ixg);
                ana.bhb(HD.ixh);
                ana.bha(HD.thumburl);
                amm.a(ana);
                aml aml4 = new aml();
                aml4.bgx(aM(caVar));
                aml4.ajd(10);
                aml4.At(true);
                aml4.As(true);
                aml4.a(amm);
                aml4.bgA(a(amm.LwO));
                aml4.bgB(b(amm.LwO));
                if (as.bjp(amm.LwO.LxA)) {
                    String O7 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O7)) {
                        aml4.bgJ(O7);
                    }
                }
                czVar.dFZ.dGb.ppH.add(aml4);
                czVar.dFZ.dGc.Lyw++;
                AppMethodBeat.o(232148);
                return true;
            case 13:
                ana ana2 = new ana();
                ana2.bgY(HD.title);
                ana2.bgZ(HD.description);
                ana2.ajj(HD.ixm);
                ana2.bhb(HD.ixn);
                ana2.bha(HD.thumburl);
                amm.a(ana2);
                aml aml5 = new aml();
                aml5.bgx(aM(caVar));
                aml5.ajd(11);
                aml5.At(true);
                aml5.As(true);
                aml5.a(amm);
                aml5.bgA(a(amm.LwO));
                aml5.bgB(b(amm.LwO));
                if (as.bjp(amm.LwO.LxA)) {
                    String O8 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O8)) {
                        aml5.bgJ(O8);
                    }
                }
                czVar.dFZ.dGb.ppH.add(aml5);
                czVar.dFZ.dGc.Lyx++;
                AppMethodBeat.o(232148);
                return true;
            case 19:
                if (!(HD.ixl != null && HD.ixl.contains("<recordxml>"))) {
                    aml aml6 = new aml();
                    aml6.bgx(aM(caVar));
                    aml6.ajd(17);
                    aml6.At(true);
                    aml6.bgf(HD.title);
                    aml6.bgF(HD.ixl);
                    String str3 = HD.description;
                    rc rcVar = new rc();
                    rcVar.dXF.type = 0;
                    rcVar.dXF.dXH = HD.ixl;
                    EventCenter.instance.publish(rcVar);
                    com.tencent.mm.protocal.b.a.c cVar = rcVar.dXG.dXP;
                    if (cVar != null) {
                        Iterator<aml> it = cVar.iAd.iterator();
                        while (it.hasNext()) {
                            if (!Util.isNullOrNil(it.next().LwF)) {
                                czVar.dFZ.dGe = R.string.c__;
                                AppMethodBeat.o(232148);
                                return false;
                            }
                        }
                    }
                    if (cVar != null) {
                        str = cVar.desc;
                    } else {
                        str = str3;
                    }
                    aml6.bgg(str);
                    aml6.a(amm);
                    aml6.bgA(a(amm.LwO));
                    aml6.bgB(b(amm.LwO));
                    aml6.Mw(caVar.field_msgId);
                    if (as.bjp(amm.LwO.LxA)) {
                        String O9 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                        if (!Util.isNullOrNil(O9)) {
                            aml6.bgJ(O9);
                        }
                    }
                    czVar.dFZ.dGb.ppH.add(aml6);
                    AppMethodBeat.o(232148);
                    return true;
                }
                break;
            case 20:
                ank ank = new ank();
                ank.bho(HD.title);
                ank.bhp(HD.description);
                ank.bhr(HD.ixk);
                ank.bhq(HD.thumburl);
                amm.a(ank);
                aml aml7 = new aml();
                aml7.bgx(aM(caVar));
                aml7.ajd(14);
                aml7.At(true);
                aml7.As(true);
                aml7.a(amm);
                aml7.bgA(a(amm.LwO));
                aml7.bgB(b(amm.LwO));
                if (as.bjp(amm.LwO.LxA)) {
                    String O10 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O10)) {
                        aml7.bgJ(O10);
                    }
                }
                czVar.dFZ.dGb.ppH.add(aml7);
                czVar.dFZ.dGc.LyA++;
                AppMethodBeat.o(232148);
                return true;
            case 33:
            case 36:
                aml aml8 = new aml();
                aml8.bgx(aM(caVar));
                aml8.bgf(HD.title);
                aml8.bgg(HD.description);
                aml8.ajd(19);
                String R3 = q.bcR().R(caVar.field_imgPath, true);
                if (Util.isNullOrNil(R3)) {
                    aml8.At(true);
                }
                if (com.tencent.mm.vfs.s.YS(R3)) {
                    aml8.bgu(R3);
                }
                amj amj = new amj();
                if (!Util.isNullOrNil(HD.izi)) {
                    amj.username = HD.izi;
                }
                if (!Util.isNullOrNil(HD.izj)) {
                    amj.appId = HD.izj;
                }
                if (!Util.isNullOrNil(HD.izB)) {
                    amj.iconUrl = HD.izB;
                }
                amj.lyE = HD.izr;
                amj.type = HD.izk;
                amj.dMe = HD.izm;
                amj.dCx = HD.izh;
                amj.Lve = HD.eah;
                amm.b(amj);
                aml8.a(amm);
                aml8.bgA(a(amm.LwO));
                aml8.bgB(b(amm.LwO));
                aml8.Mw(caVar.field_msgId);
                if (as.bjp(amm.LwO.LxA)) {
                    String O11 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O11)) {
                        aml8.bgJ(O11);
                    }
                }
                czVar.dFZ.dGb.ppH.add(aml8);
                AppMethodBeat.o(232148);
                return true;
            case 44:
                String w = HD.w(context, true);
                if (Util.isNullOrNil(w)) {
                    czVar.dFZ.dGe = R.string.c__;
                    AppMethodBeat.o(232148);
                    return false;
                }
                czVar.dFZ.dGb.ppH.add(a(caVar, w + HD.title, amm));
                AppMethodBeat.o(232148);
                return true;
            case 46:
                czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.x8), amm));
                AppMethodBeat.o(232148);
                return true;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.vu) + HD.title, amm));
                AppMethodBeat.o(232148);
                return true;
            case 51:
                f fVar = (f) HD.as(f.class);
                if (fVar != null) {
                    bcj bcj = fVar.jlg;
                    aml aml9 = new aml();
                    aml9.bgA(a(amm.LwO));
                    aml9.bgB(b(amm.LwO));
                    aml9.bgx(aM(caVar));
                    aml9.As(true);
                    aml9.bgf(bcj.nickname + MMApplicationContext.getContext().getString(R.string.cce));
                    aml9.bgg(bcj.desc);
                    aml9.ajd(22);
                    amm.c(bcj);
                    aml9.a(amm);
                    czVar.dFZ.dGb.ppH.add(aml9);
                    AppMethodBeat.o(232148);
                    return true;
                }
                AppMethodBeat.o(232148);
                return false;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                aml a5 = a(caVar, HD, 29);
                a5.bgA(a(amm.LwO));
                a5.bgB(b(amm.LwO));
                if (as.bjp(amm.LwO.LxA)) {
                    String O12 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                    if (!Util.isNullOrNil(O12)) {
                        a5.bgJ(O12);
                    }
                }
                if (HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class) != null) {
                    a5.bgL(((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
                    a5.bgM(((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
                    css css = new css();
                    css.Ktn = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktn;
                    css.Kto = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Kto;
                    css.Ktp = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktp;
                    css.Ktq = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktq;
                    css.singerName = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktr;
                    css.albumName = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Kts;
                    css.musicGenre = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktt;
                    css.issueDate = Util.safeParseLong(((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktu);
                    css.identification = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktv;
                    css.Alz = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Alz;
                    css.extraInfo = ((com.tencent.mm.pluginsdk.ui.tools.b) HD.as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktw;
                    amm.e(css);
                }
                a5.a(amm);
                czVar.dFZ.dGb.ppH.add(a5);
                czVar.dFZ.dGc.Lyu++;
                AppMethodBeat.o(232148);
                return true;
        }
        czVar.dFZ.dGe = R.string.c__;
        AppMethodBeat.o(232148);
        return false;
    }

    private static void a(ca caVar, amm amm, anq anq) {
        AppMethodBeat.i(30986);
        amm.d(m.a(caVar, anq));
        AppMethodBeat.o(30986);
    }

    private static boolean c(cz czVar, ca caVar) {
        AppMethodBeat.i(30987);
        try {
            u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content);
            LinkedList<v> linkedList = a2.iAd;
            if (linkedList != null) {
                int i2 = 0;
                for (v vVar : linkedList) {
                    if (!m.HF(vVar.iAt)) {
                        amm amm = new amm();
                        amm.c(aL(caVar));
                        amm.LwO.bgV(a2.eag);
                        amm.LwO.bgU(vVar.url);
                        aml aml = new aml();
                        aml.bgf(vVar.title);
                        aml.bgg(vVar.iAq);
                        aml.bgx(aM(caVar));
                        if (!Util.isNullOrNil(vVar.iAo)) {
                            aml.bgu(s.bdu(vVar.iAo));
                        } else {
                            aml.At(true);
                        }
                        aml.As(true);
                        anq anq = new anq();
                        if (!Util.isNullOrNil(vVar.title)) {
                            anq.bhs(vVar.title);
                        }
                        if (!Util.isNullOrNil(vVar.iAq)) {
                            anq.bht(vVar.iAq);
                        }
                        if (!Util.isNullOrNil(vVar.iAo)) {
                            anq.bhv(m.a(vVar));
                        }
                        if (anq.computeSize() > 0) {
                            anq.ajn(1);
                            amm.a(anq);
                        }
                        aml.ajd(5);
                        aml.a(amm);
                        aml.bgA(a(amm.LwO));
                        aml.bgB(b(amm.LwO));
                        if (as.bjp(amm.LwO.LxA)) {
                            String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                            if (!Util.isNullOrNil(O)) {
                                aml.bgJ(O);
                            }
                        }
                        czVar.dFZ.dGb.ppH.add(aml);
                        czVar.dFZ.dGc.Lys++;
                        amm.d(m.a(vVar, anq, a2.eag, a2.eah));
                        i2++;
                    }
                }
                if (i2 == 0) {
                    czVar.dFZ.dGe = R.string.c__;
                    AppMethodBeat.o(30987);
                    return false;
                }
                AppMethodBeat.o(30987);
                return true;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GetFavRecordDataSource", e2, "", new Object[0]);
            Log.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", e2.getLocalizedMessage());
        }
        czVar.dFZ.dGe = R.string.c_b;
        AppMethodBeat.o(30987);
        return false;
    }

    private static String a(amn amn) {
        AppMethodBeat.i(30973);
        String str = amn.LxA;
        if (Util.isNullOrNil(str)) {
            str = amn.dRL;
        }
        if (e.NF(str)) {
            String NH = e.NH(str);
            AppMethodBeat.o(30973);
            return NH;
        }
        String Ir = aa.Ir(str);
        AppMethodBeat.o(30973);
        return Ir;
    }

    private static String aM(ca caVar) {
        AppMethodBeat.i(30975);
        if (caVar.field_isSend != 1) {
            String valueOf = String.valueOf(caVar.field_msgSvrId);
            AppMethodBeat.o(30975);
            return valueOf;
        } else if (ab.Eq(caVar.field_talker) || caVar.field_talker.equals("filehelper")) {
            String format = String.format("%d", Long.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(30975);
            return format;
        } else {
            String format2 = String.format("%s#%d", caVar.field_talker, Long.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(30975);
            return format2;
        }
    }
}
