package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;

public abstract class FavBaseUI extends MMActivity implements AdapterView.OnItemClickListener {
    protected MMHandler hAk = new MMHandler(Looper.getMainLooper());
    protected TextView hSx;
    private final Object lockObj = new Object();
    private boolean tcX = false;
    protected boolean tcY = false;
    private boolean tcZ = false;
    private long tda = 0;
    protected ListView tdb;
    protected View tdc;
    private View tdd;
    protected c tde;
    protected View tdf;
    protected o tdg;
    protected c.a tdh = null;
    private i tdi = new i() {
        /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass8 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(106618);
            Log.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
            if (((ak) qVar).tbx) {
                Log.i("MicroMsg.FavoriteBaseUI", "need batch get return");
                AppMethodBeat.o(106618);
                return;
            }
            Log.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
            if (FavBaseUI.this.tcZ) {
                FavBaseUI.this.tcZ = false;
            }
            FavBaseUI.this.mz(false);
            FavBaseUI.this.cVE();
            AppMethodBeat.o(106618);
        }
    };
    private i tdj = new i() {
        /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass9 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(106619);
            Log.i("MicroMsg.FavoriteBaseUI", "on batch get end");
            if (FavBaseUI.this.tcZ) {
                Log.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
                FavBaseUI.this.tcZ = false;
                FavBaseUI.this.mz(false);
            }
            AppMethodBeat.o(106619);
        }
    };
    private Runnable tdk = new h() {
        /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass10 */

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MicroMsg.FavoriteBaseUI#notifyAdapterJob";
        }

        public final void run() {
            AppMethodBeat.i(106620);
            a cVz = FavBaseUI.this.cVz();
            cVz.boE();
            cVz.cWm();
            FavBaseUI.this.cVE();
            AppMethodBeat.o(106620);
        }
    };
    protected Runnable tdl = new Runnable() {
        /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass11 */

        public final void run() {
            AppMethodBeat.i(106621);
            a cVz = FavBaseUI.this.cVz();
            if (cVz.isEmpty() || SystemClock.elapsedRealtime() - FavBaseUI.this.tda >= 400) {
                FavBaseUI.this.tcX = false;
                FavBaseUI.this.tda = SystemClock.elapsedRealtime();
                Log.v("MicroMsg.FavoriteBaseUI", "do refresh job");
                cVz.notifyDataSetChanged();
                FavBaseUI.this.a(cVz);
                if (FavBaseUI.this.tcY) {
                    Log.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
                    FavBaseUI.this.tdb.setSelection(0);
                    FavBaseUI.this.tcY = false;
                }
                AppMethodBeat.o(106621);
                return;
            }
            Log.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.this.tda), 400);
            FavBaseUI.this.hAk.postDelayed(this, 200);
            AppMethodBeat.o(106621);
        }
    };
    private Runnable tdm = new h() {
        /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass2 */

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MicroMsg.FavoriteBaseUI#dataSetChangedJob";
        }

        public final void run() {
            AppMethodBeat.i(106612);
            synchronized (FavBaseUI.this.lockObj) {
                try {
                    FavBaseUI.this.cVA();
                    FavBaseUI.this.cVz().cWm();
                    FavBaseUI.this.cVE();
                } finally {
                    AppMethodBeat.o(106612);
                }
            }
        }
    };
    private MStorage.IOnStorageChange tdn = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass3 */
        long tdp = 0;

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(106613);
            Log.i("MicroMsg.FavoriteBaseUI", "[onNotifyChange] event=%s", str);
            FavBaseUI.this.workerHandler.removeCallbacks(FavBaseUI.this.tdm);
            if (Util.ticksToNow(this.tdp) > 200) {
                this.tdp = Util.currentTicks();
                FavBaseUI.this.workerHandler.post(FavBaseUI.this.tdm);
                AppMethodBeat.o(106613);
                return;
            }
            FavBaseUI.this.workerHandler.postDelayed(FavBaseUI.this.tdm, 200);
            AppMethodBeat.o(106613);
        }
    };
    protected MMHandler workerHandler;

    /* access modifiers changed from: protected */
    public abstract void cVA();

    /* access modifiers changed from: protected */
    public abstract boolean cVB();

    /* access modifiers changed from: protected */
    public abstract void cVC();

    /* access modifiers changed from: protected */
    public abstract View.OnClickListener cVD();

    public abstract a cVz();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a88;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        Log.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(g.aAc()));
        g.azz().a(new al(), 0);
        ((af) g.ah(af.class)).getFavItemInfoStorage().add(this.tdn);
        g.azz().a(400, this.tdi);
        g.azz().a(402, this.tdj);
        this.workerHandler = new MMHandler(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.tdg = new o(getContext(), 64);
        initView();
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        if (Util.nullAsNil((Integer) g.aAh().azQ().get(8217, (Object) null)) == 0) {
            Log.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
            this.tcZ = true;
            g.azz().a(new ak(), 0);
            if (this.tcZ) {
                Log.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
                if (cVz() == null || cVz().isEmpty()) {
                    mz(true);
                }
                mA(false);
            }
        } else {
            b.startSync();
            if (cVz().isEmpty()) {
                mz(true);
                mA(false);
                this.tdc.setVisibility(8);
            } else {
                mz(false);
                mA(false);
            }
        }
        ((af) g.ah(af.class)).getFavCdnService().run();
        ((af) g.ah(af.class)).getCheckCdnService().run();
        ((af) g.ah(af.class)).getSendService().run();
        ((af) g.ah(af.class)).getModService().run();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(106611);
                b.cUg();
                AppMethodBeat.o(106611);
            }
        });
        Log.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        com.tencent.mm.pluginsdk.wallet.h.setPayChannel(5);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        cVz();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i("MicroMsg.FavoriteBaseUI", "[onDestroy]");
        if (((af) g.ah(af.class)).getFavItemInfoStorage().cUP() == null) {
            Log.e("MicroMsg.FavoriteBaseUI", "[onDestroy] return getBaseDB is null");
            return;
        }
        this.tdg.destory();
        this.tdg = null;
        ((af) g.ah(af.class)).getFavItemInfoStorage().remove(this.tdn);
        g.azz().b(400, this.tdi);
        g.azz().b(402, this.tdj);
        this.workerHandler.quit();
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        long currentTimeMillis = System.currentTimeMillis();
        this.tdb = (ListView) findViewById(R.id.ce7);
        this.tdb.setDrawingCacheEnabled(false);
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(106614);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(FavBaseUI.this.tdb);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(106614);
            }
        });
        initHeaderView();
        this.tdc = aa.jQ(this).inflate(R.layout.a7q, (ViewGroup) null);
        this.tdb.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass5 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(106615);
                if (i2 == 0) {
                    if (((af) g.ah(af.class)).getFavItemInfoStorage().z(FavBaseUI.this.cVz().cWk(), FavBaseUI.this.cVz().getType())) {
                        Log.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
                        AppMethodBeat.o(106615);
                        return;
                    } else if (FavBaseUI.a(FavBaseUI.this)) {
                        Log.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
                        FavBaseUI.b(FavBaseUI.this);
                    }
                }
                AppMethodBeat.o(106615);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.tdb.setOnItemClickListener(this);
        this.tdb.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106616);
                FavBaseUI.this.hideVKB();
                AppMethodBeat.o(106616);
                return false;
            }
        });
        this.tdb.setAdapter((ListAdapter) cVz());
        a(cVz());
        Log.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    /* access modifiers changed from: protected */
    public final void mz(boolean z) {
        ViewStub viewStub;
        if (z) {
            if (this.tdd == null && (viewStub = (ViewStub) findViewById(R.id.c2y)) != null) {
                this.tdd = viewStub.inflate();
            }
            this.tdd.setVisibility(0);
        } else if (this.tdd != null) {
            this.tdd.setVisibility(8);
        }
    }

    private void mA(boolean z) {
        if (z) {
            if (this.hSx == null) {
                this.hSx = (TextView) ((ViewStub) findViewById(R.id.c3f)).inflate().findViewById(R.id.c2s);
            }
            this.hSx.setVisibility(0);
        } else if (this.hSx != null) {
            this.hSx.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void initHeaderView() {
        this.tde = new c(getContext());
        this.tde.setCleanFavSpace(this.tdh);
        this.tde.mJ(false);
        this.tde.tmB.setVisibility(8);
        this.tde.tmC.setVisibility(8);
        Log.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", Integer.valueOf(this.tde.getPaddingTop()), Integer.valueOf(this.tde.getPaddingBottom()));
        this.tdb.addHeaderView(this.tde);
        this.tdf = View.inflate(getContext(), R.layout.a85, null);
        TextView textView = (TextView) this.tdf.findViewById(R.id.cdc);
        final TextView textView2 = (TextView) this.tdf.findViewById(R.id.cd8);
        TextView textView3 = (TextView) this.tdf.findViewById(R.id.cdd);
        TextView textView4 = (TextView) this.tdf.findViewById(R.id.cd_);
        TextView textView5 = (TextView) this.tdf.findViewById(R.id.cd9);
        TextView textView6 = (TextView) this.tdf.findViewById(R.id.cd7);
        final TextView textView7 = (TextView) this.tdf.findViewById(R.id.cdb);
        TextView textView8 = (TextView) this.tdf.findViewById(R.id.cda);
        View.OnClickListener cVD = cVD();
        textView.setOnClickListener(cVD);
        textView.setTag(5);
        textView2.setOnClickListener(cVD);
        textView2.setTag(21);
        textView3.setOnClickListener(cVD);
        textView3.setTag(3);
        textView4.setOnClickListener(cVD);
        textView4.setTag(7);
        textView5.setOnClickListener(cVD);
        textView5.setTag(6);
        textView6.setOnClickListener(cVD);
        textView6.setTag(8);
        textView7.setOnClickListener(cVD);
        textView7.setTag(17);
        textView8.setOnClickListener(cVD);
        textView8.setTag(18);
        this.tdf.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavBaseUI.AnonymousClass7 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(106617);
                FavBaseUI.this.tdf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int width = FavBaseUI.this.tdf.findViewById(R.id.cdt).getWidth() / 4;
                if (width > 0 && textView2.getWidth() < width) {
                    textView2.setWidth(width);
                    textView7.setWidth(width);
                }
                AppMethodBeat.o(106617);
            }
        });
        this.tdb.addHeaderView(this.tdf);
    }

    /* access modifiers changed from: protected */
    public void cVE() {
        Log.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
        this.hAk.removeCallbacks(this.tdl);
        this.hAk.post(this.tdl);
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        if (aVar == null) {
            Log.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
            return;
        }
        if (!aVar.isEmpty()) {
            mz(false);
            mA(false);
        } else if (cVB()) {
            mz(true);
            mA(false);
        } else {
            mz(false);
            mA(true);
            cVC();
        }
        if (aVar.isEmpty() || ((af) g.ah(af.class)).getFavItemInfoStorage().z(aVar.cWk(), aVar.getType())) {
            this.tdb.removeFooterView(this.tdc);
        } else if (this.tdb.getFooterViewsCount() == 0) {
            this.tdb.addFooterView(this.tdc);
        }
    }

    static /* synthetic */ boolean a(FavBaseUI favBaseUI) {
        if (favBaseUI.tdb.getChildAt(favBaseUI.tdb.getChildCount() - 1) == null || favBaseUI.tdb.getLastVisiblePosition() != favBaseUI.tdb.getAdapter().getCount() - 1) {
            return false;
        }
        Log.i("MicroMsg.FavoriteBaseUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ boolean b(FavBaseUI favBaseUI) {
        Log.v("MicroMsg.FavoriteBaseUI", "on pull down callback");
        if (!((af) g.ah(af.class)).getFavItemInfoStorage().z(favBaseUI.cVz().cWk(), favBaseUI.cVz().getType())) {
            if (b.cUo()) {
                Log.w("MicroMsg.FavoriteBaseUI", "doing batchget, do not load data");
            } else if (favBaseUI.tcX) {
                Log.w("MicroMsg.FavoriteBaseUI", "onBottomLoadData loading, return");
            } else {
                favBaseUI.tcX = true;
                Log.i("MicroMsg.FavoriteBaseUI", "on bottom load data listener");
                favBaseUI.workerHandler.removeCallbacks(favBaseUI.tdk);
                favBaseUI.workerHandler.post(favBaseUI.tdk);
            }
        }
        return true;
    }
}
