package com.tencent.mm.plugin.story.proxy;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0010*\u0001\u001d\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020#H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u00100\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0006H\u0016J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020/H\u0002J\b\u0010:\u001a\u00020/H\u0002J\u0012\u0010;\u001a\u00020/2\b\u0010<\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010=\u001a\u00020/2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020#H\u0016J\u001a\u0010@\u001a\u00020/2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010B\u001a\u00020/H\u0016J\b\u0010C\u001a\u00020/H\u0002J\b\u0010D\u001a\u00020/H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy;", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MSG_HANDLE_SINGLE_TAB", "", "animator", "Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "avatarRight", "", "avatarTop", "badgeBgPaint", "Landroid/graphics/Paint;", "badgeRadius", "blueHintDrawable", "Landroid/graphics/drawable/Drawable;", "defaultHintColor", "doubleClickListener", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy$OnDoubleClickListener;", "hintHeight", "hintMarginEnd", "hintMarginTop", "hintWidth", "host", "Landroid/view/View;", "mClickListener", "Landroid/view/View$OnClickListener;", "mHandler", "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1;", "mOriginalClickListener", "originAvatarSize", "pageType", "showStoryHint", "", "userName", "", "weakContext", "Ljava/lang/ref/WeakReference;", "whiteHintDrawable", "checkConfigEnableAnimation", "checkDrawable", "highLight", "getDoubleClickListener", "goStoryGallery", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onDrawWithHint", "canvas", "Landroid/graphics/Canvas;", "hintHighLight", "hintBgColor", "onMeasureWithHint", "", "measureWidth", "measureHeight", "performDoubleClick", "report", "setOnClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnDoubleClickListener", "setShowStoryHint", "show", "setUserNameAndPageNumber", "setWeakContext", "showNoStoryAnimation", "simpleShake", "updateDot", "Companion", "plugin-story_release"})
public final class b implements i {
    public static final a Fts = new a((byte) 0);
    private static final String TAG = TAG;
    private boolean FsZ;
    private int Fta;
    private int Ftb;
    private Drawable Ftc;
    private Drawable Ftd;
    private int Fte;
    private int Ftf;
    private int Ftg;
    private float Fth;
    private float Fti;
    private float Ftj;
    private Paint Ftk;
    private View Ftl;
    private final com.tencent.mm.plugin.story.a.b Ftm = new com.tencent.mm.plugin.story.a.b();
    private int Ftn = -1;
    private final int Fto;
    private final C1770b Ftp = new C1770b(this);
    private i.a Ftq;
    private final View.OnClickListener Ftr = new c(this);
    private final Context context;
    private View.OnClickListener hEZ;
    private WeakReference<Context> ooi;
    private int pageType = -1;
    private String userName;

    public b(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(119376);
        this.context = context2;
        AppMethodBeat.o(119376);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.proxy.b$b  reason: collision with other inner class name */
    public static final class C1770b extends MMHandler {
        final /* synthetic */ b Ftt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1770b(b bVar) {
            this.Ftt = bVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            View.OnClickListener onClickListener;
            AppMethodBeat.i(119367);
            if ((message != null ? message.obj : null) == null || !(message.obj instanceof View) || message.what != this.Ftt.Fto || (onClickListener = this.Ftt.hEZ) == null) {
                AppMethodBeat.o(119367);
                return;
            }
            Object obj = message.obj;
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(119367);
                throw tVar;
            }
            onClickListener.onClick((View) obj);
            AppMethodBeat.o(119367);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "Landroid/view/View$OnClickListener;", "lastClick", "", "onClick", "", "view", "Landroid/view/View;", "plugin-story_release"})
    public static final class c implements View.OnClickListener {
        private long Dal;
        final /* synthetic */ b Ftt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(b bVar) {
            this.Ftt = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119368);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.h(view, "view");
            long nowMilliSecond = Util.nowMilliSecond();
            this.Ftt.Ftp.removeMessages(this.Ftt.Fto);
            this.Ftt.Ftp.sendMessageDelayed(this.Ftt.Ftp.obtainMessage(this.Ftt.Fto, view), (long) ViewConfiguration.getDoubleTapTimeout());
            Log.d(b.TAG, "onClick lastClick=%s now=%s", Long.valueOf(this.Dal), Long.valueOf(nowMilliSecond));
            if (nowMilliSecond - this.Dal < ((long) ViewConfiguration.getDoubleTapTimeout())) {
                this.Ftt.Ftp.removeMessages(this.Ftt.Fto);
                b.d(this.Ftt);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119368);
                return;
            }
            this.Dal = nowMilliSecond;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/proxy/StoryHintProxy$mOriginalClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119368);
        }
    }

    @Override // com.tencent.mm.plugin.story.api.i
    public final void ba(View view) {
        AppMethodBeat.i(119370);
        p.h(view, "host");
        this.Ftl = view;
        this.Fta = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
        this.Ftb = com.tencent.mm.cb.a.fromDPToPix(this.context, 2);
        this.Ftj = (float) com.tencent.mm.cb.a.fromDPToPix(this.context, 6);
        this.Ftg = view.getResources().getDimensionPixelSize(R.dimen.jx);
        this.Ftk = new Paint();
        Paint paint = this.Ftk;
        if (paint != null) {
            paint.setAntiAlias(true);
        }
        Paint paint2 = this.Ftk;
        if (paint2 != null) {
            paint2.setAlpha(0);
        }
        Paint paint3 = this.Ftk;
        if (paint3 != null) {
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        this.Ftn = context2.getResources().getColor(R.color.aaj);
        AppMethodBeat.o(119370);
    }

    @Override // com.tencent.mm.plugin.story.api.i
    public final void a(Canvas canvas, boolean z, int i2) {
        Drawable drawable;
        AppMethodBeat.i(119371);
        p.h(canvas, "canvas");
        if (!o.isShowStoryCheck()) {
            AppMethodBeat.o(119371);
            return;
        }
        View view = this.Ftl;
        if (view != null) {
            int width = (view.getWidth() - this.Ftg) / 2;
            if (view.getWidth() > this.Ftg) {
                this.Fti = (float) (this.Ftg + width);
                this.Fth = (float) width;
            }
            if (this.FsZ) {
                Paint paint = this.Ftk;
                if (paint != null) {
                    paint.setColor(i2);
                }
                Paint paint2 = this.Ftk;
                if (paint2 != null) {
                    canvas.drawCircle(((float) view.getWidth()) - this.Ftj, this.Ftj, this.Ftj, paint2);
                }
                if (z) {
                    if (this.Ftc == null) {
                        com.tencent.mm.kernel.b.a ah = g.ah(e.class);
                        p.g(ah, "plugin(IPluginStory::class.java)");
                        Drawable vJ = ((e) ah).getStoryUIFactory().vJ(true);
                        this.Ftc = vJ;
                        p.g(vJ, "drawable");
                        this.Ftf = vJ.getBounds().right;
                        this.Fte = vJ.getBounds().bottom;
                    }
                    drawable = this.Ftc;
                } else {
                    if (this.Ftd == null) {
                        com.tencent.mm.kernel.b.a ah2 = g.ah(e.class);
                        p.g(ah2, "plugin(IPluginStory::class.java)");
                        Drawable vJ2 = ((e) ah2).getStoryUIFactory().vJ(false);
                        this.Ftd = vJ2;
                        p.g(vJ2, "drawable");
                        this.Ftf = vJ2.getBounds().right;
                        this.Fte = vJ2.getBounds().bottom;
                    }
                    drawable = this.Ftd;
                }
                canvas.save();
                canvas.translate((float) ((view.getWidth() - this.Ftf) - this.Fta), (float) this.Ftb);
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                canvas.restore();
            }
            AppMethodBeat.o(119371);
            return;
        }
        AppMethodBeat.o(119371);
    }

    @Override // com.tencent.mm.plugin.story.api.i
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != this.Ftr) {
            this.hEZ = onClickListener;
        }
    }

    @Override // com.tencent.mm.plugin.story.api.i
    public final void setShowStoryHint(boolean z) {
        AppMethodBeat.i(119372);
        if (com.tencent.mm.plugin.sns.f.a.aOF(this.userName)) {
            z = false;
        }
        if (this.FsZ != z) {
            this.FsZ = z;
            View view = this.Ftl;
            if (view != null) {
                view.invalidate();
                AppMethodBeat.o(119372);
                return;
            }
        }
        AppMethodBeat.o(119372);
    }

    @Override // com.tencent.mm.plugin.story.api.i
    public final void fL(String str, int i2) {
        this.userName = str;
        this.pageType = i2;
    }

    private final void report() {
        AppMethodBeat.i(119373);
        h hVar = h.FuH;
        h.fqi().sm(this.FsZ ? 1 : 0);
        h hVar2 = h.FuH;
        jo fqi = h.fqi();
        i.a aVar = com.tencent.mm.plugin.story.h.i.FuI;
        fqi.sl(i.a.aaX(this.pageType));
        AppMethodBeat.o(119373);
    }

    private void fpJ() {
        AppMethodBeat.i(119374);
        if (this.Ftl != null) {
            AnimatorSet animatorSet = this.Ftm.Fkp;
            if (animatorSet == null) {
                p.hyc();
            }
            animatorSet.cancel();
            com.tencent.mm.plugin.story.a.b bVar = this.Ftm;
            View view = this.Ftl;
            if (view == null) {
                p.hyc();
            }
            bVar.fO(view);
            com.tencent.mm.plugin.story.a.b bVar2 = this.Ftm;
            AnimatorSet animatorSet2 = bVar2.Fkp;
            if (animatorSet2 == null) {
                p.hyc();
            }
            Iterator<Animator> it = animatorSet2.getChildAnimations().iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                if (next instanceof ValueAnimator) {
                    ((ValueAnimator) next).setRepeatCount(bVar2.Fkq);
                    ((ValueAnimator) next).setRepeatMode(bVar2.Fkr);
                }
            }
            AnimatorSet animatorSet3 = bVar2.Fkp;
            if (animatorSet3 == null) {
                p.hyc();
            }
            animatorSet3.setDuration(bVar2.mDuration);
            AnimatorSet animatorSet4 = bVar2.Fkp;
            if (animatorSet4 == null) {
                p.hyc();
            }
            animatorSet4.start();
            MMHandlerThread.postToMainThreadDelayed(new d(this), 150);
        }
        AppMethodBeat.o(119374);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ b Ftt;

        d(b bVar) {
            this.Ftt = bVar;
        }

        public final void run() {
            AppMethodBeat.i(119369);
            b.fpK();
            AppMethodBeat.o(119369);
        }
    }

    @Override // com.tencent.mm.plugin.story.api.i
    public final View.OnClickListener fne() {
        return this.Ftr;
    }

    @Override // com.tencent.mm.plugin.story.api.i
    public final void setWeakContext(Context context2) {
        AppMethodBeat.i(119375);
        p.h(context2, "context");
        this.ooi = new WeakReference<>(context2);
        AppMethodBeat.o(119375);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/proxy/StoryHintProxy$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119377);
        AppMethodBeat.o(119377);
    }

    public static final /* synthetic */ void fpK() {
        AppMethodBeat.i(119378);
        Object systemService = MMApplicationContext.getContext().getSystemService("vibrator");
        if (systemService instanceof Vibrator) {
            ((Vibrator) systemService).vibrate(10);
        }
        AppMethodBeat.o(119378);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009e, code lost:
        if (kotlin.a.j.a((java.lang.Iterable) com.tencent.mm.plugin.story.c.a.d.Flc.aLT(), (com.tencent.mm.plugin.story.c.a.d.b) com.tencent.mm.plugin.story.c.a.d.b.map.get(java.lang.Integer.valueOf(r7.pageType))) != false) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void d(com.tencent.mm.plugin.story.proxy.b r7) {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.proxy.b.d(com.tencent.mm.plugin.story.proxy.b):void");
    }
}
