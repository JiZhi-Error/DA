package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\tJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "marginClickListener", "Lcom/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$IMarginClickListener;", "maxHeight", "maxWidth", "getMaxHeight", "getMaxWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setMarginClickListener", "setMaxHeight", "setMaxWidth", "IMarginClickListener", "plugin-music_release"})
public final class WxMaxSizeRecyclerView extends WxRecyclerView {
    private a AoX;
    private int maxHeight;
    private int maxWidth;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$IMarginClickListener;", "", "onClick", "", "plugin-music_release"})
    public interface a {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxMaxSizeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(220077);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new b(this));
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.music.ui.view.WxMaxSizeRecyclerView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(220070);
                if (view instanceof WxRecyclerView) {
                    GestureDetector gestureDetector = r1;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                    boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(220070);
                    return a2;
                }
                AppMethodBeat.o(220070);
                return false;
            }
        });
        AppMethodBeat.o(220077);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxMaxSizeRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(220078);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new b(this));
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.music.ui.view.WxMaxSizeRecyclerView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(220070);
                if (view instanceof WxRecyclerView) {
                    GestureDetector gestureDetector = gestureDetector;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                    com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                    boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(220070);
                    return a2;
                }
                AppMethodBeat.o(220070);
                return false;
            }
        });
        AppMethodBeat.o(220078);
    }

    public final void setMaxHeight(int i2) {
        AppMethodBeat.i(220073);
        this.maxHeight = i2;
        invalidate();
        requestLayout();
        AppMethodBeat.o(220073);
    }

    public final void setMaxWidth(int i2) {
        AppMethodBeat.i(220074);
        this.maxWidth = i2;
        invalidate();
        requestLayout();
        AppMethodBeat.o(220074);
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    @Override // android.support.v7.widget.RecyclerView
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(220075);
        if (this.maxHeight > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
        }
        if (this.maxWidth > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(220075);
    }

    public final void setMarginClickListener(a aVar) {
        AppMethodBeat.i(220076);
        p.h(aVar, "marginClickListener");
        this.AoX = aVar;
        AppMethodBeat.o(220076);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u000e\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "Landroid/view/GestureDetector$OnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", e.a.NAME, "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "plugin-music_release"})
    public static final class b implements GestureDetector.OnGestureListener {
        final /* synthetic */ WxMaxSizeRecyclerView AoZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(WxMaxSizeRecyclerView wxMaxSizeRecyclerView) {
            this.AoZ = wxMaxSizeRecyclerView;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(220071);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            a unused = this.AoZ.AoX;
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(220071);
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(220072);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(220072);
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }
    }
}
