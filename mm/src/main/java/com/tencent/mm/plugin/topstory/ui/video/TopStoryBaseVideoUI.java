package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.support.v7.widget.v;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.video.fs.f;
import com.tencent.mm.plugin.topstory.ui.video.fs.g;
import com.tencent.mm.plugin.topstory.ui.video.i;
import com.tencent.mm.plugin.topstory.ui.video.list.h;
import com.tencent.mm.plugin.topstory.ui.widget.b;
import com.tencent.mm.plugin.topstory.ui.widget.d;
import com.tencent.mm.protocal.protobuf.any;
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

public abstract class TopStoryBaseVideoUI extends MMSecDataActivity implements c, b {
    protected ImageButton AnC;
    public eit GjJ;
    protected ImageView GmA;
    protected i GmB;
    protected RecyclerView GmC;
    protected e GmD;
    protected d GmE;
    public RecyclerView GmF;
    protected LinearLayoutManager GmG;
    protected e GmH;
    public d GmI;
    protected com.tencent.mm.plugin.topstory.ui.multitask.a GmJ;
    public boolean GmK = true;
    protected int GmL = 0;
    protected long GmM = -1;
    protected long GmN = -1;
    private i.a GmO = new i.a() {
        /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.topstory.ui.video.i.a
        public final void onOrientationChange(int i2) {
            AppMethodBeat.i(126088);
            TopStoryBaseVideoUI.this.acb(i2);
            AppMethodBeat.o(126088);
        }
    };
    protected l GmP;
    public o GmQ;
    private m GmR;
    public r GmS;
    protected n GmT;
    private boolean GmU;
    protected d GmV;
    private boolean GmW;
    protected b GmX;
    private aj GmY;
    private aj GmZ;
    protected View Gmx;
    protected ImageView Gmy;
    protected View Gmz;
    public boolean Gna;
    private j Gnb;
    private com.tencent.mm.ak.i Gnc = new com.tencent.mm.ak.i() {
        /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass3 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            AppMethodBeat.i(126079);
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
                    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", Boolean.valueOf(jVar.GjH.NiC), Integer.valueOf(jVar.GjH.NiH));
                    if (eim.him == 4) {
                        h b2 = TopStoryBaseVideoUI.this.fyK().b(jVar.GjH);
                        View view = null;
                        if (!(TopStoryBaseVideoUI.this.GmS.GjK == null || TopStoryBaseVideoUI.this.GmS.GjK == null || TopStoryBaseVideoUI.this.GmS.GjK.psI == null || !TopStoryBaseVideoUI.this.GmS.GjK.psI.equals(jVar.GjH.psI) || (!(b2 instanceof h) && !(b2 instanceof g)))) {
                            view = b2.getWowView();
                        }
                        if (view != null) {
                            TopStoryBaseVideoUI.this.a(jVar.GjH, view, true);
                            if (b2 instanceof g) {
                                b2.fzk().getControlBar().show();
                            }
                        }
                    } else {
                        if (jVar.fye().NhI) {
                            com.tencent.mm.ui.base.h.c(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.getString(R.string.hqq), "", true);
                        } else {
                            u.makeText(TopStoryBaseVideoUI.this.getContext(), (int) R.string.hqr, 0).show();
                        }
                        TopStoryBaseVideoUI.this.a(jVar.GjH, (View) null, false);
                    }
                }
                kn knVar = new kn();
                knVar.dPD.dPE = jSONObject.toString();
                knVar.dPD.dPF = "";
                EventCenter.instance.publish(knVar);
            } else {
                Log.w("MicroMsg.TopStory.TopStoryBaseVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                u.makeText(TopStoryBaseVideoUI.this.getContext(), TopStoryBaseVideoUI.this.getString(R.string.hpy), 0).show();
                if (jVar.GjH != null) {
                    jVar.GjH.NiC = !jVar.GjH.NiC;
                    Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setCmtListener onSceneEnd error, thumb:" + jVar.GjH.NiC);
                }
            }
            TopStoryBaseVideoUI.this.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass3.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(126078);
                    h b2 = TopStoryBaseVideoUI.this.fyK().b(jVar.GjH);
                    if (b2 != null) {
                        if (b2 instanceof h) {
                            b2.fzj();
                            AppMethodBeat.o(126078);
                            return;
                        } else if (b2 instanceof g) {
                            ((f) b2.fzk().getControlBar()).m(jVar.GjH);
                        }
                    }
                    AppMethodBeat.o(126078);
                }
            });
            AppMethodBeat.o(126079);
        }
    };
    protected com.tencent.mm.plugin.topstory.ui.b.a VfU;
    protected RecyclerView.l guX = new RecyclerView.l() {
        /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass9 */

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(126086);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            if (!TopStoryBaseVideoUI.this.GmK) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(126086);
                return;
            }
            switch (i2) {
                case 0:
                    if (!TopStoryBaseVideoUI.this.Gna) {
                        TopStoryBaseVideoUI.this.GmE.b(TopStoryBaseVideoUI.this);
                        break;
                    } else {
                        TopStoryBaseVideoUI.this.GmI.b(TopStoryBaseVideoUI.this);
                        break;
                    }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(126086);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(126087);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            if (!TopStoryBaseVideoUI.this.GmK || i3 == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(126087);
                return;
            }
            TopStoryBaseVideoUI.this.fzp();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(126087);
        }
    };
    private Point imX;
    protected TextView jVO;
    private boolean mqz = false;
    protected LinearLayoutManager pcs;
    protected View tql;
    private int videoHeight;

    public abstract void a(eiw eiw, View view, boolean z);

    /* access modifiers changed from: protected */
    public abstract d fzn();

    /* access modifiers changed from: protected */
    public abstract d fzo();

    /* access modifiers changed from: protected */
    public abstract e fzs();

    /* access modifiers changed from: protected */
    public abstract e fzt();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        amZ();
        initContentView();
        com.tencent.mm.kernel.g.azz().a(2802, this.Gnc);
    }

    /* access modifiers changed from: protected */
    public void amZ() {
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
        this.GmE = fzn();
        this.GmI = fzo();
        this.VfU = new com.tencent.mm.plugin.topstory.ui.b.a(new com.tencent.mm.plugin.topstory.ui.b.b(this));
        this.VfU.G(8, this.GjJ.sGQ);
        this.VfU.agT(getResources().getString(R.string.hpu));
        this.GmJ = new com.tencent.mm.plugin.topstory.ui.multitask.a(new com.tencent.mm.plugin.topstory.ui.multitask.b(this));
        this.GmJ.G(8, this.GjJ.sGQ);
        this.GmJ.aCM(getResources().getString(R.string.hpu));
    }

    private void fzl() {
        getWindow().setFlags(201327616, 201327616);
        View decorView = getWindow().getDecorView();
        if (com.tencent.mm.compatible.util.d.oE(19)) {
            decorView.setSystemUiVisibility(2);
        } else {
            decorView.setSystemUiVisibility(4098);
        }
        getWindow().addFlags(128);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        fzm();
    }

    /* access modifiers changed from: protected */
    public void fzm() {
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
            getSupportActionBar().hide();
        }
        fzl();
        this.tql = findViewById(R.id.iq5);
        this.jVO = (TextView) findViewById(R.id.ir3);
        this.GmA = (ImageView) findViewById(R.id.i2z);
        this.Gmx = findViewById(R.id.fqs);
        this.Gmy = (ImageView) findViewById(R.id.fqv);
        this.Gmz = findViewById(R.id.fk3);
        this.AnC = (ImageButton) findViewById(R.id.xt);
        this.AnC.getDrawable().setColorFilter(getResources().getColor(R.color.am), PorterDuff.Mode.SRC_ATOP);
        this.AnC.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126076);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TopStoryBaseVideoUI.this.fzm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126076);
            }
        });
        this.Gmx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(126082);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TopStoryBaseVideoUI topStoryBaseVideoUI = TopStoryBaseVideoUI.this;
                topStoryBaseVideoUI.ww(!topStoryBaseVideoUI.GjJ.guh);
                topStoryBaseVideoUI.fyy();
                topStoryBaseVideoUI.fyx();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126082);
            }
        });
        this.Gmx.setVisibility(8);
        this.GmC = (RecyclerView) findViewById(R.id.j6b);
        this.GmC.a(this.guX);
        this.GmC.setItemAnimator(new a(this, (byte) 0));
        this.pcs = new LinearLayoutManager();
        this.GmC.setLayoutManager(this.pcs);
        this.GmY = aj.e(this.pcs);
        this.GmD = fzs();
        this.GmC.setAdapter(this.GmD);
        this.GmF = (RecyclerView) findViewById(R.id.db9);
        this.GmF.a(this.guX);
        this.GmF.setItemAnimator(new a(this, (byte) 0));
        this.GmG = new LinearLayoutManager();
        this.GmF.setLayoutManager(this.GmG);
        this.GmZ = aj.e(this.GmG);
        this.GmH = fzt();
        this.GmF.setAdapter(this.GmH);
        this.GmF.setVisibility(8);
        if (!this.mqz && !fyL()) {
            this.GmB = new i(getApplicationContext());
            this.GmB.enable();
            this.GmB.Gnj = this.GmO;
            this.mqz = true;
        }
        if (this.GjJ.guh) {
            ww(this.GjJ.guh);
        }
        this.GmP.Gnv = this;
        this.Gmz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(126083);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                TopStoryBaseVideoUI.a(TopStoryBaseVideoUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126083);
            }
        });
    }

    public final void wv(boolean z) {
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "setNeedScrollEvent %b", Boolean.valueOf(z));
        this.GmK = z;
    }

    /* access modifiers changed from: protected */
    public void fzp() {
        boolean z;
        boolean z2 = false;
        if (this.Gna) {
            this.GmI.a(this);
        } else {
            this.GmE.a(this);
        }
        this.GmL = ((LinearLayoutManager) getLayoutManager()).ku();
        int itemCount = getLayoutManager().getItemCount();
        if (this.GmM <= 0 || Util.ticksToNow(this.GmM) >= 50) {
            this.GmM = Util.currentTicks();
            if (this.GmT.GnE != 1) {
                if (this.GmL >= itemCount - 1 && !this.GmT.GhN && Util.ticksToNow(this.GmN) >= 50) {
                    z = true;
                }
                z = false;
            } else {
                if (itemCount - this.GmL <= 3 && !this.GmT.GhN && Util.ticksToNow(this.GmN) >= 50) {
                    z = true;
                }
                z = false;
            }
            if (fzr()) {
                z2 = z;
            }
            if (z2) {
                fzq();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void fzq() {
        this.GmN = Util.currentTicks();
    }

    /* access modifiers changed from: protected */
    public final boolean fzr() {
        if (this.GjJ.scene == 36 || this.GjJ.Nik) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final MMActivity eeF() {
        return this;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        fzl();
        fzu();
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
        this.GmS.onUIResume();
        this.GmP.CTg = l.fiw();
        com.tencent.mm.plugin.websearch.api.a.a.pl(14);
        if (this.GmJ != null) {
            this.GmJ.bCA();
        }
        if (this.VfU != null) {
            this.VfU.bCA();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        try {
            this.GmS.onUIPause();
            ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
        } catch (Exception e2) {
        }
        com.tencent.mm.plugin.websearch.api.a.a.pl(15);
        if (this.GmJ != null) {
            this.GmJ.aGj();
        }
        if (this.VfU != null) {
            this.VfU.aGj();
        }
    }

    /* access modifiers changed from: protected */
    public void acb(int i2) {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        com.tencent.mm.plugin.topstory.a.i.a(this.GjJ, getActivityBrowseTimeMs(), this.GmT.acd(this.GjJ.Nig));
        if (this.mqz) {
            this.GmB.disable();
            this.GmB.Gnj = null;
            this.GmB = null;
        }
        if (this.Gnb != null) {
            com.tencent.mm.kernel.g.azz().a(this.Gnb);
        }
        com.tencent.mm.kernel.g.azz().b(2802, this.Gnc);
        this.GmT.onUIDestroy();
        ((com.tencent.mm.plugin.topstory.a.b) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.GjJ);
        this.GmS.onUIDestroy();
        this.GmP.onUIDestroy();
        this.GmQ.onUIDestroy();
        this.GmR.onUIDestroy();
        com.tencent.mm.plugin.websearch.api.a.a.pl(16);
        if (this.VfU != null) {
            this.VfU.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public void fyx() {
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public void fyy() {
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
        return com.tencent.mm.plugin.topstory.a.h.aTv(this.GjJ.sGQ);
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

    public final void ww(boolean z) {
        if (z) {
            this.GjJ.guh = true;
        } else {
            this.GjJ.guh = false;
            if (getSystemVolume() == 0) {
                fzv();
            }
        }
        fzu();
    }

    private void fzu() {
        if (this.GjJ.guh) {
            this.Gmy.setBackgroundResource(R.raw.top_story_volume_off);
        } else {
            this.Gmy.setBackgroundResource(R.raw.top_story_volume_on);
        }
        if (this.GmS.GnZ) {
            this.GmS.setMute(this.GjJ.guh);
        }
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

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void ay(final View view, final int i2) {
        if (this.GmS.dFG()) {
            this.GmS.cXa();
            this.GmU = true;
        }
        this.GmV = new d(getContext(), this.GmT.acd(i2), new d.a() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.topstory.ui.widget.d.a
            public final void e(eiw eiw) {
                AppMethodBeat.i(126089);
                if (eiw.NiE != null) {
                    TopStoryBaseVideoUI.this.az(view, i2);
                }
                TopStoryBaseVideoUI.this.GmV.dismiss();
                AppMethodBeat.o(126089);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.widget.d.a
            public final void f(eiw eiw) {
                AppMethodBeat.i(126090);
                p pVar = p.GnV;
                p.a(TopStoryBaseVideoUI.this, TopStoryBaseVideoUI.this.fyD(), eiw);
                TopStoryBaseVideoUI.this.GmV.dismiss();
                e.INSTANCE.a(17080, 65, 2);
                AppMethodBeat.o(126090);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.widget.d.a
            public final void g(eiw eiw) {
                AppMethodBeat.i(164124);
                com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
                if (com.tencent.mm.util.c.hde()) {
                    String str = TopStoryBaseVideoUI.this.fyC() + com.tencent.mm.plugin.topstory.ui.c.bu(eiw.psI, eiw.Nip) + ".mp4";
                    String str2 = "/sdcard/video/" + eiw.title + ".mp4";
                    if (s.YS("/sdcard/video/")) {
                        s.boN("/sdcard/video/");
                    }
                    s.nw(str, str2);
                    Toast.makeText(TopStoryBaseVideoUI.this, "copy success " + eiw.title, 0).show();
                }
                AppMethodBeat.o(164124);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.widget.d.a
            public final void onDismiss() {
                AppMethodBeat.i(126091);
                Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "more popupWindow dismiss");
                if (TopStoryBaseVideoUI.this.GmU) {
                    TopStoryBaseVideoUI.this.GmU = false;
                    if (TopStoryBaseVideoUI.this.GmW) {
                        AppMethodBeat.o(126091);
                        return;
                    }
                    TopStoryBaseVideoUI.this.GmS.eYd();
                    if (TopStoryBaseVideoUI.this.Gna) {
                        try {
                            ((f) TopStoryBaseVideoUI.this.GmS.GnY.getControlBar()).bJB();
                            AppMethodBeat.o(126091);
                            return;
                        } catch (Exception e2) {
                        }
                    }
                }
                AppMethodBeat.o(126091);
            }
        });
        if (this.Gna) {
            this.GmV.a(view, true, 0 - com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 40), com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16));
            try {
                ((f) this.GmS.GnY.getControlBar()).crH();
            } catch (Exception e2) {
            }
        } else {
            this.GmV.a(view, false, 0, 0);
        }
        e.INSTANCE.a(17080, 65, 1);
    }

    public final void az(View view, final int i2) {
        this.GmW = true;
        final eiw acd = this.GmT.acd(i2);
        this.GmX = new b(getContext(), acd, new b.a() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.topstory.ui.widget.b.a
            public final void v(Set<any> set) {
                AppMethodBeat.i(126092);
                Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
                u.makeText(TopStoryBaseVideoUI.this.getContext(), (int) R.string.hpt, 0).show();
                com.tencent.mm.plugin.topstory.a.i.a(TopStoryBaseVideoUI.this.fyD(), acd, set, TopStoryBaseVideoUI.this.GmT.fzy());
                TopStoryBaseVideoUI.this.GmS.stopPlay();
                TopStoryBaseVideoUI.this.GmT.acc(i2);
                if (TopStoryBaseVideoUI.this.GmT.fzy() == 0) {
                    TopStoryBaseVideoUI.this.finish();
                    AppMethodBeat.o(126092);
                } else if (TopStoryBaseVideoUI.this.Gna) {
                    TopStoryBaseVideoUI.this.GmH.ck(i2 + TopStoryBaseVideoUI.this.GmH.getHeadersCount());
                    TopStoryBaseVideoUI.this.GmD.atj.notifyChanged();
                    TopStoryBaseVideoUI.this.GmF.a(0, 3, (Interpolator) null);
                    AppMethodBeat.o(126092);
                } else {
                    TopStoryBaseVideoUI.this.GmD.ck(i2 + TopStoryBaseVideoUI.this.GmD.getHeadersCount());
                    TopStoryBaseVideoUI.this.GmH.atj.notifyChanged();
                    AppMethodBeat.o(126092);
                }
            }

            @Override // com.tencent.mm.plugin.topstory.ui.widget.b.a
            public final void onDismiss() {
                AppMethodBeat.i(126093);
                Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
                if (TopStoryBaseVideoUI.this.GmW) {
                    TopStoryBaseVideoUI.this.GmS.eYd();
                    TopStoryBaseVideoUI.this.GmW = false;
                    if (TopStoryBaseVideoUI.this.Gna) {
                        try {
                            ((f) TopStoryBaseVideoUI.this.GmS.GnY.getControlBar()).bJB();
                            AppMethodBeat.o(126093);
                            return;
                        } catch (Exception e2) {
                        }
                    }
                }
                AppMethodBeat.o(126093);
            }
        });
        if (this.Gna) {
            this.GmX.a(view, true, 0 - com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 40), com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16));
            try {
                ((f) this.GmS.GnY.getControlBar()).crH();
            } catch (Exception e2) {
            }
        } else {
            this.GmX.a(view, false, 0, 0 - com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 10));
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
    public void s(final List<eiw> list, final boolean z) {
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(126077);
                if (TopStoryBaseVideoUI.this.Gna) {
                    TopStoryBaseVideoUI.this.GmH.t(list, z);
                    TopStoryBaseVideoUI.this.GmD.atj.notifyChanged();
                    AppMethodBeat.o(126077);
                    return;
                }
                TopStoryBaseVideoUI.this.GmD.t(list, z);
                TopStoryBaseVideoUI.this.GmH.atj.notifyChanged();
                AppMethodBeat.o(126077);
            }
        });
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public void aTE(String str) {
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean fyL() {
        return this.GjJ.Nib == 100203;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int getVideoHeight() {
        if (this.videoHeight == 0) {
            if (!fyL()) {
                this.videoHeight = (getVideoWidth() * 280) / m.CTRL_INDEX;
            } else {
                this.videoHeight = TAVExporter.VIDEO_EXPORT_HEIGHT;
                int i2 = (cZM().y * 3) / 5;
                if (this.videoHeight > i2) {
                    this.videoHeight = i2;
                }
                Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "getVideoHeight %d maxVideoHeight %d", Integer.valueOf(this.videoHeight), Integer.valueOf(i2));
            }
        }
        return this.videoHeight;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final int getVideoWidth() {
        return Math.min(cZM().x, cZM().y);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final Point cZM() {
        if (this.imX == null) {
            this.imX = ao.az(this);
        }
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "lxl screenSize:%s, %s", Integer.valueOf(this.imX.x), Integer.valueOf(this.imX.y));
        return this.imX;
    }

    private int getSystemVolume() {
        return ((AudioManager) getApplicationContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
    }

    private void fzv() {
        com.tencent.mm.compatible.b.a.a((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE), 3, 1, 0);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z = true;
        if (i2 == 25 && keyEvent.getAction() == 0) {
            Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", Integer.valueOf(getSystemVolume()));
            eit eit = this.GjJ;
            if (getSystemVolume() > 1) {
                z = false;
            }
            eit.guh = z;
            fzu();
        } else if (i2 == 24 && keyEvent.getAction() == 0) {
            Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", Integer.valueOf(getSystemVolume()));
            this.GjJ.guh = false;
            fzu();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void fyM() {
        fzl();
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public int fyN() {
        return com.tencent.mm.plugin.topstory.ui.a.GjN;
    }

    /* access modifiers changed from: package-private */
    public class a extends v {
        private a() {
        }

        /* synthetic */ a(TopStoryBaseVideoUI topStoryBaseVideoUI, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.as
        public final void D(RecyclerView.v vVar) {
            AppMethodBeat.i(126094);
            super.D(vVar);
            TopStoryBaseVideoUI.this.fzp();
            TopStoryBaseVideoUI.this.GmE.b(TopStoryBaseVideoUI.this);
            Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", Integer.valueOf(vVar.lR()));
            AppMethodBeat.o(126094);
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final boolean isFullscreenMode() {
        return this.Gna;
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
    public final void a(eiw eiw, View view) {
        boolean z;
        if (eiw == null) {
            return;
        }
        if (!NetStatusUtil.isConnected(this)) {
            Toast.makeText(getContext(), getString(R.string.hpy), 0).show();
            return;
        }
        if (this.Gnb != null) {
            com.tencent.mm.kernel.g.azz().a(this.Gnb);
        }
        this.Gnb = new j(eiw, eiw.wWb, eiw.NiC ? 5 : 4, new StringBuilder().append(System.currentTimeMillis()).toString(), this.GjJ.scene, this.GjJ.hes, fyL() ? 318 : com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, eiw.psI, eiw.NiD);
        com.tencent.mm.kernel.g.azz().a(this.Gnb, 0);
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
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onWowBtnClick thumb:" + eiw.NiC);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void fyR() {
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(126080);
                a(TopStoryBaseVideoUI.this.GmD);
                a(TopStoryBaseVideoUI.this.GmH);
                AppMethodBeat.o(126080);
            }

            private static void a(e eVar) {
                AppMethodBeat.i(126081);
                int footersCount = eVar.getFootersCount();
                int itemCount = eVar.getItemCount();
                eVar.fyU();
                eVar.at(itemCount - footersCount, footersCount);
                AppMethodBeat.o(126081);
            }
        });
    }

    @Override // com.tencent.mm.plugin.topstory.a.c
    public void jm(int i2, int i3) {
        this.GmS.jp(i2, i3);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final RecyclerView getRecyclerView() {
        if (this.Gna) {
            return this.GmF;
        }
        return this.GmC;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final e fyK() {
        if (this.Gna) {
            return this.GmH;
        }
        return this.GmD;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final aj fyG() {
        if (this.Gna) {
            return this.GmZ;
        }
        return this.GmY;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final RecyclerView.LayoutManager getLayoutManager() {
        if (this.Gna) {
            return this.GmG;
        }
        return this.pcs;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.b
    public final void a(eiw eiw) {
        if (!this.Gna) {
            this.jVO.setText(R.string.fvg);
            this.GmA.setVisibility(8);
        }
        if (this.GmJ != null) {
            this.GmJ.a(this.GjJ, eiw);
        }
        if (this.VfU != null) {
            this.VfU.a(this.GjJ, eiw);
        }
    }

    static /* synthetic */ void a(TopStoryBaseVideoUI topStoryBaseVideoUI) {
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) topStoryBaseVideoUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(126084);
                mVar.clear();
                mVar.kV(2, R.string.bx0);
                AppMethodBeat.o(126084);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(126085);
                switch (menuItem.getItemId()) {
                    case 2:
                        if (TopStoryBaseVideoUI.this.GmJ != null) {
                            TopStoryBaseVideoUI.this.GmJ.ic(true);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(126085);
            }
        };
        eVar.dGm();
    }
}
