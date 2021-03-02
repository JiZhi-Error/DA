package com.tencent.sqlitelint.config;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.SimpleSQLiteExecutionDelegate;
import java.util.ArrayList;
import java.util.List;

public final class SQLiteLintConfig {
    private final List<ConcernDb> sConcernDbList = new ArrayList();

    public SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode sqlExecutionCallbackMode) {
        AppMethodBeat.i(52950);
        SQLiteLint.setSqlExecutionCallbackMode(sqlExecutionCallbackMode);
        AppMethodBeat.o(52950);
    }

    public final void addConcernDB(ConcernDb concernDb) {
        AppMethodBeat.i(52951);
        if (concernDb == null) {
            AppMethodBeat.o(52951);
        } else if (concernDb.mInstallEnv == null) {
            AppMethodBeat.o(52951);
        } else {
            String concernedDbPath = concernDb.mInstallEnv.getConcernedDbPath();
            if (TextUtils.isEmpty(concernedDbPath)) {
                AppMethodBeat.o(52951);
                return;
            }
            for (int i2 = 0; i2 < this.sConcernDbList.size(); i2++) {
                if (concernedDbPath.equals(concernDb.mInstallEnv.getConcernedDbPath())) {
                    AppMethodBeat.o(52951);
                    return;
                }
            }
            this.sConcernDbList.add(concernDb);
            AppMethodBeat.o(52951);
        }
    }

    public final List<ConcernDb> getConcernDbList() {
        return this.sConcernDbList;
    }

    public static final class ConcernDb {
        static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLintConfig.class.desiredAssertionStatus());
        private static final String AVOID_AUTO_INCREMENT_CHECKER_NAME = "AvoidAutoIncrementChecker";
        private static final String AVOID_SELECT_ALL_CHECKER_NAME = "AvoidSelectAllChecker";
        private static final String EXPLAIN_QUERY_PLAN_CHECKER_NAME = "ExplainQueryPlanChecker";
        private static final String PREPARED_STATEMENT_BETTER_CHECKER_NAME = "PreparedStatementBetterChecker";
        private static final String REDUNDANT_INDEX_CHECKER_NAME = "RedundantIndexChecker";
        private static final String WITHOUT_ROWID_BETTER_CHECKER_NAME = "WithoutRowIdBetterChecker";
        private final List<String> mEnableCheckerList = new ArrayList();
        private final SQLiteLint.InstallEnv mInstallEnv;
        private final SQLiteLint.Options mOptions;
        private int mWhiteListXmlResId;

        static {
            AppMethodBeat.i(52949);
            AppMethodBeat.o(52949);
        }

        public ConcernDb(SQLiteLint.InstallEnv installEnv, SQLiteLint.Options options) {
            AppMethodBeat.i(52939);
            this.mInstallEnv = installEnv;
            this.mOptions = options;
            AppMethodBeat.o(52939);
        }

        public ConcernDb(SQLiteDatabase sQLiteDatabase) {
            AppMethodBeat.i(52940);
            if ($assertionsDisabled || sQLiteDatabase != null) {
                this.mInstallEnv = new SQLiteLint.InstallEnv(sQLiteDatabase.getPath(), new SimpleSQLiteExecutionDelegate(sQLiteDatabase));
                this.mOptions = SQLiteLint.Options.LAX;
                AppMethodBeat.o(52940);
                return;
            }
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(52940);
            throw assertionError;
        }

        public final ConcernDb setWhiteListXml(int i2) {
            this.mWhiteListXmlResId = i2;
            return this;
        }

        public final SQLiteLint.InstallEnv getInstallEnv() {
            return this.mInstallEnv;
        }

        public final SQLiteLint.Options getOptions() {
            return this.mOptions;
        }

        public final int getWhiteListXmlResId() {
            return this.mWhiteListXmlResId;
        }

        public final ConcernDb enableAllCheckers() {
            AppMethodBeat.i(52941);
            ConcernDb enableRedundantIndexChecker = enableExplainQueryPlanChecker().enableAvoidSelectAllChecker().enableWithoutRowIdBetterChecker().enableAvoidAutoIncrementChecker().enablePreparedStatementBetterChecker().enableRedundantIndexChecker();
            AppMethodBeat.o(52941);
            return enableRedundantIndexChecker;
        }

        public final ConcernDb enableExplainQueryPlanChecker() {
            AppMethodBeat.i(52942);
            ConcernDb enableChecker = enableChecker(EXPLAIN_QUERY_PLAN_CHECKER_NAME);
            AppMethodBeat.o(52942);
            return enableChecker;
        }

        public final ConcernDb enableAvoidSelectAllChecker() {
            AppMethodBeat.i(52943);
            ConcernDb enableChecker = enableChecker(AVOID_SELECT_ALL_CHECKER_NAME);
            AppMethodBeat.o(52943);
            return enableChecker;
        }

        public final ConcernDb enableWithoutRowIdBetterChecker() {
            AppMethodBeat.i(52944);
            ConcernDb enableChecker = enableChecker(WITHOUT_ROWID_BETTER_CHECKER_NAME);
            AppMethodBeat.o(52944);
            return enableChecker;
        }

        public final ConcernDb enableAvoidAutoIncrementChecker() {
            AppMethodBeat.i(52945);
            ConcernDb enableChecker = enableChecker(AVOID_AUTO_INCREMENT_CHECKER_NAME);
            AppMethodBeat.o(52945);
            return enableChecker;
        }

        public final ConcernDb enablePreparedStatementBetterChecker() {
            AppMethodBeat.i(52946);
            ConcernDb enableChecker = enableChecker(PREPARED_STATEMENT_BETTER_CHECKER_NAME);
            AppMethodBeat.o(52946);
            return enableChecker;
        }

        public final ConcernDb enableRedundantIndexChecker() {
            AppMethodBeat.i(52947);
            ConcernDb enableChecker = enableChecker(REDUNDANT_INDEX_CHECKER_NAME);
            AppMethodBeat.o(52947);
            return enableChecker;
        }

        public final List<String> getEnableCheckerList() {
            return this.mEnableCheckerList;
        }

        private ConcernDb enableChecker(String str) {
            AppMethodBeat.i(52948);
            this.mEnableCheckerList.add(str);
            AppMethodBeat.o(52948);
            return this;
        }
    }
}
