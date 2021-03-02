package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Process;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavSearchUI;
import com.tencent.mm.plugin.fav.ui.gallery.f;
import com.tencent.mm.plugin.fav.ui.gallery.g;
import com.tencent.mm.plugin.fav.ui.p;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class c implements f.b, g.b {
    Activity dKq;
    private TextView gAp;
    int gsi;
    public View gvQ;
    private long hlB = 0;
    private long iTC = 0;
    private RecyclerView mRecyclerView;
    private ProgressDialog qoU;
    boolean qpl = true;
    private int qpm;
    and tfo;
    g.a tjZ;
    private RelativeLayout tka;
    private LinearLayout tkb;
    TextView tkc;
    private TextView tkd;
    private ImageButton tke;
    private ImageButton tkf;
    private boolean tkg = false;
    private int tkh = -1;
    public a tki;
    private long tkj;
    private View.OnClickListener tkk = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass3 */

        {
            AppMethodBeat.i(107365);
            AppMethodBeat.o(107365);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(235357);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c.this.cWH();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(235357);
        }
    };
    private View.OnClickListener tkl = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(107369);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c.this.cWI();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107369);
        }
    };
    private View.OnClickListener tkm = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(107370);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (c.this.tjZ != null) {
                c.this.tjZ.Ig(((Integer) view.getTag()).intValue());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107370);
        }
    };
    public List<d> tkn = new ArrayList();

    public interface a {
        void Ia(int i2);

        void cVN();

        void cVO();

        void cVP();

        void cVQ();

        void cVR();

        void fV(int i2, int i3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.fav.ui.gallery.a] */
    @Override // com.tencent.mm.plugin.fav.ui.gallery.b
    public final /* bridge */ /* synthetic */ void a(g.a aVar) {
        AppMethodBeat.i(235367);
        this.tjZ = aVar;
        if (this.tjZ != null) {
            this.tjZ.a((f.b) this);
        }
        AppMethodBeat.o(235367);
    }

    public c(Activity activity, View view) {
        AppMethodBeat.i(107375);
        this.dKq = activity;
        this.gvQ = view;
        this.tkg = true;
        h hVar = null;
        switch (g.c.TYPE_IMAGE_AND_VIDEO) {
            case TYPE_IMAGE_AND_VIDEO:
                hVar = new h(activity);
                break;
        }
        hVar.a((b) this);
        this.tfo = new and();
        this.tfo.scene = 2;
        this.tfo.pHw = 2;
        this.tfo.index = 0;
        this.tfo.sessionId = "";
        this.tfo.query = "";
        this.tfo.tay = "";
        this.tka = (RelativeLayout) this.gvQ.findViewById(R.id.dps);
        this.tkb = (LinearLayout) this.gvQ.findViewById(R.id.dpo);
        this.tkc = (TextView) this.gvQ.findViewById(R.id.lb);
        this.gAp = (TextView) this.gvQ.findViewById(R.id.heq);
        this.mRecyclerView = (RecyclerView) this.gvQ.findViewById(R.id.dpt);
        this.tke = (ImageButton) this.gvQ.findViewById(R.id.dpn);
        this.tkf = (ImageButton) this.gvQ.findViewById(R.id.dpm);
        this.mRecyclerView.setLayoutManager(this.tjZ.eS(this.dKq));
        this.mRecyclerView.a(this.tjZ.fi(this.dKq));
        this.mRecyclerView.setAdapter(this.tjZ.cyF());
        ((f) this.tjZ.cWP()).tfo = this.tfo;
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setOnScrollListener(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(235352);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(235352);
            }

            {
                AppMethodBeat.i(107360);
                AppMethodBeat.o(107360);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(235351);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(235351);
            }
        });
        this.mRecyclerView.a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass2 */
            private Runnable qpo = new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(235353);
                    c.this.tkc.startAnimation(AnimationUtils.loadAnimation(c.this.dKq, R.anim.bs));
                    c.this.tkc.setVisibility(8);
                    AppMethodBeat.o(235353);
                }
            };

            {
                AppMethodBeat.i(235354);
                AppMethodBeat.o(235354);
            }

            private void kI(boolean z) {
                AppMethodBeat.i(235355);
                if (z) {
                    c.this.tkc.removeCallbacks(this.qpo);
                    if (c.this.tkc.getVisibility() != 0) {
                        c.this.tkc.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(c.this.dKq, R.anim.br);
                        c.this.tkc.setVisibility(0);
                        c.this.tkc.startAnimation(loadAnimation);
                        AppMethodBeat.o(235355);
                        return;
                    }
                } else {
                    c.this.tkc.removeCallbacks(this.qpo);
                    c.this.tkc.postDelayed(this.qpo, 256);
                }
                AppMethodBeat.o(235355);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(107363);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                f fVar = (f) c.this.tjZ.cWP();
                f.d If = fVar.If(((LinearLayoutManager) c.this.tjZ.eS(c.this.dKq)).ks());
                if (If == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                    AppMethodBeat.o(107363);
                    return;
                }
                c.this.tkc.setText(Util.nullAs(fVar.Cc(If.timeStamp), ""));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(107363);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(235356);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                if (1 == i2) {
                    kI(true);
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, c.this.gsi);
                    c.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, WXHardCoderJNI.hcMediaGalleryScrollDelay, WXHardCoderJNI.hcMediaGalleryScrollCPU, WXHardCoderJNI.hcMediaGalleryScrollIO, WXHardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
                } else if (i2 == 0) {
                    kI(false);
                }
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    if (((LinearLayoutManager) recyclerView.getLayoutManager()).ks() == 0 && !c.this.qpl) {
                        c.this.tjZ.G(false, -1);
                    }
                    c.this.qpl = false;
                    q.bcV().onScrollStateChanged(i2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(235356);
            }
        });
        this.tkd = (TextView) this.gvQ.findViewById(R.id.hhb);
        this.tkd.setOnClickListener(this.tkk);
        this.tke.setTag(0);
        this.tke.setOnClickListener(this.tkm);
        this.tkf.setTag(1);
        this.tkf.setOnClickListener(this.tkm);
        AppMethodBeat.o(107375);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.f.b
    public final void cVN() {
        AppMethodBeat.i(235362);
        if (this.tki != null) {
            this.tki.cVN();
        }
        AppMethodBeat.o(235362);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.f.b
    public final void cWF() {
        AppMethodBeat.i(235363);
        if (this.tki != null) {
            this.tki.cVO();
        }
        AppMethodBeat.o(235363);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.f.b
    public final void cVP() {
        AppMethodBeat.i(235364);
        if (this.tki != null) {
            this.tki.cVP();
        }
        AppMethodBeat.o(235364);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.f.b
    public final void cVQ() {
        AppMethodBeat.i(235365);
        if (this.tki != null) {
            this.tki.cVQ();
        }
        AppMethodBeat.o(235365);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.f.b
    public final void cVR() {
        AppMethodBeat.i(235366);
        if (this.tki != null) {
            this.tki.cVR();
        }
        AppMethodBeat.o(235366);
    }

    public final void bqe() {
        AppMethodBeat.i(107376);
        if (this.tjZ != null) {
            this.tkj = System.currentTimeMillis();
            this.tjZ.G(true, this.tkh);
        }
        AppMethodBeat.o(107376);
    }

    public final void onResume() {
        com.tencent.matrix.trace.f.c cVar;
        AppMethodBeat.i(107377);
        this.iTC = Util.nowSecond();
        if (!(!com.tencent.matrix.b.isInstalled() || com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
            this.hlB = (long) cVar.dcx;
        }
        if (this.tjZ != null) {
            this.tjZ.onResume();
        }
        if (this.tkg) {
            if (this.tjZ == null || !this.tjZ.cWG()) {
                cWI();
            } else {
                cWH();
            }
        }
        this.tkg = false;
        AppMethodBeat.o(107377);
    }

    public final void onPause() {
        com.tencent.matrix.trace.f.c cVar;
        AppMethodBeat.i(107378);
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.gsi);
        this.gsi = 0;
        if (!(!com.tencent.matrix.b.isInstalled() || com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
            this.hlB = Math.max(0L, ((long) cVar.dcx) - this.hlB);
        }
        this.iTC = Util.nowSecond() > this.iTC ? Util.nowSecond() - this.iTC : 1;
        WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.hlB, this.iTC);
        this.hlB = 0;
        this.iTC = 0;
        AppMethodBeat.o(107378);
    }

    public final void onDestroy() {
        AppMethodBeat.i(107379);
        if (this.tjZ != null) {
            this.tjZ.onDetach();
        }
        AppMethodBeat.o(107379);
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(107380);
        this.gvQ.setVisibility(i2);
        AppMethodBeat.o(107380);
    }

    public final boolean cWG() {
        AppMethodBeat.i(107381);
        if (this.tjZ == null) {
            AppMethodBeat.o(107381);
            return false;
        }
        boolean cWG = this.tjZ.cWG();
        AppMethodBeat.o(107381);
        return cWG;
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.b
    public final void kF(boolean z) {
        AppMethodBeat.i(107382);
        if (z) {
            kH(true);
            AppMethodBeat.o(107382);
            return;
        }
        this.qpm = ((GridLayoutManager) this.mRecyclerView.getLayoutManager()).ku();
        AppMethodBeat.o(107382);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.b
    public final void D(boolean z, int i2) {
        AppMethodBeat.i(107383);
        Log.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(this.tkh));
        if (this.tki != null) {
            this.tki.fV((int) (System.currentTimeMillis() - this.tkj), i2);
        }
        if (z) {
            kH(false);
            this.mRecyclerView.getAdapter().atj.notifyChanged();
            if (this.tkh > 0) {
                if (this.tkh % 4 == 0) {
                    this.tkh++;
                }
                RecyclerView recyclerView = this.mRecyclerView;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.tkh, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
            } else {
                int itemCount = this.mRecyclerView.getAdapter().getItemCount();
                RecyclerView recyclerView2 = this.mRecyclerView;
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(itemCount - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a3.axQ(), "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView2.scrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/fav/ui/gallery/FavMediaHistoryGallery", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (i2 <= 0) {
                this.gAp.setVisibility(0);
                this.mRecyclerView.setVisibility(8);
                this.gAp.setText(this.dKq.getString(R.string.c8m));
                AppMethodBeat.o(107383);
                return;
            }
            this.gAp.setVisibility(8);
            this.mRecyclerView.setVisibility(0);
            AppMethodBeat.o(107383);
        } else if (i2 > 0) {
            this.mRecyclerView.getAdapter().atj.notifyChanged();
            AppMethodBeat.o(107383);
        } else {
            this.mRecyclerView.getAdapter().ci(0);
            AppMethodBeat.o(107383);
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.b
    public final void Ie(int i2) {
        AppMethodBeat.i(107384);
        if (cWG()) {
            mH(i2 > 0);
        }
        AppMethodBeat.o(107384);
    }

    public final void cWH() {
        AppMethodBeat.i(107385);
        if (this.tjZ != null) {
            this.tjZ.cWH();
        }
        this.tka.setVisibility(8);
        this.tkb.setVisibility(0);
        mH(false);
        AppMethodBeat.o(107385);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.b
    public final void cWI() {
        AppMethodBeat.i(107386);
        if (this.tjZ != null) {
            this.tjZ.cWI();
        }
        this.tka.setVisibility(0);
        this.tkb.setVisibility(8);
        AppMethodBeat.o(107386);
    }

    private void mH(boolean z) {
        AppMethodBeat.i(107387);
        this.tke.setEnabled(z);
        this.tkf.setEnabled(z);
        AppMethodBeat.o(107387);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.b
    public final void dM(List<d> list) {
        AppMethodBeat.i(107388);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(107388);
            return;
        }
        this.tkn.clear();
        this.tkn.addAll(list);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        if (this.tkn.size() == 1) {
            d dVar = list.get(0);
            String a2 = com.tencent.mm.plugin.fav.a.b.a(dVar.dLo);
            String d2 = com.tencent.mm.plugin.fav.a.b.d(dVar.dLo);
            if (s.YS(a2)) {
                intent.putExtra("image_path", a2);
            } else {
                intent.putExtra("image_path", d2);
            }
            intent.putExtra("Retr_Msg_Type", (dVar.cWL() || dVar.cWJ()) ? 1 : 0);
            intent.putExtra("select_is_ret", true);
        } else {
            intent.putExtra("scene_from", 1);
            intent.putExtra("Retr_Msg_Type", 17);
            intent.putExtra("select_fav_select_count", this.tkn.size());
        }
        com.tencent.mm.br.c.c(this.dKq, ".ui.transmit.SelectConversationUI", intent, 1);
        for (d dVar2 : list) {
            h.w(dVar2.qNT.field_localId, 1);
        }
        if (this.tki != null) {
            this.tki.Ia(this.tkn.size());
        }
        AppMethodBeat.o(107388);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.b
    public final void dN(List<d> list) {
        AppMethodBeat.i(107389);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(107389);
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final boolean z = false;
        HashSet hashSet = new HashSet();
        final com.tencent.mm.plugin.fav.a.g gVar = null;
        for (d dVar : list) {
            gVar = dVar.qNT;
            if (gVar == null || !(gVar.field_type == 18 || gVar.field_type == 14)) {
                arrayList.add(gVar);
            } else {
                z = true;
                hashSet.add(Long.valueOf(gVar.field_localId));
            }
        }
        if (arrayList.size() != 0) {
            com.tencent.mm.ui.base.h.a(this.dKq, this.dKq.getString(R.string.c96), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(235360);
                    p.a(c.this.dKq, arrayList, new p.a() {
                        /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass8.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.fav.ui.p.a
                        public final void cVU() {
                            AppMethodBeat.i(235359);
                            Log.v("MicroMsg.MediaHistoryGalleryUI", "do refresh job");
                            c.this.tjZ.G(true, -1);
                            AppMethodBeat.o(235359);
                        }
                    });
                    if (z) {
                        FavSearchUI.ak(c.this.dKq);
                    }
                    if (c.this.tki != null) {
                        a aVar = c.this.tki;
                        arrayList.size();
                        aVar.cVO();
                    }
                    AppMethodBeat.o(235360);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(107389);
        } else if (hashSet.size() >= 2) {
            FavSearchUI.ak(this.dKq);
            AppMethodBeat.o(107389);
        } else {
            f.a aVar = new f.a(this.dKq);
            aVar.bow(this.dKq.getString(R.string.c97));
            aVar.boB(this.dKq.getString(R.string.c92));
            aVar.boA(this.dKq.getString(R.string.c_q));
            aVar.a(new f.c() {
                /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass6 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                }
            }, new f.c() {
                /* class com.tencent.mm.plugin.fav.ui.gallery.c.AnonymousClass7 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(235358);
                    c.this.tfo.index = -1;
                    ((y) com.tencent.mm.kernel.g.af(y.class)).a(c.this.dKq, gVar, c.this.tfo);
                    AppMethodBeat.o(235358);
                }
            });
            aVar.show();
            AppMethodBeat.o(107389);
        }
    }

    private void kH(boolean z) {
        AppMethodBeat.i(107390);
        Log.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.qoU = com.tencent.mm.ui.base.q.a(this.dKq, this.dKq.getString(R.string.ekc), true, 0, null);
            AppMethodBeat.o(107390);
            return;
        }
        if (this.qoU != null && this.qoU.isShowing()) {
            this.qoU.dismiss();
            this.qoU = null;
        }
        AppMethodBeat.o(107390);
    }
}
