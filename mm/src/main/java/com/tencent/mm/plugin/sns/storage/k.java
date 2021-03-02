package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.e.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;

public final class k extends MAutoStorage<j> {
    private static String Eml = " (snsDraft.extFlag & 2 == 0 ) ";
    public static String Emm = " (snsDraft.extFlag & 2 != 0 ) ";
    public static String Emn = " order by snsDraft.timestamp desc";
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(j.info, "snsDraft")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(176289);
        AppMethodBeat.o(176289);
    }

    public k(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, j.info, "snsDraft", null);
        AppMethodBeat.i(176285);
        this.db = iSQLiteDatabase;
        Log.i("MicroMsg.SnsDraftStorage", "createDraftStorage " + iSQLiteDatabase + "  " + Thread.currentThread().getId());
        AppMethodBeat.o(176285);
    }

    public final void vk(boolean z) {
        String str;
        AppMethodBeat.i(176286);
        if (z) {
            g.aAi();
            str = (String) g.aAh().azQ().get(ar.a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, (Object) null);
        } else {
            g.aAi();
            str = (String) g.aAh().azQ().get(ar.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, (Object) null);
        }
        if (!Util.isNullOrNil(str)) {
            byte[] bqe = e.bqe(str);
            if (!Util.isNullOrNil(bqe)) {
                if (z) {
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_SNS_OPEN_UPLOAD_NEWTEXT_DRAFT_STRING_SYNC, "");
                    b("draft_text", bqe, 0);
                    AppMethodBeat.o(176286);
                    return;
                }
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_SNS_OPEN_UPLOAD_DRAFT_MEDIA_STRING_SYNC, "");
                b("draft_normal", bqe, 0);
            }
        }
        AppMethodBeat.o(176286);
    }

    public final void b(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(176287);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = bArr == null ? null : Integer.valueOf(bArr.length);
        Log.i("MicroMsg.SnsDraftStorage", "writeDraft: %s, %s", objArr);
        j jVar = new j();
        jVar.field_key = str;
        jVar.field_timestamp = System.currentTimeMillis();
        jVar.field_draft = bArr;
        jVar.field_extFlag = i2;
        super.replace(jVar);
        AppMethodBeat.o(176287);
    }

    public final j aQn(String str) {
        Integer num = null;
        AppMethodBeat.i(176288);
        j jVar = new j();
        Cursor rawQuery = this.db.rawQuery("select *,rowid from snsDraft  where snsDraft.key='" + str + "' limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            jVar.convertFrom(rawQuery);
            rawQuery.close();
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (jVar.field_draft != null) {
                num = Integer.valueOf(jVar.field_draft.length);
            }
            objArr[1] = num;
            Log.i("MicroMsg.SnsDraftStorage", "readDraft: %s, %s", objArr);
            AppMethodBeat.o(176288);
            return jVar;
        }
        rawQuery.close();
        AppMethodBeat.o(176288);
        return null;
    }
}
