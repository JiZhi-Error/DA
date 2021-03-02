package com.tencent.mm.plugin.gallery.model;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class e {
    private static int ckU = 0;
    public static boolean xik = false;
    public static boolean xil = false;
    public static boolean xim = false;
    public static boolean xin = false;
    private static volatile e xir = null;
    private o wmZ;
    private c xig;
    private g xih;
    private ArrayList<GalleryItem.MediaItem> xii = null;
    private LinkedHashSet<GalleryItem.MediaItem> xij = new LinkedHashSet<>();
    private HashSet<GalleryItem.MediaItem> xio = new HashSet<>();
    private ArrayList<Bundle> xip = new ArrayList<>();
    private HashMap<Integer, Boolean> xiq = new HashMap<>();
    private SparseArray<GalleryItem.a> xis = new SparseArray<>();

    public static GalleryItem.MediaItem ayS(String str) {
        int indexOf;
        AppMethodBeat.i(111260);
        GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(0, 0, str, "", "");
        if (dQI().xii == null || (indexOf = dQI().xii.indexOf(a2)) < 0) {
            AppMethodBeat.o(111260);
            return null;
        }
        GalleryItem.MediaItem mediaItem = dQI().xii.get(indexOf);
        AppMethodBeat.o(111260);
        return mediaItem;
    }

    private e() {
        AppMethodBeat.i(111261);
        if (this.wmZ == null) {
            this.wmZ = new o();
        }
        if (this.xih == null) {
            this.xih = new g();
        }
        if (this.xig == null) {
            this.xig = new c();
        }
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_album_local_name, "");
        Log.i("MicroMsg.GalleryCore", "localAlbumName: %s.", a2);
        try {
            f FI = new i(a2).FI("localAlbumName");
            for (int i2 = 0; i2 < FI.length(); i2++) {
                i pZ = FI.pZ(i2);
                GalleryItem.a aVar = new GalleryItem.a();
                aVar.key = pZ.optString("key");
                aVar.path = pZ.optString("path");
                aVar.xiU = pZ.optString(BuildConfig.KINDA_DEFAULT);
                aVar.xiV = d.azj(aVar.path);
                Log.d("MicroMsg.GalleryCore", "albumName info: %s.", aVar);
                this.xis.put(aVar.xiV, aVar);
            }
            AppMethodBeat.o(111261);
        } catch (Exception e2) {
            AppMethodBeat.o(111261);
        }
    }

    public static SparseArray<GalleryItem.a> dQH() {
        AppMethodBeat.i(173729);
        SparseArray<GalleryItem.a> sparseArray = dQI().xis;
        AppMethodBeat.o(173729);
        return sparseArray;
    }

    private static e dQI() {
        AppMethodBeat.i(111262);
        if (xir == null) {
            xir = new e();
        }
        e eVar = xir;
        AppMethodBeat.o(111262);
        return eVar;
    }

    public static c dQJ() {
        AppMethodBeat.i(111263);
        if (dQI().xig == null) {
            dQI().xig = new c();
        }
        c cVar = dQI().xig;
        AppMethodBeat.o(111263);
        return cVar;
    }

    public static o dQK() {
        AppMethodBeat.i(111264);
        if (dQI().wmZ == null) {
            dQI().wmZ = new o();
        }
        o oVar = dQI().wmZ;
        AppMethodBeat.o(111264);
        return oVar;
    }

    public static g dQL() {
        AppMethodBeat.i(111265);
        if (dQI().xih == null) {
            dQI().xih = new g();
        }
        g gVar = dQI().xih;
        AppMethodBeat.o(111265);
        return gVar;
    }

    public static ArrayList<GalleryItem.MediaItem> dQM() {
        AppMethodBeat.i(261885);
        ArrayList<GalleryItem.MediaItem> arrayList = dQI().xii;
        AppMethodBeat.o(261885);
        return arrayList;
    }

    public static HashSet<GalleryItem.MediaItem> dQN() {
        AppMethodBeat.i(111267);
        HashSet<GalleryItem.MediaItem> hashSet = dQI().xio;
        AppMethodBeat.o(111267);
        return hashSet;
    }

    public static ArrayList<Bundle> dQO() {
        AppMethodBeat.i(111268);
        ArrayList<Bundle> arrayList = dQI().xip;
        AppMethodBeat.o(111268);
        return arrayList;
    }

    public static LinkedHashSet<GalleryItem.MediaItem> dQP() {
        AppMethodBeat.i(111269);
        LinkedHashSet<GalleryItem.MediaItem> linkedHashSet = dQI().xij;
        AppMethodBeat.o(111269);
        return linkedHashSet;
    }

    public static void ao(ArrayList<GalleryItem.MediaItem> arrayList) {
        AppMethodBeat.i(111270);
        dQI().xii = arrayList;
        AppMethodBeat.o(111270);
    }

    public static void NA(int i2) {
        AppMethodBeat.i(111271);
        dQI().xiq.put(Integer.valueOf(i2), Boolean.TRUE);
        AppMethodBeat.o(111271);
    }

    public static void dQQ() {
        AppMethodBeat.i(111272);
        dQI().xiq.clear();
        AppMethodBeat.o(111272);
    }

    public static int dQR() {
        AppMethodBeat.i(111273);
        int size = dQI().xiq.size();
        AppMethodBeat.o(111273);
        return size;
    }

    public static void g(int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(111274);
        Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", Integer.valueOf(i2), Boolean.valueOf(z));
        if (dQK().mcq == 3) {
            i3 = 1;
        } else if (dQK().mcq == 4) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (dQI().xio != null) {
            i4 = dQI().xio.size();
        } else {
            i4 = 0;
        }
        Log.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4));
        if (i4 > 0) {
            d.bw(13858, i3 + "," + i2 + "," + i4 + ",0");
        }
        Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", Boolean.valueOf(d.dSx()));
        Iterator<Bundle> it = dQI().xip.iterator();
        while (it.hasNext()) {
            Bundle next = it.next();
            String string = next.getString("after_photo_edit");
            if (!z2) {
                Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", string);
                s.deleteFile(string);
                AndroidMediaUtil.refreshMediaScanner(string, MMApplicationContext.getContext());
            }
            int i7 = next.getInt("report_info_emotion_count");
            int i8 = next.getInt("report_info_text_count");
            int i9 = next.getInt("report_info_mosaic_count");
            int i10 = next.getInt("report_info_doodle_count");
            boolean z3 = next.getBoolean("report_info_iscrop");
            int i11 = next.getInt("report_info_undo_count");
            boolean z4 = next.getBoolean("report_info_is_rotation");
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i7);
            objArr[1] = Integer.valueOf(i8);
            objArr[2] = Integer.valueOf(i9);
            objArr[3] = Integer.valueOf(i10);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            objArr[5] = Integer.valueOf(i11);
            objArr[6] = Integer.valueOf(z4 ? 1 : 0);
            Log.i("MicroMsg.GalleryCore", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s", objArr);
            if (i4 > 0) {
                StringBuilder append = new StringBuilder().append(i3).append(",").append(z).append(",").append(i7).append(",").append(i8).append(",").append(i9).append(",").append(i10).append(",");
                if (z3) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                StringBuilder append2 = append.append(i5).append(",").append(i11).append(",2");
                if (z4) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                d.bw(13857, append2.append(i6).toString());
            }
        }
        AppMethodBeat.o(111274);
    }

    public static void a(String str, int[] iArr, boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(111275);
        int i3 = dQK().mcq;
        switch (i3) {
            case 3:
                i2 = 1;
                break;
            case 4:
                if (!Util.isNullOrNil(str) && str.equals(MMApplicationContext.getContext().getString(R.string.c8z))) {
                    i2 = 6;
                    break;
                } else {
                    i2 = 2;
                    break;
                }
                break;
            case 7:
            case 8:
            case 15:
                i2 = 3;
                break;
            default:
                i2 = 0;
                break;
        }
        Log.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", Integer.valueOf(i3));
        d.bw(14205, i2 + "," + i2 + "," + iArr[0] + "," + iArr[1] + "," + iArr[2] + "," + iArr[3] + "," + z + "," + z2 + "," + xik + "," + xil + "," + xim + "," + xin);
        xik = false;
        xil = false;
        xim = false;
        xin = false;
        AppMethodBeat.o(111275);
    }

    public static void dQS() {
        AppMethodBeat.i(111276);
        ckU++;
        Log.i("MicroMsg.GalleryCore", "pennqin, refGallery %d.", Integer.valueOf(ckU));
        AppMethodBeat.o(111276);
    }

    public static boolean dQT() {
        AppMethodBeat.i(111277);
        if (ckU > 0) {
            ckU--;
        }
        Log.i("MicroMsg.GalleryCore", "pennqin, defGallery %d.", Integer.valueOf(ckU));
        if (ckU == 0) {
            if (!(xir == null || xir.xih == null || xir.xig == null)) {
                if (ckU != 0) {
                    Log.w("MicroMsg.GalleryCore", "oh, ref count not right!!! Maybe because quick enter/back.");
                } else {
                    if (dQI().xig != null) {
                        p.a aVar = p.xjw;
                        p dRt = p.dRt();
                        dRt.xjs.clear();
                        dRt.xjt.clear();
                        dQJ().dQE();
                        xir.xig.b(null);
                        d dVar = xir.xig.xhN;
                        if (dVar.xib != null) {
                            dVar.xib.a(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0082: INVOKE  
                                  (wrap: com.tencent.mm.b.f<java.lang.String, com.tencent.mm.plugin.gallery.model.d$a> : 0x007b: IGET  (r2v22 com.tencent.mm.b.f<java.lang.String, com.tencent.mm.plugin.gallery.model.d$a>) = (r1v39 'dVar' com.tencent.mm.plugin.gallery.model.d) com.tencent.mm.plugin.gallery.model.d.xib com.tencent.mm.b.f)
                                  (wrap: com.tencent.mm.plugin.gallery.model.d$4 : 0x007f: CONSTRUCTOR  (r3v6 com.tencent.mm.plugin.gallery.model.d$4) = (r1v39 'dVar' com.tencent.mm.plugin.gallery.model.d) call: com.tencent.mm.plugin.gallery.model.d.4.<init>(com.tencent.mm.plugin.gallery.model.d):void type: CONSTRUCTOR)
                                 type: INTERFACE call: com.tencent.mm.b.f.a(com.tencent.mm.b.f$a):void in method: com.tencent.mm.plugin.gallery.model.e.dQT():boolean, file: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007f: CONSTRUCTOR  (r3v6 com.tencent.mm.plugin.gallery.model.d$4) = (r1v39 'dVar' com.tencent.mm.plugin.gallery.model.d) call: com.tencent.mm.plugin.gallery.model.d.4.<init>(com.tencent.mm.plugin.gallery.model.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.gallery.model.e.dQT():boolean, file: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 41 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.gallery.model.d, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 47 more
                                */
                            /*
                            // Method dump skipped, instructions count: 387
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.e.dQT():boolean");
                        }
                    }
