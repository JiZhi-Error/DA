package com.tencent.mm.plugin.fav.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.am;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.a.a.a;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.log.RecoveryFileLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b {
    private static HashMap<Long, ArrayList<String>> sZQ = new HashMap<>();
    private static long sZR = 0;

    static /* synthetic */ void s(g gVar) {
        AppMethodBeat.i(103359);
        i(gVar);
        AppMethodBeat.o(103359);
    }

    private static String gE(String str, String str2) {
        AppMethodBeat.i(103259);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103259);
            return str2;
        } else if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(103259);
            return str;
        } else {
            String str3 = str + RecoveryFileLog.SPLITTER + str2;
            AppMethodBeat.o(103259);
            return str3;
        }
    }

    public static String ds(String str, int i2) {
        AppMethodBeat.i(103260);
        String messageDigest = g.getMessageDigest((str + i2 + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(103260);
        return messageDigest;
    }

    public static long a(g gVar) {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(103261);
        for (int i2 : a.sZO) {
            if (i2 == gVar.field_type) {
                if (gVar.field_favProto != null) {
                    Iterator<aml> it = gVar.field_favProto.ppH.iterator();
                    while (true) {
                        j2 = j3;
                        if (!it.hasNext()) {
                            break;
                        }
                        j3 = it.next().LvI + j2;
                    }
                } else {
                    j2 = 0;
                }
                gVar.field_datatotalsize = j2;
                Log.d("MicroMsg.Fav.FavApiLogic", "calFavItemInfoTotalLength id:%d,length:%d", Integer.valueOf(gVar.field_id), Long.valueOf(j2));
                AppMethodBeat.o(103261);
                return j2;
            }
        }
        AppMethodBeat.o(103261);
        return 0;
    }

    public static amq a(int i2, anb anb, ano ano) {
        AppMethodBeat.i(103262);
        if (anb == null) {
            Log.w("MicroMsg.Fav.FavApiLogic", "proto item is null");
            AppMethodBeat.o(103262);
            return null;
        }
        amq amq = new amq();
        anh anh = anb.Lya;
        if (anh != null) {
            amq.dRL = anh.dRL;
            amq.LxL = anh.LxA;
            amq.appId = anh.appId;
            amq.dCl = anh.dCl;
        }
        if (ano != null) {
            if (ano.Lyn != null) {
                amq.LxM.addAll(ano.Lyn);
            }
            if (ano.Lyo != null) {
                amq.LxM.addAll(ano.Lyo);
            }
        }
        amq.dXI = anb;
        amq.type = i2;
        switch (i2) {
            case 1:
                amq.title = "";
                amq.desc = anb.desc;
                AppMethodBeat.o(103262);
                return amq;
            case 2:
                if (anb.ppH != null && anb.ppH.size() > 0) {
                    amq.title = anb.ppH.get(0).title;
                }
                AppMethodBeat.o(103262);
                return amq;
            case 3:
            case 9:
            case 13:
            case 16:
            case 17:
            case 19:
            case 20:
            default:
                Log.w("MicroMsg.Fav.FavApiLogic", "unknown type %d", Integer.valueOf(i2));
                AppMethodBeat.o(103262);
                return amq;
            case 4:
                if (anb.ppH != null && !anb.ppH.isEmpty()) {
                    amq.title = anb.ppH.get(0).title;
                }
                AppMethodBeat.o(103262);
                return amq;
            case 5:
                if (anb.LwS != null) {
                    amq.title = anb.LwS.title;
                    amq.desc = anb.LwS.LyC;
                }
                if (Util.isNullOrNil(amq.title) && anb.ppH != null && !anb.ppH.isEmpty()) {
                    amq.title = anb.ppH.get(0).title;
                }
                if (Util.isNullOrNil(amq.desc) && anh != null) {
                    amq.desc = anh.link;
                }
                AppMethodBeat.o(103262);
                return amq;
            case 6:
                amq.title = anb.remark;
                if (Util.isNullOrNil(amq.title)) {
                    if (anb.LwQ != null) {
                        amq.title = anb.LwQ.dWi;
                        amq.desc = anb.LwQ.label;
                    }
                } else if (anb.LwQ != null) {
                    amq.desc = anb.LwQ.dWi;
                }
                AppMethodBeat.o(103262);
                return amq;
            case 7:
            case 21:
                if (anb.ppH != null && !anb.ppH.isEmpty()) {
                    amq.title = anb.ppH.get(0).title;
                    amq.desc = anb.ppH.get(0).desc;
                }
                AppMethodBeat.o(103262);
                return amq;
            case 8:
                amq.title = anb.title;
                if (Util.isNullOrNil(amq.title) && anb.ppH != null && !anb.ppH.isEmpty()) {
                    amq.title = anb.ppH.get(0).title;
                }
                AppMethodBeat.o(103262);
                return amq;
            case 10:
            case 11:
                if (anb.LwU != null) {
                    amq.title = anb.LwU.title;
                    amq.desc = anb.LwU.desc;
                }
                AppMethodBeat.o(103262);
                return amq;
            case 12:
            case 15:
                if (anb.LwW != null) {
                    amq.title = anb.LwW.title;
                    amq.desc = anb.LwW.desc;
                }
                AppMethodBeat.o(103262);
                return amq;
            case 14:
            case 18:
                LinkedList<aml> linkedList = anb.ppH;
                if (linkedList == null) {
                    AppMethodBeat.o(103262);
                    return null;
                }
                Iterator<aml> it = linkedList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        aml next = it.next();
                        if (1 == next.dataType) {
                            amq.title = next.desc;
                        }
                    }
                }
                AppMethodBeat.o(103262);
                return amq;
        }
    }

    public static long b(g gVar) {
        AppMethodBeat.i(103263);
        if (gVar == null) {
            AppMethodBeat.o(103263);
            return 0;
        }
        int i2 = 0;
        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
        while (it.hasNext()) {
            i2 = (int) (it.next().LvI + ((long) i2));
        }
        long j2 = (long) i2;
        AppMethodBeat.o(103263);
        return j2;
    }

    public static aml c(g gVar) {
        AppMethodBeat.i(103264);
        if (gVar == null) {
            aml aml = new aml();
            AppMethodBeat.o(103264);
            return aml;
        } else if (gVar.field_favProto.ppH.size() == 0) {
            aml aml2 = new aml();
            AppMethodBeat.o(103264);
            return aml2;
        } else {
            aml aml3 = gVar.field_favProto.ppH.get(0);
            AppMethodBeat.o(103264);
            return aml3;
        }
    }

    public static void DH(long j2) {
        AppMethodBeat.i(103265);
        Log.i("MicroMsg.Fav.FavApiLogic", "setUsedCapacity:%d", Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERFINO_FAV_USED_CAPACITY_LONG, Long.valueOf(j2));
        AppMethodBeat.o(103265);
    }

    public static void DI(long j2) {
        AppMethodBeat.i(103266);
        Log.i("MicroMsg.Fav.FavApiLogic", "setTotalCapacity:%d", Long.valueOf(j2));
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERFINO_FAV_TOTAL_CAPACITY_LONG, Long.valueOf(j2));
        AppMethodBeat.o(103266);
    }

    private static String DJ(long j2) {
        AppMethodBeat.i(103267);
        StringBuilder sb = new StringBuilder();
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        if (DY == null || DY.field_favProto == null || DY.field_favProto.ppH.size() <= 1) {
            AppMethodBeat.o(103267);
            return "";
        }
        amv amv = DY.field_favProto.KBr;
        String str = "";
        String str2 = "";
        if (amv != null) {
            str = amv.LxU;
            str2 = amv.LxT;
        }
        sb.append("<noteinfo>");
        sb.append("<noteauthor>").append(str2).append("</noteauthor>");
        sb.append("<noteeditor>").append(str).append("</noteeditor>");
        sb.append("<edittime>").append(DY.field_favProto.rnM).append("</edittime>");
        sb.append("<editusr>").append(str2).append("</editusr>");
        sb.append("<favlocalid>").append(DY.field_localId).append("</favlocalid>");
        sb.append(a.dE(DY.field_favProto.ppH).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
        sb.append("</noteinfo>");
        String sb2 = sb.toString();
        AppMethodBeat.o(103267);
        return sb2;
    }

    static {
        AppMethodBeat.i(103360);
        AppMethodBeat.o(103360);
    }

    private static void a(hb hbVar) {
        AppMethodBeat.i(103268);
        if (Util.isNullOrNil(hbVar.dLm.desc)) {
            hbVar.dLn.ret = -1;
            AppMethodBeat.o(103268);
            return;
        }
        g arP = arP(hbVar.dLm.desc);
        if (arP == null || arP.field_localId <= 0) {
            hbVar.dLn.ret = -1;
            AppMethodBeat.o(103268);
            return;
        }
        boolean e2 = e(arP);
        String str = hbVar.dLm.dLs;
        if (e2) {
            hbVar.dLn.ret = 1;
            ArrayList<String> arrayList = sZQ.get(Long.valueOf(arP.field_localId));
            if (arrayList != null) {
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
                if (arrayList.size() == 0) {
                    sZQ.remove(Long.valueOf(arP.field_localId));
                }
            }
            AppMethodBeat.o(103268);
        } else if (Util.isNullOrNil(str)) {
            hbVar.dLn.ret = -1;
            AppMethodBeat.o(103268);
        } else {
            long j2 = arP.field_localId;
            ArrayList<String> arrayList2 = sZQ.get(Long.valueOf(j2));
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
            }
            arrayList2.add(str);
            sZQ.put(Long.valueOf(j2), arrayList2);
            final g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
            if (DY == null || DY.field_localId <= 0) {
                hbVar.dLn.ret = -1;
                AppMethodBeat.o(103268);
            } else if (e(DY) || DY.field_itemStatus == 10) {
                hbVar.dLn.ret = -1;
                com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.a.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(103255);
                        b.d(DY);
                        AppMethodBeat.o(103255);
                    }
                }, 500);
                AppMethodBeat.o(103268);
            } else {
                hbVar.dLn.ret = -1;
                AppMethodBeat.o(103268);
            }
        }
    }

    public static synchronized void d(g gVar) {
        synchronized (b.class) {
            AppMethodBeat.i(103269);
            if (gVar == null || gVar.field_type != 18) {
                AppMethodBeat.o(103269);
            } else if (!sZQ.containsKey(Long.valueOf(gVar.field_localId))) {
                AppMethodBeat.o(103269);
            } else if (sZQ.get(Long.valueOf(gVar.field_localId)) == null || sZQ.get(Long.valueOf(gVar.field_localId)).size() == 0) {
                AppMethodBeat.o(103269);
            } else {
                String DJ = DJ(gVar.field_localId);
                Log.i("MicroMsg.Fav.FavApiLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", Long.valueOf(gVar.field_localId), DJ);
                sm smVar = new sm();
                smVar.dZa.dZb = sZQ.get(Long.valueOf(gVar.field_localId));
                smVar.dZa.dZc = DJ;
                EventCenter.instance.publish(smVar);
                sZQ.remove(Long.valueOf(gVar.field_localId));
                AppMethodBeat.o(103269);
            }
        }
    }

    private static boolean e(g gVar) {
        boolean z;
        AppMethodBeat.i(103270);
        if (gVar == null) {
            AppMethodBeat.o(103270);
            return false;
        }
        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            aml next = it.next();
            if ((next.dataType == 8 || next.dataType == 4 || next.dataType == 2 || next.dataType == 3) && (Util.isNullOrNil(next.KuR) || Util.isNullOrNil(next.Lvp))) {
                z = false;
            }
        }
        z = false;
        AppMethodBeat.o(103270);
        return z;
    }

    public static void dC(List<Integer> list) {
        AppMethodBeat.i(103271);
        if (list.size() == 0) {
            Log.e("MicroMsg.Fav.FavApiLogic", "setDeleted list null");
            AppMethodBeat.o(103271);
            return;
        }
        Set<String> cUe = cUe();
        Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted before del:%s", cUe.toString());
        for (Integer num : list) {
            Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted id:%d, ret:%b", num, Boolean.valueOf(cUe.remove(num.toString())));
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "setDeleted after del:%s", cUe.toString());
        i(cUe);
        AppMethodBeat.o(103271);
    }

    private static void i(Set<String> set) {
        AppMethodBeat.i(103272);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : set) {
            stringBuffer.append(str).append(",");
        }
        String str2 = "";
        if (stringBuffer.length() > 0) {
            str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "set need del IDs: %s", str2);
        com.tencent.mm.kernel.g.aAh().azQ().set(225282, str2);
        AppMethodBeat.o(103272);
    }

    private static Set<String> cUe() {
        AppMethodBeat.i(103273);
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(225282, "");
        Log.i("MicroMsg.Fav.FavApiLogic", "get need del IDs: %s", str);
        HashSet hashSet = new HashSet();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103273);
            return hashSet;
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(103273);
            return hashSet;
        }
        for (String str2 : split) {
            hashSet.add(str2);
        }
        AppMethodBeat.o(103273);
        return hashSet;
    }

    public static void DK(long j2) {
        AppMethodBeat.i(103274);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_auto_download_size", j2).commit();
        AppMethodBeat.o(103274);
    }

    public static void DL(long j2) {
        AppMethodBeat.i(103275);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_auto_upload_size", j2).commit();
        AppMethodBeat.o(103275);
    }

    public static void DM(long j2) {
        AppMethodBeat.i(103276);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putLong("fav_mx_file_size", j2).commit();
        AppMethodBeat.o(103276);
    }

    public static String cUf() {
        AppMethodBeat.i(103277);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.g.aAi();
        String sb2 = sb.append(com.tencent.mm.kernel.g.aAh().hqG).append("favorite/web/").toString();
        AppMethodBeat.o(103277);
        return sb2;
    }

    public static String d(aml aml) {
        AppMethodBeat.i(103278);
        if (aml == null) {
            AppMethodBeat.o(103278);
            return "";
        }
        String str = aml.dLl;
        if (Util.isNullOrNil(str) || !com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(103278);
            return "";
        }
        o arH = arH(str);
        boolean z = false;
        if (aml.dataType == 8 && !Util.isNullOrNil(aml.title)) {
            str = aml.title;
            arH = arH(aml.dLl);
            z = true;
        }
        if (aml.LvC != null && aml.LvC.trim().length() > 0 && !z) {
            str = str + "." + aml.LvC;
        }
        o oVar = new o(arH, str);
        if (oVar.exists() || Util.isNullOrNil(aml.LvE)) {
            String z2 = aa.z(oVar.her());
            AppMethodBeat.o(103278);
            return z2;
        }
        String messageDigest = g.getMessageDigest((aml.LvE + aml.dLl).getBytes());
        if (Util.isNullOrNil(messageDigest)) {
            String z3 = aa.z(oVar.her());
            AppMethodBeat.o(103278);
            return z3;
        }
        if (aml.LvC != null && aml.LvC.trim().length() > 0) {
            messageDigest = messageDigest + "." + aml.LvC;
        }
        o oVar2 = new o(arH, messageDigest);
        if (oVar2.exists()) {
            String z4 = aa.z(oVar2.her());
            AppMethodBeat.o(103278);
            return z4;
        }
        String str2 = aml.dLl;
        if (aml.LvC != null && aml.LvC.trim().length() > 0) {
            str2 = str2 + "." + aml.LvC;
        }
        Log.d("MicroMsg.Fav.FavApiLogic", "use dataId.fmt, ".concat(String.valueOf(str2)));
        String z5 = aa.z(new o(arH, str2).her());
        AppMethodBeat.o(103278);
        return z5;
    }

    private static o arH(String str) {
        AppMethodBeat.i(103279);
        o oVar = new o(String.format("%s%s/%d/", com.tencent.mm.kernel.g.aAh().hqG, "favorite", Integer.valueOf(str.hashCode() & 255)));
        if (!oVar.exists() || !oVar.isDirectory()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(103279);
        return oVar;
    }

    public static boolean f(g gVar) {
        AppMethodBeat.i(103280);
        if (gVar.field_favProto == null) {
            AppMethodBeat.o(103280);
            return false;
        }
        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (next.Lwv == 2) {
                AppMethodBeat.o(103280);
                return true;
            } else if (next.Lwv == 1) {
                AppMethodBeat.o(103280);
                return true;
            }
        }
        AppMethodBeat.o(103280);
        return false;
    }

    public static boolean g(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.field_itemStatus == 8 || gVar.field_itemStatus == 10 || gVar.field_itemStatus == 7) {
            return true;
        }
        return false;
    }

    public static void cUg() {
        AppMethodBeat.i(103281);
        Set<String> cUe = cUe();
        if (cUe.size() == 0) {
            Log.v("MicroMsg.Fav.FavApiLogic", "doBatchDel no item to delete");
            AppMethodBeat.o(103281);
            return;
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "doBatchDel idList:%s", cUe.toString());
        LinkedList linkedList = new LinkedList();
        for (String str : cUe) {
            try {
                linkedList.add(Integer.valueOf(Util.getInt(str, 0)));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavApiLogic", e2, "", new Object[0]);
                Log.e("MicroMsg.Fav.FavApiLogic", "doBatchDel parseInt error:%s", e2.getMessage());
            }
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "doBatchDel after parse, total size %d", Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            com.tencent.mm.kernel.g.azz().a(new ah(linkedList), 0);
        }
        AppMethodBeat.o(103281);
    }

    private static void h(g gVar) {
        AppMethodBeat.i(103282);
        Set<String> set = ao.tbJ;
        LinkedList<aml> linkedList = gVar.field_favProto.ppH;
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String a2 = a(linkedList.get(i2));
            if (set == null || !set.contains(a2)) {
                s.deleteFile(a2);
            }
            String d2 = d(linkedList.get(i2));
            if (set == null || !set.contains(d2)) {
                s.deleteFile(d2);
            }
            aml aml = linkedList.get(i2);
            if (!(aml.Lwh == null || aml.Lwh.Lxi == null)) {
                u.QM(aml.dLl);
            }
        }
        AppMethodBeat.o(103282);
    }

    public static String EX(String str) {
        AppMethodBeat.i(199698);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(199698);
            return "";
        }
        String arI = arI(str);
        String z = aa.z(new o(arH(arI), arI).her());
        AppMethodBeat.o(199698);
        return z;
    }

    public static String a(aml aml) {
        AppMethodBeat.i(103283);
        if (aml == null || Util.isNullOrNil(aml.dLl)) {
            AppMethodBeat.o(103283);
            return "";
        }
        String arI = arI(aml.dLl);
        String z = aa.z(new o(arH(arI), arI).her());
        AppMethodBeat.o(103283);
        return z;
    }

    public static String arI(String str) {
        AppMethodBeat.i(103284);
        String str2 = str + "_t";
        AppMethodBeat.o(103284);
        return str2;
    }

    public static boolean dD(List<g> list) {
        AppMethodBeat.i(103285);
        if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
            AppMethodBeat.o(103285);
            return false;
        }
        Set<String> cUe = cUe();
        for (g gVar : list) {
            h(gVar);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().Ea(gVar.field_localId);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(gVar);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DW(gVar.field_localId);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().w(gVar);
            cUe.add(new StringBuilder().append(gVar.field_id).toString());
            Log.d("MicroMsg.Fav.FavApiLogic", "delete id %d", Integer.valueOf(gVar.field_id));
        }
        i(cUe);
        cUg();
        AppMethodBeat.o(103285);
        return true;
    }

    public static void a(g gVar, boolean z) {
        AppMethodBeat.i(103286);
        h(gVar);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().Ea(gVar.field_localId);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(gVar);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DW(gVar.field_localId);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().w(gVar);
        if (z) {
            Set<String> cUe = cUe();
            cUe.add(new StringBuilder().append(gVar.field_id).toString());
            i(cUe);
            cUg();
        }
        if (gVar.field_type == 18) {
            long j2 = gVar.field_localId;
            if (j2 <= 0) {
                AppMethodBeat.o(103286);
                return;
            }
            ct ctVar = new ct();
            ctVar.dFT.localId = j2;
            EventCenter.instance.publish(ctVar);
        }
        AppMethodBeat.o(103286);
    }

    public static boolean a(final g gVar, final boolean z, final Runnable runnable) {
        AppMethodBeat.i(103287);
        if (gVar == null) {
            Log.w("MicroMsg.Fav.FavApiLogic", "delete fav item fail, item is null");
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(103287);
            return false;
        }
        if (Looper.myLooper() == com.tencent.mm.kernel.g.aAk().getLooper()) {
            Log.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Boolean.valueOf(z));
            a(gVar, z);
            MMHandlerThread.postToMainThread(runnable);
            i(gVar);
        } else {
            Log.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Boolean.valueOf(z));
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.fav.a.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(103256);
                    Log.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Boolean.valueOf(z));
                    b.a(gVar, z);
                    MMHandlerThread.postToMainThread(runnable);
                    b.s(gVar);
                    AppMethodBeat.o(103256);
                }
            });
        }
        AppMethodBeat.o(103287);
        return true;
    }

    private static void i(g gVar) {
        AppMethodBeat.i(103288);
        if (gVar == null) {
            AppMethodBeat.o(103288);
            return;
        }
        if (5 == gVar.field_type) {
            String str = "";
            if (gVar.field_favProto.LwS != null) {
                str = gVar.field_favProto.LwS.LyC;
            }
            if (gVar.field_favProto.Lya != null && Util.isNullOrNil(str)) {
                str = gVar.field_favProto.Lya.link;
            }
            gv gvVar = new gv();
            gvVar.dKQ.url = str;
            EventCenter.instance.publish(gvVar);
        }
        AppMethodBeat.o(103288);
    }

    public static boolean a(g gVar, Runnable runnable) {
        AppMethodBeat.i(103289);
        boolean a2 = a(gVar, true, runnable);
        AppMethodBeat.o(103289);
        return a2;
    }

    public static void j(g gVar) {
        boolean z;
        j jVar;
        AppMethodBeat.i(103290);
        j Eb = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().Eb(gVar.field_localId);
        if (Eb == null) {
            j jVar2 = new j();
            jVar2.field_localId = gVar.field_localId;
            z = true;
            jVar = jVar2;
        } else {
            z = false;
            jVar = Eb;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (gVar.field_favProto.title != null) {
            stringBuffer.append(gVar.field_favProto.title);
        }
        if (gVar.field_favProto.desc != null) {
            stringBuffer.append(gVar.field_favProto.desc);
        }
        if (gVar.field_favProto.Lya != null) {
            anh anh = gVar.field_favProto.Lya;
            if (!Util.isNullOrNil(anh.dRL)) {
                stringBuffer.append(anh.dRL);
                as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(anh.dRL);
                if (Kn != null) {
                    stringBuffer.append(Kn.field_nickname).append(Kn.field_conRemark);
                }
                as Kn2 = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(anh.toUser);
                if (Kn2 != null) {
                    stringBuffer.append(Kn2.field_nickname).append(Kn2.field_conRemark);
                }
                stringBuffer.append(anh.LxA);
            }
        }
        LinkedList<aml> linkedList = gVar.field_favProto.ppH;
        jVar.field_subtype = 0;
        Iterator<aml> it = linkedList.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (next.desc != null) {
                stringBuffer.append(next.desc);
            }
            if (next.title != null) {
                stringBuffer.append(next.title);
            }
            jVar.field_subtype = j.HV(next.dataType) | jVar.field_subtype;
        }
        if (gVar.field_favProto.LwS != null) {
            if (gVar.field_favProto.LwS.desc != null) {
                stringBuffer.append(gVar.field_favProto.LwS.desc);
            }
            if (gVar.field_favProto.LwS.title != null) {
                stringBuffer.append(gVar.field_favProto.LwS.title);
            }
        }
        if (gVar.field_favProto.LwU != null) {
            if (gVar.field_favProto.LwU.desc != null) {
                stringBuffer.append(gVar.field_favProto.LwU.desc);
            }
            if (gVar.field_favProto.LwU.title != null) {
                stringBuffer.append(gVar.field_favProto.LwU.title);
            }
        }
        if (gVar.field_favProto.Lxk != null) {
            if (gVar.field_favProto.Lxk.nickname != null) {
                stringBuffer.append(gVar.field_favProto.Lxk.nickname);
            }
            if (gVar.field_favProto.Lxk.desc != null) {
                stringBuffer.append(gVar.field_favProto.Lxk.desc);
            }
        }
        jVar.field_tagContent = "";
        for (String str : gVar.field_tagProto.Lyn) {
            jVar.field_tagContent += " " + str;
            stringBuffer.append(str);
        }
        for (String str2 : gVar.field_tagProto.Lyo) {
            jVar.field_tagContent += " " + str2;
            stringBuffer.append(str2);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().arV(str2);
        }
        jVar.field_content = stringBuffer.toString();
        jVar.field_time = gVar.field_updateTime;
        jVar.field_type = gVar.field_type;
        if (z) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().a(jVar);
            AppMethodBeat.o(103290);
            return;
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().a(jVar, ch.COL_LOCALID);
        AppMethodBeat.o(103290);
    }

    public static boolean arJ(String str) {
        AppMethodBeat.i(103291);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103291);
            return false;
        }
        boolean endsWith = str.endsWith("_t");
        AppMethodBeat.o(103291);
        return endsWith;
    }

    public static aml a(g gVar, String str) {
        AppMethodBeat.i(103292);
        if (Util.isNullOrNil(str) || gVar == null || gVar.field_favProto.ppH.size() == 0) {
            AppMethodBeat.o(103292);
            return null;
        }
        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (next.dLl.equals(str)) {
                AppMethodBeat.o(103292);
                return next;
            }
        }
        AppMethodBeat.o(103292);
        return null;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(c cVar) {
        AppMethodBeat.i(103293);
        int x = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().x(cVar.field_favLocalId, 0);
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", Integer.valueOf(x), Long.valueOf(cVar.field_favLocalId));
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(cVar.field_favLocalId);
        if (DY == null) {
            Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
            AppMethodBeat.o(103293);
        } else if (DY.cUB()) {
            Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus waiting server upload skip.");
            AppMethodBeat.o(103293);
        } else if (cVar.field_status == 3 && x != cVar.field_status && DY.field_type == 18 && ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(cVar.field_dataId).field_status == 3) {
            a(cVar, DY);
            AppMethodBeat.o(103293);
        } else {
            switch (x) {
                case 0:
                    AppMethodBeat.o(103293);
                    return;
                case 1:
                    if (DY.cUA()) {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(15, cVar.field_favLocalId);
                    } else {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(4, cVar.field_favLocalId);
                    }
                    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_itemStatus));
                    AppMethodBeat.o(103293);
                    return;
                case 2:
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(6, cVar.field_favLocalId);
                    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_itemStatus));
                    break;
                case 3:
                    if (DY.field_type == 18) {
                        a(cVar, DY);
                        AppMethodBeat.o(103293);
                        return;
                    } else if (DY.cUA()) {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(17, cVar.field_favLocalId);
                        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_itemStatus));
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getModService().run();
                        AppMethodBeat.o(103293);
                        return;
                    } else {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(9, cVar.field_favLocalId);
                        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_itemStatus));
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
                        AppMethodBeat.o(103293);
                        return;
                    }
                case 4:
                    if (DY.cUA()) {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(16, cVar.field_favLocalId);
                    } else {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(6, cVar.field_favLocalId);
                    }
                    h.INSTANCE.a(10659, 0, Integer.valueOf(DY.field_type), -5, Long.valueOf(b(DY)), Long.valueOf(h.DR(DY.field_localId)));
                    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_itemStatus));
                    AppMethodBeat.o(103293);
                    return;
            }
            AppMethodBeat.o(103293);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void c(c cVar) {
        AppMethodBeat.i(103294);
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage() == null) {
            Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, getFavCdnStorage null");
            AppMethodBeat.o(103294);
            return;
        }
        int x = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().x(cVar.field_favLocalId, 1);
        Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", Integer.valueOf(x), Long.valueOf(cVar.field_favLocalId));
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage() == null) {
            Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus getFavItemInfoStorage null");
            AppMethodBeat.o(103294);
            return;
        }
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(cVar.field_favLocalId);
        if (DY == null) {
            Log.e("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus iteminfo null");
            AppMethodBeat.o(103294);
        } else if (DY.cUB() || DY.cUx() || DY.cUy()) {
            Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", Boolean.valueOf(DY.cUB()), Boolean.valueOf(DY.cUx()), Boolean.valueOf(DY.cUy()));
            AppMethodBeat.o(103294);
        } else {
            switch (x) {
                case 0:
                    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id));
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(10, cVar.field_favLocalId);
                    AppMethodBeat.o(103294);
                    return;
                case 1:
                    h.DS(DY.field_localId);
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(7, cVar.field_favLocalId);
                    AppMethodBeat.o(103294);
                    return;
                case 2:
                    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id));
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(8, cVar.field_favLocalId);
                    break;
                case 3:
                    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id));
                    h.INSTANCE.a(10659, 1, Integer.valueOf(DY.field_type), 0, Long.valueOf(b(DY)), Long.valueOf(h.DR(DY.field_localId)));
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(10, cVar.field_favLocalId);
                    AppMethodBeat.o(103294);
                    return;
                case 4:
                    Log.i("MicroMsg.Fav.FavApiLogic", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", Long.valueOf(cVar.field_favLocalId), Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_itemStatus));
                    h.INSTANCE.a(10659, 1, Integer.valueOf(DY.field_type), -5, Long.valueOf(b(DY)), Long.valueOf(h.DR(DY.field_localId)));
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(8, cVar.field_favLocalId);
                    AppMethodBeat.o(103294);
                    return;
            }
            AppMethodBeat.o(103294);
        }
    }

    private static void a(c cVar, g gVar) {
        int i2;
        AppMethodBeat.i(103295);
        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            aml next = it.next();
            if (!(next.dataType == 1 || next.dataType == 6)) {
                if (Util.isNullOrNil(next.KuR)) {
                    i2 = i3 + 1;
                } else {
                    i2 = i3;
                }
                i3 = i2;
            }
        }
        if (i3 == 0) {
            if (gVar.field_id > 0) {
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(17, cVar.field_favLocalId);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getModService().run();
                AppMethodBeat.o(103295);
                return;
            }
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(9, cVar.field_favLocalId);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
        }
        AppMethodBeat.o(103295);
    }

    public static void a(aml aml, g gVar, int i2) {
        AppMethodBeat.i(103296);
        if (i2 == 1 && (aml.LvT <= 0 || Util.isNullOrNil(aml.Lvk) || Util.isNullOrNil(aml.iwX))) {
            Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
            AppMethodBeat.o(103296);
        } else if (i2 != 0 || !Util.isNullOrNil(a(aml))) {
            String arI = arI(aml.dLl);
            if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(arI) != null) {
                Log.w("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", arI);
                AppMethodBeat.o(103296);
                return;
            }
            Log.v("MicroMsg.Fav.FavApiLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
            c cVar = new c();
            cVar.field_cdnKey = aml.Lvk;
            cVar.field_cdnUrl = aml.iwX;
            cVar.field_dataId = arI;
            cVar.field_favLocalId = gVar.field_localId;
            cVar.field_totalLen = (int) aml.LvT;
            cVar.field_type = i2;
            cVar.field_status = 1;
            cVar.field_path = a(aml);
            cVar.field_modifyTime = Util.nowMilliSecond();
            cVar.field_attrFlag |= 1;
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().f(cVar);
            if (i2 == 1) {
                c(cVar);
                AppMethodBeat.o(103296);
                return;
            }
            b(cVar);
            AppMethodBeat.o(103296);
        } else {
            Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnThumbInfo, type send, path must not be null!");
            AppMethodBeat.o(103296);
        }
    }

    public static void a(aml aml, g gVar, int i2, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(103297);
        if (i2 == 1 && (Util.isNullOrNil(aml.Lvp) || Util.isNullOrNil(aml.KuR))) {
            Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
            AppMethodBeat.o(103297);
        } else if (i2 == 0 && Util.isNullOrNil(d(aml))) {
            Log.e("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo, type send, path must not be null!");
            AppMethodBeat.o(103297);
        } else if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(aml.dLl) != null) {
            Log.v("MicroMsg.Fav.FavApiLogic", "cdn info exist, id[%s], return", aml.dLl);
            AppMethodBeat.o(103297);
        } else {
            Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn data info, fav local id[%d] fav id[%d]", Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id));
            c cVar = new c();
            cVar.field_dataId = aml.dLl;
            cVar.field_totalLen = (int) aml.LvI;
            cVar.field_type = i2;
            cVar.field_favLocalId = gVar.field_localId;
            cVar.field_cdnKey = aml.Lvp;
            cVar.field_cdnUrl = aml.KuR;
            cVar.field_path = d(aml);
            if (aml.dataType == 3) {
                cVar.field_dataType = arK(aml.LvC);
            } else {
                cVar.field_dataType = aml.dataType;
            }
            cVar.field_modifyTime = Util.nowMilliSecond();
            boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
            if (i2 == 0) {
                Log.i("MicroMsg.Fav.FavApiLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                if (z) {
                    z3 = true;
                } else if (isWifi) {
                    z3 = true;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    long j2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getLong("fav_mx_auto_upload_size", 0);
                    if (j2 == 0) {
                        j2 = (long) ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(true);
                    }
                    if (((long) cVar.field_totalLen) <= j2) {
                        Log.i("MicroMsg.Fav.FavApiLogic", "match max auto upload, max size %d", Long.valueOf(j2));
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = true;
                }
                if (z3) {
                    cVar.field_status = 1;
                    Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status traning");
                } else {
                    cVar.field_status = 4;
                    Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo upload status pause");
                }
            }
            if (i2 == 1) {
                Log.i("MicroMsg.Fav.FavApiLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                if (z) {
                    z2 = true;
                } else if (isWifi) {
                    z2 = true;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    long j3 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getLong("fav_mx_auto_download_size", (long) ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(true));
                    if (((long) cVar.field_totalLen) <= j3) {
                        Log.i("MicroMsg.Fav.FavApiLogic", "match max auto download, max size %d", Long.valueOf(j3));
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = true;
                }
                if (z2) {
                    cVar.field_status = 1;
                    Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status traning");
                } else {
                    cVar.field_status = 4;
                    Log.i("MicroMsg.Fav.FavApiLogic", "insertCdnDataInfo download status pause");
                }
            }
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().f(cVar);
            if (i2 == 1) {
                c(cVar);
                AppMethodBeat.o(103297);
                return;
            }
            b(cVar);
            AppMethodBeat.o(103297);
        }
    }

    public static int arK(String str) {
        AppMethodBeat.i(184037);
        if (!Util.isNullOrNil(str) && str.equals("speex")) {
            AppMethodBeat.o(184037);
            return -3;
        } else if (Util.isNullOrNil(str) || !str.equals("silk")) {
            AppMethodBeat.o(184037);
            return -2;
        } else {
            AppMethodBeat.o(184037);
            return -4;
        }
    }

    public static boolean HS(int i2) {
        for (int i3 : a.sZO) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(g gVar) {
        AppMethodBeat.i(103298);
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(gVar.field_localId) != null) {
            AppMethodBeat.o(103298);
            return true;
        }
        AppMethodBeat.o(103298);
        return false;
    }

    public static void fh(Context context) {
        AppMethodBeat.i(199699);
        if (0 >= sZR) {
            Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
            AppMethodBeat.o(199699);
            return;
        }
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(sZR);
        sZR = 0;
        if (DY == null) {
            Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
            AppMethodBeat.o(199699);
            return;
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "addTagWhenAddToFav ,go on");
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 5);
        intent.putExtra("key_fav_item_id", DY.field_localId);
        a(context, ".ui.FavTagEditUI", intent, (Bundle) null);
        AppMethodBeat.o(199699);
    }

    public static void DN(long j2) {
        sZR = j2;
    }

    public static long cUh() {
        AppMethodBeat.i(103300);
        long cUi = cUi() - cUj();
        if (cUi < 0) {
            cUi = 1024;
        }
        AppMethodBeat.o(103300);
        return cUi;
    }

    public static long cUi() {
        AppMethodBeat.i(103301);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERFINO_FAV_TOTAL_CAPACITY_LONG, (Object) 0L)).longValue();
        AppMethodBeat.o(103301);
        return longValue;
    }

    public static long cUj() {
        AppMethodBeat.i(103302);
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERFINO_FAV_USED_CAPACITY_LONG, (Object) 0L)).longValue();
        AppMethodBeat.o(103302);
        return longValue;
    }

    public static String arL(String str) {
        AppMethodBeat.i(103303);
        as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(103303);
            return str;
        } else if (!Util.isNullOrNil(Kn.field_conRemark)) {
            String str2 = Kn.field_conRemark;
            AppMethodBeat.o(103303);
            return str2;
        } else if (!Util.isNullOrNil(Kn.field_nickname)) {
            String str3 = Kn.field_nickname;
            AppMethodBeat.o(103303);
            return str3;
        } else {
            String str4 = Kn.field_username;
            AppMethodBeat.o(103303);
            return str4;
        }
    }

    public static String Is(String str) {
        AppMethodBeat.i(103304);
        as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            Log.w("MicroMsg.Fav.FavApiLogic", "wtf get contact null, username %s", str);
            AppMethodBeat.o(103304);
            return "";
        }
        String arJ = Kn.arJ();
        if (ab.Eq(arJ)) {
            List<String> Ic = v.Ic(str);
            String aTY = z.aTY();
            if (Ic == null || Ic.isEmpty()) {
                Log.w("MicroMsg.Fav.FavApiLogic", "get members from username error, content empty");
            } else {
                Ic.remove(aTY);
                Ic.add(0, aTY);
                arJ = v.e(Ic, 3);
            }
        }
        AppMethodBeat.o(103304);
        return arJ;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void l(g gVar) {
        AppMethodBeat.i(103305);
        if (!gVar.cUy()) {
            Log.f("MicroMsg.Fav.FavApiLogic", "restartItemUpload status not upload failed!");
            AppMethodBeat.o(103305);
            return;
        }
        switch (gVar.field_itemStatus) {
            case 3:
                gVar.field_itemStatus = 1;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getCheckCdnService().run();
                AppMethodBeat.o(103305);
                return;
            case 6:
                if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DT(gVar.field_localId).size() == 0) {
                    gVar.field_itemStatus = 9;
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
                    com.tencent.mm.kernel.g.azz().a(new ag(gVar), 0);
                    AppMethodBeat.o(103305);
                    return;
                }
                gVar.field_itemStatus = 4;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().y(gVar);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
                for (c cVar : ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DT(gVar.field_localId)) {
                    Log.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), cVar.field_dataId, Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(cVar.field_dataId);
                }
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
                AppMethodBeat.o(103305);
                return;
            case 11:
                gVar.field_itemStatus = 9;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
                break;
            case 14:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(12, gVar.field_localId);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getSendService().run();
                AppMethodBeat.o(103305);
                return;
            case 16:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(15, gVar.field_localId);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().y(gVar);
                for (c cVar2 : ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DT(gVar.field_localId)) {
                    Log.i("MicroMsg.Fav.FavApiLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), cVar2.field_dataId, Integer.valueOf(cVar2.field_dataType), Integer.valueOf(cVar2.field_totalLen));
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(cVar2.field_dataId);
                }
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
                AppMethodBeat.o(103305);
                return;
            case 18:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(17, gVar.field_localId);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getModService().run();
                AppMethodBeat.o(103305);
                return;
        }
        AppMethodBeat.o(103305);
    }

    public static void m(g gVar) {
        AppMethodBeat.i(103306);
        if (gVar == null) {
            AppMethodBeat.o(103306);
        } else if (gVar.field_itemStatus == 8 || gVar.field_itemStatus == 10) {
            gVar.field_itemStatus = 7;
            LinkedList<aml> linkedList = gVar.field_favProto.ppH;
            if (linkedList.size() == 0) {
                AppMethodBeat.o(103306);
                return;
            }
            for (aml aml : linkedList) {
                a(gVar, aml, true);
                a(gVar, aml);
            }
            AppMethodBeat.o(103306);
        } else {
            Log.e("MicroMsg.Fav.FavApiLogic", "status not download failed or done!");
            AppMethodBeat.o(103306);
        }
    }

    public static void a(g gVar, aml aml, boolean z) {
        AppMethodBeat.i(103307);
        if (gVar == null || Util.isNullOrNil(aml.dLl)) {
            AppMethodBeat.o(103307);
            return;
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), aml.dLl);
        c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(aml.dLl);
        if (asa != null && asa.field_status == 3) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(asa, "dataId");
            asa = null;
        }
        if (asa != null && (Util.isNullOrNil(asa.field_cdnUrl) || Util.isNullOrNil(asa.field_cdnKey) || Util.isNullOrNil(asa.field_dataId) || !asa.field_cdnUrl.equals(aml.KuR) || !asa.field_cdnKey.equals(aml.Lvp) || !asa.field_dataId.equals(aml.dLl))) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(asa, "dataId");
            asa = null;
        }
        if (asa == null || asa.field_type != 1) {
            o oVar = new o(d(aml));
            if (!Util.isNullOrNil(aml.Lvp) && !Util.isNullOrNil(aml.KuR) && !oVar.exists()) {
                Log.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
                long currentTimeMillis = System.currentTimeMillis();
                a(aml, gVar, 1, true);
                if (z) {
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(aml.dLl);
                    if (!Util.isNullOrNil(aml.Lwp) && aml.Lwp.equals("WeNoteHtmlFile")) {
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().d(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(aml.dLl));
                    }
                }
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
                Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.o(103307);
            return;
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
        asa.field_status = 1;
        asa.field_path = d(aml);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, "dataId");
        if (z) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(aml.dLl);
            if (!Util.isNullOrNil(aml.Lwp) && aml.Lwp.equals("WeNoteHtmlFile")) {
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().d(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(aml.dLl));
            }
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
        AppMethodBeat.o(103307);
    }

    public static void e(aml aml) {
        AppMethodBeat.i(103309);
        c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(aml.dLl);
        if (!(asa == null || asa.field_status == 3)) {
            asa.field_status = 2;
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, "dataId");
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().pauseDownload(aml.dLl);
        }
        c asa2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(arI(aml.dLl));
        if (!(asa2 == null || asa2.field_status == 3)) {
            asa2.field_status = 2;
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa2, "dataId");
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().pauseDownload(arI(aml.dLl));
        }
        AppMethodBeat.o(103309);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void n(g gVar) {
        AppMethodBeat.i(103310);
        if (!gVar.cUx()) {
            Log.e("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, not uploading");
            AppMethodBeat.o(103310);
            return;
        }
        Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, itemStatu:%d", Integer.valueOf(gVar.field_itemStatus));
        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(next.dLl);
            if (!(asa == null || asa.field_status == 3)) {
                asa.field_status = 2;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, "dataId");
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arZ(next.dLl);
            }
            c asa2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(arI(next.dLl));
            if (!(asa2 == null || asa2.field_status == 3)) {
                asa2.field_status = 2;
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa2, "dataId");
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arZ(arI(next.dLl));
            }
        }
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(gVar.field_localId);
        Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, after pause data itemStatu:%d", Integer.valueOf(DY.field_itemStatus));
        switch (DY.field_itemStatus) {
            case 1:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(3, DY.field_localId);
                Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", 3);
                AppMethodBeat.o(103310);
                return;
            case 4:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(6, DY.field_localId);
                Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", 6);
                AppMethodBeat.o(103310);
                return;
            case 9:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(11, DY.field_localId);
                Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", 11);
                AppMethodBeat.o(103310);
                return;
            case 12:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(14, DY.field_localId);
                Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", 14);
                AppMethodBeat.o(103310);
                return;
            case 15:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(16, DY.field_localId);
                Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", 16);
                AppMethodBeat.o(103310);
                return;
            case 17:
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(18, DY.field_localId);
                Log.v("MicroMsg.Fav.FavApiLogic", "pauseItemUpload, final itemStatu:%d", 18);
                break;
        }
        AppMethodBeat.o(103310);
    }

    public static boolean cUk() {
        AppMethodBeat.i(103311);
        if (cUi() == 0) {
            AppMethodBeat.o(103311);
            return false;
        } else if (cUh() < 52428800) {
            AppMethodBeat.o(103311);
            return true;
        } else {
            AppMethodBeat.o(103311);
            return false;
        }
    }

    public static float AO(long j2) {
        float f2 = 60.0f;
        float f3 = 1.0f;
        AppMethodBeat.i(103312);
        float f4 = ((float) j2) / 1000.0f;
        if (f4 >= 1.0f) {
            f3 = f4;
        }
        if (f3 <= 60.0f) {
            f2 = f3;
        }
        float round = (float) Math.round(f2);
        AppMethodBeat.o(103312);
        return round;
    }

    public static float DO(long j2) {
        float f2 = 1.0f;
        AppMethodBeat.i(103313);
        float f3 = ((float) j2) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        float round = (float) Math.round(f2);
        AppMethodBeat.o(103313);
        return round;
    }

    public static String DP(long j2) {
        AppMethodBeat.i(103314);
        if (j2 == 0) {
            AppMethodBeat.o(103314);
            return "0KB";
        } else if ((((double) j2) * 1.0d) / 1048576.0d >= 1.0d) {
            String format = String.format("%dMB", Integer.valueOf((int) ((((double) j2) * 1.0d) / 1048576.0d)));
            AppMethodBeat.o(103314);
            return format;
        } else if ((((double) j2) * 1.0d) / 1024.0d >= 1.0d) {
            String format2 = String.format("%dKB", Integer.valueOf((int) ((((double) j2) * 1.0d) / 1024.0d)));
            AppMethodBeat.o(103314);
            return format2;
        } else {
            AppMethodBeat.o(103314);
            return "1KB";
        }
    }

    public static String getLengthStr(float f2) {
        AppMethodBeat.i(103315);
        if (f2 < 1024.0f) {
            String format = String.format("%.1fB", Float.valueOf(f2));
            AppMethodBeat.o(103315);
            return format;
        } else if (f2 < 1048576.0f) {
            String format2 = String.format("%.1fKB", Float.valueOf(f2 / 1024.0f));
            AppMethodBeat.o(103315);
            return format2;
        } else if (f2 < 1.07374182E9f) {
            String format3 = String.format("%.1fMB", Float.valueOf((f2 / 1024.0f) / 1024.0f));
            AppMethodBeat.o(103315);
            return format3;
        } else {
            String format4 = String.format("%.1fGB", Float.valueOf(((f2 / 1024.0f) / 1024.0f) / 1024.0f));
            AppMethodBeat.o(103315);
            return format4;
        }
    }

    public static boolean f(aml aml) {
        AppMethodBeat.i(103316);
        f bef = com.tencent.mm.ay.a.bef();
        if (bef == null || bef.jeT != 6 || !Util.nullAs(aml.dLl, "").equals(bef.jeV) || !com.tencent.mm.ay.a.bec()) {
            AppMethodBeat.o(103316);
            return false;
        }
        AppMethodBeat.o(103316);
        return true;
    }

    public static String cUl() {
        AppMethodBeat.i(103317);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "favorite/music/";
        AppMethodBeat.o(103317);
        return str;
    }

    public static boolean o(g gVar) {
        boolean z;
        int i2;
        int i3;
        AppMethodBeat.i(103319);
        if (gVar == null) {
            AppMethodBeat.o(103319);
            return false;
        }
        aml c2 = c(gVar);
        if (c2 == null) {
            AppMethodBeat.o(103319);
            return false;
        }
        long currentTicks = Util.currentTicks();
        com.tencent.mm.plugin.sight.base.a aNx = e.aNx(d(c2));
        if (aNx != null) {
            i3 = aNx.getVideoDuration();
            i2 = c2.duration;
            if (i2 <= 0 || Math.abs(i2 - i3) >= 2) {
                c2.ajc(i3);
                z = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
            } else {
                z = false;
            }
        } else {
            z = false;
            i2 = 0;
            i3 = 0;
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "repair video duration[%d TO %d] %b cost time %d", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(103319);
        return z;
    }

    public static String cUm() {
        AppMethodBeat.i(103320);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "favorite/";
        AppMethodBeat.o(103320);
        return str;
    }

    public static String cUn() {
        AppMethodBeat.i(103321);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "favorite/voice/";
        AppMethodBeat.o(103321);
        return str;
    }

    public static List<g> a(long j2, int i2, Set<Integer> set, w wVar) {
        AppMethodBeat.i(103322);
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage() == null) {
            Log.e("MicroMsg.Fav.FavApiLogic", "getItemList error, getFavItemInfoStorage null.");
            AppMethodBeat.o(103322);
            return null;
        } else if (j2 == 0) {
            List<g> a2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(i2, set, wVar);
            AppMethodBeat.o(103322);
            return a2;
        } else {
            List<g> b2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().b(j2, i2, set, wVar);
            AppMethodBeat.o(103322);
            return b2;
        }
    }

    public static long v(long j2, int i2) {
        AppMethodBeat.i(103323);
        Log.i("MicroMsg.Fav.FavApiLogic", "tryStartBatchGet...");
        long C = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().C(j2, i2);
        long A = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().A(j2, i2);
        Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", Long.valueOf(C), Long.valueOf(A), Long.valueOf(j2));
        if (C == 0) {
            AppMethodBeat.o(103323);
            return A;
        }
        LinkedList<Integer> B = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().B(C, i2);
        if (B.size() > 0) {
            Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", Long.valueOf(C), Long.valueOf(A), Long.valueOf(j2));
            Log.i("MicroMsg.Fav.FavApiLogic", "klem, tryStartBatchGet, need batch get idList size:%d", Integer.valueOf(B.size()));
            if (!com.tencent.mm.kernel.g.azz().a(new ai(B), 0)) {
                Log.w("MicroMsg.Fav.FavApiLogic", "do scene BatchGetFav fail");
                ai.cVc();
            }
        }
        if (A == 0) {
            AppMethodBeat.o(103323);
            return C;
        } else if (C < A) {
            AppMethodBeat.o(103323);
            return C;
        } else {
            AppMethodBeat.o(103323);
            return A;
        }
    }

    public static void startSync() {
        AppMethodBeat.i(103324);
        com.tencent.mm.kernel.g.azz().a(new ak(), 0);
        AppMethodBeat.o(103324);
    }

    public static String arM(String str) {
        AppMethodBeat.i(103325);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103325);
            return null;
        }
        o oVar = new o(cUf() + g.getMessageDigest(str.getBytes()));
        if (oVar.exists()) {
            String z = aa.z(oVar.her());
            AppMethodBeat.o(103325);
            return z;
        }
        AppMethodBeat.o(103325);
        return null;
    }

    public static boolean g(aml aml) {
        AppMethodBeat.i(103326);
        boolean exists = new o(d(aml)).exists();
        AppMethodBeat.o(103326);
        return exists;
    }

    public static boolean h(aml aml) {
        AppMethodBeat.i(103327);
        boolean isGif = ImgUtil.isGif(d(aml));
        AppMethodBeat.o(103327);
        return isGif;
    }

    public static boolean cUo() {
        AppMethodBeat.i(103328);
        if (ai.cVd() > 0) {
            AppMethodBeat.o(103328);
            return true;
        }
        AppMethodBeat.o(103328);
        return false;
    }

    public static boolean b(long j2, Runnable runnable) {
        AppMethodBeat.i(103331);
        boolean a2 = a(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2), true, runnable);
        AppMethodBeat.o(103331);
        return a2;
    }

    public static void p(g gVar) {
        boolean z;
        j jVar;
        AppMethodBeat.i(103332);
        j Eb = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().Eb(gVar.field_localId);
        if (Eb == null) {
            j jVar2 = new j();
            jVar2.field_localId = gVar.field_localId;
            z = true;
            jVar = jVar2;
        } else {
            z = false;
            jVar = Eb;
        }
        jVar.field_tagContent = "";
        Iterator<String> it = gVar.field_tagProto.Lyn.iterator();
        while (it.hasNext()) {
            jVar.field_tagContent += " " + it.next();
        }
        for (String str : gVar.field_tagProto.Lyo) {
            jVar.field_tagContent += " " + str;
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().arV(str);
        }
        jVar.field_time = gVar.field_updateTime;
        jVar.field_type = gVar.field_type;
        if (z) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().a(jVar);
            AppMethodBeat.o(103332);
            return;
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().a(jVar, ch.COL_LOCALID);
        AppMethodBeat.o(103332);
    }

    public static ArrayList<g> a(List<String> list, List<String> list2, int i2, List<g> list3, Set<Integer> set, w wVar) {
        AppMethodBeat.i(103333);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(i2));
        ArrayList<Long> b2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().b(list, list2, arrayList);
        ArrayList<g> arrayList2 = new ArrayList<>();
        if (b2.size() == 0) {
            AppMethodBeat.o(103333);
            return arrayList2;
        }
        int i3 = 0;
        while (true) {
            int size = i3 + 20 < b2.size() ? i3 + 20 : b2.size();
            Log.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", Integer.valueOf(i3), Integer.valueOf(size), Integer.valueOf(b2.size()));
            ArrayList<g> a2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(b2.subList(i3, size), list3, set, wVar);
            if (a2 != null && a2.size() > 0) {
                if (i2 == 8) {
                    arrayList2.addAll(a(list, a2, 8, 8));
                } else if (i2 == 5) {
                    arrayList2.addAll(a(list, a2, 5, 5));
                } else if (i2 == 7) {
                    arrayList2.addAll(a(list, a2, 7, 7));
                    arrayList2.addAll(a(list, a2, 29, 21));
                } else if (i2 == 6) {
                    arrayList2.addAll(a(list, a2, 6, 6));
                } else if (i2 == 3) {
                    arrayList2.addAll(a(list, a2, 3, 3));
                } else {
                    arrayList2.addAll(a2);
                }
            }
            if (size >= b2.size()) {
                AppMethodBeat.o(103333);
                return arrayList2;
            }
            i3 = size;
        }
    }

    private static ArrayList<g> a(List<String> list, ArrayList<g> arrayList, int i2, int i3) {
        int i4;
        String str;
        boolean z;
        AppMethodBeat.i(199700);
        ArrayList<g> arrayList2 = new ArrayList<>();
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.field_type == 18 || next.field_type == 14) {
                try {
                    LinkedList<aml> linkedList = next.field_favProto.ppH;
                    if (next.field_type == 18) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    while (i4 < linkedList.size()) {
                        aml aml = linkedList.get(i4);
                        if (aml.dataType == i2) {
                            if (!Util.isNullOrNil(aml.title)) {
                                str = aml.title;
                            } else {
                                str = aml.desc;
                            }
                            if (list != null && !list.isEmpty() && !Util.isNullOrNil(str)) {
                                Iterator<String> it2 = list.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (str.contains(it2.next())) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                }
                            }
                            g cUC = next.cUC();
                            cUC.field_type = i3;
                            cUC.tad = true;
                            cUC.tae = next;
                            cUC.dLb = next.field_localId + "_" + aml.dLl;
                            cUC.taf = aml.dLl;
                            cUC.field_favProto = c.c(next.field_favProto);
                            cUC.field_favProto.ppH = new LinkedList<>();
                            cUC.field_favProto.ppH.add(aml);
                            cUC.field_favProto.bhd(aml.title);
                            if (aml.Lwh != null) {
                                if (i2 == 6) {
                                    cUC.field_favProto.d(aml.Lwh.LwQ);
                                } else if (i2 == 5) {
                                    cUC.field_favProto.b(aml.Lwh.LwS);
                                }
                            }
                            arrayList2.add(cUC);
                        }
                        i4++;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.Fav.FavApiLogic", "getSearchList() [%s] Exception:%s %s", Integer.valueOf(i2), e2.getClass().getSimpleName(), e2.getMessage());
                }
            } else {
                arrayList2.add(next);
            }
        }
        AppMethodBeat.o(199700);
        return arrayList2;
    }

    public static ArrayList<g> a(List<String> list, List<String> list2, List<Integer> list3, List<g> list4, Set<Integer> set, w wVar) {
        boolean z;
        AppMethodBeat.i(103335);
        ArrayList<Long> b2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().b(list, list2, list3);
        ArrayList<g> arrayList = new ArrayList<>();
        if (b2.size() == 0) {
            AppMethodBeat.o(103335);
            return arrayList;
        }
        int i2 = 0;
        while (true) {
            int size = i2 + 20 < b2.size() ? i2 + 20 : b2.size();
            Log.v("MicroMsg.Fav.FavApiLogic", "start:%d  end:%d listSize:%d", Integer.valueOf(i2), Integer.valueOf(size), Integer.valueOf(b2.size()));
            ArrayList<g> a2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(b2.subList(i2, size), list4, set, wVar);
            if (a2 != null && a2.size() > 0) {
                if (list3.contains(8)) {
                    Iterator<g> it = a2.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (next.field_type == 18) {
                            try {
                                LinkedList<aml> linkedList = next.field_favProto.ppH;
                                int i3 = 1;
                                while (true) {
                                    if (i3 >= linkedList.size()) {
                                        z = false;
                                        break;
                                    } else if (linkedList.get(i3).dataType == 8) {
                                        z = true;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                            } catch (Exception e2) {
                                z = false;
                            }
                            if (z) {
                                arrayList.add(next);
                            }
                        } else {
                            arrayList.add(next);
                        }
                    }
                } else {
                    arrayList.addAll(a2);
                }
            }
            if (size >= b2.size()) {
                AppMethodBeat.o(103335);
                return arrayList;
            }
            i2 = size;
        }
    }

    public static int arN(String str) {
        AppMethodBeat.i(103336);
        if (!Util.isNullOrNil(str) && str.equals("speex")) {
            AppMethodBeat.o(103336);
            return 1;
        } else if (Util.isNullOrNil(str) || !str.equals("silk")) {
            AppMethodBeat.o(103336);
            return 0;
        } else {
            AppMethodBeat.o(103336);
            return 2;
        }
    }

    public static boolean cUp() {
        AppMethodBeat.i(103337);
        if (cUi() == 0) {
            AppMethodBeat.o(103337);
            return false;
        } else if (cUh() < 10485760) {
            AppMethodBeat.o(103337);
            return true;
        } else {
            AppMethodBeat.o(103337);
            return false;
        }
    }

    public static g arO(String str) {
        AppMethodBeat.i(103338);
        g gVar = new g();
        gVar.field_localId = -1;
        gVar.field_id = -1;
        gVar.field_xml = str;
        gVar.field_type = 18;
        gVar.arQ(str);
        AppMethodBeat.o(103338);
        return gVar;
    }

    private static g arP(String str) {
        String str2;
        AppMethodBeat.i(103339);
        if (str == null || str.equals("")) {
            Log.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml but xml is null");
            AppMethodBeat.o(103339);
            return null;
        }
        String replace = str.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
        if (!replace.startsWith("<noteinfo>")) {
            str2 = "<noteinfo>" + replace + "</noteinfo>";
        } else {
            str2 = replace;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str2, "noteinfo", null);
        if (parseXml == null) {
            Log.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
            AppMethodBeat.o(103339);
            return null;
        }
        g gVar = new g();
        try {
            gVar.field_favProto = new anb();
            gVar.field_type = 18;
            gVar.field_favProto.Mz(Util.getLong(parseXml.get(".noteinfo.edittime"), 0));
            amv amv = new amv();
            amv.LxU = parseXml.get(".noteinfo.noteeditor");
            amv.LxT = parseXml.get(".noteinfo.noteauthor");
            gVar.field_favProto.a(amv);
            gVar.field_localId = Util.getLong(parseXml.get(".noteinfo.favlocalid"), System.currentTimeMillis());
            c.a(str2, gVar.field_favProto);
            AppMethodBeat.o(103339);
            return gVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Fav.FavApiLogic", e2, "", new Object[0]);
            Log.e("MicroMsg.Fav.FavApiLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", e2.toString());
            AppMethodBeat.o(103339);
            return null;
        }
    }

    public static void e(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(103340);
        g arP = arP(str);
        if (arP == null) {
            AppMethodBeat.o(103340);
            return;
        }
        oc ocVar = new oc();
        ocVar.dUe.type = 2;
        ocVar.dUe.field_localId = -1;
        ocVar.dUe.context = context;
        ocVar.dUe.dUn = 4;
        ocVar.dUe.dUo = true;
        Bundle bundle = new Bundle();
        bundle.putString("noteauthor", arP.field_favProto.KBr.LxT);
        bundle.putString("noteeditor", arP.field_favProto.KBr.LxU);
        bundle.putLong("edittime", arP.field_favProto.rnM);
        bundle.putString("notexml", g.t(arP));
        bundle.putString("snslocalid", str2);
        bundle.putString("snsthumbpath", str3);
        bundle.putString("snsnotelinkxml", str);
        ocVar.dUe.dUl = bundle;
        ocVar.dUe.field_favProto = arP.field_favProto;
        EventCenter.instance.publish(ocVar);
        AppMethodBeat.o(103340);
    }

    private static void b(hb hbVar) {
        AppMethodBeat.i(103341);
        g arP = arP(hbVar.dLm.desc);
        if (arP == null) {
            AppMethodBeat.o(103341);
            return;
        }
        if (!(arP.field_favProto == null || arP.field_favProto.ppH == null)) {
            Iterator<aml> it = arP.field_favProto.ppH.iterator();
            while (it.hasNext()) {
                aml next = it.next();
                if (next.dataType == 20) {
                    next.At(true);
                    next.As(true);
                    next.bgt("");
                    next.bgj("");
                    next.bgk("");
                    next.bgh("");
                    next.bgi("");
                }
            }
        }
        hbVar.dLm.dGb = arP.field_favProto;
        AppMethodBeat.o(103341);
    }

    public static g a(anb anb) {
        AppMethodBeat.i(103342);
        g gVar = new g();
        gVar.field_favProto = new anb();
        gVar.field_type = 18;
        gVar.field_favProto = anb;
        AppMethodBeat.o(103342);
        return gVar;
    }

    private static void b(g gVar, boolean z) {
        AppMethodBeat.i(103343);
        amv amv = new amv();
        if (!z) {
            amv.LxT = z.aTY();
        }
        amv.LxU = z.aTY();
        gVar.field_favProto.Mz(Util.nowSecond());
        gVar.field_favProto.a(amv);
        AppMethodBeat.o(103343);
    }

    public static void q(g gVar) {
        AppMethodBeat.i(103344);
        if (gVar == null) {
            AppMethodBeat.o(103344);
            return;
        }
        amv amv = gVar.field_favProto.KBr;
        if (amv == null || Util.isNullOrNil(amv.LxU)) {
            if (gVar.field_type == 18) {
                if (gVar.field_favProto.Lya.sourceType == 6) {
                    b(gVar, false);
                } else {
                    b(gVar, true);
                }
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
            }
            AppMethodBeat.o(103344);
            return;
        }
        AppMethodBeat.o(103344);
    }

    public static void c(hb hbVar) {
        String str;
        int i2 = 1;
        AppMethodBeat.i(103345);
        if (hbVar.dLm.dLt == 1) {
            hbVar.dLn.path = DJ(hbVar.dLm.dFW);
            hb.b bVar = hbVar.dLn;
            g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
            if (DY == null || DY.field_favProto == null) {
                str = "";
            } else {
                if (DY.field_type != 18 || DY.field_favProto.ppH.size() > 1) {
                    Iterator<aml> it = DY.field_favProto.ppH.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            aml next = it.next();
                            switch (next.dataType) {
                                case 2:
                                    str = a(next);
                                    if (!s.YS(str)) {
                                        String d2 = d(next);
                                        if (!s.YS(d2)) {
                                            if (!next.Lvj) {
                                                if (!next.Lvo) {
                                                    str = "";
                                                    break;
                                                } else {
                                                    a(DY, next, true);
                                                    str = d2;
                                                    break;
                                                }
                                            } else {
                                                a(DY, next);
                                                break;
                                            }
                                        } else {
                                            BitmapUtil.createThumbNail(d2, 150, 150, Bitmap.CompressFormat.JPEG, 90, str, true);
                                            str = a(next);
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
                str = "";
            }
            bVar.thumbPath = str;
            AppMethodBeat.o(103345);
        } else if (hbVar.dLm.dLt == 2) {
            g gVar = new g();
            gVar.field_type = 2;
            aml aml = new aml();
            aml.bgs(ds(aml.toString(), 2));
            String d3 = d(aml);
            aml.bgt(d3);
            aml.ajd(2);
            gVar.field_favProto.ppH.add(aml);
            hbVar.dLn.path = g.t(gVar);
            hbVar.dLn.thumbPath = d3;
            AppMethodBeat.o(103345);
        } else if (hbVar.dLm.dLt == 3) {
            g DY2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
            if (DY2 != null) {
                hbVar.dLn.path = z.aTY() + ";" + DY2.field_fromUser + ";" + DY2.field_updateTime;
            }
            AppMethodBeat.o(103345);
        } else if (hbVar.dLm.dLt == 4) {
            b(hbVar);
            AppMethodBeat.o(103345);
        } else if (hbVar.dLm.dLt == 5) {
            a(hbVar);
            AppMethodBeat.o(103345);
        } else if (hbVar.dLm.dLt == 6) {
            g DY3 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(hbVar.dLm.dFW);
            if (DY3 == null) {
                hbVar.dLn.ret = 0;
                AppMethodBeat.o(103345);
                return;
            }
            hb.b bVar2 = hbVar.dLn;
            if (DY3.field_id <= 0) {
                i2 = 0;
            }
            bVar2.ret = i2;
            AppMethodBeat.o(103345);
        } else {
            g gVar2 = new g();
            gVar2.field_type = 18;
            gVar2.field_favProto = hbVar.dLm.dGb;
            hbVar.dLn.path = g.t(gVar2);
            AppMethodBeat.o(103345);
        }
    }

    public static void a(g gVar, int i2) {
        AppMethodBeat.i(103346);
        if (gVar == null) {
            Log.w("MicroMsg.Fav.FavApiLogic", "modeTag, item info is null");
            AppMethodBeat.o(103346);
            return;
        }
        LinkedList<cps> linkedList = new LinkedList<>();
        cps cps = new cps();
        cps.MvI = 4;
        cps.MvJ = 0;
        linkedList.add(cps);
        LinkedList<cpv> linkedList2 = new LinkedList<>();
        cpv cpv = new cpv();
        cpv.xMo = "favitem.taglist";
        cpv.oUv = 1;
        StringBuffer stringBuffer = new StringBuffer();
        int size = gVar.field_tagProto.Lyo.size();
        for (int i3 = 0; i3 < size; i3++) {
            stringBuffer.append("<tag>").append(Util.escapeStringForXml(gVar.field_tagProto.Lyo.get(i3))).append("</tag>");
        }
        cpv.Cyk = stringBuffer.toString();
        Log.v("MicroMsg.Fav.FavApiLogic", "do net scene mod tag, id=%d, tag=%s", Integer.valueOf(gVar.field_id), cpv.Cyk);
        linkedList2.add(cpv);
        if (gVar.field_id > 0) {
            com.tencent.mm.kernel.g.azz().a(new am(gVar.field_id, linkedList, linkedList2), 0);
            h.i((long) gVar.field_id, size, i2);
            AppMethodBeat.o(103346);
            return;
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getEditService().a(gVar.field_localId, linkedList, linkedList2, i2);
        AppMethodBeat.o(103346);
    }

    public static void b(Context context, String str, Intent intent) {
        AppMethodBeat.i(259581);
        a(context, str, intent, (Bundle) null);
        AppMethodBeat.o(259581);
    }

    public static void a(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.i(103348);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e2) {
                Log.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", e2);
                AppMethodBeat.o(103348);
                return;
            }
        }
        String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.fav";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(MMApplicationContext.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
            context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
            AppMethodBeat.o(103348);
            return;
        }
        intent.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        context.startActivity((Intent) bl2.pG(0), (Bundle) bl2.pG(1));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/fav/api/FavApiLogic", "startFavActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(103348);
    }

    public static void a(Context context, String str, Intent intent, int i2) {
        AppMethodBeat.i(103349);
        a(context, str, intent, i2, null);
        AppMethodBeat.o(103349);
    }

    public static void a(Context context, String str, Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(103350);
        if (intent == null) {
            try {
                intent = new Intent();
            } catch (Exception e2) {
                Log.e("MicroMsg.Fav.FavApiLogic", "Class Not Found when startActivity %s", e2);
                AppMethodBeat.o(103350);
                return;
            }
        }
        String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.fav";
        if (str.startsWith(".")) {
            str = str2 + str;
        }
        intent.setClassName(MMApplicationContext.getPackageName(), str);
        Class.forName(str, false, context.getClassLoader());
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i2, bundle);
        }
        AppMethodBeat.o(103350);
    }

    public static void a(String str, Context context, String str2) {
        AppMethodBeat.i(168687);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.Fav.FavApiLogic", "share image to friend fail, imgPath is null");
            AppMethodBeat.o(168687);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("msg_uuid", str2);
        com.tencent.mm.br.c.f(context, ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.o(168687);
    }

    public static void v(Intent intent, Context context) {
        AppMethodBeat.i(103353);
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 1);
            com.tencent.mm.br.c.b(context, "sns", ".ui.SnsUploadUI", intent);
        }
        AppMethodBeat.o(103353);
    }

    public static void c(String str, Context context) {
        AppMethodBeat.i(103354);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.Fav.FavApiLogic", "shareTextToFriend content null");
            AppMethodBeat.o(103354);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", str);
        intent.putExtra("Retr_Msg_Type", 4);
        intent.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.br.c.f(context, ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.o(103354);
    }

    public static void a(long j2, ams ams, String str, String str2, ArrayList<String> arrayList, Context context) {
        AppMethodBeat.i(103355);
        if (ams == null || context == null) {
            AppMethodBeat.o(103355);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", j2);
        intent.putExtra("kwebmap_slat", ams.lat);
        intent.putExtra("kwebmap_lng", ams.lng);
        intent.putExtra("kPoiName", ams.dWi);
        intent.putExtra("Kwebmap_locaion", ams.label);
        if (ams.dRt >= 0) {
            intent.putExtra("kwebmap_scale", ams.dRt);
        }
        intent.putExtra("kisUsername", str);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("kRemark", str2);
        intent.putExtra("kTags", arrayList);
        intent.putExtra("kFavCanDel", true);
        intent.putExtra("kFavCanRemark", true);
        com.tencent.mm.br.c.b(context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(103355);
    }

    public static String[] a(final g gVar, MMHandler mMHandler) {
        String str;
        String str2 = null;
        AppMethodBeat.i(103356);
        if (gVar == null) {
            Log.w("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            AppMethodBeat.o(103356);
            return null;
        }
        final aml c2 = c(gVar);
        String[] strArr = new String[2];
        AnonymousClass3 r4 = new Runnable() {
            /* class com.tencent.mm.plugin.fav.a.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(103257);
                b.a(gVar, c2);
                AppMethodBeat.o(103257);
            }
        };
        switch (gVar.field_type) {
            case 5:
                anq anq = gVar.field_favProto.LwS;
                if (c2 == null) {
                    if (anq != null) {
                        strArr[1] = anq.thumbUrl;
                        break;
                    }
                } else {
                    if (anq == null) {
                        str = null;
                    } else {
                        str = anq.thumbUrl;
                    }
                    if (Util.isNullOrNil(str)) {
                        str = c2.dFN;
                    }
                    strArr[0] = a(c2);
                    strArr[1] = str;
                    mMHandler.post(r4);
                    break;
                }
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 12:
            case 13:
            case 16:
            case 17:
            default:
                if (c2 != null) {
                    strArr[0] = a(c2);
                    strArr[1] = c2.dFN;
                    mMHandler.post(r4);
                    break;
                }
                break;
            case 10:
                ana ana = gVar.field_favProto.LwU;
                if (ana != null) {
                    strArr[1] = ana.thumbUrl;
                    break;
                }
                break;
            case 11:
                ana ana2 = gVar.field_favProto.LwU;
                if (ana2 != null) {
                    strArr[1] = ana2.thumbUrl;
                    break;
                }
                break;
            case 14:
            case 18:
                if (gVar.field_favProto.ppH != null) {
                    Iterator<aml> it = gVar.field_favProto.ppH.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            aml next = it.next();
                            if (next.dataType == 2) {
                                str2 = d(next);
                                mMHandler.post(r4);
                            } else if (next.dataType == 15) {
                                str2 = a(next);
                                mMHandler.post(r4);
                            }
                        }
                    }
                    strArr[0] = str2;
                }
                strArr[1] = c2.dFN;
                break;
            case 15:
                ank ank = gVar.field_favProto.LwW;
                if (ank != null) {
                    strArr[1] = ank.thumbUrl;
                    break;
                }
                break;
        }
        Log.d("MicroMsg.Fav.FavApiLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", strArr[0], strArr[1], Integer.valueOf(gVar.field_type));
        AppMethodBeat.o(103356);
        return strArr;
    }

    public static final String r(g gVar) {
        int i2;
        AppMethodBeat.i(103357);
        StringBuffer stringBuffer = new StringBuffer();
        switch (gVar.field_type) {
            case 1:
                if (!Util.isNullOrNil(gVar.field_favProto.desc)) {
                    stringBuffer.append(gVar.field_favProto.desc.getBytes().length);
                    break;
                }
                break;
            case 2:
            case 8:
                long j2 = 0;
                Iterator<aml> it = gVar.field_favProto.ppH.iterator();
                while (it.hasNext()) {
                    aml next = it.next();
                    if (next != null) {
                        j2 = next.LvI + j2;
                    } else {
                        j2 = j2;
                    }
                }
                stringBuffer.append(j2);
                break;
            case 3:
            case 4:
            case 16:
                stringBuffer.append(c(gVar).duration);
                break;
            case 5:
                String str = "";
                try {
                    str = gVar.field_favProto.LwS.LyC;
                } catch (Exception e2) {
                }
                stringBuffer.append(str);
                break;
            case 14:
            case 18:
                if (gVar != null) {
                    Iterator<aml> it2 = gVar.field_favProto.ppH.iterator();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    while (it2.hasNext()) {
                        aml next2 = it2.next();
                        switch (next2.dataType) {
                            case 1:
                                if (Util.isNullOrNil(next2.desc)) {
                                    i2 = i3;
                                    break;
                                } else {
                                    i5 = next2.desc.getBytes().length + i5;
                                    continue;
                                }
                            case 2:
                                i4++;
                                continue;
                            case 3:
                            default:
                                i2 = i3 + 1;
                                break;
                            case 4:
                                i6++;
                                continue;
                        }
                        i3 = i2;
                    }
                    String format = String.format("%d:%d:%d:%d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i3));
                    AppMethodBeat.o(103357);
                    return format;
                }
                break;
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(103357);
        return stringBuffer2;
    }

    public static String b(anb anb) {
        AppMethodBeat.i(103358);
        StringBuilder sb = new StringBuilder();
        if (!(anb == null || anb.ppH == null)) {
            Iterator<aml> it = anb.ppH.iterator();
            while (it.hasNext()) {
                sb.append(it.next().dLl).append(";");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(103358);
        return sb2;
    }

    public static boolean cUq() {
        AppMethodBeat.i(168688);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_entry, 0) == 1 || ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_no_support_share_switch, 0) != 1) {
            AppMethodBeat.o(168688);
            return false;
        }
        AppMethodBeat.o(168688);
        return true;
    }

    public static String c(aml aml) {
        AppMethodBeat.i(103258);
        amm amm = aml.Lwh;
        String str = "";
        switch (aml.dataType) {
            case 1:
                str = gE(str, aml.desc);
                break;
            case 2:
            case 3:
            case 7:
            case 9:
            default:
                str = gE(gE(str, amm.title), amm.desc);
                break;
            case 4:
                if (amm.LwW != null) {
                    str = gE(str, amm.LwW.title);
                    break;
                }
                break;
            case 5:
                if (amm.LwS != null) {
                    str = gE(str, amm.LwS.title);
                    break;
                }
                break;
            case 6:
                str = gE(str, amm.remark);
                if (amm.LwQ != null) {
                    str = gE(gE(str, amm.LwQ.dWi), amm.LwQ.label);
                    break;
                }
                break;
            case 8:
                str = gE(str, amm.title);
                break;
            case 10:
            case 11:
                if (amm.LwU != null) {
                    str = gE(gE(str, amm.LwU.title), amm.LwU.desc);
                    break;
                }
                break;
        }
        AppMethodBeat.o(103258);
        return str;
    }

    public static void a(g gVar, aml aml) {
        AppMethodBeat.i(103308);
        if (Util.isNullOrNil(aml.dLl)) {
            AppMethodBeat.o(103308);
            return;
        }
        String arI = arI(aml.dLl);
        c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(arI);
        if (asa != null && asa.field_status == 3) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(asa, "dataId");
            asa = null;
        }
        if (asa == null || asa.field_type != 1) {
            o oVar = new o(a(aml));
            if (!Util.isNullOrNil(aml.Lvk) && !Util.isNullOrNil(aml.iwX) && !oVar.exists()) {
                a(aml, gVar, 1);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(arI);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
            }
            AppMethodBeat.o(103308);
            return;
        }
        asa.field_status = 1;
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, "dataId");
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(arI);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
        AppMethodBeat.o(103308);
    }

    public static String getAppName(Context context, String str) {
        AppMethodBeat.i(103318);
        am.b bVar = am.a.iDo;
        if (bVar != null) {
            String r = bVar.r(context, str);
            AppMethodBeat.o(103318);
            return r;
        }
        AppMethodBeat.o(103318);
        return "";
    }

    public static void a(aml aml, int i2, long j2) {
        AppMethodBeat.i(103329);
        if (Util.isNullOrNil(aml.dLl)) {
            AppMethodBeat.o(103329);
        } else if (Util.isNullOrNil(aml.Lvk) || Util.isNullOrNil(aml.iwX)) {
            AppMethodBeat.o(103329);
        } else {
            String arI = arI(aml.dLl);
            c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(arI);
            if (asa != null && (asa.field_status == 3 || asa.field_status == 4)) {
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(asa, "dataId");
                asa = null;
            }
            if (asa == null || asa.field_type != 1) {
                o oVar = new o(a(aml));
                if (!Util.isNullOrNil(aml.Lvk) && !Util.isNullOrNil(aml.iwX) && !oVar.exists()) {
                    g gVar = new g();
                    gVar.field_localId = j2;
                    gVar.field_id = -1;
                    gVar.field_type = i2;
                    a(aml, gVar, 1);
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(arI);
                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
                }
                AppMethodBeat.o(103329);
                return;
            }
            asa.field_status = 1;
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, "dataId");
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(arI);
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
            AppMethodBeat.o(103329);
        }
    }

    public static void b(aml aml, int i2, long j2) {
        AppMethodBeat.i(103330);
        if (Util.isNullOrNil(aml.dLl)) {
            AppMethodBeat.o(103330);
            return;
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "restart cdndata download, dataId %s", aml.dLl);
        c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(aml.dLl);
        if (asa != null && (asa.field_status == 3 || asa.field_status == 4)) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(asa, "dataId");
            asa = null;
        }
        if (asa == null || asa.field_type != 1) {
            o oVar = new o(d(aml));
            if (!Util.isNullOrNil(aml.Lvp) && !Util.isNullOrNil(aml.KuR) && !oVar.exists()) {
                Log.i("MicroMsg.Fav.FavApiLogic", "klem big img not exist, start download.");
                long currentTimeMillis = System.currentTimeMillis();
                g gVar = new g();
                gVar.field_localId = j2;
                gVar.field_id = -1;
                gVar.field_type = i2;
                a(aml, gVar, 1, true);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(aml.dLl);
                ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
                Log.i("MicroMsg.Fav.FavApiLogic", "insert cdn item use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.o(103330);
            return;
        }
        Log.i("MicroMsg.Fav.FavApiLogic", "klem data not download completed.");
        asa.field_status = 1;
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(asa, "dataId");
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().arY(aml.dLl);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
        AppMethodBeat.o(103330);
    }

    public static void b(String str, Context context) {
        AppMethodBeat.i(103352);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.Fav.FavApiLogic", "share image to timeline fail, filePath is null");
            AppMethodBeat.o(103352);
            return;
        }
        Intent intent = new Intent();
        String str2 = "fav_" + z.aTY() + "_0";
        String JX = ad.JX(str2);
        ad.aVe().G(JX, true).l("prePublishId", str2);
        intent.putExtra("reportSessionId", JX);
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", str);
        com.tencent.mm.br.c.b(context, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.o(103352);
    }
}
