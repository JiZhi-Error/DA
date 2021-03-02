package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class h extends b {
    public h(c.a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    @Override // com.tencent.mm.plugin.sns.model.a.b, com.tencent.mm.plugin.sns.model.a.c
    public final String aPI(String str) {
        return str;
    }

    @Override // com.tencent.mm.plugin.sns.model.a.b
    public final boolean K(InputStream inputStream) {
        AppMethodBeat.i(96073);
        Log.i("MicroMsg.SnsDownloadSightForAdShort", "download sight. %s ", this.DPt.getPath() + this.DPt.fbV());
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[1024];
            OutputStream dw = s.dw(this.DPt.getPath() + this.DPt.fbV(), false);
            long currentTimeMillis = System.currentTimeMillis();
            this.DPE.value = "";
            boolean z = false;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    if (read > this.DPF) {
                        this.DPF = read;
                        this.DPG = Util.nowSecond();
                    }
                    if (this.DPH == 0) {
                        this.DPH = Util.milliSecondsToNow(this.DPI);
                    }
                    if (!r.aOt(aj.getAccPath())) {
                        dw.close();
                        inputStream.close();
                        if (dw != null) {
                            try {
                                dw.close();
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e2, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(96073);
                        return false;
                    }
                    dw.write(bArr, 0, read);
                    this.DPM += read;
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
                    AppMethodBeat.o(96073);
                    return true;
                }
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e3, "snscdndownload fail : " + e3.getMessage(), new Object[0]);
            Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e3, "", new Object[0]);
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(96073);
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(96073);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.a.b, com.tencent.mm.plugin.sns.model.a.c
    public final boolean fbX() {
        AppMethodBeat.i(96074);
        s.bo(this.DPt.getPath(), this.DPt.fbV(), r.j(this.ebR));
        AppMethodBeat.o(96074);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.model.a.b, com.tencent.mm.plugin.sns.model.a.c
    public final int getMediaType() {
        return 2;
    }
}
