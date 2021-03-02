package com.tencent.mm.plugin.wepkg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class c implements k<Bundle, Bundle> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ Bundle invoke(Bundle bundle) {
        AppMethodBeat.i(200139);
        Log.i("IPCSyncInvokeTask_AddOfflineCallback", "cpan offline getProcessName:%s", MMApplicationContext.getProcessName());
        Bundle bundle2 = new Bundle();
        bundle2.putString("result", APMidasPayAPI.ENV_TEST);
        AppMethodBeat.o(200139);
        return bundle2;
    }
}
