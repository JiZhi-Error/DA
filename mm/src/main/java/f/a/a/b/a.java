package f.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class a implements b {
    private String UbR = null;

    @Override // f.a.a.b.b
    public final byte[] encode(byte[] bArr) {
        AppMethodBeat.i(214851);
        if (this.UbR == null || bArr == null) {
            AppMethodBeat.o(214851);
            return null;
        }
        Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
        instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.UbR.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET))), new IvParameterSpec(this.UbR.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.o(214851);
        return doFinal;
    }

    @Override // f.a.a.b.b
    public final void buV(String str) {
        this.UbR = str;
    }
}
