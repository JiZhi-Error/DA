package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public interface a {
    void a(int i2, C1484a aVar);

    /* renamed from: com.tencent.mm.plugin.monitor.a$a  reason: collision with other inner class name */
    public static class C1484a {
        int bCe;
        long dtZ;
        long fileLenInvalidCount;
        boolean jcC = false;
        long oJj;
        final String wKP;
        long zEP;
        long zEQ;
        ArrayList<b> zER = new ArrayList<>(20);
        ArrayList<c> zES = new ArrayList<>(20);

        C1484a(String str) {
            AppMethodBeat.i(51493);
            this.wKP = str;
            AppMethodBeat.o(51493);
        }

        public final String toString() {
            AppMethodBeat.i(51494);
            String format = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", Integer.valueOf(hashCode()), this.wKP, Boolean.valueOf(this.jcC), Long.valueOf(this.zEP), Long.valueOf(this.zEQ), Long.valueOf(this.oJj), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.zER.size()), Integer.valueOf(this.zES.size()), Long.valueOf(this.dtZ), Integer.valueOf(this.bCe));
            AppMethodBeat.o(51494);
            return format;
        }
    }

    public static class b {
        long fileLenInvalidCount;
        boolean jcC = false;
        long oJj;
        final int tag;
        String wKP;
        long zEP;
        long zEQ;

        b(String str, int i2) {
            this.wKP = str;
            this.tag = i2;
        }

        public final String toString() {
            AppMethodBeat.i(51495);
            String format = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.wKP, Boolean.valueOf(this.jcC), Long.valueOf(this.zEP), Long.valueOf(this.zEQ), Long.valueOf(this.oJj), Long.valueOf(this.fileLenInvalidCount));
            AppMethodBeat.o(51495);
            return format;
        }
    }

    public static class c {
        boolean jcC = false;
        long oJj;
        final String wKP;
        long zEP;
        long zEQ;
        long zET;

        c(String str) {
            this.wKP = str;
        }

        public final String toString() {
            AppMethodBeat.i(51496);
            String format = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", Integer.valueOf(hashCode()), this.wKP, Boolean.valueOf(this.jcC), Long.valueOf(this.zEP), Long.valueOf(this.zEQ), Long.valueOf(this.oJj), Long.valueOf(this.zET));
            AppMethodBeat.o(51496);
            return format;
        }
    }
}
