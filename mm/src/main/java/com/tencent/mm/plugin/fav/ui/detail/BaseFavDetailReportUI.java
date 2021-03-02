package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.f;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public abstract class BaseFavDetailReportUI extends MMSecDataActivity {
    public h.a thD = new h.a();
    protected boolean thE;
    private String thF = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.thD.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
        this.thD.pHw = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
        this.thD.index = getIntent().getIntExtra("key_detail_fav_index", 0);
        this.thD.query = getIntent().getStringExtra("key_detail_fav_query");
        this.thD.sGF = getIntent().getStringExtra("key_detail_fav_sessionid");
        this.thD.tay = getIntent().getStringExtra("key_detail_fav_tags");
        this.thD.query = this.thD.query == null ? "" : this.thD.query;
        this.thD.sGF = this.thD.sGF == null ? "" : this.thD.sGF;
        this.thD.tay = this.thD.tay == null ? "" : this.thD.tay;
        MMLoadScrollView cWr = cWr();
        if (cWr != null) {
            cWr.setOnTopOrBottomListerner(new MMLoadScrollView.a() {
                /* class com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.MMLoadScrollView.a
                public final void cIe() {
                    BaseFavDetailReportUI.this.thD.taw = true;
                }
            });
            if (cWr instanceof FavDetailScrollView) {
                ((FavDetailScrollView) cWr).setOnScrollChangeListener(new FavDetailScrollView.a() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView.a
                    public final void cWs() {
                        AppMethodBeat.i(107110);
                        BaseFavDetailReportUI.this.showActionbarLine();
                        AppMethodBeat.o(107110);
                    }

                    @Override // com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView.a
                    public final void cWt() {
                        AppMethodBeat.i(107111);
                        BaseFavDetailReportUI.this.hideActionbarLine();
                        AppMethodBeat.o(107111);
                    }
                });
            }
        }
        if (this.thD.scene == 0) {
            Log.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
        }
        setActionbarColor(getContext().getResources().getColor(R.color.afz));
        hideActionbarLine();
    }

    /* access modifiers changed from: protected */
    public MMLoadScrollView cWr() {
        return null;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (Util.isNullOrNil(this.thF)) {
            this.thF = f.bgg().jnZ;
        }
        Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", this.thF);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        long j2;
        this.thD.tan = getActivityBrowseTimeMs();
        String str = f.bgg().jnZ;
        if (!Util.isEqual(getClass().getName(), str) && !Util.isEqual(str, this.thF)) {
            h.a aVar = this.thD;
            long j3 = aVar.tao;
            f bgg = f.bgg();
            String str2 = f.bgg().jnZ;
            if (bgg.jnY != null) {
                j2 = bgg.jnY.get(str2).longValue();
            } else {
                j2 = 0;
            }
            aVar.tao = j2 + j3;
        }
        Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", str, Long.valueOf(this.thD.tan), Long.valueOf(this.thD.tao));
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void H(g gVar) {
        if (gVar != null && this.thD.scene > 0) {
            this.thD.tal = (long) gVar.field_id;
            this.thD.type = gVar.field_type;
            this.thD.source = gVar.field_sourceType;
            this.thD.timestamp = gVar.field_sourceCreateTime / 1000;
            if (this.thD.timestamp == 0) {
                this.thD.timestamp = gVar.field_updateTime / 1000;
            }
            if (this.thD.timestamp == 0) {
                this.thD.timestamp = gVar.field_edittime;
            }
            this.thD.tam = b.r(gVar);
            this.thE = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void Ee(long j2) {
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        if (DY != null) {
            H(DY);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        if (this.thE) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(107112);
                    BaseFavDetailReportUI.this.thD.tax = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().HX((int) BaseFavDetailReportUI.this.thD.tal) + 1;
                    h.a(BaseFavDetailReportUI.this.thD);
                    AppMethodBeat.o(107112);
                }
            }, "BaseFavReport");
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
        e.cVI();
        super.onDestroy();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1 && intent != null) {
            long longExtra = intent.getLongExtra("key_activity_browse_time", 0);
            this.thD.tao += longExtra;
            Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", Long.valueOf(this.thD.tao), Long.valueOf(longExtra));
        }
        super.onActivityResult(i2, i3, intent);
    }
}
