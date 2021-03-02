package com.tencent.wework.api.model;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage;
import com.tencent.wework.api.util.OpenDataUtils;

public class WWMediaFile extends WWMediaMessage.WWMediaObject {
    private int contentLengthLimit = 104857600;
    public byte[] fileData;
    public String fileId;
    public String fileName;
    public String filePath;

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final boolean checkArgs() {
        AppMethodBeat.i(106540);
        if (!super.checkArgs()) {
            AppMethodBeat.o(106540);
            return false;
        } else if ((this.fileData == null || this.fileData.length == 0) && (this.filePath == null || this.filePath.length() == 0)) {
            AppMethodBeat.o(106540);
            return false;
        } else if (this.fileData != null && this.fileData.length > this.contentLengthLimit) {
            AppMethodBeat.o(106540);
            return false;
        } else if (this.filePath == null || getFileSize(this.filePath) <= this.contentLengthLimit) {
            AppMethodBeat.o(106540);
            return true;
        } else {
            AppMethodBeat.o(106540);
            return false;
        }
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(106541);
        bundle.putByteArray("_wwfileobject_fileData", this.fileData);
        bundle.putString("_wwfileobject_filePath", this.filePath);
        bundle.putString("_wwfileobject_fileName", this.fileName);
        if (this.filePath == null || !this.filePath.startsWith("content")) {
            this.fileId = OpenDataUtils.aa(this.mContext, this.Sxs, this.filePath);
        } else {
            this.fileId = null;
        }
        bundle.putString("_wwfileobject_fileId", this.fileId);
        super.toBundle(bundle);
        AppMethodBeat.o(106541);
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(199005);
        this.fileData = bundle.getByteArray("_wwfileobject_fileData");
        this.filePath = bundle.getString("_wwfileobject_filePath");
        this.fileName = bundle.getString("_wwfileobject_fileName");
        this.fileId = bundle.getString("_wwfileobject_fileId");
        super.fromBundle(bundle);
        AppMethodBeat.o(199005);
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public final void v(Intent intent, String str) {
        AppMethodBeat.i(199006);
        if (this.filePath != null && this.filePath.startsWith("content")) {
            if (intent.getClipData() == null) {
                intent.setClipData(new ClipData("", new String[]{"*/*"}, new ClipData.Item(Uri.parse(this.filePath))));
            } else {
                intent.getClipData().addItem(new ClipData.Item(Uri.parse(this.filePath)));
            }
            intent.addFlags(1);
            this.fileId = null;
        }
        AppMethodBeat.o(199006);
    }

    public final void setContentLengthLimit(int i2) {
        this.contentLengthLimit = i2;
    }
}
