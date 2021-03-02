package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.HashMap;

public final class f {
    private static HashMap<String, Integer> JSK = null;

    public static int glU() {
        return R.raw.app_attach_file_icon_unknow;
    }

    public static int bcX(String str) {
        AppMethodBeat.i(133670);
        if (JSK == null) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            JSK = hashMap;
            hashMap.put("avi", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("m4v", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("vob", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("mpeg", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("mpe", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("asx", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("asf", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("f4v", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("flv", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("mkv", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("wmv", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("wm", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("3gp", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("mp4", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("rmvb", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("rm", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("ra", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("ram", Integer.valueOf((int) R.raw.app_attach_file_icon_video));
            JSK.put("mp3pro", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("vqf", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("cd", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("md", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("mod", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("vorbis", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("au", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("amr", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("silk", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("wma", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("mmf", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("mid", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("midi", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("mp3", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("aac", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("ape", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("aiff", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("aif", Integer.valueOf((int) R.raw.app_attach_file_icon_music));
            JSK.put("jfif", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("tiff", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("tif", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("jpe", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("dib", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("jpeg", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("jpg", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("png", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("bmp", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("gif", Integer.valueOf((int) R.drawable.bxc));
            JSK.put("rar", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
            JSK.put("zip", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
            JSK.put("7z", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
            JSK.put("iso", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
            JSK.put("cab", Integer.valueOf((int) R.raw.app_attach_file_icon_rar));
            JSK.put("doc", Integer.valueOf((int) R.raw.app_attach_file_icon_word));
            JSK.put("docx", Integer.valueOf((int) R.raw.app_attach_file_icon_word));
            JSK.put("ppt", Integer.valueOf((int) R.raw.app_attach_file_icon_ppt));
            JSK.put("pptx", Integer.valueOf((int) R.raw.app_attach_file_icon_ppt));
            JSK.put("xls", Integer.valueOf((int) R.raw.app_attach_file_icon_excel));
            JSK.put("xlsx", Integer.valueOf((int) R.raw.app_attach_file_icon_excel));
            JSK.put("txt", Integer.valueOf((int) R.raw.app_attach_file_icon_txt));
            JSK.put("rtf", Integer.valueOf((int) R.raw.app_attach_file_icon_txt));
            JSK.put("pdf", Integer.valueOf((int) R.raw.app_attach_file_icon_pdf));
        }
        Integer num = JSK.get(str);
        if (num == null) {
            AppMethodBeat.o(133670);
            return R.raw.app_attach_file_icon_unknow;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(133670);
        return intValue;
    }
}
