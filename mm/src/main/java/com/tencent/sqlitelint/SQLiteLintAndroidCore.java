package com.tencent.sqlitelint;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.behaviour.alert.IssueAlertBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.behaviour.persistence.PersistenceBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.SQLiteLintDbHelper;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public class SQLiteLintAndroidCore implements IOnIssuePublishListener {
    private static final String TAG = "SQLiteLint.SQLiteLintAndroidCore";
    private final List<BaseBehaviour> mBehaviors;
    private final String mConcernedDbPath;
    private final Context mContext;
    private final ISQLiteExecutionDelegate mSQLiteExecutionDelegate;

    SQLiteLintAndroidCore(Context context, SQLiteLint.InstallEnv installEnv, SQLiteLint.Options options) {
        AppMethodBeat.i(52837);
        this.mContext = context;
        SQLiteLintDbHelper.INSTANCE.initialize(context);
        this.mConcernedDbPath = installEnv.getConcernedDbPath();
        this.mSQLiteExecutionDelegate = installEnv.getSQLiteExecutionDelegate();
        if (SQLiteLint.getSqlExecutionCallbackMode() == SQLiteLint.SqlExecutionCallbackMode.HOOK) {
            SQLite3ProfileHooker.hook();
        }
        SQLiteLintNativeBridge.nativeInstall(this.mConcernedDbPath);
        this.mBehaviors = new ArrayList();
        this.mBehaviors.add(new PersistenceBehaviour());
        if (options.isAlertBehaviourEnable()) {
            this.mBehaviors.add(new IssueAlertBehaviour(context, this.mConcernedDbPath));
        }
        if (options.isReportBehaviourEnable()) {
            this.mBehaviors.add(new IssueReportBehaviour(SQLiteLint.sReportDelegate));
        }
        AppMethodBeat.o(52837);
    }

    public void addBehavior(BaseBehaviour baseBehaviour) {
        AppMethodBeat.i(52838);
        if (!this.mBehaviors.contains(baseBehaviour)) {
            this.mBehaviors.add(baseBehaviour);
        }
        AppMethodBeat.o(52838);
    }

    public void removeBehavior(BaseBehaviour baseBehaviour) {
        AppMethodBeat.i(52839);
        this.mBehaviors.remove(baseBehaviour);
        AppMethodBeat.o(52839);
    }

    public void release() {
        AppMethodBeat.i(52840);
        if (SQLiteLint.getSqlExecutionCallbackMode() == SQLiteLint.SqlExecutionCallbackMode.HOOK) {
            SQLite3ProfileHooker.unHook();
        }
        SQLiteLintNativeBridge.nativeUninstall(this.mConcernedDbPath);
        AppMethodBeat.o(52840);
    }

    public ISQLiteExecutionDelegate getSQLiteExecutionDelegate() {
        return this.mSQLiteExecutionDelegate;
    }

    public void notifySqlExecution(String str, String str2, long j2) {
        AppMethodBeat.i(52841);
        String str3 = BuildConfig.COMMAND;
        if (j2 >= 8) {
            str3 = SQLiteLintUtil.getThrowableStack(new Throwable());
        }
        SQLiteLintNativeBridge.nativeNotifySqlExecute(str, str2, j2, str3);
        AppMethodBeat.o(52841);
    }

    public void setWhiteList(int i2) {
        AppMethodBeat.i(52842);
        CheckerWhiteListLogic.setWhiteList(this.mContext, this.mConcernedDbPath, i2);
        AppMethodBeat.o(52842);
    }

    public void enableCheckers(List<String> list) {
        AppMethodBeat.i(52843);
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = list.get(i2);
        }
        SQLiteLintNativeBridge.nativeEnableCheckers(this.mConcernedDbPath, strArr);
        AppMethodBeat.o(52843);
    }

    @Override // com.tencent.sqlitelint.IOnIssuePublishListener
    public void onPublish(List<SQLiteLintIssue> list) {
        AppMethodBeat.i(52844);
        for (SQLiteLintIssue sQLiteLintIssue : list) {
            if (IssueStorage.hasIssue(sQLiteLintIssue.id)) {
                sQLiteLintIssue.isNew = false;
            } else {
                sQLiteLintIssue.isNew = true;
            }
        }
        for (int i2 = 0; i2 < this.mBehaviors.size(); i2++) {
            this.mBehaviors.get(i2).onPublish(list);
        }
        AppMethodBeat.o(52844);
    }
}
