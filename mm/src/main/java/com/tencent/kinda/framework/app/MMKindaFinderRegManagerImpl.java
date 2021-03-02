package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFinderRegManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKindaFinderRegManagerImpl implements KindaFinderRegManager {
    private final String TAG = "MicorMsg.MMFinderRegManagerImpl";

    @Override // com.tencent.kinda.gen.KindaFinderRegManager
    public void startFinderProfile(String str) {
        AppMethodBeat.i(258821);
        Log.i("MicorMsg.MMFinderRegManagerImpl", "startFinderProfile username：%s", str);
        Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        if (!(topOrUIPageFragmentActivity instanceof UIPageFragmentActivity)) {
            Log.e("MicorMsg.MMFinderRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", topOrUIPageFragmentActivity.getClass().getName());
            AppMethodBeat.o(258821);
            return;
        }
        ((aj) g.ah(aj.class)).getFinderUtilApi().dl(topOrUIPageFragmentActivity, str);
        AppMethodBeat.o(258821);
    }

    @Override // com.tencent.kinda.gen.KindaFinderRegManager
    public void startFinderFeeds(String str, String str2) {
        AppMethodBeat.i(258822);
        Log.i("MicorMsg.MMFinderRegManagerImpl", "startFinderProfile feedid：%s，nonceid：%s", str, str2);
        Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        if (!(topOrUIPageFragmentActivity instanceof UIPageFragmentActivity)) {
            Log.e("MicorMsg.MMFinderRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", topOrUIPageFragmentActivity.getClass().getName());
            AppMethodBeat.o(258822);
            return;
        }
        ((aj) g.ah(aj.class)).getFinderUtilApi().d(topOrUIPageFragmentActivity, str, str2, true);
        AppMethodBeat.o(258822);
    }
}
