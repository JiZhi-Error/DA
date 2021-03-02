package com.tencent.mm.plugin.emoji.h;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.ce.f;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class b {
    public static int bt(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return EmojiInfo.VkM;
        }
        if (bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
            return EmojiInfo.VkX;
        }
        if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            return EmojiInfo.VkY;
        }
        if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
            return EmojiInfo.VkZ;
        }
        return EmojiInfo.VkM;
    }

    public static String aTd() {
        AppMethodBeat.i(261730);
        a aVar = a.hdT;
        String awt = a.awt();
        AppMethodBeat.o(261730);
        return awt;
    }

    public static void a(String str, JSONObject jSONObject, EmojiInfo emojiInfo) {
        AppMethodBeat.i(199786);
        try {
            if (Util.isNullOrNil(emojiInfo.field_md5) || emojiInfo.field_md5.equals(jSONObject.getString("md5"))) {
                emojiInfo.field_md5 = fX(jSONObject.optString("md5", ""), emojiInfo.field_md5);
                emojiInfo.field_cdnUrl = fX(jSONObject.optString("productUrl", ""), emojiInfo.field_cdnUrl);
                emojiInfo.field_thumbUrl = fX(jSONObject.optString("thumb", ""), emojiInfo.field_thumbUrl);
                emojiInfo.field_encrypturl = fX(jSONObject.optString("encryptUrl", ""), emojiInfo.field_encrypturl);
                emojiInfo.field_aeskey = fX(jSONObject.optString("aesKey", ""), emojiInfo.field_aeskey);
                emojiInfo.field_groupId = fX(jSONObject.optString("productID", ""), emojiInfo.field_groupId);
                emojiInfo.Vlm = fX(jSONObject.optString("productName", ""), emojiInfo.Vlm);
                emojiInfo.field_catalog = EmojiInfo.VkQ;
                if (com.tencent.matrix.trace.g.b.eP(emojiInfo.field_cdnUrl) && com.tencent.matrix.trace.g.b.eP(emojiInfo.field_aeskey)) {
                    emojiInfo.field_cdnUrl = emojiInfo.field_encrypturl;
                }
                AppMethodBeat.o(199786);
                return;
            }
            AppMethodBeat.o(199786);
        } catch (Exception e2) {
            Log.printErrStackTrace(str, e2, "convertEmojiInfo", new Object[0]);
            AppMethodBeat.o(199786);
        }
    }

    public static void a(ait ait, EmojiInfo emojiInfo) {
        AppMethodBeat.i(104577);
        if (Util.isNullOrNil(emojiInfo.field_md5) || emojiInfo.field_md5.equals(ait.Md5)) {
            emojiInfo.field_md5 = fX(ait.Md5, emojiInfo.field_md5);
            emojiInfo.field_cdnUrl = fX(ait.Url, emojiInfo.field_cdnUrl);
            emojiInfo.field_thumbUrl = fX(ait.ThumbUrl, emojiInfo.field_thumbUrl);
            emojiInfo.field_designerID = fX(ait.Lsl, emojiInfo.field_designerID);
            emojiInfo.field_encrypturl = fX(ait.EncryptUrl, emojiInfo.field_encrypturl);
            emojiInfo.field_aeskey = fX(ait.AesKey, emojiInfo.field_aeskey);
            emojiInfo.field_groupId = fX(ait.ProductID, emojiInfo.field_groupId);
            emojiInfo.field_externUrl = fX(ait.ExternUrl, emojiInfo.field_externUrl);
            emojiInfo.field_externMd5 = fX(ait.ExternMd5, emojiInfo.field_externMd5);
            emojiInfo.field_activityid = fX(ait.ActivityID, emojiInfo.field_activityid);
            emojiInfo.field_attachedText = fX(ait.Lsm, emojiInfo.field_attachedText);
            emojiInfo.field_attachTextColor = fX(ait.Lsn, emojiInfo.field_attachTextColor);
            emojiInfo.field_lensId = fX(ait.Lso, emojiInfo.field_lensId);
            AppMethodBeat.o(104577);
            return;
        }
        AppMethodBeat.o(104577);
    }

    public static void b(bi biVar, EmojiInfo emojiInfo) {
        boolean z = true;
        AppMethodBeat.i(162344);
        emojiInfo.field_md5 = fX(biVar.md5, emojiInfo.field_md5);
        emojiInfo.field_svrid = fX(biVar.id, emojiInfo.field_svrid);
        emojiInfo.field_type = biVar.OpC;
        emojiInfo.field_size = biVar.OpD;
        emojiInfo.field_groupId = fX(biVar.productId, emojiInfo.field_groupId);
        emojiInfo.field_designerID = fX(biVar.OpH, emojiInfo.field_designerID);
        emojiInfo.field_thumbUrl = fX(biVar.thumbUrl, emojiInfo.field_thumbUrl);
        emojiInfo.field_cdnUrl = fX(biVar.pkK, emojiInfo.field_cdnUrl);
        emojiInfo.field_encrypturl = fX(biVar.dKK, emojiInfo.field_encrypturl);
        emojiInfo.field_width = biVar.width;
        emojiInfo.field_height = biVar.height;
        emojiInfo.field_externUrl = fX(biVar.OpI, emojiInfo.field_externUrl);
        emojiInfo.field_externMd5 = fX(biVar.OpJ, emojiInfo.field_externMd5);
        emojiInfo.field_activityid = fX(biVar.OpL, emojiInfo.field_activityid);
        emojiInfo.field_tpurl = fX(biVar.iwN, emojiInfo.field_tpurl);
        emojiInfo.field_tpauthkey = fX(biVar.iwT, emojiInfo.field_tpauthkey);
        boolean z2 = !Util.isNullOrNil(emojiInfo.field_externUrl) || !Util.isNullOrNil(emojiInfo.field_encrypturl) || !Util.isNullOrNil(emojiInfo.field_cdnUrl);
        if (Util.isNullOrNil(biVar.iwN)) {
            z = false;
        }
        if (!z || !z2) {
            emojiInfo.field_aeskey = fX(biVar.aeskey, emojiInfo.field_aeskey);
        }
        emojiInfo.field_attachedText = fX(biVar.gXx, emojiInfo.field_attachedText);
        emojiInfo.field_lensId = fX(biVar.rnS, emojiInfo.field_lensId);
        emojiInfo.field_attachTextColor = fX(biVar.OpM, emojiInfo.field_attachTextColor);
        AppMethodBeat.o(162344);
    }

    public static void a(ait ait, EmojiInfo emojiInfo, String str) {
        AppMethodBeat.i(199787);
        a(ait, emojiInfo);
        emojiInfo.MOK = str;
        AppMethodBeat.o(199787);
    }

    public static String fX(String str, String str2) {
        AppMethodBeat.i(104578);
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(104578);
            return str;
        } else if (str2 == null) {
            AppMethodBeat.o(104578);
            return "";
        } else {
            AppMethodBeat.o(104578);
            return str2;
        }
    }

    public static boolean w(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104579);
        if (emojiInfo == null || !anh(emojiInfo.field_groupId)) {
            AppMethodBeat.o(104579);
            return false;
        }
        AppMethodBeat.o(104579);
        return true;
    }

    public static boolean anh(String str) {
        AppMethodBeat.i(104580);
        if (Util.isNullOrNil(str) || Util.isEqual(str, "capture") || Util.isEqual(str, new StringBuilder().append(EmojiGroupInfo.VkN).toString())) {
            AppMethodBeat.o(104580);
            return false;
        }
        AppMethodBeat.o(104580);
        return true;
    }

    public static boolean z(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104582);
        if (emojiInfo == null) {
            AppMethodBeat.o(104582);
            return false;
        } else if (!n.avi()) {
            AppMethodBeat.o(104582);
            return false;
        } else if (y(emojiInfo) || (emojiInfo.field_activityid != null && emojiInfo.field_activityid.startsWith("Selfie"))) {
            AppMethodBeat.o(104582);
            return true;
        } else {
            AppMethodBeat.o(104582);
            return false;
        }
    }

    public static boolean ani(String str) {
        AppMethodBeat.i(104583);
        if (Util.isNullOrNil(str) || Util.isEqual(str, "capture")) {
            AppMethodBeat.o(104583);
            return false;
        }
        AppMethodBeat.o(104583);
        return true;
    }

    /* renamed from: com.tencent.mm.plugin.emoji.h.b$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] rnE = new int[EmojiInfo.b.values().length];

        static {
            AppMethodBeat.i(104574);
            try {
                rnE[EmojiInfo.b.ERR_NON_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rnE[EmojiInfo.b.ERR_WIFI_NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                rnE[EmojiInfo.b.ERR_MOBILE_NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                rnE[EmojiInfo.b.ERR_NOT_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                rnE[EmojiInfo.b.ERR_OTHERS.ordinal()] = 5;
                AppMethodBeat.o(104574);
            } catch (NoSuchFieldError e6) {
                AppMethodBeat.o(104574);
            }
        }
    }

    public static String anj(String str) {
        AppMethodBeat.i(199788);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(199788);
            return null;
        }
        f.a big = f.gxT().big(str);
        if (big != null && Util.isEqual(big.text, str)) {
            String str2 = big.key;
            AppMethodBeat.o(199788);
            return str2;
        } else if (e.gxR().containsKey(str)) {
            AppMethodBeat.o(199788);
            return str;
        } else {
            AppMethodBeat.o(199788);
            return null;
        }
    }

    public static Drawable bxs(String str) {
        AppMethodBeat.i(261731);
        e.gxR();
        Drawable bid = e.bid(str);
        AppMethodBeat.o(261731);
        return bid;
    }

    public static boolean x(EmojiInfo emojiInfo) {
        AppMethodBeat.i(183923);
        if (emojiInfo.field_catalog == EmojiInfo.VkW) {
            AppMethodBeat.o(183923);
            return true;
        }
        ArrayList<EmojiInfo> dT = j.auL().dT(true);
        if (dT == null) {
            AppMethodBeat.o(183923);
            return false;
        }
        Iterator<EmojiInfo> it = dT.iterator();
        while (it.hasNext()) {
            if (Util.isEqual(it.next().field_md5, emojiInfo.field_md5)) {
                AppMethodBeat.o(183923);
                return true;
            }
        }
        AppMethodBeat.o(183923);
        return false;
    }

    public static boolean y(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104581);
        boolean isEqual = Util.isEqual(emojiInfo.field_groupId, "capture");
        AppMethodBeat.o(104581);
        return isEqual;
    }
}
