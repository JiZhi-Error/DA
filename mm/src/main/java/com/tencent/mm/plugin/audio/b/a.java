package com.tencent.mm.plugin.audio.b;

import android.media.AudioManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.audio.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 b2\u00020\u0001:\u0001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\nH\u0002J\u000e\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u001cJ\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\nH\u0002J\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\nJ\u0006\u00102\u001a\u00020\nJ\u0006\u00103\u001a\u00020\u001cJ\u000e\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nJ\u000e\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\fJ\u000e\u00108\u001a\u00020\n2\u0006\u00105\u001a\u00020\nJ\u0006\u00109\u001a\u00020\u0004J\u0010\u0010:\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u001cH\u0002J\u000e\u0010;\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u001cJ\u0006\u0010<\u001a\u00020\u000fJ\u0006\u0010=\u001a\u00020\fJ\u0006\u0010>\u001a\u00020\fJ\u0006\u0010?\u001a\u00020\fJ\u000e\u0010@\u001a\u00020\f2\u0006\u0010.\u001a\u00020\nJ\b\u0010A\u001a\u00020\fH\u0016J\u0010\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\nH\u0007J\u0006\u0010D\u001a\u00020\fJ\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\nH\u0016J\u0006\u0010G\u001a\u00020\u000fJ\u0018\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\f2\u0006\u0010.\u001a\u00020\nH\u0002J\u000e\u0010J\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001cJ\u001d\u0010K\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001c2\b\u0010L\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fJ\u0010\u0010O\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u000e\u0010P\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010Q\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fJ\u0010\u0010R\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0006\u0010S\u001a\u00020\u000fJ\u0006\u0010T\u001a\u00020\u000fJ\"\u0010U\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020\n2\u0012\b\u0002\u0010W\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010XJ\u001e\u0010Y\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\nJ\u0010\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\fH&J\u0018\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\f2\u0006\u0010^\u001a\u00020\fH&J \u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\f2\u0006\u00105\u001a\u00020\n2\u0006\u0010^\u001a\u00020\fH&J\u0010\u0010_\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0002J\u000e\u0010`\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\nJ\u000e\u0010a\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006c"}, hxF = {"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "setAudioManager", "(Landroid/media/AudioManager;)V", "currentAudioMode", "", "isACLConnected", "", "isBluetoothRequestOk", "Lkotlin/Function1;", "", "()Lkotlin/jvm/functions/Function1;", "setBluetoothRequestOk", "(Lkotlin/jvm/functions/Function1;)V", "value", "isBluetoothRequesting", "()Z", "setBluetoothRequesting", "(Z)V", "isScoConnected", "setScoConnected", "mAudioDeviceRequester", "Ljava/util/ArrayList;", "", "getMAudioDeviceRequester", "()Ljava/util/ArrayList;", "setMAudioDeviceRequester", "(Ljava/util/ArrayList;)V", "mCurrentAudioDeviceState", "mDeviceQueue", "Ljava/util/Stack;", "mSetmodeErrorcode", "getMSetmodeErrorcode", "()I", "setMSetmodeErrorcode", "(I)V", "autoPluggingNewDeviceNext", "currentDevice", "checkIfSomeRequestAvailable", "type", "closePrevAudioPlayingDevice", "device", "getBluetoothScoStreamType", "getCurrentPlayingDevice", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "StreamType", "getStreamMode", "speakerOn", "getStreamVolume", "getSystemAudioManager", "hasRequestBluetooth", "hasRequestHeadSet", "initAudioPlayingResource", "isBluetoothScoAvailable", "isBluetoothScoOn", "isHeadsetPlugged", "isSomeOneDevicePlugged", "isSpeakerphoneOn", "isStreamMute", "streamType", "isUsingExternalAudioDevice", "onAudioDeviceStateChanged", "status", "pauseMusic", "refreshAudioPlayingDevice", "isPlugged", "releaseAudioPlayingOrRecordingResource", "requestAudioPlayingOrRecordingResource", "targetDevice", "(Ljava/lang/String;Ljava/lang/Integer;)I", "requestBluetoothOn", "requestEarPieceOn", "requestHeadSetOn", "requestRingSpeakerOn", "requestSpeakerOn", "resetSpeaker", "resumeMusic", "setMode", "mode", "setModeCallBack", "Lkotlin/Function0;", "setStreamVolume", FirebaseAnalytics.b.INDEX, "flags", "shiftSpeaker", "beSpeakerphoneOn", "ignoreBluetooth", "startCurrentAudioPlayingDevice", "volumeDown", "volumeUp", "Companion", "plugin-audio_release"})
public abstract class a {
    public static final C0830a oHT = new C0830a((byte) 0);
    public AudioManager audioManager;
    private boolean gCV;
    public boolean gCW;
    public int gCZ;
    private int oHN = -1;
    private int oHO = -1;
    protected ArrayList<String> oHP = new ArrayList<>();
    private Stack<Integer> oHQ;
    public kotlin.g.a.b<? super Boolean, x> oHR;
    protected boolean oHS;

    public abstract boolean jp(boolean z);

    public a() {
        Object systemService = MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            throw new t("null cannot be cast to non-null type android.media.AudioManager");
        }
        this.audioManager = (AudioManager) systemService;
        this.oHQ = new Stack<>();
    }

    private void jq(boolean z) {
        this.oHS = z;
        kotlin.g.a.b<? super Boolean, x> bVar = this.oHR;
        if (bVar != null) {
            bVar.invoke(Boolean.valueOf(z));
        }
    }

    public void iY(int i2) {
        Log.i("MicroMsg.BaseAudioManager", "onAudioDeviceStateChanged mstatus is " + i2 + " and  mCurrentAudioDeviceState = status " + (this.oHN == i2));
        if (this.oHN != i2) {
            if (!this.oHP.isEmpty() || (i2 == 9 && i2 == 8)) {
                switch (i2) {
                    case 0:
                    case 5:
                        this.gCV = true;
                        h.RTc.a(new b(this), 1000, "delayConnectBluetooth");
                        return;
                    case 1:
                    case 6:
                    case 7:
                        this.gCV = false;
                        js(false);
                        return;
                    case 2:
                        jq(true);
                        js(true);
                        return;
                    case 3:
                        h.RTc.bqo("delayConnectBluetooth");
                        js(false);
                        return;
                    case 4:
                    default:
                        return;
                    case 8:
                        jt(true);
                        return;
                    case 9:
                        jt(false);
                        return;
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a oHU;

        b(a aVar) {
            this.oHU = aVar;
        }

        public final void run() {
            AppMethodBeat.i(223952);
            Log.i("MicroMsg.BaseAudioManager", "dkbt post delay BLUETOOTH_SCO_CONNECTED ");
            com.tencent.mm.plugin.audio.d.b.b(this.oHU.audioManager);
            AppMethodBeat.o(223952);
        }
    }

    public final int b(String str, Integer num) {
        p.h(str, "type");
        Log.printInfoStack("MicroMsg.BaseAudioManager", "requestAudioPlayingOrRecordingResource type " + str + " adn target device " + num, new Object[0]);
        com.tencent.mm.plugin.audio.d.b.cet();
        d.cet();
        if (this.oHP.contains(str)) {
            this.oHP.remove(str);
        }
        this.oHP.add(str);
        if (num != null && num.intValue() == 4) {
            return js(true);
        }
        if (num != null && num.intValue() == 3) {
            jt(true);
            return -1;
        } else if (num != null && num.intValue() == 2) {
            cdU();
            return -1;
        } else if (num == null || num.intValue() != 1) {
            return -1;
        } else {
            cV(true);
            return -1;
        }
    }

    public final void agq(String str) {
        boolean z;
        p.h(str, "type");
        Log.printInfoStack("MicroMsg.BaseAudioManager", "releaseAudioPlayingOrRecordingResource type ".concat(String.valueOf(str)), new Object[0]);
        if (!this.oHP.contains(str) || !this.oHQ.contains(4)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            js(false);
        }
        this.oHQ.clear();
        this.oHP.remove(str);
    }

    public static void cdT() {
        com.tencent.mm.plugin.audio.d.b.cet();
        d.cet();
    }

    private final int w(boolean z, int i2) {
        int i3;
        Log.printInfoStack("MicroMsg.BaseAudioManager", "current refresh audio playing isPlugged %s, and device is  %s", Boolean.valueOf(z), Integer.valueOf(i2));
        if (!this.oHQ.isEmpty() && this.oHQ.size() > 1) {
            Integer num = this.oHQ.get(this.oHQ.size() - 1);
            Integer lastElement = this.oHQ.lastElement();
            if (z) {
                if (num == null || num.intValue() != i2) {
                    p.g(num, "prevDevice");
                    AU(num.intValue());
                }
                return AV(i2);
            }
            AU(i2);
            if (lastElement != null && i2 == lastElement.intValue()) {
                i3 = -1;
            } else {
                p.g(lastElement, "nextDevice");
                i3 = AV(lastElement.intValue());
            }
            return i3;
        } else if (z) {
            return AV(i2);
        } else {
            AU(i2);
            switch (i2) {
                case 1:
                    com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
                    if (com.tencent.mm.plugin.audio.d.b.cee()) {
                        com.tencent.mm.plugin.audio.d.b bVar2 = com.tencent.mm.plugin.audio.d.b.oIo;
                        if (com.tencent.mm.plugin.audio.d.b.ces()) {
                            return -1;
                        }
                    }
                    d dVar = d.oIq;
                    if (d.f(this.audioManager)) {
                        return -1;
                    }
                    cdU();
                    return -1;
                default:
                    return -1;
            }
        }
    }

    private final void AU(int i2) {
        Log.printInfoStack("MicroMsg.BaseAudioManager", "close prev audio playing device %s", Integer.valueOf(i2));
        switch (i2) {
            case 1:
                this.audioManager.setSpeakerphoneOn(false);
                return;
            case 2:
            default:
                return;
            case 3:
                d dVar = d.oIq;
                d.jw(false);
                return;
            case 4:
                this.gCW = false;
                com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
                com.tencent.mm.plugin.audio.d.b.jw(false);
                com.tencent.mm.plugin.audio.d.b.c(this.audioManager);
                h.RTc.bqo("delayConnectBluetooth");
                return;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final int AV(int i2) {
        boolean z;
        boolean z2 = true;
        Log.printInfoStack("MicroMsg.BaseAudioManager", "start current audio playing device %s", Integer.valueOf(i2));
        switch (i2) {
            case 1:
                this.audioManager.setSpeakerphoneOn(true);
                break;
            case 2:
                this.audioManager.setSpeakerphoneOn(false);
                return -1;
            case 3:
                if (this.oHQ.contains(4)) {
                    AU(4);
                }
                d dVar = d.oIq;
                d.jw(true);
                return -1;
            case 4:
                if (this.gCW) {
                    return 1;
                }
                h.RTc.bqo("delayConnectBluetooth");
                int b2 = com.tencent.mm.plugin.audio.d.b.b(this.audioManager);
                if (b2 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.gCW = z;
                com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
                if (b2 != 1) {
                    z2 = false;
                }
                com.tencent.mm.plugin.audio.d.b.jw(z2);
                return b2;
        }
        return -1;
    }

    public final void jr(boolean z) {
        this.audioManager.setSpeakerphoneOn(z);
    }

    public void cV(boolean z) {
        Log.printInfoStack("MicroMsg.BaseAudioManager", "request speaker on value %s", Boolean.valueOf(z));
        if (z) {
            Log.i("MicroMsg.BaseAudioManager", "isSpeakerphoneOn is " + isSpeakerphoneOn() + " and ret is " + e.f(this.oHQ));
            w(true, 1);
            return;
        }
        e.g(this.oHQ);
        x xVar = x.SXb;
        w(false, 1);
    }

    public final int js(boolean z) {
        boolean z2;
        int i2 = -1;
        Log.printInfoStack("MicroMsg.BaseAudioManager", "request bluetooth on value %s", Boolean.valueOf(z));
        if (!z) {
            jq(false);
            com.tencent.mm.plugin.audio.d.b.b(this.oHQ);
            x xVar = x.SXb;
            w(false, 4);
        } else if (com.tencent.mm.plugin.audio.d.b.a(this.oHQ)) {
            int w = w(true, 4);
            if (w != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            jq(z2);
            i2 = w;
        } else {
            jq(false);
        }
        Log.i("MicroMsg.BaseAudioManager", "request bluetooth failed %s", Integer.valueOf(i2));
        return i2;
    }

    public final void jt(boolean z) {
        if (!z) {
            d.e(this.oHQ);
            x xVar = x.SXb;
            w(false, 3);
        } else if (d.d(this.oHQ)) {
            w(true, 3);
        }
    }

    public final void cdU() {
        if (com.tencent.mm.plugin.audio.d.c.c(this.oHQ)) {
            AU(1);
            w(true, 2);
        }
    }

    public final void eQ(int i2, int i3) {
        Log.i("MicroMsg.BaseAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", Integer.valueOf(i2), Integer.valueOf(i3), 0);
        com.tencent.mm.compatible.b.a.a(this.audioManager, i2, i3, 0);
    }

    public final void cdV() {
        Log.i("MicroMsg.BaseAudioManager", "reset speaker to normal");
        b(0, (kotlin.g.a.a<x>) null);
    }

    public final void AW(int i2) {
        com.tencent.mm.compatible.b.a.a(this.audioManager, i2, 1);
    }

    public final void AX(int i2) {
        com.tencent.mm.compatible.b.a.a(this.audioManager, i2, -1);
    }

    public final void b(int i2, kotlin.g.a.a<x> aVar) {
        Log.printInfoStack("MicroMsg.BaseAudioManager", "set mode from %d to %d", Integer.valueOf(this.audioManager.getMode()), Integer.valueOf(i2));
        if (this.oHO == -1 || this.oHO != i2) {
            h.RTc.b(new c(this, i2, aVar), "reset speaker");
        }
        this.oHO = i2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ a oHU;
        final /* synthetic */ int oHV;
        final /* synthetic */ kotlin.g.a.a oHW;

        c(a aVar, int i2, kotlin.g.a.a aVar2) {
            this.oHU = aVar;
            this.oHV = i2;
            this.oHW = aVar2;
        }

        public final void run() {
            AppMethodBeat.i(223953);
            this.oHU.audioManager.setMode(this.oHV);
            kotlin.g.a.a aVar = this.oHW;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(223953);
                return;
            }
            AppMethodBeat.o(223953);
        }
    }

    public final boolean cdW() {
        d dVar = d.oIq;
        return d.f(this.audioManager);
    }

    public final int cdX() {
        com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
        return com.tencent.mm.plugin.audio.d.b.d(this.audioManager);
    }

    public final int cdY() {
        if (this.oHQ.empty()) {
            return -1;
        }
        Integer lastElement = this.oHQ.lastElement();
        p.g(lastElement, "mDeviceQueue.lastElement()");
        return lastElement.intValue();
    }

    public static boolean AY(int i2) {
        switch (i2) {
            case 3:
                d dVar = d.oIq;
                return d.ces();
            case 4:
                com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
                return com.tencent.mm.plugin.audio.d.b.ces();
            default:
                return true;
        }
    }

    public final boolean isSpeakerphoneOn() {
        e eVar = e.oIr;
        return e.g(this.audioManager);
    }

    public final boolean isBluetoothScoOn() {
        com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
        return com.tencent.mm.plugin.audio.d.b.e(this.audioManager);
    }

    public final int getStreamMaxVolume(int i2) {
        return this.audioManager.getStreamMaxVolume(i2);
    }

    public final int getStreamVolume(int i2) {
        return this.audioManager.getStreamVolume(i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
    /* renamed from: com.tencent.mm.plugin.audio.b.a$a  reason: collision with other inner class name */
    public static final class C0830a {
        private C0830a() {
        }

        public /* synthetic */ C0830a(byte b2) {
            this();
        }
    }

    public static boolean cdZ() {
        com.tencent.mm.plugin.audio.d.b.cet();
        d.cet();
        com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
        if (!com.tencent.mm.plugin.audio.d.b.ces()) {
            d dVar = d.oIq;
            return d.ces();
        }
    }
}
