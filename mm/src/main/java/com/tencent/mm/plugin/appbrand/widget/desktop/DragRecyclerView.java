package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class DragRecyclerView extends RecyclerView implements GestureDetector.OnGestureListener {
    private GestureDetector mDJ;
    boolean ooU = false;
    DragFeatureView opb;

    public DragRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DragRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    private void init(Context context) {
        this.mDJ = new GestureDetector(context, this);
    }

    public void setLongPress(boolean z) {
        this.ooU = z;
    }

    public DragFeatureView getDragRubbishView() {
        return this.opb;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.mDJ;
        a bl = new a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (this.ooU) {
            if (this.opb != null) {
                this.opb.onTouch(this, motionEvent);
            }
            int action = motionEvent.getAction();
            motionEvent.setAction(3);
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                getChildAt(i2).dispatchTouchEvent(motionEvent);
            }
            motionEvent.setAction(action);
        }
        if (motionEvent.getAction() != 3) {
            motionEvent.getAction();
        }
        if (this.ooU || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        if (this.ooU) {
            Log.i("DragRecyclerView", "alvinluo onLongPress ignore");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            return;
        }
        if (this.opb != null) {
            this.opb.onLongPress(motionEvent);
            this.ooU = this.opb.getVisibility() == 0;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/DragRecyclerView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }
}
