package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b {
    private int KVM;
    private c ONm;
    LinkedList<String> ONn;
    a ONo;
    int direction = 0;
    private GestureDetector jKk = new GestureDetector(new GestureDetector.OnGestureListener() {
        /* class com.tencent.mm.ui.applet.b.AnonymousClass2 */

        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(205201);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205201);
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            int i2;
            b bVar = b.this;
            if (f3 >= 0.0f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            bVar.direction = i2;
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(205202);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/applet/EarlyGetHeadImg$2", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(205202);
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }
    });
    private MessageQueue.IdleHandler pzA;

    public interface a {
        Bitmap Ta(String str);
    }

    /* renamed from: com.tencent.mm.ui.applet.b$b  reason: collision with other inner class name */
    public interface AbstractC2078b {
        int bnW();

        String vg(int i2);
    }

    public b(a aVar) {
        AppMethodBeat.i(141587);
        this.ONo = aVar;
        this.KVM = 15;
        this.ONm = new c();
        this.ONn = new LinkedList<>();
        this.pzA = new MessageQueue.IdleHandler() {
            /* class com.tencent.mm.ui.applet.b.AnonymousClass1 */

            public final boolean queueIdle() {
                AppMethodBeat.i(141583);
                while (b.this.ONn.size() > 0) {
                    b.this.ONo.Ta(b.this.ONn.removeFirst());
                }
                AppMethodBeat.o(141583);
                return true;
            }
        };
        Looper.myQueue().addIdleHandler(this.pzA);
        AppMethodBeat.o(141587);
    }

    public final void a(int i2, AbstractC2078b bVar) {
        AppMethodBeat.i(141588);
        if (bVar == null) {
            Log.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
            AppMethodBeat.o(141588);
        } else if (this.KVM <= 0) {
            Log.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
            AppMethodBeat.o(141588);
        } else {
            int bnW = bVar.bnW();
            for (int i3 = 1; i3 <= this.KVM; i3++) {
                if (this.direction == 1) {
                    if (i2 - i3 < 0) {
                        AppMethodBeat.o(141588);
                        return;
                    }
                    String vg = bVar.vg(i2 - i3);
                    if (!(vg == null || vg.length() == 0 || this.ONm.contains(vg))) {
                        this.ONm.add(vg);
                        this.ONn.add(vg);
                    }
                } else if (i2 + i3 >= bnW) {
                    AppMethodBeat.o(141588);
                    return;
                } else {
                    String vg2 = bVar.vg(i2 + i3);
                    if (!(vg2 == null || vg2.length() == 0 || this.ONm.contains(vg2))) {
                        this.ONm.add(vg2);
                        this.ONn.add(vg2);
                    }
                }
            }
            AppMethodBeat.o(141588);
        }
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(141589);
        if (this.jKk != null) {
            GestureDetector gestureDetector = this.jKk;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/applet/EarlyGetHeadImg", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        }
        AppMethodBeat.o(141589);
    }

    public final void detach() {
        AppMethodBeat.i(141590);
        if (this.pzA != null) {
            Looper.myQueue().removeIdleHandler(this.pzA);
        }
        AppMethodBeat.o(141590);
    }

    class c {
        private LinkedList<String> gCs;
        private int maxSize;

        public c() {
            AppMethodBeat.i(141584);
            this.gCs = null;
            this.maxSize = 40;
            this.gCs = new LinkedList<>();
            AppMethodBeat.o(141584);
        }

        /* access modifiers changed from: package-private */
        public final void add(String str) {
            AppMethodBeat.i(141585);
            if (this.gCs.contains(str)) {
                AppMethodBeat.o(141585);
                return;
            }
            this.gCs.add(str);
            if (this.gCs.size() >= this.maxSize) {
                this.gCs.removeFirst();
            }
            AppMethodBeat.o(141585);
        }

        /* access modifiers changed from: package-private */
        public final boolean contains(String str) {
            AppMethodBeat.i(141586);
            boolean contains = this.gCs.contains(str);
            AppMethodBeat.o(141586);
            return contains;
        }
    }
}
