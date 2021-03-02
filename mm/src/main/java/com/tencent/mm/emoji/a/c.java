package com.tencent.mm.emoji.a;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\u0010\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\u0010J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0002J\u0016\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u0004J\u0006\u00108\u001a\u00020.J\u001e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\bJ\u000e\u00109\u001a\u00020.2\u0006\u0010>\u001a\u00020?R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "", "()V", "TAG", "", "animDrawable", "Lcom/tencent/mm/plugin/gif/MMWXGFDrawable;", "animStartTextColor", "", "animView", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "delayRecycle", "Ljava/lang/Runnable;", "isPlaying", "", "itemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "msgId", "", "getMsgId", "()J", "setMsgId", "(J)V", "playingConfig", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "reporter", "Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;", "getReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;", "setReporter", "(Lcom/tencent/mm/autogen/mmdata/rpt/AnimateEmojiReportStruct;)V", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "screenEffectTask", "stateCallback", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "getStateCallback", "()Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "setStateCallback", "(Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;)V", "uiRefreshed", "afterAnim", "", "beforeAnim", "bindItemView", "textView", "recordTextView", "restore", "restoreTextView", "setPlayingConfig", "config", "filePath", "stop", "updateView", "centerX", "", "centerY", "size", "rootLocation", "", "AnimCallback", "plugin-emojisdk_release"})
public final class c {
    final String TAG = "MicroMsg.EmojiAnimViewHolder";
    FrameLayout gUY;
    MMAnimateView gUZ;
    MMNeat7extView gVa;
    h gVb;
    b.a gVc;
    boolean gVd;
    private boolean gVe;
    private int gVf = WebView.NIGHT_MODE_COLOR;
    Runnable gVg = new RunnableC0318c(this);
    Runnable gVh = new b(this);
    com.tencent.mm.g.b.a.l gVi;
    a gVj;
    public long msgId;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder$AnimCallback;", "", "onEnd", "", "onPlayScreenEffect", "msgId", "", "effect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "onRecycle", "holder", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "played", "", "onScreenEffect", "onStart", "plugin-emojisdk_release"})
    public interface a {
        void a(long j2, b.C0317b bVar);

        void a(b.C0317b bVar);

        void a(c cVar);
    }

    public c() {
        AppMethodBeat.i(199883);
        AppMethodBeat.o(199883);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.emoji.a.c$c  reason: collision with other inner class name */
    static final class RunnableC0318c implements Runnable {
        final /* synthetic */ c gVk;

        RunnableC0318c(c cVar) {
            this.gVk = cVar;
        }

        public final void run() {
            b.C0317b bVar;
            AppMethodBeat.i(199876);
            b.a aVar = this.gVk.gVc;
            if (aVar == null || (bVar = aVar.gUX) == null) {
                AppMethodBeat.o(199876);
                return;
            }
            a aVar2 = this.gVk.gVj;
            if (aVar2 != null) {
                aVar2.a(this.gVk.msgId, bVar);
                AppMethodBeat.o(199876);
                return;
            }
            AppMethodBeat.o(199876);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ c gVk;

        b(c cVar) {
            this.gVk = cVar;
        }

        public final void run() {
            AppMethodBeat.i(199875);
            if (!this.gVk.gVd) {
                Log.i(this.gVk.TAG, "delay: recycle");
                this.gVk.restore();
                a aVar = this.gVk.gVj;
                if (aVar != null) {
                    aVar.a(this.gVk);
                    AppMethodBeat.o(199875);
                    return;
                }
            }
            AppMethodBeat.o(199875);
        }
    }

    public final boolean b(MMNeat7extView mMNeat7extView) {
        AppMethodBeat.i(199880);
        if (!p.j(this.gVa, mMNeat7extView)) {
            aut();
            this.gVa = mMNeat7extView;
            MMNeat7extView mMNeat7extView2 = this.gVa;
            this.gVf = mMNeat7extView2 != null ? mMNeat7extView2.getCurrentTextColor() : this.gVf;
            MMNeat7extView mMNeat7extView3 = this.gVa;
            if (mMNeat7extView3 != null) {
                mMNeat7extView3.setTextColor(0);
            }
            Log.i(this.TAG, "recordTextView: " + this.gVa + ", color:" + this.gVf);
        }
        if (this.gVa == null) {
            if (this.gVd) {
                Log.i(this.TAG, "bindItemView: null");
                restore();
                AppMethodBeat.o(199880);
                return true;
            } else if (!this.gVe) {
                com.tencent.mm.ac.d.a(200, this.gVh);
            }
        }
        this.gVe = true;
        AppMethodBeat.o(199880);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/emoji/egg/EmojiAnimViewHolder$updateView$1$1"})
    static final class d implements Runnable {
        final /* synthetic */ c gVk;
        final /* synthetic */ MMAnimateView gVl;

        d(MMAnimateView mMAnimateView, c cVar) {
            this.gVl = mMAnimateView;
            this.gVk = cVar;
        }

        public final void run() {
            AppMethodBeat.i(199879);
            h hVar = this.gVk.gVb;
            if (hVar != null) {
                hVar.resume();
            }
            h hVar2 = this.gVk.gVb;
            if (hVar2 != null) {
                hVar2.au(new Runnable(this) {
                    /* class com.tencent.mm.emoji.a.c.d.AnonymousClass1 */
                    final /* synthetic */ d gVm;

                    {
                        this.gVm = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(199878);
                        h hVar = this.gVm.gVk.gVb;
                        if (hVar != null) {
                            hVar.pause();
                        }
                        this.gVm.gVl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).withEndAction(new Runnable(this) {
                            /* class com.tencent.mm.emoji.a.c.d.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 gVn;

                            {
                                this.gVn = r1;
                            }

                            public final void run() {
                                b.C0317b bVar;
                                AppMethodBeat.i(199877);
                                c cVar = this.gVn.gVm.gVk;
                                if (cVar.gVd) {
                                    b.a aVar = cVar.gVc;
                                    if (!(aVar == null || (bVar = aVar.gUX) == null || bVar.delay != -1)) {
                                        cVar.gVg.run();
                                    }
                                    com.tencent.mm.ac.d.C(cVar.gVg);
                                    cVar.restore();
                                    cVar.msgId = 0;
                                    cVar.gVa = null;
                                    a aVar2 = cVar.gVj;
                                    if (aVar2 != null) {
                                        aVar2.a(cVar);
                                        AppMethodBeat.o(199877);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(199877);
                            }
                        });
                        AppMethodBeat.o(199878);
                    }
                });
                AppMethodBeat.o(199879);
                return;
            }
            AppMethodBeat.o(199879);
        }
    }

    public final void stop() {
        AppMethodBeat.i(261733);
        Log.i(this.TAG, "stop: ");
        restore();
        AppMethodBeat.o(261733);
    }

    /* access modifiers changed from: package-private */
    public final void restore() {
        ViewPropertyAnimator animate;
        AppMethodBeat.i(199881);
        com.tencent.mm.ac.d.C(this.gVg);
        com.tencent.mm.ac.d.C(this.gVh);
        h hVar = this.gVb;
        if (hVar != null) {
            hVar.recycle();
        }
        this.gVb = null;
        MMAnimateView mMAnimateView = this.gUZ;
        if (mMAnimateView != null) {
            mMAnimateView.setVisibility(8);
        }
        MMAnimateView mMAnimateView2 = this.gUZ;
        if (!(mMAnimateView2 == null || (animate = mMAnimateView2.animate()) == null)) {
            animate.cancel();
        }
        MMAnimateView mMAnimateView3 = this.gUZ;
        if (mMAnimateView3 != null) {
            mMAnimateView3.setScaleX(1.0f);
        }
        MMAnimateView mMAnimateView4 = this.gUZ;
        if (mMAnimateView4 != null) {
            mMAnimateView4.setScaleY(1.0f);
        }
        aut();
        this.gVd = false;
        AppMethodBeat.o(199881);
    }

    private final void aut() {
        MMNeat7extView mMNeat7extView;
        AppMethodBeat.i(199882);
        MMNeat7extView mMNeat7extView2 = this.gVa;
        int currentTextColor = mMNeat7extView2 != null ? mMNeat7extView2.getCurrentTextColor() : 0;
        if (currentTextColor == 0 && (mMNeat7extView = this.gVa) != null) {
            mMNeat7extView.setTextColor(this.gVf);
        }
        Log.i(this.TAG, "restoreTextView: " + this.gVa + ", " + currentTextColor);
        AppMethodBeat.o(199882);
    }
}
