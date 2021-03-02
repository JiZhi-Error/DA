package com.tencent.mm.plugin.finder.video;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.upload.c;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.gallery.picker.b.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.o;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ \u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J8\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J,\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\u0002XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoCropTailor;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "TAG", "adjustRect", "Landroid/graphics/Rect;", "input", "clipRect", "contentRect", "viewRect", "calcOriginRect", "onInput", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "remux", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "result", "Lcom/tencent/mm/plugin/finder/video/FinderMediaTailorResult;", "thumbWidth", "thumbHeight", "mediaInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "resize", "Lkotlin/Pair;", "originWidth", "originHeight", "maxWidth", "plugin-finder_release"})
public final class l implements com.tencent.mm.plugin.gallery.picker.b.a<String, b.f> {
    final String TAG = "Finder.FinderVideoCropTailor";
    private final b.C1388b wez;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ z.c vRU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(z.c cVar) {
            super(1);
            this.vRU = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(168047);
            float floatValue = f2.floatValue();
            if (floatValue - this.vRU.SYD > 0.1f) {
                this.vRU.SYD = floatValue;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(168047);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Object tpZ;
        final /* synthetic */ z.a tqa;
        final /* synthetic */ z.d vRW;
        final /* synthetic */ long vRY;
        final /* synthetic */ VideoTransPara vSb;
        final /* synthetic */ l weZ;
        final /* synthetic */ z.d wfa;
        final /* synthetic */ z.d wfb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(l lVar, z.d dVar, long j2, z.d dVar2, z.d dVar3, VideoTransPara videoTransPara, Object obj, z.a aVar) {
            super(1);
            this.weZ = lVar;
            this.vRW = dVar;
            this.vRY = j2;
            this.wfa = dVar2;
            this.wfb = dVar3;
            this.vSb = videoTransPara;
            this.tpZ = obj;
            this.tqa = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            int a2;
            AppMethodBeat.i(168048);
            String str2 = str;
            z.d dVar = this.vRW;
            if (Util.isNullOrNil(str2)) {
                r.c cVar = r.c.vhb;
                r.c.nU(false);
                a2 = -1;
            } else {
                r.c cVar2 = r.c.vhb;
                r.c.u(Util.ticksToNow(this.vRY), false);
                Log.i(this.weZ.TAG, "remuxer succ, cost: " + Util.ticksToNow(this.vRY) + ", path:" + str2);
                c.a aVar = c.vRQ;
                a2 = c.a.a(str2, this.wfa.SYE, this.wfb.SYE, this.vSb, -2, false);
            }
            dVar.SYE = a2;
            synchronized (this.tpZ) {
                try {
                    this.tqa.SYB = true;
                    this.tpZ.notify();
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(168048);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(168048);
            return xVar2;
        }
    }

    public l(b.C1388b bVar) {
        p.h(bVar, "config");
        AppMethodBeat.i(168052);
        this.wez = bVar;
        AppMethodBeat.o(168052);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, android.graphics.Matrix, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect] */
    @Override // com.tencent.mm.plugin.gallery.picker.b.a
    public final /* synthetic */ b.f a(String str, int i2, Matrix matrix, Rect rect, Rect rect2, Rect rect3) {
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(254273);
        String str2 = str;
        p.h(str2, "input");
        p.h(matrix, "matrix");
        p.h(rect, "clipRect");
        p.h(rect2, "contentRect");
        p.h(rect3, "viewRect");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        VideoTransPara dqx = com.tencent.mm.plugin.finder.storage.c.dqx();
        Log.i(this.TAG, "FinderVideoCropTailor videoParams ".concat(String.valueOf(dqx)));
        Log.i(this.TAG, "matrix:" + matrix + ", clipRect:" + rect + ", contentRect:" + rect2 + ", viewRect:" + rect3);
        int i7 = dqx.iTf;
        Rect a2 = a(rect2, rect3, rect);
        int i8 = a2.right - a2.left;
        int i9 = a2.top - a2.bottom;
        int i10 = dqx.width;
        if (i8 % 16 != 0) {
            i3 = i8 - (i8 % 16);
            Log.i(this.TAG, "align height, before:" + i8 + ", after:" + i3);
        } else {
            i3 = i8;
        }
        if (i8 > i10) {
            i4 = (int) (((float) i9) * (((float) i10) / ((float) i8)));
        } else {
            i4 = i9;
            i10 = i3;
        }
        if (i4 % 16 != 0) {
            i4 -= i4 % 16;
            Log.i(this.TAG, "align height, before:" + i9 + ", after:" + i4);
        }
        o oVar = new o(Integer.valueOf(i10), Integer.valueOf(i4));
        int intValue = oVar.first.intValue();
        int intValue2 = oVar.second.intValue();
        Log.i(this.TAG, "resize rect, before:" + i8 + ", " + i9 + ", after:" + intValue + ", " + intValue2);
        p.h(str2, "input");
        p.h(rect, "clipRect");
        p.h(rect2, "contentRect");
        p.h(rect3, "viewRect");
        int mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(str2);
        Rect a3 = a(rect2, rect3, rect);
        int width = rect3.width();
        int height = rect3.height();
        if (mp4RotateVFS == 90) {
            a3 = new Rect(a3.bottom, width - a3.left, a3.top, width - a3.right);
        } else if (mp4RotateVFS == 180) {
            a3 = new Rect(width - a3.right, height - a3.bottom, width - a3.left, height - a3.top);
        } else if (mp4RotateVFS == 270) {
            a3 = new Rect(height - a3.top, a3.right, height - a3.bottom, a3.left);
        }
        Log.i(this.TAG, "adjustRect before:" + a2.toShortString() + ", after:" + a3.toShortString());
        e eVar = new e();
        eVar.ayV(str2);
        com.tencent.mm.plugin.sight.base.a aNx = e.aNx(str2);
        Log.i(this.TAG, "mediaInfo: ".concat(String.valueOf(aNx)));
        rect.width();
        rect.height();
        rect2.width();
        rect2.height();
        eVar.wcO = new cjx();
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        cjx cjx = eVar.wcO;
        if (cjx == null) {
            p.hyc();
        }
        cjx.Mpr = new bej();
        cjx cjx2 = eVar.wcO;
        if (cjx2 == null) {
            p.hyc();
        }
        bej bej = cjx2.Mpr;
        if (bej == null) {
            p.hyc();
        }
        bej.LOe.addAll(kotlin.a.e.s(fArr));
        cjx cjx3 = eVar.wcO;
        if (cjx3 == null) {
            p.hyc();
        }
        erf erf = new erf();
        erf.left = a3.left;
        erf.top = a3.top;
        erf.right = a3.right;
        erf.bottom = a3.bottom;
        cjx3.Mpq = erf;
        cjx cjx4 = eVar.wcO;
        if (cjx4 == null) {
            p.hyc();
        }
        cjx4.dvv = 0;
        cjx cjx5 = eVar.wcO;
        if (cjx5 == null) {
            p.hyc();
        }
        if (aNx != null) {
            i5 = aNx.videoDuration;
        } else {
            i5 = 0;
        }
        if (i5 > dqx.duration * 1000) {
            i6 = dqx.duration * 1000;
        } else {
            i6 = 0;
        }
        cjx5.iqg = i6;
        cjx cjx6 = eVar.wcO;
        if (cjx6 == null) {
            p.hyc();
        }
        cjx6.width = intValue;
        cjx cjx7 = eVar.wcO;
        if (cjx7 == null) {
            p.hyc();
        }
        cjx7.height = intValue2;
        r.c cVar2 = r.c.vhb;
        r.c.Fm(Math.min((long) (aNx != null ? aNx.videoDuration : 0), (long) (dqx.duration * 1000)));
        Rect a4 = a(rect2, rect3, rect);
        int i11 = (int) ((((float) (a4.top - a4.bottom)) / ((float) (a4.right - a4.left))) * ((float) i7));
        f fVar = f.vSz;
        eVar.HA(f.a(str2, i7, i11, a4));
        cjx cjx8 = eVar.wcO;
        if (cjx8 == null) {
            p.hyc();
        }
        erf erf2 = new erf();
        erf2.left = a4.left;
        erf2.top = a4.top;
        erf2.right = a4.right;
        erf2.bottom = a4.bottom;
        cjx8.Mps = erf2;
        j.a aVar = j.vDD;
        boolean KY = j.a.KY(Math.max(aNx.width, aNx.height));
        Log.i(this.TAG, "notFakeVideo " + KY + ", width:" + aNx.width + ", height:" + aNx.height);
        if (KY) {
            cjl cjl = new cjl();
            cjl.url = str2;
            cjl.thumbUrl = eVar.thumbPath;
            cjl.uOR = eVar.wcO;
            cjl.mediaId = MD5Util.getMD5String(str2);
            p.g(aNx, "mediaInfo");
            if (a(cjl, eVar, i7, i11, aNx)) {
                eVar.wcO = null;
            }
        }
        e eVar2 = eVar;
        AppMethodBeat.o(254273);
        return eVar2;
    }

    private final boolean a(cjl cjl, e eVar, int i2, int i3, com.tencent.mm.plugin.sight.base.a aVar) {
        AppMethodBeat.i(168050);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        VideoTransPara dqx = com.tencent.mm.plugin.finder.storage.c.dqx();
        Object obj = new Object();
        z.a aVar2 = new z.a();
        aVar2.SYB = false;
        z.d dVar = new z.d();
        dVar.SYE = -1;
        s sVar = new s(cjl, com.tencent.mm.plugin.finder.storage.x.V99_VIDEO, com.tencent.mm.modelcontrol.e.sX(4) ? 2 : 1, null, 8);
        al alVar = al.waC;
        String valueOf = String.valueOf(cl.aWy());
        p.h(sVar, "video");
        p.h(valueOf, "suffix");
        String str = al.dEG() + sVar.auA() + "_" + valueOf;
        z.c cVar2 = new z.c();
        cVar2.SYD = 0.0f;
        int mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(cjl.url);
        z.d dVar2 = new z.d();
        cjx cjx = cjl.uOR;
        dVar2.SYE = cjx != null ? cjx.width : 0;
        z.d dVar3 = new z.d();
        cjx cjx2 = cjl.uOR;
        dVar3.SYE = cjx2 != null ? cjx2.height : 0;
        int i4 = aVar.width;
        int i5 = aVar.height;
        if (mp4RotateVFS == 90 || mp4RotateVFS == 270) {
            cjx cjx3 = cjl.uOR;
            dVar2.SYE = cjx3 != null ? cjx3.height : 0;
            cjx cjx4 = cjl.uOR;
            dVar3.SYE = cjx4 != null ? cjx4.width : 0;
        }
        int i6 = dqx.videoBitrate;
        r.c cVar3 = r.c.vhb;
        r.c.nT(false);
        Log.i(this.TAG, "video rotate:" + mp4RotateVFS + ", width:" + dVar2.SYE + ", height:" + dVar3.SYE + " url " + cjl.url + " thumbUrl: " + cjl.thumbUrl + " size:" + Util.getSizeKB(com.tencent.mm.vfs.s.boW(cjl.url)));
        c.a aVar3 = c.vRQ;
        String str2 = cjl.url;
        if (str2 == null) {
            str2 = "";
        }
        int i7 = dVar2.SYE;
        int i8 = dVar3.SYE;
        cjx cjx5 = cjl.uOR;
        if (cjx5 == null) {
            p.hyc();
        }
        int i9 = cjx5.iqg;
        cjx cjx6 = cjl.uOR;
        if (cjx6 == null) {
            p.hyc();
        }
        float f2 = ((float) (i9 - cjx6.dvv)) / 1000.0f;
        cjx cjx7 = cjl.uOR;
        if (cjx7 == null) {
            p.hyc();
        }
        c.a.C1306a a2 = c.a.a(str2, i7, i8, f2, ((float) cjx7.dvv) / 1000.0f, dqx, false);
        if (a2.errCode == 0 && a2.width > 0 && a2.height > 0 && a2.bitrate > 0) {
            dVar2.SYE = a2.width;
            dVar3.SYE = a2.height;
            i6 = a2.bitrate;
            Log.i(this.TAG, "video abaResult, width:" + dVar2.SYE + ", height:" + dVar3.SYE + ", " + i6);
        }
        long currentTicks = Util.currentTicks();
        try {
            String str3 = cjl.url;
            if (str3 == null) {
                str3 = "";
            }
            c.a aVar4 = c.vRQ;
            cjx cjx8 = cjl.uOR;
            erf erf = cjx8 != null ? cjx8.Mpq : null;
            if (erf == null) {
                p.hyc();
            }
            p.g(erf, "it.cropInfo?.rect!!");
            Rect a3 = c.a.a(erf);
            int i10 = dVar2.SYE;
            int i11 = dVar3.SYE;
            int i12 = dqx.audioBitrate;
            int i13 = dqx.audioSampleRate;
            int i14 = dqx.audioChannelCount;
            int i15 = dqx.fps;
            cjx cjx9 = cjl.uOR;
            if (cjx9 == null) {
                p.hyc();
            }
            long j2 = (long) cjx9.dvv;
            cjx cjx10 = cjl.uOR;
            if (cjx10 == null) {
                p.hyc();
            }
            new n(null, str3, 1, str, a3, i10, i11, i6, i12, i13, i14, i15, j2, (long) cjx10.iqg, false, false, dqx.iiH, new a(cVar2), new b(this, dVar, currentTicks, dVar2, dVar3, dqx, obj, aVar2), i4, i5).aMG();
            synchronized (obj) {
                try {
                    if (!aVar2.SYB) {
                        Log.i(this.TAG, "wait");
                        obj.wait();
                        Log.i(this.TAG, "notify, " + dVar.SYE);
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(168050);
                    throw th;
                }
            }
            if (dVar.SYE < 0) {
                eVar.ret = dVar.SYE;
                r.e eVar2 = r.e.vhB;
                r.e.Fn(Util.ticksToNow(currentTicks));
                r.e eVar3 = r.e.vhB;
                r.e.a(aVar, null, (int) com.tencent.mm.vfs.s.boW(cjl.url), 0, Util.ticksToNow(currentTicks), eVar.ret);
                AppMethodBeat.o(168050);
                return false;
            }
            if (a2.errCode == 0 && a2.vRR != null && a2.width > 0 && a2.height > 0 && a2.bitrate > 0) {
                try {
                    SightVideoJNI.addReportMetadata(str, a2.vRR, dqx.iTg, 0);
                } catch (Throwable th2) {
                }
            }
            eVar.ayV(str);
            f fVar = f.vSz;
            eVar.HA(f.a(str, i2, i3, null));
            r.e eVar4 = r.e.vhB;
            r.e.Fn(Util.ticksToNow(currentTicks));
            com.tencent.mm.plugin.sight.base.a aNx = e.aNx(str);
            r.e eVar5 = r.e.vhB;
            r.e.a(aVar, aNx, (int) com.tencent.mm.vfs.s.boW(cjl.url), (int) com.tencent.mm.vfs.s.boW(str), Util.ticksToNow(currentTicks), eVar.ret);
            AppMethodBeat.o(168050);
            return true;
        } catch (Throwable th3) {
            eVar.ret = -10;
            Log.printErrStackTrace(this.TAG, th3, "create remuxer failed", new Object[0]);
            r.c cVar4 = r.c.vhb;
            r.c.nU(false);
            r.e eVar6 = r.e.vhB;
            r.e.Fn(Util.ticksToNow(currentTicks));
            r.e eVar7 = r.e.vhB;
            r.e.a(aVar, null, (int) com.tencent.mm.vfs.s.boW(cjl.url), 0, Util.ticksToNow(currentTicks), eVar.ret);
            AppMethodBeat.o(168050);
            return false;
        }
    }

    private static Rect a(Rect rect, Rect rect2, Rect rect3) {
        AppMethodBeat.i(168051);
        float width = (1.0f * ((float) rect.width())) / ((float) rect2.width());
        int i2 = rect3.left - rect.left;
        int i3 = rect3.top - rect.top;
        Rect rect4 = new Rect((int) (((float) i2) / width), (int) (((float) (rect3.height() + i3)) / width), (int) (((float) (rect3.width() + i2)) / width), (int) (((float) i3) / width));
        AppMethodBeat.o(168051);
        return rect4;
    }
}
