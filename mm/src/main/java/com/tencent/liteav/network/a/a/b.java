package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.b.a;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

public final class b {
    public static byte[] a(String str, int i2) {
        AppMethodBeat.i(15437);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        a aVar = new a();
        aVar.a(8);
        try {
            dataOutputStream.writeShort((short) i2);
            dataOutputStream.writeShort((short) aVar.a());
            dataOutputStream.writeShort(1);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
            b(byteArrayOutputStream, str);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(15437);
            return byteArray;
        } catch (IOException e2) {
            AssertionError assertionError = new AssertionError(e2);
            AppMethodBeat.o(15437);
            throw assertionError;
        }
    }

    private static void a(OutputStream outputStream, String str) {
        AppMethodBeat.i(15438);
        for (String str2 : str.split("[.。．｡]")) {
            byte[] bytes = IDN.toASCII(str2).getBytes();
            outputStream.write(bytes.length);
            outputStream.write(bytes, 0, bytes.length);
        }
        outputStream.write(0);
        AppMethodBeat.o(15438);
    }

    private static void b(OutputStream outputStream, String str) {
        AppMethodBeat.i(15439);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        a(outputStream, str);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeShort(1);
        AppMethodBeat.o(15439);
    }

    public static e[] a(byte[] bArr, int i2, String str) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(15440);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        if (readUnsignedShort != i2) {
            com.tencent.liteav.network.a.a aVar = new com.tencent.liteav.network.a.a(str, "the answer id " + readUnsignedShort + " is not match " + i2);
            AppMethodBeat.o(15440);
            throw aVar;
        }
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        if (((readUnsignedShort2 >> 8) & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (((readUnsignedShort2 >> 7) & 1) != 1) {
            z2 = false;
        }
        if (!z2 || !z) {
            com.tencent.liteav.network.a.a aVar2 = new com.tencent.liteav.network.a.a(str, "the dns server cant support recursion ");
            AppMethodBeat.o(15440);
            throw aVar2;
        }
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        a(dataInputStream, bArr, readUnsignedShort3);
        e[] b2 = b(dataInputStream, bArr, readUnsignedShort4);
        AppMethodBeat.o(15440);
        return b2;
    }

    private static String a(DataInputStream dataInputStream, byte[] bArr) {
        AppMethodBeat.i(15441);
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if ((readUnsignedByte & 192) == 192) {
            int readUnsignedByte2 = ((readUnsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(readUnsignedByte2));
            String a2 = a(bArr, readUnsignedByte2, hashSet);
            AppMethodBeat.o(15441);
            return a2;
        } else if (readUnsignedByte == 0) {
            AppMethodBeat.o(15441);
            return "";
        } else {
            byte[] bArr2 = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr2);
            String unicode = IDN.toUnicode(new String(bArr2));
            String a3 = a(dataInputStream, bArr);
            if (a3.length() > 0) {
                unicode = unicode + "." + a3;
            }
            AppMethodBeat.o(15441);
            return unicode;
        }
    }

    private static String a(byte[] bArr, int i2, HashSet<Integer> hashSet) {
        AppMethodBeat.i(15442);
        while (true) {
            int i3 = bArr[i2] & 255;
            if ((i3 & 192) == 192) {
                i2 = ((i3 & 63) << 8) + (bArr[i2 + 1] & 255);
                if (hashSet.contains(Integer.valueOf(i2))) {
                    com.tencent.liteav.network.a.a aVar = new com.tencent.liteav.network.a.a("", "Cyclic offsets detected.");
                    AppMethodBeat.o(15442);
                    throw aVar;
                }
                hashSet.add(Integer.valueOf(i2));
            } else if (i3 == 0) {
                AppMethodBeat.o(15442);
                return "";
            } else {
                String str = new String(bArr, i2 + 1, i3);
                String a2 = a(bArr, i3 + i2 + 1, hashSet);
                if (a2.length() > 0) {
                    str = str + "." + a2;
                }
                AppMethodBeat.o(15442);
                return str;
            }
        }
    }

    private static void a(DataInputStream dataInputStream, byte[] bArr, int i2) {
        AppMethodBeat.i(15443);
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                a(dataInputStream, bArr);
                dataInputStream.readUnsignedShort();
                dataInputStream.readUnsignedShort();
                i2 = i3;
            } else {
                AppMethodBeat.o(15443);
                return;
            }
        }
    }

    private static e[] b(DataInputStream dataInputStream, byte[] bArr, int i2) {
        AppMethodBeat.i(15444);
        int i3 = 0;
        e[] eVarArr = new e[i2];
        while (true) {
            int i4 = i2 - 1;
            if (i2 > 0) {
                eVarArr[i3] = b(dataInputStream, bArr);
                i3++;
                i2 = i4;
            } else {
                AppMethodBeat.o(15444);
                return eVarArr;
            }
        }
    }

    private static e b(DataInputStream dataInputStream, byte[] bArr) {
        String a2;
        AppMethodBeat.i(15445);
        a(dataInputStream, bArr);
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        long readUnsignedShort2 = ((long) dataInputStream.readUnsignedShort()) + (((long) dataInputStream.readUnsignedShort()) << 16);
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        switch (readUnsignedShort) {
            case 1:
                byte[] bArr2 = new byte[4];
                dataInputStream.readFully(bArr2);
                a2 = InetAddress.getByAddress(bArr2).getHostAddress();
                break;
            case 5:
                a2 = a(dataInputStream, bArr);
                break;
            default:
                a2 = null;
                for (int i2 = 0; i2 < readUnsignedShort3; i2++) {
                    dataInputStream.readByte();
                }
                break;
        }
        if (a2 == null) {
            UnknownHostException unknownHostException = new UnknownHostException("no record");
            AppMethodBeat.o(15445);
            throw unknownHostException;
        }
        e eVar = new e(a2, readUnsignedShort, (int) readUnsignedShort2, System.currentTimeMillis() / 1000);
        AppMethodBeat.o(15445);
        return eVar;
    }
}
