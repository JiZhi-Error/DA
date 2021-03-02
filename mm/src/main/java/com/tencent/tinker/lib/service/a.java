package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a implements Serializable {
    public String SjJ;
    public long SjK;
    public boolean SjL;
    public String SjM;
    public long costTime;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f2950e;
    public boolean isSuccess;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPatchResult: \n");
        stringBuffer.append("isSuccess:" + this.isSuccess + "\n");
        stringBuffer.append("rawPatchFilePath:" + this.SjJ + "\n");
        stringBuffer.append("costTime:" + this.costTime + "\n");
        stringBuffer.append("dexoptTriggerTime:" + this.SjK + "\n");
        stringBuffer.append("isOatGenerated:" + this.SjL + "\n");
        if (this.SjM != null) {
            stringBuffer.append("patchVersion:" + this.SjM + "\n");
        }
        if (this.f2950e != null) {
            stringBuffer.append("Throwable:" + this.f2950e.getMessage() + "\n");
        }
        return stringBuffer.toString();
    }
}
