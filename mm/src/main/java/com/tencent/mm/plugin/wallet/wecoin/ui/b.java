package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.ui.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEntranceTutorialDialog;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", "mBottomSheet", "Lcom/tencent/mm/plugin/wallet/ui/CommonBottomSheet;", "mCustomView", "Landroid/view/View;", "mOuterClickListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IBtnClickListener;", "initCustomView", "", "initView", "Landroid/content/Context;", "setSingleButtonClickListener", "clickListener", "plugin-wxpay_release"})
public final class b implements com.tencent.mm.plugin.wallet.wecoin.a.b {
    com.tencent.mm.plugin.wallet.wecoin.a.a HOU;
    com.tencent.mm.plugin.wallet.ui.b HOb;
    private View ahJ;
    private final Activity dKq;

    public b(Activity activity) {
        boolean z;
        boolean z2;
        p.h(activity, "context");
        AppMethodBeat.i(212841);
        this.dKq = activity;
        Activity activity2 = this.dKq;
        this.HOb = new com.tencent.mm.plugin.wallet.ui.b(activity2, 2, 0);
        com.tencent.mm.plugin.wallet.ui.b bVar = this.HOb;
        if (bVar == null) {
            p.btv("mBottomSheet");
        }
        bVar.yf(true);
        com.tencent.mm.plugin.wallet.ui.b bVar2 = this.HOb;
        if (bVar2 == null) {
            p.btv("mBottomSheet");
        }
        bVar2.T(activity2.getString(R.string.j2c));
        com.tencent.mm.plugin.wallet.ui.b bVar3 = this.HOb;
        if (bVar3 == null) {
            p.btv("mBottomSheet");
        }
        bVar3.aeF(activity2.getResources().getColor(R.color.ae));
        com.tencent.mm.plugin.wallet.ui.b bVar4 = this.HOb;
        if (bVar4 == null) {
            p.btv("mBottomSheet");
        }
        bVar4.fPx();
        com.tencent.mm.plugin.wallet.ui.b bVar5 = this.HOb;
        if (bVar5 == null) {
            p.btv("mBottomSheet");
        }
        bVar5.a(new a(this));
        View inflate = View.inflate(this.dKq, R.layout.azj, null);
        p.g(inflate, "View.inflate(context, R.…ce_tutorial_dialog, null)");
        this.ahJ = inflate;
        View view = this.ahJ;
        if (view == null) {
            p.btv("mCustomView");
        }
        TextView textView = (TextView) view.findViewById(R.id.jml);
        p.g(textView, "textView");
        ao.a(textView.getPaint(), 0.8f);
        View view2 = this.ahJ;
        if (view2 == null) {
            p.btv("mCustomView");
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.jlz);
        View view3 = this.ahJ;
        if (view3 == null) {
            p.btv("mCustomView");
        }
        TextView textView2 = (TextView) view3.findViewById(R.id.jmm);
        p.g(textView2, "userNameTV");
        ao.a(textView2.getPaint(), 0.8f);
        String aTY = z.aTY();
        String aUa = z.aUa();
        String str = aUa;
        aUa = str == null || str.length() == 0 ? z.aUb() : aUa;
        String str2 = aUa;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        aUa = z ? aTY : aUa;
        String str3 = aTY;
        if (str3 == null || str3.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && g.aAc()) {
            a.b.c(imageView, aTY);
        }
        textView2.setText(aUa);
        com.tencent.mm.plugin.wallet.ui.b bVar6 = this.HOb;
        if (bVar6 == null) {
            p.btv("mBottomSheet");
        }
        View view4 = this.ahJ;
        if (view4 == null) {
            p.btv("mCustomView");
        }
        bVar6.setCustomView(view4);
        com.tencent.mm.plugin.wallet.ui.b bVar7 = this.HOb;
        if (bVar7 == null) {
            p.btv("mBottomSheet");
        }
        bVar7.dGm();
        AppMethodBeat.o(212841);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    static final class a implements b.AbstractC1908b {
        final /* synthetic */ b HOV;

        a(b bVar) {
            this.HOV = bVar;
        }

        @Override // com.tencent.mm.plugin.wallet.ui.b.AbstractC1908b
        public final void onClick() {
            AppMethodBeat.i(212840);
            com.tencent.mm.plugin.wallet.ui.b bVar = this.HOV.HOb;
            if (bVar == null) {
                p.btv("mBottomSheet");
            }
            bVar.bMo();
            com.tencent.mm.plugin.wallet.wecoin.a.a aVar = this.HOV.HOU;
            if (aVar != null) {
                aVar.onClick();
                AppMethodBeat.o(212840);
                return;
            }
            AppMethodBeat.o(212840);
        }
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.b
    public final void a(com.tencent.mm.plugin.wallet.wecoin.a.a aVar) {
        this.HOU = aVar;
    }
}
