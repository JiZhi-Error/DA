package com.tencent.mm.plugin.card.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.p;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class CardShopUI extends MMActivity implements m.a {
    private ProgressDialog iLh;
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.card.ui.CardShopUI.AnonymousClass5 */

        public final void onClick(View view) {
            us usVar;
            AppMethodBeat.i(113560);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.hqh && (usVar = (us) view.getTag()) != null) {
                com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, usVar.latitude, usVar.dTj, usVar.iUO);
                h.INSTANCE.a(11941, 5, CardShopUI.this.pQV.csU(), CardShopUI.this.pQV.csV(), "", usVar.name);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113560);
        }
    };
    private ListView mListView;
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.card.ui.CardShopUI.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(113559);
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.LOCALE_CHANGED") && CardShopUI.cwn()) {
                CardShopUI.e(CardShopUI.this);
            }
            AppMethodBeat.o(113559);
        }
    };
    private String pQH;
    private com.tencent.mm.plugin.card.base.b pQV;
    private ArrayList<us> pRc = new ArrayList<>();
    private boolean pXP = false;
    private String qdR = "";
    private a qdS;
    private LinearLayout qdT;
    private View qdU;
    private TextView qdV;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardShopUI() {
        AppMethodBeat.i(113566);
        AppMethodBeat.o(113566);
    }

    static /* synthetic */ boolean cwn() {
        AppMethodBeat.i(113576);
        boolean cwm = cwm();
        AppMethodBeat.o(113576);
        return cwm;
    }

    static /* synthetic */ void e(CardShopUI cardShopUI) {
        AppMethodBeat.i(113577);
        cardShopUI.byG();
        AppMethodBeat.o(113577);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x008d  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.CardShopUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113568);
        if (!TextUtils.isEmpty(this.pQV.csQ().Lfd)) {
            setMMTitle(this.pQV.csQ().Lfd);
        } else {
            setMMTitle(R.string.anm);
        }
        this.mListView = (ListView) findViewById(R.id.ap4);
        this.qdT = (LinearLayout) View.inflate(getBaseContext(), R.layout.o0, null);
        this.mListView.addHeaderView(this.qdT);
        this.qdS = new a(this, (byte) 0);
        this.mListView.setAdapter((ListAdapter) this.qdS);
        final Intent intent = getIntent();
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardShopUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(113556);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 == 0) {
                    Log.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(113556);
                    return;
                }
                if (i2 > 0) {
                    i2--;
                }
                us usVar = (us) CardShopUI.this.pRc.get(i2);
                if (!TextUtils.isEmpty(usVar.Leo) && !TextUtils.isEmpty(usVar.Lep)) {
                    com.tencent.mm.plugin.card.d.b.d(CardShopUI.this.pQH, usVar.Leo, usVar.Lep, 1052, intent.getIntExtra("key_from_appbrand_type", 0));
                } else if (!TextUtils.isEmpty(usVar.pTL)) {
                    com.tencent.mm.plugin.card.d.b.a(CardShopUI.this, usVar.pTL, 1);
                    h.INSTANCE.a(11941, 4, CardShopUI.this.pQV.csU(), CardShopUI.this.pQV.csV(), "", usVar.name);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardShopUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(113556);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardShopUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(113557);
                CardShopUI.this.finish();
                AppMethodBeat.o(113557);
                return true;
            }
        });
        this.qdU = View.inflate(this, R.layout.nz, null);
        if (this.qdT != null) {
            this.qdT.addView(this.qdU);
        }
        this.qdV = (TextView) this.qdU.findViewById(R.id.ann);
        this.qdV.setText(R.string.at2);
        this.qdU.setVisibility(8);
        AppMethodBeat.o(113568);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113569);
        if (this.pXP) {
            unregisterReceiver(this.mReceiver);
        }
        am.ctT().a(this.qdR, this);
        super.onDestroy();
        AppMethodBeat.o(113569);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ot;
    }

    @Override // com.tencent.mm.plugin.card.b.m.a
    public final void a(boolean z, ArrayList<us> arrayList) {
        AppMethodBeat.i(113570);
        if (this.iLh != null) {
            this.iLh.dismiss();
            this.iLh = null;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        Log.d("MicroMsg.CardShopUI", "onGotCardShop, isOk = %b, shop list size = %d", objArr);
        if (!z) {
            Log.e("MicroMsg.CardShopUI", "onGotCardShop fail");
            AppMethodBeat.o(113570);
        } else if (arrayList == null || arrayList.size() == 0) {
            Log.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
            AppMethodBeat.o(113570);
        } else {
            if (this.pRc != null) {
                this.pRc.clear();
                this.pRc.addAll(arrayList);
                this.qdU.setVisibility(0);
            } else {
                this.qdU.setVisibility(8);
            }
            this.qdS.notifyDataSetChanged();
            AppMethodBeat.o(113570);
        }
    }

    private void cwl() {
        AppMethodBeat.i(113571);
        Log.i("MicroMsg.CardShopUI", p.NAME);
        registerReceiver();
        if (cwm()) {
            byG();
            AppMethodBeat.o(113571);
            return;
        }
        d.c(this);
        AppMethodBeat.o(113571);
    }

    private static boolean cwm() {
        boolean z;
        AppMethodBeat.i(113572);
        if (l.bcc() || l.bcd()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(113572);
            return true;
        }
        AppMethodBeat.o(113572);
        return false;
    }

    private void byG() {
        AppMethodBeat.i(113573);
        if (am.ctT().a(this.qdR, this.pQH, this)) {
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.iLh = com.tencent.mm.ui.base.h.a((Context) context, getString(R.string.aot), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.card.ui.CardShopUI.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(113558);
                    m ctT = am.ctT();
                    ctT.a(CardShopUI.this.qdR, CardShopUI.this);
                    if (ctT.pRU != null) {
                        g.aAg().hqi.a(ctT.pRU);
                    }
                    AppMethodBeat.o(113558);
                }
            });
            AppMethodBeat.o(113573);
            return;
        }
        com.tencent.mm.ui.base.h.cD(this, getString(R.string.aos));
        AppMethodBeat.o(113573);
    }

    private void registerReceiver() {
        AppMethodBeat.i(113574);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.mReceiver, intentFilter);
        AppMethodBeat.o(113574);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        /* synthetic */ a(CardShopUI cardShopUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(113565);
            us Ev = Ev(i2);
            AppMethodBeat.o(113565);
            return Ev;
        }

        private a() {
        }

        public final int getCount() {
            AppMethodBeat.i(113562);
            int size = CardShopUI.this.pRc.size();
            AppMethodBeat.o(113562);
            return size;
        }

        private us Ev(int i2) {
            AppMethodBeat.i(113563);
            us usVar = (us) CardShopUI.this.pRc.get(i2);
            AppMethodBeat.o(113563);
            return usVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C0908a aVar;
            AppMethodBeat.i(113564);
            if (view == null) {
                view = View.inflate(CardShopUI.this.getContext(), R.layout.or, null);
                C0908a aVar2 = new C0908a();
                aVar2.qdX = (TextView) view.findViewById(R.id.hqe);
                aVar2.qdY = (TextView) view.findViewById(R.id.hqa);
                aVar2.qdZ = (TextView) view.findViewById(R.id.hq_);
                aVar2.qea = (ImageView) view.findViewById(R.id.hqg);
                aVar2.qeb = view.findViewById(R.id.hqh);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C0908a) view.getTag();
            }
            us Ev = Ev(i2);
            if (Ev == null) {
                aVar.qdX.setText("");
                aVar.qdY.setText("");
                aVar.qdZ.setText("");
                AppMethodBeat.o(113564);
            } else {
                aVar.qdX.setText(Ev.name);
                if (Ev.DWG <= 0.0f) {
                    aVar.qdY.setVisibility(8);
                } else {
                    aVar.qdY.setText(l.f(CardShopUI.this.getBaseContext(), Ev.DWG));
                    aVar.qdY.setVisibility(0);
                }
                aVar.qdZ.setText(Ev.fuJ + Ev.fuK + Ev.iUO);
                aVar.qeb.setOnClickListener(CardShopUI.this.kuO);
                aVar.qeb.setTag(Ev);
                AppMethodBeat.o(113564);
            }
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.card.ui.CardShopUI$a$a  reason: collision with other inner class name */
        class C0908a {
            public TextView qdX;
            public TextView qdY;
            public TextView qdZ;
            public ImageView qea;
            public View qeb;

            C0908a() {
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(113575);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.CardShopUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(113575);
            return;
        }
        Log.i("MicroMsg.CardShopUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 69:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.b96), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.card.ui.CardShopUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(113561);
                            CardShopUI cardShopUI = CardShopUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(cardShopUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardShopUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            cardShopUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(cardShopUI, "com/tencent/mm/plugin/card/ui/CardShopUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(113561);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    Log.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.pXP);
                    if (!this.pXP) {
                        this.pXP = true;
                        cwl();
                    }
                    AppMethodBeat.o(113575);
                    return;
                }
        }
        AppMethodBeat.o(113575);
    }
}
