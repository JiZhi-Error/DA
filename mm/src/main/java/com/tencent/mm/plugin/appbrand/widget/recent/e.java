package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;

public final class e {
    public boolean oBV = false;
    public LocalUsageInfo ooj;
    public int position;
    public int type = 1;

    public e(LocalUsageInfo localUsageInfo) {
        this.ooj = localUsageInfo;
        this.type = 1;
    }

    public e(int i2) {
        this.type = i2;
    }
}
