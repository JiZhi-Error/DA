package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.remittance.model.n;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fDynamicCodeUI extends WalletBaseUI {
    private static int Cwo = 60000;
    private String AOH;
    private String Cpt;
    private String CvW;
    private String CvX;
    private String CvY;
    private String CvZ;
    private String Cwa;
    private String Cwb;
    private List<alf> Cwc = new ArrayList();
    private boolean Cwd = false;
    private TextView Cwe;
    private TextView Cwf;
    private Button Cwg;
    private LinearLayout Cwh;
    private ImageView Cwi;
    private LinearLayout Cwj;
    private WalletTextView Cwk;
    private boolean Cwl = false;
    private long Cwm = 0;
    private long Cwn = 0;
    private MTimerHandler Cwp = new MTimerHandler(new a(this, (byte) 0), true);
    private String dKo;
    private PayInfo mPayInfo;
    private String ngg;
    private String nickname;
    private int qAW;
    private u.a qBH = new u.a() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass1 */

        @Override // com.tencent.mm.platformtools.u.a
        public final void k(String str, Bitmap bitmap) {
            AppMethodBeat.i(68180);
            if (str == null || RemittanceF2fDynamicCodeUI.this.qBl == null) {
                AppMethodBeat.o(68180);
                return;
            }
            if (str.equals(RemittanceF2fDynamicCodeUI.this.qBl)) {
                Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", RemittanceF2fDynamicCodeUI.this.qBl, str);
                RemittanceF2fDynamicCodeUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(68179);
                        RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
                        AppMethodBeat.o(68179);
                    }
                });
            }
            AppMethodBeat.o(68180);
        }
    };
    private String qBl;
    private String username;
    private int yRL;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceF2fDynamicCodeUI() {
        AppMethodBeat.i(68188);
        AppMethodBeat.o(68188);
    }

    static /* synthetic */ boolean c(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.i(68198);
        boolean needConfirmFinish = remittanceF2fDynamicCodeUI.needConfirmFinish();
        AppMethodBeat.o(68198);
        return needConfirmFinish;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68189);
        super.onCreate(bundle);
        if (eOi()) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.a5i)));
                View customView = getSupportActionBar().getCustomView();
                if (customView != null) {
                    View findViewById = customView.findViewById(R.id.brt);
                    if (findViewById != null) {
                        findViewById.setBackgroundColor(getResources().getColor(R.color.BW_0_Alpha_0_5));
                    }
                    View findViewById2 = customView.findViewById(16908308);
                    if (findViewById2 != null && (findViewById2 instanceof TextView)) {
                        ((TextView) findViewById2).setTextColor(getResources().getColor(R.color.a2x));
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(getResources().getColor(R.color.a5i));
            }
            if (d.oD(21) && !d.oD(23)) {
                getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.BW_93));
            }
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass3 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(68182);
                    if (RemittanceF2fDynamicCodeUI.c(RemittanceF2fDynamicCodeUI.this)) {
                        RemittanceF2fDynamicCodeUI.this.hideVKB();
                        RemittanceF2fDynamicCodeUI.this.showDialog(1000);
                    } else {
                        RemittanceF2fDynamicCodeUI.this.setResult(0, new Intent().putExtra("key_pay_reslut_type", 4));
                        RemittanceF2fDynamicCodeUI.this.finish();
                    }
                    AppMethodBeat.o(68182);
                    return true;
                }
            }, R.raw.back_icon_normal_black);
            addSceneEndListener(2736);
            setMMTitle(R.string.g1y);
            this.mPayInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
            if (this.mPayInfo == null) {
                Log.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
                finish();
            }
            setContentViewVisibility(4);
            this.yRL = this.mPayInfo.iqp.getInt("extinfo_key_15");
            this.username = this.mPayInfo.iqp.getString("extinfo_key_1");
            this.AOH = this.mPayInfo.iqp.getString("extinfo_key_2");
            this.CvX = this.mPayInfo.iqp.getString("extinfo_key_17");
            this.CvY = this.mPayInfo.iqp.getString("extinfo_key_18");
            this.ngg = getIntent().getStringExtra("key_rcvr_open_id");
            this.CvZ = getIntent().getStringExtra("key_mch_info");
            this.CvW = getIntent().getStringExtra("key_transfer_qrcode_id");
            this.qBl = getIntent().getStringExtra("key_mch_photo");
            this.Cpt = getIntent().getStringExtra("show_paying_wording");
            this.Cwa = getIntent().getStringExtra("dynamic_code_spam_wording");
            this.Cwd = getIntent().getBooleanExtra("show_avatar_type", false);
            this.nickname = f.getDisplayName(this.username);
            initView();
        }
        AppMethodBeat.o(68189);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68190);
        if (eOi()) {
            this.Cwe = (TextView) findViewById(R.id.h6f);
            this.Cwf = (TextView) findViewById(R.id.h6e);
            this.Cwg = (Button) findViewById(R.id.h6d);
            this.Cwi = (ImageView) findViewById(R.id.h6b);
            this.Cwh = (LinearLayout) findViewById(R.id.h6c);
            this.Cwj = (LinearLayout) findViewById(R.id.i3b);
            this.Cwk = (WalletTextView) findViewById(R.id.g9e);
            this.Cwk.setText(getString(R.string.g4h, new Object[]{f.D(((double) this.yRL) / 100.0d)}));
            this.Cwg.setOnClickListener(new x() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.x
                public final void czW() {
                    AppMethodBeat.i(68183);
                    RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 2);
                    AppMethodBeat.o(68183);
                }
            });
            this.Cwi.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass5 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(68184);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceF2fDynamicCodeUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    RemittanceF2fDynamicCodeUI.d(RemittanceF2fDynamicCodeUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/remittance/ui/RemittanceF2fDynamicCodeUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(68184);
                    return false;
                }
            });
        }
        AppMethodBeat.o(68190);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68191);
        super.onResume();
        e.eNU().gS(this);
        if (eOi()) {
            this.Cwn = this.Cwm <= 0 ? 0 : ((long) Cwo) - (System.currentTimeMillis() - this.Cwm);
            Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", Long.valueOf(this.Cwm), Long.valueOf(this.Cwn));
            if (this.Cwn < 0) {
                this.Cwn = 0;
            }
            this.Cwp.startTimer(this.Cwn, (long) Cwo);
            Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
        }
        AppMethodBeat.o(68191);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(68192);
        super.onPause();
        if (eOi()) {
            this.Cwp.stopTimer();
            Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
        }
        AppMethodBeat.o(68192);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68193);
        if (eOi()) {
            removeSceneEndListener(2736);
        }
        u.c(this.qBH);
        super.onDestroy();
        AppMethodBeat.o(68193);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(68194);
        super.onActivityResult(i2, i3, intent);
        if (eOi()) {
            Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", Integer.valueOf(i2), Integer.valueOf(i3), intent);
            if (i2 == 1) {
                rn rnVar = new rn();
                rn.a aVar = rnVar.dYd;
                if (i3 != -1) {
                    z = false;
                }
                aVar.dGX = z;
                if (intent != null) {
                    rnVar.dYd.dYe = intent.getIntExtra("key_pay_reslut_type", 3);
                } else {
                    rnVar.dYd.dYe = 3;
                }
                EventCenter.instance.publish(rnVar);
                if (i3 == -1) {
                    setResult(-1, intent);
                    finish();
                    AppMethodBeat.o(68194);
                    return;
                } else if (ag.bH(intent)) {
                    setResult(0, intent);
                    finish();
                    AppMethodBeat.o(68194);
                    return;
                } else if (ag.bI(intent)) {
                    AppMethodBeat.o(68194);
                    return;
                } else {
                    gk gkVar = new gk();
                    gkVar.dKl.dKm = false;
                    EventCenter.instance.publish(gkVar);
                }
            }
        }
        AppMethodBeat.o(68194);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(68195);
        if (eOi() && (qVar instanceof n)) {
            this.Cwl = false;
            final n nVar = (n) qVar;
            setContentViewVisibility(0);
            nVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(68181);
                    RemittanceF2fDynamicCodeUI.this.dKo = nVar.CoK.qwo;
                    RemittanceF2fDynamicCodeUI.this.qAW = ag.aqj(nVar.CoK.LgF);
                    RemittanceF2fDynamicCodeUI.this.Cwb = nVar.CoK.LgD;
                    RemittanceF2fDynamicCodeUI.this.Cwc = nVar.CoK.LgE;
                    RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
                    AppMethodBeat.o(68181);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass10 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass9 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        }
        AppMethodBeat.o(68195);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bms;
    }

    class a implements MTimerHandler.CallBack {
        private a() {
        }

        /* synthetic */ a(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(68187);
            Log.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
            if (RemittanceF2fDynamicCodeUI.this.Cwl) {
                AppMethodBeat.o(68187);
            } else {
                RemittanceF2fDynamicCodeUI.this.Cwm = System.currentTimeMillis();
                RemittanceF2fDynamicCodeUI.f(RemittanceF2fDynamicCodeUI.this);
                AppMethodBeat.o(68187);
            }
            return true;
        }
    }

    private boolean eOi() {
        AppMethodBeat.i(68196);
        boolean booleanExtra = getIntent().getBooleanExtra("from_patch_ui", false);
        AppMethodBeat.o(68196);
        return booleanExtra;
    }

    static /* synthetic */ void b(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.i(68197);
        remittanceF2fDynamicCodeUI.Cwi.setImageBitmap(com.tencent.mm.plugin.collect.model.b.a(remittanceF2fDynamicCodeUI, remittanceF2fDynamicCodeUI.dKo, remittanceF2fDynamicCodeUI.username, remittanceF2fDynamicCodeUI.mPayInfo.CpF, remittanceF2fDynamicCodeUI.qBl, remittanceF2fDynamicCodeUI.qBH, remittanceF2fDynamicCodeUI.Cwd, remittanceF2fDynamicCodeUI.qAW));
        if (!Util.isNullOrNil(remittanceF2fDynamicCodeUI.Cwb)) {
            remittanceF2fDynamicCodeUI.Cwe.setText(remittanceF2fDynamicCodeUI.Cwb);
        }
        if (!Util.isNullOrNil(remittanceF2fDynamicCodeUI.Cwa)) {
            remittanceF2fDynamicCodeUI.Cwf.setText(remittanceF2fDynamicCodeUI.Cwa);
            remittanceF2fDynamicCodeUI.Cwj.setVisibility(0);
        } else {
            remittanceF2fDynamicCodeUI.Cwj.setVisibility(8);
        }
        remittanceF2fDynamicCodeUI.Cwh.removeAllViews();
        if (!remittanceF2fDynamicCodeUI.Cwc.isEmpty()) {
            for (alf alf : remittanceF2fDynamicCodeUI.Cwc) {
                F2fDynamicCodeItemLayout f2fDynamicCodeItemLayout = new F2fDynamicCodeItemLayout(remittanceF2fDynamicCodeUI);
                String str = alf.key;
                String str2 = alf.value;
                f2fDynamicCodeItemLayout.Cqw.setText(str);
                f2fDynamicCodeItemLayout.qWU.setText(str2);
                remittanceF2fDynamicCodeUI.Cwh.addView(f2fDynamicCodeItemLayout, new LinearLayout.LayoutParams(-1, -2));
            }
        }
        remittanceF2fDynamicCodeUI.Cwh.requestLayout();
        AppMethodBeat.o(68197);
    }

    static /* synthetic */ void a(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI, int i2) {
        AppMethodBeat.i(68199);
        Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "send pay: %s", Integer.valueOf(i2));
        gl glVar = new gl();
        glVar.dKn.dKq = remittanceF2fDynamicCodeUI;
        glVar.dKn.dKp = i2;
        glVar.dKn.mRequestCode = 1;
        glVar.dKn.dKo = remittanceF2fDynamicCodeUI.dKo;
        EventCenter.instance.publish(glVar);
        AppMethodBeat.o(68199);
    }

    static /* synthetic */ void d(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.i(68200);
        com.tencent.mm.ui.widget.d dVar = new com.tencent.mm.ui.widget.d(remittanceF2fDynamicCodeUI.getContext());
        dVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(68185);
                mVar.clear();
                mVar.kV(0, R.string.g4g);
                AppMethodBeat.o(68185);
            }
        };
        dVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(68186);
                if (i2 == 0) {
                    RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 1);
                }
                AppMethodBeat.o(68186);
            }
        };
        dVar.dGm();
        dVar.PGl = new e.b() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
            }
        };
        AppMethodBeat.o(68200);
    }

    static /* synthetic */ void f(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.i(68201);
        Log.i("MicroMsg.RemittanceF2fDynamicCodeUI", "do get dynamic code %s", remittanceF2fDynamicCodeUI.CvZ);
        remittanceF2fDynamicCodeUI.Cwl = true;
        remittanceF2fDynamicCodeUI.doSceneProgress(new n(remittanceF2fDynamicCodeUI.yRL, remittanceF2fDynamicCodeUI.username, remittanceF2fDynamicCodeUI.ngg, remittanceF2fDynamicCodeUI.CvW, remittanceF2fDynamicCodeUI.CvX, remittanceF2fDynamicCodeUI.CvY, remittanceF2fDynamicCodeUI.CvZ, remittanceF2fDynamicCodeUI.nickname, remittanceF2fDynamicCodeUI.AOH), false);
        AppMethodBeat.o(68201);
    }
}
