package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.f.b;
import com.tencent.mm.ui.chatting.k.d;
import com.tencent.mm.ui.chatting.k.f;
import com.tencent.mm.ui.chatting.k.g;
import com.tencent.mm.ui.chatting.k.h;

@a(3)
public class MediaHistoryListUI extends MMActivity implements b.AbstractC2093b {
    private com.tencent.mm.modelvoiceaddr.ui.b PBw;
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
        AppMethodBeat.i(36379);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.c_), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.gAn = getIntent().getStringExtra("kintent_talker");
        b.a aVar = null;
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 2:
                aVar = new d(this);
                break;
            case 3:
                aVar = new h(this);
                break;
            case 4:
                aVar = new f(this);
                break;
            case 5:
                aVar = new g(this);
                break;
            case 6:
                aVar = new com.tencent.mm.ui.chatting.k.a(this);
                break;
        }
        if (aVar == null) {
            Log.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
            AppMethodBeat.o(36379);
            return;
        }
        aVar.a(this);
        setActionbarColor(android.support.v4.content.b.n(getContext(), R.color.a2r));
        hideActionbarLine();
        initView();
        this.Pws.gRY();
        boolean Eq = ab.Eq(this.gAn);
        bg.aVF();
        ah Ke = c.aSX().Ke(this.gAn);
        if (Eq) {
            if (this.Pws.getType() == 6) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 1, 0, 0, Integer.valueOf(Ke.bax().size()), 1);
                AppMethodBeat.o(36379);
                return;
            } else if (this.Pws.getType() == -1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 0, 1, 0, Integer.valueOf(Ke.bax().size()), 1);
                AppMethodBeat.o(36379);
                return;
            } else if (this.Pws.getType() == 3) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 0, 0, 1, Integer.valueOf(Ke.bax().size()), 1);
                AppMethodBeat.o(36379);
                return;
            } else if (this.Pws.getType() == 5) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 0, 0, 0, Integer.valueOf(Ke.bax().size()), 1, 1);
                AppMethodBeat.o(36379);
                return;
            } else if (this.Pws.getType() == 33) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 0, 0, 0, Integer.valueOf(Ke.bax().size()), 1, 0, 8);
                AppMethodBeat.o(36379);
                return;
            }
        } else if (this.Pws.getType() == 6) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 1, 0, 0, 0, 0);
            AppMethodBeat.o(36379);
            return;
        } else if (this.Pws.getType() == -1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 0, 1, 0, 0, 0);
            AppMethodBeat.o(36379);
            return;
        } else if (this.Pws.getType() == 3) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 0, 0, 1, 0, 0);
            AppMethodBeat.o(36379);
            return;
        } else if (this.Pws.getType() == 5) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
            AppMethodBeat.o(36379);
            return;
        } else if (this.Pws.getType() == 33) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8);
        }
        AppMethodBeat.o(36379);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(36380);
        this.PBw = new com.tencent.mm.modelvoiceaddr.ui.b();
        this.PBw.CK(false);
        this.PBw.a(this.Pws.gSa());
        this.PBw.jxF = false;
        this.gAp = (TextView) findViewById(R.id.heq);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.dpt);
        findViewById(R.id.bes).setBackgroundColor(getResources().getColor(R.color.f3045c));
        this.mRecyclerView.setBackgroundColor(getResources().getColor(R.color.f3045c));
        this.mRecyclerView.setLayoutManager(this.Pws.gRW());
        this.mRecyclerView.a(this.Pws.gRX());
        this.mRecyclerView.setAdapter(this.Pws.bmS(this.gAn));
        this.mRecyclerView.setHasFixedSize(true);
        setMMTitle(this.Pws.bmB());
        AppMethodBeat.o(36380);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(36381);
        super.onDestroy();
        this.Pws.onDetach();
        AppMethodBeat.o(36381);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(36382);
        super.onKeyboardStateChanged();
        if (keyboardState() == 2) {
            this.PBw.clearFocus();
        }
        AppMethodBeat.o(36382);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(36383);
        if (this.PBw != null) {
            this.PBw.a((FragmentActivity) this, menu);
            com.tencent.mm.modelvoiceaddr.ui.b bVar = this.PBw;
            String gSb = this.Pws.gSb();
            if (bVar.Qwh != null && !Util.isNullOrNil(gSb)) {
                bVar.Qwh.setSelectedTag(gSb);
            }
            getContentView().postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(36378);
                    MediaHistoryListUI.this.PBw.clearFocus();
                    AppMethodBeat.o(36378);
                }
            }, 200);
            AppMethodBeat.o(36383);
            return true;
        }
        AppMethodBeat.o(36383);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(36384);
        this.PBw.a((Activity) this, menu);
        AppMethodBeat.o(36384);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(36385);
        if (keyEvent.getAction() == 4) {
            finish();
            overridePendingTransition(0, 0);
            AppMethodBeat.o(36385);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(36385);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(36386);
        super.onBackPressed();
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(36386);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b6x;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.AbstractC2093b
    public final void gSc() {
        AppMethodBeat.i(36387);
        ku(true);
        AppMethodBeat.o(36387);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.AbstractC2093b
    public final void D(boolean z, int i2) {
        AppMethodBeat.i(36388);
        ku(false);
        Log.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", Boolean.valueOf(z), Integer.valueOf(i2));
        if (i2 <= 0) {
            this.gAp.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            this.gAp.setText(getString(R.string.b1r));
            AppMethodBeat.o(36388);
            return;
        }
        this.gAp.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.mRecyclerView.getAdapter().atj.notifyChanged();
        AppMethodBeat.o(36388);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.AbstractC2093b
    public final void onFinish() {
        AppMethodBeat.i(36389);
        Log.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(36389);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.AbstractC2093b
    public final void dr(String str, boolean z) {
        AppMethodBeat.i(36390);
        if (z) {
            String string = getString(R.string.b1v, new Object[]{str});
            this.gAp.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            TextView textView = this.gAp;
            this.gAp.getContext();
            textView.setText(com.tencent.mm.plugin.fts.a.f.b(string, str));
            AppMethodBeat.o(36390);
            return;
        }
        this.gAp.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        AppMethodBeat.o(36390);
    }

    private void ku(boolean z) {
        AppMethodBeat.i(36391);
        Log.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.qoU = q.a(this, getString(R.string.ekc), true, 0, null);
            AppMethodBeat.o(36391);
            return;
        }
        if (this.qoU != null && this.qoU.isShowing()) {
            this.qoU.dismiss();
            this.qoU = null;
        }
        AppMethodBeat.o(36391);
    }
}
