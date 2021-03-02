package com.c.a.b;

public final class m {
    long MS;
    String ZJ;
    int cpJ;
    int cpK;
    String mSignature;
    String yZ;

    public m(long j2, String str, String str2, String str3, int i2, int i3) {
        this.MS = j2;
        this.ZJ = str;
        this.mSignature = str2;
        this.yZ = str3;
        this.cpJ = i2;
        this.cpK = i3;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder().append(this.ZJ).append(this.mSignature.replace('/', '.')).append(" - ").append(this.yZ).append(":");
        switch (this.cpK) {
            case -3:
                str = "Native method";
                break;
            case -2:
                str = "Compiled method";
                break;
            case -1:
                str = "Unknown line number";
                break;
            case 0:
                str = "No line number";
                break;
            default:
                str = String.valueOf(this.cpK);
                break;
        }
        return append.append(str).toString();
    }
}
