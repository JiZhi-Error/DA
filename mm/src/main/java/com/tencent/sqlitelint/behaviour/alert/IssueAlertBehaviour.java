package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.util.SLog;
import java.util.List;

public class IssueAlertBehaviour extends BaseBehaviour {
    private static final String NAME = "SQLiteLint";
    private static final String TAG = "Matrix.IssueAlertBehaviour";
    private static Handler sMainHandler = new Handler(Looper.getMainLooper());
    private final String mConcernedDbPath;
    private final Context mContext;
    private long mLastInsertRowId;

    static {
        AppMethodBeat.i(52905);
        AppMethodBeat.o(52905);
    }

    public IssueAlertBehaviour(Context context, String str) {
        AppMethodBeat.i(52902);
        this.mContext = context;
        this.mConcernedDbPath = str;
        createShortCut(context);
        AppMethodBeat.o(52902);
    }

    @Override // com.tencent.sqlitelint.IOnIssuePublishListener
    public void onPublish(List<SQLiteLintIssue> list) {
        AppMethodBeat.i(52903);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(52903);
            return;
        }
        long lastRowId = IssueStorage.getLastRowId();
        if (lastRowId == this.mLastInsertRowId) {
            SLog.v(TAG, "no new issue", new Object[0]);
            AppMethodBeat.o(52903);
            return;
        }
        this.mLastInsertRowId = lastRowId;
        sMainHandler.post(new Runnable() {
            /* class com.tencent.sqlitelint.behaviour.alert.IssueAlertBehaviour.AnonymousClass1 */
            private byte _hellAccFlag_;

            public void run() {
                AppMethodBeat.i(52901);
                Intent intent = new Intent();
                intent.setClass(IssueAlertBehaviour.this.mContext, CheckResultActivity.class);
                intent.addFlags(268435456);
                intent.putExtra(CheckResultActivity.KEY_DB_LABEL, IssueAlertBehaviour.this.mConcernedDbPath);
                Context context = IssueAlertBehaviour.this.mContext;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/sqlitelint/behaviour/alert/IssueAlertBehaviour$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/sqlitelint/behaviour/alert/IssueAlertBehaviour$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(52901);
            }
        });
        AppMethodBeat.o(52903);
    }

    private static void createShortCut(Context context) {
        AppMethodBeat.i(52904);
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.android.launcher2.settings/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{"SQLiteLint"}, null);
        if (query != null) {
            int count = query.getCount();
            query.close();
            if (count > 0) {
                AppMethodBeat.o(52904);
                return;
            }
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", "SQLiteLint");
        intent.putExtra("duplicate", false);
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.setClassName(context, CheckedDatabaseListActivity.class.getName());
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(context, R.drawable.coi));
        context.sendBroadcast(intent);
        AppMethodBeat.o(52904);
    }
}
