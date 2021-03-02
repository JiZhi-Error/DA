package com.tencent.mm.network;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.StandardCharsets;

public final class b {
    private static b jDF = new b();
    public dfx jDB = new dfx();
    public String jDC = "";
    private String jDD = "";
    private long jDE = 0;

    public static class a {
        public String jDC = "";
        public String jDD = "";
    }

    static {
        AppMethodBeat.i(197089);
        AppMethodBeat.o(197089);
    }

    private b() {
        AppMethodBeat.i(197081);
        AppMethodBeat.o(197081);
    }

    public static b bjq() {
        return jDF;
    }

    public final String RO(String str) {
        boolean z = true;
        AppMethodBeat.i(197082);
        if (TextUtils.isEmpty(this.jDC)) {
            try {
                String[] aZl = g.aAg().hqi.iMw.aZl();
                if (aZl == null || aZl.length != 2 || TextUtils.isEmpty(aZl[0]) || TextUtils.isEmpty(aZl[1])) {
                    StringBuilder sb = new StringBuilder("backup key is empty ");
                    if (aZl != null) {
                        z = false;
                    }
                    Log.w("CgiSignerPublicAndPrivateKey", sb.append(z).toString());
                } else {
                    this.jDD = aZl[0];
                    this.jDC = aZl[1];
                    Log.w("CgiSignerPublicAndPrivateKey", "origin key is empty, use backup key " + this.jDD.length() + " " + this.jDC.length());
                }
            } catch (Exception e2) {
                Log.e("CgiSignerPublicAndPrivateKey", "try restore key from push failed " + e2.getLocalizedMessage());
            }
        }
        try {
            byte[] ecdsaSignWithOctKey = UtilsJni.ecdsaSignWithOctKey(this.jDC.getBytes(StandardCharsets.ISO_8859_1), str.getBytes(StandardCharsets.ISO_8859_1));
            if (ecdsaSignWithOctKey == null) {
                Log.e("CgiSignerPublicAndPrivateKey", "sign result is null ");
                AppMethodBeat.o(197082);
                return "";
            }
            Log.d("CgiSignerPublicAndPrivateKey", "sign result length " + ecdsaSignWithOctKey.length);
            String str2 = new String(ecdsaSignWithOctKey, StandardCharsets.ISO_8859_1);
            AppMethodBeat.o(197082);
            return str2;
        } catch (Exception e3) {
            Log.e("CgiSignerPublicAndPrivateKey", "sign data failed " + e3.getLocalizedMessage());
            AppMethodBeat.o(197082);
            return "";
        }
    }

    public final byte[] az(byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(197083);
        if (bArr == null) {
            AppMethodBeat.o(197083);
            return null;
        }
        if (TextUtils.isEmpty(this.jDC)) {
            try {
                String[] aZl = g.aAg().hqi.iMw.aZl();
                if (aZl == null || aZl.length != 2 || TextUtils.isEmpty(aZl[0]) || TextUtils.isEmpty(aZl[1])) {
                    StringBuilder sb = new StringBuilder("backup key is empty ");
                    if (aZl != null) {
                        z = false;
                    }
                    Log.w("CgiSignerPublicAndPrivateKey", sb.append(z).toString());
                } else {
                    this.jDD = aZl[0];
                    this.jDC = aZl[1];
                    Log.w("CgiSignerPublicAndPrivateKey", "origin key is empty, use backup key " + this.jDD.length() + " " + this.jDC.length());
                }
            } catch (Exception e2) {
                Log.e("CgiSignerPublicAndPrivateKey", "try restore key from push failed " + e2.getLocalizedMessage());
            }
        }
        try {
            byte[] ecdsaSignWithOctKey = UtilsJni.ecdsaSignWithOctKey(this.jDC.getBytes(StandardCharsets.ISO_8859_1), bArr);
            if (ecdsaSignWithOctKey == null) {
                Log.e("CgiSignerPublicAndPrivateKey", "sign result is null ");
                AppMethodBeat.o(197083);
                return null;
            }
            Log.d("CgiSignerPublicAndPrivateKey", "sign byte result length " + ecdsaSignWithOctKey.length);
            AppMethodBeat.o(197083);
            return ecdsaSignWithOctKey;
        } catch (Exception e3) {
            Log.e("CgiSignerPublicAndPrivateKey", "sign data byte failed " + e3.getLocalizedMessage());
            AppMethodBeat.o(197083);
            return null;
        }
    }

    public final int bL(String str, String str2) {
        AppMethodBeat.i(197084);
        try {
            int ecdsaVerifyWithOctKey = UtilsJni.ecdsaVerifyWithOctKey(this.jDD.getBytes(StandardCharsets.ISO_8859_1), str.getBytes(StandardCharsets.ISO_8859_1), str2.getBytes(StandardCharsets.ISO_8859_1));
            Log.d("CgiSignerPublicAndPrivateKey", "verify result ".concat(String.valueOf(ecdsaVerifyWithOctKey)));
            AppMethodBeat.o(197084);
            return ecdsaVerifyWithOctKey;
        } catch (Exception e2) {
            Log.e("CgiSignerPublicAndPrivateKey", "verify failed " + e2.getLocalizedMessage());
            AppMethodBeat.o(197084);
            return -1;
        }
    }

    public final String bjr() {
        AppMethodBeat.i(197085);
        if (!bju() || bjs()) {
            String str = this.jDD;
            AppMethodBeat.o(197085);
            return str;
        }
        Log.e("CgiSignerPublicAndPrivateKey", "gen keypair failed");
        AppMethodBeat.o(197085);
        return "";
    }

    private boolean bjs() {
        boolean z = true;
        AppMethodBeat.i(197086);
        byte[][] ecdsaGeneralOctKeyPair = UtilsJni.ecdsaGeneralOctKeyPair();
        if (ecdsaGeneralOctKeyPair == null || ecdsaGeneralOctKeyPair.length == 0 || ecdsaGeneralOctKeyPair.length == 1) {
            StringBuilder sb = new StringBuilder("gen keypair failed ");
            if (ecdsaGeneralOctKeyPair != null) {
                z = false;
            }
            Log.w("CgiSignerPublicAndPrivateKey", sb.append(z).toString());
            AppMethodBeat.o(197086);
            return false;
        }
        try {
            this.jDD = new String(ecdsaGeneralOctKeyPair[0], StandardCharsets.ISO_8859_1);
            this.jDC = new String(ecdsaGeneralOctKeyPair[1], StandardCharsets.ISO_8859_1);
            if (!bjt()) {
                Log.e("CgiSignerPublicAndPrivateKey", "public or private key is empty, public key is empty: " + TextUtils.isEmpty(this.jDD) + ", private key is empty: " + TextUtils.isEmpty(this.jDC));
                AppMethodBeat.o(197086);
                return false;
            }
            Log.i("CgiSignerPublicAndPrivateKey", "public key length " + this.jDD.length() + " private key length " + this.jDC.length());
            this.jDE = System.currentTimeMillis();
            this.jDB.KLU = new SKBuiltinBuffer_t().setBuffer(this.jDD.getBytes(StandardCharsets.ISO_8859_1));
            this.jDB.LrO = 415;
            AppMethodBeat.o(197086);
            return true;
        } catch (Exception e2) {
            Log.e("CgiSignerPublicAndPrivateKey", "gen keypair failed: " + e2.getLocalizedMessage());
            AppMethodBeat.o(197086);
            return false;
        }
    }

    private boolean bjt() {
        AppMethodBeat.i(197087);
        if (TextUtils.isEmpty(this.jDD) || TextUtils.isEmpty(this.jDC)) {
            AppMethodBeat.o(197087);
            return false;
        }
        AppMethodBeat.o(197087);
        return true;
    }

    private boolean bju() {
        AppMethodBeat.i(197088);
        if (System.currentTimeMillis() - this.jDE > Util.MILLSECONDS_OF_DAY) {
            AppMethodBeat.o(197088);
            return true;
        } else if (!bjt()) {
            AppMethodBeat.o(197088);
            return true;
        } else {
            AppMethodBeat.o(197088);
            return false;
        }
    }
}
