package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mm.pluginsdk.model.u;

public abstract class t {
    public abstract boolean bdn(String str);

    public abstract String blB();

    public abstract String gmq();

    public abstract u.a gmr();

    public abstract boolean in(Context context);

    public boolean aw(Context context, Intent intent) {
        return false;
    }

    public String c(Context context, ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }
}
