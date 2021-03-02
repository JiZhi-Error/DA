package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.ByteBuffer;

public class LVBuffer {
    private static final byte BE = 123;
    private static final byte ED = 125;
    public static final int LENGTH_ALLOC_PER_NEW = 4096;
    public static final int MAX_STRING_LENGTH = 3072;
    private ByteBuffer byteBuffer;
    private boolean isBuildBuffer;

    private int check(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return -1;
        }
        if (bArr[0] != 123) {
            return -2;
        }
        if (bArr[bArr.length - 1] != 125) {
            return -3;
        }
        return 0;
    }

    public int initParse(byte[] bArr) {
        AppMethodBeat.i(157574);
        if (check(bArr) != 0) {
            this.byteBuffer = null;
            AppMethodBeat.o(157574);
            return -1;
        }
        this.byteBuffer = ByteBuffer.wrap(bArr);
        this.byteBuffer.position(1);
        this.isBuildBuffer = false;
        AppMethodBeat.o(157574);
        return 0;
    }

    public int getInt() {
        AppMethodBeat.i(157575);
        if (this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Build");
            AppMethodBeat.o(157575);
            throw exc;
        }
        int i2 = this.byteBuffer.getInt();
        AppMethodBeat.o(157575);
        return i2;
    }

    public long getLong() {
        AppMethodBeat.i(157576);
        if (this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Build");
            AppMethodBeat.o(157576);
            throw exc;
        }
        long j2 = this.byteBuffer.getLong();
        AppMethodBeat.o(157576);
        return j2;
    }

    public byte[] getBuffer() {
        AppMethodBeat.i(157577);
        if (this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Build");
            AppMethodBeat.o(157577);
            throw exc;
        }
        int i2 = this.byteBuffer.getShort();
        if (i2 > 3072) {
            this.byteBuffer = null;
            Exception exc2 = new Exception("Buffer String Length Error");
            AppMethodBeat.o(157577);
            throw exc2;
        } else if (i2 == 0) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(157577);
            return bArr;
        } else {
            byte[] bArr2 = new byte[i2];
            this.byteBuffer.get(bArr2, 0, i2);
            AppMethodBeat.o(157577);
            return bArr2;
        }
    }

    public String getString() {
        AppMethodBeat.i(157578);
        if (this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Build");
            AppMethodBeat.o(157578);
            throw exc;
        }
        int i2 = this.byteBuffer.getShort();
        if (i2 > 3072) {
            this.byteBuffer = null;
            Exception exc2 = new Exception("Buffer String Length Error");
            AppMethodBeat.o(157578);
            throw exc2;
        } else if (i2 == 0) {
            AppMethodBeat.o(157578);
            return "";
        } else {
            byte[] bArr = new byte[i2];
            this.byteBuffer.get(bArr, 0, i2);
            String str = new String(bArr, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(157578);
            return str;
        }
    }

    public void skipPosition(int i2) {
        AppMethodBeat.i(157579);
        ByteBuffer byteBuffer2 = this.byteBuffer;
        byteBuffer2.position(byteBuffer2.position() + i2);
        AppMethodBeat.o(157579);
    }

    public void skipString() {
        AppMethodBeat.i(157580);
        if (this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Build");
            AppMethodBeat.o(157580);
            throw exc;
        }
        short s = this.byteBuffer.getShort();
        if (s > 3072) {
            this.byteBuffer = null;
            Exception exc2 = new Exception("Buffer String Length Error");
            AppMethodBeat.o(157580);
            throw exc2;
        } else if (s == 0) {
            AppMethodBeat.o(157580);
        } else {
            this.byteBuffer.position(s + this.byteBuffer.position());
            AppMethodBeat.o(157580);
        }
    }

    public boolean checkGetFinish() {
        AppMethodBeat.i(157581);
        if (this.byteBuffer.limit() - this.byteBuffer.position() <= 1) {
            AppMethodBeat.o(157581);
            return true;
        }
        AppMethodBeat.o(157581);
        return false;
    }

    public int initBuild() {
        AppMethodBeat.i(157582);
        this.byteBuffer = ByteBuffer.allocate(4096);
        this.byteBuffer.put(BE);
        this.isBuildBuffer = true;
        AppMethodBeat.o(157582);
        return 0;
    }

    private int checkBuffer(int i2) {
        AppMethodBeat.i(157583);
        if (this.byteBuffer.limit() - this.byteBuffer.position() > i2) {
            AppMethodBeat.o(157583);
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(this.byteBuffer.limit() + 4096);
            allocate.put(this.byteBuffer.array(), 0, this.byteBuffer.position());
            this.byteBuffer = allocate;
            AppMethodBeat.o(157583);
        }
        return 0;
    }

    public int putInt(int i2) {
        AppMethodBeat.i(157584);
        if (!this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Parse");
            AppMethodBeat.o(157584);
            throw exc;
        }
        checkBuffer(4);
        this.byteBuffer.putInt(i2);
        AppMethodBeat.o(157584);
        return 0;
    }

    public int putLong(long j2) {
        AppMethodBeat.i(157585);
        if (!this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Parse");
            AppMethodBeat.o(157585);
            throw exc;
        }
        checkBuffer(8);
        this.byteBuffer.putLong(j2);
        AppMethodBeat.o(157585);
        return 0;
    }

    public int putBuffer(byte[] bArr) {
        AppMethodBeat.i(157586);
        if (!this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Parse");
            AppMethodBeat.o(157586);
            throw exc;
        }
        byte[] bArr2 = null;
        if (bArr != null) {
            bArr2 = bArr;
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (bArr2.length > 3072) {
            Exception exc2 = new Exception("Buffer String Length Error");
            AppMethodBeat.o(157586);
            throw exc2;
        }
        checkBuffer(bArr2.length + 2);
        this.byteBuffer.putShort((short) bArr2.length);
        if (bArr2.length > 0) {
            this.byteBuffer.put(bArr2);
        }
        AppMethodBeat.o(157586);
        return 0;
    }

    public int putString(String str) {
        AppMethodBeat.i(157587);
        if (!this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Parse");
            AppMethodBeat.o(157587);
            throw exc;
        }
        byte[] bArr = null;
        if (str != null) {
            bArr = str.getBytes();
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length > 3072) {
            Exception exc2 = new Exception("Buffer String Length Error");
            AppMethodBeat.o(157587);
            throw exc2;
        }
        checkBuffer(bArr.length + 2);
        this.byteBuffer.putShort((short) bArr.length);
        if (bArr.length > 0) {
            this.byteBuffer.put(bArr);
        }
        AppMethodBeat.o(157587);
        return 0;
    }

    public byte[] buildFinish() {
        AppMethodBeat.i(157588);
        if (!this.isBuildBuffer) {
            Exception exc = new Exception("Buffer For Parse");
            AppMethodBeat.o(157588);
            throw exc;
        }
        checkBuffer(1);
        this.byteBuffer.put(ED);
        byte[] bArr = new byte[this.byteBuffer.position()];
        System.arraycopy(this.byteBuffer.array(), 0, bArr, 0, bArr.length);
        AppMethodBeat.o(157588);
        return bArr;
    }
}
