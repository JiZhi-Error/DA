package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kj;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0018\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020%J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001a¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "", "()V", "currMusicId", "", "getCurrMusicId", "()I", "setCurrMusicId", "(I)V", "currStartTime", "", "getCurrStartTime", "()J", "setCurrStartTime", "(J)V", "feedbackList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "Lkotlin/collections/ArrayList;", "getFeedbackList", "()Ljava/util/ArrayList;", "pause", "", "getPause", "()Z", "setPause", "(Z)V", "requestId", "getRequestId", "setRequestId", "source", "getSource", "setSource", "withBgm", "getWithBgm", "setWithBgm", "recordCancel", "", "recordEnterSearch", "recordNoBgm", "recordPause", "recordPlay", "musicId", "recordSend", "reportKv", "sendResult", "Companion", "plugin-recordvideo_release"})
public final class c {
    private static long BPA = 0;
    private static long BPB = 0;
    private static kj BPC = new kj();
    public static final a BPD = new a((byte) 0);
    private static c BPz = null;
    public static final String TAG = TAG;
    public int BPv;
    private long BPw;
    public boolean BPx;
    public final ArrayList<clo> BPy = new ArrayList<>();
    private boolean pause = true;
    private int source = AudioCacheInfo.BPm;
    public long ulj;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020-2\u0006\u0010\"\u001a\u00020-J\u0006\u0010.\u001a\u00020,R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter$Companion;", "", "()V", "AUDIO_FINISH_TYPE_CANCEL", "", "AUDIO_FINISH_TYPE_OK", "AUDIO_FINISH_TYPE_SEARCH", "BehaviorAdoptAndCancel", "BehaviorAdoptAndSend", "BehaviorListen", "BehaviorNoBgm", "BehaviorNoBgmAndCancel", "BehaviorNoBgmAndSend", "BehaviorSearchAdoptAndCancel", "BehaviorSearchAdoptAndSend", "BehaviorSearchEnter", "BehaviorSearchListen", "BehaviorSearchNoBgmAndCancel", "BehaviorSearchNoBgmAndSend", "KVAudioResult", "TAG", "", "audioSearchStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "getAudioSearchStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;", "setAudioSearchStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/VideoBGMSearchStruct;)V", "current", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "getCurrent", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;", "setCurrent", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioReporter;)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "recordLocation", "", "", "reportAudioSearchStruct", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void eKk() {
            AppMethodBeat.i(75416);
            Log.d(c.TAG, "reportAudioSearchStruct:\n " + c.BPC.abW());
            c.BPC.bfK();
            kj kjVar = new kj();
            p.h(kjVar, "<set-?>");
            c.BPC = kjVar;
            AppMethodBeat.o(75416);
        }
    }

    public c() {
        AppMethodBeat.i(75419);
        AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
        AppMethodBeat.o(75419);
    }

    static {
        AppMethodBeat.i(75420);
        AppMethodBeat.o(75420);
    }

    public final void hV(int i2, int i3) {
        AppMethodBeat.i(237260);
        this.BPv = i2;
        this.BPw = System.currentTimeMillis();
        this.BPx = true;
        this.pause = false;
        this.source = i3;
        AppMethodBeat.o(237260);
    }

    public final void eKd() {
        AppMethodBeat.i(75417);
        if (!this.pause) {
            clo clo = new clo();
            long currentTimeMillis = System.currentTimeMillis();
            clo.MqO = this.BPv;
            int i2 = this.source;
            AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
            clo.MqP = i2 == AudioCacheInfo.BPm ? 1 : 9;
            clo.MqQ = (int) (currentTimeMillis - this.BPw);
            clo.MqR = (int) (this.BPw / 1000);
            this.BPy.add(clo);
            this.pause = true;
            Log.i(TAG, "record pause " + d.a(clo));
        }
        AppMethodBeat.o(75417);
    }

    public final void eKe() {
        AppMethodBeat.i(163424);
        if (this.ulj == 0) {
            AppMethodBeat.o(163424);
            return;
        }
        clo clo = new clo();
        clo.MqO = this.BPv;
        if (this.BPx) {
            int i2 = this.source;
            AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
            clo.MqP = i2 == AudioCacheInfo.BPn ? 10 : 2;
        } else {
            int i3 = this.source;
            AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
            clo.MqP = i3 == AudioCacheInfo.BPn ? 12 : 6;
        }
        clo.MqR = (int) Util.nowSecond();
        eKd();
        this.BPy.add(clo);
        Log.i(TAG, "record send " + d.a(clo));
        eKg();
        eKh();
        AppMethodBeat.o(163424);
    }

    public final void eKf() {
        AppMethodBeat.i(237261);
        if (this.ulj == 0) {
            AppMethodBeat.o(237261);
            return;
        }
        clo clo = new clo();
        clo.MqO = this.BPv;
        if (this.BPx) {
            int i2 = this.source;
            AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
            clo.MqP = i2 == AudioCacheInfo.BPn ? 11 : 5;
        } else {
            int i3 = this.source;
            AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
            clo.MqP = i3 == AudioCacheInfo.BPn ? 13 : 7;
        }
        clo.MqR = (int) Util.nowSecond();
        eKd();
        this.BPy.add(clo);
        Log.i(TAG, "record cancel " + d.a(clo));
        eKh();
        AppMethodBeat.o(237261);
    }

    private final void eKg() {
        int i2;
        int i3 = 2;
        AppMethodBeat.i(163425);
        if (this.ulj == 0) {
            AppMethodBeat.o(163425);
            return;
        }
        Context context = MMApplicationContext.getContext();
        if (NetStatusUtil.isWifi(context)) {
            i2 = 1;
        } else if (NetStatusUtil.is4G(context)) {
            i2 = 6;
        } else if (NetStatusUtil.is3G(context)) {
            i2 = 5;
        } else if (NetStatusUtil.is2G(context)) {
            i2 = 4;
        } else {
            i2 = NetStatusUtil.isWap(context) ? 3 : 2;
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[11];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = 1;
        objArr[2] = "";
        objArr[3] = Long.valueOf(BPA);
        objArr[4] = Long.valueOf(BPB);
        objArr[5] = "";
        objArr[6] = Long.valueOf(this.ulj);
        if (!this.BPx) {
            i3 = 1;
        }
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(this.BPv);
        objArr[9] = "";
        objArr[10] = "";
        hVar.a(16208, objArr);
        AppMethodBeat.o(163425);
    }

    private final void eKh() {
        AppMethodBeat.i(75418);
        b aAg = g.aAg();
        p.g(aAg, "network()");
        aAg.azz().b(new com.tencent.mm.plugin.recordvideo.model.a.a(this.ulj, this.BPy));
        BPz = null;
        AppMethodBeat.o(75418);
    }
}
