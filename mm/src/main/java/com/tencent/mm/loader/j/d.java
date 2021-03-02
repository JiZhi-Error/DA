package com.tencent.mm.loader.j;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class d {
    public static d icC = new d(null);
    protected final SharedPreferences sp;

    protected d(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            this.sp = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        } else {
            this.sp = sharedPreferences;
        }
    }

    public final SharedPreferences aLJ() {
        return this.sp;
    }

    public final String aA(String str, String str2) {
        return this.sp.getString(str, str2);
    }
}
