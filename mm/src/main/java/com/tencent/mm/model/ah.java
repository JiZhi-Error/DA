package com.tencent.mm.model;

public class ah {
    private final String dWp;
    public final boolean enable;
    private final String gzZ;
    private boolean iDl;
    private final String name;
    private final String type;

    public ah() {
        this.type = "";
        this.name = "";
        this.dWp = "";
        this.gzZ = "";
        this.enable = true;
    }

    public ah(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.type = str;
        this.name = str2;
        this.dWp = str3;
        this.gzZ = str4;
        this.enable = z;
        this.iDl = z2;
    }

    public final String getType() {
        return this.type == null ? "" : this.type;
    }

    public final String arI() {
        return this.dWp == null ? "" : this.dWp;
    }

    public final String aVj() {
        return this.gzZ == null ? "" : this.gzZ;
    }
}
