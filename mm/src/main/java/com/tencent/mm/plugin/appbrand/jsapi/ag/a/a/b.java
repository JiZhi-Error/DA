package com.tencent.mm.plugin.appbrand.jsapi.ag.a.a;

import android.app.Activity;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.permission.r;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 806;
    public static final String NAME = "insertXWebCamera";
    public boolean lQg;

    public interface a {
        void bMa();
    }

    public final boolean a(final f fVar, final com.tencent.mm.plugin.appbrand.jsapi.camera.f fVar2, final a aVar) {
        AppMethodBeat.i(139417);
        r.b(String.valueOf(fVar.getAppId()), new a.AbstractC0015a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b.AnonymousClass3 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(139416);
                if (i2 != 16) {
                    if (i2 == 18) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("cameraId", Integer.valueOf(fVar2.getCameraId()));
                            new i().h(fVar).Zh(new JSONObject(hashMap).toString()).bEo();
                            a.C0654a.bFI().lOW = false;
                        } else {
                            a.C0654a.bFI().lOW = true;
                            b.this.a(fVar, fVar2, aVar);
                            AppMethodBeat.o(139416);
                            return;
                        }
                    }
                    AppMethodBeat.o(139416);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("cameraId", Integer.valueOf(fVar2.getCameraId()));
                    new i().h(fVar).Zh(new JSONObject(hashMap2).toString()).bEo();
                    a.C0654a.bFI().lOV = false;
                    AppMethodBeat.o(139416);
                } else {
                    a.C0654a.bFI().lOV = true;
                    b.this.a(fVar, fVar2, aVar);
                    AppMethodBeat.o(139416);
                }
            }
        });
        Activity activity = (Activity) fVar.getContext();
        if (activity == null) {
            AppMethodBeat.o(139417);
            return false;
        }
        boolean a2 = com.tencent.luggage.h.i.a(activity, "android.permission.CAMERA", 16, "", "");
        a.C0654a.bFI().lOV = a2;
        if (!a2) {
            AppMethodBeat.o(139417);
            return false;
        }
        boolean a3 = com.tencent.luggage.h.i.a(activity, "android.permission.RECORD_AUDIO", 18, "", "");
        a.C0654a.bFI().lOW = a3;
        if (!a3) {
            AppMethodBeat.o(139417);
            return false;
        }
        r.aeq(fVar.getAppId());
        if (!this.lQg) {
            if (aVar != null) {
                aVar.bMa();
            }
            fVar2.initView();
            this.lQg = true;
        }
        AppMethodBeat.o(139417);
        return true;
    }
}
