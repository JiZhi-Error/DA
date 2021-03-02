package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.f;
import java.math.RoundingMode;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mArrivalAccountStateDescTv", "Landroid/widget/TextView;", "mArrivalState", "Landroid/widget/ImageView;", "mArrivalStateTitleTv", "mCftHandleStateDescTv", "mCftHandleStateIv", "mCftHandleStateTitleTv", "mContentLayout", "Landroid/widget/LinearLayout;", "mOrders", "Lcom/tencent/mm/plugin/wallet_core/model/Orders;", "mPaymentStateDescTv", "mPaymentStateIv", "mPaymentStateTitleTv", "mWecoinEncashKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getLayoutId", "", "initView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reportKVStatus", "value", "updateData", "Companion", "plugin-wxpay_release"})
public final class WeCoinBalanceDetailView extends MMActivity {
    public static final a HOJ = new a((byte) 0);
    private Orders CwO;
    private ImageView HOA;
    private ImageView HOB;
    private TextView HOC;
    private TextView HOD;
    private TextView HOE;
    private TextView HOF;
    private TextView HOG;
    private TextView HOH;
    private WecoinEncashKVData HOI;
    private ImageView HOz;
    private LinearLayout ncf;

    static {
        AppMethodBeat.i(212796);
        AppMethodBeat.o(212796);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ void a(WeCoinBalanceDetailView weCoinBalanceDetailView, int i2) {
        AppMethodBeat.i(212797);
        weCoinBalanceDetailView.aeH(i2);
        AppMethodBeat.o(212797);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(212792);
        super.onCreate(bundle);
        initView();
        TextView textView = this.HOG;
        if (textView == null) {
            p.btv("mCftHandleStateDescTv");
        }
        Orders orders = this.CwO;
        if (orders == null) {
            p.btv("mOrders");
        }
        textView.setText(orders.HYX);
        TextView textView2 = this.HOG;
        if (textView2 == null) {
            p.btv("mCftHandleStateDescTv");
        }
        textView2.setVisibility(0);
        TextView textView3 = this.HOH;
        if (textView3 == null) {
            p.btv("mArrivalAccountStateDescTv");
        }
        textView3.setVisibility(8);
        LinearLayout linearLayout = this.ncf;
        if (linearLayout == null) {
            p.btv("mContentLayout");
        }
        linearLayout.setBackgroundResource(R.drawable.f0);
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
        StringBuilder sb = new StringBuilder();
        Orders orders2 = this.CwO;
        if (orders2 == null) {
            p.btv("mOrders");
        }
        double doubleValue = f.b(sb.append(orders2.dDO).toString(), "100", 2, RoundingMode.HALF_UP).doubleValue();
        Orders orders3 = this.CwO;
        if (orders3 == null) {
            p.btv("mOrders");
        }
        walletBalanceFetchResultItemView.b(R.string.i76, f.d(doubleValue, orders3.AOl));
        LinearLayout linearLayout2 = this.ncf;
        if (linearLayout2 == null) {
            p.btv("mContentLayout");
        }
        linearLayout2.addView(walletBalanceFetchResultItemView);
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
        walletBalanceFetchResultItemView2.b(R.string.j27, getString(R.string.i5u));
        LinearLayout linearLayout3 = this.ncf;
        if (linearLayout3 == null) {
            p.btv("mContentLayout");
        }
        linearLayout3.addView(walletBalanceFetchResultItemView2);
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView3 = new WalletBalanceFetchResultItemView(this);
        walletBalanceFetchResultItemView3.b(R.string.j2_, getString(R.string.j29));
        LinearLayout linearLayout4 = this.ncf;
        if (linearLayout4 == null) {
            p.btv("mContentLayout");
        }
        linearLayout4.addView(walletBalanceFetchResultItemView3);
        ((Button) findViewById(R.id.acj)).setOnClickListener(new c(this));
        View findViewById = findViewById(R.id.ad1);
        p.g(findViewById, "findViewById<View>(R.id.brdu_timeline_mask)");
        findViewById.setVisibility(8);
        View findViewById2 = findViewById(R.id.ach);
        p.g(findViewById2, "findViewById<View>(R.id.brdu_content_mask)");
        findViewById2.setVisibility(8);
        AppMethodBeat.o(212792);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(212793);
        aeH(23);
        super.onBackPressed();
        AppMethodBeat.o(212793);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(212794);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("key_orders");
        p.g(parcelableExtra, "intent.getParcelableExtr…WalletProcess.KEY_ORDERS)");
        this.CwO = (Orders) parcelableExtra;
        this.HOI = (WecoinEncashKVData) getIntent().getParcelableExtra("wecoin_fetch_result_kv_data");
        Orders orders = this.CwO;
        if (orders == null) {
            p.btv("mOrders");
        }
        if (orders == null) {
            Log.w("MicroMsg.WeCoinFetchResultUI", "order is null!");
            finish();
            AppMethodBeat.o(212794);
            return;
        }
        View findViewById = findViewById(R.id.acp);
        p.g(findViewById, "findViewById(R.id.brdu_state_iv_1)");
        this.HOz = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.acq);
        p.g(findViewById2, "findViewById(R.id.brdu_state_iv_2)");
        this.HOA = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.acr);
        p.g(findViewById3, "findViewById(R.id.brdu_state_iv_3)");
        this.HOB = (ImageView) findViewById3;
        ImageView imageView = this.HOz;
        if (imageView == null) {
            p.btv("mPaymentStateIv");
        }
        imageView.setImageResource(R.drawable.f1);
        ImageView imageView2 = this.HOA;
        if (imageView2 == null) {
            p.btv("mCftHandleStateIv");
        }
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView imageView3 = this.HOA;
        if (imageView3 == null) {
            p.btv("mCftHandleStateIv");
        }
        imageView3.setImageResource(R.raw.remittance_wait);
        ImageView imageView4 = this.HOB;
        if (imageView4 == null) {
            p.btv("mArrivalState");
        }
        imageView4.setImageResource(R.drawable.f2);
        View findViewById4 = findViewById(R.id.acx);
        p.g(findViewById4, "findViewById(R.id.brdu_state_title_tv_1)");
        this.HOC = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.acy);
        p.g(findViewById5, "findViewById(R.id.brdu_state_title_tv_2)");
        this.HOD = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.acz);
        p.g(findViewById6, "findViewById(R.id.brdu_state_title_tv_3)");
        this.HOE = (TextView) findViewById6;
        TextView textView = this.HOC;
        if (textView == null) {
            p.btv("mPaymentStateTitleTv");
        }
        textView.setText(R.string.i6j);
        TextView textView2 = this.HOD;
        if (textView2 == null) {
            p.btv("mCftHandleStateTitleTv");
        }
        textView2.setText(R.string.j28);
        TextView textView3 = this.HOD;
        if (textView3 == null) {
            p.btv("mCftHandleStateTitleTv");
        }
        textView3.setTextColor(getResources().getColor(R.color.a2x));
        TextView textView4 = this.HOE;
        if (textView4 == null) {
            p.btv("mArrivalStateTitleTv");
        }
        textView4.setText(R.string.i6e);
        View findViewById7 = findViewById(R.id.acm);
        p.g(findViewById7, "findViewById(R.id.brdu_state_desc_tv_1)");
        this.HOF = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.acn);
        p.g(findViewById8, "findViewById(R.id.brdu_state_desc_tv_2)");
        this.HOG = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.aco);
        p.g(findViewById9, "findViewById(R.id.brdu_state_desc_tv_3)");
        this.HOH = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.acg);
        p.g(findViewById10, "findViewById(R.id.brdu_content_layout)");
        this.ncf = (LinearLayout) findViewById10;
        TextView textView5 = this.HOF;
        if (textView5 == null) {
            p.btv("mPaymentStateDescTv");
        }
        textView5.setVisibility(8);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitle(R.string.j2d);
        setBackBtn(new b(this));
        AppMethodBeat.o(212794);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WeCoinBalanceDetailView HOK;

        b(WeCoinBalanceDetailView weCoinBalanceDetailView) {
            this.HOK = weCoinBalanceDetailView;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(212790);
            WeCoinBalanceDetailView.a(this.HOK, 23);
            this.HOK.finish();
            AppMethodBeat.o(212790);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ WeCoinBalanceDetailView HOK;

        c(WeCoinBalanceDetailView weCoinBalanceDetailView) {
            this.HOK = weCoinBalanceDetailView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212791);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView$updateData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WeCoinBalanceDetailView.a(this.HOK, 22);
            this.HOK.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinBalanceDetailView$updateData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212791);
        }
    }

    private final void aeH(int i2) {
        int i3;
        String str;
        String str2;
        AppMethodBeat.i(212795);
        WecoinEncashKVData wecoinEncashKVData = this.HOI;
        if (wecoinEncashKVData != null) {
            i3 = wecoinEncashKVData.HNZ;
        } else {
            i3 = 1;
        }
        WecoinEncashKVData wecoinEncashKVData2 = this.HOI;
        if (wecoinEncashKVData2 == null || (str = wecoinEncashKVData2.HMK) == null) {
            str = "";
        }
        WecoinEncashKVData wecoinEncashKVData3 = this.HOI;
        if (wecoinEncashKVData3 == null || (str2 = wecoinEncashKVData3.nZz) == null) {
            str2 = "";
        }
        h.INSTANCE.a(21655, Integer.valueOf(i3), str, Integer.valueOf(i2), str2);
        AppMethodBeat.o(212795);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ic;
    }
}
