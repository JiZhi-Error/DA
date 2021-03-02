package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class h {
    public static UUID r(byte[] bArr) {
        AppMethodBeat.i(92122);
        Pair<UUID, byte[]> s = s(bArr);
        if (s == null) {
            AppMethodBeat.o(92122);
            return null;
        }
        UUID uuid = (UUID) s.first;
        AppMethodBeat.o(92122);
        return uuid;
    }

    private static Pair<UUID, byte[]> s(byte[] bArr) {
        AppMethodBeat.i(92123);
        m mVar = new m(bArr);
        if (mVar.limit < 32) {
            AppMethodBeat.o(92123);
            return null;
        }
        mVar.setPosition(0);
        if (mVar.readInt() != mVar.xd() + 4) {
            AppMethodBeat.o(92123);
            return null;
        } else if (mVar.readInt() != a.blD) {
            AppMethodBeat.o(92123);
            return null;
        } else {
            int ec = a.ec(mVar.readInt());
            if (ec > 1) {
                AppMethodBeat.o(92123);
                return null;
            }
            UUID uuid = new UUID(mVar.readLong(), mVar.readLong());
            if (ec == 1) {
                mVar.eZ(mVar.xk() * 16);
            }
            int xk = mVar.xk();
            if (xk != mVar.xd()) {
                AppMethodBeat.o(92123);
                return null;
            }
            byte[] bArr2 = new byte[xk];
            mVar.readBytes(bArr2, 0, xk);
            Pair<UUID, byte[]> create = Pair.create(uuid, bArr2);
            AppMethodBeat.o(92123);
            return create;
        }
    }
}
