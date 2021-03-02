package com.tencent.mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.utils.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class g {

    public static final class a extends i implements com.tencent.mm.vending.e.a {
        private d cBE;
        private Application nGZ;

        public /* synthetic */ a(d dVar, byte b2) {
            this(dVar);
        }

        private a(d dVar) {
            AppMethodBeat.i(48044);
            this.cBE = dVar;
            this.cBE.keep(this);
            this.nGZ = (Application) dVar.mContext.getApplicationContext();
            this.nGZ.registerComponentCallbacks(this);
            AppMethodBeat.o(48044);
        }

        @SuppressLint({"SwitchIntDef"})
        public final void onTrimMemory(int i2) {
            AppMethodBeat.i(48045);
            if (this.cBE == null) {
                AppMethodBeat.o(48045);
                return;
            }
            switch (i2) {
                case 5:
                case 10:
                case 15:
                    if (this.cBE.ON() != null) {
                        i.v(this.cBE.ON().NA(), i2);
                    }
                    if (i2 == 5) {
                        d dVar = this.cBE;
                        Log.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", dVar.mAppId, Boolean.valueOf(dVar.mInitialized), Integer.valueOf(i2));
                        if (dVar.mInitialized) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("level", Integer.valueOf(i2));
                            new v().g(dVar.NY()).L(hashMap).bEo();
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(48045);
        }

        @Override // com.tencent.mm.vending.e.a
        public final void dead() {
            AppMethodBeat.i(48046);
            this.nGZ.unregisterComponentCallbacks(this);
            this.cBE = null;
            AppMethodBeat.o(48046);
        }
    }
}
