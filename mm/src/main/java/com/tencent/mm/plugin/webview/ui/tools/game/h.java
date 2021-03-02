package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h {
    public static String JrK;
    public static String eam;
    public static int ehX;

    public h(Intent intent) {
        AppMethodBeat.i(80955);
        if (intent == null) {
            AppMethodBeat.o(80955);
            return;
        }
        eam = Util.nullAsNil(intent.getStringExtra("KPublisherId"));
        JrK = Util.nullAsNil(intent.getStringExtra("geta8key_username"));
        ehX = Util.nullAsNil(Integer.valueOf(intent.getIntExtra("geta8key_scene", 0)));
        AppMethodBeat.o(80955);
    }
}
