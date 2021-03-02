package com.tencent.mm.plugin.crashfix.d.c;

import android.os.Handler;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a implements com.tencent.mm.plugin.crashfix.d.b {
    private final String TAG = "MicroMsg.PhoneStateOverflow";
    Handler mH = new Handler(Looper.getMainLooper());
    List<c> qCI = new ArrayList();
    private List<C0934a> qCJ = new ArrayList();

    public a() {
        AppMethodBeat.i(225346);
        AppMethodBeat.o(225346);
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean Fh(int i2) {
        AppMethodBeat.i(225347);
        if (i2 < 30 || ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_r_phonestate_overflow, 0) != 1) {
            AppMethodBeat.o(225347);
            return false;
        }
        AppMethodBeat.o(225347);
        return true;
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean cAO() {
        AppMethodBeat.i(225348);
        EventCenter.instance.add(new IListener<xt>() {
            /* class com.tencent.mm.plugin.crashfix.d.c.a.AnonymousClass1 */

            {
                AppMethodBeat.i(225332);
                this.__eventId = xt.class.getName().hashCode();
                AppMethodBeat.o(225332);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(xt xtVar) {
                AppMethodBeat.i(225333);
                xt xtVar2 = xtVar;
                if (xtVar2.eeb.action == 0) {
                    final PhoneStateListener phoneStateListener = xtVar2.eeb.eec;
                    final int i2 = xtVar2.eeb.eed;
                    if (phoneStateListener instanceof b) {
                        Log.i("MicroMsg.PhoneStateOverflow", "InnerPhoneStateListener come");
                    } else {
                        Log.i("MicroMsg.PhoneStateOverflow", "event id = %d, listener %d", Integer.valueOf(i2), Integer.valueOf(phoneStateListener.hashCode()));
                        if (i2 == 0) {
                            a.this.a(phoneStateListener);
                        } else {
                            c cVar = new c(a.this, (byte) 0);
                            cVar.JRS = new WeakReference<>(phoneStateListener);
                            cVar.eventId = i2;
                            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                            final String str = "";
                            if (stackTrace != null) {
                                for (int i3 = 0; i3 < stackTrace.length; i3++) {
                                    str = str + stackTrace[i3].getClassName() + " " + stackTrace[i3].getMethodName() + ":" + stackTrace[i3].getLineNumber() + "\n";
                                }
                            }
                            a.this.mH.post(new Runnable() {
                                /* class com.tencent.mm.plugin.crashfix.d.c.a.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(225331);
                                    Log.i("MicroMsg.PhoneStateOverflow", "remove:  event id = %d, listener %d", Integer.valueOf(i2), Integer.valueOf(phoneStateListener.hashCode()));
                                    TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
                                    com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(phoneStateListener);
                                    com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/PhoneStateOverflow$1$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                                    telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                                    com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/PhoneStateOverflow$1$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                                    if (a.this.a(i2, phoneStateListener, str)) {
                                        a.this.Fj(i2);
                                    }
                                    AppMethodBeat.o(225331);
                                }
                            });
                        }
                    }
                }
                AppMethodBeat.o(225333);
                return false;
            }
        });
        AppMethodBeat.o(225348);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(PhoneStateListener phoneStateListener) {
        AppMethodBeat.i(225349);
        Iterator<c> it = this.qCI.iterator();
        while (it.hasNext()) {
            c next = it.next();
            PhoneStateListener phoneStateListener2 = next.JRS.get();
            if (phoneStateListener2 == null) {
                it.remove();
            } else if (next != null && phoneStateListener2 == phoneStateListener) {
                it.remove();
                Log.i("MicroMsg.PhoneStateOverflow", "remove outter %d", Integer.valueOf(next.eventId));
            }
        }
        AppMethodBeat.o(225349);
    }

    private synchronized int Fi(int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(225350);
        i3 = 0;
        for (c cVar : this.qCI) {
            if (cVar.eventId == i2) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i3 = i4;
        }
        AppMethodBeat.o(225350);
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void Fj(int i2) {
        boolean z;
        AppMethodBeat.i(225351);
        Log.i("MicroMsg.PhoneStateOverflow", "add inner:  event id = %d", Integer.valueOf(i2));
        Iterator<C0934a> it = this.qCJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            C0934a next = it.next();
            if (next.eventId == i2) {
                next.count = Fi(i2);
                z = true;
                break;
            }
        }
        if (!z) {
            Log.i("MicroMsg.PhoneStateOverflow", "create inner:  event id = %d", Integer.valueOf(i2));
            C0934a aVar = new C0934a(this, (byte) 0);
            aVar.eventId = i2;
            aVar.eec = new b(aVar);
            aVar.count = 1;
            this.qCJ.add(aVar);
            TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a()).bl(aVar.eec);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/PhoneStateOverflow", "initInnerListener", "(I)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/PhoneStateOverflow", "initInnerListener", "(I)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        }
        AppMethodBeat.o(225351);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a(int i2, PhoneStateListener phoneStateListener, String str) {
        boolean z;
        AppMethodBeat.i(225352);
        Log.i("MicroMsg.PhoneStateOverflow", "add outter:  event id = %d, listener %d, stack = %s", Integer.valueOf(i2), Integer.valueOf(phoneStateListener.hashCode()), str);
        Iterator<c> it = this.qCI.iterator();
        while (true) {
            if (!it.hasNext()) {
                c cVar = new c(this, (byte) 0);
                cVar.eventId = i2;
                cVar.JRS = new WeakReference<>(phoneStateListener);
                this.qCI.add(cVar);
                AppMethodBeat.o(225352);
                z = true;
                break;
            }
            c next = it.next();
            PhoneStateListener phoneStateListener2 = next.JRS.get();
            if (phoneStateListener2 != null && phoneStateListener2 == phoneStateListener) {
                Log.i("MicroMsg.PhoneStateOverflow", "change outter event id %d to %d", Integer.valueOf(next.eventId), Integer.valueOf(i2));
                next.eventId = i2;
                AppMethodBeat.o(225352);
                z = false;
                break;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public class b extends PhoneStateListener {
        C0934a qCP;

        b(C0934a aVar) {
            this.qCP = aVar;
        }

        public final void onCallStateChanged(int i2, String str) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225334);
            super.onCallStateChanged(i2, str);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onCallStateChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onCallStateChanged(i2, str);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225334);
                }
            }
        }

        public final void onCallForwardingIndicatorChanged(boolean z) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225335);
            super.onCallForwardingIndicatorChanged(z);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onCallForwardingIndicatorChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onCallForwardingIndicatorChanged(z);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225335);
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225336);
            super.onCellInfoChanged(list);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onCellInfoChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onCellInfoChanged(list);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225336);
                }
            }
        }

        public final void onCellLocationChanged(CellLocation cellLocation) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225337);
            super.onCellLocationChanged(cellLocation);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onCellLocationChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onCellLocationChanged(cellLocation);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225337);
                }
            }
        }

        public final void onDataActivity(int i2) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225338);
            super.onDataActivity(i2);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onDataActivity %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onDataActivity(i2);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225338);
                }
            }
        }

        public final void onDataConnectionStateChanged(int i2) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225339);
            super.onDataConnectionStateChanged(i2);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onDataConnectionStateChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onDataConnectionStateChanged(i2);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225339);
                }
            }
        }

        public final void onDataConnectionStateChanged(int i2, int i3) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225340);
            super.onDataConnectionStateChanged(i2, i3);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onDataConnectionStateChanged2 %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onDataConnectionStateChanged(i2, i3);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225340);
                }
            }
        }

        public final void onMessageWaitingIndicatorChanged(boolean z) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225341);
            super.onMessageWaitingIndicatorChanged(z);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onMessageWaitingIndicatorChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onMessageWaitingIndicatorChanged(z);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225341);
                }
            }
        }

        public final void onServiceStateChanged(ServiceState serviceState) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225342);
            super.onServiceStateChanged(serviceState);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onServiceStateChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onServiceStateChanged(serviceState);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225342);
                }
            }
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225343);
            super.onSignalStrengthsChanged(signalStrength);
            Log.e("MicroMsg.PhoneStateOverflow", "onSignalStrengthsChanged call! ");
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onSignalStrengthsChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onSignalStrengthsChanged(signalStrength);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225343);
                }
            }
        }

        public final void onUserMobileDataStateChanged(boolean z) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225344);
            super.onUserMobileDataStateChanged(z);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onUserMobileDataStateChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onUserMobileDataStateChanged(z);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225344);
                }
            }
        }

        public final void onSignalStrengthChanged(int i2) {
            PhoneStateListener phoneStateListener;
            AppMethodBeat.i(225345);
            super.onSignalStrengthChanged(i2);
            synchronized (a.this) {
                try {
                    for (c cVar : a.this.qCI) {
                        if (cVar.eventId == this.qCP.eventId && (phoneStateListener = cVar.JRS.get()) != null) {
                            Log.i("MicroMsg.PhoneStateOverflow", "onSignalStrengthChanged %d %d", Integer.valueOf(this.qCP.eventId), Integer.valueOf(phoneStateListener.hashCode()));
                            phoneStateListener.onSignalStrengthChanged(i2);
                        }
                    }
                } finally {
                    AppMethodBeat.o(225345);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        WeakReference<PhoneStateListener> JRS;
        int eventId;

        private c() {
        }

        /* synthetic */ c(a aVar, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.crashfix.d.c.a$a  reason: collision with other inner class name */
    public class C0934a {
        int count;
        PhoneStateListener eec;
        int eventId;

        private C0934a() {
            this.count = 0;
        }

        /* synthetic */ C0934a(a aVar, byte b2) {
            this();
        }
    }
}
