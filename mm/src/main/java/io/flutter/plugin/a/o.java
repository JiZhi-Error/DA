package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.n;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class o implements l {
    public static final o SSr = new o(n.SSp);
    private final n SSs;

    static {
        AppMethodBeat.i(9873);
        AppMethodBeat.o(9873);
    }

    private o(n nVar) {
        this.SSs = nVar;
    }

    @Override // io.flutter.plugin.a.l
    public final ByteBuffer b(j jVar) {
        AppMethodBeat.i(9868);
        n.a aVar = new n.a();
        this.SSs.a(aVar, jVar.method);
        this.SSs.a(aVar, jVar.SxX);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.buffer(), 0, aVar.size());
        AppMethodBeat.o(9868);
        return allocateDirect;
    }

    @Override // io.flutter.plugin.a.l
    public final j K(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9869);
        byteBuffer.order(ByteOrder.nativeOrder());
        Object O = this.SSs.O(byteBuffer);
        Object O2 = this.SSs.O(byteBuffer);
        if (!(O instanceof String) || byteBuffer.hasRemaining()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Method call corrupted");
            AppMethodBeat.o(9869);
            throw illegalArgumentException;
        }
        j jVar = new j((String) O, O2);
        AppMethodBeat.o(9869);
        return jVar;
    }

    @Override // io.flutter.plugin.a.l
    public final ByteBuffer eQ(Object obj) {
        AppMethodBeat.i(9870);
        n.a aVar = new n.a();
        aVar.write(0);
        this.SSs.a(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.buffer(), 0, aVar.size());
        AppMethodBeat.o(9870);
        return allocateDirect;
    }

    @Override // io.flutter.plugin.a.l
    public final ByteBuffer h(String str, String str2, Object obj) {
        AppMethodBeat.i(9871);
        n.a aVar = new n.a();
        aVar.write(1);
        this.SSs.a(aVar, str);
        this.SSs.a(aVar, str2);
        if (obj instanceof Throwable) {
            n nVar = this.SSs;
            StringWriter stringWriter = new StringWriter();
            ((Throwable) obj).printStackTrace(new PrintWriter(stringWriter));
            nVar.a(aVar, stringWriter.toString());
        } else {
            this.SSs.a(aVar, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.buffer(), 0, aVar.size());
        AppMethodBeat.o(9871);
        return allocateDirect;
    }

    @Override // io.flutter.plugin.a.l
    public final Object L(ByteBuffer byteBuffer) {
        Object O;
        Object O2;
        AppMethodBeat.i(9872);
        byteBuffer.order(ByteOrder.nativeOrder());
        switch (byteBuffer.get()) {
            case 0:
                Object O3 = this.SSs.O(byteBuffer);
                if (!byteBuffer.hasRemaining()) {
                    AppMethodBeat.o(9872);
                    return O3;
                }
                O = this.SSs.O(byteBuffer);
                O2 = this.SSs.O(byteBuffer);
                Object O4 = this.SSs.O(byteBuffer);
                if ((O instanceof String) && ((O2 == null || (O2 instanceof String)) && !byteBuffer.hasRemaining())) {
                    e eVar = new e((String) O, (String) O2, O4);
                    AppMethodBeat.o(9872);
                    throw eVar;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Envelope corrupted");
                AppMethodBeat.o(9872);
                throw illegalArgumentException;
            case 1:
                O = this.SSs.O(byteBuffer);
                O2 = this.SSs.O(byteBuffer);
                Object O42 = this.SSs.O(byteBuffer);
                e eVar2 = new e((String) O, (String) O2, O42);
                AppMethodBeat.o(9872);
                throw eVar2;
            default:
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Envelope corrupted");
                AppMethodBeat.o(9872);
                throw illegalArgumentException2;
        }
    }
}
