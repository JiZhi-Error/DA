package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;

public final class a {
    public static final void bdY() {
        AppMethodBeat.i(136991);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ay.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(136981);
                mw mwVar = new mw();
                mwVar.dSw.action = 1;
                EventCenter.instance.publish(mwVar);
                AppMethodBeat.o(136981);
            }
        });
        AppMethodBeat.o(136991);
    }

    public static final void bdZ() {
        AppMethodBeat.i(136992);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ay.a.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(136983);
                mw mwVar = new mw();
                mwVar.dSw.action = 2;
                EventCenter.instance.publish(mwVar);
                AppMethodBeat.o(136983);
            }
        });
        AppMethodBeat.o(136992);
    }

    public static final void bea() {
        AppMethodBeat.i(136993);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ay.a.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(136984);
                mw mwVar = new mw();
                mwVar.dSw.action = -1;
                EventCenter.instance.publish(mwVar);
                AppMethodBeat.o(136984);
            }
        });
        AppMethodBeat.o(136993);
    }

    public static final void beb() {
        AppMethodBeat.i(136994);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ay.a.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(136987);
                mw mwVar = new mw();
                mwVar.dSw.action = 11;
                EventCenter.instance.publish(mwVar);
                AppMethodBeat.o(136987);
            }
        });
        AppMethodBeat.o(136994);
    }

    public static final void a(final f fVar) {
        AppMethodBeat.i(136995);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ay.a.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(136988);
                mw mwVar = new mw();
                mwVar.dSw.action = 6;
                mwVar.dSw.dSy = fVar;
                EventCenter.instance.publish(mwVar);
                AppMethodBeat.o(136988);
            }
        });
        AppMethodBeat.o(136995);
    }

    public static boolean bec() {
        AppMethodBeat.i(136996);
        mw mwVar = new mw();
        mwVar.dSw.action = -3;
        EventCenter.instance.publish(mwVar);
        boolean z = mwVar.dSx.result;
        AppMethodBeat.o(136996);
        return z;
    }

    public static boolean bed() {
        AppMethodBeat.i(136997);
        mw mwVar = new mw();
        mwVar.dSw.action = 10;
        EventCenter.instance.publish(mwVar);
        boolean z = mwVar.dSx.result;
        AppMethodBeat.o(136997);
        return z;
    }

    public static boolean bee() {
        AppMethodBeat.i(136998);
        mw mwVar = new mw();
        mwVar.dSw.action = 9;
        EventCenter.instance.publish(mwVar);
        boolean z = mwVar.dSx.result;
        AppMethodBeat.o(136998);
        return z;
    }

    public static f bef() {
        AppMethodBeat.i(136999);
        mw mwVar = new mw();
        mwVar.dSw.action = -2;
        EventCenter.instance.publish(mwVar);
        f fVar = mwVar.dSx.dSy;
        AppMethodBeat.o(136999);
        return fVar;
    }

    public static void b(f fVar) {
        AppMethodBeat.i(198132);
        mw mwVar = new mw();
        mwVar.dSw.action = 16;
        mwVar.dSw.dSy = fVar;
        EventCenter.instance.publish(mwVar);
        AppMethodBeat.o(198132);
    }

    public static void c(final f fVar) {
        AppMethodBeat.i(137000);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ay.a.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(136989);
                mw mwVar = new mw();
                mwVar.dSw.action = 0;
                mwVar.dSw.dSy = fVar;
                EventCenter.instance.publish(mwVar);
                AppMethodBeat.o(136989);
            }
        });
        AppMethodBeat.o(137000);
    }

    public static void f(final List<f> list, final int i2) {
        AppMethodBeat.i(182547);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ay.a.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(136990);
                mw mwVar = new mw();
                mwVar.dSw.action = 4;
                mwVar.dSw.dLA = list;
                mwVar.dSw.dSz = i2;
                EventCenter.instance.publish(mwVar);
                AppMethodBeat.o(136990);
            }
        });
        AppMethodBeat.o(182547);
    }

    public static void d(final f fVar) {
        AppMethodBeat.i(137001);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ay.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(136982);
                mw mwVar = new mw();
                mwVar.dSw.action = 3;
                mwVar.dSw.dSy = fVar;
                EventCenter.instance.publish(mwVar);
                AppMethodBeat.o(136982);
            }
        });
        AppMethodBeat.o(137001);
    }

    public static boolean e(f fVar) {
        if (fVar == null) {
            return false;
        }
        switch (fVar.jeT) {
            case 1:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean tG(int i2) {
        AppMethodBeat.i(137002);
        mw mwVar = new mw();
        mwVar.dSw.action = 7;
        mwVar.dSw.position = i2;
        EventCenter.instance.publish(mwVar);
        boolean z = mwVar.dSx.result;
        AppMethodBeat.o(137002);
        return z;
    }

    public static c beg() {
        AppMethodBeat.i(137003);
        mw mwVar = new mw();
        mwVar.dSw.action = 8;
        EventCenter.instance.publish(mwVar);
        c cVar = mwVar.dSx.dSC;
        AppMethodBeat.o(137003);
        return cVar;
    }
}
