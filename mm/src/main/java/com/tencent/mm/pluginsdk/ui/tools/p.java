package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@TargetApi(11)
public final class p {
    public static void a(ListView listView, int i2, int i3, boolean z) {
        AppMethodBeat.i(141185);
        if (listView == null) {
            AppMethodBeat.o(141185);
            return;
        }
        Log.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", Integer.valueOf(i2), Boolean.valueOf(z));
        listView.setItemChecked(i2, true);
        listView.setSelectionFromTop(i2, i3);
        AppMethodBeat.o(141185);
    }
}
