package com.tencent.mm.plugin.exdevice.g.b;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.g.a.f;
import com.tencent.mm.plugin.exdevice.g.a.j;
import com.tencent.mm.plugin.exdevice.g.a.m;
import com.tencent.mm.plugin.exdevice.g.a.n;
import com.tencent.mm.plugin.exdevice.g.b.a.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;
import org.xwalk.core.XWalkFeature;

public final class c implements i {
    public f rCX;
    public f rCY;

    public c() {
        AppMethodBeat.i(23546);
        Log.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
        bg.azz().a(1042, this);
        bg.azz().a(1041, this);
        bg.azz().a(1043, this);
        bg.azz().a(XWalkFeature.INTERFACE_SHOW_HIDE, this);
        AppMethodBeat.o(23546);
    }

    public static void c(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(23547);
        bg.azz().a(new m(str3, str2, i2, str), 0);
        AppMethodBeat.o(23547);
    }

    public static ArrayList<d> anB(String str) {
        ArrayList<d> arrayList = null;
        AppMethodBeat.i(23548);
        Log.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.plugin.exdevice.g.b.b.d cKM = ad.cKM();
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
                AppMethodBeat.o(23548);
            } else {
                String format = String.format("select *, rowid from %s where %s = ? order by %s desc", "HardDeviceRankInfo", "rankID", FirebaseAnalytics.b.SCORE);
                Cursor rawQuery = cKM.db.rawQuery(format, new String[]{Util.nullAs(str, "")}, 2);
                if (rawQuery == null) {
                    Log.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    AppMethodBeat.o(23548);
                } else {
                    if (rawQuery.moveToFirst()) {
                        arrayList = new ArrayList<>();
                        do {
                            d dVar = new d();
                            dVar.convertFrom(rawQuery);
                            arrayList.add(dVar);
                        } while (rawQuery.moveToNext());
                    } else {
                        Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    }
                    rawQuery.close();
                    AppMethodBeat.o(23548);
                }
            }
        } else {
            Log.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
            AppMethodBeat.o(23548);
        }
        return arrayList;
    }

    public static void f(String str, ArrayList<d> arrayList) {
        int i2;
        AppMethodBeat.i(23549);
        com.tencent.mm.plugin.exdevice.g.b.b.d cKM = ad.cKM();
        Assert.assertTrue(!Util.isNullOrNil(str));
        if (arrayList != null) {
            Cursor rawQuery = cKM.db.rawQuery(String.format("select COUNT(*) from %s where %s = ?", "HardDeviceRankInfo", "rankID"), new String[]{Util.nullAs(str, "")}, 2);
            if (rawQuery == null) {
                Log.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                i2 = 0;
            } else {
                if (rawQuery.moveToFirst()) {
                    i2 = rawQuery.getInt(0);
                } else {
                    Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    i2 = 0;
                }
                rawQuery.close();
            }
            if (i2 == 0) {
                Iterator<d> it = arrayList.iterator();
                while (it.hasNext()) {
                    cKM.a(it.next(), false);
                }
                AppMethodBeat.o(23549);
                return;
            }
            Iterator<d> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                cKM.b(it2.next(), false);
            }
            AppMethodBeat.o(23549);
            return;
        }
        Log.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
        AppMethodBeat.o(23549);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(23550);
        Log.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (qVar instanceof j) {
            if (!(i2 == 0 && i3 == 0)) {
                Log.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
                AppMethodBeat.o(23550);
                return;
            }
        } else if (qVar instanceof m) {
            if (!(i2 == 0 && i3 == 0)) {
                Log.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
                AppMethodBeat.o(23550);
                return;
            }
        } else if ((qVar instanceof n) && !(i2 == 0 && i3 == 0)) {
            e.INSTANCE.idkeyStat(323, 0, 1, false);
            Log.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
        }
        AppMethodBeat.o(23550);
    }
}
