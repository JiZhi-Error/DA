package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/storage/FunctionMsgStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/api/FunctionMsgItem;", "()V", "ALL_FUNCTION_MSG_ITEM_PROJECTION", "", "", "[Ljava/lang/String;", "TABLE_NAME", "TAG", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/storagebase/SqliteDB;", "getDb", "()Lcom/tencent/mm/storagebase/SqliteDB;", "deleteAllHandleFunctionMsg", "", "getAllNeedHandleFunctionMsg", "", "getByFunctionMsgId", "functionMsgId", "updateByFunctionMsgId", "newFunctionMsgItem", "plugin-functionmsg_release"})
public final class bs extends MAutoStorage<i> {
    public static final bs OqA = new bs();
    private static final String[] Oqz = {"*", "rowid"};
    private static final h iFy;

    static {
        AppMethodBeat.i(114155);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        h dataDB = aAh.getDataDB();
        if (dataDB == null) {
            p.hyc();
        }
        iFy = dataDB;
        AppMethodBeat.o(114155);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private bs() {
        /*
            r7 = this;
            r6 = 114154(0x1bdea, float:1.59964E-40)
            com.tencent.mm.kernel.e r0 = com.tencent.mm.kernel.g.aAh()
            java.lang.String r1 = "MMKernel.storage()"
            kotlin.g.b.p.g(r0, r1)
            com.tencent.mm.storagebase.h r0 = r0.getDataDB()
            com.tencent.mm.sdk.storage.ISQLiteDatabase r0 = (com.tencent.mm.sdk.storage.ISQLiteDatabase) r0
            com.tencent.mm.sdk.storage.IAutoDBItem$MAutoDBInfo r1 = com.tencent.mm.api.i.info
            java.lang.String r2 = "FunctionMsgItem"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            java.lang.String r5 = "CREATE INDEX IF NOT EXISTS functionIdIndex ON FunctionMsgItem(functionmsgid)"
            r3[r4] = r5
            r7.<init>(r0, r1, r2, r3)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.bs.<init>():void");
    }

    public static i bkw(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(114150);
        p.h(str, "functionMsgId");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(114150);
            return null;
        }
        Log.i("FunctionMsg.FunctionMsgStorage", "getByFunctionMsgId, functionMsgId: %s", str);
        Cursor query = iFy.query("FunctionMsgItem", Oqz, "functionmsgid=?", new String[]{str}, null, null, null, 2);
        Cursor cursor = query;
        if (query == null) {
            try {
                p.hyc();
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(cursor, th2);
                AppMethodBeat.o(114150);
                throw th;
            }
        }
        if (query.moveToFirst()) {
            i iVar = new i();
            iVar.convertFrom(query);
            b.a(cursor, null);
            AppMethodBeat.o(114150);
            return iVar;
        }
        x xVar = x.SXb;
        b.a(cursor, null);
        AppMethodBeat.o(114150);
        return null;
    }

    public static void a(String str, i iVar) {
        AppMethodBeat.i(114151);
        p.h(str, "functionMsgId");
        p.h(iVar, "newFunctionMsgItem");
        Log.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", str);
        i bkw = bkw(str);
        if (bkw != null) {
            try {
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(iVar.Vn() == null);
                objArr[2] = Boolean.valueOf(bkw.Vn() == null);
                Log.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s", objArr);
                ContentValues convertTo = iVar.convertTo();
                if (convertTo.get("addMsg") == null && bkw.Vn() != null) {
                    de Vn = bkw.Vn();
                    if (Vn == null) {
                        p.hyc();
                    }
                    convertTo.put("addMsg", Vn.toByteArray());
                }
                Log.i("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", Integer.valueOf(iFy.update("FunctionMsgItem", convertTo, "functionmsgid=?", new String[]{str})));
                AppMethodBeat.o(114151);
                return;
            } catch (Exception e2) {
                Log.e("FunctionMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(114151);
    }

    public static List<i> gDb() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(114152);
        Cursor query = iFy.query("FunctionMsgItem", Oqz, "status<=? and opCode!= -1", new String[]{"2"}, null, null, null, 2);
        try {
            Cursor cursor = query;
            ArrayList arrayList = new ArrayList();
            cursor.moveToFirst();
            while (true) {
                p.g(cursor, LocaleUtil.ITALIAN);
                if (!cursor.isAfterLast()) {
                    i iVar = new i();
                    iVar.convertFrom(cursor);
                    arrayList.add(iVar);
                    cursor.moveToNext();
                } else {
                    ArrayList arrayList2 = arrayList;
                    b.a(query, null);
                    AppMethodBeat.o(114152);
                    return arrayList2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(query, th2);
            AppMethodBeat.o(114152);
            throw th;
        }
    }

    public static void gDc() {
        AppMethodBeat.i(114153);
        int delete = iFy.delete("FunctionMsgItem", "status=?", new String[]{"100"});
        Log.i("FunctionMsg.FunctionMsgStorage", "[deleteAllHandleFunctionMsg] ret1:" + delete + " ret2:" + iFy.delete("FunctionMsgItem", "status=?", new String[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL}));
        AppMethodBeat.o(114153);
    }
}
