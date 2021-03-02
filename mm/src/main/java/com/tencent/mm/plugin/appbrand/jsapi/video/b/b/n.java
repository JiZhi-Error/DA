package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.List;
import java.util.Map;

public final class n extends j {
    private static int myl = 3;
    private static boolean mym;
    private com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n mye;
    private e myn;
    private int myo = 0;
    private String uuid;

    public n(String str, i<String> iVar, s sVar, e eVar, com.tencent.mm.plugin.appbrand.jsapi.video.b.e.e<Map<String, List<String>>> eVar2, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n nVar) {
        super(str, iVar, sVar, true, eVar2);
        AppMethodBeat.i(234759);
        this.myn = eVar;
        this.mye = nVar;
        if (!mym) {
            myl = a.bJK().mxn;
            mym = true;
        }
        AppMethodBeat.o(234759);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j
    public final long a(g gVar) {
        AppMethodBeat.i(234760);
        this.uuid = gVar.uuid;
        try {
            long a2 = super.a(gVar);
            AppMethodBeat.o(234760);
            return a2;
        } catch (l.a e2) {
            long a3 = a(gVar, e2);
            AppMethodBeat.o(234760);
            return a3;
        }
    }

    private long a(g gVar, l.a aVar) {
        String str;
        AppMethodBeat.i(234761);
        int i2 = 0;
        if (aVar instanceof l.f) {
            i2 = ((l.f) aVar).responseCode;
        }
        String uri = gVar.uri.toString();
        h.log(4, getLogTag(), "retryOpen url=" + uri + " with responseCode=" + i2);
        String str2 = uri;
        int i3 = 0;
        while (true) {
            if (!Thread.currentThread().isInterrupted() && i3 < myl) {
                if (this.myn == null) {
                    h.log(4, getLogTag(), "httpRetryLogic is null");
                    break;
                }
                String bJS = this.myn.bJS();
                h.log(4, getLogTag(), "retryCount=" + i3 + " retryUrl=" + bJS);
                if (TextUtils.isEmpty(bJS)) {
                    str = str2;
                } else {
                    str = bJS;
                }
                if (str.equals(str2)) {
                    h.log(5, getLogTag(), "retryUrl is same as origin url");
                }
                int i4 = i3 + 1;
                int i5 = i4 * 2000;
                h.log(4, getLogTag(), "retry open retrying after " + i5 + " seconds  retry " + i4 + FilePathGenerator.ANDROID_DIR_SEP + myl);
                try {
                    Thread.sleep((long) i5);
                    try {
                        long b2 = super.b(new g(Uri.parse(str), gVar.bEP, gVar.position, gVar.length, gVar.key, gVar.flags, gVar.uuid, gVar.priority));
                        AppMethodBeat.o(234761);
                        return b2;
                    } catch (l.a e2) {
                        if (this.mye == null || !this.mye.xB(1)) {
                            str2 = str;
                            i3 = i4;
                        } else {
                            h.log(4, getLogTag(), "abort retryOpen videoRequest is cancelling " + this.mye + ", reason=" + h.i(e2));
                            l.b bVar = new l.b("retry open interrupted " + this.mye, this.mxt);
                            AppMethodBeat.o(234761);
                            throw bVar;
                        }
                    }
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                    l.b bVar2 = new l.b("retry open interrupted " + this.mye, this.mxt);
                    AppMethodBeat.o(234761);
                    throw bVar2;
                }
            } else {
                break;
            }
        }
        AppMethodBeat.o(234761);
        throw aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(234762);
        try {
            int read = super.read(bArr, i2, i3);
            AppMethodBeat.o(234762);
            return read;
        } catch (l.a e2) {
            int a2 = a(bArr, i2, i3, e2);
            AppMethodBeat.o(234762);
            return a2;
        }
    }

    private int a(byte[] bArr, int i2, int i3, l.a aVar) {
        AppMethodBeat.i(234763);
        h.log(4, getLogTag(), "read source error occurred " + aVar.toString());
        this.myo++;
        long j2 = this.mxt.position + this.bFB;
        int i4 = this.myo * 2000;
        h.log(4, getLogTag(), "retrying after " + i4 + " ms, read start at offset " + j2 + " retry " + this.myo + FilePathGenerator.ANDROID_DIR_SEP + myl);
        try {
            Thread.sleep((long) i4);
            g gVar = new g(Uri.parse(getUri()), 0, j2, -1, null, 0, this.uuid, this.mxt.priority);
            if (Thread.currentThread().isInterrupted() || this.myo >= myl) {
                AppMethodBeat.o(234763);
                throw aVar;
            } else if (this.mye.xB(1)) {
                h.log(4, getLogTag(), "abort retry videoRequest is cancelling " + this.mye);
                l.c cVar = new l.c("readRetry interrupted " + this.mye, this.mxt);
                AppMethodBeat.o(234763);
                throw cVar;
            } else {
                a(gVar);
                int read = read(bArr, i2, i3);
                AppMethodBeat.o(234763);
                return read;
            }
        } catch (InterruptedException e2) {
            h.log(5, getLogTag(), "readRetry interrupted");
            AppMethodBeat.o(234763);
            throw aVar;
        }
    }
}
