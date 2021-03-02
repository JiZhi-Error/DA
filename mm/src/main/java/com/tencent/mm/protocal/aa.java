package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.protocal.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class aa {

    public static class a extends l.d implements l.b {
        public int KAr;
        public int KzG;
        public byte[] ctx;
        public byte[] hqn;
        public byte[] jcK = new byte[0];
        public int netType;
        public byte[] networkId;
        private int uin = 0;

        public a() {
            AppMethodBeat.i(133125);
            AppMethodBeat.o(133125);
        }

        @Override // com.tencent.mm.protocal.l.d
        public final void setUin(int i2) {
            this.uin = i2;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            int i2;
            AppMethodBeat.i(133126);
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.uin);
            objArr[1] = Integer.valueOf(this.jcK == null ? -1 : this.jcK.length);
            objArr[2] = Util.getStack();
            Log.d("MicroMsg.MMSyncCheck", "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]", objArr);
            if (this.uin == 0 || Util.isNullOrNil(this.jcK)) {
                byte[] bArr = new byte[0];
                AppMethodBeat.o(133126);
                return bArr;
            }
            int length = (((this.uin >> 13) & 524287) | (this.jcK.length << 19)) ^ 1442968193;
            int length2 = (((this.jcK.length >> 13) & 524287) | (this.uin << 19)) ^ 1442968193;
            byte[] bArr2 = new byte[(this.jcK.length + 32)];
            if (this.networkId == null || this.networkId.length != 32) {
                i2 = 0;
            } else {
                i2 = this.KAr + 36;
                bArr2 = new byte[(this.jcK.length + 32 + 32 + 4 + this.KAr)];
            }
            Log.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", Integer.valueOf(this.uin), Integer.valueOf(length), Integer.valueOf(this.jcK.length), Integer.valueOf(length2), Integer.valueOf(bArr2.length));
            bArr2[0] = (byte) ((length >> 24) & 255);
            bArr2[1] = (byte) ((length >> 16) & 255);
            bArr2[2] = (byte) ((length >> 8) & 255);
            bArr2[3] = (byte) (length & 255);
            bArr2[4] = (byte) ((length2 >> 24) & 255);
            bArr2[5] = (byte) ((length2 >> 16) & 255);
            bArr2[6] = (byte) ((length2 >> 8) & 255);
            bArr2[7] = (byte) (length2 & 255);
            System.arraycopy(this.jcK, 0, bArr2, 8, this.jcK.length);
            bArr2[(bArr2.length - 24) - i2] = (byte) ((d.KyO >> 24) & 255);
            bArr2[(bArr2.length - 23) - i2] = (byte) ((d.KyO >> 16) & 255);
            bArr2[(bArr2.length - 22) - i2] = (byte) ((d.KyO >> 8) & 255);
            bArr2[(bArr2.length - 21) - i2] = (byte) (d.KyO & 255);
            String locale = Locale.getDefault().toString();
            if (locale.length() > 8) {
                locale = locale.substring(0, 8);
            }
            byte[] bytes = locale.getBytes();
            System.arraycopy(bytes, 0, bArr2, (bArr2.length - 20) - i2, bytes.length);
            Log.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString(bytes));
            bArr2[(bArr2.length - 12) - i2] = 0;
            bArr2[(bArr2.length - 11) - i2] = 0;
            bArr2[(bArr2.length - 10) - i2] = 0;
            bArr2[(bArr2.length - 9) - i2] = 2;
            bArr2[(bArr2.length - 8) - i2] = (byte) ((this.netType >> 24) & 255);
            bArr2[(bArr2.length - 7) - i2] = (byte) ((this.netType >> 16) & 255);
            bArr2[(bArr2.length - 6) - i2] = (byte) ((this.netType >> 8) & 255);
            bArr2[(bArr2.length - 5) - i2] = (byte) (this.netType & 255);
            bArr2[(bArr2.length - 4) - i2] = (byte) ((this.KzG >> 24) & 255);
            bArr2[(bArr2.length - 3) - i2] = (byte) ((this.KzG >> 16) & 255);
            bArr2[(bArr2.length - 2) - i2] = (byte) ((this.KzG >> 8) & 255);
            bArr2[(bArr2.length - 1) - i2] = (byte) (this.KzG & 255);
            if (this.networkId != null && this.networkId.length == 32) {
                Log.i("MicroMsg.MMSyncCheck", "copy networkid " + this.networkId.length + " " + this.KAr);
                System.arraycopy(this.networkId, 0, bArr2, this.jcK.length + 32, this.networkId.length);
                bArr2[(bArr2.length - this.KAr) - 4] = (byte) ((this.KAr >> 24) & 255);
                bArr2[(bArr2.length - this.KAr) - 3] = (byte) ((this.KAr >> 16) & 255);
                bArr2[(bArr2.length - this.KAr) - 2] = (byte) ((this.KAr >> 8) & 255);
                bArr2[(bArr2.length - this.KAr) - 1] = (byte) (this.KAr & 255);
                if (this.KAr > 0 && this.ctx != null && this.ctx.length == this.KAr) {
                    System.arraycopy(this.ctx, 0, bArr2, this.jcK.length + 32 + this.networkId.length + 4, this.ctx.length);
                }
            }
            Log.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(bArr2) + " " + bArr2.length);
            this.hqn = g.Q(bArr2);
            AppMethodBeat.o(133126);
            return bArr2;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 0;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 205;
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
        public long KAs = 7;
        private byte[] KAt;
        public int KAu = 0;
        public byte[] ctx;
        public byte[] hqn = null;
        public byte[] networkId;
        private String xml = null;

        @TargetApi(9)
        public final String gtP() {
            AppMethodBeat.i(133127);
            if (this.hqn == null) {
                AppMethodBeat.o(133127);
                return "";
            }
            if (this.xml == null) {
                byte[] aesDecrypt = MMProtocalJni.aesDecrypt(this.KAt, this.hqn);
                if (Util.isNullOrNil(aesDecrypt)) {
                    AppMethodBeat.o(133127);
                    return "";
                } else if (Build.VERSION.SDK_INT >= 9) {
                    this.xml = new String(aesDecrypt, Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } else {
                    this.xml = new String(aesDecrypt);
                }
            }
            String str = this.xml;
            AppMethodBeat.o(133127);
            return str;
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(133128);
            if (bArr == null || bArr.length < 12) {
                Log.e("MicroMsg.MMSyncCheck", "dksynccheck err resp buf:" + (bArr == null ? -1 : bArr.length));
                AppMethodBeat.o(133128);
                return -1;
            }
            this.KAs = (long) ((bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16) | ((bArr[0] & 255) << 24));
            int i2 = (bArr[7] & 255) | ((bArr[6] & 255) << 8) | ((bArr[5] & 255) << 16) | ((bArr[4] & 255) << 24);
            int i3 = (bArr[11] & 255) | ((bArr[10] & 255) << 8) | ((bArr[9] & 255) << 16) | ((bArr[8] & 255) << 24);
            Log.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d, buf length:%d", Long.valueOf(this.KAs), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length));
            if (i2 != -3002) {
                this.xml = "";
                if (bArr.length > i3 + 12) {
                    this.KAu = (bArr[i3 + 15] & 255) | ((bArr[i3 + 14] & 255) << 8) | ((bArr[i3 + 13] & 255) << 16) | ((bArr[i3 + 12] & 255) << 24);
                    this.networkId = new byte[32];
                    System.arraycopy(bArr, i3 + 16, this.networkId, 0, 32);
                    int i4 = (bArr[i3 + 51] & 255) | ((bArr[i3 + 50] & 255) << 8) | ((bArr[i3 + 49] & 255) << 16) | ((bArr[i3 + 48] & 255) << 24);
                    this.ctx = new byte[0];
                    if (i4 > 0) {
                        this.ctx = new byte[i4];
                        System.arraycopy(bArr, i3 + 52, this.ctx, 0, i4);
                    }
                }
                AppMethodBeat.o(133128);
                return i2;
            } else if (i3 == bArr.length - 12 || i3 == (bArr.length - 12) - 16) {
                if (i3 == (bArr.length - 12) - 16) {
                    this.hqn = new byte[16];
                    System.arraycopy(bArr, bArr.length - 16, this.hqn, 0, 16);
                }
                this.KAt = new byte[i3];
                System.arraycopy(bArr, 12, this.KAt, 0, i3);
                AppMethodBeat.o(133128);
                return i2;
            } else {
                Log.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", Integer.valueOf(i3), Integer.valueOf(bArr.length));
                AppMethodBeat.o(133128);
                return -1;
            }
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 1000000205;
        }

        @Override // com.tencent.mm.protocal.l.c, com.tencent.mm.protocal.l.e
        public final boolean isRawData() {
            return true;
        }
    }
}
