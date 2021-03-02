package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.kernel.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.collect.model.d;
import com.tencent.mm.plugin.collect.model.f;
import com.tencent.mm.plugin.collect.model.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dgp;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@i
@com.tencent.mm.ui.base.a(0)
public class CollectMainUI extends WalletPreferenceUI implements com.tencent.mm.ak.i, d.a, ScreenShotUtil.ScreenShotCallback {
    private static int qBI = -1;
    private static int qBJ = -1;
    private static int qBK = -1;
    private static int qBL = -1;
    private static int qBc;
    private int efI;
    private long iOB;
    protected String mTrueName = null;
    private TextView nAB = null;
    private f nRm = null;
    private e oXS;
    private Vibrator ooM;
    private WalletTextView qAA = null;
    private TextView qAB = null;
    private TextView qAC = null;
    private TextView qAD = null;
    private RelativeLayout qAE = null;
    private View qAF = null;
    private Dialog qAG = null;
    private View qAH = null;
    private View qAI = null;
    private boolean qAJ = false;
    private View qAK = null;
    private ImageView qAL;
    private TextView qAM;
    private TextView qAN;
    private TextView qAO;
    protected LinearLayout qAP;
    protected TextView qAQ;
    private RelativeLayout qAR;
    private Bitmap qAS = null;
    protected String qAT = null;
    protected String qAU = null;
    private String qAV = null;
    private int qAW;
    private List<a> qAX = new LinkedList();
    private double qAY;
    private String qAZ = null;
    private long qAb;
    private int qAv;
    private int qAw;
    private g qAx;
    private ImageView qAy = null;
    private TextView qAz = null;
    private LinearLayout qBA;
    private TextView qBB;
    private TextView qBC;
    private TextView qBD;
    private com.tencent.mm.bw.b qBE;
    private f.a qBF;
    private e qBG;
    private u.a qBH = new u.a() {
        /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass12 */

        @Override // com.tencent.mm.platformtools.u.a
        public final void k(String str, Bitmap bitmap) {
            AppMethodBeat.i(64125);
            if (str == null || CollectMainUI.this.qBl == null) {
                AppMethodBeat.o(64125);
                return;
            }
            if (str.equals(CollectMainUI.this.qBl)) {
                Log.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", CollectMainUI.this.qBl, str);
                CollectMainUI.this.cAq();
            }
            AppMethodBeat.o(64125);
        }
    };
    private String qBa = null;
    protected boolean qBb = false;
    private View qBd;
    private b qBe = new b(this, (byte) 0);
    private SpannableStringBuilder qBf;
    private SpannableStringBuilder qBg;
    private com.tencent.mm.plugin.collect.model.f qBh;
    private int qBi = 0;
    private String qBj;
    private String qBk;
    private String qBl;
    private String qBm;
    private String qBn;
    protected CdnImageView qBo;
    protected TextView qBp;
    protected TextView qBq;
    protected ImageView qBr;
    protected ViewGroup qBs;
    protected View qBt;
    private boolean qBu = false;
    private int qBv = 0;
    private coz qBw;
    private dgo qBx;
    private dgo qBy;
    private dgo qBz;
    protected ScrollView qyA = null;

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CollectMainUI() {
        AppMethodBeat.i(64149);
        AppMethodBeat.o(64149);
    }

    static /* synthetic */ void a(CollectMainUI collectMainUI, adw adw) {
        AppMethodBeat.i(213238);
        collectMainUI.a(adw);
        AppMethodBeat.o(213238);
    }

    static /* synthetic */ void a(CollectMainUI collectMainUI, dgo dgo) {
        AppMethodBeat.i(213223);
        collectMainUI.a(dgo, (adw) null);
        AppMethodBeat.o(213223);
    }

    static /* synthetic */ void b(CollectMainUI collectMainUI, dgo dgo) {
        AppMethodBeat.i(213229);
        collectMainUI.a(dgo);
        AppMethodBeat.o(213229);
    }

    static /* synthetic */ void c(CollectMainUI collectMainUI) {
        AppMethodBeat.i(213224);
        collectMainUI.Fe(2);
        AppMethodBeat.o(213224);
    }

    static /* synthetic */ cor cAD() {
        AppMethodBeat.i(213232);
        cor cAw = cAw();
        AppMethodBeat.o(213232);
        return cAw;
    }

    static /* synthetic */ List cAE() {
        AppMethodBeat.i(213233);
        List<cor> cAx = cAx();
        AppMethodBeat.o(213233);
        return cAx;
    }

    static /* synthetic */ String d(CollectMainUI collectMainUI) {
        AppMethodBeat.i(213225);
        String cAA = collectMainUI.cAA();
        AppMethodBeat.o(213225);
        return cAA;
    }

    static /* synthetic */ int e(CollectMainUI collectMainUI) {
        AppMethodBeat.i(213226);
        int cAy = collectMainUI.cAy();
        AppMethodBeat.o(213226);
        return cAy;
    }

    static /* synthetic */ String f(CollectMainUI collectMainUI) {
        AppMethodBeat.i(213227);
        String cAz = collectMainUI.cAz();
        AppMethodBeat.o(213227);
        return cAz;
    }

    static /* synthetic */ void i(CollectMainUI collectMainUI) {
        AppMethodBeat.i(213228);
        collectMainUI.cAs();
        AppMethodBeat.o(213228);
    }

    static /* synthetic */ void n(CollectMainUI collectMainUI) {
        AppMethodBeat.i(213230);
        collectMainUI.cAt();
        AppMethodBeat.o(213230);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64150);
        fixStatusbar(true);
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        setIsDarkActionbarBg(true);
        hideActionbarLine();
        com.tencent.mm.kernel.g.aAi();
        this.efI = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
        this.qAb = z.aUd();
        int intExtra = getIntent().getIntExtra("key_from_scene", 1);
        h.INSTANCE.a(14021, 2, Integer.valueOf(intExtra));
        overridePendingTransition(R.anim.eq, R.anim.en);
        com.tencent.mm.plugin.collect.a.a.czp();
        d czq = com.tencent.mm.plugin.collect.a.a.czq();
        if (!czq.pQG.contains(this)) {
            czq.pQG.add(this);
        }
        initView();
        cAn();
        refreshView();
        this.ooM = (Vibrator) getSystemService("vibrator");
        this.iOB = Util.nowSecond();
        if (qBI < 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            qBI = (displayMetrics.widthPixels / 2) - BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 20.0f);
            qBJ = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 60.0f);
            qBK = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 40.0f);
            qBL = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 70.0f);
        }
        cAs();
        ab.mg(16, 0);
        com.tencent.mm.kernel.g.azz().a(3781, this);
        AppMethodBeat.o(64150);
    }

    /* access modifiers changed from: protected */
    public final void cAr() {
        AppMethodBeat.i(213211);
        com.tencent.mm.kernel.g.aAi();
        if (((String) com.tencent.mm.kernel.g.aAh().azQ().get(327731, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            this.qBF = new f.a(getContext());
            this.qBF.aC(getResources().getString(R.string.b6t));
            f.a Dq = this.qBF.bow(getResources().getString(ah.hhE())).Dq(true);
            Dq.JnN = true;
            Dq.apa(R.string.i5n).b(new f.c() {
                /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                }
            }).show();
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(327731, "1");
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().gBI();
        }
        AppMethodBeat.o(213211);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI
    public final void setStatusColor() {
        AppMethodBeat.i(64151);
        setActionbarColor(getResources().getColor(R.color.al));
        AppMethodBeat.o(64151);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(64152);
        if (this.qAy != null) {
            this.qAy.setImageBitmap(null);
        }
        Bitmap bitmap = this.qAS;
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("MicroMsg.CollectMainUI", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        if (this.qAG != null) {
            this.qAG.dismiss();
        }
        com.tencent.mm.plugin.collect.a.a.czp();
        com.tencent.mm.plugin.collect.a.a.czq().pQG.remove(this);
        this.ooM.cancel();
        if (this.qBh != null) {
            com.tencent.mm.plugin.collect.model.f fVar = this.qBh;
            for (Map.Entry<l, f.a> entry : fVar.oPn.entrySet()) {
                Log.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.a(entry.getKey());
            }
            fVar.oPn.clear();
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.b(1588, fVar);
        }
        u.c(this.qBH);
        com.tencent.mm.kernel.g.azz().b(3781, this);
        super.onDestroy();
        AppMethodBeat.o(64152);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64153);
        setMMTitle(R.string.fi6);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass20 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(64130);
                CollectMainUI.this.finish();
                AppMethodBeat.o(64130);
                return true;
            }
        });
        this.nRm = getPreferenceScreen();
        this.qAE = (RelativeLayout) findViewById(R.id.h8v);
        this.qAF = findViewById(R.id.b70);
        this.qBt = findViewById(R.id.b71);
        this.qAA = (WalletTextView) findViewById(R.id.b6q);
        this.qAz = (TextView) findViewById(R.id.b6p);
        this.qAB = (TextView) findViewById(R.id.b6r);
        this.qAC = (TextView) findViewById(R.id.b6z);
        this.qAP = (LinearLayout) findViewById(R.id.g29);
        this.qAQ = (TextView) findViewById(R.id.a2b);
        this.qAH = (RelativeLayout) findViewById(R.id.b6x);
        this.qAI = findViewById(R.id.b6v);
        this.qBd = LayoutInflater.from(this).inflate(R.layout.v_, (ViewGroup) null, false);
        this.qAD = (TextView) findViewById(R.id.b7_);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.b78));
        spannableStringBuilder.setSpan(new q(new q.a() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass21 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(64132);
                CollectMainUI.a(CollectMainUI.this, CollectMainUI.this.qBz);
                CollectMainUI.c(CollectMainUI.this);
                if (CollectMainUI.this.qBz != null) {
                    h.INSTANCE.a(20032, "wxface2face", "ClickQRCode", "", "", "", "", 2, Integer.valueOf(CollectMainUI.this.qBz.pTI), 0, CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this));
                }
                h.INSTANCE.a(13944, 5);
                AppMethodBeat.o(64132);
            }
        }, (byte) 0), 0, spannableStringBuilder.length(), 18);
        this.qAD.setText(spannableStringBuilder);
        this.qAD.setClickable(true);
        this.qAD.setOnTouchListener(new o(this));
        getListView().addFooterView(this.qBd, null, false);
        getListView().setFooterDividersEnabled(false);
        this.qAy = (ImageView) findViewById(R.id.b6u);
        this.nAB = (TextView) findViewById(R.id.b7f);
        this.qAO = (TextView) findViewById(R.id.b7x);
        this.qAO.setClickable(true);
        this.qAO.setOnTouchListener(new o(this));
        this.qBf = new SpannableStringBuilder(getString(R.string.b6w));
        this.qBg = new SpannableStringBuilder(getString(R.string.b6x));
        final q qVar = new q(new q.a() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass22 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(64133);
                Intent intent = new Intent();
                intent.setClass(CollectMainUI.this.getContext(), CollectCreateQRCodeNewUI.class);
                intent.putExtra("key_currency_unit", CollectMainUI.this.qAU);
                CollectMainUI.this.startActivityForResult(intent, 4096);
                AppMethodBeat.o(64133);
            }
        }, (byte) 0);
        final q qVar2 = new q(new q.a() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass23 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(64134);
                CollectMainUI.this.qBb = false;
                CollectMainUI.this.cAq();
                CollectMainUI.this.qAO.setText(CollectMainUI.this.qBf);
                CollectMainUI.i(CollectMainUI.this);
                AppMethodBeat.o(64134);
            }
        }, (byte) 0);
        this.qBf.setSpan(qVar, 0, this.qBf.length(), 18);
        if (a.C2075a.OLX.gKc()) {
            this.qAO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass24 */

                public final void onClick(View view) {
                    AppMethodBeat.i(64135);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (CollectMainUI.this.qAO.getText().toString().equals(CollectMainUI.this.qBg)) {
                        qVar.onClick(view);
                    } else {
                        qVar2.onClick(view);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64135);
                }
            });
        }
        this.qBg.setSpan(qVar2, 0, this.qBg.length(), 18);
        this.qAO.setText(this.qBf);
        this.qAR = (RelativeLayout) findViewById(R.id.b7m);
        this.qAy.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass25 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(64140);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                CollectMainUI.b(CollectMainUI.this, CollectMainUI.this.qBy);
                if (CollectMainUI.this.qBy != null) {
                    h.INSTANCE.a(20032, "wxface2face", "LongClick", "", "", "", "", 3, Integer.valueOf(CollectMainUI.this.qBy.pTI), 0, CollectMainUI.d(CollectMainUI.this), Integer.valueOf(CollectMainUI.e(CollectMainUI.this)), CollectMainUI.f(CollectMainUI.this));
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(64140);
                return true;
            }
        });
        this.qAK = findViewById(R.id.b73);
        this.qAL = (ImageView) findViewById(R.id.b7o);
        this.qAM = (TextView) findViewById(R.id.b7q);
        this.qAN = (TextView) findViewById(R.id.b7p);
        this.qBo = (CdnImageView) findViewById(R.id.b5u);
        this.qBp = (TextView) findViewById(R.id.b5x);
        this.qBq = (TextView) findViewById(R.id.b5y);
        this.qBr = (ImageView) findViewById(R.id.b5w);
        this.qBs = (ViewGroup) findViewById(R.id.b5v);
        this.qAH.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass26 */

            public final void run() {
                AppMethodBeat.i(64141);
                int[] iArr = new int[2];
                CollectMainUI.this.qAH.getLocationInWindow(iArr);
                int unused = CollectMainUI.qBc = iArr[1];
                AppMethodBeat.o(64141);
            }
        }, 300);
        final zt ztVar = new zt();
        ztVar.efM.scene = "8";
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(64114);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    com.tencent.mm.wallet_core.ui.f.a((TextView) CollectMainUI.this.findViewById(R.id.a2b), ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                    AppMethodBeat.o(64114);
                    return;
                }
                Log.i("MicroMsg.CollectMainUI", "no bulletin data");
                AppMethodBeat.o(64114);
            }
        };
        EventCenter.instance.publish(ztVar);
        this.qBA = (LinearLayout) findViewById(R.id.b7i);
        this.qBB = (TextView) findViewById(R.id.b7l);
        this.qBC = (Button) findViewById(R.id.b7j);
        this.qBD = (Button) findViewById(R.id.b7k);
        AppMethodBeat.o(64153);
    }

    /* access modifiers changed from: protected */
    public final void refreshView() {
        AppMethodBeat.i(64155);
        if (Util.isNullOrNil(this.qAT)) {
            Log.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
            AppMethodBeat.o(64155);
            return;
        }
        if (this.qBi == 1) {
            if (!Util.isNullOrNil(this.qBj)) {
                this.nAB.setText(this.qBj);
            }
            if (!Util.isNullOrNil(this.qBk)) {
                TextView textView = (TextView) findViewById(R.id.b6w);
                textView.setText(this.qBk);
                textView.setVisibility(0);
            }
        }
        cAq();
        cAt();
        cAu();
        cAv();
        AppMethodBeat.o(64155);
    }

    /* access modifiers changed from: protected */
    public void cAq() {
        AppMethodBeat.i(64156);
        this.qAy.setImageBitmap(null);
        if (this.qBb) {
            if (Util.isNullOrNil(this.qAV)) {
                Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
                AppMethodBeat.o(64156);
                return;
            }
            this.qAS = cU(this.qAV, this.qAW);
        } else if (Util.isNullOrNil(this.qAT)) {
            Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
            AppMethodBeat.o(64156);
            return;
        } else {
            this.qAS = cU(this.qAT, this.qAW);
        }
        if (this.qAS == null || this.qAS.isRecycled()) {
            Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + Util.nullAsNil(this.qAV));
        } else {
            this.qAy.setImageBitmap(this.qAS);
        }
        if (this.qBb) {
            this.qAA.setPrefix(cAo());
            this.qAA.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.qAY));
            this.qAA.setVisibility(0);
            if (!Util.isNullOrNil(this.qBa)) {
                this.qAz.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.qBa, this.qAz.getTextSize()));
                this.qAz.setVisibility(0);
            } else {
                this.qAz.setVisibility(8);
            }
            findViewById(R.id.b6t).setVisibility(0);
            AppMethodBeat.o(64156);
            return;
        }
        this.qAB.setVisibility(8);
        this.qAA.setVisibility(8);
        this.qAz.setVisibility(8);
        findViewById(R.id.b6t).setVisibility(8);
        AppMethodBeat.o(64156);
    }

    private void cAs() {
        AppMethodBeat.i(64157);
        getWindow().getDecorView().post(new Runnable() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(64115);
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) CollectMainUI.this.getContext(), 37);
                ViewGroup.LayoutParams layoutParams = CollectMainUI.this.qBd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = fromDPToPix;
                    CollectMainUI.this.qBd.setLayoutParams(layoutParams);
                    CollectMainUI.this.qBd.requestLayout();
                }
                AppMethodBeat.o(64115);
            }
        });
        AppMethodBeat.o(64157);
    }

    private void cAt() {
        double d2;
        c cVar;
        AppMethodBeat.i(64158);
        if (this.qAX == null || this.qAX.size() <= 0) {
            d2 = 0.0d;
        } else {
            this.qAH.setBackgroundResource(R.drawable.ps);
            this.nRm.removeAll();
            d2 = 0.0d;
            for (int i2 = 0; i2 < this.qAX.size(); i2++) {
                a aVar = this.qAX.get(i2);
                String valueOf = String.valueOf(i2);
                if (i2 == this.qAX.size() - 1) {
                    cVar = new c(this, (byte) 0);
                } else {
                    cVar = new c(this);
                }
                cVar.setKey(valueOf);
                String str = aVar.gCv;
                if (Util.isNullOrNil(str) && !Util.isNullOrNil(aVar.username)) {
                    str = com.tencent.mm.wallet_core.ui.f.getDisplayName(aVar.username);
                }
                cVar.mTitle = str;
                cVar.goe = aVar.username;
                if (aVar.status == 0) {
                    cVar.setSummary(R.string.b73);
                } else if (aVar.status == 1) {
                    if (aVar.isAnimated) {
                        d2 += aVar.qwJ;
                        cVar.setSummary(com.tencent.mm.wallet_core.ui.f.d(aVar.qwJ, aVar.dFv));
                    } else {
                        cVar.setSummary(R.string.b72);
                    }
                    this.nRm.c(cVar);
                } else if (aVar.status == 2) {
                    cVar.setSummary(R.string.b71);
                }
                this.nRm.c(cVar);
            }
            this.nRm.notifyDataSetChanged();
            this.qAC.setText(com.tencent.mm.wallet_core.ui.f.d(d2, this.qAX.get(0).dFv));
            this.qAC.setVisibility(0);
        }
        if (this.qAX == null || this.qAX.size() <= 0) {
            this.qAC.setVisibility(8);
            this.qAF.setVisibility(8);
            this.qAI.setVisibility(8);
        } else {
            this.qBs.setBackgroundResource(R.drawable.pt);
            this.qAF.setVisibility(0);
            if (d2 > 0.0d && this.qAX.size() > 0) {
                this.qBt.setVisibility(0);
                this.qAI.setVisibility(0);
                AppMethodBeat.o(64158);
                return;
            }
        }
        AppMethodBeat.o(64158);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.base.preference.MMPreference
    public int getLayoutId() {
        return R.layout.v9;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.t;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getHeaderResourceId() {
        return R.layout.va;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI
    public boolean e(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        return false;
    }

    private Bitmap cU(String str, int i2) {
        AppMethodBeat.i(64159);
        Bitmap a2 = com.tencent.mm.plugin.collect.model.b.a(this, str, z.aTY(), this.qBi, this.qBl, this.qBH, i2);
        AppMethodBeat.o(64159);
        return a2;
    }

    @Override // com.tencent.mm.plugin.collect.model.d.a
    public final void a(com.tencent.mm.plugin.collect.model.u uVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(64160);
        Log.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
        if (((this.efI == 1 || this.efI == 0) && uVar.msgType == 9) || (this.efI == 8 && uVar.msgType == 26)) {
            if (this.ooM != null) {
                this.ooM.vibrate(50);
            }
            if (((long) uVar.qwL) < this.iOB) {
                Log.d("MicroMsg.CollectMainUI", "Recieve but time out ");
                AppMethodBeat.o(64160);
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 < this.qAX.size()) {
                    if (uVar.status == 0 && Util.nullAsNil(uVar.username).equals(this.qAX.get(i2).username) && this.qAX.get(i2).status == 2) {
                        this.qAX.remove(i2);
                        this.qAX.add(i2, new a(uVar));
                        z = true;
                        break;
                    } else if (uVar.dDM.equals(this.qAX.get(i2).dDM)) {
                        Log.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + uVar.dDM);
                        if (this.qAX.get(i2).status == 0) {
                            this.qAX.get(i2).status = uVar.status;
                            this.qAX.get(i2).qwJ = uVar.qwJ;
                            this.qAX.get(i2).dFv = uVar.dFv;
                            if (uVar.status == 1) {
                                this.qBe.qCb.add(this.qAX.get(i2));
                            }
                        }
                        z = true;
                    } else {
                        i2++;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.qAX.size()) {
                        break;
                    } else if (uVar.qwL > this.qAX.get(i3).qwL) {
                        this.qAX.add(i3, new a(uVar));
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    this.qAX.add(new a(uVar));
                }
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(64116);
                    CollectMainUI.n(CollectMainUI.this);
                    CollectMainUI.this.qBe.cAF();
                    CollectMainUI.i(CollectMainUI.this);
                    AppMethodBeat.o(64116);
                }
            });
        }
        AppMethodBeat.o(64160);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64161);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 4096:
                if (i3 != -1 || intent == null) {
                    this.qBb = false;
                } else {
                    this.qAV = intent.getStringExtra("ftf_pay_url");
                    this.qAW = intent.getIntExtra("key_error_level", -1);
                    this.qAY = intent.getDoubleExtra("ftf_fixed_fee", 0.0d);
                    this.qAZ = intent.getStringExtra("ftf_fixed_fee_type");
                    this.qBa = intent.getStringExtra("ftf_fixed_desc");
                    this.qAU = intent.getStringExtra("key_currency_unit");
                    this.qAO.setText(this.qBg);
                    this.qBb = true;
                }
                refreshView();
                cAs();
                AppMethodBeat.o(64161);
                return;
            case 4097:
                this.qAb = z.aUd();
                break;
        }
        AppMethodBeat.o(64161);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(64162);
        super.onResume();
        ScreenShotUtil.setScreenShotCallback(this, this);
        AppMethodBeat.o(64162);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(64163);
        super.onPause();
        ScreenShotUtil.setScreenShotCallback(this, null);
        AppMethodBeat.o(64163);
    }

    @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
    public void onScreenShot(String str, long j2) {
        AppMethodBeat.i(213212);
        Log.i("MicroMsg.CollectMainUI", "do screen shot");
        h.INSTANCE.a(13944, 9);
        if (this.qBx != null) {
            h.INSTANCE.a(20032, "wxface2face", "ScreenShot", "", "", "", "", 1, Integer.valueOf(this.qBx.pTI), 0, cAA(), Integer.valueOf(cAy()), cAz());
        }
        if ((this.qBG == null || !this.qBG.isShowing()) && (this.qBF == null || this.qBF.kdo == null || !this.qBF.kdo.isShowing())) {
            a(this.qBx);
            Fe(1);
            AppMethodBeat.o(213212);
            return;
        }
        Log.i("MicroMsg.CollectMainUI", "helper.isShowing() || isShowTips, do not showScreen Action");
        AppMethodBeat.o(213212);
    }

    /* access modifiers changed from: package-private */
    public class a extends com.tencent.mm.plugin.collect.model.u {
        public boolean isAnimated = false;

        public a(com.tencent.mm.plugin.collect.model.u uVar) {
            this.username = uVar.username;
            this.dDM = uVar.dDM;
            this.qwJ = uVar.qwJ;
            this.qwL = uVar.qwL;
            this.scene = uVar.scene;
            this.status = uVar.status;
            this.gCv = uVar.gCv;
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        boolean qCa;
        LinkedList<a> qCb;

        private b() {
            AppMethodBeat.i(64145);
            this.qCb = new LinkedList<>();
            AppMethodBeat.o(64145);
        }

        /* synthetic */ b(CollectMainUI collectMainUI, byte b2) {
            this();
        }

        private int Fg(int i2) {
            AppMethodBeat.i(64146);
            float height = 0.0f + ((float) (CollectMainUI.this.qAH.getHeight() / 2));
            if (CollectMainUI.this.qAF.getVisibility() == 0) {
                height += (float) CollectMainUI.this.qAF.getHeight();
            }
            float f2 = height + ((float) ((CollectMainUI.qBJ * i2) + (CollectMainUI.qBJ / 2)));
            int[] iArr = new int[2];
            CollectMainUI.this.qAH.getLocationInWindow(iArr);
            int i3 = (int) (f2 + ((float) (iArr[1] - CollectMainUI.qBc)));
            AppMethodBeat.o(64146);
            return i3;
        }

        public final void cAF() {
            AppMethodBeat.i(64147);
            if (this.qCa) {
                Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.qCb.size());
            } else if (!this.qCb.isEmpty()) {
                a(this.qCb.poll());
                AppMethodBeat.o(64147);
                return;
            }
            AppMethodBeat.o(64147);
        }

        private void a(final a aVar) {
            AppMethodBeat.i(64148);
            this.qCa = true;
            CollectMainUI.n(CollectMainUI.this);
            CollectMainUI.this.qAK.setLayoutParams(new LinearLayout.LayoutParams(CollectMainUI.this.qAH.getWidth(), CollectMainUI.this.qAH.getHeight() + com.tencent.mm.cb.a.fromDPToPix((Context) CollectMainUI.this.getContext(), 8)));
            CollectMainUI.this.qAM.setText(com.tencent.mm.pluginsdk.ui.span.l.b(CollectMainUI.this.getContext(), aVar.gCv, CollectMainUI.this.qAM.getTextSize()));
            a.b.c(CollectMainUI.this.qAL, aVar.username);
            CollectMainUI.this.qAN.setText(com.tencent.mm.wallet_core.ui.f.d(aVar.qwJ, aVar.dFv));
            CollectMainUI.this.qAK.setVisibility(0);
            final AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
            int i2 = 0;
            for (int i3 = 0; i3 < CollectMainUI.this.qAX.size(); i3++) {
                if (((a) CollectMainUI.this.qAX.get(i3)).dDM.equals(aVar.dDM)) {
                    i2 = i3;
                }
            }
            animationSet.addAnimation(new TranslateAnimation(0.0f, (float) CollectMainUI.qBI, 0.0f, (float) Fg(i2)));
            animationSet.setDuration(300);
            animationSet.setInterpolator(new DecelerateInterpolator());
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.b.AnonymousClass1 */

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(64142);
                    CollectMainUI.this.qAK.setVisibility(8);
                    Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + aVar.dDM);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= CollectMainUI.this.qAX.size()) {
                            break;
                        } else if (((a) CollectMainUI.this.qAX.get(i2)).dDM.equals(aVar.dDM)) {
                            ((a) CollectMainUI.this.qAX.get(i2)).isAnimated = true;
                            Log.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + aVar.dDM);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    CollectMainUI.n(CollectMainUI.this);
                    b.this.qCa = false;
                    b.this.cAF();
                    AppMethodBeat.o(64142);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new LinearInterpolator());
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.b.AnonymousClass2 */

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(64143);
                    animationSet.setStartOffset(1700);
                    CollectMainUI.this.qAK.startAnimation(animationSet);
                    AppMethodBeat.o(64143);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(64144);
                    CollectMainUI.this.qAK.setVisibility(0);
                    AppMethodBeat.o(64144);
                }
            });
            CollectMainUI.this.qAK.startAnimation(scaleAnimation);
            AppMethodBeat.o(64148);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(64165);
        super.finish();
        overridePendingTransition(R.anim.em, R.anim.er);
        AppMethodBeat.o(64165);
    }

    private void cAu() {
        AppMethodBeat.i(64166);
        bf fQy = k.fQy();
        int i2 = this.qBb ? 33 : 32;
        if (fQy != null) {
            h.INSTANCE.a(13447, Integer.valueOf(i2), fQy.KED, fQy.KEE, this.qAT, Double.valueOf(this.qAY), Long.valueOf(Util.nowSecond()), Long.valueOf(fQy.KEC), fQy.KEF, fQy.KEG);
        }
        AppMethodBeat.o(64166);
    }

    private void cAv() {
        AppMethodBeat.i(64167);
        if (!Util.isNullOrNil(this.qBm)) {
            this.qAQ.setText(this.qBm);
            this.qAQ.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213196);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!Util.isNullOrNil(CollectMainUI.this.qBn)) {
                        com.tencent.mm.wallet_core.ui.f.p(MMApplicationContext.getContext(), CollectMainUI.this.qBn, true);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213196);
                }
            });
            this.qAP.setVisibility(0);
            AppMethodBeat.o(64167);
            return;
        }
        this.qAP.setVisibility(8);
        AppMethodBeat.o(64167);
    }

    private static cor cAw() {
        AppMethodBeat.i(64169);
        try {
            com.tencent.mm.kernel.g.aAi();
            cor aJ = aJ(new JSONObject((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_MENU_STRING_SYNC, "")));
            AppMethodBeat.o(64169);
            return aJ;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CollectMainUI", e2, "", new Object[0]);
            AppMethodBeat.o(64169);
            return null;
        }
    }

    private static List<cor> cAx() {
        AppMethodBeat.i(64170);
        ArrayList arrayList = new ArrayList();
        try {
            com.tencent.mm.kernel.g.aAi();
            String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_F2F_COLLECT_UPRIGHT_MENU_STRING_SYNC, "");
            if (!Util.isNullOrNil(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(aJ(jSONArray.getJSONObject(i2)));
                }
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CollectMainUI", e2, "", new Object[0]);
        }
        AppMethodBeat.o(64170);
        return arrayList;
    }

    private static cor aJ(JSONObject jSONObject) {
        AppMethodBeat.i(64171);
        cor cor = new cor();
        cor.type = jSONObject.optInt("type", -1);
        cor.url = jSONObject.optString("url", "");
        cor.dQx = jSONObject.optString("wording", "");
        cor.MuQ = jSONObject.optString("waapp_username", "");
        cor.MuR = jSONObject.optString("waapp_path", "");
        AppMethodBeat.o(64171);
        return cor;
    }

    /* access modifiers changed from: protected */
    public String getTrueName() {
        AppMethodBeat.i(64172);
        if (Util.isNullOrNil(this.mTrueName)) {
            this.mTrueName = t.fQI().getTrueName();
            this.mTrueName = com.tencent.mm.wallet_core.ui.f.bps(this.mTrueName);
        }
        String str = this.mTrueName;
        AppMethodBeat.o(64172);
        return str;
    }

    /* access modifiers changed from: protected */
    public String cAo() {
        AppMethodBeat.i(64173);
        String bpp = com.tencent.mm.wallet_core.ui.f.bpp(this.qAZ);
        AppMethodBeat.o(64173);
        return bpp;
    }

    /* access modifiers changed from: protected */
    public final void de(final List<cor> list) {
        AppMethodBeat.i(64174);
        if (list != null) {
            for (cor cor : list) {
                if (cor.type == 1) {
                    h.INSTANCE.a(14526, 2, 1, cor.dQx, "", "", "", 1);
                } else if (cor.type == 2) {
                    h.INSTANCE.a(14526, 2, 2, cor.dQx, "", "", cor.url, 1);
                } else if (cor.type == 3) {
                    h.INSTANCE.a(14526, 2, 3, cor.dQx, cor.MuQ, cor.MuR, "", 1);
                }
            }
        }
        this.qAR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(213203);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CollectMainUI.this.qBG = new e((Context) CollectMainUI.this.getContext(), 1, false);
                CollectMainUI.this.qBG.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass9.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(213201);
                        com.tencent.mm.plugin.collect.a.a.czp();
                        if (com.tencent.mm.plugin.collect.a.a.czr()) {
                            mVar.add(0, 1, 0, R.string.b6p);
                        } else {
                            mVar.add(0, 1, 0, R.string.b6z);
                        }
                        if (list != null) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                cor cor = (cor) list.get(i2);
                                if (!Util.isNullOrNil(cor.dQx)) {
                                    mVar.add(0, i2 + 1 + 1, 0, cor.dQx);
                                }
                            }
                        }
                        AppMethodBeat.o(213201);
                    }
                };
                CollectMainUI.this.qBG.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass9.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(213202);
                        switch (menuItem.getItemId()) {
                            case 1:
                                com.tencent.mm.plugin.collect.a.a.czp();
                                if (com.tencent.mm.plugin.collect.a.a.czr()) {
                                    CollectMainUI.B(CollectMainUI.this);
                                    Toast.makeText(CollectMainUI.this.getContext(), (int) R.string.b6q, 1).show();
                                    h.INSTANCE.a(13944, 8);
                                    AppMethodBeat.o(213202);
                                    return;
                                }
                                CollectMainUI.C(CollectMainUI.this);
                                Toast.makeText(CollectMainUI.this.getContext(), (int) R.string.b70, 1).show();
                                com.tencent.mm.plugin.collect.model.voice.a.czG().kN(false);
                                h.INSTANCE.a(13944, 7);
                                AppMethodBeat.o(213202);
                                return;
                            default:
                                int itemId = (menuItem.getItemId() - 1) - 1;
                                if (itemId < 0) {
                                    Log.w("MicroMsg.CollectMainUI", "illegal pos: %s", Integer.valueOf(itemId));
                                    AppMethodBeat.o(213202);
                                    return;
                                }
                                cor cor = (cor) list.get(itemId);
                                if (cor.type == 1) {
                                    Log.w("MicroMsg.CollectMainUI", "wrong native type: %s", cor.url);
                                    h.INSTANCE.a(14526, 2, 1, cor.dQx, "", "", "", 2);
                                    AppMethodBeat.o(213202);
                                    return;
                                }
                                if (cor.type == 2) {
                                    if (!Util.isNullOrNil(cor.url)) {
                                        com.tencent.mm.wallet_core.ui.f.p(CollectMainUI.this.getContext(), cor.url, false);
                                        h.INSTANCE.a(14526, 2, 2, cor.dQx, "", "", cor.url, 2);
                                        AppMethodBeat.o(213202);
                                        return;
                                    }
                                } else if (cor.type == 3) {
                                    wq wqVar = new wq();
                                    wqVar.ecI.userName = cor.MuQ;
                                    wqVar.ecI.ecK = Util.nullAs(cor.MuR, "");
                                    wqVar.ecI.scene = 1072;
                                    wqVar.ecI.ecL = 0;
                                    EventCenter.instance.publish(wqVar);
                                    h.INSTANCE.a(14526, 2, 3, cor.dQx, cor.MuQ, cor.MuR, "", 2);
                                }
                                AppMethodBeat.o(213202);
                                return;
                        }
                    }
                };
                CollectMainUI.this.qBG.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213203);
            }
        });
        AppMethodBeat.o(64174);
    }

    /* access modifiers changed from: protected */
    public void cAp() {
    }

    private int cAy() {
        AppMethodBeat.i(213213);
        if (!this.qAA.isShown() || Util.isNullOrNil(this.qAA.getText())) {
            AppMethodBeat.o(213213);
            return 0;
        }
        int parseInt = Integer.parseInt(com.tencent.mm.wallet_core.ui.f.c(new StringBuilder().append((Object) this.qAA.getText()).toString(), "100", 0, RoundingMode.HALF_UP).toString());
        AppMethodBeat.o(213213);
        return parseInt;
    }

    private String cAz() {
        AppMethodBeat.i(213214);
        if (!this.qAz.isShown() || Util.isNullOrNil(this.qAz.getText())) {
            AppMethodBeat.o(213214);
            return "";
        }
        String charSequence = this.qAz.getText().toString();
        AppMethodBeat.o(213214);
        return charSequence;
    }

    private String cAA() {
        AppMethodBeat.i(213215);
        if (this.qBb) {
            if (Util.isNullOrNil(this.qAV)) {
                Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
                AppMethodBeat.o(213215);
                return "";
            }
            String str = this.qAV;
            AppMethodBeat.o(213215);
            return str;
        } else if (Util.isNullOrNil(this.qAT)) {
            Log.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
            AppMethodBeat.o(213215);
            return "";
        } else {
            String str2 = this.qAT;
            AppMethodBeat.o(213215);
            return str2;
        }
    }

    private void Fe(int i2) {
        AppMethodBeat.i(213216);
        int cAy = cAy();
        String cAz = cAz();
        String cAA = cAA();
        Log.i("MicroMsg.CollectMainUI", "doSceneSaveQrcodeNotify notifyType:%s，amount: %s,memo: %s,url: %s,mSaveNotifyInfo:%s", Integer.valueOf(i2), Integer.valueOf(cAy), cAz, cAA, this.qBE);
        com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.collect.model.m(i2, cAy, cAz, cAA, this.qBE), 0);
        AppMethodBeat.o(213216);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(213217);
        Log.i("MicroMsg.CollectMainUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof com.tencent.mm.plugin.collect.model.m) {
            Log.i("MicroMsg.CollectMainUI", "scene is NetSceneF2fQrcodeSaveNotify");
        }
        AppMethodBeat.o(213217);
    }

    private void a(dgo dgo) {
        AppMethodBeat.i(213218);
        if (dgo == null) {
            Log.i("MicroMsg.CollectMainUI", "actionInfo is null");
            AppMethodBeat.o(213218);
            return;
        }
        Log.i("MicroMsg.CollectMainUI", "actionInfo.action_type：%s", Integer.valueOf(dgo.pTI));
        switch (dgo.pTI) {
            case 0:
                AppMethodBeat.o(213218);
                return;
            case 1:
                a(dgo.MLg);
                AppMethodBeat.o(213218);
                return;
            case 2:
                a(dgo.MLh);
                AppMethodBeat.o(213218);
                return;
            case 3:
                a(dgo.MLi);
                AppMethodBeat.o(213218);
                return;
            default:
                Log.i("MicroMsg.CollectMainUI", "unknow actionInfo.action_type");
                AppMethodBeat.o(213218);
                return;
        }
    }

    private void a(cas cas) {
        AppMethodBeat.i(213219);
        if (cas == null || (this.qAx != null && this.qAx.isShowing())) {
            Log.i("MicroMsg.CollectMainUI", "mHalfBottomDialog != null || mHalfBottomDialog.isShowing() || halfPage == null ");
            AppMethodBeat.o(213219);
        } else if (this.oXS == null || !this.oXS.isShowing()) {
            Log.i("MicroMsg.CollectMainUI", "showHalfDialog");
            final dgp dgp = cas.MfW;
            final dgp dgp2 = cas.MfX;
            this.qAv = 4;
            this.qAx = new g(getContext(), 1, 3);
            this.qAx.b(dgp.dQx, dgp2.dQx);
            this.qAx.a(new g.a() {
                /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass10 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213204);
                    CollectMainUI.this.qAw = 1;
                    CollectMainUI.a(CollectMainUI.this, dgp);
                    CollectMainUI.this.qAx.bMo();
                    CollectMainUI.this.qAx = null;
                    AppMethodBeat.o(213204);
                }
            }, new g.a() {
                /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass11 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213205);
                    CollectMainUI.this.qAw = 1;
                    CollectMainUI.a(CollectMainUI.this, dgp2);
                    CollectMainUI.this.qAx.bMo();
                    CollectMainUI.this.qAx = null;
                    AppMethodBeat.o(213205);
                }
            });
            if (cas.MfV.type == 2) {
                View inflate = View.inflate(getContext(), R.layout.v8, null);
                ((ImageView) inflate.findViewById(R.id.xv)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass13 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(64126);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        CollectMainUI.this.qAx.bMo();
                        CollectMainUI.this.qAx = null;
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(64126);
                    }
                });
                TextView textView = (TextView) inflate.findViewById(R.id.b6i);
                textView.setText(cas.MfV.Nhm);
                ao.a(textView.getPaint(), 0.8f);
                this.qAx.setHeaderView(inflate);
            } else {
                View inflate2 = View.inflate(getContext(), R.layout.v7, null);
                TextView textView2 = (TextView) inflate2.findViewById(R.id.dmw);
                textView2.setText(cas.MfV.Nhm);
                ao.a(textView2.getPaint(), 0.8f);
                this.qAx.setHeaderView(inflate2);
            }
            View inflate3 = View.inflate(getContext(), R.layout.v6, null);
            ((TextView) inflate3.findViewById(R.id.dmu)).setText(cas.dQx);
            this.qAx.setCustomView(inflate3);
            this.qAx.dGm();
            AppMethodBeat.o(213219);
        } else {
            Log.i("MicroMsg.CollectMainUI", "mBottomSheet != null && mBottomSheet.isShowing()");
            AppMethodBeat.o(213219);
        }
    }

    private void a(final adw adw) {
        AppMethodBeat.i(213220);
        if (adw == null) {
            Log.i("MicroMsg.CollectMainUI", " coverInfo == null");
            AppMethodBeat.o(213220);
            return;
        }
        Log.i("MicroMsg.CollectMainUI", "showCoverUI");
        this.qBA.setVisibility(0);
        this.qBA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(64129);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64129);
            }
        });
        ViewGroup.LayoutParams layoutParams = this.qBA.getLayoutParams();
        layoutParams.height = this.qAH.getHeight();
        this.qBA.setLayoutParams(layoutParams);
        this.qBB.setText(adw.dQx);
        this.qBC.setText(adw.Lpp.dQx);
        this.qBC.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(213206);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CollectMainUI.this.qAw = 3;
                CollectMainUI.a(CollectMainUI.this, adw.Lpp);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213206);
            }
        });
        this.qBD.setText(adw.Lpq.dQx);
        this.qBD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(213207);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CollectMainUI.this.qAw = 3;
                CollectMainUI.a(CollectMainUI.this, adw.Lpq);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213207);
            }
        });
        AppMethodBeat.o(213220);
    }

    private void a(final qs qsVar) {
        AppMethodBeat.i(213221);
        if (qsVar == null) {
            Log.i("MicroMsg.CollectMainUI", " bottomCell == null");
            AppMethodBeat.o(213221);
            return;
        }
        this.qAv = 3;
        this.oXS = new e((Context) getContext(), 1, true);
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setHeight(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 56));
        textView.setTextSize(12.0f);
        textView.setTextColor(getResources().getColor(R.color.FG_1));
        textView.setText(qsVar.KXy);
        this.oXS.V(textView, false);
        this.oXS.QOp = true;
        this.oXS.HLX = new o.f() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass17 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(213208);
                Iterator<dgp> it = qsVar.KXz.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    dgp next = it.next();
                    if (!(next == null || next.dQx == null)) {
                        mVar.d(i2, next.dQx);
                        i2++;
                    }
                }
                AppMethodBeat.o(213208);
            }
        };
        this.oXS.HLY = new o.g() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass18 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(213209);
                int itemId = menuItem.getItemId();
                CollectMainUI.this.qAw = 2;
                CollectMainUI.a(CollectMainUI.this, qsVar.KXz.get(itemId));
                AppMethodBeat.o(213209);
            }
        };
        this.oXS.dGm();
        AppMethodBeat.o(213221);
    }

    private void a(final dgo dgo, final adw adw) {
        boolean z;
        int i2;
        AppMethodBeat.i(213222);
        Log.i("MicroMsg.CollectMainUI", "doSaveQrCode");
        if (this.qAS == null || this.qAS.isRecycled()) {
            Log.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
            Toast.makeText(getContext(), getString(R.string.b7l), 1).show();
        } else {
            Bitmap a2 = com.tencent.mm.plugin.collect.model.b.a(this, this.qAT, z.aTY(), this.qBi, this.qBl, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 197.0f), this.qBH, false, this.qAW, 0.0f, true);
            if (a2 == null || a2.isRecycled()) {
                z = false;
            } else {
                if (this.qBb) {
                    h.INSTANCE.a(11343, 1, Integer.valueOf((int) Math.round(this.qAY * 100.0d)));
                } else {
                    h.INSTANCE.a(11343, 0);
                }
                if (!this.qAJ) {
                    this.qyA = (ScrollView) ((ViewStub) findViewById(R.id.b7e)).inflate();
                    cAp();
                    this.qAJ = true;
                    i2 = 250;
                } else {
                    i2 = 0;
                }
                this.qyA.setVisibility(4);
                ((ImageView) this.qyA.findViewById(R.id.b79)).setImageBitmap(this.qAS);
                TextView textView = (TextView) this.qyA.findViewById(R.id.b7a);
                TextView textView2 = (TextView) this.qyA.findViewById(R.id.b7b);
                final LinearLayout linearLayout = (LinearLayout) this.qyA.findViewById(R.id.b7v);
                LinearLayout linearLayout2 = (LinearLayout) this.qyA.findViewById(R.id.b78);
                TextView textView3 = (TextView) this.qyA.findViewById(R.id.b75);
                TextView textView4 = (TextView) this.qyA.findViewById(R.id.b76);
                TextView textView5 = (TextView) this.qyA.findViewById(R.id.b77);
                String hs = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(z.aTY()), 10);
                String trueName = getTrueName();
                if (!Util.isNullOrNil(trueName)) {
                    hs = hs + getString(R.string.b77, new Object[]{trueName});
                }
                if (this.qBi != 1) {
                    textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, hs, textView.getTextSize()));
                } else if (!Util.isNullOrNil(this.qBk)) {
                    textView.setText(this.qBk);
                    textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, hs, textView2.getTextSize()));
                    textView2.setVisibility(0);
                } else {
                    textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, hs, textView.getTextSize()));
                }
                if (this.qBb) {
                    if (!Util.isNullOrNil(this.qBa)) {
                        textView4.setText(this.qBa);
                        textView4.setVisibility(0);
                    } else {
                        textView4.setVisibility(8);
                    }
                    textView3.setText(cAo());
                    textView5.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.qAY));
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass5 */
                    final /* synthetic */ boolean qBP = true;

                    public final void run() {
                        AppMethodBeat.i(64117);
                        Log.d("MicroMsg.CollectMainUI", "height: %d, width: %d", Integer.valueOf(linearLayout.getHeight()), Integer.valueOf(linearLayout.getWidth()));
                        Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Bitmap.Config.ARGB_8888);
                        linearLayout.draw(new Canvas(createBitmap));
                        try {
                            String str = s.getSysCameraDirPath() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
                            BitmapUtil.saveBitmapToImage(createBitmap, 100, Bitmap.CompressFormat.PNG, str, false);
                            if (this.qBP) {
                                Log.i("MicroMsg.CollectMainUI", "doSaveQrCode success ");
                                CollectMainUI.a(CollectMainUI.this, CollectMainUI.this.getContext(), CollectMainUI.this.getContext().getResources().getString(R.string.b7i), dgo, adw);
                            }
                            s.refreshMediaScanner(str, CollectMainUI.this.getContext());
                        } catch (Exception e2) {
                            Log.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + e2.getMessage());
                        }
                        CollectMainUI.this.qyA.setVisibility(8);
                        AppMethodBeat.o(64117);
                    }
                }, (long) i2);
                z = true;
            }
            if (!z) {
                Log.w("MicroMsg.CollectMainUI", "save ftf pay qrcode fail");
                Toast.makeText(getContext(), getString(R.string.b7l), 1).show();
            }
        }
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(213222);
    }

    /* access modifiers changed from: protected */
    public void cAn() {
        AppMethodBeat.i(64168);
        if (com.tencent.mm.plugin.collect.model.f.qvI == null) {
            com.tencent.mm.plugin.collect.model.f.qvI = new com.tencent.mm.plugin.collect.model.f();
        }
        this.qBh = com.tencent.mm.plugin.collect.model.f.qvI;
        com.tencent.mm.plugin.collect.model.f fVar = this.qBh;
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(1588, fVar);
        com.tencent.mm.plugin.collect.model.f fVar2 = this.qBh;
        AnonymousClass7 r4 = new f.a() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.collect.model.f.a
            public final void J(String str, String str2, int i2) {
                AppMethodBeat.i(213198);
                Log.i("MicroMsg.CollectMainUI", "get cache: %s, %s, %s", str, str2, Integer.valueOf(i2));
                CollectMainUI.this.qAE.setVisibility(0);
                CollectMainUI.this.qAT = str;
                CollectMainUI.this.qAW = i2;
                CollectMainUI.this.mTrueName = str2;
                cor cAD = CollectMainUI.cAD();
                List<cor> cAE = CollectMainUI.cAE();
                CollectMainUI.a(CollectMainUI.this, cAD);
                CollectMainUI.this.de(cAE);
                if (CollectMainUI.this.efI == 1) {
                    CollectMainUI collectMainUI = CollectMainUI.this;
                    com.tencent.mm.kernel.g.aAi();
                    collectMainUI.qBi = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_COLLECT_BUSITYPE_INT_SYNC, (Object) -1)).intValue();
                    CollectMainUI collectMainUI2 = CollectMainUI.this;
                    com.tencent.mm.kernel.g.aAi();
                    collectMainUI2.qBl = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_COLLECT_BUSIURL_STRING_SYNC, "");
                }
                AppMethodBeat.o(213198);
            }

            @Override // com.tencent.mm.plugin.collect.model.f.a
            public final void a(boolean z, vv vvVar) {
                boolean z2;
                AppMethodBeat.i(213199);
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = vvVar == null ? BuildConfig.COMMAND : Integer.valueOf(vvVar.dDN);
                Log.i("MicroMsg.CollectMainUI", "get from cgi: %s resp.retcode: %s", objArr);
                if (z) {
                    if (vvVar == null || vvVar.dDN != 416) {
                        CollectMainUI.this.cAr();
                        CollectMainUI.this.qAE.setVisibility(0);
                        CollectMainUI.this.qBu = false;
                        CollectMainUI.this.qAT = vvVar.url;
                        CollectMainUI.this.qAW = ag.aqj(vvVar.LgF);
                        CollectMainUI.this.mTrueName = vvVar.HTZ;
                        CollectMainUI.this.qBi = vvVar.CpF;
                        CollectMainUI.this.qBk = vvVar.CpG;
                        CollectMainUI.this.qBl = vvVar.CpH;
                        CollectMainUI.this.qBj = vvVar.LgQ;
                        CollectMainUI.this.qBm = vvVar.jTx;
                        CollectMainUI.this.qBn = vvVar.jTy;
                        CollectMainUI.a(CollectMainUI.this, vvVar.LgN);
                        CollectMainUI.this.de(vvVar.LgM);
                        CollectMainUI.this.qBv = vvVar.LgR;
                        CollectMainUI.this.qBw = vvVar.LgS;
                        Log.d("MicroMsg.CollectMainUI", "flag: %s", Integer.valueOf(CollectMainUI.this.qBv));
                        CollectMainUI.this.qBx = vvVar.LgX;
                        CollectMainUI.this.qBy = vvVar.LgY;
                        CollectMainUI.this.qBz = vvVar.LgZ;
                        CollectMainUI.this.qBE = vvVar.Lha;
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_COLLECT_BUSITYPE_INT_SYNC, Integer.valueOf(CollectMainUI.this.qBi));
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_COLLECT_BUSIURL_STRING_SYNC, CollectMainUI.this.qBl);
                        CollectMainUI.this.refreshView();
                    } else {
                        Object[] objArr2 = new Object[1];
                        if (vvVar.LgT == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr2[0] = Boolean.valueOf(z2);
                        Log.d("MicroMsg.CollectMainUI", "realNameInfo:%s", objArr2);
                        CollectMainUI.this.qAE.setVisibility(4);
                        CollectMainUI.this.qBu = true;
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.CollectMainUI");
                        bundle.putString("realname_verify_process_jump_plugin", "collect");
                        CollectMainUI collectMainUI = CollectMainUI.this;
                        int i2 = vvVar.dDN;
                        dju dju = vvVar.LgT;
                        new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass7.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(213197);
                                Log.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
                                AppMethodBeat.o(213197);
                            }
                        };
                        com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(collectMainUI, i2, dju, bundle, 1010);
                        AppMethodBeat.o(213199);
                        return;
                    }
                }
                AppMethodBeat.o(213199);
            }
        };
        com.tencent.mm.kernel.g.aAi();
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_STRING_SYNC, "");
        com.tencent.mm.kernel.g.aAi();
        String str2 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_F2F_COLLECT_TRUE_NAME_STRING_SYNC, "");
        com.tencent.mm.kernel.g.aAi();
        int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_ERROR_LEVEL_INT_SYNC, (Object) -1)).intValue();
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
            str = t.fQI().fRr();
        }
        r4.J(str, str2, intValue);
        l lVar = new l();
        fVar2.oPn.put(lVar, r4);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(lVar, 0);
        AppMethodBeat.o(64168);
    }

    static /* synthetic */ void a(CollectMainUI collectMainUI, Context context, String str, final dgo dgo, final adw adw) {
        AppMethodBeat.i(213231);
        final Toast makeText = Toast.makeText(context, "", 0);
        View inflate = View.inflate(context, R.layout.pd, null);
        ((WeImageView) inflate.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_done);
        ((TextView) inflate.findViewById(R.id.ird)).setText(str);
        makeText.setGravity(17, 0, 0);
        makeText.setView(inflate);
        makeText.show();
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass19 */

            public final void run() {
                AppMethodBeat.i(213210);
                makeText.cancel();
                if (dgo != null) {
                    CollectMainUI.b(CollectMainUI.this, dgo);
                }
                if (adw != null) {
                    CollectMainUI.a(CollectMainUI.this, adw);
                }
                AppMethodBeat.o(213210);
            }
        }, 750);
        AppMethodBeat.o(213231);
    }

    static /* synthetic */ void a(CollectMainUI collectMainUI, final cor cor) {
        AppMethodBeat.i(213234);
        if (cor == null || Util.isNullOrNil(cor.dQx)) {
            Log.i("MicroMsg.CollectMainUI", "empty item return");
            AppMethodBeat.o(213234);
            return;
        }
        com.tencent.mm.kernel.g.aAi();
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_LEFT_ICON_URL_STRING_SYNC, "");
        if (!Util.isNullOrNil(str)) {
            collectMainUI.qBo.setUrl(str);
            collectMainUI.qBo.setVisibility(0);
        } else {
            collectMainUI.qBo.setVisibility(8);
        }
        collectMainUI.qBp.setText(cor.dQx);
        if (!Util.isNullOrNil(cor.MuS)) {
            collectMainUI.qBq.setText(cor.MuS);
            collectMainUI.qBq.setVisibility(0);
        } else {
            collectMainUI.qBq.setVisibility(4);
        }
        if (cor.MuT == 1) {
            collectMainUI.qBr.setVisibility(0);
        } else {
            collectMainUI.qBr.setVisibility(8);
        }
        if (cor.type == 1) {
            h.INSTANCE.a(14526, 1, 1, cor.dQx, "", "", "", 1);
            if (cor.MuT == 1) {
                h.INSTANCE.a(14526, 3, 1, cor.dQx, "", "", "", 1);
            }
        } else if (cor.type == 2) {
            h.INSTANCE.a(14526, 1, 2, cor.dQx, "", "", cor.url, 1);
            if (cor.MuT == 1) {
                h.INSTANCE.a(14526, 3, 2, cor.dQx, "", "", cor.url, 1);
            }
        } else if (cor.type == 3) {
            h.INSTANCE.a(14526, 1, 3, cor.dQx, cor.MuQ, cor.MuR, "", 1);
            if (cor.MuT == 1) {
                h.INSTANCE.a(14526, 3, 3, cor.dQx, cor.MuQ, cor.MuR, "", 1);
            }
        }
        collectMainUI.qBs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectMainUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(213200);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/collect/ui/CollectMainUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (cor.type == 1) {
                    if (cor.url.equals("wxpay://f2f/f2fdetail")) {
                        Intent intent = new Intent(CollectMainUI.this.getContext(), CollectBillUI.class);
                        intent.putExtra("key_from_scene", 0);
                        CollectMainUI.this.startActivityForResult(intent, 4097);
                        h.INSTANCE.a(13944, 1);
                        h.INSTANCE.a(14526, 1, 1, cor.dQx, "", "", "", 2);
                        if (cor.MuT == 1) {
                            h.INSTANCE.a(14526, 3, 1, cor.dQx, "", "", "", 2);
                        }
                    }
                } else if (cor.type == 2) {
                    if (Util.isNullOrNil(cor.url)) {
                        Log.w("MicroMsg.CollectMainUI", "empty bottom h5 url");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213200);
                        return;
                    }
                    com.tencent.mm.wallet_core.ui.f.p(CollectMainUI.this.getContext(), cor.url, false);
                    h.INSTANCE.a(14526, 1, 2, cor.dQx, "", "", cor.url, 2);
                    if (cor.MuT == 1) {
                        h.INSTANCE.a(14526, 3, 2, cor.dQx, "", "", cor.url, 2);
                    }
                } else if (cor.type == 3) {
                    wq wqVar = new wq();
                    wqVar.ecI.userName = cor.MuQ;
                    wqVar.ecI.ecK = Util.nullAs(cor.MuR, "");
                    wqVar.ecI.scene = 1072;
                    wqVar.ecI.ecL = 0;
                    EventCenter.instance.publish(wqVar);
                    h.INSTANCE.a(14526, 1, 3, cor.dQx, cor.MuQ, cor.MuR, "", 2);
                    if (cor.MuT == 1) {
                        h.INSTANCE.a(14526, 3, 3, cor.dQx, cor.MuQ, cor.MuR, "", 2);
                    }
                } else {
                    Intent intent2 = new Intent(CollectMainUI.this.getContext(), CollectBillUI.class);
                    intent2.putExtra("key_from_scene", 0);
                    CollectMainUI.this.startActivityForResult(intent2, 4097);
                    h.INSTANCE.a(13944, 1);
                }
                CollectMainUI.this.qBq.setVisibility(4);
                CollectMainUI.this.qBr.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213200);
            }
        });
        AppMethodBeat.o(213234);
    }

    static /* synthetic */ void B(CollectMainUI collectMainUI) {
        AppMethodBeat.i(213235);
        collectMainUI.qAb &= -32769;
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(147457, Long.valueOf(collectMainUI.qAb));
        cqb cqb = new cqb();
        cqb.Cyb = 2;
        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(209, cqb));
        com.tencent.mm.plugin.collect.a.a.czp().czt();
        AppMethodBeat.o(213235);
    }

    static /* synthetic */ void C(CollectMainUI collectMainUI) {
        AppMethodBeat.i(213236);
        collectMainUI.qAb |= 32768;
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(147457, Long.valueOf(collectMainUI.qAb));
        cqb cqb = new cqb();
        cqb.Cyb = 1;
        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(209, cqb));
        com.tencent.mm.plugin.collect.a.a.czp().czs();
        AppMethodBeat.o(213236);
    }

    static /* synthetic */ void a(CollectMainUI collectMainUI, dgp dgp) {
        AppMethodBeat.i(213237);
        if (dgp == null) {
            Log.i("MicroMsg.CollectMainUI", " buttonInfo == null");
            AppMethodBeat.o(213237);
            return;
        }
        Log.i("MicroMsg.CollectMainUI", " ClickButtonAction：%s", Integer.valueOf(dgp.type));
        switch (dgp.type) {
            case 1:
                if (collectMainUI.qBA.isShown()) {
                    collectMainUI.qBA.setVisibility(8);
                }
                if (collectMainUI.qAx != null) {
                    collectMainUI.qAx.bMo();
                    break;
                }
                break;
            case 2:
                collectMainUI.a((dgo) null, (adw) null);
                collectMainUI.Fe(collectMainUI.qAv);
                break;
            case 3:
                com.tencent.mm.wallet_core.ui.f.bn(collectMainUI.getContext(), dgp.pTL);
                break;
            case 4:
                String str = dgp.MLj.username;
                String str2 = dgp.MLj.nHf;
                if (!Util.isNullOrNil(str)) {
                    wq wqVar = new wq();
                    wqVar.ecI.userName = str;
                    wqVar.ecI.ecK = Util.nullAs(str2, "");
                    wqVar.ecI.scene = 1072;
                    wqVar.ecI.ecL = 0;
                    EventCenter.instance.publish(wqVar);
                    break;
                }
                break;
            case 5:
                collectMainUI.a(dgp.MLh);
                break;
            case 6:
                collectMainUI.a((dgo) null, dgp.MLh);
                collectMainUI.Fe(collectMainUI.qAv);
                break;
            default:
                Log.i("MicroMsg.CollectMainUI", "unknow buttonInfo.type");
                break;
        }
        switch (collectMainUI.qAw) {
            case 1:
            case 2:
                h.INSTANCE.a(20032, "wxface2face", "ClickHalfDialogButton", "", "", "", "", 4, 0, Integer.valueOf(dgp.type), collectMainUI.cAA(), Integer.valueOf(collectMainUI.cAy()), collectMainUI.cAz());
                AppMethodBeat.o(213237);
                return;
            case 3:
                h.INSTANCE.a(20032, "wxface2face", "ClickCoverPageButton", "", "", "", "", 5, 0, Integer.valueOf(dgp.type), collectMainUI.cAA(), Integer.valueOf(collectMainUI.cAy()), collectMainUI.cAz());
                AppMethodBeat.o(213237);
                return;
            default:
                Log.i("MicroMsg.CollectMainUI", "unknow clickButtonSource");
                AppMethodBeat.o(213237);
                return;
        }
    }
}
