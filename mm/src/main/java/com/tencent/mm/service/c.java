package com.tencent.mm.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.a;
import com.tencent.mm.service.b;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static ConcurrentHashMap<String, b> NKc = new ConcurrentHashMap<>();
    private static Vector<Intent> NKd = new Vector<>();
    private static Vector<Intent> NKe = new Vector<>();
    private static ConcurrentHashMap<Integer, String> NKf = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, IBinder> NKg = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, IBinder.DeathRecipient> NKh = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(125331);
        AppMethodBeat.o(125331);
    }

    public static void a(final Intent intent, final String str, final boolean z, final Intent intent2) {
        AppMethodBeat.i(125324);
        if (intent == null) {
            Log.i("MicroMsg.MMServiceHelper", "startService Intent == null");
            AppMethodBeat.o(125324);
            return;
        }
        final String className = intent.getComponent().getClassName();
        if (Util.isNullOrNil(className)) {
            Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = null processName = %s", str);
            AppMethodBeat.o(125324);
            return;
        }
        intent.putExtra("class_name", className);
        b bVar = NKc.get(str);
        if (bVar == null) {
            NKd.add(intent);
            Context context = MMApplicationContext.getContext();
            h(context, str, intent2);
            try {
                Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s bindService_result = %b", className, str, Boolean.valueOf(context.bindService(intent2, new ServiceConnection() {
                    /* class com.tencent.mm.service.c.AnonymousClass1 */

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        AppMethodBeat.i(125310);
                        e.INSTANCE.idkeyStat(963, 2, 1, false);
                        if (iBinder == null) {
                            Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected() service == null", className, str);
                            AppMethodBeat.o(125310);
                            return;
                        }
                        Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceConnected()", className, str);
                        if (!c.NKd.contains(intent)) {
                            AppMethodBeat.o(125310);
                            return;
                        }
                        try {
                            b P = b.a.P(iBinder);
                            P.startService(intent);
                            c.NKc.put(str, P);
                        } catch (Exception e2) {
                            if (z) {
                                e.INSTANCE.idkeyStat(963, 5, 1, false);
                                c.a(intent, str, false, intent2);
                            }
                            e.INSTANCE.idkeyStat(963, 3, 1, false);
                            Log.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", className, str, e2.getMessage(), Util.getStack());
                        } finally {
                            c.NKd.remove(intent);
                            AppMethodBeat.o(125310);
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.i(125311);
                        c.NKc.remove(str);
                        Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s onServiceDisconnected()", className, str);
                        e.INSTANCE.idkeyStat(963, 4, 1, false);
                        AppMethodBeat.o(125311);
                    }
                }, 1)));
            } catch (Exception e2) {
                Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", className, str, e2.getMessage());
            }
            e.INSTANCE.idkeyStat(963, 1, 1, false);
        } else {
            try {
                bVar.startService(intent);
            } catch (Exception e3) {
                NKc.remove(str);
                if (z) {
                    a(intent, str, false, intent2);
                    e.INSTANCE.idkeyStat(963, 5, 1, false);
                }
                Log.i("MicroMsg.MMServiceHelper", "startService ClassName = %s ProcessName = %s  exception = %s stack[%s]", className, str, e3.getMessage(), Util.getStack());
            }
            Log.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, startService() ClassName = %s ProcessName = %s ", className, str);
            e.INSTANCE.idkeyStat(963, 6, 1, false);
        }
        Log.i("MicroMsg.MMServiceHelper", "startService() ClassName = %s ProcessName = %s", className, str);
        e.INSTANCE.idkeyStat(963, 0, 1, false);
        AppMethodBeat.o(125324);
    }

    public static void b(final Intent intent, final String str, final boolean z, final Intent intent2) {
        AppMethodBeat.i(125325);
        if (intent == null) {
            Log.i("MicroMsg.MMServiceHelper", "stopService Intent == null");
            AppMethodBeat.o(125325);
            return;
        }
        final String className = intent.getComponent().getClassName();
        if (Util.isNullOrNil(className)) {
            Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = null processName = %s", str);
            AppMethodBeat.o(125325);
            return;
        }
        b bVar = NKc.get(str);
        intent.putExtra("class_name", className);
        if (bVar == null) {
            e.INSTANCE.idkeyStat(963, 17, 1, false);
            Context context = MMApplicationContext.getContext();
            h(context, str, intent2);
            try {
                Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s bindService_result = %b", className, str, Boolean.valueOf(context.bindService(intent2, new ServiceConnection() {
                    /* class com.tencent.mm.service.c.AnonymousClass2 */

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        AppMethodBeat.i(125312);
                        e.INSTANCE.idkeyStat(963, 18, 1, false);
                        if (iBinder == null) {
                            Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected() service == null", className, str);
                            AppMethodBeat.o(125312);
                            return;
                        }
                        Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceConnected()", className, str);
                        try {
                            b P = b.a.P(iBinder);
                            P.bs(intent);
                            c.NKc.put(str, P);
                            AppMethodBeat.o(125312);
                        } catch (Exception e2) {
                            if (z) {
                                c.b(intent, str, false, intent2);
                                e.INSTANCE.idkeyStat(963, 21, 1, false);
                            }
                            Log.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", className, str, e2.getMessage(), Util.getStack());
                            e.INSTANCE.idkeyStat(963, 19, 1, false);
                            AppMethodBeat.o(125312);
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.i(125313);
                        c.NKc.remove(str);
                        Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s onServiceDisconnected()", className, str);
                        e.INSTANCE.idkeyStat(963, 20, 1, false);
                        AppMethodBeat.o(125313);
                    }
                }, 1)));
            } catch (Exception e2) {
                Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", className, str, e2.getMessage());
            }
        } else {
            try {
                bVar.bs(intent);
            } catch (Exception e3) {
                NKc.remove(str);
                if (z) {
                    b(intent, str, false, intent2);
                    e.INSTANCE.idkeyStat(963, 21, 1, false);
                }
                Log.i("MicroMsg.MMServiceHelper", "stopService ClassName = %s ProcessName = %s exception = %s", className, str, e3.getMessage());
            }
            e.INSTANCE.idkeyStat(963, 22, 1, false);
            Log.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, stopService() ClassName = %s ProcessName = %s stack[%s]", className, str, Util.getStack());
        }
        Log.i("MicroMsg.MMServiceHelper", "stopService() ClassName = %s ProcessName = %s", className, str);
        e.INSTANCE.idkeyStat(963, 16, 1, false);
        AppMethodBeat.o(125325);
    }

    public static boolean a(final Intent intent, final ServiceConnection serviceConnection, final int i2, final String str, final boolean z, final Intent intent2) {
        AppMethodBeat.i(125326);
        if (intent == null) {
            Log.i("MicroMsg.MMServiceHelper", "bindService Intent == null");
            AppMethodBeat.o(125326);
            return false;
        }
        final String className = intent.getComponent().getClassName();
        if (Util.isNullOrNil(className)) {
            Log.i("MicroMsg.MMServiceHelper", "bindService() processName = %s", str);
            AppMethodBeat.o(125326);
            return false;
        }
        b bVar = NKc.get(str);
        intent.putExtra("class_name", className);
        intent.putExtra("service_connection", serviceConnection.hashCode());
        NKf.put(Integer.valueOf(serviceConnection.hashCode()), className);
        if (bVar == null) {
            e.INSTANCE.idkeyStat(963, 32, 1, false);
            NKe.add(intent);
            Context context = MMApplicationContext.getContext();
            h(context, str, intent2);
            try {
                Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s bindService_result = %b", intent2.getComponent().getClassName(), className, str, Boolean.valueOf(context.bindService(intent2, new ServiceConnection() {
                    /* class com.tencent.mm.service.c.AnonymousClass3 */

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        AppMethodBeat.i(125316);
                        Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                        e.INSTANCE.idkeyStat(963, 33, 1, false);
                        if (!c.NKe.contains(intent)) {
                            AppMethodBeat.o(125316);
                        } else if (iBinder == null) {
                            Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() service == null", intent2.getComponent().getClassName(), className, str);
                            AppMethodBeat.o(125316);
                        } else {
                            try {
                                b P = b.a.P(iBinder);
                                P.a(intent, new a.AbstractBinderC2059a() {
                                    /* class com.tencent.mm.service.c.AnonymousClass3.AnonymousClass1 */

                                    @Override // com.tencent.mm.service.a
                                    public final void O(IBinder iBinder) {
                                        AppMethodBeat.i(125315);
                                        if (iBinder == null) {
                                            Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected() service == null", intent2.getComponent().getClassName(), className, str);
                                            AppMethodBeat.o(125315);
                                            return;
                                        }
                                        serviceConnection.onServiceConnected(new ComponentName(MMApplicationContext.getContext(), className), iBinder);
                                        c.NKg.put(Integer.valueOf(serviceConnection.hashCode()), iBinder);
                                        AnonymousClass1 r0 = new IBinder.DeathRecipient() {
                                            /* class com.tencent.mm.service.c.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                            public final void binderDied() {
                                                AppMethodBeat.i(125314);
                                                serviceConnection.onServiceDisconnected(new ComponentName(MMApplicationContext.getContext(), className));
                                                Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                                                AppMethodBeat.o(125314);
                                            }
                                        };
                                        c.NKh.put(Integer.valueOf(serviceConnection.hashCode()), r0);
                                        iBinder.linkToDeath(r0, 0);
                                        Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                                        AppMethodBeat.o(125315);
                                    }
                                });
                                c.NKc.put(str, P);
                            } catch (Exception e2) {
                                if (z) {
                                    c.a(intent, serviceConnection, i2, str, false, intent2);
                                    e.INSTANCE.idkeyStat(963, 36, 1, false);
                                }
                                Log.i("MicroMsg.MMServiceHelper", "bindService()  ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", intent2.getComponent().getClassName(), className, str, e2.getMessage(), Util.getStack());
                                e.INSTANCE.idkeyStat(963, 34, 1, false);
                            } finally {
                                c.NKe.remove(intent);
                                AppMethodBeat.o(125316);
                            }
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.i(125317);
                        c.NKc.remove(str);
                        Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s onServiceDisconnected()", intent2.getComponent().getClassName(), className, str);
                        e.INSTANCE.idkeyStat(963, 35, 1, false);
                        AppMethodBeat.o(125317);
                    }
                }, 1)));
            } catch (Exception e2) {
                Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s Context.bindService() Exception = %s", intent2.getComponent().getClassName(), className, str, e2.getMessage());
            }
        } else {
            e.INSTANCE.idkeyStat(963, 37, 1, false);
            try {
                Log.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, bindService() ClassName = %s ProcessName = %s ", className, str);
                bVar.a(intent, new a.AbstractBinderC2059a() {
                    /* class com.tencent.mm.service.c.AnonymousClass4 */

                    @Override // com.tencent.mm.service.a
                    public final void O(IBinder iBinder) {
                        AppMethodBeat.i(125319);
                        Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                        if (iBinder == null) {
                            AppMethodBeat.o(125319);
                            return;
                        }
                        serviceConnection.onServiceConnected(new ComponentName(MMApplicationContext.getContext(), className), iBinder);
                        c.NKg.put(Integer.valueOf(serviceConnection.hashCode()), iBinder);
                        iBinder.linkToDeath(new IBinder.DeathRecipient() {
                            /* class com.tencent.mm.service.c.AnonymousClass4.AnonymousClass1 */

                            public final void binderDied() {
                                AppMethodBeat.i(125318);
                                serviceConnection.onServiceDisconnected(new ComponentName(MMApplicationContext.getContext(), className));
                                Log.i("MicroMsg.MMServiceHelper", "bindService() ProcessServiceClassName = %s ClassName = %s ProcessName = %s IMMServiceStub_AIDL.bindService: onServiceConnected()", intent2.getComponent().getClassName(), className, str);
                                AppMethodBeat.o(125318);
                            }
                        }, 0);
                        AppMethodBeat.o(125319);
                    }
                });
            } catch (Exception e3) {
                NKc.remove(str);
                if (z) {
                    a(intent, serviceConnection, i2, str, false, intent2);
                    e.INSTANCE.idkeyStat(963, 36, 1, false);
                }
                Log.i("MicroMsg.MMServiceHelper", "bindService ClassName = %s ProcessName = %s exception = %s stack[%s]", className, str, e3.getMessage(), Util.getStack());
            }
        }
        Log.i("MicroMsg.MMServiceHelper", "bindService() ClassName = %s ProcessName = %s", className, str);
        e.INSTANCE.idkeyStat(963, 31, 1, false);
        AppMethodBeat.o(125326);
        return true;
    }

    public static void a(final ServiceConnection serviceConnection, final String str, final boolean z, final Intent intent) {
        AppMethodBeat.i(125327);
        if (serviceConnection == null) {
            Log.i("MicroMsg.MMServiceHelper", "unbindService ServiceConnection == null");
            AppMethodBeat.o(125327);
            return;
        }
        final String remove = NKf.remove(Integer.valueOf(serviceConnection.hashCode()));
        IBinder remove2 = NKg.remove(Integer.valueOf(serviceConnection.hashCode()));
        IBinder.DeathRecipient remove3 = NKh.remove(Integer.valueOf(serviceConnection.hashCode()));
        if (remove2 != null) {
            remove2.unlinkToDeath(remove3, 0);
        }
        if (Util.isNullOrNil(remove)) {
            Log.i("MicroMsg.MMServiceHelper", "unbindService() processName = %s", str);
            AppMethodBeat.o(125327);
            return;
        }
        final Intent intent2 = new Intent();
        intent2.putExtra("class_name", remove);
        intent2.putExtra("service_connection", serviceConnection.hashCode());
        b bVar = NKc.get(str);
        if (bVar == null) {
            e.INSTANCE.idkeyStat(963, 47, 1, false);
            Context context = MMApplicationContext.getContext();
            h(context, str, intent);
            try {
                Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s bindService_result = %b", remove, str, Boolean.valueOf(context.bindService(intent, new ServiceConnection() {
                    /* class com.tencent.mm.service.c.AnonymousClass5 */

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        AppMethodBeat.i(125320);
                        e.INSTANCE.idkeyStat(963, 48, 1, false);
                        if (iBinder == null) {
                            Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() service == null", remove, str);
                            AppMethodBeat.o(125320);
                            return;
                        }
                        Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected()", remove, str);
                        try {
                            b P = b.a.P(iBinder);
                            P.bw(intent2);
                            c.NKc.put(str, P);
                            AppMethodBeat.o(125320);
                        } catch (Exception e2) {
                            if (z) {
                                c.a(serviceConnection, str, false, intent);
                                e.INSTANCE.idkeyStat(963, 51, 1, false);
                            }
                            e.INSTANCE.idkeyStat(963, 49, 1, false);
                            Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceConnected() exception = %s stack[%s]", remove, str, e2.getMessage(), Util.getStack());
                            AppMethodBeat.o(125320);
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        AppMethodBeat.i(125321);
                        Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s onServiceDisconnected()", remove, str);
                        c.NKc.remove(str);
                        e.INSTANCE.idkeyStat(963, 50, 1, false);
                        AppMethodBeat.o(125321);
                    }
                }, 1)));
            } catch (Exception e2) {
                Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s  Context.bindService() Exception = %s", remove, str, e2.getMessage());
            }
        } else {
            try {
                bVar.bw(intent2);
            } catch (Exception e3) {
                NKc.remove(str);
                if (z) {
                    a(serviceConnection, str, false, intent);
                    e.INSTANCE.idkeyStat(963, 51, 1, false);
                }
                Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s ProcessName = %s exception = %s stack[%s]", remove, str, e3.getMessage(), Util.getStack());
            }
            e.INSTANCE.idkeyStat(963, 52, 1, false);
            Log.i("MicroMsg.MMServiceHelper", "IMMServiceStub_AIDL != null, unbindService() ClassName = %s ProcessName = %s ", remove, str);
        }
        Log.i("MicroMsg.MMServiceHelper", "unbindService() ClassName = %s processName = %s", remove, str);
        e.INSTANCE.idkeyStat(963, 46, 1, false);
        AppMethodBeat.o(125327);
    }

    public static void b(final String str, final boolean z, final Intent intent) {
        AppMethodBeat.i(125328);
        Context context = MMApplicationContext.getContext();
        h(context, str, intent);
        context.bindService(intent, new ServiceConnection() {
            /* class com.tencent.mm.service.c.AnonymousClass6 */

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AppMethodBeat.i(125322);
                if (iBinder == null) {
                    Log.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected() service == null", str);
                    AppMethodBeat.o(125322);
                    return;
                }
                c.NKc.put(str, b.a.P(iBinder));
                Log.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceConnected()", str);
                AppMethodBeat.o(125322);
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                AppMethodBeat.i(125323);
                c.NKc.remove(str);
                if (z) {
                    c.b(str, false, intent);
                }
                Log.i("MicroMsg.MMServiceHelper", "startProcessService() ProcessName = %s onServiceDisconnected()", str);
                e.INSTANCE.idkeyStat(963, 4, 1, false);
                AppMethodBeat.o(125323);
            }
        }, 1);
        Log.i("MicroMsg.MMServiceHelper", "startProcessService() processName = %s", str);
        AppMethodBeat.o(125328);
    }

    private static void h(Context context, String str, Intent intent) {
        AppMethodBeat.i(125329);
        if (bhW(str)) {
            try {
                context.startService(intent);
                AppMethodBeat.o(125329);
                return;
            } catch (Exception e2) {
                Log.i("MicroMsg.MMServiceHelper", "startProcessService() Exception:%s %s", e2.getClass().toString(), e2.getMessage());
            }
        }
        AppMethodBeat.o(125329);
    }

    private static boolean bhW(String str) {
        AppMethodBeat.i(125330);
        if (!Util.isEqual(str, "mm")) {
            AppMethodBeat.o(125330);
            return false;
        } else if (d.oD(26)) {
            int i2 = MMApplicationContext.getContext().getSharedPreferences("service_launch_way", 4).getInt("huawei_switch", 0);
            Log.i("MicroMsg.MMServiceHelper", "ifTarget26StartServiceHuawei() huaweiEnable : %s", Integer.valueOf(i2));
            if (Util.isEqual(i2, 0)) {
                AppMethodBeat.o(125330);
                return false;
            }
            AppMethodBeat.o(125330);
            return true;
        } else {
            AppMethodBeat.o(125330);
            return true;
        }
    }
}
