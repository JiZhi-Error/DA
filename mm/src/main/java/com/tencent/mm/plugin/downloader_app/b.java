package com.tencent.mm.plugin.downloader_app;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public final class b {
    public static void e(ImageView imageView, String str) {
        AppMethodBeat.i(183798);
        if (imageView == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(183798);
            return;
        }
        if (ao.isDarkMode()) {
            str = str + "_dark";
        }
        imageView.setImageResource(imageView.getResources().getIdentifier(str, ShareConstants.DEXMODE_RAW, imageView.getContext().getPackageName()));
        AppMethodBeat.o(183798);
    }
}
