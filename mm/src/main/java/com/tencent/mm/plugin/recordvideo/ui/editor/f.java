package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!H\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020\u0012J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\u0018\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010 J\u0012\u0010,\u001a\u00020#2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0012J\u0006\u00100\u001a\u00020#J\u0006\u00101\u001a\u00020#R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", AssetExtension.SCENE_PLAY, "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-recordvideo_release"})
public final class f extends RelativeLayout {
    public static final a CdC = new a((byte) 0);
    private static final String TAG = TAG;
    public StoryFakeVideoPlayView CdA;
    private c CdB;
    private boolean guh;
    public ProgressBar mEz;
    public FakeVideoViewLayer xCO;

    public final StoryFakeVideoPlayView getImageVideoView() {
        AppMethodBeat.i(76015);
        StoryFakeVideoPlayView storyFakeVideoPlayView = this.CdA;
        if (storyFakeVideoPlayView == null) {
            p.btv("imageVideoView");
        }
        AppMethodBeat.o(76015);
        return storyFakeVideoPlayView;
    }

    public final void setImageVideoView(StoryFakeVideoPlayView storyFakeVideoPlayView) {
        AppMethodBeat.i(76016);
        p.h(storyFakeVideoPlayView, "<set-?>");
        this.CdA = storyFakeVideoPlayView;
        AppMethodBeat.o(76016);
    }

    public final FakeVideoViewLayer getFakeLayer() {
        AppMethodBeat.i(76017);
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        AppMethodBeat.o(76017);
        return fakeVideoViewLayer;
    }

    public final void setFakeLayer(FakeVideoViewLayer fakeVideoViewLayer) {
        AppMethodBeat.i(76018);
        p.h(fakeVideoViewLayer, "<set-?>");
        this.xCO = fakeVideoViewLayer;
        AppMethodBeat.o(76018);
    }

    public final ProgressBar getLoading() {
        AppMethodBeat.i(76019);
        ProgressBar progressBar = this.mEz;
        if (progressBar == null) {
            p.btv("loading");
        }
        AppMethodBeat.o(76019);
        return progressBar;
    }

    public final void setLoading(ProgressBar progressBar) {
        AppMethodBeat.i(76020);
        p.h(progressBar, "<set-?>");
        this.mEz = progressBar;
        AppMethodBeat.o(76020);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(76029);
        AppMethodBeat.o(76029);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(76028);
        LayoutInflater.from(getContext()).inflate(R.layout.c0d, this);
        View findViewById = findViewById(R.id.dww);
        p.g(findViewById, "findViewById(R.id.imagevideoview)");
        this.CdA = (StoryFakeVideoPlayView) findViewById;
        View findViewById2 = findViewById(R.id.cay);
        p.g(findViewById2, "findViewById(R.id.fakelayer)");
        this.xCO = (FakeVideoViewLayer) findViewById2;
        View findViewById3 = findViewById(R.id.j59);
        p.g(findViewById3, "findViewById(R.id.video_loading)");
        this.mEz = (ProgressBar) findViewById3;
        AppMethodBeat.o(76028);
    }

    public final void setMute(boolean z) {
        this.guh = z;
    }

    private final ArrayList<String> getImageList() {
        byte[] bArr;
        LinkedList<String> linkedList;
        AppMethodBeat.i(76021);
        ArrayList<String> arrayList = new ArrayList<>();
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
        if (!(aio2 == null || (linkedList = aio2.Lsc) == null)) {
            arrayList.addAll(linkedList);
        }
        AppMethodBeat.o(76021);
        return arrayList;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(76022);
        StoryFakeVideoPlayView storyFakeVideoPlayView = this.CdA;
        if (storyFakeVideoPlayView == null) {
            p.btv("imageVideoView");
        }
        if (storyFakeVideoPlayView.Ceh == StoryFakeVideoPlayView.c.PLAYING) {
            AppMethodBeat.o(76022);
            return true;
        }
        AppMethodBeat.o(76022);
        return false;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(76023);
        p.h(cVar, "item");
        this.CdB = cVar;
        Log.i(TAG, "LogStory: play fake video");
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        fakeVideoViewLayer.setVisibility(0);
        c cVar2 = this.CdB;
        if (cVar2 != null) {
            FakeVideoViewLayer fakeVideoViewLayer2 = this.xCO;
            if (fakeVideoViewLayer2 == null) {
                p.btv("fakeLayer");
            }
            fakeVideoViewLayer2.setFakeVideoInfo(cVar2);
            setAlpha(0.0f);
            StoryFakeVideoPlayView storyFakeVideoPlayView = this.CdA;
            if (storyFakeVideoPlayView == null) {
                p.btv("imageVideoView");
            }
            storyFakeVideoPlayView.setCallback(new b(this));
            StoryFakeVideoPlayView storyFakeVideoPlayView2 = this.CdA;
            if (storyFakeVideoPlayView2 == null) {
                p.btv("imageVideoView");
            }
            storyFakeVideoPlayView2.aK(getImageList());
        }
        AppMethodBeat.o(76023);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$play$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
    public static final class b implements StoryFakeVideoPlayView.a {
        final /* synthetic */ f CdD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(f fVar) {
            this.CdD = fVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ b CdE;

            a(b bVar) {
                this.CdE = bVar;
            }

            public final void run() {
                AppMethodBeat.i(76013);
                this.CdE.CdD.setAlpha(1.0f);
                this.CdE.CdD.getFakeLayer().tv(this.CdE.CdD.guh);
                a aVar = f.CdC;
                Log.i(f.TAG, "imageVideoView onPrepared");
                AppMethodBeat.o(76013);
            }
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a
        public final void tf() {
            AppMethodBeat.i(76014);
            this.CdD.post(new a(this));
            AppMethodBeat.o(76014);
        }
    }

    public final void b(c cVar) {
        boolean z;
        AppMethodBeat.i(76024);
        Log.i(TAG, "resume");
        Log.i(TAG, "checkResumeLocalVideo");
        StoryFakeVideoPlayView storyFakeVideoPlayView = this.CdA;
        if (storyFakeVideoPlayView == null) {
            p.btv("imageVideoView");
        }
        if (storyFakeVideoPlayView.Cel) {
            StoryFakeVideoPlayView storyFakeVideoPlayView2 = this.CdA;
            if (storyFakeVideoPlayView2 == null) {
                p.btv("imageVideoView");
            }
            storyFakeVideoPlayView2.resume();
            z = true;
        } else {
            z = false;
        }
        if (z) {
            FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
            if (fakeVideoViewLayer == null) {
                p.btv("fakeLayer");
            }
            fakeVideoViewLayer.tv(this.guh);
            AppMethodBeat.o(76024);
            return;
        }
        if (cVar != null) {
            a(cVar);
        }
        AppMethodBeat.o(76024);
    }

    public final int getCurPos() {
        AppMethodBeat.i(76025);
        StoryFakeVideoPlayView storyFakeVideoPlayView = this.CdA;
        if (storyFakeVideoPlayView == null) {
            p.btv("imageVideoView");
        }
        int curPos = storyFakeVideoPlayView.getCurPos();
        AppMethodBeat.o(76025);
        return curPos;
    }

    public final void stop() {
        AppMethodBeat.i(76026);
        FakeVideoViewLayer fakeVideoViewLayer = this.xCO;
        if (fakeVideoViewLayer == null) {
            p.btv("fakeLayer");
        }
        fakeVideoViewLayer.eLB();
        StoryFakeVideoPlayView storyFakeVideoPlayView = this.CdA;
        if (storyFakeVideoPlayView == null) {
            p.btv("imageVideoView");
        }
        storyFakeVideoPlayView.stop();
        AppMethodBeat.o(76026);
    }

    public final void onUIResume() {
        AppMethodBeat.i(76027);
        Log.i(TAG, "onUIResume");
        b(this.CdB);
        AppMethodBeat.o(76027);
    }
}
