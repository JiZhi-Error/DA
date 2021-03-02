package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.av.g;
import com.tencent.mm.av.h;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.tools.b;
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
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static final SimpleDateFormat BGt = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS);

    static {
        AppMethodBeat.i(9458);
        AppMethodBeat.o(9458);
    }

    public static boolean a(Context context, cz czVar, String str, List<ca> list, int i2) {
        boolean z;
        aml a2;
        String format;
        g gVar;
        boolean z2;
        AppMethodBeat.i(215180);
        if (list == null || list.isEmpty() || context == null) {
            Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
            czVar.dFZ.dGe = R.string.c_2;
            AppMethodBeat.o(215180);
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
        boolean DQ = com.tencent.mm.al.g.DQ(str);
        list.size();
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
            Log.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", czVar.dFZ.dGb.title);
        }
        anb anb = czVar.dFZ.dGb;
        anh anh = new anh();
        anh.bhf(str);
        anh.ajm(1);
        anh.MA(Util.nowMilliSecond());
        anh.bhh("");
        anb.a(anh);
        czVar.dFZ.type = 14;
        boolean z3 = false;
        boolean z4 = true;
        for (ca caVar2 : list) {
            if (caVar2 == null) {
                Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
                czVar.dFZ.dGe = R.string.c_2;
                z = false;
            } else {
                ca aZ = ca.aZ(caVar2);
                z = false;
                if (br.Q(aZ)) {
                    amm amm = new amm();
                    amm.c(aL(aZ));
                    czVar.dFZ.dGb.ppH.add(a(aZ, context.getString(R.string.wr), amm));
                    z = true;
                } else if (aZ.isText()) {
                    amm amm2 = new amm();
                    amm2.c(aL(aZ));
                    aml aml = new aml();
                    aml.bgx(aM(aZ));
                    aml.ajd(1);
                    aml.bgg((aZ.gDV() ? MMApplicationContext.getContext().getString(R.string.g8d, "@") + '\n' : "") + aZ.field_content);
                    aml.At(true);
                    aml.As(true);
                    aml.a(amm2);
                    aml.bgA(a(amm2.LwO));
                    aml.bgB(b(amm2.LwO));
                    if (as.bjp(amm2.LwO.LxA)) {
                        String O = a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm2.LwO.LxA));
                        if (!Util.isNullOrNil(O)) {
                            aml.bgJ(O);
                        }
                    }
                    czVar.dFZ.dGb.ppH.add(aml);
                    czVar.dFZ.dGc.Lyp++;
                    z = true;
                } else if (aZ.gAy()) {
                    amm amm3 = new amm();
                    amm3.c(aL(aZ));
                    aml aml2 = new aml();
                    aml2.bgx(aM(aZ));
                    aml2.ajd(3);
                    aml2.At(true);
                    aml2.As(true);
                    aml2.a(amm3);
                    aml2.bgA(a(amm3.LwO));
                    aml2.bgB(b(amm3.LwO));
                    if (as.bjp(amm3.LwO.LxA)) {
                        String O2 = a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm3.LwO.LxA));
                        if (!Util.isNullOrNil(O2)) {
                            aml2.bgJ(O2);
                        }
                    }
                    czVar.dFZ.dGb.ppH.add(aml2);
                    czVar.dFZ.dGc.Lyr++;
                    z = true;
                } else if (aZ.dOS()) {
                    z = a(czVar, aZ);
                } else if (aZ.gAz()) {
                    g gVar2 = null;
                    if (aZ.field_msgId > 0) {
                        gVar2 = q.bcR().H(aZ.field_talker, (long) ((int) aZ.field_msgId));
                    }
                    if ((gVar2 == null || gVar2.localId <= 0) && aZ.field_msgSvrId > 0) {
                        gVar2 = q.bcR().G(aZ.field_talker, aZ.field_msgSvrId);
                    }
                    if (gVar2 == null) {
                        Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
                        czVar.dFZ.dGe = R.string.c_8;
                        z = false;
                    } else {
                        amm amm4 = new amm();
                        amm4.c(aL(aZ));
                        aml aml3 = new aml();
                        aml3.bgx(aM(aZ));
                        aml3.ajd(2);
                        aml3.bgt(q.bcR().o(h.c(gVar2), "", ""));
                        if (gVar2.bcv()) {
                            g tl = q.bcR().tl(gVar2.iXx);
                            if (tl.iKP > tl.offset) {
                                aml3.bgt(q.bcR().o("SERVERID://" + aZ.field_msgSvrId, "", ""));
                            }
                        }
                        aml3.bgu(q.bcR().R(aZ.field_imgPath, true));
                        aml3.a(amm4);
                        aml3.bgA(a(amm4.LwO));
                        aml3.bgB(b(amm4.LwO));
                        aml3.Mw(aZ.field_msgId);
                        aml3.bgN(br.KB(aZ.fqK));
                        if (as.bjp(amm4.LwO.LxA)) {
                            String O3 = a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm4.LwO.LxA));
                            if (!Util.isNullOrNil(O3)) {
                                aml3.bgJ(O3);
                            }
                        }
                        if (!gVar2.bcv() || gVar2.iKP != 0) {
                            gVar = gVar2;
                        } else {
                            gVar = q.bcR().tl(gVar2.iXx);
                        }
                        if (aZ.field_isSend == 1) {
                            if (gVar.bcv()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else if (!gVar.bcv()) {
                            z2 = false;
                        } else {
                            if (!s.YS(q.bcR().o(h.a(gVar).iXm, "", ""))) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        }
                        Map<String, String> parseXml = XmlParser.parseXml(gVar.iXy, "msg", null);
                        if (parseXml == null) {
                            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", gVar.iXy);
                        } else if (z2) {
                            aml3.bgj(parseXml.get(".msg.img.$cdnbigimgurl"));
                            aml3.Mu((long) Util.getInt(parseXml.get(".msg.img.$length"), 0));
                            aml3.bgk(parseXml.get(".msg.img.$aeskey"));
                        }
                        czVar.dFZ.dGb.ppH.add(aml3);
                        czVar.dFZ.dGc.Lyq++;
                        z = true;
                    }
                } else if (aZ.cWJ() || aZ.cWL()) {
                    if (i2 == 10) {
                        amm amm5 = new amm();
                        amm5.c(aL(aZ));
                        aml aml4 = new aml();
                        aml4.bgx(aM(aZ));
                        o.bhj();
                        aml4.bgt(t.Qw(aZ.field_imgPath));
                        o.bhj();
                        aml4.bgu(t.Qx(aZ.field_imgPath));
                        aml4.bgp(s.akC(aml4.LvL));
                        if (aZ.cWL()) {
                            aml4.ajd(15);
                        } else {
                            aml4.ajd(4);
                        }
                        com.tencent.mm.modelvideo.s QN = u.QN(aZ.field_imgPath);
                        if (QN == null) {
                            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
                            czVar.dFZ.dGe = R.string.c_1;
                            z = false;
                        } else {
                            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d maxFileLength:%s", Integer.valueOf(QN.iKP), Integer.valueOf(com.tencent.mm.pluginsdk.model.z.gmL()));
                            if (QN.iKP > com.tencent.mm.pluginsdk.model.z.gmL()) {
                                czVar.dFZ.dGe = R.string.ccw;
                                z = false;
                            } else if (!aZ.cWL() || !u.QO(QN.getFileName())) {
                                aml4.ajc(QN.iFw);
                                aml4.a(amm5);
                                aml4.bgA(a(amm5.LwO));
                                aml4.bgB(b(amm5.LwO));
                                if (as.bjp(amm5.LwO.LxA)) {
                                    String O4 = a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm5.LwO.LxA));
                                    if (!Util.isNullOrNil(O4)) {
                                        aml4.bgJ(O4);
                                    }
                                }
                                aml4.Mw(aZ.field_msgId);
                                aml4.bgN(br.KB(aZ.fqK));
                                aml4.Mu((long) QN.iKP);
                                Map<String, String> parseXml2 = XmlParser.parseXml(QN.bhv(), "msg", null);
                                if (parseXml2 != null) {
                                    aml4.bgj(parseXml2.get(".msg.videomsg.$cdnvideourl"));
                                    aml4.bgk(parseXml2.get(".msg.videomsg.$aeskey"));
                                } else {
                                    Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
                                }
                                czVar.dFZ.dGb.ppH.add(aml4);
                                czVar.dFZ.dGc.xiP++;
                                com.tencent.mm.modelvideo.s QN2 = u.QN(aZ.field_imgPath);
                                Map<String, String> parseXml3 = XmlParser.parseXml(QN.bhv(), "msg", null);
                                if (parseXml3 != null) {
                                    aml4.bgq(parseXml3.get(".msg.videomsg.$md5"));
                                }
                                aml4.bgD(QN2.ean);
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
                                    aml4.a(amo);
                                }
                                z = true;
                            } else {
                                czVar.dFZ.dGe = R.string.c_1;
                                z = false;
                            }
                        }
                    } else {
                        amm amm6 = new amm();
                        amm6.c(aL(aZ));
                        aml aml5 = new aml();
                        aml5.bgx(aM(aZ));
                        o.bhj();
                        aml5.bgt(t.Qw(aZ.field_imgPath));
                        o.bhj();
                        aml5.bgu(t.Qx(aZ.field_imgPath));
                        aml5.bgp(s.akC(aml5.LvL));
                        if (aZ.cWL()) {
                            aml5.ajd(15);
                        } else {
                            aml5.ajd(4);
                        }
                        com.tencent.mm.modelvideo.s QN3 = u.QN(aZ.field_imgPath);
                        if (QN3 == null) {
                            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
                            czVar.dFZ.dGe = R.string.c_1;
                            z = false;
                        } else {
                            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", Integer.valueOf(QN3.iKP));
                            if (QN3.iKP > ((af) com.tencent.mm.kernel.g.ah(af.class)).getVideoSizeLimit(true)) {
                                czVar.dFZ.dGe = R.string.ccw;
                                z = false;
                            } else if (!aZ.cWL() || !u.QO(QN3.getFileName())) {
                                aml5.ajc(QN3.iFw);
                                aml5.a(amm6);
                                aml5.bgA(a(amm6.LwO));
                                aml5.bgB(b(amm6.LwO));
                                if (as.bjp(amm6.LwO.LxA)) {
                                    String O5 = a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm6.LwO.LxA));
                                    if (!Util.isNullOrNil(O5)) {
                                        aml5.bgJ(O5);
                                    }
                                }
                                aml5.Mw(aZ.field_msgId);
                                aml5.bgN(br.KB(aZ.fqK));
                                aml5.Mu((long) QN3.iKP);
                                Map<String, String> parseXml4 = XmlParser.parseXml(QN3.bhv(), "msg", null);
                                if (parseXml4 != null) {
                                    aml5.bgj(parseXml4.get(".msg.videomsg.$cdnvideourl"));
                                    aml5.bgk(parseXml4.get(".msg.videomsg.$aeskey"));
                                } else {
                                    Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
                                }
                                czVar.dFZ.dGb.ppH.add(aml5);
                                czVar.dFZ.dGc.xiP++;
                                com.tencent.mm.modelvideo.s QN4 = u.QN(aZ.field_imgPath);
                                aml5.bgD(QN4.ean);
                                eeq eeq2 = QN4.jsw;
                                if (eeq2 != null && !Util.isNullOrNil(eeq2.izf)) {
                                    amo amo2 = new amo();
                                    amo2.iyZ = eeq2.iyZ;
                                    amo2.LxJ = eeq2.LxJ;
                                    amo2.izc = eeq2.izc;
                                    amo2.izd = eeq2.izd;
                                    amo2.izb = eeq2.izb;
                                    amo2.ize = eeq2.ize;
                                    amo2.izf = eeq2.izf;
                                    amo2.izg = eeq2.izg;
                                    aml5.a(amo2);
                                }
                                z = true;
                            } else {
                                czVar.dFZ.dGe = R.string.c_1;
                                z = false;
                            }
                        }
                    }
                } else if (aZ.cWK()) {
                    z = b(czVar, aZ);
                } else if (aZ.getType() == 318767153) {
                    z = a(context, czVar, aZ, 3);
                } else if (aZ.gAt()) {
                    z = c(czVar, aZ);
                } else if (aZ.gDn() || aZ.gDo()) {
                    z = a(context, czVar, aZ, 1);
                } else if (aZ.getType() == 419430449) {
                    z = a(context, czVar, aZ, 2);
                } else if (aZ.gDl()) {
                    ca.a aEK = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEK(aZ.field_content);
                    amm amm7 = new amm();
                    amm7.c(aL(aZ));
                    if (aEK != null && ab.rR(aEK.IOs)) {
                        aml aml6 = new aml();
                        aml6.bgx(aM(aZ));
                        aml6.ajd(16);
                        aml6.bgg(aZ.field_content);
                        aml6.At(true);
                        aml6.As(true);
                        aml6.a(amm7);
                        aml6.bgA(a(amm7.LwO));
                        aml6.bgB(b(amm7.LwO));
                        if (as.bjp(amm7.LwO.LxA)) {
                            String O6 = a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm7.LwO.LxA));
                            if (!Util.isNullOrNil(O6)) {
                                aml6.bgJ(O6);
                            }
                            a2 = aml6;
                        } else {
                            a2 = aml6;
                        }
                    } else if (aEK == null || !as.bjp(aEK.dkU)) {
                        a2 = a(aZ, context.getString(R.string.vr), amm7);
                    } else {
                        String a3 = ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(aEK.OqO, "openim_card_type_name", a.EnumC0497a.TYPE_WORDING);
                        if (TextUtils.isEmpty(a3)) {
                            format = context.getResources().getString(R.string.vr);
                        } else {
                            format = String.format("[%s]", a3);
                        }
                        a2 = a(aZ, format, amm7);
                    }
                    czVar.dFZ.dGb.ppH.add(a2);
                    czVar.dFZ.dGc.LyB++;
                    z = true;
                } else if (!aZ.dOQ()) {
                    czVar.dFZ.dGe = R.string.c__;
                    z = a(context, czVar, aZ, 3);
                } else if (aZ.gDo()) {
                    czVar.dFZ.dGe = R.string.c__;
                } else {
                    z = a(context, czVar, aZ);
                }
            }
            if (z) {
                z3 = true;
            } else {
                z4 = false;
            }
        }
        if (z3 && czVar.dFZ.dGe > 0) {
            czVar.dFZ.dGe = 0;
        }
        AppMethodBeat.o(215180);
        return z4;
    }

    private static boolean a(Context context, cz czVar, ca caVar, int i2) {
        AppMethodBeat.i(9446);
        amm amm = new amm();
        amm.c(aL(caVar));
        String str = null;
        if (i2 == 1) {
            str = context.getString(R.string.tu);
        } else if (i2 == 2) {
            str = context.getString(R.string.xd);
        } else if (i2 == 3) {
            str = context.getString(R.string.z4);
        }
        czVar.dFZ.dGb.ppH.add(a(caVar, str, amm));
        AppMethodBeat.o(9446);
        return true;
    }

    private static amn aL(ca caVar) {
        String str;
        AppMethodBeat.i(9447);
        amn amn = new amn();
        if (caVar == null) {
            AppMethodBeat.o(9447);
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
        if (com.tencent.mm.al.g.DQ(caVar.field_talker)) {
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
        AppMethodBeat.o(9447);
        return amn;
    }

    private static String b(amn amn) {
        AppMethodBeat.i(9449);
        String format = BGt.format(new Date(amn.createTime));
        AppMethodBeat.o(9449);
        return format;
    }

    private static boolean a(cz czVar, ca caVar) {
        AppMethodBeat.i(9451);
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
                AppMethodBeat.o(9451);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", e2.getStackTrace().toString());
            }
        }
        czVar.dFZ.dGe = R.string.c_b;
        AppMethodBeat.o(9451);
        return false;
    }

    private static aml a(ca caVar, k.b bVar, int i2) {
        AppMethodBeat.i(9454);
        aml aml = new aml();
        aml.bgx(aM(caVar));
        aml.bgm(bVar.ixd);
        aml.bgn(bVar.ixe);
        aml.bgl(bVar.url);
        aml.As(true);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(Util.nullAs(q.bcR().R(caVar.field_imgPath, true), ""));
        if (oVar.exists()) {
            aml.bgu(com.tencent.mm.vfs.aa.z(oVar.her()));
        } else {
            aml.At(true);
        }
        aml.bgf(bVar.title);
        aml.bgg(bVar.description);
        aml.ajd(i2);
        aml.bgE(bVar.canvasPageXml);
        AppMethodBeat.o(9454);
        return aml;
    }

    private static aml a(ca caVar, String str, amm amm) {
        AppMethodBeat.i(9455);
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
        AppMethodBeat.o(9455);
        return aml;
    }

    private static boolean a(Context context, cz czVar, ca caVar) {
        String str;
        AppMethodBeat.i(9456);
        amm amm = new amm();
        amm.c(aL(caVar));
        String str2 = caVar.field_content;
        if (str2 == null) {
            czVar.dFZ.dGe = R.string.c_b;
            AppMethodBeat.o(9456);
            return false;
        }
        k.b HD = k.b.HD(str2);
        if (HD == null) {
            czVar.dFZ.dGe = R.string.c_b;
            AppMethodBeat.o(9456);
            return false;
        }
        amm.LwO.bgT(HD.appId);
        amm.LwO.bgV(HD.eag);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, true, false);
        if (o == null || !o.NA()) {
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
                    AppMethodBeat.o(9456);
                    return true;
                case 2:
                    com.tencent.mm.kernel.g.aAi();
                    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
                        czVar.dFZ.dGe = R.string.c_h;
                        AppMethodBeat.o(9456);
                        return false;
                    }
                    com.tencent.mm.pluginsdk.model.app.c bdx = com.tencent.mm.plugin.r.a.cgO().bdx(HD.dCK);
                    aml aml2 = new aml();
                    aml2.bgx(aM(caVar));
                    if (bdx != null) {
                        aml2.bgt(bdx.field_fileFullPath);
                    }
                    String R = q.bcR().R(caVar.field_imgPath, true);
                    if (s.YS(R)) {
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
                    AppMethodBeat.o(9456);
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
                    if (HD.as(b.class) != null) {
                        a2.bgL(((b) HD.as(b.class)).songAlbumUrl);
                        a2.bgM(((b) HD.as(b.class)).songLyric);
                    }
                    czVar.dFZ.dGb.ppH.add(a2);
                    czVar.dFZ.dGc.Lyu++;
                    AppMethodBeat.o(9456);
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
                    AppMethodBeat.o(9456);
                    return true;
                case 5:
                    if (HD.url == null || HD.url.equals("")) {
                        czVar.dFZ.dGe = R.string.c_6;
                        czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.z4), amm));
                        AppMethodBeat.o(9456);
                        return true;
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
                    amm.d(m.a(caVar, anq));
                    AppMethodBeat.o(9456);
                    return true;
                case 6:
                    com.tencent.mm.kernel.g.aAi();
                    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
                        czVar.dFZ.dGe = R.string.c_h;
                        AppMethodBeat.o(9456);
                        return false;
                    }
                    com.tencent.mm.pluginsdk.model.app.c bdx2 = com.tencent.mm.plugin.r.a.cgO().bdx(HD.dCK);
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
                    if (s.YS(R2)) {
                        aml3.bgu(R2);
                    }
                    aml3.bgf(HD.title);
                    aml3.bgg(HD.description);
                    aml3.a(amm);
                    aml3.bgA(a(amm.LwO));
                    aml3.bgB(b(amm.LwO));
                    aml3.Mw(caVar.field_msgId);
                    aml3.Mu((long) HD.iwI);
                    aml3.bgq(HD.filemd5);
                    if (as.bjp(amm.LwO.LxA)) {
                        String O6 = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
                        if (!Util.isNullOrNil(O6)) {
                            aml3.bgJ(O6);
                        }
                    }
                    aml3.bgj(HD.iwW);
                    aml3.bgk(HD.aesKey);
                    aml3.bgI(HD.iwN);
                    aml3.bgG(HD.aesKey);
                    aml3.bgH(HD.iwT);
                    czVar.dFZ.dGb.ppH.add(aml3);
                    czVar.dFZ.dGc.fileCount++;
                    AppMethodBeat.o(9456);
                    return true;
                case 7:
                    if (HD.dCK == null || HD.dCK.length() == 0) {
                        czVar.dFZ.dGe = R.string.c_3;
                    } else {
                        com.tencent.mm.kernel.g.aAi();
                        if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
                            czVar.dFZ.dGe = R.string.c_h;
                            AppMethodBeat.o(9456);
                            return false;
                        }
                    }
                    czVar.dFZ.dGe = R.string.c__;
                    AppMethodBeat.o(9456);
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
                    AppMethodBeat.o(9456);
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
                    AppMethodBeat.o(9456);
                    return true;
                case 16:
                    czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.y1), amm));
                    AppMethodBeat.o(9456);
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
                                    AppMethodBeat.o(9456);
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
                        AppMethodBeat.o(9456);
                        return true;
                    }
                    czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.cd7), amm));
                    AppMethodBeat.o(9456);
                    return true;
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
                    AppMethodBeat.o(9456);
                    return true;
                case 24:
                    czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.cd7), amm));
                    AppMethodBeat.o(9456);
                    return true;
                case 33:
                case 36:
                    if (HD.izk == 3) {
                        czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.x8), amm));
                        AppMethodBeat.o(9456);
                        return true;
                    }
                    aml aml8 = new aml();
                    aml8.bgx(aM(caVar));
                    aml8.bgf(HD.title);
                    aml8.bgg(HD.description);
                    aml8.ajd(19);
                    String R3 = q.bcR().R(caVar.field_imgPath, true);
                    if (Util.isNullOrNil(R3)) {
                        aml8.At(true);
                    }
                    if (s.YS(R3)) {
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
                    amj.type = HD.izk;
                    amj.dMe = HD.izz;
                    amj.dCx = HD.izh;
                    amj.Lve = HD.eah;
                    amj.lyE = HD.izr;
                    com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class);
                    if (aVar != null) {
                        amj.leb = aVar.ivc;
                        amj.eda = aVar.ive;
                        amj.subType = aVar.ivf;
                    }
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
                    AppMethodBeat.o(9456);
                    return true;
                case 44:
                    String w = HD.w(context, true);
                    if (Util.isNullOrNil(w)) {
                        czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.z4), amm));
                        AppMethodBeat.o(9456);
                        return true;
                    }
                    czVar.dFZ.dGb.ppH.add(a(caVar, w + HD.title, amm));
                    AppMethodBeat.o(9456);
                    return true;
                case 46:
                    czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.x8), amm));
                    AppMethodBeat.o(9456);
                    return true;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.vu) + HD.title, amm));
                    AppMethodBeat.o(9456);
                    return true;
                case 50:
                    com.tencent.mm.plugin.i.a.e eVar = (com.tencent.mm.plugin.i.a.e) HD.as(com.tencent.mm.plugin.i.a.e.class);
                    if (eVar != null) {
                        bci bci = eVar.wDW;
                        aml aml9 = new aml();
                        aml9.bgA(a(amm.LwO));
                        aml9.bgB(b(amm.LwO));
                        aml9.bgx(aM(caVar));
                        aml9.As(true);
                        aml9.bgf(eVar.nickname);
                        aml9.ajd(26);
                        amm.a(bci);
                        aml9.a(amm);
                        czVar.dFZ.dGb.ppH.add(aml9);
                        AppMethodBeat.o(9456);
                        return true;
                    }
                    AppMethodBeat.o(9456);
                    return false;
                case 51:
                    f fVar = (f) HD.as(f.class);
                    if (fVar != null) {
                        bcj bcj = fVar.jlg;
                        aml aml10 = new aml();
                        aml10.bgA(a(amm.LwO));
                        aml10.bgB(b(amm.LwO));
                        aml10.bgx(aM(caVar));
                        aml10.As(true);
                        aml10.bgf(bcj.nickname + MMApplicationContext.getContext().getString(R.string.cce));
                        aml10.bgg(bcj.desc);
                        aml10.ajd(22);
                        amm.c(bcj);
                        aml10.a(amm);
                        czVar.dFZ.dGb.ppH.add(aml10);
                        AppMethodBeat.o(9456);
                        return true;
                    }
                    AppMethodBeat.o(9456);
                    return false;
                case bv.CTRL_INDEX:
                case 72:
                    com.tencent.mm.plugin.i.a.h hVar = (com.tencent.mm.plugin.i.a.h) HD.as(com.tencent.mm.plugin.i.a.h.class);
                    if (hVar != null) {
                        bcl bcl = hVar.jld;
                        aml aml11 = new aml();
                        aml11.bgA(a(amm.LwO));
                        aml11.bgB(b(amm.LwO));
                        aml11.bgx(aM(caVar));
                        aml11.As(true);
                        if (bcl.tvC == 1) {
                            aml11.bgf(MMApplicationContext.getContext().getString(R.string.fw5, bcl.dST));
                        } else {
                            aml11.bgf(bcl.dST);
                        }
                        aml11.bgg(bcl.desc);
                        aml11.ajd(27);
                        amm.c(bcl);
                        aml11.a(amm);
                        czVar.dFZ.dGb.ppH.add(aml11);
                        AppMethodBeat.o(9456);
                        return true;
                    }
                    AppMethodBeat.o(9456);
                    return false;
                case 63:
                    com.tencent.mm.plugin.i.a.b bVar = (com.tencent.mm.plugin.i.a.b) HD.as(com.tencent.mm.plugin.i.a.b.class);
                    if (bVar != null) {
                        axf axf = bVar.wDV;
                        aml aml12 = new aml();
                        aml12.bgA(a(amm.LwO));
                        aml12.bgB(b(amm.LwO));
                        aml12.bgx(aM(caVar));
                        aml12.As(true);
                        aml12.bgf(axf.nickName + MMApplicationContext.getContext().getString(R.string.ccd));
                        aml12.bgg(axf.desc);
                        aml12.ajd(23);
                        amm.e(axf);
                        aml12.a(amm);
                        czVar.dFZ.dGb.ppH.add(aml12);
                        AppMethodBeat.o(9456);
                        return true;
                    }
                    AppMethodBeat.o(9456);
                    return false;
                case d.CTRL_INDEX:
                    com.tencent.mm.plugin.i.a.d dVar = (com.tencent.mm.plugin.i.a.d) HD.as(com.tencent.mm.plugin.i.a.d.class);
                    if (dVar != null) {
                        bcf bcf = dVar.jle;
                        aml aml13 = new aml();
                        aml13.bgA(a(amm.LwO));
                        aml13.bgB(b(amm.LwO));
                        aml13.bgx(aM(caVar));
                        aml13.As(true);
                        aml13.bgf(bcf.title);
                        aml13.bgg(bcf.oqZ);
                        aml13.ajd(28);
                        amm.c(bcf);
                        aml13.a(amm);
                        czVar.dFZ.dGb.ppH.add(aml13);
                        AppMethodBeat.o(9456);
                        return true;
                    }
                    AppMethodBeat.o(9456);
                    return false;
                case 75:
                    com.tencent.mm.plugin.i.a.l.d(HD.izF, HD.izD);
                    czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.z4), amm));
                    AppMethodBeat.o(9456);
                    return true;
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
                    if (HD.as(b.class) != null) {
                        a5.bgL(((b) HD.as(b.class)).songAlbumUrl);
                        a5.bgM(((b) HD.as(b.class)).songLyric);
                        css css = new css();
                        css.Ktn = ((b) HD.as(b.class)).Ktn;
                        css.Kto = ((b) HD.as(b.class)).Kto;
                        css.Ktp = ((b) HD.as(b.class)).Ktp;
                        css.Ktq = ((b) HD.as(b.class)).Ktq;
                        css.singerName = ((b) HD.as(b.class)).Ktr;
                        css.albumName = ((b) HD.as(b.class)).Kts;
                        css.musicGenre = ((b) HD.as(b.class)).Ktt;
                        css.issueDate = Util.safeParseLong(((b) HD.as(b.class)).Ktu);
                        css.identification = ((b) HD.as(b.class)).Ktv;
                        css.Alz = ((b) HD.as(b.class)).Alz;
                        css.extraInfo = ((b) HD.as(b.class)).Ktw;
                        amm.e(css);
                    }
                    a5.a(amm);
                    czVar.dFZ.dGb.ppH.add(a5);
                    czVar.dFZ.dGc.Lyu++;
                    AppMethodBeat.o(9456);
                    return true;
                default:
                    czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.z4), amm));
                    AppMethodBeat.o(9456);
                    return true;
            }
        } else {
            czVar.dFZ.dGb.ppH.add(a(caVar, context.getString(R.string.vs), amm));
            AppMethodBeat.o(9456);
            return true;
        }
    }

    private static boolean c(cz czVar, ca caVar) {
        AppMethodBeat.i(9457);
        try {
            com.tencent.mm.ag.u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.field_msgId, caVar.field_content);
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
                            aml.bgu(com.tencent.mm.pluginsdk.model.s.bdu(vVar.iAo));
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
                    AppMethodBeat.o(9457);
                    return false;
                }
                AppMethodBeat.o(9457);
                return true;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", e2, "", new Object[0]);
            Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", e2.getLocalizedMessage());
        }
        czVar.dFZ.dGe = R.string.c_b;
        AppMethodBeat.o(9457);
        return false;
    }

    private static String a(amn amn) {
        AppMethodBeat.i(9448);
        String str = amn.LxA;
        if (Util.isNullOrNil(str)) {
            str = amn.dRL;
        }
        if (e.NF(str)) {
            String NH = e.NH(str);
            AppMethodBeat.o(9448);
            return NH;
        }
        String Ir = aa.Ir(str);
        AppMethodBeat.o(9448);
        return Ir;
    }

    private static String aM(ca caVar) {
        AppMethodBeat.i(9450);
        if (caVar.field_isSend != 1) {
            String valueOf = String.valueOf(caVar.field_msgSvrId);
            AppMethodBeat.o(9450);
            return valueOf;
        } else if (ab.Eq(caVar.field_talker) || caVar.field_talker.equals("filehelper")) {
            String format = String.format("%d", Long.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(9450);
            return format;
        } else {
            String format2 = String.format("%s#%d", caVar.field_talker, Long.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(9450);
            return format2;
        }
    }

    public static boolean b(cz czVar, ca caVar) {
        AppMethodBeat.i(9452);
        k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
        if (aD == null) {
            Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo content is null");
            AppMethodBeat.o(9452);
            return false;
        }
        anb anb = new anb();
        anh anh = new anh();
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(4);
        anh.MA(Util.nowMilliSecond());
        anh.bhm(aD.url);
        anb.a(anh);
        aml aml = new aml();
        aml.bgt("");
        aml.bgo(aD.thumburl);
        amt v = m.v(caVar);
        if (v == null) {
            Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo favMpMsgItem is null");
            AppMethodBeat.o(9452);
            return false;
        }
        aml.ajc(v.duration);
        aml.bgf(aD.title);
        aml.bgl(aD.url);
        aml.As(true);
        aml.At(true);
        amm amm = new amm();
        amm.c(aL(caVar));
        if (caVar.cWK()) {
            amm.e(v);
        }
        aml.a(amm);
        aml.Mw(caVar.field_msgId);
        aml.bgA(a(amm.LwO));
        aml.bgB(b(amm.LwO));
        if (as.bjp(amm.LwO.LxA)) {
            String O = com.tencent.mm.openim.room.a.a.O(((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(amm.LwO.LxA));
            if (!Util.isNullOrNil(O)) {
                aml.bgJ(O);
            }
        }
        czVar.dFZ.dGb.ppH.add(aml);
        czVar.dFZ.dGc.xiP++;
        aml.ajd(4);
        AppMethodBeat.o(9452);
        return true;
    }
}
