package com.tencent.mm.plugin.topstory.ui.video.list;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.boots.a.b;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.fs.d;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.c;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class TopStoryListVideoUI extends TopStoryBaseVideoUI implements b {
    private ProgressDialog Gpc;
    private View Gpd;
    private View Gpe;
    private View Gpf;
    private Button Gpg;
    View Gph;
    c Gpi;
    View Gpj;
    TopStoryCommentFloatDialog Gpk;
    private boolean Gpl;
    private View Gqa;
    private TextView Gqb;
    private e Gqc;
    private d Gqd;
    private View Gqe;
    private View Gqf;
    View Gqg;
    c Gqh;
    View Gqi;
    private long Gqj = 0;

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126514);
        if (Build.VERSION.SDK_INT >= 28) {
            customfixStatusbar(true);
        }
        super.onCreate(bundle);
        ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(b.pks, 885);
        a.pl(13);
        AppMethodBeat.o(126514);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final void amZ() {
        AppMethodBeat.i(126515);
        super.amZ();
        if (fyD().Nic != null) {
            this.GmT.h(fyD().Nic);
        }
        AppMethodBeat.o(126515);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(126517);
        p.GnV.a(this, i2, i3, intent);
        if (i2 == 10001) {
            RecyclerView.v f2 = d.f(this);
            if (f2 != null && (f2 instanceof h)) {
                ((h) f2).wu(false);
            }
            if (!(intent == null || !intent.hasExtra("isMute") || this.GjJ == null)) {
                ww(intent.getBooleanExtra("isMute", this.GjJ.guh));
            }
            if (!(intent == null || !intent.hasExtra("MOBILE_CHECK_FLAG") || this.GjJ == null)) {
                abW(intent.getIntExtra("MOBILE_CHECK_FLAG", this.GjJ.Nij));
            }
        }
        AppMethodBeat.o(126517);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final void fzm() {
        AppMethodBeat.i(126518);
        super.fzm();
        if (this.Gna) {
            KC();
            AppMethodBeat.o(126518);
            return;
        }
        if (this.GjJ != null) {
            this.GmQ.fzC();
            Intent intent = new Intent();
            intent.putExtra("isMute", this.GjJ.guh);
            intent.putExtra("MOBILE_CHECK_FLAG", this.GjJ.Nij);
            intent.putExtra("key_video_play_info", Util.listToString(this.GmQ.GnU, ";"));
            intent.putExtra("key_search_id", fyD().hes);
            setResult(-1, intent);
        }
        if (!this.GmJ.O(2, false)) {
            finish();
        }
        if (!this.VfU.wu(2)) {
            finish();
        }
        AppMethodBeat.o(126518);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final void initContentView() {
        AppMethodBeat.i(126519);
        super.initContentView();
        this.Gpf = findViewById(R.id.db8);
        this.Gpg = (Button) findViewById(R.id.hcr);
        this.Gqa = findViewById(R.id.ipy);
        this.Gqa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126498);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TopStoryListVideoUI.this.GmS.GnZ && TopStoryListVideoUI.this.GmS.GnY.getItemUIComponent() != null) {
                    TopStoryListVideoUI.this.GmS.GnY.getItemUIComponent().fyy();
                    TopStoryListVideoUI.this.GmS.GnY.getItemUIComponent().fyx();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126498);
            }
        });
        overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
        if (fyD().Nid != null) {
            this.jVO.setVisibility(8);
        }
        this.GmQ.GnS = 2;
        if (!fzr()) {
            this.Gpe.setVisibility(4);
            this.Gpd.setVisibility(4);
        } else if (this.GmP.isConnected()) {
            fzO();
            this.Gpl = false;
            if (fyD().scene != 21 && fyD().Nid == null) {
                this.Gpc = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass6 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(126507);
                        TopStoryListVideoUI.this.finish();
                        AppMethodBeat.o(126507);
                    }
                });
            }
        } else {
            Toast.makeText(this, (int) R.string.fvc, 1).show();
            this.Gpl = true;
        }
        this.Gqc.Gpq = true;
        if (fyD().Nie) {
            this.GmP.Gnu = true;
        }
        this.GmC.post(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(126508);
                TopStoryListVideoUI.this.GmQ.fzB();
                AppMethodBeat.o(126508);
            }
        });
        new c(this).f(this.GmC);
        new com.tencent.mm.plugin.topstory.ui.video.fs.b().f(this.GmF);
        this.Gph = findViewById(R.id.br1);
        this.Gpj = findViewById(R.id.br2);
        this.Gph.setVisibility(8);
        this.Gqg = findViewById(R.id.bqw);
        this.Gqi = findViewById(R.id.bqx);
        this.Gqg.setVisibility(8);
        this.Gph.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass8 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(126509);
                if (TopStoryListVideoUI.this.Gph.getVisibility() == 0) {
                    if (TopStoryListVideoUI.i(TopStoryListVideoUI.this.Gpj, motionEvent.getX(), motionEvent.getY())) {
                        Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewNotFull");
                        AppMethodBeat.o(126509);
                        return false;
                    }
                    TopStoryListVideoUI.this.Gph.setVisibility(8);
                }
                AppMethodBeat.o(126509);
                return false;
            }
        });
        this.Gqg.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass9 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(126510);
                if (TopStoryListVideoUI.this.Gqg.getVisibility() == 0) {
                    if (TopStoryListVideoUI.i(TopStoryListVideoUI.this.Gqi, motionEvent.getX(), motionEvent.getY())) {
                        Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "touch in mContentViewFull");
                        AppMethodBeat.o(126510);
                        return false;
                    }
                    TopStoryListVideoUI.this.Gqg.setVisibility(8);
                }
                AppMethodBeat.o(126510);
                return false;
            }
        });
        this.Gpk = (TopStoryCommentFloatDialog) findViewById(R.id.b8x);
        this.Gpk.setVisibility(8);
        this.Gpk.o(this);
        fzS();
        AppMethodBeat.o(126519);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final com.tencent.mm.plugin.topstory.ui.video.d fzn() {
        AppMethodBeat.i(126520);
        d dVar = new d();
        AppMethodBeat.o(126520);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final void jm(int i2, int i3) {
        AppMethodBeat.i(126523);
        if ((i3 == 2 || i3 == 1) && this.Gpl) {
            fzO();
        }
        super.jm(i2, i3);
        AppMethodBeat.o(126523);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c4b;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.plugin.topstory.ui.video.b
    public final void fyy() {
        AppMethodBeat.i(126525);
        this.tql.animate().cancel();
        this.tql.setAlpha(1.0f);
        if (!(fyD().Nid == null || this.Gqb == null)) {
            this.Gqb.setAlpha(1.0f);
        }
        AppMethodBeat.o(126525);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final void fzp() {
        AppMethodBeat.i(126526);
        super.fzp();
        if (!this.Gna && this.Gqa.getAlpha() != 0.0f) {
            this.Gqa.animate().cancel();
            this.Gqa.setAlpha(0.0f);
        }
        AppMethodBeat.o(126526);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean abU(int i2) {
        AppMethodBeat.i(126527);
        this.Gph.setVisibility(8);
        this.Gqg.setVisibility(8);
        Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo %d", Integer.valueOf(i2));
        try {
            if (this.Gna) {
                if (i2 < (this.GmH.getItemCount() - this.GmH.getFootersCount()) - this.GmH.getHeadersCount()) {
                    RecyclerView recyclerView = this.GmF;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
                    recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
                    AppMethodBeat.o(126527);
                    return true;
                }
                Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo fullScreen, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", Integer.valueOf(i2), Integer.valueOf(this.GmH.getItemCount()), Integer.valueOf(this.GmH.getFootersCount()), Integer.valueOf(this.GmH.getHeadersCount()));
            } else if (i2 < (this.Gqc.getItemCount() - this.Gqc.getFootersCount()) - this.Gqc.getHeadersCount()) {
                this.GmE.a(this, this.Gqc.getHeadersCount() + i2);
                AppMethodBeat.o(126527);
                return true;
            } else {
                Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo, position invalid, pos:%s, itemCount:%s, footer:%s, header:%s", Integer.valueOf(i2), Integer.valueOf(this.Gqc.getItemCount()), Integer.valueOf(this.Gqc.getFootersCount()), Integer.valueOf(this.Gqc.getHeadersCount()));
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.TopStory.TopStoryListVideoUI", "tryToPlayPositionVideo Exception:%s", e2.getMessage());
        }
        AppMethodBeat.o(126527);
        return false;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.plugin.topstory.ui.video.b
    public final void s(List<eiw> list, boolean z) {
        AppMethodBeat.i(126528);
        super.s(list, z);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(126511);
                if (!TopStoryListVideoUI.this.Gna) {
                    TopStoryListVideoUI.this.Gpe.setVisibility(4);
                    TopStoryListVideoUI.this.Gpd.setVisibility(4);
                } else {
                    TopStoryListVideoUI.this.Gqf.setVisibility(4);
                    TopStoryListVideoUI.this.Gqe.setVisibility(4);
                    TopStoryListVideoUI.this.GmF.a(0, 3, (Interpolator) null);
                }
                if (TopStoryListVideoUI.this.Gpc != null) {
                    TopStoryListVideoUI.this.Gpc.dismiss();
                    TopStoryListVideoUI.this.Gpc = null;
                }
                AppMethodBeat.o(126511);
            }
        }, 50);
        AppMethodBeat.o(126528);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.plugin.topstory.ui.video.b
    public final void aTE(final String str) {
        AppMethodBeat.i(126529);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(126512);
                if (!TopStoryListVideoUI.this.Gna) {
                    TopStoryListVideoUI.this.Gpe.setVisibility(4);
                    TopStoryListVideoUI.this.Gpd.setVisibility(4);
                } else {
                    TopStoryListVideoUI.this.Gqf.setVisibility(4);
                    TopStoryListVideoUI.this.Gqe.setVisibility(4);
                }
                if (TopStoryListVideoUI.this.Gpc != null) {
                    TopStoryListVideoUI.this.Gpc.dismiss();
                    TopStoryListVideoUI.this.Gpc = null;
                }
                TopStoryListVideoUI.a(TopStoryListVideoUI.this, str);
                AppMethodBeat.o(126512);
            }
        });
        AppMethodBeat.o(126529);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final void acb(int i2) {
        AppMethodBeat.i(126530);
        boolean z = Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1;
        Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", Integer.valueOf(i2), Boolean.valueOf(z));
        if (z) {
            if (i2 == 90 || i2 == 270) {
                if (this.Gna) {
                    AppMethodBeat.o(126530);
                    return;
                }
                KD();
                AppMethodBeat.o(126530);
                return;
            } else if (i2 == 180 || i2 == 0) {
                if (!this.Gna) {
                    AppMethodBeat.o(126530);
                    return;
                }
                KC();
            }
        }
        AppMethodBeat.o(126530);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final e fzs() {
        AppMethodBeat.i(126531);
        this.Gqc = new e(this);
        e eVar = this.Gqc;
        View inflate = LayoutInflater.from(this).inflate(R.layout.c49, (ViewGroup) null);
        inflate.setClickable(false);
        inflate.setFocusableInTouchMode(false);
        inflate.setFocusable(false);
        View findViewById = inflate.findViewById(R.id.do2);
        View findViewById2 = inflate.findViewById(R.id.dof);
        if (fyD().Nid != null) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            this.Gqb = (TextView) inflate.findViewById(R.id.doy);
            this.Gqb.setText(fyD().Nid.title);
            TextView textView = (TextView) inflate.findViewById(R.id.id0);
            if (!Util.isNullOrNil(fyD().Nid.oqZ)) {
                textView.setText(fyD().Nid.oqZ);
            } else {
                textView.setVisibility(8);
            }
        } else {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
        }
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
        if (ao.aQ(this)) {
            layoutParams.topMargin = ao.aP(this);
        }
        inflate.setLayoutParams(layoutParams);
        eVar.addHeaderView(inflate);
        e eVar2 = this.Gqc;
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.c4a, (ViewGroup) null);
        inflate2.setPadding(0, 0, 0, ((com.tencent.mm.cb.a.jo(getContext()) * 2) / 5) - getResources().getDimensionPixelSize(R.dimen.amx));
        inflate2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.Gpe = inflate2.findViewById(R.id.d8m);
        this.Gpd = inflate2.findViewById(R.id.d8q);
        eVar2.fT(inflate2);
        e eVar3 = this.Gqc;
        AppMethodBeat.o(126531);
        return eVar3;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final e fzt() {
        AppMethodBeat.i(126532);
        this.Gqd = new d(this);
        d dVar = this.Gqd;
        View inflate = LayoutInflater.from(this).inflate(R.layout.c4a, (ViewGroup) null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.Gqf = inflate.findViewById(R.id.d8m);
        this.Gqe = inflate.findViewById(R.id.d8q);
        dVar.fT(inflate);
        d dVar2 = this.Gqd;
        AppMethodBeat.o(126532);
        return dVar2;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.list.b
    public final void KD() {
        AppMethodBeat.i(126533);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Gqj < 1000) {
            AppMethodBeat.o(126533);
            return;
        }
        this.Gqj = currentTimeMillis;
        Log.d("MicroMsg.TopStory.TopStoryListVideoUI", "enterFullScreen");
        f.e(true, true, true);
        if (this.GmS.GnY != null) {
            this.GjJ.Nih = this.GmS.GnY.getControlBar().getmPosition();
            if (this.GmS.GnY.getControlBar().getVideoTotalTime() - this.GjJ.Nih < 2) {
                AppMethodBeat.o(126533);
                return;
            }
        }
        wv(false);
        this.Gna = true;
        this.Gqg.setVisibility(8);
        this.Gph.setVisibility(8);
        if (!fyL()) {
            setRequestedOrientation(0);
        }
        if (this.GmX != null && this.GmX.isShowing()) {
            this.GmX.dismiss();
            this.GmX = null;
        }
        this.Gqa.setVisibility(8);
        this.jVO.setVisibility(8);
        this.GmA.setVisibility(8);
        this.GmC.setVisibility(8);
        this.GmF.setVisibility(0);
        this.Gqc.atj.notifyChanged();
        if (g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_SHORT_VIDEO_FS_SCROLL_TIPS_INT, 0) == 0) {
            this.GmS.cXa();
            this.Gpf.setVisibility(0);
            this.Gpf.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass12 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.Gpg.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(126513);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_SHORT_VIDEO_FS_SCROLL_TIPS_INT, (Object) 1);
                    TopStoryListVideoUI.this.GmS.eYd();
                    TopStoryListVideoUI.this.Gpf.setVisibility(8);
                    TopStoryListVideoUI.this.GmI.b(TopStoryListVideoUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/list/TopStoryListVideoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(126513);
                }
            });
        } else {
            this.Gpf.setVisibility(8);
        }
        this.Gqd.Gol = true;
        this.GmG.ah(fyD().Nig, 0);
        getSwipeBackLayout().setEnableGesture(false);
        wv(true);
        if (ao.aQ(this)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tql.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 24);
            this.tql.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(126533);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void KC() {
        AppMethodBeat.i(126534);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Gqj < 1000) {
            AppMethodBeat.o(126534);
            return;
        }
        this.Gqj = currentTimeMillis;
        Log.d("MicroMsg.TopStory.TopStoryListVideoUI", "exitFullScreen");
        f.e(false, true, true);
        if (this.GmS.GnY != null) {
            this.GjJ.Nih = this.GmS.GnY.getControlBar().getmPosition();
            if (this.GmS.GnY.getControlBar().getVideoTotalTime() - this.GjJ.Nih < 2) {
                AppMethodBeat.o(126534);
                return;
            }
        }
        wv(false);
        this.Gna = false;
        this.Gqg.setVisibility(8);
        this.Gph.setVisibility(8);
        if (!fyL()) {
            setRequestedOrientation(1);
        }
        if (this.GmX != null && this.GmX.isShowing()) {
            this.GmX.dismiss();
            this.GmX = null;
        }
        this.Gqa.setVisibility(0);
        if (fyD().Nid == null) {
            this.jVO.setVisibility(0);
        }
        this.GmC.setVisibility(0);
        this.GmF.setVisibility(8);
        this.Gqd.atj.notifyChanged();
        this.Gpf.setVisibility(8);
        this.Gqc.GpB = true;
        this.pcs.ah(fyD().Nig + this.Gqc.getHeadersCount(), fyN());
        getSwipeBackLayout().setEnableGesture(true);
        wv(true);
        fzS();
        AppMethodBeat.o(126534);
    }

    private void fzS() {
        AppMethodBeat.i(126535);
        if (ao.aQ(this)) {
            int aP = ao.aP(this);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tql.getLayoutParams();
            layoutParams.topMargin = aP;
            layoutParams.leftMargin = 0;
            this.tql.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.Gqa.getLayoutParams();
            layoutParams2.height = aP + layoutParams2.height;
            this.Gqa.setLayoutParams(layoutParams2);
        }
        AppMethodBeat.o(126535);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.plugin.topstory.ui.video.b
    public final int fyN() {
        AppMethodBeat.i(126536);
        if (ao.aQ(this)) {
            int fyN = super.fyN() + ao.aP(this);
            AppMethodBeat.o(126536);
            return fyN;
        }
        int fyN2 = super.fyN();
        AppMethodBeat.o(126536);
        return fyN2;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(eiw eiw, com.tencent.mm.plugin.topstory.ui.video.f fVar, int i2) {
        AppMethodBeat.i(126538);
        if (!(eiw.NiI == null || eiw.NiI.NhN == null)) {
            if (i2 < eiw.NiI.LHa || i2 > eiw.NiI.iqg) {
                fVar.fzg();
            } else if (!eiw.NiI.dEF) {
                eiw.NiI.dEF = true;
                fVar.fzf();
                AppMethodBeat.o(126538);
                return;
            }
        }
        AppMethodBeat.o(126538);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(eiw eiw, int i2, int i3) {
        int i4;
        AppMethodBeat.i(126539);
        if (fyD().Nid != null) {
            AppMethodBeat.o(126539);
        } else if (eiw == null || eiw.Niz == null) {
            AppMethodBeat.o(126539);
        } else {
            com.tencent.mm.plugin.topstory.a.b.b bVar = this.GmQ.GnT;
            if (bVar == null || bVar.Gjm == 0) {
                AppMethodBeat.o(126539);
                return;
            }
            long currentTimeMillis = (System.currentTimeMillis() - bVar.Gjm) / 1000;
            int i5 = eiw.Niz.NhT - 10;
            int i6 = ((eiw.Niz.NhU * i3) / 100) - 10;
            if (!eiw.Niz.NhW && currentTimeMillis >= ((long) i5) && i2 >= i6) {
                n nVar = this.GmT;
                eit eit = this.GjJ;
                int fzy = this.GmT.fzy();
                Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo %s %d %d", eiw.psI, Integer.valueOf(fzy), Long.valueOf(currentTimeMillis));
                if (nVar.GnI != null) {
                    g.azz().a(nVar.GnI);
                    nVar.GnI = null;
                }
                eit a2 = com.tencent.mm.plugin.topstory.a.h.a(eit);
                a2.offset = fzy;
                nVar.GnI = new com.tencent.mm.plugin.topstory.a.c.h(a2, nVar.GlS.fyH(), eiw, currentTimeMillis);
                g.azz().a(nVar.GnI, 0);
                g.azz().a(1943, nVar.gNh);
                eiw.Niz.NhW = true;
            }
            if (!eiw.Niz.dEF && currentTimeMillis >= ((long) (i5 + 10)) && i2 >= i6 + 10) {
                eiw.Niz.dEF = true;
                Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "start to show second video info %d", Integer.valueOf(eiw.Niz.NhV.size()));
                Iterator<eiw> it = eiw.Niz.NhV.iterator();
                while (it.hasNext()) {
                    eiw next = it.next();
                    if (next.Niz == null) {
                        Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s not have secondInfo", next.psI);
                    } else {
                        Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "videoId %s secondVideoInfoType %d", next.psI, Integer.valueOf(next.Niz.NhR));
                        if (next.Niz.NhR == 2) {
                            int i7 = next.Niz.Kmn;
                            int fyH = fyH();
                            if (i7 > 0) {
                                i4 = i7;
                            } else {
                                i4 = 1;
                            }
                            int i8 = fyH + i4;
                            final int fzy2 = this.GmT.fzy() - 1;
                            if (i8 <= fzy2) {
                                fzy2 = i8;
                            }
                            this.GmT.GW().add(fzy2, next);
                            Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "high complete insert success curPos %s insertOffset %s pos:%s, vid[%s], title:%s", Integer.valueOf(fyH), Integer.valueOf(i7), Integer.valueOf(fzy2), next.psI, next.title);
                            getRecyclerView().post(new Runnable() {
                                /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(126499);
                                    TopStoryListVideoUI.this.fyK().cj(fzy2 + TopStoryListVideoUI.this.fyK().getHeadersCount());
                                    AppMethodBeat.o(126499);
                                }
                            });
                        }
                    }
                }
            }
            AppMethodBeat.o(126539);
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int fyS() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final com.tencent.mm.plugin.topstory.ui.video.d fzo() {
        AppMethodBeat.i(126540);
        com.tencent.mm.plugin.topstory.ui.video.fs.c cVar = new com.tencent.mm.plugin.topstory.ui.video.fs.c();
        AppMethodBeat.o(126540);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final void a(final eiw eiw, View view, boolean z) {
        int i2;
        AppMethodBeat.i(126541);
        Log.i("MicroMsg.TopStory.TopStoryListVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", eiw.psI, Boolean.valueOf(z));
        if (!z) {
            if (this.Gqg.getVisibility() == 0) {
                if (!(this.Gqh == null || this.Gqh.vid == null || !this.Gqh.vid.equals(eiw.psI))) {
                    this.Gqg.setVisibility(8);
                    AppMethodBeat.o(126541);
                    return;
                }
            } else if (this.Gph.getVisibility() == 0 && this.Gpi != null && this.Gpi.vid != null && this.Gpi.vid.equals(eiw.psI)) {
                this.Gph.setVisibility(8);
            }
            AppMethodBeat.o(126541);
            return;
        }
        String sb = new StringBuilder().append(System.currentTimeMillis()).toString();
        String str = eiw.wWb;
        String str2 = eiw.title;
        String str3 = fyD().hes;
        int i3 = fyD().scene;
        if (fyL()) {
            i2 = 318;
        } else {
            i2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX;
        }
        com.tencent.mm.plugin.topstory.a.c.f fVar = new com.tencent.mm.plugin.topstory.a.c.f(sb, str, "", "", "", "", str2, str3, i3, i2, eiw.psI, eiw.NiD);
        if (this.Gna) {
            this.Gqg.setVisibility(0);
            this.Gph.setVisibility(8);
            this.Gqh = new c(this.Gqi, new c.a() {
                /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.topstory.ui.widget.c.a
                public final void a(com.tencent.mm.plugin.topstory.a.c.f fVar) {
                    AppMethodBeat.i(126502);
                    TopStoryListVideoUI.this.Gpk.a(fVar, new TopStoryCommentFloatDialog.a() {
                        /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a
                        public final void onDismiss() {
                            AppMethodBeat.i(126500);
                            TopStoryListVideoUI.this.GmS.eYd();
                            AppMethodBeat.o(126500);
                        }

                        @Override // com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a
                        public final void fzQ() {
                            AppMethodBeat.i(126501);
                            TopStoryListVideoUI.this.Gqg.setVisibility(8);
                            TopStoryListVideoUI.this.Gph.setVisibility(8);
                            AppMethodBeat.o(126501);
                        }
                    }, (int) TopStoryListVideoUI.this.GjJ.Nib, eiw.Nis);
                    if (TopStoryListVideoUI.this.GmS.dFG()) {
                        TopStoryListVideoUI.this.GmS.cXa();
                    }
                    AppMethodBeat.o(126502);
                }
            }, fVar, eiw.psI);
            c cVar = this.Gqh;
            int dip2px = com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 10.0f);
            Context context = view.getContext();
            View view2 = cVar.contentView;
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            view.getHeight();
            int width = view.getWidth();
            int i4 = ao.az(context).x;
            view2.measure(0, 0);
            int measuredHeight = view2.getMeasuredHeight();
            int measuredWidth = view2.getMeasuredWidth();
            int[] iArr2 = {((width / 2) + iArr[0]) - (measuredWidth / 2), iArr[1] - measuredHeight};
            org.xwalk.core.Log.i("PopupUtil", "window pos x:" + iArr2[0] + ", windowWidth:" + measuredWidth + ", screenWidth:" + i4);
            if (iArr2[0] + measuredWidth > i4) {
                iArr2[0] = i4 - measuredWidth;
            }
            iArr2[0] = iArr2[0] + 0;
            iArr2[1] = dip2px + iArr2[1];
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.contentView.getLayoutParams();
            layoutParams.leftMargin = iArr2[0];
            layoutParams.topMargin = iArr2[1];
            cVar.contentView.setLayoutParams(layoutParams);
            this.Gqg.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(126503);
                    if (TopStoryListVideoUI.this.Gqg.getVisibility() == 0) {
                        TopStoryListVideoUI.this.Gqg.setVisibility(8);
                    }
                    AppMethodBeat.o(126503);
                }
            }, 1800);
            AppMethodBeat.o(126541);
            return;
        }
        this.Gqg.setVisibility(8);
        this.Gph.setVisibility(0);
        this.Gpi = new c(this.Gpj, new c.a() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.topstory.ui.widget.c.a
            public final void a(com.tencent.mm.plugin.topstory.a.c.f fVar) {
                AppMethodBeat.i(126506);
                TopStoryListVideoUI.this.Gpk.a(fVar, new TopStoryCommentFloatDialog.a() {
                    /* class com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a
                    public final void onDismiss() {
                        AppMethodBeat.i(126504);
                        TopStoryListVideoUI.this.GmS.eYd();
                        AppMethodBeat.o(126504);
                    }

                    @Override // com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a
                    public final void fzQ() {
                        AppMethodBeat.i(126505);
                        TopStoryListVideoUI.this.Gqg.setVisibility(8);
                        TopStoryListVideoUI.this.Gph.setVisibility(8);
                        AppMethodBeat.o(126505);
                    }
                }, (int) TopStoryListVideoUI.this.GjJ.Nib, eiw.Nis);
                if (TopStoryListVideoUI.this.GmS.dFG()) {
                    TopStoryListVideoUI.this.GmS.cXa();
                }
                AppMethodBeat.o(126506);
            }
        }, fVar, eiw.psI);
        this.Gpi.a(view, false, com.tencent.mm.plugin.topstory.ui.widget.e.dip2px(this, 8.0f));
        AppMethodBeat.o(126541);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(126542);
        super.onPause();
        this.Gpk.onPause();
        AppMethodBeat.o(126542);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(126543);
        super.onResume();
        this.Gpk.onResume();
        AppMethodBeat.o(126543);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(126544);
        super.onDestroy();
        this.Gpk.gyh.close();
        AppMethodBeat.o(126544);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(126545);
        if (i2 == 4 && this.Gpk.getVisibility() == 0) {
            this.Gpk.hide();
            AppMethodBeat.o(126545);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(126545);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        AppMethodBeat.i(126516);
        if (!this.Gna || fyL()) {
            AppMethodBeat.o(126516);
            return 1;
        }
        AppMethodBeat.o(126516);
        return 0;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI
    public final void fzq() {
        AppMethodBeat.i(126521);
        if (!this.Gna) {
            this.Gpe.setVisibility(0);
            this.Gpd.setVisibility(0);
        } else {
            this.Gqf.setVisibility(0);
            this.Gqe.setVisibility(0);
        }
        this.GmT.ace(this.GmT.fzy());
        AppMethodBeat.o(126521);
    }

    private void fzO() {
        AppMethodBeat.i(126522);
        if (!this.Gna) {
            this.Gpe.setVisibility(0);
            this.Gpd.setVisibility(0);
        } else {
            this.Gqf.setVisibility(0);
            this.Gqe.setVisibility(0);
        }
        this.GmT.ace(0);
        AppMethodBeat.o(126522);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI, com.tencent.mm.plugin.topstory.ui.video.b
    public final void fyx() {
        AppMethodBeat.i(126524);
        if (!this.Gna) {
            this.Gqa.animate().alpha(1.0f).setDuration(200).setStartDelay(1800);
        } else {
            this.Gqg.setVisibility(8);
        }
        this.tql.animate().alpha(0.1f).setDuration(200).setStartDelay(1800);
        if (!(fyD().Nid == null || this.Gqb == null)) {
            this.Gqb.animate().alpha(0.1f).setDuration(200).setStartDelay(1800);
        }
        AppMethodBeat.o(126524);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(dyi dyi) {
        boolean z;
        AppMethodBeat.i(126537);
        if (this.Gna) {
            KC();
        }
        this.GmP.Gnu = true;
        this.GmS.stopPlay();
        eiw acd = this.GmT.acd(fyH());
        eit a2 = com.tencent.mm.plugin.topstory.a.h.a(fyD());
        a2.sGQ = UUID.randomUUID().toString();
        a2.NhX = acd.psI;
        a2.Nib = dyi.MXW;
        a2.Nic = null;
        a2.Nid = dyi;
        a2.Nie = this.GmP.Gnu;
        Iterator<aca> it = a2.IDO.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            aca next = it.next();
            if ("show_tag_list".equals(next.key)) {
                next.LmD = dyi.id;
                z = true;
                break;
            }
        }
        if (!z) {
            aca aca = new aca();
            aca.key = "show_tag_list";
            aca.LmD = dyi.id;
            a2.IDO.add(aca);
        }
        ai.a(this, a2, 10001);
        a.pl(28);
        ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(fyD(), acd, fyH(), 4, dyi.dQx + ":" + dyi.id);
        AppMethodBeat.o(126537);
    }

    static /* synthetic */ boolean i(View view, float f2, float f3) {
        AppMethodBeat.i(126546);
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int measuredWidth = view.getMeasuredWidth() + i2;
            int measuredHeight = view.getMeasuredHeight() + i3;
            if (f3 >= ((float) i3) && f3 <= ((float) measuredHeight) && f2 >= ((float) i2) && f2 <= ((float) measuredWidth)) {
                AppMethodBeat.o(126546);
                return true;
            }
        }
        AppMethodBeat.o(126546);
        return false;
    }

    static /* synthetic */ void a(TopStoryListVideoUI topStoryListVideoUI, String str) {
        AppMethodBeat.i(126547);
        if (!NetStatusUtil.isNetworkConnected(topStoryListVideoUI)) {
            Toast.makeText(topStoryListVideoUI, topStoryListVideoUI.getString(R.string.fva), 1).show();
            AppMethodBeat.o(126547);
        } else if (!Util.isNullOrNil(str)) {
            Toast.makeText(topStoryListVideoUI, str, 1).show();
            AppMethodBeat.o(126547);
        } else {
            Toast.makeText(topStoryListVideoUI, topStoryListVideoUI.getString(R.string.fvb), 1).show();
            AppMethodBeat.o(126547);
        }
    }
}
