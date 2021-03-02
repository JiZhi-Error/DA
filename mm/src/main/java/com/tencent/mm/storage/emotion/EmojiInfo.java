package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.g.c.bj;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public class EmojiInfo extends bj implements Parcelable, r {
    public static final Parcelable.Creator<EmojiInfo> CREATOR = new Parcelable.Creator<EmojiInfo>() {
        /* class com.tencent.mm.storage.emotion.EmojiInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EmojiInfo[] newArray(int i2) {
            return new EmojiInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EmojiInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105015);
            EmojiInfo emojiInfo = new EmojiInfo(parcel);
            AppMethodBeat.o(105015);
            return emojiInfo;
        }
    };
    public static int TYPE_TEXT = 4;
    public static int VkM = -1;
    public static int VkQ = 65;
    public static String VkR = ".gif";
    public static int VkS = 17;
    public static int VkT = 32;
    public static int VkU = 49;
    public static int VkV = 50;
    public static int VkW = 81;
    public static int VkX = 1;
    public static int VkY = 2;
    public static int VkZ = 3;
    public static int Vla = 10;
    public static int Vlb = 11;
    public static int Vlc = 0;
    public static int Vld = 1;
    public static int Vle = 3;
    public static int Vlf = 4;
    public static int Vlg = 8;
    public static int Vlh = 0;
    public static int Vli = 1;
    public static int Vlj = 0;
    public static int Vlk = 1;
    public static int Vll = 1;
    protected static IAutoDBItem.MAutoDBInfo info;
    private final String Brx;
    public String MOK;
    public String Vlm;
    public int Vln;
    public int Vlo = 2;
    public String talker;

    static {
        AppMethodBeat.i(105048);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[44];
        mAutoDBInfo.columns = new String[45];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        sb.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "md5";
        mAutoDBInfo.columns[1] = "svrid";
        mAutoDBInfo.colsMap.put("svrid", "TEXT");
        sb.append(" svrid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "catalog";
        mAutoDBInfo.colsMap.put("catalog", "INTEGER");
        sb.append(" catalog INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "size";
        mAutoDBInfo.colsMap.put("size", "INTEGER");
        sb.append(" size INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "start";
        mAutoDBInfo.colsMap.put("start", "INTEGER");
        sb.append(" start INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "state";
        mAutoDBInfo.colsMap.put("state", "INTEGER");
        sb.append(" state INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "name";
        mAutoDBInfo.colsMap.put("name", "TEXT");
        sb.append(" name TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "content";
        mAutoDBInfo.colsMap.put("content", "TEXT");
        sb.append(" content TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "reserved1";
        mAutoDBInfo.colsMap.put("reserved1", "TEXT");
        sb.append(" reserved1 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "reserved2";
        mAutoDBInfo.colsMap.put("reserved2", "TEXT");
        sb.append(" reserved2 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "reserved3";
        mAutoDBInfo.colsMap.put("reserved3", "INTEGER");
        sb.append(" reserved3 INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "reserved4";
        mAutoDBInfo.colsMap.put("reserved4", "INTEGER");
        sb.append(" reserved4 INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "app_id";
        mAutoDBInfo.colsMap.put("app_id", "TEXT");
        sb.append(" app_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "groupId";
        mAutoDBInfo.colsMap.put("groupId", "TEXT default '' ");
        sb.append(" groupId TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "lastUseTime";
        mAutoDBInfo.colsMap.put("lastUseTime", "LONG");
        sb.append(" lastUseTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "framesInfo";
        mAutoDBInfo.colsMap.put("framesInfo", "TEXT default '' ");
        sb.append(" framesInfo TEXT default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "idx";
        mAutoDBInfo.colsMap.put("idx", "INTEGER default '0' ");
        sb.append(" idx INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "temp";
        mAutoDBInfo.colsMap.put("temp", "INTEGER default '0' ");
        sb.append(" temp INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "source";
        mAutoDBInfo.colsMap.put("source", "INTEGER default '0' ");
        sb.append(" source INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "needupload";
        mAutoDBInfo.colsMap.put("needupload", "INTEGER default '0' ");
        sb.append(" needupload INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "designerID";
        mAutoDBInfo.colsMap.put("designerID", "TEXT");
        sb.append(" designerID TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "thumbUrl";
        mAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
        sb.append(" thumbUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "cdnUrl";
        mAutoDBInfo.colsMap.put("cdnUrl", "TEXT");
        sb.append(" cdnUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "encrypturl";
        mAutoDBInfo.colsMap.put("encrypturl", "TEXT");
        sb.append(" encrypturl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "aeskey";
        mAutoDBInfo.colsMap.put("aeskey", "TEXT");
        sb.append(" aeskey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "width";
        mAutoDBInfo.colsMap.put("width", "INTEGER default '0' ");
        sb.append(" width INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "height";
        mAutoDBInfo.colsMap.put("height", "INTEGER default '0' ");
        sb.append(" height INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[28] = "externUrl";
        mAutoDBInfo.colsMap.put("externUrl", "TEXT");
        sb.append(" externUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[29] = "externMd5";
        mAutoDBInfo.colsMap.put("externMd5", "TEXT");
        sb.append(" externMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[30] = "activityid";
        mAutoDBInfo.colsMap.put("activityid", "TEXT");
        sb.append(" activityid TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[31] = "tpurl";
        mAutoDBInfo.colsMap.put("tpurl", "TEXT");
        sb.append(" tpurl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[32] = "tpauthkey";
        mAutoDBInfo.colsMap.put("tpauthkey", "TEXT");
        sb.append(" tpauthkey TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[33] = "wxamMd5";
        mAutoDBInfo.colsMap.put("wxamMd5", "TEXT");
        sb.append(" wxamMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[34] = "attachedText";
        mAutoDBInfo.colsMap.put("attachedText", "TEXT");
        sb.append(" attachedText TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[35] = "captureStatus";
        mAutoDBInfo.colsMap.put("captureStatus", "INTEGER default '0' ");
        sb.append(" captureStatus INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[36] = "attachedEmojiMD5";
        mAutoDBInfo.colsMap.put("attachedEmojiMD5", "BLOB default '' ");
        sb.append(" attachedEmojiMD5 BLOB default '' ");
        sb.append(", ");
        mAutoDBInfo.columns[37] = "imitateMd5";
        mAutoDBInfo.colsMap.put("imitateMd5", "TEXT");
        sb.append(" imitateMd5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[38] = "captureUploadErrCode";
        mAutoDBInfo.colsMap.put("captureUploadErrCode", "INTEGER default '0' ");
        sb.append(" captureUploadErrCode INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[39] = "captureUploadCounter";
        mAutoDBInfo.colsMap.put("captureUploadCounter", "INTEGER default '0' ");
        sb.append(" captureUploadCounter INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[40] = "captureEnterTime";
        mAutoDBInfo.colsMap.put("captureEnterTime", "LONG");
        sb.append(" captureEnterTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[41] = "lensId";
        mAutoDBInfo.colsMap.put("lensId", "TEXT");
        sb.append(" lensId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[42] = "attachTextColor";
        mAutoDBInfo.colsMap.put("attachTextColor", "TEXT");
        sb.append(" attachTextColor TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[43] = "captureScene";
        mAutoDBInfo.colsMap.put("captureScene", "INTEGER");
        sb.append(" captureScene INTEGER");
        mAutoDBInfo.columns[44] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(105048);
    }

    public EmojiInfo() {
        AppMethodBeat.i(105022);
        com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
        this.Brx = com.tencent.mm.emoji.e.a.awt();
        reset();
        AppMethodBeat.o(105022);
    }

    public EmojiInfo(String str) {
        AppMethodBeat.i(105023);
        this.Brx = str;
        reset();
        AppMethodBeat.o(105023);
    }

    @Override // com.tencent.mm.g.c.bj
    public final void reset() {
        AppMethodBeat.i(105024);
        this.field_md5 = "";
        this.field_svrid = "";
        this.field_catalog = VkS;
        this.field_type = VkX;
        this.field_size = 0;
        this.field_start = 0;
        this.field_state = Vlc;
        this.field_name = "";
        this.field_content = "";
        this.field_reserved1 = "";
        this.field_reserved2 = "";
        this.field_reserved3 = 0;
        this.field_reserved4 = 0;
        this.field_app_id = "";
        this.field_temp = 0;
        this.field_captureStatus = a.STATUS_SUCCESS.ordinal();
        this.field_captureUploadErrCode = b.ERR_SUCCESS.ordinal();
        this.field_captureUploadCounter = 0;
        this.field_imitateMd5 = "";
        this.field_attachedEmojiMD5 = new byte[0];
        this.MOK = "";
        AppMethodBeat.o(105024);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f A[SYNTHETIC, Splitter:B:28:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7 A[SYNTHETIC, Splitter:B:36:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] nl(int r10, int r11) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.EmojiInfo.nl(int, int):byte[]");
    }

    public final boolean hYi() {
        AppMethodBeat.i(105026);
        if (this.field_catalog == VkS || this.field_catalog == EmojiGroupInfo.VkO || this.field_catalog == VkV || this.field_catalog == VkU) {
            AppMethodBeat.o(105026);
            return true;
        }
        String hYx = hYx();
        if (Util.isNullOrNil(hYx)) {
            AppMethodBeat.o(105026);
            return false;
        }
        o oVar = new o(hYx);
        if (!oVar.exists() || oVar.length() <= 0) {
            AppMethodBeat.o(105026);
            return false;
        }
        AppMethodBeat.o(105026);
        return true;
    }

    public final void hYj() {
        AppMethodBeat.i(105027);
        if (this.field_catalog == VkS || this.field_catalog == VkV || this.field_catalog == VkU) {
            AppMethodBeat.o(105027);
            return;
        }
        String hYx = hYx();
        if (!Util.isNullOrNil(hYx)) {
            o oVar = new o(hYx);
            if (oVar.exists()) {
                oVar.delete();
            }
        }
        AppMethodBeat.o(105027);
    }

    /* renamed from: do  reason: not valid java name */
    public static InputStream m37do(Context context, String str) {
        InputStream inputStream = null;
        AppMethodBeat.i(105028);
        if (context == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(105028);
        } else {
            try {
                String str2 = str.split("\\.")[0];
                Log.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", str2);
                inputStream = context.getResources().openRawResource(context.getResources().getIdentifier(str2, "drawable", context.getPackageName()));
                AppMethodBeat.o(105028);
            } catch (Exception e2) {
                Log.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", e2.getMessage());
                AppMethodBeat.o(105028);
            }
        }
        return inputStream;
    }

    public final synchronized Bitmap hYk() {
        Bitmap hYl;
        AppMethodBeat.i(177040);
        hYl = hYl();
        AppMethodBeat.o(177040);
        return hYl;
    }

    public final synchronized Bitmap hYl() {
        Bitmap decodeThumb;
        AppMethodBeat.i(177041);
        if (!s.YS(hYy()) || (decodeThumb = BitmapUtil.decodeFile(hYy(), null)) == null) {
            decodeThumb = MMGIFJNIFactory.Companion.decodeThumb(this);
            if (decodeThumb != null) {
                try {
                    BitmapUtil.saveBitmapToImage(decodeThumb, 100, Bitmap.CompressFormat.PNG, hYy(), false);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiInfo", e2, "save emoji thumb error", new Object[0]);
                }
            }
            AppMethodBeat.o(177041);
        } else {
            AppMethodBeat.o(177041);
        }
        return decodeThumb;
    }

    public final boolean NA() {
        return this.field_catalog == VkV || this.field_catalog == VkU;
    }

    public final boolean hYm() {
        return this.field_catalog == VkS || this.field_catalog == VkV || this.field_catalog == VkU || this.field_catalog == EmojiGroupInfo.VkO;
    }

    public final boolean hYn() {
        AppMethodBeat.i(105032);
        boolean equalsIgnoreCase = this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
        AppMethodBeat.o(105032);
        return equalsIgnoreCase;
    }

    public final boolean isGif() {
        return this.field_type == VkY || this.field_type == Vla;
    }

    public static boolean axs(int i2) {
        return i2 == VkV || i2 == VkU;
    }

    public final boolean hYo() {
        AppMethodBeat.i(105034);
        if (!Util.isNullOrNil(this.field_wxamMd5)) {
            AppMethodBeat.o(105034);
            return true;
        }
        AppMethodBeat.o(105034);
        return false;
    }

    public final void setMd5(String str) {
        this.field_md5 = str;
    }

    @Override // com.tencent.mm.api.r
    public final String getMd5() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    public final boolean fYz() {
        AppMethodBeat.i(105035);
        if (getMd5().length() == 32) {
            AppMethodBeat.o(105035);
            return true;
        }
        AppMethodBeat.o(105035);
        return false;
    }

    public final String hYp() {
        return this.field_svrid == null ? "" : this.field_svrid;
    }

    public final void axt(int i2) {
        this.field_catalog = i2;
    }

    public final int getGroup() {
        return this.field_catalog;
    }

    public final void setType(int i2) {
        this.field_type = i2;
    }

    public final int getType() {
        return this.field_type;
    }

    public final void setSize(int i2) {
        this.field_size = i2;
    }

    public final int getSize() {
        return this.field_size;
    }

    public final void setState(int i2) {
        this.field_state = i2;
    }

    public final int getState() {
        return this.field_state;
    }

    public final String getName() {
        return this.field_name == null ? "" : this.field_name;
    }

    public final String getContent() {
        return this.field_content == null ? "" : this.field_content;
    }

    public final int hYq() {
        return this.field_reserved3;
    }

    public final String avy() {
        return this.field_groupId;
    }

    public final void byG(String str) {
        this.field_groupId = str;
    }

    public final int getIndex() {
        return this.field_idx;
    }

    public final void hYr() {
        this.field_temp = 1;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(105036);
        this.field_captureStatus = aVar.ordinal();
        AppMethodBeat.o(105036);
    }

    public final a hYs() {
        switch (this.field_captureStatus) {
            case 0:
                return a.STATUS_SUCCESS;
            case 1:
                return a.STATUS_MIXING;
            case 2:
                return a.STATUS_MIX_FAIL;
            case 3:
                return a.STATUS_UPLOADING;
            case 4:
                return a.STATUS_UPLOAD_FAIL;
            default:
                return a.STATUS_SUCCESS;
        }
    }

    public final int hYt() {
        return this.field_captureUploadCounter;
    }

    public final void hYu() {
        this.field_captureUploadCounter++;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(105037);
        this.field_captureUploadErrCode = bVar.ordinal();
        AppMethodBeat.o(105037);
    }

    public final b hYv() {
        switch (this.field_captureUploadErrCode) {
            case 0:
                return b.ERR_SUCCESS;
            case 1:
                return b.ERR_NON_NETWORK;
            case 2:
                return b.ERR_WIFI_NETWORK;
            case 3:
                return b.ERR_MOBILE_NETWORK;
            case 4:
                return b.ERR_NOT_COMPLETED;
            case 5:
                return b.ERR_OVER_LIMIT;
            case 6:
                return b.ERR_OTHERS;
            case 7:
                return b.ERR_LOCAL_FILE;
            case 8:
                return b.ERR_OVER_SIZE;
            case 9:
                return b.ERR_SPAM;
            case 10:
                return b.ERR_OVER_UPLOAD_TIME;
            default:
                return b.ERR_OTHERS;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e A[SYNTHETIC, Splitter:B:22:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083 A[SYNTHETIC, Splitter:B:25:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cb A[SYNTHETIC, Splitter:B:35:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d0 A[SYNTHETIC, Splitter:B:38:0x00d0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bH(java.util.ArrayList<java.lang.String> r8) {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.EmojiInfo.bH(java.util.ArrayList):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a A[SYNTHETIC, Splitter:B:23:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[SYNTHETIC, Splitter:B:26:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c3 A[SYNTHETIC, Splitter:B:36:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8 A[SYNTHETIC, Splitter:B:39:0x00c8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.String> hYw() {
        /*
        // Method dump skipped, instructions count: 275
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.EmojiInfo.hYw():java.util.ArrayList");
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String hYx() {
        String str;
        AppMethodBeat.i(105040);
        if (Util.isNullOrNil(this.field_groupId) && Util.isNullOrNil(this.field_md5)) {
            Log.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
            AppMethodBeat.o(105040);
            return null;
        } else if (!Util.isNullOrNil(this.field_md5)) {
            if (Util.isNullOrNil(this.field_groupId) || Util.isEqual(this.field_groupId, "capture")) {
                str = this.Brx;
            } else {
                str = this.Brx + this.field_groupId + FilePathGenerator.ANDROID_DIR_SEP;
            }
            s.boN(str);
            String str2 = str + this.field_md5;
            AppMethodBeat.o(105040);
            return str2;
        } else {
            AppMethodBeat.o(105040);
            return null;
        }
    }

    public final String hYy() {
        AppMethodBeat.i(105041);
        String hYx = hYx();
        String str = hYx == null ? null : hYx + "_cover";
        if (!com.tencent.mm.plugin.emoji.h.b.x(this)) {
            AppMethodBeat.o(105041);
            return str;
        }
        String str2 = com.tencent.mm.loader.j.b.aKB() + "emoji/cover/" + getMd5() + "_cover";
        AppMethodBeat.o(105041);
        return str2;
    }

    public static String hYz() {
        AppMethodBeat.i(105042);
        com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
        String awt = com.tencent.mm.emoji.e.a.awt();
        AppMethodBeat.o(105042);
        return awt;
    }

    public String toString() {
        AppMethodBeat.i(105045);
        StringBuilder sb = new StringBuilder();
        sb.append("field_md5:").append(this.field_md5).append("\n");
        sb.append("field_svrid:").append(this.field_svrid).append("\n");
        sb.append("field_catalog:").append(this.field_catalog).append("\n");
        sb.append("field_type:").append(this.field_type).append("\n");
        sb.append("field_size:").append(this.field_size).append("\n");
        sb.append("field_start:").append(this.field_start).append("\n");
        sb.append("field_state:").append(this.field_state).append("\n");
        sb.append("field_name:").append(this.field_name).append("\n");
        sb.append("field_content:").append(this.field_content).append("\n");
        sb.append("field_reserved1:").append(this.field_reserved1).append("\n");
        sb.append("field_reserved2:").append(this.field_reserved2).append("\n");
        sb.append("field_reserved3:").append(this.field_reserved3).append("\n");
        sb.append("field_reserved4:").append(this.field_reserved4).append("\n");
        sb.append("field_app_id:").append(this.field_app_id).append("\n");
        sb.append("field_groupId:").append(this.field_groupId).append("\n");
        sb.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
        sb.append("field_framesInfo:").append(this.field_framesInfo).append("\n");
        sb.append("field_idx:").append(this.field_idx).append("\n");
        sb.append("field_temp:").append(this.field_temp).append("\n");
        sb.append("field_source:").append(this.field_source).append("\n");
        sb.append("field_needupload:").append(this.field_needupload).append("\n");
        sb.append("field_designerID:").append(this.field_designerID).append("\n");
        sb.append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
        sb.append("field_captureStatus:").append(this.field_captureStatus).append("\n");
        sb.append("field_captureUploadErrCode").append(this.field_captureUploadErrCode).append("\n");
        sb.append("field_captureUploadCounter").append(this.field_captureUploadCounter).append("\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(105045);
        return sb2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(105046);
        parcel.writeString(this.Brx);
        parcel.writeString(this.field_md5);
        parcel.writeString(this.field_svrid);
        parcel.writeInt(this.field_catalog);
        parcel.writeInt(this.field_type);
        parcel.writeInt(this.field_size);
        parcel.writeInt(this.field_start);
        parcel.writeInt(this.field_state);
        parcel.writeString(this.field_name);
        parcel.writeString(this.field_content);
        parcel.writeString(this.field_reserved1);
        parcel.writeString(this.field_reserved2);
        parcel.writeInt(this.field_reserved3);
        parcel.writeInt(this.field_reserved4);
        parcel.writeString(this.field_app_id);
        parcel.writeString(this.field_groupId);
        parcel.writeLong(this.field_lastUseTime);
        parcel.writeString(this.field_framesInfo);
        parcel.writeInt(this.field_idx);
        parcel.writeInt(this.field_temp);
        parcel.writeInt(this.field_source);
        parcel.writeInt(this.field_needupload);
        parcel.writeString(this.field_designerID);
        parcel.writeString(this.field_thumbUrl);
        parcel.writeString(this.field_cdnUrl);
        parcel.writeString(this.field_encrypturl);
        parcel.writeString(this.field_aeskey);
        parcel.writeInt(this.field_width);
        parcel.writeInt(this.field_height);
        parcel.writeString(this.field_activityid);
        parcel.writeLong(this.systemRowid);
        parcel.writeString(this.field_wxamMd5);
        parcel.writeString(this.field_attachedText);
        parcel.writeInt(this.field_captureStatus);
        if (this.field_attachedEmojiMD5 == null || this.field_attachedEmojiMD5.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.field_attachedEmojiMD5.length);
            parcel.writeByteArray(this.field_attachedEmojiMD5);
        }
        parcel.writeString(this.field_imitateMd5);
        parcel.writeInt(this.field_captureUploadErrCode);
        parcel.writeInt(this.field_captureUploadCounter);
        parcel.writeLong(this.field_captureEnterTime);
        parcel.writeString(this.field_lensId);
        parcel.writeString(this.field_attachTextColor);
        parcel.writeInt(this.field_captureScene);
        parcel.writeString(this.field_externMd5);
        AppMethodBeat.o(105046);
    }

    protected EmojiInfo(Parcel parcel) {
        AppMethodBeat.i(105047);
        this.Brx = parcel.readString();
        this.field_md5 = parcel.readString();
        this.field_svrid = parcel.readString();
        this.field_catalog = parcel.readInt();
        this.field_type = parcel.readInt();
        this.field_size = parcel.readInt();
        this.field_start = parcel.readInt();
        this.field_state = parcel.readInt();
        this.field_name = parcel.readString();
        this.field_content = parcel.readString();
        this.field_reserved1 = parcel.readString();
        this.field_reserved2 = parcel.readString();
        this.field_reserved3 = parcel.readInt();
        this.field_reserved4 = parcel.readInt();
        this.field_app_id = parcel.readString();
        this.field_groupId = parcel.readString();
        this.field_lastUseTime = parcel.readLong();
        this.field_framesInfo = parcel.readString();
        this.field_idx = parcel.readInt();
        this.field_temp = parcel.readInt();
        this.field_source = parcel.readInt();
        this.field_needupload = parcel.readInt();
        this.field_designerID = parcel.readString();
        this.field_thumbUrl = parcel.readString();
        this.field_cdnUrl = parcel.readString();
        this.field_encrypturl = parcel.readString();
        this.field_aeskey = parcel.readString();
        this.field_width = parcel.readInt();
        this.field_height = parcel.readInt();
        this.field_activityid = parcel.readString();
        this.systemRowid = parcel.readLong();
        this.field_wxamMd5 = parcel.readString();
        this.field_attachedText = parcel.readString();
        this.field_captureStatus = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_attachedEmojiMD5 = new byte[readInt];
            parcel.readByteArray(this.field_attachedEmojiMD5);
        }
        this.field_imitateMd5 = parcel.readString();
        this.field_captureUploadErrCode = parcel.readInt();
        this.field_captureUploadCounter = parcel.readInt();
        this.field_captureEnterTime = parcel.readLong();
        this.field_lensId = parcel.readString();
        this.field_attachTextColor = parcel.readString();
        this.field_captureScene = parcel.readInt();
        this.field_externMd5 = parcel.readString();
        AppMethodBeat.o(105047);
    }

    public enum a {
        STATUS_SUCCESS,
        STATUS_MIXING,
        STATUS_MIX_FAIL,
        STATUS_UPLOADING,
        STATUS_UPLOAD_FAIL;

        public static a valueOf(String str) {
            AppMethodBeat.i(105017);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(105017);
            return aVar;
        }

        static {
            AppMethodBeat.i(105018);
            AppMethodBeat.o(105018);
        }
    }

    public enum b {
        ERR_SUCCESS,
        ERR_NON_NETWORK,
        ERR_WIFI_NETWORK,
        ERR_MOBILE_NETWORK,
        ERR_NOT_COMPLETED,
        ERR_OVER_LIMIT,
        ERR_OTHERS,
        ERR_LOCAL_FILE,
        ERR_OVER_SIZE,
        ERR_SPAM,
        ERR_OVER_UPLOAD_TIME,
        ERR_MIX_VIDEO_ZERO_FRAME,
        ERR_MIX_OUTPUT_EMPTY,
        ERR_MIX_PROCESS_KILL;

        public static b valueOf(String str) {
            AppMethodBeat.i(105020);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(105020);
            return bVar;
        }

        static {
            AppMethodBeat.i(105021);
            AppMethodBeat.o(105021);
        }
    }

    @Override // com.tencent.mm.api.r
    public final synchronized Bitmap A(Context context, int i2) {
        Bitmap bitmap;
        String replaceAll;
        int i3 = 0;
        synchronized (this) {
            AppMethodBeat.i(105030);
            if (this.field_catalog == EmojiGroupInfo.VkO || this.field_catalog == VkV || this.field_catalog == VkU) {
                String name = getName();
                if (!Util.isNullOrNil(name)) {
                    Log.i("MicroMsg.emoji.EmojiInfo", "#getBitmap, name = ".concat(String.valueOf(name)));
                    if (name.startsWith("jsb")) {
                        replaceAll = "jsb";
                    } else if (name.startsWith("dice")) {
                        replaceAll = "dice";
                    } else {
                        replaceAll = name.replaceAll(".png", "");
                    }
                    try {
                        int identifier = context.getResources().getIdentifier(replaceAll, "drawable", context.getPackageName());
                        Log.i("MicroMsg.emoji.EmojiInfo", "#getBitmap, get res identifier, name = " + replaceAll + ", resId = " + identifier);
                        bitmap = BitmapUtil.transformDrawableToBitmap(context.getResources().getDrawable(identifier));
                        Log.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                        AppMethodBeat.o(105030);
                    } catch (Resources.NotFoundException e2) {
                        Log.printErrStackTrace("MicroMsg.emoji.EmojiInfo", e2, "get res fail, name = ".concat(String.valueOf(replaceAll)), new Object[0]);
                        bitmap = null;
                        AppMethodBeat.o(105030);
                    }
                } else {
                    Log.i("MicroMsg.emoji.EmojiInfo", "name is null");
                    Log.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", this);
                    bitmap = null;
                    AppMethodBeat.o(105030);
                }
            } else if (this.field_catalog == EmojiGroupInfo.VkN) {
                String name2 = getName();
                if (!Util.isNullOrNil(name2)) {
                    name2 = (Util.isNullOrNil(getContent()) ? getName() : getContent()).replaceAll(".png", "");
                } else {
                    Log.i("MicroMsg.emoji.EmojiInfo", "name is null");
                }
                Log.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", name2);
                bitmap = BitmapUtil.transformDrawableToBitmap(context.getResources().getDrawable(context.getResources().getIdentifier(name2, "drawable", MMApplicationContext.getPackageName())));
                Log.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                AppMethodBeat.o(105030);
            } else {
                String hYy = hYy();
                boolean YS = s.YS(hYy);
                Log.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", hYy, Boolean.valueOf(YS));
                if (!YS) {
                    String hYx = hYx();
                    boolean YS2 = s.YS(hYx);
                    if (YS2) {
                        byte[] a2 = ((d) g.ah(d.class)).getProvider().a(this);
                        if (a2 == null) {
                            Log.e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
                            bitmap = null;
                            AppMethodBeat.o(105030);
                        } else {
                            Log.i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", Integer.valueOf(a2.length));
                            if (ImgUtil.isWXGF(a2)) {
                                bitmap = i.bF(a2);
                            } else {
                                bitmap = BitmapUtil.decodeByteArray(a2, i2, i2);
                            }
                            if (bitmap != null) {
                                Log.i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", this, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                            }
                            AppMethodBeat.o(105030);
                        }
                    } else {
                        Log.w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", hYx, Boolean.valueOf(YS2));
                        Log.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", this);
                        bitmap = null;
                        AppMethodBeat.o(105030);
                    }
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeFile(hYy, options);
                    if (options.outHeight >= i2 || options.outWidth >= i2) {
                        bitmap = BitmapUtil.createThumbBitmap(hYy, i2, i2, true, false);
                    } else {
                        bitmap = BitmapUtil.createThumbBitmap(hYy, options.outHeight, options.outWidth, true, false);
                    }
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(this.field_catalog);
                    objArr[1] = Integer.valueOf(bitmap == null ? 0 : bitmap.getWidth());
                    if (bitmap != null) {
                        i3 = bitmap.getHeight();
                    }
                    objArr[2] = Integer.valueOf(i3);
                    Log.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", objArr);
                    AppMethodBeat.o(105030);
                }
            }
        }
        return bitmap;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(105044);
        if (obj == null || !(obj instanceof EmojiInfo) || !((EmojiInfo) obj).getMd5().equalsIgnoreCase(this.field_md5)) {
            AppMethodBeat.o(105044);
            return false;
        }
        AppMethodBeat.o(105044);
        return true;
    }
}
