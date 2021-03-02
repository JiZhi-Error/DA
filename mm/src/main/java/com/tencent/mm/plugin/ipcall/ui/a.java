package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a {
    String countryCode;
    String jbZ;
    String jca;
    private int ysM;

    public a(String str, String str2, int i2, String str3) {
        this.jbZ = str;
        this.countryCode = str2;
        this.ysM = i2;
        this.jca = str3;
    }

    public final int ebc() {
        AppMethodBeat.i(25567);
        if (this.ysM == 0) {
            AppMethodBeat.o(25567);
            return 0;
        }
        for (String str : IPCallCountryCodeScrollbar.yuU) {
            if (str.equals(String.valueOf((char) this.ysM))) {
                int i2 = this.ysM;
                AppMethodBeat.o(25567);
                return i2;
            }
        }
        char charAt = "#".charAt(0);
        AppMethodBeat.o(25567);
        return charAt;
    }
}
