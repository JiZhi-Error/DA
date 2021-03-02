package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;

public class WXImageObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 26214400;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    public byte[] imageData;
    public String imagePath;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap bitmap) {
        AppMethodBeat.i(3986);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            AppMethodBeat.o(3986);
        } catch (Exception e2) {
            Log.e(TAG, "WXImageObject <init>, exception:" + e2.getMessage());
            AppMethodBeat.o(3986);
        }
    }

    public WXImageObject(byte[] bArr) {
        AppMethodBeat.i(190359);
        this.imageData = bArr;
        AppMethodBeat.o(190359);
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(3990);
        int a2 = b.a(str);
        AppMethodBeat.o(3990);
        return a2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        AppMethodBeat.i(3989);
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && ((str = this.imagePath) == null || str.length() == 0)) {
            Log.e(TAG, "checkArgs fail, all arguments are null");
            AppMethodBeat.o(3989);
            return false;
        }
        byte[] bArr2 = this.imageData;
        if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
            String str2 = this.imagePath;
            if (str2 == null || str2.length() <= 10240) {
                String str3 = this.imagePath;
                if (str3 == null || getFileSize(str3) <= CONTENT_LENGTH_LIMIT) {
                    AppMethodBeat.o(3989);
                    return true;
                }
                Log.e(TAG, "checkArgs fail, image content is too large");
                AppMethodBeat.o(3989);
                return false;
            }
            Log.e(TAG, "checkArgs fail, path is invalid");
            AppMethodBeat.o(3989);
            return false;
        }
        Log.e(TAG, "checkArgs fail, content is too large");
        AppMethodBeat.o(3989);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3987);
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        AppMethodBeat.o(3987);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3988);
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        AppMethodBeat.o(3988);
    }
}
