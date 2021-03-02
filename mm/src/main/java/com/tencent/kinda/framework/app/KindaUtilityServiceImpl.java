package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KUtilityService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.ndk.Encrypt;

public class KindaUtilityServiceImpl implements KUtilityService {
    @Override // com.tencent.kinda.gen.KUtilityService
    public String qmfCardStrLimitLen(String str, int i2) {
        AppMethodBeat.i(18529);
        if (i2 < 0) {
            AppMethodBeat.o(18529);
        } else {
            try {
                str = str.substring(0, str.offsetByCodePoints(0, i2)) + "...";
                AppMethodBeat.o(18529);
            } catch (IndexOutOfBoundsException e2) {
                Log.e("KindaUtilityServiceImpl", "IndexOutOfBoundsException error");
                AppMethodBeat.o(18529);
            }
        }
        return str;
    }

    @Override // com.tencent.kinda.gen.KUtilityService
    public String get3DesEncryptResult(String str) {
        AppMethodBeat.i(214426);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(214426);
            return "";
        }
        String desedeEncode = new Encrypt().desedeEncode(str);
        if (Util.isNullOrNil(desedeEncode)) {
            AppMethodBeat.o(214426);
            return "";
        }
        AppMethodBeat.o(214426);
        return desedeEncode;
    }
}
