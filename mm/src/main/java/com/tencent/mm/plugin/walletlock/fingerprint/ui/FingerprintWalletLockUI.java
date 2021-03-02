package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.plugin.walletlock.c.b;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.plugin.walletlock.fingerprint.a.c;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d;
import com.tencent.mm.plugin.walletlock.fingerprint.a.h;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public class FingerprintWalletLockUI extends MMActivity implements com.tencent.mm.plugin.walletlock.ui.a {
    private boolean Ivd = false;
    private TextView Ivj;
    private TextView Ivk;
    private TextView Ivl;
    private Animation Ivm;
    private String Ivn;
    private String Ivo;
    private d Ivp;
    private h Ivq;
    private b Ivr;
    private String Ivs = "-1";
    private int Ivt = -1;
    private int Ivu = -1;
    private String Nl;
    private TextView hOu;
    private boolean isCancelled = false;
    private String krw = null;
    private String mToken;
    private com.tencent.mm.ui.widget.a.d mhs = null;
    private ProgressDialog qoU = null;
    private int wFZ = 0;
    private boolean zzT = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(129740);
        fingerprintWalletLockUI.biW();
        AppMethodBeat.o(129740);
    }

    static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI, String str) {
        AppMethodBeat.i(129747);
        fingerprintWalletLockUI.cK(4, str);
        AppMethodBeat.o(129747);
    }

    static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(129741);
        fingerprintWalletLockUI.fUO();
        AppMethodBeat.o(129741);
    }

    static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI, String str) {
        AppMethodBeat.i(129749);
        fingerprintWalletLockUI.aeu(str);
        AppMethodBeat.o(129749);
    }

    static /* synthetic */ void g(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(129745);
        fingerprintWalletLockUI.afa(1);
        AppMethodBeat.o(129745);
    }

    static /* synthetic */ void h(FingerprintWalletLockUI fingerprintWalletLockUI) {
        AppMethodBeat.i(129748);
        fingerprintWalletLockUI.fUQ();
        AppMethodBeat.o(129748);
    }

    public class a implements b {
        private WeakReference<FingerprintWalletLockUI> wGB = null;

        public a(FingerprintWalletLockUI fingerprintWalletLockUI) {
            AppMethodBeat.i(129718);
            this.wGB = new WeakReference<>(fingerprintWalletLockUI);
            AppMethodBeat.o(129718);
        }

        private FingerprintWalletLockUI fUT() {
            AppMethodBeat.i(129719);
            if (this.wGB != null) {
                FingerprintWalletLockUI fingerprintWalletLockUI = this.wGB.get();
                AppMethodBeat.o(129719);
                return fingerprintWalletLockUI;
            }
            AppMethodBeat.o(129719);
            return null;
        }

        @Override // com.tencent.mm.plugin.walletlock.c.b
        public final void fUU() {
            AppMethodBeat.i(129720);
            FingerprintWalletLockUI.a(FingerprintWalletLockUI.this);
            FingerprintWalletLockUI.b(FingerprintWalletLockUI.this);
            AppMethodBeat.o(129720);
        }

        @Override // com.tencent.mm.plugin.walletlock.c.b
        public final void A(int i2, String str) {
            AppMethodBeat.i(129721);
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", Integer.valueOf(i2), str, Boolean.valueOf(FingerprintWalletLockUI.this.isCancelled));
            if (FingerprintWalletLockUI.this.Nl != null && FingerprintWalletLockUI.this.Nl.equals("action.switch_on_pattern")) {
                kz kzVar = new kz();
                kzVar.eEH = 3;
                kzVar.eXI = 1;
                kzVar.bfK();
            }
            if (FingerprintWalletLockUI.this.Nl != null && FingerprintWalletLockUI.this.Nl.equals("action.verify_pattern")) {
                if (FingerprintWalletLockUI.this.Ivu == 1) {
                    kz kzVar2 = new kz();
                    kzVar2.eEH = 7;
                    kzVar2.eXI = 1;
                    kzVar2.bfK();
                } else if (FingerprintWalletLockUI.this.Ivu == 2) {
                    kz kzVar3 = new kz();
                    kzVar3.eEH = 9;
                    kzVar3.eXI = 1;
                    kzVar3.bfK();
                }
            }
            if (FingerprintWalletLockUI.this.isCancelled) {
                AppMethodBeat.o(129721);
                return;
            }
            switch (i2) {
                case 0:
                    Log.i("MicroMsg.FingerprintWalletLockUI", "identify success");
                    if (fUT() != null) {
                        FingerprintWalletLockUI.f(fUT());
                    }
                    if (FingerprintWalletLockUI.this.Nl != null && FingerprintWalletLockUI.this.Nl.equals("action.switch_on_pattern")) {
                        kz kzVar4 = new kz();
                        kzVar4.eEH = 3;
                        kzVar4.eXI = 2;
                        kzVar4.bfK();
                    }
                    if (FingerprintWalletLockUI.this.Nl != null && FingerprintWalletLockUI.this.Nl.equals("action.verify_pattern")) {
                        if (FingerprintWalletLockUI.this.Ivu == 1) {
                            kz kzVar5 = new kz();
                            kzVar5.eEH = 7;
                            kzVar5.eXI = 2;
                            kzVar5.bfK();
                            AppMethodBeat.o(129721);
                            return;
                        } else if (FingerprintWalletLockUI.this.Ivu == 2) {
                            kz kzVar6 = new kz();
                            kzVar6.eEH = 9;
                            kzVar6.eXI = 2;
                            kzVar6.bfK();
                            AppMethodBeat.o(129721);
                            return;
                        }
                    }
                    break;
                case 1:
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
                    if (fUT() != null) {
                        FingerprintWalletLockUI.a(fUT(), i2, FingerprintWalletLockUI.this.getString(R.string.if6));
                        AppMethodBeat.o(129721);
                        return;
                    }
                    break;
                case 2:
                    if (fUT() != null) {
                        FingerprintWalletLockUI.b(fUT(), i2, FingerprintWalletLockUI.this.getString(R.string.iey));
                        AppMethodBeat.o(129721);
                        return;
                    }
                    break;
                case 3:
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", Integer.valueOf(i2));
                    if (fUT() != null) {
                        FingerprintWalletLockUI.b(fUT(), i2, FingerprintWalletLockUI.this.getString(R.string.if5));
                        break;
                    }
                    break;
                case 4:
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
                    AppMethodBeat.o(129721);
                    return;
                case 5:
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
                    if (fUT() != null) {
                        FingerprintWalletLockUI.a(fUT(), i2, FingerprintWalletLockUI.this.getString(R.string.if6));
                        AppMethodBeat.o(129721);
                        return;
                    }
                    break;
                case 8:
                    if (fUT() != null) {
                        FingerprintWalletLockUI.b(fUT(), i2, FingerprintWalletLockUI.this.getString(R.string.ife));
                        AppMethodBeat.o(129721);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(129721);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(129722);
        super.onCreate(bundle);
        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onCreate %d", Long.valueOf(System.currentTimeMillis()));
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initView();
        Intent intent = getIntent();
        this.Nl = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        this.Ivo = this.Nl;
        this.Ivn = intent.getStringExtra("next_action");
        this.mToken = intent.getStringExtra("token");
        this.krw = intent.getStringExtra("key_pay_passwd");
        this.Ivu = intent.getIntExtra("scene", -1);
        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAction: %s, mNextAction: %s", this.Nl, this.Ivn);
        if (this.Nl.equals("action.verify_pattern")) {
            this.Ivt = 2;
            com.tencent.mm.plugin.walletlock.c.h.fVy();
            AppMethodBeat.o(129722);
            return;
        }
        if (this.Nl.equals("action.switch_on_pattern")) {
            this.Ivt = 1;
        }
        AppMethodBeat.o(129722);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(129723);
        super.onResume();
        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo needResume: %b", Boolean.valueOf(this.zzT));
        if (!this.zzT) {
            AppMethodBeat.o(129723);
            return;
        }
        this.Ivp = new c();
        this.Ivq = new h();
        this.isCancelled = false;
        f.hlO().hlP();
        this.qoU = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
        fUO();
        if (this.Nl.equals("action.switch_on_pattern")) {
            this.Ivd = false;
        } else {
            this.Ivd = true;
        }
        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start prepare, time: %d, isOffline: %b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(this.Ivd));
        g gVar = g.instance;
        boolean fVu = g.fVu();
        g gVar2 = g.instance;
        if (g.fUJ() && !fVu) {
            Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opend fingerprint lock but device not support soter, isSupportFingerprintLock: %b", Boolean.valueOf(fVu));
            if (e.fUV()) {
                Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user opened gesture, then switch to gesture");
                ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).aeZ(1);
                g gVar3 = g.instance;
                g.fVs();
                finish();
                Intent intent = new Intent(this, GestureGuardLogicUI.class);
                intent.addFlags(131072);
                intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                intent.putExtra("next_action", "next_action.goto_protected_page");
                intent.putExtra("page_intent", getIntent().getParcelableExtra("page_intent"));
                intent.setPackage(MMApplicationContext.getPackageName());
                boolean z = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, false);
                if (!z) {
                    intent.putExtra("verify_title", getString(R.string.ifk));
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLETLOCK_IS_AUTO_JUMP_TO_GESTURE_WHEN_NOT_SUPPORT_FINGERPRINT_BOOLEAN_SYNC, Boolean.TRUE);
                    com.tencent.mm.kernel.g.aAh().azQ().gBI();
                }
                Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo start gesture protect ui, isShowed: %b", Boolean.valueOf(z));
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "startGestureProtect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12097, 8, 0, Long.valueOf(System.currentTimeMillis()));
            } else {
                Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo show not support fingerprint dialog");
                biW();
                this.mhs = new d.a(this).aoS(R.string.iff).aoV(R.string.ifj).c(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass15 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(129717);
                        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
                        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).b(FingerprintWalletLockUI.this, 1, 4);
                        AppMethodBeat.o(129717);
                    }
                }).f(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass14 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(129716);
                        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
                        FingerprintWalletLockUI.this.finish();
                        FingerprintWalletLockUI.fUS();
                        AppMethodBeat.o(129716);
                    }
                }).hbn();
                this.mhs.setCanceledOnTouchOutside(false);
                this.mhs.b(getString(R.string.ies), false, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(129704);
                        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
                        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).m(FingerprintWalletLockUI.this, 5);
                        AppMethodBeat.o(129704);
                    }
                });
                this.mhs.show();
            }
        } else if (!com.tencent.soter.core.a.ld(this)) {
            fUP();
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("key_pay_passwd", this.krw);
            bundle.putBoolean("key_fp_lock_offline_mode", this.Ivd);
            this.Ivp.a(new d.a() {
                /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass10 */

                @Override // com.tencent.mm.plugin.walletlock.fingerprint.a.d.a
                public final void bg(int i2, String str) {
                    AppMethodBeat.i(129712);
                    Log.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", Integer.valueOf(i2), str, Long.valueOf(System.currentTimeMillis()));
                    if (FingerprintWalletLockUI.this.isCancelled) {
                        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
                        AppMethodBeat.o(129712);
                    } else if (i2 == 0) {
                        FingerprintWalletLockUI.h(FingerprintWalletLockUI.this);
                        AppMethodBeat.o(129712);
                    } else {
                        FingerprintWalletLockUI.b(FingerprintWalletLockUI.this, FingerprintWalletLockUI.this.getString(R.string.iey));
                        AppMethodBeat.o(129712);
                    }
                }
            }, bundle);
        }
        Log.i("MicroMsg.FingerprintWalletLockUI", "onResume end: %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(129723);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(129724);
        super.onPause();
        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo FingerprintWalletLockUI onPause");
        dismissDialog();
        release();
        this.zzT = true;
        AppMethodBeat.o(129724);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(129725);
        super.initView();
        this.Ivj = (TextView) findViewById(R.id.d4w);
        this.Ivk = (TextView) findViewById(R.id.g9i);
        this.hOu = (TextView) findViewById(R.id.d4s);
        this.Ivl = (TextView) findViewById(R.id.d4t);
        this.Ivk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(129703);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(129703);
            }
        });
        this.hOu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(129710);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FingerprintWalletLockUI.fUS();
                FingerprintWalletLockUI.a(FingerprintWalletLockUI.this, "user cancel setting fingerprint lock");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(129710);
            }
        });
        this.Ivl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(129711);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FingerprintWalletLockUI.g(FingerprintWalletLockUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(129711);
            }
        });
        AppMethodBeat.o(129725);
    }

    private void fUO() {
        AppMethodBeat.i(129726);
        if (this.Nl.equals("action.verify_pattern")) {
            this.Ivj.setText(R.string.if8);
            this.Ivj.setTextColor(getResources().getColor(R.color.a2x));
            this.Ivl.setVisibility(0);
            AppMethodBeat.o(129726);
            return;
        }
        this.Ivj.setText(R.string.if1);
        this.Ivj.setTextColor(getResources().getColor(R.color.a2x));
        this.Ivl.setVisibility(8);
        AppMethodBeat.o(129726);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.alp;
    }

    private void fUP() {
        AppMethodBeat.i(129727);
        biW();
        d.a aVar = new d.a(this);
        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo mAuthType: %d", Integer.valueOf(this.Ivt));
        if (this.Ivt == 2) {
            aVar.aoS(R.string.ife).aoV(R.string.ifi).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(129714);
                    FingerprintWalletLockUI.i(FingerprintWalletLockUI.this);
                    AppMethodBeat.o(129714);
                }
            }).aoW(R.string.sz).d(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(129713);
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
                    AppMethodBeat.o(129713);
                }
            });
        } else {
            aVar.aoS(R.string.ifd).bou(getString(R.string.x_)).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(129715);
                    FingerprintWalletLockUI.this.finish();
                    FingerprintWalletLockUI.fUS();
                    AppMethodBeat.o(129715);
                }
            });
        }
        this.mhs = aVar.hbn();
        this.mhs.setCanceledOnTouchOutside(false);
        this.mhs.show();
        AppMethodBeat.o(129727);
    }

    private void dismissDialog() {
        AppMethodBeat.i(129728);
        biW();
        if (this.mhs != null && this.mhs.isShowing()) {
            this.mhs.dismiss();
        }
        AppMethodBeat.o(129728);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(129729);
        Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onBackPressed");
        finish();
        i.INSTANCE.fVC();
        AppMethodBeat.o(129729);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void fUQ() {
        AppMethodBeat.i(129730);
        Log.i("MicroMsg.FingerprintWalletLockUI", "currentAction: %s", this.Ivo);
        if (Util.isNullOrNil(this.Ivo)) {
            finish();
            AppMethodBeat.o(129730);
            return;
        }
        String str = this.Ivo;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1423990800:
                if (str.equals("next_action.goto_protected_page")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1305462654:
                if (str.equals("action.verify_pattern")) {
                    c2 = 1;
                    break;
                }
                break;
            case -639789777:
                if (str.equals("next_action.switch_on_pattern")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1420518755:
                if (str.equals("action.switch_on_pattern")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                this.Ivr = new a(this);
                this.Ivs = "-1";
                if (this.Ivq == null) {
                    this.Ivq = new h();
                }
                h hVar = this.Ivq;
                b bVar = this.Ivr;
                h.AnonymousClass1 r4 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0082: CONSTRUCTOR  (r4v7 'r4' com.tencent.mm.plugin.walletlock.fingerprint.a.h$1) = (r0v18 'hVar' com.tencent.mm.plugin.walletlock.fingerprint.a.h), (r1v3 'bVar' com.tencent.mm.plugin.walletlock.c.b) call: com.tencent.mm.plugin.walletlock.fingerprint.a.h.1.<init>(com.tencent.mm.plugin.walletlock.fingerprint.a.h, com.tencent.mm.plugin.walletlock.c.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.fUQ():void, file: classes6.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.walletlock.fingerprint.a.h, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 23 more
                    */
                /*
                // Method dump skipped, instructions count: 304
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.fUQ():void");
            }

            private void fUR() {
                AppMethodBeat.i(129731);
                this.zzT = false;
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(129705);
                        FingerprintWalletLockUI.this.finish();
                        AppMethodBeat.o(129705);
                    }
                }, 200);
                Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
                if (intent != null) {
                    Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo go to protected page");
                    i.INSTANCE.yH(true);
                    i.INSTANCE.yI(true);
                    intent.addFlags(131072);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/walletlock/fingerprint/ui/FingerprintWalletLockUI", "goToProtectedPage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    overridePendingTransition(R.anim.em, R.anim.er);
                    AppMethodBeat.o(129731);
                    return;
                }
                Log.i("MicroMsg.FingerprintWalletLockUI", "Protected page's intent not found, finish myself only.");
                AppMethodBeat.o(129731);
            }

            private void afa(int i2) {
                AppMethodBeat.i(129732);
                Intent intent = new Intent();
                if (i2 == 1) {
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.touchlock_verify_by_paypwd");
                } else if (i2 == 2) {
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.touchlock_need_verify_paypwd");
                    intent.putExtra("key_wallet_lock_input_new_fp_tips", getString(R.string.ifc));
                }
                intent.putExtra("key_wallet_lock_type", 2);
                com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
                AppMethodBeat.o(129732);
            }

            private void biW() {
                AppMethodBeat.i(129733);
                if (this.qoU != null && this.qoU.isShowing()) {
                    this.qoU.dismiss();
                }
                AppMethodBeat.o(129733);
            }

            private void amW(String str) {
                AppMethodBeat.i(129734);
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.if7);
                }
                dismissDialog();
                this.mhs = com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(129706);
                        FingerprintWalletLockUI.this.finish();
                        AppMethodBeat.o(129706);
                    }
                });
                this.mhs.setCanceledOnTouchOutside(false);
                AppMethodBeat.o(129734);
            }

            private void aeu(String str) {
                AppMethodBeat.i(129735);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (currentTimeMillis - this.wFZ > 1) {
                    this.wFZ = currentTimeMillis;
                    dismissDialog();
                    if (this.Ivj != null) {
                        this.Ivj.setText(str);
                        this.Ivj.setTextColor(getResources().getColor(R.color.a5c));
                        this.Ivj.setVisibility(4);
                        if (this.Ivm == null) {
                            this.Ivm = AnimationUtils.loadAnimation(getContext(), R.anim.bu);
                        }
                        this.Ivj.startAnimation(this.Ivm);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(129707);
                                FingerprintWalletLockUI.this.Ivj.setVisibility(0);
                                AppMethodBeat.o(129707);
                            }
                        }, this.Ivm.getDuration());
                    }
                    AppMethodBeat.o(129735);
                    return;
                }
                AppMethodBeat.o(129735);
            }

            private void release() {
                AppMethodBeat.i(129736);
                Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo fingerprint lock ui release isCancelled: %b", Boolean.valueOf(this.isCancelled));
                if (this.isCancelled) {
                    AppMethodBeat.o(129736);
                    return;
                }
                this.isCancelled = true;
                if (this.Ivq != null) {
                    this.Ivq.release();
                }
                if (this.Ivp != null) {
                    this.Ivp.release();
                }
                f.hlO().hlP();
                AppMethodBeat.o(129736);
            }

            private void cK(int i2, String str) {
                AppMethodBeat.i(129737);
                Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo finish with result, resultCode: %d, errCode: %d, errMsg: %s", -1, Integer.valueOf(i2), str);
                release();
                Intent intent = new Intent();
                intent.putExtra("key_err_code", i2);
                intent.putExtra("key_err_msg", str);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(129737);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
            public void finish() {
                AppMethodBeat.i(129738);
                super.finish();
                release();
                AppMethodBeat.o(129738);
            }

            @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onActivityResult(int i2, int i3, Intent intent) {
                AppMethodBeat.i(129739);
                Log.v("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (intent == null) {
                    Log.e("MicroMsg.FingerprintWalletLockUI", "alvinluo data is null");
                    AppMethodBeat.o(129739);
                    return;
                }
                int intExtra = intent.getIntExtra("key_err_code", -1);
                Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onActivityResult errCode: %d", Integer.valueOf(intExtra));
                if (i2 == 1) {
                    if (intExtra == 0) {
                        fUR();
                        com.tencent.mm.plugin.walletlock.c.h.fVw();
                        AppMethodBeat.o(129739);
                        return;
                    } else if (intExtra == -1) {
                        this.zzT = false;
                        amW(getString(R.string.ifm));
                        AppMethodBeat.o(129739);
                        return;
                    }
                } else if (i2 == 2) {
                    if (intExtra == 0) {
                        com.tencent.mm.plugin.walletlock.fingerprint.a.a.aWg(this.Ivs);
                        com.tencent.mm.plugin.walletlock.fingerprint.a.a.LU(SystemClock.elapsedRealtime());
                        fUR();
                        AppMethodBeat.o(129739);
                        return;
                    } else if (intExtra == -1) {
                        this.zzT = false;
                        amW(getString(R.string.ifm));
                        AppMethodBeat.o(129739);
                        return;
                    }
                } else if (i2 == 3) {
                    if (intExtra == 0) {
                        fUR();
                        AppMethodBeat.o(129739);
                        return;
                    }
                    finish();
                    i.INSTANCE.fVC();
                    AppMethodBeat.o(129739);
                    return;
                } else if (i2 == 4) {
                    if (intExtra == 0) {
                        fUR();
                        AppMethodBeat.o(129739);
                        return;
                    } else if (intExtra == -1) {
                        this.zzT = false;
                        amW(getString(R.string.ifa));
                        AppMethodBeat.o(129739);
                        return;
                    } else {
                        finish();
                        i.INSTANCE.fVC();
                        AppMethodBeat.o(129739);
                        return;
                    }
                } else if (i2 == 5) {
                    if (intExtra == 0) {
                        ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).aeZ(0);
                        g gVar = g.instance;
                        g.fUM();
                        Toast.makeText(this, getString(R.string.iet), 0).show();
                        fUR();
                        AppMethodBeat.o(129739);
                        return;
                    } else if (intExtra == -1) {
                        this.zzT = false;
                        amW(getString(R.string.ieu));
                        AppMethodBeat.o(129739);
                        return;
                    } else if (intExtra == 4) {
                        finish();
                        i.INSTANCE.fVC();
                    }
                }
                AppMethodBeat.o(129739);
            }

            static /* synthetic */ void f(FingerprintWalletLockUI fingerprintWalletLockUI) {
                AppMethodBeat.i(129742);
                com.tencent.mm.plugin.walletlock.c.h.aJ(fingerprintWalletLockUI.Ivu, 2, 0);
                j jVar = g.instance.IwW;
                if (jVar != null) {
                    fingerprintWalletLockUI.Ivs = jVar.RPS;
                    Log.v("MicroMsg.FingerprintWalletLockUI", "alvinluo authSuccess and mFid: %s", fingerprintWalletLockUI.Ivs);
                    if (fingerprintWalletLockUI.Ivo.equals("action.switch_on_pattern")) {
                        fingerprintWalletLockUI.Ivo = fingerprintWalletLockUI.Ivn;
                        fingerprintWalletLockUI.fUQ();
                        AppMethodBeat.o(129742);
                        return;
                    } else if (fingerprintWalletLockUI.Ivo.equals("action.verify_pattern")) {
                        if (com.tencent.mm.plugin.walletlock.fingerprint.a.a.aWh(fingerprintWalletLockUI.Ivs)) {
                            fingerprintWalletLockUI.Ivo = fingerprintWalletLockUI.Ivn;
                            fingerprintWalletLockUI.fUQ();
                            AppMethodBeat.o(129742);
                            return;
                        }
                        fingerprintWalletLockUI.afa(2);
                    }
                }
                AppMethodBeat.o(129742);
            }

            static /* synthetic */ void a(FingerprintWalletLockUI fingerprintWalletLockUI, int i2, String str) {
                AppMethodBeat.i(129743);
                Log.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenFailed errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
                com.tencent.mm.plugin.walletlock.c.h.aJ(fingerprintWalletLockUI.Ivu, 2, 1);
                fingerprintWalletLockUI.aeu(str);
                AppMethodBeat.o(129743);
            }

            static /* synthetic */ void b(FingerprintWalletLockUI fingerprintWalletLockUI, int i2, String str) {
                AppMethodBeat.i(129744);
                Log.e("MicroMsg.FingerprintWalletLockUI", "alvinluo onAuthenError errCode: %d, errMsg: %s", Integer.valueOf(i2), str);
                com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUM();
                fingerprintWalletLockUI.dismissDialog();
                if (i2 == 3) {
                    com.tencent.mm.plugin.walletlock.c.h.aJ(fingerprintWalletLockUI.Ivu, 2, 2);
                    com.tencent.mm.plugin.walletlock.fingerprint.a.a.aB(System.currentTimeMillis(), 0);
                    fingerprintWalletLockUI.Ivj.setText(R.string.if5);
                    fingerprintWalletLockUI.Ivj.setTextColor(fingerprintWalletLockUI.getResources().getColor(R.color.a5c));
                    AppMethodBeat.o(129744);
                } else if (i2 == 8) {
                    fingerprintWalletLockUI.fUP();
                    AppMethodBeat.o(129744);
                } else {
                    fingerprintWalletLockUI.aeu(str);
                    AppMethodBeat.o(129744);
                }
            }

            static /* synthetic */ void fUS() {
                AppMethodBeat.i(129746);
                i.INSTANCE.fVC();
                AppMethodBeat.o(129746);
            }

            static /* synthetic */ void i(FingerprintWalletLockUI fingerprintWalletLockUI) {
                AppMethodBeat.i(129750);
                Intent intent = new Intent();
                intent.putExtra("key_wallet_lock_setting_scene", 1);
                ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).c(fingerprintWalletLockUI, intent, 3);
                AppMethodBeat.o(129750);
            }

            static /* synthetic */ void k(FingerprintWalletLockUI fingerprintWalletLockUI) {
                AppMethodBeat.i(129751);
                fingerprintWalletLockUI.dismissDialog();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(129709);
                        com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUI();
                        com.tencent.mm.plugin.walletlock.fingerprint.a.a.aWg(FingerprintWalletLockUI.this.Ivs);
                        com.tencent.mm.plugin.walletlock.fingerprint.a.a.LU(-1);
                        g gVar = g.instance;
                        g.fVs();
                        AppMethodBeat.o(129709);
                    }
                });
                Toast.makeText(fingerprintWalletLockUI, (int) R.string.if0, 0).show();
                ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).aeZ(2);
                i.INSTANCE.fVB();
                fingerprintWalletLockUI.cK(0, "open fingerprint lock ok");
                AppMethodBeat.o(129751);
            }
        }
