package com.tencent.mm.plugin.recordvideo.plugin.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u000e\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0012J\u0017\u0010 \u001a\u00020\u001c2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010\u0013\u001a\u00020\u001cJ\u0014\u0010$\u001a\u00020\u001c2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bodyColor", "bodyPaint", "Landroid/graphics/Paint;", "deleteColor", "deletePaint", "endColor", "endPaint", "prepareDelete", "", "subFinish", "subProgress", "Ljava/util/ArrayList;", "", "getDrawBodyRect", "Landroid/graphics/RectF;", FirebaseAnalytics.b.INDEX, "getDrawEndRect", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "delete", "removeCurrentProgress", "verify", "(Ljava/lang/Integer;)V", "reset", "updateProgress", "Companion", "plugin-recordvideo_release"})
public final class HorizontalSubProgressBar extends View {
    public static final a BXp = new a((byte) 0);
    private int BXl = Color.parseColor("#FA9D3B");
    private Paint BXm = new Paint();
    private Paint BXn = new Paint();
    boolean BXo;
    private final int endColor = Color.parseColor("#ffffff");
    private final int zAS = Color.parseColor("#FA5151");
    private Paint zAV = new Paint();
    ArrayList<Float> zBc = new ArrayList<>();
    private boolean zBg;

    static {
        AppMethodBeat.i(237424);
        AppMethodBeat.o(237424);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressBar$Companion;", "", "()V", "END_POINT", "", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalSubProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(237422);
        this.BXm.setStyle(Paint.Style.FILL);
        this.BXm.setColor(this.BXl);
        this.BXm.setAntiAlias(true);
        this.BXn.setStyle(Paint.Style.FILL);
        this.BXn.setColor(this.endColor);
        this.BXn.setAntiAlias(true);
        this.zAV.setStyle(Paint.Style.FILL);
        this.zAV.setColor(this.zAS);
        this.zAV.setAntiAlias(true);
        AppMethodBeat.o(237422);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalSubProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(237423);
        this.BXm.setStyle(Paint.Style.FILL);
        this.BXm.setColor(this.BXl);
        this.BXm.setAntiAlias(true);
        this.BXn.setStyle(Paint.Style.FILL);
        this.BXn.setColor(this.endColor);
        this.BXn.setAntiAlias(true);
        this.zAV.setStyle(Paint.Style.FILL);
        this.zAV.setColor(this.zAS);
        this.zAV.setAntiAlias(true);
        AppMethodBeat.o(237423);
    }

    public final void aJ(ArrayList<Float> arrayList) {
        AppMethodBeat.i(237416);
        p.h(arrayList, "subProgress");
        this.zBc.clear();
        this.zBc.addAll(arrayList);
        this.BXo = false;
        this.zBg = false;
        postInvalidate();
        AppMethodBeat.o(237416);
    }

    public final void eKU() {
        AppMethodBeat.i(237417);
        this.BXo = true;
        postInvalidate();
        AppMethodBeat.o(237417);
    }

    public final void rl(boolean z) {
        AppMethodBeat.i(237418);
        this.zBg = z;
        invalidate();
        AppMethodBeat.o(237418);
    }

    public final void m(Integer num) {
        boolean z;
        AppMethodBeat.i(237419);
        this.zBg = false;
        if (num == null || num.intValue() != this.zBc.size()) {
            if (!this.zBc.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.zBc.remove(this.zBc.size() - 1);
            }
            invalidate();
            AppMethodBeat.o(237419);
            return;
        }
        AppMethodBeat.o(237419);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(237420);
        int i2 = 0;
        for (T t : this.zBc) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            t.floatValue();
            if (i2 != this.zBc.size() - 1 || !this.zBg) {
                if (canvas != null) {
                    canvas.drawRect(VF(i2), this.BXm);
                }
            } else if (canvas != null) {
                canvas.drawRect(VF(i2), this.zAV);
            }
            if ((i2 != this.zBc.size() - 1 || this.BXo) && canvas != null) {
                Float f2 = this.zBc.get(i2);
                p.g(f2, "subProgress[index]");
                float floatValue = (f2.floatValue() * ((float) getWidth())) / 100.0f;
                canvas.drawRect(new RectF(floatValue - (((float) getWidth()) * 0.0053f), 0.0f, floatValue, (float) getHeight()), this.BXn);
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        AppMethodBeat.o(237420);
    }

    private final RectF VF(int i2) {
        AppMethodBeat.i(237421);
        Float f2 = this.zBc.get(i2);
        p.g(f2, "subProgress[index]");
        RectF rectF = new RectF(i2 == 0 ? 0.0f : (this.zBc.get(i2 - 1).floatValue() * ((float) getWidth())) / 100.0f, 0.0f, (f2.floatValue() * ((float) getWidth())) / 100.0f, (float) getHeight());
        AppMethodBeat.o(237421);
        return rectF;
    }
}
