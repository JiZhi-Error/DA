package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.wenote.c.b;
import com.tencent.mm.plugin.wenote.c.c;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class d {
    public static boolean JGX = false;
    public static String qPd = "";
    public static HashMap<String, JSONArray> qPe = new HashMap<>();
    public static String qPf = (ao.cVg() + "/fav_fileicon_recording.png");
    private static String qPg = (ao.cVg() + "/ofm_file_icon.png");
    private static String qPh = (ao.cVg() + "/app_attach_file_icon_pic.png");
    public static String qPi = (ao.cVg() + "/location_msg.png");
    public static String qPj = (ao.cVg() + "/note_fav_not_support.png");
    public m JGO = null;
    public g JGP;
    public HashMap<String, w> JGQ = new HashMap<>();
    public HashMap<String, String> JGR = new HashMap<>();
    public HashMap<String, o> JGS = new HashMap<>();
    public String JGT = "WeNote_0";
    public String JGU = "";
    public boolean JGV = false;
    public anb JGW = new anb();
    public String JGY = "";
    public int JGZ = 0;

    public abstract String a(aml aml);

    public abstract void a(aml aml, String str);

    public abstract void bX(Context context, String str);

    public abstract void bY(Context context, String str);

    public abstract void bZ(Context context, String str);

    public abstract String d(aml aml);

    public abstract void p(aml aml);

    public final void iq(List<aml> list) {
        v lVar;
        String valueOf;
        ArrayList<String> arrayList;
        w wVar = new w();
        ArrayList<String> arrayList2 = null;
        for (aml aml : list) {
            o oVar = new o();
            oVar.qPN = aml.Lwp;
            if (aml.dataType == 1) {
                oVar.qPN = "-1";
            }
            if (Util.isNullOrNil(oVar.qPN)) {
                Log.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
                String d2 = d(aml);
                if (Util.isNullOrNil(d2) || !s.YS(d2)) {
                    p(aml);
                    return;
                } else {
                    f.O(this.JGO.dUt, d2);
                    return;
                }
            } else if (oVar.qPN.equals("WeNoteHtmlFile")) {
                String d3 = d(aml);
                if (Util.isNullOrNil(d3) || !s.YS(d3)) {
                    p(aml);
                    wVar.qPV = true;
                    Log.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", aml.dLl);
                    this.JGR.put(aml.dLl, oVar.qPN);
                    arrayList = arrayList2;
                } else {
                    try {
                        wVar.qPT = s.boY(d3);
                        arrayList = b.alN(wVar.qPT);
                        try {
                            Log.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", aml.dLl);
                            qPe.containsKey(wVar.qPT);
                        } catch (Exception e2) {
                            e = e2;
                            Log.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                            Log.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(Util.isNullOrNil(aml.KuR)), Boolean.valueOf(Util.isNullOrNil(aml.Lvp)));
                            arrayList2 = arrayList;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        arrayList = arrayList2;
                        Log.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                        Log.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(Util.isNullOrNil(aml.KuR)), Boolean.valueOf(Util.isNullOrNil(aml.Lvp)));
                        arrayList2 = arrayList;
                    }
                }
                Log.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(Util.isNullOrNil(aml.KuR)), Boolean.valueOf(Util.isNullOrNil(aml.Lvp)));
                arrayList2 = arrayList;
            } else {
                if (!oVar.qPN.equals("-1")) {
                    int i2 = Util.getInt(oVar.qPN.substring(7), 0);
                    int i3 = Util.getInt(this.JGT.substring(7), 0);
                    StringBuilder sb = new StringBuilder("WeNote_");
                    if (i3 > i2) {
                        valueOf = String.valueOf(i3);
                    } else {
                        valueOf = String.valueOf(i2);
                    }
                    this.JGT = sb.append(valueOf).toString();
                }
                oVar.dLl = aml.dLl;
                switch (aml.dataType) {
                    case 1:
                        if (!Util.isNullOrNil(aml.desc)) {
                            if (wVar.qPU.size() <= 0 || wVar.qPU.get(wVar.qPU.size() - 1) == null || !wVar.qPU.get(wVar.qPU.size() - 1).qPN.equals("-1")) {
                                i iVar = new i();
                                ((t) iVar).qPN = oVar.qPN;
                                iVar.content = aml.desc;
                                wVar.qPU.add(iVar);
                                break;
                            } else {
                                t tVar = (t) wVar.qPU.get(wVar.qPU.size() - 1);
                                tVar.content += aml.desc;
                                break;
                            }
                        } else {
                            continue;
                        }
                        break;
                    case 2:
                        f fVar = new f();
                        ((p) fVar).qPN = oVar.qPN;
                        ((p) fVar).type = 2;
                        ((p) fVar).dLl = oVar.dLl;
                        ((p) fVar).qPM = aml;
                        String d4 = d(aml);
                        if (!Util.isNullOrNil(d4)) {
                            String str = d4 + "_bigthumb";
                            String a2 = a(aml);
                            if (!s.YS(a2)) {
                                a(aml, a2);
                            }
                            if (s.YS(d4)) {
                                ((p) fVar).qPO = true;
                                c.fK(d4, str);
                            } else {
                                p(aml);
                                ((p) fVar).qPO = false;
                                this.JGR.put(aml.dLl, oVar.qPN);
                            }
                            ((p) fVar).dUs = str;
                            fVar.qPL = d4;
                            wVar.qPU.add(fVar);
                            this.JGS.put(oVar.qPN, fVar);
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                    case 20:
                        if (aml.dataType == 20) {
                            lVar = new com.tencent.mm.plugin.wenote.model.a.b();
                            if (!Util.isNullOrNil(aml.KuR)) {
                                ((com.tencent.mm.plugin.wenote.model.a.b) lVar).DmM = true;
                            }
                        } else {
                            lVar = new l();
                        }
                        lVar.qPN = oVar.qPN;
                        lVar.type = 4;
                        lVar.dLl = oVar.dLl;
                        lVar.qPM = aml;
                        String d5 = d(aml);
                        if (Util.isNullOrNil(d5) || !s.YS(d5)) {
                            p(aml);
                            lVar.qPO = false;
                            lVar.qPS = MMApplicationContext.getContext().getString(R.string.cd9);
                            this.JGR.put(aml.dLl, oVar.qPN);
                        } else {
                            lVar.qPO = true;
                            lVar.mav = qPf;
                            lVar.length = (int) f.AO((long) aml.duration);
                        }
                        lVar.dUs = d5;
                        lVar.qPR = f.W(MMApplicationContext.getContext(), (int) f.AO((long) aml.duration));
                        lVar.dLu = aml.duration;
                        hb hbVar = new hb();
                        hbVar.dLm.type = 17;
                        hbVar.dLm.dLo = aml;
                        EventCenter.instance.publish(hbVar);
                        lVar.dLt = hbVar.dLn.ret;
                        lVar.qPP = aml.LvC;
                        wVar.qPU.add(lVar);
                        this.JGS.put(oVar.qPN, lVar);
                        continue;
                    case 4:
                        k kVar = new k();
                        kVar.qPN = oVar.qPN;
                        kVar.type = 6;
                        kVar.dLl = oVar.dLl;
                        kVar.qPM = aml;
                        if (aml != null) {
                            kVar.duration = aml.duration;
                        }
                        kVar.thumbPath = a(aml);
                        String d6 = d(aml);
                        kVar.dUs = d6;
                        if (!Util.isNullOrNil(kVar.thumbPath) && !s.YS(kVar.thumbPath)) {
                            if (s.YS(d6)) {
                                Bitmap asm = e.asm(d6);
                                if (asm != null) {
                                    try {
                                        Log.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                        com.tencent.mm.pluginsdk.l.f.a(asm, Bitmap.CompressFormat.JPEG, kVar.thumbPath, true);
                                    } catch (Exception e4) {
                                        Log.printErrStackTrace("MicroMsg.WNNoteBase", e4, "", new Object[0]);
                                    }
                                }
                            } else {
                                a(aml, kVar.thumbPath);
                                this.JGR.put(aml.dLl + "_t", oVar.qPN);
                            }
                        }
                        if (Util.isNullOrNil(d6) || !s.YS(d6)) {
                            kVar.qPO = false;
                            this.JGR.put(aml.dLl, oVar.qPN);
                        } else {
                            kVar.qPO = true;
                        }
                        wVar.qPU.add(kVar);
                        this.JGS.put(oVar.qPN, kVar);
                        continue;
                    case 6:
                        r rVar = new r();
                        ams ams = aml.Lwh.LwQ;
                        if (ams == null) {
                            ams = new ams();
                            ams.bgW("");
                            ams.bgX("");
                            Log.e("MicroMsg.WNNoteBase", "locItem is null, dataItemId:" + aml.dLl);
                        }
                        rVar.latitude = (float) ams.lat;
                        rVar.longtitude = (float) ams.lng;
                        rVar.dRt = ams.dRt;
                        rVar.JHY = ams.label;
                        rVar.JHZ = ams.dWi;
                        rVar.JIa = aml.Lwp;
                        com.tencent.mm.plugin.wenote.model.a.g gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                        ((com.tencent.mm.plugin.wenote.model.a.s) gVar).qPN = oVar.qPN;
                        ((com.tencent.mm.plugin.wenote.model.a.s) gVar).type = 3;
                        ((com.tencent.mm.plugin.wenote.model.a.s) gVar).dLl = oVar.dLl;
                        ((com.tencent.mm.plugin.wenote.model.a.s) gVar).qPM = aml;
                        ((com.tencent.mm.plugin.wenote.model.a.s) gVar).qPO = true;
                        gVar.kHV = rVar.JHZ;
                        gVar.iUO = rVar.JHY;
                        gVar.lat = (double) rVar.latitude;
                        gVar.lng = (double) rVar.longtitude;
                        gVar.JIb = (double) rVar.dRt;
                        ((com.tencent.mm.plugin.wenote.model.a.s) gVar).dUs = "";
                        wVar.qPU.add(gVar);
                        this.JGS.put(oVar.qPN, gVar);
                        continue;
                    case 8:
                        com.tencent.mm.plugin.wenote.model.a.d dVar = new com.tencent.mm.plugin.wenote.model.a.d();
                        ((u) dVar).qPN = oVar.qPN;
                        ((u) dVar).type = 5;
                        ((u) dVar).dLl = oVar.dLl;
                        ((u) dVar).qPM = aml;
                        String d7 = d(aml);
                        if (Util.isNullOrNil(d7) || !s.YS(d7)) {
                            ((u) dVar).qPO = false;
                            this.JGR.put(aml.dLl, oVar.qPN);
                        } else {
                            ((u) dVar).qPO = true;
                            ((u) dVar).dUs = d7;
                        }
                        dVar.mav = h.bbT(aml.LvC);
                        dVar.title = aml.title;
                        dVar.content = aml.desc;
                        dVar.qPP = aml.LvC;
                        if (Util.isNullOrNil(dVar.content)) {
                            dVar.content = f.getLengthStr((float) aml.LvI);
                        }
                        wVar.qPU.add(dVar);
                        this.JGS.put(oVar.qPN, dVar);
                        continue;
                    default:
                        if (aml.dataType > 0) {
                            j jVar = new j();
                            ((n) jVar).qPN = oVar.qPN;
                            ((n) jVar).type = 0;
                            ((n) jVar).dLl = oVar.dLl;
                            ((n) jVar).qPM = aml;
                            String d8 = d(aml);
                            ((n) jVar).qPO = true;
                            ((n) jVar).dUs = d8;
                            jVar.mav = qPj;
                            jVar.title = MMApplicationContext.getContext().getResources().getString(R.string.cbe);
                            jVar.content = MMApplicationContext.getContext().getResources().getString(R.string.cag);
                            wVar.qPU.add(jVar);
                            this.JGS.put(oVar.qPN, jVar);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            h.a((Object) wVar.qPU, (List<String>) arrayList2, true);
        }
        if (this.JGO.msgId == -1) {
            this.JGQ.put(Long.toString(this.JGO.dUt), wVar);
        } else {
            this.JGQ.put(Long.toString(this.JGO.msgId), wVar);
        }
    }

    public final void b(oc ocVar) {
        if (ocVar.dUe == null) {
            Log.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
            return;
        }
        String str = ocVar.dUe.dUg;
        o oVar = this.JGS.get(str);
        if (oVar == null) {
            Log.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
            return;
        }
        Log.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", Integer.valueOf(oVar.type));
        switch (oVar.type) {
            case 2:
                bZ(ocVar.dUe.context, str);
                return;
            case 3:
                bY(ocVar.dUe.context, str);
                return;
            case 4:
            default:
                return;
            case 5:
                bX(ocVar.dUe.context, str);
                return;
            case 6:
                ca(ocVar.dUe.context, str);
                return;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static anb a(String str, List<o> list, aml aml) {
        LinkedList<aml> linkedList = new LinkedList<>();
        anb anb = new anb();
        if (aml != null) {
            linkedList.add(aml);
        } else if (!Util.isNullOrNil(str) && str.length() > 0) {
            String cVj = ao.cVj();
            aml aml2 = new aml();
            aml2.ajd(8);
            aml2.bgC("WeNoteHtmlFile");
            aml2.At(true);
            aml2.Mu(s.boW(cVj));
            aml2.bgp(".htm");
            linkedList.add(aml2);
            String b2 = f.b(aml2);
            if (!s.YS(b2)) {
                s.nw(cVj, b2);
            }
            aml2.bgt(b2);
        }
        for (o oVar : list) {
            if (oVar != null) {
                if (oVar.qPM == null) {
                    aml aml3 = new aml();
                    amm amm = new amm();
                    amn amn = new amn();
                    amn.ajh(6);
                    amm.c(amn);
                    aml3.a(amm);
                    switch (oVar.type) {
                        case 1:
                            if (!JGX) {
                                h.INSTANCE.a(14547, 6);
                                JGX = true;
                            }
                            aml3.ajd(1);
                            aml3.As(true);
                            aml3.At(true);
                            aml3.bgs(oVar.dLl);
                            aml3.bgg(b.alO(((i) oVar).content));
                            if (!Util.isNullOrNil(aml3.desc) && aml3.desc.length() > 1000) {
                                aml3.bgg(aml3.desc.substring(0, 1000));
                            }
                            aml3.bgC(oVar.qPN);
                            linkedList.add(aml3);
                            break;
                        case 2:
                            aml3.ajd(2);
                            p pVar = (p) oVar;
                            String str2 = pVar.qPL;
                            aml3.bgt(str2);
                            if (!Util.isNullOrNil(((p) oVar).dLl)) {
                                aml3.bgs(oVar.dLl);
                                aml3.bgu(pVar.dUs);
                            } else {
                                aml3.bgs(f.alR(pVar.toString()));
                                BitmapUtil.createThumbNail(str2, 150, 150, Bitmap.CompressFormat.JPEG, 90, f.a(aml3), true);
                                aml3.bgu(f.a(aml3));
                            }
                            aml3.ajd(2);
                            aml3.bgC(oVar.qPN);
                            linkedList.add(aml3);
                            break;
                        case 3:
                            aml3.ajd(6);
                            com.tencent.mm.plugin.wenote.model.a.s sVar = (com.tencent.mm.plugin.wenote.model.a.s) oVar;
                            aml3.bgs(oVar.dLl);
                            ams ams = new ams();
                            ams.bgW(sVar.iUO);
                            ams.C(sVar.lat);
                            ams.B(sVar.lng);
                            ams.aji((int) sVar.JIb);
                            ams.bgX(sVar.kHV);
                            aml3.As(true);
                            aml3.At(true);
                            aml3.Lwh.c(ams);
                            aml3.bgC(oVar.qPN);
                            linkedList.add(aml3);
                            break;
                        case 4:
                            aml3.ajd(3);
                            v vVar = (v) oVar;
                            aml3.bgs(oVar.dLl);
                            String str3 = vVar.dUs;
                            if (!Util.isNullOrNil(str3) && str3.length() != 0) {
                                aml3.bgt(str3);
                                aml3.ajc(vVar.dLu);
                                aml3.At(true);
                                aml3.bgp(vVar.qPP);
                                aml3.bgC(oVar.qPN);
                                linkedList.add(aml3);
                                break;
                            }
                        case 5:
                            aml3.ajd(8);
                            u uVar = (u) oVar;
                            aml3.bgs(oVar.dLl);
                            aml3.bgt(uVar.dUs);
                            aml3.At(true);
                            aml3.bgf(uVar.title);
                            aml3.bgg(uVar.content);
                            aml3.bgp(uVar.qPP);
                            aml3.bgC(oVar.qPN);
                            linkedList.add(aml3);
                            break;
                        case 6:
                            aml3.ajd(4);
                            k kVar = (k) oVar;
                            aml3.bgs(oVar.dLl);
                            aml3.bgt(kVar.dUs);
                            aml3.bgu(kVar.thumbPath);
                            a aNx = com.tencent.mm.plugin.sight.base.e.aNx(kVar.dUs);
                            if (aNx != null) {
                                aml3.ajc(aNx.getVideoDuration());
                            } else {
                                aml3.ajc(1);
                            }
                            aml3.bgp(kVar.qPP);
                            aml3.bgC(oVar.qPN);
                            linkedList.add(aml3);
                            break;
                        default:
                            aml3.bgC(oVar.qPN);
                            linkedList.add(aml3);
                            break;
                    }
                } else {
                    if (oVar.qPM.dataType == 20) {
                        oVar.qPM.ajd(3);
                    }
                    linkedList.add(oVar.qPM);
                }
            }
        }
        a(linkedList, list);
        anb.bH(linkedList);
        return anb;
    }

    private static void a(LinkedList<aml> linkedList, List<o> list) {
        Log.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                aml aml = linkedList.get(i2);
                if (i2 > 0 && Util.isNullOrNil(aml.KuR)) {
                    aml.bgs(f.alR(aml.toString()));
                    o oVar = null;
                    if (i2 - 1 >= 0 && i2 - 1 < list.size() && list.size() > 0) {
                        oVar = list.get(i2 - 1);
                    }
                    if (!(oVar == null || oVar.qPN == null || !oVar.qPN.equals(aml.Lwp))) {
                        oVar.dLl = aml.dLl;
                    }
                }
                if (i2 <= 0 || Util.isNullOrNil(aml.KuR) || Util.isNullOrNil(aml.Lvp)) {
                    Log.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", Integer.valueOf(i2), Integer.valueOf(aml.dataType));
                    String str = aml.LvL;
                    if (s.YS(str)) {
                        Log.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", str);
                        String bhK = s.bhK(str);
                        String messageDigest = com.tencent.mm.b.g.getMessageDigest(s.aW(str, 0, 256));
                        aml.bgq(bhK);
                        aml.bgr(messageDigest);
                        aml.Mu(new com.tencent.mm.vfs.o(str).length());
                        String b2 = f.b(aml);
                        boolean YS = s.YS(b2);
                        if (!str.equals(b2) && !YS && !"WeNoteHtmlFile".equals(aml.Lwp)) {
                            s.nw(str, b2);
                        }
                    } else {
                        Log.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", str);
                    }
                    String str2 = aml.LvN;
                    if (s.YS(str2)) {
                        Log.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", str2);
                        String bhK2 = s.bhK(str2);
                        String fb = com.tencent.mm.b.g.fb(str2);
                        aml.bgv(bhK2);
                        aml.bgw(fb);
                        aml.Mv(new com.tencent.mm.vfs.o(str2).length());
                        String a2 = f.a(aml);
                        if (!str2.equals(a2) && !s.YS(a2)) {
                            s.nw(str2, a2);
                        }
                    } else {
                        Log.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", str2);
                    }
                } else {
                    aml.As(true);
                    aml.At(true);
                }
            }
        }
    }

    public void bbO(String str) {
    }

    private void ca(Context context, String str) {
        k kVar = (k) this.JGS.get(str);
        if (!Util.isNullOrNil(kVar.dUs)) {
            if (!s.YS(kVar.dUs)) {
                aml bbP = bbP(kVar.dLl);
                if (bbP == null) {
                    Log.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
                    return;
                }
                p(bbP);
            }
            Intent intent = new Intent();
            if (this.JGP == null) {
                intent.putExtra("key_detail_info_id", 0);
            } else {
                intent.putExtra("key_detail_info_id", this.JGP.field_localId);
            }
            intent.putExtra("key_detail_fav_path", kVar.dUs);
            intent.putExtra("key_detail_fav_thumb_path", kVar.thumbPath);
            intent.putExtra("key_detail_fav_video_duration", kVar.duration);
            intent.putExtra("key_detail_data_id", kVar.dLl);
            intent.putExtra("key_detail_statExtStr", "");
            intent.putExtra("key_detail_fav_video_show_download_status", true);
            if (kVar.qPM != null) {
                intent.putExtra("key_detail_msg_uuid", kVar.qPM.jsz);
            }
            com.tencent.mm.plugin.fav.a.b.a(context, ".ui.detail.FavoriteVideoPlayUI", intent, 1);
        }
    }

    public final aml bbP(String str) {
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
            return null;
        }
        String str2 = this.JGR.get(str);
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", str);
            return null;
        }
        o oVar = this.JGS.get(str2);
        if (oVar != null) {
            return oVar.qPM;
        }
        Log.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", str2);
        return null;
    }

    public String gjA() {
        return "";
    }
}
