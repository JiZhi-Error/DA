package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.c.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.pluginsdk.location.d;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private static String JHA = "";
    public static String JHn = (ao.cVg() + "/fav_fileicon_video.png");
    public static String JHo = (ao.cVg() + "/fav_fileicon_music.png");
    public static String JHp = (ao.cVg() + "/fav_list_img_default.png");
    public static String JHq = (ao.cVg() + "/fav_fileicon_zip.png");
    public static String JHr = (ao.cVg() + "/fav_fileicon_word.png");
    public static String JHs = (ao.cVg() + "/fav_fileicon_ppt.png");
    public static String JHt = (ao.cVg() + "/fav_fileicon_xls.png");
    public static String JHu = (ao.cVg() + "/fav_fileicon_txt.png");
    public static String JHv = (ao.cVg() + "/fav_fileicon_pdf.png");
    public static String JHw = (ao.cVg() + "/fav_fileicon_unknow.png");
    private static String[] JHx = {"<div>", "<div/>", "<object", "<br", "</"};
    private static String[] JHy = {"＜div>", "＜div/>", "＜object", "＜br", "＜/"};
    private static LinkedList<amz> JHz = null;
    private static Map<String, String> oYD;

    private static void cf(JSONObject jSONObject) {
        AppMethodBeat.i(30328);
        od odVar = new od();
        odVar.dUq.type = 6;
        odVar.dUq.jsonString = jSONObject.toString();
        odVar.dUq.dUg = "";
        EventCenter.instance.publish(odVar);
        AppMethodBeat.o(30328);
    }

    public static void p(Context context, String str, int i2) {
        AppMethodBeat.i(30329);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(30329);
        } else if (!s.YS(str)) {
            AppMethodBeat.o(30329);
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                int AO = (int) f.AO((long) i2);
                jSONObject.put("type", 4);
                jSONObject.put("downloaded", true);
                jSONObject.put("length", AO);
                jSONObject.put("lengthStr", f.W(context, AO));
                jSONObject.put("iconPath", ao.cVg() + "/fav_fileicon_recording.png");
                cf(jSONObject);
                AppMethodBeat.o(30329);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
                AppMethodBeat.o(30329);
            }
        }
    }

    public static void bbR(String str) {
        AppMethodBeat.i(30330);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(30330);
        } else if (!s.YS(str)) {
            AppMethodBeat.o(30330);
        } else {
            o oVar = new o(str);
            if (!oVar.exists()) {
                AppMethodBeat.o(30330);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 5);
                jSONObject.put("downloaded", true);
                jSONObject.put("title", oVar.getName());
                jSONObject.put("content", f.getLengthStr((float) oVar.length()));
                jSONObject.put("iconPath", bbT(s.akC(str)));
                jSONObject.put("localPath", str);
                cf(jSONObject);
                AppMethodBeat.o(30330);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
                AppMethodBeat.o(30330);
            }
        }
    }

    public static void bbS(String str) {
        AppMethodBeat.i(30331);
        Log.i("MicroMsg.WNNoteLogic", "insert location run");
        JSONObject jSONObject = new JSONObject(str);
        Log.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
        String str2 = ao.cVi() + FilePathGenerator.ANDROID_DIR_SEP + g.getMessageDigest((new d(-1, (float) jSONObject.getDouble("lat"), (float) jSONObject.getDouble("lng"), jSONObject.getInt("scale"), 1).toString()).getBytes()) + ".png";
        Log.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", str2);
        if (s.YS(str2)) {
            Log.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
        }
        if (s.YS(str2)) {
            Log.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
        } else {
            Log.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", str2);
            str2 = d.qPi;
        }
        jSONObject.put("localPath", str2);
        cf(jSONObject);
        AppMethodBeat.o(30331);
    }

    public static void bf(ArrayList<String> arrayList) {
        AppMethodBeat.i(30332);
        JSONObject jSONObject = new JSONObject();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                jSONObject.put("type", 2);
                jSONObject.put("downloaded", true);
                String fJ = c.fJ(next, "");
                String fK = c.fK(next, "");
                if (Util.isNullOrNil(fJ) || Util.isNullOrNil(fK)) {
                    AppMethodBeat.o(30332);
                    return;
                }
                jSONObject.put("bigImagePath", fJ);
                jSONObject.put("localPath", fK);
                cf(jSONObject);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(30332);
    }

    public static void cb(Context context, String str) {
        AppMethodBeat.i(30333);
        JSONObject jSONObject = new JSONObject();
        if (!Util.isNullOrNil(str)) {
            int i2 = (int) k.gjD().duration;
            int AO = (int) f.AO((long) i2);
            try {
                jSONObject.put("downloaded", true);
                jSONObject.put("length", i2);
                jSONObject.put("lengthStr", f.W(context, AO));
                jSONObject.put("iconPath", ao.cVg() + "/fav_fileicon_recording.png");
                jSONObject.put("localPath", str);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
            }
        }
        try {
            jSONObject.put("type", 4);
        } catch (JSONException e3) {
            Log.printErrStackTrace("MicroMsg.WNNoteLogic", e3, "", new Object[0]);
        }
        int i3 = k.gjD().qPu;
        od odVar = new od();
        odVar.dUq.type = 6;
        odVar.dUq.jsonString = jSONObject.toString();
        odVar.dUq.dUg = Integer.toString(i3);
        EventCenter.instance.publish(odVar);
        AppMethodBeat.o(30333);
    }

    static {
        AppMethodBeat.i(30339);
        oYD = new HashMap();
        HashMap hashMap = new HashMap();
        oYD = hashMap;
        hashMap.put("avi", JHn);
        oYD.put("m4v", JHn);
        oYD.put("vob", JHn);
        oYD.put("mpeg", JHn);
        oYD.put("mpe", JHn);
        oYD.put("asx", JHn);
        oYD.put("asf", JHn);
        oYD.put("f4v", JHn);
        oYD.put("flv", JHn);
        oYD.put("mkv", JHn);
        oYD.put("wmv", JHn);
        oYD.put("wm", JHn);
        oYD.put("3gp", JHn);
        oYD.put("mp4", JHn);
        oYD.put("rmvb", JHn);
        oYD.put("rm", JHn);
        oYD.put("ra", JHn);
        oYD.put("ram", JHn);
        oYD.put("mp3pro", JHo);
        oYD.put("vqf", JHo);
        oYD.put("cd", JHo);
        oYD.put("md", JHo);
        oYD.put("mod", JHo);
        oYD.put("vorbis", JHo);
        oYD.put("au", JHo);
        oYD.put("amr", JHo);
        oYD.put("silk", JHo);
        oYD.put("wma", JHo);
        oYD.put("mmf", JHo);
        oYD.put("mid", JHo);
        oYD.put("midi", JHo);
        oYD.put("mp3", JHo);
        oYD.put("aac", JHo);
        oYD.put("ape", JHo);
        oYD.put("aiff", JHo);
        oYD.put("aif", JHo);
        oYD.put("jfif", JHp);
        oYD.put("tiff", JHp);
        oYD.put("tif", JHp);
        oYD.put("jpe", JHp);
        oYD.put("dib", JHp);
        oYD.put("jpeg", JHp);
        oYD.put("jpg", JHp);
        oYD.put("png", JHp);
        oYD.put("bmp", JHp);
        oYD.put("gif", JHp);
        oYD.put("rar", JHq);
        oYD.put("zip", JHq);
        oYD.put("7z", JHq);
        oYD.put("iso", JHq);
        oYD.put("cab", JHq);
        oYD.put("doc", JHr);
        oYD.put("docx", JHr);
        oYD.put("ppt", JHs);
        oYD.put("pptx", JHs);
        oYD.put("xls", JHt);
        oYD.put("xlsx", JHt);
        oYD.put("txt", JHu);
        oYD.put("rtf", JHu);
        oYD.put("pdf", JHv);
        oYD.put("unknown", JHw);
        AppMethodBeat.o(30339);
    }

    public static String bbT(String str) {
        AppMethodBeat.i(30334);
        String str2 = oYD.get(str);
        if (str2 == null) {
            String str3 = oYD.get("unknown");
            AppMethodBeat.o(30334);
            return str3;
        }
        AppMethodBeat.o(30334);
        return str2;
    }

    public static ArrayList<com.tencent.mm.plugin.wenote.model.a.c> a(Object obj, List<String> list, boolean z) {
        AppMethodBeat.i(30335);
        if (obj == null) {
            AppMethodBeat.o(30335);
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
            if (cVar.getType() != 1) {
                arrayList2.add(cVar);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (str.trim().equals("<ThisisNoteNodeHrObj>")) {
                com.tencent.mm.plugin.wenote.model.a.h hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                hVar.qPA = false;
                hVar.qPG = false;
                if (i2 < arrayList2.size()) {
                    arrayList2.add(i2, hVar);
                } else {
                    arrayList2.add(hVar);
                }
            } else if (!str.trim().equals("<ThisisNoteNodeObj>")) {
                i iVar = new i();
                iVar.content = str;
                iVar.qPA = false;
                iVar.qPG = false;
                iVar.dLl = f.alR(iVar.toString());
                if (i2 < arrayList2.size()) {
                    arrayList2.add(i2, iVar);
                } else {
                    arrayList2.add(iVar);
                }
            }
        }
        if (z) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        AppMethodBeat.o(30335);
        return arrayList2;
    }

    public static void aho(int i2) {
        LinkedList<amz> linkedList;
        AppMethodBeat.i(30336);
        JHz = null;
        JHA = "";
        String cDw = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDw();
        JHA = cDw;
        LinkedList<amz> linkedList2 = new LinkedList<>();
        anb alU = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().alU(cDw);
        if (alU == null || alU.ppH.size() <= 1) {
            linkedList = null;
        } else {
            Iterator<aml> it = alU.ppH.iterator();
            while (it.hasNext()) {
                aml next = it.next();
                String b2 = f.b(next);
                if (!Util.isNullOrNil(b2) && next.dataType == 2 && s.YS(b2)) {
                    amz amz = new amz();
                    amz.Md5 = next.LvE;
                    amz.AesKey = next.Lvp;
                    amz.LxW = next.KuR;
                    linkedList2.add(amz);
                }
            }
            linkedList = linkedList2;
        }
        JHz = linkedList;
        bg.azz().a(new b(i2, 1, JHA, JHz, null), 0);
        AppMethodBeat.o(30336);
    }

    public static void a(Context context, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(30337);
        String exportImagePath = AndroidMediaUtil.getExportImagePath("jpg");
        if (bitmap != null) {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, exportImagePath, true);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
                Log.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[5];
                objArr[0] = 0;
                objArr[1] = 0;
                objArr[2] = 0;
                objArr[3] = 3;
                objArr[4] = Integer.valueOf(z ? 1 : 0);
                hVar.a(14811, objArr);
                exportImagePath = "";
            }
        } else {
            Log.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr2 = new Object[5];
            objArr2[0] = 0;
            objArr2[1] = 0;
            objArr2[2] = 0;
            objArr2[3] = 1;
            objArr2[4] = Integer.valueOf(z ? 1 : 0);
            hVar2.a(14811, objArr2);
            exportImagePath = "";
        }
        if (!Util.isNullOrNil(exportImagePath)) {
            AndroidMediaUtil.refreshMediaScanner(exportImagePath, context);
        }
        o oVar = new o(exportImagePath);
        if (oVar.exists()) {
            long length = oVar.length() / 1024;
            int i2 = 0;
            int i3 = 0;
            if (bitmap != null) {
                i2 = bitmap.getWidth();
                i3 = bitmap.getHeight();
                bitmap.recycle();
            }
            amz amz = new amz();
            amz.Md5 = s.bhK(exportImagePath);
            bg.azz().a(new b(0, 2, JHA, JHz, amz), 0);
            com.tencent.mm.plugin.report.service.h hVar3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr3 = new Object[5];
            objArr3[0] = Integer.valueOf(i2);
            objArr3[1] = Integer.valueOf(i3);
            objArr3[2] = Long.valueOf(length);
            objArr3[3] = 0;
            objArr3[4] = Integer.valueOf(z ? 1 : 0);
            hVar3.a(14811, objArr3);
        }
        AppMethodBeat.o(30337);
    }

    public static void cc(Context context, String str) {
        AppMethodBeat.i(30338);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
            AppMethodBeat.o(30338);
            return;
        }
        cz czVar = new cz();
        wo woVar = new wo();
        woVar.ecC.ecF = str;
        woVar.ecC.ecG = czVar;
        woVar.ecC.url = "";
        EventCenter.instance.publish(woVar);
        if (!woVar.ecD.dFE) {
            if (czVar.dFZ.dGe == 0) {
                czVar.dFZ.dGe = R.string.c__;
            }
            com.tencent.mm.ui.base.h.n(context, czVar.dFZ.dGe, 0);
            AppMethodBeat.o(30338);
            return;
        }
        czVar.dFZ.activity = (Activity) context;
        czVar.dFZ.dGf = 28;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(30338);
    }
}
