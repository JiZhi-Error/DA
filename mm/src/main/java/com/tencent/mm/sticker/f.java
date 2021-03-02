package com.tencent.mm.sticker;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\f\u00102\u001a\b\u0012\u0004\u0012\u00020403J\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0015J\u000e\u0010:\u001a\u0002082\u0006\u00109\u001a\u00020\u0015R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006<"}, hxF = {"Lcom/tencent/mm/sticker/StickerPack;", "", "()V", "additionStickers", "Ljava/util/ArrayList;", "Lcom/tencent/mm/sticker/StickerInfo;", "Lkotlin/collections/ArrayList;", "getAdditionStickers", "()Ljava/util/ArrayList;", "backgroundSticker", "getBackgroundSticker", "()Lcom/tencent/mm/sticker/StickerInfo;", "setBackgroundSticker", "(Lcom/tencent/mm/sticker/StickerInfo;)V", "faceTrackSticker", "getFaceTrackSticker", "setFaceTrackSticker", "foregroundSticker", "getForegroundSticker", "setForegroundSticker", "lensId", "", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "strokeColor", "getStrokeColor", "setStrokeColor", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "version", "", "getVersion", "()D", "setVersion", "(D)V", "allElement", "", "Lcom/tencent/mm/sticker/StickerElement;", "isValid", "", "parseFromLocal", "", "packDir", "parseFromPack", "Companion", "plugin-sticker_release"})
public final class f {
    public static final a NNw = new a((byte) 0);
    private static final String TAG = TAG;
    private g NMS = new g();
    public String NNr = "";
    public e NNs;
    public e NNt;
    public e NNu;
    public final ArrayList<e> NNv = new ArrayList<>();
    private String cHM = "";
    public String iyd = "";
    double jgT;
    public String rnS = "";
    public String title = "";

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/sticker/StickerInfo;", "path", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<String, List<? extends e>> {
        public static final b NNx = new b();

        static {
            AppMethodBeat.i(194219);
            AppMethodBeat.o(194219);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ List<? extends e> invoke(String str) {
            boolean z = true;
            AppMethodBeat.i(194218);
            String str2 = str;
            p.h(str2, "path");
            String[] list = new o(str2).list();
            if (list != null) {
                if (list.length == 0) {
                    z = false;
                }
                if (z) {
                    ArrayList arrayList = new ArrayList(list.length);
                    for (String str3 : list) {
                        e eVar = new e();
                        eVar.bip(str2 + str3 + '/');
                        a.C2063a aVar = a.NMI;
                        a.C2063a.a(eVar.cHM + "config.json", eVar);
                        arrayList.add(eVar);
                    }
                    ArrayList arrayList2 = arrayList;
                    AppMethodBeat.o(194218);
                    return arrayList2;
                }
            }
            v vVar = v.SXr;
            AppMethodBeat.o(194218);
            return vVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sticker/StickerInfo;", "type", "", "path", "invoke"})
    static final class c extends q implements m<String, String, e> {
        final /* synthetic */ f NNy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar) {
            super(2);
            this.NNy = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ e invoke(String str, String str2) {
            AppMethodBeat.i(194220);
            String str3 = str;
            String str4 = str2;
            p.h(str3, "type");
            p.h(str4, "path");
            e eVar = new e();
            String str5 = this.NNy.rnS;
            p.h(str5, "<set-?>");
            eVar.rnS = str5;
            eVar.jgT = this.NNy.jgT;
            eVar.setType(str3);
            eVar.bip(str4);
            AppMethodBeat.o(194220);
            return eVar;
        }
    }

    public f() {
        AppMethodBeat.i(105907);
        AppMethodBeat.o(105907);
    }

    public final void biq(String str) {
        AppMethodBeat.i(105903);
        p.h(str, "<set-?>");
        this.rnS = str;
        AppMethodBeat.o(105903);
    }

    public final void bip(String str) {
        AppMethodBeat.i(105904);
        p.h(str, "<set-?>");
        this.cHM = str;
        AppMethodBeat.o(105904);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/sticker/StickerPack$Companion;", "", "()V", "ADDITION_DIR", "", "BACKGROUND_DIR", "CLIENT_CACHE_VERSION", "", "CONFIG_FILE", "FACE_TRACK_DIR", "FOREGROUND_DIR", "KEY_ADDITION", "KEY_BACKGROUND", "KEY_CACHE_VERSION", "KEY_CUSTOM", "KEY_ELEMENTS", "KEY_FACE_TRACK", "KEY_FOREGROUND", "KEY_ID", "KEY_PARAMS", "KEY_SUBTITLE", "KEY_SUBTITLE_COLOR", "KEY_SUBTITLE_STROKE_COLOR", "KEY_VERSION", "TAG", "TYPE_3D", "TYPE_DEFORMATION", "TYPE_FACE_TRACK", "TYPE_FIXED", "TYPE_LIQUIFY", "TYPE_SEGMENT", "checkLocalCacheVersion", "", "packDir", "createByLocal", "Lcom/tencent/mm/sticker/StickerPack;", "plugin-sticker_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f bit(String str) {
            AppMethodBeat.i(194216);
            p.h(str, "packDir");
            f fVar = new f();
            fVar.bip(str);
            fVar.bir(str);
            AppMethodBeat.o(194216);
            return fVar;
        }

        public static boolean biu(String str) {
            AppMethodBeat.i(194217);
            p.h(str, "packDir");
            try {
                if (!s.YS(str + "config.json")) {
                    AppMethodBeat.o(194217);
                    return false;
                }
                int optInt = h.FE(s.boY(str + "config.json")).optInt("cache_version", 0);
                Log.i(f.TAG, "checkLocalCacheVersion: " + optInt + ", 2");
                if (optInt >= 2) {
                    AppMethodBeat.o(194217);
                    return true;
                }
                s.deleteDir(str);
                AppMethodBeat.o(194217);
                return false;
            } catch (Exception e2) {
                AppMethodBeat.o(194217);
                return false;
            }
        }
    }

    static {
        AppMethodBeat.i(105908);
        AppMethodBeat.o(105908);
    }

    public final boolean isValid() {
        AppMethodBeat.i(194221);
        if (this.NNs == null && this.NNt == null && this.NNu == null && this.NNv.size() <= 0) {
            AppMethodBeat.o(194221);
            return false;
        }
        AppMethodBeat.o(194221);
        return true;
    }

    public final void bir(String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(105905);
        p.h(str, "packDir");
        try {
            JSONObject FE = h.FE(s.boY(str + "config.json"));
            String string = FE.getString("id");
            p.g(string, "jsonObj.getString(KEY_ID)");
            this.rnS = string;
            this.jgT = FE.getDouble("version");
            String optString = FE.optString(MessengerShareContentUtility.SUBTITLE);
            p.g(optString, "jsonObj.optString(KEY_SUBTITLE)");
            this.title = optString;
            String optString2 = FE.optString("subtitle_color");
            p.g(optString2, "jsonObj.optString(KEY_SUBTITLE_COLOR)");
            this.iyd = optString2;
            String optString3 = FE.optString("stroke_color");
            p.g(optString3, "jsonObj.optString(KEY_SUBTITLE_STROKE_COLOR)");
            this.NNr = optString3;
            String optString4 = FE.optString("face_track");
            String optString5 = FE.optString("background");
            String optString6 = FE.optString("foreground");
            String optString7 = FE.optString("addition");
            String str2 = optString4;
            if (!(str2 == null || str2.length() == 0)) {
                e eVar = new e();
                eVar.bip(str + "face_track/");
                a.C2063a aVar = a.NMI;
                a.C2063a.a(eVar.cHM + "config.json", eVar);
                this.NNs = eVar;
            }
            String str3 = optString5;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                e eVar2 = new e();
                eVar2.bip(str + "background/");
                a.C2063a aVar2 = a.NMI;
                a.C2063a.a(eVar2.cHM + "config.json", eVar2);
                this.NNt = eVar2;
            }
            String str4 = optString6;
            if (str4 == null || str4.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                e eVar3 = new e();
                eVar3.bip(str + "foreground/");
                a.C2063a aVar3 = a.NMI;
                a.C2063a.a(eVar3.cHM + "config.json", eVar3);
                this.NNu = eVar3;
            }
            b bVar = b.NNx;
            String str5 = optString7;
            if (!(str5 == null || str5.length() == 0)) {
                this.NNv.clear();
                this.NNv.addAll((Collection) bVar.invoke(str + optString7));
                AppMethodBeat.o(105905);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(105905);
    }

    public final void bis(String str) {
        AppMethodBeat.i(105906);
        p.h(str, "packDir");
        try {
            JSONObject FE = h.FE(s.boY(str + "config.json"));
            Log.i(TAG, "parseFromPack: ".concat(String.valueOf(FE)));
            this.jgT = FE.getDouble("version");
            JSONObject optJSONObject = FE.optJSONObject("custom");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(MessengerShareContentUtility.SUBTITLE);
                p.g(optString, "custom.optString(KEY_SUBTITLE)");
                this.title = optString;
                String optString2 = optJSONObject.optString("subtitle_color");
                p.g(optString2, "custom.optString(KEY_SUBTITLE_COLOR)");
                this.iyd = optString2;
                String optString3 = optJSONObject.optString("stroke_color");
                p.g(optString3, "custom.optString(KEY_SUBTITLE_STROKE_COLOR)");
                this.NNr = optString3;
            }
            JSONObject jSONObject = FE.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
            JSONArray jSONArray = jSONObject.getJSONArray(MessengerShareContentUtility.ELEMENTS);
            HashMap<String, d> hashMap = new HashMap<>();
            HashMap<String, d> hashMap2 = new HashMap<>();
            HashMap<String, d> hashMap3 = new HashMap<>();
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            HashMap hashMap6 = new HashMap();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                JSONObject jSONObject2 = jSONObject.getJSONObject(string);
                d dVar = new d();
                p.g(string, "name");
                dVar.setName(string);
                p.g(jSONObject2, "elementObj");
                dVar.au(jSONObject2);
                switch (dVar.NMP) {
                    case 0:
                        hashMap.put(string, dVar);
                        break;
                    case 1:
                        hashMap3.put(string, dVar);
                        break;
                    case 2:
                        hashMap2.put(string, dVar);
                        break;
                    case 3:
                        hashMap4.put(string, dVar);
                        break;
                    case 4:
                        hashMap5.put(string, dVar);
                        break;
                    case 5:
                        hashMap6.put(string, dVar);
                        break;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("template_trans_set");
            if (optJSONObject2 != null) {
                this.NMS.au(optJSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", this.rnS).put("version", this.jgT).put("cache_version", 2).put(MessengerShareContentUtility.SUBTITLE, this.title).put("subtitle_color", this.iyd).put("stroke_color", this.NNr);
            c cVar = new c(this);
            if (hashMap.size() > 0) {
                Object invoke = cVar.invoke("Sticker2D", "face_track/");
                e eVar = (e) invoke;
                eVar.a(this.NMS);
                s.boN(eVar.cHM);
                eVar.s(hashMap);
                for (Map.Entry<String, d> entry : hashMap.entrySet()) {
                    s.cL(this.cHM + entry.getKey(), this.cHM + eVar.cHM + entry.getKey());
                }
                a.C2063a aVar = a.NMI;
                a.C2063a.a(eVar, this.cHM + eVar.cHM + "config.json");
                jSONObject3.put("face_track", eVar.cHM);
                x xVar = x.SXb;
                this.NNs = (e) invoke;
            }
            if (hashMap2.size() > 0) {
                Object invoke2 = cVar.invoke("Segment", "background/");
                e eVar2 = (e) invoke2;
                s.boN(eVar2.cHM);
                eVar2.s(hashMap2);
                for (Map.Entry<String, d> entry2 : hashMap2.entrySet()) {
                    s.cL(this.cHM + entry2.getKey(), this.cHM + eVar2.cHM + entry2.getKey());
                }
                a.C2063a aVar2 = a.NMI;
                a.C2063a.a(eVar2, this.cHM + eVar2.cHM + "config.json");
                jSONObject3.put("background", eVar2.cHM);
                x xVar2 = x.SXb;
                this.NNt = (e) invoke2;
            }
            if (hashMap3.size() > 0) {
                Object invoke3 = cVar.invoke("StickerFixed", "foreground/");
                e eVar3 = (e) invoke3;
                s.boN(eVar3.cHM);
                eVar3.s(hashMap3);
                for (Map.Entry<String, d> entry3 : hashMap3.entrySet()) {
                    s.cL(this.cHM + entry3.getKey(), this.cHM + eVar3.cHM + entry3.getKey());
                }
                a.C2063a aVar3 = a.NMI;
                a.C2063a.a(eVar3, this.cHM + eVar3.cHM + "config.json");
                jSONObject3.put("foreground", eVar3.cHM);
                x xVar3 = x.SXb;
                this.NNu = (e) invoke3;
            }
            this.NNv.clear();
            ArrayList<e> arrayList = this.NNv;
            HashMap hashMap7 = hashMap4;
            ArrayList arrayList2 = new ArrayList(hashMap7.size());
            for (Map.Entry entry4 : hashMap7.entrySet()) {
                Object invoke4 = cVar.invoke("FaceDeformation", this.cHM + "addition/" + ((String) entry4.getKey()));
                s.cL(this.cHM + ((String) entry4.getKey()), ((e) invoke4).cHM);
                x xVar4 = x.SXb;
                arrayList2.add((e) invoke4);
            }
            arrayList.addAll(arrayList2);
            ArrayList<e> arrayList3 = this.NNv;
            HashMap hashMap8 = hashMap5;
            ArrayList arrayList4 = new ArrayList(hashMap8.size());
            for (Map.Entry entry5 : hashMap8.entrySet()) {
                Object invoke5 = cVar.invoke("FaceLiquify", this.cHM + "addition/" + ((String) entry5.getKey()));
                s.cL(this.cHM + ((String) entry5.getKey()), ((e) invoke5).cHM);
                x xVar5 = x.SXb;
                arrayList4.add((e) invoke5);
            }
            arrayList3.addAll(arrayList4);
            ArrayList<e> arrayList5 = this.NNv;
            HashMap hashMap9 = hashMap6;
            ArrayList arrayList6 = new ArrayList(hashMap9.size());
            for (Map.Entry entry6 : hashMap9.entrySet()) {
                Object invoke6 = cVar.invoke("Sticker3D", this.cHM + "addition/" + ((String) entry6.getKey()));
                s.cL(this.cHM + ((String) entry6.getKey()), ((e) invoke6).cHM);
                x xVar6 = x.SXb;
                arrayList6.add((e) invoke6);
            }
            arrayList5.addAll(arrayList6);
            if (this.NNv.size() > 0) {
                jSONObject3.put("addition", "addition/");
            }
            String str2 = this.cHM + "config.json";
            String jSONObject4 = jSONObject3.toString();
            p.g(jSONObject4, "saveJson.toString()");
            Charset charset = d.UTF_8;
            if (jSONObject4 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(105906);
                throw tVar;
            }
            byte[] bytes = jSONObject4.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            s.C(str2, bytes);
            AppMethodBeat.o(105906);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(105906);
        }
    }
}
