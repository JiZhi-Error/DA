package org.extra.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.extra.tools.ScreenBroadcastReceiver;

public final class a implements ScreenBroadcastReceiver.a {
    public static List<WeakReference<ScreenBroadcastReceiver.a>> opg = new ArrayList();
    public final Object UhX = new Object();
    public ScreenBroadcastReceiver UhY = null;

    public a() {
        AppMethodBeat.i(236815);
        AppMethodBeat.o(236815);
    }

    static {
        AppMethodBeat.i(236820);
        AppMethodBeat.o(236820);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.extra.tools.a$a  reason: collision with other inner class name */
    public static class C2386a {
        private static final a UhZ = new a();

        static {
            AppMethodBeat.i(236814);
            AppMethodBeat.o(236814);
        }
    }

    public static a hPU() {
        AppMethodBeat.i(236816);
        a aVar = C2386a.UhZ;
        AppMethodBeat.o(236816);
        return aVar;
    }

    public final void hPV() {
        AppMethodBeat.i(236817);
        synchronized (this.UhX) {
            try {
                ArrayList<WeakReference> arrayList = new ArrayList();
                for (WeakReference<ScreenBroadcastReceiver.a> weakReference : opg) {
                    if (weakReference.get() == null) {
                        arrayList.add(weakReference);
                    }
                }
                for (WeakReference weakReference2 : arrayList) {
                    opg.remove(weakReference2);
                }
            } finally {
                AppMethodBeat.o(236817);
            }
        }
    }

    @Override // org.extra.tools.ScreenBroadcastReceiver.a
    public final void onScreenOff() {
        AppMethodBeat.i(236818);
        hPV();
        synchronized (this.UhX) {
            try {
                for (int size = opg.size() - 1; size >= 0; size--) {
                    ScreenBroadcastReceiver.a aVar = opg.get(size).get();
                    if (aVar != null) {
                        aVar.onScreenOff();
                    }
                }
            } finally {
                AppMethodBeat.o(236818);
            }
        }
    }

    @Override // org.extra.tools.ScreenBroadcastReceiver.a
    public final void onScreenOn() {
        AppMethodBeat.i(236819);
        hPV();
        synchronized (this.UhX) {
            try {
                for (int size = opg.size() - 1; size >= 0; size--) {
                    ScreenBroadcastReceiver.a aVar = opg.get(size).get();
                    if (aVar != null) {
                        aVar.onScreenOn();
                    }
                }
            } finally {
                AppMethodBeat.o(236819);
            }
        }
    }
}
