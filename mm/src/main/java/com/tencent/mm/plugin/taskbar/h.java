package com.tencent.mm.plugin.taskbar;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u000fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J/\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u001e\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u001fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteById", "", "id", "", "isNotify", "", "scene", "", "deleteOldestRecordByType", "type", "count", "getById", "getCurrentTabList", "", "getMultiTaskInfoByTabType", "getMultiTaskInfoList", "getTaskCountByType", "getTaskListByType", "insert", "item", "update", "keys", "", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;[Ljava/lang/String;)Z", "Companion", "TaskBarDeleteNotify", "plugin-taskbar_release"})
public final class h extends MAutoStorage<MultiTaskInfo> {
    public static final a FSe = new a((byte) 0);
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(MultiTaskInfo.info, "TaskBarInfo")};
    final ISQLiteDatabase db;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/TaskBarStorage$TaskBarDeleteNotify;", "", "()V", "deleteType", "", "getDeleteType", "()I", "setDeleteType", "(I)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "plugin-taskbar_release"})
    public static final class b {
        public MultiTaskInfo Agu;
        public int FSf;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, MultiTaskInfo.info, "TaskBarInfo", null);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(238430);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(238430);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(238426);
        boolean h2 = h(multiTaskInfo);
        AppMethodBeat.o(238426);
        return h2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(MultiTaskInfo multiTaskInfo, String[] strArr) {
        AppMethodBeat.i(238428);
        boolean a2 = a(multiTaskInfo, strArr);
        AppMethodBeat.o(238428);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/TaskBarStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "plugin-taskbar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(238431);
        AppMethodBeat.o(238431);
    }

    public final boolean h(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(238425);
        p.h(multiTaskInfo, "item");
        Log.i("MicroMsg.TaskBarStorage", "insert:" + multiTaskInfo.field_type + ' ' + multiTaskInfo.field_id + ' ' + multiTaskInfo.erh().title);
        byte[] bArr = multiTaskInfo.field_data;
        if ((bArr != null ? bArr.length : 0) <= 0) {
            Log.w("MicroMsg.TaskBarStorage", "empty data!");
        }
        boolean insertNotify = insertNotify(multiTaskInfo, false);
        doNotify(MStorageEventData.EventType.SINGLE, 2, multiTaskInfo);
        AppMethodBeat.o(238425);
        return insertNotify;
    }

    public final boolean a(MultiTaskInfo multiTaskInfo, String... strArr) {
        int i2;
        byte[] bArr;
        cru erh;
        String str = null;
        AppMethodBeat.i(238427);
        p.h(strArr, "keys");
        StringBuilder append = new StringBuilder("update:").append(multiTaskInfo != null ? Integer.valueOf(multiTaskInfo.field_type) : null).append(' ').append(multiTaskInfo != null ? multiTaskInfo.field_id : null).append(' ');
        if (!(multiTaskInfo == null || (erh = multiTaskInfo.erh()) == null)) {
            str = erh.title;
        }
        Log.i("MicroMsg.TaskBarStorage", append.append(str).toString());
        if (multiTaskInfo == null || (bArr = multiTaskInfo.field_data) == null) {
            i2 = 0;
        } else {
            i2 = bArr.length;
        }
        if (i2 <= 0) {
            Log.w("MicroMsg.TaskBarStorage", "empty data!");
        }
        if (multiTaskInfo == null) {
            AppMethodBeat.o(238427);
            return false;
        }
        boolean updateNotify = updateNotify(multiTaskInfo, false, new String[0]);
        doNotify(MStorageEventData.EventType.SINGLE, 3, multiTaskInfo);
        AppMethodBeat.o(238427);
        return updateNotify;
    }

    public final MultiTaskInfo aGM(String str) {
        AppMethodBeat.i(238429);
        p.h(str, "id");
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM TaskBarInfo WHERE id = ?;", new String[]{str});
        MultiTaskInfo multiTaskInfo = null;
        if (rawQuery.moveToNext()) {
            multiTaskInfo = new MultiTaskInfo();
            multiTaskInfo.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(238429);
        return multiTaskInfo;
    }
}
