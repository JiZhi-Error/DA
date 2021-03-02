package com.tencent.matrix.trace.e;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

public class b {
    private static final LinkedList<a> dbM = new LinkedList<>();
    public int dbL;
    private Executor executor;
    public final List<a> list;
    public long time;

    public static final class a {
        public String dbP;
        public long dbQ;
        public long dbR;
        public int dbS;
        public long dbT;
        public long dbU;
        public long dbV;
        public long dbW;
        public boolean dbn;

        public static a TF() {
            a aVar;
            synchronized (b.dbM) {
                aVar = (a) b.dbM.poll();
            }
            if (aVar == null) {
                return new a();
            }
            return aVar;
        }
    }

    public b() {
        this.dbL = 0;
        this.list = new LinkedList();
        this.dbL = TD();
    }

    @Deprecated
    public void a(String str, long j2, long j3, int i2, boolean z) {
    }

    public void a(String str, long j2, long j3, int i2, boolean z, long j4, long j5, long j6, long j7) {
    }

    public void L(List<a> list2) {
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public int TD() {
        return 0;
    }
}
