package com.tencent.matrix.a.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import com.tencent.matrix.a.c.g;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class a {
    private static boolean cTW;
    private static g.b cTX = new g.b() {
        /* class com.tencent.matrix.a.c.a.AnonymousClass1 */

        @Override // com.tencent.matrix.a.c.g.b
        public final void b(Method method, Object[] objArr) {
            com.tencent.matrix.g.c.v("Matrix.battery.AlarmHooker", "onServiceMethodInvoke: method name %s", method.getName());
            a.a(method, objArr);
        }
    };
    private static g cTY = new g("alarm", "android.app.IAlarmManager", cTX);
    private static List<b> cTZ = new ArrayList();

    public interface b {
        void a(int i2, long j2, long j3, long j4, int i3, PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener);

        void a(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener);
    }

    static /* synthetic */ void a(Method method, Object[] objArr) {
        c cVar;
        C0218a aVar = null;
        if (method.getName().equals("set") || method.getName().equals("setRepeating") || method.getName().equals("setInexactRepeating")) {
            if (objArr != null) {
                com.tencent.matrix.g.c.i("Matrix.battery.AlarmHooker", "createSetArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.CODENAME, Integer.valueOf(Build.VERSION.SDK_INT));
                int length = objArr.length;
                com.tencent.matrix.g.c.i("Matrix.battery.AlarmHooker", "createSetArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
                switch (length) {
                    case 3:
                        if (objArr.length != 3) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            cVar = null;
                            break;
                        } else {
                            c cVar2 = new c((byte) 0);
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                cVar = null;
                                break;
                            } else {
                                cVar2.type = ((Integer) objArr[0]).intValue();
                                if (!(objArr[1] instanceof Long)) {
                                    com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                    cVar = null;
                                    break;
                                } else {
                                    cVar2.cQq = ((Long) objArr[1]).longValue();
                                    if (objArr[2] != null && !(objArr[2] instanceof PendingIntent)) {
                                        com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 2 not PendingIntent, %s", objArr[2]);
                                        cVar = null;
                                        break;
                                    } else {
                                        cVar2.cQB = (PendingIntent) objArr[2];
                                        cVar = cVar2;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        if (objArr.length != 4) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            cVar = null;
                            break;
                        } else {
                            c cVar3 = new c((byte) 0);
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                cVar = null;
                                break;
                            } else {
                                cVar3.type = ((Integer) objArr[0]).intValue();
                                if (!(objArr[1] instanceof Long)) {
                                    com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                    cVar = null;
                                    break;
                                } else {
                                    cVar3.cQq = ((Long) objArr[1]).longValue();
                                    if (!(objArr[2] instanceof Long)) {
                                        com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                        cVar = null;
                                        break;
                                    } else {
                                        cVar3.cQr = ((Long) objArr[2]).longValue();
                                        if (objArr[3] != null && !(objArr[3] instanceof PendingIntent)) {
                                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 3 not PendingIntent, %s", objArr[3]);
                                            cVar = null;
                                            break;
                                        } else {
                                            cVar3.cQB = (PendingIntent) objArr[3];
                                            cVar = cVar3;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 5:
                    default:
                        if (objArr.length != 11) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            cVar = null;
                            break;
                        } else {
                            c cVar4 = new c((byte) 0);
                            if (!(objArr[1] instanceof Integer)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 1 not Integer, %s", objArr[1]);
                                cVar = null;
                                break;
                            } else {
                                cVar4.type = ((Integer) objArr[1]).intValue();
                                if (!(objArr[2] instanceof Long)) {
                                    com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                    cVar = null;
                                    break;
                                } else {
                                    cVar4.cQq = ((Long) objArr[2]).longValue();
                                    if (!(objArr[3] instanceof Long)) {
                                        com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                                        cVar = null;
                                        break;
                                    } else {
                                        cVar4.cSw = ((Long) objArr[3]).longValue();
                                        if (!(objArr[4] instanceof Long)) {
                                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 4 not Long, %s", objArr[4]);
                                            cVar = null;
                                            break;
                                        } else {
                                            cVar4.cQr = ((Long) objArr[4]).longValue();
                                            if (!(objArr[5] instanceof Integer)) {
                                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 5 not Integer, %s", objArr[5]);
                                                cVar = null;
                                                break;
                                            } else {
                                                cVar4.flags = ((Integer) objArr[5]).intValue();
                                                if (objArr[6] != null && !(objArr[6] instanceof PendingIntent)) {
                                                    com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 6 not PendingIntent, %s", objArr[6]);
                                                    cVar = null;
                                                    break;
                                                } else {
                                                    cVar4.cQB = (PendingIntent) objArr[6];
                                                    cVar = cVar4;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 6:
                    case 7:
                        if (objArr.length != 7 && objArr.length != 6) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            cVar = null;
                            break;
                        } else {
                            c cVar5 = new c((byte) 0);
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                cVar = null;
                                break;
                            } else {
                                cVar5.type = ((Integer) objArr[0]).intValue();
                                if (!(objArr[1] instanceof Long)) {
                                    com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                    cVar = null;
                                    break;
                                } else {
                                    cVar5.cQq = ((Long) objArr[1]).longValue();
                                    if (!(objArr[2] instanceof Long)) {
                                        com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                        cVar = null;
                                        break;
                                    } else {
                                        cVar5.cSw = ((Long) objArr[2]).longValue();
                                        if (!(objArr[3] instanceof Long)) {
                                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                                            cVar = null;
                                            break;
                                        } else {
                                            cVar5.cQr = ((Long) objArr[3]).longValue();
                                            if (objArr[4] != null && !(objArr[4] instanceof PendingIntent)) {
                                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 4 not PendingIntent, %s", objArr[4]);
                                                cVar = null;
                                                break;
                                            } else {
                                                cVar5.cQB = (PendingIntent) objArr[4];
                                                cVar = cVar5;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 8:
                        if (objArr.length != 8) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            cVar = null;
                            break;
                        } else {
                            c cVar6 = new c((byte) 0);
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                cVar = null;
                                break;
                            } else {
                                cVar6.type = ((Integer) objArr[0]).intValue();
                                if (!(objArr[1] instanceof Long)) {
                                    com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                    cVar = null;
                                    break;
                                } else {
                                    cVar6.cQq = ((Long) objArr[1]).longValue();
                                    if (!(objArr[2] instanceof Long)) {
                                        com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                        cVar = null;
                                        break;
                                    } else {
                                        cVar6.cSw = ((Long) objArr[2]).longValue();
                                        if (!(objArr[3] instanceof Long)) {
                                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                                            cVar = null;
                                            break;
                                        } else {
                                            cVar6.cQr = ((Long) objArr[3]).longValue();
                                            if (!(objArr[4] instanceof Integer)) {
                                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 4 not Integer, %s", objArr[4]);
                                                cVar = null;
                                                break;
                                            } else {
                                                cVar6.flags = ((Integer) objArr[4]).intValue();
                                                if (objArr[5] != null && !(objArr[5] instanceof PendingIntent)) {
                                                    com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args idx 5 not PendingIntent, %s", objArr[5]);
                                                    cVar = null;
                                                    break;
                                                } else {
                                                    cVar6.cQB = (PendingIntent) objArr[5];
                                                    cVar = cVar6;
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
                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createSetArgs args null", new Object[0]);
                cVar = null;
            }
            if (cVar == null) {
                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "dispatchSet setArgs null", new Object[0]);
                return;
            }
            synchronized (a.class) {
                for (int i2 = 0; i2 < cTZ.size(); i2++) {
                    cTZ.get(i2).a(cVar.type, cVar.cQq, cVar.cSw, cVar.cQr, cVar.flags, cVar.cQB, cVar.cQt);
                }
            }
        } else if (method.getName().equals("remove")) {
            if (objArr != null) {
                com.tencent.matrix.g.c.i("Matrix.battery.AlarmHooker", "createCancelArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.CODENAME, Integer.valueOf(Build.VERSION.SDK_INT));
                int length2 = objArr.length;
                com.tencent.matrix.g.c.i("Matrix.battery.AlarmHooker", "createCancelArgsAccordingToArgsLength: length:%s", Integer.valueOf(length2));
                switch (length2) {
                    case 1:
                        if (objArr.length != 1) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createCancelArgs1 args length invalid : %d", Integer.valueOf(objArr.length));
                            break;
                        } else {
                            C0218a aVar2 = new C0218a((byte) 0);
                            if (objArr[0] != null && !(objArr[0] instanceof PendingIntent)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createCancelArgs1 args idx 0 not PendingIntent, %s", objArr[0]);
                                break;
                            } else {
                                aVar2.cQB = (PendingIntent) objArr[0];
                                aVar = aVar2;
                                break;
                            }
                        }
                        break;
                    default:
                        if (objArr.length != 2) {
                            com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createCancelArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                            break;
                        } else {
                            C0218a aVar3 = new C0218a((byte) 0);
                            if (objArr[0] != null && !(objArr[0] instanceof PendingIntent)) {
                                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createCancelArgs2 args idx 0 not PendingIntent, %s", objArr[0]);
                                break;
                            } else {
                                aVar3.cQB = (PendingIntent) objArr[0];
                                aVar = aVar3;
                                break;
                            }
                        }
                        break;
                }
            } else {
                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "createCancelArgs args null", new Object[0]);
            }
            if (aVar == null) {
                com.tencent.matrix.g.c.w("Matrix.battery.AlarmHooker", "dispatchCancel cancelArgs null", new Object[0]);
                return;
            }
            synchronized (a.class) {
                for (int i3 = 0; i3 < cTZ.size(); i3++) {
                    cTZ.get(i3).a(aVar.cQB, aVar.cQt);
                }
            }
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (a.class) {
            if (!cTZ.contains(bVar)) {
                cTZ.add(bVar);
                if (!cTW && !cTZ.isEmpty()) {
                    com.tencent.matrix.g.c.i("Matrix.battery.AlarmHooker", "checkHook hookRet:%b", Boolean.valueOf(cTY.doHook()));
                    cTW = true;
                }
            }
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (a.class) {
            cTZ.remove(bVar);
            if (cTW && cTZ.isEmpty()) {
                com.tencent.matrix.g.c.i("Matrix.battery.AlarmHooker", "checkUnHook unHookRet:%b", Boolean.valueOf(cTY.doUnHook()));
                cTW = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        PendingIntent cQB;
        long cQq;
        long cQr;
        AlarmManager.OnAlarmListener cQt;
        long cSw;
        int flags;
        int type;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.matrix.a.c.a$a  reason: collision with other inner class name */
    public static final class C0218a {
        PendingIntent cQB;
        AlarmManager.OnAlarmListener cQt;

        private C0218a() {
        }

        /* synthetic */ C0218a(byte b2) {
            this();
        }
    }
}
