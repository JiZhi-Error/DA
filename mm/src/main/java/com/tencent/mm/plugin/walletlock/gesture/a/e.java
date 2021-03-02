package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e {
    public static boolean b(czk czk) {
        AppMethodBeat.i(129778);
        if (czk == null || czk.MEI == null || czk.MEI.getBuffer() == null) {
            AppMethodBeat.o(129778);
            return false;
        }
        byte[] bufferToBytes = czk.MEI.getBufferToBytes();
        if (bufferToBytes.length == 0 || (bufferToBytes.length & 1) != 0) {
            AppMethodBeat.o(129778);
            return false;
        }
        long longValue = new p(czk.uin).longValue();
        byte[] ct = ct(bufferToBytes);
        StringBuilder sb = new StringBuilder();
        sb.append(czk.version);
        if (czk.MEG.hasBuffer()) {
            sb.append(new String(czk.MEG.getBufferToBytes()));
        }
        sb.append(longValue);
        int doEcdsaVerify = UtilsJni.doEcdsaVerify(a.Ivx, sb.toString().getBytes(), ct);
        Log.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", Integer.valueOf(doEcdsaVerify)));
        if (doEcdsaVerify == 1) {
            AppMethodBeat.o(129778);
            return true;
        }
        AppMethodBeat.o(129778);
        return false;
    }

    public static boolean b(czl czl) {
        boolean z;
        AppMethodBeat.i(129779);
        if (czl == null || czl.MEK == null || czl.MEK.getBuffer() == null) {
            AppMethodBeat.o(129779);
            return false;
        }
        byte[] bufferToBytes = czl.MEK.getBufferToBytes();
        if (bufferToBytes.length == 0 || (bufferToBytes.length & 1) != 0) {
            AppMethodBeat.o(129779);
            return false;
        }
        byte[] ct = ct(bufferToBytes);
        g.aAf();
        long longValue = new p(a.getUin()).longValue();
        StringBuilder sb = new StringBuilder();
        sb.append(czl.MEJ);
        sb.append(longValue);
        int doEcdsaVerify = UtilsJni.doEcdsaVerify(a.Ivx, sb.toString().getBytes(), ct);
        if ((doEcdsaVerify == 1 || czl.MEL != 1) && !(doEcdsaVerify == 1 && czl.MEL == 0)) {
            z = false;
        } else {
            z = true;
        }
        Log.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", Integer.valueOf(doEcdsaVerify), Boolean.valueOf(z)));
        AppMethodBeat.o(129779);
        return z;
    }

    private static byte[] ct(byte[] bArr) {
        AppMethodBeat.i(129780);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < bArr.length - 1; i2 += 2) {
            byteArrayOutputStream.write(("0123456789abcdef".indexOf(Character.toLowerCase(bArr[i2])) << 4) | "0123456789abcdef".indexOf(Character.toLowerCase(bArr[i2 + 1])));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(129780);
        return byteArray;
    }

    public static boolean fUV() {
        boolean z;
        boolean z2;
        boolean z3;
        int i2 = -1;
        AppMethodBeat.i(129781);
        if (!g.aAc() || a.azj()) {
            Log.w("MicroMsg.GestureUtil", "not login !!");
            AppMethodBeat.o(129781);
            return false;
        }
        czl fVc = d.fVc();
        czk fVb = d.fVb();
        boolean z4 = fVc == null;
        if (fVb == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z4) {
            z2 = b(fVc);
        } else {
            z2 = false;
        }
        Object[] objArr = new Object[3];
        objArr[0] = fVc;
        objArr[1] = Integer.valueOf(fVc == null ? -1 : fVc.MEL);
        objArr[2] = Boolean.valueOf(z2);
        Log.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s", objArr);
        if (!z) {
            z3 = b(fVb);
        } else {
            z3 = false;
        }
        Object[] objArr2 = new Object[3];
        objArr2[0] = fVb;
        if (fVb != null) {
            i2 = fVb.MEH;
        }
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = Boolean.valueOf(z3);
        Log.i("MicroMsg.GestureUtil", "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s", objArr2);
        if (z2) {
            if (z3) {
                try {
                    Log.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
                    if (fVc.MEJ > fVb.version) {
                        Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", Integer.valueOf(fVc.MEJ), Integer.valueOf(fVb.version));
                        if (fVc.MEL == 1) {
                            AppMethodBeat.o(129781);
                            return true;
                        }
                        AppMethodBeat.o(129781);
                        return false;
                    } else if (fVc.MEJ == fVb.version) {
                        Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", Integer.valueOf(fVc.MEJ), Integer.valueOf(fVb.version));
                        if (fVc.MEL == 1) {
                            AppMethodBeat.o(129781);
                            return true;
                        }
                        AppMethodBeat.o(129781);
                        return false;
                    } else {
                        Log.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", Integer.valueOf(fVc.MEJ), Integer.valueOf(fVb.version));
                        if (fVb.MEH == 1) {
                            AppMethodBeat.o(129781);
                            return true;
                        }
                        AppMethodBeat.o(129781);
                        return false;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.GestureUtil", e2, "isUserSetWalletLock throw an exception.", new Object[0]);
                    AppMethodBeat.o(129781);
                    return false;
                }
            } else {
                Log.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
                if (fVc.MEL == 1) {
                    AppMethodBeat.o(129781);
                    return true;
                }
                AppMethodBeat.o(129781);
                return false;
            }
        } else if (z3) {
            Log.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
            if (fVb.MEH == 1) {
                AppMethodBeat.o(129781);
                return true;
            }
            AppMethodBeat.o(129781);
            return false;
        } else {
            Log.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
            AppMethodBeat.o(129781);
            return false;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static byte[] m32if(List<f> list) {
        AppMethodBeat.i(129782);
        if (list == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("pattern is null");
            AppMethodBeat.o(129782);
            throw illegalArgumentException;
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = list.get(i2);
            bArr[i2] = (byte) (fVar.Ivz + (fVar.Ivy * 3) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < size; i3++) {
            sb.append((int) bArr[i3]);
        }
        String sb2 = sb.toString();
        byte[] bytes = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.b.g.getMessageDigest(sb2.getBytes()) + z.aTY()).getBytes()) + sb2).getBytes()).getBytes();
        AppMethodBeat.o(129782);
        return bytes;
    }

    public static void a(g gVar) {
        AppMethodBeat.i(129783);
        if (gVar.IvB == -1) {
            AppMethodBeat.o(129783);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime < gVar.IvB) {
            gVar.IvB = elapsedRealtime;
            gVar.IvC += elapsedRealtime;
            Log.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", Long.valueOf(elapsedRealtime), Long.valueOf(gVar.IvC)));
            AppMethodBeat.o(129783);
            return;
        }
        gVar.IvC = (elapsedRealtime - gVar.IvB) + gVar.IvC;
        gVar.IvB = elapsedRealtime;
        AppMethodBeat.o(129783);
    }

    public static byte[] stringToBytes(String str) {
        AppMethodBeat.i(129784);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < str.length(); i2 += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i2, i2 + 2), 16));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(129784);
        return byteArray;
    }

    public static String bytesToString(byte[] bArr) {
        AppMethodBeat.i(129785);
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(129785);
        return sb2;
    }
}
