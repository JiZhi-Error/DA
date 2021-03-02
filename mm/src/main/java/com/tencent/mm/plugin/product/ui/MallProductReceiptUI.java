package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public class MallProductReceiptUI extends MallBaseUI {
    private c BaP;
    private d Bbf = null;
    private AutoCompleteTextView Bbg = null;
    private h Bbh = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bj5;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.product.ui.MallBaseUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(66999);
        super.onCreate(bundle);
        this.Bbf = a.eDb().eDd();
        a.eDb();
        this.BaP = a.eDc();
        initView();
        AppMethodBeat.o(66999);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67000);
        setMMTitle(R.string.ewt);
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductReceiptUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i2 = 0;
                AppMethodBeat.i(66996);
                String obj = MallProductReceiptUI.this.Bbg.getText().toString();
                if (!Util.isNullOrNil(obj)) {
                    c cVar = MallProductReceiptUI.this.BaP;
                    cVar.AZe = new dki();
                    dki dki = cVar.AZe;
                    if (!Util.isNullOrNil(obj)) {
                        i2 = 1;
                    }
                    dki.MOm = i2;
                    cVar.AZe.xKd = obj;
                    MallProductReceiptUI.this.finish();
                } else {
                    u.makeText(MallProductReceiptUI.this, (int) R.string.ews, 0).show();
                }
                AppMethodBeat.o(66996);
                return true;
            }
        });
        this.Bbg = (AutoCompleteTextView) findViewById(R.id.f9a);
        dki eDj = this.BaP.eDj();
        if (eDj != null && !Util.isNullOrNil(eDj.xKd)) {
            this.Bbg.setText(eDj.xKd);
        }
        this.Bbg.setSelection(this.Bbg.getText().length());
        this.Bbh = new h(this);
        this.Bbg.setAdapter(this.Bbh);
        this.Bbg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductReceiptUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                String str;
                AppMethodBeat.i(66997);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                d dVar = MallProductReceiptUI.this.Bbf;
                if (dVar.AZp == null || i2 >= dVar.AZp.size()) {
                    str = null;
                } else {
                    str = dVar.AZp.get(i2);
                }
                Log.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = ".concat(String.valueOf(str)));
                if (!Util.isNullOrNil(str)) {
                    MallProductReceiptUI.this.Bbg.setText(str);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductReceiptUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(66997);
            }
        });
        View.inflate(getContext(), R.layout.bj1, null).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallProductReceiptUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(66998);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/product/ui/MallProductReceiptUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d dVar = MallProductReceiptUI.this.Bbf;
                dVar.AZp.clear();
                dVar.eDw();
                MallProductReceiptUI.this.Bbh.notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductReceiptUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(66998);
            }
        });
        AppMethodBeat.o(67000);
    }
}
