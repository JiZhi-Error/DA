package com.tencent.matrix;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import com.tencent.c.a.a;
import com.tencent.matrix.trace.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class e {
    private static MultiProcessMMKV cPL = MultiProcessMMKV.getMMKV("MatrixDelegate");

    public static void addAction(IntentFilter intentFilter) {
        intentFilter.addAction("ENABLE_FPS");
        intentFilter.addAction("MODIFY_EVIL_THRESHOLD");
        intentFilter.addAction("ENABLE_METHOD_BEAT");
        intentFilter.addAction("ENABLE_ANR");
        intentFilter.addAction("ENABLE_START_UP");
        intentFilter.addAction("ENABLE_EVIL_METHOD");
        intentFilter.addAction("ENABLE_FPS_FLOAT");
        intentFilter.addAction("ENABLE_DEV_LOG");
    }

    public static void j(Intent intent) {
        int i2;
        int i3 = 1;
        a aVar = (a) b.RG().Y(a.class);
        if (aVar != null) {
            if ("ENABLE_FPS".equals(intent.getAction())) {
                c cVar = aVar.daF;
                boolean booleanExtra = intent.getBooleanExtra("ENABLE_FPS", cVar.dbi);
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra));
                if (booleanExtra) {
                    cVar.TG();
                } else {
                    cVar.TH();
                }
                if (MMApplicationContext.isMainProcess()) {
                    MultiProcessMMKV multiProcessMMKV = cPL;
                    String name = a.EnumC0131a.clicfg_matrix_trace_fps_enable.name();
                    if (booleanExtra) {
                        i2 = 1;
                    } else {
                        i2 = -1;
                    }
                    multiProcessMMKV.putInt(name, i2).apply();
                }
            } else if ("ENABLE_FPS_FLOAT".equals(intent.getAction())) {
                com.tencent.matrix.trace.view.a bi = com.tencent.matrix.trace.view.a.bi(MMApplicationContext.getContext());
                bi.eQ(MMApplicationContext.getProcessName());
                bi.dec = new View.OnClickListener() {
                    /* class com.tencent.matrix.e.AnonymousClass1 */

                    public final void onClick(View view) {
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/matrix/MatrixSettingUIHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("Matrix.UISettingHandler", "[onClick] FrameDecorator");
                        Intent intent = new Intent();
                        intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
                        intent.addFlags(67108864);
                        intent.addFlags(268435456);
                        Context context = MMApplicationContext.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/matrix/MatrixSettingUIHandler$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/matrix/MatrixSettingUIHandler$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/matrix/MatrixSettingUIHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    }
                };
                boolean booleanExtra2 = intent.getBooleanExtra("ENABLE_FPS_FLOAT", false);
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra2));
                if (!booleanExtra2 || RN()) {
                    bi.ded = true;
                    if (!booleanExtra2) {
                        bi.dismiss();
                        bi.ded = false;
                    } else if (a.INSTANCE.cPB) {
                        bi.show();
                    } else {
                        Log.w("Matrix.UISettingHandler", "not in the foreground now!");
                    }
                    if (MMApplicationContext.isMainProcess()) {
                        MultiProcessMMKV multiProcessMMKV2 = cPL;
                        if (!booleanExtra2) {
                            i3 = -1;
                        }
                        multiProcessMMKV2.putInt("ENABLE_FPS_FLOAT", i3).apply();
                        return;
                    }
                    return;
                }
                Log.e("Matrix.UISettingHandler", "permission denied for window type");
            } else if ("ENABLE_START_UP".equals(intent.getAction())) {
                com.tencent.matrix.trace.f.e eVar = aVar.daE;
                boolean booleanExtra3 = intent.getBooleanExtra("ENABLE_START_UP", eVar.dbi);
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra3));
                if (booleanExtra3) {
                    eVar.TG();
                } else {
                    eVar.TH();
                }
                if (MMApplicationContext.isMainProcess()) {
                    MultiProcessMMKV multiProcessMMKV3 = cPL;
                    String name2 = a.EnumC0131a.clicfg_matrix_trace_startup_enable.name();
                    if (!booleanExtra3) {
                        i3 = -1;
                    }
                    multiProcessMMKV3.putInt(name2, i3).apply();
                }
            } else if ("ENABLE_EVIL_METHOD".equals(intent.getAction())) {
                com.tencent.matrix.trace.f.b bVar = aVar.daD;
                boolean booleanExtra4 = intent.getBooleanExtra("ENABLE_EVIL_METHOD", bVar.dbi);
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra4));
                if (booleanExtra4) {
                    bVar.TG();
                } else {
                    bVar.TH();
                }
                if (MMApplicationContext.isMainProcess()) {
                    MultiProcessMMKV multiProcessMMKV4 = cPL;
                    String name3 = a.EnumC0131a.clicfg_matrix_trace_evil_method_enable.name();
                    if (!booleanExtra4) {
                        i3 = -1;
                    }
                    multiProcessMMKV4.putInt(name3, i3).apply();
                }
            } else if ("ENABLE_ANR".equals(intent.getAction())) {
                com.tencent.matrix.trace.f.a aVar2 = aVar.daG;
                boolean booleanExtra5 = intent.getBooleanExtra("ENABLE_ANR", aVar2.dbi);
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra5));
                if (booleanExtra5) {
                    aVar2.TG();
                } else {
                    aVar2.TH();
                }
                if (MMApplicationContext.isMainProcess()) {
                    MultiProcessMMKV multiProcessMMKV5 = cPL;
                    String name4 = a.EnumC0131a.clicfg_matrix_trace_anr_enable.name();
                    if (!booleanExtra5) {
                        i3 = -1;
                    }
                    multiProcessMMKV5.putInt(name4, i3).apply();
                }
            } else if ("ENABLE_METHOD_BEAT".equals(intent.getAction())) {
                AppMethodBeat Ts = com.tencent.matrix.trace.a.Ts();
                boolean booleanExtra6 = intent.getBooleanExtra("ENABLE_METHOD_BEAT", Ts.isAlive());
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra6));
                if (booleanExtra6) {
                    Ts.onStart();
                } else {
                    Ts.onStop();
                }
            } else if ("ENABLE_DEV_LOG".equals(intent.getAction())) {
                boolean booleanExtra7 = intent.getBooleanExtra("ENABLE_DEV_LOG", false);
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra7));
                aVar.daC.daO = booleanExtra7;
            } else if ("MODIFY_EVIL_THRESHOLD".equals(intent.getAction())) {
                long longExtra = intent.getLongExtra("MODIFY_EVIL_THRESHOLD", 700);
                aVar.daD.dci = longExtra;
                if (MMApplicationContext.isMainProcess()) {
                    cPL.putLong(a.EnumC0131a.clicfg_matrix_trace_evil_method_threshold.name(), longExtra).apply();
                }
            } else if ("ENABLE_BATTERY".equals(intent.getAction())) {
                boolean booleanExtra8 = intent.getBooleanExtra("ENABLE_BATTERY", false);
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra8));
                com.tencent.matrix.a.b bVar2 = (com.tencent.matrix.a.b) b.RG().Y(com.tencent.matrix.a.b.class);
                if (booleanExtra8) {
                    bVar2.start();
                } else {
                    bVar2.stop();
                }
                if (MMApplicationContext.isMainProcess()) {
                    MultiProcessMMKV multiProcessMMKV6 = cPL;
                    if (!booleanExtra8) {
                        i3 = -1;
                    }
                    multiProcessMMKV6.putInt("ENABLE_BATTERY", i3).apply();
                }
            } else if ("ENABLE_THREAD".equals(intent.getAction())) {
                boolean booleanExtra9 = intent.getBooleanExtra("ENABLE_THREAD", false);
                Log.i("Matrix.UISettingHandler", "action=%s isEnable=%s", intent.getAction(), Boolean.valueOf(booleanExtra9));
                com.tencent.matrix.f.a aVar3 = (com.tencent.matrix.f.a) b.RG().Y(com.tencent.matrix.f.a.class);
                if (booleanExtra9) {
                    aVar3.start();
                } else {
                    aVar3.stop();
                }
                if (MMApplicationContext.isMainProcess()) {
                    MultiProcessMMKV multiProcessMMKV7 = cPL;
                    if (!booleanExtra9) {
                        i3 = -1;
                    }
                    multiProcessMMKV7.putInt("ENABLE_THREAD", i3).apply();
                }
            }
        }
    }

    public static boolean RN() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(MMApplicationContext.getContext());
        }
        return true;
    }
}
