package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;

public final class c {
    private static int pkU = 1;
    private static int pkV = 1;

    public static String ahl(String str) {
        AppMethodBeat.i(22644);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(22644);
            return null;
        }
        String[] split = str.split("@bottle:");
        if (split == null || split.length < 2) {
            AppMethodBeat.o(22644);
            return null;
        }
        String str2 = split[1];
        AppMethodBeat.o(22644);
        return str2;
    }

    public static void ahm(String str) {
        a aVar;
        String str2;
        long j2;
        int i2;
        a aVar2 = null;
        AppMethodBeat.i(22645);
        a.jRu.WZ();
        bg.aVF();
        if (com.tencent.mm.model.c.aSQ().aEM(str) != 1) {
            AppMethodBeat.o(22645);
            return;
        }
        bg.aVF();
        ca aEx = com.tencent.mm.model.c.aSQ().aEx(str);
        if (aEx == null || !aEx.field_talker.equals(str)) {
            AppMethodBeat.o(22645);
            return;
        }
        String ahl = ahl(str);
        if (Util.isNullOrNil(ahl)) {
            AppMethodBeat.o(22645);
            return;
        }
        Cursor rawQuery = d.ckU().iFy.rawQuery("select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + Util.escapeSqlValue(String.valueOf(ahl)) + "\"", null);
        if (rawQuery == null) {
            aVar = null;
        } else {
            if (rawQuery.moveToFirst()) {
                aVar2 = new a();
                aVar2.pkQ = rawQuery.getString(0);
                aVar2.bva = rawQuery.getInt(1);
                aVar2.pkR = rawQuery.getString(2);
                aVar2.pkS = rawQuery.getInt(3);
                aVar2.msgType = rawQuery.getInt(4);
                aVar2.pkT = rawQuery.getInt(5);
                aVar2.content = rawQuery.getString(6);
                aVar2.createtime = rawQuery.getLong(7);
                aVar2.iFr = rawQuery.getInt(8);
                aVar2.iWj = rawQuery.getInt(9);
                aVar2.iFt = rawQuery.getString(10);
                aVar2.iFu = rawQuery.getString(11);
            }
            rawQuery.close();
            aVar = aVar2;
        }
        if (aVar != null) {
            if (aVar.pkR == null) {
                str2 = "";
            } else {
                str2 = aVar.pkR;
            }
            if (str2.equals(ahl)) {
                if (aVar.pkS != 1) {
                    AppMethodBeat.o(22645);
                    return;
                }
                ca caVar = new ca();
                caVar.Cy(str);
                if (aEx.field_createTime <= aVar.createtime) {
                    j2 = aEx.field_createTime - 1;
                } else {
                    j2 = aVar.createtime;
                }
                caVar.setCreateTime(j2);
                switch (aVar.msgType) {
                    case 1:
                        i2 = 1;
                        break;
                    case 2:
                        i2 = 3;
                        break;
                    case 3:
                        i2 = 34;
                        break;
                    case 4:
                        i2 = 43;
                        break;
                    default:
                        i2 = -1;
                        break;
                }
                caVar.setType(i2);
                caVar.setStatus(2);
                caVar.nv(1);
                if (caVar.getType() == 34) {
                    caVar.setContent(p.b(z.aTY(), (long) aVar.pkT, false));
                    String str3 = aVar.getContent() + Util.nowMilliSecond();
                    if (s.nw(com.tencent.mm.modelvoice.s.getFullPath(aVar.getContent()), com.tencent.mm.modelvoice.s.getFullPath(str3)) < 0) {
                        Log.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + aVar.getContent());
                        AppMethodBeat.o(22645);
                        return;
                    }
                    caVar.Cz(str3);
                } else {
                    caVar.setContent(aVar.getContent());
                }
                bg.aVF();
                com.tencent.mm.model.c.aSQ().aC(caVar);
                AppMethodBeat.o(22645);
                return;
            }
        }
        AppMethodBeat.o(22645);
    }

    public static void ckS() {
        String[] strArr;
        AppMethodBeat.i(22646);
        b ckU = d.ckU();
        long nowMilliSecond = Util.nowMilliSecond() - 7776000000L;
        Cursor rawQuery = ckU.iFy.rawQuery("select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < ".concat(String.valueOf(nowMilliSecond)), null);
        int count = rawQuery.getCount();
        if (count > 0) {
            strArr = new String[count];
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                if (rawQuery.getInt(1) == 3) {
                    strArr[i2] = rawQuery.getString(0);
                } else {
                    strArr[i2] = null;
                }
            }
        } else {
            strArr = null;
        }
        rawQuery.close();
        if (count > 0) {
            ckU.iFy.delete("bottleinfo1", "createtime< ?", new String[]{String.valueOf(nowMilliSecond)});
        }
        if (strArr == null) {
            AppMethodBeat.o(22646);
            return;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            Log.d("MicroMsg.BottleLogic", "delete path:" + com.tencent.mm.modelvoice.s.getFullPath(strArr[i3]));
            if (!Util.isNullOrNil(com.tencent.mm.modelvoice.s.getFullPath(strArr[i3]))) {
                s.deleteFile(com.tencent.mm.modelvoice.s.getFullPath(strArr[i3]));
            }
        }
        AppMethodBeat.o(22646);
    }

    public static String a(Context context, as asVar) {
        AppMethodBeat.i(22647);
        if (asVar == null) {
            String string = context.getString(R.string.alg);
            AppMethodBeat.o(22647);
            return string;
        } else if (RegionCodeDecoder.bkO(asVar.getCountryCode())) {
            String city = asVar.getCity();
            if (!Util.isNullOrNil(city)) {
                AppMethodBeat.o(22647);
                return city;
            }
            String It = aa.It(asVar.getProvince());
            if (!Util.isNullOrNil(It)) {
                AppMethodBeat.o(22647);
                return It;
            }
            RegionCodeDecoder.gEm();
            String locName = RegionCodeDecoder.getLocName(asVar.getCountryCode());
            AppMethodBeat.o(22647);
            return locName;
        } else {
            String string2 = context.getString(R.string.alg);
            AppMethodBeat.o(22647);
            return string2;
        }
    }
}
