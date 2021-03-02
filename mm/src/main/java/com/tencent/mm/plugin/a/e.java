package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Random;

public final class e {
    private static final int jQc = aF(new byte[]{102, 114, 101, 101});
    private static final int jQd = aF(new byte[]{106, 117, 110, 107});
    private static final int jQe = aF(new byte[]{109, 100, 97, 116});
    private static final int jQf = aF(new byte[]{109, 111, 111, 118});
    private static final int jQg = aF(new byte[]{112, 110, 111, 116});
    private static final int jQh = aF(new byte[]{115, 107, 105, 112});
    private static final int jQi = aF(new byte[]{119, 105, 100, 101});
    private static final int jQj = aF(new byte[]{80, 73, 67, 84});
    private static final int jQk = aF(new byte[]{102, 116, 121, 112});
    private static final int jQl = aF(new byte[]{117, 117, 105, 100});
    private static final int jQm = aF(new byte[]{99, 109, 111, 118});
    private static final int jQn = aF(new byte[]{115, 116, 99, 111});
    private static final int jQo = aF(new byte[]{99, 111, 54, 52});

    static {
        AppMethodBeat.i(133865);
        AppMethodBeat.o(133865);
    }

    private static boolean bT(String str, String str2) {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(133858);
        o oVar = new o(str);
        o oVar2 = new o(str2);
        if (oVar.length() != oVar2.length()) {
            Log.w("MicroMsg.FastStart", "check size not right");
            AppMethodBeat.o(133858);
            return false;
        }
        long Sw = new b().Sw(str);
        j jVar = new j();
        jVar.L(str, Sw);
        int i2 = jVar.jQw;
        long Sw2 = new b().Sw(str2);
        j jVar2 = new j();
        jVar2.L(str2, Sw2);
        int i3 = jVar2.jQw;
        if (i3 != i2) {
            Log.w("MicroMsg.FastStart", "check duration not right");
            AppMethodBeat.o(133858);
            return false;
        }
        Log.d("MicroMsg.FastStart", "old duration:" + i2 + " new duration: " + i3);
        int nextInt = new Random().nextInt(i3 - 1) + 1;
        if (nextInt + 1 <= i3) {
            i3 = nextInt + 1;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        jVar.a(nextInt, i3, pInt, pInt2);
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        jVar2.a(nextInt, i3, pInt3, pInt4);
        if (pInt4.value != pInt2.value) {
            Log.w("MicroMsg.FastStart", "check len not right");
            AppMethodBeat.o(133858);
            return false;
        }
        try {
            inputStream = s.ao(oVar);
            try {
                inputStream.skip((long) pInt.value);
                byte[] bArr = new byte[4096];
                inputStream.read(bArr);
                InputStream ao = s.ao(oVar2);
                try {
                    ao.skip((long) pInt3.value);
                    byte[] bArr2 = new byte[4096];
                    inputStream.read(bArr2);
                    if (Arrays.equals(bArr, bArr2)) {
                        Log.w("MicroMsg.FastStart", "check data not right");
                        safeClose(inputStream);
                        safeClose(ao);
                        AppMethodBeat.o(133858);
                        return false;
                    }
                    safeClose(inputStream);
                    safeClose(ao);
                    AppMethodBeat.o(133858);
                    return true;
                } catch (Exception e3) {
                    e2 = e3;
                    inputStream2 = ao;
                    try {
                        Log.w("MicroMsg.FastStart", "fast start error: " + e2.toString());
                        safeClose(inputStream);
                        safeClose(inputStream2);
                        AppMethodBeat.o(133858);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        safeClose(inputStream);
                        safeClose(inputStream2);
                        AppMethodBeat.o(133858);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream2 = ao;
                    safeClose(inputStream);
                    safeClose(inputStream2);
                    AppMethodBeat.o(133858);
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                inputStream2 = null;
                Log.w("MicroMsg.FastStart", "fast start error: " + e2.toString());
                safeClose(inputStream);
                safeClose(inputStream2);
                AppMethodBeat.o(133858);
                return true;
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = null;
                safeClose(inputStream);
                safeClose(inputStream2);
                AppMethodBeat.o(133858);
                throw th;
            }
        } catch (Exception e5) {
            e2 = e5;
            inputStream2 = null;
            inputStream = null;
            Log.w("MicroMsg.FastStart", "fast start error: " + e2.toString());
            safeClose(inputStream);
            safeClose(inputStream2);
            AppMethodBeat.o(133858);
            return true;
        } catch (Throwable th5) {
            th = th5;
            inputStream2 = null;
            inputStream = null;
            safeClose(inputStream);
            safeClose(inputStream2);
            AppMethodBeat.o(133858);
            throw th;
        }
    }

    private static int aF(byte[] bArr) {
        AppMethodBeat.i(133859);
        int i2 = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt();
        AppMethodBeat.o(133859);
        return i2;
    }

    private static int AR(long j2) {
        AppMethodBeat.i(133860);
        if (j2 > 2147483647L || j2 < 0) {
            Exception exc = new Exception("uint32 value is too large");
            AppMethodBeat.o(133860);
            throw exc;
        }
        int i2 = (int) j2;
        AppMethodBeat.o(133860);
        return i2;
    }

    private static boolean a(FileChannel fileChannel, ByteBuffer byteBuffer) {
        AppMethodBeat.i(133861);
        byteBuffer.clear();
        int read = fileChannel.read(byteBuffer);
        byteBuffer.flip();
        if (read == byteBuffer.capacity()) {
            AppMethodBeat.o(133861);
            return true;
        }
        AppMethodBeat.o(133861);
        return false;
    }

    private static void safeClose(Closeable closeable) {
        AppMethodBeat.i(133862);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(133862);
                return;
            } catch (IOException e2) {
                Log.w("MicroMsg.FastStart", "Failed to close file: ");
            }
        }
        AppMethodBeat.o(133862);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0281, code lost:
        if (r6.remaining() >= (r14 * 8)) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0283, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FastStart", "bad atom size/element count");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x028f, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0290, code lost:
        if (r2 >= r14) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0292, code lost:
        r6.putLong(r6.getLong(r6.position()) + ((long) r12));
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02a7, code lost:
        r3.position(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02aa, code lost:
        if (r13 == null) goto L_0x02b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02ac, code lost:
        r13.rewind();
        r8.write(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02b2, code lost:
        r6.rewind();
        r8.write(r6);
        r3.transferTo(r4, r10 - r4, r8);
        r3.transferTo(((long) r12) + r10, (r3.size() - r10) - ((long) r12), r8);
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02e6, code lost:
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e8, code lost:
        if (r12 == false) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ea, code lost:
        if (r2 != false) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ec, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FastStart", "it can not find moov or ftyp");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0182, code lost:
        if (r16 != com.tencent.mm.plugin.a.e.jQf) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0188, code lost:
        if (r10 >= 0) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x018a, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FastStart", "it can not find moov atom");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0196, code lost:
        r12 = AR(r14);
        r6 = java.nio.ByteBuffer.allocate(r12).order(java.nio.ByteOrder.BIG_ENDIAN);
        r6.clear();
        r2 = r3.read(r6, r10);
        r6.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01b2, code lost:
        if (r2 != r6.capacity()) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01b4, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b5, code lost:
        if (r2 != false) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b7, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FastStart", "failed to read moov atom");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c3, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01cd, code lost:
        if (r6.getInt(12) != com.tencent.mm.plugin.a.e.jQm) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01cf, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FastStart", "this utility does not support compressed moov atoms yet");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01e1, code lost:
        if (r6.remaining() < 8) goto L_0x02a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01e3, code lost:
        r2 = r6.position();
        r7 = r6.getInt(r2 + 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01ef, code lost:
        if (r7 == com.tencent.mm.plugin.a.e.jQn) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01f3, code lost:
        if (r7 == com.tencent.mm.plugin.a.e.jQo) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01f5, code lost:
        r6.position(r6.position() + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0216, code lost:
        if ((((long) r6.getInt(r2)) & com.tencent.mm.sdk.platformtools.Util.MAX_32BIT_VALUE) <= ((long) r6.remaining())) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0218, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FastStart", "bad atom size");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0224, code lost:
        r6.position(r2 + 12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022e, code lost:
        if (r6.remaining() >= 4) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0230, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FastStart", "malformed atom");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x023c, code lost:
        r14 = AR((long) r6.getInt());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0247, code lost:
        if (r7 != com.tencent.mm.plugin.a.e.jQn) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x024f, code lost:
        if (r6.remaining() >= (r14 * 4)) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0251, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FastStart", "bad atom size/element count");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x025d, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x025e, code lost:
        if (r2 >= r14) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0260, code lost:
        r7 = r6.getInt(r6.position());
        r15 = r7 + r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x026a, code lost:
        if (r7 >= 0) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x026c, code lost:
        if (r15 < 0) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x026e, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0271, code lost:
        r6.putInt(r15);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0279, code lost:
        if (r7 != com.tencent.mm.plugin.a.e.jQo) goto L_0x01db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r22, java.lang.String r23, com.tencent.mm.pointers.PInt r24) {
        /*
        // Method dump skipped, instructions count: 745
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.a.e.b(java.lang.String, java.lang.String, com.tencent.mm.pointers.PInt):boolean");
    }
}
