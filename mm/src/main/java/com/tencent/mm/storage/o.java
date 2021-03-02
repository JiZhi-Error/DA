package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class o extends MAutoStorage<n> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(n.info, "BackupTempMoveTime")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* bridge */ /* synthetic */ boolean update(long j2, n nVar) {
        AppMethodBeat.i(32837);
        boolean update = super.update(j2, nVar);
        AppMethodBeat.o(32837);
        return update;
    }

    static {
        AppMethodBeat.i(32838);
        AppMethodBeat.o(32838);
    }

    public o(h hVar) {
        super(hVar, n.info, "BackupTempMoveTime", null);
        this.db = hVar;
    }

    public final LinkedList<n> gzF() {
        AppMethodBeat.i(32834);
        LinkedList<n> linkedList = new LinkedList<>();
        Cursor all = getAll();
        if (all == null) {
            Log.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
            AppMethodBeat.o(32834);
        } else {
            while (all.moveToNext()) {
                n nVar = new n();
                nVar.convertFrom(all);
                linkedList.add(nVar);
            }
            all.close();
            AppMethodBeat.o(32834);
        }
        return linkedList;
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        LinkedList linkedList5;
        boolean z;
        AppMethodBeat.i(32835);
        if (getCount() <= 0) {
            linkedList3.addAll(linkedList);
            linkedList4.addAll(linkedList2);
            AppMethodBeat.o(32835);
            return;
        }
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
                LinkedList linkedList6 = new LinkedList();
                String str = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + next + "\" ";
                Log.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:".concat(String.valueOf(str)));
                Cursor rawQuery = this.db.rawQuery(str, null);
                if (rawQuery == null) {
                    Log.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", next);
                    linkedList5 = null;
                } else {
                    while (rawQuery.moveToNext()) {
                        n nVar = new n();
                        nVar.convertFrom(rawQuery);
                        im imVar = new im();
                        imVar.startTime = nVar.field_startTime;
                        imVar.endTime = nVar.field_endTime;
                        linkedList6.add(imVar);
                    }
                    rawQuery.close();
                    linkedList5 = linkedList6;
                }
                if (linkedList5 == null || linkedList5.size() <= 0 || longValue2 < ((im) linkedList5.getFirst()).startTime || longValue > ((im) linkedList5.getLast()).endTime) {
                    linkedList3.add(next);
                    linkedList4.add(Long.valueOf(longValue));
                    linkedList4.add(Long.valueOf(longValue2));
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= linkedList5.size() || longValue > longValue2) {
                            z = z2;
                        } else {
                            im imVar2 = (im) linkedList5.get(i2);
                            if (longValue <= imVar2.endTime) {
                                if (longValue < imVar2.startTime) {
                                    z2 = true;
                                    linkedList3.add(next);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < imVar2.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = imVar2.startTime;
                                        z = true;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(imVar2.startTime));
                                }
                                longValue = imVar2.endTime;
                            }
                            i2++;
                        }
                    }
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
        AppMethodBeat.o(32835);
    }

    public final boolean aHo() {
        AppMethodBeat.i(32836);
        boolean execSQL = this.db.execSQL("BackupTempMoveTime", "delete from BackupTempMoveTime");
        Log.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", Boolean.valueOf(execSQL));
        AppMethodBeat.o(32836);
        return execSQL;
    }
}
