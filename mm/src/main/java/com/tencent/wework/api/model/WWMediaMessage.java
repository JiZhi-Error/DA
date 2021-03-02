package com.tencent.wework.api.model;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WWMediaMessage extends WWBaseMessage {
    public String description;
    public byte[] thumbData;
    public String title;

    @Override // com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public void toBundle(Bundle bundle) {
        AppMethodBeat.i(106550);
        super.toBundle(bundle);
        bundle.putString("_wwobject_title", this.title);
        bundle.putString("_wwobject_description", this.description);
        bundle.putByteArray("_wwobject_thumbdata", this.thumbData);
        AppMethodBeat.o(106550);
    }

    @Override // com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public void fromBundle(Bundle bundle) {
        AppMethodBeat.i(199013);
        super.fromBundle(bundle);
        this.title = bundle.getString("_wwobject_title");
        this.description = bundle.getString("_wwobject_description");
        this.thumbData = bundle.getByteArray("_wwobject_thumbdata");
        AppMethodBeat.o(199013);
    }

    public final void setThumbImage(Bitmap bitmap) {
        AppMethodBeat.i(106551);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            AppMethodBeat.o(106551);
        } catch (Exception e2) {
            AppMethodBeat.o(106551);
        }
    }

    @Override // com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public boolean checkArgs() {
        AppMethodBeat.i(106552);
        if (this.thumbData != null && this.thumbData.length > 32768) {
            AppMethodBeat.o(106552);
            return false;
        } else if (this.title != null && this.title.length() > 512) {
            AppMethodBeat.o(106552);
            return false;
        } else if (this.description == null || this.description.length() <= 1024) {
            AppMethodBeat.o(106552);
            return true;
        } else {
            AppMethodBeat.o(106552);
            return false;
        }
    }

    public static abstract class WWMediaObject extends WWMediaMessage {
        protected static int getFileSize(String str) {
            if (!(str == null || str.length() == 0)) {
                File file = new File(str);
                if (file.exists()) {
                    return (int) file.length();
                }
            }
            return 0;
        }
    }
}
