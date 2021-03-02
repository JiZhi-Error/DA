package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class RspHead extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!RspHead.class.desiredAssertionStatus());
    private static final String TAG = "RspHead";
    public int cmdId = 0;
    public byte encryptWithPack = 0;
    public String phoneGuid = "";
    public int requestId = 0;
    public int ret = 0;

    static {
        AppMethodBeat.i(102371);
        AppMethodBeat.o(102371);
    }

    public final String className() {
        return "jce.RspHead";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(int i2) {
        this.requestId = i2;
    }

    public final int getCmdId() {
        return this.cmdId;
    }

    public final void setCmdId(int i2) {
        this.cmdId = i2;
    }

    public final int getRet() {
        return this.ret;
    }

    public final void setRet(int i2) {
        this.ret = i2;
    }

    public final byte getEncryptWithPack() {
        return this.encryptWithPack;
    }

    public final void setEncryptWithPack(byte b2) {
        this.encryptWithPack = b2;
    }

    public final String getPhoneGuid() {
        return this.phoneGuid;
    }

    public final void setPhoneGuid(String str) {
        this.phoneGuid = str;
    }

    public RspHead() {
    }

    public RspHead(int i2, int i3, int i4, byte b2, String str) {
        this.requestId = i2;
        this.cmdId = i3;
        this.ret = i4;
        this.encryptWithPack = b2;
        this.phoneGuid = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102364);
        if (obj == null) {
            AppMethodBeat.o(102364);
            return false;
        }
        RspHead rspHead = (RspHead) obj;
        if (!JceUtil.equals(this.requestId, rspHead.requestId) || !JceUtil.equals(this.cmdId, rspHead.cmdId) || !JceUtil.equals(this.ret, rspHead.ret) || !JceUtil.equals(this.encryptWithPack, rspHead.encryptWithPack) || !JceUtil.equals(this.phoneGuid, rspHead.phoneGuid)) {
            AppMethodBeat.o(102364);
            return false;
        }
        AppMethodBeat.o(102364);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102365);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102365);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102365);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102366);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102366);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102366);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102367);
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.ret, 2);
        jceOutputStream.write(this.encryptWithPack, 3);
        if (this.phoneGuid != null) {
            jceOutputStream.write(this.phoneGuid, 4);
        }
        AppMethodBeat.o(102367);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102368);
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.ret = jceInputStream.read(this.ret, 2, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 3, false);
        this.phoneGuid = jceInputStream.readString(4, false);
        AppMethodBeat.o(102368);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102369);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.requestId, "requestId");
        jceDisplayer.display(this.cmdId, "cmdId");
        jceDisplayer.display(this.ret, "ret");
        jceDisplayer.display(this.encryptWithPack, "encryptWithPack");
        jceDisplayer.display(this.phoneGuid, "phoneGuid");
        AppMethodBeat.o(102369);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102370);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple(this.requestId, true);
        jceDisplayer.displaySimple(this.cmdId, true);
        jceDisplayer.displaySimple(this.ret, true);
        jceDisplayer.displaySimple(this.encryptWithPack, true);
        jceDisplayer.displaySimple(this.phoneGuid, false);
        AppMethodBeat.o(102370);
    }
}
