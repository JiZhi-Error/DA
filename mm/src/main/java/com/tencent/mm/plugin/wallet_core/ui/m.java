package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public final class m {
    public static d a(Context context, b bVar, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(70939);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(70939);
            return null;
        } else if (bVar == null || (TextUtils.isEmpty(bVar.HVg) && (bVar.HVh == null || bVar.HVh.isEmpty()))) {
            Log.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
            AppMethodBeat.o(70939);
            return null;
        } else {
            d.a aVar = new d.a(context);
            aVar.Dk(false);
            aVar.aoW(R.string.sz).d(onClickListener2);
            aVar.aoV(R.string.i5y).c(onClickListener);
            View inflate = View.inflate(context, R.layout.c8y, null);
            if (bVar.HVh == null || bVar.HVh.isEmpty()) {
                Log.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
            } else {
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.be3);
                linearLayout.removeAllViews();
                int i2 = 0;
                while (i2 < bVar.HVh.size() && i2 < bVar.HVh.size()) {
                    View inflate2 = View.inflate(context, R.layout.c8x, null);
                    ((TextView) inflate2.findViewById(R.id.ipm)).setText(bVar.HVh.get(i2).key);
                    ((TextView) inflate2.findViewById(R.id.idt)).setText(bVar.HVh.get(i2).value);
                    linearLayout.addView(inflate2, i2);
                    i2++;
                }
            }
            ((TextView) inflate.findViewById(R.id.ipm)).setText(bVar.HVg);
            TextView textView = (TextView) inflate.findViewById(R.id.iov);
            textView.setVisibility(0);
            textView.setText(context.getString(R.string.i5z));
            aVar.hs(inflate);
            d hbn = aVar.hbn();
            hbn.show();
            h.a(context, hbn);
            AppMethodBeat.o(70939);
            return hbn;
        }
    }
}
