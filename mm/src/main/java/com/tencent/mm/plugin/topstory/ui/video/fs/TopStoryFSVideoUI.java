package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.multitask.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.m;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.b;
import com.tencent.mm.plugin.topstory.ui.widget.c;
import com.tencent.mm.plugin.topstory.ui.widget.d;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TopStoryFSVideoUI extends MMSecDataActivity implements c, b {
    private static long Gpm = 0;
    protected ImageButton AnC;
    protected eit GjJ;
    protected RecyclerView GmC;
    private a GmJ;
    protected int GmL = 0;
    protected long GmM = -1;
    protected long GmN = -1;
    private l GmP;
    private o GmQ;
    private m GmR;
    r GmS;
    n GmT;
    private boolean GmU;
    protected d GmV;
    private boolean GmW;
    protected com.tencent.mm.plugin.topstory.ui.widget.b GmX;
    private aj GmY;
    protected View Gmx;
    protected ImageView Gmy;
    protected View Gmz;
    private i Gnc = new i() {
        /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass8 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            AppMethodBeat.i(126341);
            final j jVar = (j) qVar;
            eim eim = (eim) jVar.rr.iLK.iLR;
            if (i2 == 0 && i3 == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("docId", eim.MEq);
                    jSONObject.put("opType", "LIKE");
                    jSONObject.put("isLike", eim.him == 4);
                } catch (JSONException e2) {
                }
                if (jVar.GjH != null) {
                    eiw eiw = jVar.GjH;
                    if (eim.him == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    eiw.NiC = z;
                    Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", Boolean.valueOf(jVar.GjH.NiC), Integer.valueOf(jVar.GjH.NiH));
                }
                if (eim.him == 4) {
                    h b2 = TopStoryFSVideoUI.this.fyK().b(jVar.GjH);
                    View view = null;
                    if (TopStoryFSVideoUI.this.GmS.GjK != null && TopStoryFSVideoUI.this.GmS.GjK.psI != null && TopStoryFSVideoUI.this.GmS.GjK.psI.equals(jVar.GjH.psI) && (b2 instanceof g)) {
                        view = b2.getWowView();
                    }
                    if (view != null) {
                        TopStoryFSVideoUI.this.a(jVar.GjH, view, true);
                        if (b2 instanceof g) {
                            b2.fzk().getControlBar().show();
                        }
                    }
                } else {
                    if (jVar.fye().NhI) {
                        com.tencent.mm.ui.base.h.c(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(R.string.hqq), "", true);
                    } else {
                        u.makeText(TopStoryFSVideoUI.this.getContext(), (int) R.string.hqr, 0).show();
                    }
                    TopStoryFSVideoUI.this.a(jVar.GjH, (View) null, false);
                }
                kn knVar = new kn();
                knVar.dPD.dPE = jSONObject.toString();
                knVar.dPD.dPF = "";
                EventCenter.instance.publish(knVar);
            } else {
                Log.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                u.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(R.string.hpy), 0).show();
                if (jVar.GjH != null) {
                    jVar.GjH.NiC = !jVar.GjH.NiC;
                    Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + jVar.GjH.NiC);
                }
            }
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass8.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(126340);
                    h b2 = TopStoryFSVideoUI.this.fyK().b(jVar.GjH);
                    if (b2 != null && (b2 instanceof g)) {
                        ((f) b2.fzk().getControlBar()).m(jVar.GjH);
                    }
                    AppMethodBeat.o(126340);
                }
            });
            AppMethodBeat.o(126341);
        }
    };
    protected i Gpa;
    protected h Gpb;
    private ProgressDialog Gpc;
    private View Gpd;
    private View Gpe;
    private View Gpf;
    private Button Gpg;
    View Gph;
    com.tencent.mm.plugin.topstory.ui.widget.c Gpi;
    View Gpj;
    TopStoryCommentFloatDialog Gpk;
    private boolean Gpl;
    private com.tencent.mm.plugin.topstory.ui.b.a VfU;
    protected RecyclerView.l guX = new RecyclerView.l() {
        /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass3 */

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(126331);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            switch (i2) {
                case 0:
                    TopStoryFSVideoUI.this.Gpb.b(TopStoryFSVideoUI.this);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(126331);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(126332);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            if (i3 == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(126332);
                return;
            }
            TopStoryFSVideoUI.this.fzp();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(126332);
        }
    };
    private Point imX;
    protected LinearLayoutManager pcs;
    protected View tql;
    private int videoHeight;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TopStoryFSVideoUI() {
        AppMethodBeat.i(126353);
        AppMethodBeat.o(126353);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126354);
        if (Build.VERSION.SDK_INT >= 28) {
            customfixStatusbar(true);
        }
        super.onCreate(bundle);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_context");
        this.GjJ = new eit();
        try {
            this.GjJ.parseFrom(byteArrayExtra);
        } catch (Exception e2) {
            finish();
        }
        this.GmT = new n();
        this.GmT.GlS = this;
        this.GmR = new m();
        this.GmR.d(this);
        this.GmQ = new o();
        this.GmQ.d(this);
        this.GmS = new r();
        this.GmS.d(this);
        this.GmP = new l();
        this.Gpb = new h();
        if (this.GjJ.Nic != null) {
            this.GmT.h(this.GjJ.Nic);
        }
        this.VfU = new com.tencent.mm.plugin.topstory.ui.b.a(new com.tencent.mm.plugin.topstory.ui.b.b(this));
        this.VfU.G(8, this.GjJ.sGQ);
        this.VfU.agT(getResources().getString(R.string.hpu));
        this.GmJ = new a(new com.tencent.mm.plugin.topstory.ui.multitask.b(this));
        this.GmJ.G(8, this.GjJ.sGQ);
        this.GmJ.aCM(getResources().getString(R.string.hpu));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
            getSupportActionBar().hide();
        }
        if (this.GjJ.Nie) {
            this.GmP.Gnu = true;
        }
        fzl();
        this.tql = findViewById(R.id.iq5);
        this.Gmx = findViewById(R.id.fqs);
        this.Gmz = findViewById(R.id.fk3);
        this.Gmy = (ImageView) findViewById(R.id.fqv);
        this.AnC = (ImageButton) findViewById(R.id.xt);
        this.AnC.getDrawable().setColorFilter(getResources().getColor(R.color.am), PorterDuff.Mode.SRC_ATOP);
        this.AnC.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126329);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TopStoryFSVideoUI.a(TopStoryFSVideoUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126329);
            }
        });
        this.Gmx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(126347);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TopStoryFSVideoUI.this.fzP();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126347);
            }
        });
        this.Gmx.setVisibility(8);
        this.Gpf = findViewById(R.id.db8);
        this.Gpg = (Button) findViewById(R.id.hcr);
        this.GmC = (RecyclerView) findViewById(R.id.j6b);
        this.GmC.a(this.guX);
        this.pcs = new LinearLayoutManager();
        this.GmC.setLayoutManager(this.pcs);
        this.GmY = aj.e(this.pcs);
        this.Gpa = new i(this);
        i iVar = this.Gpa;
        View inflate = LayoutInflater.from(this).inflate(R.layout.c4a, (ViewGroup) null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.Gpe = inflate.findViewById(R.id.d8m);
        this.Gpd = inflate.findViewById(R.id.d8q);
        iVar.fT(inflate);
        this.GmC.setAdapter(this.Gpa);
        new b().f(this.GmC);
        if (!fzr()) {
            this.Gpe.setVisibility(4);
            this.Gpd.setVisibility(4);
        } else if (this.GmP.isConnected()) {
            fzO();
            this.Gpl = false;
            if (this.GjJ.scene != 21 && this.GjJ.Nid == null) {
                this.Gpc = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass13 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(126348);
                        TopStoryFSVideoUI.this.finish();
                        AppMethodBeat.o(126348);
                    }
                });
            }
        } else {
            Toast.makeText(this, (int) R.string.fvc, 1).show();
            this.Gpl = true;
        }
        this.Gpa.Gpq = true;
        this.Gpf.setVisibility(8);
        if (this.GmP.fzw() && ai.isFreeSimCard() && System.currentTimeMillis() - Gpm > Util.MILLSECONDS_OF_DAY) {
            Toast.makeText(this, (int) R.string.hq5, 0).show();
            Gpm = System.currentTimeMillis();
        }
        this.Gph = findViewById(R.id.br1);
        this.Gpj = findViewById(R.id.br2);
        this.Gph.setVisibility(8);
        this.Gph.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass14 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(126349);
                if (TopStoryFSVideoUI.this.Gph.getVisibility() == 0) {
                    if (TopStoryFSVideoUI.h(TopStoryFSVideoUI.this.Gpj, motionEvent.getX(), motionEvent.getY())) {
                        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
                        AppMethodBeat.o(126349);
                        return false;
                    }
                    TopStoryFSVideoUI.this.Gph.setVisibility(8);
                }
                AppMethodBeat.o(126349);
                return false;
            }
        });
        this.Gpk = (TopStoryCommentFloatDialog) findViewById(R.id.b8x);
        this.Gpk.setVisibility(8);
        this.Gpk.o(this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass15 */

            public final void onSystemUiVisibilityChange(int i2) {
                AppMethodBeat.i(126350);
                TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
                AppMethodBeat.o(126350);
            }
        });
        if (fyL()) {
            this.AnC.setImageResource(R.raw.top_story_close_icon);
            if (ao.aQ(this)) {
                int aP = ao.aP(this);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tql.getLayoutParams();
                layoutParams.topMargin = aP + com.tencent.mm.cb.a.fromDPToPix((Context) this, 12);
                this.tql.setLayoutParams(layoutParams);
            }
        }
        this.Gmz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(126351);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TopStoryFSVideoUI.c(TopStoryFSVideoUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126351);
            }
        });
        g.azz().a(2802, this.Gnc);
        AppMethodBeat.o(126354);
    }

    /* access modifiers changed from: protected */
    public final void fzp() {
        boolean z = true;
        AppMethodBeat.i(126355);
        this.Gpb.a(this);
        this.GmL = this.pcs.ku();
        int itemCount = this.pcs.getItemCount();
        if (this.GmM <= 0 || Util.ticksToNow(this.GmM) >= 50) {
            this.GmM = Util.currentTicks();
            if (this.GmT.GnE == 1 ? itemCount - this.GmL > 3 || this.GmT.GhN || Util.ticksToNow(this.GmN) < 50 : this.GmL < itemCount - 1 || this.GmT.GhN || Util.ticksToNow(this.GmN) < 50) {
                z = false;
            }
            if (!fzr()) {
                z = false;
            }
            if (z) {
                this.Gpe.setVisibility(0);
                this.Gpd.setVisibility(0);
                this.GmT.ace(this.GmT.fzy());
            }
        }
        AppMethodBeat.o(126355);
    }

    private boolean fzr() {
        if (this.GjJ.scene == 36 || this.GjJ.Nik) {
            return false;
        }
        return true;
    }

    private void fzl() {
        AppMethodBeat.i(126356);
        getWindow().setFlags(201327616, 201327616);
        View decorView = getWindow().getDecorView();
        if (com.tencent.mm.compatible.util.d.oE(19)) {
            decorView.setSystemUiVisibility(2);
        } else {
            decorView.setSystemUiVisibility(4102);
        }
        getWindow().addFlags(128);
        AppMethodBeat.o(126356);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void fyx() {
        AppMethodBeat.i(126357);
        this.tql.animate().alpha(0.0f).setDuration(200).setStartDelay(1800);
        this.Gph.setVisibility(8);
        AppMethodBeat.o(126357);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void fyy() {
        AppMethodBeat.i(126358);
        this.tql.animate().cancel();
        this.tql.setAlpha(1.0f);
        AppMethodBeat.o(126358);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean abU(int i2) {
        AppMethodBeat.i(126359);
        this.Gph.setVisibility(8);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", Integer.valueOf(i2));
        try {
            if (i2 >= (this.Gpa.getItemCount() - this.Gpa.getFootersCount()) - this.Gpa.getHeadersCount()) {
                AppMethodBeat.o(126359);
                return false;
            }
            RecyclerView recyclerView = this.GmC;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.Gpa.getHeadersCount() + i2, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(126359);
            return true;
        } catch (Exception e2) {
            Log.w("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo Exception:%s", e2.getMessage());
            AppMethodBeat.o(126359);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c3z;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(eiw eiw) {
        AppMethodBeat.i(126360);
        if (this.GmJ != null) {
            this.GmJ.a(this.GjJ, eiw);
        }
        if (this.VfU != null) {
            this.VfU.a(this.GjJ, eiw);
        }
        AppMethodBeat.o(126360);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void KC() {
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(dyi dyi) {
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(eiw eiw, f fVar, int i2) {
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(eiw eiw, int i2, int i3) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        AppMethodBeat.i(126361);
        if (fyL()) {
            AppMethodBeat.o(126361);
            return 1;
        }
        AppMethodBeat.o(126361);
        return 0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        h c2;
        AppMethodBeat.i(126362);
        p.GnV.a(this, i2, i3, intent);
        if (i2 == 10001 && ((this.GmP.cGF() || ai.isFreeSimCard()) && (c2 = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this)) != null)) {
            c2.wu(false);
        }
        AppMethodBeat.o(126362);
    }

    private void fzO() {
        AppMethodBeat.i(126363);
        this.Gpe.setVisibility(0);
        this.Gpd.setVisibility(0);
        this.GmT.ace(0);
        AppMethodBeat.o(126363);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final l fyA() {
        return this.GmP;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final o fyB() {
        return this.GmQ;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final String fyC() {
        AppMethodBeat.i(126364);
        String aTv = com.tencent.mm.plugin.topstory.a.h.aTv(this.GjJ.sGQ);
        AppMethodBeat.o(126364);
        return aTv;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final eit fyD() {
        return this.GjJ;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final m fyE() {
        return this.GmR;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final r fyF() {
        return this.GmS;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final n fyO() {
        return this.GmT;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final String fyP() {
        return this.GjJ.Nii == null ? "" : this.GjJ.Nii;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void aTF(String str) {
        this.GjJ.Nii = str;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int fyQ() {
        return this.GjJ.Nij;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void abW(int i2) {
        this.GjJ.Nij = i2;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean fyL() {
        return this.GjJ.Nib == 100203;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int getVideoHeight() {
        AppMethodBeat.i(126365);
        if (this.videoHeight == 0) {
            if (!fyL()) {
                this.videoHeight = (getVideoWidth() * 280) / com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX;
            } else {
                this.videoHeight = TAVExporter.VIDEO_EXPORT_HEIGHT;
                int i2 = (cZM().y * 3) / 5;
                if (this.videoHeight > i2) {
                    this.videoHeight = i2;
                }
                Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", Integer.valueOf(this.videoHeight), Integer.valueOf(i2));
            }
        }
        int i3 = this.videoHeight;
        AppMethodBeat.o(126365);
        return i3;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int getVideoWidth() {
        AppMethodBeat.i(126366);
        int min = Math.min(cZM().x, cZM().y);
        AppMethodBeat.o(126366);
        return min;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final Point cZM() {
        AppMethodBeat.i(126367);
        if (this.imX == null) {
            this.imX = ao.az(this);
        }
        Point point = this.imX;
        AppMethodBeat.o(126367);
        return point;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final aj fyG() {
        return this.GmY;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final RecyclerView.LayoutManager getLayoutManager() {
        return this.pcs;
    }

    private int getSystemVolume() {
        AppMethodBeat.i(126368);
        int streamVolume = ((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
        AppMethodBeat.o(126368);
        return streamVolume;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z = true;
        AppMethodBeat.i(126369);
        if (i2 == 4 && this.Gpk.getVisibility() == 0) {
            this.Gpk.hide();
            AppMethodBeat.o(126369);
            return true;
        }
        if (i2 == 25 && keyEvent.getAction() == 0) {
            Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", Integer.valueOf(getSystemVolume()));
            eit eit = this.GjJ;
            if (getSystemVolume() > 1) {
                z = false;
            }
            eit.guh = z;
            fzu();
        } else if (i2 == 24 && keyEvent.getAction() == 0) {
            Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", Integer.valueOf(getSystemVolume()));
            this.GjJ.guh = false;
            fzu();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(126369);
        return onKeyDown;
    }

    @SuppressLint({"ResourceType"})
    private void fzu() {
        AppMethodBeat.i(126371);
        if (this.GjJ.guh) {
            this.Gmy.setBackgroundResource(R.raw.top_story_volume_off);
        } else {
            this.Gmy.setBackgroundResource(R.raw.top_story_volume_on);
        }
        if (this.GmS.GnZ) {
            this.GmS.setMute(this.GjJ.guh);
        }
        AppMethodBeat.o(126371);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean Zx() {
        return this.GjJ.guh;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int fyH() {
        return this.GjJ.Nig;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void abV(int i2) {
        this.GjJ.Nig = i2;
    }

    public final void az(View view, final int i2) {
        AppMethodBeat.i(126373);
        this.GmW = true;
        final eiw acd = this.GmT.acd(i2);
        this.GmX = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), acd, new b.a() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.topstory.ui.widget.b.a
            public final void v(Set<any> set) {
                AppMethodBeat.i(126336);
                Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
                u.makeText(TopStoryFSVideoUI.this.getContext(), (int) R.string.hpt, 0).show();
                com.tencent.mm.plugin.topstory.a.i.a(TopStoryFSVideoUI.this.fyD(), acd, set, TopStoryFSVideoUI.this.GmT.fzy());
                TopStoryFSVideoUI.this.GmS.stopPlay();
                TopStoryFSVideoUI.this.GmT.acc(i2);
                if (TopStoryFSVideoUI.this.GmT.fzy() == 0) {
                    TopStoryFSVideoUI.this.finish();
                    AppMethodBeat.o(126336);
                    return;
                }
                TopStoryFSVideoUI.this.Gpa.ck(i2 + TopStoryFSVideoUI.this.Gpa.getHeadersCount());
                TopStoryFSVideoUI.this.GmC.a(0, 3, (Interpolator) null);
                AppMethodBeat.o(126336);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.widget.b.a
            public final void onDismiss() {
                AppMethodBeat.i(126337);
                Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
                if (TopStoryFSVideoUI.this.GmW) {
                    TopStoryFSVideoUI.this.GmS.eYd();
                    TopStoryFSVideoUI.this.GmW = false;
                    try {
                        ((f) TopStoryFSVideoUI.this.GmS.GnY.getControlBar()).bJB();
                        AppMethodBeat.o(126337);
                        return;
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(126337);
            }
        });
        this.GmX.a(view, true, 0, com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16));
        try {
            ((f) this.GmS.GnY.getControlBar()).crH();
            AppMethodBeat.o(126373);
        } catch (Exception e2) {
            AppMethodBeat.o(126373);
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean fyI() {
        if (this.GjJ.scene == 36) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean fyJ() {
        if (this.GjJ.scene == 326) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final e fyK() {
        return this.Gpa;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void s(List<eiw> list, boolean z) {
        AppMethodBeat.i(126374);
        this.Gpa.t(list, z);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(126338);
                TopStoryFSVideoUI.this.Gpe.setVisibility(4);
                TopStoryFSVideoUI.this.Gpd.setVisibility(4);
                TopStoryFSVideoUI.this.GmC.a(0, 3, (Interpolator) null);
                if (TopStoryFSVideoUI.this.Gpc != null) {
                    TopStoryFSVideoUI.this.Gpc.dismiss();
                    TopStoryFSVideoUI.this.Gpc = null;
                }
                AppMethodBeat.o(126338);
            }
        }, 50);
        AppMethodBeat.o(126374);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void aTE(final String str) {
        AppMethodBeat.i(126375);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(126339);
                TopStoryFSVideoUI.this.Gpe.setVisibility(4);
                TopStoryFSVideoUI.this.Gpd.setVisibility(4);
                if (TopStoryFSVideoUI.this.Gpc != null) {
                    TopStoryFSVideoUI.this.Gpc.dismiss();
                    TopStoryFSVideoUI.this.Gpc = null;
                }
                TopStoryFSVideoUI.a(TopStoryFSVideoUI.this, str);
                AppMethodBeat.o(126339);
            }
        });
        AppMethodBeat.o(126375);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean isFullscreenMode() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(126376);
        com.tencent.mm.plugin.topstory.a.i.a(this.GjJ, getActivityBrowseTimeMs(), this.GmT.acd(this.GjJ.Nig));
        g.azz().b(2802, this.Gnc);
        this.GmT.onUIDestroy();
        ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.GjJ);
        this.GmS.onUIDestroy();
        this.GmP.onUIDestroy();
        this.GmQ.onUIDestroy();
        this.GmR.onUIDestroy();
        this.Gpk.gyh.close();
        com.tencent.mm.plugin.websearch.api.a.a.pl(16);
        if (this.VfU != null) {
            this.VfU.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(126376);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(126377);
        super.onResume();
        fzl();
        fzu();
        ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
        this.GmS.onUIResume();
        this.GmP.CTg = l.fiw();
        this.Gpk.onResume();
        com.tencent.mm.plugin.websearch.api.a.a.pl(14);
        if (this.GmJ != null) {
            this.GmJ.bCA();
        }
        if (this.VfU != null) {
            this.VfU.bCA();
        }
        AppMethodBeat.o(126377);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(126378);
        super.onPause();
        this.GmS.onUIPause();
        ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
        this.Gpk.onPause();
        com.tencent.mm.plugin.websearch.api.a.a.pl(15);
        if (this.GmJ != null) {
            this.GmJ.aGj();
        }
        if (this.VfU != null) {
            this.VfU.aGj();
        }
        AppMethodBeat.o(126378);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final RecyclerView getRecyclerView() {
        return this.GmC;
    }

    @Override // com.tencent.mm.plugin.topstory.a.c
    public final void jm(int i2, int i3) {
        AppMethodBeat.i(126379);
        if ((i3 == 2 || i3 == 1) && this.Gpl) {
            fzO();
        }
        this.GmS.jp(i2, i3);
        AppMethodBeat.o(126379);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final MMActivity eeF() {
        return this;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void fyM() {
        AppMethodBeat.i(126380);
        fzl();
        AppMethodBeat.o(126380);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int fyN() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(eiw eiw, View view) {
        boolean z;
        AppMethodBeat.i(126381);
        if (eiw != null) {
            if (!NetStatusUtil.isConnected(this)) {
                Toast.makeText(getContext(), getString(R.string.hpy), 0).show();
                AppMethodBeat.o(126381);
                return;
            }
            g.azz().a(new j(eiw, eiw.wWb, eiw.NiC ? 5 : 4, new StringBuilder().append(System.currentTimeMillis()).toString(), this.GjJ.scene, this.GjJ.hes, fyL() ? 318 : com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, eiw.psI, eiw.NiD), 0);
            if (!eiw.NiC) {
                z = true;
            } else {
                z = false;
            }
            eiw.NiC = z;
            if (eiw.NiC) {
                eiw.NiH++;
            } else {
                eiw.NiH--;
            }
            ((TextView) view.findViewById(R.id.jov)).setText(com.tencent.mm.plugin.topstory.ui.c.abR(eiw.NiH));
            Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + eiw.NiC);
        }
        AppMethodBeat.o(126381);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void fyR() {
        AppMethodBeat.i(126382);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(126342);
                i iVar = TopStoryFSVideoUI.this.Gpa;
                int footersCount = iVar.getFootersCount();
                int itemCount = iVar.getItemCount();
                iVar.fyU();
                iVar.at(itemCount - footersCount, footersCount);
                AppMethodBeat.o(126342);
            }
        });
        AppMethodBeat.o(126382);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int fyS() {
        AppMethodBeat.i(126383);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_topstory_v_video_play, 0);
        AppMethodBeat.o(126383);
        return a2;
    }

    public final void a(final eiw eiw, View view, boolean z) {
        AppMethodBeat.i(126384);
        Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", eiw.psI, Boolean.valueOf(z));
        if (!z) {
            if (this.Gph.getVisibility() == 0 && this.Gpi != null && this.Gpi.vid != null && this.Gpi.vid.equals(eiw.psI)) {
                this.Gph.setVisibility(8);
            }
            AppMethodBeat.o(126384);
            return;
        }
        com.tencent.mm.plugin.topstory.a.c.f fVar = new com.tencent.mm.plugin.topstory.a.c.f(new StringBuilder().append(System.currentTimeMillis()).toString(), eiw.wWb, "", "", "", "", eiw.title, this.GjJ.hes, this.GjJ.scene, fyL() ? 318 : com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, eiw.psI, eiw.NiD);
        this.Gph.setVisibility(0);
        this.Gpi = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Gpj, new c.a() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.topstory.ui.widget.c.a
            public final void a(com.tencent.mm.plugin.topstory.a.c.f fVar) {
                AppMethodBeat.i(126345);
                TopStoryFSVideoUI.this.Gpk.a(fVar, new TopStoryCommentFloatDialog.a() {
                    /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass10.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a
                    public final void onDismiss() {
                        AppMethodBeat.i(126343);
                        TopStoryFSVideoUI.this.GmS.eYd();
                        TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
                        AppMethodBeat.o(126343);
                    }

                    @Override // com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a
                    public final void fzQ() {
                        AppMethodBeat.i(126344);
                        TopStoryFSVideoUI.this.Gph.setVisibility(8);
                        AppMethodBeat.o(126344);
                    }
                }, (int) TopStoryFSVideoUI.this.GjJ.Nib, eiw.Nis);
                if (TopStoryFSVideoUI.this.GmS.dFG()) {
                    TopStoryFSVideoUI.this.GmS.cXa();
                }
                AppMethodBeat.o(126345);
            }
        }, fVar, eiw.psI);
        this.Gph.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(126346);
                if (TopStoryFSVideoUI.this.Gph.getVisibility() == 0) {
                    TopStoryFSVideoUI.this.Gph.setVisibility(8);
                }
                AppMethodBeat.o(126346);
            }
        }, 2000);
        this.Gpi.a(view, true, 0);
        AppMethodBeat.o(126384);
    }

    public final void fzP() {
        AppMethodBeat.i(126370);
        if (this.GjJ.guh) {
            this.GjJ.guh = false;
            if (getSystemVolume() == 0) {
                com.tencent.mm.compatible.b.a.a((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE), 3, 1, 0);
            }
        } else {
            this.GjJ.guh = true;
        }
        fzu();
        fyy();
        fyx();
        AppMethodBeat.o(126370);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void ay(final View view, final int i2) {
        AppMethodBeat.i(126372);
        if (this.GmS.dFG()) {
            this.GmS.cXa();
            this.GmU = true;
        }
        this.GmV = new d(getContext(), this.GmT.acd(i2), new d.a() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.topstory.ui.widget.d.a
            public final void e(eiw eiw) {
                AppMethodBeat.i(126333);
                if (eiw.NiE != null) {
                    TopStoryFSVideoUI.this.az(view, i2);
                }
                TopStoryFSVideoUI.this.GmV.dismiss();
                AppMethodBeat.o(126333);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.widget.d.a
            public final void f(eiw eiw) {
                AppMethodBeat.i(126334);
                p pVar = p.GnV;
                p.a(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.fyD(), eiw);
                TopStoryFSVideoUI.this.GmV.dismiss();
                AppMethodBeat.o(126334);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.widget.d.a
            public final void g(eiw eiw) {
                AppMethodBeat.i(164128);
                com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
                if (com.tencent.mm.util.c.hde()) {
                    String str = TopStoryFSVideoUI.this.fyC() + com.tencent.mm.plugin.topstory.ui.c.bu(eiw.psI, eiw.Nip) + ".mp4";
                    String str2 = "/sdcard/video/" + eiw.title + ".mp4";
                    if (s.YS("/sdcard/video/")) {
                        s.boN("/sdcard/video/");
                    }
                    s.nw(str, str2);
                    Toast.makeText(TopStoryFSVideoUI.this, "copy success " + eiw.title, 0).show();
                }
                AppMethodBeat.o(164128);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.widget.d.a
            public final void onDismiss() {
                AppMethodBeat.i(126335);
                Log.i("MicroMsg.TopStory.TopStoryFSVideoUI", "more popupWindow dismiss");
                if (TopStoryFSVideoUI.this.GmU) {
                    TopStoryFSVideoUI.this.GmU = false;
                    if (TopStoryFSVideoUI.this.GmW) {
                        AppMethodBeat.o(126335);
                        return;
                    }
                    TopStoryFSVideoUI.this.GmS.eYd();
                    try {
                        ((f) TopStoryFSVideoUI.this.GmS.GnY.getControlBar()).bJB();
                        AppMethodBeat.o(126335);
                        return;
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(126335);
            }
        });
        this.GmV.a(view, true, 0, 0);
        try {
            ((f) this.GmS.GnY.getControlBar()).crH();
            AppMethodBeat.o(126372);
        } catch (Exception e2) {
            AppMethodBeat.o(126372);
        }
    }

    static /* synthetic */ void a(TopStoryFSVideoUI topStoryFSVideoUI) {
        AppMethodBeat.i(126385);
        topStoryFSVideoUI.GmQ.fzC();
        Intent intent = new Intent();
        intent.putExtra("key_video_play_info", Util.listToString(topStoryFSVideoUI.GmQ.GnU, ";"));
        intent.putExtra("key_search_id", topStoryFSVideoUI.GjJ.hes);
        topStoryFSVideoUI.setResult(-1, intent);
        if (!topStoryFSVideoUI.GmJ.O(2, false)) {
            topStoryFSVideoUI.finish();
        }
        if (!topStoryFSVideoUI.VfU.wu(2)) {
            topStoryFSVideoUI.finish();
        }
        AppMethodBeat.o(126385);
    }

    static /* synthetic */ boolean h(View view, float f2, float f3) {
        AppMethodBeat.i(126386);
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int measuredWidth = view.getMeasuredWidth() + i2;
            int measuredHeight = view.getMeasuredHeight() + i3;
            if (f3 >= ((float) i3) && f3 <= ((float) measuredHeight) && f2 >= ((float) i2) && f2 <= ((float) measuredWidth)) {
                AppMethodBeat.o(126386);
                return true;
            }
        }
        AppMethodBeat.o(126386);
        return false;
    }

    static /* synthetic */ void b(TopStoryFSVideoUI topStoryFSVideoUI) {
        AppMethodBeat.i(126387);
        View decorView = topStoryFSVideoUI.getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 2 | 4096 | 4);
        AppMethodBeat.o(126387);
    }

    static /* synthetic */ void c(TopStoryFSVideoUI topStoryFSVideoUI) {
        AppMethodBeat.i(126388);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) topStoryFSVideoUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass17 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(126352);
                mVar.clear();
                mVar.kV(2, R.string.bx0);
                AppMethodBeat.o(126352);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(126330);
                switch (menuItem.getItemId()) {
                    case 2:
                        if (TopStoryFSVideoUI.this.GmJ != null) {
                            TopStoryFSVideoUI.this.GmJ.ic(true);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(126330);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(126388);
    }

    static /* synthetic */ void a(TopStoryFSVideoUI topStoryFSVideoUI, String str) {
        AppMethodBeat.i(126389);
        if (!NetStatusUtil.isNetworkConnected(topStoryFSVideoUI)) {
            Toast.makeText(topStoryFSVideoUI, topStoryFSVideoUI.getString(R.string.fva), 1).show();
            AppMethodBeat.o(126389);
        } else if (!Util.isNullOrNil(str)) {
            Toast.makeText(topStoryFSVideoUI, str, 1).show();
            AppMethodBeat.o(126389);
        } else {
            Toast.makeText(topStoryFSVideoUI, topStoryFSVideoUI.getString(R.string.fvb), 1).show();
            AppMethodBeat.o(126389);
        }
    }
}
