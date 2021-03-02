package com.tencent.mm.plugin.appbrand.launching.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;

enum b {
    WALLET("weapp://wallet/", 1019),
    SEARCH_NATIVE_FEATURE("weapp://search/", 1005);
    
    final String prefix;
    final int scene;

    public static b valueOf(String str) {
        AppMethodBeat.i(47408);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(47408);
        return bVar;
    }

    static {
        AppMethodBeat.i(47409);
        AppMethodBeat.o(47409);
    }

    private b(String str, int i2) {
        this.prefix = str;
        this.scene = i2;
    }

    static String bOa() {
        return "";
    }

    static String bOb() {
        return "";
    }

    static WeAppOpenDeclarePromptBundle R(Bundle bundle) {
        AppMethodBeat.i(227132);
        if (bundle == null) {
            AppMethodBeat.o(227132);
            return null;
        }
        WeAppOpenDeclarePromptBundle weAppOpenDeclarePromptBundle = (WeAppOpenDeclarePromptBundle) bundle.getParcelable("weapp_open_declare_prompt_key");
        AppMethodBeat.o(227132);
        return weAppOpenDeclarePromptBundle;
    }
}
