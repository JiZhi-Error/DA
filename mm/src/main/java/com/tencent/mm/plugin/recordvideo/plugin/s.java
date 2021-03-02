package com.tencent.mm.plugin.recordvideo.plugin;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.au;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r*\u0001\"\u0018\u0000 B2\u00020\u0001:\u0001BB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u0018J\u000e\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\u0018J\b\u00101\u001a\u00020)H\u0016J\b\u00102\u001a\u00020)H\u0016J\b\u00103\u001a\u00020)H\u0016J\u000e\u00104\u001a\u00020)2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0016J\u000e\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\fJ\u000e\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u0018J\u0016\u0010=\u001a\u00020)2\u0006\u0010:\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fJ\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\fH\u0016J\b\u0010A\u001a\u00020)H\u0002J\u0018\u0010:\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010,R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "debugInfoView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/widget/TextView;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "broadcastDistance", "", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "forceFullScreen", "", "isClipMode", "lastBroadcastTime", "", "lastPlayTimeLogTick", "maxRecordTime", "startTime", "getStartTime", "setStartTime", "videoCallback", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1;", "getVideoPlayView", "()Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "setVideoPlayView", "(Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;)V", "fullScreenPreview", "", "info", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "gotoClipMode", "isShowWeseeBtn", "gotoPreviewMode", "enableCrop", "onDetach", "onPause", "onResume", "playVideo", "filePath", "", "release", "reset", "seek", "start", "setMute", "mute", "setPlayRange", "end", "setVisibility", "visibility", "showVideoDebugInfoIfNeed", "Companion", "plugin-recordvideo_release"})
public final class s implements t {
    public static final a BRi = new a((byte) 0);
    public com.tencent.mm.media.widget.camerarecordview.b.b BQt;
    private long BRa = -1;
    public int BRb = 10000;
    public boolean BRc;
    public boolean BRd;
    private int BRe = TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_NULL;
    private long BRf;
    public final d BRg;
    public final TextView BRh;
    public Context context = this.zyd.getContext();
    public int dvv;
    public int iqg;
    public com.tencent.mm.compatible.util.b jvG;
    public VideoPlayerTextureView zyd;

    static {
        AppMethodBeat.i(75607);
        AppMethodBeat.o(75607);
    }

    public s(VideoPlayerTextureView videoPlayerTextureView, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar, TextView textView) {
        p.h(videoPlayerTextureView, "videoPlayView");
        p.h(dVar, "status");
        AppMethodBeat.i(75606);
        this.zyd = videoPlayerTextureView;
        this.BRh = textView;
        this.BRg = new d(this, dVar);
        AppMethodBeat.o(75606);
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
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237300);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237300);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$Companion;", "", "()V", "TAG", "", "VIDEO_DURATION_TOLERANT_MS", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75599);
        this.zyd.setVisibility(i2);
        TextView textView = this.BRh;
        if (textView != null) {
            textView.setVisibility(i2);
            AppMethodBeat.o(75599);
            return;
        }
        AppMethodBeat.o(75599);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-recordvideo_release"})
    public static final class d implements j.a {
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.plugin.parent.d BQQ;
        final /* synthetic */ s BRj;

        d(s sVar, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
            this.BRj = sVar;
            this.BQQ = dVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onError(int i2, int i3) {
            AppMethodBeat.i(75595);
            Log.e("MicroMsg.MMRecordUI", "%d on error what %d extra %d", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(75595);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void tf() {
            AppMethodBeat.i(75596);
            Log.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared");
            if (this.BRj.BRd) {
                au.az(this.BRj.context);
                e eVar = e.BKp;
                Rect eIS = e.eIS();
                com.tencent.mm.plugin.recordvideo.model.a aVar = com.tencent.mm.plugin.recordvideo.model.a.BOO;
                int eJO = com.tencent.mm.plugin.recordvideo.model.a.eJO();
                com.tencent.mm.plugin.recordvideo.model.a aVar2 = com.tencent.mm.plugin.recordvideo.model.a.BOO;
                eIS.set(new Rect(0, 0, eJO, com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight()));
            } else {
                this.BRj.zyd.invalidate();
                this.BRj.zyd.post(new a(this));
            }
            this.BRj.BRa = -1;
            this.BRj.zyd.start();
            this.BRj.zyd.setLoop(true);
            this.BRj.zyd.setOneTimeVideoTextureUpdateCallback(new b(this));
            Bundle bundle = new Bundle();
            if (this.BRj.iqg - this.BRj.dvv > this.BRj.BRb + 750) {
                bundle.putBoolean("PARAM_VIDEO_NEED_CROP", true);
            }
            this.BQQ.a(d.c.BVx, bundle);
            if (this.BRj.iqg - this.BRj.dvv > this.BRj.BRb + 750) {
                this.BRj.iqg = this.BRj.BRb + 250;
                d.b.a(this.BQQ, d.c.BVo);
            }
            AppMethodBeat.o(75596);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ d BRn;

            a(d dVar) {
                this.BRn = dVar;
            }

            public final void run() {
                AppMethodBeat.i(75592);
                Log.i("MicroMsg.EditVideoPlayPlugin", "video onPrepared l:" + this.BRn.BRj.zyd.getLeft() + " t:" + this.BRn.BRj.zyd.getTop() + " r:" + this.BRn.BRj.zyd.getRight() + " b:" + this.BRn.BRj.zyd.getBottom());
                e eVar = e.BKp;
                e.eIS().set(new Rect(this.BRn.BRj.zyd.getLeft(), this.BRn.BRj.zyd.getTop(), this.BRn.BRj.zyd.getRight(), this.BRn.BRj.zyd.getBottom()));
                AppMethodBeat.o(75592);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTextureUpdate"})
        static final class b implements j.e {
            final /* synthetic */ d BRn;

            b(d dVar) {
                this.BRn = dVar;
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
            public final void bLh() {
                AppMethodBeat.i(75594);
                MMHandlerThread.postToMainThreadDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.recordvideo.plugin.s.d.b.AnonymousClass1 */
                    final /* synthetic */ b BRo;

                    {
                        this.BRo = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(75593);
                        Log.i("MicroMsg.MMRecordUI", "onTextureUpdate");
                        this.BRo.BRn.BRj.zyd.setAlpha(1.0f);
                        d.b.a(this.BRo.BRn.BQQ, d.c.BUR);
                        AppMethodBeat.o(75593);
                    }
                }, 10);
                AppMethodBeat.o(75594);
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onCompletion() {
            AppMethodBeat.i(75597);
            Log.i("MicroMsg.EditVideoPlayPlugin", "onCompletion, startTime:" + this.BRj.dvv);
            this.BRj.zyd.d((double) this.BRj.dvv, true);
            AppMethodBeat.o(75597);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final int fh(int i2, int i3) {
            AppMethodBeat.i(75598);
            if (this.BRj.BRa <= 0 || Util.ticksToNow(this.BRj.BRa) >= 1000) {
                Log.d("MicroMsg.EditVideoPlayPlugin", " " + this.BRj.zyd.isPlaying() + " videoPlayView.currentPosition: " + this.BRj.zyd.getCurrentPosition() + " + " + this.BRj.iqg);
                this.BRj.BRa = Util.currentTicks();
            }
            if (this.BRj.zyd.isPlaying()) {
                if (this.BRj.zyd.getCurrentPosition() >= this.BRj.iqg && this.BRj.iqg < this.BRj.zyd.getDuration()) {
                    Log.i("MicroMsg.EditVideoPlayPlugin", "currentPosition:" + this.BRj.zyd.getCurrentPosition() + " reach endTime:" + this.BRj.iqg + ", seekTo startTime:" + this.BRj.dvv + ", isClipMode:" + this.BRj.BRc);
                    this.BRj.zyd.d((double) this.BRj.dvv, true);
                }
                if (this.BRj.BRc) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.BRj.zyd.getCurrentPosition());
                    this.BQQ.a(d.c.BVq, bundle);
                } else if (System.currentTimeMillis() - this.BRj.BRf >= ((long) this.BRj.BRe)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("EDIT_CROP_VIDEO_CURRENT_TIME_INT", this.BRj.zyd.getCurrentPosition());
                    this.BQQ.a(d.c.BVq, bundle2);
                }
            }
            AppMethodBeat.o(75598);
            return 0;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void eo(int i2, int i3) {
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        AppMethodBeat.i(75600);
        Log.i("MicroMsg.EditVideoPlayPlugin", "onResume");
        if (!this.zyd.isPlaying()) {
            com.tencent.mm.compatible.util.b bVar = this.jvG;
            if (bVar != null) {
                bVar.requestFocus();
            }
            this.zyd.start();
        }
        AppMethodBeat.o(75600);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(75601);
        Log.i("MicroMsg.EditVideoPlayPlugin", "onPause");
        com.tencent.mm.compatible.util.b bVar = this.jvG;
        if (bVar != null) {
            bVar.apm();
        }
        this.zyd.pause();
        AppMethodBeat.o(75601);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(75602);
        Log.i("MicroMsg.EditVideoPlayPlugin", "release");
        com.tencent.mm.compatible.util.b bVar = this.jvG;
        if (bVar != null) {
            bVar.apm();
        }
        this.zyd.stop();
        this.zyd.setVideoCallback(null);
        AppMethodBeat.o(75602);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75603);
        Log.i("MicroMsg.EditVideoPlayPlugin", "release");
        com.tencent.mm.compatible.util.b bVar = this.jvG;
        if (bVar != null) {
            bVar.apm();
        }
        this.zyd.stop();
        this.zyd.setVideoCallback(null);
        AppMethodBeat.o(75603);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
        AppMethodBeat.i(75604);
        release();
        AppMethodBeat.o(75604);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$gotoClipMode$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ s BRj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(s sVar) {
            this.BRj = sVar;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(75586);
            p.h(animator, "animation");
            AppMethodBeat.o(75586);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(75587);
            p.h(animator, "animation");
            ViewParent parent = this.BRj.zyd.getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(75587);
                throw tVar;
            }
            ((ViewGroup) parent).requestLayout();
            AppMethodBeat.o(75587);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(75588);
            p.h(animator, "animation");
            AppMethodBeat.o(75588);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(75589);
            p.h(animator, "animation");
            AppMethodBeat.o(75589);
        }
    }

    public final void tc(boolean z) {
        int i2;
        AppMethodBeat.i(75605);
        this.BRc = false;
        ViewParent parent = this.zyd.getParent();
        if (parent == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(75605);
            throw tVar;
        }
        ViewPropertyAnimator translationY = ((ViewGroup) parent).animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f);
        p.g(translationY, "(videoPlayView.parent as…eY(1.0f).translationY(0f)");
        translationY.setDuration(300);
        if (!z) {
            this.dvv = 0;
            com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BQt;
            if (bVar != null) {
                i2 = bVar.iqg;
            } else {
                i2 = 10000;
            }
            this.iqg = i2;
        }
        AppMethodBeat.o(75605);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1"})
    public static final class c implements Runnable {
        final /* synthetic */ s BRj;
        final /* synthetic */ TextView BRk;

        public c(TextView textView, s sVar) {
            this.BRk = textView;
            this.BRj = sVar;
        }

        public final void run() {
            String str;
            AppMethodBeat.i(75591);
            final z.f fVar = new z.f();
            com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BRj.BQt;
            if (bVar != null) {
                str = bVar.iqd;
            } else {
                str = null;
            }
            fVar.SYG = (T) com.tencent.mm.plugin.mmsight.d.aFm(str);
            fVar.SYG = (T) (((String) fVar.SYG) + "\n针对拍摄视频：\n");
            StringBuilder append = new StringBuilder().append((String) fVar.SYG).append("是否使用CPU预览裁剪方式：");
            com.tencent.mm.plugin.recordvideo.e.b bVar2 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            fVar.SYG = (T) append.append(com.tencent.mm.plugin.recordvideo.e.b.eME()).append("\n").toString();
            StringBuilder append2 = new StringBuilder().append((String) fVar.SYG).append("是否使用两路流录制：");
            com.tencent.mm.plugin.recordvideo.e.b bVar3 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            fVar.SYG = (T) append2.append(com.tencent.mm.plugin.recordvideo.e.b.eMF()).append("\n").toString();
            StringBuilder append3 = new StringBuilder().append((String) fVar.SYG).append("预览页视频个数：");
            com.tencent.mm.plugin.recordvideo.e.b bVar4 = com.tencent.mm.plugin.recordvideo.e.b.ChY;
            fVar.SYG = (T) append3.append(com.tencent.mm.plugin.recordvideo.e.b.eMG()).append("\n").toString();
            if (Util.isNullOrNil((String) fVar.SYG)) {
                AppMethodBeat.o(75591);
                return;
            }
            if (MMApplicationContext.isMainProcess()) {
                com.tencent.mm.kernel.e aAh = g.aAh();
                p.g(aAh, "storage()");
                if (aAh.azQ().getInt(ar.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, 0) != 1) {
                    AppMethodBeat.o(75591);
                    return;
                }
            }
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.s.c.AnonymousClass1 */
                final /* synthetic */ c BRl;

                {
                    this.BRl = r1;
                }

                public final void run() {
                    AppMethodBeat.i(75590);
                    Log.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", fVar.SYG);
                    this.BRl.BRk.setVisibility(0);
                    this.BRl.BRk.setText(fVar.SYG);
                    AppMethodBeat.o(75590);
                }
            });
            AppMethodBeat.o(75591);
        }
    }
}
