package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class i {
    public static byte[] UcM = new byte[0];
    public SecureRandom UcB = new SecureRandom();
    public byte[] UcC = util.hPJ();
    public byte[] UcD = null;
    public byte[] UcE = new byte[16];
    public f UcF = new f();
    public g UcG = new g();
    public long UcH = 0;
    public int UcI = 0;
    public long UcJ = -1;
    public int UcK = 0;
    byte[] UcL = new byte[0];
    byte[] UcN = new byte[0];
    int UcO = 0;
    byte[] UcP = new byte[0];
    byte[] UcQ = new byte[0];
    byte[] UcR = new byte[0];
    byte[] UcS = new byte[0];
    byte[] UcT = new byte[0];
    byte[] UcU = new byte[0];
    int UcV = 0;
    int UcW = 0;
    int UcX = 0;
    int UcY = 0;
    byte[] UcZ = new byte[0];
    ErrMsg Uda = new ErrMsg();
    byte[] Udb = new byte[0];
    byte[] Udc = new byte[4];
    byte[] Udd = new byte[0];
    c Ude = null;
    public Context _context = null;
    public long _uin = 0;

    public i() {
        AppMethodBeat.i(88082);
        AppMethodBeat.o(88082);
    }

    public static long hPz() {
        AppMethodBeat.i(88083);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        AppMethodBeat.o(88083);
        return currentTimeMillis;
    }

    public final synchronized int a(long j2, long j3, long j4, long j5, long j6, long j7, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        int a2;
        AppMethodBeat.i(88084);
        util.buY("put siginfo:" + j2 + "," + j3 + "," + j4 + "," + j5 + "," + j6 + "," + j7 + "," + util.dx(bArr) + "," + util.dx(bArr2) + "," + util.dx(bArr3) + "," + util.dx(bArr4) + "," + util.dx(bArr5) + "," + util.dx(bArr6) + "," + util.dx(bArr7) + "," + util.dx(bArr8) + "," + util.dx(bArr9) + "," + util.dx(bArr10) + "," + util.dx(bArr11) + "," + util.dx(bArr12) + "," + util.dx(bArr13) + "," + util.dx(bArr14) + "," + util.dx(bArr15) + "," + util.dx(bArr16));
        String str = "";
        for (int i2 = 0; i2 < bArr17.length; i2++) {
            str = String.valueOf(str) + String.format("reserve[%d]: %d ", Integer.valueOf(i2), Long.valueOf(util.dx(bArr17[i2])));
        }
        util.buY("reserve:".concat(String.valueOf(str)));
        a2 = this.Ude.a(j2, j3, j4, j5, j6, j7, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
        AppMethodBeat.o(88084);
        return a2;
    }

    public final synchronized WloginSigInfo Pu(long j2) {
        WloginSigInfo aO;
        AppMethodBeat.i(88085);
        util.oF("get_siginfo", "uin=" + j2 + "appid=522017402");
        aO = this.Ude.aO(j2, 522017402);
        if (aO != null) {
            AppMethodBeat.o(88085);
        } else {
            AppMethodBeat.o(88085);
        }
        return aO;
    }

    public final synchronized void q(Long l) {
        AppMethodBeat.i(88086);
        this.Ude.q(l);
        AppMethodBeat.o(88086);
    }
}
