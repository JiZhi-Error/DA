package com.tencent.soter.core.d;

import android.content.Context;
import android.util.Base64;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Signature;

public abstract class b {
    public abstract byte[] Oz(long j2);

    public abstract f bqg(String str);

    public abstract boolean bqh(String str);

    public abstract boolean bqi(String str);

    public abstract i bqj(String str);

    public abstract Signature bqk(String str);

    public abstract f dE(String str, boolean z);

    public abstract boolean hlj();

    public abstract f hlk();

    public abstract f hll();

    public abstract boolean hlm();

    public abstract boolean hln();

    public abstract i hlo();

    public abstract boolean lg(Context context);

    public abstract SoterSessionResult nI(String str, String str2);

    public boolean hlh() {
        return true;
    }

    public void hli() {
    }

    public void a(e eVar) {
    }

    protected static i cZ(byte[] bArr) {
        i iVar = null;
        if (bArr == null) {
            d.e("Soter.SoterCoreBase", "soter: raw data is null", new Object[0]);
        } else {
            if (bArr.length < 4) {
                d.e("Soter.SoterCoreBase", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
            }
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int i2 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                i2 += (bArr2[i3] & 255) << (i3 * 8);
            }
            d.d("Soter.SoterCoreBase", "soter: parsed raw length: ".concat(String.valueOf(i2)), new Object[0]);
            if (i2 > 1048576) {
                d.e("Soter.SoterCoreBase", "soter: too large json result!", new Object[0]);
            } else {
                byte[] bArr3 = new byte[i2];
                if (bArr.length < i2 + 4) {
                    d.e("Soter.SoterCoreBase", "length not correct 2", new Object[0]);
                } else {
                    System.arraycopy(bArr, 4, bArr3, 0, i2);
                    String str = new String(bArr3);
                    d.d("Soter.SoterCoreBase", "soter: to convert json: ".concat(String.valueOf(str)), new Object[0]);
                    iVar = new i(str, "");
                    int length = bArr.length - (i2 + 4);
                    d.d("Soter.SoterCoreBase", "soter: signature length: ".concat(String.valueOf(length)), new Object[0]);
                    if (length != 0) {
                        byte[] bArr4 = new byte[length];
                        System.arraycopy(bArr, i2 + 4, bArr4, 0, length);
                        iVar.signature = Base64.encodeToString(bArr4, 2);
                    }
                }
            }
        }
        return iVar;
    }
}
