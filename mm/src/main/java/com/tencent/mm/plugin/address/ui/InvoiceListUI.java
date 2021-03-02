package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvoiceListUI extends MMActivity implements i {
    private ListView hUI;
    private boolean ktF = false;
    private TextView ktu = null;
    private b kug;
    private a kuh;
    private com.tencent.mm.plugin.address.b.b.a kui = null;
    private TextView kuj = null;
    private LinkedList<b> kuk = new LinkedList<>();
    private boolean kul = false;
    private boolean kum = false;
    private Object lockObj = new Object();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public InvoiceListUI() {
        AppMethodBeat.i(20912);
        AppMethodBeat.o(20912);
    }

    static /* synthetic */ void a(InvoiceListUI invoiceListUI, int i2) {
        AppMethodBeat.i(20922);
        invoiceListUI.vq(i2);
        AppMethodBeat.o(20922);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20913);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.ktF = intent.getBooleanExtra("launch_from_webview", false);
        this.kul = intent.getBooleanExtra("launch_from_appbrand", false);
        if (this.ktF || this.kul) {
            this.ktF = true;
        }
        if (this.ktF) {
            bg.aVF();
            boolean booleanValue = ((Boolean) c.azQ().get(ar.a.USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
            Log.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(booleanValue)));
            if (booleanValue) {
                Log.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
                h.a((Context) this, getString(R.string.e5j), getString(R.string.e5k), getString(R.string.f3148e), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.address.ui.InvoiceListUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(20906);
                        Log.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
                        dialogInterface.dismiss();
                        AppMethodBeat.o(20906);
                    }
                });
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.FALSE);
            }
        }
        setMMTitle(R.string.grc);
        bg.azz().a(1194, this);
        bg.azz().a(1191, this);
        initView();
        bqn();
        AppMethodBeat.o(20913);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(20914);
        bg.azz().b(1194, this);
        bg.azz().b(1191, this);
        super.onDestroy();
        AppMethodBeat.o(20914);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(20915);
        bg.azz().a(new com.tencent.mm.plugin.address.model.b(), 0);
        super.onResume();
        AppMethodBeat.o(20915);
    }

    private void bqn() {
        AppMethodBeat.i(20916);
        synchronized (this.lockObj) {
            try {
                com.tencent.mm.plugin.address.a.a.bqb();
                this.kuk = com.tencent.mm.plugin.address.a.a.bqc().ksN.ynO;
                this.kuh.iHf = this.kuk;
                this.kuk.size();
                this.kuh.notifyDataSetChanged();
            } finally {
                AppMethodBeat.o(20916);
            }
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(20917);
        this.kuj = (TextView) findViewById(R.id.dxo);
        if (this.kuj != null) {
            this.kuj.setVisibility(8);
        }
        if (this.ktF) {
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
        this.kuj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceListUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(20900);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                InvoiceListUI.a(InvoiceListUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20900);
            }
        });
        this.hUI = (ListView) findViewById(R.id.hmr);
        this.kuh = new a(this);
        this.hUI.setAdapter((ListAdapter) this.kuh);
        this.hUI.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceListUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(20901);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(i2)));
                synchronized (InvoiceListUI.this.lockObj) {
                    try {
                        if (i2 < InvoiceListUI.this.kuk.size()) {
                            InvoiceListUI.this.kug = (b) InvoiceListUI.this.kuk.get(i2);
                            if (!InvoiceListUI.this.ktF && InvoiceListUI.this.kug != null) {
                                InvoiceListUI.a(InvoiceListUI.this, InvoiceListUI.this.kug.ynP);
                            } else if (!(InvoiceListUI.this.kug == null || InvoiceListUI.this.kug.ynP == 0)) {
                                Intent intent = new Intent();
                                intent.putExtra("choose_invoice_title_info", e.a(InvoiceListUI.this.kug));
                                InvoiceListUI.this.setResult(-1, intent);
                                InvoiceListUI.this.finish();
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(20901);
                        throw th;
                    }
                }
                InvoiceListUI.this.kuh.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(20901);
            }
        });
        this.hUI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceListUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i2, long j2) {
                AppMethodBeat.i(20903);
                h.a(InvoiceListUI.this.getContext(), (String) null, InvoiceListUI.this.getResources().getStringArray(R.array.n), (String) null, new h.d() {
                    /* class com.tencent.mm.plugin.address.ui.InvoiceListUI.AnonymousClass3.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        b bVar;
                        AppMethodBeat.i(20902);
                        synchronized (InvoiceListUI.this.lockObj) {
                            try {
                                if (i2 < InvoiceListUI.this.kuk.size()) {
                                    bVar = (b) InvoiceListUI.this.kuk.get(i2);
                                } else {
                                    bVar = null;
                                }
                            } finally {
                                AppMethodBeat.o(20902);
                            }
                        }
                        if (bVar == null) {
                            AppMethodBeat.o(20902);
                            return;
                        }
                        switch (i2) {
                            case 0:
                                InvoiceListUI.a(InvoiceListUI.this, bVar.ynP);
                                AppMethodBeat.o(20902);
                                return;
                            case 1:
                                com.tencent.mm.plugin.address.model.a aVar = new com.tencent.mm.plugin.address.model.a(bVar.ynP);
                                InvoiceListUI.this.kug = null;
                                bg.azz().a(aVar, 0);
                                AppMethodBeat.o(20902);
                                return;
                            case 2:
                                InvoiceListUI.b(InvoiceListUI.this, bVar);
                                break;
                        }
                    }
                });
                AppMethodBeat.o(20903);
                return true;
            }
        });
        this.kuh.notifyDataSetChanged();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceListUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20904);
                InvoiceListUI.this.setResult(0);
                InvoiceListUI.this.finish();
                AppMethodBeat.o(20904);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.gn8, R.raw.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.InvoiceListUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(20905);
                InvoiceListUI.a(InvoiceListUI.this);
                AppMethodBeat.o(20905);
                return true;
            }
        });
        AppMethodBeat.o(20917);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awb;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(20918);
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 1191) {
                bqn();
                if (this.ktF) {
                    com.tencent.mm.plugin.address.a.a.bqb();
                    if (com.tencent.mm.plugin.address.a.a.bqc().ksN.ynO.size() == 0 && !this.kum) {
                        Intent intent = new Intent();
                        intent.setClass(this, AddInvoiceUI.class);
                        intent.putExtra("launch_from_webview", true);
                        startActivityForResult(intent, 1);
                        AppMethodBeat.o(20918);
                        return;
                    }
                }
            } else if (qVar.getType() == 1194) {
                bg.azz().a(new com.tencent.mm.plugin.address.model.b(), 0);
                this.kum = true;
            }
        }
        AppMethodBeat.o(20918);
    }

    public class a extends BaseAdapter {
        private final Context context;
        List<b> iHf = new ArrayList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(20911);
            b vr = vr(i2);
            AppMethodBeat.o(20911);
            return vr;
        }

        public a(Context context2) {
            AppMethodBeat.i(20907);
            this.context = context2;
            AppMethodBeat.o(20907);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C0527a aVar;
            AppMethodBeat.i(20908);
            C0527a aVar2 = new C0527a();
            if (view == null) {
                view = View.inflate(this.context, R.layout.c7e, null);
                aVar2.kup = (ImageView) view.findViewById(R.id.b0d);
                aVar2.hXC = (TextView) view.findViewById(R.id.h5);
                aVar2.gxs = (TextView) view.findViewById(R.id.hj);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C0527a) view.getTag();
            }
            b vr = vr(i2);
            if (vr.type != null && vr.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                aVar.hXC.setText(R.string.e53);
                aVar.gxs.setText(vr.title);
            } else if (vr.type != null && vr.type.equals("1")) {
                aVar.hXC.setText(R.string.e59);
                aVar.gxs.setText(vr.ynQ);
            }
            if (!InvoiceListUI.this.ktF || InvoiceListUI.this.kug == null || InvoiceListUI.this.kug.ynP != vr.ynP) {
                aVar.kup.setImageBitmap(null);
            } else {
                aVar.kup.setImageResource(R.raw.radio_on);
            }
            AppMethodBeat.o(20908);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.i(20909);
            int size = this.iHf.size();
            AppMethodBeat.o(20909);
            return size;
        }

        private b vr(int i2) {
            AppMethodBeat.i(20910);
            b bVar = this.iHf.get(i2);
            AppMethodBeat.o(20910);
            return bVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$a$a  reason: collision with other inner class name */
        class C0527a {
            TextView gxs;
            TextView hXC;
            ImageView kup;

            C0527a() {
            }
        }
    }

    private void vq(int i2) {
        AppMethodBeat.i(20919);
        Intent intent = new Intent();
        if (i2 != 0) {
            intent.setClass(this, QrcodeInvoiceUI.class);
            intent.putExtra("invoice_id", i2);
        } else {
            intent.setClass(this, AddInvoiceUI.class);
            intent.putExtra("launch_from_invoicelist_webview", this.ktF);
            intent.putExtra("invoice_id", i2);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(20919);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        b bVar;
        AppMethodBeat.i(20920);
        if (i2 == 1) {
            if (-1 == i3) {
                if (intent == null) {
                    Log.e("MicroMsg.InvoiceUtil", "intent is null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.type = intent.getStringExtra("type");
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        bVar.title = intent.getStringExtra("title");
                        bVar.ynR = intent.getStringExtra("tax_number");
                        bVar.ynX = intent.getStringExtra("company_address");
                        bVar.ynV = intent.getStringExtra("telephone");
                        bVar.ynT = intent.getStringExtra("bank_name");
                        bVar.ynS = intent.getStringExtra("bank_account");
                    } else {
                        bVar.ynQ = intent.getStringExtra("title");
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtra("choose_invoice_title_info", e.a(bVar));
                setResult(-1, intent2);
            } else {
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.o(20920);
    }

    static /* synthetic */ void a(InvoiceListUI invoiceListUI) {
        AppMethodBeat.i(20921);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14199, 2);
        invoiceListUI.vq(0);
        AppMethodBeat.o(20921);
    }

    static /* synthetic */ void b(InvoiceListUI invoiceListUI, b bVar) {
        AppMethodBeat.i(20923);
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            if (bVar.type != null && bVar.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                if (!TextUtils.isEmpty(bVar.title)) {
                    sb.append(invoiceListUI.getString(R.string.e5l));
                    sb.append("：");
                    sb.append(bVar.title);
                    sb.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.ynR)) {
                    sb.append(invoiceListUI.getString(R.string.e5g));
                    sb.append("：");
                    sb.append(bVar.ynR);
                    sb.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.ynX)) {
                    sb.append(invoiceListUI.getString(R.string.e51));
                    sb.append("：");
                    sb.append(bVar.ynX);
                    sb.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.ynV)) {
                    sb.append(invoiceListUI.getString(R.string.e5b));
                    sb.append("：");
                    sb.append(bVar.ynV);
                    sb.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.ynT)) {
                    sb.append(invoiceListUI.getString(R.string.e4u));
                    sb.append("：");
                    sb.append(bVar.ynT);
                    sb.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.ynS)) {
                    sb.append(invoiceListUI.getString(R.string.e4w));
                    sb.append("：");
                    sb.append(bVar.ynS);
                    sb.append(" \n");
                }
            } else if (bVar.type != null && bVar.type.equals("1") && !TextUtils.isEmpty(bVar.ynQ)) {
                sb.append(invoiceListUI.getString(R.string.e5l));
                sb.append("：");
                sb.append(bVar.ynQ);
                sb.append(" \n");
            }
            try {
                invoiceListUI.getContext();
                d.TF(sb.toString());
                AppMethodBeat.o(20923);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.InvoiceListUI", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(20923);
    }
}
