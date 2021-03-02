package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.KToastDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public class MMToastDialog implements KToastDialog {
    private static final String TAG = "MMToastDialog";

    @Override // com.tencent.kinda.gen.KToastDialog
    public void show(String str, String str2) {
        AppMethodBeat.i(214569);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "MMToastDialog showImpl() KindaContext.get() return null!");
            AppMethodBeat.o(214569);
            return;
        }
        int drawableId = ResourcesUtils.getDrawableId(MMApplicationContext.getContext(), str2);
        int resId = ResourcesUtils.getResId(MMApplicationContext.getContext(), str2, ShareConstants.DEXMODE_RAW);
        if (resId == 0) {
            resId = drawableId;
        }
        u.u(context, str, resId);
        AppMethodBeat.o(214569);
    }
}
