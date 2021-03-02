package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.v2helper;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\b\u0010\u0015\u001a\u00020\u0011H\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "uiCallback", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "getUiCallback", "()Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;)V", "getMaxAmplitudeRate", "", "getMaxAmplitudeRateRemote", "onRecongnizeFinish", "", "onRes", "voiceText", "start", "startRemote", "stop", "fromUI", "", "stopRemote", "Companion", "UICallback", "plugin-emojicapture_release"})
public final class VoiceInputProxy extends com.tencent.mm.remoteservice.a {
    private static g rrK;
    public static final a rrL = new a((byte) 0);
    private final String TAG = "MicroMsg.VoiceInputProxy";
    private b rrJ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
    public interface b {
        void biz();

        void onRes(String str);
    }

    static {
        AppMethodBeat.i(v2helper.EMethodSetSendToNetworkOff);
        AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOff);
    }

    public final b getUiCallback() {
        return this.rrJ;
    }

    public final void setUiCallback(b bVar) {
        this.rrJ = bVar;
    }

    public VoiceInputProxy(b bVar, d dVar) {
        super(dVar);
        this.rrJ = bVar;
    }

    @e
    public final void start() {
        AppMethodBeat.i(425);
        REMOTE_CALL("startRemote", new Object[0]);
        AppMethodBeat.o(425);
    }

    @e
    public final void stop(boolean z) {
        AppMethodBeat.i(v2helper.EMethodSetAgcRxOn);
        REMOTE_CALL("stopRemote", Boolean.valueOf(z));
        AppMethodBeat.o(v2helper.EMethodSetAgcRxOn);
    }

    @e
    public final void onRes(String str) {
        AppMethodBeat.i(v2helper.EMethodPcMicLevel);
        b bVar = this.rrJ;
        if (bVar != null) {
            bVar.onRes(str);
            AppMethodBeat.o(v2helper.EMethodPcMicLevel);
            return;
        }
        AppMethodBeat.o(v2helper.EMethodPcMicLevel);
    }

    @e
    public final void onRecongnizeFinish() {
        AppMethodBeat.i(v2helper.EMethodSetIosMicAbCheckOn);
        b bVar = this.rrJ;
        if (bVar != null) {
            bVar.biz();
            AppMethodBeat.o(v2helper.EMethodSetIosMicAbCheckOn);
            return;
        }
        AppMethodBeat.o(v2helper.EMethodSetIosMicAbCheckOn);
    }

    @e
    public final int getMaxAmplitudeRate() {
        AppMethodBeat.i(v2helper.EMethodSetIosMicAbCheckOff);
        Object REMOTE_CALL = REMOTE_CALL("getMaxAmplitudeRateRemote", new Object[0]);
        if (REMOTE_CALL == null || !(REMOTE_CALL instanceof Integer)) {
            AppMethodBeat.o(v2helper.EMethodSetIosMicAbCheckOff);
            return 0;
        }
        int intValue = ((Number) REMOTE_CALL).intValue();
        AppMethodBeat.o(v2helper.EMethodSetIosMicAbCheckOff);
        return intValue;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$Companion;", "", "()V", "voiceInputRemote", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr;", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J/\u0010\f\u001a\u00020\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$startRemote$uiCallback$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-emojicapture_release"})
    public static final class c implements g.b {
        final /* synthetic */ VoiceInputProxy rrM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(VoiceInputProxy voiceInputProxy) {
            this.rrM = voiceInputProxy;
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void b(String[] strArr, List<String> list) {
            AppMethodBeat.i(v2helper.EMethodSetPlayerPreCorrectCofOff);
            if (strArr != null) {
                if (!(strArr.length == 0)) {
                    if (strArr[0].length() > 0) {
                        String str = strArr[0];
                        Log.i(this.rrM.TAG, "onRes remote ".concat(String.valueOf(str)));
                        int g2 = n.g(str, "。");
                        if (g2 >= 0) {
                            if (str == null) {
                                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                                AppMethodBeat.o(v2helper.EMethodSetPlayerPreCorrectCofOff);
                                throw tVar;
                            }
                            str = str.substring(0, g2);
                            p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        this.rrM.CLIENT_CALL("onRes", str);
                    }
                }
            }
            AppMethodBeat.o(v2helper.EMethodSetPlayerPreCorrectCofOff);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void c(int i2, int i3, int i4, long j2) {
            AppMethodBeat.i(v2helper.EMethodOutputVolumeGainEnable);
            Log.w(this.rrM.TAG, "onError " + i2 + ' ' + i3 + ' ' + i4 + ' ' + j2);
            AppMethodBeat.o(v2helper.EMethodOutputVolumeGainEnable);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void biv() {
            AppMethodBeat.i(v2helper.EMethodSetNgStrength);
            Log.i(this.rrM.TAG, "onRecordFin");
            AppMethodBeat.o(v2helper.EMethodSetNgStrength);
        }

        @Override // com.tencent.mm.modelvoiceaddr.g.b
        public final void biz() {
            AppMethodBeat.i(v2helper.EMethodSetSpkEnhance);
            Log.i(this.rrM.TAG, "onRecognizeFinish");
            this.rrM.CLIENT_CALL("onRecognizeFinish", new Object[0]);
            AppMethodBeat.o(v2helper.EMethodSetSpkEnhance);
        }
    }

    @f
    public final void startRemote() {
        AppMethodBeat.i(430);
        g gVar = new g(g.jwq, 9, new c(this));
        rrK = gVar;
        gVar.start();
        AppMethodBeat.o(430);
    }

    @f
    public final int getMaxAmplitudeRateRemote() {
        AppMethodBeat.i(431);
        Log.d(this.TAG, "getMaxAmplitudeRateRemote call " + rrK);
        if (rrK != null) {
            g gVar = rrK;
            if (gVar == null) {
                p.hyc();
            }
            int maxAmplitudeRate = gVar.getMaxAmplitudeRate();
            AppMethodBeat.o(431);
            return maxAmplitudeRate;
        }
        AppMethodBeat.o(431);
        return 0;
    }

    @f
    public final void stopRemote(boolean z) {
        AppMethodBeat.i(v2helper.EMethodSetSendToNetworkOn);
        g gVar = rrK;
        if (gVar != null) {
            gVar.stop(z);
        }
        rrK = null;
        AppMethodBeat.o(v2helper.EMethodSetSendToNetworkOn);
    }
}
