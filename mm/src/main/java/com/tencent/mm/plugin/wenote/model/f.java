package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static String getLengthStr(float f2) {
        AppMethodBeat.i(30298);
        if (f2 < 1024.0f) {
            String format = String.format("%.1fB", Float.valueOf(f2));
            AppMethodBeat.o(30298);
            return format;
        } else if (f2 < 1048576.0f) {
            String format2 = String.format("%.1fKB", Float.valueOf(f2 / 1024.0f));
            AppMethodBeat.o(30298);
            return format2;
        } else if (f2 < 1.07374182E9f) {
            String format3 = String.format("%.1fMB", Float.valueOf((f2 / 1024.0f) / 1024.0f));
            AppMethodBeat.o(30298);
            return format3;
        } else {
            String format4 = String.format("%.1fGB", Float.valueOf(((f2 / 1024.0f) / 1024.0f) / 1024.0f));
            AppMethodBeat.o(30298);
            return format4;
        }
    }

    public static float AO(long j2) {
        float f2 = 1.0f;
        AppMethodBeat.i(30299);
        float f3 = ((float) j2) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        float round = (float) Math.round(f2);
        AppMethodBeat.o(30299);
        return round;
    }

    public static String W(Context context, int i2) {
        AppMethodBeat.i(30300);
        hb hbVar = new hb();
        hbVar.dLm.type = 21;
        hbVar.dLm.context = context;
        hbVar.dLm.dLu = i2;
        EventCenter.instance.publish(hbVar);
        String str = hbVar.dLn.path;
        AppMethodBeat.o(30300);
        return str;
    }

    public static String alR(String str) {
        AppMethodBeat.i(30301);
        String messageDigest = g.getMessageDigest((str + 18 + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(30301);
        return messageDigest;
    }

    public static String a(aml aml) {
        AppMethodBeat.i(30302);
        hb hbVar = new hb();
        hbVar.dLm.type = 27;
        hbVar.dLm.dLo = aml;
        EventCenter.instance.publish(hbVar);
        String str = hbVar.dLn.thumbPath;
        AppMethodBeat.o(30302);
        return str;
    }

    public static String b(aml aml) {
        AppMethodBeat.i(30303);
        hb hbVar = new hb();
        hbVar.dLm.type = 27;
        hbVar.dLm.dLo = aml;
        EventCenter.instance.publish(hbVar);
        String str = hbVar.dLn.path;
        AppMethodBeat.o(30303);
        return str;
    }

    public static com.tencent.mm.plugin.fav.a.g HT(long j2) {
        AppMethodBeat.i(30304);
        com.tencent.mm.plugin.fav.a.g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        AppMethodBeat.o(30304);
        return DY;
    }

    public static void O(long j2, String str) {
        AppMethodBeat.i(30305);
        if (j2 <= 0) {
            AppMethodBeat.o(30305);
            return;
        }
        hb hbVar = new hb();
        hbVar.dLm.type = 34;
        hbVar.dLm.dFW = j2;
        EventCenter.instance.publish(hbVar);
        if (hbVar.dLm.dGb == null) {
            AppMethodBeat.o(30305);
        } else if (hbVar.dLm.dGb.ppH == null || hbVar.dLm.dGb.ppH.size() <= 1) {
            AppMethodBeat.o(30305);
        } else if (hbVar.dLm.dGb.ppH.get(0).Lwp != null) {
            AppMethodBeat.o(30305);
        } else {
            Log.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
            if (!Util.isNullOrNil(str) && s.YS(str)) {
                try {
                    a(hbVar.dLm.dGb, j2, s.boY(str));
                    AppMethodBeat.o(30305);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", e2.getMessage());
                }
            }
            AppMethodBeat.o(30305);
        }
    }

    private static void a(anb anb, long j2, String str) {
        String group;
        int indexOf;
        int indexOf2;
        int indexOf3;
        AppMethodBeat.i(30306);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str) || str.length() == 0) {
            AppMethodBeat.o(30306);
            return;
        }
        Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(str);
        while (matcher.find() && (indexOf = (group = matcher.group()).indexOf("WeNote_")) != -1 && (indexOf2 = group.indexOf("\"", indexOf + 1)) != -1 && (indexOf3 = group.indexOf(" ", indexOf + 1)) != -1) {
            if (indexOf2 >= indexOf3) {
                indexOf2 = indexOf3;
            }
            arrayList.add(group.substring(indexOf, indexOf2));
        }
        LinkedList<aml> linkedList = new LinkedList<>();
        Iterator<aml> it = anb.ppH.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            aml next = it.next();
            if (i3 == 0) {
                next.bgC("WeNoteHtmlFile");
                linkedList.add(next);
                i3++;
            } else {
                if (next.dataType == 1) {
                    next.bgC("-1");
                } else {
                    next.bgC((String) arrayList.get(i2));
                    i2++;
                }
                linkedList.add(next);
            }
        }
        hb hbVar = new hb();
        hbVar.dLm.type = 33;
        hbVar.dLm.dGb = anb;
        hbVar.dLm.dGb.ppH = linkedList;
        hbVar.dLm.dFW = j2;
        EventCenter.instance.publish(hbVar);
        AppMethodBeat.o(30306);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.protocal.protobuf.anb */
    /* JADX WARN: Multi-variable type inference failed */
    public static void be(ArrayList<String> arrayList) {
        boolean z;
        AppMethodBeat.i(30307);
        if (c.gjz().JGL == null) {
            Log.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
            AppMethodBeat.o(30307);
            return;
        }
        anb anb = c.gjz().JGL.JGW;
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (anb == 0) {
            Log.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
            AppMethodBeat.o(30307);
            return;
        }
        Iterator<aml> it = anb.ppH.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (!Util.isNullOrNil(next.Lwp) && !next.Lwp.contains("WeNoteHtmlFile") && !next.Lwp.contains("-1")) {
                arrayList2.add(next.Lwp);
                hashMap.put(next.Lwp, next);
            }
        }
        if (arrayList.size() != arrayList2.size() || !arrayList2.containsAll(arrayList) || !arrayList.containsAll(arrayList2)) {
            arrayList2.removeAll(arrayList);
            if (arrayList2.size() == 0) {
                AppMethodBeat.o(30307);
                return;
            }
            ArrayList<aml> arrayList3 = new ArrayList();
            Iterator<aml> it2 = anb.ppH.iterator();
            while (it2.hasNext()) {
                aml next2 = it2.next();
                if (arrayList2.contains(next2.Lwp)) {
                    arrayList3.add(next2);
                }
            }
            for (aml aml : arrayList3) {
                anb.ppH.remove(aml);
            }
            gjB();
            AppMethodBeat.o(30307);
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList2.size()) {
                z = false;
                break;
            } else if (!((String) arrayList2.get(i2)).trim().equals(arrayList.get(i2).trim())) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                linkedList.add(hashMap.get(arrayList.get(i3)));
            }
            anb.bH(linkedList);
            gjB();
            hashMap.clear();
        }
        AppMethodBeat.o(30307);
    }

    private static void gjB() {
        AppMethodBeat.i(30308);
        hb hbVar = new hb();
        hbVar.dLm.type = 30;
        if (c.gjz().JGL != null) {
            hbVar.dLm.dGb = c.gjz().JGL.JGW;
            EventCenter.instance.publish(hbVar);
            c.gjz().JGL.bbO(hbVar.dLn.path);
        }
        AppMethodBeat.o(30308);
    }
}
