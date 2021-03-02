package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import java.io.IOException;

public final class o extends MAutoStorage<n> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(n.info, "EmotionRewardInfo")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(105120);
        AppMethodBeat.o(105120);
    }

    public o(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, n.info, "EmotionRewardInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final GetEmotionRewardResponse blu(String str) {
        GetEmotionRewardResponse getEmotionRewardResponse = null;
        AppMethodBeat.i(105119);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
            AppMethodBeat.o(105119);
        } else {
            Cursor query = this.db.query("EmotionRewardInfo", new String[]{"content"}, "productID=?", new String[]{str}, null, null, null, 2);
            if (query != null && query.moveToFirst()) {
                try {
                    GetEmotionRewardResponse getEmotionRewardResponse2 = new GetEmotionRewardResponse();
                    getEmotionRewardResponse2.parseFrom(query.getBlob(0));
                    getEmotionRewardResponse = getEmotionRewardResponse2;
                } catch (IOException e2) {
                    Log.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(105119);
        }
        return getEmotionRewardResponse;
    }
}
