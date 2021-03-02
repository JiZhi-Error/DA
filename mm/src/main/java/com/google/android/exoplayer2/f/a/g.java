package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    public static void a(long j2, m mVar, com.google.android.exoplayer2.c.m[] mVarArr) {
        AppMethodBeat.i(92787);
        while (mVar.xd() > 1) {
            int A = A(mVar);
            int A2 = A(mVar);
            if (A2 == -1 || A2 > mVar.xd()) {
                mVar.setPosition(mVar.limit);
            } else if (a(A, A2, mVar)) {
                mVar.eZ(8);
                int readUnsignedByte = mVar.readUnsignedByte() & 31;
                mVar.eZ(1);
                int i2 = readUnsignedByte * 3;
                int i3 = mVar.position;
                for (com.google.android.exoplayer2.c.m mVar2 : mVarArr) {
                    mVar.setPosition(i3);
                    mVar2.a(mVar, i2);
                    mVar2.a(j2, 1, i2, 0, null);
                }
                mVar.eZ(A2 - ((readUnsignedByte * 3) + 10));
            } else {
                mVar.eZ(A2);
            }
        }
        AppMethodBeat.o(92787);
    }

    private static int A(m mVar) {
        AppMethodBeat.i(92788);
        int i2 = 0;
        while (mVar.xd() != 0) {
            int readUnsignedByte = mVar.readUnsignedByte();
            i2 += readUnsignedByte;
            if (readUnsignedByte != 255) {
                AppMethodBeat.o(92788);
                return i2;
            }
        }
        AppMethodBeat.o(92788);
        return -1;
    }

    private static boolean a(int i2, int i3, m mVar) {
        AppMethodBeat.i(92789);
        if (i2 != 4 || i3 < 8) {
            AppMethodBeat.o(92789);
            return false;
        }
        int i4 = mVar.position;
        int readUnsignedByte = mVar.readUnsignedByte();
        int readUnsignedShort = mVar.readUnsignedShort();
        int readInt = mVar.readInt();
        int readUnsignedByte2 = mVar.readUnsignedByte();
        mVar.setPosition(i4);
        if (readUnsignedByte == 181 && readUnsignedShort == 49 && readInt == 1195456820 && readUnsignedByte2 == 3) {
            AppMethodBeat.o(92789);
            return true;
        }
        AppMethodBeat.o(92789);
        return false;
    }
}
