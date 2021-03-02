package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class GetSettingsRequest extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!GetSettingsRequest.class.desiredAssertionStatus());
    private static final String TAG = "GetSettingsRequest";
    public String reserve = "";

    static {
        AppMethodBeat.i(102299);
        AppMethodBeat.o(102299);
    }

    public final String className() {
        return "jce.GetSettingsRequest";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final String getReserve() {
        return this.reserve;
    }

    public final void setReserve(String str) {
        this.reserve = str;
    }

    public GetSettingsRequest() {
    }

    public GetSettingsRequest(String str) {
        this.reserve = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102292);
        if (obj == null) {
            AppMethodBeat.o(102292);
            return false;
        }
        boolean equals = JceUtil.equals(this.reserve, ((GetSettingsRequest) obj).reserve);
        AppMethodBeat.o(102292);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.i(102293);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102293);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102293);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102294);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102294);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102294);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102295);
        if (this.reserve != null) {
            jceOutputStream.write(this.reserve, 0);
        }
        AppMethodBeat.o(102295);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102296);
        this.reserve = jceInputStream.readString(0, false);
        AppMethodBeat.o(102296);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102297);
        new JceDisplayer(sb, i2).display(this.reserve, "reserve");
        AppMethodBeat.o(102297);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102298);
        new JceDisplayer(sb, i2).displaySimple(this.reserve, false);
        AppMethodBeat.o(102298);
    }
}
