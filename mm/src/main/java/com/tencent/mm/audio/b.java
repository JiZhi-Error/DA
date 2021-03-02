package com.tencent.mm.audio;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B*\u0012#\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "isRequestBluetoothStart", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "startRecordHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "plugin-audiologic_release"})
public final class b extends d {
    public static final a dtN = new a((byte) 0);
    private final MMHandler dtK = new MMHandler(new C0270b(this));
    private boolean dtL;
    kotlin.g.a.b<? super Boolean, x> dtM;

    static {
        AppMethodBeat.i(187347);
        AppMethodBeat.o(187347);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/audio/SceneVoiceRecorderAudioManager$Companion;", "", "()V", "TAG", "", "plugin-audiologic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(kotlin.g.a.b<? super Boolean, x> bVar) {
        p.h(bVar, "onStartRecord");
        AppMethodBeat.i(187346);
        this.dtM = bVar;
        com.tencent.mm.plugin.audio.d.b.cet();
        com.tencent.mm.plugin.audio.d.d.cet();
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "record");
        AppMethodBeat.o(187346);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    /* renamed from: com.tencent.mm.audio.b$b  reason: collision with other inner class name */
    static final class C0270b implements MMHandler.Callback {
        final /* synthetic */ b dtO;

        C0270b(b bVar) {
            this.dtO = bVar;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(187342);
            this.dtO.dtM.invoke(Boolean.FALSE);
            AppMethodBeat.o(187342);
            return false;
        }
    }

    public final void Yo() {
        AppMethodBeat.i(187343);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "record");
        Log.i("MicroMsg.SceneVoiceRecorderAudioManager", "some one has been request audio to record");
        a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
        com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
        if (com.tencent.mm.plugin.audio.d.b.cee()) {
            com.tencent.mm.plugin.audio.d.b bVar2 = com.tencent.mm.plugin.audio.d.b.oIo;
            if (com.tencent.mm.plugin.audio.d.b.ceu()) {
                if (isBluetoothScoOn()) {
                    this.dtL = true;
                    this.dtM.invoke(Boolean.TRUE);
                    b("record", (Integer) 1);
                    AppMethodBeat.o(187343);
                    return;
                }
                this.dtL = true;
                if (b("record", (Integer) 4) != -1) {
                    this.dtK.sendEmptyMessageDelayed(0, 1000);
                    AppMethodBeat.o(187343);
                    return;
                }
                this.dtM.invoke(Boolean.TRUE);
                AppMethodBeat.o(187343);
                return;
            }
        }
        this.dtM.invoke(Boolean.TRUE);
        AppMethodBeat.o(187343);
    }

    public final void Yp() {
        AppMethodBeat.i(187344);
        this.dtK.removeCallbacksAndMessages(null);
        if (this.dtL) {
            agq("record");
            this.dtL = false;
        }
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("record");
        AppMethodBeat.o(187344);
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        T t;
        boolean z;
        AppMethodBeat.i(187345);
        super.iY(i2);
        switch (i2) {
            case 2:
            case 3:
                this.dtK.removeCallbacksAndMessages(null);
                p.h("record", "type");
                Iterator<T> it = this.oHP.iterator();
                while (true) {
                    if (it.hasNext()) {
                        t = it.next();
                        if (p.j(t, "record")) {
                        }
                    } else {
                        t = null;
                    }
                }
                if (t != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Log.i("MicroMsg.SceneVoiceRecorderAudioManager", "checkIfSomeRequestAvailable available");
                    this.dtM.invoke(Boolean.TRUE);
                    break;
                }
                break;
        }
        AppMethodBeat.o(187345);
    }
}
