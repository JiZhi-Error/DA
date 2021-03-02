package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.g.b;
import com.tencent.tmediacodec.hook.THookTextureView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private static boolean Sml;
    private static final Map<String, c> Smm = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(190137);
        AppMethodBeat.o(190137);
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(190134);
        Smm.put(str, cVar);
        if (b.isLogEnable()) {
            new StringBuilder("after hookSurfaceCallback size:").append(Smm.size()).append(" mHoldCallbackMap:").append(Smm);
            b.bqQ("HookManager");
        }
        if (!Sml) {
            Sml = true;
            THookTextureView.setHookCallback(new THookTextureView.a() {
                /* class com.tencent.tmediacodec.hook.a.AnonymousClass1 */

                @Override // com.tencent.tmediacodec.hook.THookTextureView.a
                public final boolean u(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(190133);
                    if (surfaceTexture == null) {
                        AppMethodBeat.o(190133);
                        return true;
                    }
                    String obj = surfaceTexture.toString();
                    for (String str : a.Smm.keySet()) {
                        if (TextUtils.equals(str, obj)) {
                            c cVar = (c) a.Smm.get(obj);
                            if (cVar != null) {
                                cVar.s(surfaceTexture);
                            }
                            AppMethodBeat.o(190133);
                            return false;
                        }
                    }
                    AppMethodBeat.o(190133);
                    return true;
                }
            });
        }
        AppMethodBeat.o(190134);
    }

    public static void bqO(String str) {
        AppMethodBeat.i(190135);
        Smm.remove(str);
        AppMethodBeat.o(190135);
    }

    public static void t(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(190136);
        try {
            "realReleaseSurfaceTexture surfaceTexture:".concat(String.valueOf(surfaceTexture));
            b.bqS("HookManager");
            bqO(surfaceTexture.toString());
            surfaceTexture.release();
            AppMethodBeat.o(190136);
        } catch (Throwable th) {
            new StringBuilder("realReleaseSurfaceTexture surfaceTexture:").append(surfaceTexture).append(" ignoreThrowable");
            b.bqT("HookManager");
            AppMethodBeat.o(190136);
        }
    }
}
