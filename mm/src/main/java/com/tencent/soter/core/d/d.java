package com.tencent.soter.core.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.b;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.soterserver.SoterSignResult;
import com.tencent.soter.soterserver.a;
import java.security.Signature;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class d extends b implements b {
    protected static a RQh;
    private static boolean RQi = false;
    private static f RQj = new f();
    private static boolean aCh = false;
    private static int dHO = 0;
    private static final Object lock = new Object();
    public static int uid = 0;
    private e RPi;
    private int RQc = 0;
    private int RQd = 0;
    private long RQe = 0;
    private boolean RQf = false;
    private Handler RQg = new Handler(Looper.getMainLooper());
    private IBinder.DeathRecipient RQk = new IBinder.DeathRecipient() {
        /* class com.tencent.soter.core.d.d.AnonymousClass1 */

        public final void binderDied() {
            AppMethodBeat.i(88696);
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: binder died", new Object[0]);
            if (d.RQh == null) {
                AppMethodBeat.o(88696);
                return;
            }
            d.RQh.asBinder().unlinkToDeath(d.this.RQk, 0);
            d.RQh = null;
            if (d.this.RPi != null) {
                d.this.RPi.fma();
            }
            synchronized (d.lock) {
                try {
                    int unused = d.dHO = 0;
                    d.this.cKu();
                    d.c(d.this);
                } finally {
                    AppMethodBeat.o(88696);
                }
            }
        }
    };
    private ServiceConnection RQl = new ServiceConnection() {
        /* class com.tencent.soter.core.d.d.AnonymousClass2 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(88697);
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: onServiceConnected", new Object[0]);
            synchronized (d.lock) {
                try {
                    int unused = d.dHO = 2;
                } catch (Throwable th) {
                    AppMethodBeat.o(88697);
                    throw th;
                }
            }
            d.this.RQd = 0;
            try {
                iBinder.linkToDeath(d.this.RQk, 0);
                d.RQh = a.AbstractBinderC2193a.Q(iBinder);
            } catch (RemoteException e2) {
                com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: Binding deathRecipient is error - RemoteException" + e2.toString(), new Object[0]);
            }
            if (d.this.RPi != null) {
                d.this.RPi.onServiceConnected();
            }
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: Binding is done - Service connected", new Object[0]);
            d.RQj.countDown();
            AppMethodBeat.o(88697);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(88698);
            synchronized (d.lock) {
                try {
                    int unused = d.dHO = 0;
                    d.RQh = null;
                    d.this.RQd = 0;
                    if (d.this.RPi != null) {
                        d.this.RPi.flZ();
                    }
                    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: unBinding is done - Service disconnected", new Object[0]);
                    d.c(d.this);
                    d.RQj.countDown();
                } finally {
                    AppMethodBeat.o(88698);
                }
            }
        }

        public final void onBindingDied(ComponentName componentName) {
            AppMethodBeat.i(88699);
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: binding died", new Object[0]);
            int unused = d.dHO = 0;
            d.RQh = null;
            d.this.RQd = 0;
            d.this.cKu();
            d.c(d.this);
            AppMethodBeat.o(88699);
        }
    };
    private Context mContext;
    private boolean rop = true;

    public d() {
        AppMethodBeat.i(88703);
        AppMethodBeat.o(88703);
    }

    static /* synthetic */ int f(d dVar) {
        int i2 = dVar.RQd;
        dVar.RQd = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(88725);
        AppMethodBeat.o(88725);
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean lg(Context context) {
        AppMethodBeat.i(88704);
        this.mContext = context;
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter in", new Object[0]);
        aCh = true;
        f fVar = RQj;
        AnonymousClass4 r3 = new Runnable() {
            /* class com.tencent.soter.core.d.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(88701);
                d.this.hlw();
                com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter binding", new Object[0]);
                AppMethodBeat.o(88701);
            }
        };
        com.tencent.soter.core.c.d.i("Soter.SyncJob", "doAsSyncJob", new Object[0]);
        fVar.JTq = new CountDownLatch(1);
        r3.run();
        if (fVar.JTq != null) {
            try {
                fVar.JTq.await(3000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                com.tencent.soter.core.c.d.a("Soter.SyncJob", e2, "");
            }
        }
        aCh = false;
        if (dHO == 2) {
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSoter finish", new Object[0]);
            RQi = true;
            AppMethodBeat.o(88704);
            return true;
        }
        dHO = 0;
        com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: initSoter error", new Object[0]);
        AppMethodBeat.o(88704);
        return false;
    }

    public static boolean isInitializing() {
        return aCh;
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean hlh() {
        return dHO == 2;
    }

    @Override // com.tencent.soter.core.d.b
    public final void a(e eVar) {
        this.RPi = eVar;
    }

    public final void hlw() {
        AppMethodBeat.i(88706);
        if (dHO != 2 || RQh == null || !RQh.asBinder().isBinderAlive() || !RQh.asBinder().pingBinder()) {
            com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindServiceIfNeeded try to bind", new Object[0]);
            cyb();
            AppMethodBeat.o(88706);
            return;
        }
        com.tencent.soter.core.c.d.d("Soter.SoterCoreTreble", "no need rebind", new Object[0]);
        AppMethodBeat.o(88706);
    }

    public final void cyb() {
        AppMethodBeat.i(88707);
        Intent intent = new Intent();
        intent.setAction("com.tencent.soter.soterserver.ISoterService");
        intent.setPackage("com.tencent.soter.soterserver");
        if (this.mContext == null) {
            com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: bindService context is null ", new Object[0]);
            AppMethodBeat.o(88707);
            return;
        }
        dHO = 1;
        if (this.RPi != null) {
            this.RPi.flY();
        }
        this.RQe = SystemClock.elapsedRealtime();
        this.RQf = this.mContext.bindService(intent, this.RQl, 1);
        hlx();
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindService binding is start ", new Object[0]);
        AppMethodBeat.o(88707);
    }

    private void hlx() {
        AppMethodBeat.i(88708);
        final long OB = OB((long) (this.RQd + 3));
        this.RQg.postDelayed(new Runnable() {
            /* class com.tencent.soter.core.d.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(88702);
                if (!d.this.rop || !d.RQi) {
                    AppMethodBeat.o(88702);
                    return;
                }
                d.f(d.this);
                if (d.dHO != 2) {
                    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: bindservice no response: %s", Long.valueOf(OB));
                    d.this.cyb();
                }
                AppMethodBeat.o(88702);
            }
        }, OB * 1000);
        AppMethodBeat.o(88708);
    }

    public final void cKu() {
        AppMethodBeat.i(88709);
        if (this.RQf) {
            try {
                this.mContext.unbindService(this.RQl);
            } catch (Exception e2) {
                com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "");
            } finally {
                this.RQf = false;
                AppMethodBeat.o(88709);
            }
        } else {
            AppMethodBeat.o(88709);
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean hlj() {
        AppMethodBeat.i(88710);
        if (h.hlu()) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: the device has already triggered OOM. mark as not support", new Object[0]);
            AppMethodBeat.o(88710);
            return false;
        }
        AppMethodBeat.o(88710);
        return true;
    }

    private boolean hly() {
        AppMethodBeat.i(88711);
        if (RQh == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
            if (this.RPi != null) {
                this.RPi.fmb();
            }
            AppMethodBeat.o(88711);
            return true;
        }
        AppMethodBeat.o(88711);
        return false;
    }

    @Override // com.tencent.soter.core.d.b
    public final f hlk() {
        AppMethodBeat.i(88712);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAppSecureKey in", new Object[0]);
        if (!hlj()) {
            f fVar = new f(4);
            AppMethodBeat.o(88712);
            return fVar;
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            f fVar2 = new f(4);
            AppMethodBeat.o(88712);
            return fVar2;
        } else {
            hlw();
            if (hly()) {
                f fVar3 = new f(4);
                AppMethodBeat.o(88712);
                return fVar3;
            }
            try {
                if (RQh.aqG(uid) == 0) {
                    f fVar4 = new f(0);
                    AppMethodBeat.o(88712);
                    return fVar4;
                }
            } catch (RemoteException e2) {
                com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: generateAppSecureKey fail: ");
            }
            f fVar5 = new f(4);
            AppMethodBeat.o(88712);
            return fVar5;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final f hll() {
        AppMethodBeat.i(88713);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAppGlobalSecureKey in", new Object[0]);
        if (!hlj()) {
            f fVar = new f(5);
            AppMethodBeat.o(88713);
            return fVar;
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            f fVar2 = new f(5);
            AppMethodBeat.o(88713);
            return fVar2;
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                f fVar3 = new f(5);
                AppMethodBeat.o(88713);
                return fVar3;
            }
            try {
                if (RQh.aqJ(uid) == 0) {
                    f fVar4 = new f(0);
                    AppMethodBeat.o(88713);
                    return fVar4;
                }
            } catch (RemoteException e2) {
                com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: removeAppGlobalSecureKey fail: ");
            }
            f fVar5 = new f(5);
            AppMethodBeat.o(88713);
            return fVar5;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean hlm() {
        boolean z = false;
        AppMethodBeat.i(88714);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAppGlobalSecureKey in", new Object[0]);
        if (!hlj()) {
            AppMethodBeat.o(88714);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(88714);
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(88714);
            } else {
                try {
                    z = RQh.aqI(uid);
                    AppMethodBeat.o(88714);
                } catch (RemoteException e2) {
                    com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: hasAppGlobalSecureKey fail: ");
                    AppMethodBeat.o(88714);
                }
            }
        }
        return z;
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean hln() {
        AppMethodBeat.i(88715);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAppGlobalSecureKeyValid in", new Object[0]);
        if (!hlm() || hlo() == null) {
            AppMethodBeat.o(88715);
            return false;
        }
        AppMethodBeat.o(88715);
        return true;
    }

    @Override // com.tencent.soter.core.d.b
    public final i hlo() {
        i iVar = null;
        AppMethodBeat.i(88716);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAppGlobalSecureKeyModel in", new Object[0]);
        if (!hlj()) {
            AppMethodBeat.o(88716);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(88716);
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(88716);
            } else {
                try {
                    byte[] bArr = RQh.aqH(uid).RQo;
                    if (bArr == null || bArr.length <= 0) {
                        com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.o(88716);
                    } else {
                        iVar = cZ(bArr);
                        AppMethodBeat.o(88716);
                    }
                } catch (RemoteException e2) {
                    com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: getAppGlobalSecureKeyModel fail: ");
                    AppMethodBeat.o(88716);
                }
            }
        }
        return iVar;
    }

    @Override // com.tencent.soter.core.d.b
    public final f bqg(String str) {
        AppMethodBeat.i(88717);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: generateAuthKey in", new Object[0]);
        if (!hlj()) {
            f fVar = new f(6);
            AppMethodBeat.o(88717);
            return fVar;
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            f fVar2 = new f(6);
            AppMethodBeat.o(88717);
            return fVar2;
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                f fVar3 = new f(6);
                AppMethodBeat.o(88717);
                return fVar3;
            }
            try {
                if (RQh.ds(uid, str) == 0) {
                    f fVar4 = new f(0);
                    AppMethodBeat.o(88717);
                    return fVar4;
                }
            } catch (RemoteException e2) {
                com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: generateAuthKey fail: ");
            }
            f fVar5 = new f(6);
            AppMethodBeat.o(88717);
            return fVar5;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final f dE(String str, boolean z) {
        AppMethodBeat.i(88718);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: removeAuthKey in", new Object[0]);
        if (!hlj()) {
            f fVar = new f(7);
            AppMethodBeat.o(88718);
            return fVar;
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            f fVar2 = new f(7);
            AppMethodBeat.o(88718);
            return fVar2;
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                f fVar3 = new f(7);
                AppMethodBeat.o(88718);
                return fVar3;
            }
            try {
                if (RQh.dt(uid, str) == 0) {
                    if (!z) {
                        f fVar4 = new f(0);
                        AppMethodBeat.o(88718);
                        return fVar4;
                    } else if (RQh.aqJ(uid) == 0) {
                        f fVar5 = new f(0);
                        AppMethodBeat.o(88718);
                        return fVar5;
                    } else {
                        f fVar6 = new f(5);
                        AppMethodBeat.o(88718);
                        return fVar6;
                    }
                }
            } catch (RemoteException e2) {
                com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: removeAuthKey fail: ");
            }
            f fVar7 = new f(7);
            AppMethodBeat.o(88718);
            return fVar7;
        }
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean bqi(String str) {
        AppMethodBeat.i(88719);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: isAuthKeyValid in", new Object[0]);
        if (!bqh(str) || bqj(str) == null) {
            AppMethodBeat.o(88719);
            return false;
        }
        AppMethodBeat.o(88719);
        return true;
    }

    @Override // com.tencent.soter.core.d.b
    public final i bqj(String str) {
        i iVar = null;
        AppMethodBeat.i(88720);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: getAuthKeyModel in", new Object[0]);
        if (!hlj()) {
            AppMethodBeat.o(88720);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(88720);
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(88720);
            } else {
                try {
                    byte[] bArr = RQh.du(uid, str).RQo;
                    if (bArr == null || bArr.length <= 0) {
                        com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.o(88720);
                    } else {
                        iVar = cZ(bArr);
                        AppMethodBeat.o(88720);
                    }
                } catch (RemoteException e2) {
                    com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: getAuthKeyModel fail: ");
                    AppMethodBeat.o(88720);
                }
            }
        }
        return iVar;
    }

    @Override // com.tencent.soter.core.d.b
    public final Signature bqk(String str) {
        return null;
    }

    @Override // com.tencent.soter.core.d.b
    public final boolean bqh(String str) {
        boolean z = false;
        AppMethodBeat.i(88721);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: hasAuthKey in", new Object[0]);
        if (!hlj()) {
            AppMethodBeat.o(88721);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(88721);
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(88721);
            } else {
                try {
                    z = RQh.dv(uid, str);
                    AppMethodBeat.o(88721);
                } catch (RemoteException e2) {
                    com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: hasAuthKey fail: ");
                    AppMethodBeat.o(88721);
                }
            }
        }
        return z;
    }

    @Override // com.tencent.soter.core.d.b
    public final SoterSessionResult nI(String str, String str2) {
        SoterSessionResult soterSessionResult = null;
        AppMethodBeat.i(88722);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: initSigh in", new Object[0]);
        if (!hlj()) {
            AppMethodBeat.o(88722);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(88722);
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(88722);
            } else {
                try {
                    soterSessionResult = RQh.ab(uid, str, str2);
                    AppMethodBeat.o(88722);
                } catch (RemoteException e2) {
                    com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: initSigh fail: ");
                    AppMethodBeat.o(88722);
                }
            }
        }
        return soterSessionResult;
    }

    @Override // com.tencent.soter.core.d.b
    public final byte[] Oz(long j2) {
        byte[] bArr = null;
        AppMethodBeat.i(88723);
        com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: finishSign in", new Object[0]);
        if (!hlj()) {
            AppMethodBeat.o(88723);
        } else if (this.mContext == null) {
            com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: context is null", new Object[0]);
            AppMethodBeat.o(88723);
        } else {
            hlw();
            if (hly()) {
                com.tencent.soter.core.c.d.w("Soter.SoterCoreTreble", "soter: soter service not found", new Object[0]);
                AppMethodBeat.o(88723);
            } else {
                bArr = new byte[0];
                try {
                    SoterSignResult OC = RQh.OC(j2);
                    bArr = OC.RQo;
                    if (OC.resultCode != 0) {
                        Exception exc = new Exception("finishSign error");
                        AppMethodBeat.o(88723);
                        throw exc;
                    }
                } catch (RemoteException e2) {
                    com.tencent.soter.core.c.d.a("Soter.SoterCoreTreble", e2, "soter: finishSign fail: ");
                }
                AppMethodBeat.o(88723);
            }
        }
        return bArr;
    }

    private static long OB(long j2) {
        long j3 = 0;
        if (j2 < 0) {
            return -1;
        }
        if (j2 == 0) {
            return 0;
        }
        if (j2 == 1 || j2 == 2) {
            return 1;
        }
        int i2 = 3;
        long j4 = 1;
        long j5 = 1;
        while (((long) i2) <= j2) {
            long j6 = j5 + j4;
            i2++;
            j5 = j4;
            j3 = j6;
            j4 = j6;
        }
        return j3;
    }

    @Override // com.tencent.soter.core.d.b
    public final void hli() {
        AppMethodBeat.i(88705);
        this.RQc = 0;
        hlw();
        AppMethodBeat.o(88705);
    }

    static /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(88724);
        if (dVar.rop) {
            dVar.RQc++;
            long OB = OB((long) dVar.RQc);
            long elapsedRealtime = OB - ((SystemClock.elapsedRealtime() - dVar.RQe) / 1000);
            com.tencent.soter.core.c.d.d("Soter.SoterCoreTreble", "fib: %s, rebind delay: %sS", Long.valueOf(OB), Long.valueOf(elapsedRealtime));
            if (elapsedRealtime <= 0) {
                dVar.cyb();
                AppMethodBeat.o(88724);
                return;
            }
            dVar.RQg.postDelayed(new Runnable() {
                /* class com.tencent.soter.core.d.d.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(88700);
                    d.this.hlw();
                    AppMethodBeat.o(88700);
                }
            }, elapsedRealtime * 1000);
        }
        AppMethodBeat.o(88724);
    }
}
