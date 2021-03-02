package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {

    public interface a {
        void em(boolean z);
    }

    public interface b {
        void onFuncRet(int i2, long j2, int i3, int i4, int i5, byte[] bArr);
    }

    public interface d {
        void sceneReport(int i2, long j2);
    }

    /* renamed from: com.tencent.mm.hardcoder.c$c  reason: collision with other inner class name */
    public static class C0350c {
        public long hlf;
        public int hlv;
        public int hlw;
        public int hlx;
        public int[] hly;
        public int scene;

        public C0350c(int i2, long j2, int i3, int i4, int i5, int[] iArr) {
            AppMethodBeat.i(62457);
            this.scene = i2;
            this.hlf = j2;
            this.hlv = i3;
            this.hlw = i4;
            this.hlx = i5;
            this.hly = (int[]) iArr.clone();
            AppMethodBeat.o(62457);
        }

        public final String toString() {
            AppMethodBeat.i(62458);
            String str = "[RequestStatus, scene:" + this.scene + ", action:" + this.hlf + ", cpulevel:" + this.hlv + ", gpulevel:" + this.hlw + ", iolevel:" + this.hlx + ", bindtids size:" + this.hly.length + "]";
            AppMethodBeat.o(62458);
            return str;
        }
    }
}
