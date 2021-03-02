package com.tencent.mm.plugin.editor.model;

import android.graphics.Bitmap;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.editor.b;
import com.tencent.mm.plugin.editor.model.a.c;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.f;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class a {
    public static String qPd = "";
    public static HashMap<String, JSONArray> qPe = new HashMap<>();
    public static String qPf = (ao.cVg() + "/fav_fileicon_recording.png");
    private static String qPg = (ao.cVg() + "/ofm_file_icon.png");
    private static String qPh = (ao.cVg() + "/app_attach_file_icon_pic.png");
    public static String qPi = (ao.cVg() + "/location_msg.png");
    public static String qPj = (ao.cVg() + "/note_fav_not_support.png");

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static anb a(String str, List<d> list, aml aml) {
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
            String b2 = b.b(aml2);
            if (!s.YS(b2)) {
                s.nw(cVj, b2);
            }
            aml2.bgt(b2);
        }
        for (d dVar : list) {
            if (dVar != null) {
                if (dVar.qPM == null) {
                    aml aml3 = new aml();
                    amm amm = new amm();
                    amn amn = new amn();
                    amn.ajh(6);
                    amm.c(amn);
                    aml3.a(amm);
                    switch (dVar.type) {
                        case 1:
                            aml3.ajd(1);
                            aml3.As(true);
                            aml3.At(true);
                            aml3.bgs(dVar.dLl);
                            aml3.bgg(b.alO(((j) dVar).content));
                            if (!Util.isNullOrNil(aml3.desc) && aml3.desc.length() > 1000) {
                                aml3.bgg(aml3.desc.substring(0, 1000));
                            }
                            aml3.bgC(dVar.qPN);
                            linkedList.add(aml3);
                            break;
                        case 2:
                            aml3.ajd(2);
                            c cVar = (c) dVar;
                            String str2 = cVar.qPL;
                            aml3.bgt(str2);
                            if (!Util.isNullOrNil(((c) dVar).dLl)) {
                                aml3.bgs(dVar.dLl);
                                aml3.bgu(cVar.dUs);
                            } else {
                                aml3.bgs(b.alR(cVar.toString()));
                                BitmapUtil.createThumbNail(str2, 150, 150, Bitmap.CompressFormat.JPEG, 90, b.a(aml3), true);
                                aml3.bgu(b.a(aml3));
                            }
                            aml3.ajd(2);
                            aml3.bgC(dVar.qPN);
                            linkedList.add(aml3);
                            break;
                        case 3:
                        case 5:
                        default:
                            aml3.bgC(dVar.qPN);
                            linkedList.add(aml3);
                            break;
                        case 4:
                            aml3.ajd(3);
                            f fVar = (f) dVar;
                            aml3.bgs(dVar.dLl);
                            String str3 = fVar.dUs;
                            if (!Util.isNullOrNil(str3) && str3.length() != 0) {
                                aml3.bgt(str3);
                                aml3.ajc(fVar.dLu);
                                aml3.At(true);
                                aml3.bgp(fVar.qPP);
                                aml3.bgC(dVar.qPN);
                                linkedList.add(aml3);
                                break;
                            }
                        case 6:
                            aml3.ajd(4);
                            l lVar = (l) dVar;
                            aml3.bgs(dVar.dLl);
                            aml3.bgt(lVar.dUs);
                            aml3.bgu(lVar.thumbPath);
                            com.tencent.mm.plugin.sight.base.a aNx = e.aNx(lVar.dUs);
                            if (aNx != null) {
                                aml3.ajc(aNx.getVideoDuration());
                            } else {
                                aml3.ajc(1);
                            }
                            aml3.bgp(lVar.qPP);
                            aml3.bgC(dVar.qPN);
                            linkedList.add(aml3);
                            break;
                    }
                } else {
                    linkedList.add(dVar.qPM);
                }
            }
        }
        a(linkedList, list);
        anb.bH(linkedList);
        return anb;
    }

    private static void a(LinkedList<aml> linkedList, List<d> list) {
        Log.i("MicroMsg.EditorBase", "do EditorBase.setExtraInfo");
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                aml aml = linkedList.get(i2);
                if (i2 > 0 && Util.isNullOrNil(aml.KuR)) {
                    aml.bgs(b.alR(aml.toString()));
                    d dVar = null;
                    if (i2 - 1 >= 0 && i2 - 1 < list.size() && list.size() > 0) {
                        dVar = list.get(i2 - 1);
                    }
                    if (!(dVar == null || dVar.qPN == null || !dVar.qPN.equals(aml.Lwp))) {
                        dVar.dLl = aml.dLl;
                    }
                }
                if (i2 <= 0 || Util.isNullOrNil(aml.KuR) || Util.isNullOrNil(aml.Lvp)) {
                    Log.i("MicroMsg.EditorBase", "datalist.get[%d].type = %d", Integer.valueOf(i2), Integer.valueOf(aml.dataType));
                    String str = aml.LvL;
                    if (s.YS(str)) {
                        Log.i("MicroMsg.EditorBase", "datapath exist,pathname:%s", str);
                        String bhK = s.bhK(str);
                        String messageDigest = g.getMessageDigest(s.aW(str, 0, 256));
                        aml.bgq(bhK);
                        aml.bgr(messageDigest);
                        aml.Mu(new o(str).length());
                        String b2 = b.b(aml);
                        boolean YS = s.YS(b2);
                        if (!str.equals(b2) && !YS && !"WeNoteHtmlFile".equals(aml.Lwp)) {
                            s.nw(str, b2);
                        }
                    } else {
                        Log.e("MicroMsg.EditorBase", "datapath not exist, %s not exist!", str);
                    }
                    String str2 = aml.LvN;
                    if (s.YS(str2)) {
                        Log.i("MicroMsg.EditorBase", "thumbPath exist,pathname:%s", str2);
                        String bhK2 = s.bhK(str2);
                        String fb = g.fb(str2);
                        aml.bgv(bhK2);
                        aml.bgw(fb);
                        aml.Mv(new o(str2).length());
                        String a2 = b.a(aml);
                        if (!str2.equals(a2) && !s.YS(a2)) {
                            s.nw(str2, a2);
                        }
                    } else {
                        Log.e("MicroMsg.EditorBase", "thumbPath not exist, pathname:%s", str2);
                    }
                } else {
                    aml.As(true);
                    aml.At(true);
                }
            }
        }
    }
}
