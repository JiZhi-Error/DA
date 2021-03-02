package com.tencent.matrix.c;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.ISQLiteExecutionDelegate;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static Map<String, Boolean> cVe = new HashMap();
    private static SQLiteLintPlugin cVf;

    public static void a(SQLiteDatabase sQLiteDatabase, String str, long j2) {
        if (com.tencent.matrix.b.isInstalled()) {
            if (cVf == null) {
                SQLiteLintPlugin sQLiteLintPlugin = (SQLiteLintPlugin) com.tencent.matrix.b.RG().Y(SQLiteLintPlugin.class);
                cVf = sQLiteLintPlugin;
                if (sQLiteLintPlugin == null) {
                    return;
                }
            }
            if (cVf.isPluginStarted()) {
                Log.v("Matrix.MatrixSQLiteLintManager", "onSQLExecuted  String sql:%s,  timeCost:%d", str, Long.valueOf(j2));
                String path = sQLiteDatabase.getPath();
                if (!cVe.containsKey(path)) {
                    SQLiteLint.InstallEnv installEnv = new SQLiteLint.InstallEnv(path, new a(sQLiteDatabase));
                    SQLiteLint.Options.Builder builder = new SQLiteLint.Options.Builder();
                    builder.setReportBehaviour(true);
                    builder.setAlertBehaviour(false);
                    SQLiteLintConfig.ConcernDb concernDb = new SQLiteLintConfig.ConcernDb(installEnv, builder.build());
                    concernDb.enableAvoidAutoIncrementChecker();
                    concernDb.enableAvoidSelectAllChecker();
                    concernDb.enableExplainQueryPlanChecker();
                    concernDb.enableRedundantIndexChecker();
                    concernDb.enableWithoutRowIdBetterChecker();
                    concernDb.enablePreparedStatementBetterChecker();
                    String concernedDbPath = concernDb.getInstallEnv().getConcernedDbPath();
                    if (concernedDbPath.endsWith("EnMicroMsg.db")) {
                        concernDb.setWhiteListXml(R.xml.as);
                    } else if (concernedDbPath.endsWith("AppBrandComm.db")) {
                        concernDb.setWhiteListXml(R.xml.k);
                    } else if (concernedDbPath.endsWith("SnsMicroMsg.db")) {
                        concernDb.setWhiteListXml(R.xml.d1);
                    }
                    cVf.addConcernedDB(concernDb);
                    cVe.put(path, Boolean.TRUE);
                }
                cVf.notifySqlExecution(path, str, (int) j2);
            }
        }
    }

    static final class a implements ISQLiteExecutionDelegate {
        private final SQLiteDatabase mDb;

        a(SQLiteDatabase sQLiteDatabase) {
            this.mDb = sQLiteDatabase;
        }

        @Override // com.tencent.sqlitelint.ISQLiteExecutionDelegate
        public final Cursor rawQuery(String str, String... strArr) {
            if (this.mDb.isOpen()) {
                return this.mDb.rawQuery(str, strArr);
            }
            Log.w("Matrix.MatrixSQLiteLintManager", "rawQuery db close", new Object[0]);
            return null;
        }

        @Override // com.tencent.sqlitelint.ISQLiteExecutionDelegate
        public final void execSQL(String str) {
            if (!this.mDb.isOpen()) {
                Log.w("Matrix.MatrixSQLiteLintManager", "rawQuery db close", new Object[0]);
            } else {
                this.mDb.execSQL(str);
            }
        }
    }
}
