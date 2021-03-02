package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.protocal.protobuf.ckm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001?B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016J\u0006\u00101\u001a\u00020/J\b\u00102\u001a\u00020/H\u0016J\u0006\u00103\u001a\u00020/J\u000e\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020 J\u0014\u00106\u001a\u00020/2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\b08J\u000e\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\u0017J\u001a\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010>\u001a\u00020\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "audioPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "getAudioPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;", "audioStateListeners", "", "Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$AudioStateListener;", "getAudioStateListeners", "()Ljava/util/List;", "setAudioStateListeners", "(Ljava/util/List;)V", "autoPlay", "", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "firstPlay", "getFirstPlay", "setFirstPlay", "firstPlayDelay", "", "getFirstPlayDelay", "()J", "setFirstPlayDelay", "(J)V", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "playRunnable", "Ljava/lang/Runnable;", "getPlayRunnable", "()Ljava/lang/Runnable;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "onBackPress", "onPause", "", "onResume", "pause", "release", "resume", "seekTo", "time", "setLocalAudioList", "audioList", "", "setShow", "show", "setup", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "showMuteOrigin", "AudioStateListener", "plugin-finder_release"})
public final class a implements t {
    public boolean autoPlay;
    final b wgF;
    public AudioCacheInfo wgG;
    boolean wgH = true;
    long wgI = 500;
    public List<Object> wgJ = new ArrayList();
    final Runnable wgK = new RunnableC1321a(this);
    public final EditorAudioView wgL;
    final d wgr;

    public a(EditorAudioView editorAudioView, d dVar) {
        p.h(editorAudioView, "audioPanel");
        p.h(dVar, "status");
        AppMethodBeat.i(254456);
        this.wgL = editorAudioView;
        this.wgr = dVar;
        Context context = this.wgL.getContext();
        p.g(context, "audioPanel.context");
        this.wgF = new b(context);
        this.wgL.setBackground(R.drawable.b1l);
        this.wgL.setOnVisibleChangeCallback(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.finder.video.plugin.a.AnonymousClass1 */
            final /* synthetic */ a wgM;

            {
                this.wgM = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(254442);
                if (bool.booleanValue()) {
                    d.b.a(this.wgM.wgr, d.c.BVg);
                } else {
                    d.b.a(this.wgM.wgr, d.c.BVj);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(254442);
                return xVar;
            }
        });
        EditorAudioView.a(this.wgL, Integer.valueOf((int) R.color.a2), null, Integer.valueOf((int) R.drawable.ax6), null, Integer.valueOf((int) R.raw.popvideo_post_selected_origin), null, null, null, null, null, null, null, false, 16336);
        this.wgL.setCallback(new EditorAudioView.a(this) {
            /* class com.tencent.mm.plugin.finder.video.plugin.a.AnonymousClass2 */
            final /* synthetic */ a wgM;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wgM = r1;
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
            public final void a(AudioCacheInfo audioCacheInfo) {
                AppMethodBeat.i(254443);
                if (p.j(this.wgM.wgG, audioCacheInfo)) {
                    if (this.wgM.wgG != null) {
                        this.wgM.resume();
                    }
                    AppMethodBeat.o(254443);
                } else if (audioCacheInfo == null) {
                    this.wgM.wgG = audioCacheInfo;
                    this.wgM.wgF.eKQ();
                    d.b.a(this.wgM.wgr, d.c.BVl);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", false);
                    this.wgM.wgr.a(d.c.BVm, bundle);
                    this.wgM.wgr.a(d.c.BUI, null);
                    AppMethodBeat.o(254443);
                } else {
                    int i2 = audioCacheInfo.type;
                    AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
                    if (i2 == AudioCacheInfo.BPi) {
                        this.wgM.pause();
                        AppMethodBeat.o(254443);
                        return;
                    }
                    this.wgM.wgG = audioCacheInfo;
                    d.b.a(this.wgM.wgr, d.c.BVl);
                    if (this.wgM.wgH) {
                        this.wgM.wgH = false;
                        this.wgM.wgL.postDelayed(this.wgM.wgK, this.wgM.wgI);
                        AppMethodBeat.o(254443);
                        return;
                    }
                    this.wgM.wgF.d(audioCacheInfo);
                    if (!this.wgM.autoPlay) {
                        this.wgM.pause();
                    }
                    AppMethodBeat.o(254443);
                }
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
            public final void b(AudioCacheInfo audioCacheInfo) {
                AppMethodBeat.i(254444);
                p.h(audioCacheInfo, "info");
                AppMethodBeat.o(254444);
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
            public final void oR(boolean z) {
                AppMethodBeat.i(254445);
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN", z);
                this.wgM.wgr.a(d.c.BVk, bundle);
                AppMethodBeat.o(254445);
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
            public final void pauseAudio() {
                AppMethodBeat.i(254446);
                this.wgM.pause();
                AppMethodBeat.o(254446);
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
            public final void e(boolean z, List<? extends ckm> list) {
                AppMethodBeat.i(254447);
                p.h(list, "lyricsInfos");
                AppMethodBeat.o(254447);
            }
        });
        AppMethodBeat.o(254456);
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
        AppMethodBeat.i(254457);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(254457);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.finder.video.plugin.a$a  reason: collision with other inner class name */
    static final class RunnableC1321a implements Runnable {
        final /* synthetic */ a wgM;

        RunnableC1321a(a aVar) {
            this.wgM = aVar;
        }

        public final void run() {
            AppMethodBeat.i(254448);
            this.wgM.wgF.d(this.wgM.wgG);
            if (!this.wgM.autoPlay) {
                this.wgM.wgF.pauseAudio();
            }
            AppMethodBeat.o(254448);
        }
    }

    public final void seekTo(long j2) {
        AppMethodBeat.i(254449);
        this.wgF.seekTo(j2);
        AppMethodBeat.o(254449);
    }

    public final void pause() {
        AppMethodBeat.i(254450);
        this.wgF.pauseAudio();
        Iterator<T> it = this.wgJ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(254450);
    }

    public final void resume() {
        AppMethodBeat.i(254451);
        this.wgF.eKR();
        Iterator<T> it = this.wgJ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(254451);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(254452);
        if (this.wgL.bJw()) {
            this.wgL.setShow(false);
            AppMethodBeat.o(254452);
            return true;
        }
        AppMethodBeat.o(254452);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(254453);
        pause();
        AppMethodBeat.o(254453);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        AppMethodBeat.i(254454);
        if (this.autoPlay && this.wgG != null) {
            resume();
        }
        AppMethodBeat.o(254454);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(254455);
        this.wgG = null;
        this.wgF.release();
        this.wgL.destroy();
        AppMethodBeat.o(254455);
    }
}
