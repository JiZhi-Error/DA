package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.appbrand.game.e.b.c;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.protocal.protobuf.dmg;
import com.tencent.mm.protocal.protobuf.dmh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI extends MMActivity implements View.OnClickListener, PatternLockView.a, com.tencent.mm.plugin.walletlock.ui.a {
    private int IvD = 0;
    private int IvE = 0;
    private int IvF = 0;
    private a[] IvG = null;
    private Animation IvH = null;
    private List<f> IvI = null;
    private List<f> IvJ = null;
    private boolean IvK = false;
    private int IvL = 0;
    private q IvM = null;
    private q IvN = null;
    private String IvO = null;
    private ViewFlipper IvP = null;
    private Dialog IvQ = null;
    private boolean IvR = true;
    private boolean IvS = false;
    private String IvT;
    private int Ivu = -1;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private int mStatus;
    private String mToken = null;

    /* access modifiers changed from: package-private */
    public interface a {
        void onDone();
    }

    public GestureGuardLogicUI() {
        AppMethodBeat.i(129819);
        AppMethodBeat.o(129819);
    }

    static /* synthetic */ void a(GestureGuardLogicUI gestureGuardLogicUI, int i2, int i3, String str) {
        AppMethodBeat.i(129846);
        gestureGuardLogicUI.M(i2, i3, str);
        AppMethodBeat.o(129846);
    }

    static /* synthetic */ boolean a(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(129845);
        boolean fVf = gestureGuardLogicUI.fVf();
        AppMethodBeat.o(129845);
        return fVf;
    }

    static /* synthetic */ void e(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(129847);
        gestureGuardLogicUI.fVh();
        AppMethodBeat.o(129847);
    }

    static /* synthetic */ void g(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(129848);
        gestureGuardLogicUI.bp(1, true);
        AppMethodBeat.o(129848);
    }

    static /* synthetic */ void h(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(129849);
        gestureGuardLogicUI.fVg();
        AppMethodBeat.o(129849);
    }

    static /* synthetic */ int k(GestureGuardLogicUI gestureGuardLogicUI) {
        int i2 = gestureGuardLogicUI.IvL + 1;
        gestureGuardLogicUI.IvL = i2;
        return i2;
    }

    static /* synthetic */ void o(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(129850);
        gestureGuardLogicUI.biW();
        AppMethodBeat.o(129850);
    }

    static /* synthetic */ void t(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.i(129852);
        gestureGuardLogicUI.fVi();
        AppMethodBeat.o(129852);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(129820);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.eq, R.anim.en);
        Intent intent = getIntent();
        if (!MMApplicationContext.getPackageName().equals(intent.getPackage()) || Util.isNullOrNil(intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION)) || Util.isNullOrNil(intent.getStringExtra("next_action"))) {
            Log.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
            finish();
            AppMethodBeat.o(129820);
            return;
        }
        this.IvP = new ViewFlipper(this);
        this.IvG = new a[]{new a(this), new a(this), new a(this)};
        a[] aVarArr = this.IvG;
        for (a aVar : aVarArr) {
            this.IvP.addView(aVar.mView);
            aVar.Iwc.setOnPatternListener(this);
            aVar.Iwd.setOnClickListener(this);
        }
        setContentView(this.IvP);
        this.mToken = getIntent().getStringExtra("token");
        this.IvO = getIntent().getStringExtra("type");
        this.IvT = getIntent().getStringExtra("verify_title");
        this.Ivu = getIntent().getIntExtra("scene", -1);
        if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            h.fVy();
        }
        initView();
        AppMethodBeat.o(129820);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r7.IvL == -1) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r7 = this;
            r6 = 129821(0x1fb1d, float:1.81918E-40)
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            super.onResume()
            int r0 = r7.mStatus
            if (r0 != 0) goto L_0x003f
            com.tencent.mm.plugin.walletlock.gesture.a.g r0 = com.tencent.mm.plugin.walletlock.gesture.a.d.fUZ()
            long r2 = r0.IvB
            r4 = -1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0046
            com.tencent.mm.plugin.walletlock.gesture.a.e.a(r0)
            long r2 = r0.IvC
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r4 = 600(0x258, double:2.964E-321)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0043
            long r2 = r0.IvB
            long r4 = r0.IvC
            com.tencent.mm.plugin.walletlock.gesture.a.d.aC(r2, r4)
            r0 = 1
        L_0x0030:
            if (r0 == 0) goto L_0x003d
            int r0 = com.tencent.mm.plugin.walletlock.gesture.a.d.fVd()
            r7.IvL = r0
            int r0 = r7.IvL
            r2 = -1
            if (r0 != r2) goto L_0x003f
        L_0x003d:
            r7.IvL = r1
        L_0x003f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0043:
            com.tencent.mm.plugin.walletlock.gesture.a.d.fVa()
        L_0x0046:
            r0 = r1
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.onResume():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(129822);
        super.onDestroy();
        if (this.IvM != null) {
            g.azz().a(this.IvM);
            this.IvM = null;
        }
        if (this.IvN != null) {
            g.azz().a(this.IvN);
            this.IvN = null;
        }
        if (this.IvQ != null && this.IvQ.isShowing()) {
            this.IvQ.dismiss();
        }
        if (this.IvP != null) {
            this.IvP.removeAllViews();
            this.IvP = null;
        }
        for (int i2 = 0; i2 < this.IvG.length; i2++) {
            a aVar = this.IvG[i2];
            aVar.Iwc.setOnClickListener(null);
            aVar.Iwd.setOnClickListener(null);
            aVar.mView = null;
            aVar.Iwa = null;
            aVar.Iwb = null;
            aVar.Iwc = null;
            aVar.Iwd = null;
            this.IvG[i2] = null;
        }
        this.IvG = null;
        AppMethodBeat.o(129822);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(129823);
        hideVKB();
        setActionbarColor(getResources().getColor(R.color.afz));
        setMMSubTitle(R.string.j1m);
        this.IvH = AnimationUtils.loadAnimation(this, R.anim.e9);
        this.IvD = getResources().getColor(R.color.a2x);
        this.IvE = getResources().getColor(R.color.a5e);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        intent.getStringExtra("next_action");
        if ("action.switch_on_pattern".equals(stringExtra)) {
            this.mStatus = 16;
            bp(1, false);
        } else if ("action.verify_pattern".equals(stringExtra)) {
            if (b.fUW()) {
                this.IvK = true;
                this.mStatus = 20;
            } else {
                this.IvK = false;
                this.mStatus = 0;
            }
            bp(0, false);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(129791);
                if (GestureGuardLogicUI.a(GestureGuardLogicUI.this)) {
                    AppMethodBeat.o(129791);
                } else {
                    GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
                    AppMethodBeat.o(129791);
                }
                return true;
            }
        });
        Log.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", Integer.valueOf(this.mStatus)));
        fVg();
        AppMethodBeat.o(129823);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(129824);
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (intent == null) {
                Log.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
                AppMethodBeat.o(129824);
                return;
            }
            int intExtra = intent.getIntExtra("key_err_code", 0);
            if (intExtra == 0) {
                this.mToken = intent.getStringExtra("key_token");
                this.IvO = intent.getStringExtra("key_type");
                String stringExtra = getIntent().getStringExtra("next_action");
                if ("next_action.goto_protected_page".equals(stringExtra) || "next_action.modify_pattern".equals(stringExtra)) {
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        this.IvS = true;
                    }
                    this.IvR = false;
                    setBackBtn(null);
                    setBackBtnVisible(false);
                    this.mStatus = 16;
                    bp(1, false);
                } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                    String str = this.mToken;
                    final AnonymousClass12 r0 = new aa.a() {
                        /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass12 */

                        @Override // com.tencent.mm.ak.aa.a
                        public final int a(int i2, int i3, String str, d dVar, q qVar) {
                            AppMethodBeat.i(129802);
                            if (i3 == 0) {
                                com.tencent.mm.plugin.walletlock.gesture.a.d.fVe();
                                com.tencent.mm.plugin.walletlock.gesture.a.d.fUY();
                                com.tencent.mm.plugin.walletlock.gesture.a.d.fVa();
                                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.dv2), 0).show();
                            } else {
                                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.duk), 0).show();
                            }
                            GestureGuardLogicUI.this.mToken = null;
                            GestureGuardLogicUI.this.IvO = null;
                            GestureGuardLogicUI.this.finish();
                            AppMethodBeat.o(129802);
                            return 0;
                        }
                    };
                    d(new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass13 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(129803);
                            GestureGuardLogicUI.this.IvG[GestureGuardLogicUI.this.IvF].Iwc.fVp();
                            if (GestureGuardLogicUI.this.IvM != null && !GestureGuardLogicUI.this.IvM.isCanceled()) {
                                g.azz().a(GestureGuardLogicUI.this.IvM);
                            }
                            AppMethodBeat.o(129803);
                        }
                    });
                    if (str == null) {
                        biW();
                        r0.a(3, -6, getString(R.string.dum), null, null);
                    } else {
                        d.a aVar = new d.a();
                        aVar.iLN = new dmg();
                        aVar.iLO = new dmh();
                        aVar.funcId = c.CTRL_INDEX;
                        aVar.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
                        d aXF = aVar.aXF();
                        dmg dmg = (dmg) aXF.iLK.iLR;
                        dmg.MPO = new SKBuiltinBuffer_t().setBuffer(str.getBytes());
                        dmg.EX = 3;
                        aa.a(aXF, new aa.a() {
                            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass14 */

                            @Override // com.tencent.mm.ak.aa.a
                            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                                AppMethodBeat.i(129804);
                                Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str));
                                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                                if (i2 == 0 && i3 == 0) {
                                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((dmh) dVar.iLL.iLR).MAJ);
                                    com.tencent.mm.plugin.walletlock.c.g gVar = com.tencent.mm.plugin.walletlock.c.g.instance;
                                    com.tencent.mm.plugin.walletlock.c.g.yD(false);
                                    GestureGuardLogicUI.fVm();
                                }
                                i.INSTANCE.fVB();
                                if (r0 != null) {
                                    int a2 = r0.a(i2, i3, str, dVar, qVar);
                                    AppMethodBeat.o(129804);
                                    return a2;
                                }
                                AppMethodBeat.o(129804);
                                return 0;
                            }
                        }, false);
                    }
                } else {
                    this.mStatus = 1;
                }
                fVg();
                AppMethodBeat.o(129824);
                return;
            } else if (intExtra == -1) {
                Toast.makeText(this, getString(R.string.duk), 0).show();
            }
        }
        AppMethodBeat.o(129824);
    }

    public void onClick(View view) {
        AppMethodBeat.i(129825);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.ixf) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("key_wallet_lock_type", 1);
            com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, 1001);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(129825);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(129826);
        if (i2 != 4) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(129826);
            return onKeyDown;
        } else if (fVf()) {
            AppMethodBeat.o(129826);
            return false;
        } else {
            M(0, 4, "user cancel when setting gesture");
            AppMethodBeat.o(129826);
            return false;
        }
    }

    private void M(int i2, int i3, String str) {
        AppMethodBeat.i(129827);
        Log.i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i3);
        intent.putExtra("key_err_msg", str);
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(129827);
    }

    private boolean fVf() {
        AppMethodBeat.i(129828);
        if (this.mStatus == 20 || this.mStatus == 0 || this.mStatus == 2 || this.mStatus == 1) {
            fVi();
            AppMethodBeat.o(129828);
            return false;
        }
        if (this.IvR) {
            fVl();
        } else {
            fVk();
        }
        AppMethodBeat.o(129828);
        return true;
    }

    private void fVg() {
        AppMethodBeat.i(129829);
        while (this.IvG != null) {
            final a aVar = this.IvG[this.IvF];
            switch (this.mStatus) {
                case 0:
                    setMMTitle("");
                    this.IvK = false;
                    aVar.Iwc.setEnableInput(true);
                    aVar.Iwc.setOnPatternListener(this);
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        aVar.Iwa.setText(getString(R.string.duw));
                    } else if (!Util.isNullOrNil(this.IvT)) {
                        aVar.Iwa.setText(this.IvT);
                    } else {
                        aVar.Iwa.setText(getString(R.string.dux));
                    }
                    aVar.Iwa.setTextColor(this.IvD);
                    if (aVar.Iwd.getVisibility() != 0) {
                        aVar.Iwd.setVisibility(0);
                        AppMethodBeat.o(129829);
                        return;
                    }
                    AppMethodBeat.o(129829);
                    return;
                case 1:
                    String stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        aVar.Iwc.fVp();
                        bp(1, true);
                        this.mStatus = 16;
                    } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                        a(this.IvJ, new aa.a() {
                            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass26 */

                            @Override // com.tencent.mm.ak.aa.a
                            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                                AppMethodBeat.i(129817);
                                if (i3 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.dv2), 0).show();
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.duk), 0).show();
                                }
                                GestureGuardLogicUI.this.IvJ = null;
                                GestureGuardLogicUI.this.finish();
                                AppMethodBeat.o(129817);
                                return 0;
                            }
                        });
                        AppMethodBeat.o(129829);
                        return;
                    } else {
                        if ("next_action.goto_protected_page".equals(stringExtra)) {
                            com.tencent.mm.plugin.walletlock.gesture.a.d.LU(SystemClock.elapsedRealtime());
                            fVh();
                            h.aJ(this.Ivu, 1, 0);
                            AppMethodBeat.o(129829);
                            return;
                        }
                        AppMethodBeat.o(129829);
                        return;
                    }
                case 2:
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    com.tencent.mm.plugin.walletlock.gesture.a.d.aC(elapsedRealtime, 0);
                    com.tencent.mm.plugin.walletlock.gesture.a.d.afb(this.IvL);
                    com.tencent.mm.plugin.walletlock.gesture.a.d.fUM();
                    if (this.IvL == 5) {
                        this.IvK = true;
                        com.tencent.mm.plugin.walletlock.gesture.a.d.aB(elapsedRealtime, 0);
                        aVar.Iwc.fVp();
                        aVar.Iwc.setEnableInput(false);
                        this.mStatus = 20;
                        fVg();
                        fVj();
                    } else {
                        aVar.Iwc.setEnableInput(false);
                        aVar.Iwc.setDisplayMode(PatternLockView.b.Wrong);
                        a(String.format(getResources().getString(R.string.dun), Integer.valueOf(5 - this.IvL)), new a() {
                            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass27 */

                            @Override // com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a
                            public final void onDone() {
                                AppMethodBeat.i(129818);
                                GestureGuardLogicUI.this.mStatus = 0;
                                aVar.Iwc.fVp();
                                aVar.Iwc.setEnableInput(true);
                                AppMethodBeat.o(129818);
                            }
                        });
                    }
                    String stringExtra2 = getIntent().getStringExtra("next_action");
                    Log.i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", stringExtra2);
                    if ("next_action.goto_protected_page".equals(stringExtra2)) {
                        if (this.IvL == 5) {
                            h.aJ(this.Ivu, 1, 2);
                            AppMethodBeat.o(129829);
                            return;
                        }
                        h.aJ(this.Ivu, 1, 1);
                    }
                    AppMethodBeat.o(129829);
                    return;
                case 16:
                    String stringExtra3 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra3)) {
                        setMMTitle(getString(R.string.duz));
                        kz kzVar = new kz();
                        kzVar.eEH = 5;
                        kzVar.eXI = 1;
                        kzVar.bfK();
                    } else if ("next_action.switch_on_pattern".equals(stringExtra3)) {
                        setMMTitle(getString(R.string.dv0));
                        kz kzVar2 = new kz();
                        kzVar2.eEH = 4;
                        kzVar2.eXI = 1;
                        kzVar2.bfK();
                    } else {
                        setMMTitle(getString(R.string.duz));
                        kz kzVar3 = new kz();
                        kzVar3.eEH = 5;
                        kzVar3.eXI = 1;
                        kzVar3.bfK();
                    }
                    this.IvK = false;
                    aVar.Iwc.setEnableInput(true);
                    aVar.Iwc.setOnPatternListener(this);
                    aVar.Iwa.setText(getString(R.string.duv));
                    aVar.Iwa.setTextColor(getResources().getColor(R.color.a2x));
                    if (aVar.Iwd.getVisibility() != 8) {
                        aVar.Iwd.setVisibility(8);
                        AppMethodBeat.o(129829);
                        return;
                    }
                    AppMethodBeat.o(129829);
                    return;
                case 17:
                    aVar.Iwa.setText(getResources().getString(R.string.dut));
                    aVar.Iwa.setTextColor(this.IvD);
                    aVar.Iwc.fVp();
                    aVar.Iwc.setEnableInput(true);
                    if (aVar.Iwd.getVisibility() != 8) {
                        aVar.Iwd.setVisibility(8);
                        AppMethodBeat.o(129829);
                        return;
                    }
                    AppMethodBeat.o(129829);
                    return;
                case 18:
                    String stringExtra4 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra4)) {
                        if (this.IvS) {
                            this.IvS = false;
                            a(this.mToken, this.IvI, new aa.a() {
                                /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass21 */

                                @Override // com.tencent.mm.ak.aa.a
                                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                                    AppMethodBeat.i(129811);
                                    if (i3 == 0) {
                                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.dv4), 0).show();
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11474, new Object[0]);
                                    } else {
                                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.duk), 0).show();
                                    }
                                    GestureGuardLogicUI.this.mToken = null;
                                    GestureGuardLogicUI.this.IvI = null;
                                    GestureGuardLogicUI.this.finish();
                                    AppMethodBeat.o(129811);
                                    return 0;
                                }
                            });
                            AppMethodBeat.o(129829);
                            return;
                        }
                        a(this.IvJ, this.IvI, new aa.a() {
                            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass22 */

                            @Override // com.tencent.mm.ak.aa.a
                            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                                AppMethodBeat.i(129812);
                                if (i3 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.dv4), 0).show();
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.duk), 0).show();
                                }
                                GestureGuardLogicUI.this.IvJ = null;
                                GestureGuardLogicUI.this.IvI = null;
                                GestureGuardLogicUI.this.finish();
                                AppMethodBeat.o(129812);
                                return 0;
                            }
                        });
                        AppMethodBeat.o(129829);
                        return;
                    } else if ("next_action.switch_on_pattern".equals(stringExtra4)) {
                        a(this.mToken, this.IvI, new aa.a() {
                            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass23 */

                            @Override // com.tencent.mm.ak.aa.a
                            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                                AppMethodBeat.i(129813);
                                GestureGuardLogicUI.this.mToken = null;
                                GestureGuardLogicUI.this.IvI = null;
                                if (i3 == 0) {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.dv3), 0).show();
                                    GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, 0, "open gesture ok");
                                } else {
                                    Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.duk), 0).show();
                                    GestureGuardLogicUI.a(GestureGuardLogicUI.this, -1, -1, "open gesture failed");
                                }
                                AppMethodBeat.o(129813);
                                return 0;
                            }
                        });
                        AppMethodBeat.o(129829);
                        return;
                    } else {
                        if ("next_action.goto_protected_page".equals(stringExtra4)) {
                            a(this.mToken, this.IvI, new aa.a() {
                                /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass24 */

                                @Override // com.tencent.mm.ak.aa.a
                                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                                    AppMethodBeat.i(129814);
                                    if (i3 == 0) {
                                        com.tencent.mm.plugin.walletlock.gesture.a.d.LU(SystemClock.elapsedRealtime());
                                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.dv4), 0).show();
                                        GestureGuardLogicUI.e(GestureGuardLogicUI.this);
                                    } else {
                                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.duk), 0).show();
                                    }
                                    GestureGuardLogicUI.this.mToken = null;
                                    GestureGuardLogicUI.this.IvI = null;
                                    AppMethodBeat.o(129814);
                                    return 0;
                                }
                            });
                            AppMethodBeat.o(129829);
                            return;
                        }
                        AppMethodBeat.o(129829);
                        return;
                    }
                case 19:
                    aVar.Iwc.setEnableInput(false);
                    aVar.Iwc.setDisplayMode(PatternLockView.b.Wrong);
                    a(getResources().getString(R.string.duu), new a() {
                        /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass25 */

                        @Override // com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a
                        public final void onDone() {
                            AppMethodBeat.i(129816);
                            GestureGuardLogicUI.this.mHandler.postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass25.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(129815);
                                    GestureGuardLogicUI.this.mHandler.removeCallbacks(this);
                                    aVar.Iwc.fVp();
                                    GestureGuardLogicUI.this.mStatus = 16;
                                    GestureGuardLogicUI.g(GestureGuardLogicUI.this);
                                    GestureGuardLogicUI.h(GestureGuardLogicUI.this);
                                    AppMethodBeat.o(129815);
                                }
                            }, 500);
                            AppMethodBeat.o(129816);
                        }
                    });
                    AppMethodBeat.o(129829);
                    return;
                case 20:
                    setMMTitle(getString(R.string.duy));
                    setMMTitle(getString(R.string.duz));
                    if (this.Ivu == 1) {
                        kz kzVar4 = new kz();
                        kzVar4.eEH = 8;
                        kzVar4.eXI = 1;
                        kzVar4.bfK();
                    } else if (this.Ivu == 2) {
                        kz kzVar5 = new kz();
                        kzVar5.eEH = 10;
                        kzVar5.eXI = 1;
                        kzVar5.bfK();
                    }
                    this.IvK = true;
                    aVar.Iwc.setEnableInput(false);
                    aVar.Iwc.setOnPatternListener(null);
                    aVar.Iwa.setText(String.format(getString(R.string.dur), Long.valueOf((long) Math.ceil(((double) (600 - (com.tencent.mm.plugin.walletlock.gesture.a.d.fUX().IvC / 1000))) / 60.0d))));
                    aVar.Iwa.setTextColor(getResources().getColor(R.color.a5e));
                    AppMethodBeat.o(129829);
                    return;
                default:
                    AppMethodBeat.o(129829);
                    return;
            }
        }
        AppMethodBeat.o(129829);
    }

    @Override // com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a
    public final void a(final PatternLockView patternLockView, final List<f> list) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(129830);
        if (this.mStatus == 16) {
            if (list.size() < 4) {
                patternLockView.setEnableInput(false);
                patternLockView.setDisplayMode(PatternLockView.b.Wrong);
                a(String.format(getString(R.string.duo), 4), new a() {
                    /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a
                    public final void onDone() {
                        AppMethodBeat.i(129792);
                        patternLockView.fVp();
                        patternLockView.setEnableInput(true);
                        AppMethodBeat.o(129792);
                    }
                });
                AppMethodBeat.o(129830);
                return;
            }
            this.IvI = list;
            patternLockView.fVp();
            this.mStatus = 17;
            bp(2, true);
        } else if (this.mStatus == 0) {
            final AnonymousClass3 r0 = new aa.a() {
                /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass3 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, d dVar, q qVar) {
                    AppMethodBeat.i(129793);
                    if (i3 == 0) {
                        GestureGuardLogicUI.this.IvK = false;
                        GestureGuardLogicUI.this.IvL = 0;
                        com.tencent.mm.plugin.walletlock.gesture.a.d.fVe();
                        com.tencent.mm.plugin.walletlock.gesture.a.d.fUY();
                        com.tencent.mm.plugin.walletlock.gesture.a.d.fVa();
                        GestureGuardLogicUI.this.IvJ = list;
                        GestureGuardLogicUI.this.mStatus = 1;
                        GestureGuardLogicUI.h(GestureGuardLogicUI.this);
                    } else if (i3 == -3) {
                        GestureGuardLogicUI.k(GestureGuardLogicUI.this);
                        GestureGuardLogicUI.this.mStatus = 2;
                        GestureGuardLogicUI.h(GestureGuardLogicUI.this);
                    } else {
                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(R.string.dul), 0).show();
                    }
                    AppMethodBeat.o(129793);
                    return 0;
                }
            };
            czl fVc = com.tencent.mm.plugin.walletlock.gesture.a.d.fVc();
            czk fVb = com.tencent.mm.plugin.walletlock.gesture.a.d.fVb();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11453, new Object[0]);
            d(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(129796);
                    GestureGuardLogicUI.this.IvG[GestureGuardLogicUI.this.IvF].Iwc.fVp();
                    if (GestureGuardLogicUI.this.IvN != null && !GestureGuardLogicUI.this.IvN.isCanceled()) {
                        g.azz().a(GestureGuardLogicUI.this.IvN);
                    }
                    AppMethodBeat.o(129796);
                }
            });
            boolean b2 = e.b(fVc);
            boolean b3 = e.b(fVb);
            if (b3) {
                z = b2 ? fVb.version < fVc.MEJ : false;
            } else {
                z = true;
            }
            Log.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", Boolean.valueOf(b2), Boolean.valueOf(b3), Boolean.valueOf(z)));
            if (z) {
                d.a aVar = new d.a();
                aVar.iLN = new cvg();
                aVar.iLO = new cvh();
                aVar.funcId = 689;
                aVar.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                d aXF = aVar.aXF();
                cvg cvg = (cvg) aXF.iLK.iLR;
                cvg.EX = 2;
                cvg.MAH = new SKBuiltinBuffer_t().setBuffer(e.m32if(list));
                aa.a(aXF, new aa.a() {
                    /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass7 */

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, d dVar, q qVar) {
                        AppMethodBeat.i(129797);
                        Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str));
                        GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                        if (i2 == 0 && i3 == 0) {
                            com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cvh) dVar.iLL.iLR).MAJ);
                            if (GestureGuardLogicUI.this.mStatus != 0) {
                                String stringExtra = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                                if ("next_action.modify_pattern".equals(stringExtra)) {
                                    kz kzVar = new kz();
                                    kzVar.eEH = 5;
                                    kzVar.eXI = 2;
                                    kzVar.bfK();
                                } else if ("next_action.switch_on_pattern".equals(stringExtra)) {
                                    kz kzVar2 = new kz();
                                    kzVar2.eEH = 4;
                                    kzVar2.eXI = 2;
                                    kzVar2.bfK();
                                } else {
                                    kz kzVar3 = new kz();
                                    kzVar3.eEH = 5;
                                    kzVar3.eXI = 2;
                                    kzVar3.bfK();
                                }
                            } else if (GestureGuardLogicUI.this.Ivu == 1) {
                                kz kzVar4 = new kz();
                                kzVar4.eEH = 8;
                                kzVar4.eXI = 2;
                                kzVar4.bfK();
                            } else if (GestureGuardLogicUI.this.Ivu == 2) {
                                kz kzVar5 = new kz();
                                kzVar5.eEH = 10;
                                kzVar5.eXI = 2;
                                kzVar5.bfK();
                            }
                        }
                        if (r0 != null) {
                            int a2 = r0.a(i2, i3, str, dVar, qVar);
                            AppMethodBeat.o(129797);
                            return a2;
                        }
                        AppMethodBeat.o(129797);
                        return 0;
                    }
                }, false);
                AppMethodBeat.o(129830);
                return;
            }
            biW();
            czk fVb2 = com.tencent.mm.plugin.walletlock.gesture.a.d.fVb();
            if (fVb2 != null) {
                StringBuilder sb = new StringBuilder();
                g.aAf();
                sb.append(new p(com.tencent.mm.kernel.a.getUin()).longValue());
                sb.append('_');
                sb.append(new String(e.m32if(list)));
                z2 = new String(fVb2.MEG.getBufferToBytes()).equals(com.tencent.mm.b.g.getMessageDigest(sb.toString().getBytes()));
            }
            if (z2) {
                r0.a(3, 0, null, null, null);
                AppMethodBeat.o(129830);
                return;
            }
            r0.a(3, -3, null, null, null);
            AppMethodBeat.o(129830);
            return;
        } else {
            if (this.mStatus == 17) {
                if (this.IvI.equals(list)) {
                    patternLockView.fVp();
                    this.IvK = false;
                    this.IvL = 0;
                    com.tencent.mm.plugin.walletlock.gesture.a.d.fVe();
                    com.tencent.mm.plugin.walletlock.gesture.a.d.fUY();
                    com.tencent.mm.plugin.walletlock.gesture.a.d.fVa();
                    com.tencent.mm.plugin.walletlock.gesture.a.d.fUM();
                    this.mStatus = 18;
                } else {
                    this.mStatus = 19;
                }
            }
            AppMethodBeat.o(129830);
        }
        fVg();
        AppMethodBeat.o(129830);
    }

    private void a(String str, List<f> list, final aa.a aVar) {
        AppMethodBeat.i(129831);
        d(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(129794);
                GestureGuardLogicUI.this.IvG[GestureGuardLogicUI.this.IvF].Iwc.fVp();
                if (GestureGuardLogicUI.this.IvM != null && !GestureGuardLogicUI.this.IvM.isCanceled()) {
                    g.azz().a(GestureGuardLogicUI.this.IvM);
                }
                AppMethodBeat.o(129794);
            }
        });
        if (str == null) {
            biW();
            aVar.a(3, -6, getString(R.string.dum), null, null);
            AppMethodBeat.o(129831);
            return;
        }
        d.a aVar2 = new d.a();
        aVar2.iLN = new dmg();
        aVar2.iLO = new dmh();
        aVar2.funcId = c.CTRL_INDEX;
        aVar2.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
        d aXF = aVar2.aXF();
        dmg dmg = (dmg) aXF.iLK.iLR;
        dmg.MPO = new SKBuiltinBuffer_t().setBuffer(str.getBytes());
        dmg.MPP = new SKBuiltinBuffer_t().setBuffer(e.m32if(list));
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass5 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(129795);
                Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((dmh) dVar.iLL.iLR).MAJ);
                    GestureGuardLogicUI.fVm();
                    ((com.tencent.mm.plugin.walletlock.a.b) g.af(com.tencent.mm.plugin.walletlock.a.b.class)).aeZ(1);
                }
                i.INSTANCE.fVB();
                if (aVar != null) {
                    int a2 = aVar.a(i2, i3, str, dVar, qVar);
                    AppMethodBeat.o(129795);
                    return a2;
                }
                AppMethodBeat.o(129795);
                return 0;
            }
        }, false);
        AppMethodBeat.o(129831);
    }

    private void a(List<f> list, List<f> list2, final aa.a aVar) {
        AppMethodBeat.i(129832);
        d.a aVar2 = new d.a();
        d(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(129798);
                GestureGuardLogicUI.this.IvG[GestureGuardLogicUI.this.IvF].Iwc.fVp();
                if (GestureGuardLogicUI.this.IvN != null && !GestureGuardLogicUI.this.IvN.isCanceled()) {
                    g.azz().a(GestureGuardLogicUI.this.IvN);
                }
                AppMethodBeat.o(129798);
            }
        });
        aVar2.iLN = new cvg();
        aVar2.iLO = new cvh();
        aVar2.funcId = 689;
        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
        d aXF = aVar2.aXF();
        cvg cvg = (cvg) aXF.iLK.iLR;
        cvg.EX = 1;
        cvg.MAH = new SKBuiltinBuffer_t().setBuffer(e.m32if(list));
        cvg.MAI = new SKBuiltinBuffer_t().setBuffer(e.m32if(list2));
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass9 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(129799);
                Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cvh) dVar.iLL.iLR).MAJ);
                    GestureGuardLogicUI.fVm();
                    if (GestureGuardLogicUI.this.mStatus != 0) {
                        String stringExtra = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                        if ("next_action.modify_pattern".equals(stringExtra)) {
                            kz kzVar = new kz();
                            kzVar.eEH = 5;
                            kzVar.eXI = 2;
                            kzVar.bfK();
                        } else if ("next_action.switch_on_pattern".equals(stringExtra)) {
                            kz kzVar2 = new kz();
                            kzVar2.eEH = 4;
                            kzVar2.eXI = 2;
                            kzVar2.bfK();
                        } else {
                            kz kzVar3 = new kz();
                            kzVar3.eEH = 5;
                            kzVar3.eXI = 2;
                            kzVar3.bfK();
                        }
                    } else if (GestureGuardLogicUI.this.Ivu == 1) {
                        kz kzVar4 = new kz();
                        kzVar4.eEH = 8;
                        kzVar4.eXI = 2;
                        kzVar4.bfK();
                    } else if (GestureGuardLogicUI.this.Ivu == 2) {
                        kz kzVar5 = new kz();
                        kzVar5.eEH = 10;
                        kzVar5.eXI = 2;
                        kzVar5.bfK();
                    }
                }
                i.INSTANCE.fVB();
                if (aVar != null) {
                    int a2 = aVar.a(i2, i3, str, dVar, qVar);
                    AppMethodBeat.o(129799);
                    return a2;
                }
                AppMethodBeat.o(129799);
                return 0;
            }
        }, false);
        AppMethodBeat.o(129832);
    }

    private void a(List<f> list, final aa.a aVar) {
        AppMethodBeat.i(129833);
        d(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass10 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(129800);
                GestureGuardLogicUI.this.IvG[GestureGuardLogicUI.this.IvF].Iwc.fVp();
                if (GestureGuardLogicUI.this.IvN != null && !GestureGuardLogicUI.this.IvN.isCanceled()) {
                    g.azz().a(GestureGuardLogicUI.this.IvN);
                }
                AppMethodBeat.o(129800);
            }
        });
        d.a aVar2 = new d.a();
        aVar2.iLN = new cvg();
        aVar2.iLO = new cvh();
        aVar2.funcId = 689;
        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
        d aXF = aVar2.aXF();
        cvg cvg = (cvg) aXF.iLK.iLR;
        cvg.EX = 3;
        cvg.MAH = new SKBuiltinBuffer_t().setBuffer(e.m32if(list));
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass11 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(129801);
                Log.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str));
                GestureGuardLogicUI.o(GestureGuardLogicUI.this);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.plugin.walletlock.gesture.a.d.a(((cvh) dVar.iLL.iLR).MAJ);
                    com.tencent.mm.plugin.walletlock.c.g gVar = com.tencent.mm.plugin.walletlock.c.g.instance;
                    com.tencent.mm.plugin.walletlock.c.g.yD(false);
                    GestureGuardLogicUI.this.IvK = false;
                    GestureGuardLogicUI.fVm();
                }
                if (aVar != null) {
                    int a2 = aVar.a(i2, i3, str, dVar, qVar);
                    AppMethodBeat.o(129801);
                    return a2;
                }
                AppMethodBeat.o(129801);
                return 0;
            }
        }, false);
        AppMethodBeat.o(129833);
    }

    private void fVh() {
        AppMethodBeat.i(129834);
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            i.INSTANCE.yH(true);
            i.INSTANCE.yI(true);
            intent.addFlags(131072);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/gesture/ui/GestureGuardLogicUI", "doGotoProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else {
            Log.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
        }
        finish();
        AppMethodBeat.o(129834);
    }

    private void fVi() {
        AppMethodBeat.i(129835);
        String stringExtra = getIntent().getStringExtra("next_action");
        if (this.mStatus == 20 || "next_action.goto_protected_page".equals(stringExtra)) {
            i.INSTANCE.fVC();
        }
        AppMethodBeat.o(129835);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(129836);
        AppMethodBeat.at(this, z);
        a aVar = this.IvG[this.IvF];
        if (aVar.Iwc != null) {
            aVar.Iwc.setEnableInput(z && !this.IvK);
        }
        AppMethodBeat.o(129836);
    }

    @Override // com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.a
    public final void a(PatternLockView patternLockView) {
        AppMethodBeat.i(129837);
        patternLockView.setDisplayMode(PatternLockView.b.Correct);
        AppMethodBeat.o(129837);
    }

    private void bp(int i2, boolean z) {
        AppMethodBeat.i(129838);
        int i3 = i2 - this.IvF;
        if (i3 == 0) {
            AppMethodBeat.o(129838);
            return;
        }
        this.IvF = i2;
        if (!z) {
            this.IvP.setInAnimation(null);
            this.IvP.setOutAnimation(null);
        } else if (i3 > 0) {
            this.IvP.setInAnimation(this, R.anim.eq);
            this.IvP.setOutAnimation(this, R.anim.en);
        } else {
            this.IvP.setInAnimation(this, R.anim.em);
            this.IvP.setOutAnimation(this, R.anim.er);
        }
        if (i3 > 0) {
            for (int i4 = 0; i4 < i3; i4++) {
                this.IvP.showNext();
            }
            AppMethodBeat.o(129838);
            return;
        }
        while (i3 < 0) {
            this.IvP.showPrevious();
            i3++;
        }
        AppMethodBeat.o(129838);
    }

    private void a(String str, final a aVar) {
        AppMethodBeat.i(129839);
        TextView textView = this.IvG[this.IvF].Iwa;
        textView.getText().toString();
        textView.setText(str);
        textView.setTextColor(this.IvE);
        textView.startAnimation(this.IvH);
        this.IvH.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass15 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(129805);
                GestureGuardLogicUI.this.IvH.setAnimationListener(null);
                if (aVar != null) {
                    aVar.onDone();
                }
                AppMethodBeat.o(129805);
            }
        });
        AppMethodBeat.o(129839);
    }

    private void fVj() {
        AppMethodBeat.i(129840);
        d.a aVar = new d.a(this);
        aVar.Dk(false).boo(String.format(getString(R.string.dug), 10L));
        aVar.aoV(R.string.duc).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass16 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(129806);
                dialogInterface.dismiss();
                GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.this.IvG[GestureGuardLogicUI.this.IvF].Iwd);
                AppMethodBeat.o(129806);
            }
        });
        aVar.aoW(R.string.dub).d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass17 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(129807);
                dialogInterface.dismiss();
                GestureGuardLogicUI.t(GestureGuardLogicUI.this);
                GestureGuardLogicUI.this.finish();
                AppMethodBeat.o(129807);
            }
        });
        aVar.hbn().show();
        AppMethodBeat.o(129840);
    }

    private void fVk() {
        AppMethodBeat.i(129841);
        new d.a(this).Dk(true).aoS(R.string.duj).aoV(R.string.due).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass18 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(129808);
                dialogInterface.dismiss();
                AppMethodBeat.o(129808);
            }
        }).hbn().show();
        AppMethodBeat.o(129841);
    }

    private void fVl() {
        String string;
        AppMethodBeat.i(129842);
        String stringExtra = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) {
            string = getString(R.string.duh);
        } else {
            string = getString(R.string.dui);
        }
        new d.a(this).Dk(false).boo(string).aoV(R.string.duf).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass20 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(129810);
                dialogInterface.dismiss();
                GestureGuardLogicUI.t(GestureGuardLogicUI.this);
                GestureGuardLogicUI.a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
                AppMethodBeat.o(129810);
            }
        }).aoW(R.string.dud).d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.AnonymousClass19 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(129809);
                dialogInterface.dismiss();
                AppMethodBeat.o(129809);
            }
        }).hbn().show();
        AppMethodBeat.o(129842);
    }

    private void d(DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(129843);
        if (this.IvQ == null) {
            this.IvQ = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dup), false, onCancelListener);
            AppMethodBeat.o(129843);
            return;
        }
        this.IvQ.show();
        AppMethodBeat.o(129843);
    }

    private void biW() {
        AppMethodBeat.i(129844);
        if (this.IvQ != null && this.IvQ.isShowing()) {
            this.IvQ.dismiss();
        }
        AppMethodBeat.o(129844);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void fVm() {
        AppMethodBeat.i(129851);
        ab.b(z.aTY(), 9, "PatternLockUpdate", "");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11473, new Object[0]);
        AppMethodBeat.o(129851);
    }
}
