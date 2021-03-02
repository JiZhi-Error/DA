package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class e extends f {
    public e(c.a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final boolean fbX() {
        boolean z;
        AppMethodBeat.i(96071);
        long j2 = -1;
        String l = !Util.isNullOrNil(this.DPt.DEt) && !Util.isNullOrNil(this.DPt.DEu) ? this.DPt.DEu : r.l(this.ebR);
        String str = this.DPt.getPath() + this.DPt.fbV();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapUtil.decodeFile(str, options);
        String lowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        long boW = s.boW(str);
        if (this.DPU || lowerCase.contains("webp")) {
            z = false;
        } else if (this.DPV || lowerCase.contains("vcodec")) {
            z = true;
        } else if (lowerCase.contains("wxam")) {
            z = true;
        } else {
            z = true;
        }
        switch (z) {
            case false:
                h.INSTANCE.idkeyStat(22, 64, 1, true);
                s.deleteFile(this.DPt.getPath() + l);
                long currentTicks = Util.currentTicks();
                com.tencent.mm.plugin.sns.storage.r.f(this.DPt.getPath(), this.DPt.getPath() + this.DPt.fbV(), l, false);
                long ticksToNow = Util.ticksToNow(currentTicks);
                s.deleteFile(this.DPt.getPath() + this.DPt.fbV());
                j2 = Util.ticksToNow(currentTicks);
                com.tencent.mm.plugin.sns.k.c.a(this.DPt.getPath() + l, this.DPt.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, boW, ticksToNow);
                break;
            case true:
            case true:
                Log.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", this.DPt.getPath() + this.DPt.fbV());
                s.deleteFile(this.DPt.getPath() + l);
                long currentTicks2 = Util.currentTicks();
                com.tencent.mm.plugin.sns.storage.r.f(this.DPt.getPath(), this.DPt.getPath() + this.DPt.fbV(), l, false);
                long ticksToNow2 = Util.ticksToNow(currentTicks2);
                s.deleteFile(this.DPt.getPath() + this.DPt.fbV());
                j2 = Util.ticksToNow(currentTicks2);
                com.tencent.mm.plugin.sns.k.c.a(this.DPt.getPath() + l, this.DPt.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, boW, ticksToNow2);
                break;
            case true:
                long j3 = -1;
                if (r.aOv(this.DPt.getPath() + this.DPt.fbV())) {
                    Log.w("MicroMsg.SnsDownloadImage", "the " + this.DPt.mediaId + " is too max ! " + this.DPt.url);
                    s.deleteFile(this.DPt.getPath() + l);
                    long currentTicks3 = Util.currentTicks();
                    com.tencent.mm.plugin.sns.storage.r.f(this.DPt.getPath(), this.DPt.getPath() + this.DPt.fbV(), l, false);
                    j3 = Util.ticksToNow(currentTicks3);
                    s.deleteFile(this.DPt.getPath() + this.DPt.fbV());
                    j2 = Util.ticksToNow(currentTicks3);
                } else {
                    s.bo(this.DPt.getPath(), this.DPt.fbV(), l);
                    j2 = 0;
                }
                int i2 = -1;
                if ((lowerCase.contains("jpg") || lowerCase.contains("jpeg")) && (i2 = MMNativeJpeg.queryQuality(this.DPt.getPath() + l)) == 0) {
                    i2 = -1;
                }
                com.tencent.mm.plugin.sns.k.c.a(this.DPt.getPath() + l, this.DPt.url, 0, options.outMimeType, options.outWidth, options.outHeight, i2, boW, j3);
                break;
        }
        Log.i("MicroMsg.SnsDownloadImage", "donwload big pic isWebp " + (!z));
        long boW2 = s.boW(this.DPt.getPath() + l);
        h.INSTANCE.a(11696, 3, Long.valueOf(j2), Long.valueOf(boW2), Thread.currentThread().getName(), aj.fbh(), b.aKD());
        boolean z2 = this.DPt.DPo != 3;
        if (!(this.DPt.DDH == null || this.DPt.DDH.DEs == 4 || this.DPt.DDH.DEs == 5)) {
            z2 = false;
        }
        if (z2) {
            String e2 = r.e(this.ebR);
            boolean z3 = 1 == ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_use_high_thumb, 0);
            if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                z3 = true;
            }
            if (!z3 || !s.YS(this.DPt.getPath() + e2)) {
                if (s.YS(this.DPt.getPath() + e2)) {
                    s.deleteFile(this.DPt.getPath() + e2);
                }
                long currentTicks4 = Util.currentTicks();
                com.tencent.mm.plugin.sns.storage.r.a(this.DPt.getPath(), l, e2, (float) aj.fbc());
                long ticksToNow3 = Util.ticksToNow(currentTicks4);
                s.boW(this.DPt.getPath() + e2);
                h.INSTANCE.a(11696, 3, Long.valueOf(ticksToNow3), Long.valueOf(boW2), Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD());
                a(this.DPt, this.ebR, l, (float) aj.fbb());
            } else {
                a(this.DPt, this.ebR, l, (float) aj.fbb());
                AppMethodBeat.o(96071);
                return true;
            }
        }
        AppMethodBeat.o(96071);
        return true;
    }

    private static void a(a aVar, cnb cnb, String str, float f2) {
        AppMethodBeat.i(202798);
        String f3 = r.f(cnb);
        if (!s.YS(aVar.getPath() + f3)) {
            com.tencent.mm.plugin.sns.storage.r.b(aVar.getPath(), str, f3, f2);
        }
        AppMethodBeat.o(202798);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final int getMediaType() {
        return 1;
    }
}
