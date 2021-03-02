package com.tencent.mm.plugin.audio.c;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.plugin.audio.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020 H\u0016J\u0006\u0010#\u001a\u00020\u0019J\u0006\u0010$\u001a\u00020\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "Lcom/tencent/mm/model/ISubCore;", "()V", "mAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "getMAudioManager", "()Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "setMAudioManager", "(Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;)V", "mBroadCastHelper", "Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "mRequestAudioManagerQueue", "", "", "getMRequestAudioManagerQueue", "()[Ljava/lang/String;", "setMRequestAudioManagerQueue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "requesterType", "getRequesterType", "()Ljava/lang/String;", "setRequesterType", "(Ljava/lang/String;)V", "clearPluginData", "", "p0", "", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "", "onAccountRelease", "onSdcardMount", "registerBroadcast", "unRegisterBroadcast", "Companion", "plugin-audio_release"})
public final class a implements bd {
    public static final C0831a oIh = new C0831a((byte) 0);
    public com.tencent.mm.plugin.audio.a oId = new com.tencent.mm.plugin.audio.a();
    com.tencent.mm.plugin.audio.b.a oIe = new c();
    String oIf = "music";
    String[] oIg;

    static {
        AppMethodBeat.i(223979);
        AppMethodBeat.o(223979);
    }

    public static final com.tencent.mm.plugin.audio.b.a cea() {
        AppMethodBeat.i(223980);
        com.tencent.mm.plugin.audio.b.a cea = C0831a.cea();
        AppMethodBeat.o(223980);
        return cea;
    }

    public static final boolean cec() {
        AppMethodBeat.i(223983);
        boolean cec = C0831a.cec();
        AppMethodBeat.o(223983);
        return cec;
    }

    public static final int getMode() {
        AppMethodBeat.i(223998);
        int mode = C0831a.getMode();
        AppMethodBeat.o(223998);
        return mode;
    }

    public a() {
        AppMethodBeat.i(223978);
        String[] strArr = new String[2];
        for (int i2 = 0; i2 < 2; i2++) {
            strArr[i2] = "";
        }
        this.oIg = strArr;
        AppMethodBeat.o(223978);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(223976);
        Log.i("MicroMsg.SubCoreAudio", "onAccountRelease");
        this.oId.unRegisterBroadcasts();
        AppMethodBeat.o(223976);
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(223977);
        Log.i("MicroMsg.SubCoreAudio", "onAccountPostReset");
        this.oId.registerBroadcasts();
        AppMethodBeat.o(223977);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u000fH\u0007J\b\u0010\u0014\u001a\u00020\u000fH\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u001d\u001a\u00020\bH\u0007J\b\u0010\u001e\u001a\u00020\bH\u0007J\b\u0010\u001f\u001a\u00020\bH\u0007J\b\u0010 \u001a\u00020\bH\u0007J\b\u0010!\u001a\u00020\bH\u0007J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000fH\u0007J\b\u0010%\u001a\u00020\u0006H\u0007J\b\u0010&\u001a\u00020\u0006H\u0007J\b\u0010'\u001a\u00020\u0006H\u0007J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000fH\u0007J \u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0007J\b\u0010-\u001a\u00020\u0006H\u0007J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J\u0010\u00100\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/audio/model/SubCoreAudio$Companion;", "", "()V", "TAG", "", "bindBroadcast", "", "checkAndSetRequestPriority", "", "current", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "getAudioManager", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "type", "getBluetoothScoStreamType", "", "getCore", "Lcom/tencent/mm/plugin/audio/model/SubCoreAudio;", "getCurrentAudioManagerType", "getMode", "getSetModeErrorCodeAndReset", "getStatsString", "getStreamMaxVolume", "streamType", "getStreamMode", "speakerOn", "getStreamVolume", "initAudioManager", "audioManager", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isHeadsetPlugged", "isSpeakerphoneOn", "isStreamMute", "onAudioDeviceStateChanged", "status", "pauseMusic", "resetSpeaker", "resumeMusic", "setMode", "mode", "setStreamVolume", FirebaseAnalytics.b.INDEX, "flags", "unBindBroadcast", "unInitAudioManager", "volumeDown", "volumeUp", "plugin-audio_release"})
    /* renamed from: com.tencent.mm.plugin.audio.c.a$a  reason: collision with other inner class name */
    public static final class C0831a {
        private C0831a() {
        }

        public /* synthetic */ C0831a(byte b2) {
            this();
        }

        public static a cei() {
            AppMethodBeat.i(223966);
            bd at = y.at(a.class);
            p.g(at, "CompatSubCore.theCore(SubCoreAudio::class.java)");
            a aVar = (a) at;
            AppMethodBeat.o(223966);
            return aVar;
        }

        public static com.tencent.mm.plugin.audio.b.a cea() {
            AppMethodBeat.i(223967);
            c cVar = cei().oIe;
            if (cVar == null) {
                c cVar2 = new c();
                C0831a aVar = a.oIh;
                cei().oIg[0] = "music";
                cVar = cVar2;
            }
            AppMethodBeat.o(223967);
            return cVar;
        }

        public static boolean cec() {
            AppMethodBeat.i(223968);
            boolean a2 = b.a(cea().audioManager);
            AppMethodBeat.o(223968);
            return a2;
        }

        public static String cej() {
            AppMethodBeat.i(223969);
            com.tencent.mm.plugin.audio.b.a cea = cea();
            StringBuilder append = new StringBuilder("mode:").append(cea.audioManager.getMode()).append(" isSpeakerphoneOn:").append(cea.isSpeakerphoneOn()).append(" isBluetoothOn:");
            b bVar = b.oIo;
            String sb = append.append(b.ceb()).toString();
            AppMethodBeat.o(223969);
            return sb;
        }

        public static int getMode() {
            AppMethodBeat.i(223970);
            int mode = cea().audioManager.getMode();
            AppMethodBeat.o(223970);
            return mode;
        }

        public static void a(com.tencent.mm.plugin.audio.b.a aVar, String str) {
            AppMethodBeat.i(223971);
            p.h(aVar, "audioManager");
            p.h(str, "type");
            Log.printInfoStack("MicroMsg.SubCoreAudio", "init audio manager from ".concat(String.valueOf(str)), new Object[0]);
            String str2 = (String) e.Q(cei().oIg);
            if (p.j(str2, "")) {
                cei().oIg[0] = str;
                cei().oIe = aVar;
            } else if (eP(str2, str)) {
                Log.i("MicroMsg.SubCoreAudio", "success set the audio manager is: ".concat(String.valueOf(str)));
                C0831a aVar2 = a.oIh;
                cei().oIe = aVar;
            } else {
                Log.i("MicroMsg.SubCoreAudio", "current  " + str2 + " is running a priority higher than request: " + str);
            }
            com.tencent.mm.plugin.audio.broadcast.bluetooth.a.cdS();
            AppMethodBeat.o(223971);
        }

        public static boolean ags(String str) {
            AppMethodBeat.i(223972);
            p.h(str, "type");
            if (p.j(str, cei().oIg[0]) || p.j(cei().oIg[0], "")) {
                AppMethodBeat.o(223972);
                return true;
            }
            AppMethodBeat.o(223972);
            return false;
        }

        public static String cek() {
            AppMethodBeat.i(223973);
            String str = cei().oIg[0];
            AppMethodBeat.o(223973);
            return str;
        }

        public static void agt(String str) {
            AppMethodBeat.i(223974);
            p.h(str, "type");
            if (p.j(str, (String) e.Q(cei().oIg))) {
                Log.i("MicroMsg.SubCoreAudio", "current do unInit audio manager and clear the queue");
                cei().oIg[0] = "";
                cei().oIe = null;
            }
            AppMethodBeat.o(223974);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
            r0 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
            if (r6.equals("voip") != false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
            if (r6.equals("voipcs") != false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
            if (r6.equals("multitalke") != false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
            if (r7.equals("ipcall") != false) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
            if (r7.equals("voip") != false) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
            if (r7.equals("voipcs") != false) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
            if (r7.equals("multitalke") != false) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
            if (r6.equals("ipcall") != false) goto L_0x0031;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean eP(java.lang.String r6, java.lang.String r7) {
            /*
            // Method dump skipped, instructions count: 170
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.audio.c.a.C0831a.eP(java.lang.String, java.lang.String):boolean");
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        if (r4.equals("voip") != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
        r0 = new com.tencent.mm.plugin.audio.b.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        if (r4.equals("voipcs") != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
        if (r4.equals("multitalke") != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004b, code lost:
        if (r4.equals("ipcall") != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004d, code lost:
        r0 = new com.tencent.mm.plugin.audio.b.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.tencent.mm.plugin.audio.b.a agr(java.lang.String r4) {
        /*
        // Method dump skipped, instructions count: 140
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.audio.c.a.agr(java.lang.String):com.tencent.mm.plugin.audio.b.a");
    }

    public static final boolean ceb() {
        AppMethodBeat.i(223982);
        b bVar = b.oIo;
        boolean ceb = b.ceb();
        AppMethodBeat.o(223982);
        return ceb;
    }

    public static final boolean isSpeakerphoneOn() {
        AppMethodBeat.i(223984);
        boolean isSpeakerphoneOn = C0831a.cea().isSpeakerphoneOn();
        AppMethodBeat.o(223984);
        return isSpeakerphoneOn;
    }

    public static final int getStreamMaxVolume(int i2) {
        AppMethodBeat.i(223985);
        int streamMaxVolume = C0831a.cea().getStreamMaxVolume(i2);
        AppMethodBeat.o(223985);
        return streamMaxVolume;
    }

    public static final int getStreamVolume(int i2) {
        AppMethodBeat.i(223986);
        int streamVolume = C0831a.cea().getStreamVolume(i2);
        AppMethodBeat.o(223986);
        return streamVolume;
    }

    public static final void eQ(int i2, int i3) {
        AppMethodBeat.i(223987);
        C0831a.cea().eQ(i2, i3);
        AppMethodBeat.o(223987);
    }

    public static final int cdX() {
        AppMethodBeat.i(223988);
        int cdX = C0831a.cea().cdX();
        AppMethodBeat.o(223988);
        return cdX;
    }

    public static final int ced() {
        AppMethodBeat.i(223989);
        com.tencent.mm.plugin.audio.b.a cea = C0831a.cea();
        int i2 = cea.gCZ;
        cea.gCZ = 0;
        AppMethodBeat.o(223989);
        return i2;
    }

    public static final boolean cee() {
        AppMethodBeat.i(223990);
        b bVar = b.oIo;
        boolean cee = b.cee();
        AppMethodBeat.o(223990);
        return cee;
    }

    public static final void cdV() {
        AppMethodBeat.i(223991);
        C0831a.cea().cdV();
        AppMethodBeat.o(223991);
    }

    public static final boolean cdW() {
        AppMethodBeat.i(223992);
        boolean cdW = C0831a.cea().cdW();
        AppMethodBeat.o(223992);
        return cdW;
    }

    public static final void AW(int i2) {
        AppMethodBeat.i(223993);
        C0831a.cea().AW(i2);
        AppMethodBeat.o(223993);
    }

    public static final void AX(int i2) {
        AppMethodBeat.i(223994);
        C0831a.cea().AX(i2);
        AppMethodBeat.o(223994);
    }

    public static final void bdY() {
        AppMethodBeat.i(223995);
        C0831a.cea().audioManager.setStreamMute(3, true);
        AppMethodBeat.o(223995);
    }

    public static final void bdZ() {
        AppMethodBeat.i(223996);
        C0831a.cea().audioManager.setStreamMute(3, false);
        AppMethodBeat.o(223996);
    }

    public static final void setMode(int i2) {
        AppMethodBeat.i(223997);
        C0831a.cea().b((com.tencent.mm.plugin.audio.b.a) i2, (int) ((kotlin.g.a.a<x>) null));
        AppMethodBeat.o(223997);
    }

    public static final boolean cef() {
        AppMethodBeat.i(223999);
        boolean isStreamMute = C0831a.cea().audioManager.isStreamMute(3);
        AppMethodBeat.o(223999);
        return isStreamMute;
    }

    public static final int jv(boolean z) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(224000);
        com.tencent.mm.plugin.audio.b.a cea = C0831a.cea();
        boolean z2 = cea.audioManager.isBluetoothScoOn() || cea.gCW;
        if (z) {
            i2 = 3;
        } else {
            i2 = 0;
        }
        if (!z2) {
            i3 = i2;
        }
        AppMethodBeat.o(224000);
        return i3;
    }

    public static final void ceg() {
        AppMethodBeat.i(224001);
        C0831a.cei().oId.registerBroadcasts();
        AppMethodBeat.o(224001);
    }

    public static final void ceh() {
        AppMethodBeat.i(224002);
        C0831a.cei().oId.unRegisterBroadcasts();
        AppMethodBeat.o(224002);
    }
}
