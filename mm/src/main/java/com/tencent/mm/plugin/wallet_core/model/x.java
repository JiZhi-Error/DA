package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class x {
    public List<ElementQuery> HQe = null;
    public SparseArray<String> Ibf = null;
    public List<a> Ibg;

    public final String hM(Context context) {
        AppMethodBeat.i(70410);
        String av = av(context, t.fQI().fRu());
        AppMethodBeat.o(70410);
        return av;
    }

    public final String av(Context context, int i2) {
        AppMethodBeat.i(70411);
        if (this.Ibf != null) {
            String str = this.Ibf.get(i2);
            if (!Util.isNullOrNil(str)) {
                AppMethodBeat.o(70411);
                return str;
            }
        }
        String string = context.getString(R.string.i9f);
        AppMethodBeat.o(70411);
        return string;
    }

    public final ElementQuery aVi(String str) {
        AppMethodBeat.i(70412);
        if (this.HQe == null || this.HQe.size() == 0) {
            Log.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
            AppMethodBeat.o(70412);
            return null;
        }
        for (ElementQuery elementQuery : this.HQe) {
            if (elementQuery.dDj != null && elementQuery.dDj.equals(str)) {
                AppMethodBeat.o(70412);
                return elementQuery;
            }
        }
        Log.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", str);
        AppMethodBeat.o(70412);
        return null;
    }

    public final ElementQuery aVj(String str) {
        AppMethodBeat.i(70413);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
            AppMethodBeat.o(70413);
            return null;
        } else if (this.HQe == null || this.HQe.size() == 0) {
            Log.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
            AppMethodBeat.o(70413);
            return null;
        } else {
            for (ElementQuery elementQuery : this.HQe) {
                if (str.equals(elementQuery.ANo)) {
                    AppMethodBeat.o(70413);
                    return elementQuery;
                }
            }
            Log.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
            AppMethodBeat.o(70413);
            return null;
        }
    }
}
