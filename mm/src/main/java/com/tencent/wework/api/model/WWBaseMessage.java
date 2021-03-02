package com.tencent.wework.api.model;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;

public abstract class WWBaseMessage extends BaseMessage {
    public String appId;
    public String leq;

    @Override // com.tencent.wework.api.model.BaseMessage
    public void toBundle(Bundle bundle) {
        String valueOf = String.valueOf(SystemClock.uptimeMillis());
        this.transaction = valueOf;
        bundle.putString("_wwapi_basereq_transaction", valueOf);
        bundle.putString("_wwapi_basereq_openid", this.appId);
        bundle.putString("_wwapi_basereq_agentid", this.leq);
        try {
            bundle.putString("_wwapi_basereq_appbundle", this.mContext.getPackageName());
            bundle.putString("_wwapi_basereq_appname", this.mContext.getString(this.mContext.getApplicationInfo().labelRes));
        } catch (Throwable th) {
        }
        bundle.putInt("_wwobject_sdkVer", 4);
        bundle.putString("_wwobject_sdkVername", "2.0.11.21");
        if (Sxr != null && TextUtils.isEmpty(this.yOQ)) {
            this.yOQ = Sxr.hrF();
        }
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public void fromBundle(Bundle bundle) {
        this.transaction = bundle.getString("_wwapi_basereq_transaction");
        this.appId = bundle.getString("_wwapi_basereq_openid");
        this.leq = bundle.getString("_wwapi_basereq_agentid");
        this.appName = bundle.getString("_wwapi_basereq_appname");
        this.Sxp = bundle.getString("_wwapi_basereq_appbundle");
        this.sdkVer = bundle.getInt("_wwobject_sdkVer", 0);
        this.Sxq = bundle.getString("_wwobject_sdkVername");
        if (Sxr != null && TextUtils.isEmpty(this.yOQ)) {
            this.yOQ = Sxr.hrF();
        }
    }
}
