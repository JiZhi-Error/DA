package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "thumbPagView", "Lorg/libpag/PAGView;", "tvSend", "Landroid/widget/TextView;", "release", "", "startPAGAnim", "path", "stopPAGAnim", "plugin-finder_release"})
public final class FinderLiveGiftPreviewView extends RelativeLayout {
    private final String TAG;
    public final PAGView uyw;
    private final TextView uyx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveGiftPreviewView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(247450);
        this.TAG = "Finder.FinderLiveGiftPreviewView";
        View.inflate(context, R.layout.adv, this);
        View findViewById = findViewById(R.id.cr4);
        p.g(findViewById, "findViewById(R.id.finder_live_gift_thumb_pag)");
        this.uyw = (PAGView) findViewById;
        View findViewById2 = findViewById(R.id.cr5);
        p.g(findViewById2, "findViewById(R.id.finder_live_gift_thumb_send_btn)");
        this.uyx = (TextView) findViewById2;
        AppMethodBeat.o(247450);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveGiftPreviewView(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(247451);
        AppMethodBeat.o(247451);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveGiftPreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(247452);
        AppMethodBeat.o(247452);
    }
}
