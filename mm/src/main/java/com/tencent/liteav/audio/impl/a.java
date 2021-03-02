package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f177a = new a();

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<Integer, WeakReference<b>> f178b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private PhoneStateListener f179c = null;

    /* renamed from: d  reason: collision with root package name */
    private Context f180d;

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(221880);
        aVar.a(i2);
        AppMethodBeat.o(221880);
    }

    static {
        AppMethodBeat.i(221881);
        AppMethodBeat.o(221881);
    }

    public static a a() {
        return f177a;
    }

    private a() {
        AppMethodBeat.i(16413);
        AppMethodBeat.o(16413);
    }

    public synchronized void a(b bVar) {
        AppMethodBeat.i(221877);
        if (bVar == null) {
            AppMethodBeat.o(221877);
        } else {
            this.f178b.put(Integer.valueOf(bVar.hashCode()), new WeakReference<>(bVar));
            AppMethodBeat.o(221877);
        }
    }

    private synchronized void a(int i2) {
        AppMethodBeat.i(16444);
        Iterator<Map.Entry<Integer, WeakReference<b>>> it = this.f178b.entrySet().iterator();
        while (it.hasNext()) {
            b bVar = it.next().getValue().get();
            if (bVar != null) {
                bVar.onCallStateChanged(i2);
            } else {
                it.remove();
            }
        }
        AppMethodBeat.o(16444);
    }

    public void a(Context context) {
        AppMethodBeat.i(221878);
        if (this.f179c != null) {
            AppMethodBeat.o(221878);
            return;
        }
        this.f180d = context.getApplicationContext();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.liteav.audio.impl.a.AnonymousClass1 */
            private byte _hellAccFlag_;

            public void run() {
                AppMethodBeat.i(221898);
                if (a.this.f179c != null) {
                    AppMethodBeat.o(221898);
                    return;
                }
                a.this.f179c = new PhoneStateListener() {
                    /* class com.tencent.liteav.audio.impl.a.AnonymousClass1.AnonymousClass1 */

                    public void onCallStateChanged(int i2, String str) {
                        AppMethodBeat.i(221869);
                        super.onCallStateChanged(i2, str);
                        TXCLog.i("AudioCenter:TXCTelephonyMgr", "onCallStateChanged:".concat(String.valueOf(i2)));
                        a.a(a.this, i2);
                        AppMethodBeat.o(221869);
                    }
                };
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) a.this.f180d.getSystemService("phone");
                    com.tencent.mm.hellhoundlib.b.a bl = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(a.this.f179c);
                    com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/liteav/audio/impl/a$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                    telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/liteav/audio/impl/a$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                    AppMethodBeat.o(221898);
                } catch (Exception e2) {
                    TXCLog.e("AudioCenter:TXCTelephonyMgr", "TelephonyManager listen error ", e2);
                    AppMethodBeat.o(221898);
                }
            }
        });
        AppMethodBeat.o(221878);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(221879);
        super.finalize();
        if (!(this.f179c == null || this.f180d == null)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.liteav.audio.impl.a.AnonymousClass2 */
                private byte _hellAccFlag_;

                public void run() {
                    AppMethodBeat.i(221932);
                    if (!(a.this.f179c == null || a.this.f180d == null)) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) a.this.f180d.getApplicationContext().getSystemService("phone");
                            com.tencent.mm.hellhoundlib.b.a bl = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(a.this.f179c);
                            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/liteav/audio/impl/a$2", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/liteav/audio/impl/a$2", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                        } catch (Exception e2) {
                            TXCLog.e("AudioCenter:TXCTelephonyMgr", "TelephonyManager listen error ", e2);
                        }
                    }
                    a.this.f179c = null;
                    AppMethodBeat.o(221932);
                }
            });
        }
        AppMethodBeat.o(221879);
    }
}
