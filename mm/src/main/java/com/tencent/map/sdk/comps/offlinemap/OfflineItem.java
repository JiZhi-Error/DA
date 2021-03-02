package com.tencent.map.sdk.comps.offlinemap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OfflineItem {
    private String name;
    private int percentage;
    private String pinyin;
    private long size;
    private boolean upgrade = true;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j2) {
        this.size = j2;
    }

    public boolean isUpgrade() {
        return this.upgrade;
    }

    public void setUpgrade(boolean z) {
        this.upgrade = z;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int i2) {
        this.percentage = i2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(193502);
        if (this == obj) {
            AppMethodBeat.o(193502);
            return true;
        } else if (!(obj instanceof OfflineItem)) {
            AppMethodBeat.o(193502);
            return false;
        } else {
            OfflineItem offlineItem = (OfflineItem) obj;
            if (this.name == null ? offlineItem.name != null : !this.name.equals(offlineItem.name)) {
                AppMethodBeat.o(193502);
                return false;
            } else if (this.pinyin != null) {
                boolean equals = this.pinyin.equals(offlineItem.pinyin);
                AppMethodBeat.o(193502);
                return equals;
            } else if (offlineItem.pinyin == null) {
                AppMethodBeat.o(193502);
                return true;
            } else {
                AppMethodBeat.o(193502);
                return false;
            }
        }
    }

    public int hashCode() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(193503);
        if (this.name != null) {
            i2 = this.name.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = i2 * 31;
        if (this.pinyin != null) {
            i3 = this.pinyin.hashCode();
        }
        int i5 = i4 + i3;
        AppMethodBeat.o(193503);
        return i5;
    }

    public String toString() {
        AppMethodBeat.i(193504);
        StringBuffer stringBuffer = new StringBuffer("OfflineItem{");
        stringBuffer.append("name='").append(this.name).append('\'');
        stringBuffer.append(", pinyin='").append(this.pinyin).append('\'');
        stringBuffer.append(", size=").append(this.size);
        stringBuffer.append(", upgrade=").append(this.upgrade);
        stringBuffer.append(", percentage=").append(this.percentage);
        stringBuffer.append('}');
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(193504);
        return stringBuffer2;
    }
}
