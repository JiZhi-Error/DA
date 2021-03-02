package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.g.a.j;
import com.tencent.mm.plugin.exdevice.g.b.a.a;
import com.tencent.mm.plugin.exdevice.g.b.a.c;
import com.tencent.mm.plugin.exdevice.g.b.a.d;
import com.tencent.mm.plugin.exdevice.g.b.e;
import com.tencent.mm.plugin.exdevice.g.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public class ExdeviceRankInfoUI extends MMSecDataActivity implements j.a, e, f, c {
    private static int rJm = 128;
    private int likeCount;
    private boolean mIsDestroyed;
    private String mRa;
    private String mwj;
    public boolean rCL;
    public String rCM;
    private boolean rCz;
    private q rGN = null;
    private String rIS;
    private ImageView rIY;
    private Map<String, String> rJE = new HashMap();
    private View rJc;
    private String rJd;
    private String rJe;
    private ArrayList<c> rKA;
    private ArrayList<d> rKB;
    private boolean rKC;
    private boolean rKD;
    private String rKE;
    private boolean rKF;
    private j rKG;
    private b<j> rKH = new b<j>() {
        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass12 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
        @Override // com.tencent.mm.plugin.exdevice.b.b
        public final /* synthetic */ void a(int i2, int i3, String str, j jVar) {
            AppMethodBeat.i(24222);
            j jVar2 = jVar;
            Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s).", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (ExdeviceRankInfoUI.this.isFinishing() || ExdeviceRankInfoUI.this.mIsDestroyed) {
                Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "ExdeviceRankInfoUI has been destroyed.");
                AppMethodBeat.o(24222);
                return;
            }
            ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass12.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(24218);
                    if (ExdeviceRankInfoUI.this.rGN != null && ExdeviceRankInfoUI.this.rGN.isShowing()) {
                        ExdeviceRankInfoUI.this.rGN.dismiss();
                        ExdeviceRankInfoUI.this.rGN = null;
                        Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                    }
                    AppMethodBeat.o(24218);
                }
            });
            if (i2 == 0 && i3 == 0) {
                ExdeviceRankInfoUI.this.rJd = jVar2.rCq;
                ExdeviceRankInfoUI.this.rJe = jVar2.msN;
                ExdeviceRankInfoUI.this.rCM = jVar2.rCM;
                ExdeviceRankInfoUI.this.rCL = jVar2.rCL;
                ExdeviceRankInfoUI.this.rCz = jVar2.rCz;
                ExdeviceRankInfoUI.g(ExdeviceRankInfoUI.this);
                ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass12.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(24221);
                        ExdeviceRankInfoUI.h(ExdeviceRankInfoUI.this);
                        if (!Util.isNullOrNil(ExdeviceRankInfoUI.this.rJd)) {
                            ExdeviceRankInfoUI.this.addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
                                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass12.AnonymousClass3.AnonymousClass1 */

                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    AppMethodBeat.i(24220);
                                    com.tencent.mm.plugin.sport.a.c.pl(11);
                                    ExdeviceRankInfoUI.j(ExdeviceRankInfoUI.this);
                                    AppMethodBeat.o(24220);
                                    return true;
                                }
                            });
                        }
                        if (ExdeviceRankInfoUI.this.rKr != null) {
                            ExdeviceRankInfoUI.this.rKr.anT(ExdeviceRankInfoUI.this.rKx);
                        }
                        AppMethodBeat.o(24221);
                    }
                });
                AppMethodBeat.o(24222);
                return;
            }
            if (ExdeviceRankInfoUI.this.rKz == null || ExdeviceRankInfoUI.this.rKz.size() == 0) {
                ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass12.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(24219);
                        Toast.makeText(ExdeviceRankInfoUI.this, (int) R.string.c0y, 1).show();
                        ExdeviceRankInfoUI.this.finish();
                        AppMethodBeat.o(24219);
                    }
                });
            }
            AppMethodBeat.o(24222);
        }
    };
    private ListView rKn;
    private b rKo;
    private View rKp;
    private ExdeviceRankListHeaderView rKq;
    private ExdeviceRankChampionInfoView rKr;
    private View rKs;
    private String rKt;
    private String rKu;
    private String rKv;
    private a rKw;
    private String rKx;
    private int rKy;
    private List<d> rKz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExdeviceRankInfoUI() {
        AppMethodBeat.i(24235);
        AppMethodBeat.o(24235);
    }

    static /* synthetic */ void g(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24262);
        exdeviceRankInfoUI.lR(false);
        AppMethodBeat.o(24262);
    }

    static /* synthetic */ void h(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24263);
        exdeviceRankInfoUI.cLV();
        AppMethodBeat.o(24263);
    }

    static /* synthetic */ void m(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24265);
        exdeviceRankInfoUI.cMb();
        AppMethodBeat.o(24265);
    }

    static /* synthetic */ void r(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24269);
        exdeviceRankInfoUI.cLY();
        AppMethodBeat.o(24269);
    }

    static /* synthetic */ void s(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24270);
        exdeviceRankInfoUI.cLR();
        AppMethodBeat.o(24270);
    }

    static /* synthetic */ void t(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24271);
        exdeviceRankInfoUI.cLZ();
        AppMethodBeat.o(24271);
    }

    static /* synthetic */ void u(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24272);
        exdeviceRankInfoUI.lS(true);
        AppMethodBeat.o(24272);
    }

    private void lR(boolean z) {
        AppMethodBeat.i(24236);
        if (!this.rKD || z) {
            ad.cKT();
            this.rKB = com.tencent.mm.plugin.exdevice.g.b.c.anB(this.rIS);
            this.rKA = ad.cKN().cKZ();
            this.rKz = this.rKo.b(this.rKA, this.rKB, this.rCL);
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(24206);
                    ExdeviceRankInfoUI.this.rKo.rJD = ExdeviceRankInfoUI.this.rKz;
                    ExdeviceRankInfoUI.this.rKo.notifyDataSetChanged();
                    ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
                    AppMethodBeat.o(24206);
                }
            });
            AppMethodBeat.o(24236);
            return;
        }
        AppMethodBeat.o(24236);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        d dVar;
        AppMethodBeat.i(24237);
        super.onCreate(bundle);
        this.mIsDestroyed = false;
        this.mRa = z.aTY();
        Intent intent = getIntent();
        this.rKt = intent.getStringExtra("key_rank_info");
        this.rKu = intent.getStringExtra("key_rank_semi");
        this.rKv = intent.getStringExtra("app_username");
        this.rIS = intent.getStringExtra("rank_id");
        this.rKC = intent.getBooleanExtra("key_is_latest", false);
        this.rKx = intent.getStringExtra("key_champioin_username");
        this.rKy = intent.getIntExtra("device_type", 0);
        this.rKE = intent.getStringExtra("locate_to_username");
        this.rKD = intent.getBooleanExtra("key_only_show_latest_rank", false);
        if (Util.isNullOrNil(this.rIS) || "#".equals(this.rIS)) {
            if (!this.rKD) {
                Cursor rawQuery = ad.cKM().db.rawQuery(String.format("select * from %s order by %s desc limit 1", "HardDeviceRankInfo", "rankID"), null, 2);
                if (rawQuery == null) {
                    Log.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    dVar = null;
                } else {
                    if (!rawQuery.moveToFirst()) {
                        Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.convertFrom(rawQuery);
                    }
                    rawQuery.close();
                }
                if (dVar != null) {
                    this.rIS = dVar.field_rankID;
                    this.rKv = dVar.field_appusername;
                }
            }
            this.rKx = null;
            this.rKC = true;
        }
        ad.cKT();
        this.rKB = com.tencent.mm.plugin.exdevice.g.b.c.anB(this.rIS);
        if (!this.rKD) {
            if (this.rKB == null || this.rKB.size() <= 0) {
                this.rKA = new ArrayList<>();
                this.rKB = com.tencent.mm.plugin.exdevice.g.a.a.a(this.rIS, this.rKv, this.rKt, this.rKu, this.rJE, this.rKA);
                ad.cKT();
                com.tencent.mm.plugin.exdevice.g.b.c.f(this.rIS, this.rKB);
            } else {
                com.tencent.mm.plugin.exdevice.g.a.a.b(this.rKt, this.rKu, this.rJE);
            }
            this.rKA = ad.cKN().cKZ();
        }
        this.rKo = new b(this, this.rKv);
        this.rKo.rJE = this.rJE;
        this.rKz = this.rKo.b(this.rKA, this.rKB, this.rCL);
        this.rKo.rJD = this.rKz;
        if (Util.isNullOrNil(this.rKx)) {
            cLW();
        }
        this.rKw = ad.cKP().anF(this.rKx);
        if (this.rKw == null && !Util.isNullOrNil(this.rKx)) {
            this.rKw = new a();
            this.rKw.field_username = this.rKx;
            this.rKw.field_championMotto = getIntent().getStringExtra("key_champion_info");
            this.rKw.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
            ad.cKT();
            ad.cKP().a(this.rKw);
        }
        initView();
        if (this.rKB != null && this.rKB.size() > 0) {
            this.rKr.anT(this.rKB.get(0).field_username);
        }
        ad.cKU().a(this);
        ad.cKT().rCX = this;
        cLU();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass20 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(179644);
                ExdeviceRankInfoUI.this.finish();
                AppMethodBeat.o(179644);
                return false;
            }
        });
        setMMTitle(R.string.c2o);
        showOptionMenu(true);
        cLV();
        wp wpVar = new wp();
        wpVar.ecH.action = 2;
        EventCenter.instance.asyncPublish(wpVar, new Executor() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass19 */

            public final void execute(Runnable runnable) {
                AppMethodBeat.i(179643);
                h.RTc.aX(runnable);
                AppMethodBeat.o(179643);
            }
        });
        if (com.tencent.mm.compatible.util.d.oF(28)) {
            try {
                if (android.support.v4.content.b.checkSelfPermission(this, "android.permission.ACTIVITY_RECOGNITION") != 0) {
                    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "no ACTIVITY_RECOGNITION permission");
                    android.support.v4.app.a.a(this, new String[]{"android.permission.ACTIVITY_RECOGNITION"}, 5);
                } else {
                    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "has ACTIVITY_RECOGNITION permission");
                }
            } catch (Exception e2) {
            }
        }
        if (g.aAh().azQ().getInt(ar.a.USERINFO_REGISTER_STEP_COUNTER_FAIL_INT, 0) == 1) {
            Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "toast get step fail");
            Toast.makeText(this, (int) R.string.c1t, 0).show();
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(323, 6, 1, false);
        }
        AppMethodBeat.o(24237);
    }

    private void cLU() {
        AppMethodBeat.i(24238);
        Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
        this.rKG = new j(this.rIS, this.rKv, this.rKx, this.rKC, this.rKH);
        this.rKG.rCO = this;
        bg.azz().a(this.rKG, 0);
        AppMethodBeat.o(24238);
    }

    private void cLV() {
        AppMethodBeat.i(24239);
        Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", this.rKE, this.mRa);
        if (Util.isNullOrNil(this.rKE) || anV(this.rKE) < 0) {
            Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
            AppMethodBeat.o(24239);
            return;
        }
        AppMethodBeat.o(24239);
    }

    private int anV(String str) {
        AppMethodBeat.i(24240);
        Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", str, this.mRa);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(24240);
            return -1;
        } else if (this.rKz == null || this.rKz.size() == 0) {
            AppMethodBeat.o(24240);
            return -2;
        } else {
            for (int i2 = 0; i2 < this.rKz.size(); i2++) {
                d dVar = this.rKz.get(i2).rMD;
                int i3 = this.rKz.get(i2).rME;
                if (dVar != null && str.equalsIgnoreCase(dVar.field_username) && !str.equalsIgnoreCase(this.mRa) && (i3 & 2) != 2) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    int i4 = displayMetrics.heightPixels;
                    Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", Integer.valueOf(i2), Integer.valueOf(i4));
                    this.rKn.setSelectionFromTop(i2, i4 / 4);
                    this.rKo.rJF = str;
                    this.rKo.notifyDataSetInvalidated();
                    cLY();
                    AppMethodBeat.o(24240);
                    return i2;
                }
            }
            this.rKo.rJF = null;
            AppMethodBeat.o(24240);
            return -3;
        }
    }

    private void cLR() {
        AppMethodBeat.i(24241);
        if (this.rKw == null || this.mRa == null || !this.mRa.equals(this.rKw.field_username) || !Util.isNullOrNil(this.rKw.field_championUrl)) {
            if (this.rJc != null) {
                this.rJc.setVisibility(8);
            }
            if (this.rKw != null && !Util.nullAs(this.rKw.field_username, "").equals(this.mRa) && !Util.isNullOrNil(this.rKw.field_championUrl)) {
                this.rKq.setOnViewClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass24 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(24233);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        ExdeviceRankInfoUI.p(ExdeviceRankInfoUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(24233);
                    }
                });
            }
        } else {
            if (this.rJc != null) {
                this.rJc.setVisibility(0);
            }
            if (this.rKq != null) {
                this.rKq.setOnViewClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass23 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(24232);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceRankInfoUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(24232);
                    }
                });
                AppMethodBeat.o(24241);
                return;
            }
        }
        AppMethodBeat.o(24241);
    }

    private void cLW() {
        AppMethodBeat.i(24242);
        String cLX = cLX();
        if (!Util.isNullOrNil(cLX)) {
            this.rKx = cLX;
        }
        AppMethodBeat.o(24242);
    }

    private String cLX() {
        AppMethodBeat.i(24243);
        if (this.rKz != null) {
            for (d dVar : this.rKz) {
                d dVar2 = dVar.rMD;
                if (dVar2 != null && dVar2.field_ranknum == 1) {
                    String str = dVar2.field_username;
                    AppMethodBeat.o(24243);
                    return str;
                }
            }
        }
        AppMethodBeat.o(24243);
        return null;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int dimensionPixelSize;
        int i2;
        int i3;
        boolean z;
        AppMethodBeat.i(24244);
        this.rKp = findViewById(R.id.g12);
        ExdeviceRankListHeaderView exdeviceRankListHeaderView = new ExdeviceRankListHeaderView(this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        if (i4 == 0) {
            i4 = com.tencent.mm.plugin.exdevice.k.b.D(this, getResources().getDimensionPixelSize(R.dimen.d6));
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b8);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b9);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int height = ((defaultDisplay.getHeight() / 2) - i4) - dimensionPixelSize;
        if (defaultDisplay.getHeight() <= 0 || height <= 0) {
            height = getResources().getDimensionPixelSize(R.dimen.d0);
        }
        exdeviceRankListHeaderView.setMinimumHeight(height);
        exdeviceRankListHeaderView.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceRankListHeaderView.setTag(Integer.valueOf(height));
        this.rKq = exdeviceRankListHeaderView;
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.id.gm5);
        this.rKn = (ListView) findViewById(R.id.c68);
        this.rKr = (ExdeviceRankChampionInfoView) findViewById(R.id.aqr);
        this.rJc = findViewById(R.id.hl3);
        this.rJc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass25 */

            public final void onClick(View view) {
                AppMethodBeat.i(179647);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
                com.tencent.mm.plugin.exdevice.g.a.e.e(ExdeviceRankInfoUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179647);
            }
        });
        this.rKq.setIsShowTip(false);
        cLR();
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setTopViewVisible(false);
        mMPullDownView.setBottomViewVisible(false);
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setIsTopShowAll(false);
        mMPullDownView.setCanOverScrool(true);
        mMPullDownView.setOnInterceptTouchEventListener(new MMPullDownView.a() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.a
            public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                boolean z;
                AppMethodBeat.i(179630);
                ExdeviceRankInfoUI exdeviceRankInfoUI = ExdeviceRankInfoUI.this;
                if (ExdeviceRankInfoUI.this.rKz == null || ExdeviceRankInfoUI.this.rKz.size() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                exdeviceRankInfoUI.rKF = z;
                AppMethodBeat.o(179630);
                return false;
            }
        });
        mMPullDownView.setAtBottomCallBack(new MMPullDownView.c() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.c
            public final boolean cAl() {
                AppMethodBeat.i(179631);
                View childAt = ExdeviceRankInfoUI.this.rKn.getChildAt(ExdeviceRankInfoUI.this.rKn.getChildCount() - 1);
                int count = ExdeviceRankInfoUI.this.rKn.getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceRankInfoUI.this.rKn.getHeight() || ExdeviceRankInfoUI.this.rKn.getLastVisiblePosition() != count - 1) {
                    AppMethodBeat.o(179631);
                    return false;
                }
                AppMethodBeat.o(179631);
                return true;
            }
        });
        mMPullDownView.setOnScrollChangedListener(new MMPullDownView.b() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.b
            public final void cLT() {
                AppMethodBeat.i(179632);
                ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(179632);
            }
        });
        mMPullDownView.setAtTopCallBack(new MMPullDownView.d() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.MMPullDownView.d
            public final boolean cAk() {
                View childAt;
                AppMethodBeat.i(179633);
                int firstVisiblePosition = ExdeviceRankInfoUI.this.rKn.getFirstVisiblePosition();
                if (firstVisiblePosition != 0 || (childAt = ExdeviceRankInfoUI.this.rKn.getChildAt(firstVisiblePosition)) == null || childAt.getTop() < 0) {
                    AppMethodBeat.o(179633);
                    return false;
                }
                AppMethodBeat.o(179633);
                return true;
            }
        });
        this.rKn.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass6 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(179634);
                ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(179634);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(179635);
                ExdeviceRankInfoUI.r(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(179635);
            }
        });
        this.rKn.addHeaderView(this.rKq, null, false);
        View inflate = getLayoutInflater().inflate(R.layout.a55, (ViewGroup) null);
        this.rKs = inflate.findViewById(R.id.dzo);
        inflate.findViewById(R.id.dzn).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(179636);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.sport.a.c.pl(24);
                Intent intent = new Intent();
                intent.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
                intent.putExtra("Select_block_List", "gh_43f2581f6fd6");
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Select_Send_Card", true);
                com.tencent.mm.br.c.c(ExdeviceRankInfoUI.this, ".ui.transmit.SelectConversationUI", intent, 3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179636);
            }
        });
        this.rKs.setVisibility(8);
        this.rKn.addFooterView(inflate);
        if (this.rKA != null) {
            i2 = this.rKA.size();
        } else {
            i2 = 0;
        }
        if (this.rKB != null) {
            i3 = this.rKB.size();
        } else {
            i3 = 0;
        }
        if (i2 + i3 == 0) {
            this.rKz = new ArrayList();
            this.rKo.rJD = this.rKz;
            getString(R.string.zb);
            this.rGN = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(179637);
                    if (ExdeviceRankInfoUI.this.rGN != null) {
                        ExdeviceRankInfoUI.this.rGN.dismiss();
                        ExdeviceRankInfoUI.this.rGN = null;
                    }
                    ExdeviceRankInfoUI.this.finish();
                    AppMethodBeat.o(179637);
                }
            });
        }
        this.rKn.setAdapter((ListAdapter) this.rKo);
        this.rKo.rJG = this;
        if (this.rKy == 1) {
            this.rKn.setVisibility(0);
            this.rKp.setVisibility(8);
            z = true;
        } else {
            this.rKn.setVisibility(8);
            this.rKp.setVisibility(0);
            z = false;
        }
        if (!z) {
            Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
            finish();
            AppMethodBeat.o(24244);
            return;
        }
        this.rIY = (ImageView) findViewById(R.id.c5m);
        mMPullDownView.setCanOverScrool(false);
        int jn = com.tencent.mm.cb.a.jn(this);
        int intValue = ((Integer) this.rKq.getTag()).intValue();
        if (this.rCL) {
            intValue += (getResources().getDimensionPixelSize(R.dimen.df) / 2) + getResources().getDimensionPixelSize(R.dimen.de);
        }
        this.rIY.setLayoutParams(new RelativeLayout.LayoutParams(jn, intValue));
        cLZ();
        lS(false);
        AppMethodBeat.o(24244);
    }

    private void cLY() {
        float f2;
        AppMethodBeat.i(24245);
        View childAt = this.rKn.getChildAt(0);
        int[] iArr = new int[2];
        if (childAt != null) {
            if (this.rKn.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (Util.isNullOrNil(this.rKE) && rJm == 128) {
                    rJm = iArr[1];
                }
                int i2 = iArr[1];
                if (i2 > 0) {
                    if (i2 >= rJm) {
                        f2 = 1.0f;
                    } else {
                        f2 = ((float) i2) / ((float) rJm);
                    }
                    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", Float.valueOf(f2));
                    this.rKr.setAlpha(f2);
                    this.rKr.setVisibility(0);
                    this.rJc.setAlpha(f2);
                    AppMethodBeat.o(24245);
                    return;
                }
            }
            this.rKr.setAlpha(0.0f);
            this.rJc.setAlpha(0.0f);
            this.rKr.setVisibility(8);
        }
        AppMethodBeat.o(24245);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(24246);
        super.onResume();
        AppMethodBeat.o(24246);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        AppMethodBeat.i(24247);
        super.onRestart();
        lR(true);
        AppMethodBeat.o(24247);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(24248);
        this.mIsDestroyed = true;
        if (this.rKo != null) {
            b.finish();
        }
        super.onDestroy();
        if (this.rKG != null) {
            this.rKG.rCO = null;
        }
        ad.cKU().b(this);
        ad.cKT().rCX = null;
        ad.cKT().rCY = null;
        if (this.likeCount > 0) {
            int i2 = this.likeCount;
            Log.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", Integer.valueOf(i2));
            com.tencent.mm.plugin.report.e.INSTANCE.a(13168, 0, Integer.valueOf(i2));
        }
        AppMethodBeat.o(24248);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(24249);
        super.onPause();
        AppMethodBeat.o(24249);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a57;
    }

    private void cLZ() {
        AppMethodBeat.i(24250);
        if (this.rKw == null) {
            this.rIY.setImageResource(R.color.kw);
            this.mwj = null;
        } else if (this.mwj != this.rKw.field_championUrl && (this.mwj == null || !this.mwj.equals(this.rKw.field_championUrl))) {
            com.tencent.mm.plugin.exdevice.g.a.e.a(this, this.rIY, this.rKw.field_championUrl);
            this.mwj = this.rKw.field_championUrl;
            AppMethodBeat.o(24250);
            return;
        }
        AppMethodBeat.o(24250);
    }

    private void lS(boolean z) {
        AppMethodBeat.i(24251);
        if (z) {
            cLW();
        }
        if (!Util.isNullOrNil(this.rKv)) {
            this.rKr.anT(this.rKx);
            this.rKr.setVisibility(0);
            AppMethodBeat.o(24251);
            return;
        }
        this.rKr.setVisibility(8);
        AppMethodBeat.o(24251);
    }

    @Override // com.tencent.mm.plugin.exdevice.g.b.e
    public final void b(String str, com.tencent.mm.plugin.exdevice.g.b.d dVar) {
        AppMethodBeat.i(24252);
        Assert.assertTrue(dVar != null && !Util.isNullOrNil(str));
        if ("HardDeviceRankInfo".equals(str)) {
            if (this.rIS != null && this.rIS.equals(dVar.rCB)) {
                Log.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", this.rIS);
                lR(true);
                if (Util.isNullOrNil(this.rKx) || !this.rKx.equals(cLX())) {
                    cLW();
                    this.rKw = ad.cKP().anF(this.rKx);
                    runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass9 */

                        public final void run() {
                            AppMethodBeat.i(24215);
                            ExdeviceRankInfoUI.s(ExdeviceRankInfoUI.this);
                            ExdeviceRankInfoUI.t(ExdeviceRankInfoUI.this);
                            AppMethodBeat.o(24215);
                        }
                    });
                }
                runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass10 */

                    public final void run() {
                        AppMethodBeat.i(24216);
                        ExdeviceRankInfoUI.u(ExdeviceRankInfoUI.this);
                        if (!ExdeviceRankInfoUI.this.rKF) {
                            ExdeviceRankInfoUI.h(ExdeviceRankInfoUI.this);
                            AppMethodBeat.o(24216);
                            return;
                        }
                        ExdeviceRankInfoUI.this.rKo.notifyDataSetChanged();
                        AppMethodBeat.o(24216);
                    }
                });
                AppMethodBeat.o(24252);
                return;
            }
        } else if ("HardDeviceChampionInfo".equals(str) && !Util.isNullOrNil(this.rKx) && this.rKx.equals(dVar.username)) {
            this.rKw = ad.cKP().anF(this.rKx);
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(179638);
                    ExdeviceRankInfoUI.s(ExdeviceRankInfoUI.this);
                    ExdeviceRankInfoUI.t(ExdeviceRankInfoUI.this);
                    AppMethodBeat.o(179638);
                }
            });
        }
        AppMethodBeat.o(24252);
    }

    @Override // com.tencent.mm.plugin.exdevice.g.b.f
    public final void anC(String str) {
        AppMethodBeat.i(24253);
        Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", str);
        this.rIS = str;
        AppMethodBeat.o(24253);
    }

    @Override // com.tencent.mm.plugin.exdevice.ui.c
    public final void anW(String str) {
        AppMethodBeat.i(24254);
        com.tencent.mm.plugin.sport.a.c.pl(6);
        Intent intent = new Intent(this, ExdeviceProfileUI.class);
        intent.putExtra(ch.COL_USERNAME, str);
        intent.putExtra("usernickname", this.rJE.get(str));
        intent.putExtra("app_username", this.rKv);
        intent.putExtra("rank_id", this.rIS);
        startActivityForResult(intent, 4);
        AppMethodBeat.o(24254);
    }

    @Override // com.tencent.mm.plugin.exdevice.ui.c
    public final void cMa() {
        AppMethodBeat.i(24255);
        com.tencent.mm.plugin.sport.a.c.pl(31);
        cMb();
        AppMethodBeat.o(24255);
    }

    @Override // com.tencent.mm.plugin.exdevice.ui.c
    public final void di(String str, int i2) {
        AppMethodBeat.i(24256);
        ad.cKT();
        String str2 = this.rIS;
        String str3 = this.rKv;
        com.tencent.mm.plugin.exdevice.g.b.b.d cKM = ad.cKM();
        Assert.assertTrue(!Util.isNullOrNil(str2) && !Util.isNullOrNil(str) && (i2 == 1 || i2 == 0 || i2 == 2));
        d a2 = cKM.a(new com.tencent.mm.plugin.exdevice.g.b.d(str2, null, str));
        if (a2 != null) {
            a2.field_selfLikeState = i2;
            switch (a2.field_selfLikeState) {
                case 0:
                    a2.field_likecount--;
                    cKM.a(a2, true);
                    break;
                case 1:
                    a2.field_likecount++;
                    cKM.a(a2, true);
                    break;
                default:
                    Log.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
                    break;
            }
        } else {
            Log.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
        }
        com.tencent.mm.plugin.exdevice.g.b.c.c(str2, str3, str, i2);
        this.likeCount++;
        AppMethodBeat.o(24256);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(24257);
        super.onActivityResult(i2, i3, intent);
        if (com.tencent.mm.plugin.exdevice.g.a.e.a(this, i2, i3, intent, this.rKv)) {
            AppMethodBeat.o(24257);
            return;
        }
        if (i3 == -1) {
            switch (i2) {
                case 1:
                    if (intent == null) {
                        Log.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", Integer.valueOf(i2));
                        AppMethodBeat.o(24257);
                        return;
                    }
                    String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        Log.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
                        AppMethodBeat.o(24257);
                        return;
                    }
                    ac.a(this, stringExtra, ac.fb(this), intent.getStringExtra("custom_send_text"), this.rJe);
                    com.tencent.mm.ui.base.h.cD(getContext(), getResources().getString(R.string.z0));
                    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
                    AppMethodBeat.o(24257);
                    return;
                case 2:
                    com.tencent.mm.ui.base.h.cD(getContext(), getResources().getString(R.string.z0));
                    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
                    AppMethodBeat.o(24257);
                    return;
                case 3:
                    if (intent != null) {
                        ArrayList<String> stringsToList = Util.stringsToList(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        for (String str : stringsToList) {
                            com.tencent.mm.plugin.messenger.a.g.eir().s("gh_43f2581f6fd6", str, ab.Eq(str));
                            if (!Util.isNullOrNil(stringExtra2)) {
                                tw twVar = new tw();
                                twVar.eaq.dkV = str;
                                twVar.eaq.content = stringExtra2;
                                twVar.eaq.type = ab.JG(str);
                                twVar.eaq.flags = 0;
                                EventCenter.instance.publish(twVar);
                            }
                        }
                        AppMethodBeat.o(24257);
                        return;
                    }
                    break;
                case 4:
                    if (intent != null && intent.getBooleanExtra("KeyNeedUpdateRank", false)) {
                        cLU();
                        break;
                    }
            }
        }
        AppMethodBeat.o(24257);
    }

    @Override // com.tencent.mm.plugin.exdevice.ui.c
    public final boolean anX(String str) {
        AppMethodBeat.i(24258);
        if (Util.isNullOrNil(this.rIS) || "#".equals(this.rIS)) {
            Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
            Toast.makeText(this, getString(R.string.c1k), 0).show();
            AppMethodBeat.o(24258);
            return true;
        } else if (z.aTY().equals(str)) {
            Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
            Intent intent = new Intent(this, ExdeviceLikeUI.class);
            intent.putExtra("app_username", this.rKv);
            intent.putExtra("rank_id", this.rIS);
            intent.putExtra("key_is_like_read_only", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI", "beforeLikeBtnClicked", "(Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(24258);
            return true;
        } else {
            AppMethodBeat.o(24258);
            return false;
        }
    }

    private void cMb() {
        a anF;
        AppMethodBeat.i(24259);
        if (Util.isNullOrNil(this.rCM) && (anF = ad.cKP().anF(this.mRa)) != null) {
            this.rCM = anF.field_championUrl;
        }
        d h2 = b.h(this.mRa, this.rKB);
        String str = "--";
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (h2 != null) {
            str = String.valueOf(h2.field_ranknum);
            str2 = String.valueOf(h2.field_score);
        }
        new ac().a(this, str, str2, this.rCM, new ac.a() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass13 */

            @Override // com.tencent.mm.plugin.exdevice.model.ac.a
            public final void anx(String str) {
                AppMethodBeat.i(24223);
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
                intent.putExtra("Ksnsupload_appname", ExdeviceRankInfoUI.this.getString(R.string.c2n));
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("need_result", true);
                String JX = com.tencent.mm.model.ad.JX("wx_sport");
                com.tencent.mm.model.ad.aVe().G(JX, true).l("prePublishId", "wx_sport");
                intent.putExtra("reportSessionId", JX);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", str);
                com.tencent.mm.br.c.b(ExdeviceRankInfoUI.this, "sns", ".ui.SnsUploadUI", intent, 2);
                AppMethodBeat.o(24223);
            }
        });
        AppMethodBeat.o(24259);
    }

    @Override // com.tencent.mm.plugin.exdevice.g.a.j.a
    public final void a(j jVar) {
        AppMethodBeat.i(24260);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(24225);
                if (ExdeviceRankInfoUI.this.rGN != null && ExdeviceRankInfoUI.this.rGN.isShowing()) {
                    ExdeviceRankInfoUI.this.rGN.dismiss();
                    ExdeviceRankInfoUI.this.rGN = null;
                    Log.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                }
                AppMethodBeat.o(24225);
            }
        });
        this.rJd = jVar.rCq;
        this.rJe = jVar.msN;
        this.rCM = jVar.rCM;
        this.rCL = jVar.rCL;
        this.rCz = jVar.rCz;
        this.rKB = jVar.rCE;
        this.rKA = jVar.rCF;
        this.rKz = this.rKo.b(this.rKA, this.rKB, this.rCL);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(179640);
                ExdeviceRankInfoUI.this.rKo.rJD = ExdeviceRankInfoUI.this.rKz;
                ExdeviceRankInfoUI.this.rKo.notifyDataSetChanged();
                ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this);
                AppMethodBeat.o(179640);
            }
        });
        AppMethodBeat.o(24260);
    }

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24261);
        exdeviceRankInfoUI.rKs.setVisibility(0);
        AppMethodBeat.o(24261);
    }

    static /* synthetic */ void j(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24264);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) exdeviceRankInfoUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass21 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                int i2;
                AppMethodBeat.i(179645);
                if (Log.getLogLevel() == 0) {
                    i2 = 2;
                } else {
                    i2 = com.tencent.mm.n.h.aqJ().getInt("WeRunLaunchGroupRankWeAppSwitch", 0);
                }
                if (i2 == 2) {
                    mVar.b(3, ExdeviceRankInfoUI.this.getString(R.string.c12), R.raw.bottomsheet_icon_transmit);
                }
                mVar.b(0, ExdeviceRankInfoUI.this.getString(R.string.c10), R.raw.bottomsheet_icon_transmit);
                mVar.b(1, ExdeviceRankInfoUI.this.getString(R.string.c13), R.raw.bottomsheet_icon_moment);
                mVar.b(2, ExdeviceRankInfoUI.this.getString(R.string.c0z), R.raw.bottomsheet_icon_donate);
                AppMethodBeat.o(179645);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass22 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(179646);
                switch (menuItem.getItemId()) {
                    case 0:
                        com.tencent.mm.plugin.sport.a.c.pl(15);
                        ExdeviceRankInfoUI.n(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(179646);
                        return;
                    case 1:
                        com.tencent.mm.plugin.sport.a.c.pl(16);
                        ExdeviceRankInfoUI.m(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(179646);
                        return;
                    case 2:
                        com.tencent.mm.plugin.sport.a.c.pl(7);
                        ExdeviceRankInfoUI.o(ExdeviceRankInfoUI.this);
                        AppMethodBeat.o(179646);
                        return;
                    case 3:
                        com.tencent.mm.plugin.sport.a.c.pl(36);
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1063;
                        ((r) g.af(r.class)).a((Context) null, "gh_1f9ebf140e39@app", (String) null, 0, 0, (String) null, appBrandStatObject);
                        break;
                }
                AppMethodBeat.o(179646);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(24264);
    }

    static /* synthetic */ void n(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        a anF;
        AppMethodBeat.i(24266);
        if (Util.isNullOrNil(exdeviceRankInfoUI.rCM) && (anF = ad.cKP().anF(exdeviceRankInfoUI.mRa)) != null) {
            exdeviceRankInfoUI.rCM = anF.field_championUrl;
        }
        d h2 = b.h(exdeviceRankInfoUI.mRa, exdeviceRankInfoUI.rKB);
        String str = "--";
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (h2 != null) {
            str = String.valueOf(h2.field_ranknum);
            str2 = String.valueOf(h2.field_score);
        }
        new ac().a(exdeviceRankInfoUI, str, str2, exdeviceRankInfoUI.rCM, new ac.a() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass14 */

            @Override // com.tencent.mm.plugin.exdevice.model.ac.a
            public final void anx(String str) {
                AppMethodBeat.i(179639);
                ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this, str);
                AppMethodBeat.o(179639);
            }
        });
        AppMethodBeat.o(24266);
    }

    static /* synthetic */ void o(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24267);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1063;
        ((r) g.af(r.class)).a(exdeviceRankInfoUI.getContext(), (String) null, "wx3fca79fc5715b185", 0, 0, "", appBrandStatObject);
        AppMethodBeat.o(24267);
    }

    static /* synthetic */ void p(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        AppMethodBeat.i(24268);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) exdeviceRankInfoUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass17 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(179641);
                if (ExdeviceRankInfoUI.this.rCz) {
                    mVar.d(1, ExdeviceRankInfoUI.this.getString(R.string.c18));
                    AppMethodBeat.o(179641);
                    return;
                }
                mVar.d(0, ExdeviceRankInfoUI.this.getString(R.string.c1d));
                AppMethodBeat.o(179641);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.AnonymousClass18 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(179642);
                if (ExdeviceRankInfoUI.this.rKw == null) {
                    AppMethodBeat.o(179642);
                    return;
                }
                switch (i2) {
                    case 0:
                        ExdeviceRankInfoUI.this.rCz = true;
                        com.tencent.mm.plugin.sport.a.c.pl(10);
                        ad.cKT();
                        com.tencent.mm.plugin.exdevice.g.b.c.c("", ExdeviceRankInfoUI.this.rKv, ExdeviceRankInfoUI.this.rKw.field_username, 3);
                        break;
                }
                AppMethodBeat.o(179642);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(24268);
    }

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI, String str) {
        AppMethodBeat.i(24273);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.br.c.c(exdeviceRankInfoUI, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.o(24273);
    }
}
