package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.recordvideo.background.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0004+,-.B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\tJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\"J\u001e\u0010%\u001a\u00020\"2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00150'j\b\u0012\u0004\u0012\u00020\u0015`(J\u0006\u0010)\u001a\u00020\"J\u0006\u0010*\u001a\u00020\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;)V", "canResume", "", "curImageList", "", "", "curPos", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "playStatus", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$STATUS;", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "surfaceAvailable", "task", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "getCurPos", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "isPlaying", "pause", AssetExtension.SCENE_PLAY, "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "resume", "stop", "Callback", "Companion", "STATUS", "VideoLoopTask", "plugin-recordvideo_release"})
public final class StoryFakeVideoPlayView extends TextureView {
    public static final b Cen = new b((byte) 0);
    public static final String TAG = TAG;
    private h BLs;
    private com.tencent.mm.plugin.recordvideo.background.b.c BLt;
    public c Ceh = c.STOP;
    private boolean Cei;
    private a Cej;
    private d Cek;
    boolean Cel;
    private List<String> Cem;
    private int uis;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "", "onPrepared", "", "plugin-recordvideo_release"})
    public interface a {
        void tf();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$STATUS;", "", "(Ljava/lang/String;I)V", "STOP", "PLAYING", "PAUSE", "plugin-recordvideo_release"})
    public enum c {
        STOP,
        PLAYING,
        PAUSE;

        static {
            AppMethodBeat.i(76048);
            AppMethodBeat.o(76048);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(76050);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(76050);
            return cVar;
        }
    }

    public static final /* synthetic */ h c(StoryFakeVideoPlayView storyFakeVideoPlayView) {
        AppMethodBeat.i(76067);
        h hVar = storyFakeVideoPlayView.BLs;
        if (hVar == null) {
            p.btv("render");
        }
        AppMethodBeat.o(76067);
        return hVar;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.recordvideo.background.b.c d(StoryFakeVideoPlayView storyFakeVideoPlayView) {
        AppMethodBeat.i(76068);
        com.tencent.mm.plugin.recordvideo.background.b.c cVar = storyFakeVideoPlayView.BLt;
        if (cVar == null) {
            p.btv("glThread");
        }
        AppMethodBeat.o(76068);
        return cVar;
    }

    public StoryFakeVideoPlayView(Context context) {
        super(context);
        AppMethodBeat.i(76063);
        init();
        AppMethodBeat.o(76063);
    }

    public StoryFakeVideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(76064);
        init();
        AppMethodBeat.o(76064);
    }

    public StoryFakeVideoPlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(76065);
        init();
        AppMethodBeat.o(76065);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-recordvideo_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(76066);
        AppMethodBeat.o(76066);
    }

    public final a getCallback() {
        return this.Cej;
    }

    public final void setCallback(a aVar) {
        this.Cej = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-recordvideo_release"})
    public static final class e implements TextureView.SurfaceTextureListener {
        final /* synthetic */ StoryFakeVideoPlayView Ces;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(StoryFakeVideoPlayView storyFakeVideoPlayView) {
            this.Ces = storyFakeVideoPlayView;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(76055);
            b bVar = StoryFakeVideoPlayView.Cen;
            Log.i(StoryFakeVideoPlayView.TAG, "onSurfaceTextureSizeChanged");
            AppMethodBeat.o(76055);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(76056);
            b bVar = StoryFakeVideoPlayView.Cen;
            Log.i(StoryFakeVideoPlayView.TAG, "onSurfaceTextureUpdated");
            AppMethodBeat.o(76056);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(76057);
            b bVar = StoryFakeVideoPlayView.Cen;
            Log.i(StoryFakeVideoPlayView.TAG, "onSurfaceTextureDestroyed");
            this.Ces.Cei = false;
            StoryFakeVideoPlayView.d(this.Ces).stop();
            AppMethodBeat.o(76057);
            return true;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(76058);
            this.Ces.BLt = new com.tencent.mm.plugin.recordvideo.background.b.c(surfaceTexture, StoryFakeVideoPlayView.c(this.Ces));
            StoryFakeVideoPlayView.d(this.Ces).start();
            StoryFakeVideoPlayView.d(this.Ces).dL(i2, i3);
            com.tencent.mm.plugin.recordvideo.background.b.c d2 = StoryFakeVideoPlayView.d(this.Ces);
            com.tencent.mm.plugin.recordvideo.b.e eVar = com.tencent.mm.plugin.recordvideo.b.e.BNm;
            d2.setFrameRate(com.tencent.mm.plugin.recordvideo.b.e.getFrameRate());
            this.Ces.Cei = true;
            b bVar = StoryFakeVideoPlayView.Cen;
            Log.i(StoryFakeVideoPlayView.TAG, "onSurfaceTextureAvailable");
            AppMethodBeat.o(76058);
        }
    }

    private void init() {
        AppMethodBeat.i(76059);
        this.BLs = new h();
        setSurfaceTextureListener(new e(this));
        AppMethodBeat.o(76059);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;Ljava/util/ArrayList;)V", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "getKey", "run", "", "plugin-recordvideo_release"})
    public final class d implements com.tencent.f.i.h {
        private ArrayList<String> BLy;
        final /* synthetic */ StoryFakeVideoPlayView Ces;
        boolean stop;

        public d(StoryFakeVideoPlayView storyFakeVideoPlayView, ArrayList<String> arrayList) {
            p.h(arrayList, "imageList");
            this.Ces = storyFakeVideoPlayView;
            AppMethodBeat.i(76054);
            this.BLy = arrayList;
            AppMethodBeat.o(76054);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "Story_VideoLoopTask";
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 138
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
            */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 257
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView.d.run():void");
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ d Cet;

            b(d dVar) {
                this.Cet = dVar;
            }

            public final void run() {
                AppMethodBeat.i(76052);
                StoryFakeVideoPlayView.c(this.Cet.Ces).startTime = 0;
                AppMethodBeat.o(76052);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$VideoLoopTask$run$2$1"})
        static final class a implements Runnable {
            final /* synthetic */ d Cet;

            a(d dVar) {
                this.Cet = dVar;
            }

            public final void run() {
                AppMethodBeat.i(76051);
                a callback = this.Cet.Ces.getCallback();
                if (callback != null) {
                    callback.tf();
                }
                this.Cet.Ces.setCallback(null);
                AppMethodBeat.o(76051);
            }
        }
    }

    public final void aK(ArrayList<String> arrayList) {
        int size;
        boolean z = false;
        AppMethodBeat.i(76060);
        p.h(arrayList, "imageList");
        Log.i(TAG, AssetExtension.SCENE_PLAY);
        d dVar = this.Cek;
        if (dVar != null) {
            List<String> list = this.Cem;
            if (list != null) {
                if (list.size() == arrayList.size() && arrayList.size() - 1 >= 0) {
                    int i2 = 0;
                    while (true) {
                        if (Util.isEqual(arrayList.get(i2), list.get(i2))) {
                            if (i2 == size) {
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
                z = true;
            } else {
                z = true;
            }
            if (!z || dVar.stop) {
                dVar.stop = true;
            } else {
                Log.i(TAG, "play same imagelist, do nothing");
                AppMethodBeat.o(76060);
                return;
            }
        }
        this.Cem = arrayList;
        this.Cek = new d(this, arrayList);
        i iVar = com.tencent.f.h.RTc;
        d dVar2 = this.Cek;
        if (dVar2 == null) {
            p.hyc();
        }
        iVar.ba(dVar2);
        AppMethodBeat.o(76060);
    }

    public final int getCurPos() {
        return this.uis;
    }

    public final void resume() {
        AppMethodBeat.i(76061);
        Log.i(TAG, "resume");
        this.Ceh = c.PLAYING;
        AppMethodBeat.o(76061);
    }

    public final void stop() {
        AppMethodBeat.i(76062);
        Log.i(TAG, "stop");
        this.Ceh = c.STOP;
        d dVar = this.Cek;
        if (dVar != null) {
            dVar.stop = true;
            AppMethodBeat.o(76062);
            return;
        }
        AppMethodBeat.o(76062);
    }
}
