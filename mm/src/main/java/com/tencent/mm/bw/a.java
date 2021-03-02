package com.tencent.mm.bw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.a.a.b;

public class a {
    protected static final int OPCODE_COMPUTESIZE = 1;
    protected static final int OPCODE_PARSEFROM = 2;
    protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
    protected static final int OPCODE_WRITEFIELDS = 0;
    protected static b unknownTagHandler = new g.a.a.a.a.a();
    private boolean includeUnKnownField = false;
    private byte[] pbData;

    public byte[] toByteArray() {
        AppMethodBeat.i(2350);
        validate();
        byte[] bArr = new byte[computeSize()];
        g.a.a.c.a aVar = new g.a.a.c.a(bArr);
        writeFields(aVar);
        aVar.hPu();
        AppMethodBeat.o(2350);
        return bArr;
    }

    public static int getNextFieldNumber(g.a.a.a.a aVar) {
        AppMethodBeat.i(2351);
        int hPk = aVar.hPk();
        AppMethodBeat.o(2351);
        return hPk;
    }

    /* access modifiers changed from: protected */
    public a validate() {
        return this;
    }

    /* access modifiers changed from: protected */
    public int op(int i2, Object... objArr) {
        AppMethodBeat.i(2352);
        Error error = new Error("Cannot use this method");
        AppMethodBeat.o(2352);
        throw error;
    }

    public void writeFields(g.a.a.c.a aVar) {
        AppMethodBeat.i(2353);
        op(0, aVar);
        AppMethodBeat.o(2353);
    }

    public int computeSize() {
        int i2 = 0;
        AppMethodBeat.i(2354);
        try {
            i2 = op(1, new Object[0]);
            AppMethodBeat.o(2354);
        } catch (Exception e2) {
            AppMethodBeat.o(2354);
        }
        return i2;
    }

    public a parseFrom(byte[] bArr) {
        AppMethodBeat.i(2355);
        this.pbData = bArr;
        op(2, bArr);
        AppMethodBeat.o(2355);
        return this;
    }

    public boolean populateBuilderWithField(g.a.a.a.a aVar, a aVar2, int i2) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(2356);
        if (op(3, aVar, aVar2, Integer.valueOf(i2)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.includeUnKnownField || !z) {
            z2 = true;
        }
        this.includeUnKnownField = z2;
        AppMethodBeat.o(2356);
        return z;
    }

    public boolean isIncludeUnKnownField() {
        return this.includeUnKnownField;
    }

    public byte[] getData() {
        return this.pbData;
    }

    static {
        AppMethodBeat.i(2349);
        AppMethodBeat.o(2349);
    }
}
