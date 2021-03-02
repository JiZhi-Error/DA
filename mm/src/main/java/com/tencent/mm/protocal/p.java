package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class p {

    public static class a extends l.d implements l.b {
        public String KzO = "";
        public byte[] KzP = new byte[0];
        public int cSx = 0;
        public int dKy = 0;
        public int jlm = 0;

        public a() {
            AppMethodBeat.i(32087);
            AppMethodBeat.o(32087);
        }

        private byte[] gtO() {
            AppMethodBeat.i(32088);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(this.jlm);
                dataOutputStream.writeShort(this.KzO.getBytes().length);
                dataOutputStream.write(this.KzO.getBytes());
                dataOutputStream.writeShort(this.KzP.length);
                dataOutputStream.write(this.KzP);
                dataOutputStream.close();
            } catch (IOException e2) {
                Log.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + e2.getMessage());
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(32088);
            return byteArray;
        }

        private byte[] cH(byte[] bArr) {
            AppMethodBeat.i(32089);
            if (bArr == null) {
                AppMethodBeat.o(32089);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeByte(this.dKy);
                dataOutputStream.writeByte(this.cSx);
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            } catch (IOException e2) {
                Log.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + e2.getMessage());
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(32089);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(32090);
            byte[] gtO = gtO();
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, gtO, p.bge(super.getDeviceID()));
            byte[] cH = cH(pByteArray.value);
            AppMethodBeat.o(32090);
            return cH;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 10;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 8;
        }

        @Override // com.tencent.mm.protocal.l.b, com.tencent.mm.protocal.l.d
        public final boolean isRawData() {
            return true;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final boolean getShortSupport() {
            return false;
        }
    }

    public static class b extends l.e implements l.c {
        private int cSx;
        public byte[] content;
        private int dKy;
        public String deviceID;
        public String jje;
        private int jlm;

        public b() {
            AppMethodBeat.i(32091);
            this.jje = "";
            this.content = new byte[0];
            this.deviceID = "";
            this.dKy = 0;
            this.cSx = 0;
            this.jlm = 0;
            this.jje = "";
            this.content = new byte[0];
            AppMethodBeat.o(32091);
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 8;
        }

        @Override // com.tencent.mm.protocal.l.c, com.tencent.mm.protocal.l.e
        public final boolean isRawData() {
            return true;
        }

        private byte[] cI(byte[] bArr) {
            AppMethodBeat.i(32092);
            if (bArr == null || bArr.length < 2) {
                Log.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
                AppMethodBeat.o(32092);
                return null;
            }
            byte[] bArr2 = new byte[(bArr.length - 2)];
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                this.dKy = dataInputStream.readByte();
                this.cSx = dataInputStream.readByte();
                dataInputStream.readFully(bArr2);
                Log.d("MicroMsg.MMDirectSend", "cmdId:" + this.dKy + ", flag=" + this.cSx + ", tail len=" + bArr2.length);
                byteArrayInputStream.close();
            } catch (IOException e2) {
                Log.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e2.getMessage());
            }
            AppMethodBeat.o(32092);
            return bArr2;
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(32093);
            byte[] bge = p.bge(this.deviceID);
            PByteArray pByteArray = new PByteArray();
            if (c.b(pByteArray, cI(bArr), bge) != 0) {
                byte[] bArr2 = new byte[16];
                for (int i2 = 0; i2 < 16; i2++) {
                    bArr2[i2] = 0;
                }
                if (c.b(pByteArray, cI(bArr), bArr2) != 0) {
                    Log.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", Util.dumpHex(bge));
                    AppMethodBeat.o(32093);
                    return -1;
                }
            }
            byte[] bArr3 = pByteArray.value;
            if (bArr3 == null) {
                Log.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
            } else {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3));
                    this.jlm = dataInputStream.readInt();
                    Log.d("MicroMsg.MMDirectSend", "seq=" + this.jlm);
                    int readShort = dataInputStream.readShort();
                    if (readShort < 0) {
                        IOException iOException = new IOException("sender empty");
                        AppMethodBeat.o(32093);
                        throw iOException;
                    }
                    byte[] bArr4 = new byte[readShort];
                    dataInputStream.readFully(bArr4);
                    this.jje = new String(bArr4);
                    Log.d("MicroMsg.MMDirectSend", "recievers len=" + readShort + ", sender=" + this.jje);
                    int readShort2 = dataInputStream.readShort();
                    if (readShort2 < 0) {
                        IOException iOException2 = new IOException("content empty");
                        AppMethodBeat.o(32093);
                        throw iOException2;
                    }
                    this.content = new byte[readShort2];
                    dataInputStream.readFully(this.content);
                    Log.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
                } catch (IOException e2) {
                    Log.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e2.getMessage());
                }
            }
            AppMethodBeat.o(32093);
            return 0;
        }
    }

    static /* synthetic */ byte[] bge(String str) {
        AppMethodBeat.i(32094);
        byte[] bArr = new byte[16];
        System.arraycopy(str.getBytes(), 0, bArr, 0, 15);
        bArr[15] = 0;
        byte[] Q = g.Q(bArr);
        Log.d("MicroMsg.MMDirectSend", "new direct send: key=%s", Util.dumpHex(Q));
        AppMethodBeat.o(32094);
        return Q;
    }
}
