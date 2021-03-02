package com.tencent.mm.plugin.whatsnew.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewSubtitlesView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adjustViews", "", "position", "ratio", "", "attachImages", "imageIds", "", "select", "Companion", "app_release"})
public final class WhatsNewSubtitlesView extends FrameLayout {
    public static final a JPe = new a((byte) 0);

    static {
        AppMethodBeat.i(230978);
        AppMethodBeat.o(230978);
    }

    public WhatsNewSubtitlesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private /* synthetic */ WhatsNewSubtitlesView(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WhatsNewSubtitlesView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(230977);
        setClipChildren(false);
        setClipToPadding(false);
        AppMethodBeat.o(230977);
    }

    public final void y(int i2, float f2) {
        AppMethodBeat.i(230976);
        if (i2 >= getChildCount() - 1) {
            AppMethodBeat.o(230976);
            return;
        }
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
        f mY = j.mY(0, getChildCount());
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(mY, 10));
        Iterator it = mY.iterator();
        while (it.hasNext()) {
            arrayList.add(getChildAt(((ab) it).nextInt()));
        }
        int i3 = 0;
        for (Object obj : arrayList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.a.j.hxH();
            }
            View view = (View) obj;
            if (i3 == i2) {
                p.g(view, "childView");
                view.setVisibility(0);
                if (f2 < 0.5714286f) {
                    float f3 = f2 / 0.5714286f;
                    view.setAlpha(1.0f - f3);
                    view.setTranslationX(f3 * ((float) (-fromDPToPix)));
                    i3 = i4;
                } else {
                    view.setAlpha(0.0f);
                    view.setTranslationX((float) (-fromDPToPix));
                    i3 = i4;
                }
            } else if (i3 == i2 + 1) {
                p.g(view, "childView");
                view.setVisibility(0);
                if (f2 > 0.5714286f) {
                    float f4 = (f2 - 0.5714286f) / 0.4285714f;
                    view.setAlpha(f4);
                    view.setTranslationX((1.0f - f4) * ((float) fromDPToPix));
                    i3 = i4;
                } else {
                    view.setAlpha(0.0f);
                    view.setTranslationX((float) fromDPToPix);
                    i3 = i4;
                }
            } else {
                p.g(view, "childView");
                view.setVisibility(8);
                i3 = i4;
            }
        }
        AppMethodBeat.o(230976);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewSubtitlesView$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
