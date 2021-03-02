package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {

    public static class a implements View.OnTouchListener {
        private static volatile View mFl;
        private f czm;
        private ad.b hpn;
        private Map<Integer, e.f> mFm = new HashMap();
        private boolean mFn;
        private boolean mFo;
        private e.f mFp;
        private Runnable mFq;
        private int mFr;
        private float mFs;
        private MotionEvent mFt;
        private MotionEvent mFu;
        private e.f mFv;
        private e.f mFw;
        private View mView;

        static /* synthetic */ void b(f fVar, bc bcVar, String str) {
            AppMethodBeat.i(140686);
            a(fVar, bcVar, str);
            AppMethodBeat.o(140686);
        }

        public a(final f fVar, ad.b bVar) {
            AppMethodBeat.i(140679);
            Assert.assertNotNull(fVar);
            Assert.assertNotNull(bVar);
            this.hpn = bVar;
            this.mFr = fVar.getComponentId();
            this.czm = fVar;
            this.mFs = (float) ViewConfiguration.get(fVar.getContext()).getScaledTouchSlop();
            this.mFv = new e.f();
            this.mFw = new e.f();
            this.mFq = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ac.d.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(140678);
                    if (!a.this.mFn) {
                        Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
                        AppMethodBeat.o(140678);
                    } else if (!u.aD(a.this.mView)) {
                        Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
                        if (a.mFl != null && a.mFl.equals(a.this.mView)) {
                            View unused = a.mFl = null;
                        }
                        AppMethodBeat.o(140678);
                    } else {
                        e.f cv = e.cv(a.this.mView);
                        if (Math.abs(a.this.mFp.x - cv.x) > 1.0f || Math.abs(a.this.mFp.y - cv.y) > 1.0f) {
                            Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
                            AppMethodBeat.o(140678);
                        } else if (a.this.mFm.size() != 1) {
                            Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
                            AppMethodBeat.o(140678);
                        } else if (Math.abs(a.this.mFv.x - a.this.mFw.x) > a.this.mFs || Math.abs(a.this.mFv.y - a.this.mFw.y) > a.this.mFs) {
                            Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", Float.valueOf(a.this.mFv.x), Float.valueOf(a.this.mFw.x), Float.valueOf(a.this.mFv.y), Float.valueOf(a.this.mFw.y));
                            AppMethodBeat.o(140678);
                        } else {
                            Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", Float.valueOf(a.this.mFv.x), Float.valueOf(a.this.mFw.x), Float.valueOf(a.this.mFv.y), Float.valueOf(a.this.mFw.y));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("data", a.this.hpn.getString("data", ""));
                                jSONObject.put("touch", a.this.mFv.toJSONObject());
                            } catch (JSONException e2) {
                            }
                            if (!a.this.hpn.getBoolean("disableScroll", false)) {
                                a.this.mFt = MotionEvent.obtain(a.this.mFu);
                                a.this.mFt.setAction(0);
                                a.this.hpn.H("fakeDownEvent", true);
                                a.this.mView.getParent().requestDisallowInterceptTouchEvent(true);
                                a.this.mView.setDuplicateParentStateEnabled(false);
                                a.a(a.this, a.this.mView, MotionEvent.obtain(a.this.mFt));
                            }
                            a.b(fVar, new e.a(), jSONObject.toString());
                            AppMethodBeat.o(140678);
                        }
                    }
                }
            };
            AppMethodBeat.o(140679);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x02f1  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0248  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(android.view.View r19, android.view.MotionEvent r20) {
            /*
            // Method dump skipped, instructions count: 966
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ac.d.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        private void l(View view, boolean z) {
            AppMethodBeat.i(140681);
            this.mView = view;
            this.mFn = z;
            if (!z) {
                this.hpn.H("fakeDownEvent", false);
                this.hpn.H("onLongClick", false);
                this.mView.removeCallbacks(this.mFq);
                this.mFv.b(-1, 0.0f, 0.0f);
                this.mFt = null;
            }
            AppMethodBeat.o(140681);
        }

        private static void a(f fVar, e.f fVar2, bc bcVar, String str) {
            AppMethodBeat.i(140682);
            if (fVar2 == null) {
                AppMethodBeat.o(140682);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
                jSONObject.put("touch", fVar2.toJSONObject());
            } catch (JSONException e2) {
            }
            a(fVar, bcVar, jSONObject.toString());
            AppMethodBeat.o(140682);
        }

        private static void a(f fVar, bc bcVar, String str) {
            AppMethodBeat.i(140683);
            fVar.b(bcVar.getName(), str, null);
            AppMethodBeat.o(140683);
        }

        private e.f[] z(MotionEvent motionEvent) {
            AppMethodBeat.i(140684);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                e.f fVar = this.mFm.get(Integer.valueOf(motionEvent.getPointerId(i2)));
                if (fVar != null) {
                    fVar.x = motionEvent.getX(i2);
                    fVar.y = motionEvent.getY(i2);
                    arrayList.add(fVar);
                }
            }
            e.f[] fVarArr = new e.f[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                fVarArr[i3] = (e.f) arrayList.get(i3);
            }
            AppMethodBeat.o(140684);
            return fVarArr;
        }

        static /* synthetic */ void a(a aVar, View view, MotionEvent motionEvent) {
            AppMethodBeat.i(221238);
            while (true) {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    view.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(221238);
                } else {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    motionEvent.offsetLocation(-(((float) viewGroup.getScrollX()) - view.getX()), -(((float) viewGroup.getScrollY()) - view.getY()));
                    view = (View) parent;
                }
            }
            view.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(221238);
        }
    }
}
