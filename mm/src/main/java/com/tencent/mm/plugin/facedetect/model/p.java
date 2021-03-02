package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.a;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class p {
    public static String a(FaceProNative.FaceResult faceResult) {
        AppMethodBeat.i(103785);
        if (faceResult == null || faceResult.result != 0) {
            Log.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
            AppMethodBeat.o(103785);
            return null;
        }
        try {
            String cTn = cTn();
            mn mnVar = new mn();
            mnVar.KQI = b.cD(faceResult.sidedata);
            mnVar.KQJ = b.cD(faceResult.data);
            e(mnVar.toByteArray(), cTn);
            AppMethodBeat.o(103785);
            return cTn;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceUtils", e2, "", new Object[0]);
            AppMethodBeat.o(103785);
            return null;
        }
    }

    public static Bitmap arA(String str) {
        AppMethodBeat.i(103786);
        try {
            if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
                AppMethodBeat.o(103786);
                return null;
            }
            String str2 = a.AbstractC1038a.sQz + MD5Util.getMD5String(str);
            if (!new o(str2).exists()) {
                Log.w("MicroMsg.FaceUtils", "hy: no last file. return");
                AppMethodBeat.o(103786);
                return null;
            }
            byte[] aW = s.aW(str2, 0, -1);
            if (aW != null) {
                byte[] f2 = a.f(aW, arB(str));
                if (f2.length <= 0) {
                    Log.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
                    AppMethodBeat.o(103786);
                    return null;
                }
                Bitmap decodeByteArray = com.tencent.mm.compatible.f.a.decodeByteArray(f2, 0, f2.length);
                AppMethodBeat.o(103786);
                return decodeByteArray;
            }
            Log.w("MicroMsg.FaceUtils", "hy: nothing in file");
            AppMethodBeat.o(103786);
            return null;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceUtils", e2, "hy: err in encrypt", new Object[0]);
            AppMethodBeat.o(103786);
            return null;
        }
    }

    public static boolean b(Bitmap bitmap, String str) {
        AppMethodBeat.i(103787);
        if (bitmap == null) {
            try {
                Log.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
                AppMethodBeat.o(103787);
                return false;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FaceUtils", e2, "hy: err in encrypt", new Object[0]);
                AppMethodBeat.o(103787);
                return false;
            }
        } else if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
            AppMethodBeat.o(103787);
            return false;
        } else {
            o oVar = new o(a.AbstractC1038a.sQz);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            String str2 = a.AbstractC1038a.sQz + MD5Util.getMD5String(str);
            o oVar2 = new o(str2);
            if (!oVar2.exists()) {
                Log.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
                oVar2.createNewFile();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (byteArray != null) {
                byte[] f2 = a.f(byteArray, arB(str));
                if (f2.length <= 0) {
                    Log.w("MicroMsg.FaceUtils", "hy: enc err. return null");
                    AppMethodBeat.o(103787);
                    return false;
                }
                s.f(str2, f2, f2.length);
                AppMethodBeat.o(103787);
                return true;
            }
            Log.w("MicroMsg.FaceUtils", "hy: nothing in stream");
            AppMethodBeat.o(103787);
            return false;
        }
    }

    private static String arB(String str) {
        AppMethodBeat.i(103788);
        String encodeToString = Base64.encodeToString((str + str.hashCode()).getBytes(), 0);
        AppMethodBeat.o(103788);
        return encodeToString;
    }

    public static boolean ai(Activity activity) {
        AppMethodBeat.i(186369);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(activity, "android.permission.CAMERA", 16, "", "");
        Log.i("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), activity);
        if (!a2) {
            AppMethodBeat.o(186369);
            return false;
        }
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(activity, "android.permission.RECORD_AUDIO", 80, "", "");
        Log.i("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), activity);
        if (!a3) {
            AppMethodBeat.o(186369);
            return false;
        }
        AppMethodBeat.o(186369);
        return true;
    }

    public static boolean aj(Activity activity) {
        AppMethodBeat.i(103789);
        boolean n = com.tencent.mm.pluginsdk.permission.b.n(activity, "android.permission.CAMERA");
        boolean n2 = com.tencent.mm.pluginsdk.permission.b.n(activity, "android.permission.RECORD_AUDIO");
        Log.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", Boolean.valueOf(n), Boolean.valueOf(n2), Util.getStack(), activity);
        ArrayList arrayList = new ArrayList();
        if (!n) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!n2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (!n || !n2) {
            Log.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
            android.support.v4.app.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 23);
            AppMethodBeat.o(103789);
            return false;
        }
        AppMethodBeat.o(103789);
        return true;
    }

    public static boolean cTg() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(103791);
        String str = cTh() + FilePathGenerator.ANDROID_DIR_SEP;
        String[] cTk = cTk();
        String[] cTj = cTj();
        String[] cTi = cTi();
        int i2 = 0;
        while (true) {
            if (i2 >= 4) {
                z = true;
                break;
            }
            String str2 = cTk[i2];
            String str3 = str + str2;
            String concat = "detector/".concat(String.valueOf(str2));
            if (!s.YS(str3) && !gC(str3, "face_detect/".concat(String.valueOf(concat))).booleanValue()) {
                z = false;
                break;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= 5) {
                break;
            }
            String str4 = cTj[i3];
            String str5 = str + str4;
            String concat2 = "ufa/".concat(String.valueOf(str4));
            if (!s.YS(str5) && !gC(str5, "face_detect/".concat(String.valueOf(concat2))).booleanValue()) {
                z = false;
                break;
            }
            i3++;
        }
        int i4 = 0;
        while (true) {
            if (i4 > 0) {
                break;
            }
            String str6 = cTi[i4];
            String concat3 = "poseest/".concat(String.valueOf(str6));
            String str7 = str + str6;
            if (!s.YS(str7) && !gC(str7, "face_detect/".concat(String.valueOf(concat3))).booleanValue()) {
                z = false;
                break;
            }
            i4++;
        }
        String cTl = cTl();
        String cTm = cTm();
        if (Util.isNullOrNil(cTl) || Util.isNullOrNil(cTm)) {
            Log.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
        } else {
            o oVar = new o(cTl);
            o oVar2 = new o(cTm);
            if (!oVar.exists() && !HM(0)) {
                Log.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
                z = false;
            }
            if (oVar2.exists() || HM(1)) {
                z2 = z;
            } else {
                Log.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
            }
        }
        AppMethodBeat.o(103791);
        return z2;
    }

    private static Boolean gC(String str, String str2) {
        AppMethodBeat.i(103792);
        Log.i("MicroMsg.FaceUtils", "SDPath: " + str + " assetPath: " + str2);
        com.tencent.mm.plugin.expansions.a.cMq();
        j(MMApplicationContext.getContext(), str2, str);
        Boolean valueOf = Boolean.valueOf(s.YS(str));
        AppMethodBeat.o(103792);
        return valueOf;
    }

    public static String cTh() {
        String str;
        AppMethodBeat.i(103793);
        if (a.sQx) {
            str = com.tencent.mm.loader.j.b.aKJ() + "face_detect";
        } else {
            str = com.tencent.mm.loader.j.b.aKA() + "face_detect";
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            Log.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
            oVar.mkdirs();
        }
        AppMethodBeat.o(103793);
        return str;
    }

    public static String[] cTi() {
        return new String[]{"rotBasis.bin"};
    }

    public static String[] cTj() {
        return new String[]{"align.rpdm", "align.stb", "align_bin.rpdc", "eye.rpdm", "eye_bin.rpdc"};
    }

    public static String[] cTk() {
        return new String[]{"net1_18.rpnmodel", "net1_18_bin.rpnproto", "net2_36.rpnmodel", "net2_36_bin.rpnproto"};
    }

    public static String cTl() {
        AppMethodBeat.i(103794);
        String str = cTh() + "/ufdmtcc.bin";
        AppMethodBeat.o(103794);
        return str;
    }

    public static String cTm() {
        AppMethodBeat.i(103795);
        String str = cTh() + "/ufat.bin";
        AppMethodBeat.o(103795);
        return str;
    }

    public static String cTn() {
        AppMethodBeat.i(103796);
        String str = cTh() + "/release_out.fd";
        AppMethodBeat.o(103796);
        return str;
    }

    public static boolean HM(int i2) {
        AppMethodBeat.i(103797);
        String str = "";
        switch (i2) {
            case 0:
                str = bf.iDu.aA("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
                break;
            case 1:
                str = bf.iDu.aA("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
                break;
        }
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", Integer.valueOf(i2));
            AppMethodBeat.o(103797);
            return false;
        } else if (new o(str).exists()) {
            o oVar = new o(HN(i2));
            if (oVar.exists()) {
                oVar.delete();
            }
            s.nw(str, HN(i2));
            AppMethodBeat.o(103797);
            return true;
        } else {
            Log.e("MicroMsg.FaceUtils", "originFile file not exist");
            AppMethodBeat.o(103797);
            return false;
        }
    }

    private static String HN(int i2) {
        AppMethodBeat.i(103798);
        switch (i2) {
            case 0:
                String cTl = cTl();
                AppMethodBeat.o(103798);
                return cTl;
            case 1:
                String cTm = cTm();
                AppMethodBeat.o(103798);
                return cTm;
            default:
                AppMethodBeat.o(103798);
                return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[SYNTHETIC, Splitter:B:19:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC, Splitter:B:38:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a7 A[Catch:{ Exception -> 0x00ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void j(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 188
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.model.p.j(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static Bitmap l(final String str, Bitmap bitmap) {
        final Bitmap copy;
        AppMethodBeat.i(103800);
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.1f), Math.round(((float) bitmap.getHeight()) * 0.1f), false);
            copy = createScaledBitmap.copy(createScaledBitmap.getConfig(), true);
            int width = copy.getWidth();
            int height = copy.getHeight();
            int[] iArr = new int[(width * height)];
            Log.e("pix", width + " " + height + " " + iArr.length);
            copy.getPixels(iArr, 0, width, 0, 0, width, height);
            int i2 = width - 1;
            int i3 = height - 1;
            int i4 = width * height;
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            int[] iArr4 = new int[i4];
            int[] iArr5 = new int[Math.max(width, height)];
            int[] iArr6 = new int[246016];
            for (int i5 = 0; i5 < 246016; i5++) {
                iArr6[i5] = i5 / 961;
            }
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, 61, 3);
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (i6 >= height) {
                    int i9 = 0;
                    while (true) {
                        if (i9 >= width) {
                            Log.e("pix", width + " " + height + " " + i4);
                            copy.setPixels(iArr, 0, width, 0, 0, width, height);
                            break;
                        }
                        int i10 = width * -30;
                        if (b.DE(currentTimeMillis2)) {
                            copy = null;
                            break;
                        }
                        int i11 = 0;
                        int i12 = 0;
                        int i13 = 0;
                        int i14 = 0;
                        int i15 = 0;
                        int i16 = 0;
                        int i17 = 0;
                        int i18 = 0;
                        int i19 = 0;
                        for (int i20 = -30; i20 <= 30; i20++) {
                            int max = Math.max(0, i10) + i9;
                            int[] iArr8 = iArr7[i20 + 30];
                            iArr8[0] = iArr2[max];
                            iArr8[1] = iArr3[max];
                            iArr8[2] = iArr4[max];
                            int abs = 31 - Math.abs(i20);
                            i17 += iArr2[max] * abs;
                            i18 += iArr3[max] * abs;
                            i19 += iArr4[max] * abs;
                            if (i20 > 0) {
                                i11 += iArr8[0];
                                i12 += iArr8[1];
                                i13 += iArr8[2];
                            } else {
                                i14 += iArr8[0];
                                i15 += iArr8[1];
                                i16 += iArr8[2];
                            }
                            if (i20 < i3) {
                                i10 += width;
                            }
                        }
                        int i21 = 30;
                        if (b.DE(currentTimeMillis2)) {
                            copy = null;
                            break;
                        }
                        int i22 = 0;
                        int i23 = i11;
                        int i24 = i9;
                        while (i22 < height) {
                            iArr[i24] = (-16777216 & iArr[i24]) | (iArr6[i17] << 16) | (iArr6[i18] << 8) | iArr6[i19];
                            int i25 = i17 - i14;
                            int i26 = i18 - i15;
                            int i27 = i19 - i16;
                            int[] iArr9 = iArr7[((i21 - 30) + 61) % 61];
                            int i28 = i14 - iArr9[0];
                            int i29 = i15 - iArr9[1];
                            int i30 = i16 - iArr9[2];
                            if (i9 == 0) {
                                iArr5[i22] = Math.min(i22 + 31, i3) * width;
                            }
                            int i31 = iArr5[i22] + i9;
                            iArr9[0] = iArr2[i31];
                            iArr9[1] = iArr3[i31];
                            iArr9[2] = iArr4[i31];
                            int i32 = i23 + iArr9[0];
                            int i33 = i12 + iArr9[1];
                            int i34 = i13 + iArr9[2];
                            i17 = i25 + i32;
                            i18 = i26 + i33;
                            i19 = i27 + i34;
                            i21 = (i21 + 1) % 61;
                            int[] iArr10 = iArr7[i21];
                            i14 = i28 + iArr10[0];
                            i15 = i29 + iArr10[1];
                            i16 = i30 + iArr10[2];
                            i23 = i32 - iArr10[0];
                            int i35 = i33 - iArr10[1];
                            i13 = i34 - iArr10[2];
                            i24 += width;
                            i22++;
                            i12 = i35;
                        }
                        i9++;
                    }
                } else if (b.DE(currentTimeMillis2)) {
                    copy = null;
                    break;
                } else {
                    int i36 = 0;
                    int i37 = 0;
                    int i38 = 0;
                    int i39 = 0;
                    int i40 = 0;
                    int i41 = 0;
                    int i42 = 0;
                    int i43 = 0;
                    int i44 = 0;
                    for (int i45 = -30; i45 <= 30; i45++) {
                        int i46 = iArr[Math.min(i2, Math.max(i45, 0)) + i8];
                        int[] iArr11 = iArr7[i45 + 30];
                        iArr11[0] = (16711680 & i46) >> 16;
                        iArr11[1] = (65280 & i46) >> 8;
                        iArr11[2] = i46 & 255;
                        int abs2 = 31 - Math.abs(i45);
                        i42 += iArr11[0] * abs2;
                        i43 += iArr11[1] * abs2;
                        i44 += abs2 * iArr11[2];
                        if (i45 > 0) {
                            i36 += iArr11[0];
                            i37 += iArr11[1];
                            i38 += iArr11[2];
                        } else {
                            i39 += iArr11[0];
                            i40 += iArr11[1];
                            i41 += iArr11[2];
                        }
                    }
                    int i47 = 30;
                    if (b.DE(currentTimeMillis2)) {
                        copy = null;
                        break;
                    }
                    int i48 = 0;
                    int i49 = i36;
                    int i50 = i37;
                    int i51 = i38;
                    int i52 = i39;
                    int i53 = i40;
                    int i54 = i41;
                    while (i48 < width) {
                        iArr2[i8] = iArr6[i42];
                        iArr3[i8] = iArr6[i43];
                        iArr4[i8] = iArr6[i44];
                        int i55 = i42 - i52;
                        int i56 = i43 - i53;
                        int i57 = i44 - i54;
                        int[] iArr12 = iArr7[((i47 - 30) + 61) % 61];
                        int i58 = i52 - iArr12[0];
                        int i59 = i53 - iArr12[1];
                        int i60 = i54 - iArr12[2];
                        if (i6 == 0) {
                            iArr5[i48] = Math.min(i48 + 30 + 1, i2);
                        }
                        int i61 = iArr[iArr5[i48] + i7];
                        iArr12[0] = (16711680 & i61) >> 16;
                        iArr12[1] = (65280 & i61) >> 8;
                        iArr12[2] = i61 & 255;
                        int i62 = i49 + iArr12[0];
                        int i63 = i50 + iArr12[1];
                        int i64 = iArr12[2] + i51;
                        i42 = i55 + i62;
                        i43 = i56 + i63;
                        i44 = i57 + i64;
                        i47 = (i47 + 1) % 61;
                        int[] iArr13 = iArr7[i47 % 61];
                        int i65 = i58 + iArr13[0];
                        int i66 = i59 + iArr13[1];
                        i54 = i60 + iArr13[2];
                        int i67 = i64 - iArr13[2];
                        i8++;
                        i48++;
                        i49 = i62 - iArr13[0];
                        i50 = i63 - iArr13[1];
                        i51 = i67;
                        i52 = i65;
                        i53 = i66;
                    }
                    i6++;
                    i7 += width;
                }
            }
        } else {
            copy = null;
        }
        Log.i("MicroMsg.FaceUtils", "hy: blur using %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        boolean z = true;
        if (copy == null) {
            Log.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
            z = false;
            copy = arA(str);
            if (copy == null) {
                copy = BitmapUtil.getBitmapNative((int) R.drawable.c6b);
            }
        }
        if (z) {
            h.RTc.ba(new Runnable() {
                /* class com.tencent.mm.plugin.facedetect.model.p.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(103782);
                    long currentTicks = Util.currentTicks();
                    p.b(copy, str);
                    Log.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
                    AppMethodBeat.o(103782);
                }
            });
        }
        AppMethodBeat.o(103800);
        return copy;
    }

    public static String arC(String str) {
        AppMethodBeat.i(103801);
        String messageDigest = g.getMessageDigest((Util.currentTicks() + ", " + str).getBytes());
        AppMethodBeat.o(103801);
        return messageDigest;
    }

    public static class a {
        public static byte[] f(byte[] bArr, String str) {
            AppMethodBeat.i(103783);
            byte[] bytes = str.getBytes();
            byte[] bArr2 = new byte[256];
            for (int i2 = 0; i2 < 256; i2++) {
                bArr2[i2] = (byte) i2;
            }
            if (bytes == null || bytes.length == 0) {
                bArr2 = null;
            } else {
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < 256; i5++) {
                    i3 = (i3 + (bytes[i4] & 255) + (bArr2[i5] & 255)) & 255;
                    byte b2 = bArr2[i5];
                    bArr2[i5] = bArr2[i3];
                    bArr2[i3] = b2;
                    i4 = (i4 + 1) % bytes.length;
                }
            }
            byte[] bArr3 = new byte[bArr.length];
            if (bArr2 != null) {
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (i6 < bArr.length) {
                    i8 = (i8 + 1) & 255;
                    int i9 = ((bArr2[i8] & 255) + i7) & 255;
                    byte b3 = bArr2[i8];
                    bArr2[i8] = bArr2[i9];
                    bArr2[i9] = b3;
                    bArr3[i6] = (byte) (bArr2[((bArr2[i8] & 255) + (bArr2[i9] & 255)) & 255] ^ bArr[i6]);
                    i6++;
                    i7 = i9;
                }
            }
            AppMethodBeat.o(103783);
            return bArr3;
        }
    }

    public static void e(byte[] bArr, String str) {
        AppMethodBeat.i(103784);
        try {
            s.f(str, bArr, bArr.length);
            AppMethodBeat.o(103784);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceUtils", e2, "hy: err in save debug jpeg", new Object[0]);
            AppMethodBeat.o(103784);
        }
    }
}
