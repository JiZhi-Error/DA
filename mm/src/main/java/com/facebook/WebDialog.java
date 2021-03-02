package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebDialog {
    private WebDialog() {
    }

    public static int getWebDialogTheme() {
        AppMethodBeat.i(7621);
        int webDialogTheme = com.facebook.internal.WebDialog.getWebDialogTheme();
        AppMethodBeat.o(7621);
        return webDialogTheme;
    }

    public static void setWebDialogTheme(int i2) {
        AppMethodBeat.i(7622);
        com.facebook.internal.WebDialog.setWebDialogTheme(i2);
        AppMethodBeat.o(7622);
    }
}
