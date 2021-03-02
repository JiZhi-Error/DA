package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.d;
import com.tencent.mm.plugin.fts.ui.widget.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.s;
import java.util.List;

@a(19)
public abstract class FTSBaseVoiceSearchUI extends MMSecDataActivity implements d.a, e, s.b {
    String query;
    ListView xaK;
    private d xaL;
    private boolean xaM = false;
    protected c xaQ;
    private boolean xaR = true;
    private boolean xaS;
    private MMHandler xad = new MMHandler() {
        /* class com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(111877);
            if (message.what == 1 && !Util.isNullOrNil(FTSBaseVoiceSearchUI.this.query)) {
                FTSBaseVoiceSearchUI.this.dPc();
            }
            AppMethodBeat.o(111877);
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
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        dPh();
        this.xaQ = new c();
        this.xaQ.Qwi = this;
        this.xaQ.xfJ = false;
        this.xaK = (ListView) findViewById(R.id.hf1);
        if (getHeaderView() != null) {
            Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addHeaderView");
            this.xaK.addHeaderView(getHeaderView());
        }
        List<View> dPq = dPq();
        if (dPq != null && dPq.size() > 0) {
            Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView %d", Integer.valueOf(dPq.size()));
            for (View view : dPq) {
                this.xaK.addFooterView(view);
            }
        }
        this.xaL = a((e) this);
        this.xaL.xaJ = this;
        this.xaK.setAdapter((ListAdapter) this.xaL);
        this.xaK.setOnScrollListener(this.xaL);
        this.xaK.setOnItemClickListener(this.xaL);
        this.xaK.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(111875);
                FTSBaseVoiceSearchUI.this.xaQ.clearFocus();
                FTSBaseVoiceSearchUI.this.hideVKB();
                FTSBaseVoiceSearchUI.this.dPp();
                if (!FTSBaseVoiceSearchUI.this.xaR) {
                    AppMethodBeat.o(111875);
                    return true;
                }
                AppMethodBeat.o(111875);
                return false;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111876);
                FTSBaseVoiceSearchUI.this.finish();
                AppMethodBeat.o(111876);
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void dPh() {
    }

    public final void pu(boolean z) {
        Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "enableLV %s", Boolean.valueOf(z));
        this.xaR = z;
    }

    /* access modifiers changed from: protected */
    public void dPp() {
    }

    /* access modifiers changed from: protected */
    public View getHeaderView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public List<View> dPq() {
        return null;
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
        Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
        finish();
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public void SO(String str) {
        Log.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", str);
        if (Util.isNullOrNil(str)) {
            if (!this.xaQ.gXp()) {
                this.xaQ.gXq();
                showVKB();
            }
            dPm();
        }
        String ayr = com.tencent.mm.plugin.fts.a.d.ayr(str);
        if (Util.isNullOrNil(this.query) || !this.query.equals(ayr)) {
            this.query = ayr;
            if (!Util.isNullOrNil(this.query)) {
                this.xad.removeMessages(1);
                this.xad.sendEmptyMessageDelayed(1, 300);
                return;
            }
            stopSearch();
            return;
        }
        Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", this.query, ayr);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public boolean SN(String str) {
        Log.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", str);
        hideVKB();
        if (this.xaQ != null) {
            this.xaQ.clearFocus();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void dPc() {
        this.xaM = true;
        this.xaL.auV(this.query);
        dPj();
    }

    /* access modifiers changed from: protected */
    public void dPj() {
        this.xaK.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void dPk() {
        this.xaK.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void dPl() {
        this.xaK.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void dPm() {
        this.xaK.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void stopSearch() {
        this.xad.removeMessages(1);
        this.xaM = false;
        this.xaL.stopSearch();
        dPm();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        this.xaQ.clearFocus();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        this.xad.removeMessages(1);
        this.xaL.finish();
        super.onDestroy();
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        this.xaQ.a((FragmentActivity) this, menu);
        if (!this.xaS) {
            this.xaQ.CK(true);
            this.xaS = true;
        }
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.xaQ.a((Activity) this, menu);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d.a
    public void ay(int i2, boolean z) {
        Log.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", Integer.valueOf(i2), Boolean.valueOf(z));
        if (z) {
            dPs();
            if (i2 > 0) {
                dPl();
            } else {
                dPk();
            }
        } else if (i2 > 0) {
            dPl();
            dPr();
        } else {
            dPj();
            dPs();
        }
        if (this.xaM) {
            this.xaM = false;
            this.xaK.setSelection(0);
        }
    }

    /* access modifiers changed from: protected */
    public void dPr() {
    }

    /* access modifiers changed from: protected */
    public void dPs() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
    }

    @Override // com.tencent.mm.plugin.fts.ui.e
    public final ListView getListView() {
        return this.xaK;
    }
}
