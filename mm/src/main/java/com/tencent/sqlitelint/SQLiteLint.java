package com.tencent.sqlitelint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import java.util.List;

public class SQLiteLint {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLint.class.desiredAssertionStatus());
    private static final int BEHAVIOUR_ALERT = 1;
    private static final int BEHAVIOUR_REPORT = 2;
    public static String sPackageName = null;
    static IssueReportBehaviour.IReportDelegate sReportDelegate;
    private static SqlExecutionCallbackMode sSqlExecutionCallbackMode = null;

    static {
        AppMethodBeat.i(52836);
        AppMethodBeat.o(52836);
    }

    private SQLiteLint() {
    }

    public static void init() {
        AppMethodBeat.i(197274);
        SQLiteLintNativeBridge.loadLibrary();
        AppMethodBeat.o(197274);
    }

    public static void setSqlExecutionCallbackMode(SqlExecutionCallbackMode sqlExecutionCallbackMode) {
        AppMethodBeat.i(52828);
        if (sSqlExecutionCallbackMode != null) {
            AppMethodBeat.o(52828);
            return;
        }
        sSqlExecutionCallbackMode = sqlExecutionCallbackMode;
        if (sqlExecutionCallbackMode == SqlExecutionCallbackMode.HOOK) {
            SQLite3ProfileHooker.hook();
        }
        AppMethodBeat.o(52828);
    }

    public static SqlExecutionCallbackMode getSqlExecutionCallbackMode() {
        return sSqlExecutionCallbackMode;
    }

    public static void install(Context context, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(52829);
        if (!$assertionsDisabled && sQLiteDatabase == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(52829);
            throw assertionError;
        } else if ($assertionsDisabled || sSqlExecutionCallbackMode != null) {
            SQLiteLintAndroidCoreManager.INSTANCE.install(context, new InstallEnv(sQLiteDatabase.getPath(), new SimpleSQLiteExecutionDelegate(sQLiteDatabase)), Options.LAX);
            AppMethodBeat.o(52829);
        } else {
            AssertionError assertionError2 = new AssertionError("SqlExecutionCallbackMode not set！setSqlExecutionCallbackMode must be called before install");
            AppMethodBeat.o(52829);
            throw assertionError2;
        }
    }

    public static void install(Context context, InstallEnv installEnv, Options options) {
        AppMethodBeat.i(52830);
        if (!$assertionsDisabled && installEnv == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(52830);
            throw assertionError;
        } else if ($assertionsDisabled || sSqlExecutionCallbackMode != null) {
            if (options == null) {
                options = Options.LAX;
            }
            SQLiteLintAndroidCoreManager.INSTANCE.install(context, installEnv, options);
            AppMethodBeat.o(52830);
        } else {
            AssertionError assertionError2 = new AssertionError("SqlExecutionCallbackMode is UNKNOWN！setSqlExecutionCallbackMode must be called before install");
            AppMethodBeat.o(52830);
            throw assertionError2;
        }
    }

    public static void notifySqlExecution(String str, String str2, int i2) {
        AppMethodBeat.i(52831);
        if (SQLiteLintAndroidCoreManager.INSTANCE.get(str) == null) {
            AppMethodBeat.o(52831);
            return;
        }
        SQLiteLintAndroidCoreManager.INSTANCE.get(str).notifySqlExecution(str, str2, (long) i2);
        AppMethodBeat.o(52831);
    }

    public static void uninstall(String str) {
        AppMethodBeat.i(52832);
        SQLiteLintAndroidCoreManager.INSTANCE.get(str).release();
        SQLiteLintAndroidCoreManager.INSTANCE.remove(str);
        AppMethodBeat.o(52832);
    }

    public static void setWhiteList(String str, int i2) {
        AppMethodBeat.i(52833);
        if (SQLiteLintAndroidCoreManager.INSTANCE.get(str) == null) {
            AppMethodBeat.o(52833);
            return;
        }
        SQLiteLintAndroidCoreManager.INSTANCE.get(str).setWhiteList(i2);
        AppMethodBeat.o(52833);
    }

    public static void enableCheckers(String str, List<String> list) {
        AppMethodBeat.i(52834);
        if (SQLiteLintAndroidCoreManager.INSTANCE.get(str) == null) {
            AppMethodBeat.o(52834);
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.o(52834);
        } else {
            SQLiteLintAndroidCoreManager.INSTANCE.get(str).enableCheckers(list);
            AppMethodBeat.o(52834);
        }
    }

    static void setReportDelegate(IssueReportBehaviour.IReportDelegate iReportDelegate) {
        sReportDelegate = iReportDelegate;
    }

    public static void setPackageName(Context context) {
        AppMethodBeat.i(52835);
        if (sPackageName == null) {
            sPackageName = context.getPackageName();
        }
        AppMethodBeat.o(52835);
    }

    public static final class InstallEnv {
        static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteLint.class.desiredAssertionStatus());
        private final String mConcernedDbPath;
        private final ISQLiteExecutionDelegate mSQLiteExecutionDelegate;

        static {
            AppMethodBeat.i(52821);
            AppMethodBeat.o(52821);
        }

        public InstallEnv(String str, ISQLiteExecutionDelegate iSQLiteExecutionDelegate) {
            AppMethodBeat.i(52820);
            if (!$assertionsDisabled && str == null) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(52820);
                throw assertionError;
            } else if ($assertionsDisabled || iSQLiteExecutionDelegate != null) {
                this.mConcernedDbPath = str;
                this.mSQLiteExecutionDelegate = iSQLiteExecutionDelegate;
                AppMethodBeat.o(52820);
            } else {
                AssertionError assertionError2 = new AssertionError();
                AppMethodBeat.o(52820);
                throw assertionError2;
            }
        }

        public final String getConcernedDbPath() {
            return this.mConcernedDbPath;
        }

        public final ISQLiteExecutionDelegate getSQLiteExecutionDelegate() {
            return this.mSQLiteExecutionDelegate;
        }
    }

    public enum SqlExecutionCallbackMode {
        HOOK,
        CUSTOM_NOTIFY;

        public static SqlExecutionCallbackMode valueOf(String str) {
            AppMethodBeat.i(52826);
            SqlExecutionCallbackMode sqlExecutionCallbackMode = (SqlExecutionCallbackMode) Enum.valueOf(SqlExecutionCallbackMode.class, str);
            AppMethodBeat.o(52826);
            return sqlExecutionCallbackMode;
        }

        static {
            AppMethodBeat.i(52827);
            AppMethodBeat.o(52827);
        }
    }

    public static final class Options {
        public static final Options LAX = new Builder().build();
        private int behaviourMask;

        static {
            AppMethodBeat.i(52824);
            AppMethodBeat.o(52824);
        }

        public final boolean isAlertBehaviourEnable() {
            return (this.behaviourMask & 1) > 0;
        }

        public final boolean isReportBehaviourEnable() {
            return (this.behaviourMask & 2) > 0;
        }

        public static final class Builder {
            private int mBehaviourMask;

            public Builder() {
                AppMethodBeat.i(52822);
                this.mBehaviourMask |= 1;
                AppMethodBeat.o(52822);
            }

            public final Builder setAlertBehaviour(boolean z) {
                if (z) {
                    this.mBehaviourMask |= 1;
                } else {
                    this.mBehaviourMask &= -2;
                }
                return this;
            }

            public final Builder setReportBehaviour(boolean z) {
                if (z) {
                    this.mBehaviourMask |= 2;
                } else {
                    this.mBehaviourMask &= -3;
                }
                return this;
            }

            public final Options build() {
                AppMethodBeat.i(52823);
                Options options = new Options();
                options.behaviourMask = this.mBehaviourMask;
                AppMethodBeat.o(52823);
                return options;
            }
        }
    }
}
