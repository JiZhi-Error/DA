package org.extra.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.extra.a.a.c;

public final class f implements Closeable, c {
    private final int UhV = 1179403647;
    private final FileChannel UhW;

    public f(File file) {
        AppMethodBeat.i(236800);
        if (file == null || !file.exists()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("File is null or does not exist");
            AppMethodBeat.o(236800);
            throw illegalArgumentException;
        }
        this.UhW = new FileInputStream(file).getChannel();
        AppMethodBeat.o(236800);
    }

    public final List<String> hPT() {
        c.b eVar;
        long j2;
        c.a aw;
        AppMethodBeat.i(236801);
        this.UhW.position(0L);
        ArrayList arrayList = new ArrayList();
        this.UhW.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (e(allocate, 0) != 1179403647) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid ELF Magic!");
            AppMethodBeat.o(236801);
            throw illegalArgumentException;
        }
        short g2 = g(allocate, 4);
        boolean z = g(allocate, 5) == 2;
        if (g2 == 1) {
            eVar = new d(z, this);
        } else if (g2 == 2) {
            eVar = new e(z, this);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Invalid class type!");
            AppMethodBeat.o(236801);
            throw illegalStateException;
        }
        ByteBuffer allocate2 = ByteBuffer.allocate(8);
        allocate2.order(eVar.UhJ ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = (long) eVar.UhN;
        if (j3 == 65535) {
            j3 = eVar.hPS().UhT;
        }
        long j4 = 0;
        while (true) {
            if (j4 >= j3) {
                j2 = 0;
                break;
            }
            c.AbstractC2385c Pv = eVar.Pv(j4);
            if (Pv.dDw == 2) {
                j2 = Pv.offset;
                break;
            }
            j4++;
        }
        if (j2 == 0) {
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            AppMethodBeat.o(236801);
            return unmodifiableList;
        }
        int i2 = 0;
        ArrayList<Long> arrayList2 = new ArrayList();
        long j5 = 0;
        do {
            aw = eVar.aw(j2, i2);
            if (aw.UhH == 1) {
                arrayList2.add(Long.valueOf(aw.UhI));
            } else if (aw.UhH == 5) {
                j5 = aw.UhI;
            }
            i2++;
        } while (aw.UhH != 0);
        if (j5 == 0) {
            IllegalStateException illegalStateException2 = new IllegalStateException("String table offset not found!");
            AppMethodBeat.o(236801);
            throw illegalStateException2;
        }
        long a2 = a(eVar, j3, j5);
        for (Long l : arrayList2) {
            arrayList.add(c(allocate2, l.longValue() + a2));
        }
        AppMethodBeat.o(236801);
        return arrayList;
    }

    private static long a(c.b bVar, long j2, long j3) {
        AppMethodBeat.i(236802);
        for (long j4 = 0; j4 < j2; j4++) {
            c.AbstractC2385c Pv = bVar.Pv(j4);
            if (Pv.dDw == 1 && Pv.UhR <= j3 && j3 <= Pv.UhR + Pv.UhS) {
                long j5 = (j3 - Pv.UhR) + Pv.offset;
                AppMethodBeat.o(236802);
                return j5;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Could not map vma to file offset!");
        AppMethodBeat.o(236802);
        throw illegalStateException;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(236803);
        this.UhW.close();
        AppMethodBeat.o(236803);
    }

    private String c(ByteBuffer byteBuffer, long j2) {
        AppMethodBeat.i(236804);
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j3 = 1 + j2;
            short g2 = g(byteBuffer, j2);
            if (g2 != 0) {
                sb.append((char) g2);
                j2 = j3;
            } else {
                String sb2 = sb.toString();
                AppMethodBeat.o(236804);
                return sb2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final long d(ByteBuffer byteBuffer, long j2) {
        AppMethodBeat.i(236805);
        a(byteBuffer, j2, 8);
        long j3 = byteBuffer.getLong();
        AppMethodBeat.o(236805);
        return j3;
    }

    /* access modifiers changed from: protected */
    public final long e(ByteBuffer byteBuffer, long j2) {
        AppMethodBeat.i(236806);
        a(byteBuffer, j2, 4);
        long j3 = ((long) byteBuffer.getInt()) & Util.MAX_32BIT_VALUE;
        AppMethodBeat.o(236806);
        return j3;
    }

    /* access modifiers changed from: protected */
    public final int f(ByteBuffer byteBuffer, long j2) {
        AppMethodBeat.i(236807);
        a(byteBuffer, j2, 2);
        int i2 = byteBuffer.getShort() & ISelectionInterface.HELD_NOTHING;
        AppMethodBeat.o(236807);
        return i2;
    }

    private short g(ByteBuffer byteBuffer, long j2) {
        AppMethodBeat.i(236808);
        a(byteBuffer, j2, 1);
        short s = (short) (byteBuffer.get() & 255);
        AppMethodBeat.o(236808);
        return s;
    }

    private void a(ByteBuffer byteBuffer, long j2, int i2) {
        AppMethodBeat.i(236809);
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        long j3 = 0;
        while (j3 < ((long) i2)) {
            int read = this.UhW.read(byteBuffer, j2 + j3);
            if (read == -1) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(236809);
                throw eOFException;
            }
            j3 += (long) read;
        }
        byteBuffer.position(0);
        AppMethodBeat.o(236809);
    }
}
