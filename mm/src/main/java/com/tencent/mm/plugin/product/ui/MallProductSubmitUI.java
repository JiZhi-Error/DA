package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.ui.d;
import com.tencent.mm.plugin.product.ui.f;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MallProductSubmitUI extends MallBaseUI implements u.a {
    private e AZm;
    private c BaP;
    private RelativeLayout BbO;
    private TextView BbP;
    private TextView BbQ;
    private MallProductItemView BbR;
    private MallProductItemView BbS;
    private TextView BbT;
    private TextView BbU;
    private TextView BbV;
    private TextView BbW;
    private ListView BbX;
    private a BbY;
    private ImageView Bbr;
    private TextView Bbs;
    private f Bby;
    private Button krs;
    private TextView mPa;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MallProductSubmitUI mallProductSubmitUI) {
        AppMethodBeat.i(67062);
        mallProductSubmitUI.updateView();
        AppMethodBeat.o(67062);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bjb;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67054);
        super.onCreate(bundle);
        this.Bby = new f(getContext(), new f.a() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSubmitUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.product.ui.f.a
            public final void D(int i2, int i3, String str) {
                AppMethodBeat.i(67046);
                if (i2 == 0 && i3 == 0) {
                    MallProductSubmitUI.a(MallProductSubmitUI.this);
                    AppMethodBeat.o(67046);
                    return;
                }
                MallProductSubmitUI.this.aKi(str);
                AppMethodBeat.o(67046);
            }
        });
        a.eDb();
        this.BaP = a.eDc();
        this.AZm = this.BaP.AZm;
        initView();
        updateView();
        AppMethodBeat.o(67054);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(67055);
        this.Bby.onStart();
        super.onStart();
        AppMethodBeat.o(67055);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(67056);
        this.Bby.onStop();
        super.onStop();
        AppMethodBeat.o(67056);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67057);
        setMMTitle(R.string.exh);
        this.BbO = (RelativeLayout) findViewById(R.id.f9t);
        this.BbP = (TextView) findViewById(R.id.f9v);
        this.BbQ = (TextView) findViewById(R.id.f9u);
        this.BbR = (MallProductItemView) findViewById(R.id.f9x);
        this.BbS = (MallProductItemView) findViewById(R.id.f9z);
        this.Bbr = (ImageView) findViewById(R.id.f9y);
        this.mPa = (TextView) findViewById(R.id.f_6);
        this.BbT = (TextView) findViewById(R.id.f_0);
        this.Bbs = (TextView) findViewById(R.id.f_4);
        this.BbU = (TextView) findViewById(R.id.f_3);
        this.BbV = (TextView) findViewById(R.id.f_2);
        this.BbW = (TextView) findViewById(R.id.f_7);
        this.BbX = (ListView) findViewById(R.id.f_1);
        this.BbY = new a(this);
        this.BbX.setAdapter((ListAdapter) this.BbY);
        this.BbX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSubmitUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67047);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                b bVar2 = (b) view.getTag();
                switch (bVar2.type) {
                    case 1:
                        if (bVar2.Bax instanceof String) {
                            MallProductSubmitUI.this.BaP.AZg = (String) bVar2.Bax;
                            break;
                        }
                        break;
                    case 2:
                        m mVar = MallProductSubmitUI.this.BaP.AYX;
                        if (mVar.AZB.AZO != null && mVar.AZB.AZO.size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<String> it = mVar.AZB.AZO.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next());
                            }
                            bVar2.Bax = arrayList;
                            break;
                        }
                }
                MallProductSubmitUI.this.BbY.a(MallProductSubmitUI.this, view, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(67047);
            }
        });
        this.krs = (Button) findViewById(R.id.f_5);
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSubmitUI.AnonymousClass3 */

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(67048);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f fVar = MallProductSubmitUI.this.Bby;
                if (fVar.BaP.eDq()) {
                    if (fVar.BaP.eDh() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        g.aAi();
                        g.aAg().hqi.a(new k(fVar.BaP.eDs()), 0);
                    } else {
                        g.aAi();
                        g.aAg().hqi.a(new l(fVar.BaP.eDs(), fVar.BaP.getAppId()), 0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67048);
            }
        });
        this.BbO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSubmitUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(67049);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f fVar = MallProductSubmitUI.this.Bby;
                Intent intent = new Intent();
                intent.putExtra("launch_from_webview", true);
                com.tencent.mm.br.c.a((Context) fVar.mContext, "address", ".ui.WalletSelectAddrUI", intent, 1, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67049);
            }
        });
        this.BbR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSubmitUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(67050);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MallProductSubmitUI.this.showDialog(1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67050);
            }
        });
        this.BbS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSubmitUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(67051);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f fVar = MallProductSubmitUI.this.Bby;
                fVar.mContext.startActivityForResult(new Intent(fVar.mContext, MallProductReceiptUI.class), 4);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67051);
            }
        });
        MallProductItemView mallProductItemView = this.BbS;
        boolean z = (this.BaP.eDe().BaM & 2) > 0;
        Log.d("MicroMsg.MallProductConfig", "hasReceipt, ret = ".concat(String.valueOf(z)));
        mallProductItemView.setVisibility(z ? 0 : 8);
        if (this.BaP.eDe().eDA()) {
            this.BbR.setEnabled(false);
            this.BbR.setClickable(false);
            this.BbR.setSummary(getString(R.string.exf));
        }
        AppMethodBeat.o(67057);
    }

    private void updateView() {
        AppMethodBeat.i(67058);
        m mVar = this.BaP.AYX;
        if (this.AZm != null) {
            this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(this.AZm.AZq, this.AZm.AZq, mVar.AZB.AOl) + " x " + this.BaP.mCount);
        } else {
            this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(mVar.AZB.AZM, mVar.AZB.AZN, mVar.AZB.AOl));
        }
        if (!Util.isNullOrNil(this.BaP.eDf())) {
            this.Bbr.setImageBitmap(u.a(new c(this.BaP.eDf())));
            u.a(this);
        }
        this.mPa.setText(mVar.AZB.name);
        this.BbT.setText(this.BaP.eDg());
        dki eDj = this.BaP.eDj();
        if (eDj == null || Util.isNullOrNil(eDj.xKd)) {
            this.BbS.setSummary("");
        } else {
            this.BbS.setSummary(eDj.xKd);
        }
        String str = "";
        if (!this.BaP.eDe().eDA()) {
            akg akg = this.BaP.AZc;
            if (akg != null) {
                this.BbR.setEnabled(true);
                this.BbR.setClickable(true);
                this.BbR.setSummary(com.tencent.mm.plugin.product.b.b.a(this, akg));
                str = getString(R.string.exd, new Object[]{com.tencent.mm.plugin.product.b.b.c((double) akg.KZx, akg.PriceType)});
                this.BbQ.setVisibility(8);
            } else {
                this.BbR.setEnabled(false);
                this.BbR.setClickable(false);
                this.BbR.setSummary(getString(R.string.exe));
                this.BbQ.setVisibility(0);
            }
        }
        String str2 = "";
        int eDi = this.BaP.eDi();
        if (eDi > 0) {
            Util.isNullOrNil(str);
            str2 = getString(R.string.exc, new Object[]{com.tencent.mm.plugin.product.b.b.c((double) eDi, mVar.AZB.AOl)});
        }
        LinkedList<com.tencent.mm.plugin.product.c.a> aB = this.BaP.aB(this);
        if (aB.size() > 0) {
            this.BbX.setVisibility(0);
            this.BbY.fO(aB);
            this.BbY.notifyDataSetChanged();
        } else {
            this.BbX.setVisibility(8);
        }
        dr drVar = this.BaP.AZd;
        if (drVar != null) {
            this.BbP.setText(Html.fromHtml(String.format("%s %s<br><br>%s %s %s", drVar.UserName, drVar.KHE, drVar.kdZ, drVar.kea, drVar.xKd)));
        }
        String str3 = str + str2;
        if (!Util.isNullOrNil(str3)) {
            this.BbU.setText(getString(R.string.exb, new Object[]{str3}));
            this.BbV.setVisibility(8);
            this.BbU.setVisibility(0);
        } else {
            this.BbV.setVisibility(0);
            this.BbU.setVisibility(8);
        }
        this.BbW.setText(com.tencent.mm.plugin.product.b.b.c((double) this.BaP.eDh(), mVar.AZB.AOl));
        this.krs.setEnabled(this.BaP.eDq());
        AppMethodBeat.o(67058);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(67059);
        super.onActivityResult(i2, i3, intent);
        this.Bby.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(67059);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(67060);
        Log.d("MicroMsg.MallProductSubmitUI", str + ", bitmap = " + (bitmap == null));
        if (Util.isNullOrNil(this.BaP.eDf())) {
            AppMethodBeat.o(67060);
            return;
        }
        this.Bbr.post(new Runnable() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSubmitUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(67052);
                MallProductSubmitUI.this.Bbr.setImageBitmap(bitmap);
                AppMethodBeat.o(67052);
            }
        });
        AppMethodBeat.o(67060);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.product.ui.MallBaseUI
    public Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(67061);
        switch (i2) {
            case 1:
                LinkedList<akg> linkedList = this.BaP.AZk;
                if (linkedList != null) {
                    ArrayList arrayList = new ArrayList();
                    for (akg akg : linkedList) {
                        arrayList.add(com.tencent.mm.plugin.product.b.b.a(this, akg));
                    }
                    String string = getString(R.string.ex7);
                    AnonymousClass8 r3 = new AdapterView.OnItemClickListener() {
                        /* class com.tencent.mm.plugin.product.ui.MallProductSubmitUI.AnonymousClass8 */

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                            AppMethodBeat.i(67053);
                            b bVar = new b();
                            bVar.bm(adapterView);
                            bVar.bm(view);
                            bVar.pH(i2);
                            bVar.zo(j2);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                            MallProductSubmitUI.this.dismissDialog(1);
                            MallProductSubmitUI.this.BaP.Ut(i2);
                            MallProductSubmitUI.a(MallProductSubmitUI.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(67053);
                        }
                    };
                    d.a aVar = new d.a(this);
                    ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this, R.layout.b8c, null);
                    listViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener(r3, aVar) {
                        /* class com.tencent.mm.plugin.product.ui.d.AnonymousClass1 */
                        final /* synthetic */ AdapterView.OnItemClickListener BaF;
                        final /* synthetic */ a BaG;

                        {
                            this.BaF = r1;
                            this.BaG = r2;
                        }

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                            AppMethodBeat.i(66956);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(adapterView);
                            bVar.bm(view);
                            bVar.pH(i2);
                            bVar.zo(j2);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallListDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                            if (this.BaF != null) {
                                this.BaF.onItemClick(adapterView, view, i2, j2);
                            }
                            this.BaG.BaH = i2;
                            this.BaG.notifyDataSetChanged();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallListDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(66956);
                        }
                    });
                    aVar.aKs = arrayList;
                    aVar.BaH = 0;
                    listViewInScrollView.setAdapter((ListAdapter) aVar);
                    d.a aVar2 = new d.a(this);
                    aVar2.bon(string);
                    aVar2.hs(listViewInScrollView);
                    aVar2.f(null);
                    com.tencent.mm.ui.widget.a.d hbn = aVar2.hbn();
                    hbn.show();
                    AppMethodBeat.o(67061);
                    return hbn;
                }
                break;
        }
        Dialog onCreateDialog = super.onCreateDialog(i2);
        AppMethodBeat.o(67061);
        return onCreateDialog;
    }
}
