package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

public final class c {
    private static final k djm = new k(84298576);
    private static final k djn = new k(50613072);
    private static int djo = 0;
    private static final k djp = new k(101010256);

    static {
        AppMethodBeat.i(973);
        AppMethodBeat.o(973);
    }

    static class a {
        Properties djq;
        byte[] djr;

        private a() {
            AppMethodBeat.i(970);
            this.djq = new Properties();
            AppMethodBeat.o(970);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void W(byte[] bArr) {
            AppMethodBeat.i(971);
            if (bArr == null || bArr.length == 0) {
                AppMethodBeat.o(971);
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            k unused = c.djm;
            byte[] bArr2 = new byte[4];
            wrap.get(bArr2);
            System.out.println("securityPart: " + new k(bArr2).value);
            if (c.djm.equals(new k(bArr2))) {
                if (bArr.length - 4 <= 2) {
                    System.err.println("data.length - securityMarkLength <= 2");
                    AppMethodBeat.o(971);
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int i2 = new l(bArr3).value;
                if ((bArr.length - 4) - 2 < i2) {
                    System.err.println("data.length - securityMarkLength - 2 < len");
                    System.err.println("exit");
                    AppMethodBeat.o(971);
                    return;
                }
                byte[] bArr4 = new byte[i2];
                wrap.get(bArr4);
                this.djq.load(new ByteArrayInputStream(bArr4));
                int length = ((bArr.length - 4) - i2) - 2;
                if (length > 0) {
                    k unused2 = c.djn;
                    byte[] bArr5 = new byte[4];
                    wrap.get(bArr5);
                    if (c.djn.equals(new k(bArr5))) {
                        if (length - 4 <= 2) {
                            System.err.println("data.length - oriMarkLength <= 2");
                            AppMethodBeat.o(971);
                            return;
                        }
                        byte[] bArr6 = new byte[2];
                        wrap.get(bArr6);
                        int i3 = new l(bArr6).value;
                        if ((length - 4) - 2 < i3) {
                            System.err.println("data.length - oriMarkLength - 2 < len");
                            System.err.println("exit");
                            AppMethodBeat.o(971);
                            return;
                        }
                        this.djr = new byte[i3];
                        wrap.get(this.djr);
                        AppMethodBeat.o(971);
                        return;
                    }
                }
                AppMethodBeat.o(971);
            } else if (c.djn.equals(new k(bArr2))) {
                k unused3 = c.djn;
                if (bArr.length - 4 <= 2) {
                    System.err.println("data.length - oriMarkLength <= 2");
                    AppMethodBeat.o(971);
                    return;
                }
                byte[] bArr7 = new byte[2];
                wrap.get(bArr7);
                int i4 = new l(bArr7).value;
                if ((bArr.length - 4) - 2 < i4) {
                    System.err.println("data.length - oriMarkLength - 2 < len");
                    System.err.println("exit");
                    AppMethodBeat.o(971);
                    return;
                }
                this.djr = new byte[i4];
                wrap.get(this.djr);
                AppMethodBeat.o(971);
            } else {
                ProtocolException protocolException = new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
                AppMethodBeat.o(971);
                throw protocolException;
            }
        }

        /* access modifiers changed from: package-private */
        public final byte[] IJ() {
            AppMethodBeat.i(972);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (this.djq.size() > 0) {
                byteArrayOutputStream.write(c.djm.getBytes());
                String str = "";
                for (Object obj : this.djq.keySet()) {
                    str = String.valueOf(str) + obj + "=" + this.djq.getProperty((String) obj) + APLogFileUtil.SEPARATOR_LINE;
                }
                byte[] bytes = str.getBytes();
                byteArrayOutputStream.write(new l(bytes.length).getBytes());
                byteArrayOutputStream.write(bytes);
            }
            if (this.djr != null && this.djr.length > 0) {
                byteArrayOutputStream.write(c.djn.getBytes());
                byteArrayOutputStream.write(new l(this.djr.length).getBytes());
                byteArrayOutputStream.write(this.djr);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(972);
            return byteArray;
        }
    }

    private static byte[] d(RandomAccessFile randomAccessFile) {
        boolean z = true;
        AppMethodBeat.i(974);
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = djp.getBytes();
        int read = randomAccessFile.read();
        while (true) {
            if (read != -1) {
                if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                    break;
                }
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            System.err.println("archive is not a ZIP archive");
            ZipException zipException = new ZipException("archive is not a ZIP archive");
            AppMethodBeat.o(974);
            throw zipException;
        }
        randomAccessFile.seek(length + 16 + 4);
        if (((long) djo) != length + 16 + 4) {
            djo = (int) (length + 16 + 4);
        }
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        System.err.println("readComment:length bytes data = " + V(bArr));
        int i2 = new l(bArr).value;
        if (i2 == 0) {
            AppMethodBeat.o(974);
            return null;
        }
        byte[] bArr2 = new byte[i2];
        randomAccessFile.read(bArr2);
        AppMethodBeat.o(974);
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.io.File r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.d.c.g(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String B(java.io.File r5) {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.d.c.B(java.io.File):java.lang.String");
    }

    private static String V(byte[] bArr) {
        AppMethodBeat.i(977);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 2; i2++) {
            sb.append((int) bArr[i2]);
            sb.append(",");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(977);
        return sb2;
    }
}
