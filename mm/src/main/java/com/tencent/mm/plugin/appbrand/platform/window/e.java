package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.Log;

public interface e {

    public interface a {
        void a(b bVar, boolean z);
    }

    void a(b bVar, a aVar);

    b btm();

    public enum b {
        PORTRAIT(1),
        UNSPECIFIED(-1),
        LANDSCAPE_SENSOR(6),
        LANDSCAPE_LOCKED(0),
        LANDSCAPE_LEFT(8),
        LANDSCAPE_RIGHT(0);
        
        public static final b[] nEs = {LANDSCAPE_LEFT, LANDSCAPE_RIGHT, LANDSCAPE_LOCKED, LANDSCAPE_SENSOR};
        public final int nEr;

        public static b valueOf(String str) {
            AppMethodBeat.i(176699);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(176699);
            return bVar;
        }

        static {
            AppMethodBeat.i(176703);
            AppMethodBeat.o(176703);
        }

        public final boolean b(b bVar) {
            return this == bVar || (this == LANDSCAPE_SENSOR && bVar == LANDSCAPE_LOCKED) || (this == LANDSCAPE_LOCKED && bVar == LANDSCAPE_SENSOR);
        }

        private b(int i2) {
            this.nEr = i2;
        }

        public static b yZ(int i2) {
            AppMethodBeat.i(176700);
            b[] values = values();
            for (b bVar : values) {
                if (bVar.nEr == i2) {
                    AppMethodBeat.o(176700);
                    return bVar;
                }
            }
            b bVar2 = UNSPECIFIED;
            AppMethodBeat.o(176700);
            return bVar2;
        }

        public static boolean c(b bVar) {
            AppMethodBeat.i(219573);
            boolean contains = org.apache.commons.b.a.contains(nEs, bVar);
            AppMethodBeat.o(219573);
            return contains;
        }

        public static b h(AppBrandInitConfig appBrandInitConfig) {
            AppMethodBeat.i(176702);
            b bVar = null;
            if (appBrandInitConfig != null) {
                bVar = aeE(appBrandInitConfig.cBG);
            }
            if (bVar == null) {
                bVar = PORTRAIT;
            }
            AppMethodBeat.o(176702);
            return bVar;
        }

        public static b aeE(String str) {
            b bVar;
            String str2 = null;
            AppMethodBeat.i(176701);
            if (!"landscape".equals(str)) {
                if (!"portrait".equals(str)) {
                    if (!"landscapeLeft".equals(str)) {
                        if (!"landscapeRight".equals(str)) {
                            if (!"auto".equals(str) && !UNSPECIFIED.name().equalsIgnoreCase(str)) {
                                b[] values = values();
                                int length = values.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length) {
                                        bVar = null;
                                        break;
                                    }
                                    bVar = values[i2];
                                    if (bVar.name().equalsIgnoreCase(str)) {
                                        break;
                                    }
                                    i2++;
                                }
                            } else {
                                bVar = UNSPECIFIED;
                            }
                        } else {
                            bVar = LANDSCAPE_RIGHT;
                        }
                    } else {
                        bVar = LANDSCAPE_LEFT;
                    }
                } else {
                    bVar = PORTRAIT;
                }
            } else {
                bVar = LANDSCAPE_SENSOR;
            }
            Object[] objArr = new Object[3];
            objArr[0] = str;
            if (bVar != null) {
                str2 = bVar.name();
            }
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(bVar == null ? -1 : bVar.nEr);
            Log.i("Luggage.WXA.Window.Orientation", "parseOrientationString [%s]->[%s][%d]", objArr);
            AppMethodBeat.o(176701);
            return bVar;
        }
    }
}
