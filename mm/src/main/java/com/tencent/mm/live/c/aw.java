package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J@\u0010\u001b\u001a\u00020\u001928\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001dJ\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\nJ\u0012\u0010%\u001a\u00020\u00192\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'J\u000e\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\fJI\u0010*\u001a\u00020\u00192\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\n2#\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u0019\u0018\u00010.J\u001a\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u000e\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0017J\b\u00107\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveTXLivePlayerPlygin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curPlayerStatus", "", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "streamType", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "txLivePlayerPreview", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "kotlin.jvm.PlatformType", "getPlayer", "getPlayerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isCdnPlayerDisconnect", "", "pausePlayer", "", "resumePlayer", "setPreviewClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "setRenderRotation", "rotation", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "setupSecondaryDeviceConfig", "core", "startPlay", "Lcom/tencent/rtmp/TXLivePlayConfig;", "renderMode", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "success", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopPlay", "keepLastFrame", "unMount", "plugin-logic_release"})
public final class aw extends a {
    private final String TAG = "MicroMsg.LiveTXLivePlayerPlygin";
    public int hCl;
    private final b hOp;
    public final LiveVideoView hSD;
    public TXLivePlayer hwO;
    public b liveCore;
    private int streamType;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ kotlin.g.a.b hSE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(kotlin.g.a.b bVar) {
            super(1);
            this.hSE = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(208170);
            boolean booleanValue = bool.booleanValue();
            kotlin.g.a.b bVar = this.hSE;
            if (bVar != null) {
                bVar.invoke(Boolean.valueOf(booleanValue));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(208170);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aw(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208177);
        this.hOp = bVar;
        this.hSD = (LiveVideoView) viewGroup.findViewById(R.id.emo);
        viewGroup.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(208177);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(com.tencent.mm.live.c.aw r5, int r6, com.tencent.rtmp.TXLivePlayConfig r7, int r8, kotlin.g.a.b r9, int r10) {
        /*
        // Method dump skipped, instructions count: 164
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.c.aw.a(com.tencent.mm.live.c.aw, int, com.tencent.rtmp.TXLivePlayConfig, int, kotlin.g.a.b, int):void");
    }

    public final void ev(boolean z) {
        AppMethodBeat.i(208172);
        Log.i(this.TAG, "stopPlay, type:" + this.streamType);
        if (this.liveCore != null) {
            d.ev(z);
            AppMethodBeat.o(208172);
            return;
        }
        AppMethodBeat.o(208172);
    }

    public final void aHy() {
        AppMethodBeat.i(208173);
        b.a aVar = b.hCo;
        this.hwr.getContext();
        this.liveCore = b.a.aEf();
        AppMethodBeat.o(208173);
    }

    public final TXCloudVideoView aHJ() {
        AppMethodBeat.i(208174);
        LiveVideoView liveVideoView = this.hSD;
        p.g(liveVideoView, "txLivePlayerPreview");
        LiveVideoView liveVideoView2 = liveVideoView;
        AppMethodBeat.o(208174);
        return liveVideoView2;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208175);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ax.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                ev(true);
                AppMethodBeat.o(208175);
                return;
            case 3:
                if (!(this.liveCore instanceof com.tencent.mm.live.core.core.c.a)) {
                    ev(true);
                    break;
                }
                break;
        }
        AppMethodBeat.o(208175);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(208176);
        super.unMount();
        AppMethodBeat.o(208176);
    }
}
