package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavCleanUI extends MMActivity implements b.c {
    protected MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private boolean tcX = false;
    protected boolean tcY = false;
    private d.a tdA = new d.a() {
        /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.fav.a.d.a
        public final void onFinish() {
            AppMethodBeat.i(106637);
            Log.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
            FavCleanUI.c(FavCleanUI.this);
            FavCleanUI.d(FavCleanUI.this);
            AppMethodBeat.o(106637);
        }
    };
    private i tdB = new i() {
        /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass6 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(106644);
            Log.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
            if (FavCleanUI.this.tdx != null) {
                FavCleanUI.this.tdx.tml = com.tencent.mm.plugin.fav.a.b.cUh();
            }
            AppMethodBeat.o(106644);
        }
    };
    private long tda = 0;
    protected View tdc;
    private View tdd;
    private Runnable tdk = new Runnable() {
        /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass7 */

        public final void run() {
            AppMethodBeat.i(106645);
            if (FavCleanUI.this.tdu != null) {
                FavCleanUI.this.tdu.boE();
            }
            FavCleanUI.this.cVE();
            AppMethodBeat.o(106645);
        }
    };
    protected Runnable tdl = new Runnable() {
        /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass8 */

        public final void run() {
            AppMethodBeat.i(106646);
            if (FavCleanUI.this.tdu == null) {
                AppMethodBeat.o(106646);
            } else if (FavCleanUI.this.tdu.isEmpty() || SystemClock.elapsedRealtime() - FavCleanUI.this.tda >= 1000) {
                FavCleanUI.this.tcX = false;
                FavCleanUI.this.tda = SystemClock.elapsedRealtime();
                Log.v("MicroMsg.FavCleanUI", "do refresh job");
                FavCleanUI.d(FavCleanUI.this);
                if (FavCleanUI.this.tcY) {
                    Log.v("MicroMsg.FavCleanUI", "do scroll to first");
                    FavCleanUI.this.tdv.setSelection(0);
                    FavCleanUI.this.tcY = false;
                }
                AppMethodBeat.o(106646);
            } else {
                Log.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.this.tda), 1000);
                FavCleanUI.this.hAk.postDelayed(this, 500);
                AppMethodBeat.o(106646);
            }
        }
    };
    private o tdt;
    private com.tencent.mm.plugin.fav.ui.a.b tdu;
    private ListView tdv;
    private TextView tdw;
    private a tdx;
    private boolean tdy = false;
    private int tdz = 0;
    protected MMHandler workerHandler;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavCleanUI() {
        AppMethodBeat.i(106647);
        AppMethodBeat.o(106647);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a6y;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106648);
        super.onCreate(bundle);
        this.tdz = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
        this.workerHandler = new MMHandler(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.tdv = (ListView) findViewById(R.id.cbg);
        setMMTitle(R.string.c8h);
        this.tdy = true;
        g.azz().a(new al(), 0);
        g.azz().a(438, this.tdB);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(106635);
                FavCleanUI.this.finish();
                AppMethodBeat.o(106635);
                return true;
            }
        });
        ViewStub viewStub = (ViewStub) findViewById(R.id.c2y);
        if (viewStub != null) {
            this.tdd = viewStub.inflate();
        } else {
            this.tdd = findViewById(R.id.ce6);
        }
        this.tdw = (TextView) findViewById(R.id.c2s);
        this.tdd.setVisibility(0);
        this.tdw.setVisibility(8);
        this.tdv.removeFooterView(this.tdc);
        if (this.tdx != null) {
            this.tdx.hide();
        }
        this.tdc = aa.jQ(this).inflate(R.layout.a7q, (ViewGroup) null);
        this.tdv.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass2 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(106636);
                if (i2 == 0 && FavCleanUI.a(FavCleanUI.this)) {
                    Log.i("MicroMsg.FavCleanUI", "force bottom load data");
                    FavCleanUI.b(FavCleanUI.this);
                }
                AppMethodBeat.o(106636);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        if (this.tdy) {
            this.tdx = new a();
            a aVar = this.tdx;
            View findViewById = findViewById(R.id.cbf);
            aVar.tmn = false;
            aVar.tmo = findViewById;
            this.tdx.tmp = new a.AbstractC1050a() {
                /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.fav.ui.widget.a.AbstractC1050a
                public final void cVF() {
                    AppMethodBeat.i(106643);
                    h.a(FavCleanUI.this.getContext(), FavCleanUI.this.getString(R.string.c8d), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(106642);
                            long cWq = FavCleanUI.this.tdu.cWq();
                            final List<com.tencent.mm.plugin.fav.a.g> mE = FavCleanUI.this.tdu.mE(true);
                            FavCleanUI.this.tdx.tml += cWq;
                            com.tencent.mm.plugin.fav.a.b.DH(com.tencent.mm.plugin.fav.a.b.cUj() - cWq);
                            if (mE.isEmpty()) {
                                AppMethodBeat.o(106642);
                                return;
                            }
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14110, Integer.valueOf(FavCleanUI.this.tdz), Integer.valueOf(mE.size()), Integer.valueOf((int) ((((double) cWq) * 1.0d) / 1024.0d)));
                            final com.tencent.mm.ui.base.q a2 = h.a((Context) FavCleanUI.this.getContext(), FavCleanUI.this.getString(R.string.c99), false, (DialogInterface.OnCancelListener) null);
                            g.aAk().postToWorker(new Runnable() {
                                /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(106641);
                                    com.tencent.mm.plugin.fav.a.b.dD(mE);
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass5.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            boolean z;
                                            boolean z2;
                                            AppMethodBeat.i(106639);
                                            com.tencent.mm.plugin.fav.ui.a.b bVar = FavCleanUI.this.tdu;
                                            List list = mE;
                                            if (bVar.thh != null) {
                                                ArrayList arrayList = new ArrayList();
                                                for (com.tencent.mm.plugin.fav.a.g gVar : bVar.thh) {
                                                    if (gVar != null) {
                                                        Iterator it = list.iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                z2 = false;
                                                                break;
                                                            }
                                                            com.tencent.mm.plugin.fav.a.g gVar2 = (com.tencent.mm.plugin.fav.a.g) it.next();
                                                            if (gVar2 != null && gVar.field_localId == gVar2.field_localId) {
                                                                z2 = true;
                                                                break;
                                                            }
                                                        }
                                                        if (!z2) {
                                                            arrayList.add(gVar);
                                                        }
                                                    }
                                                }
                                                bVar.thh = arrayList;
                                                ArrayList arrayList2 = new ArrayList();
                                                for (Long l : bVar.thk) {
                                                    Iterator it2 = list.iterator();
                                                    while (true) {
                                                        if (!it2.hasNext()) {
                                                            z = false;
                                                            break;
                                                        }
                                                        com.tencent.mm.plugin.fav.a.g gVar3 = (com.tencent.mm.plugin.fav.a.g) it2.next();
                                                        if (gVar3 != null && l.equals(Long.valueOf(gVar3.field_localId))) {
                                                            z = true;
                                                            break;
                                                        }
                                                    }
                                                    if (!z) {
                                                        arrayList2.add(l);
                                                    }
                                                }
                                                bVar.thk = arrayList2;
                                            }
                                            FavCleanUI.this.tdu.notifyDataSetChanged();
                                            FavCleanUI.this.tdx.cWQ();
                                            a2.dismiss();
                                            AppMethodBeat.o(106639);
                                        }

                                        public final String toString() {
                                            AppMethodBeat.i(106640);
                                            String str = super.toString() + "|batchDelFavItems";
                                            AppMethodBeat.o(106640);
                                            return str;
                                        }
                                    });
                                    AppMethodBeat.o(106641);
                                }
                            });
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11125, Integer.valueOf(mE.size()), 3);
                            AppMethodBeat.o(106642);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(106643);
                }
            };
            this.tdy = false;
        }
        d.cUs().a(this.tdA);
        AppMethodBeat.o(106648);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(106649);
        super.onDestroy();
        d cUs = d.cUs();
        d.a aVar = this.tdA;
        if (cUs.sZY.contains(aVar)) {
            cUs.sZY.remove(aVar);
        }
        if (this.tdt != null) {
            this.tdt.destory();
            this.tdt = null;
        }
        if (this.tdu != null) {
            this.tdu.finish();
        }
        this.workerHandler.quit();
        g.azz().b(438, this.tdB);
        AppMethodBeat.o(106649);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(106650);
        Log.d("MicroMsg.FavCleanUI", "on create options menu");
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(106650);
        return onCreateOptionsMenu;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.i(106651);
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(106651);
        return onOptionsItemSelected;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(106652);
        super.onResume();
        AppMethodBeat.o(106652);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(106653);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(106653);
    }

    /* access modifiers changed from: protected */
    public final void cVE() {
        AppMethodBeat.i(106654);
        Log.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
        this.hAk.removeCallbacks(this.tdl);
        this.hAk.post(this.tdl);
        AppMethodBeat.o(106654);
    }

    private void mB(boolean z) {
        AppMethodBeat.i(106655);
        if (z) {
            this.tdd.setVisibility(8);
            this.tdw.setVisibility(0);
            this.tdv.removeFooterView(this.tdc);
            if (this.tdx != null) {
                this.tdx.hide();
                AppMethodBeat.o(106655);
                return;
            }
        } else {
            this.tdd.setVisibility(8);
            this.tdw.setVisibility(8);
            this.tdv.removeFooterView(this.tdc);
            if (this.tdx != null) {
                this.tdx.show();
            }
        }
        AppMethodBeat.o(106655);
    }

    private void mC(boolean z) {
        AppMethodBeat.i(106656);
        if (!z) {
            this.tdv.removeFooterView(this.tdc);
        } else if (this.tdv.getFooterViewsCount() == 0) {
            this.tdv.addFooterView(this.tdc);
            AppMethodBeat.o(106656);
            return;
        }
        AppMethodBeat.o(106656);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(106657);
        finish();
        super.onBackPressed();
        AppMethodBeat.o(106657);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b.c
    public final void Ec(long j2) {
        boolean z;
        AppMethodBeat.i(106658);
        com.tencent.mm.plugin.fav.a.g DY = ((af) g.ah(af.class)).getFavItemInfoStorage().DY(j2);
        if (!(DY == null || DY.field_favProto == null || DY.field_favProto.ppH.size() == 0)) {
            Iterator<aml> it = DY.field_favProto.ppH.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.tdu.tht) {
            a aVar = this.tdx;
            if (this.tdu.cWp() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.tmn) {
                aVar.kjo.setEnabled(z);
            }
            a aVar2 = this.tdx;
            List<com.tencent.mm.plugin.fav.a.g> mE = this.tdu.mE(false);
            long cWq = this.tdu.cWq();
            if (mE.size() == 0 || cWq <= 0) {
                aVar2.cWQ();
            } else {
                aVar2.qqI.setText(aVar2.qqI.getContext().getString(R.string.c8c, com.tencent.mm.plugin.fav.a.b.DP(cWq)));
                aVar2.kjo.setEnabled(true);
                AppMethodBeat.o(106658);
                return;
            }
        }
        AppMethodBeat.o(106658);
    }

    static /* synthetic */ boolean a(FavCleanUI favCleanUI) {
        AppMethodBeat.i(106659);
        if (favCleanUI.tdv.getChildAt(favCleanUI.tdv.getChildCount() - 1) == null || favCleanUI.tdv.getLastVisiblePosition() != favCleanUI.tdv.getAdapter().getCount() - 1) {
            AppMethodBeat.o(106659);
            return false;
        }
        Log.i("MicroMsg.FavCleanUI", "at bottom call back");
        AppMethodBeat.o(106659);
        return true;
    }

    static /* synthetic */ void b(FavCleanUI favCleanUI) {
        AppMethodBeat.i(106660);
        Log.v("MicroMsg.FavCleanUI", "on pull down callback");
        if (favCleanUI.tdu.thu) {
            Log.i("MicroMsg.FavCleanUI", "has shown all, do not load data");
            AppMethodBeat.o(106660);
        } else if (favCleanUI.tcX) {
            Log.w("MicroMsg.FavCleanUI", "onBottomLoadData loading, return");
            AppMethodBeat.o(106660);
        } else {
            favCleanUI.tcX = true;
            favCleanUI.mC(true);
            Log.i("MicroMsg.FavCleanUI", "on bottom load data listener");
            favCleanUI.workerHandler.removeCallbacks(favCleanUI.tdk);
            favCleanUI.workerHandler.post(favCleanUI.tdk);
            AppMethodBeat.o(106660);
        }
    }

    static /* synthetic */ void c(FavCleanUI favCleanUI) {
        AppMethodBeat.i(106661);
        favCleanUI.tdt = new o(MMApplicationContext.getContext(), 16);
        MMApplicationContext.getContext();
        favCleanUI.tdu = new com.tencent.mm.plugin.fav.ui.a.b(favCleanUI.tdt, true);
        favCleanUI.tdu.ths = favCleanUI;
        favCleanUI.tdv.setAdapter((ListAdapter) favCleanUI.tdu);
        favCleanUI.tdv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavCleanUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(106638);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavCleanUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (FavCleanUI.this.tdu != null) {
                    FavCleanUI.this.tdu.onItemClick(adapterView, view, i2, j2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavCleanUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(106638);
            }
        });
        favCleanUI.tdv.setOnTouchListener(null);
        favCleanUI.tdv.setOnItemLongClickListener(null);
        AppMethodBeat.o(106661);
    }

    static /* synthetic */ void d(FavCleanUI favCleanUI) {
        AppMethodBeat.i(106662);
        favCleanUI.tdu.notifyDataSetChanged();
        if (favCleanUI.tdu.isEmpty()) {
            favCleanUI.mB(true);
            if (8 != favCleanUI.tdv.getVisibility()) {
                favCleanUI.tdv.setVisibility(8);
            }
        } else {
            favCleanUI.mB(false);
            if (favCleanUI.tdx != null) {
                favCleanUI.tdx.show();
            }
            if (favCleanUI.tdv.getVisibility() != 0) {
                favCleanUI.tdv.setVisibility(0);
            }
        }
        favCleanUI.mC(false);
        AppMethodBeat.o(106662);
    }
}
