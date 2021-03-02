package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public final class b {
    public g.a iZc = new g.a() {
        /* class com.tencent.mm.plugin.appbrand.b.b.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(44811);
            Log.i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.o(44811);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(44812);
            Log.i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.o(44812);
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
        @Override // com.tencent.mm.i.g.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(java.lang.String r11, int r12, com.tencent.mm.i.c r13, com.tencent.mm.i.d r14, boolean r15) {
            /*
            // Method dump skipped, instructions count: 501
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.b.b.AnonymousClass1.a(java.lang.String, int, com.tencent.mm.i.c, com.tencent.mm.i.d, boolean):int");
        }
    };
    public Vector<d.b> laX = new Vector<>();
    public Vector<d.a> laY = new Vector<>();
    HashMap<String, Object> laZ = new HashMap<>();
    private h.a lba = new h.a() {
        /* class com.tencent.mm.plugin.appbrand.b.b.AnonymousClass2 */

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, long j2, long j3, String str2) {
            AppMethodBeat.i(226460);
            Log.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", str, Long.valueOf(j2), Long.valueOf(j3));
            b.this.laZ.get(str);
            AppMethodBeat.o(226460);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(String str, long j2, long j3) {
            AppMethodBeat.i(44815);
            Log.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", str, Long.valueOf(j2), Long.valueOf(j3));
            b.this.laZ.get(str);
            AppMethodBeat.o(44815);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(String str, long j2, long j3) {
            AppMethodBeat.i(44816);
            Log.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", str, Long.valueOf(j2), Long.valueOf(j3));
            b.this.laZ.get(str);
            AppMethodBeat.o(44816);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(44817);
            Log.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", str, Integer.valueOf(i2));
            b.this.laZ.get(str);
            AppMethodBeat.o(44817);
        }
    };

    public b() {
        AppMethodBeat.i(44818);
        AppMethodBeat.o(44818);
    }

    public final void a(d.b bVar) {
        AppMethodBeat.i(44819);
        if (!(this.laX == null || bVar == null)) {
            this.laX.remove(bVar);
        }
        AppMethodBeat.o(44819);
    }

    public final void a(d.a aVar) {
        AppMethodBeat.i(44820);
        if (!(this.laY == null || aVar == null)) {
            this.laY.remove(aVar);
        }
        AppMethodBeat.o(44820);
    }

    public static boolean WG(String str) {
        AppMethodBeat.i(44821);
        a WH = n.buN().WH(str);
        if (WH == null) {
            Log.e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", str);
            AppMethodBeat.o(44821);
            return false;
        }
        boolean Ob = f.baQ().Ob(WH.mediaId);
        AppMethodBeat.o(44821);
        return Ob;
    }

    static /* synthetic */ void a(b bVar, boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(44823);
        if (bVar.laX != null && bVar.laX.size() > 0) {
            Iterator<d.b> it = bVar.laX.iterator();
            while (it.hasNext()) {
                it.next().b(z, str, str2, str3);
            }
        }
        AppMethodBeat.o(44823);
    }
}
