package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class StatCfg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!StatCfg.class.desiredAssertionStatus());
    private static final String TAG = "StatCfg";
    public int internal = 0;
    public short lineNum = 0;
    public byte netType = 0;
    public byte type = 0;

    static {
        AppMethodBeat.i(102387);
        AppMethodBeat.o(102387);
    }

    public final String className() {
        return "jce.StatCfg";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final byte getType() {
        return this.type;
    }

    public final void setType(byte b2) {
        this.type = b2;
    }

    public final byte getNetType() {
        return this.netType;
    }

    public final void setNetType(byte b2) {
        this.netType = b2;
    }

    public final short getLineNum() {
        return this.lineNum;
    }

    public final void setLineNum(short s) {
        this.lineNum = s;
    }

    public final int getInternal() {
        return this.internal;
    }

    public final void setInternal(int i2) {
        this.internal = i2;
    }

    public StatCfg() {
    }

    public StatCfg(byte b2, byte b3, short s, int i2) {
        this.type = b2;
        this.netType = b3;
        this.lineNum = s;
        this.internal = i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102380);
        if (obj == null) {
            AppMethodBeat.o(102380);
            return false;
        }
        StatCfg statCfg = (StatCfg) obj;
        if (!JceUtil.equals(this.type, statCfg.type) || !JceUtil.equals(this.netType, statCfg.netType) || !JceUtil.equals(this.lineNum, statCfg.lineNum) || !JceUtil.equals(this.internal, statCfg.internal)) {
            AppMethodBeat.o(102380);
            return false;
        }
        AppMethodBeat.o(102380);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102381);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102381);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102381);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102382);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102382);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102382);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102383);
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.netType, 1);
        jceOutputStream.write(this.lineNum, 2);
        jceOutputStream.write(this.internal, 3);
        AppMethodBeat.o(102383);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102384);
        this.type = jceInputStream.read(this.type, 0, true);
        this.netType = jceInputStream.read(this.netType, 1, true);
        this.lineNum = jceInputStream.read(this.lineNum, 2, false);
        this.internal = jceInputStream.read(this.internal, 3, false);
        AppMethodBeat.o(102384);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102385);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.netType, DownloadInfo.NETTYPE);
        jceDisplayer.display(this.lineNum, "lineNum");
        jceDisplayer.display(this.internal, "internal");
        AppMethodBeat.o(102385);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102386);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.netType, true);
        jceDisplayer.displaySimple(this.lineNum, true);
        jceDisplayer.displaySimple(this.internal, false);
        AppMethodBeat.o(102386);
    }
}
