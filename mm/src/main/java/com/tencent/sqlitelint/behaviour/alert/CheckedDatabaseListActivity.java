package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
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
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.behaviour.persistence.SQLiteLintDbHelper;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckedDatabaseListActivity extends SQLiteLintBaseActivity {
    private static final String TAG = "SQLiteLint.CheckedDatabaseListActivity";
    private CheckedDatabaseListAdapter mListAdapter;
    private ListView mListView;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(52897);
        super.onCreate(bundle);
        SQLiteLintDbHelper.INSTANCE.initialize(this);
        initView();
        AppMethodBeat.o(52897);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(52898);
        super.onResume();
        refreshView();
        AppMethodBeat.o(52898);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.sqlitelint.behaviour.alert.SQLiteLintBaseActivity
    public int getLayoutId() {
        return R.layout.bp;
    }

    private void initView() {
        AppMethodBeat.i(52899);
        setTitle(getString(R.string.b3l));
        this.mListView = (ListView) findViewById(R.id.ecm);
        this.mListAdapter = new CheckedDatabaseListAdapter(this);
        this.mListView.setAdapter((ListAdapter) this.mListAdapter);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.sqlitelint.behaviour.alert.CheckedDatabaseListActivity.AnonymousClass1 */
            private byte _hellAccFlag_;

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(52890);
                String str = (String) adapterView.getItemAtPosition(i2);
                if (SQLiteLintUtil.isNullOrNil(str)) {
                    AppMethodBeat.o(52890);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(CheckedDatabaseListActivity.this, CheckResultActivity.class);
                intent.putExtra(CheckResultActivity.KEY_DB_LABEL, str);
                CheckedDatabaseListActivity checkedDatabaseListActivity = CheckedDatabaseListActivity.this;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(checkedDatabaseListActivity, bl.axQ(), "com/tencent/sqlitelint/behaviour/alert/CheckedDatabaseListActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                checkedDatabaseListActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(checkedDatabaseListActivity, "com/tencent/sqlitelint/behaviour/alert/CheckedDatabaseListActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(52890);
            }
        });
        AppMethodBeat.o(52899);
    }

    private void refreshView() {
        AppMethodBeat.i(52900);
        List<String> dbPathList = IssueStorage.getDbPathList();
        SLog.i(TAG, "refreshView defectiveDbList is %d", Integer.valueOf(dbPathList.size()));
        this.mListAdapter.setData(dbPathList);
        AppMethodBeat.o(52900);
    }

    /* access modifiers changed from: package-private */
    public static class CheckedDatabaseListAdapter extends BaseAdapter {
        private List<String> mDefectiveDbList;
        private final LayoutInflater mInflater;

        CheckedDatabaseListAdapter(Context context) {
            AppMethodBeat.i(52891);
            this.mInflater = LayoutInflater.from(context);
            AppMethodBeat.o(52891);
        }

        public void setData(List<String> list) {
            AppMethodBeat.i(52892);
            this.mDefectiveDbList = list;
            notifyDataSetChanged();
            AppMethodBeat.o(52892);
        }

        public int getCount() {
            AppMethodBeat.i(52893);
            if (this.mDefectiveDbList == null) {
                AppMethodBeat.o(52893);
                return 0;
            }
            int size = this.mDefectiveDbList.size();
            AppMethodBeat.o(52893);
            return size;
        }

        public String getItem(int i2) {
            AppMethodBeat.i(52894);
            String str = this.mDefectiveDbList.get(i2);
            AppMethodBeat.o(52894);
            return str;
        }

        public long getItemId(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            AppMethodBeat.i(52895);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.c5u, viewGroup, false);
                ViewHolder viewHolder2 = new ViewHolder();
                viewHolder2.dbPathTv = (TextView) view.findViewById(R.id.bkt);
                view.setTag(viewHolder2);
                viewHolder = viewHolder2;
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.dbPathTv.setText(getItem(i2));
            AppMethodBeat.o(52895);
            return view;
        }
    }

    static class ViewHolder {
        public TextView dbPathTv;

        ViewHolder() {
        }
    }
}
