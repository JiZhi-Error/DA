package com.tencent.matrix.a.b;

import com.tencent.matrix.a.b.a;
import com.tencent.matrix.a.b.a.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class b {
    public a cRJ;
    public Callable<String> cRK;
    public long cRL;
    public int cRM;
    public long cRN;
    public long cRO;
    public long cRP;
    public int cRQ;
    public int cRR;
    public boolean cRS;
    public boolean cRT;
    public boolean cRU;
    public boolean cRV;
    public boolean cRW;
    public List<String> cRX;
    public List<String> cRY;
    public final List<g> cRZ;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        this.cRJ = new a.C0204a();
        this.cRL = 120000;
        this.cRM = 30;
        this.cRN = 30000;
        this.cRO = 1200000;
        this.cRP = 600000;
        this.cRQ = 1024;
        this.cRR = 100;
        this.cRS = true;
        this.cRT = false;
        this.cRU = true;
        this.cRV = false;
        this.cRW = false;
        this.cRX = Collections.emptyList();
        this.cRY = Collections.emptyList();
        this.cRZ = new ArrayList(3);
    }

    public final String toString() {
        return "BatteryMonitorConfig{, wakelockTimeout=" + this.cRL + ", wakelockWarnCount=" + this.cRM + ", greyTime=" + this.cRN + ", foregroundLoopCheckTime=" + this.cRO + ", overHeatCount=" + this.cRQ + ", isForegroundModeEnabled=" + this.cRS + ", isBackgroundModeEnabled=" + this.cRT + ", isBuiltinForegroundNotifyEnabled=" + this.cRU + ", isStatAsSample=" + this.cRV + ", tagWhiteList=" + this.cRX + ", features=" + this.cRZ + '}';
    }

    public static class a {
        public final b cSa = new b((byte) 0);

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.List<com.tencent.matrix.a.b.a.g> */
        /* JADX WARN: Multi-variable type inference failed */
        public final a Z(Class<? extends g> cls) {
            try {
                this.cSa.cRZ.add(cls.newInstance());
            } catch (Exception e2) {
            }
            return this;
        }

        public final a eo(String str) {
            if (this.cSa.cRX == Collections.EMPTY_LIST) {
                this.cSa.cRX = new ArrayList();
            }
            this.cSa.cRX.add(str);
            return this;
        }

        public final a ep(String str) {
            if (this.cSa.cRY == Collections.EMPTY_LIST) {
                this.cSa.cRY = new ArrayList();
            }
            this.cSa.cRY.add(str);
            return this;
        }
    }
}
