package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.k;
import java.util.ArrayList;

public final class a extends k {
    @Override // com.tencent.mm.plugin.wallet_core.ui.k
    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(72101);
        Bankcard aeu = aeu(i2);
        AppMethodBeat.o(72101);
        return aeu;
    }

    public a(Context context, ArrayList<Bankcard> arrayList, int i2, Orders orders) {
        super(context, arrayList, i2, orders);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.k
    public final int getCount() {
        AppMethodBeat.i(72099);
        if (this.Hva == null || this.Hva.size() == 0) {
            AppMethodBeat.o(72099);
            return 1;
        }
        int size = this.Hva.size();
        AppMethodBeat.o(72099);
        return size;
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.k
    public final Bankcard aeu(int i2) {
        AppMethodBeat.i(72100);
        if (this.Hva != null && this.Hva.size() != 0) {
            Bankcard bankcard = (Bankcard) this.Hva.get(i2);
            AppMethodBeat.o(72100);
            return bankcard;
        } else if (i2 != getCount() - 1) {
            Bankcard bankcard2 = (Bankcard) this.Hva.get(i2);
            AppMethodBeat.o(72100);
            return bankcard2;
        } else {
            AppMethodBeat.o(72100);
            return null;
        }
    }
}
