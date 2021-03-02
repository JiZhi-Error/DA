package com.tencent.mm.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010%\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010&\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rJ\u000e\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\rJ\u0006\u0010+\u001a\u00020\nJ\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0006\u0010-\u001a\u00020\rJ\u0016\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\nJ\u0006\u00103\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00065"}, hxF = {"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "context", "Landroid/content/Context;", "onAudioFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "status", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "abandonFocusOnStop", "", "audioFocusListener", "Lcom/tencent/mm/compatible/util/AudioFocusHelper$AudioFocusListener;", "bluetoothResumeSpeaker", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "hasAudioFocus", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "needFocusOnPlay", "player", "Lcom/tencent/mm/modelvoice/IVoicePlayer;", "getPlayer", "()Lcom/tencent/mm/modelvoice/IVoicePlayer;", "setPlayer", "(Lcom/tencent/mm/modelvoice/IVoicePlayer;)V", "value", "speakerOn", "getSpeakerOn", "()Z", "setSpeakerOn", "(Z)V", "onAudioDeviceStateChanged", "onErrorPlaying", "pausePlaying", "abandonFocus", "releaseAudioPlayingDevice", "isContinuousPlay", "requestAudioPlayingDevice", "requestSpeakerOn", "resumePlaying", "startPlay", "filepath", "", "position", "stopPlaying", "unInit", "Companion", "plugin-audiologic_release"})
public final class a extends c {
    public static final C0269a dtI = new C0269a((byte) 0);
    public Context context;
    private boolean dtA = true;
    private boolean dtB = true;
    public boolean dtC;
    private boolean dtD;
    public boolean dtE;
    public d dtF;
    private final b.a dtG;
    private kotlin.g.a.b<? super Integer, x> dtH;
    public com.tencent.mm.compatible.util.b dtz;

    static {
        AppMethodBeat.i(187341);
        AppMethodBeat.o(187341);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/audio/SceneVoicePlayerAudioManager$Companion;", "", "()V", "TAG", "", "plugin-audiologic_release"})
    /* renamed from: com.tencent.mm.audio.a$a  reason: collision with other inner class name */
    public static final class C0269a {
        private C0269a() {
        }

        public /* synthetic */ C0269a(byte b2) {
            this();
        }
    }

    public a(Context context2, kotlin.g.a.b<? super Integer, x> bVar) {
        p.h(context2, "context");
        p.h(bVar, "onAudioFocusChanged");
        AppMethodBeat.i(187340);
        this.dtH = bVar;
        this.context = context2;
        this.dtz = new com.tencent.mm.compatible.util.b(context2);
        com.tencent.mm.plugin.audio.d.b.cet();
        com.tencent.mm.plugin.audio.d.d.cet();
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "music");
        this.dtG = new b(this);
        AppMethodBeat.o(187340);
    }

    public final void cU(boolean z) {
        this.dtE = z;
        this.dtD = z;
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void cV(boolean z) {
        AppMethodBeat.i(187332);
        if (this.dtE == z) {
            AppMethodBeat.o(187332);
            return;
        }
        if (this.dtF != null) {
            d dVar = this.dtF;
            if (dVar == null) {
                AppMethodBeat.o(187332);
                return;
            } else if (dVar.isPlaying()) {
                d dVar2 = this.dtF;
                if (dVar2 != null) {
                    dVar2.cU(z);
                }
                jp(z);
                cU(z);
            }
        }
        AppMethodBeat.o(187332);
    }

    public final void Yl() {
        AppMethodBeat.i(187333);
        d dVar = this.dtF;
        if (dVar != null) {
            dVar.c(this.dtG);
        }
        d dVar2 = this.dtF;
        if (dVar2 != null) {
            dVar2.bhQ();
        }
        if (this.dtA) {
            com.tencent.mm.compatible.util.b bVar = this.dtz;
            if (bVar != null) {
                bVar.a(this.dtG);
            }
            com.tencent.mm.compatible.util.b bVar2 = this.dtz;
            if (bVar2 != null) {
                bVar2.requestFocus();
            }
            this.dtC = true;
        }
        this.dtB = true;
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        if (!a.C0831a.cea().cdW()) {
            b("music", (Integer) 2);
            AppMethodBeat.o(187333);
            return;
        }
        b("music", (Integer) 1);
        AppMethodBeat.o(187333);
    }

    public final void cW(boolean z) {
        AppMethodBeat.i(187334);
        cdV();
        if (!z) {
            agq("music");
        }
        if (this.dtC) {
            com.tencent.mm.compatible.util.b bVar = this.dtz;
            if (bVar != null) {
                bVar.apm();
            }
            com.tencent.mm.compatible.util.b bVar2 = this.dtz;
            if (bVar2 != null) {
                bVar2.b(this.dtG);
            }
            this.dtz = null;
            this.dtC = false;
        }
        AppMethodBeat.o(187334);
    }

    public final void x(String str, int i2) {
        AppMethodBeat.i(187335);
        p.h(str, "filepath");
        d dVar = this.dtF;
        if (dVar == null) {
            p.hyc();
        }
        if (!dVar.c(str, this.dtE, i2)) {
            Log.i("MicroMsg.SceneVoiceAudioManager", "start play error fileName[" + str + "], [" + this.dtE + ']');
            agq("music");
        }
        AppMethodBeat.o(187335);
    }

    public final boolean cX(boolean z) {
        boolean z2;
        AppMethodBeat.i(187336);
        d dVar = this.dtF;
        if (dVar == null) {
            z2 = false;
        } else if (dVar.isPlaying()) {
            d dVar2 = this.dtF;
            z2 = dVar2 != null ? dVar2.da(z) : false;
        } else {
            z2 = false;
        }
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.cea().cdV();
        if (this.dtC) {
            com.tencent.mm.compatible.util.b bVar = this.dtz;
            if (bVar != null) {
                bVar.apm();
            }
            this.dtC = false;
        }
        AppMethodBeat.o(187336);
        return z2;
    }

    public final boolean Ym() {
        AppMethodBeat.i(187337);
        d dVar = this.dtF;
        boolean resume = dVar != null ? dVar.resume() : false;
        if (resume) {
            b("music", (Integer) 2);
            a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
            com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
            if (com.tencent.mm.plugin.audio.d.b.ceb()) {
                cU(false);
            }
            jp(this.dtE);
        }
        if (this.dtC) {
            com.tencent.mm.compatible.util.b bVar2 = this.dtz;
            if (bVar2 != null) {
                bVar2.requestFocus();
            }
            this.dtC = false;
        }
        AppMethodBeat.o(187337);
        return resume;
    }

    public final void Yn() {
        AppMethodBeat.i(187338);
        cdV();
        if (this.dtC && this.dtB) {
            com.tencent.mm.compatible.util.b bVar = this.dtz;
            if (bVar != null) {
                bVar.apm();
            }
            this.dtC = false;
        }
        AppMethodBeat.o(187338);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "focusChange", "", "onChange"})
    static final class b implements b.a {
        final /* synthetic */ a dtJ;

        b(a aVar) {
            this.dtJ = aVar;
        }

        @Override // com.tencent.mm.compatible.util.b.a
        public final void iZ(int i2) {
            AppMethodBeat.i(187331);
            Log.i("MicroMsg.SceneVoiceAudioManager", "on audio focus change: %s", Integer.valueOf(i2));
            this.dtJ.dtH.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(187331);
        }
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        AppMethodBeat.i(187339);
        super.iY(i2);
        switch (i2) {
            case 2:
                cV(false);
                AppMethodBeat.o(187339);
                return;
            case 1:
            case 3:
            case 6:
            case 7:
            case 9:
                cU(this.dtD);
                break;
        }
        AppMethodBeat.o(187339);
    }
}
