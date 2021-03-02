package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.as;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.g;

@a(3)
public class F2FAppBrandRemittanceUI extends MMActivity implements i {
    private Bitmap AKT;
    private String Cqr = "";
    private ImageView Cqs;
    private IListener<as> Cqt = new IListener<as>() {
        /* class com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI.AnonymousClass1 */

        {
            AppMethodBeat.i(213736);
            this.__eventId = as.class.getName().hashCode();
            AppMethodBeat.o(213736);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(as asVar) {
            AppMethodBeat.i(213737);
            as asVar2 = asVar;
            if (asVar2 == null || !asVar2.dDK.isKinda) {
                AppMethodBeat.o(213737);
                return false;
            }
            Log.i("MicroMsg.F2FAppBrandRemittanceUI", "f2f appbrand callback data.pay_fail_reason :%s", Integer.valueOf(asVar2.dDK.dDP));
            switch (asVar2.dDK.dDP) {
                case 0:
                case 2:
                    F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.f.a.FAIL, "pay fail");
                    break;
                case 1:
                    break;
                case 3:
                    h.INSTANCE.a(19821, 9, F2FAppBrandRemittanceUI.this.app_id, 0);
                    F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.f.a.SUCCESS, "");
                    break;
                case 4:
                    F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.f.a.CANCEL, "");
                    break;
                default:
                    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "unknown pay failreason");
                    F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.f.a.CANCEL, "");
                    break;
            }
            AppMethodBeat.o(213737);
            return true;
        }
    };
    private String app_id = "";
    private d jzT;
    private g qAx;
    private u.a qBH = new u.a() {
        /* class com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI.AnonymousClass5 */

        @Override // com.tencent.mm.platformtools.u.a
        public final void k(String str, Bitmap bitmap) {
        }
    };

    public F2FAppBrandRemittanceUI() {
        AppMethodBeat.i(213740);
        AppMethodBeat.o(213740);
    }

    static /* synthetic */ void a(F2FAppBrandRemittanceUI f2FAppBrandRemittanceUI, Enum r2, String str) {
        AppMethodBeat.i(213750);
        f2FAppBrandRemittanceUI.a(r2, str);
        AppMethodBeat.o(213750);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(213741);
        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onCreate（）");
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        getWindow().setFlags(1024, 1024);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.app_id = getIntent().getStringExtra("key_app_id");
        this.Cqr = getIntent().getStringExtra("key_confirm_id");
        if (Util.isNullOrNil(this.Cqr)) {
            a(e.f.a.FAIL, "confirm_id is empty");
        }
        com.tencent.mm.kernel.g.azz().a(2850, this);
        com.tencent.mm.kernel.g.azz().a(new m(this.Cqr, this.app_id), 0);
        AppMethodBeat.o(213741);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(213742);
        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onDestroy()");
        super.onDestroy();
        if (this.Cqs != null) {
            this.Cqs.setImageBitmap(null);
        }
        Bitmap bitmap = this.AKT;
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("MicroMsg.F2FAppBrandRemittanceUI", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        u.c(this.qBH);
        this.Cqt.dead();
        com.tencent.mm.kernel.g.azz().b(2850, this);
        AppMethodBeat.o(213742);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        final vr vrVar;
        AppMethodBeat.i(213743);
        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof m) {
            if (i2 == 0 && i3 == 0) {
                m mVar = (m) qVar;
                if (mVar.CoI == null) {
                    vrVar = new vr();
                } else {
                    vrVar = mVar.CoI;
                }
                Log.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd ok，retcode:%s, retMsg：%s", Integer.valueOf(vrVar.dDN), vrVar.qwn);
                if (vrVar.dDN == 0) {
                    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "showHalfDialog");
                    if (vrVar == null || Util.isNullOrNil(vrVar.dTx)) {
                        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "res == null || Util.isNullOrNil(res.qrcode)");
                        a(e.f.a.FAIL, "get qrcode fail");
                        AppMethodBeat.o(213743);
                        return;
                    }
                    h.INSTANCE.a(19821, 1, this.app_id, 0);
                    this.qAx = new g(getContext(), 2, 3);
                    View inflate = View.inflate(getContext(), R.layout.a5h, null);
                    ((ImageView) inflate.findViewById(R.id.xv)).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(213738);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            F2FAppBrandRemittanceUI.this.qAx.bMo();
                            F2FAppBrandRemittanceUI.this.qAx = null;
                            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.f.a.CANCEL, "");
                            h.INSTANCE.a(19821, 3, F2FAppBrandRemittanceUI.this.app_id, 0);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213738);
                        }
                    });
                    TextView textView = (TextView) inflate.findViewById(R.id.c7y);
                    textView.setText(vrVar.title);
                    textView.getPaint().setFakeBoldText(true);
                    this.qAx.setHeaderView(inflate);
                    View inflate2 = View.inflate(getContext(), R.layout.a5g, null);
                    this.Cqs = (ImageView) inflate2.findViewById(R.id.c7v);
                    this.Cqs.setImageBitmap(null);
                    if (Util.isNullOrNil(vrVar.LgG)) {
                        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： res.head_img null");
                    } else {
                        String str2 = vrVar.dTx;
                        String str3 = vrVar.LgG;
                        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "contentUrl： %s ， headUrl：%s", str2, str3);
                        this.AKT = com.tencent.mm.plugin.collect.model.b.a(this, str2, z.aTY(), 1, str3, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 197.0f), this.qBH, false, 1, 2.0f, false);
                    }
                    if (this.AKT == null || this.AKT.isRecycled()) {
                        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： bmp null ");
                    } else {
                        this.Cqs.setImageBitmap(this.AKT);
                    }
                    ((TextView) inflate2.findViewById(R.id.c7x)).setText(vrVar.LgH);
                    TextView textView2 = (TextView) inflate2.findViewById(R.id.c7z);
                    textView2.setText(vrVar.LgI);
                    textView2.getPaint().setFakeBoldText(true);
                    this.qAx.setCustomView(inflate2);
                    this.qAx.T(vrVar.LgJ);
                    this.qAx.ape(0);
                    this.qAx.QOT = new g.a() {
                        /* class com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.widget.a.g.a
                        public final void onClick() {
                            AppMethodBeat.i(213739);
                            Log.i("MicroMsg.F2FAppBrandRemittanceUI", "go to remittaneUI");
                            F2FAppBrandRemittanceUI.this.Cqt.alive();
                            com.tencent.mm.plugin.wallet.a aVar = new com.tencent.mm.plugin.wallet.a();
                            aVar.HsN = F2FAppBrandRemittanceUI.this.app_id;
                            f.a(F2FAppBrandRemittanceUI.this.getContext(), 1, vrVar.dTx, 56, aVar);
                            h.INSTANCE.a(19821, 2, F2FAppBrandRemittanceUI.this.app_id, 0);
                            AppMethodBeat.o(213739);
                        }
                    };
                    this.qAx.dGm();
                    AppMethodBeat.o(213743);
                    return;
                }
                amW(vrVar.qwn);
                AppMethodBeat.o(213743);
                return;
            }
            Log.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
            amW(str);
        }
        AppMethodBeat.o(213743);
    }

    private void amW(String str) {
        AppMethodBeat.i(213744);
        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "showErrorDialog,errMsg:%s", str);
        f.a aVar = new f.a(getContext());
        aVar.aC("");
        f.a Dq = aVar.bow(str).Dq(true);
        Dq.JnN = true;
        Dq.apa(R.string.j34).b(new f.c() {
            /* class com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
            }
        }).show();
        if (aVar.kdo != null) {
            this.jzT = aVar.kdo;
        }
        AppMethodBeat.o(213744);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(213745);
        a(e.f.a.CANCEL, "");
        super.onBackPressed();
        AppMethodBeat.o(213745);
    }

    private void a(Enum r6, String str) {
        AppMethodBeat.i(213746);
        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "setActivityResultData result :%s , errmsg : %s", r6, str);
        Intent intent = new Intent();
        intent.putExtra("key_result_pay_result", r6);
        intent.putExtra("key_result_error_msg", str);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(213746);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(213747);
        AppMethodBeat.at(this, z);
        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged");
        if (this.qAx != null && !this.qAx.isShowing()) {
            Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", Boolean.valueOf(this.qAx.isShowing()));
            this.qAx = null;
            a(e.f.a.CANCEL, "");
            h.INSTANCE.a(19821, 3, this.app_id, 0);
        }
        if (this.jzT != null && !this.jzT.isShowing()) {
            Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", Boolean.valueOf(this.jzT.isShowing()));
            this.jzT = null;
            a(e.f.a.FAIL, "get qrcode fail");
        }
        super.onWindowFocusChanged(z);
        AppMethodBeat.o(213747);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(213748);
        super.onResume();
        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onResume()");
        AppMethodBeat.o(213748);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(213749);
        super.onPause();
        Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onPause()");
        AppMethodBeat.o(213749);
    }
}
