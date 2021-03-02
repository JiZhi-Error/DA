package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import java.util.ArrayList;

public class YTImageInfo {
    public String checksum;
    public ArrayList<Float> five_points = new ArrayList<>();
    public String image;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A[SYNTHETIC, Splitter:B:20:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041 A[SYNTHETIC, Splitter:B:23:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0053 A[SYNTHETIC, Splitter:B:31:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0058 A[SYNTHETIC, Splitter:B:34:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createFileWithByte(java.lang.String r7, byte[] r8) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo.createFileWithByte(java.lang.String, byte[]):void");
    }

    public YTImageInfo(YTActReflectImage yTActReflectImage) {
        AppMethodBeat.i(43382);
        this.image = new String(Base64.encode(yTActReflectImage.image, 2));
        this.checksum = yTActReflectImage.checksum;
        if (yTActReflectImage.xys != null) {
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[176]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[177]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[178]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[179]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[64]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[65]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[90]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[91]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[102]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[103]));
        }
        AppMethodBeat.o(43382);
    }
}
