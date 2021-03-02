package com.tencent.xweb.xwalk;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.k;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;

public final class s implements m {
    public ConcurrentMap<String, k> SHM;
    public l SHN;
    private ReflectMethod SHO;
    private ReflectMethod SHP;

    /* synthetic */ s(byte b2) {
        this();
    }

    public static void bb(String str, int i2, int i3) {
        AppMethodBeat.i(207327);
        Bundle bundle = new Bundle();
        bundle.putString("enabledTraceCategory", str);
        bundle.putInt("traceSampleRatio", i2);
        bundle.putInt("enableWindowPerformanceSampleRatio", i3);
        if (XWalkCoreWrapper.getInstance().hasFeature(4)) {
            Log.d("XWebProfilerController", "setProfileConfig via INTERNAL_XPROFILE_NG");
            XWalkCoreWrapper.invokeRuntimeChannel(80012, new Object[]{bundle});
            AppMethodBeat.o(207327);
            return;
        }
        if (XWalkCoreWrapper.getInstance().hasFeature(0)) {
            try {
                Class<?> cls = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
                if (cls == null) {
                    AppMethodBeat.o(207327);
                    return;
                }
                new ReflectMethod(cls, "setProfileConfig", (Class<?>[]) new Class[]{Bundle.class}).invoke(bundle);
                AppMethodBeat.o(207327);
                return;
            } catch (Exception e2) {
                Log.e("XWebProfilerController", "setProfileConfig reflect failed");
            }
        }
        AppMethodBeat.o(207327);
    }

    @Override // com.tencent.xweb.m
    public final boolean setProfileResultCallback(String str, k kVar) {
        AppMethodBeat.i(183745);
        if (kVar == null) {
            if (this.SHM.containsKey(str)) {
                this.SHM.remove(str);
                U(false, str);
                AppMethodBeat.o(183745);
                return true;
            }
            AppMethodBeat.o(183745);
            return false;
        } else if (this.SHM.containsKey(str) || U(true, str)) {
            this.SHM.put(str, kVar);
            AppMethodBeat.o(183745);
            return true;
        } else {
            AppMethodBeat.o(183745);
            return false;
        }
    }

    @Override // com.tencent.xweb.m
    public final void forceEnableFrameCostProfile() {
        AppMethodBeat.i(207328);
        bb("xprofile.frameCost", 10000, 0);
        AppMethodBeat.o(207328);
    }

    private static boolean U(boolean z, String str) {
        AppMethodBeat.i(183746);
        Object invokeRuntimeChannel = XWalkCoreWrapper.invokeRuntimeChannel(80013, new Object[]{Boolean.valueOf(z), str});
        if (!(invokeRuntimeChannel instanceof Boolean) || !((Boolean) invokeRuntimeChannel).booleanValue()) {
            AppMethodBeat.o(183746);
            return false;
        }
        AppMethodBeat.o(183746);
        return true;
    }

    @Override // com.tencent.xweb.m
    public final void bsg(String str) {
        AppMethodBeat.i(154502);
        if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
            try {
                if (this.SHO == null) {
                    Class<?> cls = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
                    if (cls == null) {
                        AppMethodBeat.o(154502);
                        return;
                    } else {
                        this.SHO = new ReflectMethod(cls, "manualStartProfile", (Class<?>[]) new Class[]{Integer.TYPE, Bundle.class});
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("enabledTraceCategory", str);
                bundle.putInt("traceSampleRatio", 10000);
                this.SHO.invoke(0, bundle);
                AppMethodBeat.o(154502);
                return;
            } catch (Exception e2) {
                Log.e("XWebProfilerController", "manualStartOrStopTracingProfileUsingConfig reflect failed");
            }
        }
        AppMethodBeat.o(154502);
    }

    @Override // com.tencent.xweb.m
    public final void a(l lVar) {
        AppMethodBeat.i(154503);
        if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
            try {
                if (this.SHP == null) {
                    Class<?> cls = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
                    if (cls == null) {
                        AppMethodBeat.o(154503);
                        return;
                    } else {
                        this.SHP = new ReflectMethod(cls, "manualStopProfile", (Class<?>[]) new Class[]{Integer.TYPE});
                    }
                }
                this.SHN = lVar;
                this.SHP.invoke(0);
                AppMethodBeat.o(154503);
                return;
            } catch (Exception e2) {
                Log.e("XWebProfilerController", "manualStartOrStopTracingProfileUsingConfig reflect failed");
            }
        }
        AppMethodBeat.o(154503);
    }

    private s() {
        AppMethodBeat.i(183747);
        this.SHM = new ConcurrentHashMap();
        AppMethodBeat.o(183747);
    }

    public static final class a {
        private static final s SHQ = new s((byte) 0);

        static {
            AppMethodBeat.i(154500);
            AppMethodBeat.o(154500);
        }
    }
}
