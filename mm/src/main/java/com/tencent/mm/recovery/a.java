package com.tencent.mm.recovery;

import android.content.SharedPreferences;
import com.tencent.mm.recoveryv2.e;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a {

    /* renamed from: com.tencent.mm.recovery.a$a  reason: collision with other inner class name */
    static abstract class AbstractC2042a extends e.b {
        final String mName;

        public AbstractC2042a(String str) {
            super(str);
            this.mName = str;
        }

        @Override // com.tencent.mm.recoveryv2.e
        public final void guv() {
            if (this.Bar.size() != 0) {
                MultiProcessMMKV.init();
                SharedPreferences.Editor edit = ("".equals(this.mName) ? MultiProcessMMKV.getDefault() : MultiProcessMMKV.getMMKV(this.mName)).edit();
                for (e.b.a aVar : this.Bar) {
                    aVar.NBE = edit;
                    aVar.perform();
                    this.NBD.append(aVar.getDescription()).append(";\n");
                }
                edit.apply();
            }
        }
    }
}
