package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d extends b {
    private long DPS = 0;
    private int DPT = 0;

    public d(c.a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    @Override // com.tencent.mm.plugin.sns.model.a.b, com.tencent.mm.plugin.sns.model.a.c
    public final String aPI(String str) {
        return str;
    }

    @Override // com.tencent.mm.plugin.sns.model.a.b, com.tencent.mm.plugin.sns.model.a.c
    public final boolean fbW() {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.model.a.b
    public final x a(x xVar) {
        AppMethodBeat.i(96068);
        this.DPS = 0;
        if (this.DPS > 0) {
            Log.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.DPS);
            xVar.setRequestProperty("RANGE", "bytes=" + this.DPS + "-");
        }
        AppMethodBeat.o(96068);
        return xVar;
    }

    @Override // com.tencent.mm.plugin.sns.model.a.b
    public final boolean K(InputStream inputStream) {
        AppMethodBeat.i(96069);
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[1024];
            String str = this.DPt.getPath() + this.DPt.fbV();
            Log.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(s.boW(str))));
            OutputStream dw = s.dw(str, true);
            int i2 = 1;
            long currentTimeMillis = System.currentTimeMillis();
            this.DPE.value = "";
            boolean z = false;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    if (this.DPH == 0) {
                        this.DPH = Util.milliSecondsToNow(this.DPI);
                    }
                    if (read > this.DPF) {
                        this.DPF = read;
                        this.DPG = Util.nowSecond();
                    }
                    if (!r.aOt(aj.getAccPath())) {
                        Log.i("MicroMsg.SnsDownloadAdSight", "read data");
                        dw.close();
                        inputStream.close();
                        if (dw != null) {
                            try {
                                dw.close();
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(96069);
                        return false;
                    }
                    dw.write(bArr, 0, read);
                    this.DPM += read;
                    if (this.DPM - this.DPT > Downloads.SPLIT_RANGE_SIZE_WAP * i2) {
                        aj.dRd().post(new Runnable(this.DPt.mediaId, str) {
                            /* class com.tencent.mm.plugin.sns.model.c.AnonymousClass3 */
                            final /* synthetic */ String LY;
                            final /* synthetic */ String val$path;

                            {
                                this.LY = r2;
                                this.val$path = r3;
                            }

                            public final void run() {
                                AppMethodBeat.i(95415);
                                if (c.this.DGK != null) {
                                    for (a aVar : c.this.DGK) {
                                        if (aVar != null) {
                                            aVar.ke(this.LY, this.val$path);
                                        }
                                    }
                                }
                                AppMethodBeat.o(95415);
                            }
                        });
                        this.DPT = this.DPM;
                        i2++;
                    }
                    z = true;
                    if (a(this.DPM, currentTimeMillis, this.DPE)) {
                        currentTimeMillis = System.currentTimeMillis();
                        z = false;
                    }
                } else {
                    dw.close();
                    if (z) {
                        a(this.DPM, 0, this.DPE);
                    }
                    Log.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(s.boW(this.DPt.getPath() + this.DPt.fbV()))));
                    AppMethodBeat.o(96069);
                    return true;
                }
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e3, "snscdndownload fail : " + e3.getMessage(), new Object[0]);
            Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e3, "", new Object[0]);
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(96069);
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(96069);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.a.b, com.tencent.mm.plugin.sns.model.a.c
    public final boolean fbX() {
        AppMethodBeat.i(96070);
        long boW = s.boW(this.DPt.getPath() + this.DPt.fbV());
        Log.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + boW + " " + this.DPJ);
        if (boW < ((long) this.DPJ) + this.DPS) {
            AppMethodBeat.o(96070);
            return false;
        }
        s.bo(this.DPt.getPath(), this.DPt.fbV(), r.k(this.ebR));
        AppMethodBeat.o(96070);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.model.a.b, com.tencent.mm.plugin.sns.model.a.c
    public final int getMediaType() {
        return 4;
    }
}
