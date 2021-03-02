package com.tencent.tmassistantsdk.storage.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadLogTable;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;
import com.tencent.tmassistantsdk.storage.table.TipsInfoLogTable;
import com.tencent.tmassistantsdk.storage.table.UpdateInfoLogTable;
import com.tencent.tmassistantsdk.util.GlobalUtil;

public class AstSDKDBHelper_V2 extends SqliteHelper {
    protected static final String DB_NAME = "tmassistant_sdk_v2.db";
    protected static final int DB_VERSION = 3;
    private static final Class<?>[] TABLESS = {DownloadInfoTable.class, DownloadSettingTable.class, ClientInfoTable.class, TipsInfoLogTable.class, DownloadLogTable.class, UpdateInfoLogTable.class};
    protected static SqliteHelper mInstance = null;

    public AstSDKDBHelper_V2(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    public static synchronized SqliteHelper getInstance() {
        SqliteHelper sqliteHelper;
        Context context;
        synchronized (AstSDKDBHelper_V2.class) {
            AppMethodBeat.i(102429);
            if (mInstance == null && (context = GlobalUtil.getInstance().getContext()) != null) {
                mInstance = new AstSDKDBHelper_V2(context, DB_NAME, null, 3);
            }
            sqliteHelper = mInstance;
            AppMethodBeat.o(102429);
        }
        return sqliteHelper;
    }

    @Override // com.tencent.tmassistantsdk.storage.helper.SqliteHelper
    public int getDBVersion() {
        return 3;
    }

    @Override // com.tencent.tmassistantsdk.storage.helper.SqliteHelper
    public Class<?>[] getTables() {
        return TABLESS;
    }
}
