package com.tencent.e.e.b.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public abstract class e implements a {
    private c RNM;

    public abstract String a(Context context, IBinder iBinder);

    public abstract Intent getIntent();

    @Override // com.tencent.e.e.b.a.a.a
    public final c kV(Context context) {
        if (this.RNM == null || this.RNM.errorCode != 0) {
            this.RNM = kX(context);
        }
        return this.RNM;
    }

    private c kX(Context context) {
        int i2;
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("");
        try {
            AtomicReference<IBinder> atomicReference2 = new AtomicReference<>();
            AtomicReference<ServiceConnection> atomicReference3 = new AtomicReference<>();
            int a2 = a(context, atomicReference2, atomicReference3);
            if (a2 == 0) {
                a2 = a(context, atomicReference2, atomicReference3, atomicReference);
            }
            i2 = a2;
        } catch (Throwable th) {
            i2 = -1;
        }
        return new c(atomicReference.get(), i2);
    }

    private int a(Context context, final AtomicReference<IBinder> atomicReference, final AtomicReference<ServiceConnection> atomicReference2) {
        final Object obj = new Object();
        if (!context.bindService(getIntent(), new ServiceConnection() {
            /* class com.tencent.e.e.b.a.a.e.AnonymousClass1 */

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.i(138433);
                atomicReference.set(iBinder);
                atomicReference2.set(this);
                synchronized (obj) {
                    try {
                        obj.notifyAll();
                    } catch (Throwable th) {
                    }
                    try {
                    } catch (Throwable th2) {
                        AppMethodBeat.o(138433);
                        throw th2;
                    }
                }
                AppMethodBeat.o(138433);
            }

            public final void onServiceDisconnected(ComponentName componentName) {
            }
        }, 1)) {
            return -100;
        }
        if (atomicReference.get() == null) {
            synchronized (obj) {
                try {
                    obj.wait(2000);
                } catch (Throwable th) {
                }
            }
        }
        if (atomicReference.get() == null) {
            return -105;
        }
        return 0;
    }

    private int a(final Context context, final AtomicReference<IBinder> atomicReference, final AtomicReference<ServiceConnection> atomicReference2, final AtomicReference<String> atomicReference3) {
        final Object obj = new Object();
        final AtomicReference atomicReference4 = new AtomicReference(0);
        h.RTc.ba(new Runnable() {
            /* class com.tencent.e.e.b.a.a.e.AnonymousClass2 */

            public final void run() {
                String str;
                AppMethodBeat.i(138434);
                try {
                    str = e.this.a(context, (IBinder) atomicReference.get());
                } catch (Throwable th) {
                    atomicReference4.set(-102);
                    str = "";
                }
                atomicReference3.set(str);
                try {
                    context.unbindService((ServiceConnection) atomicReference2.get());
                } catch (Throwable th2) {
                    atomicReference4.set(-103);
                }
                synchronized (obj) {
                    try {
                        obj.notifyAll();
                    } catch (Throwable th3) {
                    }
                    try {
                    } catch (Throwable th4) {
                        AppMethodBeat.o(138434);
                        throw th4;
                    }
                }
                AppMethodBeat.o(138434);
            }
        });
        synchronized (obj) {
            try {
                obj.wait(2000);
            } catch (Throwable th) {
            }
        }
        return ((Integer) atomicReference4.get()).intValue();
    }
}
