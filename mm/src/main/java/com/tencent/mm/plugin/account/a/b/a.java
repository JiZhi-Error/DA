package com.tencent.mm.plugin.account.a.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class a {
    public static void b(Context context, String str, int i2, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(155384);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        if (!z) {
            z2 = true;
        }
        intent.putExtra("neverGetA8Key", z2);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        if (i2 > 0) {
            c.b(context, "webview", ".ui.tools.WebViewUI", intent, i2);
            AppMethodBeat.o(155384);
            return;
        }
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(155384);
    }

    /* renamed from: com.tencent.mm.plugin.account.a.b.a$a  reason: collision with other inner class name */
    public enum EnumC0518a {
        TwoPasswordsNotMatch,
        BeyondMaximumLength,
        NotReachMinimumLength,
        DisallowShortNumericPassword;

        public static EnumC0518a valueOf(String str) {
            AppMethodBeat.i(155382);
            EnumC0518a aVar = (EnumC0518a) Enum.valueOf(EnumC0518a.class, str);
            AppMethodBeat.o(155382);
            return aVar;
        }

        static {
            AppMethodBeat.i(155383);
            AppMethodBeat.o(155383);
        }
    }

    public static boolean V(Context context, String str) {
        AppMethodBeat.i(155385);
        if (str.length() > 16) {
            a(context, EnumC0518a.BeyondMaximumLength);
            AppMethodBeat.o(155385);
            return false;
        } else if (Util.isChinese(str)) {
            h.n(context, R.string.fyn, R.string.fzn);
            AppMethodBeat.o(155385);
            return false;
        } else if (!Util.isValidPassword(str)) {
            if (str.length() < 8 || str.length() >= 16) {
                a(context, EnumC0518a.NotReachMinimumLength);
            } else {
                a(context, EnumC0518a.DisallowShortNumericPassword);
            }
            AppMethodBeat.o(155385);
            return false;
        } else {
            AppMethodBeat.o(155385);
            return true;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(Context context, EnumC0518a aVar) {
        AppMethodBeat.i(155386);
        switch (aVar) {
            case TwoPasswordsNotMatch:
                h.n(context, R.string.fzl, R.string.fzn);
                AppMethodBeat.o(155386);
                return;
            case BeyondMaximumLength:
                h.n(context, R.string.fzm, R.string.fzn);
                AppMethodBeat.o(155386);
                return;
            case DisallowShortNumericPassword:
                h.n(context, R.string.hvj, R.string.u3);
                AppMethodBeat.o(155386);
                return;
            case NotReachMinimumLength:
                h.n(context, R.string.hvm, R.string.u3);
                break;
        }
        AppMethodBeat.o(155386);
    }
}
