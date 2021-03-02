package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.f.a;
import com.tencent.mm.ui.chatting.k.e;

public class MediaHistoryGalleryUI extends MMActivity implements View.OnClickListener, a.b {
    private a.AbstractC2092a PBo;
    private b PBp;
    private boolean PBq;
    private boolean PBr;
    private boolean PBs;
    private long PlX;
    private View PxB;
    private View PxD;
    private View PxE;
    private View PxF;
    private View PxG;
    private String gAn;
    private TextView gAp;
    private int gsi;
    private long hlB = 0;
    private long iTC = 0;
    private RecyclerView mRecyclerView;
    private ProgressDialog qoU;
    private boolean qpl = true;
    private int qpm;
    private TextView tkc;
    private boolean tkg = false;
    private int tkh = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MediaHistoryGalleryUI() {
        AppMethodBeat.i(36358);
        AppMethodBeat.o(36358);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.chatting.k.c] */
    @Override // com.tencent.mm.ui.chatting.view.a
    public final /* bridge */ /* synthetic */ void a(a.AbstractC2092a aVar) {
        this.PBo = aVar;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        a.AbstractC2092a a2;
        AppMethodBeat.i(36359);
        h.q(this);
        super.onCreate(bundle);
        this.tkg = true;
        Intent intent = getIntent();
        this.PBq = intent.getIntExtra("kintent_intent_source", 0) == 1;
        this.gAn = intent.getStringExtra("kintent_talker");
        this.tkh = intent.getIntExtra("kintent_image_index", -1);
        this.PBr = intent.getBooleanExtra("key_is_biz_chat", false);
        this.PlX = getIntent().getLongExtra("key_biz_chat_id", -1);
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 1:
                a2 = a.a(this, a.c.TYPE_IMAGE_AND_VIDEO);
                break;
            default:
                a2 = a.a(this, a.c.TYPE_IMAGE_AND_VIDEO);
                break;
        }
        a2.a(this);
        setActionbarColor(getContext().getResources().getColor(R.color.ko));
        setNavigationbarColor(getContext().getResources().getColor(R.color.ko));
        initView();
        this.PBo.G(true, this.tkh);
        h.r(this);
        AppMethodBeat.o(36359);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        c cVar;
        AppMethodBeat.i(36360);
        this.iTC = Util.nowSecond();
        if (!(!com.tencent.matrix.b.isInstalled() || com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
            this.hlB = (long) cVar.dcx;
        }
        super.onResume();
        this.PBo.onResume();
        if (this.tkg) {
            if (this.PBo.cWG()) {
                cWH();
            } else {
                cWI();
            }
        }
        this.tkg = false;
        AppMethodBeat.o(36360);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        c cVar;
        AppMethodBeat.i(36361);
        super.onPause();
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, this.gsi);
        this.gsi = 0;
        if (!(!com.tencent.matrix.b.isInstalled() || com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
            this.hlB = Math.max(0L, ((long) cVar.dcx) - this.hlB);
        }
        this.iTC = Util.nowSecond() > this.iTC ? Util.nowSecond() - this.iTC : 1;
        WXHardCoderJNI.reportFPS(703, WXHardCoderJNI.hcMediaGalleryScrollAction, 1, this.hlB, this.iTC);
        this.hlB = 0;
        this.iTC = 0;
        AppMethodBeat.o(36361);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(36362);
        super.onDestroy();
        this.PBo.onDetach();
        AppMethodBeat.o(36362);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(36363);
        super.initView();
        this.PxB = findViewById(R.id.fju);
        this.PxE = findViewById(R.id.iuu);
        this.PxG = findViewById(R.id.blh);
        this.PxF = findViewById(R.id.h__);
        this.PxD = findViewById(R.id.cb4);
        this.PxD.setTag(1);
        this.PxE.setTag(0);
        this.PxF.setTag(3);
        this.PxG.setTag(2);
        this.PxD.setOnClickListener(this);
        this.PxE.setOnClickListener(this);
        this.PxF.setOnClickListener(this);
        this.PxG.setOnClickListener(this);
        this.tkc = (TextView) findViewById(R.id.lb);
        this.gAp = (TextView) findViewById(R.id.heq);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.dpt);
        this.mRecyclerView.setBackgroundColor(getResources().getColor(R.color.cb));
        findViewById(R.id.bes).setBackgroundColor(getResources().getColor(R.color.cb));
        this.mRecyclerView.setLayoutManager(this.PBo.eS(this));
        this.mRecyclerView.a(this.PBo.fi(this));
        this.PBp = this.PBo.ch(this.gAn, this.PlX);
        this.mRecyclerView.setAdapter(this.PBp);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setOnScrollListener(new RecyclerView.l() {
            /* class com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(233455);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(233455);
            }

            {
                AppMethodBeat.i(36345);
                AppMethodBeat.o(36345);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(233454);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(233454);
            }
        });
        this.mRecyclerView.a(new RecyclerView.l() {
            /* class com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.AnonymousClass2 */
            private Runnable qpo = new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(233456);
                    MediaHistoryGalleryUI.this.tkc.startAnimation(AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), R.anim.bs));
                    MediaHistoryGalleryUI.this.tkc.setVisibility(8);
                    AppMethodBeat.o(233456);
                }
            };

            {
                AppMethodBeat.i(233457);
                AppMethodBeat.o(233457);
            }

            private void kI(boolean z) {
                AppMethodBeat.i(233458);
                if (z) {
                    MediaHistoryGalleryUI.this.tkc.removeCallbacks(this.qpo);
                    if (MediaHistoryGalleryUI.this.tkc.getVisibility() != 0) {
                        MediaHistoryGalleryUI.this.tkc.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.getContext(), R.anim.br);
                        MediaHistoryGalleryUI.this.tkc.setVisibility(0);
                        MediaHistoryGalleryUI.this.tkc.startAnimation(loadAnimation);
                        AppMethodBeat.o(233458);
                        return;
                    }
                } else {
                    MediaHistoryGalleryUI.this.tkc.removeCallbacks(this.qpo);
                    MediaHistoryGalleryUI.this.tkc.postDelayed(this.qpo, 256);
                }
                AppMethodBeat.o(233458);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(36347);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                b bVar2 = (b) MediaHistoryGalleryUI.this.PBo.cWP();
                b.c amx = bVar2.amx(((LinearLayoutManager) MediaHistoryGalleryUI.this.PBo.eS(MediaHistoryGalleryUI.this)).ks());
                if (amx == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                    AppMethodBeat.o(36347);
                    return;
                }
                MediaHistoryGalleryUI.this.tkc.setText(Util.nullAs(bVar2.Cc(amx.timeStamp), ""));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(36347);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(233459);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                if (1 == i2) {
                    kI(true);
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.this.gsi);
                    MediaHistoryGalleryUI.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, WXHardCoderJNI.hcMediaGalleryScrollDelay, WXHardCoderJNI.hcMediaGalleryScrollCPU, WXHardCoderJNI.hcMediaGalleryScrollIO, WXHardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
                } else if (i2 == 0) {
                    kI(false);
                }
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    if (((LinearLayoutManager) recyclerView.getLayoutManager()).ks() == 0 && !MediaHistoryGalleryUI.this.qpl && MediaHistoryGalleryUI.this.PBo != null && MediaHistoryGalleryUI.this.PBp != null && !MediaHistoryGalleryUI.this.PBp.qor) {
                        MediaHistoryGalleryUI.this.PBo.G(false, -1);
                    }
                    MediaHistoryGalleryUI.this.qpl = false;
                    q.bcV().onScrollStateChanged(i2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(233459);
            }
        });
        setMMTitle(this.PBo.bmB());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.AnonymousClass3 */

            {
                AppMethodBeat.i(36349);
                AppMethodBeat.o(36349);
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(233460);
                MediaHistoryGalleryUI.this.finish();
                AppMethodBeat.o(233460);
                return true;
            }
        });
        AppMethodBeat.o(36363);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b6x;
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final void kF(boolean z) {
        AppMethodBeat.i(36364);
        if (z) {
            Q(true, null);
        } else {
            this.qpm = ((GridLayoutManager) this.mRecyclerView.getLayoutManager()).ku();
        }
        Log.i("MicroMsg.MediaHistoryGalleryUI", "onDataLoading mLastVisibleItemPosition:%s", Integer.valueOf(this.qpm));
        AppMethodBeat.o(36364);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final void D(boolean z, int i2) {
        AppMethodBeat.i(36365);
        Log.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(this.tkh));
        if (z) {
            Q(false, null);
            this.mRecyclerView.getAdapter().atj.notifyChanged();
            if (this.tkh > 0) {
                if (this.tkh % 4 == 0) {
                    this.tkh++;
                }
                int itemCount = this.mRecyclerView.getAdapter().getItemCount();
                RecyclerView recyclerView = this.mRecyclerView;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Math.min(itemCount - 1, this.tkh), new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
            } else {
                int itemCount2 = this.mRecyclerView.getAdapter().getItemCount();
                RecyclerView recyclerView2 = this.mRecyclerView;
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(itemCount2 - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a3.axQ(), "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView2.scrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "onDataLoaded", "(ZI)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (i2 <= 0) {
                this.gAp.setVisibility(0);
                this.mRecyclerView.setVisibility(8);
                this.gAp.setTextColor(com.tencent.mm.cb.a.n(this, R.color.afz));
                this.gAp.setText(getString(R.string.b1r));
                AppMethodBeat.o(36365);
                return;
            }
            this.gAp.setVisibility(8);
            this.mRecyclerView.setVisibility(0);
            AppMethodBeat.o(36365);
        } else if (this.mRecyclerView.ld()) {
            Log.w("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isComputingLayout ");
            AppMethodBeat.o(36365);
        } else if (i2 > 0) {
            this.mRecyclerView.getAdapter().as(0, i2);
            this.mRecyclerView.getAdapter().aq(i2, this.qpm + i2);
            Log.i("MicroMsg.MediaHistoryGalleryUI", "onDataLoading notifyItemRangeChanged:%s", Integer.valueOf(this.qpm + i2));
            AppMethodBeat.o(36365);
        } else {
            this.mRecyclerView.getAdapter().ci(0);
            AppMethodBeat.o(36365);
        }
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final View getChildAt(int i2) {
        AppMethodBeat.i(36366);
        View childAt = this.mRecyclerView.getChildAt(i2);
        AppMethodBeat.o(36366);
        return childAt;
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final void Ie(int i2) {
        AppMethodBeat.i(36367);
        setMMTitle(getString(R.string.dn5, new Object[]{Integer.valueOf(i2)}));
        anm(i2);
        AppMethodBeat.o(36367);
    }

    public void onClick(View view) {
        AppMethodBeat.i(36368);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.PBo.Ig(((Integer) view.getTag()).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(36368);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(36369);
        super.onBackPressed();
        Log.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
        if (this.PBs) {
            this.PBo.gRS();
            AppMethodBeat.o(36369);
            return;
        }
        finish();
        AppMethodBeat.o(36369);
    }

    public final void cWH() {
        AppMethodBeat.i(36370);
        this.PBo.cWH();
        setMMTitle(getString(R.string.dn5, new Object[]{Integer.valueOf(this.PBo.gRR())}));
        this.PxB.setVisibility(0);
        this.PxB.startAnimation(AnimationUtils.loadAnimation(this, R.anim.dq));
        anm(this.PBo.gRR());
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.string.dls), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(36353);
                MediaHistoryGalleryUI.this.cWI();
                AppMethodBeat.o(36353);
                return true;
            }
        });
        AppMethodBeat.o(36370);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final void cWI() {
        AppMethodBeat.i(36371);
        this.PBo.cWI();
        setMMTitle(this.PBo.bmB());
        this.PxB.setVisibility(8);
        this.PxB.startAnimation(AnimationUtils.loadAnimation(this, R.anim.f6do));
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.string.dlt), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(36354);
                MediaHistoryGalleryUI.this.cWH();
                AppMethodBeat.o(36354);
                return true;
            }
        });
        AppMethodBeat.o(36371);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final void gRT() {
        AppMethodBeat.i(36372);
        this.PBs = true;
        Q(true, getString(R.string.e30));
        AppMethodBeat.o(36372);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final void gRS() {
        AppMethodBeat.i(36373);
        cWI();
        this.PBs = false;
        Q(false, "");
        AppMethodBeat.o(36373);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final void gRU() {
        String aKV;
        AppMethodBeat.i(36374);
        cWI();
        this.PBs = false;
        Q(false, "");
        int indexOf = com.tencent.mm.loader.j.b.aKV().indexOf(com.tencent.mm.loader.j.b.aKz());
        if (indexOf >= 0) {
            aKV = com.tencent.mm.loader.j.b.aKV().substring(indexOf);
        } else {
            aKV = com.tencent.mm.loader.j.b.aKV();
        }
        Toast.makeText(this, getString(R.string.b1s, new Object[]{aKV}), 1).show();
        AppMethodBeat.o(36374);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final void amL(int i2) {
        AppMethodBeat.i(36375);
        cWI();
        Q(false, "");
        if (i2 == 0) {
            i2 = R.string.dn3;
        }
        if (this.PBs) {
            com.tencent.mm.ui.base.h.a((Context) this, i2, (int) R.string.zb, true, (DialogInterface.OnClickListener) null);
        }
        this.PBs = false;
        AppMethodBeat.o(36375);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.b
    public final boolean gRV() {
        return this.PBs;
    }

    private void anm(int i2) {
        AppMethodBeat.i(36376);
        if (!this.PBo.cWG() || i2 <= 0) {
            this.PxD.setEnabled(false);
            this.PxE.setEnabled(false);
            this.PxF.setEnabled(false);
            this.PxG.setEnabled(false);
            AppMethodBeat.o(36376);
            return;
        }
        this.PxD.setEnabled(true);
        this.PxE.setEnabled(true);
        this.PxF.setEnabled(true);
        this.PxG.setEnabled(true);
        AppMethodBeat.o(36376);
    }

    private void Q(boolean z, String str) {
        AppMethodBeat.i(36377);
        Log.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            if (str == null) {
                str = getString(R.string.ekc);
            }
            this.qoU = com.tencent.mm.ui.base.q.a(this, str, true, 0, null);
            AppMethodBeat.o(36377);
            return;
        }
        if (this.qoU != null && this.qoU.isShowing()) {
            this.qoU.dismiss();
            this.qoU = null;
        }
        AppMethodBeat.o(36377);
    }

    static class a {
        public static a.AbstractC2092a a(Context context, a.c cVar) {
            AppMethodBeat.i(36357);
            e eVar = null;
            switch (cVar) {
                case TYPE_IMAGE_AND_VIDEO:
                    eVar = new e(context);
                    break;
            }
            AppMethodBeat.o(36357);
            return eVar;
        }
    }
}
