package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public class SKBuiltinBuffer_t extends a {
    private static final int fieldNumberBuffer = 2;
    private static final int fieldNumberILen = 1;
    private b Buffer;
    private boolean hasBuffer;
    private boolean hasILen;
    private int iLen;

    private SKBuiltinBuffer_t setILen(int i2) {
        this.iLen = i2;
        this.hasILen = true;
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(byte[] bArr) {
        AppMethodBeat.i(2367);
        b cD = b.cD(bArr);
        setBuffer(cD);
        setILen(cD.zy.length);
        AppMethodBeat.o(2367);
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(2368);
        b Q = b.Q(bArr, i2, i3);
        setBuffer(Q);
        setILen(Q.zy.length);
        AppMethodBeat.o(2368);
        return this;
    }

    public SKBuiltinBuffer_t setBuffer(b bVar) {
        AppMethodBeat.i(2369);
        if (bVar == null) {
            setBuffer((byte[]) null);
        }
        this.Buffer = bVar;
        this.hasBuffer = true;
        setILen(this.Buffer.zy.length);
        AppMethodBeat.o(2369);
        return this;
    }

    public int getILen() {
        return this.iLen;
    }

    public b getBuffer() {
        return this.Buffer;
    }

    public byte[] getBufferToBytes() {
        return this.Buffer.zy;
    }

    public boolean hasBuffer() {
        return this.hasBuffer;
    }

    public String toString() {
        AppMethodBeat.i(2370);
        String str = ("" + getClass().getName() + "(") + "iLen = " + this.iLen + "   ";
        if (this.hasBuffer) {
            str = str + "Buffer = " + this.Buffer + "   ";
        }
        String str2 = str + ")";
        AppMethodBeat.o(2370);
        return str2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.bw.a
    public SKBuiltinBuffer_t validate() {
        AppMethodBeat.i(2371);
        if (!this.hasILen) {
            g.a.a.b bVar = new g.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.hasILen);
            AppMethodBeat.o(2371);
            throw bVar;
        }
        AppMethodBeat.o(2371);
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public int computeSize() {
        AppMethodBeat.i(2372);
        int bu = g.a.a.b.b.a.bu(1, this.iLen) + 0;
        if (this.hasBuffer) {
            bu += g.a.a.b.b.a.b(2, this.Buffer);
        }
        int computeNestedMessageSize = bu + computeNestedMessageSize();
        AppMethodBeat.o(2372);
        return computeNestedMessageSize;
    }

    private int computeNestedMessageSize() {
        return 0;
    }

    @Override // com.tencent.mm.bw.a
    public byte[] toByteArray() {
        AppMethodBeat.i(2373);
        validate();
        byte[] byteArray = super.toByteArray();
        AppMethodBeat.o(2373);
        return byteArray;
    }

    @Override // com.tencent.mm.bw.a
    public void writeFields(g.a.a.c.a aVar) {
        AppMethodBeat.i(2374);
        aVar.aM(1, this.iLen);
        if (this.hasBuffer) {
            aVar.c(2, this.Buffer);
        }
        AppMethodBeat.o(2374);
    }

    @Override // com.tencent.mm.bw.a
    public final boolean populateBuilderWithField(g.a.a.a.a aVar, a aVar2, int i2) {
        AppMethodBeat.i(2375);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = (SKBuiltinBuffer_t) aVar2;
        boolean z = true;
        switch (i2) {
            case 1:
                sKBuiltinBuffer_t.setILen(aVar.UbS.zi());
                break;
            case 2:
                sKBuiltinBuffer_t.setBuffer(aVar.UbS.hPo());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.o(2375);
        return z;
    }

    @Override // com.tencent.mm.bw.a
    public SKBuiltinBuffer_t parseFrom(byte[] bArr) {
        AppMethodBeat.i(2376);
        g.a.a.a.a aVar = new g.a.a.a.a(bArr, unknownTagHandler);
        for (int nextFieldNumber = getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = getNextFieldNumber(aVar)) {
            if (!populateBuilderWithField(aVar, this, nextFieldNumber)) {
                aVar.hPl();
            }
        }
        SKBuiltinBuffer_t validate = validate();
        AppMethodBeat.o(2376);
        return validate;
    }
}
