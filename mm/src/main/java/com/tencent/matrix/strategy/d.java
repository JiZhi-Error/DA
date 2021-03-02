package com.tencent.matrix.strategy;

import com.tencent.c.a.a;
import com.tencent.matrix.e.b;
import com.tencent.matrix.trace.a;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.e;
import com.tencent.matrix.trace.f.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.Map;

public final class d implements a {
    private static MultiProcessMMKV cPL = MultiProcessMMKV.getMMKV("MatrixDelegate");

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.matrix.strategy.a
    public final void p(Map<String, Boolean> map) {
        char c2;
        f fVar;
        int i2;
        try {
            for (String str : map.keySet()) {
                boolean booleanValue = map.get(str).booleanValue();
                Iterator<b> it = com.tencent.matrix.b.RG().cqP.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next == null) {
                        Log.e("Matrix.PluginStatusChangeNotify", "plugin is null");
                    } else if (!(next instanceof com.tencent.matrix.a.b)) {
                        if (!next.getTag().equals("Trace") || !str.startsWith("Trace")) {
                            String tag = next.getTag();
                            if (tag.equals(str)) {
                                if (next.isPluginStarted() && !booleanValue) {
                                    Log.i("Matrix.PluginStatusChangeNotify", "%sPlugin#onStop", tag);
                                    next.stop();
                                } else if ((next.isPluginStopped() || next.getStatus() == 1) && booleanValue) {
                                    Log.i("Matrix.PluginStatusChangeNotify", "%sPlugin#onStart", tag);
                                    next.start();
                                }
                            }
                        } else {
                            a aVar = (a) next;
                            com.tencent.matrix.trace.core.b Tt = a.Tt();
                            if (Tt == null || !Tt.isInit) {
                                Log.w("Matrix.PluginStatusChangeNotify", "uiThreadMonitor is never inited!");
                            } else {
                                switch (str.hashCode()) {
                                    case -1864660637:
                                        if (str.equals("Trace_StartUp")) {
                                            c2 = 0;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -1566431569:
                                        if (str.equals("Trace_FPS")) {
                                            c2 = 2;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -935762161:
                                        if (str.equals("Trace_EvilMethod")) {
                                            c2 = 1;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        c2 = 65535;
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                        fVar = aVar.daE;
                                        break;
                                    case 1:
                                        fVar = aVar.daD;
                                        break;
                                    case 2:
                                        fVar = aVar.daF;
                                        break;
                                    default:
                                        fVar = null;
                                        break;
                                }
                                if (fVar != null) {
                                    if (fVar instanceof c) {
                                        int i3 = cPL.getInt(a.EnumC0131a.clicfg_matrix_trace_fps_enable.name(), 0);
                                        if (i3 == 1 || i3 == -1) {
                                            Log.i("Matrix.PluginStatusChangeNotify", "FrameTracer has set in MatrixSettingUI value=".concat(String.valueOf(i3)));
                                        } else if (BuildInfo.DEBUG) {
                                            Log.i("Matrix.PluginStatusChangeNotify", "FrameTracer ignore change");
                                        }
                                    } else if (fVar instanceof com.tencent.matrix.trace.f.b) {
                                        int i4 = cPL.getInt(a.EnumC0131a.clicfg_matrix_trace_evil_method_enable.name(), 0);
                                        if (i4 == 1 || i4 == -1) {
                                            Log.i("Matrix.PluginStatusChangeNotify", "EvilMethodTracer has set in MatrixSettingUI value=".concat(String.valueOf(i4)));
                                        }
                                    } else if ((fVar instanceof e) && ((i2 = cPL.getInt(a.EnumC0131a.clicfg_matrix_trace_startup_enable.name(), 0)) == 1 || i2 == -1)) {
                                        Log.i("Matrix.PluginStatusChangeNotify", "StartupTracer has set in MatrixSettingUI value=".concat(String.valueOf(i2)));
                                    }
                                    if (!booleanValue) {
                                        Log.i("Matrix.PluginStatusChangeNotify", "%s#onCloseTrace", str);
                                        fVar.TH();
                                        if (fVar instanceof com.tencent.matrix.trace.f.b) {
                                            com.tencent.matrix.trace.a.Ts().onStop();
                                        }
                                    } else {
                                        Log.i("Matrix.PluginStatusChangeNotify", "%s#onStartTrace", str);
                                        if (fVar instanceof com.tencent.matrix.trace.f.b) {
                                            com.tencent.matrix.trace.a.Ts().onStart();
                                        }
                                        fVar.TG();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("Matrix.PluginStatusChangeNotify", e2, "", new Object[0]);
        }
    }
}
