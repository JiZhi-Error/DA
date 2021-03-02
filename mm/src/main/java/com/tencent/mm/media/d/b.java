package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010&\u001a\u00020\tJ\b\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0018\u0012\u0004\u0012\u00020\u00050\"J\u0006\u0010*\u001a\u00020(J\u0016\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0005J\u000e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u000200R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\"0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u000e\u0010%\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/media/decoder/DecodeHelper;", "", "path", "", "outputFPS", "", "startTime", "", "enableHevc", "", "(Ljava/lang/String;IJZ)V", "copyPts", "Landroid/support/v4/util/ArrayMap;", "", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "frameInterval", "getFrameInterval", "()J", "setFrameInterval", "(J)V", "frames", "", "inFPS", "lastPts", "maxFps", "", "minFps", "outFPS", "parents", "queue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "recentPts", "getStartTime", "vfrThreshold", "hasFrame", "initStrategy", "", "receiveFrame", "release", "sendPacket", "pts", "bufferIndex", "useStrategy", "strategy", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "Companion", "plugin-mediaeditor_release"})
public final class b {
    public static final a idZ = new a((byte) 0);
    private final List<Long> aEj;
    final PriorityQueue<o<Long, Integer>> bHs;
    long idQ = -1;
    long idR = -1;
    final android.support.v4.e.a<Long, Long> idS = new android.support.v4.e.a<>();
    final android.support.v4.e.a<Long, List<Long>> idT = new android.support.v4.e.a<>();
    private int idU;
    private int idV;
    private double idW;
    private double idX;
    private final int idY = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remuxer_vfr_threshold, 10);
    private boolean iiD;
    private final long startTime;
    private long zpe = 333;

    static {
        AppMethodBeat.i(93527);
        AppMethodBeat.o(93527);
    }

    public b(String str, int i2, long j2, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(259081);
        this.startTime = j2;
        this.iiD = z;
        double[] dArr = {0.0d, 0.0d, 0.0d};
        this.aEj = j.n(com.tencent.mm.media.k.b.a(str, dArr));
        this.idU = (int) dArr[2];
        this.idV = i2 <= 0 ? this.idU : i2;
        h.INSTANCE.F(986, 114);
        h.INSTANCE.n(986, 115, (long) dArr[2]);
        h.INSTANCE.n(986, 116, (long) (dArr[1] - dArr[0]));
        int i3 = 0;
        while (true) {
            if (i3 >= 3) {
                z2 = true;
                break;
            }
            if (dArr[i3] > 0.0d) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                z2 = false;
                break;
            }
            i3++;
        }
        if (z2) {
            if (!this.aEj.isEmpty()) {
                this.idR = ((Number) j.ku(this.aEj)).longValue();
            }
        }
        this.idW = dArr[0];
        this.idX = dArr[1];
        this.bHs = new PriorityQueue<>(Math.max(this.aEj.size(), 11), AnonymousClass1.iea);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remuxer_decode_check_strategy, false);
        if (!WeChatEnvironment.hasDebugger() && !a2) {
            Log.i("DecodeHelper", "use PassthroughDecodeStrategy");
            a(new k());
        } else if (this.idU <= this.idV) {
            Log.i("DecodeHelper", "use PassthroughDecodeStrategy");
            a(new k());
        } else {
            int hWK = com.tencent.mm.plugin.sight.base.b.hWK();
            if (this.aEj.size() > hWK && !com.tencent.mm.plugin.sight.base.b.eVr() && !com.tencent.mm.plugin.sight.base.b.aj(false, this.iiD)) {
                Log.i("DecodeHelper", "use CfrDecodeStrategy");
                a(new a());
            } else if (this.aEj.size() <= hWK) {
                Log.i("DecodeHelper", "use VfrDecodeStrategy");
                a(new l());
            } else {
                Log.i("DecodeHelper", "use SimpleVfrDecodeStrategy");
                a(new m());
            }
        }
        Log.i("DecodeHelper", "init decode helper, inFPS = " + this.idU + ", outFPS = " + this.idV + ", minFps:" + this.idW + ", maxFps:" + this.idX + ", vfrThreshold:" + this.idY + ", valid frames = " + this.idS.size() + ", lastPts:" + this.idR + ", frames.size:" + this.aEj.size());
        AppMethodBeat.o(259081);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/media/decoder/DecodeHelper$Companion;", "", "()V", "DEFAULT_QUEUE_CAPACITY", "", "REPORT_ID_STORY_VIDEO", "", "REPORT_KEY_ENCODE_CFR_COUNT", "REPORT_KEY_ENCODE_CFR_INIT_TIME", "REPORT_KEY_ENCODE_COUNT", "REPORT_KEY_ENCODE_FRAME_RATE", "REPORT_KEY_ENCODE_FRAME_RATE_DIFF", "REPORT_KEY_ENCODE_ORIGINAL_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_INIT_TIME", "REPORT_KEY_ENCODE_SIMPLE_VFR_COUNT", "REPORT_KEY_ENCODE_SIMPLE_VFR_INIT_TIME", "REPORT_KEY_ENCODE_VFR_COUNT", "REPORT_KEY_ENCODE_VFR_INIT_TIME", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private void a(c cVar) {
        AppMethodBeat.i(93525);
        p.h(cVar, "strategy");
        long currentTimeMillis = System.currentTimeMillis();
        cVar.a(this.startTime, this.aEj, this.idU, this.idV, this.idS, this.idT);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (cVar instanceof k) {
            h.INSTANCE.F(986, 105);
            h.INSTANCE.n(986, 108, currentTimeMillis2);
        } else if (cVar instanceof a) {
            h.INSTANCE.F(986, 107);
            h.INSTANCE.n(986, 112, currentTimeMillis2);
            this.zpe = ((a) cVar).zgl;
        } else if (cVar instanceof l) {
            h.INSTANCE.F(986, 106);
            h.INSTANCE.n(986, 110, currentTimeMillis2);
        } else if (cVar instanceof m) {
            h.INSTANCE.F(986, 149);
            h.INSTANCE.n(986, 150, currentTimeMillis2);
        }
        this.idQ = -1;
        AppMethodBeat.o(93525);
    }
}
