package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u00012B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001d\u001a\u00020\u000eJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020!H\u0002J\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020!J\u0018\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*J\u0006\u0010+\u001a\u00020!J\u0012\u0010,\u001a\u00020!2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u000eJ\u0006\u00100\u001a\u00020!J\u0006\u00101\u001a\u00020!R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "vlogVideoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "getVlogVideoView", "()Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "setVlogVideoView", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;)V", "canResume", "getScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", AssetExtension.SCENE_PLAY, "item", "sessionId", "", "release", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-vlog_release"})
public final class VLogFakeVideoView extends RelativeLayout {
    public static final a GOi = new a((byte) 0);
    private static final String TAG = TAG;
    private c CdB;
    public VLogPlayView GOh;
    private boolean guh;
    public ProgressBar mEz;
    public FakeVideoViewLayer xCO;

    public final VLogPlayView getVlogVideoView() {
        AppMethodBeat.i(111169);
        VLogPlayView vLogPlayView = this.GOh;
        if (vLogPlayView == null) {
            p.btv("vlogVideoView");
        }
        AppMethodBeat.o(111169);
        return vLogPlayView;
    }

    public final void setVlogVideoView(VLogPlayView vLogPlayView) {
        AppMethodBeat.i(111170);
        p.h(vLogPlayView, "<set-?>");
        this.GOh = vLogPlayView;
        AppMethodBeat.o(111170);
    }

    public final FakeVideoViewLayer getFakeLayer() {
        AppMethodBeat.i(111171);
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        AppMethodBeat.o(111171);
        return fakeVideoViewLayer;
    }

    public final void setFakeLayer(FakeVideoViewLayer fakeVideoViewLayer) {
        AppMethodBeat.i(111172);
        p.h(fakeVideoViewLayer, "<set-?>");
        this.xCO = fakeVideoViewLayer;
        AppMethodBeat.o(111172);
    }

    public final ProgressBar getLoading() {
        AppMethodBeat.i(111173);
        ProgressBar progressBar = this.mEz;
        if (progressBar == null) {
            p.btv("loading");
        }
        AppMethodBeat.o(111173);
        return progressBar;
    }

    public final void setLoading(ProgressBar progressBar) {
        AppMethodBeat.i(111174);
        p.h(progressBar, "<set-?>");
        this.mEz = progressBar;
        AppMethodBeat.o(111174);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(111182);
        AppMethodBeat.o(111182);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VLogFakeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(111181);
        Log.i(TAG, "initView");
        LayoutInflater.from(getContext()).inflate(R.layout.c67, this);
        View findViewById = findViewById(R.id.j8t);
        p.g(findViewById, "findViewById(R.id.vlog_play_view)");
        this.GOh = (VLogPlayView) findViewById;
        View findViewById2 = findViewById(R.id.cay);
        p.g(findViewById2, "findViewById(R.id.fakelayer)");
        this.xCO = (FakeVideoViewLayer) findViewById2;
        View findViewById3 = findViewById(R.id.j59);
        p.g(findViewById3, "findViewById(R.id.video_loading)");
        this.mEz = (ProgressBar) findViewById3;
        VLogPlayView vLogPlayView = this.GOh;
        if (vLogPlayView == null) {
            p.btv("vlogVideoView");
        }
        vLogPlayView.setPrepareCallback(new b(this));
        AppMethodBeat.o(111181);
    }

    public /* synthetic */ VLogFakeVideoView(Context context, AttributeSet attributeSet, int i2) {
        this(context, null);
    }

    public final void setMute(boolean z) {
        this.guh = z;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(111175);
        VLogPlayView vLogPlayView = this.GOh;
        if (vLogPlayView == null) {
            p.btv("vlogVideoView");
        }
        boolean z = vLogPlayView.GOq;
        AppMethodBeat.o(111175);
        return z;
    }

    private final ah getScriptModel() {
        byte[] bArr;
        epc epc;
        AppMethodBeat.i(111176);
        aio aio = new aio();
        c cVar = this.CdB;
        if (cVar != null) {
            bArr = cVar.field_baseItemData;
        } else {
            bArr = null;
        }
        try {
            aio.parseFrom(bArr);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            aio = null;
        }
        aio aio2 = aio;
        if (aio2 != null) {
            float[] fArr = {(float) aio2.LrU, (float) aio2.LrW, (float) aio2.LrV, (float) aio2.LrX};
            e eVar = e.BKp;
            LinkedList<jn> linkedList = aio2.Lna;
            p.g(linkedList, "this.baseItemData");
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a2 = e.a(linkedList, context);
            epc epc2 = new epc();
            try {
                epc2.parseFrom(aio2.Lsd.toByteArray());
                epc = epc2;
            } catch (Exception e3) {
                Log.printDebugStack("safeParser", "", e3);
                epc = null;
            }
            epc epc3 = epc;
            if (epc3 != null) {
                erh erh = epc3.NmX;
                long j2 = erh.KPe;
                ae.a aVar = ae.GzI;
                p.g(erh, "vlogResp");
                List<s> a3 = ae.a.a(erh);
                String str = erh.NoU.MxH;
                p.g(str, "vlogResp.music.local_path");
                ah ahVar = new ah(j2, a3, str, erh);
                ahVar.p(fArr);
                ahVar.aT(a2);
                AppMethodBeat.o(111176);
                return ahVar;
            }
        }
        AppMethodBeat.o(111176);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c2, code lost:
        if (r3.BYt != false) goto L_0x00c4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.recordvideo.background.c r10) {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView.a(com.tencent.mm.plugin.recordvideo.background.c):void");
    }

    public final void b(c cVar) {
        AppMethodBeat.i(111178);
        Log.i(TAG, "resume");
        VLogPlayView vLogPlayView = this.GOh;
        if (vLogPlayView == null) {
            p.btv("vlogVideoView");
        }
        if (vLogPlayView.Cel) {
            VLogPlayView vLogPlayView2 = this.GOh;
            if (vLogPlayView2 == null) {
                p.btv("vlogVideoView");
            }
            Log.i("MicroMsg.VLogPlayView", "resume");
            vLogPlayView2.GOq = true;
            com.tencent.mm.plugin.vlog.player.c cVar2 = vLogPlayView2.GCP;
            if (cVar2 != null) {
                com.tencent.mm.plugin.vlog.player.c.a(cVar2, null, false, 7);
            }
            FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
            if (fakeVideoViewLayer == null) {
                p.btv("fakeLayer");
            }
            fakeVideoViewLayer.tv(this.guh);
        }
        if (cVar != null) {
            a(cVar);
        }
        AppMethodBeat.o(111178);
    }

    public final void stop() {
        AppMethodBeat.i(111179);
        Log.i(TAG, "stop");
        VLogPlayView vLogPlayView = this.GOh;
        if (vLogPlayView == null) {
            p.btv("vlogVideoView");
        }
        Log.i("MicroMsg.VLogPlayView", "stop");
        com.tencent.mm.plugin.vlog.player.c cVar = vLogPlayView.GCP;
        if (cVar != null) {
            cVar.release();
        }
        k kVar = vLogPlayView.GBp;
        if (kVar != null) {
            kVar.release();
        }
        MMHandler mMHandler = vLogPlayView.GOo;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = vLogPlayView.GOn;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        vLogPlayView.GCP = null;
        vLogPlayView.GOo = null;
        vLogPlayView.Cel = false;
        vLogPlayView.GOq = false;
        vLogPlayView.GOr = null;
        vLogPlayView.frameCount = 0;
        vLogPlayView.GOt = false;
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        fakeVideoViewLayer.eLB();
        AppMethodBeat.o(111179);
    }

    public final void onUIResume() {
        AppMethodBeat.i(111180);
        Log.i(TAG, "onUIResume");
        b(this.CdB);
        AppMethodBeat.o(111180);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ VLogFakeVideoView GOj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(VLogFakeVideoView vLogFakeVideoView) {
            super(0);
            this.GOj = vLogFakeVideoView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(111168);
            this.GOj.setAlpha(1.0f);
            x xVar = x.SXb;
            AppMethodBeat.o(111168);
            return xVar;
        }
    }
}
