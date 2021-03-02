package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.f.a;
import com.tencent.mm.plugin.fav.ui.gallery.c;
import com.tencent.mm.plugin.fav.ui.gallery.d;
import com.tencent.mm.plugin.fav.ui.p;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.b;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FavFilterUI extends MMActivity implements b.c, c.a {
    private String dAi;
    private long iOB;
    private int jvZ;
    private ListView pop;
    private String query = "";
    private int tdR = -1;
    private String tdS;
    private Set<Integer> tdT;
    private w tdU;
    private View tdV;
    private Animation tdW;
    private Animation tdX;
    private List<Integer> tdY = new LinkedList();
    private List<String> tdZ = new LinkedList();
    private o tdt;
    private com.tencent.mm.plugin.fav.ui.a.b tdu;
    private List<String> tea = new LinkedList();
    private Set<String> teb = new HashSet();
    private List<Long> tec = new ArrayList();
    a ted;
    private c tee;
    private int[] tef = new int[2];
    private g teg;
    private g teh;
    private com.tencent.mm.plugin.fav.ui.widget.b tei;
    private AdapterView.OnItemLongClickListener tej = new AdapterView.OnItemLongClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(106691);
            if (FavFilterUI.this.jvZ == 2) {
                Log.w("MicroMsg.FavFilterUI", "on edit mode long click, ignore");
                AppMethodBeat.o(106691);
            } else if (i2 < FavFilterUI.this.pop.getHeaderViewsCount()) {
                Log.w("MicroMsg.FavFilterUI", "on header view long click, ignore");
                AppMethodBeat.o(106691);
            } else {
                FavFilterUI.a(FavFilterUI.this, view, i2, j2, FavFilterUI.this.tef);
                AppMethodBeat.o(106691);
            }
            return true;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavFilterUI() {
        AppMethodBeat.i(106713);
        AppMethodBeat.o(106713);
    }

    static /* synthetic */ void a(FavFilterUI favFilterUI, int i2, int i3) {
        AppMethodBeat.i(235312);
        favFilterUI.fU(i2, i3);
        AppMethodBeat.o(235312);
    }

    static /* synthetic */ boolean d(FavFilterUI favFilterUI) {
        AppMethodBeat.i(106727);
        boolean cVL = favFilterUI.cVL();
        AppMethodBeat.o(106727);
        return cVL;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a75;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106714);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.c_), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        if (!(getSupportActionBar() == null || getSupportActionBar().getCustomView() == null)) {
            getSupportActionBar().getCustomView().post(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(235289);
                    View findViewById = FavFilterUI.this.getSupportActionBar().getCustomView().findViewById(R.id.dz);
                    if (findViewById != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
                        marginLayoutParams.leftMargin = at.fromDPToPix(FavFilterUI.this.getContext(), 54);
                        findViewById.setLayoutParams(marginLayoutParams);
                    }
                    Log.i("MicroMsg.FavFilterUI", "mActionBar center mode");
                    AppMethodBeat.o(235289);
                }
            });
        }
        this.tdR = getIntent().getIntExtra("key_preset_search_type", -1);
        setMMTitle(FavSearchActionView.Y(getContext(), this.tdR));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(235290);
                if (FavFilterUI.d(FavFilterUI.this)) {
                    AppMethodBeat.o(235290);
                } else {
                    FavFilterUI.this.finish();
                    AppMethodBeat.o(235290);
                }
                return true;
            }
        });
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        this.jvZ = getIntent().getIntExtra("key_search_type", 0);
        this.tdV = findViewById(R.id.he0);
        if (1 == this.jvZ) {
            this.dAi = getIntent().getStringExtra("key_to_user");
            this.tdS = getIntent().getStringExtra("key_fav_item_id");
        }
        this.tdW = AnimationUtils.loadAnimation(getContext(), R.anim.d6);
        this.tdX = AnimationUtils.loadAnimation(getContext(), R.anim.d7);
        this.pop = (ListView) findViewById(R.id.hf0);
        this.tee = new c(this, findViewById(R.id.ccl));
        this.tee.tki = this;
        this.tdt = new o(getContext(), 16);
        getContext();
        this.tdu = new com.tencent.mm.plugin.fav.ui.a.b(this.tdt, false);
        this.tdu.ths = this;
        this.tdu.scene = 2;
        this.tdu.thv = this.pop;
        if (1 == this.jvZ) {
            this.tdT = new HashSet();
            this.tdU = new k();
            if (!Util.isNullOrNil(this.tdS)) {
                for (String str : this.tdS.split(",")) {
                    int i2 = Util.getInt(str, Integer.MAX_VALUE);
                    if (Integer.MAX_VALUE != i2) {
                        this.tdT.add(Integer.valueOf(i2));
                    }
                }
            }
            this.tdu.k(this.tdT);
            this.tdu.a(this.tdU);
        }
        this.pop.setAdapter((ListAdapter) this.tdu);
        this.pop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass9 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, final int i2, long j2) {
                AppMethodBeat.i(235296);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                final b.C1049b bVar2 = (b.C1049b) view.getTag();
                if (!(bVar2 == null || bVar2.tbr == null)) {
                    FavFilterUI.a(FavFilterUI.this, 2, i2);
                }
                if (1 == FavFilterUI.this.jvZ) {
                    if (bVar2 == null) {
                        Log.w("MicroMsg.FavFilterUI", "on item click, holder is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(235296);
                        return;
                    } else if (bVar2.tbr == null) {
                        Log.w("MicroMsg.FavFilterUI", "on item click, info is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(235296);
                        return;
                    } else {
                        ((ab) com.tencent.mm.kernel.g.af(ab.class)).a(FavFilterUI.this.getContext(), FavFilterUI.this.dAi, bVar2.tbr, false, new y.a() {
                            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass9.AnonymousClass1 */

                            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                            public final void a(boolean z, String str, int i2) {
                                AppMethodBeat.i(235294);
                                FavFilterUI.this.hideVKB();
                                if (z) {
                                    final q a2 = h.a((Context) FavFilterUI.this.getContext(), FavFilterUI.this.getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                                    l.a(FavFilterUI.this.getContext(), FavFilterUI.this.dAi, str, bVar2.tbr, new Runnable() {
                                        /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(235293);
                                            if (a2 != null) {
                                                a2.dismiss();
                                            }
                                            com.tencent.mm.ui.widget.snackbar.b.r(FavFilterUI.this, FavFilterUI.this.getString(R.string.c8o));
                                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                                /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass9.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(235292);
                                                    FavFilterUI.this.finish();
                                                    AppMethodBeat.o(235292);
                                                }
                                            }, 1800);
                                            AppMethodBeat.o(235293);
                                        }
                                    });
                                }
                                AppMethodBeat.o(235294);
                            }
                        });
                    }
                } else if (2 != FavFilterUI.this.jvZ) {
                    FavFilterUI.this.tdu.onItemClick(adapterView, view, i2, j2);
                    if (bVar2.tbr != null) {
                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass9.AnonymousClass2 */

                            public final void run() {
                                int i2;
                                AppMethodBeat.i(235295);
                                Log.d("MicroMsg.FavFilterUI", "type %s", Integer.valueOf(bVar2.tbr.field_type));
                                long j2 = bVar2.tbr.field_localId;
                                if (FavFilterUI.this.tec.size() == 0) {
                                    FavFilterUI.this.tec = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUZ();
                                }
                                if (FavFilterUI.this.tec.size() != 0) {
                                    Iterator it = FavFilterUI.this.tec.iterator();
                                    i2 = 1;
                                    while (it.hasNext() && ((Long) it.next()).longValue() != j2) {
                                        i2++;
                                    }
                                } else {
                                    i2 = 1;
                                }
                                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(bVar2.tbr.field_type);
                                objArr[1] = Integer.valueOf(FavFilterUI.h(FavFilterUI.this));
                                if (FavFilterUI.this.tec.size() == 0) {
                                    i2 = i2;
                                }
                                objArr[2] = Integer.valueOf(i2);
                                hVar.a(12746, objArr);
                                AppMethodBeat.o(235295);
                            }
                        });
                    }
                } else if (bVar2 == null) {
                    Log.w("MicroMsg.FavFilterUI", "on item click, holder is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(235296);
                    return;
                } else if (bVar2.tbr == null) {
                    Log.w("MicroMsg.FavFilterUI", "on item click, info is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(235296);
                    return;
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_result_local_id", bVar2.tbr.field_localId);
                    FavFilterUI.this.setResult(-1, intent);
                    FavFilterUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavFilterUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(235296);
            }
        });
        this.pop.setOnItemLongClickListener(this.tej);
        this.pop.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(235297);
                switch (motionEvent.getAction()) {
                    case 0:
                        FavFilterUI.this.hideVKB();
                        FavFilterUI.this.tef[0] = (int) motionEvent.getRawX();
                        FavFilterUI.this.tef[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(235297);
                return false;
            }
        });
        this.tei = new com.tencent.mm.plugin.fav.ui.widget.b();
        this.tei.dQ(findViewById(R.id.cbt));
        this.tei.tmy = new b.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVS() {
                AppMethodBeat.i(235301);
                if (!FavoriteIndexUI.a(FavFilterUI.this.tdu.mE(false), FavFilterUI.this, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass11.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(235298);
                        p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.this.tdu, FavFilterUI.this.teh);
                        FavFilterUI.a(FavFilterUI.this, 3, 0);
                        AppMethodBeat.o(235298);
                    }
                })) {
                    AppMethodBeat.o(235301);
                    return;
                }
                p.b(FavFilterUI.this.getContext(), 4105, FavFilterUI.this.tdu, FavFilterUI.this.teh);
                FavFilterUI.a(FavFilterUI.this, 3, 0);
                AppMethodBeat.o(235301);
            }

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVF() {
                AppMethodBeat.i(235302);
                List<g> mE = FavFilterUI.this.tdu.mE(true);
                if (mE.size() == 0) {
                    Log.e("MicroMsg.FavFilterUI", "FavEditFooter onDelRequest list == null");
                    AppMethodBeat.o(235302);
                    return;
                }
                final ArrayList arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                final boolean z = false;
                for (g gVar : mE) {
                    if (gVar.tad) {
                        hashSet.add(Long.valueOf(gVar.field_localId));
                        z = true;
                    } else {
                        arrayList.add(gVar);
                    }
                }
                if (arrayList.size() != 0) {
                    h.a(FavFilterUI.this.getContext(), FavFilterUI.this.getString(R.string.c96), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass11.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(106694);
                            p.a(FavFilterUI.this.getContext(), arrayList, new p.a() {
                                /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass11.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.fav.ui.p.a
                                public final void cVU() {
                                    AppMethodBeat.i(235300);
                                    if (FavFilterUI.this.tdu != null) {
                                        Log.v("MicroMsg.FavFilterUI", "do refresh job");
                                        FavFilterUI.this.tdu.cWm();
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass11.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(235299);
                                                FavFilterUI.this.tdu.notifyDataSetChanged();
                                                AppMethodBeat.o(235299);
                                            }
                                        });
                                        FavFilterUI.a(FavFilterUI.this, 6, 0);
                                    }
                                    AppMethodBeat.o(235300);
                                }
                            });
                            FavFilterUI.d(FavFilterUI.this);
                            if (z) {
                                FavFilterUI.j(FavFilterUI.this);
                            }
                            AppMethodBeat.o(106694);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(235302);
                } else if (hashSet.size() >= 2) {
                    FavFilterUI.j(FavFilterUI.this);
                    AppMethodBeat.o(235302);
                } else {
                    FavFilterUI.a(FavFilterUI.this, null, 0, mE.get(0));
                    AppMethodBeat.o(235302);
                }
            }

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVT() {
            }
        };
        com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(235291);
                FavFilterUI.this.tec = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUZ();
                AppMethodBeat.o(235291);
            }
        }, 1000);
        this.ted = new a();
        this.iOB = System.currentTimeMillis();
        this.ted.hes = a.getSearchId();
        this.ted.tme = this.iOB;
        if (cVK()) {
            this.pop.setVisibility(8);
            this.tee.setVisibility(0);
            this.ted.hes = a.getSearchId();
            this.tee.bqe();
            AppMethodBeat.o(106714);
            return;
        }
        if (this.tdR > 0) {
            this.tdY.clear();
            this.tdY.add(Integer.valueOf(this.tdR));
            this.tdu.c(this.tdY, this.tdZ, this.tea);
            this.tdu.notifyDataSetChanged();
            if (8 != this.tee.gvQ.getVisibility()) {
                this.tee.setVisibility(8);
            }
            if (this.tdu.isEmpty()) {
                if (this.tdV.getVisibility() != 0) {
                    this.tdV.setVisibility(0);
                    this.tdV.startAnimation(this.tdW);
                }
                if (8 != this.pop.getVisibility()) {
                    this.pop.setVisibility(8);
                    this.pop.startAnimation(this.tdX);
                }
            } else {
                if (8 != this.tdV.getVisibility()) {
                    this.tdV.setVisibility(8);
                    this.tdV.startAnimation(this.tdX);
                }
                if (this.pop.getVisibility() != 0) {
                    this.pop.setVisibility(0);
                    this.pop.startAnimation(this.tdW);
                }
            }
            this.ted.tmf = System.currentTimeMillis();
            fU(9, 0);
            hideVKB();
            this.tee.setVisibility(8);
            this.pop.setVisibility(0);
        }
        AppMethodBeat.o(106714);
    }

    private boolean cVK() {
        return this.tdR == 21;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(106715);
        if (4 == i2 && this.tdu.thl) {
            cVM();
            AppMethodBeat.o(106715);
            return true;
        } else if (4 != i2 || !cVK() || !this.tee.cWG()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(106715);
            return onKeyUp;
        } else {
            this.tee.cWI();
            AppMethodBeat.o(106715);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(106716);
        this.ted.tmg = (this.ted.actionType == 1 || this.ted.actionType == 9) ? false : true;
        if (!this.ted.tmg) {
            fU(1, 0);
        }
        this.tee.onDestroy();
        super.onDestroy();
        this.tdt.destory();
        this.tdt = null;
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().j(this.teb);
        if (this.tdu != null) {
            this.tdu.finish();
        }
        AppMethodBeat.o(106716);
    }

    @Override // com.tencent.mm.ui.MMActivity
    @SuppressLint({"ResourceType"})
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(106717);
        MenuItem add = menu.add(0, 10, 0, R.string.hpa);
        add.setIcon(ar.m(getContext(), R.raw.actionbar_icon_dark_search, getContext().getResources().getColor(R.color.FG_0)));
        add.setShowAsAction(2);
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        AppMethodBeat.o(106717);
        return onCreateOptionsMenu;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AppMethodBeat.i(106718);
        if (menuItem.getItemId() == 10) {
            Intent intent = new Intent();
            intent.putExtra("key_enter_fav_search_from", 0);
            intent.putExtra("key_preset_search_type", this.tdR);
            p.a(getContext(), this.tdu.thl, intent);
            AppMethodBeat.o(106718);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        AppMethodBeat.o(106718);
        return onOptionsItemSelected;
    }

    private boolean cVL() {
        AppMethodBeat.i(106719);
        if (this.tdu.thl) {
            cVM();
            AppMethodBeat.o(106719);
            return true;
        } else if (!cVK() || !this.tee.cWG()) {
            AppMethodBeat.o(106719);
            return false;
        } else {
            this.tee.cWI();
            AppMethodBeat.o(106719);
            return true;
        }
    }

    private void cVM() {
        AppMethodBeat.i(106720);
        this.tdu.a(false, (g) null);
        this.pop.setOnItemLongClickListener(this.tej);
        this.tei.hide();
        if (cVK()) {
            this.tee.cWI();
        }
        AppMethodBeat.o(106720);
    }

    private void b(int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7;
        AppMethodBeat.i(235303);
        switch (this.jvZ) {
            case 0:
                i7 = 1;
                break;
            case 1:
                i7 = 2;
                break;
            case 2:
                i7 = 3;
                break;
            default:
                i7 = 0;
                break;
        }
        String str = this.query;
        String str2 = this.ted.hes;
        int i8 = this.ted.tlY;
        if (!z) {
            i8 = (int) (this.ted.tmf - this.ted.tme);
        }
        this.ted.actionType = i2;
        this.ted.scene = i7;
        this.ted.pHw = i5;
        this.ted.ehn = i4;
        this.ted.tlX = ((int) (System.currentTimeMillis() - this.iOB)) / 1000;
        this.ted.query = str;
        this.ted.hes = str2;
        this.ted.tlY = i8;
        this.ted.tma = String.format("%d", Integer.valueOf(i3));
        this.ted.tmc = i6;
        this.ted.report();
        AppMethodBeat.o(235303);
    }

    private void fU(int i2, int i3) {
        int i4;
        int i5;
        AppMethodBeat.i(235304);
        if (this.tdu != null) {
            i4 = this.tdu.pHw;
        } else {
            i4 = 0;
        }
        if (this.tdY == null) {
            i5 = 0;
        } else if (this.tdY.size() > 0) {
            switch (this.tdY.get(0).intValue()) {
                case 3:
                    i5 = 6;
                    break;
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 19:
                case 20:
                default:
                    i5 = 0;
                    break;
                case 5:
                    i5 = 2;
                    break;
                case 6:
                    i5 = 8;
                    break;
                case 7:
                    i5 = 4;
                    break;
                case 8:
                    i5 = 3;
                    break;
                case 17:
                    i5 = 5;
                    break;
                case 18:
                    i5 = 7;
                    break;
                case 21:
                    i5 = 1;
                    break;
            }
        } else {
            i5 = 0;
        }
        b(i2, i3, i5, i4, this.tdu.getCount() - 1, false);
        AppMethodBeat.o(235304);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(106722);
        this.tdu.cWm();
        this.tdu.notifyDataSetChanged();
        i.arT(getClass().getSimpleName());
        if (cVK()) {
            this.tee.onResume();
        }
        super.onResume();
        AppMethodBeat.o(106722);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(106723);
        i.arU(getClass().getSimpleName());
        if (cVK()) {
            this.tee.onPause();
        }
        super.onPause();
        AppMethodBeat.o(106723);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b.c
    public final void Ec(long j2) {
        AppMethodBeat.i(106724);
        if (this.tdu.thl) {
            this.tei.gf(this.tdu.cWp() > 0);
        }
        AppMethodBeat.o(106724);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(106725);
        Log.i("MicroMsg.FavFilterUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            AppMethodBeat.o(106725);
            return;
        }
        String stringExtra = intent.getStringExtra("custom_send_text");
        String stringExtra2 = intent.getStringExtra("Select_Conv_User");
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    List<d> list = this.tee.tkn;
                    if (!Util.isNullOrNil(stringExtra2)) {
                        ArrayList<String> stringsToList = Util.stringsToList(stringExtra2.split(","));
                        for (d dVar : list) {
                            if (dVar == null) {
                                Log.d("MicroMsg.FavFilterUI", "select %s, send item null, continute", stringExtra2);
                            } else {
                                new k();
                                if (k.v(dVar.qNT)) {
                                    h.cD(getContext(), getString(R.string.f3146c));
                                    AppMethodBeat.o(106725);
                                    return;
                                }
                                Log.d("MicroMsg.FavFilterUI", "select %s for sending", stringExtra2);
                                if (dVar.cWJ() || dVar.cWL()) {
                                    final q a2 = h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                                    AnonymousClass5 r6 = new Runnable() {
                                        /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass5 */

                                        public final void run() {
                                            AppMethodBeat.i(235288);
                                            a2.dismiss();
                                            AppMethodBeat.o(235288);
                                        }
                                    };
                                    for (String str : stringsToList) {
                                        l.a(this, str, dVar.dLo, r6);
                                    }
                                } else {
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    arrayList.add(com.tencent.mm.plugin.fav.a.b.d(dVar.dLo));
                                    for (String str2 : stringsToList) {
                                        com.tencent.mm.av.q.bcP().a(z.aTY(), str2, arrayList);
                                    }
                                }
                            }
                        }
                        if (!Util.isNullOrNil(stringExtra)) {
                            for (String str3 : stringsToList) {
                                com.tencent.mm.plugin.messenger.a.g.eir().ad(str3, stringExtra, com.tencent.mm.model.ab.JG(str3));
                            }
                            break;
                        }
                    } else {
                        AppMethodBeat.o(106725);
                        return;
                    }
                } else {
                    AppMethodBeat.o(106725);
                    return;
                }
                break;
            case 4103:
                long longExtra = intent.getLongExtra("key_fav_result_local_id", -1);
                String stringExtra3 = intent.getStringExtra("key_fav_result_fake_local_id");
                if (-1 == longExtra) {
                    AppMethodBeat.o(106725);
                    return;
                }
                int p = this.tdu.p(longExtra, stringExtra3);
                if (-1 == p) {
                    AppMethodBeat.o(106725);
                    return;
                }
                this.pop.setSelection(p);
                AppMethodBeat.o(106725);
                return;
            case 4105:
                Log.d("MicroMsg.FavFilterUI", "select %s for sending", stringExtra2);
                p.a(getContext(), this.tdu.mE(false), stringExtra, stringExtra2, "MicroMsg.FavFilterUI");
                break;
            case 4106:
                Log.d("MicroMsg.FavFilterUI", "select %s for sending", stringExtra2);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.teh);
                p.a(getContext(), arrayList2, stringExtra, stringExtra2, "MicroMsg.FavFilterUI");
                break;
        }
        cVL();
        AppMethodBeat.o(106725);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.c.a
    public final void fV(int i2, int i3) {
        AppMethodBeat.i(235305);
        this.ted.tlY = i2;
        this.ted.tmc = i3;
        b(9, 0, 1, 2, i3, true);
        AppMethodBeat.o(235305);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.c.a
    public final void Ia(int i2) {
        AppMethodBeat.i(235306);
        b(3, 0, 1, 2, i2, true);
        AppMethodBeat.o(235306);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.c.a
    public final void cVN() {
        AppMethodBeat.i(235307);
        b(2, 0, 1, 2, this.ted.tmc, true);
        AppMethodBeat.o(235307);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.c.a
    public final void cVO() {
        AppMethodBeat.i(235308);
        b(6, 0, 1, 2, this.ted.tmc, true);
        AppMethodBeat.o(235308);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.c.a
    public final void cVP() {
        AppMethodBeat.i(235309);
        b(5, 0, 1, 2, this.ted.tmc, true);
        AppMethodBeat.o(235309);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.c.a
    public final void cVQ() {
        AppMethodBeat.i(235310);
        b(8, 0, 1, 2, this.ted.tmc, true);
        AppMethodBeat.o(235310);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.c.a
    public final void cVR() {
        AppMethodBeat.i(235311);
        b(4, 0, 1, 2, this.ted.tmc, true);
        AppMethodBeat.o(235311);
    }

    static /* synthetic */ void a(FavFilterUI favFilterUI, final View view, final int i2, long j2, int[] iArr) {
        AppMethodBeat.i(106726);
        new com.tencent.mm.ui.widget.b.a(favFilterUI.getContext(), view).a(view, i2, j2, new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass3 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(235284);
                k kVar = new k();
                g Id = FavFilterUI.this.tdu.Id((i2 - FavFilterUI.this.pop.getHeaderViewsCount()) - 1);
                boolean u = kVar.u(Id);
                if (!u) {
                    contextMenu.add(0, 3, 0, R.string.cbt);
                }
                if (u && com.tencent.mm.plugin.fav.a.b.g(Id)) {
                    contextMenu.add(0, 3, 0, R.string.cbt);
                }
                if (Id.field_type == 8) {
                    aml c2 = com.tencent.mm.plugin.fav.a.b.c(Id);
                    if (com.tencent.mm.plugin.fav.a.b.g(c2) && !com.tencent.mm.plugin.fav.a.b.h(c2)) {
                        contextMenu.add(0, 4, 0, R.string.cai);
                    }
                }
                contextMenu.add(0, 2, 0, R.string.c9s);
                if (Id.tad) {
                    contextMenu.add(0, 5, 0, R.string.c_q);
                }
                contextMenu.add(0, 0, 0, R.string.c94);
                contextMenu.add(0, 1, 0, R.string.ca8);
                AppMethodBeat.o(235284);
            }
        }, new o.g() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(235287);
                if (menuItem == null) {
                    AppMethodBeat.o(235287);
                    return;
                }
                g Id = FavFilterUI.this.tdu.Id((i2 - FavFilterUI.this.pop.getHeaderViewsCount()) - 1);
                switch (menuItem.getItemId()) {
                    case 0:
                        if (i2 < FavFilterUI.this.pop.getHeaderViewsCount()) {
                            AppMethodBeat.o(235287);
                            return;
                        }
                        Log.i("MicroMsg.FavFilterUI", "do delete, long click info is %s (isExistDetail:%s)", Integer.valueOf(i2), Boolean.valueOf(Id.tad));
                        if (Id.tad) {
                            FavFilterUI.a(FavFilterUI.this, view, i2, Id);
                            AppMethodBeat.o(235287);
                            return;
                        }
                        com.tencent.mm.plugin.fav.a.b.a(Id, new Runnable() {
                            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(235285);
                                if (FavFilterUI.this.tdu != null) {
                                    Log.v("MicroMsg.FavFilterUI", "do refresh job");
                                    FavFilterUI.this.tdu.cWm();
                                    FavFilterUI.this.tdu.notifyDataSetChanged();
                                }
                                AppMethodBeat.o(235285);
                            }
                        });
                        FavFilterUI.a(FavFilterUI.this, 6, i2);
                        AppMethodBeat.o(235287);
                        return;
                    case 1:
                        Log.i("MicroMsg.FavFilterUI", "do edit, long click info is %s", Integer.valueOf(i2));
                        FavFilterUI.this.teg = Id;
                        FavFilterUI.b(FavFilterUI.this, FavFilterUI.this.teg);
                        AppMethodBeat.o(235287);
                        return;
                    case 2:
                        Log.i("MicroMsg.FavFilterUI", "do tag, long click info is %s", Integer.valueOf(i2));
                        Intent intent = new Intent();
                        intent.putExtra("key_fav_scene", 4);
                        intent.putExtra("key_fav_item_id", Id.field_localId);
                        com.tencent.mm.plugin.fav.a.b.b(FavFilterUI.this.getContext(), ".ui.FavTagEditUI", intent);
                        i.arT("FavTagEditUI");
                        FavFilterUI.a(FavFilterUI.this, 7, i2);
                        AppMethodBeat.o(235287);
                        return;
                    case 3:
                        Log.i("MicroMsg.FavFilterUI", "do transmit, long click info is %s", Integer.valueOf(i2));
                        FavFilterUI.this.teh = Id;
                        FavFilterUI.this.teh = FavFilterUI.this.teh.cUC();
                        if (FavFilterUI.this.teh == null) {
                            AppMethodBeat.o(235287);
                            return;
                        }
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(FavFilterUI.this.teh);
                        if (!FavoriteIndexUI.a(linkedList, FavFilterUI.this, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass4.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(235286);
                                p.b(FavFilterUI.this.getContext(), 4106, FavFilterUI.this.tdu, FavFilterUI.this.teh);
                                FavFilterUI.a(FavFilterUI.this, 3, i2);
                                AppMethodBeat.o(235286);
                            }
                        })) {
                            AppMethodBeat.o(235287);
                            return;
                        }
                        p.b(FavFilterUI.this.getContext(), 4106, FavFilterUI.this.tdu, FavFilterUI.this.teh);
                        FavFilterUI.a(FavFilterUI.this, 3, i2);
                        AppMethodBeat.o(235287);
                        return;
                    case 4:
                        and and = new and();
                        and.ecL = 1;
                        ((com.tencent.mm.plugin.fav.a.y) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.y.class)).a(FavFilterUI.this.getContext(), Id, and);
                        AppMethodBeat.o(235287);
                        return;
                    case 5:
                        FavFilterUI.this.tdu.a(view, Id);
                        FavFilterUI.a(FavFilterUI.this, 8, i2);
                        AppMethodBeat.o(235287);
                        return;
                    default:
                        AppMethodBeat.o(235287);
                        return;
                }
            }
        }, iArr[0], iArr[1]);
        AppMethodBeat.o(106726);
    }

    static /* synthetic */ int h(FavFilterUI favFilterUI) {
        AppMethodBeat.i(106729);
        int size = favFilterUI.tdY.size();
        int size2 = favFilterUI.tdZ.size();
        int size3 = favFilterUI.tea.size();
        if (size == 0 && size2 == 0 && size3 > 0) {
            AppMethodBeat.o(106729);
            return 2;
        } else if (size == 0 && size2 > 0 && size3 == 0) {
            AppMethodBeat.o(106729);
            return 3;
        } else if (size > 0 && size2 == 0 && size3 == 0) {
            AppMethodBeat.o(106729);
            return 1;
        } else {
            AppMethodBeat.o(106729);
            return 4;
        }
    }

    static /* synthetic */ void j(FavFilterUI favFilterUI) {
        AppMethodBeat.i(106730);
        f.a aVar = new f.a(favFilterUI.getContext());
        aVar.bow(favFilterUI.getContext().getString(R.string.c98));
        aVar.boA(favFilterUI.getContext().getString(R.string.c95));
        aVar.b(new f.c() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(106711);
                AppMethodBeat.o(106711);
            }
        });
        aVar.show();
        AppMethodBeat.o(106730);
    }

    static /* synthetic */ void a(FavFilterUI favFilterUI, final View view, final int i2, final g gVar) {
        AppMethodBeat.i(106731);
        f.a aVar = new f.a(favFilterUI.getContext());
        aVar.bow(favFilterUI.getContext().getString(R.string.c97));
        aVar.boB(favFilterUI.getContext().getString(R.string.c92));
        aVar.boA(favFilterUI.getContext().getString(R.string.c_q));
        aVar.a(new f.c() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass13 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(106712);
                FavFilterUI.this.tdu.notifyDataSetChanged();
                AppMethodBeat.o(106712);
            }
        }, new f.c() {
            /* class com.tencent.mm.plugin.fav.ui.FavFilterUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(235283);
                FavFilterUI.this.tdu.a(view, gVar);
                AppMethodBeat.o(235283);
            }
        });
        aVar.show();
        AppMethodBeat.o(106731);
    }

    static /* synthetic */ void b(FavFilterUI favFilterUI, g gVar) {
        AppMethodBeat.i(106732);
        favFilterUI.tdu.a(true, gVar);
        favFilterUI.pop.setOnItemLongClickListener(null);
        favFilterUI.tei.mI(true);
        AppMethodBeat.o(106732);
    }
}
