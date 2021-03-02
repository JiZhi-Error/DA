package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ShareResPatchInfo {
    public ArrayList<String> addRes = new ArrayList<>();
    public String arscBaseCrc = null;
    public ArrayList<String> deleteRes = new ArrayList<>();
    public HashMap<String, LargeModeInfo> largeModMap = new HashMap<>();
    public ArrayList<String> largeModRes = new ArrayList<>();
    public ArrayList<String> modRes = new ArrayList<>();
    public HashSet<Pattern> patterns = new HashSet<>();
    public String resArscMd5 = null;
    public HashMap<String, File> storeRes = new HashMap<>();

    public static class LargeModeInfo {
        public long crc;
        public File file = null;
        public String md5 = null;
    }

    public static void parseAllResPatchInfo(String str, ShareResPatchInfo shareResPatchInfo) {
        if (!(str == null || str.length() == 0)) {
            String[] split = str.split("\n");
            int i2 = 0;
            while (i2 < split.length) {
                String str2 = split[i2];
                if (str2 != null && str2.length() > 0) {
                    if (str2.startsWith(ShareConstants.RES_TITLE)) {
                        String[] split2 = str2.split(",", 3);
                        shareResPatchInfo.arscBaseCrc = split2[1];
                        shareResPatchInfo.resArscMd5 = split2[2];
                    } else if (str2.startsWith(ShareConstants.RES_PATTERN_TITLE)) {
                        for (int parseInt = Integer.parseInt(str2.split(":", 2)[1]); parseInt > 0; parseInt--) {
                            shareResPatchInfo.patterns.add(convertToPatternString(split[i2 + 1]));
                            i2++;
                        }
                    } else if (str2.startsWith(ShareConstants.RES_ADD_TITLE)) {
                        for (int parseInt2 = Integer.parseInt(str2.split(":", 2)[1]); parseInt2 > 0; parseInt2--) {
                            shareResPatchInfo.addRes.add(split[i2 + 1]);
                            i2++;
                        }
                    } else if (str2.startsWith(ShareConstants.RES_MOD_TITLE)) {
                        for (int parseInt3 = Integer.parseInt(str2.split(":", 2)[1]); parseInt3 > 0; parseInt3--) {
                            shareResPatchInfo.modRes.add(split[i2 + 1]);
                            i2++;
                        }
                    } else if (str2.startsWith(ShareConstants.RES_LARGE_MOD_TITLE)) {
                        for (int parseInt4 = Integer.parseInt(str2.split(":", 2)[1]); parseInt4 > 0; parseInt4--) {
                            String[] split3 = split[i2 + 1].split(",", 3);
                            String str3 = split3[0];
                            LargeModeInfo largeModeInfo = new LargeModeInfo();
                            largeModeInfo.md5 = split3[1];
                            largeModeInfo.crc = Long.parseLong(split3[2]);
                            shareResPatchInfo.largeModRes.add(str3);
                            shareResPatchInfo.largeModMap.put(str3, largeModeInfo);
                            i2++;
                        }
                    } else if (str2.startsWith(ShareConstants.RES_DEL_TITLE)) {
                        for (int parseInt5 = Integer.parseInt(str2.split(":", 2)[1]); parseInt5 > 0; parseInt5--) {
                            shareResPatchInfo.deleteRes.add(split[i2 + 1]);
                            i2++;
                        }
                    } else if (str2.startsWith(ShareConstants.RES_STORE_TITLE)) {
                        for (int parseInt6 = Integer.parseInt(str2.split(":", 2)[1]); parseInt6 > 0; parseInt6--) {
                            shareResPatchInfo.storeRes.put(split[i2 + 1], null);
                            i2++;
                        }
                    }
                }
                i2++;
            }
        }
    }

    public static boolean checkFileInPattern(HashSet<Pattern> hashSet, String str) {
        if (!hashSet.isEmpty()) {
            Iterator<Pattern> it = hashSet.iterator();
            while (it.hasNext()) {
                if (it.next().matcher(str).matches()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkResPatchInfo(ShareResPatchInfo shareResPatchInfo) {
        String str;
        if (shareResPatchInfo == null || (str = shareResPatchInfo.resArscMd5) == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    private static Pattern convertToPatternString(String str) {
        if (str.contains(".")) {
            str = str.replaceAll("\\.", "\\\\.");
        }
        if (str.contains("?")) {
            str = str.replaceAll("\\?", "\\.");
        }
        if (str.contains("*")) {
            str = str.replace("*", ".*");
        }
        return Pattern.compile(str);
    }

    public static void parseResPatchInfoFirstLine(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String str2 = str.split("\n")[0];
            if (str2 == null || str2.length() <= 0) {
                throw new TinkerRuntimeException("res meta Corrupted:".concat(String.valueOf(str)));
            }
            String[] split = str2.split(",", 3);
            shareResPatchInfo.arscBaseCrc = split[1];
            shareResPatchInfo.resArscMd5 = split[2];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("resArscMd5:" + this.resArscMd5 + "\n");
        stringBuffer.append("arscBaseCrc:" + this.arscBaseCrc + "\n");
        Iterator<Pattern> it = this.patterns.iterator();
        while (it.hasNext()) {
            stringBuffer.append(ShareConstants.RES_PATTERN_TITLE + it.next() + "\n");
        }
        Iterator<String> it2 = this.addRes.iterator();
        while (it2.hasNext()) {
            stringBuffer.append("addedSet:" + it2.next() + "\n");
        }
        Iterator<String> it3 = this.modRes.iterator();
        while (it3.hasNext()) {
            stringBuffer.append("modifiedSet:" + it3.next() + "\n");
        }
        Iterator<String> it4 = this.largeModRes.iterator();
        while (it4.hasNext()) {
            stringBuffer.append("largeModifiedSet:" + it4.next() + "\n");
        }
        Iterator<String> it5 = this.deleteRes.iterator();
        while (it5.hasNext()) {
            stringBuffer.append("deletedSet:" + it5.next() + "\n");
        }
        Iterator<String> it6 = this.storeRes.keySet().iterator();
        while (it6.hasNext()) {
            stringBuffer.append("storeSet:" + it6.next() + "\n");
        }
        return stringBuffer.toString();
    }
}
