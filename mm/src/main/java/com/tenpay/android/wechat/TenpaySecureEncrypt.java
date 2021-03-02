package com.tenpay.android.wechat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public final class TenpaySecureEncrypt implements ISecureEncrypt {
    @Override // com.tenpay.android.wechat.ISecureEncrypt
    public final String encryptPasswdWithRSA2048(boolean z, String str, String str2) {
        AppMethodBeat.i(73251);
        if (z) {
            str = TenpayUtil.md5HexDigest(str);
        }
        Encrypt encrypt = new Encrypt();
        if (str2 != null) {
            encrypt.setTimeStamp(str2);
        }
        String encryptPasswdWithRSA2048 = encrypt.encryptPasswdWithRSA2048(str);
        AppMethodBeat.o(73251);
        return encryptPasswdWithRSA2048;
    }

    @Override // com.tenpay.android.wechat.ISecureEncrypt
    public final String encryptPasswd(boolean z, String str, String str2) {
        AppMethodBeat.i(73252);
        if (z) {
            str = TenpayUtil.md5HexDigest(str);
        }
        Encrypt encrypt = new Encrypt();
        if (str2 != null) {
            encrypt.setTimeStamp(str2);
        }
        String encryptPasswd = encrypt.encryptPasswd(str);
        AppMethodBeat.o(73252);
        return encryptPasswd;
    }

    @Override // com.tenpay.android.wechat.ISecureEncrypt
    public final String desedeEncode(String str, String str2) {
        AppMethodBeat.i(73253);
        String desedeEncode = new Encrypt().desedeEncode(str);
        AppMethodBeat.o(73253);
        return desedeEncode;
    }

    @Override // com.tenpay.android.wechat.ISecureEncrypt
    public final String desedeVerifyCode(String str, String str2) {
        AppMethodBeat.i(73254);
        String desedeVerifyCode = new Encrypt().desedeVerifyCode(str);
        AppMethodBeat.o(73254);
        return desedeVerifyCode;
    }
}
