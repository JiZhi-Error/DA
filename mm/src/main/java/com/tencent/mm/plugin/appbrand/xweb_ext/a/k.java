package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.a;
import com.tencent.mm.sticker.d;
import com.tencent.mm.sticker.e;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.m;
import kotlin.n.n;
import kotlin.s;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0016\u0010\u001e\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J(\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyAdapterCoreLogic;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseResApplyAdapterCoreLogic;", "()V", "STICKER_ELEMENT_RES_NAME_DELIMITER", "", "STICKER_ELEMENT_RES_NAME_DELIMITER_2", "STICKER_ELEMENT_RES_NAME_SUFFIX", "", "TAG", "stickerTransform", "Lcom/tencent/mm/sticker/StickerTransform;", "getStickerTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "stickerTransform$delegate", "Lkotlin/Lazy;", "convert2StickerApplyParams", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyParams;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "itemInfoList", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "copyStickerItemResourcesIfNeed", "", "itemResCount", "", "itemResDir", "Lcom/tencent/mm/vfs/VFSFile;", "itemName", "stickerResDir", "generateStickerResDirName", "realConvert2StickerApplyParams", "stickerType", "plugin-appbrand-integration_release"})
public final class k extends b {
    private static final f oGQ = g.ah(c.oGT);
    public static final k oGR = new k();

    static {
        AppMethodBeat.i(229747);
        AppMethodBeat.o(229747);
    }

    private k() {
    }

    public final m b(l.c cVar, List<StickerItemInfo> list) {
        String str;
        m mVar;
        AppMethodBeat.i(229744);
        p.h(cVar, "type");
        p.h(list, "itemInfoList");
        o oVar = new o(cdJ(), bZ(list));
        List a2 = j.a((Iterable) list, (Comparator) new b());
        ArrayList arrayList = new ArrayList(j.a(a2, 10));
        Iterator it = a2.iterator();
        while (true) {
            if (it.hasNext()) {
                StickerItemInfo stickerItemInfo = (StickerItemInfo) it.next();
                if (!a(stickerItemInfo.frameCount, new o(stickerItemInfo.cHM), stickerItemInfo.name, oVar)) {
                    mVar = null;
                    break;
                }
                String str2 = stickerItemInfo.name;
                d dVar = new d();
                dVar.setName(stickerItemInfo.name);
                dVar.len = stickerItemInfo.frameCount;
                dVar.NMN = stickerItemInfo.cHL.getJsonVal();
                if (l.c.STICKER_BACK == cVar) {
                    dVar.NMO = stickerItemInfo.cHP.getJsonVal();
                } else {
                    StickerItemInfo.a aVar = stickerItemInfo.cHO;
                    if (aVar != null) {
                        double[] dArr = {aVar.cHQ, aVar.cHR, aVar.cHS, aVar.cHT};
                        p.h(dArr, "<set-?>");
                        dVar.NMR = dArr;
                    }
                }
                arrayList.add(s.U(str2, dVar));
            } else {
                HashMap<String, d> hashMap = (HashMap) ae.a(arrayList, new HashMap());
                e eVar = new e();
                eVar.jgT = 1.0d;
                switch (l.$EnumSwitchMapping$0[cVar.ordinal()]) {
                    case 1:
                        str = "Sticker2D";
                        break;
                    case 2:
                        str = "StickerFixed";
                        break;
                    case 3:
                        str = "Segment";
                        break;
                    default:
                        m mVar2 = new m();
                        AppMethodBeat.o(229744);
                        throw mVar2;
                }
                eVar.setType(str);
                eVar.s(hashMap);
                if (l.c.STICKER_2D == cVar) {
                    eVar.a((com.tencent.mm.sticker.g) oGQ.getValue());
                }
                String absolutePath = new o(oVar, "config.json").getAbsolutePath();
                p.g(absolutePath, "stickerConfigFile.absolutePath");
                Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "realConvert2StickerApplyParams, stickerConfigPath: ".concat(String.valueOf(absolutePath)));
                a.C2063a aVar2 = com.tencent.mm.sticker.a.NMI;
                a.C2063a.a(eVar, absolutePath);
                String absolutePath2 = oVar.getAbsolutePath();
                p.g(absolutePath2, "stickerResDir.absolutePath");
                mVar = new m(cVar, absolutePath2);
            }
        }
        if (mVar == null) {
            com.tencent.mm.vfs.s.deleteDir(oVar.getAbsolutePath());
        }
        AppMethodBeat.o(229744);
        return mVar;
    }

    private static String bZ(List<StickerItemInfo> list) {
        AppMethodBeat.i(229745);
        Object[] array = list.toArray(new StickerItemInfo[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(229745);
            throw tVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (StickerItemInfo stickerItemInfo : (StickerItemInfo[]) array) {
            sb.append(stickerItemInfo.Qc());
            sb.append(", ");
        }
        sb.append(']');
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply(builderAction).toString()");
        Charset charset = kotlin.n.d.UTF_8;
        if (sb2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(229745);
            throw tVar2;
        }
        byte[] bytes = sb2.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(bytes);
        p.g(messageDigest, "MD5.getMessageDigest(ite…nfoListStr.toByteArray())");
        AppMethodBeat.o(229745);
        return messageDigest;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(229741);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.id), Integer.valueOf(t2.id));
            AppMethodBeat.o(229741);
            return a2;
        }
    }

    private static boolean a(int i2, o oVar, String str, o oVar2) {
        AppMethodBeat.i(229746);
        o oVar3 = new o(oVar2, str);
        com.tencent.mm.plugin.appbrand.jsapi.ag.c.d dVar = com.tencent.mm.plugin.appbrand.jsapi.ag.c.d.mJM;
        if (com.tencent.mm.plugin.appbrand.jsapi.ag.c.d.D(oVar3)) {
            Log.i("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, stickerItemDir(" + oVar3 + ") already exist");
            AppMethodBeat.o(229746);
            return true;
        }
        o[] b2 = oVar.b(new a(kotlin.k.j.mY(0, i2)));
        if (b2 == null) {
            b2 = new o[0];
        }
        p.g(b2, "itemResDir.listFiles { _…        } ?: emptyArray()");
        if (i2 != b2.length) {
            Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, can not find all res");
            AppMethodBeat.o(229746);
            return false;
        } else if (oVar3.exists() || oVar3.mkdirs()) {
            for (o oVar4 : b2) {
                p.g(oVar4, "itemResFile");
                String name = oVar4.getName();
                p.g(name, "itemResFile.name");
                Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, itemResName: ".concat(String.valueOf(name)));
                if (0 > com.tencent.mm.vfs.s.nw(oVar4.getAbsolutePath(), new o(oVar3, name).getAbsolutePath())) {
                    Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, copy fail");
                    AppMethodBeat.o(229746);
                    return false;
                }
            }
            com.tencent.mm.plugin.appbrand.jsapi.ag.c.d dVar2 = com.tencent.mm.plugin.appbrand.jsapi.ag.c.d.mJM;
            if (!com.tencent.mm.plugin.appbrand.jsapi.ag.c.d.C(oVar3)) {
                Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, record stickerItemDir fail");
                AppMethodBeat.o(229746);
                return false;
            }
            AppMethodBeat.o(229746);
            return true;
        } else {
            Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, create stickerItemDir fail");
            AppMethodBeat.o(229746);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
    public static final class a implements w {
        final /* synthetic */ kotlin.k.f oGS;

        a(kotlin.k.f fVar) {
            this.oGS = fVar;
        }

        @Override // com.tencent.mm.vfs.w
        public final boolean accept(o oVar, String str) {
            AppMethodBeat.i(229740);
            p.h(str, "name");
            List<String> a2 = n.a((CharSequence) str, new char[]{'.'});
            if (2 > a2.size() || (!p.j("png", (String) j.ku(a2)))) {
                Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, invalid res: ".concat(String.valueOf(str)));
                AppMethodBeat.o(229740);
                return false;
            }
            List<String> a3 = n.a((CharSequence) a2.get(0), new char[]{'_'});
            StringBuilder sb = new StringBuilder("copyStickerItemResourcesIfNeed, nameList2: ");
            Object[] array = a3.toArray(new String[0]);
            if (array == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(229740);
                throw tVar;
            }
            String arrays = Arrays.toString(array);
            p.g(arrays, "java.util.Arrays.toString(this)");
            Log.d("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", sb.append(arrays).toString());
            if (2 > a3.size()) {
                Log.w("MicroMsg.AppBrand.StickerApplyAdapterCoreLogic", "copyStickerItemResourcesIfNeed, invalid res: ".concat(String.valueOf(str)));
                AppMethodBeat.o(229740);
                return false;
            }
            kotlin.k.f fVar = this.oGS;
            Integer buA = n.buA((String) j.ku(a3));
            if (buA == null || !fVar.contains(buA.intValue())) {
                AppMethodBeat.o(229740);
                return false;
            }
            AppMethodBeat.o(229740);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sticker/StickerTransform;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<com.tencent.mm.sticker.g> {
        public static final c oGT = new c();

        static {
            AppMethodBeat.i(229743);
            AppMethodBeat.o(229743);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.sticker.g invoke() {
            AppMethodBeat.i(229742);
            com.tencent.mm.sticker.g gVar = new com.tencent.mm.sticker.g();
            double[] dArr = {4.335721d, -0.021943d, -2.150932d, 0.031819d, 21.920067d, -11.751821d, 0.0d, 0.0d, 1.0d};
            p.h(dArr, "<set-?>");
            gVar.NNz = dArr;
            double[] dArr2 = {7.069497d, -0.039278d, -3.505431d, 0.029885d, 10.946254d, -4.376129d, 0.0d, 0.0d, 1.0d};
            p.h(dArr2, "<set-?>");
            gVar.NNA = dArr2;
            double[] dArr3 = {7.069001d, -0.22088d, -3.501082d, 0.074695d, 27.359489d, -7.990312d, 0.0d, 0.0d, 1.0d};
            p.h(dArr3, "<set-?>");
            gVar.NNB = dArr3;
            double[] dArr4 = {1.430905d, -0.125584d, -0.692772d, 0.017179d, 9.884148d, -1.4595d, 0.0d, 0.0d, 1.0d};
            p.h(dArr4, "<set-?>");
            gVar.NNC = dArr4;
            AppMethodBeat.o(229742);
            return gVar;
        }
    }
}
