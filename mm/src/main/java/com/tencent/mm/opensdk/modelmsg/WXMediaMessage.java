package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 65536;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    public static class Builder {
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

        public static WXMediaMessage fromBundle(Bundle bundle) {
            AppMethodBeat.i(4029);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
            wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
            String pathOldToNew = pathOldToNew(bundle.getString(KEY_IDENTIFIER));
            if (pathOldToNew == null || pathOldToNew.length() <= 0) {
                AppMethodBeat.o(4029);
                return wXMediaMessage;
            }
            try {
                IMediaObject iMediaObject = (IMediaObject) Class.forName(pathOldToNew).newInstance();
                wXMediaMessage.mediaObject = iMediaObject;
                iMediaObject.unserialize(bundle);
                AppMethodBeat.o(4029);
                return wXMediaMessage;
            } catch (Exception e2) {
                Log.e(WXMediaMessage.TAG, "get media object from bundle failed: unknown ident " + pathOldToNew + ", ex = " + e2.getMessage());
                AppMethodBeat.o(4029);
                return wXMediaMessage;
            }
        }

        private static String pathNewToOld(String str) {
            AppMethodBeat.i(4030);
            if (str == null || str.length() == 0) {
                Log.e(WXMediaMessage.TAG, "pathNewToOld fail, newPath is null");
                AppMethodBeat.o(4030);
                return str;
            }
            String replace = str.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
            AppMethodBeat.o(4030);
            return replace;
        }

        private static String pathOldToNew(String str) {
            AppMethodBeat.i(4031);
            Log.i(WXMediaMessage.TAG, "pathOldToNew, oldPath = ".concat(String.valueOf(str)));
            if (str == null || str.length() == 0) {
                Log.e(WXMediaMessage.TAG, "pathOldToNew fail, oldPath is null");
                AppMethodBeat.o(4031);
                return str;
            }
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                Log.e(WXMediaMessage.TAG, "pathOldToNew fail, invalid pos, oldPath = ".concat(String.valueOf(str)));
                AppMethodBeat.o(4031);
                return str;
            }
            String str2 = "com.tencent.mm.opensdk.modelmsg" + str.substring(lastIndexOf);
            AppMethodBeat.o(4031);
            return str2;
        }

        public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
            AppMethodBeat.i(4028);
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            IMediaObject iMediaObject = wXMediaMessage.mediaObject;
            if (iMediaObject != null) {
                bundle.putString(KEY_IDENTIFIER, pathNewToOld(iMediaObject.getClass().getName()));
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
            bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
            AppMethodBeat.o(4028);
            return bundle;
        }
    }

    public interface IMediaObject {
        public static final int TYPE_APPBRAND = 33;
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_BUSINESS_CARD = 45;
        public static final int TYPE_CARD_SHARE = 16;
        public static final int TYPE_DESIGNER_SHARED = 25;
        public static final int TYPE_DEVICE_ACCESS = 12;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_EMOJILIST_SHARED = 27;
        public static final int TYPE_EMOTICON_GIFT = 11;
        public static final int TYPE_EMOTICON_SHARED = 15;
        public static final int TYPE_EMOTIONLIST_SHARED = 26;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_GAME_VIDEO_FILE = 39;
        public static final int TYPE_GIFTCARD = 34;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_LOCATION = 30;
        public static final int TYPE_LOCATION_SHARE = 17;
        public static final int TYPE_MALL_PRODUCT = 13;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_MUSIC_VIDEO = 76;
        public static final int TYPE_NOTE = 24;
        public static final int TYPE_OLD_TV = 14;
        public static final int TYPE_OPENSDK_APPBRAND = 36;
        public static final int TYPE_OPENSDK_APPBRAND_WEISHIVIDEO = 46;
        public static final int TYPE_OPENSDK_LITEAPP = 68;
        public static final int TYPE_OPENSDK_WEWORK_OBJECT = 49;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_RECORD = 19;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_TV = 20;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;
        public static final int TYPE_VIDEO_FILE = 38;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        AppMethodBeat.i(190415);
        this.mediaObject = iMediaObject;
        AppMethodBeat.o(190415);
    }

    /* access modifiers changed from: package-private */
    public final boolean checkArgs() {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        AppMethodBeat.i(3993);
        if (getType() == 8 && ((bArr3 = this.thumbData) == null || bArr3.length == 0)) {
            Log.e(TAG, "checkArgs fail, thumbData should not be null when send emoji");
            AppMethodBeat.o(3993);
            return false;
        } else if (getType() == 76 && b.b(this.title)) {
            Log.e(TAG, "checkArgs fail, Type = Music Video, but title == null");
            AppMethodBeat.o(3993);
            return false;
        } else if (b.a(getType()) && ((bArr2 = this.thumbData) == null || bArr2.length > 131072)) {
            Log.e(TAG, "checkArgs fail, thumbData should not be null or exceed 128kb");
            AppMethodBeat.o(3993);
            return false;
        } else if (b.a(getType()) || (bArr = this.thumbData) == null || bArr.length <= 65536) {
            String str = this.title;
            if (str == null || str.length() <= 512) {
                String str2 = this.description;
                if (str2 != null && str2.length() > 1024) {
                    Log.e(TAG, "checkArgs fail, description is invalid");
                    AppMethodBeat.o(3993);
                    return false;
                } else if (this.mediaObject == null) {
                    Log.e(TAG, "checkArgs fail, mediaObject is null");
                    AppMethodBeat.o(3993);
                    return false;
                } else {
                    String str3 = this.mediaTagName;
                    if (str3 == null || str3.length() <= 64) {
                        String str4 = this.messageAction;
                        if (str4 == null || str4.length() <= 2048) {
                            String str5 = this.messageExt;
                            if (str5 == null || str5.length() <= 2048) {
                                boolean checkArgs = this.mediaObject.checkArgs();
                                AppMethodBeat.o(3993);
                                return checkArgs;
                            }
                            Log.e(TAG, "checkArgs fail, messageExt is too long");
                            AppMethodBeat.o(3993);
                            return false;
                        }
                        Log.e(TAG, "checkArgs fail, messageAction is too long");
                        AppMethodBeat.o(3993);
                        return false;
                    }
                    Log.e(TAG, "checkArgs fail, mediaTagName is too long");
                    AppMethodBeat.o(3993);
                    return false;
                }
            } else {
                Log.e(TAG, "checkArgs fail, title is invalid");
                AppMethodBeat.o(3993);
                return false;
            }
        } else {
            Log.e(TAG, "checkArgs fail, thumbData is invalid");
            AppMethodBeat.o(3993);
            return false;
        }
    }

    public final int getType() {
        AppMethodBeat.i(3991);
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            AppMethodBeat.o(3991);
            return 0;
        }
        int type = iMediaObject.type();
        AppMethodBeat.o(3991);
        return type;
    }

    public final void setThumbImage(Bitmap bitmap) {
        AppMethodBeat.i(3992);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            AppMethodBeat.o(3992);
        } catch (Exception e2) {
            Log.e(TAG, "setThumbImage exception:" + e2.getMessage());
            AppMethodBeat.o(3992);
        }
    }
}
