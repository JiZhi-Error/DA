package com.tencent.mm.av.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b implements c {
    @Override // com.tencent.mm.av.a.c.c
    public final com.tencent.mm.av.a.d.b OV(String str) {
        AppMethodBeat.i(130412);
        Log.d("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data from url:%s", str);
        try {
            com.tencent.mm.av.a.d.b OW = a.OW(str);
            AppMethodBeat.o(130412);
            return OW;
        } catch (InterruptedException e2) {
            Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e2));
            com.tencent.mm.av.a.d.b bVar = new com.tencent.mm.av.a.d.b(null, null);
            AppMethodBeat.o(130412);
            return bVar;
        } catch (UnknownHostException e3) {
            Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e3));
            com.tencent.mm.av.a.d.b bVar2 = new com.tencent.mm.av.a.d.b(null, null);
            AppMethodBeat.o(130412);
            return bVar2;
        } catch (SSLHandshakeException e4) {
            Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e4));
            com.tencent.mm.av.a.d.b bVar22 = new com.tencent.mm.av.a.d.b(null, null);
            AppMethodBeat.o(130412);
            return bVar22;
        } catch (SocketException e5) {
            Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e5));
            com.tencent.mm.av.a.d.b bVar222 = new com.tencent.mm.av.a.d.b(null, null);
            AppMethodBeat.o(130412);
            return bVar222;
        } catch (SocketTimeoutException e6) {
            Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e6));
            com.tencent.mm.av.a.d.b bVar2222 = new com.tencent.mm.av.a.d.b(null, null);
            AppMethodBeat.o(130412);
            return bVar2222;
        } catch (IOException e7) {
            Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e7));
            com.tencent.mm.av.a.d.b bVar22222 = new com.tencent.mm.av.a.d.b(null, null);
            AppMethodBeat.o(130412);
            return bVar22222;
        } catch (Exception e8) {
            Log.e("MicroMsg.imageload.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e8));
            com.tencent.mm.av.a.d.b bVar222222 = new com.tencent.mm.av.a.d.b(null, null);
            AppMethodBeat.o(130412);
            return bVar222222;
        }
    }

    static class a {
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[SYNTHETIC, Splitter:B:26:0x0087] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.av.a.d.b OW(java.lang.String r7) {
            /*
            // Method dump skipped, instructions count: 148
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.a.b.b.a.OW(java.lang.String):com.tencent.mm.av.a.d.b");
        }
    }
}
