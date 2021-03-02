package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bg;
import java.util.Iterator;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "EmojiDesignerProduct")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(183928);
        AppMethodBeat.o(183928);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "EmojiDesignerProduct", null);
        this.db = iSQLiteDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.bg akn(int r13) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.b.akn(int):com.tencent.mm.storage.bg");
    }

    public final void a(bg bgVar) {
        AppMethodBeat.i(183927);
        this.db.delete("EmojiDesignerProduct", "designerUin=? ", new String[]{new StringBuilder().append(bgVar.gWW).toString()});
        Iterator<a> it = bgVar.LGy.iterator();
        while (it.hasNext()) {
            this.db.insert("EmojiDesignerProduct", "", it.next().convertTo());
        }
        AppMethodBeat.o(183927);
    }
}
