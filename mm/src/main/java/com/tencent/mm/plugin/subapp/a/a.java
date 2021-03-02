package com.tencent.mm.plugin.subapp.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B*\u0012#\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\t¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyRespone", "", "(Lkotlin/jvm/functions/Function1;)V", "hasbeginRec", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "app_release"})
public final class a extends d {
    public static final C1789a FJf = new C1789a((byte) 0);
    private boolean FJe;
    private kotlin.g.a.b<? super Boolean, x> dtM;

    static {
        AppMethodBeat.i(230897);
        AppMethodBeat.o(230897);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$Companion;", "", "()V", "TAG", "", "app_release"})
    /* renamed from: com.tencent.mm.plugin.subapp.a.a$a  reason: collision with other inner class name */
    public static final class C1789a {
        private C1789a() {
        }

        public /* synthetic */ C1789a(byte b2) {
            this();
        }
    }

    public a(kotlin.g.a.b<? super Boolean, x> bVar) {
        p.h(bVar, "onStartRecord");
        AppMethodBeat.i(230896);
        this.dtM = bVar;
        AppMethodBeat.o(230896);
    }

    public final void Yo() {
        AppMethodBeat.i(230894);
        int b2 = b("record", (Integer) 4);
        this.FJe = false;
        if (b2 != 0) {
            iY(100);
            AppMethodBeat.o(230894);
            return;
        }
        new b(this).sendEmptyMessageDelayed(0, 50);
        AppMethodBeat.o(230894);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$requestAudioRecordDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
    public static final class b extends MMHandler {
        final /* synthetic */ a FJg;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.FJg = aVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(230893);
            p.h(message, "msg");
            Log.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder handleMessage");
            if (this.FJg.FJe) {
                AppMethodBeat.o(230893);
                return;
            }
            this.FJg.iY(200);
            this.FJg.agq("record");
            AppMethodBeat.o(230893);
        }
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        AppMethodBeat.i(230895);
        super.iY(i2);
        Log.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(i2)));
        if (this.FJe) {
            AppMethodBeat.o(230895);
            return;
        }
        this.FJe = true;
        this.dtM.invoke(Boolean.TRUE);
        AppMethodBeat.o(230895);
    }
}
