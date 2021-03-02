package com.tencent.mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.d;

public final class i {
    public d HWP = new d();
    public String crt_token = "";
    public String crt_wording = "";
    public int is_gen_cert = 0;
    public int is_hint_cert = 0;
    public int is_ignore_cert = 0;

    public i() {
        AppMethodBeat.i(70256);
        AppMethodBeat.o(70256);
    }

    public i(Bundle bundle) {
        AppMethodBeat.i(70257);
        this.is_gen_cert = bundle.getInt("key_is_gen_cert", 0);
        this.is_hint_cert = bundle.getInt("key_is_hint_crt", 0);
        this.is_ignore_cert = bundle.getInt("key_is_ignore_cert", 0);
        this.crt_token = bundle.getString("key_crt_token", "");
        this.crt_wording = bundle.getString("key_crt_wording", "");
        this.HWP = new d(this.crt_wording);
        AppMethodBeat.o(70257);
    }

    public final boolean fQm() {
        AppMethodBeat.i(70258);
        if (this.is_hint_cert == 0 || Util.isNullOrNil(this.crt_wording)) {
            AppMethodBeat.o(70258);
            return false;
        }
        AppMethodBeat.o(70258);
        return true;
    }

    public final boolean fQn() {
        if (this.is_gen_cert == 1) {
            return true;
        }
        return false;
    }

    public final boolean fQo() {
        AppMethodBeat.i(70259);
        if (!fQn() || this.is_ignore_cert != 0) {
            AppMethodBeat.o(70259);
            return false;
        }
        AppMethodBeat.o(70259);
        return true;
    }
}
