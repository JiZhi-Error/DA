package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class Net extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Net.class.desiredAssertionStatus());
    private static final String TAG = "Net";
    public String extNetworkOperator = "";
    public int extNetworkType = 0;
    public byte isWap = 0;
    public byte netType = 0;

    static {
        AppMethodBeat.i(102319);
        AppMethodBeat.o(102319);
    }

    public final String className() {
        return "jce.Net";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final byte getNetType() {
        return this.netType;
    }

    public final void setNetType(byte b2) {
        this.netType = b2;
    }

    public final String getExtNetworkOperator() {
        return this.extNetworkOperator;
    }

    public final void setExtNetworkOperator(String str) {
        this.extNetworkOperator = str;
    }

    public final int getExtNetworkType() {
        return this.extNetworkType;
    }

    public final void setExtNetworkType(int i2) {
        this.extNetworkType = i2;
    }

    public final byte getIsWap() {
        return this.isWap;
    }

    public final void setIsWap(byte b2) {
        this.isWap = b2;
    }

    public Net() {
    }

    public Net(byte b2, String str, int i2, byte b3) {
        this.netType = b2;
        this.extNetworkOperator = str;
        this.extNetworkType = i2;
        this.isWap = b3;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102312);
        if (obj == null) {
            AppMethodBeat.o(102312);
            return false;
        }
        Net net = (Net) obj;
        if (!JceUtil.equals(this.netType, net.netType) || !JceUtil.equals(this.extNetworkOperator, net.extNetworkOperator) || !JceUtil.equals(this.extNetworkType, net.extNetworkType) || !JceUtil.equals(this.isWap, net.isWap)) {
            AppMethodBeat.o(102312);
            return false;
        }
        AppMethodBeat.o(102312);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102313);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102313);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102313);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102314);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102314);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102314);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102315);
        jceOutputStream.write(this.netType, 0);
        if (this.extNetworkOperator != null) {
            jceOutputStream.write(this.extNetworkOperator, 1);
        }
        jceOutputStream.write(this.extNetworkType, 2);
        jceOutputStream.write(this.isWap, 3);
        AppMethodBeat.o(102315);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102316);
        this.netType = jceInputStream.read(this.netType, 0, true);
        this.extNetworkOperator = jceInputStream.readString(1, false);
        this.extNetworkType = jceInputStream.read(this.extNetworkType, 2, false);
        this.isWap = jceInputStream.read(this.isWap, 3, false);
        AppMethodBeat.o(102316);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102317);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.netType, DownloadInfo.NETTYPE);
        jceDisplayer.display(this.extNetworkOperator, "extNetworkOperator");
        jceDisplayer.display(this.extNetworkType, "extNetworkType");
        jceDisplayer.display(this.isWap, "isWap");
        AppMethodBeat.o(102317);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102318);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple(this.netType, true);
        jceDisplayer.displaySimple(this.extNetworkOperator, true);
        jceDisplayer.displaySimple(this.extNetworkType, true);
        jceDisplayer.displaySimple(this.isWap, false);
        AppMethodBeat.o(102318);
    }
}
