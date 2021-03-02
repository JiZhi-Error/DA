package com.qq.wx.voice.vad;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static boolean DEBUG = false;
    public static boolean cgx = false;
    public EVadNative cgv = new EVadNative();
    public MMVoipVadNative cgw = new MMVoipVadNative();
    public long handle = 0;

    public a() {
        AppMethodBeat.i(74968);
        AppMethodBeat.o(74968);
    }

    public static void bI(boolean z) {
        AppMethodBeat.i(74969);
        cgx = z;
        if (z) {
            System.loadLibrary("MMVoipVadEmbed");
            if (DEBUG) {
                System.out.println("EVad loadLib MMVoipVadEmbed");
                AppMethodBeat.o(74969);
                return;
            }
        } else {
            System.loadLibrary("EVadEmbed");
            if (DEBUG) {
                System.out.println("EVad loadLib EVadEmbed");
            }
        }
        AppMethodBeat.o(74969);
    }

    public final int a(short[] sArr, int i2) {
        AppMethodBeat.i(74970);
        if (this.handle == 0) {
            AppMethodBeat.o(74970);
            return 1;
        }
        if (DEBUG) {
            System.out.println("EVad AddData handle = " + this.handle);
        }
        if (cgx) {
            int AddData = this.cgw.AddData(this.handle, sArr, i2);
            AppMethodBeat.o(74970);
            return AddData;
        }
        int AddData2 = this.cgv.AddData(this.handle, sArr, i2);
        AppMethodBeat.o(74970);
        return AddData2;
    }

    public final int IL() {
        AppMethodBeat.i(74971);
        if (this.handle == 0) {
            AppMethodBeat.o(74971);
            return 1;
        }
        if (DEBUG) {
            System.out.println("EVad Release handle = " + this.handle);
        }
        if (cgx) {
            int Release = this.cgw.Release(this.handle);
            AppMethodBeat.o(74971);
            return Release;
        }
        int Release2 = this.cgv.Release(this.handle);
        AppMethodBeat.o(74971);
        return Release2;
    }
}
