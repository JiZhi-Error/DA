package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001cJ\b\u0010%\u001a\u00020\u001cH\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftSendBtn;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CONTINUE_CLICK_SHORT_PAG", "", "CONTINUE_KEEP_DURATION", "", "SINGLE_CLICK_SHORT_PAG", "TAG", "continueClickPag", "fullScreenSendAgainContainer", "Landroid/view/View;", "fullScreenSendAgainPag", "Lorg/libpag/PAGView;", "singleClickPag", "singleClickPagTask", "Ljava/lang/Runnable;", "getSingleClickPagTask", "()Ljava/lang/Runnable;", "doSingleClickPagTask", "", "release", "removeClickPagTask", "resetSendAgainPagPath", "path", "showContinueClickSendAgain", "longClick", "", "showSingleClickSendAgian", "stopSendAgainPag", "plugin-finder_release"})
public final class FinderLiveGiftSendBtn extends RelativeLayout {
    public final String TAG;
    public final long uyA;
    private final View uyB;
    public final PAGView uyC;
    public String uyD;
    private String uyE;
    public final Runnable uyF;
    private final String uyy;
    private final String uyz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveGiftSendBtn(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(247457);
        this.TAG = "FinderLiveGiftSendBtn";
        this.uyy = "assets://finder_live_gift_continue_click_short.pag";
        this.uyz = "assets://finder_live_gift_single_click_short.pag";
        this.uyA = 500;
        this.uyD = this.uyy;
        this.uyE = this.uyz;
        View.inflate(context, R.layout.adu, this);
        View findViewById = findViewById(R.id.cq5);
        p.g(findViewById, "findViewById(R.id.finder…reen_gift_send_container)");
        this.uyB = findViewById;
        View findViewById2 = this.uyB.findViewById(R.id.cq3);
        p.g(findViewById2, "fullScreenSendAgainConta…reen_gift_send_again_pag)");
        this.uyC = (PAGView) findViewById2;
        this.uyF = new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveGiftSendBtn.AnonymousClass1 */
            final /* synthetic */ FinderLiveGiftSendBtn uyG;

            {
                this.uyG = r1;
            }

            public final void run() {
                AppMethodBeat.i(247453);
                this.uyG.dit();
                AppMethodBeat.o(247453);
            }
        };
        AppMethodBeat.o(247457);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveGiftSendBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(247458);
        AppMethodBeat.o(247458);
    }

    public final Runnable getSingleClickPagTask() {
        return this.uyF;
    }

    public final void dit() {
        AppMethodBeat.i(247454);
        Log.i(this.TAG, "showSingleClickSendAgian");
        if (!p.j(this.uyC.getPath(), this.uyE)) {
            diu();
            atQ(this.uyE);
            this.uyC.setRepeatCount(-1);
            this.uyC.setProgress(0.0d);
        }
        if (!this.uyC.isPlaying()) {
            this.uyC.play();
        }
        AppMethodBeat.o(247454);
    }

    public final void diu() {
        AppMethodBeat.i(247455);
        if (this.uyC.isPlaying()) {
            this.uyC.stop();
        }
        AppMethodBeat.o(247455);
    }

    public final void atQ(String str) {
        AppMethodBeat.i(247456);
        if (!p.j(this.uyC.getPath(), str)) {
            this.uyC.setPath(str);
        }
        AppMethodBeat.o(247456);
    }
}
