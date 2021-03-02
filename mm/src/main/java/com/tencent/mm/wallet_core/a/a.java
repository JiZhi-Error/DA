package com.tencent.mm.wallet_core.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tenpay.android.wechat.PayuSecureEncrypt;

public final class a extends PayuSecureEncrypt {
    public a(int i2) {
        this.mEncrptType = i2;
    }

    @Override // com.tenpay.android.wechat.ISecureEncrypt, com.tenpay.android.wechat.PayuSecureEncrypt
    public final String desedeEncode(String str, String str2) {
        AppMethodBeat.i(72647);
        String nB = nB(str, str2);
        AppMethodBeat.o(72647);
        return nB;
    }

    @Override // com.tenpay.android.wechat.ISecureEncrypt, com.tenpay.android.wechat.PayuSecureEncrypt
    public final String desedeVerifyCode(String str, String str2) {
        AppMethodBeat.i(72648);
        String nB = nB(str, str2);
        AppMethodBeat.o(72648);
        return nB;
    }

    @Override // com.tenpay.android.wechat.ISecureEncrypt, com.tenpay.android.wechat.PayuSecureEncrypt
    public final String encryptPasswd(boolean z, String str, String str2) {
        AppMethodBeat.i(72649);
        String nB = nB(str, str2);
        AppMethodBeat.o(72649);
        return nB;
    }

    private String nB(String str, String str2) {
        AppMethodBeat.i(72650);
        if (!(this.mEncrptType == 40 || this.mEncrptType == -20)) {
            str = str.replaceAll(" ", "");
        }
        switch (this.mEncrptType) {
            case -20:
            case -10:
            case 60:
                String i2 = i(true, str, str2);
                AppMethodBeat.o(72650);
                return i2;
            case 20:
            case 30:
            case 40:
            case 50:
                String i3 = i(false, str, str2);
                AppMethodBeat.o(72650);
                return i3;
            default:
                AppMethodBeat.o(72650);
                return str;
        }
    }

    private String i(boolean z, String str, String str2) {
        AppMethodBeat.i(72651);
        int i2 = this.mEncrptType;
        String str3 = PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT;
        if (-20 == this.mEncrptType) {
            i2 = 40;
        } else if (-10 == this.mEncrptType) {
            i2 = 20;
        }
        if (this.mEncrptType == -10 || this.mEncrptType == -20 || this.mEncrptType == 60) {
            str3 = PayuSecureEncrypt.ENCRYPT_VERSION_HASH;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("|");
        sb.append(str3);
        sb.append("|");
        sb.append(str2);
        sb.append("|");
        if (z) {
            sb.append(MD5Util.getMD5String(str));
        } else {
            sb.append(str);
        }
        String str4 = null;
        try {
            byte[] bytes = sb.toString().getBytes();
            PByteArray pByteArray = new PByteArray();
            if (!MMProtocalJni.rsaPublicEncrypt(bytes, pByteArray, getRsaEKey().getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), getRsaNKey().getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET))) {
                Log.e("MicroMsg.WxPayuSecureEncrypt", "MMProtocalJni encrypt failed!");
            }
            str4 = "01" + Base64.encodeToString(pByteArray.value, 2);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WxPayuSecureEncrypt", e2, "", new Object[0]);
        }
        AppMethodBeat.o(72651);
        return str4;
    }
}
