package com.tencent.tinker.loader.shareutil;

import java.util.ArrayList;

public class ShareArkHotDiffPatchInfo {
    public String name;
    public String patchMd5;
    public String path;

    public ShareArkHotDiffPatchInfo(String str, String str2, String str3) {
        this.name = str2;
        this.patchMd5 = str3;
        this.path = str;
    }

    public static void parseDiffPatchInfo(String str, ArrayList<ShareArkHotDiffPatchInfo> arrayList) {
        String[] split;
        if (!(str == null || arrayList == null)) {
            String[] split2 = str.split("\n");
            for (String str2 : split2) {
                if (str2 != null && str2.length() > 0 && (split = str2.split(",", 4)) != null && split.length >= 3) {
                    arrayList.add(new ShareArkHotDiffPatchInfo(split[1].trim(), split[0].trim(), split[2].trim()));
                }
            }
        }
    }

    public static boolean checkDiffPatchInfo(ShareArkHotDiffPatchInfo shareArkHotDiffPatchInfo) {
        if (shareArkHotDiffPatchInfo == null) {
            return false;
        }
        String str = shareArkHotDiffPatchInfo.name;
        String str2 = shareArkHotDiffPatchInfo.patchMd5;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.patchMd5);
        return stringBuffer.toString();
    }
}
