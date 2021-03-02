package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.n;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.ac;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI extends MMActivity implements com.tencent.mm.plugin.address.c.a {
    private ListView hUI;
    private boolean ktF = false;
    private boolean kuZ;
    private List<b> kvf = new LinkedList();
    private b kvg;
    private a kvh;
    private com.tencent.mm.plugin.address.c.b kvi = null;
    private View kvj;
    private TextView kvk = null;
    private p kvl;
    private boolean kvm = false;
    private boolean kvn = false;
    private d kvo = null;
    private boolean kvp;
    private Object lockObj = new Object();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletSelectAddrUI() {
        AppMethodBeat.i(21037);
        AppMethodBeat.o(21037);
    }

    static /* synthetic */ void a(WalletSelectAddrUI walletSelectAddrUI, int i2) {
        AppMethodBeat.i(21049);
        walletSelectAddrUI.vs(i2);
        AppMethodBeat.o(21049);
    }

    static /* synthetic */ void a(WalletSelectAddrUI walletSelectAddrUI, String str, String str2) {
        AppMethodBeat.i(231583);
        walletSelectAddrUI.cf(str, str2);
        AppMethodBeat.o(231583);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21038);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.kvm = intent.getBooleanExtra("launch_from_appbrand", false);
        this.kvn = intent.getBooleanExtra("launch_from_remittance", false);
        boolean booleanExtra = intent.getBooleanExtra("launch_from_webview", false);
        if (booleanExtra || this.kvm) {
            this.ktF = true;
            getContentView().findViewById(R.id.h3).setVisibility(8);
            if (this.kvm && !this.kvp) {
                getWindow().setBackgroundDrawableResource(R.color.a2h);
            }
            if (booleanExtra) {
                Log.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
                bg.aVF();
                if (((Boolean) c.azQ().get(ar.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue()) {
                    Log.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
                    h.a(this, getString(R.string.fx), getString(R.string.fy), getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(21019);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(21019);
                        }
                    });
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.FALSE);
                }
            }
        }
        this.kvi = new com.tencent.mm.plugin.address.c.b(this, this);
        setMMTitle(R.string.fw);
        this.kvi.addSceneEndListener(417);
        this.kvi.addSceneEndListener(416);
        this.kvi.addSceneEndListener(419);
        this.kvi.addSceneEndListener(ac.CTRL_INDEX);
        this.kvi.doSceneProgress(new e(intent.getStringExtra("req_url"), intent.getStringExtra("req_app_id"), 2), false);
        bg.aVF();
        this.kvl = new p(Util.nullAs((Integer) c.azQ().get(9, (Object) null), 0));
        com.tencent.mm.plugin.address.a.a.bqd().bqe();
        initView();
        this.kuZ = intent.getBooleanExtra("force_light_mode", false);
        if (this.kuZ) {
            getContentView().findViewById(R.id.be9).setBackgroundColor(getContext().getResources().getColor(R.color.BW_BG_100));
            getContentView().findViewById(R.id.h3).setBackgroundColor(getContext().getResources().getColor(R.color.BW_BG_100));
            setActionbarColor(getContext().getResources().getColor(R.color.af));
            setNavigationbarColor(getContext().getResources().getColor(R.color.af));
        }
        bg.aVF();
        if (c.isSDCardAvailable()) {
            bg.azz().a(new n(12), 0);
        }
        AppMethodBeat.o(21038);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean convertActivityFromTranslucent() {
        return !this.kvp;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(231582);
        super.onCreateBeforeSetContentView();
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("content_view_height", -1);
        boolean z = intExtra != -1;
        this.kvp = z;
        if (z) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = intExtra;
            attributes.width = -1;
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
            setFinishOnTouchOutside(intent.getBooleanExtra("click_empty_close", false));
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            com.tencent.mm.ui.base.b.a(this, null);
        }
        Log.i("MicroMsg.WalletSelectAddrUI", "forceTransparent = " + this.kvp);
        AppMethodBeat.o(231582);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21039);
        super.onDestroy();
        this.kvi.removeSceneEndListener(417);
        this.kvi.removeSceneEndListener(416);
        this.kvi.removeSceneEndListener(419);
        this.kvi.removeSceneEndListener(ac.CTRL_INDEX);
        AppMethodBeat.o(21039);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(21040);
        super.onResume();
        bqn();
        AppMethodBeat.o(21040);
    }

    private void bqn() {
        AppMethodBeat.i(21041);
        synchronized (this.lockObj) {
            try {
                com.tencent.mm.plugin.address.a.a.bqb();
                this.kvf = com.tencent.mm.plugin.address.a.a.bqd().ksX.ktf;
                this.kvh.iHf = this.kvf;
                this.kvf.size();
                this.kvj.setVisibility(8);
                this.kvh.notifyDataSetChanged();
            } finally {
                AppMethodBeat.o(21041);
            }
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(21042);
        this.kvk = (TextView) findViewById(R.id.dxn);
        this.kvk.setVisibility(8);
        this.kvk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(21022);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a((Context) WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(R.string.g7, new Object[]{WalletSelectAddrUI.this.kvl.toString()}), "", WalletSelectAddrUI.this.getString(R.string.g8), WalletSelectAddrUI.this.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass3.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(21021);
                        WalletSelectAddrUI.b(WalletSelectAddrUI.this);
                        AppMethodBeat.o(21021);
                    }
                }, (DialogInterface.OnClickListener) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21022);
            }
        });
        this.hUI = (ListView) findViewById(R.id.hmo);
        this.kvh = new a(this);
        this.kvj = findViewById(R.id.gh);
        this.kvj.findViewById(R.id.h5).setVisibility(8);
        ((TextView) this.kvj.findViewById(R.id.hj)).setText(R.string.dz);
        this.hUI.setAdapter((ListAdapter) this.kvh);
        this.hUI.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(21023);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(i2)));
                synchronized (WalletSelectAddrUI.this.lockObj) {
                    try {
                        if (i2 < WalletSelectAddrUI.this.kvf.size()) {
                            WalletSelectAddrUI.this.kvg = (b) WalletSelectAddrUI.this.kvf.get(i2);
                            if (!WalletSelectAddrUI.this.ktF && !WalletSelectAddrUI.this.kvn && WalletSelectAddrUI.this.kvg != null) {
                                WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.this.kvg.id);
                            } else if (!(WalletSelectAddrUI.this.kvg == null || WalletSelectAddrUI.this.kvg.id == 0)) {
                                WalletSelectAddrUI.this.kvi.doSceneProgress(new g(WalletSelectAddrUI.this.kvg.id), true);
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(21023);
                        throw th;
                    }
                }
                WalletSelectAddrUI.this.kvh.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(21023);
            }
        });
        this.hUI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i2, long j2) {
                AppMethodBeat.i(21025);
                h.a(WalletSelectAddrUI.this.getContext(), (String) null, WalletSelectAddrUI.this.getResources().getStringArray(R.array.au), (String) null, new h.d() {
                    /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass5.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        b bVar;
                        AppMethodBeat.i(21024);
                        synchronized (WalletSelectAddrUI.this.lockObj) {
                            try {
                                if (i2 < WalletSelectAddrUI.this.kvf.size()) {
                                    bVar = (b) WalletSelectAddrUI.this.kvf.get(i2);
                                } else {
                                    bVar = null;
                                }
                            } finally {
                                AppMethodBeat.o(21024);
                            }
                        }
                        if (bVar == null) {
                            AppMethodBeat.o(21024);
                            return;
                        }
                        switch (i2) {
                            case 0:
                                WalletSelectAddrUI.a(WalletSelectAddrUI.this, bVar.id);
                                AppMethodBeat.o(21024);
                                return;
                            case 1:
                                f fVar = new f(bVar.id);
                                WalletSelectAddrUI.this.kvg = null;
                                WalletSelectAddrUI.this.kvi.doSceneProgress(fVar, true);
                                AppMethodBeat.o(21024);
                                return;
                            case 2:
                                WalletSelectAddrUI.b(WalletSelectAddrUI.this, bVar);
                                break;
                        }
                    }
                });
                AppMethodBeat.o(21025);
                return true;
            }
        });
        bqn();
        this.kvj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(21026);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletSelectAddrUI.j(WalletSelectAddrUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21026);
            }
        });
        this.kvh.notifyDataSetChanged();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21027);
                WalletSelectAddrUI.this.setResult(0);
                WalletSelectAddrUI.this.finish();
                AppMethodBeat.o(21027);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.e1, R.raw.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21028);
                WalletSelectAddrUI.j(WalletSelectAddrUI.this);
                AppMethodBeat.o(21028);
                return true;
            }
        });
        AppMethodBeat.o(21042);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c7f;
    }

    public class a extends BaseAdapter {
        private final Context context;
        List<b> iHf = new ArrayList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(21036);
            b vt = vt(i2);
            AppMethodBeat.o(21036);
            return vt;
        }

        public a(Context context2) {
            AppMethodBeat.i(21032);
            this.context = context2;
            AppMethodBeat.o(21032);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C0528a aVar;
            AppMethodBeat.i(21033);
            C0528a aVar2 = new C0528a();
            if (view == null) {
                view = View.inflate(this.context, R.layout.c7e, null);
                aVar2.kup = (ImageView) view.findViewById(R.id.b0d);
                aVar2.hXC = (TextView) view.findViewById(R.id.h5);
                aVar2.gxs = (TextView) view.findViewById(R.id.hj);
                if (WalletSelectAddrUI.this.kuZ) {
                    view.setBackgroundResource(R.drawable.qc);
                    aVar2.gxs.setTextColor(WalletSelectAddrUI.this.getContext().getResources().getColor(R.color.ae));
                    aVar2.hXC.setTextColor(WalletSelectAddrUI.this.getContext().getResources().getColor(R.color.ac));
                }
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C0528a) view.getTag();
            }
            b vt = vt(i2);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(vt.kth)) {
                sb.append(vt.kth);
            }
            if (!TextUtils.isEmpty(vt.kti)) {
                sb.append(" ");
                sb.append(vt.kti);
            }
            if (!TextUtils.isEmpty(vt.ktj)) {
                sb.append(" ");
                sb.append(vt.ktj);
            }
            if (!TextUtils.isEmpty(vt.ktl)) {
                sb.append(" ");
                sb.append(vt.ktl);
            }
            aVar.hXC.setText(sb.toString());
            aVar.gxs.setText(vt.ktm + "，" + vt.ktn);
            if (!WalletSelectAddrUI.this.ktF || WalletSelectAddrUI.this.kvg == null || WalletSelectAddrUI.this.kvg.id != vt.id) {
                aVar.kup.setImageBitmap(null);
            } else {
                aVar.kup.setImageResource(R.raw.radio_on);
            }
            AppMethodBeat.o(21033);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.i(21034);
            int size = this.iHf.size();
            AppMethodBeat.o(21034);
            return size;
        }

        private b vt(int i2) {
            AppMethodBeat.i(21035);
            b bVar = this.iHf.get(i2);
            AppMethodBeat.o(21035);
            return bVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$a$a  reason: collision with other inner class name */
        class C0528a {
            TextView gxs;
            TextView hXC;
            ImageView kup;

            C0528a() {
            }
        }
    }

    @Override // com.tencent.mm.plugin.address.c.a
    public final void c(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(21043);
        this.kvi.onSceneEnd(i2, i3, str, qVar);
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 417) {
                if (((e) qVar).ksQ) {
                    bqn();
                    getContentView().findViewById(R.id.h3).setVisibility(0);
                    if (this.ktF && this.kvf.size() == 0) {
                        Intent intent = new Intent();
                        intent.setClass(this, WalletAddAddressUI.class);
                        startActivityForResult(intent, 1);
                    }
                }
                AppMethodBeat.o(21043);
                return;
            } else if (qVar.getType() == 416) {
                com.tencent.mm.plugin.address.a.a.bqb();
                b vp = com.tencent.mm.plugin.address.a.a.bqd().vp(((f) qVar).ksR);
                if (vp != null) {
                    com.tencent.mm.plugin.address.a.a.bqb();
                    Log.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.bqd().a(vp))));
                }
                bqn();
                AppMethodBeat.o(21043);
                return;
            } else if (qVar.getType() == 419) {
                if (this.kvg != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.kvg));
                    finish();
                    AppMethodBeat.o(21043);
                    return;
                }
            } else if (qVar.getType() == 582) {
                String string = getString(R.string.g_);
                switch (((com.tencent.mm.plugin.address.model.d) qVar).status) {
                    case 0:
                        bg.aVF();
                        c.azQ().set(196657, Boolean.TRUE);
                        this.kvk.setVisibility(8);
                        bqn();
                        getContentView().setVisibility(0);
                        string = getString(R.string.gb);
                        break;
                    case 1:
                    case 2:
                        bg.aVF();
                        c.azQ().set(196657, Boolean.TRUE);
                        this.kvk.setVisibility(8);
                        string = getString(R.string.ga);
                        break;
                    case 3:
                        bqs();
                        AppMethodBeat.o(21043);
                        return;
                }
                if (this.kvo != null) {
                    this.kvo.dismiss();
                }
                this.kvo = h.a((Context) this, string, (String) null, true, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(21043);
                return;
            }
        } else if (qVar.getType() == 419 && i3 == -3103) {
            h.a((Context) this, true, str, "", getString(R.string.e5), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(21031);
                    dialogInterface.dismiss();
                    WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.this.kvg.id);
                    AppMethodBeat.o(21031);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(21020);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(21020);
                }
            });
        }
        AppMethodBeat.o(21043);
    }

    private void cf(String str, String str2) {
        AppMethodBeat.i(21044);
        this.kvi.doSceneProgress(new com.tencent.mm.plugin.address.model.d(str, str2, this.kvl), true);
        AppMethodBeat.o(21044);
    }

    private void bqs() {
        AppMethodBeat.i(21045);
        final nb nbVar = new nb();
        nbVar.dSL.dKq = this;
        nbVar.dSL.dSN = new Runnable() {
            /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(21030);
                WalletSelectAddrUI.this.hUI.post(new Runnable() {
                    /* class com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(21029);
                        if (nbVar.dSM.dFE) {
                            bg.aVF();
                            String nullAsNil = Util.nullAsNil((String) c.azQ().get(46, (Object) null));
                            bg.aVF();
                            WalletSelectAddrUI.a(WalletSelectAddrUI.this, nullAsNil, Util.nullAsNil((String) c.azQ().get(72, (Object) null)));
                        }
                        AppMethodBeat.o(21029);
                    }
                });
                AppMethodBeat.o(21030);
            }
        };
        EventCenter.instance.asyncPublish(nbVar, Looper.myLooper());
        AppMethodBeat.o(21045);
    }

    private void vs(int i2) {
        AppMethodBeat.i(21046);
        Intent intent = new Intent();
        intent.setClass(this, WalletAddAddressUI.class);
        intent.putExtra("address_id", i2);
        intent.putExtra("force_light_mode", this.kuZ);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI", "editAddressUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21046);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        b bVar;
        AppMethodBeat.i(21047);
        if (i2 == 1) {
            if (-1 == i3) {
                if (intent == null) {
                    Log.e("MicroMsg.AddrUtil", "intent == null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.kto = intent.getStringExtra("nationalCode");
                    bVar.ktm = intent.getStringExtra("userName");
                    bVar.ktn = intent.getStringExtra("telNumber");
                    bVar.ktk = intent.getStringExtra("addressPostalCode");
                    bVar.kth = intent.getStringExtra("proviceFirstStageName");
                    bVar.kti = intent.getStringExtra("addressCitySecondStageName");
                    bVar.ktj = intent.getStringExtra("addressCountiesThirdStageName");
                    bVar.ktl = intent.getStringExtra("addressDetailInfo");
                }
                setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
            } else {
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.o(21047);
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI) {
        AppMethodBeat.i(21048);
        bg.aVF();
        String nullAsNil = Util.nullAsNil((String) c.azQ().get(46, (Object) null));
        bg.aVF();
        String nullAsNil2 = Util.nullAsNil((String) c.azQ().get(72, (Object) null));
        if (!Util.isNullOrNil(nullAsNil) || !Util.isNullOrNil(nullAsNil2)) {
            walletSelectAddrUI.cf(nullAsNil, nullAsNil2);
            AppMethodBeat.o(21048);
            return;
        }
        walletSelectAddrUI.bqs();
        AppMethodBeat.o(21048);
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI, b bVar) {
        AppMethodBeat.i(21050);
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(bVar.ktm)) {
                sb.append(walletSelectAddrUI.getString(R.string.fk));
                sb.append("：");
                sb.append(bVar.ktm);
                sb.append(" \n");
            }
            if (!TextUtils.isEmpty(bVar.ktn)) {
                sb.append(walletSelectAddrUI.getString(R.string.fp));
                sb.append("：");
                sb.append(bVar.ktn);
                sb.append(" \n");
            }
            sb.append(walletSelectAddrUI.getString(R.string.ex));
            sb.append("：");
            if (!TextUtils.isEmpty(bVar.kth)) {
                sb.append(bVar.kth);
            }
            if (!TextUtils.isEmpty(bVar.kti)) {
                sb.append(bVar.kti);
            }
            if (!TextUtils.isEmpty(bVar.ktj)) {
                sb.append(bVar.ktj);
            }
            if (!TextUtils.isEmpty(bVar.ktl)) {
                sb.append(bVar.ktl);
            }
            if (!TextUtils.isEmpty(bVar.ktk)) {
                sb.append(" \n");
                sb.append(walletSelectAddrUI.getString(R.string.fr));
                sb.append("：");
                sb.append(bVar.ktk);
            }
            try {
                walletSelectAddrUI.getContext();
                com.tencent.mm.plugin.address.e.d.TF(sb.toString());
                AppMethodBeat.o(21050);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WalletSelectAddrUI", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(21050);
    }

    static /* synthetic */ void j(WalletSelectAddrUI walletSelectAddrUI) {
        AppMethodBeat.i(21051);
        walletSelectAddrUI.vs(0);
        AppMethodBeat.o(21051);
    }
}
