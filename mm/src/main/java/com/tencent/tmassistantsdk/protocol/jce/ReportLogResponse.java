package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class ReportLogResponse extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ReportLogResponse.class.desiredAssertionStatus());
    private static final String TAG = "ReportLogResponse";
    public int ret = 0;

    static {
        AppMethodBeat.i(102335);
        AppMethodBeat.o(102335);
    }

    public final String className() {
        return "jce.ReportLogResponse";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final int getRet() {
        return this.ret;
    }

    public final void setRet(int i2) {
        this.ret = i2;
    }

    public ReportLogResponse() {
    }

    public ReportLogResponse(int i2) {
        this.ret = i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102328);
        if (obj == null) {
            AppMethodBeat.o(102328);
            return false;
        }
        boolean equals = JceUtil.equals(this.ret, ((ReportLogResponse) obj).ret);
        AppMethodBeat.o(102328);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.i(102329);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102329);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102329);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102330);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102330);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102330);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102331);
        jceOutputStream.write(this.ret, 0);
        AppMethodBeat.o(102331);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102332);
        this.ret = jceInputStream.read(this.ret, 0, true);
        AppMethodBeat.o(102332);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102333);
        new JceDisplayer(sb, i2).display(this.ret, "ret");
        AppMethodBeat.o(102333);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102334);
        new JceDisplayer(sb, i2).displaySimple(this.ret, false);
        AppMethodBeat.o(102334);
    }
}
