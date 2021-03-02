package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.protocal.protobuf.dzo;

public final class m implements a {
    public dzo DIu;
    public String Epu = "";
    public String Epv = "";
    public View Epw;
    public String Epx;
    public String UserName = "";
    public String iAc = "";
    public int scene = -1;
    public Object tag;

    public m(String str, String str2, dzo dzo, String str3, String str4, View view, int i2, String str5) {
        this.Epu = str;
        this.Epv = str2;
        this.DIu = dzo;
        this.UserName = str3;
        this.iAc = str4;
        this.Epw = view;
        this.Epx = str5;
        this.scene = i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.c.a
    public final String getUserName() {
        if (this.DIu == null) {
            return null;
        }
        return this.DIu.Username;
    }
}
