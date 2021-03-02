package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class ReqHead extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ReqHead.class.desiredAssertionStatus());
    private static final String TAG = "ReqHead";
    static Net cache_net;
    static Terminal cache_terminal;
    public int assistantAPILevel = 0;
    public int assistantVersionCode = 0;
    public int cmdId = 0;
    public byte encryptWithPack = 0;
    public Net net = null;
    public String phoneGuid = "";
    public String qua = "";
    public int requestId = 0;
    public Terminal terminal = null;

    static {
        AppMethodBeat.i(102343);
        AppMethodBeat.o(102343);
    }

    public final String className() {
        return "jce.ReqHead";
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

    public final String getPhoneGuid() {
        return this.phoneGuid;
    }

    public final void setPhoneGuid(String str) {
        this.phoneGuid = str;
    }

    public final String getQua() {
        return this.qua;
    }

    public final void setQua(String str) {
        this.qua = str;
    }

    public final byte getEncryptWithPack() {
        return this.encryptWithPack;
    }

    public final void setEncryptWithPack(byte b2) {
        this.encryptWithPack = b2;
    }

    public final Terminal getTerminal() {
        return this.terminal;
    }

    public final void setTerminal(Terminal terminal2) {
        this.terminal = terminal2;
    }

    public final int getAssistantAPILevel() {
        return this.assistantAPILevel;
    }

    public final void setAssistantAPILevel(int i2) {
        this.assistantAPILevel = i2;
    }

    public final int getAssistantVersionCode() {
        return this.assistantVersionCode;
    }

    public final void setAssistantVersionCode(int i2) {
        this.assistantVersionCode = i2;
    }

    public final Net getNet() {
        return this.net;
    }

    public final void setNet(Net net2) {
        this.net = net2;
    }

    public ReqHead() {
    }

    public ReqHead(int i2, int i3, String str, String str2, byte b2, Terminal terminal2, int i4, int i5, Net net2) {
        this.requestId = i2;
        this.cmdId = i3;
        this.phoneGuid = str;
        this.qua = str2;
        this.encryptWithPack = b2;
        this.terminal = terminal2;
        this.assistantAPILevel = i4;
        this.assistantVersionCode = i5;
        this.net = net2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102336);
        if (obj == null) {
            AppMethodBeat.o(102336);
            return false;
        }
        ReqHead reqHead = (ReqHead) obj;
        if (!JceUtil.equals(this.requestId, reqHead.requestId) || !JceUtil.equals(this.cmdId, reqHead.cmdId) || !JceUtil.equals(this.phoneGuid, reqHead.phoneGuid) || !JceUtil.equals(this.qua, reqHead.qua) || !JceUtil.equals(this.encryptWithPack, reqHead.encryptWithPack) || !JceUtil.equals(this.terminal, reqHead.terminal) || !JceUtil.equals(this.assistantAPILevel, reqHead.assistantAPILevel) || !JceUtil.equals(this.assistantVersionCode, reqHead.assistantVersionCode) || !JceUtil.equals(this.net, reqHead.net)) {
            AppMethodBeat.o(102336);
            return false;
        }
        AppMethodBeat.o(102336);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102337);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102337);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102337);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102338);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102338);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102338);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102339);
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.phoneGuid, 2);
        jceOutputStream.write(this.qua, 3);
        jceOutputStream.write(this.encryptWithPack, 4);
        if (this.terminal != null) {
            jceOutputStream.write((JceStruct) this.terminal, 5);
        }
        jceOutputStream.write(this.assistantAPILevel, 6);
        jceOutputStream.write(this.assistantVersionCode, 7);
        if (this.net != null) {
            jceOutputStream.write((JceStruct) this.net, 8);
        }
        AppMethodBeat.o(102339);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102340);
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.phoneGuid = jceInputStream.readString(2, true);
        this.qua = jceInputStream.readString(3, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 4, false);
        if (cache_terminal == null) {
            cache_terminal = new Terminal();
        }
        this.terminal = (Terminal) jceInputStream.read((JceStruct) cache_terminal, 5, false);
        this.assistantAPILevel = jceInputStream.read(this.assistantAPILevel, 6, false);
        this.assistantVersionCode = jceInputStream.read(this.assistantVersionCode, 7, false);
        if (cache_net == null) {
            cache_net = new Net();
        }
        this.net = (Net) jceInputStream.read((JceStruct) cache_net, 8, false);
        AppMethodBeat.o(102340);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102341);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.requestId, "requestId");
        jceDisplayer.display(this.cmdId, "cmdId");
        jceDisplayer.display(this.phoneGuid, "phoneGuid");
        jceDisplayer.display(this.qua, "qua");
        jceDisplayer.display(this.encryptWithPack, "encryptWithPack");
        jceDisplayer.display((JceStruct) this.terminal, "terminal");
        jceDisplayer.display(this.assistantAPILevel, "assistantAPILevel");
        jceDisplayer.display(this.assistantVersionCode, "assistantVersionCode");
        jceDisplayer.display((JceStruct) this.net, "net");
        AppMethodBeat.o(102341);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102342);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple(this.requestId, true);
        jceDisplayer.displaySimple(this.cmdId, true);
        jceDisplayer.displaySimple(this.phoneGuid, true);
        jceDisplayer.displaySimple(this.qua, true);
        jceDisplayer.displaySimple(this.encryptWithPack, true);
        jceDisplayer.displaySimple((JceStruct) this.terminal, true);
        jceDisplayer.displaySimple(this.assistantAPILevel, true);
        jceDisplayer.displaySimple(this.assistantVersionCode, true);
        jceDisplayer.displaySimple((JceStruct) this.net, false);
        AppMethodBeat.o(102342);
    }
}
