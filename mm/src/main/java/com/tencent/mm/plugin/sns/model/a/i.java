package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class i extends f {
    private boolean iDj = false;

    public i(c.a aVar, a aVar2) {
        super(aVar, aVar2);
        AppMethodBeat.i(96075);
        h.INSTANCE.idkeyStat(150, 10, 1, true);
        AppMethodBeat.o(96075);
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final boolean fbX() {
        int i2;
        String str;
        AppMethodBeat.i(96076);
        if (this.DPt.DDH != null) {
            String e2 = r.e(this.ebR);
            this.iDj = com.tencent.mm.plugin.sns.storage.r.aQF(this.DPt.getPath() + this.DPt.fbV());
            if (this.DPU) {
                this.iDj = true;
            }
            if (this.iDj) {
                h.INSTANCE.idkeyStat(22, 64, 1, true);
            }
            String str2 = this.DPt.getPath() + this.DPt.fbV();
            this.DPt.mediaType = r.aBO(str2);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str2, options);
            String lowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || Util.isNullOrNil(options.outMimeType)) {
                h.INSTANCE.idkeyStat(150, 35, 1, true);
            }
            if (lowerCase.contains("jpg") || lowerCase.contains("jpeg")) {
                i2 = MMNativeJpeg.queryQuality(str2);
                if (i2 == 0) {
                    i2 = -1;
                }
            } else {
                i2 = -1;
            }
            long boW = s.boW(str2);
            if (boW <= 0) {
                Log.e("MicroMsg.SnsDownloadThumb", "processData!!! file err!!! [%s].", str2);
                h.INSTANCE.idkeyStat(150, 23, 1, true);
            }
            long currentTicks = Util.currentTicks();
            String i3 = r.i(this.ebR);
            s.bo(this.DPt.getPath(), this.DPt.fbV(), i3);
            Log.v("MicroMsg.SnsDownloadThumb", "file src" + s.YS(this.DPt.getPath() + i3));
            long currentTicks2 = Util.currentTicks();
            if (!com.tencent.mm.plugin.sns.storage.r.a(this.DPt.getPath(), i3, e2, (float) aj.fbc())) {
                Log.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                h.INSTANCE.idkeyStat(150, 27, 1, true);
            }
            Log.i("MicroMsg.SnsDownloadThumb", "processData execute step1.");
            long ticksToNow = Util.ticksToNow(currentTicks2);
            boolean YS = s.YS(this.DPt.getPath() + i3);
            long ticksToNow2 = Util.ticksToNow(currentTicks);
            if (!s.YS(this.DPt.getPath() + e2)) {
                Log.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", Long.valueOf(s.boW(this.DPt.getPath() + e2)));
                h.INSTANCE.idkeyStat(150, 31, 1, true);
                if (YS && !s.YS(this.DPt.getPath() + e2)) {
                    boolean exI = d.INSTANCE.exI();
                    Log.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", Boolean.valueOf(exI));
                    h.INSTANCE.idkeyStat(150, 32, 1, true);
                    if (exI) {
                        h.INSTANCE.idkeyStat(150, 33, 1, true);
                    }
                }
            }
            h.INSTANCE.a(11696, 3, Long.valueOf(ticksToNow2), Integer.valueOf(this.DPM), Thread.currentThread().getName(), aj.fbh(), b.aKD());
            Log.i("MicroMsg.SnsDownloadThumb", "processData execute step2.");
            if (this.DPt.DDH.DEs == 0 || this.DPt.DDH.DEs == 5) {
                String f2 = r.f(this.ebR);
                com.tencent.mm.plugin.sns.storage.r.b(this.DPt.getPath(), e2, f2, (float) aj.fbb());
                str = f2;
            } else {
                str = e2;
            }
            com.tencent.mm.plugin.sns.k.c.a(this.DPt.getPath() + str, this.DPt.url, 1, options.outMimeType, options.outWidth, options.outHeight, i2, boW, ticksToNow);
            Log.i("MicroMsg.SnsDownloadThumb", "processData execute step3.");
            this.DPs = r.aOq(this.DPt.getPath() + str);
            boolean b2 = r.b(this.DPs);
            Log.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b2 + " isWebp: " + this.iDj + " srcImgFileSize: " + boW);
            if (!b2) {
                h.INSTANCE.idkeyStat(150, 65, 1, true);
                if (this.DPX) {
                    h.INSTANCE.idkeyStat(150, 50, 1, true);
                } else {
                    h.INSTANCE.idkeyStat(150, 51, 1, true);
                }
                if (this.DPV) {
                    h.INSTANCE.idkeyStat(150, 54, 1, true);
                }
                if (this.DPU) {
                    h.INSTANCE.idkeyStat(150, 57, 1, true);
                }
            }
            if (this.iDj && !b2) {
                h.INSTANCE.idkeyStat(22, 65, 1, true);
            }
            if (this.DPX && b2) {
                com.tencent.mm.plugin.sns.lucky.a.b.pl(com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX);
            }
        }
        AppMethodBeat.o(96076);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final boolean YM(int i2) {
        int i3;
        String str;
        AppMethodBeat.i(96077);
        if (this.DPt.DDI != null && this.DPt.DDI.size() > 0) {
            n nVar = this.DPt.DDI.get(i2);
            cnb cnb = this.DPt.DEw.get(i2);
            if (nVar == null || cnb == null) {
                Log.e("MicroMsg.SnsDownloadThumb", "decodeElement or media is null.");
                AppMethodBeat.o(96077);
                return false;
            }
            Log.i("MicroMsg.SnsDownloadThumb", "In processGroupDownloadSuccessData ing, %d.", Integer.valueOf(i2));
            String str2 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.n(cnb);
            String e2 = r.e(cnb);
            this.iDj = com.tencent.mm.plugin.sns.storage.r.aQF(str2);
            if (this.DPU) {
                this.iDj = true;
            }
            if (this.iDj) {
                h.INSTANCE.idkeyStat(22, 64, 1, true);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str2, options);
            String lowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || Util.isNullOrNil(options.outMimeType)) {
                h.INSTANCE.idkeyStat(150, 35, 1, true);
            }
            int i4 = -1;
            if ((lowerCase.contains("jpg") || lowerCase.contains("jpeg")) && (i4 = MMNativeJpeg.queryQuality(str2)) == 0) {
                i3 = -1;
            } else {
                i3 = i4;
            }
            this.DPt.mediaType = r.aBO(str2);
            long boW = s.boW(str2);
            if (boW <= 0) {
                Log.e("MicroMsg.SnsDownloadThumb", "processGroupDownloadSuccessData!!! file err!!! [%s].", str2);
                h.INSTANCE.idkeyStat(150, 23, 1, true);
            }
            long currentTicks = Util.currentTicks();
            String i5 = r.i(cnb);
            s.nw(str2, ar.ki(aj.getAccSnsPath(), cnb.Id) + i5);
            Log.v("MicroMsg.SnsDownloadThumb", "file exist " + s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + i5));
            long currentTicks2 = Util.currentTicks();
            if (!com.tencent.mm.plugin.sns.storage.r.a(ar.ki(aj.getAccSnsPath(), cnb.Id), r.n(cnb), e2, (float) aj.fbc())) {
                Log.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                h.INSTANCE.idkeyStat(150, 27, 1, true);
            }
            long ticksToNow = Util.ticksToNow(currentTicks2);
            boolean YS = s.YS(str2);
            s.deleteFile(str2);
            long ticksToNow2 = Util.ticksToNow(currentTicks);
            if (!s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + e2)) {
                Log.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s.", Long.valueOf(s.boW(this.DPt.getPath() + e2)));
                h.INSTANCE.idkeyStat(150, 31, 1, true);
                if (YS) {
                    if (!s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + e2)) {
                        boolean exI = d.INSTANCE.exI();
                        Log.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", Boolean.valueOf(exI));
                        h.INSTANCE.idkeyStat(150, 32, 1, true);
                        if (exI) {
                            h.INSTANCE.idkeyStat(150, 33, 1, true);
                        }
                    }
                }
            }
            h.INSTANCE.a(11696, 3, Long.valueOf(ticksToNow2), Integer.valueOf(this.DPM), Thread.currentThread().getName(), aj.fbh(), b.aKD());
            if (nVar.DEs == 0 || this.DPt.DDH.DEs == 5) {
                str = r.f(cnb);
                com.tencent.mm.plugin.sns.storage.r.b(ar.ki(aj.getAccSnsPath(), cnb.Id), e2, str, (float) aj.fbb());
            } else {
                str = e2;
            }
            com.tencent.mm.plugin.sns.k.c.a(ar.ki(aj.getAccSnsPath(), cnb.Id) + str, cnb.Msz, 1, options.outMimeType, options.outWidth, options.outHeight, i3, boW, ticksToNow);
            this.DPs = r.aOq(ar.ki(aj.getAccSnsPath(), cnb.Id) + str);
            this.DPN.put(i2, this.DPs);
            boolean b2 = r.b(this.DPs);
            Log.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b2 + " isWebp: " + this.iDj + " srcImgFileSize: " + boW + " index: " + i2);
            if (!b2) {
                h.INSTANCE.idkeyStat(150, 65, 1, true);
                if (this.DPX) {
                    h.INSTANCE.idkeyStat(150, 50, 1, true);
                } else {
                    h.INSTANCE.idkeyStat(150, 51, 1, true);
                }
                if (this.DPV) {
                    h.INSTANCE.idkeyStat(150, 54, 1, true);
                }
                if (this.DPU) {
                    h.INSTANCE.idkeyStat(150, 57, 1, true);
                }
            }
            if (this.iDj && !b2) {
                h.INSTANCE.idkeyStat(22, 65, 1, true);
            }
            if (this.DPX && b2) {
                com.tencent.mm.plugin.sns.lucky.a.b.pl(com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX);
            }
        }
        AppMethodBeat.o(96077);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final int getMediaType() {
        return 3;
    }
}
