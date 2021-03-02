package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class c implements e {
    private long bEJ;
    private final boolean bGd;
    private final boolean bGe;
    private long bGi;
    private long bGm;
    private int flags;
    private long kNt;
    private String key;
    private final e mxA;
    private final e mxB;
    public final e mxC;
    private final a mxD;
    private e mxE;
    private f mxF;
    private boolean mxG;
    private boolean mxH;
    private final a mxs;
    private String mxw = "";
    private long mxx = 0;
    private int mxy;
    private long mxz;
    private int priority;
    private Uri uri;
    private String uuid;

    public interface a {
        void a(String str, int i2, long j2, long j3, long j4);

        void b(String str, long j2, long j3, long j4);

        void k(long j2, long j3);
    }

    public c(a aVar, e eVar, e eVar2, d dVar, a aVar2) {
        AppMethodBeat.i(234669);
        this.mxs = aVar;
        this.mxA = eVar2;
        this.bGd = false;
        this.bGe = true;
        this.mxC = eVar;
        if (dVar != null) {
            this.mxB = new r(eVar, dVar);
        } else {
            this.mxB = null;
        }
        this.mxD = aVar2;
        AppMethodBeat.o(234669);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long a(g gVar) {
        AppMethodBeat.i(234670);
        try {
            this.uri = gVar.uri;
            this.flags = gVar.flags;
            this.uuid = gVar.uuid;
            this.key = gVar.key;
            this.bGi = gVar.position;
            this.bEJ = gVar.length;
            this.priority = gVar.priority;
            long currentTimeMillis = System.currentTimeMillis();
            long bJO = bJO();
            this.kNt = getTotalLength();
            this.mxx = System.currentTimeMillis() - currentTimeMillis;
            AppMethodBeat.o(234670);
            return bJO;
        } catch (IOException e2) {
            if (this.mxE instanceof k) {
                h.log(6, getLogTag(), "open cache error " + e2.toString());
            } else {
                h.log(6, getLogTag(), "open error " + e2.toString());
            }
            b(e2);
            if (!this.mxG) {
                AppMethodBeat.o(234670);
                throw e2;
            }
            try {
                wQ();
            } catch (Exception e3) {
                h.a(5, getLogTag(), "open, failed on closeCurrentSource, shouldn't be a problem", e3);
            }
            h.log(6, getLogTag(), "open cache error, try reopen without cache");
            long currentTimeMillis2 = System.currentTimeMillis();
            long bJO2 = bJO();
            this.kNt = getTotalLength();
            this.mxx = System.currentTimeMillis() - currentTimeMillis2;
            AppMethodBeat.o(234670);
            return bJO2;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(234671);
        try {
            if (!this.mxH && (this.mxE instanceof k) && com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().cWq) {
                h.log(4, getLogTag(), "read from cache " + ((k) this.mxE).getUri() + ", fileSize=" + this.mxE.available());
            }
            long currentTimeMillis = System.currentTimeMillis();
            int read = this.mxE.read(bArr, i2, i3);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (!this.mxH) {
                if (!(this.mxE == this.mxA || com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp == null || this.priority != 90 || !URLUtil.isNetworkUrl(this.uri.toString()) || this.mxD == null)) {
                    this.mxD.b(this.uuid, this.mxx, this.mxx, currentTimeMillis2);
                }
                this.mxH = true;
            }
            if (read >= 0) {
                if (this.mxE == this.mxA) {
                    this.bGm += (long) read;
                } else {
                    this.mxy += read;
                    this.mxz += currentTimeMillis2;
                }
                this.bGi += (long) read;
                if (this.bEJ != -1) {
                    this.bEJ -= (long) read;
                }
            } else {
                if (this.mxD != null) {
                    if (this.priority == 90) {
                        this.mxD.a(this.uuid, this.mxy, this.mxz, this.kNt, this.bGm);
                    }
                    this.mxy = 0;
                    this.mxz = 0;
                    if (this.mxE == this.mxA && this.bGm > 0) {
                        this.mxD.k(this.mxs.wN(), this.bGm);
                        this.bGm = 0;
                    }
                }
                wQ();
                if (this.bEJ > 0) {
                    bJO();
                    int read2 = read(bArr, i2, i3);
                    AppMethodBeat.o(234671);
                    return read2;
                }
            }
            AppMethodBeat.o(234671);
            return read;
        } catch (IOException e2) {
            if (this.mxE instanceof k) {
                h.log(6, getLogTag(), "read cache error " + e2.toString());
            } else {
                h.log(6, getLogTag(), "read error " + e2.toString());
            }
            b(e2);
            AppMethodBeat.o(234671);
            throw e2;
        }
    }

    private long bJO() {
        f R;
        long min;
        g gVar;
        e eVar;
        c cVar;
        boolean z = false;
        AppMethodBeat.i(234672);
        try {
            if (this.mxG) {
                R = null;
            } else if (this.bGd) {
                R = this.mxs.Q(this.key, this.bGi);
            } else {
                R = this.mxs.R(this.key, this.bGi);
            }
            if (R == null) {
                this.mxE = this.mxC;
                gVar = new g(this.uri, this.bGi, this.bGi, this.bEJ, this.key, this.flags, this.uuid, this.priority);
            } else {
                if (R.bGq) {
                    Uri uriForFile = FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), R.file);
                    long j2 = this.bGi - R.position;
                    if (this.bEJ == -1) {
                        this.bEJ = R.kNt - this.bGi;
                    } else if (this.bEJ > R.kNt - this.bGi) {
                        h.log(5, getLogTag(), "fix bytesRemaining, max=" + (R.kNt - this.bGi) + " current=" + this.bEJ);
                        this.bEJ = R.kNt - this.bGi;
                    }
                    gVar = new g(uriForFile, this.bGi, j2, Math.min(R.length - j2, this.bEJ), this.key, this.flags, this.uuid, this.priority);
                    eVar = this.mxA;
                    cVar = this;
                } else {
                    this.mxF = R;
                    if (R.length == -1) {
                        z = true;
                    }
                    if (z) {
                        min = this.bEJ;
                    } else {
                        min = this.bEJ != -1 ? Math.min(R.length, this.bEJ) : R.length;
                    }
                    gVar = new g(this.uri, this.bGi, this.bGi, min, this.key, this.flags, this.uuid, this.priority);
                    if (this.mxB != null) {
                        eVar = this.mxB;
                        cVar = this;
                    } else {
                        eVar = this.mxC;
                        cVar = this;
                    }
                }
                cVar.mxE = eVar;
            }
            long a2 = this.mxE.a(gVar);
            if ((this.mxE instanceof l) && this.mxE.getTotalLength() != -1 && gVar.position >= this.mxE.getTotalLength() - 1) {
                h.log(6, getLogTag(), "read position out of bound");
            }
            if (this.bEJ == -1 && this.mxE.getTotalLength() != -1) {
                this.bEJ = this.mxE.getTotalLength() - this.bGi;
                h.log(4, getLogTag(), "init bytesRemaining " + this.bEJ + ", readPosition=" + this.bGi + ", totalLength=" + this.mxE.getTotalLength());
            }
            this.bEJ = Math.max(0L, Math.min(this.bEJ, getTotalLength()));
            this.mxH = false;
            AppMethodBeat.o(234672);
            return a2;
        } catch (InterruptedException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(234672);
            throw runtimeException;
        }
    }

    private void wQ() {
        AppMethodBeat.i(234673);
        if (this.mxE == null) {
            AppMethodBeat.o(234673);
            return;
        }
        try {
            this.mxE.close();
            this.mxE = null;
            if (this.mxF != null) {
                this.mxs.a(this.mxF);
                this.mxF = null;
                AppMethodBeat.o(234673);
                return;
            }
            AppMethodBeat.o(234673);
        } catch (Throwable th) {
            if (this.mxF != null) {
                this.mxs.a(this.mxF);
                this.mxF = null;
            }
            AppMethodBeat.o(234673);
            throw th;
        }
    }

    private void b(IOException iOException) {
        AppMethodBeat.i(234674);
        h.log(3, getLogTag(), "handleBeforeThrow " + iOException + ", ignoreCacheOnError=" + this.bGe + ", currentDataSource=" + this.mxE);
        if (this.bGe && this.mxE == this.mxA) {
            h.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.mxE + ", exception=" + iOException);
            this.mxG = true;
        }
        AppMethodBeat.o(234674);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long available() {
        AppMethodBeat.i(234675);
        if (this.mxE == null) {
            AppMethodBeat.o(234675);
            return 0;
        }
        long available = this.mxE.available();
        AppMethodBeat.o(234675);
        return available;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void close() {
        AppMethodBeat.i(234676);
        try {
            wQ();
            AppMethodBeat.o(234676);
        } catch (IOException e2) {
            if (this.mxE instanceof k) {
                h.log(6, getLogTag(), "close cache error " + e2.toString());
            } else {
                h.log(6, getLogTag(), "close error " + e2.toString());
            }
            b(e2);
            AppMethodBeat.o(234676);
            throw e2;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c bJP() {
        AppMethodBeat.i(234677);
        if (this.mxE == null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c cVar = com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.myu;
            AppMethodBeat.o(234677);
            return cVar;
        } else if (this.mxE != this.mxA || this.mxs == null) {
            com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c bJP = this.mxE.bJP();
            AppMethodBeat.o(234677);
            return bJP;
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c aaZ = this.mxs.aaZ(this.key);
            AppMethodBeat.o(234677);
            return aaZ;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long getTotalLength() {
        AppMethodBeat.i(234678);
        if (this.mxE == null) {
            AppMethodBeat.o(234678);
            return -1;
        } else if (this.mxE != this.mxA || this.mxs == null) {
            long totalLength = this.mxE.getTotalLength();
            AppMethodBeat.o(234678);
            return totalLength;
        } else {
            long aaY = this.mxs.aaY(this.key);
            AppMethodBeat.o(234678);
            return aaY;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void setLogTag(String str) {
        this.mxw = str;
    }

    private String getLogTag() {
        AppMethodBeat.i(234679);
        String str = this.mxw + "CacheDataSource";
        AppMethodBeat.o(234679);
        return str;
    }
}
