package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class Response extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Response.class.desiredAssertionStatus());
    private static final String TAG = "Response";
    static byte[] cache_body;
    static RspHead cache_head;
    public byte[] body = null;
    public RspHead head = null;

    static {
        AppMethodBeat.i(102359);
        AppMethodBeat.o(102359);
    }

    public final String className() {
        return "jce.Response";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final RspHead getHead() {
        return this.head;
    }

    public final void setHead(RspHead rspHead) {
        this.head = rspHead;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public Response() {
    }

    public Response(RspHead rspHead, byte[] bArr) {
        this.head = rspHead;
        this.body = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102352);
        if (obj == null) {
            AppMethodBeat.o(102352);
            return false;
        }
        Response response = (Response) obj;
        if (!JceUtil.equals(this.head, response.head) || !JceUtil.equals(this.body, response.body)) {
            AppMethodBeat.o(102352);
            return false;
        }
        AppMethodBeat.o(102352);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102353);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102353);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102353);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102354);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102354);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102354);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102355);
        jceOutputStream.write((JceStruct) this.head, 0);
        jceOutputStream.write(this.body, 1);
        AppMethodBeat.o(102355);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102356);
        if (cache_head == null) {
            cache_head = new RspHead();
        }
        this.head = (RspHead) jceInputStream.read((JceStruct) cache_head, 0, true);
        if (cache_body == null) {
            byte[] bArr = new byte[1];
            cache_body = bArr;
            bArr[0] = 0;
        }
        this.body = jceInputStream.read(cache_body, 1, true);
        AppMethodBeat.o(102356);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102357);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display((JceStruct) this.head, "head");
        jceDisplayer.display(this.body, "body");
        AppMethodBeat.o(102357);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102358);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple((JceStruct) this.head, true);
        jceDisplayer.displaySimple(this.body, false);
        AppMethodBeat.o(102358);
    }
}
