package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVSource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0017\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ(\u0010\u0017\u001a\u00020\u00182\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00180\u001aj\u0002`\u001dH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J6\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0$2\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00180\u001aj\u0002`\u001dH\u0016J\b\u0010%\u001a\u00020\u0018H\u0002J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, hxF = {"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "cacheKey", "", "(Lcom/tencent/tavkit/composition/TAVSource;Ljava/lang/String;)V", "sourceBuilder", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "generateCallback", "Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;", "generator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "isRunning", "", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "size", "Lcom/tencent/tav/coremedia/CGSize;", "getSourceBuilder", "()Lkotlin/jvm/functions/Function0;", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "destroyGenerator", "ensureGenerator", "requestFrames", "times", "", "requestNext", "setSize", "width", "", "height", "Companion", "Request", "video_composition_release"})
public final class c implements g {
    private static final LruCache<String, Bitmap> Asq = new LruCache<>(200);
    public static final a RgU = new a((byte) 0);
    private final LinkedList<b> Asm;
    private TAVSourceImageGenerator RgR;
    private final AssetImageGenerator.ImageGeneratorListener RgS;
    private final kotlin.g.a.a<TAVSource> RgT;
    private final String cacheKey;
    private boolean isRunning;
    private final CGSize size;

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "requestedTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "result", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"})
    static final class d implements AssetImageGenerator.ImageGeneratorListener {
        final /* synthetic */ c RgW;

        d(c cVar) {
            this.RgW = cVar;
        }

        @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$generateCallback$1$1$1"})
        static final class a extends q implements kotlin.g.a.b<b, Boolean> {
            final /* synthetic */ z.e Asz;
            final /* synthetic */ d RgX;
            final /* synthetic */ CMTime RgY;
            final /* synthetic */ Bitmap RgZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, CMTime cMTime, z.e eVar, Bitmap bitmap) {
                super(1);
                this.RgX = dVar;
                this.RgY = cMTime;
                this.Asz = eVar;
                this.RgZ = bitmap;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(b bVar) {
                boolean z;
                AppMethodBeat.i(216728);
                b bVar2 = bVar;
                p.h(bVar2, LocaleUtil.ITALIAN);
                if (p.j(bVar2.Asw, this.RgY)) {
                    this.Asz.SYF = bVar2.Asv;
                    bVar2.gWp.invoke(Long.valueOf(bVar2.Asv), this.RgZ);
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(216728);
                return valueOf;
            }
        }

        @Override // com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener
        public final void onCompletion(CMTime cMTime, Bitmap bitmap, CMTime cMTime2, AssetImageGenerator.AssetImageGeneratorResult assetImageGeneratorResult) {
            AppMethodBeat.i(216729);
            p.h(cMTime, "requestedTime");
            p.h(assetImageGeneratorResult, "result");
            if (assetImageGeneratorResult != AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded) {
                bitmap = null;
            }
            z.e eVar = new z.e();
            eVar.SYF = -1;
            synchronized (this.RgW.Asm) {
                try {
                    j.c((List) this.RgW.Asm, (kotlin.g.a.b) new a(this, cMTime, eVar, bitmap));
                } finally {
                    AppMethodBeat.o(216729);
                }
            }
            b.i("MicroMsg.VLogCompositionCoverGenerator", "get " + this.RgW.hashCode() + ": " + eVar.SYF + (char) 65292 + (cMTime.getTimeUs() / 1000), new Object[0]);
            this.RgW.isRunning = false;
            c.c(this.RgW);
            if (eVar.SYF >= 0 && bitmap != null) {
                a aVar = c.RgU;
                c.Asq.put(this.RgW.cacheKey + '-' + eVar.SYF, bitmap);
            }
        }
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$cancel$1$1"})
    /* renamed from: com.tencent.mm.videocomposition.c$c  reason: collision with other inner class name */
    static final class C2158c extends q implements kotlin.g.a.b<b, Boolean> {
        final /* synthetic */ long Asx;
        final /* synthetic */ c RgW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2158c(c cVar, long j2) {
            super(1);
            this.RgW = cVar;
            this.Asx = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(b bVar) {
            boolean z;
            AppMethodBeat.i(216727);
            b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            if (bVar2.Asv == this.Asx) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(216727);
            return valueOf;
        }
    }

    public /* synthetic */ c(TAVSource tAVSource, String str, byte b2) {
        this(tAVSource, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.a<? extends com.tencent.tavkit.composition.TAVSource> */
    /* JADX WARN: Multi-variable type inference failed */
    private c(kotlin.g.a.a<? extends TAVSource> aVar, String str) {
        AppMethodBeat.i(216736);
        this.RgT = aVar;
        this.cacheKey = str;
        this.size = new CGSize(300.0f, 300.0f);
        this.Asm = new LinkedList<>();
        this.RgS = new d(this);
        b.i("MicroMsg.VLogCompositionCoverGenerator", "init: " + hashCode(), new Object[0]);
        AppMethodBeat.o(216736);
    }

    public /* synthetic */ c(kotlin.g.a.a aVar, String str, byte b2) {
        this(aVar, str);
    }

    public static final /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(216739);
        cVar.evJ();
        AppMethodBeat.o(216739);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Companion;", "", "()V", "DefaultMaxImageSize", "", "TAG", "", "thumbCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "getThumbCache", "()Landroid/util/LruCache;", "clearCache", "", "fromCompositionTrack", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/videocomposition/CompositionTrack;", "fromVideoComposition", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "video_composition_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c b(d dVar) {
            AppMethodBeat.i(216720);
            p.h(dVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
            c cVar = new c(dVar.hfj(), dVar.path, (byte) 0);
            AppMethodBeat.o(216720);
            return cVar;
        }

        public static c b(n nVar) {
            AppMethodBeat.i(216721);
            p.h(nVar, "composition");
            c cVar = new c(new C2157a(nVar), String.valueOf(nVar.hashCode()), (byte) 0);
            AppMethodBeat.o(216721);
            return cVar;
        }

        @l(hxD = {1, 1, 15}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/tavkit/composition/TAVSource;", "invoke"})
        /* renamed from: com.tencent.mm.videocomposition.c$a$a  reason: collision with other inner class name */
        static final class C2157a extends q implements kotlin.g.a.a<TAVSource> {
            final /* synthetic */ n GLI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2157a(n nVar) {
                super(0);
                this.GLI = nVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ TAVSource invoke() {
                AppMethodBeat.i(216719);
                TAVSource buildSource = this.GLI.buildSource();
                AppMethodBeat.o(216719);
                return buildSource;
            }
        }
    }

    static {
        AppMethodBeat.i(216738);
        AppMethodBeat.o(216738);
    }

    private c(final TAVSource tAVSource, String str) {
        this(new kotlin.g.a.a<TAVSource>() {
            /* class com.tencent.mm.videocomposition.c.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* bridge */ /* synthetic */ TAVSource invoke() {
                return tAVSource;
            }
        }, str);
        AppMethodBeat.i(216737);
        AppMethodBeat.o(216737);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void setSize(int i2, int i3) {
        this.size.width = (float) i2;
        this.size.height = (float) i3;
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void b(List<Long> list, m<? super Long, ? super Bitmap, x> mVar) {
        boolean z;
        AppMethodBeat.i(216730);
        p.h(list, "times");
        p.h(mVar, "callback");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            long longValue = t.longValue();
            b.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: ".concat(String.valueOf(longValue)), new Object[0]);
            Bitmap bitmap = Asq.get(this.cacheKey + '-' + longValue);
            if (bitmap != null) {
                mVar.invoke(Long.valueOf(longValue), bitmap);
                z = false;
            } else {
                z = true;
            }
            if (z) {
                arrayList.add(t);
            }
        }
        List<Number> t2 = j.t((Iterable) arrayList);
        ArrayList arrayList2 = new ArrayList(j.a(t2, 10));
        for (Number number : t2) {
            arrayList2.add(new b(number.longValue(), mVar));
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            b.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: no new request", new Object[0]);
            AppMethodBeat.o(216730);
            return;
        }
        synchronized (this.Asm) {
            try {
                this.Asm.addAll(arrayList3);
            } catch (Throwable th) {
                AppMethodBeat.o(216730);
                throw th;
            }
        }
        evJ();
        AppMethodBeat.o(216730);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void cancel(long j2) {
        AppMethodBeat.i(216731);
        synchronized (this.Asm) {
            try {
                j.c((List) this.Asm, (kotlin.g.a.b) new C2158c(this, j2));
            } finally {
                AppMethodBeat.o(216731);
            }
        }
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void destroy() {
        AppMethodBeat.i(216732);
        b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy: " + hashCode(), new Object[0]);
        synchronized (this.Asm) {
            try {
                this.Asm.clear();
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(216732);
                throw th;
            }
        }
        hfi();
        AppMethodBeat.o(216732);
    }

    private final void evJ() {
        boolean z;
        AppMethodBeat.i(216733);
        synchronized (this.Asm) {
            try {
                if (!this.isRunning) {
                    if (!this.Asm.isEmpty()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        b bVar = this.Asm.get(0);
                        p.g(bVar, "requests[0]");
                        b bVar2 = bVar;
                        hfh();
                        this.isRunning = true;
                        TAVSourceImageGenerator tAVSourceImageGenerator = this.RgR;
                        if (tAVSourceImageGenerator != null) {
                            tAVSourceImageGenerator.generateThumbnailAtTime(bVar2.Asw, this.RgS);
                            x xVar = x.SXb;
                        }
                    } else {
                        hfi();
                        x xVar2 = x.SXb;
                    }
                    AppMethodBeat.o(216733);
                }
            } finally {
                AppMethodBeat.o(216733);
            }
        }
    }

    private final void hfh() {
        AssetImageGenerator assetImageGenerator;
        AppMethodBeat.i(216734);
        if (this.RgR == null) {
            this.RgR = new TAVSourceImageGenerator(this.RgT.invoke(), this.size);
            b.i("MicroMsg.VLogCompositionCoverGenerator", "create generator " + this.RgR, new Object[0]);
            TAVSourceImageGenerator tAVSourceImageGenerator = this.RgR;
            if (!(tAVSourceImageGenerator == null || (assetImageGenerator = tAVSourceImageGenerator.getAssetImageGenerator()) == null)) {
                assetImageGenerator.setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
                AppMethodBeat.o(216734);
                return;
            }
        }
        AppMethodBeat.o(216734);
    }

    private final void hfi() {
        AssetImageGenerator assetImageGenerator;
        AppMethodBeat.i(216735);
        if (this.RgR != null) {
            b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy generator: " + this.RgR, new Object[0]);
            TAVSourceImageGenerator tAVSourceImageGenerator = this.RgR;
            if (!(tAVSourceImageGenerator == null || (assetImageGenerator = tAVSourceImageGenerator.getAssetImageGenerator()) == null)) {
                assetImageGenerator.release();
            }
            this.RgR = null;
        }
        AppMethodBeat.o(216735);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J!\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\nHÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032 \b\u0002\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R)\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "video_composition_release"})
    public static final class b {
        final long Asv;
        final CMTime Asw;
        final m<Long, Bitmap, x> gWp;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
            if (kotlin.g.b.p.j(r7.Asw, r8.Asw) != false) goto L_0x002f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r8) {
            /*
                r7 = this;
                r1 = 1
                r0 = 0
                r6 = 216726(0x34e96, float:3.03698E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                if (r7 == r8) goto L_0x002f
                boolean r2 = r8 instanceof com.tencent.mm.videocomposition.c.b
                if (r2 == 0) goto L_0x0036
                com.tencent.mm.videocomposition.c$b r8 = (com.tencent.mm.videocomposition.c.b) r8
                long r2 = r7.Asv
                long r4 = r8.Asv
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x0034
                r2 = r1
            L_0x0019:
                if (r2 == 0) goto L_0x0036
                kotlin.g.a.m<java.lang.Long, android.graphics.Bitmap, kotlin.x> r2 = r7.gWp
                kotlin.g.a.m<java.lang.Long, android.graphics.Bitmap, kotlin.x> r3 = r8.gWp
                boolean r2 = kotlin.g.b.p.j(r2, r3)
                if (r2 == 0) goto L_0x0036
                com.tencent.tav.coremedia.CMTime r2 = r7.Asw
                com.tencent.tav.coremedia.CMTime r3 = r8.Asw
                boolean r2 = kotlin.g.b.p.j(r2, r3)
                if (r2 == 0) goto L_0x0036
            L_0x002f:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                r0 = r1
            L_0x0033:
                return r0
            L_0x0034:
                r2 = r0
                goto L_0x0019
            L_0x0036:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                goto L_0x0033
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.videocomposition.c.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(216725);
            long j2 = this.Asv;
            int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            m<Long, Bitmap, x> mVar = this.gWp;
            int hashCode = ((mVar != null ? mVar.hashCode() : 0) + i3) * 31;
            CMTime cMTime = this.Asw;
            if (cMTime != null) {
                i2 = cMTime.hashCode();
            }
            int i4 = hashCode + i2;
            AppMethodBeat.o(216725);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(216724);
            String str = "Request(timeMs=" + this.Asv + ", callback=" + this.gWp + ", cmTime=" + this.Asw + ")";
            AppMethodBeat.o(216724);
            return str;
        }

        public /* synthetic */ b(long j2, m mVar) {
            this(j2, mVar, new CMTime(j2, 1000));
            AppMethodBeat.i(216723);
            AppMethodBeat.o(216723);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.g.a.m<? super java.lang.Long, ? super android.graphics.Bitmap, kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        private b(long j2, m<? super Long, ? super Bitmap, x> mVar, CMTime cMTime) {
            p.h(mVar, "callback");
            p.h(cMTime, "cmTime");
            AppMethodBeat.i(216722);
            this.Asv = j2;
            this.gWp = mVar;
            this.Asw = cMTime;
            AppMethodBeat.o(216722);
        }
    }
}
