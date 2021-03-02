package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

public class c {
    public static boolean Hla = false;

    static {
        AppMethodBeat.i(115716);
        fLC();
        AppMethodBeat.o(115716);
    }

    public static void fLC() {
        AppMethodBeat.i(115715);
        System.currentTimeMillis();
        if (!Hla) {
            try {
                c.class.getClassLoader();
                j.Ed("image_filter_common");
                c.class.getClassLoader();
                j.Ed("image_filter_gpu");
                c.class.getClassLoader();
                j.Ed("format_convert");
                c.class.getClassLoader();
                j.Ed("YTCommon");
                c.class.getClassLoader();
                j.Ed("YTFaceTrackPro");
                c.class.getClassLoader();
                j.Ed("algo_youtu_jni");
                c.class.getClassLoader();
                j.Ed("pitu_tools");
                Hla = true;
                AppMethodBeat.o(115715);
                return;
            } catch (UnsatisfiedLinkError e2) {
                Hla = false;
                AppMethodBeat.o(115715);
                return;
            } catch (RuntimeException e3) {
                Hla = false;
                AppMethodBeat.o(115715);
                return;
            } catch (Exception e4) {
                Hla = false;
            }
        }
        AppMethodBeat.o(115715);
    }
}
