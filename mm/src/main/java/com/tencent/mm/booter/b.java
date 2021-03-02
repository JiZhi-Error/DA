package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b {
    public static boolean c(Context context, String str, boolean z) {
        AppMethodBeat.i(131860);
        while (true) {
            if ((str.equals("noop") && (!ChannelUtil.shouldShowGprsAlert || !ChannelUtil.isShowingGprsAlert)) || !l.cK(context)) {
                Log.i("MicroMsg.CoreServiceHelper", "ensure service running, type=%s ifRepeat=%s", str, Boolean.valueOf(z));
                Intent intent = new Intent(context, CoreService.class);
                intent.setFlags(268435456);
                intent.putExtra("START_TYPE", str);
                if (!c.akA()) {
                    Log.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() startService");
                    boolean z2 = false;
                    boolean z3 = false;
                    try {
                        context.startService(intent);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.CoreServiceHelper", "ensureServiceInstance() Exception = %s, Detail = %s SDK_INT = %s", e2.getClass().toString(), e2.getMessage(), Integer.valueOf(Build.VERSION.SDK_INT));
                        if (e2 instanceof IllegalStateException) {
                            z3 = true;
                        }
                        if (d.oD(26)) {
                            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("service_launch_way");
                            boolean cf = c.cf(context);
                            if (mmkv.getBoolean("service_first_crash", true)) {
                                Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=true result=%s", Boolean.valueOf(cf));
                                mmkv.edit().putBoolean("service_first_crash", false).commit();
                                e.INSTANCE.idkeyStat(954, 80, 1, false);
                                if (e2 instanceof IllegalStateException) {
                                    c.dg(false);
                                    mmkv.edit().putBoolean("service_IllegalStateException", true).commit();
                                    e.INSTANCE.idkeyStat(954, 81, 1, false);
                                    if (cf) {
                                        e.INSTANCE.idkeyStat(954, 82, 1, false);
                                        z2 = true;
                                    } else {
                                        mmkv.edit().putBoolean("crash_not_ignore", true).commit();
                                        e.INSTANCE.idkeyStat(954, 83, 1, false);
                                        z2 = true;
                                    }
                                } else {
                                    e.INSTANCE.idkeyStat(954, 86, 1, false);
                                    z2 = true;
                                }
                            } else {
                                Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false result=%s", Boolean.valueOf(cf));
                                if (e2 instanceof IllegalStateException) {
                                    c.dg(false);
                                    if (!mmkv.getBoolean("service_IllegalStateException", false)) {
                                        Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=false");
                                        mmkv.edit().putBoolean("service_IllegalStateException", true).commit();
                                        e.INSTANCE.idkeyStat(954, 87, 1, false);
                                        if (cf) {
                                            e.INSTANCE.idkeyStat(954, 82, 1, false);
                                            z2 = true;
                                        } else {
                                            mmkv.edit().putBoolean("crash_not_ignore", true).commit();
                                            e.INSTANCE.idkeyStat(954, 83, 1, false);
                                            z2 = true;
                                        }
                                    } else {
                                        Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService service_first_crash=false service_IllegalStateException=true");
                                    }
                                }
                            }
                        }
                        z2 = true;
                    }
                    if (d.oD(26)) {
                        if (d.oD(26)) {
                            Log.i("MicroMsg.CoreServiceUtil", "ensureServiceInstance() startService crash_not_ignore=%s service_IllegalStateException=%s", Boolean.valueOf(MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("crash_not_ignore", false)), Boolean.valueOf(c.cf(context)));
                            if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("crash_not_ignore", false) && c.cf(context) && !z2) {
                                MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("crash_not_ignore", false);
                                e.INSTANCE.idkeyStat(954, 85, 1, false);
                            }
                        }
                        if (!z3) {
                            break;
                        } else if (z) {
                            z = false;
                        } else {
                            AppMethodBeat.o(131860);
                            return false;
                        }
                    } else {
                        break;
                    }
                } else {
                    Log.i("MicroMsg.CoreServiceHelper", "ensureServiceInstance() bindService");
                    MMApplicationContext.getContext().bindService(intent, new g(), 1);
                    break;
                }
            } else {
                Log.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
                AppMethodBeat.o(131860);
                return false;
            }
        }
        Log.i("MicroMsg.CoreServiceUtil", "if_26_num=%s  if_ignore_false=%s  ignore_true=%s", Boolean.valueOf(MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("if_26_num", true)), Boolean.valueOf(MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("if_ignore_false", true)), Boolean.valueOf(MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("ignore_true", false)));
        if (d.oD(26) && MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("if_26_num", true)) {
            MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("if_26_num", false).commit();
            e.INSTANCE.idkeyStat(954, 92, 1, false);
        }
        if (d.oD(26)) {
            if (c.cf(context)) {
                MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("ignore_true", true).commit();
            } else if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("if_ignore_false", true)) {
                MultiProcessMMKV.getMMKV("service_launch_way").edit().putBoolean("if_ignore_false", false).commit();
                e.INSTANCE.idkeyStat(954, 90, 1, false);
                if (MultiProcessMMKV.getMMKV("service_launch_way").getBoolean("ignore_true", false)) {
                    e.INSTANCE.idkeyStat(954, 91, 1, false);
                }
            }
        }
        AppMethodBeat.o(131860);
        return true;
    }

    public static void ce(Context context) {
        AppMethodBeat.i(131861);
        if (c.akA()) {
            g.Wj();
            AppMethodBeat.o(131861);
            return;
        }
        try {
            context.stopService(new Intent(context, CoreService.class));
            AppMethodBeat.o(131861);
        } catch (Exception e2) {
            Log.e("MicroMsg.CoreServiceHelper", "stopServiceInstance() Exception:%s", e2.getMessage());
            AppMethodBeat.o(131861);
        }
    }
}
