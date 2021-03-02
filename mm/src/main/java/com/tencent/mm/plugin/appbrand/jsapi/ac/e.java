package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    public static class a extends bc {
        private static final int CTRL_INDEX = 137;
        public static final String NAME = "onLongPress";
    }

    public static class b extends bc {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onTouchCancel";
    }

    public static class c extends bc {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onTouchStart";
    }

    public static class d extends bc {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onTouchMove";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ac.e$e  reason: collision with other inner class name */
    public static class C0599e extends bc {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onTouchEnd";
    }

    public static f cv(View view) {
        AppMethodBeat.i(140689);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        f fVar = new f(0, (float) iArr[0], (float) iArr[1]);
        AppMethodBeat.o(140689);
        return fVar;
    }

    public static class f {
        public int id;
        public float x;
        public float y;

        public f() {
        }

        public f(int i2, float f2, float f3) {
            this.id = i2;
            this.x = f2;
            this.y = f3;
        }

        public final void b(int i2, float f2, float f3) {
            this.id = i2;
            this.x = f2;
            this.y = f3;
        }

        public final JSONObject toJSONObject() {
            AppMethodBeat.i(140687);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.id);
                jSONObject.put("x", (double) g.aS(this.x));
                jSONObject.put("y", (double) g.aS(this.y));
            } catch (JSONException e2) {
            }
            AppMethodBeat.o(140687);
            return jSONObject;
        }

        public final String toString() {
            AppMethodBeat.i(140688);
            String jSONObject = toJSONObject().toString();
            AppMethodBeat.o(140688);
            return jSONObject;
        }
    }

    public static void a(ViewGroup viewGroup, MotionEvent motionEvent) {
        AppMethodBeat.i(140690);
        int childCount = viewGroup.getChildCount();
        int pointerId = viewGroup.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(motionEvent.getActionIndex()) : -1;
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = viewGroup.getChildAt(i2);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (AppBrandViewMotionCompat.cN(childAt) && AppBrandViewMotionCompat.a(viewGroup, x, y, childAt) && childAt.isDuplicateParentStateEnabled()) {
                a(viewGroup, motionEvent, childAt, pointerId);
                if ((childAt instanceof com.tencent.mm.plugin.appbrand.jsapi.base.f) && ((com.tencent.mm.plugin.appbrand.jsapi.base.f) childAt).bEY()) {
                    AppMethodBeat.o(140690);
                    return;
                }
            }
        }
        AppMethodBeat.o(140690);
    }

    public static boolean a(ViewGroup viewGroup, MotionEvent motionEvent, View view, int i2) {
        MotionEvent g2;
        AppMethodBeat.i(140691);
        if (view == null) {
            Log.v("MicroMsg.ViewMotionHelper", "child is null.");
            AppMethodBeat.o(140691);
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3) {
            motionEvent.setAction(3);
            boolean dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            AppMethodBeat.o(140691);
            return dispatchTouchEvent;
        }
        int J = AppBrandViewMotionCompat.J(motionEvent);
        int i3 = J & i2;
        if (i3 == 0) {
            Log.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
            AppMethodBeat.o(140691);
            return false;
        }
        boolean cO = AppBrandViewMotionCompat.cO(view);
        if (i3 != J) {
            g2 = AppBrandViewMotionCompat.g(motionEvent, i3);
            if (g2 == null) {
                g2 = MotionEvent.obtain(motionEvent);
            }
        } else if (cO) {
            float scrollX = (float) (viewGroup.getScrollX() - view.getLeft());
            float scrollY = (float) (viewGroup.getScrollY() - view.getTop());
            motionEvent.offsetLocation(scrollX, scrollY);
            boolean dispatchTouchEvent2 = view.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            AppMethodBeat.o(140691);
            return dispatchTouchEvent2;
        } else {
            g2 = MotionEvent.obtain(motionEvent);
        }
        g2.offsetLocation((float) (viewGroup.getScrollX() - view.getLeft()), (float) (viewGroup.getScrollY() - view.getTop()));
        if (!cO) {
            g2.transform(AppBrandViewMotionCompat.cP(view));
        }
        boolean dispatchTouchEvent3 = view.dispatchTouchEvent(g2);
        g2.recycle();
        AppMethodBeat.o(140691);
        return dispatchTouchEvent3;
    }
}
