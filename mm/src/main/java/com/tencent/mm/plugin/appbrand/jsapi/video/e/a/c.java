package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0002&'BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u001e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\tH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000bH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "Lcom/google/android/exoplayer2/trackselection/BaseTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/source/TrackGroup;[ILcom/google/android/exoplayer2/upstream/BandwidthMeter;IJJJF)V", "maxDurationForQualityDecreaseUs", "minDurationForQualityIncreaseUs", "minDurationToRetainAfterDiscardUs", "reason", "selectedIndex", "determineIdealSelectedIndex", "nowMs", "evaluateQueueSize", "playbackPositionUs", "queue", "", "Lcom/google/android/exoplayer2/source/chunk/MediaChunk;", "getSelectFormat", "Lcom/google/android/exoplayer2/Format;", "getSelectedIndex", "getSelectionData", "", "getSelectionReason", "updateSelectedTrack", "", "bufferedDurationUs", "Companion", "Factory", "luggage-commons-jsapi-video-ext_release"})
public final class c extends com.google.android.exoplayer2.g.b {
    private static final int mBM = mBM;
    private static final int mBN = 10000;
    private static final int mBO = 25000;
    private static final int mBP = 25000;
    private static final float mBQ = mBQ;
    public static final a mBR = new a((byte) 0);
    private final d bDT;
    private final int bDU;
    private final long bDV;
    private final long bDW;
    private final long bDX;
    private final float bDY;
    private int bDZ;
    private int bxP;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(q qVar, int[] iArr, d dVar, int i2, long j2, long j3, long j4, float f2) {
        super(qVar, Arrays.copyOf(iArr, iArr.length));
        p.h(qVar, "group");
        p.h(iArr, "tracks");
        p.h(dVar, "bandwidthMeter");
        AppMethodBeat.i(235238);
        this.bDT = dVar;
        this.bDU = i2;
        this.bDY = f2;
        this.bDV = 1000 * j2;
        this.bDW = 1000 * j3;
        this.bDX = 1000 * j4;
        d dVar2 = this.bDT;
        a aVar = (a) (!(dVar2 instanceof a) ? null : dVar2);
        if (aVar != null) {
            aVar.bFf = -1;
        }
        this.bxP = ak(-1);
        this.bDZ = 1;
        AppMethodBeat.o(235238);
    }

    @Override // com.google.android.exoplayer2.g.f
    public final void af(long j2) {
        AppMethodBeat.i(235236);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.bxP;
        this.bxP = ak(elapsedRealtime);
        if (this.bxP != i2) {
            if (!l(i2, elapsedRealtime)) {
                Format eU = eU(i2);
                Format eU2 = eU(this.bxP);
                if (eU2.bitrate > eU.bitrate && j2 < this.bDV) {
                    Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack < selectIndex = " + this.bxP + ", bufferedDurationUs = " + j2 + ", min = " + this.bDV);
                    this.bxP = i2;
                } else if (eU2.bitrate < eU.bitrate && j2 >= this.bDW) {
                    Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack > selectIndex = " + this.bxP + ", bufferedDurationUs = " + j2);
                    this.bxP = i2;
                }
            }
            if (this.bxP != i2) {
                this.bDZ = 3;
            }
        }
        Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack selectIndex = " + this.bxP);
        AppMethodBeat.o(235236);
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int getSelectedIndex() {
        return this.bxP;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final int vP() {
        return this.bDZ;
    }

    @Override // com.google.android.exoplayer2.g.f
    public final Object vQ() {
        return null;
    }

    private final int ak(long j2) {
        AppMethodBeat.i(235237);
        long wE = this.bDT.wE();
        long j3 = wE == -1 ? (long) this.bDU : (long) (((float) wE) * this.bDY);
        Log.i("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] determineIdealSelectedIndex bitrateEstimate = ".concat(String.valueOf(wE)));
        int i2 = this.length;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (j2 == -1 || !l(i4, j2)) {
                if (((long) eU(i4).bitrate) <= j3) {
                    AppMethodBeat.o(235237);
                    return i4;
                }
                i3 = i4;
            }
        }
        AppMethodBeat.o(235237);
        return i3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00020\u0011\"\u00020\u0005H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection$Factory;", "Lcom/google/android/exoplayer2/trackselection/TrackSelection$Factory;", "bandwidthMeter", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "maxInitialBitrate", "", "minDurationForQualityIncreaseMs", "maxDurationForQualityDecreaseMs", "minDurationToRetainAfterDiscardMs", "bandwidthFraction", "", "(Lcom/google/android/exoplayer2/upstream/BandwidthMeter;IIIIF)V", "createTrackSelection", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection;", "group", "Lcom/google/android/exoplayer2/source/TrackGroup;", "tracks", "", "luggage-commons-jsapi-video-ext_release"})
    public static final class b implements f.a {
        private final d bDT;
        private final int bDU;
        private final float bDY;
        private final int bEa;
        private final int bEb;
        private final int bEc = 25000;

        public b(d dVar, int i2, int i3, int i4, float f2) {
            p.h(dVar, "bandwidthMeter");
            AppMethodBeat.i(235235);
            this.bDT = dVar;
            this.bDU = i2;
            this.bEa = i3;
            this.bEb = i4;
            this.bDY = f2;
            AppMethodBeat.o(235235);
        }

        @Override // com.google.android.exoplayer2.g.f.a
        public final /* synthetic */ f a(q qVar, int[] iArr) {
            AppMethodBeat.i(235234);
            p.h(qVar, "group");
            p.h(iArr, "tracks");
            c cVar = new c(qVar, iArr, this.bDT, this.bDU, (long) this.bEa, (long) this.bEb, (long) this.bEc, this.bDY);
            AppMethodBeat.o(235234);
            return cVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0012XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceTrackSelection$Companion;", "", "()V", "DEFAULT_BANDWIDTH_FRACTION", "", "getDEFAULT_BANDWIDTH_FRACTION", "()F", "DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS", "", "getDEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS", "()I", "DEFAULT_MAX_INITIAL_BITRATE", "getDEFAULT_MAX_INITIAL_BITRATE", "DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS", "getDEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS", "DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS", "getDEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS", "TAG", "", "luggage-commons-jsapi-video-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(235239);
        AppMethodBeat.o(235239);
    }
}
