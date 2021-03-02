package com.tencent.matrix.mrs.core;

import com.tencent.mm.sdk.platformtools.Util;

public class MatrixUploadIssue {
    public static final int DATA_TYPE_BYTE = 0;
    public static final int DATA_TYPE_FILE = 1;
    private byte[] byteData = null;
    private boolean canSplitSlice = false;
    private int dataType = 0;
    private String desKey = "";
    private String filePath = "";
    private long id = Util.nowMilliSecond();
    private boolean needDeleteFileAfterSucc = false;
    private String tag = "";
    private int type = 0;

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public String getDesKey() {
        return this.desKey;
    }

    public void setDesKey(String str) {
        this.desKey = str;
    }

    public boolean getCanSplitSlice() {
        return this.canSplitSlice;
    }

    public void setCanSplitSlice(boolean z) {
        this.canSplitSlice = z;
    }

    public int getDataType() {
        return this.dataType;
    }

    public void setDataType(int i2) {
        this.dataType = i2;
    }

    public byte[] getByteData() {
        return this.byteData;
    }

    public void setByteData(byte[] bArr) {
        this.byteData = bArr;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public boolean isNeedDeleteFileAfterSucc() {
        return this.needDeleteFileAfterSucc;
    }

    public void setNeedDeleteFileAfterSucc(boolean z) {
        this.needDeleteFileAfterSucc = z;
    }

    public long getId() {
        return this.id;
    }
}
