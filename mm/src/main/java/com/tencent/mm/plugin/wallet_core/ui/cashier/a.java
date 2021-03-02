package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends i {
    Orders CwO = new Orders();
    com.tencent.mm.plugin.wallet_core.utils.a HCH;
    FavorPayInfo HGf;
    Bankcard HJA;
    private ImageView IkS;
    ViewGroup IkT;
    TextView IkU;
    List<WcPayCashierBankcardItemLayout> IkV = new ArrayList();
    int IkW;
    boolean IkX;
    int IkY;
    boolean IkZ = true;
    AbstractC1921a Ila;
    WcPayCashierDialog.b Ilb = new WcPayCashierDialog.b() {
        /* class com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.b
        public final void fTr() {
            AppMethodBeat.i(71307);
            Log.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
            a.this.dismiss();
            AppMethodBeat.o(71307);
        }
    };
    private Context mContext;
    PayInfo mPayInfo = new PayInfo();
    private ViewGroup nmW;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.cashier.a$a  reason: collision with other inner class name */
    public interface AbstractC1921a {
        void fNc();

        void j(Bankcard bankcard);

        void onCancel();
    }

    public a(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(71314);
        this.mContext = context;
        this.nmW = (ViewGroup) View.inflate(getContext(), R.layout.cap, null);
        this.IkS = (ImageView) this.nmW.findViewById(R.id.jp3);
        this.IkT = (ViewGroup) this.nmW.findViewById(R.id.jp0);
        this.IkU = (TextView) this.nmW.findViewById(R.id.jp5);
        ImageView imageView = this.IkS;
        int i2 = WcPayCashierDialog.Ill;
        int i3 = WcPayCashierDialog.Ill;
        Util.expandViewTouchArea(imageView, i2, i2, i3, i3);
        this.IkS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(71310);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.this.cancel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierBankcardDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71310);
            }
        });
        setContentView(this.nmW);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(71308);
                if (a.this.Ila != null) {
                    a.this.Ila.onCancel();
                }
                AppMethodBeat.o(71308);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.cashier.a.AnonymousClass3 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(71309);
                a.this.HCH.destory();
                AppMethodBeat.o(71309);
            }
        });
        this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
        AppMethodBeat.o(71314);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(71315);
        super.onCreate(bundle);
        if (this.mPayInfo == null) {
            Log.w("MicroMsg.WcPayCashierBankcardDialog", "pay info is null!!");
            dismiss();
        }
        ab.mg(7, 0);
        AppMethodBeat.o(71315);
    }

    public final void a(WcPayCashierDialog wcPayCashierDialog) {
        AppMethodBeat.i(71316);
        wcPayCashierDialog.IlY.remove(this.Ilb);
        AppMethodBeat.o(71316);
    }

    /* access modifiers changed from: package-private */
    public final LinkedList<String> h(Bankcard bankcard) {
        AppMethodBeat.i(71317);
        LinkedList<String> linkedList = new LinkedList<>();
        if (!(this.CwO == null || this.CwO.HZe == null || this.CwO.HZe.HEE == null)) {
            Iterator<c> it = this.CwO.HZe.HEE.HDZ.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.ANo.equals(bankcard.field_bindSerial)) {
                    Iterator<d> it2 = next.HEk.iterator();
                    while (it2.hasNext()) {
                        linkedList.add(it2.next().Coh);
                    }
                    AppMethodBeat.o(71317);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.o(71317);
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public final LinkedList<String> fTq() {
        n nVar;
        AppMethodBeat.i(71318);
        LinkedList<String> linkedList = new LinkedList<>();
        if (this.CwO == null || this.CwO.HZe == null || this.CwO.HZe.HEE == null || (nVar = this.CwO.HZe.HEE.HEa) == null) {
            AppMethodBeat.o(71318);
            return linkedList;
        }
        Iterator<o> it = nVar.HEQ.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().Coh);
        }
        AppMethodBeat.o(71318);
        return linkedList;
    }

    static /* synthetic */ void a(a aVar, View view) {
        AppMethodBeat.i(71319);
        for (WcPayCashierBankcardItemLayout wcPayCashierBankcardItemLayout : aVar.IkV) {
            if (wcPayCashierBankcardItemLayout == view) {
                wcPayCashierBankcardItemLayout.Ilf.setChecked(true);
            } else {
                wcPayCashierBankcardItemLayout.Ilf.setChecked(false);
            }
        }
        AppMethodBeat.o(71319);
    }
}
