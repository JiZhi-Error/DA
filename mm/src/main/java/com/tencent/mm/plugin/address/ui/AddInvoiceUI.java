package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.ui.InvoiceEditView;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;

public class AddInvoiceUI extends MMActivity implements i, InvoiceEditView.c {
    private int adT = 0;
    private String dWN = "";
    private InvoiceEditView ktA;
    private InvoiceEditView ktB;
    private InvoiceEditView ktC;
    private b ktD = null;
    private b ktE = new b();
    private boolean ktF = false;
    private boolean ktG = false;
    private int ktp = 0;
    private Button ktq = null;
    private Button ktr = null;
    private TextView kts;
    private TextView ktt;
    private TextView ktu = null;
    private InvoiceEditView ktv;
    private InvoiceEditView ktw;
    private InvoiceEditView ktx;
    private InvoiceEditView kty;
    private InvoiceEditView ktz;
    private Dialog tipDialog = null;
    private TextView vr;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AddInvoiceUI() {
        AppMethodBeat.i(20833);
        AppMethodBeat.o(20833);
    }

    static /* synthetic */ boolean d(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.i(20845);
        boolean bqg = addInvoiceUI.bqg();
        AppMethodBeat.o(20845);
        return bqg;
    }

    static /* synthetic */ void e(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.i(20846);
        addInvoiceUI.bqi();
        AppMethodBeat.o(20846);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20834);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.ktF = intent.getBooleanExtra("launch_from_webview", false);
        this.ktG = intent.getBooleanExtra("launch_from_invoicelist_webview", false);
        bg.azz().a(1191, this);
        Log.d("MicroMsg.AddInvoiceUI", "index Oncreate");
        this.ktE = new b();
        this.ktp = getIntent().getIntExtra("invoice_id", 0);
        if (this.ktp == 0) {
            setMMTitle(R.string.gn8);
        } else {
            setMMTitle(R.string.gqt);
        }
        initView();
        AppMethodBeat.o(20834);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(20835);
        this.adT = 0;
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.id.e0q);
        if (mMScrollView != null) {
            mMScrollView.a(mMScrollView, mMScrollView);
        }
        this.ktq = (Button) findViewById(R.id.e0h);
        if (this.ktq != null) {
            this.ktq.setVisibility(0);
        }
        this.ktr = (Button) findViewById(R.id.e0f);
        if (this.ktr != null) {
            this.ktr.setVisibility(0);
        }
        if (this.ktp == 0 && this.ktr != null) {
            this.ktr.setActivated(true);
        }
        if (this.ktr != null) {
            this.ktr.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.address.ui.AddInvoiceUI.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(20828);
                    if (motionEvent.getAction() == 0) {
                        AppMethodBeat.o(20828);
                        return true;
                    } else if (motionEvent.getAction() != 1) {
                        AppMethodBeat.o(20828);
                        return false;
                    } else {
                        if (!AddInvoiceUI.this.ktr.isActivated()) {
                            AddInvoiceUI.this.ktr.setActivated(true);
                        }
                        if (AddInvoiceUI.this.ktr.isActivated()) {
                            AddInvoiceUI.this.ktq.setActivated(false);
                            AddInvoiceUI.this.ktE.type = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        AddInvoiceUI.d(AddInvoiceUI.this);
                        AppMethodBeat.o(20828);
                        return true;
                    }
                }
            });
        }
        if (this.ktq != null) {
            this.ktq.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.address.ui.AddInvoiceUI.AnonymousClass2 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(20829);
                    if (motionEvent.getAction() == 0) {
                        AppMethodBeat.o(20829);
                        return true;
                    } else if (motionEvent.getAction() != 1) {
                        AppMethodBeat.o(20829);
                        return false;
                    } else {
                        if (!AddInvoiceUI.this.ktq.isActivated()) {
                            AddInvoiceUI.this.ktq.setActivated(true);
                        }
                        if (AddInvoiceUI.this.ktq.isActivated()) {
                            AddInvoiceUI.this.ktr.setActivated(false);
                            AddInvoiceUI.this.ktE.type = "1";
                        }
                        AddInvoiceUI.d(AddInvoiceUI.this);
                        AppMethodBeat.o(20829);
                        return true;
                    }
                }
            });
        }
        this.ktv = (InvoiceEditView) findViewById(R.id.e0t);
        this.ktw = (InvoiceEditView) findViewById(R.id.e0s);
        this.ktx = (InvoiceEditView) findViewById(R.id.e0i);
        this.kty = (InvoiceEditView) findViewById(R.id.e0r);
        this.ktz = (InvoiceEditView) findViewById(R.id.e0e);
        this.ktA = (InvoiceEditView) findViewById(R.id.e0j);
        this.ktB = (InvoiceEditView) findViewById(R.id.e0b);
        this.ktC = (InvoiceEditView) findViewById(R.id.e0c);
        this.kty.ktZ = true;
        this.kty.ktT = true;
        this.kty.setOnInputValidChangeListener(this);
        this.ktv.setOnInputValidChangeListener(this);
        this.ktw.setOnInputValidChangeListener(this);
        this.ktx.setOnInputValidChangeListener(this);
        this.ktz.setOnInputValidChangeListener(this);
        this.ktA.setOnInputValidChangeListener(this);
        this.ktB.setOnInputValidChangeListener(this);
        this.ktC.setOnInputValidChangeListener(this);
        if (this.ktp != 0) {
            this.vr = (TextView) findViewById(R.id.ior);
            this.vr.setVisibility(8);
            this.ktt = (TextView) findViewById(R.id.izm);
            this.ktD = a.bqc().vo(this.ktp);
            if (this.ktD != null && this.ktD.type != null && this.ktD.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.ktt.setText(getString(R.string.e54));
            } else if (!(this.ktD == null || this.ktD.type == null || !this.ktD.type.equals("1"))) {
                this.ktt.setText(getString(R.string.e5_));
            }
            this.ktt.setVisibility(0);
            this.ktr.setVisibility(8);
            this.ktq.setVisibility(8);
            if (this.ktD != null) {
                this.ktv.setValStr(this.ktD.type);
                this.ktw.setValStr(this.ktD.title);
                this.ktx.setValStr(this.ktD.ynQ);
                this.kty.setValStr(this.ktD.ynR);
                this.ktz.setValStr(this.ktD.ynX);
                this.ktA.setValStr(this.ktD.ynV);
                this.ktB.setValStr(this.ktD.ynT);
                this.ktC.setValStr(this.ktD.ynS);
            }
        }
        if (this.ktG || this.ktF) {
            this.ktu = (TextView) findViewById(R.id.e5b);
            if (this.ktu != null) {
                this.ktu.setVisibility(0);
            }
        } else {
            this.ktu = (TextView) findViewById(R.id.e5b);
            if (this.ktu != null) {
                this.ktu.setVisibility(8);
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.AddInvoiceUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20830);
                AddInvoiceUI.e(AddInvoiceUI.this);
                AppMethodBeat.o(20830);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.AddInvoiceUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20831);
                if (AddInvoiceUI.this.ktp == 0) {
                    h.INSTANCE.a(14199, 3);
                } else {
                    h.INSTANCE.a(14199, 4);
                }
                if (AddInvoiceUI.this.ktr != null && AddInvoiceUI.this.ktr.isActivated() && AddInvoiceUI.this.ktw.getText().length() == 0) {
                    AddInvoiceUI.this.bqj();
                    AppMethodBeat.o(20831);
                    return false;
                } else if (AddInvoiceUI.this.ktq != null && AddInvoiceUI.this.ktq.isActivated() && AddInvoiceUI.this.ktx.getText().length() == 0) {
                    AddInvoiceUI.this.bqj();
                    AppMethodBeat.o(20831);
                    return false;
                } else if (AddInvoiceUI.this.ktp != 0 && AddInvoiceUI.this.ktx.getText().length() == 0 && AddInvoiceUI.this.ktw.getText().length() == 0) {
                    AddInvoiceUI.this.bqj();
                    AppMethodBeat.o(20831);
                    return false;
                } else if (AddInvoiceUI.this.kty.getText().length() > 100) {
                    AddInvoiceUI addInvoiceUI = AddInvoiceUI.this;
                    com.tencent.mm.ui.base.h.a((Context) addInvoiceUI, addInvoiceUI.getString(R.string.e50), addInvoiceUI.getString(R.string.zb), false, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(20831);
                    return false;
                } else if (!AddInvoiceUI.d(AddInvoiceUI.this)) {
                    if ((AddInvoiceUI.this.ktr != null && AddInvoiceUI.this.ktr.isActivated()) || !(AddInvoiceUI.this.ktD == null || AddInvoiceUI.this.ktD.type == null || !AddInvoiceUI.this.ktD.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                        if (!AddInvoiceUI.this.ktA.bql()) {
                            AddInvoiceUI addInvoiceUI2 = AddInvoiceUI.this;
                            com.tencent.mm.ui.base.h.a((Context) addInvoiceUI2, addInvoiceUI2.getString(R.string.e5a), addInvoiceUI2.getString(R.string.zb), false, (DialogInterface.OnClickListener) null);
                        }
                        if (!AddInvoiceUI.this.ktC.bql()) {
                            AddInvoiceUI addInvoiceUI3 = AddInvoiceUI.this;
                            com.tencent.mm.ui.base.h.a((Context) addInvoiceUI3, addInvoiceUI3.getString(R.string.e4x), addInvoiceUI3.getString(R.string.zb), false, (DialogInterface.OnClickListener) null);
                        }
                    }
                    AppMethodBeat.o(20831);
                    return true;
                } else {
                    if (AddInvoiceUI.this.ktr.isActivated()) {
                        AddInvoiceUI.this.ktE.type = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else if (AddInvoiceUI.this.ktq.isActivated()) {
                        AddInvoiceUI.this.ktE.type = "1";
                    }
                    if (AddInvoiceUI.this.ktD != null) {
                        AddInvoiceUI.this.ktE.type = AddInvoiceUI.this.ktD.type;
                    }
                    AddInvoiceUI.this.ktE.title = AddInvoiceUI.this.ktw.getText();
                    AddInvoiceUI.this.ktE.ynQ = AddInvoiceUI.this.ktx.getText();
                    AddInvoiceUI.this.ktE.ynR = AddInvoiceUI.this.kty.getText();
                    AddInvoiceUI.this.ktE.ynP = AddInvoiceUI.this.ktp;
                    AddInvoiceUI.this.ktE.ynV = AddInvoiceUI.this.ktA.getText();
                    AddInvoiceUI.this.ktE.ynT = AddInvoiceUI.this.ktB.getText();
                    AddInvoiceUI.this.ktE.ynS = AddInvoiceUI.this.ktC.getText();
                    AddInvoiceUI.this.ktE.ynX = AddInvoiceUI.this.ktz.getText();
                    AddInvoiceUI.o(AddInvoiceUI.this);
                    AppMethodBeat.o(20831);
                    return true;
                }
            }
        }, null, t.b.GREEN);
        enableOptionMenu(false);
        bqg();
        AppMethodBeat.o(20835);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(20836);
        bg.azz().b(1180, this);
        bg.azz().b(1191, this);
        getWindow().setSoftInputMode(3);
        super.onDestroy();
        AppMethodBeat.o(20836);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(20837);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    String stringExtra = intent.getStringExtra("karea_result");
                    if (!Util.isNullOrNil(stringExtra)) {
                        Log.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:".concat(String.valueOf(stringExtra)));
                        this.ktA.setValStr(stringExtra);
                    }
                    String stringExtra2 = intent.getStringExtra("kpost_code");
                    if (!Util.isNullOrNil(stringExtra2)) {
                        Log.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(stringExtra2)));
                        this.ktA.setValStr(stringExtra2);
                    }
                    this.dWN = intent.getStringExtra("kwcode");
                    AppMethodBeat.o(20837);
                    return;
                }
                break;
            case 3:
                if (i3 != -1) {
                    Log.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
                    break;
                }
                break;
        }
        AppMethodBeat.o(20837);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b7d;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        Intent intent = null;
        AppMethodBeat.i(20838);
        Log.i("MicroMsg.AddInvoiceUI", "errType " + i2 + ",errCode " + i3 + ",errMsg " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (i2 != 0 || i3 != 0) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.e5f), getString(R.string.zb), false, (DialogInterface.OnClickListener) null);
        } else if (qVar.getType() == 1180) {
            dqp dqp = ((com.tencent.mm.plugin.address.model.i) qVar).ksS;
            if (!(dqp == null || dqp.MTy == null || dqp.MTy.size() <= 0 || dqp.MTy.get(0) == null)) {
                this.adT = dqp.MTy.get(0).Lqz;
            }
            bg.azz().b(1180, this);
            bg.azz().a(new com.tencent.mm.plugin.address.model.b(), 0);
            AppMethodBeat.o(20838);
            return;
        } else if (qVar.getType() == 1191) {
            bg.azz().b(1191, this);
            if (this.ktF) {
                Log.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
                b bVar = this.ktE;
                if (bVar == null) {
                    Log.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
                } else {
                    intent = new Intent();
                    intent.putExtra("type", bVar.type);
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        intent.putExtra("title", bVar.title);
                        intent.putExtra("tax_number", bVar.ynR);
                        intent.putExtra("company_address", bVar.ynX);
                        intent.putExtra("telephone", bVar.ynV);
                        intent.putExtra("bank_name", bVar.ynT);
                        intent.putExtra("bank_account", bVar.ynS);
                    } else {
                        intent.putExtra("title", bVar.ynQ);
                    }
                }
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(20838);
                return;
            }
            if (this.ktp == 0 && this.adT != 0) {
                Intent intent2 = new Intent();
                intent2.setClass(this, QrcodeInvoiceUI.class);
                intent2.putExtra("invoice_id", this.adT);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.adT = 0;
            }
            finish();
            AppMethodBeat.o(20838);
            return;
        }
        AppMethodBeat.o(20838);
    }

    private boolean bqg() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(20839);
        boolean z3 = true;
        if ((this.ktr != null && this.ktr.isActivated()) || (this.ktD != null && this.ktD.type != null && this.ktD.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            this.kty.setVisibility(0);
            this.ktz.setVisibility(0);
            this.ktA.setVisibility(0);
            this.ktB.setVisibility(0);
            this.ktC.setVisibility(0);
            this.ktw.setVisibility(0);
            this.ktx.setVisibility(8);
            if (!this.ktr.isActivated() && !this.ktD.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                z3 = false;
            }
            if (!this.ktw.bql()) {
                if (this.ktw.getText().length() > 100) {
                    aJ(getString(R.string.e5l), 100);
                }
                z3 = false;
            }
            if (this.ktr == null || !this.ktr.isActivated() || this.ktw.getText().length() != 0) {
                z = z3;
            } else {
                z = false;
            }
            enableOptionMenu(z);
            if (!this.kty.bql()) {
                if (this.kty.getText().length() > 0) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.j8_);
                    if (viewStub != null) {
                        viewStub.inflate();
                        this.kts = (TextView) findViewById(R.id.j89);
                    }
                    if (this.kts != null) {
                        this.kts.setVisibility(0);
                    }
                }
            } else if (this.kts != null) {
                this.kts.setVisibility(8);
            }
            if (!this.ktz.bql()) {
                if (this.ktz.getText().length() > 100) {
                    aJ(getString(R.string.e51), 100);
                }
                z = false;
            }
            if (!this.ktA.bql()) {
                if (this.ktA.getText().length() > 100) {
                    aJ(getString(R.string.e5b), 100);
                }
                z = false;
            }
            if (!this.ktB.bql()) {
                if (this.ktB.getText().length() > 100) {
                    aJ(getString(R.string.e4u), 100);
                }
                z = false;
            }
            if (this.ktC.bql()) {
                z2 = z;
            } else if (this.ktC.getText().length() > 48) {
                aJ(getString(R.string.e4w), 39);
            }
        } else if ((this.ktq == null || !this.ktq.isActivated()) && (this.ktD == null || this.ktD.type == null || !this.ktD.type.equals("1"))) {
            this.kty.setVisibility(0);
            this.ktz.setVisibility(0);
            this.ktA.setVisibility(0);
            this.ktB.setVisibility(0);
            this.ktC.setVisibility(0);
            this.ktx.setVisibility(8);
            this.ktw.setVisibility(0);
            this.ktx.setVisibility(8);
            if (this.ktq != null && !this.ktq.isActivated() && this.ktr != null && !this.ktr.isActivated()) {
                z3 = false;
            }
            if (!this.ktw.bql()) {
                z3 = false;
            }
            if (!this.kty.bql()) {
                z3 = false;
            }
            if (!this.ktz.bql()) {
                z3 = false;
            }
            if (!this.ktA.bql()) {
                z3 = false;
            }
            if (!this.ktB.bql()) {
                z3 = false;
            }
            if (this.ktC.bql()) {
                z2 = z3;
            }
        } else {
            this.kty.setVisibility(8);
            this.ktz.setVisibility(8);
            this.ktA.setVisibility(8);
            this.ktB.setVisibility(8);
            this.ktC.setVisibility(8);
            this.ktw.setVisibility(8);
            this.ktx.setVisibility(0);
            if (!this.ktq.isActivated() && !this.ktD.type.equals("1")) {
                z3 = false;
            }
            if (!this.ktx.bql()) {
                if (this.ktx.getText().length() > 100) {
                    aJ(getString(R.string.e5l), 100);
                }
                z3 = false;
            }
            if (this.ktq != null && this.ktq.isActivated() && this.ktx.getText().length() == 0) {
                z3 = false;
            }
            enableOptionMenu(z3);
            z2 = z3;
        }
        AppMethodBeat.o(20839);
        return z2;
    }

    @Override // com.tencent.mm.plugin.address.ui.InvoiceEditView.c
    public final void bqh() {
        AppMethodBeat.i(20840);
        bqg();
        AppMethodBeat.o(20840);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(20841);
        if (i2 == 4) {
            bqi();
            AppMethodBeat.o(20841);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(20841);
        return onKeyUp;
    }

    private void bqi() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(20842);
        if ((this.ktp == 0 || this.ktD == null || this.ktE.type == null || this.ktE.type.equals("") || this.ktE.type.equals(this.ktD.type)) && (this.ktp != 0 || this.ktE.type == null || this.ktE.type.equals(""))) {
            z = false;
        } else {
            z = true;
        }
        if (this.ktq != null && this.ktr != null && !this.ktq.isActivated() && !this.ktr.isActivated() && this.ktD == null) {
            z = true;
        }
        if (this.ktw.bqm()) {
            z = true;
        }
        if (this.ktx.bqm()) {
            z = true;
        }
        if (this.kty.bqm()) {
            z = true;
        }
        if (this.ktz.bqm()) {
            z = true;
        }
        if (this.ktA.bqm()) {
            z = true;
        }
        if (this.ktB.bqm()) {
            z = true;
        }
        if (!this.ktC.bqm()) {
            z2 = z;
        }
        if (z2) {
            com.tencent.mm.ui.base.h.a((Context) this, false, getContext().getString(R.string.e4t), "", getContext().getString(R.string.e4s), getContext().getString(R.string.e4r), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.address.ui.AddInvoiceUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(20832);
                    AddInvoiceUI.this.setResult(0);
                    AddInvoiceUI.this.finish();
                    AppMethodBeat.o(20832);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(20842);
            return;
        }
        setResult(0);
        finish();
        AppMethodBeat.o(20842);
    }

    private void aJ(String str, int i2) {
        AppMethodBeat.i(20843);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.e4z, new Object[]{str, Integer.valueOf(i2)}), getString(R.string.zb), false, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(20843);
    }

    public final void bqj() {
        AppMethodBeat.i(20844);
        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.e5m), getString(R.string.zb), false, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(20844);
    }

    static /* synthetic */ void o(AddInvoiceUI addInvoiceUI) {
        AppMethodBeat.i(20847);
        bg.azz().a(new com.tencent.mm.plugin.address.model.i(addInvoiceUI.ktE), 0);
        bg.azz().a(1180, addInvoiceUI);
        if (addInvoiceUI.ktp != 0) {
            Log.i("MicroMsg.AddInvoiceUI", "modify save invoice " + addInvoiceUI.ktE.toString());
        }
        addInvoiceUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) addInvoiceUI, "", true, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(20847);
    }
}
