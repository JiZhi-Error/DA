package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.model.d;
import com.tencent.mm.plugin.recharge.model.e;
import com.tencent.mm.plugin.recharge.ui.MallEditText;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI extends MMActivity implements i, u.a, MallEditText.b {
    private TextView BEI = null;
    private TextView BEJ = null;
    private TextView BEK = null;
    private TextView BEL = null;
    private FrameLayout BEM = null;
    private ImageView BEN = null;
    private ImageView BEO = null;
    private LinearLayout BEP = null;
    private a BEQ = null;
    private a BER = null;
    private MallEditText BES;
    private TextView BET;
    private int BEU;
    private MallRechargeProduct BEV = null;
    private String BEW = null;
    private MallNews BEX = null;
    private boolean BEY = false;
    private Map<String, Integer> BEZ = new HashMap();
    private MallFunction BEt = null;
    private String BFa;
    public String BFb;
    private String BFc;
    public String BFd;
    private boolean BaO = false;
    private IListener BaR = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass10 */

        {
            AppMethodBeat.i(160832);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160832);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(67224);
            aaa aaa2 = aaa;
            if (!(aaa2 instanceof aaa)) {
                Log.f("MicroMsg.MallRechargeUI", "mismatched event");
                AppMethodBeat.o(67224);
                return false;
            } else if (aaa2.egJ.egL) {
                Log.f("MicroMsg.MallRechargeUI", "WalletPayResultEvent is from kinda, ScanQRCodePay");
                AppMethodBeat.o(67224);
                return false;
            } else {
                if (aaa2.egJ.result != -1) {
                    Log.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                } else if (!RechargeUI.this.BaO) {
                    Log.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                    com.tencent.mm.plugin.recharge.a.a.eHL().a(RechargeUI.this.BES.getInputRecord());
                    RechargeUI.this.finish();
                    RechargeUI.this.BaO = true;
                }
                AppMethodBeat.o(67224);
                return true;
            }
        }
    };
    private Button krs = null;
    private boolean mDr = true;
    protected Dialog tipDialog = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RechargeUI() {
        AppMethodBeat.i(67240);
        AppMethodBeat.o(67240);
    }

    static /* synthetic */ String M(int i2, String str, String str2) {
        AppMethodBeat.i(67271);
        String L = L(i2, str, str2);
        AppMethodBeat.o(67271);
        return L;
    }

    static /* synthetic */ boolean b(RechargeUI rechargeUI) {
        AppMethodBeat.i(67266);
        boolean bqg = rechargeUI.bqg();
        AppMethodBeat.o(67266);
        return bqg;
    }

    static /* synthetic */ void l(RechargeUI rechargeUI) {
        AppMethodBeat.i(67269);
        rechargeUI.updateView();
        AppMethodBeat.o(67269);
    }

    static /* synthetic */ String m(RechargeUI rechargeUI) {
        AppMethodBeat.i(67270);
        String eIc = rechargeUI.eIc();
        AppMethodBeat.o(67270);
        return eIc;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.blh;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67241);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.BEt = (MallFunction) intent.getParcelableExtra("key_func_info");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_product_list");
        this.mDr = !intent.getBooleanExtra("key_is_hide_progress", false);
        if (this.BEt == null) {
            Log.e("MicroMsg.MallRechargeUI", "function info is null");
            com.tencent.mm.ui.base.u.makeText(this, "function info is null", 1).show();
            AppMethodBeat.o(67241);
            return;
        }
        if (parcelableArrayListExtra == null) {
            Log.d("MicroMsg.MallRechargeUI", "function info : " + this.BEt.edq);
            n(new e(this.BEt.kHR));
        } else {
            this.BEV = a.gb(parcelableArrayListExtra);
        }
        Log.i("MicroMsg.MallRechargeUI", "onCreate()");
        this.BEX = c.fSg().aVv(this.BEt.kHR);
        initView();
        AppMethodBeat.o(67241);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67242);
        setMMTitle(this.BEt.edq);
        Log.v("MicroMsg.MallRechargeUI", "initView");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67216);
                RechargeUI.this.hideVKB();
                RechargeUI.this.finish();
                AppMethodBeat.o(67216);
                return true;
            }
        });
        this.BEI = (TextView) findViewById(R.id.f91);
        this.BEJ = (TextView) findViewById(R.id.f_b);
        this.BEK = (TextView) findViewById(R.id.f_d);
        this.krs = (Button) findViewById(R.id.fz0);
        this.BEP = (LinearLayout) findViewById(R.id.f7_);
        this.BEL = (TextView) findViewById(R.id.f_c);
        this.BEL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(67225);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", RechargeUI.this.BFc);
                com.tencent.mm.br.c.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67225);
            }
        });
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(67226);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (RechargeUI.b(RechargeUI.this) && RechargeUI.c(RechargeUI.this)) {
                    RechargeUI.d(RechargeUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67226);
            }
        });
        this.BES = (MallEditText) findViewById(R.id.f7c);
        this.BES.setInfoTvOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(67227);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (RechargeUI.this.BES.BDE) {
                    RechargeUI.this.BES.setInput(null);
                } else {
                    RechargeUI.this.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67227);
            }
        });
        this.BET = (TextView) findViewById(R.id.f96);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_product_list");
        List<MallRechargeProduct> q = q(0, parcelableArrayListExtra);
        List<MallRechargeProduct> q2 = q(2, parcelableArrayListExtra);
        this.BEU = q.size() > q2.size() ? q.size() : q2.size();
        this.BEQ = new a(this, (byte) 0);
        this.BEQ.gd(q);
        this.BER = new a(this, (byte) 0);
        this.BER.gd(q2);
        this.BEP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(67228);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if ((RechargeUI.this.BEQ != null && RechargeUI.this.BEQ.getCount() > 0) || (RechargeUI.this.BER != null && RechargeUI.this.BER.getCount() > 0)) {
                    RechargeUI.this.showDialog(1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67228);
            }
        });
        this.BEM = (FrameLayout) findViewById(R.id.f_9);
        this.BEN = (ImageView) findViewById(R.id.f_a);
        this.BEO = (ImageView) findViewById(R.id.f__);
        this.BEO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(67229);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c fSg = c.fSg();
                String str = RechargeUI.this.BEt.kHR;
                Log.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
                if (!Util.isNullOrNil(str) && fSg.Icv.containsKey(str)) {
                    MallNews mallNews = fSg.Icv.get(str);
                    if ("1".equals(mallNews.Icl)) {
                        mallNews.Icl = "2";
                        fSg.eDw();
                    }
                }
                RechargeUI.this.BEM.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67229);
            }
        });
        this.BEM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(67230);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!Util.isNullOrNil(RechargeUI.this.BEt.Icf.Ico)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", RechargeUI.this.BEt.Icf.Ico);
                    intent.putExtra("geta8key_username", z.aTY());
                    com.tencent.mm.br.c.b(RechargeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67230);
            }
        });
        this.BES.setOnInputValidChangeListener(this);
        this.BES.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(67231);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RechargeUI.this.BES.getFocus();
                if (RechargeUI.this.BES.getInputRecord().sourceType == 2) {
                    RechargeUI.this.BES.setInput(null);
                }
                if (Util.isNullOrNil(RechargeUI.this.BES.getText().toString())) {
                    RechargeUI.this.BES.BDD.showDropDown();
                }
                RechargeUI.this.showVKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67231);
            }
        });
        eHR();
        u.a(this);
        updateView();
        AppMethodBeat.o(67242);
    }

    private void updateView() {
        AppMethodBeat.i(67243);
        Log.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.BEV);
        if (this.BEV != null) {
            this.BET.setText(this.BEV.rjt);
            this.BEK.setText(a(this.BEV));
        }
        if (this.BEX != null && this.BEt.Icf != null && this.BEX.equals(this.BEt.Icf) && !"1".equals(this.BEX.Icl)) {
            this.BEM.setVisibility(8);
            Log.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.BEX.toString());
        } else if (this.BEt.Icf == null || Util.isNullOrNil(this.BEt.Icf.Icp)) {
            this.BEM.setVisibility(8);
            Log.d("MicroMsg.MallRechargeUI", "dismiss banner!");
        } else {
            this.BEW = this.BEt.Icf.Icp;
            this.BEN.setImageBitmap(u.a(new com.tencent.mm.plugin.recharge.b.a(this.BEW)));
            this.BEM.setVisibility(0);
            Log.d("MicroMsg.MallRechargeUI", "Show banner!");
        }
        this.BEJ.setVisibility(4);
        if (!bqg()) {
            this.BEI.setText("");
        } else if (this.BEV != null && !eId()) {
            this.BEI.setText(this.BEV.BCZ);
            this.BEI.setTextColor(getResources().getColor(R.color.uj));
        }
        eHZ();
        eIa();
        AppMethodBeat.o(67243);
    }

    private void eHZ() {
        AppMethodBeat.i(67244);
        String string = getString(R.string.exk);
        if (!TextUtils.isEmpty(this.BFb)) {
            string = this.BFb;
        }
        if (!Util.isNullOrNil(this.BFa)) {
            addTextOptionMenu(0, string, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass18 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(67232);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", RechargeUI.this.BFa);
                    com.tencent.mm.br.c.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(67232);
                    return true;
                }
            });
        }
        AppMethodBeat.o(67244);
    }

    private void eIa() {
        AppMethodBeat.i(67245);
        if (!Util.isNullOrNil(this.BFc)) {
            this.BEL.setVisibility(0);
        } else {
            this.BEL.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.BFd)) {
            this.BEL.setText(this.BFd);
        }
        AppMethodBeat.o(67245);
    }

    private String a(MallRechargeProduct mallRechargeProduct) {
        AppMethodBeat.i(67246);
        if (!mallRechargeProduct.isValid()) {
            String string = getString(R.string.exs);
            AppMethodBeat.o(67246);
            return string;
        } else if (mallRechargeProduct.BDa != mallRechargeProduct.BDb || (eId() && this.BEV.BDf)) {
            AppMethodBeat.o(67246);
            return "";
        } else {
            String format = String.format(getString(R.string.exv), Float.valueOf(mallRechargeProduct.BDa));
            AppMethodBeat.o(67246);
            return format;
        }
    }

    private static List<MallRechargeProduct> q(int i2, List<MallRechargeProduct> list) {
        AppMethodBeat.i(67247);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            boolean z = false;
            for (int i3 = 0; i3 < list.size(); i3++) {
                MallRechargeProduct mallRechargeProduct = list.get(i3);
                if (mallRechargeProduct.iFf == i2) {
                    arrayList.add(mallRechargeProduct);
                    if (mallRechargeProduct.isDefault) {
                        if (z) {
                            mallRechargeProduct.isDefault = false;
                        }
                        z = true;
                    }
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
        }
        AppMethodBeat.o(67247);
        return arrayList;
    }

    private void n(final q qVar) {
        AppMethodBeat.i(67248);
        if (qVar.getType() == 497 || qVar.getType() == 1555) {
            g.aAi();
            g.aAg().hqi.a(qVar, 0);
            AppMethodBeat.o(67248);
        } else if (!this.mDr) {
            g.aAi();
            g.aAg().hqi.a(qVar, 0);
            AppMethodBeat.o(67248);
        } else {
            if (this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing())) {
                this.tipDialog = h.a((Context) getContext(), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(67218);
                        g.aAi();
                        g.aAg().hqi.a(qVar);
                        AppMethodBeat.o(67218);
                    }
                });
            }
            g.aAi();
            g.aAg().hqi.a(qVar, 0);
            AppMethodBeat.o(67248);
        }
    }

    private boolean bqg() {
        boolean z;
        AppMethodBeat.i(67249);
        if (!this.BES.eHQ()) {
            z = false;
        } else {
            z = true;
        }
        if (!z || this.BEV == null || !this.BEV.isValid()) {
            this.krs.setEnabled(false);
            this.krs.setClickable(false);
            Log.d("MicroMsg.MallRechargeUI", "checkInfo : false");
            AppMethodBeat.o(67249);
            return false;
        }
        if (eId() && this.BEV.BDf) {
            n(new d(this.BEV.iFf, this.BEt.kHR, this.BEV.productId, this.BEV.appId, eIb(), eIc()));
        }
        hideVKB();
        this.krs.setEnabled(true);
        this.krs.setClickable(true);
        Log.d("MicroMsg.MallRechargeUI", "checkInfo : true");
        AppMethodBeat.o(67249);
        return true;
    }

    private String eIb() {
        AppMethodBeat.i(67250);
        String str = "mobile=" + com.tencent.mm.plugin.recharge.model.b.Ts(this.BES.getText());
        AppMethodBeat.o(67250);
        return str;
    }

    private String eIc() {
        AppMethodBeat.i(67251);
        String Ts = com.tencent.mm.plugin.recharge.model.b.Ts(this.BES.getText());
        AppMethodBeat.o(67251);
        return Ts;
    }

    private static String L(int i2, String str, String str2) {
        AppMethodBeat.i(67252);
        String str3 = i2 + "-" + str + "-" + str2;
        AppMethodBeat.o(67252);
        return str3;
    }

    private boolean eId() {
        AppMethodBeat.i(67253);
        if (!this.BEZ.containsKey(L(this.BEV.iFf, this.BEV.productId, eIc()))) {
            AppMethodBeat.o(67253);
            return true;
        }
        AppMethodBeat.o(67253);
        return false;
    }

    @Override // com.tencent.mm.plugin.recharge.ui.MallEditText.b
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(67254);
        if (!z) {
            this.BEZ.clear();
            this.BEI.setText("");
            this.BEJ.setVisibility(4);
        }
        bqg();
        AppMethodBeat.o(67254);
    }

    @Override // com.tencent.mm.plugin.recharge.ui.MallEditText.b
    public final void eHR() {
        AppMethodBeat.i(67255);
        if (Util.isNullOrNil(this.BES.getText()) || this.BES.bql()) {
            this.BES.setInfoTvImageResource(R.drawable.aqm);
            AppMethodBeat.o(67255);
            return;
        }
        this.BES.setInfoTvImageResource(R.drawable.a_5);
        AppMethodBeat.o(67255);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(67256);
        Log.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + i2 + ", errCode = " + i3);
        if (!(this.tipDialog == null || !this.tipDialog.isShowing() || qVar.getType() == 497)) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof e) {
                e eVar = (e) qVar;
                ArrayList<MallRechargeProduct> arrayList = eVar.BDk;
                if (arrayList != null) {
                    this.BEV = a.gb(arrayList);
                    Log.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.BEV);
                }
                this.BFa = eVar.BDl;
                this.BFb = eVar.BDm;
                this.BFc = eVar.BDn;
                this.BFd = eVar.BDo;
                Log.d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(arrayList)));
                updateView();
                List<MallRechargeProduct> q = q(0, arrayList);
                List<MallRechargeProduct> q2 = q(2, arrayList);
                this.BEU = q.size() > q2.size() ? q.size() : q2.size();
                this.BEQ.gd(q);
                this.BER.gd(q2);
                AppMethodBeat.o(67256);
                return;
            } else if (qVar instanceof d) {
                Log.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.BEV);
                d dVar = (d) qVar;
                if (!(this.BEV == null || this.BEV.productId == null || dVar.BDh == null || ((!this.BEV.productId.equals(dVar.BDh.productId) || !eIc().equals(dVar.kik)) && dVar.iFf == 2))) {
                    MallRechargeProduct.a(dVar.BDh, this.BEV);
                    this.BEV.isDefault = true;
                    this.BEZ.put(L(dVar.iFf, dVar.BDh.productId, dVar.kik), 1);
                    updateView();
                    this.BEJ.setText(str);
                    this.BEJ.setVisibility(0);
                    this.BEJ.setTextColor(getResources().getColor(R.color.tw));
                }
                if (dVar.iFf == 2) {
                    if (this.BEV == null || !this.BEV.productId.equals(dVar.BDj) || !eIc().equals(dVar.kik)) {
                        this.krs.setEnabled(true);
                        this.krs.setClickable(true);
                        this.BEJ.setText((CharSequence) null);
                    } else if (((bpb) dVar.rr.iLL.iLR).LOv != 0 || !this.BEV.productId.equals(dVar.BDh.productId)) {
                        this.krs.setEnabled(false);
                        this.krs.setClickable(false);
                        this.BEJ.setText(((bpb) dVar.rr.iLL.iLR).LOw);
                        this.BEJ.setVisibility(0);
                        this.BEJ.setTextColor(getResources().getColor(R.color.a5c));
                    } else {
                        n(new com.tencent.mm.plugin.recharge.model.c(this.BEV.kHR, eIc(), this.BEV.rjt, this.BEV.appId, eIb()));
                    }
                }
                gc(dVar.BDi);
                Log.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.BEV);
                AppMethodBeat.o(67256);
                return;
            } else if (qVar instanceof com.tencent.mm.plugin.recharge.model.g) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) qVar).BDB;
                payInfo.dVv = 6;
                payInfo.Kxr = 100;
                f.a(this, payInfo, 2);
                EventCenter.instance.addListener(this.BaR);
                AppMethodBeat.o(67256);
                return;
            } else if (qVar instanceof com.tencent.mm.plugin.recharge.model.c) {
                com.tencent.mm.plugin.recharge.model.c cVar = (com.tencent.mm.plugin.recharge.model.c) qVar;
                if (this.BEV == null || !this.BEV.rjt.equals(cVar.rjt) || !eIc().equals(cVar.dSf)) {
                    this.krs.setEnabled(true);
                    this.krs.setClickable(true);
                    this.BEJ.setText((CharSequence) null);
                } else if (((ber) cVar.rr.iLL.iLR).LOv != 0) {
                    this.krs.setEnabled(false);
                    this.krs.setClickable(false);
                    this.BEJ.setText(((ber) cVar.rr.iLL.iLR).LOw);
                    this.BEJ.setVisibility(0);
                    this.BEJ.setTextColor(getResources().getColor(R.color.a5c));
                    AppMethodBeat.o(67256);
                    return;
                }
                AppMethodBeat.o(67256);
                return;
            }
        } else if (!(qVar instanceof com.tencent.mm.plugin.recharge.model.c)) {
            if (qVar instanceof d) {
                if (i3 == 100) {
                    this.krs.setEnabled(true);
                    this.krs.setClickable(true);
                } else {
                    this.krs.setEnabled(false);
                    this.krs.setClickable(false);
                }
                gc(((d) qVar).BDi);
                this.BEJ.setText(str);
                this.BEJ.setVisibility(0);
                this.BEJ.setTextColor(getResources().getColor(R.color.a5c));
                this.BEI.setText(((d) qVar).BCZ);
                this.BEI.setTextColor(getResources().getColor(R.color.a5c));
                AppMethodBeat.o(67256);
                return;
            }
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.itf);
            }
            com.tencent.mm.ui.base.h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
        AppMethodBeat.o(67256);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(67257);
        super.onResume();
        g.aAi();
        g.aAg().hqi.a(m.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(1555, this);
        AppMethodBeat.o(67257);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(67258);
        super.onPause();
        g.aAi();
        g.aAg().hqi.b(m.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(1555, this);
        AppMethodBeat.o(67258);
    }

    private void gc(List<MallRechargeProduct> list) {
        AppMethodBeat.i(67259);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = list.get(i2);
                if (mallRechargeProduct.iFf == 2) {
                    if (this.BEV != null && mallRechargeProduct.productId.equals(this.BEV.productId)) {
                        mallRechargeProduct.isDefault = true;
                        z = true;
                    }
                    arrayList.add(mallRechargeProduct);
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
            this.BER.gd(arrayList);
            AppMethodBeat.o(67259);
            return;
        }
        this.BER.gd(new ArrayList());
        AppMethodBeat.o(67259);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private List<MallRechargeProduct> BDi;

        private a() {
            this.BDi = null;
        }

        /* synthetic */ a(RechargeUI rechargeUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(67239);
            MallRechargeProduct Vs = Vs(i2);
            AppMethodBeat.o(67239);
            return Vs;
        }

        public final void gd(List<MallRechargeProduct> list) {
            AppMethodBeat.i(67233);
            this.BDi = list;
            notifyDataSetChanged();
            AppMethodBeat.o(67233);
        }

        public final void Vr(int i2) {
            AppMethodBeat.i(67234);
            for (int i3 = 0; i3 < this.BDi.size(); i3++) {
                this.BDi.get(i3).isDefault = false;
            }
            this.BDi.get(i2).isDefault = true;
            AppMethodBeat.o(67234);
        }

        public final int getCount() {
            AppMethodBeat.i(67235);
            if (this.BDi == null) {
                AppMethodBeat.o(67235);
                return 0;
            }
            int size = this.BDi.size();
            AppMethodBeat.o(67235);
            return size;
        }

        public final MallRechargeProduct Vs(int i2) {
            AppMethodBeat.i(67236);
            MallRechargeProduct mallRechargeProduct = this.BDi.get(i2);
            AppMethodBeat.o(67236);
            return mallRechargeProduct;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final boolean isEnabled(int i2) {
            AppMethodBeat.i(67237);
            if (!Vs(i2).isValid()) {
                AppMethodBeat.o(67237);
                return false;
            }
            boolean isEnabled = super.isEnabled(i2);
            AppMethodBeat.o(67237);
            return isEnabled;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(67238);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(RechargeUI.this, R.layout.ble, null);
            MallRechargeProduct Vs = Vs(i2);
            checkedTextView.setText(Vs.rjt);
            checkedTextView.setEnabled(Vs.isValid());
            if (Vs.isDefault) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            AppMethodBeat.o(67238);
            return checkedTextView;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013d  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
        // Method dump skipped, instructions count: 386
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recharge.ui.RechargeUI.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(67261);
        EventCenter.instance.removeListener(this.BaR);
        super.onDestroy();
        AppMethodBeat.o(67261);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(67262);
        if (this.BEW == null) {
            AppMethodBeat.o(67262);
            return;
        }
        if (str.equals(this.BEW)) {
            this.BEN.post(new Runnable() {
                /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(67223);
                    RechargeUI.this.BEN.setImageBitmap(bitmap);
                    AppMethodBeat.o(67223);
                }
            });
        }
        AppMethodBeat.o(67262);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public void showVKB() {
        AppMethodBeat.i(67263);
        Log.d("MicroMsg.MallRechargeUI", "showVKB");
        this.BES.setInfoTvImageResource(R.drawable.a_5);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(67263);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(67263);
        } else if (currentFocus.getWindowToken() == null) {
            AppMethodBeat.o(67263);
        } else {
            inputMethodManager.showSoftInput(currentFocus, 2);
            AppMethodBeat.o(67263);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public void hideVKB() {
        AppMethodBeat.i(67264);
        Log.d("MicroMsg.MallRechargeUI", "hideVKB");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(67264);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(67264);
            return;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(67264);
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        AppMethodBeat.o(67264);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(67265);
        switch (i2) {
            case 1:
                final int color = getResources().getColor(R.color.aeq);
                final int color2 = getResources().getColor(R.color.afp);
                View inflate = getLayoutInflater().inflate(R.layout.bld, (ViewGroup) null);
                final TextView textView = (TextView) inflate.findViewById(R.id.gun);
                final ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.gur);
                final ListViewInScrollView listViewInScrollView2 = (ListViewInScrollView) inflate.findViewById(R.id.guv);
                final TextView textView2 = (TextView) inflate.findViewById(R.id.guo);
                final View findViewById = inflate.findViewById(R.id.guq);
                final TextView textView3 = (TextView) inflate.findViewById(R.id.gus);
                final View findViewById2 = inflate.findViewById(R.id.guu);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.gv7);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = (getResources().getDimensionPixelSize(R.dimen.j5) * this.BEU) + 4;
                relativeLayout.setLayoutParams(layoutParams);
                listViewInScrollView.setAdapter((ListAdapter) this.BEQ);
                listViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass5 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(67219);
                        b bVar = new b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        RechargeUI.this.dismissDialog(1);
                        Log.d("MicroMsg.MallRechargeUI", "onItemClick : ".concat(String.valueOf(i2)));
                        Log.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.BEV);
                        RechargeUI.this.BEV = RechargeUI.this.BEQ.Vs(i2);
                        RechargeUI.this.BEQ.Vr(i2);
                        RechargeUI.this.BEQ.notifyDataSetChanged();
                        Log.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.BEV);
                        RechargeUI.l(RechargeUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(67219);
                    }
                });
                listViewInScrollView2.setAdapter((ListAdapter) this.BER);
                listViewInScrollView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass6 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(67220);
                        b bVar = new b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$14", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        RechargeUI.this.dismissDialog(1);
                        Log.d("MicroMsg.MallRechargeUI", "onItemClick : ".concat(String.valueOf(i2)));
                        RechargeUI.this.BEV = RechargeUI.this.BER.Vs(i2);
                        RechargeUI.this.BER.Vr(i2);
                        RechargeUI.this.BER.notifyDataSetChanged();
                        RechargeUI.this.BEZ.remove(RechargeUI.M(RechargeUI.this.BEV.iFf, RechargeUI.this.BEV.productId, RechargeUI.m(RechargeUI.this)));
                        RechargeUI.b(RechargeUI.this);
                        RechargeUI.l(RechargeUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$14", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(67220);
                    }
                });
                inflate.findViewById(R.id.gup).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(67221);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        findViewById.setVisibility(0);
                        textView2.setTextColor(color2);
                        listViewInScrollView.setVisibility(0);
                        findViewById2.setVisibility(8);
                        textView3.setTextColor(color);
                        listViewInScrollView2.setVisibility(8);
                        if (RechargeUI.this.BEQ.getCount() == 0) {
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(67221);
                    }
                });
                inflate.findViewById(R.id.gut).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(67222);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/RechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        findViewById2.setVisibility(0);
                        textView3.setTextColor(color2);
                        listViewInScrollView2.setVisibility(0);
                        findViewById.setVisibility(8);
                        textView2.setTextColor(color);
                        listViewInScrollView.setVisibility(8);
                        if (RechargeUI.this.BER.getCount() == 0) {
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/RechargeUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(67222);
                    }
                });
                if (this.BEQ.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                d.a aVar = new d.a(this);
                aVar.bon(null);
                aVar.hs(inflate);
                aVar.f(null);
                com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
                AppMethodBeat.o(67265);
                return hbn;
            default:
                com.tencent.mm.ui.widget.a.d c2 = com.tencent.mm.ui.base.h.c(this, getString(R.string.exu), "", true);
                AppMethodBeat.o(67265);
                return c2;
        }
    }

    static /* synthetic */ boolean c(RechargeUI rechargeUI) {
        AppMethodBeat.i(67267);
        if (rechargeUI.BES.getInputRecord().sourceType == 0) {
            com.tencent.mm.ui.base.h.c(rechargeUI, rechargeUI.getString(R.string.exn, new Object[]{rechargeUI.BES.getText().toString()}), "", rechargeUI.getString(R.string.a0_), rechargeUI.getString(R.string.x6), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.recharge.ui.RechargeUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(67217);
                    RechargeUI.d(RechargeUI.this);
                    AppMethodBeat.o(67217);
                }
            }, null);
            AppMethodBeat.o(67267);
            return false;
        }
        AppMethodBeat.o(67267);
        return true;
    }

    static /* synthetic */ void d(RechargeUI rechargeUI) {
        AppMethodBeat.i(67268);
        rechargeUI.n(new com.tencent.mm.plugin.recharge.model.g(rechargeUI.BEV, rechargeUI.eIb()));
        AppMethodBeat.o(67268);
    }
}
