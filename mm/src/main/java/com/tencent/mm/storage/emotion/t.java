package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;

public final class t extends MAutoStorage<SmileyInfo> implements g.a {
    private static final String[] OsN = {"key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", DownloadInfo.FILENAME};
    private static final String[] OsO = {"key"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(SmileyInfo.info, "SmileyInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(105145);
        AppMethodBeat.o(105145);
    }

    public t(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, SmileyInfo.info, "SmileyInfo");
    }

    private t(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.storage.emotion.SmileyInfo> cFJ() {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.t.cFJ():java.util.ArrayList");
    }

    public final boolean bn(ArrayList<SmileyInfo> arrayList) {
        long j2;
        h hVar;
        AppMethodBeat.i(105144);
        if (arrayList == null || arrayList.size() <= 0) {
            Log.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
            AppMethodBeat.o(105144);
            return false;
        }
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            j2 = -1;
            hVar = null;
        }
        this.db.delete("SmileyInfo", null, null);
        Iterator<SmileyInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            insert(it.next());
        }
        int i2 = -1;
        if (hVar != null) {
            i2 = hVar.endTransaction(j2);
        }
        if (i2 >= 0) {
            AppMethodBeat.o(105144);
            return true;
        }
        AppMethodBeat.o(105144);
        return false;
    }
}
