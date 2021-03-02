package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001/B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0014J\u0006\u0010%\u001a\u00020 J\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\tJ\u0014\u0010(\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*J\u000e\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\tJ\u000e\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "labelChildren", "Ljava/util/LinkedList;", "Landroid/widget/TextView;", "labelCount", "labelGuideLines", "Landroid/support/constraint/Guideline;", "labelPadding", "labelWidth", "labels", "", "trackView", "Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "refresh", "setLabelCount", "count", "setLabels", "labelList", "", "setSelection", FirebaseAnalytics.b.INDEX, "setTrackColor", "color", "SliderCallback", "plugin-vlog_release"})
public final class LabelSlider extends ConstraintLayout {
    private int GDn;
    private int GDo;
    private int GDp;
    private final SliderTrackView GDq;
    private final LinkedList<Guideline> GDr;
    private final LinkedList<TextView> GDs;
    private final LinkedList<CharSequence> GDt;
    private a GDu;
    private final String TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "", "onSelected", "", FirebaseAnalytics.b.INDEX, "", "plugin-vlog_release"})
    public interface a {
        void Ir(int i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LabelSlider(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(190903);
        this.TAG = "MicroMsg.LabelSlider";
        this.GDn = 5;
        this.GDo = 80;
        this.GDp = 16;
        this.GDr = new LinkedList<>();
        this.GDs = new LinkedList<>();
        this.GDt = new LinkedList<>();
        this.GDq = new SliderTrackView(context);
        Drawable drawable = context.getDrawable(R.drawable.c9u);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, drawable != null ? drawable.getIntrinsicHeight() : 48);
        layoutParams.endToEnd = 0;
        layoutParams.startToStart = 0;
        layoutParams.topToTop = 0;
        addView(this.GDq, layoutParams);
        this.GDq.setThumbDrawable(drawable);
        this.GDq.setCallback(new a(this) {
            /* class com.tencent.mm.plugin.vlog.ui.LabelSlider.AnonymousClass1 */
            final /* synthetic */ LabelSlider GDv;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.GDv = r1;
            }

            @Override // com.tencent.mm.plugin.vlog.ui.LabelSlider.a
            public final void Ir(int i2) {
                AppMethodBeat.i(190895);
                a callback = this.GDv.getCallback();
                if (callback != null) {
                    callback.Ir(i2);
                    AppMethodBeat.o(190895);
                    return;
                }
                AppMethodBeat.o(190895);
            }
        });
        AppMethodBeat.o(190903);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LabelSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(190904);
        AppMethodBeat.o(190904);
    }

    public final a getCallback() {
        return this.GDu;
    }

    public final void setCallback(a aVar) {
        this.GDu = aVar;
    }

    public final void setTrackColor(int i2) {
        AppMethodBeat.i(190897);
        this.GDq.setTrackColor(i2);
        AppMethodBeat.o(190897);
    }

    public final void setLabelCount(int i2) {
        AppMethodBeat.i(190898);
        this.GDn = i2;
        refresh();
        AppMethodBeat.o(190898);
    }

    public final void setLabels(List<? extends CharSequence> list) {
        AppMethodBeat.i(190899);
        p.h(list, "labelList");
        this.GDt.clear();
        this.GDt.addAll(list);
        int i2 = 0;
        for (T t : this.GDs) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            t.setText((CharSequence) j.L(this.GDt, i2));
            i2 = i3;
        }
        AppMethodBeat.o(190899);
    }

    public final void setSelection(int i2) {
        AppMethodBeat.i(190900);
        this.GDq.setSelection(i2);
        AppMethodBeat.o(190900);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ LabelSlider GDv;

        b(LabelSlider labelSlider) {
            this.GDv = labelSlider;
        }

        public final void run() {
            AppMethodBeat.i(190896);
            this.GDv.refresh();
            AppMethodBeat.o(190896);
        }
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(190901);
        super.onSizeChanged(i2, i3, i4, i5);
        post(new b(this));
        AppMethodBeat.o(190901);
    }

    public final void refresh() {
        AppMethodBeat.i(190902);
        this.GDq.setPointCount(this.GDn);
        SliderTrackView sliderTrackView = this.GDq;
        Context context = getContext();
        p.g(context, "context");
        sliderTrackView.setStartOffset(context.getResources().getDimensionPixelOffset(R.dimen.cl));
        Iterator<T> it = this.GDs.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.GDs.clear();
        Iterator<T> it2 = this.GDr.iterator();
        while (it2.hasNext()) {
            removeView(it2.next());
        }
        this.GDr.clear();
        if (getWidth() > 0) {
            int i2 = 0;
            for (T t : this.GDq.getTrackPoint()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                float floatValue = t.floatValue();
                Guideline guideline = new Guideline(getContext());
                guideline.setId(View.generateViewId());
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
                layoutParams.startToStart = 0;
                layoutParams.startToEnd = 0;
                layoutParams.orientation = 1;
                layoutParams.guideBegin = (int) floatValue;
                addView(guideline, layoutParams);
                this.GDr.add(guideline);
                TextView textView = new TextView(getContext());
                textView.setText((CharSequence) j.L(this.GDt, i2));
                textView.setTextColor(-855638017);
                textView.setGravity(17);
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams2.topToBottom = this.GDq.getId();
                layoutParams2.startToStart = guideline.getId();
                layoutParams2.endToEnd = guideline.getId();
                layoutParams2.bottomToBottom = 0;
                addView(textView, layoutParams2);
                this.GDs.add(textView);
                i2 = i3;
            }
        }
        AppMethodBeat.o(190902);
    }
}
