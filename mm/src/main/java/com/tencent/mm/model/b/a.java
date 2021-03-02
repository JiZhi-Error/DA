package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import com.tencent.mm.model.b.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;

public abstract class a implements e {
    protected e.a iGF;
    protected String iGG = aWV();
    protected String[] iGH = aWU();

    public abstract String aWV();

    public final boolean KX(String str) {
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ == null || !FQ.getBoolean(this.iGG + str, false)) {
            return false;
        }
        return true;
    }

    public final void a(String str, boolean z, String[] strArr) {
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ != null) {
            FQ.edit().putBoolean(this.iGG + str, z).commit();
            if (!(this.iGH == null || strArr == null || this.iGH.length != strArr.length)) {
                String[] strArr2 = this.iGH;
                int i2 = 0;
                for (String str2 : strArr2) {
                    if (str2 != null) {
                        FQ.edit().putString(this.iGG + str2 + str, strArr[i2] != null ? strArr[i2] : "").commit();
                    }
                    i2++;
                }
            }
            if (this.iGF != null) {
                this.iGF.aXh();
            }
        }
    }

    public final String aU(String str, String str2) {
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ == null) {
            return null;
        }
        return FQ.getString(this.iGG + str2 + str, null);
    }

    public final void KY(String str) {
        bg.aVF();
        SharedPreferences FQ = c.FQ("banner");
        if (FQ != null) {
            FQ.edit().remove(this.iGG + str).commit();
            if (this.iGH != null) {
                String[] strArr = this.iGH;
                for (String str2 : strArr) {
                    if (str2 != null) {
                        FQ.edit().remove(this.iGG + str2 + str).commit();
                    }
                }
            }
            if (this.iGF != null) {
                this.iGF.aXi();
            }
        }
    }

    public final void a(e.a aVar) {
        this.iGF = aVar;
    }

    /* access modifiers changed from: protected */
    public String[] aWU() {
        return null;
    }
}
