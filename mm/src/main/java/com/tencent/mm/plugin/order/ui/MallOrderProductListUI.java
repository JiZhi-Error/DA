package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI extends WalletBaseUI {
    private ListView GP;
    private String ixZ = "";
    private List<ProductSectionItem> opg = new ArrayList();
    private BaseAdapter pXY;
    private String qvD = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallOrderProductListUI() {
        AppMethodBeat.i(66750);
        AppMethodBeat.o(66750);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b67;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(66751);
        super.onCreate(bundle);
        setContentViewVisibility(0);
        initView();
        AppMethodBeat.o(66751);
    }

    @Override // com.tencent.mm.ui.MMActivity
    @Deprecated
    public void initView() {
        AppMethodBeat.i(66752);
        setMMTitle(R.string.ewg);
        Bundle input = getInput();
        ArrayList parcelableArrayList = input.getParcelableArrayList("order_product_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            this.opg.clear();
            this.opg.addAll(parcelableArrayList);
        }
        this.qvD = input.getString("key_trans_id");
        this.ixZ = input.getString("appname");
        this.GP = (ListView) findViewById(R.id.g68);
        this.pXY = new a(this, (byte) 0);
        this.GP.setAdapter((ListAdapter) this.pXY);
        this.pXY.notifyDataSetChanged();
        this.GP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderProductListUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(66743);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderProductListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.this.opg.get(i2);
                if (productSectionItem != null) {
                    MallOrderProductListUI.a(MallOrderProductListUI.this, productSectionItem);
                    c.a(Boolean.FALSE, MallOrderProductListUI.this.ixZ, MallOrderProductListUI.this.qvD, productSectionItem.name, productSectionItem.APx);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderProductListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(66743);
            }
        });
        AppMethodBeat.o(66752);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66753);
        super.onDestroy();
        AppMethodBeat.o(66753);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(66754);
        if (i2 == 4) {
            if (com.tencent.mm.wallet_core.a.by(this) instanceof com.tencent.mm.plugin.order.a.a) {
                com.tencent.mm.wallet_core.a.bv(this);
            }
            AppMethodBeat.o(66754);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(66754);
        return onKeyUp;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MallOrderProductListUI mallOrderProductListUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(66747);
            ProductSectionItem Uj = Uj(i2);
            AppMethodBeat.o(66747);
            return Uj;
        }

        public final int getCount() {
            AppMethodBeat.i(66744);
            int size = MallOrderProductListUI.this.opg.size();
            AppMethodBeat.o(66744);
            return size;
        }

        private ProductSectionItem Uj(int i2) {
            AppMethodBeat.i(66745);
            ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.this.opg.get(i2);
            AppMethodBeat.o(66745);
            return productSectionItem;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(66746);
            if (view == null) {
                view = View.inflate(MallOrderProductListUI.this, R.layout.b68, null);
                b bVar2 = new b(MallOrderProductListUI.this, (byte) 0);
                bVar2.qdu = (ImageView) view.findViewById(R.id.e3i);
                bVar2.APT = (TextView) view.findViewById(R.id.e3h);
                bVar2.APU = (TextView) view.findViewById(R.id.e3e);
                bVar2.APV = (TextView) view.findViewById(R.id.e3j);
                bVar2.APW = (TextView) view.findViewById(R.id.e3f);
                bVar2.APX = (TextView) view.findViewById(R.id.e3k);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            ProductSectionItem Uj = Uj(i2);
            bVar.iwv = Uj.iconUrl;
            if (TextUtils.isEmpty(bVar.iwv) || !f.bpr(bVar.iwv)) {
                bVar.qdu.setImageResource(R.raw.mall_order_detail_frame);
            } else {
                bVar.qdu.setImageBitmap(u.a(new com.tencent.mm.plugin.order.c.b(bVar.iwv)));
            }
            bVar.APT.setText(Uj.name);
            bVar.APU.setText(ProductSectionItem.Skus.fJ(Uj.APw));
            bVar.APV.setText(Uj.price);
            bVar.APW.setText("+" + Uj.count);
            u.a(bVar);
            bVar.APX.setVisibility(8);
            AppMethodBeat.o(66746);
            return view;
        }
    }

    class b implements u.a {
        TextView APT;
        TextView APU;
        TextView APV;
        TextView APW;
        TextView APX;
        String iwv;
        ImageView qdu;

        private b() {
        }

        /* synthetic */ b(MallOrderProductListUI mallOrderProductListUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.platformtools.u.a
        public final void k(String str, final Bitmap bitmap) {
            AppMethodBeat.i(66749);
            if (str != null && str.equals(this.iwv)) {
                this.qdu.post(new Runnable() {
                    /* class com.tencent.mm.plugin.order.ui.MallOrderProductListUI.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(66748);
                        b.this.qdu.setImageBitmap(bitmap);
                        AppMethodBeat.o(66748);
                    }
                });
            }
            AppMethodBeat.o(66749);
        }
    }

    static /* synthetic */ void a(MallOrderProductListUI mallOrderProductListUI, ProductSectionItem productSectionItem) {
        AppMethodBeat.i(66755);
        if (!c.bl(mallOrderProductListUI, productSectionItem.jumpUrl)) {
            c.bm(mallOrderProductListUI, productSectionItem.APx);
        }
        AppMethodBeat.o(66755);
    }
}
