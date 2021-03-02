package com.tencent.mm.vfs;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import kotlin.f.b;
import kotlin.f.d;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0006\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0002H\b\u001a\u0014\u0010\r\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0015"}, hxF = {"forEachLine", "", "Lcom/tencent/mm/vfs/VFSFile;", "charset", "Ljava/nio/charset/Charset;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "readText", "reader", "Ljava/io/InputStreamReader;", "writeBytes", "array", "", "writeText", "text", "mmkernel_release"})
public final class p {
    public static final void b(o oVar, byte[] bArr) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(176826);
        kotlin.g.b.p.h(oVar, "$this$writeBytes");
        kotlin.g.b.p.h(bArr, "array");
        OutputStream ap = s.ap(oVar);
        try {
            ap.write(bArr);
            x xVar = x.SXb;
            b.a(ap, null);
            AppMethodBeat.o(176826);
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(ap, th2);
            AppMethodBeat.o(176826);
            throw th;
        }
    }

    private static String a(o oVar, Charset charset) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(176827);
        kotlin.g.b.p.h(oVar, "$this$readText");
        kotlin.g.b.p.h(charset, "charset");
        kotlin.g.b.p.h(oVar, "$this$reader");
        kotlin.g.b.p.h(charset, "charset");
        InputStream ao = s.ao(oVar);
        kotlin.g.b.p.g(ao, "VFSFileOp.openRead(this)");
        InputStreamReader inputStreamReader = new InputStreamReader(ao, charset);
        try {
            InputStreamReader inputStreamReader2 = inputStreamReader;
            kotlin.g.b.p.h(inputStreamReader2, "$this$readText");
            StringWriter stringWriter = new StringWriter();
            d.a(inputStreamReader2, stringWriter);
            String stringWriter2 = stringWriter.toString();
            kotlin.g.b.p.g(stringWriter2, "buffer.toString()");
            b.a(inputStreamReader, null);
            AppMethodBeat.o(176827);
            return stringWriter2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(inputStreamReader, th2);
            AppMethodBeat.o(176827);
            throw th;
        }
    }

    public static /* synthetic */ String an(o oVar) {
        AppMethodBeat.i(176828);
        String a2 = a(oVar, kotlin.n.d.UTF_8);
        AppMethodBeat.o(176828);
        return a2;
    }
}
