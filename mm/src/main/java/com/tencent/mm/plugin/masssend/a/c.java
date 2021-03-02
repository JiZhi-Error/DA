package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    private LinkedList<d> zns;

    public final void ehB() {
        a aVar;
        String a2;
        a aVar2 = null;
        AppMethodBeat.i(26352);
        boolean ehD = ehD();
        bg.aVF();
        boolean booleanValue = ((Boolean) com.tencent.mm.model.c.azQ().get(102408, Boolean.FALSE)).booleanValue();
        boolean z = (z.aUl() & 65536) == 0;
        Log.d("MicroMsg.MassSendService", "hadSetTop is %B", Boolean.valueOf(booleanValue));
        if (!z || booleanValue || !ehD) {
            if (!ehD) {
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(102408, Boolean.FALSE);
            }
            AppMethodBeat.o(26352);
            return;
        }
        Log.d("MicroMsg.MassSendService", "set top conversation");
        bg.aVF();
        if (com.tencent.mm.model.c.aST().bjY("masssendapp") == null) {
            bg.aVF();
            if (com.tencent.mm.model.c.aST().bjY("masssendapp") == null) {
                az azVar = new az();
                azVar.setUsername("masssendapp");
                azVar.setContent(MMApplicationContext.getContext().getResources().getString(R.string.bcm));
                azVar.yA(Util.nowMilliSecond() + 2000);
                azVar.nv(0);
                azVar.nt(0);
                bg.aVF();
                com.tencent.mm.model.c.aST().e(azVar);
            }
        } else {
            Cursor rawQuery = h.ehF().iFy.rawQuery("select * from massendinfo ORDER BY createtime DESC  limit 1", null, 2);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.convertFrom(rawQuery);
                } else {
                    aVar = null;
                }
                rawQuery.close();
                aVar2 = aVar;
            }
            if (aVar2 == null) {
                a2 = MMApplicationContext.getContext().getResources().getString(R.string.bcm);
            } else {
                h.ehF();
                a2 = b.a(aVar2);
            }
            az azVar2 = new az();
            azVar2.setUsername("masssendapp");
            azVar2.setContent(a2);
            azVar2.yA(Util.nowMilliSecond() + 2000);
            azVar2.nv(0);
            azVar2.nt(0);
            bg.aVF();
            com.tencent.mm.model.c.aST().a(azVar2, "masssendapp");
        }
        h.INSTANCE.kvStat(10425, "");
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(102409, Long.valueOf(Util.nowMilliSecond()));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(102408, Boolean.TRUE);
        AppMethodBeat.o(26352);
    }

    public static void Ha(long j2) {
        AppMethodBeat.i(26353);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(102409, Long.valueOf(j2));
        AppMethodBeat.o(26353);
    }

    private static String ehC() {
        AppMethodBeat.i(26354);
        if (bg.aAc()) {
            bg.aVF();
            String format = String.format("%s/masssend_%s.ini", com.tencent.mm.model.c.azM(), LocaleUtil.getApplicationLanguage());
            Log.d("MicroMsg.MassSendService", "config file path is %s", format);
            AppMethodBeat.o(26354);
            return format;
        }
        AppMethodBeat.o(26354);
        return "";
    }

    private boolean ehD() {
        AppMethodBeat.i(26355);
        if (this.zns == null) {
            String ehC = ehC();
            byte[] aW = s.aW(ehC, 0, -1);
            if (aW == null) {
                AppMethodBeat.o(26355);
                return false;
            }
            try {
                this.zns = ((e) new e().parseFrom(aW)).znt;
            } catch (Exception e2) {
                s.deleteFile(ehC);
                AppMethodBeat.o(26355);
                return false;
            }
        }
        if (this.zns == null) {
            Log.w("MicroMsg.MassSendService", "info list is empty");
            AppMethodBeat.o(26355);
            return false;
        }
        Log.i("MicroMsg.MassSendService", "info list[%s]", this.zns.toString());
        long nowSecond = Util.nowSecond();
        Iterator<d> it = this.zns.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (((long) next.begin) <= nowSecond && nowSecond <= ((long) next.end)) {
                AppMethodBeat.o(26355);
                return true;
            }
        }
        AppMethodBeat.o(26355);
        return false;
    }

    public final void aDM(String str) {
        AppMethodBeat.i(26356);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(26356);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "Festivals", null);
        if (parseXml == null) {
            AppMethodBeat.o(26356);
            return;
        }
        e eVar = new e();
        int i2 = 0;
        while (true) {
            String str2 = ".Festivals.Festival" + (i2 == 0 ? "" : String.valueOf(i2));
            if (!parseXml.containsKey(str2)) {
                break;
            }
            d dVar = new d();
            dVar.begin = Util.getSeconds(parseXml.get(str2 + ".StartTime"), 0);
            dVar.end = Util.getSeconds(parseXml.get(str2 + ".EndTime"), 0) + Downloads.MAX_RETYR_AFTER;
            eVar.znt.add(dVar);
            i2++;
        }
        eVar.count = eVar.znt.size();
        this.zns = eVar.znt;
        try {
            byte[] byteArray = eVar.toByteArray();
            String ehC = ehC();
            if (Util.isNullOrNil(ehC)) {
                Log.w("MicroMsg.MassSendService", "mass send config file path is null, return");
                AppMethodBeat.o(26356);
                return;
            }
            o oVar = new o(ehC);
            if (!oVar.exists()) {
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(102408, Boolean.FALSE);
            } else {
                if (!s.bhK(aa.z(oVar.mUri)).equals(g.getMessageDigest(byteArray))) {
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(102408, Boolean.FALSE);
                }
            }
            Log.d("MicroMsg.MassSendService", "save to config file : %s", eVar.toString());
            s.f(ehC, byteArray, byteArray.length);
            AppMethodBeat.o(26356);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MassSendService", e2, "", new Object[0]);
            AppMethodBeat.o(26356);
        }
    }
}
