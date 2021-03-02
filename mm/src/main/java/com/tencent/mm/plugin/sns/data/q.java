package com.tencent.mm.plugin.sns.data;

public final class q {
    public int DEA;
    public int DEB;
    public String DEC = "";
    public String DED = "";
    public String DEE = "";
    public boolean DEF = false;
    public int DEz = 0;
    public String desc = "";
    public int ecf;
    public int fileSize = 0;
    public int height = -1;
    public String path = "";
    public String thumbPath = "";
    public int type;
    public int width = -1;

    public q() {
    }

    public q(String str, int i2) {
        this.path = str;
        this.type = i2;
        this.ecf = -1;
    }

    public q(int i2, int i3) {
        this.ecf = i2;
        this.type = i3;
        this.path = "";
    }
}
