package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u0013H\u0016J@\u0010\u001c\u001a\u00020\u001328\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001eJ@\u0010#\u001a\u00020\u001328\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001eJ\b\u0010&\u001a\u00020\u0013H\u0002J\u0006\u0010'\u001a\u00020\u0013J\u001a\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0013H\u0002J\b\u0010.\u001a\u00020\u0013H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/live/plugin/LivePreviewPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "dp2px", "", "dpVal", "", "mount", "", "orientationChanged", "orientation", "userId", "", "streamType", "pause", "refreshPreviewView", "resume", "setPreviewMoveListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "xOffset", "yOffset", "setPreviewTouchListener", "x", "y", "showMicLayout", "startPreview", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "switchCamera", "unMount", "Companion", "plugin-logic_release"})
public final class ao extends a {
    public static final a hSn = new a((byte) 0);
    private final Context context;
    public final LivePreviewView hAs;
    private final b hOp;
    private com.tencent.mm.live.core.core.a.a hSm = b.a.aDo();

    static {
        AppMethodBeat.i(208141);
        AppMethodBeat.o(208141);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ao(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208140);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.ek7);
        p.g(findViewById, "root.findViewById(R.id.live_preview_view)");
        this.hAs = (LivePreviewView) findViewById;
        b.a aVar = b.hyv;
        viewGroup.getContext();
        viewGroup.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(208140);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/live/plugin/LivePreviewPlugin$Companion;", "", "()V", "LIVE_UI", "", "TAG", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void startPreview() {
        AppMethodBeat.i(208137);
        com.tencent.mm.live.core.core.a.a aVar = this.hSm;
        if (aVar != null) {
            LivePreviewView livePreviewView = this.hAs;
            x xVar = x.hJf;
            com.tencent.mm.live.core.b.a aGk = x.aGk();
            x xVar2 = x.hJf;
            aVar.a(livePreviewView, aGk, x.aGl());
            AppMethodBeat.o(208137);
            return;
        }
        AppMethodBeat.o(208137);
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void pause() {
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(208138);
        Log.i("MicroMsg.LiveCoreAnchor", "unMount");
        AppMethodBeat.o(208138);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(208139);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ap.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(0);
                AppMethodBeat.o(208139);
                return;
            case 4:
                Log.i("MicroMsg.LiveCoreAnchor", "switchCamera");
                com.tencent.mm.live.core.core.a.a aVar = this.hSm;
                if (aVar != null) {
                    aVar.switchCamera();
                }
                x xVar = x.hJf;
                String aGm = x.aGm();
                x xVar2 = x.hJf;
                long j2 = x.aGr().hyH;
                x xVar3 = x.hJf;
                String aGt = x.aGt();
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                p.g(aDC, "ConfigHelper.getInstance()");
                if (aDC.aDG().hBp == 0) {
                    i2 = 1;
                }
                x xVar4 = x.hJf;
                e.a(aGm, j2, aGt, 1, i2, x.aGr().LIa);
                com.tencent.mm.live.d.a.aIa();
                AppMethodBeat.o(208139);
                return;
            case 5:
                rg(8);
                com.tencent.mm.live.core.core.a.a aVar2 = this.hSm;
                if (aVar2 != null) {
                    aVar2.aBS();
                    AppMethodBeat.o(208139);
                    return;
                }
                break;
        }
        AppMethodBeat.o(208139);
    }
}
