package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppDetailParam extends JceStruct {
    public byte actionFlag = 0;
    public long apkId = 0;
    public int apkVersionCode = 0;
    public long appId = 0;
    public byte appType = 1;
    public byte authPlatform = 0;
    public String channelId = "";
    public int grayVersionCode = 0;
    public String manifestMd5 = "";
    public String packageName = "";
    public String signatureMd5 = "";
    public String token = "";
    public String verifyAppId = "";
    public byte verifyType = 0;
    public int versionCode = 0;

    public AppDetailParam() {
    }

    public AppDetailParam(long j2, String str, String str2, int i2, String str3, byte b2, long j3, int i3, String str4, byte b3, int i4, String str5, byte b4, byte b5, String str6) {
        this.appId = j2;
        this.packageName = str;
        this.signatureMd5 = str2;
        this.versionCode = i2;
        this.manifestMd5 = str3;
        this.appType = b2;
        this.apkId = j3;
        this.apkVersionCode = i3;
        this.channelId = str4;
        this.actionFlag = b3;
        this.grayVersionCode = i4;
        this.token = str5;
        this.verifyType = b4;
        this.authPlatform = b5;
        this.verifyAppId = str6;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102276);
        jceOutputStream.write(this.appId, 0);
        if (this.packageName != null) {
            jceOutputStream.write(this.packageName, 1);
        }
        if (this.signatureMd5 != null) {
            jceOutputStream.write(this.signatureMd5, 2);
        }
        jceOutputStream.write(this.versionCode, 3);
        if (this.manifestMd5 != null) {
            jceOutputStream.write(this.manifestMd5, 4);
        }
        jceOutputStream.write(this.appType, 5);
        jceOutputStream.write(this.apkId, 6);
        jceOutputStream.write(this.apkVersionCode, 7);
        if (this.channelId != null) {
            jceOutputStream.write(this.channelId, 8);
        }
        jceOutputStream.write(this.actionFlag, 9);
        jceOutputStream.write(this.grayVersionCode, 10);
        if (this.token != null) {
            jceOutputStream.write(this.token, 11);
        }
        jceOutputStream.write(this.verifyType, 12);
        jceOutputStream.write(this.authPlatform, 13);
        if (this.verifyAppId != null) {
            jceOutputStream.write(this.verifyAppId, 14);
        }
        AppMethodBeat.o(102276);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102277);
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.packageName = jceInputStream.readString(1, false);
        this.signatureMd5 = jceInputStream.readString(2, false);
        this.versionCode = jceInputStream.read(this.versionCode, 3, false);
        this.manifestMd5 = jceInputStream.readString(4, false);
        this.appType = jceInputStream.read(this.appType, 5, false);
        this.apkId = jceInputStream.read(this.apkId, 6, false);
        this.apkVersionCode = jceInputStream.read(this.apkVersionCode, 7, false);
        this.channelId = jceInputStream.readString(8, false);
        this.actionFlag = jceInputStream.read(this.actionFlag, 9, false);
        this.grayVersionCode = jceInputStream.read(this.grayVersionCode, 10, false);
        this.token = jceInputStream.readString(11, false);
        this.verifyType = jceInputStream.read(this.verifyType, 12, false);
        this.authPlatform = jceInputStream.read(this.authPlatform, 13, false);
        this.verifyAppId = jceInputStream.readString(14, false);
        AppMethodBeat.o(102277);
    }
}
