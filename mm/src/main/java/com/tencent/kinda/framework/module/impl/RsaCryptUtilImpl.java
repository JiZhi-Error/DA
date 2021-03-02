package com.tencent.kinda.framework.module.impl;

import android.util.Base64;
import com.tencent.kinda.gen.RsaCryptUtil;
import com.tencent.kinda.gen.RsaEncryptResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class RsaCryptUtilImpl implements RsaCryptUtil {
    private static final String TAG = "MicroMsg.RsaCryptUtilImpl";

    @Override // com.tencent.kinda.gen.RsaCryptUtil
    public RsaEncryptResult rsaPublicEncryptPemkey(String str, String str2) {
        int i2;
        AppMethodBeat.i(18680);
        RsaEncryptResult rsaEncryptResult = new RsaEncryptResult();
        if (Util.isNullOrNil(str, str2)) {
            Log.w(TAG, "input is null");
            rsaEncryptResult.mRet = 0;
            AppMethodBeat.o(18680);
            return rsaEncryptResult;
        }
        PByteArray pByteArray = new PByteArray();
        boolean rsaPublicEncryptPemkey = MMProtocalJni.rsaPublicEncryptPemkey(str.getBytes(), pByteArray, str2.getBytes());
        if (rsaPublicEncryptPemkey && !Util.isNullOrNil(pByteArray.value)) {
            rsaEncryptResult.mBase64Str = Base64.encodeToString(pByteArray.value, 2);
        }
        if (rsaPublicEncryptPemkey) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        rsaEncryptResult.mRet = i2;
        Log.d(TAG, "encrypt ret: %s", rsaEncryptResult);
        AppMethodBeat.o(18680);
        return rsaEncryptResult;
    }
}
