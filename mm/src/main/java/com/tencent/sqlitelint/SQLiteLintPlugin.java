package com.tencent.sqlitelint;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.e.b;
import com.tencent.matrix.e.c;
import com.tencent.matrix.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.sqlitelint.util.SLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SQLiteLintPlugin extends b {
    private static final String TAG = "Matrix.SQLiteLintPlugin";
    private final SQLiteLintConfig mConfig;
    private Context mContext;

    static /* synthetic */ void access$000(SQLiteLintPlugin sQLiteLintPlugin, SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.i(52875);
        sQLiteLintPlugin.reportMatrixIssue(sQLiteLintIssue);
        AppMethodBeat.o(52875);
    }

    public SQLiteLintPlugin(SQLiteLintConfig sQLiteLintConfig) {
        this.mConfig = sQLiteLintConfig;
    }

    @Override // com.tencent.matrix.e.b
    public void init(Application application, c cVar) {
        AppMethodBeat.i(52868);
        super.init(application, cVar);
        SQLiteLint.init();
        SQLiteLint.setPackageName(application);
        this.mContext = application.getApplicationContext();
        AppMethodBeat.o(52868);
    }

    @Override // com.tencent.matrix.e.b
    public void start() {
        AppMethodBeat.i(52869);
        super.start();
        if (!isSupported()) {
            AppMethodBeat.o(52869);
            return;
        }
        SQLiteLint.setReportDelegate(new IssueReportBehaviour.IReportDelegate() {
            /* class com.tencent.sqlitelint.SQLiteLintPlugin.AnonymousClass1 */

            @Override // com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour.IReportDelegate
            public void report(SQLiteLintIssue sQLiteLintIssue) {
                AppMethodBeat.i(52867);
                if (sQLiteLintIssue == null) {
                    AppMethodBeat.o(52867);
                    return;
                }
                SQLiteLintPlugin.access$000(SQLiteLintPlugin.this, sQLiteLintIssue);
                AppMethodBeat.o(52867);
            }
        });
        List<SQLiteLintConfig.ConcernDb> concernDbList = this.mConfig.getConcernDbList();
        for (int i2 = 0; i2 < concernDbList.size(); i2++) {
            SQLiteLintConfig.ConcernDb concernDb = concernDbList.get(i2);
            String concernedDbPath = concernDb.getInstallEnv().getConcernedDbPath();
            SQLiteLint.install(this.mContext, concernDb.getInstallEnv(), concernDb.getOptions());
            SQLiteLint.setWhiteList(concernedDbPath, concernDb.getWhiteListXmlResId());
            SQLiteLint.enableCheckers(concernedDbPath, concernDb.getEnableCheckerList());
        }
        AppMethodBeat.o(52869);
    }

    @Override // com.tencent.matrix.e.b
    public void stop() {
        AppMethodBeat.i(52870);
        super.stop();
        if (!isSupported()) {
            AppMethodBeat.o(52870);
            return;
        }
        List<SQLiteLintConfig.ConcernDb> concernDbList = this.mConfig.getConcernDbList();
        for (int i2 = 0; i2 < concernDbList.size(); i2++) {
            SQLiteLint.uninstall(concernDbList.get(i2).getInstallEnv().getConcernedDbPath());
        }
        SQLiteLint.setReportDelegate(null);
        AppMethodBeat.o(52870);
    }

    @Override // com.tencent.matrix.e.b
    public void destroy() {
        AppMethodBeat.i(52871);
        super.destroy();
        AppMethodBeat.o(52871);
    }

    @Override // com.tencent.matrix.e.b
    public String getTag() {
        return SharePluginInfo.TAG_PLUGIN;
    }

    public void notifySqlExecution(String str, String str2, int i2) {
        AppMethodBeat.i(52872);
        if (!isPluginStarted()) {
            SLog.i(TAG, "notifySqlExecution isPluginStarted not", new Object[0]);
            AppMethodBeat.o(52872);
            return;
        }
        SQLiteLint.notifySqlExecution(str, str2, i2);
        AppMethodBeat.o(52872);
    }

    public void addConcernedDB(SQLiteLintConfig.ConcernDb concernDb) {
        AppMethodBeat.i(52873);
        if (!isPluginStarted()) {
            SLog.i(TAG, "addConcernedDB isPluginStarted not", new Object[0]);
            AppMethodBeat.o(52873);
        } else if (concernDb == null) {
            AppMethodBeat.o(52873);
        } else {
            this.mConfig.addConcernDB(concernDb);
            String concernedDbPath = concernDb.getInstallEnv().getConcernedDbPath();
            SQLiteLint.install(this.mContext, concernDb.getInstallEnv(), concernDb.getOptions());
            SQLiteLint.setWhiteList(concernedDbPath, concernDb.getWhiteListXmlResId());
            SQLiteLint.enableCheckers(concernedDbPath, concernDb.getEnableCheckerList());
            AppMethodBeat.o(52873);
        }
    }

    private void reportMatrixIssue(SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.i(52874);
        SLog.i(TAG, "reportMatrixIssue type:%d, isNew %b", Integer.valueOf(sQLiteLintIssue.type), Boolean.valueOf(sQLiteLintIssue.isNew));
        if (!sQLiteLintIssue.isNew) {
            AppMethodBeat.o(52874);
            return;
        }
        com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c(sQLiteLintIssue.type);
        cVar.key = sQLiteLintIssue.id;
        JSONObject jSONObject = new JSONObject();
        cVar.cWe = jSONObject;
        try {
            jSONObject.put("machine", a.bj(getApplication()));
            jSONObject.put("id", sQLiteLintIssue.id);
            jSONObject.put("dbPath", sQLiteLintIssue.dbPath);
            jSONObject.put("level", sQLiteLintIssue.level);
            jSONObject.put(SharePluginInfo.ISSUE_KEY_SQL, sQLiteLintIssue.sql);
            jSONObject.put(SharePluginInfo.ISSUE_KEY_TABLE, sQLiteLintIssue.table);
            jSONObject.put("desc", sQLiteLintIssue.desc);
            jSONObject.put("detail", sQLiteLintIssue.detail);
            jSONObject.put("advice", sQLiteLintIssue.advice);
            jSONObject.put("createTime", sQLiteLintIssue.createTime);
            jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, sQLiteLintIssue.extInfo);
            jSONObject.put("sqlTimeCost", sQLiteLintIssue.sqlTimeCost);
            jSONObject.put(SharePluginInfo.ISSUE_KEY_IS_IN_MAIN_THREAD, sQLiteLintIssue.isInMainThread);
        } catch (JSONException e2) {
            SLog.i(TAG, "reportMatrixIssue e:%s", e2.getLocalizedMessage());
        }
        onDetectIssue(cVar);
        AppMethodBeat.o(52874);
    }
}
