package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class ProductPurchaseAreaUI extends MMPreference {
    private List<b.a> CKY;
    private int CKZ;
    protected f nRm;
    private String rcD;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(51844);
        super.onCreate(bundle);
        initView();
        n.a fn = r.fn(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (fn == null || fn.CUx == null) {
            Log.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
            AppMethodBeat.o(51844);
            return;
        }
        this.rcD = fn.field_productid;
        this.CKZ = fn.field_functionType;
        String stringExtra = getIntent().getStringExtra("referkey");
        Log.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(stringExtra)));
        if (!Util.isNullOrNil(stringExtra)) {
            for (int i2 = 0; i2 < fn.CUx.size(); i2++) {
                if (stringExtra.equals(fn.CUx.get(i2).CEG)) {
                    this.CKY = fn.CUx.get(i2).mRG;
                    setMMTitle(fn.CUx.get(i2).title);
                    if (this.CKY != null) {
                        for (int i3 = 0; i3 < this.CKY.size(); i3++) {
                            b.a aVar = this.CKY.get(i3);
                            String valueOf = String.valueOf(i3);
                            if (aVar != null) {
                                a aVar2 = new a(this);
                                aVar2.setKey(valueOf);
                                aVar2.setTitle(aVar.name);
                                aVar2.setSummary(aVar.desc);
                                aVar2.CJc = aVar.iAq;
                                this.nRm.c(aVar2);
                                if (i3 != this.CKY.size() - 1) {
                                    this.nRm.c(new f(getContext()));
                                }
                            }
                        }
                        this.nRm.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(51844);
                    return;
                }
            }
        }
        AppMethodBeat.o(51844);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(51845);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(51843);
                ProductPurchaseAreaUI.this.finish();
                AppMethodBeat.o(51843);
                return false;
            }
        });
        this.nRm = getPreferenceScreen();
        AppMethodBeat.o(51845);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(51846);
        if (this.CKY == null) {
            AppMethodBeat.o(51846);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            if (intValue < 0 || intValue >= this.CKY.size()) {
                AppMethodBeat.o(51846);
                return false;
            }
            b.a aVar = this.CKY.get(intValue);
            if (aVar == null) {
                AppMethodBeat.o(51846);
                return false;
            }
            String str = null;
            switch (aVar.type) {
                case 1:
                    str = aVar.link;
                    if (Util.isNullOrNil(aVar.link)) {
                        Log.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
                        break;
                    } else {
                        n(getContext(), aVar.link, this.CKZ);
                        break;
                    }
                case 9:
                    str = aVar.CEN;
                    if (!Util.isNullOrNil(aVar.CEN)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", aVar.CEN);
                        intent.putExtra("key_product_scene", 12);
                        c.b(this, "product", ".ui.MallProductUI", intent);
                        break;
                    }
                    break;
                default:
                    Log.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + aVar.link);
                    if (!Util.isNullOrNil(aVar.link)) {
                        n(getContext(), aVar.link, this.CKZ);
                        break;
                    }
                    break;
            }
            g.azz().a(new p(this.rcD, aVar.CEM, aVar.type, str, this.CKY.size(), aVar.dDG), 0);
            AppMethodBeat.o(51846);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", e2, "", new Object[0]);
            AppMethodBeat.o(51846);
            return false;
        }
    }

    private static void n(Context context, String str, int i2) {
        AppMethodBeat.i(51847);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", r.Wu(i2));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(51847);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bv;
    }
}
