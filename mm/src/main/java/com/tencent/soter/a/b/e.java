package com.tencent.soter.a.b;

import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;

public abstract class e<T> extends f {
    public T RQu;

    e() {
        super(-1);
        this.RQu = null;
    }

    protected e(int i2, String str) {
        this(i2, str, null);
    }

    protected e(int i2, String str, T t) {
        super(i2, str);
        this.RQu = null;
        switch (i2) {
            case 1002:
                this.errMsg = "get support soter failed remotely";
                break;
            case 1003:
                this.errMsg = "upload app secure key";
                break;
            case 1004:
                this.errMsg = "upload auth key failed";
                break;
            case 1008:
                this.errMsg = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
                break;
            case 1011:
                this.errMsg = "context instance already released. should not happen normally, you can try to call again";
                break;
            case 1013:
                this.errMsg = "there must be at least 1 biometric enrolled in system to complete this process. please check it previously";
                break;
            case 1014:
                this.errMsg = "get challenge failed";
                break;
            case 1019:
                this.errMsg = "upload or verify signature in server side failed";
                break;
        }
        if (!g.isNullOrNil(str)) {
            this.errMsg = str;
        }
        this.RQu = t;
    }

    protected e(int i2) {
        this(i2, "", null);
    }

    protected e(T t) {
        this(0, "", t);
    }

    @Override // com.tencent.soter.core.c.f
    public String toString() {
        if (this.RQu == null) {
            return super.toString();
        }
        return String.format("total: %s, extData: %s", super.toString(), this.RQu.toString());
    }
}
