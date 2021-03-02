package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class c implements AutoCloseable {
    public NativeInterpreterWrapper UiX;

    public static class a {
        final List<b> TiL = new ArrayList();
        int UiY = -1;
        Boolean UiZ;
        Boolean Uja;
        Boolean Ujb;
        Boolean Ujc;
        Boolean Ujd;

        public a() {
            AppMethodBeat.i(238964);
            AppMethodBeat.o(238964);
        }
    }

    public c(ByteBuffer byteBuffer) {
        this(byteBuffer, (byte) 0);
    }

    private c(ByteBuffer byteBuffer, byte b2) {
        AppMethodBeat.i(238965);
        this.UiX = new NativeInterpreterWrapper(byteBuffer);
        AppMethodBeat.o(238965);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(238966);
        if (this.UiX != null) {
            this.UiX.close();
            this.UiX = null;
        }
        AppMethodBeat.o(238966);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(238967);
        try {
            close();
        } finally {
            super.finalize();
            AppMethodBeat.o(238967);
        }
    }

    public final void oa() {
        AppMethodBeat.i(238968);
        if (this.UiX == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Internal error: The Interpreter has already been closed.");
            AppMethodBeat.o(238968);
            throw illegalStateException;
        }
        AppMethodBeat.o(238968);
    }
}
