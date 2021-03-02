package com.tencent.mm.plugin.vlog.model;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kk;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.b.d;
import com.tencent.mm.videocomposition.b.g;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.EffectProfileData;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\"\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0016\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J)\u0010,\u001a\u00020\u00102!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bJ\n\u0010-\u001a\u00020$*\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "", "()V", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "calculateAba", "progressCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "retryCount", "", "getRetryCount", "()I", "setRetryCount", "(I)V", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "align4", "value", "checkFallbackSize", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "checkTargetSize", AssetExtension.SCENE_EXPORT, "callback", "performanceReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "key", "", "reportStartExport", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputPath", "softEncode", "setCalculateAdaptiveBitrate", "enable", "setProgressCallback", "getReportKey", "Companion", "plugin-vlog_release"})
public final class f {
    public static final a Gxm = new a((byte) 0);
    public boolean Gxj = true;
    private boolean Gxk;
    private kotlin.g.a.b<? super Float, x> Gxl;
    public int retryCount = 1;
    private VideoTransPara zua;

    static {
        AppMethodBeat.i(190498);
        AppMethodBeat.o(190498);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "invoke"})
    public static final class b extends q implements m<Boolean, Integer, x> {
        final /* synthetic */ f Gxn;
        final /* synthetic */ EffectManager Gxo;
        final /* synthetic */ ac Gxp;
        final /* synthetic */ boolean Gxq;
        final /* synthetic */ boolean Gxr;
        final /* synthetic */ z.a Gxs;
        final /* synthetic */ String Gxt;
        final /* synthetic */ z.c Gxu;
        final /* synthetic */ z.f Gxv;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ String lCM;
        final /* synthetic */ long qVz;
        final /* synthetic */ aco vSa;
        final /* synthetic */ long vSg;
        final /* synthetic */ acn vTK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar, acn acn, long j2, long j3, EffectManager effectManager, ac acVar, boolean z, boolean z2, z.a aVar, String str, z.c cVar, z.f fVar2, String str2, aco aco, kotlin.g.a.b bVar) {
            super(2);
            this.Gxn = fVar;
            this.vTK = acn;
            this.qVz = j2;
            this.vSg = j3;
            this.Gxo = effectManager;
            this.Gxp = acVar;
            this.Gxq = z;
            this.Gxr = z2;
            this.Gxs = aVar;
            this.Gxt = str;
            this.Gxu = cVar;
            this.Gxv = fVar2;
            this.lCM = str2;
            this.vSa = aco;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, Integer num) {
            int i2;
            AppMethodBeat.i(190491);
            boolean booleanValue = bool.booleanValue();
            int intValue = num.intValue();
            Log.i("MicroMsg.VLogCompositionBlendExporter", "export finished, success:" + booleanValue + ", errCode:" + intValue);
            if (intValue < 0) {
                i2 = -intValue;
            } else {
                i2 = intValue;
            }
            kk aTS = f.aTS(f.b(this.vTK));
            aTS.xI(this.vTK.editId);
            aTS.tp((long) this.vTK.Gxw.fps);
            aTS.tr((long) i2);
            aTS.tu(Util.ticksToNow(this.qVz));
            aTS.ts(1);
            aTS.tv(this.vSg);
            aTS.tB((long) this.vTK.Gxw.Lnq);
            com.tencent.mm.plugin.vlog.report.b bVar = com.tencent.mm.plugin.vlog.report.b.GDm;
            String b2 = f.b(this.vTK);
            String str = this.vTK.Gxw.rpE;
            p.h(b2, "key");
            com.tencent.mm.plugin.vlog.report.b.a(com.tencent.mm.plugin.vlog.report.b.aUh(b2), str);
            EffectProfileData hiw = this.Gxo.hiw();
            aTS.tm((long) EffectProfileData.g(hiw.nGetCreatePAGFile()).JRy);
            aTS.tn((long) EffectProfileData.g(hiw.nGetCreatePAGFile()).successCount);
            EffectProfileData hiw2 = this.Gxo.hiw();
            aTS.to(EffectProfileData.g(hiw2.nGetRenderPAG(hiw2.ptr)).RxT);
            JSONArray jSONArray = new JSONArray();
            LinkedList<acp> linkedList = this.vTK.Lnj;
            p.g(linkedList, "compositionInfo.trackLabelInfoList");
            for (T t : linkedList) {
                jSONArray.put(new JSONObject().put(String.valueOf(t.label), t.Lns));
            }
            String jSONArray2 = jSONArray.toString();
            p.g(jSONArray2, "labelArray.toString()");
            aTS.xJ(n.j(jSONArray2, ",", ";", false));
            g gVar = this.Gxp.getComposition().Rhs;
            d dVar = gVar != null ? gVar.Rie : null;
            if (dVar != null) {
                aTS.to(dVar.RhY.invoke().longValue());
                aTS.tw(dVar.tTn);
                aTS.tx(dVar.dtZ);
                if (this.Gxq) {
                    aTS.lQ(1);
                } else if (this.Gxr) {
                    aTS.lQ(2);
                }
                aTS.tA(this.Gxs.SYB ? 1 : 0);
            }
            VideoTransPara videoTransPara = this.Gxn.zua;
            if (videoTransPara != null) {
                aTS.ty((long) (AdaptiveAdjustBitrate.a(this.Gxt, ((float) videoTransPara.audioBitrate) / 1000.0f, (float) videoTransPara.audioSampleRate, videoTransPara.audioChannelCount, ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_audio_quality_analysis_switch, 0) == 1, this.vTK.Gzo) * 100.0f));
                aTS.tz((long) (this.Gxu.SYD * 100.0f));
            }
            com.tencent.mm.plugin.vlog.report.b bVar2 = com.tencent.mm.plugin.vlog.report.b.GDm;
            com.tencent.mm.plugin.vlog.report.b.aUi(f.b(this.vTK));
            T t2 = this.Gxv.SYG;
            if (t2 != null) {
                t2.destroy();
            }
            this.Gxo.destroy();
            if (booleanValue) {
                com.tencent.mm.plugin.vlog.model.report.a aVar = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                String str2 = this.lCM;
                p.g(str2, "path");
                com.tencent.mm.plugin.vlog.model.report.a.a(str2, Util.ticksToNow(this.qVz), this.Gxp.Gzo, this.Gxp.BNS, this.Gxq, this.Gxr);
                if (!this.vSa.Lno.isEmpty()) {
                    try {
                        String str3 = this.lCM;
                        LinkedList<Integer> linkedList2 = this.vSa.Lno;
                        p.g(linkedList2, "outputConfig.abaParams");
                        SightVideoJNI.addReportMetadata(str3, j.u((Collection<Integer>) linkedList2), this.vSa.iTg, 0);
                    } catch (Throwable th) {
                    }
                }
            }
            if (intValue == -103 || intValue == -121) {
                f.c(this.vTK);
            }
            this.gWe.invoke(Boolean.valueOf(booleanValue));
            com.tencent.mm.plugin.vlog.model.report.a aVar2 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
            com.tencent.mm.plugin.vlog.model.report.a.c(this.Gxn.Gxj, booleanValue, this.Gxn.retryCount, this.Gxs.SYB);
            if (intValue != 0) {
                com.tencent.mm.plugin.vlog.model.report.a aVar3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
                com.tencent.mm.plugin.vlog.model.report.a.acB(intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190491);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void r(VideoTransPara videoTransPara) {
        AppMethodBeat.i(190492);
        p.h(videoTransPara, "videoTransPara");
        this.Gxk = true;
        this.zua = videoTransPara;
        AppMethodBeat.o(190492);
    }

    public final void N(kotlin.g.a.b<? super Float, x> bVar) {
        AppMethodBeat.i(190493);
        p.h(bVar, "callback");
        this.Gxl = bVar;
        AppMethodBeat.o(190493);
    }

    public final float a(acn acn, kotlin.g.a.b<? super Boolean, x> bVar) {
        dlh dlh;
        AppMethodBeat.i(190494);
        p.h(acn, "compositionInfo");
        p.h(bVar, "callback");
        Log.i("MicroMsg.VLogCompositionBlendExporter", "start export, retryCount:" + this.retryCount);
        aco aco = acn.Gxw;
        EffectManager effectManager = new EffectManager();
        ac d2 = i.d(acn, effectManager);
        boolean z = !Util.isNullOrNil(acn.iiv);
        z.a aVar = new z.a();
        aVar.SYB = false;
        if (this.retryCount >= 2) {
            boolean fBw = w.fBw();
            Log.i("MicroMsg.VLogCompositionBlendExporter", "retryCount:" + this.retryCount + ", enable try use softEncode: " + fBw);
            aVar.SYB = fBw;
        }
        aVar.SYB = aVar.SYB || w.fBu();
        String str = aco.rpE;
        p.g(str, "outputConfig.outputPath");
        a(d2, str, aVar.SYB);
        z.c cVar = new z.c();
        cVar.SYD = 0.0f;
        if (this.Gxk && this.zua != null) {
            g.a aVar2 = g.GxB;
            VideoTransPara videoTransPara = this.zua;
            if (videoTransPara == null) {
                p.hyc();
            }
            int i2 = aco.targetWidth;
            int i3 = aco.targetHeight;
            LinkedList<jn> linkedList = acn.Gxx.Lna;
            p.g(linkedList, "compositionInfo.editData.baseItemData");
            a a2 = g.a.a(d2, videoTransPara, i2, i3, !linkedList.isEmpty());
            g.a aVar3 = g.GxB;
            p.g(aco, "outputConfig");
            g.a.a(a2, aco);
            if (a2.vRR != null && a2.vRR.length >= 28) {
                cVar.SYD = (float) a2.vRR[27];
                Log.i("MicroMsg.VLogCompositionBlendExporter", "export videoQuality: " + cVar.SYD);
            }
        }
        a(acn);
        Log.i("MicroMsg.VLogCompositionBlendExporter", "export: size " + aco.targetWidth + ' ' + aco.targetHeight);
        z.f fVar = new z.f();
        fVar.SYG = null;
        acm acm = acn.Gxx;
        if ((acm != null ? acm.LmZ : null) != null) {
            acm acm2 = acn.Gxx;
            if (acm2 != null) {
                dlh = acm2.Lnc;
            } else {
                dlh = null;
            }
            if (dlh != null) {
                fVar.SYG = (T) i.d(acn);
                d2.O(fVar.SYG);
                fVar.SYG.start();
            }
        }
        if (z) {
            Log.i("MicroMsg.VLogCompositionBlendExporter", "export: has music, audio info " + aco.audioBitrate + ", " + aco.audioSampleRate + ", " + aco.audioChannelCount);
            if (aco.audioBitrate == 0) {
                aco.audioBitrate = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
            }
            if (aco.audioSampleRate == 0) {
                aco.audioSampleRate = 44100;
            }
            if (aco.audioChannelCount == 0) {
                aco.audioChannelCount = 1;
            }
        }
        if (w.fBu()) {
            aco.targetWidth = acw(aco.targetWidth);
            aco.targetHeight = acw(aco.targetHeight);
        }
        n.b bVar2 = new n.b(new Size(aco.targetWidth, aco.targetHeight), aco.videoBitrate, aco.fps, aco.iiH, aco.audioBitrate, aco.audioSampleRate, aco.audioChannelCount, ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_tavkit_encode_high_profile_enable, 1) == 1, false, aco.Lnr);
        String str2 = aco.rpE;
        String boZ = s.boZ(str2);
        if (!s.YS(boZ)) {
            s.boN(boZ);
        }
        if (!s.bpa(str2)) {
            bVar.invoke(Boolean.FALSE);
            AppMethodBeat.o(190494);
            return 0.0f;
        }
        String k = s.k(str2, true);
        if (k == null) {
            p.hyc();
        }
        p.g(k, "VFSFileOp.exportExternalPath(path, true)!!");
        long currentTicks = Util.currentTicks();
        d2.ju(bVar2.audioSampleRate, bVar2.audioChannelCount);
        if (d2.Gzp) {
            Log.i("MicroMsg.VLogCompositionBlendExporter", "enable video enhancement");
            com.tencent.mm.plugin.vlog.model.local.a aVar4 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            com.tencent.mm.plugin.vlog.model.local.a.fBY();
        }
        com.tencent.mm.videocomposition.n composition = d2.getComposition();
        long ticksToNow = Util.ticksToNow(currentTicks);
        boolean fBu = w.fBu();
        boolean fBv = w.fBv();
        Log.i("MicroMsg.VLogCompositionBlendExporter", "enableHevcSoft:" + fBu + ", enableHevcHard:" + fBv);
        b bVar3 = new b(this, acn, currentTicks, ticksToNow, effectManager, d2, fBu, fBv, aVar, k, cVar, fVar, str2, aco, bVar);
        if (w.fBu() || aVar.SYB) {
            composition.b(k, bVar2, new h(), bVar3, this.Gxl);
        } else {
            composition.a(k, bVar2, bVar3, this.Gxl);
        }
        float f2 = cVar.SYD;
        AppMethodBeat.o(190494);
        return f2;
    }

    private static int acw(int i2) {
        if (i2 % 4 != 0) {
            while (i2 % 4 != 0) {
                i2++;
            }
        }
        return i2;
    }

    private static void a(acn acn) {
        AppMethodBeat.i(190495);
        k kVar = k.GxP;
        int fAT = k.fAT();
        Log.i("MicroMsg.VLogCompositionBlendExporter", "checkTargetSize: origin " + acn.Gxw.targetWidth + ", " + acn.Gxw.targetHeight + ", type " + fAT);
        acn.Gxw.Lnq = fAT;
        switch (fAT) {
            case 0:
                int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_remux_max_height, 1920);
                if (acn.Gxw.targetHeight > a2) {
                    acn.Gxw.targetWidth = com.tencent.mm.plugin.mmsight.d.QH((int) (((((float) a2) * 1.0f) / ((float) acn.Gxw.targetHeight)) * ((float) acn.Gxw.targetWidth)));
                    acn.Gxw.targetHeight = a2;
                    AppMethodBeat.o(190495);
                    return;
                }
                break;
            case 1:
                int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_remux_retry_max_width, TAVExporter.VIDEO_EXPORT_WIDTH);
                Log.i("MicroMsg.VLogCompositionBlendExporter", "checkTargetSize: config ".concat(String.valueOf(a3)));
                if (acn.Gxw.targetWidth > a3) {
                    int QH = com.tencent.mm.plugin.mmsight.d.QH((int) (((((float) a3) * 1.0f) / ((float) acn.Gxw.targetWidth)) * ((float) acn.Gxw.targetHeight)));
                    acn.Gxw.targetWidth = a3;
                    acn.Gxw.targetHeight = QH;
                    break;
                }
                break;
        }
        AppMethodBeat.o(190495);
    }

    public static String b(acn acn) {
        AppMethodBeat.i(190497);
        p.h(acn, "$this$getReportKey");
        String str = acn.editId;
        if (str == null) {
            str = acn.Gxw.rpE;
            p.g(str, "outputConfig.outputPath");
        }
        AppMethodBeat.o(190497);
        return str;
    }

    private static void a(ac acVar, String str, boolean z) {
        AppMethodBeat.i(190496);
        ArrayList<ad> arrayList = acVar.Gzn;
        ArrayList arrayList2 = new ArrayList();
        for (T t : arrayList) {
            if (t.type == 2) {
                arrayList2.add(t);
            }
        }
        ArrayList<ad> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (ad adVar : arrayList3) {
            arrayList4.add(adVar.path);
        }
        ArrayList arrayList5 = arrayList4;
        com.tencent.mm.plugin.vlog.model.report.a aVar = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.bd(arrayList.size(), arrayList5.size() < arrayList.size());
        com.tencent.mm.plugin.vlog.model.report.a aVar2 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.c(arrayList5, str, z);
        AppMethodBeat.o(190496);
    }

    public static final /* synthetic */ kk aTS(String str) {
        AppMethodBeat.i(190499);
        com.tencent.mm.plugin.vlog.report.b bVar = com.tencent.mm.plugin.vlog.report.b.GDm;
        kk aUh = com.tencent.mm.plugin.vlog.report.b.aUh(str);
        AppMethodBeat.o(190499);
        return aUh;
    }

    public static final /* synthetic */ void c(acn acn) {
        AppMethodBeat.i(190500);
        k kVar = k.GxP;
        switch (k.fAT()) {
            case 0:
                k kVar2 = k.GxP;
                k.getKV().putInt(k.GxO, 1).commit();
                AppMethodBeat.o(190500);
                return;
            default:
                Log.w("MicroMsg.VLogCompositionBlendExporter", "checkFallbackSize : fallback size failed " + acn.Gxw.targetWidth + ", " + acn.Gxw.targetHeight);
                AppMethodBeat.o(190500);
                return;
        }
    }
}
