package com.tencent.mm.kernel.b;

import android.app.Application;

public abstract class g {
    public Application ca;
    public com.tencent.mm.kernel.a.a hqy;
    private Boolean hto;
    public a htp = new a();
    public String mProcessName;

    public static class a {
        public long htq;
        public long htr;
        public long hts;
        public long htt;
        public long htu;
        public long htv;
        public long htw;
        public long htx;
        public long hty;
    }

    public abstract String getPackageName();

    public g(String str, Application application) {
        this.mProcessName = str;
        this.hqy = new com.tencent.mm.kernel.a.a();
        this.ca = application;
    }

    public final Application aAZ() {
        return this.ca;
    }

    public final String getProcessName() {
        return this.mProcessName;
    }

    public final a aBa() {
        return this.htp;
    }

    public String toString() {
        return this.mProcessName != null ? this.mProcessName : super.toString();
    }

    public final boolean aBb() {
        if (this.hto == null) {
            this.hto = Boolean.valueOf(FY(""));
        }
        return this.hto.booleanValue();
    }

    public final boolean FY(String str) {
        return this.mProcessName != null && this.mProcessName.equals(new StringBuilder().append(getPackageName()).append(str).toString());
    }

    public final boolean FZ(String str) {
        return this.mProcessName != null && this.mProcessName.contains(new StringBuilder().append(getPackageName()).append(str).toString());
    }
}
