package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo {
    public final String destMd5InArt;
    public final String destMd5InDvm;
    public final String dexDiffMd5;
    public final String dexMode;
    public final boolean isJarMode;
    public final String newOrPatchedDexCrC;
    public final String oldDexCrC;
    public final String path;
    public final String rawName;
    public final String realName;

    public ShareDexDiffPatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.rawName = str;
        this.path = str2;
        this.destMd5InDvm = str3;
        this.destMd5InArt = str4;
        this.dexDiffMd5 = str5;
        this.oldDexCrC = str6;
        this.newOrPatchedDexCrC = str7;
        this.dexMode = str8;
        if (str8.equals(ShareConstants.DEXMODE_JAR)) {
            this.isJarMode = true;
            if (SharePatchFileUtil.isRawDexFile(str)) {
                this.realName = str + ShareConstants.JAR_SUFFIX;
            } else {
                this.realName = str;
            }
        } else if (str8.equals(ShareConstants.DEXMODE_RAW)) {
            this.isJarMode = false;
            this.realName = str;
        } else {
            throw new TinkerRuntimeException("can't recognize dex mode:".concat(String.valueOf(str8)));
        }
    }

    public static void parseDexDiffPatchInfo(String str, ArrayList<ShareDexDiffPatchInfo> arrayList) {
        String[] split;
        if (!(str == null || str.length() == 0)) {
            String[] split2 = str.split("\n");
            for (String str2 : split2) {
                if (str2 != null && str2.length() > 0 && (split = str2.split(",", 8)) != null && split.length >= 8) {
                    arrayList.add(new ShareDexDiffPatchInfo(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim(), split[7].trim()));
                }
            }
        }
    }

    public static boolean checkDexDiffPatchInfo(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (shareDexDiffPatchInfo == null) {
            return false;
        }
        String str = shareDexDiffPatchInfo.rawName;
        String str2 = ShareTinkerInternals.isVmArt() ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.rawName);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.destMd5InDvm);
        stringBuffer.append(",");
        stringBuffer.append(this.destMd5InArt);
        stringBuffer.append(",");
        stringBuffer.append(this.oldDexCrC);
        stringBuffer.append(",");
        stringBuffer.append(this.newOrPatchedDexCrC);
        stringBuffer.append(",");
        stringBuffer.append(this.dexDiffMd5);
        stringBuffer.append(",");
        stringBuffer.append(this.dexMode);
        return stringBuffer.toString();
    }
}
