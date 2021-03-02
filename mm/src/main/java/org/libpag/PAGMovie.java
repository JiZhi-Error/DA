package org.libpag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGMovie extends PAGImage {
    private static native long MakeFromComposition(PAGComposition pAGComposition);

    private static native long MakeFromVideoPath(String str);

    private static native long MakeFromVideoPath(String str, long j2, long j3);

    private static native void nativeInit();

    public native long duration();

    private PAGMovie(long j2) {
        super(j2);
    }

    public static PAGMovie FromComposition(PAGComposition pAGComposition) {
        AppMethodBeat.i(236901);
        long MakeFromComposition = MakeFromComposition(pAGComposition);
        if (MakeFromComposition == 0) {
            AppMethodBeat.o(236901);
            return null;
        }
        PAGMovie pAGMovie = new PAGMovie(MakeFromComposition);
        AppMethodBeat.o(236901);
        return pAGMovie;
    }

    public static PAGMovie FromVideoPath(String str) {
        AppMethodBeat.i(236902);
        long MakeFromVideoPath = MakeFromVideoPath(str);
        if (MakeFromVideoPath == 0) {
            AppMethodBeat.o(236902);
            return null;
        }
        PAGMovie pAGMovie = new PAGMovie(MakeFromVideoPath);
        AppMethodBeat.o(236902);
        return pAGMovie;
    }

    public static PAGMovie FromVideoPath(String str, long j2, long j3) {
        AppMethodBeat.i(236903);
        long MakeFromVideoPath = MakeFromVideoPath(str, j2, j3);
        if (MakeFromVideoPath == 0) {
            AppMethodBeat.o(236903);
            return null;
        }
        PAGMovie pAGMovie = new PAGMovie(MakeFromVideoPath);
        AppMethodBeat.o(236903);
        return pAGMovie;
    }

    static {
        AppMethodBeat.i(236904);
        b.loadLibrary("pag");
        nativeInit();
        AppMethodBeat.o(236904);
    }
}
