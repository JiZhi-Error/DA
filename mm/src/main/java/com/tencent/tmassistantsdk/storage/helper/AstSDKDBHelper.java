package com.tencent.tmassistantsdk.storage.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadLogTable;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;
import com.tencent.tmassistantsdk.storage.table.TipsInfoLogTable;
import com.tencent.tmassistantsdk.util.GlobalUtil;

public class AstSDKDBHelper extends SqliteHelper {
    public static final String DB_NAME = "tmassistant_sdk.db";
    protected static final int DB_VERSION = 2;
    private static final Class<?>[] TABLESS = {DownloadInfoTable.class, DownloadSettingTable.class, ClientInfoTable.class, TipsInfoLogTable.class, DownloadLogTable.class};
    protected static SqliteHelper mInstance = null;

    public AstSDKDBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, DB_NAME, cursorFactory, i2);
    }

    public static synchronized SqliteHelper getInstance() {
        SqliteHelper sqliteHelper;
        Context context;
        synchronized (AstSDKDBHelper.class) {
            AppMethodBeat.i(102428);
            if (mInstance == null && (context = GlobalUtil.getInstance().getContext()) != null) {
                mInstance = new AstSDKDBHelper(context, DB_NAME, null, 2);
            }
            sqliteHelper = mInstance;
            AppMethodBeat.o(102428);
        }
        return sqliteHelper;
    }

    @Override // com.tencent.tmassistantsdk.storage.helper.SqliteHelper
    public int getDBVersion() {
        return 2;
    }

    @Override // com.tencent.tmassistantsdk.storage.helper.SqliteHelper
    public Class<?>[] getTables() {
        return TABLESS;
    }
}
