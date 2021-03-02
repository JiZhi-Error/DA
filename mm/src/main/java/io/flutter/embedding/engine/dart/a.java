package io.flutter.embedding.engine.dart;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.a.c;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* access modifiers changed from: package-private */
public final class a implements b, c {
    private final FlutterJNI SNV;
    private final Map<String, c.a> SOQ;
    private final Map<Integer, c.b> SOR;
    private int SOS = 1;

    a(FlutterJNI flutterJNI) {
        AppMethodBeat.i(10206);
        this.SNV = flutterJNI;
        this.SOQ = new HashMap();
        this.SOR = new HashMap();
        AppMethodBeat.o(10206);
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, c.a aVar) {
        AppMethodBeat.i(10207);
        if (aVar == null) {
            new StringBuilder("Removing handler for channel '").append(str).append("'");
            io.flutter.a.hwd();
            this.SOQ.remove(str);
            AppMethodBeat.o(10207);
            return;
        }
        new StringBuilder("Setting handler for channel '").append(str).append("'");
        io.flutter.a.hwd();
        this.SOQ.put(str, aVar);
        AppMethodBeat.o(10207);
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, ByteBuffer byteBuffer) {
        AppMethodBeat.i(10208);
        new StringBuilder("Sending message over channel '").append(str).append("'");
        io.flutter.a.hwd();
        a(str, byteBuffer, null);
        AppMethodBeat.o(10208);
    }

    @Override // io.flutter.plugin.a.c
    public final void a(String str, ByteBuffer byteBuffer, c.b bVar) {
        AppMethodBeat.i(10209);
        new StringBuilder("Sending message with callback over channel '").append(str).append("'");
        io.flutter.a.hwd();
        int i2 = 0;
        if (bVar != null) {
            i2 = this.SOS;
            this.SOS = i2 + 1;
            this.SOR.put(Integer.valueOf(i2), bVar);
        }
        if (byteBuffer == null) {
            this.SNV.dispatchEmptyPlatformMessage(str, i2);
            AppMethodBeat.o(10209);
            return;
        }
        this.SNV.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i2);
        AppMethodBeat.o(10209);
    }

    @Override // io.flutter.embedding.engine.dart.b
    public final void g(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(10210);
        new StringBuilder("Received message from Dart over channel '").append(str).append("'");
        io.flutter.a.hwd();
        c.a aVar = this.SOQ.get(str);
        if (aVar != null) {
            try {
                io.flutter.a.hwd();
                aVar.a(bArr == null ? null : ByteBuffer.wrap(bArr), new C2250a(this.SNV, i2));
                AppMethodBeat.o(10210);
            } catch (Exception e2) {
                io.flutter.a.hwh();
                this.SNV.invokePlatformMessageEmptyResponseCallback(i2);
                AppMethodBeat.o(10210);
            }
        } else {
            io.flutter.a.hwd();
            this.SNV.invokePlatformMessageEmptyResponseCallback(i2);
            AppMethodBeat.o(10210);
        }
    }

    @Override // io.flutter.embedding.engine.dart.b
    public final void handlePlatformMessageResponse(int i2, byte[] bArr) {
        AppMethodBeat.i(10211);
        io.flutter.a.hwd();
        c.b remove = this.SOR.remove(Integer.valueOf(i2));
        if (remove != null) {
            try {
                io.flutter.a.hwd();
                remove.I(bArr == null ? null : ByteBuffer.wrap(bArr));
                AppMethodBeat.o(10211);
                return;
            } catch (Exception e2) {
                io.flutter.a.hwh();
            }
        }
        AppMethodBeat.o(10211);
    }

    /* renamed from: io.flutter.embedding.engine.dart.a$a  reason: collision with other inner class name */
    static class C2250a implements c.b {
        private final FlutterJNI SNV;
        private final int SOT;
        private final AtomicBoolean SOU = new AtomicBoolean(false);

        C2250a(FlutterJNI flutterJNI, int i2) {
            AppMethodBeat.i(10215);
            this.SNV = flutterJNI;
            this.SOT = i2;
            AppMethodBeat.o(10215);
        }

        @Override // io.flutter.plugin.a.c.b
        public final void I(ByteBuffer byteBuffer) {
            AppMethodBeat.i(10216);
            if (this.SOU.getAndSet(true)) {
                IllegalStateException illegalStateException = new IllegalStateException("Reply already submitted");
                AppMethodBeat.o(10216);
                throw illegalStateException;
            } else if (byteBuffer == null) {
                this.SNV.invokePlatformMessageEmptyResponseCallback(this.SOT);
                AppMethodBeat.o(10216);
            } else {
                this.SNV.invokePlatformMessageResponseCallback(this.SOT, byteBuffer, byteBuffer.position());
                AppMethodBeat.o(10216);
            }
        }
    }
}
