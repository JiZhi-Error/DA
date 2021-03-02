package com.tencent.mm.plugin.qqmail.d;

import android.util.Base64;
import com.qq.taf.jce.HexUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.xweb.util.a;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class p extends q implements m {
    public String BrO;
    public String BrP;
    private i callback;
    public String dHx;
    private d hJu;

    public p(int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(198602);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        this.BrO = str;
        this.dHx = str2;
        this.BrP = str3;
        d dVar = new d();
        dVar.Brf = i2;
        if (!Util.isNullOrNil(str4)) {
            dVar.Brj = encrypt(str4, str3);
        }
        dVar.Brh = str;
        dVar.Bri = str2;
        aVar.iLN = dVar;
        aVar.iLO = new e();
        aVar.uri = "/cgi-bin/micromsg-bin/commitbindxmail";
        this.hJu = aVar.aXF();
        AppMethodBeat.o(198602);
    }

    private static String encrypt(String str, String str2) {
        AppMethodBeat.i(198603);
        try {
            byte[] bsA = a.bsA(str2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bsA, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(bsA));
            byte[] bytes = MD5Util.getMD5String(str).getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            byte[] doFinal = instance.doFinal(bytes);
            Log.d("MicroMsg.NetSceneBindXmail", "key %s, pwd %s, encrypt %s", HexUtil.bytes2HexStr(bsA), HexUtil.bytes2HexStr(bytes), HexUtil.bytes2HexStr(doFinal));
            String encodeToString = Base64.encodeToString(doFinal, 2);
            AppMethodBeat.o(198603);
            return encodeToString;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneBindXmail", e2, "bind xmail encrypt second pwd error", new Object[0]);
            AppMethodBeat.o(198603);
            return "";
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 586;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(198604);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(198604);
        return dispatch;
    }

    public final int eGo() {
        return ((e) this.hJu.iLL.iLR).Brk;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198605);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198605);
    }
}
