package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.b.p;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public class EmojiLogic {
    public static native boolean extractForeground(int[] iArr, int i2, int i3);

    public static native boolean gifToMMAni(byte[] bArr, PByteArray pByteArray, int i2);

    public static String amn(String str) {
        String str2 = null;
        AppMethodBeat.i(108546);
        if (!Util.isNullOrNil(str)) {
            int boW = (int) s.boW(str);
            if (boW > 0) {
                byte[] aW = s.aW(str, 0, boW);
                str2 = g.getMessageDigest(aW);
                if (!(str2 == null && aW == null)) {
                    a aVar = a.hdT;
                    s.f(a.awt() + str2, aW, aW.length);
                    if (ImgUtil.isGif(aW)) {
                        ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiStorageMgr().OpN.a(str2, "", EmojiInfo.VkQ, EmojiInfo.VkY, aW.length, "", "");
                    } else {
                        ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiStorageMgr().OpN.a(str2, "", EmojiInfo.VkQ, EmojiInfo.VkX, aW.length, "", "");
                    }
                }
                AppMethodBeat.o(108546);
            } else {
                AppMethodBeat.o(108546);
            }
        } else {
            AppMethodBeat.o(108546);
        }
        return str2;
    }

    public static String b(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(108547);
        if (wXMediaMessage.getType() != 8) {
            AppMethodBeat.o(108547);
            return null;
        }
        WXEmojiObject wXEmojiObject = (WXEmojiObject) wXMediaMessage.mediaObject;
        if (!Util.isNullOrNil(wXEmojiObject.emojiData)) {
            Log.d("MicroMsg.emoji.EmojiLogic", " fileData:" + wXEmojiObject.emojiData.length);
            String messageDigest = g.getMessageDigest(wXEmojiObject.emojiData);
            a(context, wXMediaMessage.thumbData, messageDigest, wXEmojiObject.emojiData, str);
            AppMethodBeat.o(108547);
            return messageDigest;
        } else if (!Util.isNullOrNil(wXEmojiObject.emojiPath)) {
            int boW = (int) s.boW(wXEmojiObject.emojiPath);
            if (boW > 0) {
                byte[] aW = s.aW(wXEmojiObject.emojiPath, 0, boW);
                String messageDigest2 = g.getMessageDigest(aW);
                a(context, wXMediaMessage.thumbData, messageDigest2, aW, str);
                AppMethodBeat.o(108547);
                return messageDigest2;
            }
            AppMethodBeat.o(108547);
            return null;
        } else {
            AppMethodBeat.o(108547);
            return null;
        }
    }

    private static void a(Context context, byte[] bArr, String str, byte[] bArr2, String str2) {
        EmojiInfo a2;
        AppMethodBeat.i(108548);
        if (str == null && bArr2 == null) {
            AppMethodBeat.o(108548);
            return;
        }
        a aVar = a.hdT;
        String awt = a.awt();
        s.f(awt + str, bArr2, bArr2.length);
        if (ImgUtil.isGif(bArr2)) {
            a2 = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiStorageMgr().OpN.a(str, "", EmojiInfo.VkQ, EmojiInfo.Vla, bArr2.length, str2, "");
        } else {
            a2 = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiStorageMgr().OpN.a(str, "", EmojiInfo.VkQ, EmojiInfo.Vlb, bArr2.length, str2, "");
        }
        a(bArr, str, awt, a2);
        AppMethodBeat.o(108548);
    }

    private static void a(byte[] bArr, String str, String str2, EmojiInfo emojiInfo) {
        Bitmap decodeByteArray;
        Bitmap bitmap;
        int i2;
        int i3;
        AppMethodBeat.i(176182);
        if (bArr == null) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(emojiInfo == null);
            Log.d("MicroMsg.emoji.EmojiLogic", "insertEmoji: thumb is null, emojiInfo is null ? %B", objArr);
            if (emojiInfo != null) {
                decodeByteArray = emojiInfo.hYk();
            } else {
                AppMethodBeat.o(176182);
                return;
            }
        } else {
            decodeByteArray = BitmapUtil.decodeByteArray(bArr);
        }
        if (decodeByteArray == null || (decodeByteArray.getWidth() <= 300 && decodeByteArray.getHeight() <= 300)) {
            bitmap = decodeByteArray;
        } else {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            Log.i("MicroMsg.emoji.EmojiLogic", "cpan app msg width:%d height:%d", Integer.valueOf(width), Integer.valueOf(height));
            if (width > height) {
                i3 = (int) ((((float) height) / ((float) width)) * 300.0f);
                i2 = 300;
            } else {
                i2 = (int) ((((float) width) / ((float) height)) * 300.0f);
                i3 = 300;
            }
            Log.i("MicroMsg.emoji.EmojiLogic", "cpan app msg new width:%d new height:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            bitmap = BitmapUtil.extractThumbNail(decodeByteArray, i3, i2, false, true);
        }
        if (bitmap != null) {
            try {
                if (bitmap.getByteCount() > 65536) {
                    BitmapUtil.saveBitmapToImage(bitmap, 80, Bitmap.CompressFormat.JPEG, str2 + str + "_thumb", true);
                    Log.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is over size. save as jpg. size :%d", Integer.valueOf(bitmap.getByteCount()));
                    AppMethodBeat.o(176182);
                    return;
                }
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, str2 + str + "_thumb", true);
                Log.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is in normal size. sav as png. size :%d", Integer.valueOf(bitmap.getByteCount()));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.emoji.EmojiLogic", e2, "insertEmoji Error", new Object[0]);
                AppMethodBeat.o(176182);
                return;
            }
        }
        AppMethodBeat.o(176182);
    }

    public static EmojiInfo a(String str, String str2, k kVar) {
        AppMethodBeat.i(108550);
        if (com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
            EmojiInfo H = H(str, 4, str2);
            if (H == null) {
                q.bcV().a(str2, (ImageView) null, e.h(str, str2, new Object[0]), kVar);
                Log.i("MicroMsg.emoji.EmojiLogic", "[cpan] get emoji info, try to load image:%s", str2);
            }
            AppMethodBeat.o(108550);
            return H;
        } else if (MMApplicationContext.getContext() == null) {
            AppMethodBeat.o(108550);
            return null;
        } else if (MMApplicationContext.getContext().getResources() == null) {
            AppMethodBeat.o(108550);
            return null;
        } else {
            new EmojiInfo().field_type = EmojiInfo.VkX;
            AppMethodBeat.o(108550);
            return null;
        }
    }

    public static EmojiInfo H(String str, int i2, String str2) {
        boolean z = false;
        AppMethodBeat.i(108551);
        if (TextUtils.isEmpty(str)) {
            Log.d("MicroMsg.emoji.EmojiLogic", "getIcon : productId is null.");
            AppMethodBeat.o(108551);
            return null;
        }
        EmojiInfo emojiInfo = new EmojiInfo();
        a aVar = a.hdT;
        String j2 = j(a.awt(), str, str2);
        if (s.YS(j2)) {
            o oVar = new o(j2);
            if (oVar.exists()) {
                if (oVar.length() < 1) {
                    oVar.delete();
                } else {
                    emojiInfo.field_type = b.bt(s.aW(j2, 0, 10));
                    z = true;
                }
            }
        }
        if (!z) {
            Log.d("MicroMsg.emoji.EmojiLogic", "banner icon does not exist. icon path :" + j2 + "...., icon type:" + i2);
            AppMethodBeat.o(108551);
            return null;
        }
        emojiInfo.field_md5 = ao(str, str2);
        emojiInfo.field_catalog = FW(i2);
        emojiInfo.field_groupId = str;
        emojiInfo.field_temp = 1;
        AppMethodBeat.o(108551);
        return emojiInfo;
    }

    private static int FW(int i2) {
        switch (i2) {
            case 2:
                return 82;
            case 4:
                return 83;
            case 8:
                return 84;
            default:
                return EmojiInfo.VkS;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0228 A[SYNTHETIC, Splitter:B:53:0x0228] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0295  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.tencent.mm.storage.emotion.EmojiGroupInfo r22) {
        /*
        // Method dump skipped, instructions count: 1303
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.model.EmojiLogic.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.storage.emotion.EmojiGroupInfo):boolean");
    }

    public static bms cFW() {
        AppMethodBeat.i(108553);
        bms bms = new bms();
        bms.LVs = 1;
        bms.LVu = 1;
        AppMethodBeat.o(108553);
        return bms;
    }

    public static String amG(String str) {
        AppMethodBeat.i(108554);
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("<xml>");
            sb.append("<productid>" + str + "</productid>");
            sb.append("</xml>");
            String sb2 = sb.toString();
            Log.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", sb2);
            AppMethodBeat.o(108554);
            return sb2;
        }
        AppMethodBeat.o(108554);
        return null;
    }

    public static String v(int i2, String str, String str2) {
        AppMethodBeat.i(108555);
        if (i2 != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("<xml>");
            sb.append("<designeruin>" + i2 + "</designeruin>");
            sb.append("<designername>" + str + "</designername>");
            sb.append("<designerrediretcturl>" + str2 + "</designerrediretcturl>");
            sb.append("</xml>");
            String sb2 = sb.toString();
            Log.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", sb2);
            AppMethodBeat.o(108555);
            return sb2;
        }
        AppMethodBeat.o(108555);
        return null;
    }

    public static int amu(String str) {
        Exception e2;
        int i2;
        AppMethodBeat.i(108556);
        try {
            i2 = p.fd(XmlParser.parseXml(str, "xml", null).get(".xml.designeruin"));
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", Integer.valueOf(i2));
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", e2.toString());
                AppMethodBeat.o(108556);
                return i2;
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = 0;
            Log.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", e2.toString());
            AppMethodBeat.o(108556);
            return i2;
        }
        AppMethodBeat.o(108556);
        return i2;
    }

    public static String amv(String str) {
        Exception e2;
        String str2;
        AppMethodBeat.i(108557);
        try {
            str2 = XmlParser.parseXml(str, "xml", null).get(".xml.designername");
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", str2);
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", e2.toString());
                AppMethodBeat.o(108557);
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
            Log.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", e2.toString());
            AppMethodBeat.o(108557);
            return str2;
        }
        AppMethodBeat.o(108557);
        return str2;
    }

    public static String amH(String str) {
        Exception e2;
        String str2;
        AppMethodBeat.i(108558);
        try {
            str2 = XmlParser.parseXml(str, "xml", null).get(".xml.designerrediretcturl");
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "designerrediretcturl:%s", str2);
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", e2.toString());
                AppMethodBeat.o(108558);
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
            Log.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", e2.toString());
            AppMethodBeat.o(108558);
            return str2;
        }
        AppMethodBeat.o(108558);
        return str2;
    }

    public static String amt(String str) {
        Exception e2;
        String str2;
        AppMethodBeat.i(108559);
        try {
            str2 = XmlParser.parseXml(str, "xml", null).get(".xml.productid");
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "productId:%s", str2);
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", e2.toString());
                AppMethodBeat.o(108559);
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
            Log.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", e2.toString());
            AppMethodBeat.o(108559);
            return str2;
        }
        AppMethodBeat.o(108559);
        return str2;
    }

    public static String ams(String str) {
        AppMethodBeat.i(108560);
        Log.d("MicroMsg.emoji.EmojiLogic", "url:%s", str);
        String str2 = "";
        if (!TextUtils.isEmpty(str) && str.startsWith(HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2m) + "/emoticonstore/")) {
            str2 = str.substring(str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP) + 1);
        }
        AppMethodBeat.o(108560);
        return str2;
    }

    public static String a(int i2, String str, String str2, String str3, String str4, int i3) {
        AppMethodBeat.i(108561);
        if (i2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("<xml>");
            sb.append("<tid>" + i2 + "</tid>");
            sb.append("<title>" + str + "</title>");
            sb.append("<desc>" + str2 + "</desc>");
            sb.append("<iconUrl>" + str3 + "</iconUrl>");
            sb.append("<secondUrl>" + str4 + "</secondUrl>");
            sb.append("<pageType>" + i3 + "</pageType>");
            sb.append("</xml>");
            String sb2 = sb.toString();
            Log.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", sb2);
            AppMethodBeat.o(108561);
            return sb2;
        }
        AppMethodBeat.o(108561);
        return null;
    }

    public static int amI(String str) {
        Exception e2;
        int i2;
        AppMethodBeat.i(108562);
        try {
            i2 = Util.safeParseInt(XmlParser.parseXml(str, "xml", null).get(".xml.tid"));
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "tid:%s", Integer.valueOf(i2));
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", e2.toString());
                AppMethodBeat.o(108562);
                return i2;
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = 0;
            Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", e2.toString());
            AppMethodBeat.o(108562);
            return i2;
        }
        AppMethodBeat.o(108562);
        return i2;
    }

    public static String amJ(String str) {
        Exception e2;
        String str2;
        AppMethodBeat.i(108563);
        try {
            str2 = XmlParser.parseXml(str, "xml", null).get(".xml.title");
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "title:%s", str2);
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", e2.toString());
                AppMethodBeat.o(108563);
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
            Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", e2.toString());
            AppMethodBeat.o(108563);
            return str2;
        }
        AppMethodBeat.o(108563);
        return str2;
    }

    public static String amK(String str) {
        Exception e2;
        String str2;
        AppMethodBeat.i(108564);
        try {
            str2 = XmlParser.parseXml(str, "xml", null).get(".xml.desc");
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "desc:%s", str2);
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", e2.toString());
                AppMethodBeat.o(108564);
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
            Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", e2.toString());
            AppMethodBeat.o(108564);
            return str2;
        }
        AppMethodBeat.o(108564);
        return str2;
    }

    public static String amL(String str) {
        Exception e2;
        String str2;
        AppMethodBeat.i(108565);
        try {
            str2 = XmlParser.parseXml(str, "xml", null).get(".xml.iconUrl");
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "iconUrl:%s", str2);
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", e2.toString());
                AppMethodBeat.o(108565);
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
            Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", e2.toString());
            AppMethodBeat.o(108565);
            return str2;
        }
        AppMethodBeat.o(108565);
        return str2;
    }

    public static String amM(String str) {
        Exception e2;
        String str2;
        AppMethodBeat.i(108566);
        try {
            str2 = Util.nullAs(XmlParser.parseXml(str, "xml", null).get(".xml.secondUrl"), "");
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "secondUrl:%s", str2);
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", e2.toString());
                AppMethodBeat.o(108566);
                return str2;
            }
        } catch (Exception e4) {
            e2 = e4;
            str2 = "";
            Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", e2.toString());
            AppMethodBeat.o(108566);
            return str2;
        }
        AppMethodBeat.o(108566);
        return str2;
    }

    public static int amN(String str) {
        Exception e2;
        int i2;
        AppMethodBeat.i(108567);
        try {
            i2 = Util.safeParseInt(XmlParser.parseXml(str, "xml", null).get(".xml.pageType"));
            try {
                Log.d("MicroMsg.emoji.EmojiLogic", "pageType:%s", Integer.valueOf(i2));
            } catch (Exception e3) {
                e2 = e3;
                Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", e2.toString());
                AppMethodBeat.o(108567);
                return i2;
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = 0;
            Log.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", e2.toString());
            AppMethodBeat.o(108567);
            return i2;
        }
        AppMethodBeat.o(108567);
        return i2;
    }

    public static String j(String str, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.i(108568);
        if (!Util.isNullOrNil(str2) || !Util.isNullOrNil(str3)) {
            String ao = ao(str2, str3);
            if (!Util.isNullOrNil(ao)) {
                if (Util.isNullOrNil(str2)) {
                    str4 = str + ao;
                } else {
                    str4 = str + str2 + FilePathGenerator.ANDROID_DIR_SEP + ao;
                }
            }
            AppMethodBeat.o(108568);
        } else {
            Log.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and url are null.");
            AppMethodBeat.o(108568);
        }
        return str4;
    }

    public static String W(String str, String str2, String str3) {
        String str4 = null;
        AppMethodBeat.i(108569);
        if (!Util.isNullOrNil(str2) || !Util.isNullOrNil(str3)) {
            if (!Util.isNullOrNil(str3)) {
                if (Util.isNullOrNil(str2)) {
                    str4 = str + str3;
                } else {
                    str4 = str + str2 + FilePathGenerator.ANDROID_DIR_SEP + str3;
                }
            }
            Log.d("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path. productid:%s md5:%s path:%s", str2, str3, str4);
            AppMethodBeat.o(108569);
        } else {
            Log.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and md5 are null.");
            AppMethodBeat.o(108569);
        }
        return str4;
    }

    private static String ao(String str, String str2) {
        String messageDigest;
        AppMethodBeat.i(108570);
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            if (Util.isNullOrNil(str2)) {
                messageDigest = g.getMessageDigest(str.getBytes());
            } else {
                messageDigest = g.getMessageDigest(str2.getBytes());
            }
            AppMethodBeat.o(108570);
            return messageDigest;
        }
        Log.e("MicroMsg.emoji.EmojiLogic", "[cpan] product id and url are null.");
        AppMethodBeat.o(108570);
        return null;
    }

    public static boolean amO(String str) {
        AppMethodBeat.i(108571);
        if (!Util.isNullOrNil(str)) {
            try {
                if (com.tencent.mm.modelcontrol.b.Of(str)) {
                    Log.d("MicroMsg.emoji.EmojiLogic", "In Not Auto Download Time Range. timeRange:%s", str);
                    AppMethodBeat.o(108571);
                    return true;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.emoji.EmojiLogic", "isInNotAutoDownloadTimeRange :%s", Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(108571);
        return false;
    }
}
