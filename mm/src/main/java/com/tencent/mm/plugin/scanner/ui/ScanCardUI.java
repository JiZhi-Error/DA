package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.b.a.la;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.view.ScanCardRectView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@i
@a(3)
public class ScanCardUI extends MMActivity implements e.b {
    private boolean CEf;
    private boolean CJq = true;
    private long CJs;
    private int CLK;
    private ScanCardRectView CLL;
    private com.tencent.mm.plugin.scanner.b.c.a CLM;
    private la CLN = new la();
    private ScanCardRectView.a CLO = new ScanCardRectView.a() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanCardUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.scanner.view.ScanCardRectView.a
        public final void e(long j2, Bundle bundle) {
            AppMethodBeat.i(118350);
            if (ScanCardUI.this.CLM != null) {
                ScanCardUI.this.CLM.c(j2, bundle);
            }
            AppMethodBeat.o(118350);
        }
    };
    private ScanCardRectView.a CLP = new ScanCardRectView.a() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanCardUI.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.scanner.view.ScanCardRectView.a
        public final void e(long j2, Bundle bundle) {
            AppMethodBeat.i(118351);
            if (bundle.containsKey("param_card_bitmap")) {
                Bitmap decodeByteArray = BitmapUtil.decodeByteArray(bundle.getByteArray("param_card_bitmap"));
                if (ScanCardUI.this.CLK == 11) {
                    th thVar = new th();
                    thVar.dZJ.cardType = "identity_pay_auth";
                    thVar.dZJ.dZK = 1;
                    thVar.dZJ.dZM = decodeByteArray;
                    EventCenter.instance.publish(thVar);
                    ScanCardUI.this.finish();
                }
            }
            AppMethodBeat.o(118351);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ScanCardUI() {
        AppMethodBeat.i(118357);
        AppMethodBeat.o(118357);
    }

    static /* synthetic */ void c(ScanCardUI scanCardUI) {
        AppMethodBeat.i(118367);
        scanCardUI.goBack();
        AppMethodBeat.o(118367);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(118358);
        super.onCreate(bundle);
        hideTitleView();
        this.CLK = getIntent().getIntExtra("BaseScanUI_select_scan_mode", -1);
        Log.i("MicroMsg.ScanCardUI", "scanMode %d", Integer.valueOf(this.CLK));
        this.CEf = getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false);
        initView();
        this.CJs = System.currentTimeMillis();
        AppMethodBeat.o(118358);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bnt;
    }

    private void goBack() {
        AppMethodBeat.i(118360);
        tl tlVar = new tl();
        tlVar.dZU.cSx = 1;
        EventCenter.instance.publish(tlVar);
        setResult(0);
        cvn();
        AppMethodBeat.o(118360);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e.b
    public final void cvn() {
        AppMethodBeat.i(118361);
        Log.i("MicroMsg.ScanCardUI", "finishUI");
        if (this.CLK == 7) {
            if (this.CLN.erW == 1) {
                this.CLN.erW = 4;
            }
            this.CLN.eiR = System.currentTimeMillis() - this.CJs;
            this.CLN.bfK();
        }
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(118361);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(118362);
        goBack();
        AppMethodBeat.o(118362);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008d, code lost:
        if (com.tencent.mm.q.a.r(getApplicationContext(), true) == false) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0042  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.ScanCardUI.onResume():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(118364);
        Log.i("MicroMsg.ScanCardUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr.length), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.CJq = false;
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.ScanCardUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(118355);
                            ScanCardUI scanCardUI = ScanCardUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(scanCardUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            scanCardUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(scanCardUI, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ScanCardUI.this.CJq = true;
                            ScanCardUI.this.finish();
                            AppMethodBeat.o(118355);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.ScanCardUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(118356);
                            ScanCardUI.this.CJq = true;
                            ScanCardUI.this.finish();
                            AppMethodBeat.o(118356);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(118364);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(118365);
        super.onStop();
        this.CLL.onStop();
        AppMethodBeat.o(118365);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(118366);
        super.onDestroy();
        this.CLL.onDestroy();
        if (this.CLM != null) {
            this.CLM.destroy();
        }
        AppMethodBeat.o(118366);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(118359);
        getWindow().getDecorView().setSystemUiVisibility(5892);
        setActionbarColor(getResources().getColor(R.color.ac_));
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.h8y);
        this.CLL = new ScanCardRectView(this);
        frameLayout.addView(this.CLL, 0, new FrameLayout.LayoutParams(-1, -1));
        Button button = new Button(this);
        button.setWidth(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 36));
        button.setHeight(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 36));
        button.setBackgroundDrawable(ar.e(getResources().getDrawable(R.raw.icons_filled_close2), -1));
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanCardUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(118352);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ScanCardUI.c(ScanCardUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanCardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(118352);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(getResources().getDimensionPixelSize(R.dimen.cf), getResources().getDimensionPixelSize(R.dimen.cr), 0, 0);
        frameLayout.addView(button, layoutParams);
        this.CLL.setMode(this.CLK);
        this.CLL.onCreate();
        switch (this.CLK) {
            case 7:
                setMMTitle(R.string.gbm);
                la laVar = this.CLN;
                laVar.erW = 1;
                laVar.bfK();
                this.CLL.setScanCallback(this.CLO);
                this.CLM = new com.tencent.mm.plugin.scanner.b.c.a(this.CLK, this.CLL, this, this.CLN);
                this.CLM.CEf = this.CEf;
                AppMethodBeat.o(118359);
                return;
            case 8:
            default:
                setMMTitle("");
                AppMethodBeat.o(118359);
                return;
            case 9:
                setMMTitle(R.string.gbp);
                this.CLL.setScanCallback(this.CLP);
                AppMethodBeat.o(118359);
                return;
            case 10:
                setMMTitle(R.string.gbn);
                this.CLL.setScanCallback(this.CLP);
                AppMethodBeat.o(118359);
                return;
            case 11:
                setMMTitle(R.string.gbq);
                this.CLL.setScanCallback(this.CLP);
                AppMethodBeat.o(118359);
                return;
        }
    }
}
