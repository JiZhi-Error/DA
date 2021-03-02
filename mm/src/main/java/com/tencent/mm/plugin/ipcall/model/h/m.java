package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public final class m {
    public static k b(k kVar) {
        AppMethodBeat.i(25563);
        if (kVar == null) {
            AppMethodBeat.o(25563);
            return null;
        }
        Log.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", Long.valueOf(kVar.systemRowid));
        if (kVar.systemRowid != -1) {
            kVar.field_status = 7;
            i.eaz().a(kVar);
        }
        AppMethodBeat.o(25563);
        return kVar;
    }

    public static k a(k kVar, long j2) {
        AppMethodBeat.i(25564);
        if (kVar == null) {
            AppMethodBeat.o(25564);
            return null;
        }
        Log.d("MicroMsg.IPCallRecordStorageLogic", "recordSelfShutdownCall, localId: %d, talkTime: %d", Long.valueOf(kVar.systemRowid), Long.valueOf(j2));
        if (kVar.systemRowid != -1) {
            kVar.field_status = 4;
            kVar.field_duration = j2;
            i.eaz().a(kVar);
        }
        AppMethodBeat.o(25564);
        return kVar;
    }

    public static Cursor aCb(String str) {
        AppMethodBeat.i(25565);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(25565);
            return null;
        }
        c aBV = i.eay().aBV(str);
        if (aBV == null || aBV.systemRowid == -1) {
            AppMethodBeat.o(25565);
            return null;
        }
        long j2 = aBV.systemRowid;
        Cursor query = i.eaz().db.query("IPCallRecord", l.ysL, "addressId=?", new String[]{String.valueOf(j2)}, null, null, "calltime desc limit 4");
        AppMethodBeat.o(25565);
        return query;
    }

    public static ArrayList<k> ebb() {
        Cursor cursor;
        long j2;
        AppMethodBeat.i(25566);
        long currentTimeMillis = System.currentTimeMillis();
        l eaz = i.eaz();
        Calendar instance = Calendar.getInstance();
        instance.add(6, -30);
        long timeInMillis = instance.getTimeInMillis();
        Cursor query = eaz.db.query("IPCallRecord", l.ysL, "calltime>=?", new String[]{String.valueOf(timeInMillis)}, "addressId, phonenumber", null, "calltime desc");
        if (query.getCount() < 30) {
            query.close();
            cursor = i.eaz().db.query("IPCallRecord", l.ysL, null, null, "addressId, phonenumber", null, "calltime desc");
        } else {
            cursor = query;
        }
        Log.d("MicroMsg.IPCallRecordStorageLogic", "finish query used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        HashMap hashMap = new HashMap();
        ArrayList<k> arrayList = new ArrayList<>();
        try {
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast() && arrayList.size() <= 30) {
                    k kVar = new k();
                    kVar.convertFrom(cursor);
                    if (kVar.field_addressId == -1) {
                        c aBW = i.eay().aBW(a.bb(MMApplicationContext.getContext(), kVar.field_phonenumber));
                        if (aBW != null) {
                            l eaz2 = i.eaz();
                            if (eaz2.db instanceof h) {
                                j2 = ((h) eaz2.db).beginTransaction(-1);
                            } else {
                                j2 = -1;
                            }
                            Cursor aCa = i.eaz().aCa(kVar.field_phonenumber);
                            if (aCa.moveToFirst()) {
                                while (!aCa.isAfterLast()) {
                                    k kVar2 = new k();
                                    kVar2.convertFrom(aCa);
                                    kVar2.field_addressId = aBW.systemRowid;
                                    i.eaz().a(kVar2);
                                    aCa.moveToNext();
                                }
                            }
                            l eaz3 = i.eaz();
                            if ((eaz3.db instanceof h) && j2 != -1) {
                                ((h) eaz3.db).endTransaction(j2);
                            }
                            if (!hashMap.containsKey(new StringBuilder().append(kVar.field_addressId).toString())) {
                                hashMap.put(new StringBuilder().append(kVar.field_addressId).toString(), kVar);
                                arrayList.add(kVar);
                            }
                        } else if (!hashMap.containsKey(kVar.field_phonenumber)) {
                            hashMap.put(kVar.field_phonenumber, kVar);
                            arrayList.add(kVar);
                        }
                    } else if (!hashMap.containsKey(new StringBuilder().append(kVar.field_addressId).toString())) {
                        hashMap.put(new StringBuilder().append(kVar.field_addressId).toString(), kVar);
                        arrayList.add(kVar);
                    }
                    cursor.moveToNext();
                }
            }
            cursor.close();
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser error: %s", e2.getMessage());
            cursor.close();
        } catch (Throwable th) {
            cursor.close();
            AppMethodBeat.o(25566);
            throw th;
        }
        Log.d("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser, used: %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(25566);
        return arrayList;
    }
}
