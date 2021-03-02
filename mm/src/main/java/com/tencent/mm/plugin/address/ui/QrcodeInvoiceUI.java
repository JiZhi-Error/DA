package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.t;

public class QrcodeInvoiceUI extends MMActivity {
    private b ktD = null;
    private int ktp = 0;
    private TextView ktt;
    private InvoiceQrcodeTextView kuC;
    private InvoiceQrcodeTextView kuD;
    private InvoiceQrcodeTextView kuE;
    private InvoiceQrcodeTextView kuF;
    private InvoiceQrcodeTextView kuG;
    private InvoiceQrcodeTextView kuH;
    private InvoiceQrcodeTextView kuI;
    private Bitmap kuJ;
    private p kuK = null;
    private ImageView kuL;
    private View kuM;
    private float kuN = 0.0f;
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(20961);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.e0k && QrcodeInvoiceUI.this.kuK != null && QrcodeInvoiceUI.this.kuK.isShowing()) {
                QrcodeInvoiceUI.this.kuK.dismiss();
            }
            a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(20961);
        }
    };
    private View.OnClickListener kuP = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.AnonymousClass6 */

        public final void onClick(View view) {
            AppMethodBeat.i(20962);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.e0m && QrcodeInvoiceUI.this.kuK != null) {
                QrcodeInvoiceUI.this.showPopupWindow(view);
                QrcodeInvoiceUI.d(QrcodeInvoiceUI.this);
            }
            a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(20962);
        }
    };
    private Dialog tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrcodeInvoiceUI() {
        AppMethodBeat.i(20963);
        AppMethodBeat.o(20963);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20964);
        super.onCreate(bundle);
        Log.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
        this.ktp = getIntent().getIntExtra("invoice_id", 0);
        setMMTitle(R.string.e5e);
        AppMethodBeat.o(20964);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(20965);
        getWindow().setSoftInputMode(3);
        super.onResume();
        initView();
        AppMethodBeat.o(20965);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(20966);
        findViewById(R.id.goe);
        this.kuC = (InvoiceQrcodeTextView) findViewById(R.id.gog);
        if (this.kuC != null) {
            this.kuC.bqo();
        }
        this.kuD = (InvoiceQrcodeTextView) findViewById(R.id.goc);
        if (this.kuD != null) {
            this.kuD.bqo();
        }
        this.kuE = (InvoiceQrcodeTextView) findViewById(R.id.gof);
        if (this.kuE != null) {
            this.kuE.bqo();
        }
        this.kuF = (InvoiceQrcodeTextView) findViewById(R.id.gob);
        if (this.kuF != null) {
            this.kuF.bqo();
        }
        this.kuG = (InvoiceQrcodeTextView) findViewById(R.id.god);
        if (this.kuG != null) {
            this.kuG.bqo();
        }
        this.kuH = (InvoiceQrcodeTextView) findViewById(R.id.go_);
        if (this.kuH != null) {
            this.kuH.bqo();
        }
        this.kuI = (InvoiceQrcodeTextView) findViewById(R.id.goa);
        if (this.kuI != null) {
            this.kuI.bqo();
        }
        this.kuE.ktZ = true;
        this.kuE.ktT = true;
        if (this.ktp != 0) {
            this.ktt = (TextView) findViewById(R.id.gok);
            this.ktD = com.tencent.mm.plugin.address.a.a.bqc().vo(this.ktp);
            if (this.ktD == null) {
                Log.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
                finish();
            }
            if (this.ktD != null && this.ktD.type != null && this.ktD.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.ktt.setText(getString(R.string.e54));
                this.kuD.setVisibility(8);
                if (this.ktD.ynR == null || this.ktD.ynR.equals("")) {
                    this.kuE.setVisibility(8);
                } else {
                    this.kuE.setVisibility(0);
                    this.kuE.setValStr(this.ktD.ynR);
                }
                if (this.ktD.ynX == null || this.ktD.ynX.equals("")) {
                    this.kuF.setVisibility(8);
                } else {
                    this.kuF.setVisibility(0);
                    this.kuF.setValStr(this.ktD.ynX);
                }
                if (this.ktD.ynV == null || this.ktD.ynV.equals("")) {
                    this.kuG.setVisibility(8);
                } else {
                    this.kuG.setVisibility(0);
                    this.kuG.setValStr(this.ktD.ynV);
                }
                if (this.ktD.ynT == null || this.ktD.ynT.equals("")) {
                    this.kuH.setVisibility(8);
                } else {
                    this.kuH.setVisibility(0);
                    this.kuH.setValStr(this.ktD.ynT);
                }
                if (this.ktD.ynS == null || this.ktD.ynS.equals("")) {
                    this.kuI.setVisibility(8);
                } else {
                    this.kuI.setVisibility(0);
                    this.kuI.setValStr(this.ktD.ynS);
                }
            } else if (!(this.ktD == null || this.ktD.type == null || !this.ktD.type.equals("1"))) {
                this.ktt.setText(getString(R.string.e5_));
                this.kuC.setVisibility(8);
                this.kuE.setVisibility(8);
                this.kuF.setVisibility(8);
                this.kuG.setVisibility(8);
                this.kuH.setVisibility(8);
                this.kuI.setVisibility(8);
            }
            this.ktt.setVisibility(0);
            if (this.ktD != null) {
                this.kuC.setValStr(this.ktD.title);
                this.kuD.setValStr(this.ktD.ynQ);
            }
            if (this.kuK == null) {
                View inflate = View.inflate(this, R.layout.awc, null);
                inflate.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(20959);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (QrcodeInvoiceUI.this.kuK != null && QrcodeInvoiceUI.this.kuK.isShowing()) {
                            QrcodeInvoiceUI.this.kuK.dismiss();
                        }
                        a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(20959);
                    }
                });
                this.kuM = inflate.findViewById(R.id.e0l);
                this.kuL = (ImageView) inflate.findViewById(R.id.e0k);
                this.kuK = new p(inflate, -1, -1, true);
                this.kuK.setClippingEnabled(false);
                this.kuK.update();
                this.kuK.setBackgroundDrawable(new ColorDrawable(16777215));
                this.kuK.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    /* class com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.AnonymousClass4 */

                    public final void onDismiss() {
                        AppMethodBeat.i(20960);
                        QrcodeInvoiceUI.c(QrcodeInvoiceUI.this);
                        AppMethodBeat.o(20960);
                    }
                });
            }
        } else {
            Log.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
            finish();
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20957);
                QrcodeInvoiceUI.this.setResult(0);
                QrcodeInvoiceUI.this.finish();
                AppMethodBeat.o(20957);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.tt), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20958);
                Intent intent = new Intent();
                intent.setClass(QrcodeInvoiceUI.this, AddInvoiceUI.class);
                intent.putExtra("invoice_id", QrcodeInvoiceUI.this.ktp);
                QrcodeInvoiceUI qrcodeInvoiceUI = QrcodeInvoiceUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(qrcodeInvoiceUI, bl.axQ(), "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                qrcodeInvoiceUI.startActivity((Intent) bl.pG(0));
                a.a(qrcodeInvoiceUI, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(20958);
                return true;
            }
        }, null, t.b.GREEN);
        if (this.ktD == null || this.ktD.ynY == null || this.ktD.ynY.equals("")) {
            ImageView imageView = (ImageView) findViewById(R.id.e0m);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            View findViewById = findViewById(R.id.e0n);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            TextView textView = (TextView) findViewById(R.id.go6);
            if (textView != null) {
                textView.setVisibility(8);
            }
            AppMethodBeat.o(20966);
            return;
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.e0m);
        if (imageView2 != null) {
            imageView2.setVisibility(0);
            this.kuJ = com.tencent.mm.by.a.a.b(this, this.ktD.ynY, 12, 3);
            imageView2.setImageBitmap(this.kuJ);
            imageView2.setOnClickListener(this.kuP);
        }
        View findViewById2 = findViewById(R.id.e0n);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
        TextView textView2 = (TextView) findViewById(R.id.go6);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        AppMethodBeat.o(20966);
    }

    public void showPopupWindow(View view) {
        AppMethodBeat.i(20967);
        if (this.kuK != null && !this.kuK.isShowing()) {
            this.kuK.showAtLocation(view.getRootView(), 17, 0, 0);
            this.kuK.setFocusable(true);
            this.kuK.setTouchable(true);
            this.kuK.setBackgroundDrawable(new ColorDrawable(16777215));
            this.kuK.setOutsideTouchable(true);
            this.kuM.setVisibility(0);
            this.kuL.setOnClickListener(this.kuO);
            this.kuL.setImageBitmap(this.kuJ);
            if (this.kuJ != null) {
                Log.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                Log.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.kuK.update();
        }
        AppMethodBeat.o(20967);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(20968);
        super.onDestroy();
        AppMethodBeat.o(20968);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(20969);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!Util.isNullOrNil(stringExtra)) {
                        Log.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.kuG.setValStr(stringExtra);
                    }
                    String stringExtra2 = intent.getStringExtra("kpost_code");
                    if (!Util.isNullOrNil(stringExtra2)) {
                        Log.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(stringExtra2)));
                        this.kuG.setValStr(stringExtra2);
                    }
                    AppMethodBeat.o(20969);
                    return;
                }
                break;
            case 3:
                if (i3 != -1) {
                    Log.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
                    break;
                }
                break;
        }
        AppMethodBeat.o(20969);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ba7;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(20970);
        if (i2 == 4) {
            setResult(0);
            finish();
            AppMethodBeat.o(20970);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(20970);
        return onKeyUp;
    }

    static /* synthetic */ void c(QrcodeInvoiceUI qrcodeInvoiceUI) {
        AppMethodBeat.i(20971);
        WindowManager.LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness > qrcodeInvoiceUI.kuN) {
            attributes.screenBrightness = qrcodeInvoiceUI.kuN;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
        AppMethodBeat.o(20971);
    }

    static /* synthetic */ void d(QrcodeInvoiceUI qrcodeInvoiceUI) {
        AppMethodBeat.i(20972);
        WindowManager.LayoutParams attributes = qrcodeInvoiceUI.getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            qrcodeInvoiceUI.kuN = attributes.screenBrightness;
            attributes.screenBrightness = 0.85f;
            qrcodeInvoiceUI.getWindow().setAttributes(attributes);
        }
        AppMethodBeat.o(20972);
    }
}
