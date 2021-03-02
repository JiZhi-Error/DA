package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.android.wechat.TenpaySecureEditText;

interface c {

    public static class a {
        public static String a(int i2, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.i(73139);
            if (z.aUo()) {
                Log.v("MicroMsg.IEncryptDelegate", "hy: is payu. encrypt with payu");
                new b();
                String b2 = b.b(i2, tenpaySecureEditText);
                AppMethodBeat.o(73139);
                return b2;
            }
            Log.v("MicroMsg.IEncryptDelegate", "hy: is tenpay. encrypt with tenpay");
            new C2171c();
            String b3 = C2171c.b(i2, tenpaySecureEditText);
            AppMethodBeat.o(73139);
            return b3;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.c$c  reason: collision with other inner class name */
    public static class C2171c {
        public static String b(int i2, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.i(73141);
            switch (i2) {
                case 0:
                    com.tencent.mm.wallet_core.b.hgC();
                    String encryptDataWithHash = tenpaySecureEditText.getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.hgD());
                    AppMethodBeat.o(73141);
                    return encryptDataWithHash;
                case 1:
                    com.tencent.mm.wallet_core.b.hgC();
                    String encryptDataWithHash2 = tenpaySecureEditText.getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.hgD());
                    AppMethodBeat.o(73141);
                    return encryptDataWithHash2;
                case 2:
                    String str = tenpaySecureEditText.get3DesEncrptData();
                    AppMethodBeat.o(73141);
                    return str;
                case 3:
                    String str2 = tenpaySecureEditText.get3DesVerifyCode();
                    AppMethodBeat.o(73141);
                    return str2;
                default:
                    if (tenpaySecureEditText.getText().toString() == null) {
                        AppMethodBeat.o(73141);
                        return "";
                    }
                    String obj = tenpaySecureEditText.getText().toString();
                    AppMethodBeat.o(73141);
                    return obj;
            }
        }
    }

    public static class b {
        public static String b(int i2, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.i(73140);
            tenpaySecureEditText.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(i2));
            String str = tenpaySecureEditText.get3DesEncrptData();
            AppMethodBeat.o(73140);
            return str;
        }
    }
}
