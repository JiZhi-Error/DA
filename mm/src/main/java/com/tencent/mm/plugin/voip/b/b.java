package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.os.HandlerThread;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 i2\u00020\u0001:\u0001iB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020?H\u0002J\u0010\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020&H\u0002J\u0010\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020&H\u0002J\b\u0010E\u001a\u00020?H\u0002J\u0010\u0010F\u001a\u00020?2\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0018\u0010F\u001a\u00020?2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0004H\u0002J\n\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0016\u0010K\u001a\u00020?2\u0006\u0010L\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J)\u0010M\u001a\u00020?2!\u0010N\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Q\u0012\u0004\u0012\u00020\u00060!J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020&H\u0016J\u000e\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020\u0004J\u000e\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u00020\u0004J\u0006\u0010X\u001a\u00020?J\u0006\u0010Y\u001a\u00020?J\u000e\u0010Z\u001a\u00020?2\u0006\u0010-\u001a\u00020\u0004J\u001e\u0010[\u001a\u00020?2\u0006\u0010\\\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u0004J\u0006\u0010^\u001a\u00020?J\u0010\u0010_\u001a\u00020?2\u0006\u0010-\u001a\u00020\u0004H\u0016J\u000e\u0010`\u001a\u00020?2\u0006\u0010a\u001a\u00020\u0004J\b\u0010b\u001a\u00020?H\u0002J\u0016\u0010c\u001a\u00020?2\u0006\u0010L\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010d\u001a\u00020?J\u0010\u0010e\u001a\u00020?2\u0006\u0010f\u001a\u00020&H\u0002J\u0006\u0010g\u001a\u00020?J\u0006\u0010h\u001a\u00020?R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R(\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010.@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "asyncRingPlayer", "", "deviceSwitchNearScreenTick", "", "getDeviceSwitchNearScreenTick", "()J", "setDeviceSwitchNearScreenTick", "(J)V", "deviceTotalNearScreenTime", "getDeviceTotalNearScreenTime", "setDeviceTotalNearScreenTime", "hasSkip", "isAllowToResponseMike", "isCheckBluetoothEnd", "isOutCall", "isSystemPhoneRing", "()Z", "setSystemPhoneRing", "(Z)V", "lastIsDeviceNear", "getLastIsDeviceNear", "setLastIsDeviceNear", "lastScreenSensorTick", "getLastScreenSensorTick", "setLastScreenSensorTick", "lastShakeTime", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "mBTRecoverSpeakerOn", "mEventCallback", "Lkotlin/Function1;", "mHSRecoverSpeakerOn", "mIgnoreBluetooth", "mIsMute", "mIsScreenOff", "", "mIsSpeakerOn", "mSensorHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mStateMachine", "Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "mUIType", "value", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "mVoIPUi", "getMVoIPUi", "()Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "setMVoIPUi", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUI;)V", "mVoicePlayDevice", "ringPlayerHandler", "ringPlayerThread", "Landroid/os/HandlerThread;", "sensorController", "Lcom/tencent/mm/sdk/platformtools/SensorController;", "sensorListener", "Lcom/tencent/mm/sdk/platformtools/SensorController$SensorEventCallBack;", "shakeManager", "Lcom/tencent/mm/sdk/platformtools/ShakeManager;", "checkClean", "", "checkStartRingAsyncThread", "doPlayRingSound", "type", "doStartRing", "ringType", "doStopRing", "enableSpeaker", "speakerOn", "ignoreBluetooth", "getContext", "Landroid/content/Context;", "initParams", "isVideoCall", "initSensorListener", "eventCallback", "Lkotlin/ParameterName;", "name", "isOn", "onAudioDeviceStateChanged", "status", "onSensorEvent", "isON", "playRingSound", "mIsVideoCall", "refreshBTStatus", "releaseAudioPlayingDevice", "requestAudioMute", "requestAudioPlayingDevice", "isSwitchVoice", "useLastedDevice", "requestRingPlayerDevice", "requestSpeakerOn", "responseScreenOn", "isScreenOn", "setSpeakerAfterBluetoothDisconnected", "startVoIPRing", "stopVoIPRing", "switchVoicePlayDevice", "newDevice", "unInit", "unInitSensorListener", "Companion", "plugin-voip_release"})
public final class b extends com.tencent.mm.plugin.audio.b.e {
    public static final a HgF = new a((byte) 0);
    public l GTW;
    private boolean GUA;
    private boolean GUH;
    public boolean GUT;
    private int GUk = 1;
    public boolean GZs;
    private boolean HgA;
    private HandlerThread HgB;
    private MMHandler HgC;
    private MMHandler HgD;
    public boolean HgE;
    private SensorController.SensorEventCallBack Hgq;
    private kotlin.g.a.b<? super Boolean, Long> Hgr;
    long Hgs = -1;
    boolean Hgt;
    public long Hgu;
    long Hgv = -1;
    private boolean Hgw;
    public boolean Hgx;
    private volatile com.tencent.mm.plugin.voip.ui.b Hgy;
    private boolean Hgz;
    private com.tencent.mm.compatible.util.b dtz = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    private long lastShakeTime = -1;
    private boolean mIsMute;
    private int mUIType;
    private boolean qUo;
    private ShakeManager qUp;
    private SensorController qUq;

    static {
        AppMethodBeat.i(236031);
        AppMethodBeat.o(236031);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class f extends q implements kotlin.g.a.b {
        final /* synthetic */ b HgG;
        final /* synthetic */ boolean HgL;
        final /* synthetic */ boolean HgM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(b bVar, boolean z, boolean z2) {
            super(1);
            this.HgG = bVar;
            this.HgL = z;
            this.HgM = z2;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(Object obj) {
            AppMethodBeat.i(236005);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "the bluetooth is connected available and start voip ring and ret is ".concat(String.valueOf(booleanValue)));
            com.tencent.mm.plugin.voip.c.fFg().bk(this.HgL ? 0 : 1, this.HgM);
            this.HgG.oHR = null;
            if (!booleanValue && this.HgG.GUk == 4) {
                b.c(this.HgG);
            }
            AppMethodBeat.o(236005);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b() {
        boolean z;
        AppMethodBeat.i(236030);
        com.tencent.mm.compatible.util.b bVar = this.dtz;
        if (bVar != null) {
            bVar.requestFocus();
        }
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "voip");
        com.tencent.mm.plugin.audio.d.b.cet();
        com.tencent.mm.plugin.audio.d.d.cet();
        com.tencent.mm.plugin.audio.broadcast.bluetooth.a.agp("voip");
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_ringplayer_async, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.HgA = z;
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "asyncRingPlayer:" + this.HgA);
        this.HgD = new MMHandler("mSensorHandler");
        AppMethodBeat.o(236030);
    }

    public static final /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(236032);
        bVar.fJM();
        AppMethodBeat.o(236032);
    }

    public final void b(com.tencent.mm.plugin.voip.ui.b bVar) {
        AppMethodBeat.i(236007);
        this.Hgy = bVar;
        com.tencent.mm.plugin.voip.ui.b bVar2 = this.Hgy;
        if (bVar2 != null) {
            bVar2.setVoicePlayDevice(this.GUk);
        }
        com.tencent.mm.plugin.voip.ui.b bVar3 = this.Hgy;
        if (bVar3 != null) {
            bVar3.setMute(this.mIsMute);
            AppMethodBeat.o(236007);
            return;
        }
        AppMethodBeat.o(236007);
    }

    public final void unInit() {
        AppMethodBeat.i(236008);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("voip");
        fJP();
        MMHandler mMHandler = this.HgD;
        if (mMHandler != null) {
            mMHandler.quitSafely();
        }
        this.HgD = null;
        AppMethodBeat.o(236008);
    }

    public final void onSensorEvent(boolean z) {
        Long invoke;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(236009);
        Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", Boolean.valueOf(z), Boolean.valueOf(this.Hgt), Long.valueOf(this.Hgs));
        if (this.GTW == null) {
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent, not create stateMachine yet, ignore");
            AppMethodBeat.o(236009);
            return;
        }
        l lVar = this.GTW;
        if (lVar == null) {
            p.hyc();
        }
        if (k.adQ(lVar.getState()) || this.GUk != 2) {
            fJP();
            AppMethodBeat.o(236009);
        } else if (this.qUo) {
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.qUo = z2;
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent has skip and val is %s", Boolean.valueOf(this.qUo));
            AppMethodBeat.o(236009);
        } else if (Math.abs(Util.currentTicks() - this.Hgv) < 500 && this.Hgv != -1) {
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent time interval too small");
            AppMethodBeat.o(236009);
        } else if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_response_acc, true) || z || this.lastShakeTime == -1 || Util.ticksToNow(this.lastShakeTime) <= 400) {
            this.qUo = false;
            l lVar2 = this.GTW;
            if (lVar2 != null) {
                if (k.adP(lVar2.getState()) && (this.Hgt != z || this.Hgs == -1)) {
                    if (!this.Hgt && z && !k.adQ(lVar2.getState()) && this.mUIType != 2 && this.Hgs != -1) {
                        long ticksToNow = Util.ticksToNow(this.Hgs);
                        Log.i("MicroMsg.VoIP.VoIPAudioManager", "accumulate near screen time: %s", Long.valueOf(ticksToNow));
                        this.Hgu = ticksToNow + this.Hgu;
                    }
                    this.Hgs = Util.currentTicks();
                    this.Hgt = z;
                }
                kotlin.g.a.b<? super Boolean, Long> bVar = this.Hgr;
                if (!(bVar == null || (invoke = bVar.invoke(Boolean.valueOf(z))) == null)) {
                    if (invoke.longValue() == -1) {
                        z3 = false;
                    }
                    if (!z3) {
                        invoke = null;
                    }
                    if (invoke != null) {
                        this.Hgv = invoke.longValue();
                        AppMethodBeat.o(236009);
                        return;
                    }
                }
                AppMethodBeat.o(236009);
                return;
            }
            AppMethodBeat.o(236009);
        } else {
            this.qUo = true;
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "onSensorEvent has skip case shake near to small");
            AppMethodBeat.o(236009);
        }
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        boolean z;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        AppMethodBeat.i(236010);
        super.iY(i2);
        if (!this.oHP.isEmpty() || (i2 == 9 && i2 == 8)) {
            switch (i2) {
                case 1:
                case 3:
                case 6:
                case 7:
                    if (!this.GUT) {
                        fJM();
                        this.GUH = true;
                        AppMethodBeat.o(236010);
                        return;
                    }
                    break;
                case 2:
                    this.GUA = false;
                    l lVar = this.GTW;
                    if (lVar != null) {
                        if (!k.adQ(lVar.getState())) {
                            if (1 == this.GUk) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            this.Hgx = z3;
                        }
                        u fFg = com.tencent.mm.plugin.voip.c.fFg();
                        p.g(fFg, "SubCoreVoip.getVoipService()");
                        a(false, fFg.bhV(), false);
                        com.tencent.mm.plugin.voip.c.fFg().wS(false);
                        com.tencent.mm.plugin.voip.c.fFg().xe(false);
                        adD(4);
                        this.GUA = false;
                        com.tencent.mm.plugin.voip.c.fFg().ry(true);
                        AppMethodBeat.o(236010);
                        return;
                    }
                    AppMethodBeat.o(236010);
                    return;
                case 8:
                    a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
                    com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
                    Log.i("MicroMsg.VoIP.VoIPAudioManager", "headset connected and bluetooth: %s", Boolean.valueOf(com.tencent.mm.plugin.audio.d.b.cee()));
                    if (3 == this.GUk) {
                        Log.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
                        AppMethodBeat.o(236010);
                        return;
                    }
                    l lVar2 = this.GTW;
                    if (lVar2 != null) {
                        if (k.adQ(lVar2.getState())) {
                            this.GUk = 3;
                        } else {
                            if (1 == this.GUk) {
                                z = true;
                            } else {
                                z = false;
                            }
                            this.Hgw = z;
                            this.GUk = 3;
                        }
                        if (this.GUk == 1) {
                            aK(true, true);
                        } else {
                            aK(false, true);
                        }
                        com.tencent.mm.plugin.voip.c.fFg().ry(true);
                        adD(this.GUk);
                        AppMethodBeat.o(236010);
                        return;
                    }
                    break;
                case 9:
                    com.tencent.mm.plugin.audio.d.b bVar2 = com.tencent.mm.plugin.audio.d.b.oIo;
                    boolean cee = com.tencent.mm.plugin.audio.d.b.cee();
                    Log.i("MicroMsg.VoIP.VoIPAudioManager", "headset disconnected and  bluetooth: %s", Boolean.valueOf(cee));
                    if (3 != this.GUk) {
                        Log.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
                        AppMethodBeat.o(236010);
                        return;
                    }
                    l lVar3 = this.GTW;
                    if (lVar3 != null) {
                        if (k.adQ(lVar3.getState())) {
                            if (cee) {
                                b("voip", (Integer) 4);
                                i4 = 4;
                            } else {
                                u fFg2 = com.tencent.mm.plugin.voip.c.fFg();
                                p.g(fFg2, "SubCoreVoip.getVoipService()");
                                if (fFg2.czl()) {
                                    Context context = getContext();
                                    Context context2 = getContext();
                                    Toast.makeText(context, context2 != null ? context2.getString(R.string.i4v) : null, 0).show();
                                    i4 = 1;
                                } else if (!this.GZs) {
                                    i4 = 1;
                                } else {
                                    i4 = 2;
                                }
                            }
                            this.GUk = i4;
                        } else if (cee) {
                            if (1 == this.GUk) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            this.Hgw = z2;
                            this.GUk = 4;
                            b("voip", (Integer) 4);
                        } else {
                            u fFg3 = com.tencent.mm.plugin.voip.c.fFg();
                            p.g(fFg3, "SubCoreVoip.getVoipService()");
                            if (fFg3.czl()) {
                                if (this.Hgw || 2 == this.mUIType) {
                                    Context context3 = getContext();
                                    Context context4 = getContext();
                                    Toast.makeText(context3, context4 != null ? context4.getString(R.string.i4v) : null, 0).show();
                                    i3 = 1;
                                } else {
                                    Context context5 = getContext();
                                    Context context6 = getContext();
                                    Toast.makeText(context5, context6 != null ? context6.getString(R.string.i4u) : null, 0).show();
                                    i3 = 2;
                                }
                                this.GUk = i3;
                                this.Hgw = false;
                            } else if (this.GZs) {
                            }
                        }
                        if (this.GUk == 1) {
                            aK(true, true);
                        } else {
                            xo(false);
                        }
                        com.tencent.mm.plugin.voip.c.fFg().ry(false);
                        adD(this.GUk);
                        AppMethodBeat.o(236010);
                        return;
                    }
                    AppMethodBeat.o(236010);
                    return;
            }
            AppMethodBeat.o(236010);
            return;
        }
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "no situation need to respone this event ".concat(String.valueOf(i2)));
        AppMethodBeat.o(236010);
    }

    private final void adD(int i2) {
        AppMethodBeat.i(236011);
        Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "switchVoicePlayDevice: %s and before is %s", Integer.valueOf(i2), Integer.valueOf(this.GUk));
        this.GUk = i2;
        com.tencent.mm.plugin.voip.ui.b bVar = this.Hgy;
        if (bVar != null) {
            bVar.setVoicePlayDevice(this.GUk);
            AppMethodBeat.o(236011);
            return;
        }
        AppMethodBeat.o(236011);
    }

    private final void xo(boolean z) {
        AppMethodBeat.i(236012);
        aK(z, this.GUH);
        AppMethodBeat.o(236012);
    }

    private final void aK(boolean z, boolean z2) {
        AppMethodBeat.i(236013);
        Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "enableSpeaker: %s, ignoreBluetooth: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (!z2) {
            a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
            com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
            if (com.tencent.mm.plugin.audio.d.b.ceb()) {
                z = false;
            }
        }
        if (ae.gKu.gDA) {
            ae.gKu.dump();
            if (ae.gKu.gDB > 0) {
                com.tencent.mm.plugin.voip.c.fFg().wS(z);
            }
        }
        if (ae.gKu.gEh >= 0 || ae.gKu.gEi >= 0) {
            com.tencent.mm.plugin.voip.c.fFg().wS(z);
        }
        u fFg = com.tencent.mm.plugin.voip.c.fFg();
        p.g(fFg, "SubCoreVoip.getVoipService()");
        a(z, fFg.bhV(), z2);
        com.tencent.mm.plugin.voip.c.fFg().xe(z);
        this.Hgz = z;
        AppMethodBeat.o(236013);
    }

    private final void fJM() {
        Boolean bool;
        int i2;
        int i3 = 3;
        AppMethodBeat.i(236014);
        boolean AY = AY(3);
        Object[] objArr = new Object[6];
        objArr[0] = Boolean.valueOf(this.GUA);
        if (this.GTW != null) {
            l lVar = this.GTW;
            if (lVar == null) {
                p.hyc();
            }
            bool = Boolean.valueOf(k.adQ(lVar.getState()));
        } else {
            bool = null;
        }
        objArr[1] = bool;
        u fFg = com.tencent.mm.plugin.voip.c.fFg();
        p.g(fFg, "SubCoreVoip.getVoipService()");
        objArr[2] = Boolean.valueOf(fFg.czl());
        objArr[3] = Boolean.valueOf(this.Hgx);
        objArr[4] = Boolean.valueOf(2 == this.mUIType);
        objArr[5] = Boolean.valueOf(AY);
        Log.i("MicroMsg.VoIP.VoIPAudioManager", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", objArr);
        if (!this.GUA) {
            l lVar2 = this.GTW;
            if (lVar2 != null) {
                if (k.adQ(lVar2.getState())) {
                    if (!AY) {
                        i2 = 1;
                    } else {
                        i2 = 3;
                    }
                    this.GUk = i2;
                } else {
                    u fFg2 = com.tencent.mm.plugin.voip.c.fFg();
                    p.g(fFg2, "SubCoreVoip.getVoipService()");
                    if (!fFg2.czl()) {
                        if (!AY(3)) {
                            if (!this.GZs) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                        }
                        this.GUk = i3;
                    } else {
                        if ((this.Hgx || 2 == this.mUIType) && !AY) {
                            i3 = 1;
                        } else if (!AY) {
                            i3 = 2;
                        }
                        this.GUk = i3;
                        this.Hgx = false;
                    }
                }
            }
            if (this.GUk == 1) {
                aK(true, true);
            } else {
                xo(false);
            }
            switch (this.GUk) {
                case 2:
                    cdU();
                    break;
                case 3:
                    jt(true);
                    break;
            }
            adD(this.GUk);
            this.GUA = true;
            com.tencent.mm.plugin.voip.c.fFg().ry(false);
        }
        AppMethodBeat.o(236014);
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void cV(boolean z) {
        int i2;
        AppMethodBeat.i(236015);
        com.tencent.mm.compatible.util.b bVar = this.dtz;
        if (bVar != null) {
            bVar.requestFocus();
        }
        super.cV(z);
        adD(cdY() != -1 ? cdY() : this.GUk);
        u fFg = com.tencent.mm.plugin.voip.c.fFg();
        p.g(fFg, "SubCoreVoip.getVoipService()");
        if (!fFg.czl()) {
            com.tencent.mm.plugin.voip.c.fFg().xf(z);
        } else {
            xo(z);
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[3];
        objArr[0] = 2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = 0;
        hVar.a(11080, objArr);
        AppMethodBeat.o(236015);
    }

    public final void xp(boolean z) {
        int i2 = 1;
        AppMethodBeat.i(236016);
        if (z) {
            com.tencent.mm.plugin.voip.c.fFg().fHW();
            com.tencent.mm.plugin.voip.c.fFg().adf(9);
            com.tencent.mm.plugin.voip.c.fFg().xd(true);
        } else {
            com.tencent.mm.plugin.voip.c.fFg().fHX();
            com.tencent.mm.plugin.voip.c.fFg().adf(8);
            com.tencent.mm.plugin.voip.c.fFg().xd(false);
        }
        this.mIsMute = z;
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[3];
        objArr[0] = 2;
        objArr[1] = 0;
        if (z) {
            i2 = 2;
        }
        objArr[2] = Integer.valueOf(i2);
        hVar.a(11080, objArr);
        AppMethodBeat.o(236016);
    }

    public final void aL(boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(236017);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        if (a.C0831a.cea().cdW()) {
            i2 = 3;
        } else {
            a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
            com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
            if (com.tencent.mm.plugin.audio.d.b.cee()) {
                a.C0831a aVar3 = com.tencent.mm.plugin.audio.c.a.oIh;
                if (a.C0831a.cec()) {
                    i2 = 4;
                }
            }
            i2 = z ? 1 : 2;
        }
        this.GUk = i2;
        this.GZs = z2;
        this.Hgx = z;
        AppMethodBeat.o(236017);
    }

    public final void xq(boolean z) {
        AppMethodBeat.i(236018);
        fJO();
        adE(z ? 0 : 1);
        AppMethodBeat.o(236018);
    }

    private final void adE(int i2) {
        HandlerThread handlerThread;
        AppMethodBeat.i(236019);
        if (!this.HgA || (handlerThread = this.HgB) == null || !handlerThread.isAlive() || this.HgC == null) {
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync play sound");
            com.tencent.mm.plugin.voip.c.fFg().ado(i2);
            AppMethodBeat.o(236019);
            return;
        }
        MMHandler mMHandler = this.HgC;
        if (mMHandler != null) {
            mMHandler.post(new RunnableC1889b(i2));
            AppMethodBeat.o(236019);
            return;
        }
        AppMethodBeat.o(236019);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.voip.b.b$b  reason: collision with other inner class name */
    public static final class RunnableC1889b implements Runnable {
        final /* synthetic */ int $type;

        RunnableC1889b(int i2) {
            this.$type = i2;
        }

        public final void run() {
            AppMethodBeat.i(235998);
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "async play sound");
            com.tencent.mm.plugin.voip.c.fFg().ado(this.$type);
            AppMethodBeat.o(235998);
        }
    }

    public final void aM(boolean z, boolean z2) {
        boolean z3 = false;
        AppMethodBeat.i(236020);
        com.tencent.mm.compatible.util.b bVar = this.dtz;
        if (bVar != null) {
            bVar.requestFocus();
        }
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        com.tencent.mm.plugin.audio.d.b bVar2 = com.tencent.mm.plugin.audio.d.b.oIo;
        if (com.tencent.mm.plugin.audio.d.b.ceb()) {
            a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
            if (a.C0831a.cec()) {
                b("voip", (Integer) 4);
                xo(false);
                AppMethodBeat.o(236020);
                return;
            }
        }
        a.C0831a aVar3 = com.tencent.mm.plugin.audio.c.a.oIh;
        if (a.C0831a.cea().cdW()) {
            b("voip", (Integer) 3);
            xo(false);
            AppMethodBeat.o(236020);
            return;
        }
        boolean z4 = 1 == this.GUk;
        if (z && !this.HgE) {
            b("voip", (Integer) 2);
        } else if (z2) {
            b("voip", (Integer) 1);
            z3 = true;
        } else {
            b("voip", Integer.valueOf(this.GUk));
            z3 = z4;
        }
        cV(z3);
        AppMethodBeat.o(236020);
    }

    public final void fJN() {
        AppMethodBeat.i(236021);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
        if (com.tencent.mm.plugin.audio.d.b.cee()) {
            b("voip", (Integer) 4);
            AppMethodBeat.o(236021);
            return;
        }
        a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
        if (a.C0831a.cea().cdW()) {
            b("voip", (Integer) 3);
            AppMethodBeat.o(236021);
            return;
        }
        b("voip", (Integer) 2);
        AppMethodBeat.o(236021);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ b HgG;
        final /* synthetic */ int HgH;

        c(b bVar, int i2) {
            this.HgG = bVar;
            this.HgH = i2;
        }

        public final void run() {
            AppMethodBeat.i(235999);
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "async start ring player");
            com.tencent.mm.plugin.voip.c.fFg().bk(this.HgH, this.HgG.GZs);
            AppMethodBeat.o(235999);
        }
    }

    public final void fFK() {
        AppMethodBeat.i(236023);
        fJO();
        this.oHR = null;
        AppMethodBeat.o(236023);
    }

    private final void fJO() {
        HandlerThread handlerThread;
        AppMethodBeat.i(236024);
        if (!this.HgA || (handlerThread = this.HgB) == null || !handlerThread.isAlive() || this.HgC == null) {
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync stop ring player");
            com.tencent.mm.plugin.voip.c.fFg().stopRing();
            AppMethodBeat.o(236024);
            return;
        }
        MMHandler mMHandler = this.HgC;
        if (mMHandler != null) {
            mMHandler.post(d.HgI);
            AppMethodBeat.o(236024);
            return;
        }
        AppMethodBeat.o(236024);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        public static final d HgI = new d();

        static {
            AppMethodBeat.i(236001);
            AppMethodBeat.o(236001);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(236000);
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "async stop ring player");
            com.tencent.mm.plugin.voip.c.fFg().stopRing();
            AppMethodBeat.o(236000);
        }
    }

    public final void fFV() {
        AppMethodBeat.i(236025);
        com.tencent.mm.compatible.util.b bVar = this.dtz;
        if (bVar != null) {
            bVar.apm();
        }
        fJO();
        cdV();
        AppMethodBeat.o(236025);
    }

    public final void elB() {
        AppMethodBeat.i(236026);
        agq("voip");
        fJO();
        if (this.HgA) {
            HandlerThread handlerThread = this.HgB;
            if (handlerThread == null) {
                AppMethodBeat.o(236026);
                return;
            } else if (handlerThread.isAlive()) {
                Log.i("MicroMsg.VoIP.VoIPAudioManager", "release quit ring player thread");
                HandlerThread handlerThread2 = this.HgB;
                if (handlerThread2 != null) {
                    handlerThread2.quitSafely();
                }
                this.HgB = null;
            }
        }
        AppMethodBeat.o(236026);
    }

    private final Context getContext() {
        com.tencent.mm.plugin.voip.ui.b bVar;
        Context context = null;
        AppMethodBeat.i(236027);
        if (!(this.Hgy == null || (bVar = this.Hgy) == null)) {
            context = bVar.fJl();
        }
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        AppMethodBeat.o(236027);
        return context;
    }

    public final void ad(kotlin.g.a.b<? super Boolean, Long> bVar) {
        AppMethodBeat.i(260045);
        p.h(bVar, "eventCallback");
        fJP();
        MMHandler mMHandler = this.HgD;
        if (mMHandler != null) {
            mMHandler.post(new e(this, bVar));
            AppMethodBeat.o(260045);
            return;
        }
        AppMethodBeat.o(260045);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ b HgG;
        final /* synthetic */ kotlin.g.a.b HgJ;

        e(b bVar, kotlin.g.a.b bVar2) {
            this.HgG = bVar;
            this.HgJ = bVar2;
        }

        public final void run() {
            long j2;
            AppMethodBeat.i(236004);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            this.HgG.qUq = new SensorController(context);
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "initMgr setSensorCallBack context is ".concat(String.valueOf(context)));
            this.HgG.Hgq = new SensorController.SensorEventCallBack(this) {
                /* class com.tencent.mm.plugin.voip.b.b.e.AnonymousClass1 */
                final /* synthetic */ e HgK;

                {
                    this.HgK = r1;
                }

                @Override // com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack
                public final void onSensorEvent(boolean z) {
                    AppMethodBeat.i(236003);
                    this.HgK.HgG.onSensorEvent(z);
                    AppMethodBeat.o(236003);
                }
            };
            SensorController sensorController = this.HgG.qUq;
            if (sensorController == null) {
                p.hyc();
            }
            sensorController.setSensorCallBack(this.HgG.Hgq);
            if (this.HgG.qUp == null) {
                b bVar = this.HgG;
                ShakeManager shakeManager = new ShakeManager(context);
                b bVar2 = this.HgG;
                if (shakeManager.startShake(new a(this))) {
                    j2 = 0;
                } else {
                    j2 = -1;
                }
                bVar2.lastShakeTime = j2;
                bVar.qUp = shakeManager;
            }
            this.HgG.Hgr = this.HgJ;
            AppMethodBeat.o(236004);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/voip/util/VoIPAudioManager$initSensorListener$1$2$callback$1"})
        static final class a implements Runnable {
            final /* synthetic */ e HgK;

            a(e eVar) {
                this.HgK = eVar;
            }

            public final void run() {
                AppMethodBeat.i(236002);
                this.HgK.HgG.lastShakeTime = Util.currentTicks();
                Log.i("MicroMsg.VoIP.VoIPAudioManager", "device happened shake in time,%s", Long.valueOf(this.HgK.HgG.lastShakeTime));
                AppMethodBeat.o(236002);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ b HgG;

        g(b bVar) {
            this.HgG = bVar;
        }

        public final void run() {
            AppMethodBeat.i(236006);
            if (this.HgG.qUq != null) {
                Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "removeSensorCallBack", new Object[0]);
                SensorController sensorController = this.HgG.qUq;
                if (sensorController != null) {
                    sensorController.setSensorCallBack(null);
                }
                SensorController sensorController2 = this.HgG.qUq;
                if (sensorController2 != null) {
                    sensorController2.removeSensorCallBack();
                }
                this.HgG.qUq = null;
                this.HgG.Hgt = false;
                this.HgG.Hgu = 0;
                this.HgG.Hgs = -1;
            }
            if (this.HgG.qUp != null) {
                ShakeManager shakeManager = this.HgG.qUp;
                if (shakeManager == null) {
                    p.hyc();
                }
                shakeManager.stopShake();
            }
            this.HgG.Hgq = null;
            this.HgG.Hgv = -1;
            this.HgG.lastShakeTime = -1;
            AppMethodBeat.o(236006);
        }
    }

    public final void fJP() {
        AppMethodBeat.i(236029);
        MMHandler mMHandler = this.HgD;
        if (mMHandler != null) {
            mMHandler.post(new g(this));
            AppMethodBeat.o(236029);
            return;
        }
        AppMethodBeat.o(236029);
    }

    public final void aN(boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(236022);
        if (!this.oHS) {
            Log.printInfoStack("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing ignore bluetooth or not bt plug", new Object[0]);
            if (z) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (this.HgA) {
                if (this.HgB == null) {
                    HandlerThread handlerThread = new HandlerThread("Voip_RingPlayer");
                    Log.i("MicroMsg.VoIP.VoIPAudioManager", "create voip ring player thread");
                    handlerThread.start();
                    this.HgC = new MMHandler(handlerThread.getLooper());
                    this.HgB = handlerThread;
                }
                MMHandler mMHandler = this.HgC;
                if (mMHandler != null) {
                    mMHandler.post(new c(this, i2));
                }
            } else {
                Log.i("MicroMsg.VoIP.VoIPAudioManager", "sync start ring player");
                com.tencent.mm.plugin.voip.c.fFg().bk(i2, this.GZs);
            }
            if (this.GUk == 4) {
                fJM();
                AppMethodBeat.o(236022);
                return;
            }
        } else {
            Log.i("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing but waitting the bt connected");
            this.oHR = new f(this, z, z2);
        }
        AppMethodBeat.o(236022);
    }
}
