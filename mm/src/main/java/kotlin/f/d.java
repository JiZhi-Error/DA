package kotlin.f;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m.i;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\b\u001a5\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u0002\b\n\u0006\b\u0011(\u001e0\u0001¨\u0006 "}, hxF = {"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class d {
    public static final long a(Reader reader, Writer writer) {
        AppMethodBeat.i(129250);
        p.h(reader, "$this$copyTo");
        p.h(writer, "out");
        long j2 = 0;
        char[] cArr = new char[8192];
        int read = reader.read(cArr);
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j2 += (long) read;
            read = reader.read(cArr);
        }
        AppMethodBeat.o(129250);
        return j2;
    }

    public static final byte[] e(URL url) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(129251);
        p.h(url, "$this$readBytes");
        InputStream openStream = url.openStream();
        try {
            InputStream inputStream = openStream;
            p.g(inputStream, LocaleUtil.ITALIAN);
            byte[] U = a.U(inputStream);
            b.a(openStream, null);
            AppMethodBeat.o(129251);
            return U;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(openStream, th2);
            AppMethodBeat.o(129251);
            throw th;
        }
    }

    public static final void a(Reader reader, b<? super String, x> bVar) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(129249);
        p.h(reader, "$this$forEachLine");
        p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
        BufferedReader bufferedReader = new BufferedReader(reader, 8192);
        try {
            BufferedReader bufferedReader2 = bufferedReader;
            p.h(bufferedReader2, "$this$lineSequence");
            for (Object obj : i.a(new c(bufferedReader2))) {
                bVar.invoke(obj);
            }
            x xVar = x.SXb;
            b.a(bufferedReader, null);
            AppMethodBeat.o(129249);
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(bufferedReader, th2);
            AppMethodBeat.o(129249);
            throw th;
        }
    }
}
