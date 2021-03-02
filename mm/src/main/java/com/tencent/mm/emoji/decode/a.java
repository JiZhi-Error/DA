package com.tencent.mm.emoji.decode;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;

public class a {
    public static a gUF;
    private boolean isRunning = false;
    private String key;

    public static a aum() {
        AppMethodBeat.i(104434);
        if (gUF == null) {
            synchronized (a.class) {
                try {
                    gUF = new a();
                } catch (Throwable th) {
                    AppMethodBeat.o(104434);
                    throw th;
                }
            }
        }
        a aVar = gUF;
        AppMethodBeat.o(104434);
        return aVar;
    }

    public final String aun() {
        AppMethodBeat.i(104435);
        if (Util.isNullOrNil(this.key)) {
            this.key = bj.gCJ().OpN.getKey();
        }
        String str = this.key;
        AppMethodBeat.o(104435);
        return str;
    }

    public final boolean a(EmojiInfo emojiInfo, boolean z) {
        boolean z2;
        int i2;
        int i3;
        AppMethodBeat.i(104437);
        if (emojiInfo == null) {
            Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
            AppMethodBeat.o(104437);
            return false;
        }
        if (Util.isNullOrNil(aun())) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
            AppMethodBeat.o(104437);
            return false;
        }
        String hYx = emojiInfo.hYx();
        if (s.YS(hYx)) {
            boolean z3 = false;
            byte[] aW = s.aW(hYx, 0, 10);
            if (aW != null) {
                try {
                    if (aW.length >= 10) {
                        z3 = ImgUtil.isImageFile(aW);
                    }
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                    z3 = false;
                }
            }
            if (z || z3) {
                long currentTimeMillis = System.currentTimeMillis();
                int boW = (int) s.boW(hYx);
                if (boW > 1024) {
                    i2 = 1024;
                } else {
                    i2 = boW;
                }
                byte[] aW2 = s.aW(hYx, 0, boW);
                byte[] bArr = new byte[0];
                try {
                    bArr = AesEcb.aesCryptEcb(s.aW(hYx, 0, i2), aun().getBytes(), true, false);
                } catch (Throwable th2) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th2, "", new Object[0]);
                }
                if (bArr == null || bArr.length < i2 || aW2 == null || aW2.length < i2) {
                    i3 = -1;
                } else {
                    System.arraycopy(bArr, 0, aW2, 0, i2);
                    i3 = s.f(hYx, aW2, aW2.length);
                }
                if (i3 == 0) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    h.INSTANCE.idkeyStat(252, 1, currentTimeMillis2, false);
                    h.INSTANCE.idkeyStat(252, 6, 1, false);
                    emojiInfo.field_reserved4 |= EmojiInfo.Vll;
                    emojiInfo.field_size = boW;
                    bj.gCJ().OpN.M(emojiInfo);
                    Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", Integer.valueOf(aW2.length), Long.valueOf(currentTimeMillis2));
                    AppMethodBeat.o(104437);
                    return true;
                }
                Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                h.INSTANCE.idkeyStat(252, 3, 1, false);
                AppMethodBeat.o(104437);
                return false;
            }
            Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
            AppMethodBeat.o(104437);
            return true;
        }
        Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", hYx);
        emojiInfo.field_reserved4 = 0;
        bj.gCJ().OpN.M(emojiInfo);
        AppMethodBeat.o(104437);
        return false;
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104438);
        if (emojiInfo == null) {
            Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            AppMethodBeat.o(104438);
            return null;
        }
        String hYx = emojiInfo.hYx();
        byte[] aW = s.aW(hYx, 0, -1);
        if (s.boW(hYx) <= 0 || aW == null || aW.length < 10) {
            Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", hYx);
            AppMethodBeat.o(104438);
            return null;
        }
        byte[] bArr = new byte[10];
        System.arraycopy(aW, 0, bArr, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.Vll) == EmojiInfo.Vll || !ImgUtil.isImageFile(bArr)) {
            long currentTimeMillis = System.currentTimeMillis();
            int boW = (int) s.boW(hYx);
            if (boW > 1024) {
                boW = 1024;
            }
            byte[] aW2 = s.aW(hYx, 0, boW);
            byte[] bArr2 = null;
            if (!Util.isNullOrNil(aun())) {
                try {
                    bArr2 = AesEcb.aesCryptEcb(aW2, aun().getBytes(), false, false);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                }
            }
            if (Util.isNullOrNil(bArr2) || Util.isNullOrNil(aW)) {
                h.INSTANCE.idkeyStat(252, 2, 1, false);
                Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", hYx);
                if (a(emojiInfo, aW)) {
                    AppMethodBeat.o(104438);
                    return aW;
                }
            } else {
                System.arraycopy(bArr2, 0, aW, 0, boW);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                h.INSTANCE.idkeyStat(252, 0, currentTimeMillis2, false);
                h.INSTANCE.idkeyStat(252, 5, 1, false);
                Log.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", Integer.valueOf(aW.length), Long.valueOf(currentTimeMillis2));
                if (a(emojiInfo, aW)) {
                    AppMethodBeat.o(104438);
                    return aW;
                }
            }
        } else if (a(emojiInfo, aW)) {
            AppMethodBeat.o(104438);
            return aW;
        }
        AppMethodBeat.o(104438);
        return null;
    }

    private static boolean a(EmojiInfo emojiInfo, byte[] bArr) {
        String str;
        AppMethodBeat.i(104439);
        if (ImgUtil.isWXGF(bArr)) {
            str = emojiInfo.field_externMd5;
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(104439);
                return true;
            }
        } else {
            str = emojiInfo.field_md5;
        }
        String mD5String = MD5Util.getMD5String(bArr);
        boolean z = !Util.isNullOrNil(str) && !Util.isNullOrNil(mD5String) && Util.isEqual(str, mD5String);
        if (!z) {
            emojiInfo.hYj();
            Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "checkFileMd5: %s", emojiInfo.field_md5);
        }
        AppMethodBeat.o(104439);
        return z;
    }

    public final boolean b(EmojiInfo emojiInfo) {
        boolean z;
        int i2 = 1024;
        AppMethodBeat.i(104440);
        if (emojiInfo == null) {
            Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            AppMethodBeat.o(104440);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String hYx = emojiInfo.hYx();
        int boW = (int) s.boW(hYx);
        if (boW <= 1024) {
            i2 = boW;
        }
        byte[] aW = s.aW(hYx, 0, i2);
        if (s.boW(hYx) > 0 && aW != null && aW.length >= 10) {
            byte[] bArr = new byte[10];
            System.arraycopy(aW, 0, bArr, 0, 10);
            if (ImgUtil.isImageFile(bArr)) {
                z = true;
            } else if ((emojiInfo.field_reserved4 & EmojiInfo.Vll) == EmojiInfo.Vll) {
                byte[] bArr2 = null;
                if (!Util.isNullOrNil(aun())) {
                    try {
                        bArr2 = AesEcb.aesCryptEcb(aW, aun().getBytes(), false, false);
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                    }
                }
                if (!Util.isNullOrNil(bArr2) && ImgUtil.isImageFile(bArr2)) {
                    z = true;
                }
            }
            Log.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
            AppMethodBeat.o(104440);
            return z;
        }
        z = false;
        Log.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
        AppMethodBeat.o(104440);
        return z;
    }
}
