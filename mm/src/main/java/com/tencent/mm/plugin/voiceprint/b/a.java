package com.tencent.mm.plugin.voiceprint.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B*\u0012#\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "hasBeginRec", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecorderDevice", "context", "Landroid/content/Context;", JsApiStopRecordVoice.NAME, "isContinue", "Companion", "app_release"})
public final class a extends d {
    public static final C1885a GQE = new C1885a((byte) 0);
    private boolean GQD;
    private kotlin.g.a.b<? super Boolean, x> dtM;
    private com.tencent.mm.compatible.util.b jvG;

    static {
        AppMethodBeat.i(230908);
        AppMethodBeat.o(230908);
    }

    public a(kotlin.g.a.b<? super Boolean, x> bVar) {
        p.h(bVar, "onStartRecord");
        AppMethodBeat.i(230907);
        this.dtM = bVar;
        com.tencent.mm.plugin.audio.d.b.cet();
        com.tencent.mm.plugin.audio.d.d.cet();
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "record");
        AppMethodBeat.o(230907);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$Companion;", "", "()V", "TAG", "", "app_release"})
    /* renamed from: com.tencent.mm.plugin.voiceprint.b.a$a  reason: collision with other inner class name */
    public static final class C1885a {
        private C1885a() {
        }

        public /* synthetic */ C1885a(byte b2) {
            this();
        }
    }

    public final boolean hx(Context context) {
        AppMethodBeat.i(230903);
        p.h(context, "context");
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "record");
        this.jvG = new com.tencent.mm.compatible.util.b(context);
        int b2 = b("record", (Integer) 4);
        this.GQD = false;
        if (b2 != 0) {
            iY(100);
        } else {
            new b(this).sendEmptyMessageDelayed(0, 50);
        }
        AppMethodBeat.o(230903);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$requestAudioRecorderDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
    public static final class b extends MMHandler {
        final /* synthetic */ a GQF;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.GQF = aVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(230902);
            p.h(message, "msg");
            Log.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder handleMessage");
            if (this.GQF.GQD) {
                AppMethodBeat.o(230902);
                return;
            }
            this.GQF.agq("record");
            this.GQF.iY(200);
            AppMethodBeat.o(230902);
        }
    }

    private final void Yp() {
        AppMethodBeat.i(230904);
        agq("record");
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("record");
        AppMethodBeat.o(230904);
    }

    public final void wN(boolean z) {
        AppMethodBeat.i(230905);
        if (!z) {
            Yp();
        }
        com.tencent.mm.compatible.util.b bVar = this.jvG;
        if (bVar != null) {
            bVar.apm();
            AppMethodBeat.o(230905);
            return;
        }
        AppMethodBeat.o(230905);
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        AppMethodBeat.i(230906);
        super.iY(i2);
        Log.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(i2)));
        if (this.GQD) {
            AppMethodBeat.o(230906);
            return;
        }
        this.GQD = true;
        Yp();
        this.dtM.invoke(Boolean.TRUE);
        AppMethodBeat.o(230906);
    }
}
