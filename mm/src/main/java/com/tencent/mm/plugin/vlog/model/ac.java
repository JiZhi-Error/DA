package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.b.e;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.extractor.AssetExtractor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u0000 Y2\u00020\u0001:\u0001YB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\u0012J\u0010\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010'J\b\u0010(\u001a\u00020)H\u0007J\u000e\u0010\u0014\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0012J\u0006\u0010,\u001a\u00020\fJ\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170.J\u0006\u0010/\u001a\u00020\u0017J\u0006\u00100\u001a\u00020\u001aJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020\u0017J$\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\t2\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020#08J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010<\u001a\u00020\u0012J\u0006\u0010=\u001a\u00020\u0012J\u0006\u0010>\u001a\u00020\u0012J\u0006\u0010?\u001a\u00020\u001aJ\u0006\u0010@\u001a\u00020\u001aJ\b\u0010A\u001a\u00020\tH\u0002J\u0016\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\tJ\u001c\u0010E\u001a\u00020#2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010908J\u0010\u0010G\u001a\u00020#2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020\u001a2\b\b\u0002\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020\tJ\u000e\u0010N\u001a\u00020#2\u0006\u0010O\u001a\u00020\u0017J\u0016\u0010P\u001a\u00020#2\u0006\u0010Q\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\u0017J\u000e\u0010S\u001a\u00020#2\u0006\u0010T\u001a\u00020\u000eJ\u0016\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\tJ\u0006\u0010X\u001a\u00020#R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060 j\b\u0012\u0004\u0012\u00020\u0006`!X\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "", FirebaseAnalytics.b.ORIGIN, "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Ljava/util/List;)V", "audioChannelCount", "", "audioSampleRate", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "cropRect", "Landroid/graphics/Rect;", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "enableMusic", "", "enableOriginAudio", "enableVideoEnhancement", "fpsUpperLimit", "maxDuration", "", "maxFps", "musicPath", "", "playEnd", "getPlayEnd", "()J", "playStart", "getPlayStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addMusic", "", "fillUp", "addRenderProcessCallback", "callback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "enable", "enableVideoSound", "getComposition", "getCutPlayRange", "Lkotlin/Pair;", "getDurationMs", "getMusicPath", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getSize", "Landroid/util/Size;", "getSourceDuration", "getThumbBitmap", "widthLimit", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getThumbTrackList", "getTrackList", "isEnableMusic", "isEnableOriginSound", "isEnableVideoEnhancement", "kvPlayRateInfo", "kvTransitionInfo", "selectMaxFpsFromTrackList", "setAudioConfig", "sampleRate", "channelCount", "setBlendBitmapProvider", "blendBitmapProvider", "setEffectMgr", "setFilter", "path", "weight", "", "setFpsUpperLimit", "limit", "setMaxDuration", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "setPlayRange", "start", "end", "setRenderCrop", "rect", "setRenderSize", "width", "height", "updateComposition", "Companion", "plugin-vlog_release"})
public final class ac {
    public static final a Gzs = new a((byte) 0);
    boolean BNS;
    public n Gez;
    private long Gfd;
    public ArrayList<ad> Gzn;
    boolean Gzo;
    public volatile boolean Gzp;
    private int Gzq;
    private int Gzr;
    private int audioChannelCount;
    private int audioSampleRate;
    String iiv;
    private final Rect iiw;
    private EffectManager wbk;

    public ac(List<ad> list) {
        p.h(list, "trackList");
        AppMethodBeat.i(190700);
        this.Gez = new n();
        this.Gzn = new ArrayList<>();
        this.iiw = new Rect();
        this.Gzo = true;
        this.iiv = "";
        this.Gzq = 30;
        this.Gzr = -1;
        this.audioSampleRate = 44100;
        this.audioChannelCount = 1;
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_edit_use_system_extractor_api_level, 28);
        if (a2 <= 0 || !d.oD(a2)) {
            AssetExtractor.DOWNGRADING = false;
        } else {
            Log.i("MicroMsg.VLogComposition", "extractor config: ".concat(String.valueOf(a2)));
            AssetExtractor.DOWNGRADING = true;
        }
        this.Gzn.clear();
        this.Gzn.addAll(list);
        n nVar = this.Gez;
        ArrayList<ad> arrayList = this.Gzn;
        ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().GzA);
        }
        ArrayList arrayList3 = arrayList2;
        p.h(arrayList3, "trackList");
        nVar.Gzn.clear();
        nVar.Gzn.addAll(arrayList3);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multivideo_edit_preview_high_fps_enable, 1) == 1) {
            this.Gzr = fBC();
        }
        this.Gez.wB(this.Gzo);
        AppMethodBeat.o(190700);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogComposition$Companion;", "", "()V", "EXTRA_TRACK", "", "IMAGE_SIZE_LIMIT", "", "TAG", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<String, x> {
        public static final b Gzt = new b();

        static {
            AppMethodBeat.i(190677);
            AppMethodBeat.o(190677);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(190676);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            com.tencent.mm.compatible.util.j.load(str2);
            x xVar = x.SXb;
            AppMethodBeat.o(190676);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(190702);
        com.tencent.mm.xeffect.d dVar = com.tencent.mm.xeffect.d.RxN;
        com.tencent.mm.xeffect.d.R(b.Gzt);
        com.tencent.mm.plugin.xlabeffect.d.gls();
        aa aaVar = aa.Gzi;
        aa.efp();
        TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
        TAVKitMuxer.setup();
        AppMethodBeat.o(190702);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ac(ac acVar) {
        this(acVar.Gzn);
        p.h(acVar, FirebaseAnalytics.b.ORIGIN);
        AppMethodBeat.i(190701);
        Size hfp = acVar.getComposition().hfp();
        jt(hfp.getWidth(), hfp.getHeight());
        at(acVar.Gez.getPlayStart(), acVar.Gez.fBz());
        this.iiw.set(acVar.iiw);
        this.Gzp = acVar.Gzp;
        AppMethodBeat.o(190701);
    }

    public final long fBz() {
        AppMethodBeat.i(258772);
        long fBz = this.Gez.fBz();
        AppMethodBeat.o(258772);
        return fBz;
    }

    public final long getDurationMs() {
        AppMethodBeat.i(190679);
        long durationMs = this.Gez.getDurationMs();
        AppMethodBeat.o(190679);
        return durationMs;
    }

    public final long getSourceDuration() {
        AppMethodBeat.i(190680);
        long sourceDuration = this.Gez.getSourceDuration();
        AppMethodBeat.o(190680);
        return sourceDuration;
    }

    public final void at(long j2, long j3) {
        AppMethodBeat.i(190681);
        Log.i("MicroMsg.VLogComposition", "setPlayRange:[" + j2 + ", " + j3 + ']');
        this.Gez.at(j2, j3);
        AppMethodBeat.o(190681);
    }

    public final void KN(long j2) {
        AppMethodBeat.i(190682);
        this.Gfd = j2;
        long playStart = this.Gez.getPlayStart();
        if (this.Gfd > 0 && this.Gez.fBz() - playStart > this.Gfd) {
            this.Gez.at(playStart, this.Gfd + playStart);
        }
        AppMethodBeat.o(190682);
    }

    public final o<Long, Long> fBA() {
        AppMethodBeat.i(190683);
        o<Long, Long> oVar = new o<>(Long.valueOf(this.Gez.Rhl), Long.valueOf(this.Gez.Rhm));
        AppMethodBeat.o(190683);
        return oVar;
    }

    private void fBB() {
        AppMethodBeat.i(190684);
        for (T t : this.Gzn) {
            t.Cev.ai(t.GzA.Rhd, t.GzA.Rhe);
        }
        long playStart = this.Gez.getPlayStart();
        if (this.Gfd > 0 && this.Gez.fBz() - playStart > this.Gfd) {
            this.Gez.at(playStart, this.Gfd + playStart);
        }
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multivideo_edit_preview_high_fps_enable, 1) == 1 && this.Gzq > 0 && this.Gzr > 0) {
            n nVar = this.Gez;
            float min = (float) Math.min(this.Gzq, this.Gzr);
            if (min > 0.0f) {
                nVar.Rhp = min;
            }
        }
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_use_audio_resampler, 1) == 1) {
            this.Gez.Rht = new com.tencent.mm.videocomposition.a.a(new d(this.audioSampleRate, this.audioChannelCount));
        }
        AppMethodBeat.o(190684);
    }

    public final n getComposition() {
        AppMethodBeat.i(190685);
        fBB();
        n nVar = this.Gez;
        AppMethodBeat.o(190685);
        return nVar;
    }

    public final void q(Rect rect) {
        AppMethodBeat.i(190686);
        p.h(rect, "rect");
        this.iiw.set(rect);
        this.Gez.t(this.iiw);
        AppMethodBeat.o(190686);
    }

    public final void jt(int i2, int i3) {
        AppMethodBeat.i(190687);
        Log.i("MicroMsg.VLogComposition", "setRenderSize: " + i2 + ", " + i3);
        this.Gez.lW(i2, i3);
        AppMethodBeat.o(190687);
    }

    public static /* synthetic */ void a(ac acVar, String str) {
        AppMethodBeat.i(190689);
        acVar.cB(str, false);
        AppMethodBeat.o(190689);
    }

    public final void cB(String str, boolean z) {
        long j2;
        AppMethodBeat.i(190688);
        p.h(str, "musicPath");
        this.BNS = !Util.isNullOrNil(str);
        this.iiv = str;
        String k = s.k(str, false);
        if (k == null) {
            k = "";
        }
        p.g(k, "VFSFileOp.exportExternal…h(musicPath, false) ?: \"\"");
        MultiMediaVideoChecker multiMediaVideoChecker = MultiMediaVideoChecker.GyY;
        MultiMediaVideoChecker.a aTW = MultiMediaVideoChecker.aTW(k);
        if (aTW != null) {
            j2 = aTW.duration;
        } else {
            j2 = 0;
        }
        if (!z || j2 == 0) {
            com.tencent.mm.videocomposition.d dVar = new com.tencent.mm.videocomposition.d(k, 3);
            dVar.KO(this.Gez.getPlayStart());
            dVar.KP(this.Gez.getSourceDuration());
            dVar.KQ(0);
            dVar.KR(dVar.endTimeMs);
            this.Gez.e(dVar);
        } else {
            long playStart = this.Gez.getPlayStart();
            while (playStart <= this.Gez.fBz()) {
                com.tencent.mm.videocomposition.d dVar2 = new com.tencent.mm.videocomposition.d(k, 3);
                dVar2.KO(playStart);
                dVar2.KP(dVar2.GJB + playStart);
                this.Gez.e(dVar2);
                playStart += dVar2.GJB;
            }
        }
        Log.i("MicroMsg.VLogComposition", "addCompositionMusic musicPath:" + str + ", fillUp:" + z);
        AppMethodBeat.o(190688);
    }

    public final void wB(boolean z) {
        AppMethodBeat.i(190690);
        Log.i("MicroMsg.VLogComposition", "enableVideoSound:".concat(String.valueOf(z)));
        this.Gzo = z;
        this.Gez.wB(this.Gzo);
        AppMethodBeat.o(190690);
    }

    private final int fBC() {
        int i2 = 0;
        AppMethodBeat.i(190691);
        ArrayList arrayList = new ArrayList();
        for (T t : this.Gzn) {
            if (t.type == 2) {
                arrayList.add(t);
            }
        }
        ArrayList<ad> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
        for (ad adVar : arrayList2) {
            MultiMediaVideoChecker.a cA = MultiMediaVideoChecker.GyY.cA(adVar.path, true);
            arrayList3.add(Integer.valueOf(cA != null ? (int) cA.cKu : 0));
        }
        Integer num = (Integer) j.w(arrayList3);
        if (num != null) {
            i2 = num.intValue();
        }
        Log.i("MicroMsg.VLogComposition", "selectMaxFpsFromTrackList maxFps:".concat(String.valueOf(i2)));
        AppMethodBeat.o(190691);
        return i2;
    }

    public final void O(kotlin.g.a.b<? super Long, Bitmap> bVar) {
        AppMethodBeat.i(190692);
        p.h(bVar, "blendBitmapProvider");
        this.Gez.a(new e(bVar, this.wbk));
        AppMethodBeat.o(190692);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(190693);
        this.Gez.a(eVar);
        AppMethodBeat.o(190693);
    }

    public final List<ad> fBD() {
        AppMethodBeat.i(190694);
        ArrayList arrayList = new ArrayList();
        for (T t : this.Gzn) {
            T t2 = t;
            if (t2.type == 1 || t2.type == 2) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(190694);
        return arrayList2;
    }

    public final void acz(int i2) {
        AppMethodBeat.i(190695);
        Log.i("MicroMsg.VLogComposition", "setFpsUpperLimit:".concat(String.valueOf(i2)));
        if (i2 > 0) {
            this.Gzq = i2;
        }
        AppMethodBeat.o(190695);
    }

    public final void ju(int i2, int i3) {
        this.audioSampleRate = i2;
        this.audioChannelCount = i3;
    }

    public static void aUa(String str) {
        AppMethodBeat.i(190696);
        p.h(str, "path");
        AppMethodBeat.o(190696);
    }

    public final void c(int i2, kotlin.g.a.b<? super Bitmap, x> bVar) {
        AppMethodBeat.i(190697);
        p.h(bVar, "callback");
        this.Gez.c(i2, bVar);
        AppMethodBeat.o(190697);
    }

    public final void a(EffectManager effectManager) {
        this.wbk = effectManager;
        this.Gez.GAw = effectManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fBE() {
        /*
        // Method dump skipped, instructions count: 271
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.ac.fBE():java.lang.String");
    }

    public final String fBF() {
        int i2;
        int i3;
        AppMethodBeat.i(190699);
        if (this.Gzn.isEmpty()) {
            AppMethodBeat.o(190699);
            return "";
        }
        ArrayList<ad> arrayList = this.Gzn;
        ArrayList arrayList2 = new ArrayList(j.a(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Float.valueOf(it.next().GzA.mwH));
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList<Number> arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 0;
            for (Number number : arrayList4) {
                if (number.floatValue() != 1.0f) {
                    i3 = i2 + 1;
                    if (i3 < 0) {
                        j.hxI();
                    }
                } else {
                    i3 = i2;
                }
                i2 = i3;
            }
        }
        String iVar = new i(ae.e(kotlin.s.U("usePlayRateTrackCount", Integer.valueOf(i2)), kotlin.s.U("playRateStatus", j.a(arrayList3, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)))).toString();
        p.g(iVar, "JSONObject(info).toString()");
        String j2 = kotlin.n.n.j(iVar, ",", ";", false);
        AppMethodBeat.o(190699);
        return j2;
    }
}
