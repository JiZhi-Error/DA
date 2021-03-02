package com.tencent.recovery.wx.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.recovery.util.Util;
import java.util.UUID;

public class WXUtil {
    public static final String LAST_LOGIN_UIN = "last_login_uin";
    public static final String LAST_LOGIN_USERNAME = "login_user_name";
    public static final String LAST_LOGIN_WEXIN_USERNAME = "login_weixin_username";

    public static String getWXUin(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString(LAST_LOGIN_UIN, AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public static String getWXUserName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        String string = sharedPreferences.getString(LAST_LOGIN_WEXIN_USERNAME, "");
        if (Util.isNullOrNil(string)) {
            string = sharedPreferences.getString(LAST_LOGIN_USERNAME, "");
        }
        if (Util.isNullOrNil(string)) {
            return String.valueOf(Util.getUUID(context));
        }
        return string;
    }

    public static final String appendRandomParams(String str) {
        if (str.contains("?")) {
            return str + "uuid=" + UUID.randomUUID().toString();
        }
        return str + "?uuid=" + UUID.randomUUID().toString();
    }

    public static final String getHttpConfigCodeKey(int i2) {
        return "KeyConfigHttpCode[" + i2 + "]";
    }

    public static final String getHttpPatchCodeKey(int i2) {
        return "KeyPatchHttpCode[" + i2 + "]";
    }
}
