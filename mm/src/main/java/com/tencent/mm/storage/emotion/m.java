package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class m extends MAutoStorage<l> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(l.info, "EmotionDetailInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(105117);
        AppMethodBeat.o(105117);
    }

    public m(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, l.info, "EmotionDetailInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.storagebase.g.a
    public final String getTableName() {
        return "EmotionDetailInfo";
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final l blt(String str) {
        l lVar = null;
        AppMethodBeat.i(105116);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmotionDetailInfoStorage", "getEmotionDetailRespnseByPID failed. productID is null.");
            AppMethodBeat.o(105116);
        } else {
            Cursor query = this.db.query("EmotionDetailInfo", new String[]{"content", "lan"}, "productID=?", new String[]{str}, null, null, null, 2);
            if (query != null && query.moveToFirst()) {
                lVar = new l();
                lVar.field_content = query.getBlob(0);
                lVar.field_lan = query.getString(1);
                lVar.field_productID = str;
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(105116);
        }
        return lVar;
    }

    public final void a(String str, GetEmotionDetailResponse getEmotionDetailResponse, String str2) {
        AppMethodBeat.i(183930);
        if (Util.isNullOrNil(str) || getEmotionDetailResponse == null) {
            Log.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
        }
        try {
            l lVar = new l();
            lVar.field_productID = str;
            lVar.field_content = getEmotionDetailResponse.toByteArray();
            lVar.field_lan = str2;
            if (this.db.replace("EmotionDetailInfo", "productID", lVar.convertTo()) > 0) {
                Log.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", str);
                AppMethodBeat.o(183930);
                return;
            }
            Log.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", str);
            AppMethodBeat.o(183930);
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(183930);
        }
    }
}
