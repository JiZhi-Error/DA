package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static Intent b(b bVar) {
        AppMethodBeat.i(21053);
        if (bVar == null) {
            Log.e("MicroMsg.AddrUtil", "addressObj == null");
            AppMethodBeat.o(21053);
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("nationalCode", bVar.kto);
        intent.putExtra("userName", bVar.ktm);
        intent.putExtra("telNumber", bVar.ktn);
        intent.putExtra("addressPostalCode", bVar.ktk);
        intent.putExtra("proviceFirstStageName", bVar.kth);
        intent.putExtra("addressCitySecondStageName", bVar.kti);
        intent.putExtra("addressCountiesThirdStageName", bVar.ktj);
        intent.putExtra("addressDetailInfo", bVar.ktl);
        AppMethodBeat.o(21053);
        return intent;
    }
}
