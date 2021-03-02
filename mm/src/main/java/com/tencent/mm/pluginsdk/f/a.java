package com.tencent.mm.pluginsdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.f.g;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a implements h {
    String GaX;
    public String JTA;
    public String JTB;
    public int JTC;
    public String JTD;
    public String JTE;
    public String JTF;
    private g JTG;
    private String JTH;
    private List<f> JTI;
    private List<f> JTJ;
    private int JTK;
    private int JTL = 0;
    private long JTv;
    private int JTw;
    private int JTx;
    public String JTy;
    public String JTz;
    public int fileType;
    private boolean isRunning;
    public String ixb;
    public int scene;
    private int successCount;

    public final void bP(String str, long j2) {
        this.GaX = str;
        this.JTv = j2;
    }

    public a(g gVar) {
        AppMethodBeat.i(223722);
        this.JTG = gVar;
        this.JTx = gmd();
        this.JTw = ((b) g.af(b.class)).a(b.a.clicfg_cgi_upload_concurrent_max_android, 10);
        this.JTI = Collections.synchronizedList(new ArrayList());
        this.JTJ = Collections.synchronizedList(new ArrayList());
        AppMethodBeat.o(223722);
    }

    public final void dUx() {
        AppMethodBeat.i(223723);
        if (this.isRunning) {
            Log.d("MicroMsg.CGIFileUploader", "uploader is already running");
            AppMethodBeat.o(223723);
        } else if (!s.YS(this.GaX)) {
            Log.e("MicroMsg.CGIFileUploader", "file %s not exist", this.GaX);
            if (this.JTG != null) {
                this.JTG.a(this, this.JTH, -30001);
            }
            AppMethodBeat.o(223723);
        } else {
            long j2 = this.JTv;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                e eVar = new e();
                eVar.filePath = this.GaX;
                eVar.fileSize = this.JTv;
                eVar.JTX = i2;
                eVar.JTY = i3;
                if (((long) (this.JTx + i3)) > j2) {
                    eVar.JTx = (int) (j2 - ((long) i3));
                } else {
                    eVar.JTx = this.JTx;
                }
                i3 += this.JTx;
                f fVar = new f();
                fVar.JUd = this;
                fVar.JUb = eVar;
                fVar.taskId = eVar.JTX;
                fVar.retryCount = 0;
                fVar.yiR = ((b) g.af(b.class)).a(b.a.clicfg_parallel_cgi_upload_retry_max_android, 3);
                if (i2 == 0) {
                    this.JTF = s.bhK(this.GaX);
                    cyy cyy = new cyy();
                    cyy.Scene = this.scene;
                    cyy.KKA = this.fileType;
                    cyy.FileSize = (int) this.JTv;
                    cyy.MEb = this.JTF;
                    cyy.MEc = this.JTx;
                    cyy.MEd = this.JTz;
                    cyy.MEe = this.ixb;
                    cyy.MEg = this.JTA;
                    cyy.MEh = this.JTB;
                    cyy.MEi = this.JTC;
                    cyy.MEf = this.JTy;
                    cyy.keb = this.JTD;
                    cyy.MEj = this.JTE;
                    fVar.JUa = cyy;
                }
                this.JTJ.add(fVar);
                int i4 = i2 + 1;
                if (((long) i3) >= j2) {
                    this.JTK = this.JTJ.size();
                    Log.i("MicroMsg.CGIFileUploader", "will start upload, file = %s, scene = %s, fileType = %s, sectionLen = %s, sectionCount = %s", this.GaX, Integer.valueOf(this.scene), Integer.valueOf(this.fileType), Integer.valueOf(this.JTx), Integer.valueOf(this.JTJ.size()));
                    this.isRunning = true;
                    gme();
                    AppMethodBeat.o(223723);
                    return;
                }
                i2 = i4;
            }
        }
    }

    private void gme() {
        AppMethodBeat.i(223724);
        if (this.JTJ.size() <= 0) {
            Log.e("MicroMsg.CGIFileUploader", "no section to upload, file:%s", this.GaX);
            if (this.JTG != null) {
                this.JTG.a(this, this.JTH, -30003);
            }
            AppMethodBeat.o(223724);
            return;
        }
        f fVar = this.JTJ.get(0);
        this.JTJ.remove(0);
        this.JTI.add(fVar);
        fVar.gmh();
        AppMethodBeat.o(223724);
    }

    private void ahy(int i2) {
        AppMethodBeat.i(223725);
        gmf();
        if (this.JTG != null) {
            this.JTG.a(this, this.JTH, i2);
        }
        AppMethodBeat.o(223725);
    }

    private boolean ahz(int i2) {
        AppMethodBeat.i(223726);
        if (!this.isRunning) {
            Log.i("MicroMsg.CGIFileUploader", "it means error has occurred, return.");
            AppMethodBeat.o(223726);
            return false;
        }
        while (this.JTI.size() < this.JTw && this.JTJ.size() > 1) {
            if (i2 - 1 == this.JTL) {
                Log.e("MicroMsg.CGIFileUploader", "The whole piece is uploaded, but the limit value is not updated [%s, %s]", Integer.valueOf(i2), Integer.valueOf(this.JTL + 1));
                ahy(-30004);
                AppMethodBeat.o(223726);
                return false;
            }
            f fVar = this.JTJ.get(0);
            if (fVar.taskId > this.JTL) {
                Log.i("MicroMsg.CGIFileUploader", "upload too fast, need to wait for the previous task to complete first");
                AppMethodBeat.o(223726);
                return true;
            }
            this.JTJ.remove(0);
            this.JTI.add(fVar);
            fVar.gmh();
            Log.i("MicroMsg.CGIFileUploader", "start section idx = %s", Integer.valueOf(fVar.JUb.JTX));
        }
        AppMethodBeat.o(223726);
        return true;
    }

    private void gmf() {
        AppMethodBeat.i(223727);
        this.isRunning = false;
        for (f fVar : this.JTI) {
            fVar.gmi();
        }
        AppMethodBeat.o(223727);
    }

    @Override // com.tencent.mm.pluginsdk.f.h
    public final void a(f fVar, cyx cyx) {
        AppMethodBeat.i(223728);
        this.successCount++;
        int i2 = cyx != null ? cyx.MEa : 0;
        Log.i("MicroMsg.CGIFileUploader", "upload section success, index = %s, successCount:%s, partIDLimit:%s", Integer.valueOf(fVar.JUb.JTX), Integer.valueOf(this.successCount), Integer.valueOf(i2));
        this.JTI.remove(fVar);
        if (i2 <= this.JTL) {
            i2 = this.JTL;
        }
        this.JTL = i2;
        if (this.JTK > 0) {
            this.JTG.a(this, (((float) this.successCount) * 1.0f) / ((float) this.JTK), (long) (fVar.JUb.JTY + fVar.JUb.JTx));
        }
        if (fVar.JUb.JTX == 0) {
            if (Util.isNullOrNil(cyx.MDU)) {
                Log.e("MicroMsg.CGIFileUploader", "no upload id return!");
                ahy(-30002);
                AppMethodBeat.o(223728);
                return;
            }
            this.JTH = cyx.MDU;
            for (f fVar2 : this.JTJ) {
                fVar2.JTZ = cyx.MDU;
            }
        }
        if (!ahz(this.successCount)) {
            AppMethodBeat.o(223728);
            return;
        }
        if (this.JTJ.size() == 1 && this.JTI.size() == 0) {
            gme();
        }
        if (this.JTJ.size() == 0 && this.JTI.size() == 0) {
            g.a aVar = new g.a();
            aVar.JTZ = this.JTH;
            aVar.fileId = cyx.LxW;
            aVar.aesKey = cyx.AesKey;
            aVar.JUg = cyx.MDZ;
            aVar.jPY = this.JTv;
            gmf();
            if (this.JTG != null) {
                this.JTG.a(this, aVar);
            }
        }
        AppMethodBeat.o(223728);
    }

    @Override // com.tencent.mm.pluginsdk.f.h
    public final void a(f fVar, boolean z, int i2) {
        AppMethodBeat.i(223729);
        Log.e("MicroMsg.CGIFileUploader", "upload section failure, index = %s, canRetry:%s, retCode:%s", Integer.valueOf(fVar.JUb.JTX), Boolean.valueOf(z), Integer.valueOf(i2));
        this.JTI.remove(fVar);
        if (z) {
            fVar.retryCount++;
            if (fVar.JUb.JTX == 0) {
                this.JTJ.add(0, fVar);
                gme();
                AppMethodBeat.o(223729);
            } else if (fVar.JUb.JTX == this.JTK - 1) {
                this.JTJ.add(fVar);
                gme();
                AppMethodBeat.o(223729);
            } else {
                this.JTJ.add(0, fVar);
                ahz(this.successCount);
                AppMethodBeat.o(223729);
            }
        } else {
            ahy(i2);
            AppMethodBeat.o(223729);
        }
    }

    private static int gmd() {
        AppMethodBeat.i(223721);
        try {
            String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ParallelUploadPartSize");
            if (Util.isNullOrNil(value)) {
                Log.i("MicroMsg.CGIFileUploader", "getFileSizeLimit nullOrNil");
            } else {
                Log.i("MicroMsg.CGIFileUploader", "getFileSizeLimit ".concat(String.valueOf(value)));
            }
            int i2 = Util.getInt(value, 32768);
            AppMethodBeat.o(223721);
            return i2;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.CGIFileUploader", th, "getFileSizeLimit", new Object[0]);
            AppMethodBeat.o(223721);
            return 32768;
        }
    }
}
