package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class x {
    private boolean IVm;
    private String IVn;
    private String IVo;
    private String IVp;
    private String IVq;
    private String IVr;
    private String IVs;
    private String lang = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());

    public x(Bundle bundle) {
        AppMethodBeat.i(78478);
        this.IVm = bundle.getBoolean("close_window_confirm_dialog_switch");
        this.IVn = bundle.getString("close_window_confirm_dialog_title_cn");
        this.IVo = bundle.getString("close_window_confirm_dialog_title_eng");
        this.IVp = bundle.getString("close_window_confirm_dialog_ok_cn");
        this.IVq = bundle.getString("close_window_confirm_dialog_ok_eng");
        this.IVr = bundle.getString("close_window_confirm_dialog_cancel_cn");
        this.IVs = bundle.getString("close_window_confirm_dialog_cancel_eng");
        AppMethodBeat.o(78478);
    }

    public final boolean gci() {
        AppMethodBeat.i(78479);
        if (!this.IVm || Util.isNullOrNil(gcj()) || Util.isNullOrNil(gck()) || Util.isNullOrNil(gcl())) {
            AppMethodBeat.o(78479);
            return false;
        }
        AppMethodBeat.o(78479);
        return true;
    }

    public final String gcj() {
        AppMethodBeat.i(78480);
        if (LocaleUtil.CHINA.equals(this.lang)) {
            String str = this.IVn;
            AppMethodBeat.o(78480);
            return str;
        }
        String str2 = this.IVo;
        AppMethodBeat.o(78480);
        return str2;
    }

    public final String gck() {
        AppMethodBeat.i(78481);
        if (LocaleUtil.CHINA.equals(this.lang)) {
            String str = this.IVp;
            AppMethodBeat.o(78481);
            return str;
        }
        String str2 = this.IVq;
        AppMethodBeat.o(78481);
        return str2;
    }

    public final String gcl() {
        AppMethodBeat.i(78482);
        if (LocaleUtil.CHINA.equals(this.lang)) {
            String str = this.IVr;
            AppMethodBeat.o(78482);
            return str;
        }
        String str2 = this.IVs;
        AppMethodBeat.o(78482);
        return str2;
    }
}
