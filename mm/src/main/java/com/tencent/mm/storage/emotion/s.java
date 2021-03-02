package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import java.io.IOException;

public final class s extends MAutoStorage<r> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(r.info, "GetEmotionListCache")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(105137);
        AppMethodBeat.o(105137);
    }

    public s(ISQLiteDatabase iSQLiteDatabase) {
        this(iSQLiteDatabase, r.info, "GetEmotionListCache");
    }

    private s(ISQLiteDatabase iSQLiteDatabase, IAutoDBItem.MAutoDBInfo mAutoDBInfo, String str) {
        super(iSQLiteDatabase, mAutoDBInfo, str, null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    private boolean blv(String str) {
        AppMethodBeat.i(105128);
        if (this.db.delete("GetEmotionListCache", "reqType=?", new String[]{str}) > 0) {
            AppMethodBeat.o(105128);
            return true;
        }
        AppMethodBeat.o(105128);
        return false;
    }

    public final boolean a(int i2, GetEmotionListResponse getEmotionListResponse) {
        boolean z = false;
        AppMethodBeat.i(105129);
        if (getEmotionListResponse == null) {
            AppMethodBeat.o(105129);
        } else {
            try {
                this.db.delete("GetEmotionListCache", "reqType=?", new String[]{String.valueOf(i2)});
                r rVar = new r(String.valueOf(i2), getEmotionListResponse.toByteArray());
                Log.d("MicroMsg.emoji.Storage", "insert cache: %d", Integer.valueOf(i2));
                z = insert(rVar);
                AppMethodBeat.o(105129);
            } catch (Exception e2) {
                Log.e("MicroMsg.emoji.Storage", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(105129);
            }
        }
        return z;
    }

    public final GetEmotionListResponse akx(int i2) {
        GetEmotionListResponse getEmotionListResponse = null;
        AppMethodBeat.i(105130);
        Cursor query = this.db.query("GetEmotionListCache", null, "reqType=?", new String[]{String.valueOf(i2)}, null, null, null, 2);
        if (query != null && query.moveToFirst()) {
            r rVar = new r(query);
            try {
                GetEmotionListResponse getEmotionListResponse2 = new GetEmotionListResponse();
                getEmotionListResponse2.parseFrom(rVar.field_cache);
                Log.d("MicroMsg.emoji.Storage", "succed get cache: %d", Integer.valueOf(i2));
                getEmotionListResponse = getEmotionListResponse2;
            } catch (IOException e2) {
                Log.e("MicroMsg.emoji.Storage", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(105130);
        return getEmotionListResponse;
    }

    public final boolean a(String str, bsp bsp) {
        boolean z = false;
        AppMethodBeat.i(105131);
        if (bsp == null) {
            AppMethodBeat.o(105131);
        } else {
            try {
                blv(str);
                z = insert(new r(str, bsp.toByteArray()));
                AppMethodBeat.o(105131);
            } catch (Exception e2) {
                Log.e("MicroMsg.emoji.Storage", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(105131);
            }
        }
        return z;
    }

    public final bsp blw(String str) {
        bsp bsp = null;
        AppMethodBeat.i(105132);
        Cursor query = this.db.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null, 2);
        if (query != null && query.moveToFirst()) {
            r rVar = new r(query);
            try {
                bsp bsp2 = new bsp();
                bsp2.parseFrom(rVar.field_cache);
                Log.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", str);
                bsp = bsp2;
            } catch (IOException e2) {
                Log.e("MicroMsg.emoji.Storage", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(105132);
        return bsp;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.protocal.protobuf.dyv gFr() {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.s.gFr():com.tencent.mm.protocal.protobuf.dyv");
    }

    public final boolean a(dyv dyv) {
        boolean z = false;
        AppMethodBeat.i(105134);
        if (dyv == null) {
            AppMethodBeat.o(105134);
        } else {
            try {
                blv("Smiley_panel_req_type");
                z = insert(new r("Smiley_panel_req_type", dyv.toByteArray()));
                AppMethodBeat.o(105134);
            } catch (Exception e2) {
                Log.e("MicroMsg.emoji.Storage", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(105134);
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.protocal.protobuf.bmq blx(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.s.blx(java.lang.String):com.tencent.mm.protocal.protobuf.bmq");
    }

    public final boolean a(String str, bmq bmq) {
        boolean z = false;
        AppMethodBeat.i(105136);
        if (bmq == null) {
            AppMethodBeat.o(105136);
        } else {
            try {
                blv(str);
                z = insert(new r(str, bmq.toByteArray()));
                AppMethodBeat.o(105136);
            } catch (Exception e2) {
                Log.e("MicroMsg.emoji.Storage", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(105136);
            }
        }
        return z;
    }

    public final byte[] get(String str) {
        byte[] bArr = null;
        AppMethodBeat.i(199826);
        Cursor query = this.db.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                bArr = new r(query).field_cache;
            }
            query.close();
        }
        AppMethodBeat.o(199826);
        return bArr;
    }

    public final void l(String str, byte[] bArr) {
        AppMethodBeat.i(199827);
        replace(new r(str, bArr));
        AppMethodBeat.o(199827);
    }
}
