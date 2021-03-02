package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.f.b;
import com.tencent.mm.ui.chatting.k.a;

public class AppBrandHistoryListUI extends MMActivity implements b.AbstractC2093b {
    private b.a Pws;
    private String gAn;
    private TextView gAp;
    private RecyclerView mRecyclerView;
    private ProgressDialog qoU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.chatting.k.c] */
    @Override // com.tencent.mm.ui.chatting.view.a
    public final /* bridge */ /* synthetic */ void a(b.a aVar) {
        this.Pws = aVar;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35868);
        super.onCreate(bundle);
        this.gAn = getIntent().getStringExtra("Chat_User");
        new a(this).a(this);
        initView();
        this.Pws.gRY();
        if (ab.Eq(this.gAn)) {
            h.INSTANCE.a(14562, this.gAn, 0);
            AppMethodBeat.o(35868);
            return;
        }
        h.INSTANCE.a(14562, this.gAn, 1);
        AppMethodBeat.o(35868);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(35869);
        setMMTitle(getString(R.string.au_));
        this.gAp = (TextView) findViewById(R.id.heq);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.dpt);
        this.mRecyclerView.setBackgroundColor(-1);
        this.mRecyclerView.setLayoutManager(this.Pws.gRW());
        this.mRecyclerView.setAdapter(this.Pws.bmS(this.gAn));
        this.mRecyclerView.setHasFixedSize(true);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.gallery.AppBrandHistoryListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35867);
                AppBrandHistoryListUI.this.finish();
                AppMethodBeat.o(35867);
                return true;
            }
        });
        AppMethodBeat.o(35869);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(35870);
        super.onDestroy();
        this.Pws.onDetach();
        AppMethodBeat.o(35870);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.gn;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.AbstractC2093b
    public final void gSc() {
        AppMethodBeat.i(35871);
        ku(true);
        AppMethodBeat.o(35871);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.AbstractC2093b
    public final void D(boolean z, int i2) {
        AppMethodBeat.i(35872);
        ku(false);
        Log.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i2));
        if (i2 <= 0) {
            this.gAp.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            this.gAp.setText(getString(R.string.b1r));
            AppMethodBeat.o(35872);
            return;
        }
        this.gAp.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.mRecyclerView.getAdapter().aq(0, i2);
        AppMethodBeat.o(35872);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.AbstractC2093b
    public final void onFinish() {
        AppMethodBeat.i(35873);
        Log.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
        finish();
        AppMethodBeat.o(35873);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.AbstractC2093b
    public final void dr(String str, boolean z) {
    }

    private void ku(boolean z) {
        AppMethodBeat.i(35874);
        Log.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.qoU = q.a(this, getString(R.string.ekc), true, 0, null);
            AppMethodBeat.o(35874);
            return;
        }
        if (this.qoU != null && this.qoU.isShowing()) {
            this.qoU.dismiss();
            this.qoU = null;
        }
        AppMethodBeat.o(35874);
    }
}
