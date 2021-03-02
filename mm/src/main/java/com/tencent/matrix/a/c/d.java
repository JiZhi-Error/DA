package com.tencent.matrix.a.c;

import android.os.Build;
import android.os.IBinder;
import android.os.WorkSource;
import com.tencent.matrix.a.c.g;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static boolean cTW;
    private static g.b cTX = new g.b() {
        /* class com.tencent.matrix.a.c.d.AnonymousClass1 */

        @Override // com.tencent.matrix.a.c.g.b
        public final void b(Method method, Object[] objArr) {
            com.tencent.matrix.g.c.v("Matrix.battery.PowerHooker", "onServiceMethodInvoke: method name %s", method.getName());
            d.a(method, objArr);
        }
    };
    private static g cTY = new g("power", "android.os.IPowerManager", cTX);
    private static List<b> cTZ = new ArrayList();

    public interface b {
        void a(IBinder iBinder, int i2);

        void a(IBinder iBinder, int i2, String str, String str2, WorkSource workSource, String str3);
    }

    static /* synthetic */ void a(Method method, Object[] objArr) {
        a aVar;
        c cVar = null;
        if (method.getName().equals("acquireWakeLock")) {
            if (objArr != null) {
                com.tencent.matrix.g.c.i("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.CODENAME, Integer.valueOf(Build.VERSION.SDK_INT));
                int length = objArr.length;
                com.tencent.matrix.g.c.i("Matrix.battery.PowerHooker", "createAcquireWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
                switch (length) {
                    case 4:
                        if (objArr.length != 4) {
                            com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs4 args length invalid : %d", Integer.valueOf(objArr.length));
                            aVar = null;
                            break;
                        } else {
                            a aVar2 = new a((byte) 0);
                            if (objArr[2] != null && !(objArr[2] instanceof String)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 2 not String, %s", objArr[2]);
                                aVar = null;
                                break;
                            } else {
                                aVar2.tag = (String) objArr[2];
                                if (objArr[3] != null && !(objArr[3] instanceof WorkSource)) {
                                    com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 3 not WorkSource, %s", objArr[3]);
                                    aVar = null;
                                    break;
                                } else {
                                    aVar2.cUb = (WorkSource) objArr[3];
                                    if (objArr[0] instanceof Integer) {
                                        aVar2.flags = ((Integer) objArr[0]).intValue();
                                        if (!(objArr[1] instanceof IBinder)) {
                                            com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 1 not IBinder, %s", objArr[1]);
                                            aVar = null;
                                            break;
                                        } else {
                                            aVar2.token = (IBinder) objArr[1];
                                        }
                                    } else if (!(objArr[0] instanceof IBinder)) {
                                        com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs4 args idx 0 not IBinder an Integer, %s", objArr[0]);
                                        aVar = null;
                                        break;
                                    } else {
                                        aVar2.token = (IBinder) objArr[0];
                                        if (!(objArr[1] instanceof Integer)) {
                                            com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs4 args idx 1 not Integer, %s", objArr[1]);
                                            aVar = null;
                                            break;
                                        } else {
                                            aVar2.flags = ((Integer) objArr[1]).intValue();
                                        }
                                    }
                                    aVar = aVar2;
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        if (objArr.length != 6 && objArr.length != 5) {
                            com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args length invalid : %d", Integer.valueOf(objArr.length));
                            aVar = null;
                            break;
                        } else {
                            a aVar3 = new a((byte) 0);
                            if (!(objArr[0] instanceof IBinder)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 0 not IBinder, %s", objArr[0]);
                                aVar = null;
                                break;
                            } else {
                                aVar3.token = (IBinder) objArr[0];
                                if (!(objArr[1] instanceof Integer)) {
                                    com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 1 not Integer, %s", objArr[1]);
                                    aVar = null;
                                    break;
                                } else {
                                    aVar3.flags = ((Integer) objArr[1]).intValue();
                                    if (objArr[2] != null && !(objArr[2] instanceof String)) {
                                        com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 2 not String, %s", objArr[2]);
                                        aVar = null;
                                        break;
                                    } else {
                                        aVar3.tag = (String) objArr[2];
                                        if (objArr[3] != null && !(objArr[3] instanceof String)) {
                                            com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 3 not String, %s", objArr[3]);
                                            aVar = null;
                                            break;
                                        } else {
                                            aVar3.packageName = (String) objArr[3];
                                            if (objArr[4] != null && !(objArr[4] instanceof WorkSource)) {
                                                com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 4 not WorkSource, %s", objArr[4]);
                                                aVar = null;
                                                break;
                                            } else {
                                                aVar3.cUb = (WorkSource) objArr[4];
                                                if (objArr.length != 5) {
                                                    if (objArr[5] != null && !(objArr[5] instanceof String)) {
                                                        com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs6 args idx 5 not String, %s", objArr[5]);
                                                        aVar = null;
                                                        break;
                                                    } else {
                                                        aVar3.cUc = (String) objArr[5];
                                                        aVar = aVar3;
                                                        break;
                                                    }
                                                } else {
                                                    aVar = aVar3;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                }
            } else {
                com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createAcquireWakeLockArgs args null", new Object[0]);
                aVar = null;
            }
            if (aVar == null) {
                com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "dispatchAcquireWakeLock AcquireWakeLockArgs null", new Object[0]);
                return;
            }
            synchronized (d.class) {
                for (int i2 = 0; i2 < cTZ.size(); i2++) {
                    cTZ.get(i2).a(aVar.token, aVar.flags, aVar.tag, aVar.packageName, aVar.cUb, aVar.cUc);
                }
            }
        } else if (method.getName().equals("releaseWakeLock")) {
            if (objArr == null) {
                com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createReleaseWakeLockArgs args null", new Object[0]);
            } else {
                com.tencent.matrix.g.c.i("Matrix.battery.PowerHooker", "createReleaseWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.CODENAME, Integer.valueOf(Build.VERSION.SDK_INT));
                com.tencent.matrix.g.c.i("Matrix.battery.PowerHooker", "createReleaseWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                if (objArr.length != 2) {
                    com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createReleaseWakeLockArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                } else {
                    c cVar2 = new c((byte) 0);
                    if (!(objArr[0] instanceof IBinder)) {
                        com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createReleaseWakeLockArgs2 args idx 0 not IBinder, %s", objArr[0]);
                    } else {
                        cVar2.token = (IBinder) objArr[0];
                        if (!(objArr[1] instanceof Integer)) {
                            com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "createReleaseWakeLockArgs2 args idx 1 not Integer, %s", objArr[1]);
                        } else {
                            cVar2.flags = ((Integer) objArr[1]).intValue();
                            cVar = cVar2;
                        }
                    }
                }
            }
            if (cVar == null) {
                com.tencent.matrix.g.c.w("Matrix.battery.PowerHooker", "dispatchReleaseWakeLock AcquireWakeLockArgs null", new Object[0]);
                return;
            }
            synchronized (d.class) {
                for (int i3 = 0; i3 < cTZ.size(); i3++) {
                    cTZ.get(i3).a(cVar.token, cVar.flags);
                }
            }
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (d.class) {
            if (!cTZ.contains(bVar)) {
                cTZ.add(bVar);
                if (!cTW && !cTZ.isEmpty()) {
                    com.tencent.matrix.g.c.i("Matrix.battery.PowerHooker", "checkHook hookRet:%b", Boolean.valueOf(cTY.doHook()));
                    cTW = true;
                }
            }
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (d.class) {
            cTZ.remove(bVar);
            if (cTW && cTZ.isEmpty()) {
                com.tencent.matrix.g.c.i("Matrix.battery.PowerHooker", "checkUnHook unHookRet:%b", Boolean.valueOf(cTY.doUnHook()));
                cTW = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        WorkSource cUb;
        String cUc;
        int flags;
        String packageName;
        String tag;
        IBinder token;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        int flags;
        IBinder token;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }
}
