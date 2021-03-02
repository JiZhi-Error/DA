package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class UpdateInfoLog extends JceStruct {
    public int actionCode = 0;
    public long appid = 0;
    public String extra = "";
    public String packageName = "";
    public byte updateType = 0;
    public byte yybExistFlag = 0;

    public UpdateInfoLog() {
    }

    public UpdateInfoLog(byte b2, String str, long j2, int i2, byte b3, String str2) {
        this.updateType = b2;
        this.packageName = str;
        this.appid = j2;
        this.actionCode = i2;
        this.yybExistFlag = b3;
        this.extra = str2;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102404);
        jceOutputStream.write(this.updateType, 0);
        jceOutputStream.write(this.packageName, 1);
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.actionCode, 3);
        jceOutputStream.write(this.yybExistFlag, 4);
        if (this.extra != null) {
            jceOutputStream.write(this.extra, 5);
        }
        AppMethodBeat.o(102404);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102405);
        this.updateType = jceInputStream.read(this.updateType, 0, true);
        this.packageName = jceInputStream.readString(1, true);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.actionCode = jceInputStream.read(this.actionCode, 3, true);
        this.yybExistFlag = jceInputStream.read(this.yybExistFlag, 4, false);
        this.extra = jceInputStream.readString(5, false);
        AppMethodBeat.o(102405);
    }
}
