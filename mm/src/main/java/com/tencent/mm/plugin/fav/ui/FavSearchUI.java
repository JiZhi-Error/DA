package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.h;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
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
import com.tencent.mm.plugin.fav.ui.gallery.c;
import com.tencent.mm.plugin.fav.ui.gallery.d;
import com.tencent.mm.plugin.fav.ui.p;
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.fav.ui.widget.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@a(3)
public class FavSearchUI extends MMActivity implements b.c {
    private String dAi;
    private long iOB;
    private int jvZ;
    private MMHandler mHandler;
    private ListView pop;
    private String query = "";
    private int tdR = -1;
    private String tdS;
    private Set<Integer> tdT;
    private w tdU;
    private View tdV;
    private Animation tdW;
    private Animation tdX;
    private List<Integer> tdY;
    private List<String> tdZ;
    private o tdt;
    private com.tencent.mm.plugin.fav.ui.a.b tdu;
    private List<String> tea;
    private Set<String> teb = new HashSet();
    private List<Long> tec = new ArrayList();
    com.tencent.mm.plugin.fav.ui.f.a ted;
    private c tee;
    private int[] tef = new int[2];
    private g teg;
    private g teh;
    private com.tencent.mm.plugin.fav.ui.widget.b tei;
    private AdapterView.OnItemLongClickListener tej = new AdapterView.OnItemLongClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(106813);
            if (FavSearchUI.this.jvZ == 2) {
                Log.w("MicroMsg.FavSearchUI", "on edit mode long click, ignore");
                AppMethodBeat.o(106813);
            } else if (i2 < FavSearchUI.this.pop.getHeaderViewsCount()) {
                Log.w("MicroMsg.FavSearchUI", "on header view long click, ignore");
                AppMethodBeat.o(106813);
            } else {
                FavSearchUI.a(FavSearchUI.this, view, i2, j2, FavSearchUI.this.tef);
                AppMethodBeat.o(106813);
            }
            return true;
        }
    };
    private com.tencent.mm.plugin.fav.ui.a.c tfh;
    private FavSearchActionView tfi;
    private ListView tfj;
    private FavCapacityPanel tfk;
    private View tfl;
    private ImageButton tfm;
    private MenuItem tfn;
    private and tfo = new and();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavSearchUI() {
        AppMethodBeat.i(106845);
        AppMethodBeat.o(106845);
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, int i2, int i3) {
        AppMethodBeat.i(235319);
        favSearchUI.fW(i2, i3);
        AppMethodBeat.o(235319);
    }

    static /* synthetic */ boolean e(FavSearchUI favSearchUI) {
        AppMethodBeat.i(106860);
        boolean cVL = favSearchUI.cVL();
        AppMethodBeat.o(106860);
        return cVL;
    }

    static /* synthetic */ boolean h(FavSearchUI favSearchUI) {
        AppMethodBeat.i(106862);
        boolean cVK = favSearchUI.cVK();
        AppMethodBeat.o(106862);
        return cVK;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a7y;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106846);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.c_), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.mHandler = new MMHandler();
        setMMTitle("");
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        this.jvZ = getIntent().getIntExtra("key_search_type", 0);
        if (1 == this.jvZ) {
            this.dAi = getIntent().getStringExtra("key_to_user");
            this.tdS = getIntent().getStringExtra("key_fav_item_id");
        }
        this.tdR = getIntent().getIntExtra("key_preset_search_type", -1);
        this.tfj = (ListView) findViewById(R.id.ih_);
        this.pop = (ListView) findViewById(R.id.hf0);
        this.tdV = findViewById(R.id.he0);
        this.tdW = AnimationUtils.loadAnimation(getContext(), R.anim.d6);
        this.tdX = AnimationUtils.loadAnimation(getContext(), R.anim.d7);
        this.tee = new c(this, findViewById(R.id.ccl));
        cWa();
        this.tfk = (FavCapacityPanel) View.inflate(getContext(), R.layout.a6w, null);
        this.tfk.tmk = getIntent().getIntExtra("key_enter_fav_search_from", 0);
        this.tfh = new com.tencent.mm.plugin.fav.ui.a.c(getContext()) {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass17 */

            @Override // com.tencent.mm.plugin.fav.ui.a.c
            public final void aso(String str) {
                AppMethodBeat.i(106841);
                FavSearchActionView favSearchActionView = FavSearchUI.this.tfi;
                favSearchActionView.tmI.add(str);
                if (favSearchActionView.tfS == null) {
                    AppMethodBeat.o(106841);
                    return;
                }
                favSearchActionView.tfS.setEditHint("");
                favSearchActionView.tfS.dm(str, true);
                if (favSearchActionView.tmK == null) {
                    AppMethodBeat.o(106841);
                    return;
                }
                favSearchActionView.asw(favSearchActionView.tfS.getEditText());
                favSearchActionView.tmK.a(favSearchActionView.thn, favSearchActionView.tmJ, favSearchActionView.tmI, false);
                h.INSTANCE.a(11126, 2);
                AppMethodBeat.o(106841);
            }

            @Override // com.tencent.mm.plugin.fav.ui.a.c
            public final void asp(String str) {
                AppMethodBeat.i(106842);
                FavSearchActionView favSearchActionView = FavSearchUI.this.tfi;
                favSearchActionView.tmI.remove(str);
                if (favSearchActionView.tfS == null) {
                    AppMethodBeat.o(106842);
                    return;
                }
                if (favSearchActionView.tmI.isEmpty()) {
                    favSearchActionView.tfS.setEditHint(favSearchActionView.getResources().getString(R.string.yn));
                }
                favSearchActionView.tfS.removeTag(str);
                if (favSearchActionView.tmK == null) {
                    AppMethodBeat.o(106842);
                    return;
                }
                favSearchActionView.asw(favSearchActionView.tfS.getEditText());
                favSearchActionView.tmK.a(favSearchActionView.thn, favSearchActionView.tmJ, favSearchActionView.tmI, true);
                AppMethodBeat.o(106842);
            }
        };
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().cUF() > 0) {
            this.tfj.addHeaderView((TextView) View.inflate(getContext(), R.layout.a82, null));
        }
        this.tfj.addFooterView(this.tfk);
        this.tfj.setAdapter((ListAdapter) this.tfh);
        this.tfj.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass18 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106843);
                switch (motionEvent.getAction()) {
                    case 0:
                        FavSearchUI.this.hideVKB();
                        break;
                }
                AppMethodBeat.o(106843);
                return false;
            }
        });
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
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, final int i2, long j2) {
                AppMethodBeat.i(106818);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                final b.C1049b bVar2 = (b.C1049b) view.getTag();
                if (!(bVar2 == null || bVar2.tbr == null)) {
                    FavSearchUI.a(FavSearchUI.this, 2, i2);
                }
                if (1 == FavSearchUI.this.jvZ) {
                    if (bVar2 == null) {
                        Log.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(106818);
                        return;
                    } else if (bVar2.tbr == null) {
                        Log.w("MicroMsg.FavSearchUI", "on item click, info is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(106818);
                        return;
                    } else {
                        ((ab) com.tencent.mm.kernel.g.af(ab.class)).a(FavSearchUI.this.getContext(), FavSearchUI.this.dAi, bVar2.tbr, false, new y.a() {
                            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                            public final void a(boolean z, String str, int i2) {
                                AppMethodBeat.i(106816);
                                FavSearchUI.this.hideVKB();
                                if (z) {
                                    final q a2 = com.tencent.mm.ui.base.h.a((Context) FavSearchUI.this.getContext(), FavSearchUI.this.getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                                    l.a(FavSearchUI.this.getContext(), FavSearchUI.this.dAi, str, bVar2.tbr, new Runnable() {
                                        /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(106815);
                                            if (a2 != null) {
                                                a2.dismiss();
                                            }
                                            com.tencent.mm.ui.widget.snackbar.b.r(FavSearchUI.this, FavSearchUI.this.getString(R.string.c8o));
                                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                                /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass2.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(106814);
                                                    FavSearchUI.this.finish();
                                                    AppMethodBeat.o(106814);
                                                }
                                            }, 1800);
                                            AppMethodBeat.o(106815);
                                        }
                                    });
                                }
                                AppMethodBeat.o(106816);
                            }
                        });
                    }
                } else if (2 != FavSearchUI.this.jvZ) {
                    FavSearchUI.this.tdu.onItemClick(adapterView, view, i2, j2);
                    if (bVar2.tbr != null) {
                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass2.AnonymousClass2 */

                            public final void run() {
                                int i2;
                                AppMethodBeat.i(106817);
                                Log.d("MicroMsg.FavSearchUI", "type %s", Integer.valueOf(bVar2.tbr.field_type));
                                long j2 = bVar2.tbr.field_localId;
                                if (FavSearchUI.this.tec.size() == 0) {
                                    FavSearchUI.this.tec = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUZ();
                                }
                                if (FavSearchUI.this.tec.size() != 0) {
                                    Iterator it = FavSearchUI.this.tec.iterator();
                                    i2 = 1;
                                    while (it.hasNext() && ((Long) it.next()).longValue() != j2) {
                                        i2++;
                                    }
                                } else {
                                    i2 = 1;
                                }
                                h hVar = h.INSTANCE;
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(bVar2.tbr.field_type);
                                objArr[1] = Integer.valueOf(FavSearchUI.n(FavSearchUI.this));
                                if (FavSearchUI.this.tec.size() == 0) {
                                    i2 = i2;
                                }
                                objArr[2] = Integer.valueOf(i2);
                                hVar.a(12746, objArr);
                                AppMethodBeat.o(106817);
                            }
                        });
                    }
                } else if (bVar2 == null) {
                    Log.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(106818);
                    return;
                } else if (bVar2.tbr == null) {
                    Log.w("MicroMsg.FavSearchUI", "on item click, info is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(106818);
                    return;
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_result_local_id", bVar2.tbr.field_localId);
                    intent.putExtra("key_fav_result_fake_local_id", bVar2.tbr.dLb);
                    FavSearchUI.this.setResult(-1, intent);
                    FavSearchUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(106818);
            }
        });
        this.pop.setOnItemLongClickListener(this.tej);
        this.pop.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106819);
                switch (motionEvent.getAction()) {
                    case 0:
                        FavSearchUI.this.hideVKB();
                        FavSearchUI.this.tef[0] = (int) motionEvent.getRawX();
                        FavSearchUI.this.tef[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(106819);
                return false;
            }
        });
        this.tei = new com.tencent.mm.plugin.fav.ui.widget.b();
        this.tei.dQ(findViewById(R.id.cbt));
        this.tei.tmy = new b.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVS() {
                AppMethodBeat.i(106824);
                if (!FavoriteIndexUI.a(FavSearchUI.this.tdu.mE(false), FavSearchUI.this, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass4.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(106820);
                        p.b(FavSearchUI.this.getContext(), 4105, FavSearchUI.this.tdu, FavSearchUI.this.teh);
                        AppMethodBeat.o(106820);
                    }
                })) {
                    AppMethodBeat.o(106824);
                    return;
                }
                p.b(FavSearchUI.this.getContext(), 4105, FavSearchUI.this.tdu, FavSearchUI.this.teh);
                AppMethodBeat.o(106824);
            }

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVF() {
                AppMethodBeat.i(106825);
                List<g> mE = FavSearchUI.this.tdu.mE(true);
                if (mE.size() == 0) {
                    Log.e("MicroMsg.FavSearchUI", "FavEditFooter onDelRequest list == null");
                    AppMethodBeat.o(106825);
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
                    com.tencent.mm.ui.base.h.a(FavSearchUI.this.getContext(), FavSearchUI.this.getString(R.string.c96), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass4.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(106823);
                            p.a(FavSearchUI.this.getContext(), arrayList, new p.a() {
                                /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass4.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.fav.ui.p.a
                                public final void cVU() {
                                    AppMethodBeat.i(106822);
                                    if (FavSearchUI.this.tdu != null) {
                                        Log.v("MicroMsg.FavSearchUI", "do refresh job");
                                        FavSearchUI.this.tdu.cWm();
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass4.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(106821);
                                                FavSearchUI.this.tdu.notifyDataSetChanged();
                                                AppMethodBeat.o(106821);
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(106822);
                                }
                            });
                            FavSearchUI.e(FavSearchUI.this);
                            if (z) {
                                FavSearchUI.ak(FavSearchUI.this.getContext());
                            }
                            AppMethodBeat.o(106823);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(106825);
                } else if (hashSet.size() >= 2) {
                    FavSearchUI.ak(FavSearchUI.this.getContext());
                    AppMethodBeat.o(106825);
                } else {
                    FavSearchUI.a(FavSearchUI.this, null, 0, mE.get(0));
                    AppMethodBeat.o(106825);
                }
            }

            @Override // com.tencent.mm.plugin.fav.ui.widget.b.a
            public final void cVT() {
            }
        };
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().a(this.tfh);
        com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(106832);
                FavSearchUI.this.tec = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUZ();
                AppMethodBeat.o(106832);
            }
        }, 1000);
        this.ted = new com.tencent.mm.plugin.fav.ui.f.a();
        this.iOB = System.currentTimeMillis();
        this.ted.hes = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
        this.ted.tme = this.iOB;
        if (cVK()) {
            this.tfi.aj(this.tdR, false);
            this.pop.setVisibility(8);
            this.tfj.setVisibility(8);
            this.tee.setVisibility(0);
            this.tee.bqe();
            AppMethodBeat.o(106846);
            return;
        }
        if (this.tdR > 0) {
            this.tfi.aj(this.tdR, true);
            this.tee.setVisibility(8);
            this.pop.setVisibility(0);
        }
        AppMethodBeat.o(106846);
    }

    private boolean cVK() {
        return this.tdR == 21;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(106847);
        if (4 == i2 && this.tdu.thl) {
            cVM();
            AppMethodBeat.o(106847);
            return true;
        } else if (4 != i2 || !cVK() || !this.tee.cWG()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(106847);
            return onKeyUp;
        } else {
            this.tee.cWI();
            AppMethodBeat.o(106847);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(106848);
        this.ted.tmg = (this.ted.actionType == 1 || this.ted.actionType == 9) ? false : true;
        if (!this.ted.tmg) {
            fW(1, 0);
        }
        this.tee.onDestroy();
        super.onDestroy();
        this.tdt.destory();
        this.tdt = null;
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().a(this.tfh);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().j(this.teb);
        if (this.tdu != null) {
            this.tdu.finish();
        }
        AppMethodBeat.o(106848);
    }

    @Override // com.tencent.mm.ui.MMActivity
    @SuppressLint({"ResourceType"})
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(106849);
        Log.d("MicroMsg.FavSearchUI", "on create options menu");
        cWa();
        this.tfn = menu.add(0, R.id.fdi, 0, R.string.ty);
        this.tfn.setActionView(this.tfi);
        this.tfn.setShowAsAction(9);
        this.tfi.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(106833);
                FavSearchActionView favSearchActionView = FavSearchUI.this.tfi;
                if (favSearchActionView.tfS != null) {
                    favSearchActionView.tfS.gLd();
                }
                FavSearchUI.this.showVKB();
                AppMethodBeat.o(106833);
            }
        });
        android.support.v4.view.h.a(this.tfn, new h.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass13 */

            @Override // android.support.v4.view.h.a
            public final boolean fA() {
                return true;
            }

            @Override // android.support.v4.view.h.a
            public final boolean fB() {
                AppMethodBeat.i(106834);
                if (FavSearchUI.e(FavSearchUI.this)) {
                    AppMethodBeat.o(106834);
                    return false;
                }
                FavSearchUI.this.finish();
                AppMethodBeat.o(106834);
                return true;
            }
        });
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(106835);
                if (FavSearchUI.this.tfn != null) {
                    FavSearchUI.this.tfn.expandActionView();
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) FavSearchUI.this.tfi.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = -1;
                        layoutParams.width = -1;
                    }
                    FavSearchUI.this.tfi.setLayoutParams(layoutParams);
                }
                AppMethodBeat.o(106835);
            }
        });
        AppMethodBeat.o(106849);
        return true;
    }

    private void cWa() {
        AppMethodBeat.i(106850);
        if (this.tfi != null) {
            AppMethodBeat.o(106850);
            return;
        }
        this.tfi = (FavSearchActionView) View.inflate(getContext(), R.layout.a7x, null);
        this.tfl = this.tfi.findViewById(R.id.aib);
        this.tfl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(106836);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FavSearchUI.e(FavSearchUI.this)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(106836);
                    return;
                }
                FavSearchUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(106836);
            }
        });
        this.tfm = (ImageButton) this.tfi.findViewById(R.id.hdi);
        this.tfm.setVisibility(8);
        this.tfi.setOnSearchChangedListener(new FavSearchActionView.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass16 */

            @Override // com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a
            public final void bnz() {
                AppMethodBeat.i(106838);
                Log.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
                if (FavSearchUI.e(FavSearchUI.this)) {
                    AppMethodBeat.o(106838);
                    return;
                }
                FavSearchUI.g(FavSearchUI.this);
                AppMethodBeat.o(106838);
            }

            @Override // com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a
            public final void a(List<Integer> list, List<String> list2, List<String> list3, boolean z) {
                AppMethodBeat.i(106839);
                if (!list2.isEmpty() || !list3.isEmpty() || !FavSearchUI.h(FavSearchUI.this)) {
                    Log.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", list, list2, list3);
                    FavSearchUI.this.tdZ = list2;
                    FavSearchUI.this.tea = list3;
                    FavSearchUI.this.tdY = list;
                    FavSearchUI.this.tfh.dK(list3);
                    if (z) {
                        FavSearchUI.g(FavSearchUI.this);
                        FavSearchUI.a(FavSearchUI.this, list2, list3);
                        AppMethodBeat.o(106839);
                        return;
                    }
                    FavSearchUI.this.tdu.c(list, list2, list3);
                    FavSearchUI.b(FavSearchUI.this, true);
                    FavSearchUI.a(FavSearchUI.this, list2, list3);
                    AppMethodBeat.o(106839);
                    return;
                }
                FavSearchUI.a(FavSearchUI.this, true);
                FavSearchUI.a(FavSearchUI.this, list2, list3);
                AppMethodBeat.o(106839);
            }

            @Override // com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.a
            public final void a(String str, final List<Integer> list, final List<String> list2, final List<String> list3) {
                AppMethodBeat.i(106840);
                FavSearchUI.this.tfi.post(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass16.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(106837);
                        if (!list2.isEmpty() || !list3.isEmpty() || !FavSearchUI.h(FavSearchUI.this)) {
                            FavSearchUI.a(FavSearchUI.this, list2, list3);
                            Log.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", list, list2, list3);
                            FavSearchUI.this.tdZ = list2;
                            FavSearchUI.this.tea = list3;
                            FavSearchUI.this.tdY = list;
                            FavSearchUI.this.tfh.dK(list3);
                            FavSearchUI.this.tdu.c(list, list2, list3);
                            FavSearchUI.b(FavSearchUI.this, false);
                            AppMethodBeat.o(106837);
                            return;
                        }
                        FavSearchUI.a(FavSearchUI.this, false);
                        FavSearchUI.a(FavSearchUI.this, list2, list3);
                        AppMethodBeat.o(106837);
                    }
                });
                if (str != null) {
                    FavSearchUI.this.query = str;
                    FavSearchUI.this.ted.hes = com.tencent.mm.plugin.fav.ui.f.a.getSearchId();
                    FavSearchUI.this.ted.tme = System.currentTimeMillis();
                } else {
                    FavSearchUI.this.query = "";
                }
                if (FavSearchUI.this.tdu != null) {
                    com.tencent.mm.plugin.fav.ui.a.b bVar = FavSearchUI.this.tdu;
                    String str2 = FavSearchUI.this.query;
                    if (str2 != null) {
                        bVar.query = str2;
                        AppMethodBeat.o(106840);
                        return;
                    }
                    bVar.query = "";
                }
                AppMethodBeat.o(106840);
            }
        });
        AppMethodBeat.o(106850);
    }

    private boolean cVL() {
        AppMethodBeat.i(106851);
        if (this.tdu.thl) {
            cVM();
            AppMethodBeat.o(106851);
            return true;
        } else if (!cVK() || !this.tee.cWG()) {
            AppMethodBeat.o(106851);
            return false;
        } else {
            this.tee.cWI();
            AppMethodBeat.o(106851);
            return true;
        }
    }

    public static void ak(Activity activity) {
        AppMethodBeat.i(106852);
        f.a aVar = new f.a(activity);
        aVar.bow(activity.getString(R.string.c98));
        aVar.boA(activity.getString(R.string.c95));
        aVar.b(new f.c() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
            }
        });
        aVar.show();
        AppMethodBeat.o(106852);
    }

    private void cVM() {
        AppMethodBeat.i(106853);
        this.tdu.a(false, (g) null);
        this.pop.setOnItemLongClickListener(this.tej);
        this.tei.hide();
        if (cVK()) {
            this.tee.cWI();
        }
        AppMethodBeat.o(106853);
    }

    private void fW(int i2, int i3) {
        AppMethodBeat.i(235318);
        this.ted.actionType = i2;
        if (this.tdu != null) {
            this.ted.pHw = this.tdu.pHw;
        }
        switch (this.jvZ) {
            case 0:
                this.ted.scene = 1;
                break;
            case 1:
                this.ted.scene = 2;
                break;
            case 2:
                this.ted.scene = 3;
                break;
            default:
                this.ted.scene = 0;
                break;
        }
        this.ted.tlX = ((int) (System.currentTimeMillis() - this.iOB)) / 1000;
        this.ted.query = this.query;
        if (this.tdY != null) {
            if (this.tdY.size() > 0) {
                switch (this.tdY.get(0).intValue()) {
                    case 3:
                        this.ted.ehn = 6;
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
                        this.ted.ehn = 0;
                        break;
                    case 5:
                        this.ted.ehn = 2;
                        break;
                    case 6:
                        this.ted.ehn = 8;
                        break;
                    case 7:
                        this.ted.ehn = 4;
                        break;
                    case 8:
                        this.ted.ehn = 3;
                        break;
                    case 17:
                        this.ted.ehn = 5;
                        break;
                    case 18:
                        this.ted.ehn = 7;
                        break;
                    case 21:
                        this.ted.ehn = 1;
                        break;
                }
            } else {
                this.ted.ehn = 0;
            }
        }
        this.ted.tlY = (int) (this.ted.tmf - this.ted.tme);
        this.ted.tma = String.format("%d", Integer.valueOf(i3));
        this.ted.tmc = this.tdu.getCount() - 1;
        this.ted.report();
        AppMethodBeat.o(235318);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        long j2 = 0;
        AppMethodBeat.i(106855);
        this.tdu.cWm();
        this.tdu.notifyDataSetChanged();
        FavCapacityPanel favCapacityPanel = this.tfk;
        if (favCapacityPanel.tmi != com.tencent.mm.plugin.fav.a.b.cUh() / 1048576) {
            favCapacityPanel.tmi = com.tencent.mm.plugin.fav.a.b.cUh() / 1048576;
            TextView textView = favCapacityPanel.tmj;
            Context context = favCapacityPanel.tmj.getContext();
            Object[] objArr = new Object[2];
            if (favCapacityPanel.tml - favCapacityPanel.tmi > 0) {
                j2 = favCapacityPanel.tml - favCapacityPanel.tmi;
            }
            objArr[0] = Long.valueOf(j2);
            objArr[1] = Long.valueOf(favCapacityPanel.tmi);
            textView.setText(context.getString(R.string.c8a, objArr));
        }
        i.arT(getClass().getSimpleName());
        if (cVK()) {
            this.tee.onResume();
        }
        super.onResume();
        AppMethodBeat.o(106855);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(106856);
        i.arU(getClass().getSimpleName());
        if (cVK()) {
            this.tee.onPause();
        }
        super.onPause();
        AppMethodBeat.o(106856);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b.c
    public final void Ec(long j2) {
        AppMethodBeat.i(106857);
        if (this.tdu.thl) {
            this.tei.gf(this.tdu.cWp() > 0);
        }
        AppMethodBeat.o(106857);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(106858);
        Log.i("MicroMsg.FavSearchUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            AppMethodBeat.o(106858);
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
                                Log.d("MicroMsg.FavSearchUI", "select %s, send item null, continute", stringExtra2);
                            } else {
                                new k();
                                if (k.v(dVar.qNT)) {
                                    com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.f3146c));
                                    AppMethodBeat.o(106858);
                                    return;
                                }
                                Log.d("MicroMsg.FavSearchUI", "select %s for sending", stringExtra2);
                                if (dVar.cWJ() || dVar.cWL()) {
                                    final q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
                                    AnonymousClass10 r6 = new Runnable() {
                                        /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass10 */

                                        public final void run() {
                                            AppMethodBeat.i(106831);
                                            a2.dismiss();
                                            AppMethodBeat.o(106831);
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
                        AppMethodBeat.o(106858);
                        return;
                    }
                } else {
                    AppMethodBeat.o(106858);
                    return;
                }
                break;
            case 4105:
                Log.d("MicroMsg.FavSearchUI", "select %s for sending", stringExtra2);
                p.a(getContext(), this.tdu.mE(false), stringExtra, stringExtra2, "MicroMsg.FavSearchUI");
                break;
            case 4106:
                Log.d("MicroMsg.FavSearchUI", "select %s for sending", stringExtra2);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.teh);
                p.a(getContext(), arrayList2, stringExtra, stringExtra2, "MicroMsg.FavSearchUI");
                break;
        }
        cVL();
        AppMethodBeat.o(106858);
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, final View view, final int i2, long j2, int[] iArr) {
        AppMethodBeat.i(106859);
        new com.tencent.mm.ui.widget.b.a(favSearchUI.getContext(), view).a(view, i2, j2, new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass8 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(106827);
                k kVar = new k();
                g Id = FavSearchUI.this.tdu.Id((i2 - FavSearchUI.this.pop.getHeaderViewsCount()) - 1);
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
                AppMethodBeat.o(106827);
            }
        }, new o.g() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(106830);
                if (menuItem == null) {
                    AppMethodBeat.o(106830);
                    return;
                }
                g Id = FavSearchUI.this.tdu.Id((i2 - FavSearchUI.this.pop.getHeaderViewsCount()) - 1);
                switch (menuItem.getItemId()) {
                    case 0:
                        if (i2 < FavSearchUI.this.pop.getHeaderViewsCount()) {
                            AppMethodBeat.o(106830);
                            return;
                        }
                        Log.i("MicroMsg.FavSearchUI", "do delete, long click info is %s (isExistDetail:%s)", Integer.valueOf(i2), Boolean.valueOf(Id.tad));
                        if (Id.tad) {
                            FavSearchUI.a(FavSearchUI.this, view, i2, Id);
                            AppMethodBeat.o(106830);
                            return;
                        }
                        com.tencent.mm.plugin.fav.a.b.a(Id, new Runnable() {
                            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass9.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(106828);
                                if (FavSearchUI.this.tdu != null) {
                                    Log.v("MicroMsg.FavSearchUI", "do refresh job");
                                    FavSearchUI.this.tdu.cWm();
                                    FavSearchUI.this.tdu.notifyDataSetChanged();
                                }
                                AppMethodBeat.o(106828);
                            }
                        });
                        FavSearchUI.a(FavSearchUI.this, 6, i2);
                        AppMethodBeat.o(106830);
                        return;
                    case 1:
                        Log.i("MicroMsg.FavSearchUI", "do edit, long click info is %s", Integer.valueOf(i2));
                        FavSearchUI.this.teg = Id;
                        FavSearchUI.b(FavSearchUI.this, FavSearchUI.this.teg);
                        AppMethodBeat.o(106830);
                        return;
                    case 2:
                        Log.i("MicroMsg.FavSearchUI", "do tag, long click info is %s", Integer.valueOf(i2));
                        Intent intent = new Intent();
                        intent.putExtra("key_fav_scene", 4);
                        intent.putExtra("key_fav_item_id", Id.field_localId);
                        com.tencent.mm.plugin.fav.a.b.b(FavSearchUI.this.getContext(), ".ui.FavTagEditUI", intent);
                        i.arT("FavTagEditUI");
                        FavSearchUI.a(FavSearchUI.this, 7, i2);
                        AppMethodBeat.o(106830);
                        return;
                    case 3:
                        Log.i("MicroMsg.FavSearchUI", "do transmit, long click info is %s", Integer.valueOf(i2));
                        FavSearchUI.this.teh = Id;
                        FavSearchUI.this.teh = FavSearchUI.this.teh.cUC();
                        if (FavSearchUI.this.teh == null) {
                            AppMethodBeat.o(106830);
                            return;
                        }
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(FavSearchUI.this.teh);
                        if (!FavoriteIndexUI.a(linkedList, FavSearchUI.this, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass9.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(106829);
                                p.b(FavSearchUI.this.getContext(), 4106, FavSearchUI.this.tdu, FavSearchUI.this.teh);
                                FavSearchUI.a(FavSearchUI.this, 3, i2);
                                AppMethodBeat.o(106829);
                            }
                        })) {
                            AppMethodBeat.o(106830);
                            return;
                        }
                        p.b(FavSearchUI.this.getContext(), 4106, FavSearchUI.this.tdu, FavSearchUI.this.teh);
                        FavSearchUI.a(FavSearchUI.this, 3, i2);
                        AppMethodBeat.o(106830);
                        return;
                    case 4:
                        and and = new and();
                        and.ecL = 1;
                        ((com.tencent.mm.plugin.fav.a.y) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.y.class)).a(FavSearchUI.this.getContext(), Id, and);
                        AppMethodBeat.o(106830);
                        return;
                    case 5:
                        FavSearchUI.this.tdu.a(view, Id);
                        FavSearchUI.a(FavSearchUI.this, 8, i2);
                        AppMethodBeat.o(106830);
                        return;
                    default:
                        AppMethodBeat.o(106830);
                        return;
                }
            }
        }, iArr[0], iArr[1]);
        AppMethodBeat.o(106859);
    }

    static /* synthetic */ void g(FavSearchUI favSearchUI) {
        AppMethodBeat.i(106861);
        favSearchUI.tfh.notifyDataSetChanged();
        if (8 != favSearchUI.tee.gvQ.getVisibility()) {
            favSearchUI.tee.setVisibility(8);
        }
        if (favSearchUI.tfj.getVisibility() != 0) {
            favSearchUI.tfj.setVisibility(0);
            favSearchUI.tfj.startAnimation(favSearchUI.tdW);
        }
        if (8 != favSearchUI.pop.getVisibility()) {
            favSearchUI.pop.setVisibility(8);
            favSearchUI.pop.startAnimation(favSearchUI.tdX);
        }
        if (8 != favSearchUI.tdV.getVisibility()) {
            favSearchUI.tdV.setVisibility(8);
            favSearchUI.tdV.startAnimation(favSearchUI.tdX);
        }
        AppMethodBeat.o(106861);
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, boolean z) {
        AppMethodBeat.i(106863);
        if (8 != favSearchUI.tfj.getVisibility()) {
            favSearchUI.tfj.setVisibility(8);
            favSearchUI.tfj.startAnimation(favSearchUI.tdX);
        }
        if (8 != favSearchUI.pop.getVisibility()) {
            favSearchUI.pop.setVisibility(8);
            favSearchUI.pop.startAnimation(favSearchUI.tdX);
        }
        if (favSearchUI.tee.gvQ.getVisibility() != 0) {
            favSearchUI.tee.setVisibility(0);
            favSearchUI.tee.gvQ.startAnimation(favSearchUI.tdW);
        }
        if (z) {
            favSearchUI.hideVKB();
        }
        AppMethodBeat.o(106863);
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, List list, List list2) {
        AppMethodBeat.i(106864);
        if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            favSearchUI.tfm.setVisibility(8);
            AppMethodBeat.o(106864);
            return;
        }
        favSearchUI.tfm.setVisibility(0);
        AppMethodBeat.o(106864);
    }

    static /* synthetic */ void b(FavSearchUI favSearchUI, boolean z) {
        AppMethodBeat.i(106865);
        favSearchUI.tdu.notifyDataSetChanged();
        if (8 != favSearchUI.tee.gvQ.getVisibility()) {
            favSearchUI.tee.setVisibility(8);
        }
        if (8 != favSearchUI.tfj.getVisibility()) {
            favSearchUI.tfj.setVisibility(8);
            favSearchUI.tfj.startAnimation(favSearchUI.tdX);
        }
        if (favSearchUI.tdu.isEmpty()) {
            if (favSearchUI.tdV.getVisibility() != 0) {
                favSearchUI.tdV.setVisibility(0);
                favSearchUI.tdV.startAnimation(favSearchUI.tdW);
            }
            if (8 != favSearchUI.pop.getVisibility()) {
                favSearchUI.pop.setVisibility(8);
                favSearchUI.pop.startAnimation(favSearchUI.tdX);
            }
        } else {
            if (8 != favSearchUI.tdV.getVisibility()) {
                favSearchUI.tdV.setVisibility(8);
                favSearchUI.tdV.startAnimation(favSearchUI.tdX);
            }
            if (favSearchUI.pop.getVisibility() != 0) {
                favSearchUI.pop.setVisibility(0);
                favSearchUI.pop.startAnimation(favSearchUI.tdW);
            }
        }
        favSearchUI.ted.tmf = System.currentTimeMillis();
        if (favSearchUI.tdu.isEmpty() && ((favSearchUI.tdZ == null || favSearchUI.tdZ.isEmpty()) && ((favSearchUI.tdY == null || favSearchUI.tdY.isEmpty()) && favSearchUI.tea != null && favSearchUI.tea.size() == 1))) {
            String str = favSearchUI.tea.get(0);
            Log.w("MicroMsg.FavSearchUI", "need del tag %s", str);
            favSearchUI.teb.add(str);
        }
        if (z) {
            favSearchUI.hideVKB();
        }
        AppMethodBeat.o(106865);
    }

    static /* synthetic */ int n(FavSearchUI favSearchUI) {
        AppMethodBeat.i(106867);
        int size = favSearchUI.tdY.size();
        int size2 = favSearchUI.tdZ.size();
        int size3 = favSearchUI.tea.size();
        if (size == 0 && size2 == 0 && size3 > 0) {
            AppMethodBeat.o(106867);
            return 2;
        } else if (size == 0 && size2 > 0 && size3 == 0) {
            AppMethodBeat.o(106867);
            return 3;
        } else if (size > 0 && size2 == 0 && size3 == 0) {
            AppMethodBeat.o(106867);
            return 1;
        } else {
            AppMethodBeat.o(106867);
            return 4;
        }
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, final View view, final int i2, final g gVar) {
        AppMethodBeat.i(106868);
        f.a aVar = new f.a(favSearchUI.getContext());
        aVar.bow(favSearchUI.getContext().getString(R.string.c97));
        aVar.boB(favSearchUI.getContext().getString(R.string.c92));
        aVar.boA(favSearchUI.getContext().getString(R.string.c_q));
        aVar.a(new f.c() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
            }
        }, new f.c() {
            /* class com.tencent.mm.plugin.fav.ui.FavSearchUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(106826);
                FavSearchUI.this.tdu.a(view, gVar);
                AppMethodBeat.o(106826);
            }
        });
        aVar.show();
        AppMethodBeat.o(106868);
    }

    static /* synthetic */ void b(FavSearchUI favSearchUI, g gVar) {
        AppMethodBeat.i(106869);
        favSearchUI.tdu.a(true, gVar);
        favSearchUI.pop.setOnItemLongClickListener(null);
        favSearchUI.tei.mI(true);
        AppMethodBeat.o(106869);
    }
}
