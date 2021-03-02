package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.ui.MallProductSelectAmountView;
import com.tencent.mm.plugin.product.ui.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class MallProductSelectSkuUI extends MallBaseUI implements u.a {
    private m AYX;
    private e AZm;
    private c BaP;
    private ImageView Bbr;
    private TextView Bbs;
    private TextView Bbt;
    private Button Bbu;
    private ListView Bbv;
    private MallProductSelectAmountView Bbw = null;
    private i Bbx = null;
    private f Bby;
    private TextView mPa;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MallProductSelectSkuUI mallProductSelectSkuUI) {
        AppMethodBeat.i(67025);
        mallProductSelectSkuUI.updateView();
        AppMethodBeat.o(67025);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bj9;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67018);
        super.onCreate(bundle);
        this.Bby = new f(getContext(), new f.a() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.product.ui.f.a
            public final void D(int i2, int i3, String str) {
                AppMethodBeat.i(67012);
                if (i2 == 0 && i3 == 0) {
                    MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
                    AppMethodBeat.o(67012);
                    return;
                }
                MallProductSelectSkuUI.this.aKi(str);
                AppMethodBeat.o(67012);
            }
        });
        a.eDb();
        this.BaP = a.eDc();
        this.AYX = this.BaP.AYX;
        initView();
        updateView();
        AppMethodBeat.o(67018);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(67019);
        this.Bby.onStart();
        super.onStart();
        AppMethodBeat.o(67019);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(67020);
        this.Bby.onStop();
        super.onStop();
        AppMethodBeat.o(67020);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67021);
        setMMTitle(R.string.ewz);
        this.Bbr = (ImageView) findViewById(R.id.f9e);
        this.mPa = (TextView) findViewById(R.id.f9i);
        this.Bbs = (TextView) findViewById(R.id.f9g);
        this.Bbt = (TextView) findViewById(R.id.f9d);
        this.Bbu = (Button) findViewById(R.id.f9f);
        this.Bbv = (ListView) findViewById(R.id.f9l);
        this.Bbw = (MallProductSelectAmountView) findViewById(R.id.hh2);
        this.Bbw.setAmount(this.BaP.mCount);
        this.Bbx = new i(this);
        if (this.AYX == null || this.AYX.AZB == null || this.AYX.AZB.AZU == null) {
            Log.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
        } else {
            this.Bbx.BbA = this.AYX.AZB.AZU;
        }
        this.Bbx.BbB = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                e eVar;
                e eVar2 = null;
                AppMethodBeat.i(67013);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Pair pair = (Pair) view.getTag();
                MallProductSelectSkuUI mallProductSelectSkuUI = MallProductSelectSkuUI.this;
                c cVar = MallProductSelectSkuUI.this.BaP;
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                Log.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + str2 + ")");
                if (!cVar.AZj.containsKey(str) || !cVar.AZj.get(str).equals(str2)) {
                    cVar.AZj.put(str, str2);
                    cVar.AZb = c.aF(cVar.AZj);
                    Log.d("MicroMsg.MallProductManager", "getSkuInfoId (" + cVar.AZb + ")");
                    if (cVar.AZi != null) {
                        cVar.AZm = cVar.AZi.get(cVar.AZb);
                    }
                    mallProductSelectSkuUI.AZm = eVar2;
                    MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(67013);
                }
                cVar.AZj.remove(str);
                cVar.AZb = c.aF(cVar.AZj);
                if (cVar.AZi != null) {
                    eVar = cVar.AZi.get(cVar.AZb);
                } else {
                    eVar = null;
                }
                cVar.AZm = eVar;
                cVar.eDt();
                eVar2 = cVar.AZm;
                mallProductSelectSkuUI.AZm = eVar2;
                MallProductSelectSkuUI.a(MallProductSelectSkuUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(67013);
            }
        };
        this.Bbv.setAdapter((ListAdapter) this.Bbx);
        this.Bbw.setOnAmountChangeListener(new MallProductSelectAmountView.a() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.product.ui.MallProductSelectAmountView.a
            public final void iZ(int i2) {
                AppMethodBeat.i(67014);
                MallProductSelectSkuUI.this.BaP.mCount = i2;
                MallProductSelectSkuUI.this.Bbt.setVisibility(8);
                AppMethodBeat.o(67014);
            }

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.plugin.product.ui.MallProductSelectAmountView.a
            public final void hO(int i2, int i3) {
                AppMethodBeat.i(67015);
                switch (i3) {
                    case 1:
                        MallProductSelectSkuUI.this.Bbt.setText(R.string.ewu);
                        MallProductSelectSkuUI.this.Bbt.setVisibility(0);
                        AppMethodBeat.o(67015);
                        return;
                    case 3:
                        MallProductSelectSkuUI.this.Bbt.setText(MallProductSelectSkuUI.this.getString(R.string.ewv, new Object[]{Integer.valueOf(i2)}));
                        MallProductSelectSkuUI.this.Bbt.setVisibility(0);
                        break;
                }
                AppMethodBeat.o(67015);
            }
        });
        this.Bbu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.AnonymousClass4 */

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(67016);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f fVar = MallProductSelectSkuUI.this.Bby;
                if (fVar.BaN) {
                    com.tencent.mm.ui.base.u.makeText(fVar.mContext, (int) R.string.ewo, 1).show();
                } else if (!fVar.BaP.eDp()) {
                    c cVar = fVar.BaP;
                    if (cVar.AZj != null && cVar.AZj.size() < cVar.AZh && cVar.AZh > 0) {
                        Iterator<com.tencent.mm.plugin.product.c.m> it = cVar.AYX.AZB.AZU.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            com.tencent.mm.plugin.product.c.m next = it.next();
                            if (!cVar.AZj.containsKey(next.Bae)) {
                                str = next.Baf;
                                break;
                            }
                        }
                    }
                    str = null;
                    if (!Util.isNullOrNil(str)) {
                        com.tencent.mm.ui.base.u.makeText(fVar.mContext, fVar.mContext.getString(R.string.ewx, new Object[]{str}), 0).show();
                    }
                } else if (fVar.BaP.AZd != null) {
                    g.aAi();
                    g.aAg().hqi.a(new j(fVar.BaP.eDr(), f.mScene), 0);
                } else {
                    com.tencent.mm.br.c.d(fVar.mContext, "address", ".ui.WalletAddAddressUI", 2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSelectSkuUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67016);
            }
        });
        this.Bbr.setFocusable(true);
        this.Bbr.setFocusableInTouchMode(true);
        this.Bbr.requestFocus();
        AppMethodBeat.o(67021);
    }

    private void updateView() {
        AppMethodBeat.i(67022);
        if (this.AYX != null) {
            if (this.AZm == null || this.AYX.AZB == null) {
                this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(this.AYX.AZB.AZM, this.AYX.AZB.AZN, this.AYX.AZB.AOl));
            } else {
                this.Bbs.setText(com.tencent.mm.plugin.product.b.b.C(this.AZm.AZq, this.AZm.AZr, this.AYX.AZB.AOl));
            }
            if (this.AYX.AZB != null) {
                this.mPa.setText(this.AYX.AZB.name);
            }
        }
        if (!Util.isNullOrNil(this.BaP.eDf())) {
            this.Bbr.setImageBitmap(u.a(new c(this.BaP.eDf())));
            u.a(this);
        }
        this.Bbt.setVisibility(8);
        this.Bbw.hN(this.BaP.eDn(), this.BaP.AYX.AZA);
        this.Bbx.notifyDataSetChanged();
        AppMethodBeat.o(67022);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(67023);
        super.onActivityResult(i2, i3, intent);
        this.Bby.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(67023);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(67024);
        Log.d("MicroMsg.MallProductSelectSkuUI", str + ", bitmap = " + (bitmap == null));
        if (Util.isNullOrNil(this.BaP.eDf())) {
            AppMethodBeat.o(67024);
            return;
        }
        this.Bbr.post(new Runnable() {
            /* class com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(67017);
                MallProductSelectSkuUI.this.Bbr.setImageBitmap(bitmap);
                AppMethodBeat.o(67017);
            }
        });
        AppMethodBeat.o(67024);
    }
}
