package com.tencent.mm.storage;

import android.database.Cursor;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends MAutoStorage<j> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(j.info, "BackupMoveTime")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* bridge */ /* synthetic */ boolean update(long j2, j jVar) {
        AppMethodBeat.i(32823);
        boolean update = super.update(j2, jVar);
        AppMethodBeat.o(32823);
        return update;
    }

    static {
        AppMethodBeat.i(32824);
        AppMethodBeat.o(32824);
    }

    public k(h hVar) {
        super(hVar, j.info, "BackupMoveTime", null);
        AppMethodBeat.i(32818);
        this.db = hVar;
        long currentTimeMillis = System.currentTimeMillis();
        long beginTransaction = hVar.beginTransaction(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList("CREATE INDEX IF NOT EXISTS DeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )"));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hVar.execSQL("BackupMoveTime", (String) arrayList.get(i2));
        }
        Log.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        hVar.endTransaction(beginTransaction);
        Log.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(32818);
    }

    public final void a(String str, LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        in inVar;
        boolean z;
        AppMethodBeat.i(NativeBitmapStruct.GLType.GL_UNSIGNED_SHORT_4_4_4_4);
        Iterator<Long> it = linkedList2.iterator();
        Iterator<String> it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            boolean z2 = false;
            if (it.hasNext()) {
                long longValue = it.next().longValue();
                if (!it.hasNext()) {
                    break;
                }
                long longValue2 = it.next().longValue();
                if (longValue2 == 0) {
                    longValue2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                }
                String str2 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" AND sessionName = \"" + next + "\" ";
                Log.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:".concat(String.valueOf(str2)));
                Cursor rawQuery = this.db.rawQuery(str2, null);
                if (rawQuery == null) {
                    Log.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", str, next);
                    inVar = null;
                } else if (rawQuery.moveToFirst()) {
                    j jVar = new j();
                    jVar.convertFrom(rawQuery);
                    rawQuery.close();
                    inVar = jVar.field_moveTime;
                } else {
                    rawQuery.close();
                    inVar = null;
                }
                if (inVar == null || inVar.KMB.size() <= 0 || longValue2 < inVar.KMB.getFirst().startTime || longValue > inVar.KMB.getLast().endTime) {
                    linkedList3.add(next);
                    linkedList4.add(Long.valueOf(longValue));
                    linkedList4.add(Long.valueOf(longValue2));
                } else {
                    LinkedList<im> linkedList5 = inVar.KMB;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= linkedList5.size() || longValue > longValue2) {
                            z = z2;
                        } else {
                            im imVar = linkedList5.get(i2);
                            if (longValue <= imVar.endTime) {
                                if (longValue < imVar.startTime) {
                                    z2 = true;
                                    linkedList3.add(next);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < imVar.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = imVar.startTime;
                                        z = true;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(imVar.startTime));
                                }
                                longValue = imVar.endTime;
                            }
                            i2++;
                        }
                    }
                    z = z2;
                    if (longValue <= longValue2) {
                        linkedList3.add(next);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                        z = true;
                    }
                    if (!z) {
                        linkedList3.add(next);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                    }
                }
            }
        }
        AppMethodBeat.o(NativeBitmapStruct.GLType.GL_UNSIGNED_SHORT_4_4_4_4);
    }

    public final void i(String str, LinkedList<n> linkedList) {
        HashMap hashMap;
        AppMethodBeat.i(NativeBitmapStruct.GLType.GL_UNSIGNED_SHORT_5_5_5_1);
        Log.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
        HashMap hashMap2 = new HashMap();
        String str2 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" ";
        Log.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:".concat(String.valueOf(str2)));
        Cursor rawQuery = this.db.rawQuery(str2, null);
        if (rawQuery == null) {
            Log.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", str);
            hashMap = hashMap2;
        } else {
            while (rawQuery.moveToNext()) {
                j jVar = new j();
                jVar.convertFrom(rawQuery);
                hashMap2.put(jVar.field_sessionName, jVar);
            }
            rawQuery.close();
            hashMap = hashMap2;
        }
        if (this.db.delete("BackupMoveTime", "deviceId= ? ", new String[]{String.valueOf(str)}) < 0) {
            Log.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", str);
            AppMethodBeat.o(NativeBitmapStruct.GLType.GL_UNSIGNED_SHORT_5_5_5_1);
            return;
        }
        Iterator<n> it = linkedList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            j jVar2 = (j) hashMap.get(next.field_sessionName);
            if (jVar2 == null) {
                im imVar = new im();
                imVar.startTime = next.field_startTime;
                imVar.endTime = next.field_endTime;
                j jVar3 = new j();
                jVar3.field_deviceId = str;
                jVar3.field_sessionName = next.field_sessionName;
                jVar3.field_moveTime = new in();
                jVar3.field_moveTime.KMB = new LinkedList<>();
                jVar3.field_moveTime.KMB.add(imVar);
                hashMap.put(next.field_sessionName, jVar3);
            } else {
                a(jVar2.field_moveTime.KMB, next);
            }
        }
        for (String str3 : hashMap.keySet()) {
            Log.i("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId insert BackupMoveTimeStorage ret[%b], sessionName:%s", Boolean.valueOf(insert((IAutoDBItem) hashMap.get(str3))), str3);
        }
        AppMethodBeat.o(NativeBitmapStruct.GLType.GL_UNSIGNED_SHORT_5_5_5_1);
    }

    private static void a(LinkedList<im> linkedList, n nVar) {
        boolean z;
        AppMethodBeat.i(32821);
        if (nVar.field_startTime > nVar.field_endTime) {
            AppMethodBeat.o(32821);
            return;
        }
        Iterator<im> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            im next = it.next();
            if (nVar.field_startTime < next.endTime) {
                if (nVar.field_endTime < next.startTime) {
                    im imVar = new im();
                    imVar.startTime = nVar.field_startTime;
                    imVar.endTime = nVar.field_endTime;
                    linkedList.add(imVar);
                    z = true;
                } else {
                    if (nVar.field_startTime < next.startTime) {
                        next.startTime = nVar.field_startTime;
                    }
                    if (nVar.field_endTime > next.endTime) {
                        next.endTime = nVar.field_endTime;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            im next2 = it.next();
                            if (nVar.field_endTime <= next2.startTime) {
                                break;
                            } else if (nVar.field_endTime <= next2.endTime) {
                                next.endTime = next2.endTime;
                                it.remove();
                                z = true;
                                break;
                            } else {
                                it.remove();
                            }
                        }
                    }
                    z = true;
                }
            }
        }
        if (!z) {
            im imVar2 = new im();
            imVar2.startTime = nVar.field_startTime;
            imVar2.endTime = nVar.field_endTime;
            linkedList.add(imVar2);
        }
        AppMethodBeat.o(32821);
    }

    public final boolean aHo() {
        AppMethodBeat.i(32822);
        boolean execSQL = this.db.execSQL("BackupMoveTime", "delete from BackupMoveTime");
        Log.i("MicroMsg.BackupMoveTimeStorage", "deleteAllData, result:%b", Boolean.valueOf(execSQL));
        AppMethodBeat.o(32822);
        return execSQL;
    }
}
