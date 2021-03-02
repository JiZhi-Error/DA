package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class q extends IListener<hb> {
    public q() {
        AppMethodBeat.i(160917);
        this.__eventId = hb.class.getName().hashCode();
        AppMethodBeat.o(160917);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(hb hbVar) {
        AppMethodBeat.i(107064);
        boolean d2 = d(hbVar);
        AppMethodBeat.o(107064);
        return d2;
    }

    private static boolean d(hb hbVar) {
        g DZ;
        boolean YY;
        double ZY;
        g DY;
        g DY2;
        AppMethodBeat.i(107062);
        switch (hbVar.dLm.type) {
            case 2:
                if (hbVar.dLm.dLo != null) {
                    o oVar = new o(b.d(hbVar.dLm.dLo));
                    if (oVar.exists()) {
                        hbVar.dLn.path = aa.z(oVar.her());
                    }
                    o oVar2 = new o(b.a(hbVar.dLm.dLo));
                    if (oVar2.exists()) {
                        hbVar.dLn.thumbPath = aa.z(oVar2.her());
                        break;
                    }
                }
                break;
            case 4:
                g DY3 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                if (!(DY3 == null || DY3.field_tagProto.Lyo == null)) {
                    hbVar.dLn.bzh = new ArrayList();
                    hbVar.dLn.bzh.addAll(DY3.field_tagProto.Lyo);
                    break;
                }
            case 6:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(hbVar.dLm.dLq);
                hbVar.dLn.ret = 0;
                break;
            case 7:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(hbVar.dLm.dLq);
                hbVar.dLn.ret = 0;
                break;
            case 8:
                hbVar.dLn.dLz = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUP();
                hbVar.dLn.ret = 0;
                break;
            case 9:
                g DY4 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                if (DY4 == null) {
                    hbVar.dLn.dLy = null;
                } else {
                    hbVar.dLn.dLy = b.a(DY4.field_type, DY4.field_favProto, DY4.field_tagProto);
                }
                hbVar.dLn.ret = 0;
                break;
            case 10:
                ((y) com.tencent.mm.kernel.g.af(y.class)).a(hbVar.dLm.context, ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW), hbVar.dLm.dLx);
                hbVar.dLn.ret = 0;
                break;
            case 11:
                String[] a2 = b.a(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW), hbVar.dLm.handler);
                hbVar.dLn.thumbPath = a2[0];
                hbVar.dLn.thumbUrl = a2[1];
                hbVar.dLn.ret = 0;
                break;
            case 12:
                b.b(hbVar.dLm.dFW, hbVar.dLm.dLr);
                break;
            case 13:
                g DY5 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                b.q(DY5);
                if (DY5 == null && hbVar.dLm.dGb != null) {
                    DY5 = b.a(hbVar.dLm.dGb);
                }
                l.a(hbVar.dLm.context, hbVar.dLm.toUser, hbVar.dLm.dLs, DY5, hbVar.dLm.dLr);
                break;
            case 14:
                if (b.g(hbVar.dLm.dLo)) {
                    hbVar.dLn.ret = 1;
                    break;
                } else {
                    hbVar.dLn.ret = 0;
                    break;
                }
            case 15:
                b.l(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW));
                break;
            case 16:
                b.m(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW));
                break;
            case 17:
                hbVar.dLn.ret = b.arN(hbVar.dLm.dLo.LvC);
                break;
            case 18:
                ArrayList arrayList = new ArrayList();
                arrayList.add(7);
                ArrayList<g> a3 = b.a((List<String>) null, (List<String>) null, arrayList, (List<g>) null, (Set<Integer>) null, (w) null);
                ArrayList arrayList2 = new ArrayList();
                for (g gVar : a3) {
                    anh anh = gVar.field_favProto.Lya;
                    if (gVar.field_type == 7 || gVar.field_type == 21) {
                        aml c2 = b.c(gVar);
                        f a4 = com.tencent.mm.ay.g.a(6, null, c2.title, c2.desc, c2.Lvu, c2.Lvy, c2.Lvw, c2.dLl, b.cUl(), m(c2), "", anh.appId);
                        a4.jfm = c2.songAlbumUrl;
                        a4.jfe = c2.songLyric;
                        arrayList2.add(a4);
                    } else if (gVar.field_type == 14 && gVar.field_favProto.ppH != null) {
                        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
                        while (it.hasNext()) {
                            aml next = it.next();
                            if (next.dataType == 7 || next.dataType == 29) {
                                f a5 = com.tencent.mm.ay.g.a(6, null, next.title, next.desc, next.Lvu, next.Lvy, next.Lvw, next.dLl, b.cUl(), m(next), "", anh.appId);
                                a5.jfm = next.songAlbumUrl;
                                a5.jfe = next.songLyric;
                                arrayList2.add(a5);
                            }
                        }
                    }
                }
                hbVar.dLn.dLA = arrayList2;
                break;
            case 19:
                if (hbVar.dLm.dFW != -1) {
                    if (hbVar.dLm.dLt != -1) {
                        if (hbVar.dLm.dLt != -3 || hbVar.dLm.dFW <= 0) {
                            if (hbVar.dLm.dLt == -2 && hbVar.dLm.dFW > 0 && (DY2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW)) != null && DY2.field_itemStatus == 10 && !Util.isNullOrNil(DY2.field_xml)) {
                                DY2.arQ(DY2.field_xml);
                                if (DY2.field_favProto != null && DY2.field_favProto.ppH.size() > 1) {
                                    aml aml = DY2.field_favProto.ppH.get(0);
                                    if (!Util.isNullOrNil(aml.KuR) && !Util.isNullOrNil(aml.Lvp)) {
                                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DY2, ch.COL_LOCALID);
                                        break;
                                    }
                                }
                            }
                            Intent intent = new Intent();
                            if (hbVar.dLm.dFW > 0 && !Util.isNullOrNil(hbVar.dLm.desc) && hbVar.dLm.dLt > 0 && (DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW)) != null) {
                                intent.putExtra("fav_note_xml", g.t(DY));
                                intent.putExtra("fav_note_item_updatetime", DY.field_updateTime);
                            }
                            g a6 = k.a(hbVar.dLm.dGb.ppH, hbVar.dLm.dFW);
                            if (!Util.isNullOrNil(hbVar.dLm.desc)) {
                                if (hbVar.dLm.dLt > 0) {
                                    intent.putExtra("fav_note_item_status", a6.field_itemStatus);
                                    hbVar.dLm.dLp = intent;
                                    a6.field_favProto.ajl(a6.field_favProto.version + 1);
                                }
                                a6.field_itemStatus = 1;
                                b.q(a6);
                                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(a6, ch.COL_LOCALID);
                                if (hbVar.dLm.desc.equals("fav_add_new_note")) {
                                    if (a6.field_favProto.version != 0) {
                                        a6.field_favProto.ajl(a6.field_favProto.version + 1);
                                    } else {
                                        a6.field_favProto.ajl(a6.field_favProto.version + 2);
                                    }
                                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(a6, ch.COL_LOCALID);
                                    k.a(hbVar.dLm.title, hbVar.dLm.dGb.ppH, hbVar.dLm.dFW);
                                    break;
                                }
                            } else {
                                if (a6.field_favProto.version != 0) {
                                    a6.field_favProto.ajl(a6.field_favProto.version + 1);
                                } else {
                                    a6.field_favProto.ajl(a6.field_favProto.version + 2);
                                }
                                a6.field_itemStatus = 1;
                                b.q(a6);
                                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(a6, ch.COL_LOCALID);
                                ((af) com.tencent.mm.kernel.g.ah(af.class)).getCheckCdnService().run();
                                break;
                            }
                        } else {
                            g DY6 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                            if (DY6 != null) {
                                DY6.field_itemStatus = hbVar.dLm.dLp.getIntExtra("fav_note_item_status", DY6.field_itemStatus);
                                DY6.field_updateTime = hbVar.dLm.dLp.getLongExtra("fav_note_item_updatetime", DY6.field_updateTime);
                                DY6.arQ(hbVar.dLm.dLp.getStringExtra("fav_note_xml"));
                                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DY6, ch.COL_LOCALID);
                                break;
                            }
                        }
                    } else {
                        g DY7 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                        if (!(DY7 == null || DY7.field_favProto == null || DY7.field_favProto.ppH.size() <= 1)) {
                            hbVar.dLn.dLD = Util.isNullOrNil(DY7.field_favProto.ppH.get(0).KuR);
                            break;
                        }
                    }
                } else {
                    k.a(hbVar.dLm.title, hbVar.dLm.dGb.ppH, -1);
                    break;
                }
                break;
            case 20:
                ap.cVm().cVn();
                ap cVm = ap.cVm();
                String str = hbVar.dLm.title;
                int i2 = hbVar.dLm.dLt;
                int i3 = hbVar.dLm.dLu;
                cVm.path = Util.nullAs(str, "");
                cVm.dLt = i2;
                cVm.duration = i3;
                break;
            case 21:
                hbVar.dLn.path = m.J(hbVar.dLm.context, hbVar.dLm.dLu).toString();
                break;
            case 22:
                ap.cVm();
                ap.cVo().destroy();
                break;
            case 23:
                ap.cVm();
                ap.cVo().cUJ();
                break;
            case 24:
                hb.b bVar = hbVar.dLn;
                ap.cVm();
                bVar.dLB = ap.cVo().ab(hbVar.dLm.path, hbVar.dLm.dLt, hbVar.dLm.dLu);
                break;
            case 25:
                ap.cVm();
                ap.cVo().stopPlay();
                break;
            case 26:
                hb.b bVar2 = hbVar.dLn;
                ap.cVm();
                bVar2.path = ap.cVo().path;
                hb.b bVar3 = hbVar.dLn;
                ap.cVm();
                bVar3.dLB = ap.cVo().cEF();
                hb.b bVar4 = hbVar.dLn;
                ap.cVm();
                bVar4.dLC = ap.cVo().cUI();
                hb.b bVar5 = hbVar.dLn;
                ap.cVm();
                n cVo = ap.cVo();
                if (cVo.qUl == null) {
                    Log.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
                    YY = false;
                } else {
                    YY = cVo.qUl.YY();
                }
                bVar5.dLD = YY;
                hb.b bVar6 = hbVar.dLn;
                ap.cVm();
                n cVo2 = ap.cVo();
                if (cVo2.qUl == null) {
                    Log.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
                    ZY = 0.0d;
                } else {
                    ZY = cVo2.qUl.ZY();
                }
                bVar6.dLE = ZY;
                break;
            case 27:
                if (hbVar.dLm.dLo != null) {
                    hbVar.dLn.path = aa.z(new o(b.d(hbVar.dLm.dLo)).her());
                    hbVar.dLn.thumbPath = aa.z(new o(b.a(hbVar.dLm.dLo)).her());
                    break;
                }
                break;
            case 28:
                g DY8 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                if (DY8 != null) {
                    if (Util.isNullOrNil(hbVar.dLm.path)) {
                        b.a(DY8, hbVar.dLm.dLo, true);
                        break;
                    } else {
                        b.a(DY8, hbVar.dLm.dLo);
                        break;
                    }
                } else {
                    b.b(hbVar.dLm.dLo, hbVar.dLm.dLt, hbVar.dLm.dFW);
                    b.a(hbVar.dLm.dLo, hbVar.dLm.dLt, hbVar.dLm.dFW);
                    break;
                }
            case 30:
                b.c(hbVar);
                break;
            case 31:
                am amVar = (am) hbVar.dLm.dGJ;
                hbVar.dLn.path = amVar.tbF;
                if (!(amVar.getReqResp() == null || amVar.getReqResp().getRespObj() == null || amVar.getReqResp().getRespObj().getRetCode() != -435 || (DZ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) amVar.tbB)) == null || DZ.field_favProto == null || DZ.field_favProto.ppH == null)) {
                    DZ.field_favProto.ajl(DZ.field_favProto.version + 2);
                    DZ.field_itemStatus = 1;
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ, ch.COL_LOCALID);
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getCheckCdnService().run();
                    break;
                }
            case 32:
                g DY9 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                if (DY9 == null && hbVar.dLm.dGb != null) {
                    DY9 = b.a(hbVar.dLm.dGb);
                }
                hbVar.dLn.ret = (!new k().u(DY9) || b.g(DY9)) ? 0 : 1;
                hbVar.dLn.dLD = k.v(DY9);
                hbVar.dLn.path = "";
                if (DY9 == null) {
                    hbVar.dLn.dLD = true;
                    hbVar.dLn.path = null;
                    break;
                }
                break;
            case 33:
                g DY10 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                if (DY10 != null) {
                    DY10.field_favProto.bH(hbVar.dLm.dGb.ppH);
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().b(DY10, ch.COL_LOCALID);
                    break;
                }
                break;
            case 34:
                g DY11 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
                if (DY11 != null && DY11.field_type == 18) {
                    hbVar.dLm.dGb = DY11.field_favProto;
                    break;
                }
            case 35:
                b.fh(hbVar.dLm.context);
                break;
            case 36:
                hbVar.dLn.ret = b.cUp() ? 1 : 0;
                break;
            case 37:
                b.e(hbVar.dLm.context, hbVar.dLm.desc, hbVar.dLm.title, hbVar.dLm.path);
                break;
            case 38:
                Log.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", hbVar.dLm.dLv);
                if (!Util.isNullOrNil(hbVar.dLm.dLv)) {
                    String[] split = hbVar.dLm.dLv.split(";");
                    LinkedList<String> linkedList = new LinkedList();
                    linkedList.addAll(Arrays.asList(split));
                    if (linkedList.size() > 0) {
                        ArrayList arrayList3 = new ArrayList();
                        for (String str2 : linkedList) {
                            try {
                                int intValue = Integer.valueOf(str2).intValue();
                                if (intValue > 0) {
                                    g DZ2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) intValue);
                                    amr amr = new amr();
                                    amr.KGZ = intValue;
                                    if (DZ2 != null && !Util.isNullOrNil(DZ2.field_xml)) {
                                        amr.KHf = DZ2.field_xml;
                                    }
                                    arrayList3.add(amr);
                                }
                            } catch (Exception e2) {
                            }
                        }
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).checkFavItem(arrayList3);
                        Log.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                        break;
                    }
                }
                break;
            case 39:
                try {
                    Log.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", hbVar.dLm.dLv, hbVar.dLm.dLw);
                    int i4 = Util.getInt(hbVar.dLm.dLv, -1);
                    ArrayList<String> stringsToList = Util.stringsToList(hbVar.dLm.dLw.split(";"));
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(stringsToList);
                    g DZ3 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) i4);
                    if (DZ3 == null) {
                        Log.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", Integer.valueOf(i4));
                        h.HT(8);
                        break;
                    } else {
                        ane ane = new ane();
                        ane.KGZ = i4;
                        boolean z = false;
                        for (aml aml2 : DZ3.field_favProto.ppH) {
                            if (hashSet.remove(aml2.dLl + "#0")) {
                                if (Util.isNullOrNil(aml2.Lvp)) {
                                    com.tencent.mm.an.f.baR();
                                    aml2.bgk(a.baG());
                                    h.HT(2);
                                }
                                if (s.YS(b.d(aml2))) {
                                    aml2.ajg(1);
                                    b.a(aml2, DZ3, 0, false);
                                    h.HT(3);
                                    z = true;
                                } else {
                                    h.HT(5);
                                    aoc aoc = new aoc();
                                    aoc.LiU = aml2.dLl;
                                    aoc.Lja = 0;
                                    aoc.oTW = 4;
                                    ane.Lye.add(aoc);
                                }
                            }
                            if (hashSet.remove(aml2.dLl + "#1")) {
                                if (Util.isNullOrNil(aml2.Lvp)) {
                                    com.tencent.mm.an.f.baR();
                                    aml2.bgk(a.baG());
                                    h.HT(2);
                                }
                                if (s.YS(b.a(aml2))) {
                                    aml2.ajg(-1);
                                    b.a(aml2, DZ3, 0);
                                    h.HT(3);
                                    z = true;
                                } else {
                                    h.HT(5);
                                    aoc aoc2 = new aoc();
                                    aoc2.LiU = aml2.dLl;
                                    aoc2.Lja = 1;
                                    aoc2.oTW = 4;
                                    ane.Lye.add(aoc2);
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            Log.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", hashSet.toString());
                            h.HU(hashSet.size());
                            Iterator it2 = hashSet.iterator();
                            while (it2.hasNext()) {
                                try {
                                    String[] split2 = ((String) it2.next()).split("#");
                                    aoc aoc3 = new aoc();
                                    aoc3.LiU = split2[0];
                                    aoc3.Lja = Integer.valueOf(split2[1]).intValue();
                                    aoc3.oTW = 3;
                                    ane.Lye.add(aoc3);
                                } catch (Exception e3) {
                                }
                            }
                        }
                        if (ane.Lye.size() > 0) {
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).checkFavItem(ane);
                        }
                        if (z) {
                            if (DZ3.field_type == 18) {
                                DZ3.field_favProto.ajl(DZ3.field_favProto.version + 1);
                            }
                            DZ3.field_itemStatus = 15;
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ3, ch.COL_LOCALID);
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
                            h.HT(6);
                            break;
                        } else {
                            h.HT(7);
                            Log.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                            break;
                        }
                    }
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", e4, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                    break;
                }
            case 40:
                hbVar.dLn.dLF = b.b(hbVar.dLm.dGb);
                break;
        }
        AppMethodBeat.o(107062);
        return false;
    }

    private static String m(aml aml) {
        String z;
        AppMethodBeat.i(107063);
        o oVar = new o(b.a(aml));
        if (oVar.exists()) {
            z = aa.z(oVar.her());
        } else if (aml.dFN == null) {
            z = "";
        } else {
            o oVar2 = new o(b.cUf() + com.tencent.mm.b.g.getMessageDigest(aml.dFN.getBytes()));
            z = oVar2.exists() ? aa.z(oVar2.her()) : "";
        }
        AppMethodBeat.o(107063);
        return z;
    }
}
