package com.tencent.tmediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b;
import com.tencent.tmediacodec.b.c;
import com.tencent.tmediacodec.b.e;
import com.tencent.tmediacodec.b.f;
import com.tencent.tmediacodec.b.g;
import com.tencent.tmediacodec.e.a;
import com.tencent.tmediacodec.e.b;
import com.tencent.tmediacodec.g.d;
import java.util.HashMap;

public final class a {
    private static a Sla = new a();
    private static boolean Sle = false;
    public b Slb = b.SmK;
    public boolean Slc = true;
    private boolean Sld;
    private final HashMap<b, c> Slf = new HashMap<>();
    private final com.tencent.tmediacodec.d.a Slg = new com.tencent.tmediacodec.d.a();
    private final com.tencent.tmediacodec.c.a Slh = new com.tencent.tmediacodec.c.a();
    private final com.tencent.tmediacodec.c.a Sli = new com.tencent.tmediacodec.c.a();

    public a() {
        AppMethodBeat.i(190074);
        AppMethodBeat.o(190074);
    }

    static {
        AppMethodBeat.i(190079);
        AppMethodBeat.o(190079);
    }

    public static a hpn() {
        return Sla;
    }

    public final void a(b bVar) {
        this.Slb = bVar;
    }

    public final void hpo() {
        AppMethodBeat.i(190075);
        if (!this.Slc) {
            this.Slc = true;
            if (this.Sld && !this.Slc) {
                this.Slh.hpB();
                this.Sli.hpB();
            }
        }
        AppMethodBeat.o(190075);
    }

    public final c a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, b bVar) {
        c c2;
        c a2;
        c cVar;
        AppMethodBeat.i(190076);
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder("configureStart videoPoolInfo:").append(this.Slh.hpC()).append(", audioPoolInfo:").append(this.Sli.hpC());
            com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
        }
        this.Sld = true;
        boolean z = this.Slc;
        boolean z2 = bVar.Slo;
        boolean by = d.by(bVar.Slq);
        boolean z3 = z && z2;
        boolean z4 = Build.VERSION.SDK_INT >= 23 && !d.hpH();
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder("getCodec isVideo:").append(by).append(" reuseEnable:").append(z3).append(' ').append("globalReuseEnable:").append(z).append(" mediaCodecReuseEnable:").append(z2).append(" canUseSetOutputSurfaceAPI:").append(z4).append(" ,surface:").append(surface);
            com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
        }
        boolean z5 = z3 && by && z4 && surface != null;
        bVar.Slj = z5;
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder("getCodec isVideo:").append(by).append(" codecFinalReuseEnable:").append(z5);
            com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
        }
        if (!z5) {
            bVar.Slk = false;
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                new StringBuilder("getCodec return DirectCodecWrapper for mediaFormat:").append(mediaFormat).append(" globalReuseEnable:").append(z).append(' ').append("mediaCodecReuseEnable:").append(z2).append(" surface:").append(surface);
                com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
            }
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                new StringBuilder("createDirectCodecWrapper mediaFormat:").append(mediaFormat).append(" createBy:").append(bVar.Slr).append(" nameOrType:").append(bVar.Slq);
                com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
            }
            if (bVar.Slr == b.EnumC2217b.CreateByName) {
                cVar = new com.tencent.tmediacodec.b.d(MediaCodec.createByCodecName(bVar.Slq));
            } else {
                cVar = new com.tencent.tmediacodec.b.d(MediaCodec.createDecoderByType(bVar.Slq));
            }
        } else {
            e i2 = e.i(mediaFormat);
            if (by) {
                c2 = this.Slh.c(i2);
            } else {
                c2 = this.Sli.c(i2);
            }
            e.bA(i2.Slz);
            if (c2 != null) {
                a.b b2 = c2.b(i2);
                if (b2 == a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION || b2 == a.b.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION) {
                    if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                        new StringBuilder("getCodec reuse, isVideo:").append(by).append(" reuseType:").append(b2);
                        com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
                    }
                    c2.hpt();
                    c2.hpu();
                    bVar.Slk = true;
                    cVar = c2;
                } else if (b2 == a.b.KEEP_CODEC_RESULT_NO && com.tencent.tmediacodec.g.b.isLogEnable()) {
                    new StringBuilder("getCodec not reuse, isVideo:").append(by).append(" reuseType:").append(b2);
                    com.tencent.tmediacodec.g.b.bqS("TCodecManager");
                }
            }
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                "getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:".concat(String.valueOf(by));
                com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
            }
            bVar.Slk = false;
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                new StringBuilder("createNewReuseCodecWrapper mediaFormat:").append(mediaFormat).append(" createBy:").append(bVar.Slr).append(" nameOrType:").append(bVar.Slq);
                com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
            }
            String string = mediaFormat.getString("mime");
            e i3 = e.i(mediaFormat);
            com.tencent.tmediacodec.e.b bVar2 = Sla.Slb;
            int max = Math.max(bVar2.SmH, i3.width);
            int max2 = Math.max(bVar2.SmI, i3.height);
            if (bVar2.SmG) {
                bVar2.SmH = max;
                bVar2.SmI = max2;
            }
            int max3 = Math.max(0, d.d(i3.bdq, max, max2, false));
            if (com.tencent.tmediacodec.g.b.isLogEnable()) {
                new StringBuilder("initFormatWrapper initWidth:").append(max).append(" initHeight:").append(max2).append(" initMaxInputSize:").append(max3).append(' ').append("reusePolicy:").append(bVar2);
                com.tencent.tmediacodec.g.b.bqQ("ReuseHelper");
            }
            i3.maxWidth = max;
            i3.maxHeight = max2;
            i3.bdr = max3;
            mediaFormat.setInteger("max-input-size", Math.max(max3, 0));
            if (i3.cWJ() && Build.VERSION.SDK_INT >= 19) {
                mediaFormat.setInteger("max-width", max);
                mediaFormat.setInteger("max-height", max2);
            }
            if (bVar.Slr == b.EnumC2217b.CreateByName) {
                a2 = f.a(MediaCodec.createByCodecName(bVar.Slq), string, i3);
            } else {
                a2 = f.a(MediaCodec.createDecoderByType(string), string, i3);
            }
            a2.hpt();
            this.Slf.put(bVar, a2);
            cVar = a2;
        }
        if (this.Slc) {
            if (cVar instanceof g) {
                this.Slh.f((f) cVar);
            } else if (cVar instanceof com.tencent.tmediacodec.b.a) {
                this.Sli.f((f) cVar);
            }
        }
        cVar.a(bVar.Slm);
        cVar.configure(mediaFormat, surface, mediaCrypto, 0);
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            new StringBuilder("configureEnd   videoPoolInfo:").append(this.Slh.hpC()).append(", audioPoolInfo:").append(this.Sli.hpC());
            com.tencent.tmediacodec.g.b.bqQ("TCodecManager");
        }
        AppMethodBeat.o(190076);
        return cVar;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(190077);
        if (this.Slc) {
            if (cVar instanceof g) {
                this.Slh.g((f) cVar);
                AppMethodBeat.o(190077);
                return;
            } else if (cVar instanceof com.tencent.tmediacodec.b.a) {
                this.Sli.g((f) cVar);
            }
        }
        AppMethodBeat.o(190077);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(190078);
        if (this.Slc) {
            if (cVar instanceof g) {
                this.Slh.h((f) cVar);
                AppMethodBeat.o(190078);
                return;
            } else if (cVar instanceof com.tencent.tmediacodec.b.a) {
                this.Sli.h((f) cVar);
            }
        }
        AppMethodBeat.o(190078);
    }
}
