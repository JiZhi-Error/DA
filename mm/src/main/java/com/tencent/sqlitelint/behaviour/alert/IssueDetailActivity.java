package com.tencent.sqlitelint.behaviour.alert;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public class IssueDetailActivity extends SQLiteLintBaseActivity {
    public static final String KEY_ISSUE = "issue";
    private static final String TAG = "MicroMsg.IssueDetailActivity";

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(52908);
        super.onCreate(bundle);
        initView((SQLiteLintIssue) getIntent().getParcelableExtra(KEY_ISSUE));
        AppMethodBeat.o(52908);
    }

    private void initView(final SQLiteLintIssue sQLiteLintIssue) {
        AppMethodBeat.i(52909);
        if (sQLiteLintIssue == null) {
            AppMethodBeat.o(52909);
            return;
        }
        setTitle(getString(R.string.bmg));
        ((TextView) findViewById(R.id.in3)).setText(SQLiteLintUtil.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, sQLiteLintIssue.createTime));
        ((TextView) findViewById(R.id.bpz)).setText(SQLiteLintIssue.getLevelText(sQLiteLintIssue.level, getBaseContext()));
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.desc)) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.bn3);
            ((TextView) findViewById(R.id.bn6)).setText(sQLiteLintIssue.desc);
            linearLayout.setVisibility(0);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.sqlitelint.behaviour.alert.IssueDetailActivity.AnonymousClass1 */

                public void onClick(View view) {
                    AppMethodBeat.i(52906);
                    SLog.v(IssueDetailActivity.TAG, sQLiteLintIssue.desc.replace("%", "###"), new Object[0]);
                    AppMethodBeat.o(52906);
                }
            });
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.detail)) {
            TextView textView = (TextView) findViewById(R.id.bop);
            textView.setText(sQLiteLintIssue.detail);
            ((LinearLayout) findViewById(R.id.boc)).setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.sqlitelint.behaviour.alert.IssueDetailActivity.AnonymousClass2 */

                public void onClick(View view) {
                    AppMethodBeat.i(52907);
                    SLog.v(IssueDetailActivity.TAG, sQLiteLintIssue.detail.replace("%", "###"), new Object[0]);
                    AppMethodBeat.o(52907);
                }
            });
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.advice)) {
            ((TextView) findViewById(R.id.i8)).setText(sQLiteLintIssue.advice);
            ((LinearLayout) findViewById(R.id.i7)).setVisibility(0);
        }
        if (!SQLiteLintUtil.isNullOrNil(sQLiteLintIssue.extInfo)) {
            ((TextView) findViewById(R.id.c79)).setText(getString(R.string.bmh, new Object[]{sQLiteLintIssue.extInfo}));
            ((LinearLayout) findViewById(R.id.c78)).setVisibility(0);
        }
        AppMethodBeat.o(52909);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public int getLayoutId() {
        return R.layout.bq;
    }
}
