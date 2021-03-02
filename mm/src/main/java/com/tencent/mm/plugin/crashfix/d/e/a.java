package com.tencent.mm.plugin.crashfix.d.e;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.crashfix.jni.JNIEnvNewWeakGlobalRefHook;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.reflect.Method;

public final class a implements com.tencent.mm.plugin.crashfix.d.a {
    @Override // com.tencent.mm.plugin.crashfix.d.a
    public final void start() {
        AppMethodBeat.i(145636);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("weakglobal_fix");
        singleMMKV.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
        singleMMKV.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", true);
        singleMMKV.putInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", 0);
        singleMMKV.commit();
        AppMethodBeat.o(145636);
    }

    @Override // com.tencent.mm.plugin.crashfix.d.a
    public final void cAM() {
        AppMethodBeat.i(145637);
        MultiProcessMMKV.getSingleMMKV("weakglobal_fix").putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", true).commit();
        AppMethodBeat.o(145637);
    }

    @Override // com.tencent.mm.plugin.crashfix.d.a
    public final boolean cAN() {
        AppMethodBeat.i(145638);
        boolean z = MultiProcessMMKV.getSingleMMKV("weakglobal_fix").getBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", false);
        boolean z2 = MultiProcessMMKV.getSingleMMKV("weakglobal_fix").getBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
        Log.i("MicroMsg.WeakGlobalRefFix", "start ".concat(String.valueOf(z)));
        Log.i("MicroMsg.WeakGlobalRefFix", "end ".concat(String.valueOf(z2)));
        if (z == z2) {
            if (z2) {
                h.INSTANCE.idkeyStat(1113, 2, 1, false);
            }
            AppMethodBeat.o(145638);
            return false;
        }
        if (MultiProcessMMKV.getSingleMMKV("weakglobal_fix").getInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", 0) == -5) {
            h.INSTANCE.idkeyStat(1113, 0, 1, false);
        } else {
            h.INSTANCE.idkeyStat(1113, 1, 1, false);
        }
        AppMethodBeat.o(145638);
        return true;
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean Fh(int i2) {
        AppMethodBeat.i(145639);
        if (i2 == 24 || i2 == 25) {
            Log.i("MicroMsg.WeakGlobalRefFix", "api ".concat(String.valueOf(i2)));
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_weakglobal_fix, 1);
            Log.i("MicroMsg.WeakGlobalRefFix", "Expt : ".concat(String.valueOf(a2)));
            if (a2 == 0) {
                AppMethodBeat.o(145639);
                return false;
            }
            if (a2 == 2) {
                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("weakglobal_fix");
                singleMMKV.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_END_BOOLEAN", false);
                singleMMKV.putBoolean("SYSTEM_CRASH_PROTECT_WEAK_GLOBAL_REF_START_BOOLEAN", false);
                singleMMKV.commit();
            }
            AppMethodBeat.o(145639);
            return true;
        }
        AppMethodBeat.o(145639);
        return false;
    }

    @Override // com.tencent.mm.plugin.crashfix.d.b
    public final boolean cAO() {
        AppMethodBeat.i(145640);
        JNIEnvNewWeakGlobalRefHook.init();
        try {
            JNIEnvNewWeakGlobalRefHook.calculateOffset();
            new View(MMApplicationContext.getContext());
            Log.i("MicroMsg.WeakGlobalRefFix", "init finish");
            Method declaredMethod = Class.forName("android.view.RenderNode").getDeclaredMethod("nCreate", String.class);
            Method method = JNIEnvNewWeakGlobalRefHook.class.getMethod("calculateOffset", new Class[0]);
            Log.i("MicroMsg.WeakGlobalRefFix", "reflect finish");
            JNIEnvNewWeakGlobalRefHook.hook(declaredMethod, method);
            new View(MMApplicationContext.getContext());
            Log.i("MicroMsg.WeakGlobalRefFix", "succ");
        } catch (Exception e2) {
            MultiProcessMMKV.getSingleMMKV("weakglobal_fix").putInt("SYSTEM_CRASH_PROTECT_WEAKGLOBALREF_HOOK_RESULT", -5).commit();
        }
        AppMethodBeat.o(145640);
        return true;
    }
}
