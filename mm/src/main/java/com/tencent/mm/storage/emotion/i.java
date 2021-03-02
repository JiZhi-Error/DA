package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;

public final class i extends MAutoStorage<h> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(h.info, "EmojiSuggestDescInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(105107);
        AppMethodBeat.o(105107);
    }

    public i(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, h.info, "EmojiSuggestDescInfo");
    }

    private i(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final boolean bm(ArrayList<ArrayList<String>> arrayList) {
        long j2;
        h hVar;
        AppMethodBeat.i(105106);
        if (arrayList.isEmpty()) {
            Log.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
            AppMethodBeat.o(105106);
        } else {
            if (this.db instanceof h) {
                h hVar2 = (h) this.db;
                j2 = hVar2.beginTransaction(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                j2 = -1;
                hVar = null;
            }
            this.db.delete("EmojiSuggestDescInfo", "", null);
            Iterator<ArrayList<String>> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                ArrayList<String> next = it.next();
                if (next != null && !next.isEmpty()) {
                    Iterator<String> it2 = next.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        if (!Util.isNullOrNil(next2)) {
                            Log.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", String.valueOf(i2), next2);
                            insert(new h(String.valueOf(i2), next2));
                        }
                    }
                    i2++;
                }
                i2 = i2;
            }
            if (hVar != null) {
                hVar.endTransaction(j2);
            }
            AppMethodBeat.o(105106);
        }
        return false;
    }
}
