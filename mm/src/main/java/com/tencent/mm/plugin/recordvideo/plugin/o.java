package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0014\u0018\u0000 (2\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u000eH\u0016J\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "endTime", "", "getEndTime", "()I", "setEndTime", "(I)V", "fakeVideoPlayViewCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1;", "startTime", "getStartTime", "setStartTime", "getVideoPlayView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setVideoPlayView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "onBackPress", "", "onPause", "", "onResume", "release", "reset", "setVisibility", "visibility", "start", "info", "Companion", "plugin-recordvideo_release"})
public final class o implements t {
    public static final a BQO = new a((byte) 0);
    public final b BQM;
    public StoryFakeVideoPlayView BQN;
    public com.tencent.mm.media.widget.camerarecordview.b.b BQt;
    public int dvv;
    public int iqg;

    static {
        AppMethodBeat.i(75573);
        AppMethodBeat.o(75573);
    }

    public o(StoryFakeVideoPlayView storyFakeVideoPlayView, d dVar) {
        p.h(storyFakeVideoPlayView, "videoPlayView");
        p.h(dVar, "status");
        AppMethodBeat.i(75572);
        this.BQN = storyFakeVideoPlayView;
        this.BQM = new b(this, dVar);
        AppMethodBeat.o(75572);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237296);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237296);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin$fakeVideoPlayViewCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
    public static final class b implements StoryFakeVideoPlayView.a {
        final /* synthetic */ o BQP;
        final /* synthetic */ d BQQ;

        b(o oVar, d dVar) {
            this.BQP = oVar;
            this.BQQ = dVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ b BQR;

            a(b bVar) {
                this.BQR = bVar;
            }

            public final void run() {
                AppMethodBeat.i(75564);
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_VIDEO_NEED_CROP", false);
                this.BQR.BQP.BQN.setAlpha(0.99f);
                d.b.a(this.BQR.BQQ, d.c.BUR);
                this.BQR.BQQ.a(d.c.BVx, bundle);
                Log.i("MicroMsg.EditPhotoToVideoPlugin", "setup fakeVideoPlayView onPrepared");
                AppMethodBeat.o(75564);
            }
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.a
        public final void tf() {
            AppMethodBeat.i(75565);
            this.BQP.BQN.post(new a(this));
            AppMethodBeat.o(75565);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75566);
        this.BQN.setVisibility(i2);
        AppMethodBeat.o(75566);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        ArrayList<String> arrayList;
        AppMethodBeat.i(75567);
        Log.i("MicroMsg.EditPhotoToVideoPlugin", "onResume");
        com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BQt;
        if (bVar == null || (arrayList = bVar.iqm) == null) {
            AppMethodBeat.o(75567);
            return;
        }
        if (!arrayList.isEmpty()) {
            this.BQN.resume();
        }
        AppMethodBeat.o(75567);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(75568);
        Log.i("MicroMsg.EditPhotoToVideoPlugin", "onPause");
        StoryFakeVideoPlayView storyFakeVideoPlayView = this.BQN;
        Log.i(StoryFakeVideoPlayView.TAG, "pause");
        storyFakeVideoPlayView.Ceh = StoryFakeVideoPlayView.c.PAUSE;
        AppMethodBeat.o(75568);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75569);
        this.BQN.stop();
        AppMethodBeat.o(75569);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(75570);
        Log.i("MicroMsg.EditPhotoToVideoPlugin", "release");
        this.BQN.stop();
        this.BQt = null;
        AppMethodBeat.o(75570);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75571);
        this.BQN.stop();
        this.BQt = null;
        AppMethodBeat.o(75571);
    }
}
