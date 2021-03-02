package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ConfigFileStorageProxyMMKV;
import com.tencent.mm.storage.an;

public final class i extends an {
    public i(String str) {
        super(str);
    }

    @Override // com.tencent.mm.storage.an
    public final synchronized long getLong(int i2, long j2) {
        AppMethodBeat.i(149327);
        if (gBE()) {
            j2 = this.NRN.getLong(i2, j2);
            AppMethodBeat.o(149327);
        } else {
            Object obj = get(i2);
            if (obj instanceof Long) {
                j2 = ((Long) obj).longValue();
                AppMethodBeat.o(149327);
            } else if (obj instanceof Integer) {
                j2 = ((Integer) obj).longValue();
                AppMethodBeat.o(149327);
            } else {
                AppMethodBeat.o(149327);
            }
        }
        return j2;
    }

    public final synchronized void setString(int i2, String str) {
        AppMethodBeat.i(149328);
        set(i2, str);
        AppMethodBeat.o(149328);
    }

    public final synchronized String getString(int i2, String str) {
        AppMethodBeat.i(149329);
        if (gBE()) {
            ConfigFileStorageProxyMMKV configFileStorageProxyMMKV = this.NRN;
            if (configFileStorageProxyMMKV.get(i2, str) instanceof String) {
                String str2 = (String) configFileStorageProxyMMKV.get(i2, str);
                AppMethodBeat.o(149329);
                str = str2;
            } else {
                AppMethodBeat.o(149329);
            }
        } else {
            try {
                Object obj = get(i2);
                if (obj instanceof String) {
                    String str3 = (String) obj;
                    AppMethodBeat.o(149329);
                    str = str3;
                } else {
                    AppMethodBeat.o(149329);
                }
            } catch (Exception e2) {
                AppMethodBeat.o(149329);
            }
        }
        return str;
    }
}
