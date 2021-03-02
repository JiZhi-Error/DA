package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public final class DownloadChunkLogInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!DownloadChunkLogInfo.class.desiredAssertionStatus());
    private static final String TAG = "DownloadChunkLogInfo";
    public String UUID = "";
    public String appId = "";
    public byte currentRetryCnt = 0;
    public long endTime = 0;
    public int errorCode = 0;
    public String flag = "";
    public byte isWap = 0;
    public String networkOperator = "";
    public int networkType = 0;
    public long readHeaderTime = 0;
    public long receiveDataSize = 0;
    public long requestRanagePosition = 0;
    public long requestRanageSize = 0;
    public String requestUrl = "";
    public long responseContentLength = 0;
    public int responseHttpCode = 0;
    public long responseRangeLength = 0;
    public long responseRangePosition = 0;
    public int resultState = 0;
    public long startTime = 0;
    public byte type = 0;
    public String via = "";

    static {
        AppMethodBeat.i(102287);
        AppMethodBeat.o(102287);
    }

    public final String className() {
        return "jce.DownloadChunkLogInfo";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final String getUUID() {
        return this.UUID;
    }

    public final void setUUID(String str) {
        this.UUID = str;
    }

    public final byte getType() {
        return this.type;
    }

    public final void setType(byte b2) {
        this.type = b2;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final void setRequestUrl(String str) {
        this.requestUrl = str;
    }

    public final String getNetworkOperator() {
        return this.networkOperator;
    }

    public final void setNetworkOperator(String str) {
        this.networkOperator = str;
    }

    public final int getNetworkType() {
        return this.networkType;
    }

    public final void setNetworkType(int i2) {
        this.networkType = i2;
    }

    public final byte getIsWap() {
        return this.isWap;
    }

    public final void setIsWap(byte b2) {
        this.isWap = b2;
    }

    public final long getRequestRanagePosition() {
        return this.requestRanagePosition;
    }

    public final void setRequestRanagePosition(long j2) {
        this.requestRanagePosition = j2;
    }

    public final long getRequestRanageSize() {
        return this.requestRanageSize;
    }

    public final void setRequestRanageSize(long j2) {
        this.requestRanageSize = j2;
    }

    public final long getResponseRangePosition() {
        return this.responseRangePosition;
    }

    public final void setResponseRangePosition(long j2) {
        this.responseRangePosition = j2;
    }

    public final long getResponseRangeLength() {
        return this.responseRangeLength;
    }

    public final void setResponseRangeLength(long j2) {
        this.responseRangeLength = j2;
    }

    public final long getResponseContentLength() {
        return this.responseContentLength;
    }

    public final void setResponseContentLength(long j2) {
        this.responseContentLength = j2;
    }

    public final int getResponseHttpCode() {
        return this.responseHttpCode;
    }

    public final void setResponseHttpCode(int i2) {
        this.responseHttpCode = i2;
    }

    public final long getReceiveDataSize() {
        return this.receiveDataSize;
    }

    public final void setReceiveDataSize(long j2) {
        this.receiveDataSize = j2;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j2) {
        this.startTime = j2;
    }

    public final long getReadHeaderTime() {
        return this.readHeaderTime;
    }

    public final void setReadHeaderTime(long j2) {
        this.readHeaderTime = j2;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j2) {
        this.endTime = j2;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public final int getResultState() {
        return this.resultState;
    }

    public final void setResultState(int i2) {
        this.resultState = i2;
    }

    public final byte getCurrentRetryCnt() {
        return this.currentRetryCnt;
    }

    public final void setCurrentRetryCnt(byte b2) {
        this.currentRetryCnt = b2;
    }

    public final String getVia() {
        return this.via;
    }

    public final void setVia(String str) {
        this.via = str;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final String getFlag() {
        return this.flag;
    }

    public final void setFlag(String str) {
        this.flag = str;
    }

    public DownloadChunkLogInfo() {
    }

    public DownloadChunkLogInfo(String str, byte b2, String str2, String str3, int i2, byte b3, long j2, long j3, long j4, long j5, long j6, int i3, long j7, long j8, long j9, long j10, int i4, int i5, byte b4, String str4, String str5, String str6) {
        this.UUID = str;
        this.type = b2;
        this.requestUrl = str2;
        this.networkOperator = str3;
        this.networkType = i2;
        this.isWap = b3;
        this.requestRanagePosition = j2;
        this.requestRanageSize = j3;
        this.responseRangePosition = j4;
        this.responseRangeLength = j5;
        this.responseContentLength = j6;
        this.responseHttpCode = i3;
        this.receiveDataSize = j7;
        this.startTime = j8;
        this.readHeaderTime = j9;
        this.endTime = j10;
        this.errorCode = i4;
        this.resultState = i5;
        this.currentRetryCnt = b4;
        this.via = str4;
        this.appId = str5;
        this.flag = str6;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102280);
        if (obj == null) {
            AppMethodBeat.o(102280);
            return false;
        }
        DownloadChunkLogInfo downloadChunkLogInfo = (DownloadChunkLogInfo) obj;
        if (!JceUtil.equals(this.UUID, downloadChunkLogInfo.UUID) || !JceUtil.equals(this.type, downloadChunkLogInfo.type) || !JceUtil.equals(this.requestUrl, downloadChunkLogInfo.requestUrl) || !JceUtil.equals(this.networkOperator, downloadChunkLogInfo.networkOperator) || !JceUtil.equals(this.networkType, downloadChunkLogInfo.networkType) || !JceUtil.equals(this.isWap, downloadChunkLogInfo.isWap) || !JceUtil.equals(this.requestRanagePosition, downloadChunkLogInfo.requestRanagePosition) || !JceUtil.equals(this.requestRanageSize, downloadChunkLogInfo.requestRanageSize) || !JceUtil.equals(this.responseRangePosition, downloadChunkLogInfo.responseRangePosition) || !JceUtil.equals(this.responseRangeLength, downloadChunkLogInfo.responseRangeLength) || !JceUtil.equals(this.responseContentLength, downloadChunkLogInfo.responseContentLength) || !JceUtil.equals(this.responseHttpCode, downloadChunkLogInfo.responseHttpCode) || !JceUtil.equals(this.receiveDataSize, downloadChunkLogInfo.receiveDataSize) || !JceUtil.equals(this.startTime, downloadChunkLogInfo.startTime) || !JceUtil.equals(this.readHeaderTime, downloadChunkLogInfo.readHeaderTime) || !JceUtil.equals(this.endTime, downloadChunkLogInfo.endTime) || !JceUtil.equals(this.errorCode, downloadChunkLogInfo.errorCode) || !JceUtil.equals(this.resultState, downloadChunkLogInfo.resultState) || !JceUtil.equals(this.currentRetryCnt, downloadChunkLogInfo.currentRetryCnt) || !JceUtil.equals(this.via, downloadChunkLogInfo.via) || !JceUtil.equals(this.appId, downloadChunkLogInfo.appId) || !JceUtil.equals(this.flag, downloadChunkLogInfo.flag)) {
            AppMethodBeat.o(102280);
            return false;
        }
        AppMethodBeat.o(102280);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102281);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102281);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102281);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102282);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102282);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102282);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102283);
        if (this.UUID != null) {
            jceOutputStream.write(this.UUID, 0);
        }
        jceOutputStream.write(this.type, 1);
        if (this.requestUrl != null) {
            jceOutputStream.write(this.requestUrl, 2);
        }
        if (this.networkOperator != null) {
            jceOutputStream.write(this.networkOperator, 3);
        }
        jceOutputStream.write(this.networkType, 4);
        jceOutputStream.write(this.isWap, 5);
        jceOutputStream.write(this.requestRanagePosition, 6);
        jceOutputStream.write(this.requestRanageSize, 7);
        jceOutputStream.write(this.responseRangePosition, 9);
        jceOutputStream.write(this.responseRangeLength, 10);
        jceOutputStream.write(this.responseContentLength, 11);
        jceOutputStream.write(this.responseHttpCode, 12);
        jceOutputStream.write(this.receiveDataSize, 13);
        jceOutputStream.write(this.startTime, 14);
        jceOutputStream.write(this.readHeaderTime, 15);
        jceOutputStream.write(this.endTime, 16);
        jceOutputStream.write(this.errorCode, 17);
        jceOutputStream.write(this.resultState, 18);
        jceOutputStream.write(this.currentRetryCnt, 19);
        if (this.via != null) {
            jceOutputStream.write(this.via, 20);
        }
        if (this.appId != null) {
            jceOutputStream.write(this.appId, 21);
        }
        if (this.flag != null) {
            jceOutputStream.write(this.flag, 22);
        }
        AppMethodBeat.o(102283);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102284);
        this.UUID = jceInputStream.readString(0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.requestUrl = jceInputStream.readString(2, false);
        this.networkOperator = jceInputStream.readString(3, false);
        this.networkType = jceInputStream.read(this.networkType, 4, false);
        this.isWap = jceInputStream.read(this.isWap, 5, false);
        this.requestRanagePosition = jceInputStream.read(this.requestRanagePosition, 6, false);
        this.requestRanageSize = jceInputStream.read(this.requestRanageSize, 7, false);
        this.responseRangePosition = jceInputStream.read(this.responseRangePosition, 9, false);
        this.responseRangeLength = jceInputStream.read(this.responseRangeLength, 10, false);
        this.responseContentLength = jceInputStream.read(this.responseContentLength, 11, false);
        this.responseHttpCode = jceInputStream.read(this.responseHttpCode, 12, false);
        this.receiveDataSize = jceInputStream.read(this.receiveDataSize, 13, false);
        this.startTime = jceInputStream.read(this.startTime, 14, false);
        this.readHeaderTime = jceInputStream.read(this.readHeaderTime, 15, false);
        this.endTime = jceInputStream.read(this.endTime, 16, false);
        this.errorCode = jceInputStream.read(this.errorCode, 17, false);
        this.resultState = jceInputStream.read(this.resultState, 18, false);
        this.currentRetryCnt = jceInputStream.read(this.currentRetryCnt, 19, false);
        this.via = jceInputStream.readString(20, false);
        this.appId = jceInputStream.readString(21, false);
        this.flag = jceInputStream.readString(22, false);
        AppMethodBeat.o(102284);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102285);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.UUID, "UUID");
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.requestUrl, "requestUrl");
        jceDisplayer.display(this.networkOperator, "networkOperator");
        jceDisplayer.display(this.networkType, "networkType");
        jceDisplayer.display(this.isWap, "isWap");
        jceDisplayer.display(this.requestRanagePosition, "requestRanagePosition");
        jceDisplayer.display(this.requestRanageSize, "requestRanageSize");
        jceDisplayer.display(this.responseRangePosition, "responseRangePosition");
        jceDisplayer.display(this.responseRangeLength, "responseRangeLength");
        jceDisplayer.display(this.responseContentLength, "responseContentLength");
        jceDisplayer.display(this.responseHttpCode, "responseHttpCode");
        jceDisplayer.display(this.receiveDataSize, "receiveDataSize");
        jceDisplayer.display(this.startTime, "startTime");
        jceDisplayer.display(this.readHeaderTime, "readHeaderTime");
        jceDisplayer.display(this.endTime, "endTime");
        jceDisplayer.display(this.errorCode, OpenSDKTool4Assistant.EXTRA_ERROR_CODE);
        jceDisplayer.display(this.resultState, "resultState");
        jceDisplayer.display(this.currentRetryCnt, "currentRetryCnt");
        jceDisplayer.display(this.via, OpenSDKTool4Assistant.EXTRA_VIA);
        jceDisplayer.display(this.appId, "appId");
        jceDisplayer.display(this.flag, "flag");
        AppMethodBeat.o(102285);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102286);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple(this.UUID, true);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.requestUrl, true);
        jceDisplayer.displaySimple(this.networkOperator, true);
        jceDisplayer.displaySimple(this.networkType, true);
        jceDisplayer.displaySimple(this.isWap, true);
        jceDisplayer.displaySimple(this.requestRanagePosition, true);
        jceDisplayer.displaySimple(this.requestRanageSize, true);
        jceDisplayer.displaySimple(this.responseRangePosition, true);
        jceDisplayer.displaySimple(this.responseRangeLength, true);
        jceDisplayer.displaySimple(this.responseContentLength, true);
        jceDisplayer.displaySimple(this.responseHttpCode, true);
        jceDisplayer.displaySimple(this.receiveDataSize, true);
        jceDisplayer.displaySimple(this.startTime, true);
        jceDisplayer.displaySimple(this.readHeaderTime, true);
        jceDisplayer.displaySimple(this.endTime, true);
        jceDisplayer.displaySimple(this.errorCode, true);
        jceDisplayer.displaySimple(this.resultState, true);
        jceDisplayer.displaySimple(this.currentRetryCnt, true);
        jceDisplayer.displaySimple(this.via, true);
        jceDisplayer.displaySimple(this.appId, true);
        jceDisplayer.displaySimple(this.flag, false);
        AppMethodBeat.o(102286);
    }
}
