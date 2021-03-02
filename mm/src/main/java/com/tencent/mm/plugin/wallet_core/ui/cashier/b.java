package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import org.xwalk.core.Log;

public final class b extends i {
    private ImageView Img = ((ImageView) this.jBN.findViewById(R.id.jpn));
    ViewGroup Imh = ((ViewGroup) this.jBN.findViewById(R.id.jpo));
    private View jBN = View.inflate(getContext(), R.layout.cau, null);
    TextView mPa = ((TextView) this.jBN.findViewById(R.id.jji));

    public b(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(71417);
        ImageView imageView = this.Img;
        int i2 = WcPayCashierDialog.Ill;
        int i3 = WcPayCashierDialog.Ill;
        Util.expandViewTouchArea(imageView, i2, i2, i3, i3);
        this.Img.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(71416);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WcPayCashierFetchFavorDialog", "click back");
                b.this.cancel();
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71416);
            }
        });
        setContentView(this.jBN);
        setCanceledOnTouchOutside(false);
        AppMethodBeat.o(71417);
    }
}
