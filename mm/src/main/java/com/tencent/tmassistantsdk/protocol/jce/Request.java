package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class Request extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Request.class.desiredAssertionStatus());
    private static final String TAG = "Request";
    static byte[] cache_body;
    static ReqHead cache_head;
    public byte[] body = null;
    public ReqHead head = null;

    static {
        AppMethodBeat.i(102351);
        AppMethodBeat.o(102351);
    }

    public final String className() {
        return "jce.Request";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final ReqHead getHead() {
        return this.head;
    }

    public final void setHead(ReqHead reqHead) {
        this.head = reqHead;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public Request() {
    }

    public Request(ReqHead reqHead, byte[] bArr) {
        this.head = reqHead;
        this.body = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102344);
        if (obj == null) {
            AppMethodBeat.o(102344);
            return false;
        }
        Request request = (Request) obj;
        if (!JceUtil.equals(this.head, request.head) || !JceUtil.equals(this.body, request.body)) {
            AppMethodBeat.o(102344);
            return false;
        }
        AppMethodBeat.o(102344);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102345);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102345);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102345);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102346);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102346);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102346);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102347);
        jceOutputStream.write((JceStruct) this.head, 0);
        if (this.body != null) {
            jceOutputStream.write(this.body, 1);
        }
        AppMethodBeat.o(102347);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102348);
        if (cache_head == null) {
            cache_head = new ReqHead();
        }
        this.head = (ReqHead) jceInputStream.read((JceStruct) cache_head, 0, true);
        if (cache_body == null) {
            byte[] bArr = new byte[1];
            cache_body = bArr;
            bArr[0] = 0;
        }
        this.body = jceInputStream.read(cache_body, 1, false);
        AppMethodBeat.o(102348);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102349);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display((JceStruct) this.head, "head");
        jceDisplayer.display(this.body, "body");
        AppMethodBeat.o(102349);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102350);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple((JceStruct) this.head, true);
        jceDisplayer.displaySimple(this.body, false);
        AppMethodBeat.o(102350);
    }
}
