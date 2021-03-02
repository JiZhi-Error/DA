package com.google.android.exoplayer2.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface d {
    public static final ByteBuffer beO = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void f(ByteBuffer byteBuffer);

    void flush();

    boolean isActive();

    boolean p(int i2, int i3, int i4);

    void reset();

    boolean tB();

    int tH();

    void tI();

    ByteBuffer tJ();

    public static final class a extends Exception {
        public a(int i2, int i3, int i4) {
            super("Unhandled format: " + i2 + " Hz, " + i3 + " channels in encoding " + i4);
            AppMethodBeat.i(91762);
            AppMethodBeat.o(91762);
        }
    }
}
