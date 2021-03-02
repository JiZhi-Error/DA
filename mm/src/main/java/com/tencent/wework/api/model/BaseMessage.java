package com.tencent.wework.api.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.wework.api.util.ReflecterHelper;
import com.tencent.wework.api.util.SessionProvider;

public abstract class BaseMessage {
    protected static SessionProvider Sxr = null;
    public String Sxp;
    public String Sxq;
    protected String Sxs;
    public String appName;
    protected Context mContext = null;
    public int sdkVer;
    public String transaction;
    protected String yOQ = "";

    public abstract boolean checkArgs();

    public abstract void fromBundle(Bundle bundle);

    public abstract void toBundle(Bundle bundle);

    public void setContext(Context context) {
        this.mContext = context;
    }

    public final void brz(String str) {
        this.yOQ = str;
    }

    public void v(Intent intent, String str) {
    }

    public static BaseMessage bB(Bundle bundle) {
        try {
            String string = bundle.getString("_wwobject_identifier_");
            if (!TextUtils.isEmpty(string)) {
                BaseMessage baseMessage = (BaseMessage) ReflecterHelper.newInstance(string);
                baseMessage.fromBundle(bundle);
                return baseMessage;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static Bundle a(BaseMessage baseMessage) {
        if (baseMessage == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        baseMessage.toBundle(bundle);
        bundle.putString("_wwobject_identifier_", baseMessage.getClass().getName());
        return bundle;
    }

    public static BaseMessage A(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter("wwoid");
            if (!TextUtils.isEmpty(queryParameter)) {
                return (BaseMessage) ReflecterHelper.newInstance(queryParameter);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public void brA(String str) {
        this.Sxs = str;
    }
}
