package com.tencent.matrix.trace.a;

import java.util.Set;

public final class b {
    public com.tencent.c.a.a cVx;
    public boolean cWq;
    public boolean daK;
    public boolean daL;
    public boolean daM;
    public boolean daN;
    public boolean daO;
    public String daP;
    public Set<String> daQ;
    public boolean daR;

    public static class a {
        public b daS = new b((byte) 0);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        this.daR = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" \n");
        sb.append("# TraceConfig\n");
        sb.append("* isDebug:\t").append(this.cWq).append("\n");
        sb.append("* isDevEnv:\t").append(this.daO).append("\n");
        sb.append("* isHasActivity:\t").append(this.daR).append("\n");
        sb.append("* defaultFpsEnable:\t").append(this.daK).append("\n");
        sb.append("* defaultMethodTraceEnable:\t").append(this.daL).append("\n");
        sb.append("* defaultStartupEnable:\t").append(this.daM).append("\n");
        sb.append("* defaultAnrEnable:\t").append(this.daN).append("\n");
        sb.append("* splashActivities:\t").append(this.daP).append("\n");
        return sb.toString();
    }
}
