package com.tencent.mm.videocomposition.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.play.a;
import com.tencent.tav.player.Player;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001c\b\u0016\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\b\u0010/\u001a\u00020\"H\u0014J\u0006\u00100\u001a\u00020\"J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u00020\u0015J\u0006\u00105\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\u0015J\"\u00108\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016J\u0012\u00109\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\"\u0010:\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0016J\u0012\u0010;\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010<\u001a\u00020\u0015H\u0016J\u0006\u0010=\u001a\u00020\"J\u0006\u0010>\u001a\u00020\"J\u000e\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u000202J\u000e\u0010A\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u0015J@\u0010B\u001a\u00020\"28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dJ\u0016\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u0002022\u0006\u0010E\u001a\u000202J\u0010\u0010F\u001a\u00020\"2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010G\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010D\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010H\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010I\u001a\u00020\"H\u0016J(\u0010J\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00152\u0006\u0010?\u001a\u000202H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R@\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, hxF = {"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getComposition", "()Lcom/tencent/mm/videocomposition/VideoComposition;", "setComposition", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "firstFrame", "", "getFirstFrame", "()Z", "setFirstFrame", "(Z)V", "isStarted", "loop", "onSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "player", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "getPlayer", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "setPlayer", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;)V", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceHeight", "surfaceWidth", "createPlayer", "flushSurface", "getLaggingTime", "", "getPosition", "isLoop", "isPlaying", "muteOrigin", "mute", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "resume", "seekTo", "timeMs", "setLoop", "setOnSizeChangedListener", "setPlayRange", "start", "end", "setPlayerCallback", "setPlayerProfileCallback", "startWithUpdateComposition", "stop", "updateComposition", "playAfterUpdate", "seekToOriginPosition", "Companion", "video_composition_release"})
public class VideoCompositionPlayView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final a RhF = new a((byte) 0);
    public static final String TAG = TAG;
    private m<? super Integer, ? super Integer, x> GOp;
    public n Gez;
    public a RhC;
    private a.C2159a.AbstractC2160a RhD;
    private a.C2159a.c RhE;
    private boolean ihq = true;
    protected boolean isStarted;
    public boolean loop = true;
    private int surfaceHeight;
    private int surfaceWidth;
    private SurfaceTexture zCV;

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView$Companion;", "", "()V", "TAG", "", "video_composition_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(216818);
        AppMethodBeat.o(216818);
    }

    public VideoCompositionPlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(216815);
        setSurfaceTextureListener(this);
        b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
        AppMethodBeat.o(216815);
    }

    public VideoCompositionPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(216816);
        setSurfaceTextureListener(this);
        b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
        AppMethodBeat.o(216816);
    }

    public VideoCompositionPlayView(Context context) {
        super(context);
        AppMethodBeat.i(216817);
        setSurfaceTextureListener(this);
        b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
        AppMethodBeat.o(216817);
    }

    /* access modifiers changed from: protected */
    public final a getPlayer() {
        return this.RhC;
    }

    /* access modifiers changed from: protected */
    public final void setPlayer(a aVar) {
        this.RhC = aVar;
    }

    /* access modifiers changed from: protected */
    public final n getComposition() {
        return this.Gez;
    }

    /* access modifiers changed from: protected */
    public final void setComposition(n nVar) {
        this.Gez = nVar;
    }

    /* access modifiers changed from: protected */
    public final boolean getFirstFrame() {
        return this.ihq;
    }

    /* access modifiers changed from: protected */
    public final void setFirstFrame(boolean z) {
        this.ihq = z;
    }

    public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, x> mVar) {
        this.GOp = mVar;
    }

    public final void setPlayerCallback(a.C2159a.AbstractC2160a aVar) {
        a aVar2;
        AppMethodBeat.i(216796);
        if (!(this.RhC == null || (aVar2 = this.RhC) == null)) {
            aVar2.setPlayerCallback(aVar);
        }
        this.RhD = aVar;
        AppMethodBeat.o(216796);
    }

    public final void setPlayerProfileCallback(a.C2159a.c cVar) {
        this.RhE = cVar;
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.RhE = cVar;
        }
    }

    public final void at(long j2, long j3) {
        AppMethodBeat.i(216797);
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.at(j2, j3);
            AppMethodBeat.o(216797);
            return;
        }
        AppMethodBeat.o(216797);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(216798);
        b.i(TAG, "surfaceSizeChanged, surfaceTexture:" + getSurfaceTexture() + ", width:" + i2 + ", height:" + i3, new Object[0]);
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.lX(i2, i3);
        }
        m<? super Integer, ? super Integer, x> mVar = this.GOp;
        if (mVar != null) {
            mVar.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(216798);
            return;
        }
        AppMethodBeat.o(216798);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(216799);
        if (this.ihq && this.isStarted) {
            b.i(TAG, "onSurfaceTextureUpdated", new Object[0]);
            a.C2159a.AbstractC2160a aVar = this.RhD;
            if (aVar != null) {
                aVar.dEU();
            }
            this.ihq = false;
        }
        a.C2159a.AbstractC2160a aVar2 = this.RhD;
        if (!(aVar2 instanceof a.C2159a.b)) {
            aVar2 = null;
        }
        a.C2159a.b bVar = (a.C2159a.b) aVar2;
        if (bVar != null) {
            bVar.dEW();
            AppMethodBeat.o(216799);
            return;
        }
        AppMethodBeat.o(216799);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(216800);
        b.i(TAG, "surfaceDestroy", new Object[0]);
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.release();
        }
        this.surfaceWidth = 0;
        this.surfaceHeight = 0;
        this.zCV = null;
        AppMethodBeat.o(216800);
        return false;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        a aVar;
        AppMethodBeat.i(216801);
        b.i(TAG, "surfaceAvailable, surfaceTexture:" + getSurfaceTexture() + ", width:" + i2 + ", height:" + i3, new Object[0]);
        this.zCV = surfaceTexture;
        this.surfaceWidth = i2;
        this.surfaceHeight = i3;
        if (this.Gez != null) {
            dFu();
            if (this.isStarted && (aVar = this.RhC) != null) {
                aVar.start();
                AppMethodBeat.o(216801);
                return;
            }
        }
        AppMethodBeat.o(216801);
    }

    public void a(n nVar) {
        AppMethodBeat.i(216802);
        p.h(nVar, "composition");
        b.printInfoStack(TAG, hashCode() + " start, surface:" + this.zCV + ", player:" + this.RhC + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", composition:" + nVar.hashCode(), new Object[0]);
        if (this.RhC != null && this.zCV != null && this.surfaceWidth > 0 && this.surfaceHeight > 0 && (!p.j(nVar, this.Gez))) {
            b.i(TAG, "startWithUpdateComposition", new Object[0]);
            a aVar = this.RhC;
            if (aVar != null) {
                a.a(aVar, nVar, true, 0, 12);
            }
            this.Gez = nVar;
            AppMethodBeat.o(216802);
        } else if (!p.j(nVar, this.Gez)) {
            this.Gez = nVar;
            if (this.zCV != null && this.surfaceWidth > 0 && this.surfaceHeight > 0) {
                dFu();
            }
            this.isStarted = true;
            a aVar2 = this.RhC;
            if (aVar2 != null) {
                aVar2.start();
                AppMethodBeat.o(216802);
                return;
            }
            AppMethodBeat.o(216802);
        } else if (this.zCV != null) {
            b.i(TAG, "same composition directly start", new Object[0]);
            this.isStarted = true;
            a aVar3 = this.RhC;
            if (aVar3 != null) {
                a.a(aVar3, nVar, true, 0, 12);
                AppMethodBeat.o(216802);
                return;
            }
            AppMethodBeat.o(216802);
        } else {
            b.i(TAG, "same composition but surface is null", new Object[0]);
            this.isStarted = true;
            AppMethodBeat.o(216802);
        }
    }

    /* access modifiers changed from: protected */
    public void dFu() {
        a aVar;
        AppMethodBeat.i(216803);
        if (!(this.Gez == null || this.zCV == null)) {
            b.i(TAG, "do createPlayer, composition:" + this.Gez, new Object[0]);
            n nVar = this.Gez;
            if (nVar == null) {
                p.hyc();
            }
            this.RhC = new a(nVar);
            a aVar2 = this.RhC;
            if (aVar2 != null) {
                SurfaceTexture surfaceTexture = this.zCV;
                if (surfaceTexture == null) {
                    p.hyc();
                }
                aVar2.c(surfaceTexture, this.surfaceWidth, this.surfaceHeight);
            }
            a aVar3 = this.RhC;
            if (aVar3 != null) {
                aVar3.setLoop(this.loop);
            }
            if (!(this.RhD == null || (aVar = this.RhC) == null)) {
                aVar.setPlayerCallback(this.RhD);
            }
            a aVar4 = this.RhC;
            if (aVar4 != null) {
                aVar4.RhE = this.RhE;
                AppMethodBeat.o(216803);
                return;
            }
        }
        AppMethodBeat.o(216803);
    }

    public final void DB(boolean z) {
        AppMethodBeat.i(216804);
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.DB(z);
            AppMethodBeat.o(216804);
            return;
        }
        AppMethodBeat.o(216804);
    }

    public boolean pause() {
        AppMethodBeat.i(216805);
        b.i(TAG, "pause", new Object[0]);
        this.isStarted = false;
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.pause();
        }
        AppMethodBeat.o(216805);
        return true;
    }

    public final void resume() {
        AppMethodBeat.i(216806);
        b.i(TAG, "resume", new Object[0]);
        this.isStarted = true;
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.start();
            AppMethodBeat.o(216806);
            return;
        }
        AppMethodBeat.o(216806);
    }

    public void stop() {
        AppMethodBeat.i(216807);
        b.i(TAG, "stop", new Object[0]);
        this.isStarted = false;
        this.ihq = true;
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.stop();
            AppMethodBeat.o(216807);
            return;
        }
        AppMethodBeat.o(216807);
    }

    public final void release() {
        AppMethodBeat.i(216808);
        b.i(TAG, "release", new Object[0]);
        this.isStarted = false;
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.release();
            AppMethodBeat.o(216808);
            return;
        }
        AppMethodBeat.o(216808);
    }

    public final void seekTo(long j2) {
        AppMethodBeat.i(216809);
        b.i(TAG, "seekTo:".concat(String.valueOf(j2)), new Object[0]);
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.seekTo(j2);
            AppMethodBeat.o(216809);
            return;
        }
        AppMethodBeat.o(216809);
    }

    public final void setLoop(boolean z) {
        AppMethodBeat.i(216810);
        b.i(TAG, "setLoop:".concat(String.valueOf(z)), new Object[0]);
        this.loop = z;
        if (this.RhC != null) {
            a aVar = this.RhC;
            if (aVar != null) {
                aVar.setLoop(z);
                AppMethodBeat.o(216810);
                return;
            }
            AppMethodBeat.o(216810);
            return;
        }
        this.loop = z;
        AppMethodBeat.o(216810);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(216811);
        a aVar = this.RhC;
        if (aVar != null) {
            Player player = aVar.player;
            if (player != null) {
                boolean isPlaying = player.isPlaying();
                AppMethodBeat.o(216811);
                return isPlaying;
            }
            AppMethodBeat.o(216811);
            return false;
        }
        AppMethodBeat.o(216811);
        return false;
    }

    public final void bLe() {
        AppMethodBeat.i(216812);
        a aVar = this.RhC;
        if (aVar != null) {
            aVar.hft();
            AppMethodBeat.o(216812);
            return;
        }
        AppMethodBeat.o(216812);
    }

    public final long getPosition() {
        AppMethodBeat.i(216813);
        a aVar = this.RhC;
        if (aVar != null) {
            long hfu = aVar.hfu();
            AppMethodBeat.o(216813);
            return hfu;
        }
        AppMethodBeat.o(216813);
        return 0;
    }

    public final long getLaggingTime() {
        AppMethodBeat.i(216814);
        a aVar = this.RhC;
        if (aVar != null) {
            long laggingTime = aVar.playerItem.getLaggingTime();
            AppMethodBeat.o(216814);
            return laggingTime;
        }
        AppMethodBeat.o(216814);
        return 0;
    }
}
