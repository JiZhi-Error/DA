package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\nJ\u0016\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView;", "Landroid/widget/TextView;", "Lcom/tencent/mm/ui/widget/cropview/IBorderVisibilityCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disappearRunnable", "Ljava/lang/Runnable;", "value", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "getDuration", "()I", "setDuration", "(I)V", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "runnable", "makeTimeString", "", "d", "onDetachedFromWindow", "", "onVisibility", "isShow", "", "start", "time", "disappearTime", "", "stop", "Companion", "libmmui_release"})
public final class VideoTimeView extends TextView implements b {
    public static final a QNo = new a((byte) 0);
    private Runnable dQN;
    private int duration;
    private final MMHandler mainHandler = new MMHandler(Looper.getMainLooper());

    static {
        AppMethodBeat.i(164495);
        AppMethodBeat.o(164495);
    }

    public static final /* synthetic */ String aoL(int i2) {
        AppMethodBeat.i(164496);
        String xt = xt(i2);
        AppMethodBeat.o(164496);
        return xt;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/VideoTimeView$Companion;", "", "()V", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public VideoTimeView(Context context) {
        super(context);
        AppMethodBeat.i(164492);
        Context context2 = getContext();
        p.g(context2, "context");
        setTextSize(0, context2.getResources().getDimension(R.dimen.bd));
        Context context3 = getContext();
        p.g(context3, "context");
        setTextColor(context3.getResources().getColor(R.color.am));
        setBackgroundResource(R.drawable.sd);
        Context context4 = getContext();
        p.g(context4, "context");
        int dimension = (int) context4.getResources().getDimension(R.dimen.ct);
        Context context5 = getContext();
        p.g(context5, "context");
        int dimension2 = (int) context5.getResources().getDimension(R.dimen.bt);
        setPadding(dimension, dimension2, dimension, dimension2);
        AppMethodBeat.o(164492);
    }

    public VideoTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(164493);
        Context context2 = getContext();
        p.g(context2, "context");
        setTextSize(0, context2.getResources().getDimension(R.dimen.bd));
        Context context3 = getContext();
        p.g(context3, "context");
        setTextColor(context3.getResources().getColor(R.color.am));
        setBackgroundResource(R.drawable.sd);
        Context context4 = getContext();
        p.g(context4, "context");
        int dimension = (int) context4.getResources().getDimension(R.dimen.ct);
        Context context5 = getContext();
        p.g(context5, "context");
        int dimension2 = (int) context5.getResources().getDimension(R.dimen.bt);
        setPadding(dimension, dimension2, dimension, dimension2);
        AppMethodBeat.o(164493);
    }

    public VideoTimeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164494);
        Context context2 = getContext();
        p.g(context2, "context");
        setTextSize(0, context2.getResources().getDimension(R.dimen.bd));
        Context context3 = getContext();
        p.g(context3, "context");
        setTextColor(context3.getResources().getColor(R.color.am));
        setBackgroundResource(R.drawable.sd);
        Context context4 = getContext();
        p.g(context4, "context");
        int dimension = (int) context4.getResources().getDimension(R.dimen.ct);
        Context context5 = getContext();
        p.g(context5, "context");
        int dimension2 = (int) context5.getResources().getDimension(R.dimen.bt);
        setPadding(dimension, dimension2, dimension, dimension2);
        AppMethodBeat.o(164494);
    }

    public final int getDuration() {
        return this.duration;
    }

    public final void setDuration(int i2) {
        AppMethodBeat.i(164485);
        this.duration = i2;
        setText(xt(i2 / 60) + ":" + xt(i2 % 60));
        Log.i("MicroMsg.VideoTimeView", "[setDuration] value=".concat(String.valueOf(i2)));
        AppMethodBeat.o(164485);
    }

    public final void start() {
        AppMethodBeat.i(164486);
        start(this.duration);
        AppMethodBeat.o(164486);
    }

    private void start(int i2) {
        AppMethodBeat.i(164487);
        animate().cancel();
        setAlpha(1.0f);
        setVisibility(0);
        stop();
        if (i2 < 0) {
            AppMethodBeat.o(164487);
            return;
        }
        z.d dVar = new z.d();
        dVar.SYE = i2;
        setText(xt(dVar.SYE / 60) + ":" + xt(dVar.SYE % 60));
        this.dQN = new b(this, dVar, i2);
        postDelayed(this.dQN, 1000);
        AppMethodBeat.o(164487);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/ui/widget/cropview/VideoTimeView$start$2", "Ljava/lang/Runnable;", "run", "", "libmmui_release"})
    public static final class b implements Runnable {
        final /* synthetic */ VideoTimeView QNp;
        final /* synthetic */ z.d QNq;
        final /* synthetic */ int QNr;

        b(VideoTimeView videoTimeView, z.d dVar, int i2) {
            this.QNp = videoTimeView;
            this.QNq = dVar;
            this.QNr = i2;
        }

        public final void run() {
            AppMethodBeat.i(164484);
            this.QNq.SYE = j.mZ(0, this.QNq.SYE - 1);
            this.QNp.setText(VideoTimeView.aoL(this.QNq.SYE / 60) + ":" + VideoTimeView.aoL(this.QNq.SYE % 60));
            if (this.QNq.SYE <= 0) {
                this.QNq.SYE = this.QNr;
            }
            this.QNp.postDelayed(this, 1000);
            AppMethodBeat.o(164484);
        }
    }

    private void stop() {
        AppMethodBeat.i(164488);
        Runnable runnable = this.dQN;
        if (runnable != null) {
            removeCallbacks(runnable);
            AppMethodBeat.o(164488);
            return;
        }
        AppMethodBeat.o(164488);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(164489);
        super.onDetachedFromWindow();
        stop();
        AppMethodBeat.o(164489);
    }

    private static String xt(int i2) {
        AppMethodBeat.i(164490);
        if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(164490);
            return concat;
        }
        String str = String.valueOf(i2);
        AppMethodBeat.o(164490);
        return str;
    }

    @Override // com.tencent.mm.ui.widget.cropview.b
    public final void Df(boolean z) {
        AppMethodBeat.i(164491);
        if (z) {
            setVisibility(0);
            AppMethodBeat.o(164491);
            return;
        }
        setVisibility(4);
        AppMethodBeat.o(164491);
    }
}
