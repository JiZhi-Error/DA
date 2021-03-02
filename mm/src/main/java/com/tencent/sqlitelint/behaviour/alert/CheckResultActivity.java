package com.tencent.sqlitelint.behaviour.alert;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckResultActivity extends SQLiteLintBaseActivity {
    public static final String KEY_DB_LABEL = "db_label";
    private static final String TAG = "MpApp.CheckResultActivity";
    private CheckResultListAdapter mAdapter;
    private List<SQLiteLintIssue> mCheckResultList;
    private String mDbLabel;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(52886);
        super.onCreate(bundle);
        this.mDbLabel = getIntent().getStringExtra(KEY_DB_LABEL);
        initView();
        refreshData();
        AppMethodBeat.o(52886);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(52887);
        super.onNewIntent(intent);
        refreshData();
        AppMethodBeat.o(52887);
    }

    private void refreshData() {
        AppMethodBeat.i(52888);
        List<SQLiteLintIssue> issueListByDb = IssueStorage.getIssueListByDb(this.mDbLabel);
        if (this.mCheckResultList == null) {
            this.mCheckResultList = issueListByDb;
        } else {
            this.mCheckResultList.clear();
            this.mCheckResultList.addAll(issueListByDb);
        }
        SLog.d(TAG, "refreshData size %d", Integer.valueOf(this.mCheckResultList.size()));
        this.mAdapter.notifyDataSetChanged();
        AppMethodBeat.o(52888);
    }

    private void initView() {
        AppMethodBeat.i(52889);
        setTitle(getString(R.string.b3k, new Object[]{SQLiteLintUtil.extractDbName(this.mDbLabel)}));
        ListView listView = (ListView) findViewById(R.id.ecm);
        this.mAdapter = new CheckResultListAdapter();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.sqlitelint.behaviour.alert.CheckResultActivity.AnonymousClass1 */
            private byte _hellAccFlag_;

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(52880);
                Intent intent = new Intent();
                intent.putExtra(IssueDetailActivity.KEY_ISSUE, (SQLiteLintIssue) adapterView.getItemAtPosition(i2));
                intent.setClass(CheckResultActivity.this.getBaseContext(), IssueDetailActivity.class);
                CheckResultActivity checkResultActivity = CheckResultActivity.this;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(checkResultActivity, bl.axQ(), "com/tencent/sqlitelint/behaviour/alert/CheckResultActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                checkResultActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(checkResultActivity, "com/tencent/sqlitelint/behaviour/alert/CheckResultActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(52880);
            }
        });
        listView.setAdapter((ListAdapter) this.mAdapter);
        this.mAdapter.notifyDataSetChanged();
        AppMethodBeat.o(52889);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public int getLayoutId() {
        return R.layout.bo;
    }

    /* access modifiers changed from: package-private */
    public class CheckResultListAdapter extends BaseAdapter {
        private final LayoutInflater mInflater;

        CheckResultListAdapter() {
            AppMethodBeat.i(52881);
            this.mInflater = LayoutInflater.from(CheckResultActivity.this);
            AppMethodBeat.o(52881);
        }

        public int getCount() {
            AppMethodBeat.i(52882);
            if (CheckResultActivity.this.mCheckResultList == null) {
                AppMethodBeat.o(52882);
                return 0;
            }
            int size = CheckResultActivity.this.mCheckResultList.size();
            AppMethodBeat.o(52882);
            return size;
        }

        public SQLiteLintIssue getItem(int i2) {
            AppMethodBeat.i(52883);
            SQLiteLintIssue sQLiteLintIssue = (SQLiteLintIssue) CheckResultActivity.this.mCheckResultList.get(i2);
            AppMethodBeat.o(52883);
            return sQLiteLintIssue;
        }

        public long getItemId(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            AppMethodBeat.i(52884);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.c5t, viewGroup, false);
                ViewHolder viewHolder2 = new ViewHolder();
                viewHolder2.checkResultTv = (TextView) view.findViewById(R.id.h5p);
                viewHolder2.diagnosisLevelTv = (TextView) view.findViewById(R.id.bpz);
                viewHolder2.timeTv = (TextView) view.findViewById(R.id.in3);
                view.setTag(viewHolder2);
                viewHolder = viewHolder2;
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SQLiteLintIssue item = getItem(i2);
            viewHolder.checkResultTv.setText(String.format("%d、%s", Integer.valueOf(i2 + 1), item.desc));
            viewHolder.timeTv.setText(SQLiteLintUtil.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, item.createTime));
            viewHolder.diagnosisLevelTv.setText(SQLiteLintIssue.getLevelText(item.level, CheckResultActivity.this.getBaseContext()));
            AppMethodBeat.o(52884);
            return view;
        }
    }

    static class ViewHolder {
        public TextView checkResultTv;
        public TextView diagnosisLevelTv;
        public TextView timeTv;

        ViewHolder() {
        }
    }
}
