package com.tencent.mm.plugin.multitask.model;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

public final class a extends MAutoStorage<MultiTaskInfo> {
    public static final C1519a AbX = new C1519a((byte) 0);
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(MultiTaskInfo.info, "MultiTaskInfo")};
    private static final String TAG = TAG;
    public final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, MultiTaskInfo.info, "MultiTaskInfo", null);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(200628);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(200628);
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(200623);
        boolean h2 = h(multiTaskInfo);
        AppMethodBeat.o(200623);
        return h2;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(MultiTaskInfo multiTaskInfo, String[] strArr) {
        AppMethodBeat.i(200625);
        boolean a2 = a(multiTaskInfo, strArr);
        AppMethodBeat.o(200625);
        return a2;
    }

    /* renamed from: com.tencent.mm.plugin.multitask.model.a$a */
    public static final class C1519a {
        private C1519a() {
        }

        public /* synthetic */ C1519a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(200629);
        AppMethodBeat.o(200629);
    }

    public final boolean h(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(200622);
        p.h(multiTaskInfo, "item");
        boolean insertNotify = insertNotify(multiTaskInfo, false);
        if (insertNotify) {
            doNotify(MStorageEventData.EventType.SINGLE, 2, multiTaskInfo);
        }
        b.i(TAG, "insert " + multiTaskInfo.field_id + ' ' + insertNotify, new Object[0]);
        AppMethodBeat.o(200622);
        return insertNotify;
    }

    public final boolean a(MultiTaskInfo multiTaskInfo, String... strArr) {
        AppMethodBeat.i(200624);
        p.h(strArr, "keys");
        boolean updateNotify = updateNotify(multiTaskInfo, false, new String[0]);
        if (updateNotify) {
            doNotify(MStorageEventData.EventType.SINGLE, 3, multiTaskInfo);
        }
        b.i(TAG, "update " + (multiTaskInfo != null ? multiTaskInfo.field_id : null) + ' ' + updateNotify, new Object[0]);
        AppMethodBeat.o(200624);
        return updateNotify;
    }

    public final MultiTaskInfo aGM(String str) {
        AppMethodBeat.i(200626);
        p.h(str, "id");
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM MultiTaskInfo WHERE id = ?;", new String[]{str});
        MultiTaskInfo multiTaskInfo = null;
        if (rawQuery.moveToNext()) {
            multiTaskInfo = new MultiTaskInfo();
            multiTaskInfo.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(200626);
        return multiTaskInfo;
    }

    public final List<MultiTaskInfo> eri() {
        AppMethodBeat.i(200627);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM MultiTaskInfo ORDER BY createTime DESC;", null);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            MultiTaskInfo multiTaskInfo = new MultiTaskInfo();
            multiTaskInfo.convertFrom(rawQuery);
            arrayList.add(multiTaskInfo);
        }
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(200627);
        return arrayList2;
    }
}
