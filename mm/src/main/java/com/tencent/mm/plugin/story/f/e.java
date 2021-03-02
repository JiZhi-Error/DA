package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import kotlin.g.b.p;
import kotlin.t;

public final class e {
    private static final String FILE_NAME = FILE_NAME;
    private static final int FlT = FlT;
    private static final String FlU = FlU;
    public static final a FlV = new a((byte) 0);
    private static final String TAG = TAG;
    private eda FlO;
    private final Vector<Integer> FlP = new Vector<>();
    private final HashMap<String, Integer> FlQ = new HashMap<>();
    private final Vector<Integer> FlR = new Vector<>();
    private final HashMap<Integer, Integer> FlS = new HashMap<>();
    private String gna = "";
    private final String path;

    public e(String str) {
        p.h(str, "path");
        AppMethodBeat.i(118650);
        this.path = str;
        if (!fap()) {
            this.FlO = new eda();
        }
        this.FlP.clear();
        this.FlQ.clear();
        AppMethodBeat.o(118650);
    }

    private final synchronized boolean fap() {
        boolean z;
        AppMethodBeat.i(118648);
        byte[] aW = s.aW(this.path, 0, -1);
        if (aW == null) {
            AppMethodBeat.o(118648);
            z = false;
        } else {
            try {
                com.tencent.mm.bw.a parseFrom = new eda().parseFrom(aW);
                if (parseFrom == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryAsyncQueue");
                    AppMethodBeat.o(118648);
                    throw tVar;
                }
                this.FlO = (eda) parseFrom;
                z = true;
                AppMethodBeat.o(118648);
            } catch (IOException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                s.deleteFile(this.path);
                AppMethodBeat.o(118648);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean Yv(int i2) {
        AppMethodBeat.i(118649);
        this.FlP.remove(Integer.valueOf(i2));
        AppMethodBeat.o(118649);
        return true;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118651);
        AppMethodBeat.o(118651);
    }
}
