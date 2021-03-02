package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.util.List;

public abstract class FTSBaseUI extends MMSecDataActivity implements d.a, e, FTSEditTextView.a, a.b {
    String query = "";
    private TextView vtJ;
    ListView xaK;
    private d xaL;
    private boolean xaM = false;
    a xaN;
    private String xaO = null;
    private MMHandler xad = new MMHandler() {
        /* class com.tencent.mm.plugin.fts.ui.FTSBaseUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(111874);
            if (message.what == 1 && !Util.isNullOrNil(FTSBaseUI.this.query)) {
                FTSBaseUI.this.dPc();
            }
            AppMethodBeat.o(111874);
        }
    };

    /* access modifiers changed from: protected */
    public abstract d a(e eVar);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.fts.ui.e, com.tencent.mm.ui.MMActivity
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        showMMLogo();
        setMMTitle("");
        setActionbarColor(getContext().getResources().getColor(R.color.f3043a));
        dPh();
        dPf();
    }

    /* access modifiers changed from: protected */
    public void dPh() {
    }

    /* access modifiers changed from: protected */
    public void dPf() {
        this.xaN = new a(this);
        this.xaN.setSearchViewListener(this);
        this.xaN.getFtsEditText().setHint(getHint());
        this.xaN.getFtsEditText().gWY();
        this.xaN.getFtsEditText().setFtsEditTextListener(this);
        this.xaN.getFtsEditText().setCanDeleteTag(false);
        getSupportActionBar().setCustomView(this.xaN);
        this.xaK = (ListView) findViewById(R.id.hf1);
        if (getFooterView() != null) {
            Log.i("MicroMsg.FTS.FTSBaseUI", "searchResultLV addFooterView");
            this.xaK.addFooterView(getFooterView());
        }
        this.xaL = a((e) this);
        this.xaL.xaJ = this;
        this.xaK.setAdapter((ListAdapter) this.xaL);
        this.xaK.setOnScrollListener(this.xaL);
        this.xaK.setOnItemClickListener(this.xaL);
        this.xaK.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSBaseUI.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(111872);
                FTSBaseUI.this.xaN.getFtsEditText().vy.clearFocus();
                FTSBaseUI.this.hideVKB();
                AppMethodBeat.o(111872);
                return false;
            }
        });
        this.vtJ = (TextView) findViewById(R.id.g02);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSBaseUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111873);
                FTSBaseUI.this.finish();
                AppMethodBeat.o(111873);
                return true;
            }
        });
    }

    public String getHint() {
        if (this.xaO != null) {
            return this.xaO;
        }
        return getString(R.string.yn);
    }

    public final void setHint(String str) {
        this.xaO = str;
        this.xaN.getFtsEditText().setHint(getHint());
    }

    /* access modifiers changed from: protected */
    public final ListView dPi() {
        return this.xaK;
    }

    @Override // com.tencent.mm.plugin.fts.ui.e
    public void a(com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
    }

    @Override // com.tencent.mm.ui.search.a.b
    public void onClickBackBtn(View view) {
        hideVKB();
        finish();
    }

    public void onClickCancelBtn(View view) {
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
    }

    public final String getQuery() {
        return this.query;
    }

    /* access modifiers changed from: protected */
    public final void v(String str, List<a.c> list) {
        this.query = str;
        this.xaN.getFtsEditText().O(str, list);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        if (bVar == FTSEditTextView.b.UserInput) {
            String ayr = com.tencent.mm.plugin.fts.a.d.ayr(str);
            if (Util.isNullOrNil(this.query) || !this.query.equals(ayr)) {
                ayM(ayr);
                return;
            }
            Log.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", this.query, ayr);
        }
    }

    /* access modifiers changed from: protected */
    public void ayM(String str) {
        if (!Util.isNullOrNil(str)) {
            this.query = str;
            this.xad.removeMessages(1);
            this.xad.sendEmptyMessageDelayed(1, 300);
            return;
        }
        stopSearch();
    }

    /* access modifiers changed from: protected */
    public void stopSearch() {
        this.query = "";
        this.xad.removeMessages(1);
        this.xaM = false;
        this.xaL.stopSearch();
        this.xaN.getFtsEditText().setHint(getHint());
        dPm();
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public void onClickClearTextBtn(View view) {
        stopSearch();
        this.xaN.getFtsEditText().awD();
        showVKB();
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public boolean awE() {
        hideVKB();
        this.xaN.getFtsEditText().vy.clearFocus();
        return false;
    }

    /* access modifiers changed from: protected */
    public View getFooterView() {
        return null;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        this.xad.removeMessages(1);
        this.xaL.finish();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void dPc() {
        if (this.xaL != null) {
            this.xaM = true;
            this.xaL.auV(this.query);
            dPj();
        }
    }

    /* access modifiers changed from: protected */
    public void dPj() {
        this.vtJ.setVisibility(8);
        this.xaK.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void dPk() {
        this.vtJ.setVisibility(0);
        this.vtJ.setText(f.a(getString(R.string.gfv), getString(R.string.gfu), this.query));
        this.xaK.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void dPl() {
        this.vtJ.setVisibility(8);
        this.xaK.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void dPm() {
        this.vtJ.setVisibility(8);
        this.xaK.setVisibility(8);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.a
    public void ay(int i2, boolean z) {
        Log.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", Integer.valueOf(i2), Boolean.valueOf(z));
        if (z) {
            if (i2 > 0) {
                dPl();
            } else {
                dPk();
            }
        } else if (i2 > 0) {
            dPl();
        } else {
            dPj();
        }
        if (this.xaM) {
            this.xaM = false;
            this.xaK.setSelection(0);
        }
    }

    public final a dPn() {
        return this.xaN;
    }

    @Override // com.tencent.mm.plugin.fts.ui.e
    public final ListView getListView() {
        return this.xaK;
    }

    public final TextView dPo() {
        return this.vtJ;
    }
}
