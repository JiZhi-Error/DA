package com.tencent.mm.live.core.d;

import android.content.Context;
import android.content.res.AssetManager;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/live/core/util/LiveFilterUtil;", "", "()V", "ASSETS_ROOT", "", "FILTERS_PATH", "TAG", "filterCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getFilterCache", "()Ljava/util/HashMap;", "checkFilterPath", "", "checkFiltersPath", "copyAssets", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "filterId", "path", "filterName", "filter", "filterPath", "FilterInfo", "plugin-core_release"})
public final class a {
    private static final String hEL = (com.tencent.mm.loader.j.b.aKC() + "live/filters");
    private static final HashMap<Integer, String> hEM = new HashMap<>();
    public static final a hEN = new a();

    static {
        AppMethodBeat.i(196743);
        AppMethodBeat.o(196743);
    }

    private a() {
    }

    public static HashMap<Integer, String> aEU() {
        return hEM;
    }

    public static void aEV() {
        AppMethodBeat.i(196739);
        d.i(b.hEO);
        AppMethodBeat.o(196739);
    }

    private static void a(AssetManager assetManager, String str, String str2) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4 = null;
        AppMethodBeat.i(196740);
        Log.i("LiveCore.LiveFilterUtil", "copyAssets assetsPath:" + str + " localPath:" + str2);
        try {
            String[] list = assetManager.list(str);
            if (list == null) {
                AppMethodBeat.o(196740);
                return;
            }
            p.g(list, "assets.list(assetsPath) ?: return");
            if (list.length == 0) {
                InputStream open = assetManager.open(str);
                try {
                    InputStream inputStream = open;
                    OutputStream LM = s.LM(str2);
                    try {
                        OutputStream outputStream = LM;
                        p.g(inputStream, "input");
                        p.g(outputStream, "output");
                        kotlin.f.a.f(inputStream, outputStream);
                        kotlin.f.b.a(LM, null);
                        kotlin.f.b.a(open, null);
                        AppMethodBeat.o(196740);
                    } catch (Throwable th5) {
                        th2 = th5;
                        th3 = th;
                        kotlin.f.b.a(LM, th3);
                        AppMethodBeat.o(196740);
                        throw th2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    th4 = th;
                    kotlin.f.b.a(open, th4);
                    AppMethodBeat.o(196740);
                    throw th;
                }
            } else {
                s.boN(str2);
                for (String str3 : list) {
                    a(assetManager, str + '/' + str3, str2 + '/' + str3);
                }
                AppMethodBeat.o(196740);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("LiveCore.LiveFilterUtil", e2, "copyAssets", new Object[0]);
            AppMethodBeat.o(196740);
        }
    }

    public static String qM(int i2) {
        AppMethodBeat.i(196741);
        e.C0383e eVar = e.C0383e.hxP;
        if (i2 == e.C0383e.aCF()) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.cs9);
            p.g(string, "MMApplicationContext.get…nder_live_filter_default)");
            AppMethodBeat.o(196741);
            return string;
        }
        e.C0383e eVar2 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCG()) {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            String string2 = context2.getResources().getString(R.string.cs8);
            p.g(string2, "MMApplicationContext.get…finder_live_filter_baixi)");
            AppMethodBeat.o(196741);
            return string2;
        }
        e.C0383e eVar3 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCM()) {
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            String string3 = context3.getResources().getString(R.string.csb);
            p.g(string3, "MMApplicationContext.get…nder_live_filter_huaijiu)");
            AppMethodBeat.o(196741);
            return string3;
        }
        e.C0383e eVar4 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCH()) {
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            String string4 = context4.getResources().getString(R.string.csf);
            p.g(string4, "MMApplicationContext.get…finder_live_filter_qiuri)");
            AppMethodBeat.o(196741);
            return string4;
        }
        e.C0383e eVar5 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCI()) {
            Context context5 = MMApplicationContext.getContext();
            p.g(context5, "MMApplicationContext.getContext()");
            String string5 = context5.getResources().getString(R.string.csd);
            p.g(string5, "MMApplicationContext.get…inder_live_filter_meishi)");
            AppMethodBeat.o(196741);
            return string5;
        }
        e.C0383e eVar6 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCJ()) {
            Context context6 = MMApplicationContext.getContext();
            p.g(context6, "MMApplicationContext.getContext()");
            String string6 = context6.getResources().getString(R.string.cs_);
            p.g(string6, "MMApplicationContext.get…r_live_filter_fanchaleng)");
            AppMethodBeat.o(196741);
            return string6;
        }
        e.C0383e eVar7 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCL()) {
            Context context7 = MMApplicationContext.getContext();
            p.g(context7, "MMApplicationContext.getContext()");
            String string7 = context7.getResources().getString(R.string.csa);
            p.g(string7, "MMApplicationContext.get…der_live_filter_gangfeng)");
            AppMethodBeat.o(196741);
            return string7;
        }
        e.C0383e eVar8 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCK()) {
            Context context8 = MMApplicationContext.getContext();
            p.g(context8, "MMApplicationContext.getContext()");
            String string8 = context8.getResources().getString(R.string.csc);
            p.g(string8, "MMApplicationContext.get…der_live_filter_jiaojuan)");
            AppMethodBeat.o(196741);
            return string8;
        }
        AppMethodBeat.o(196741);
        return "";
    }

    public static int GD(String str) {
        AppMethodBeat.i(196742);
        if (p.j(str, hEL + "/lut.png")) {
            e.C0383e eVar = e.C0383e.hxP;
            int aCF = e.C0383e.aCF();
            AppMethodBeat.o(196742);
            return aCF;
        } else if (p.j(str, hEL + "/baixi.png")) {
            e.C0383e eVar2 = e.C0383e.hxP;
            int aCG = e.C0383e.aCG();
            AppMethodBeat.o(196742);
            return aCG;
        } else if (p.j(str, hEL + "/huaijiu.png")) {
            e.C0383e eVar3 = e.C0383e.hxP;
            int aCM = e.C0383e.aCM();
            AppMethodBeat.o(196742);
            return aCM;
        } else if (p.j(str, hEL + "/qiuri.jpg")) {
            e.C0383e eVar4 = e.C0383e.hxP;
            int aCH = e.C0383e.aCH();
            AppMethodBeat.o(196742);
            return aCH;
        } else if (p.j(str, hEL + "/meishi.jpg")) {
            e.C0383e eVar5 = e.C0383e.hxP;
            int aCI = e.C0383e.aCI();
            AppMethodBeat.o(196742);
            return aCI;
        } else if (p.j(str, hEL + "/fanchaleng.jpg")) {
            e.C0383e eVar6 = e.C0383e.hxP;
            int aCJ = e.C0383e.aCJ();
            AppMethodBeat.o(196742);
            return aCJ;
        } else if (p.j(str, hEL + "/gangfeng.jpg")) {
            e.C0383e eVar7 = e.C0383e.hxP;
            int aCL = e.C0383e.aCL();
            AppMethodBeat.o(196742);
            return aCL;
        } else if (p.j(str, hEL + "/jiaojuan.jpg")) {
            e.C0383e eVar8 = e.C0383e.hxP;
            int aCK = e.C0383e.aCK();
            AppMethodBeat.o(196742);
            return aCK;
        } else {
            AppMethodBeat.o(196742);
            return -1;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/live/core/util/LiveFilterUtil$FilterInfo;", "", "key", "", "path", "", "title", "value", "(ILjava/lang/String;Ljava/lang/String;I)V", "getKey", "()I", "getPath", "()Ljava/lang/String;", "getTitle", "getValue", "setValue", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-core_release"})
    /* renamed from: com.tencent.mm.live.core.d.a$a  reason: collision with other inner class name */
    public static final class C0387a {
        public final int key;
        public final String path;
        public final String title;
        public int value;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (r3.value == r4.value) goto L_0x002e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 196734(0x3007e, float:2.75683E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002e
                boolean r0 = r4 instanceof com.tencent.mm.live.core.d.a.C0387a
                if (r0 == 0) goto L_0x0033
                com.tencent.mm.live.core.d.a$a r4 = (com.tencent.mm.live.core.d.a.C0387a) r4
                int r0 = r3.key
                int r1 = r4.key
                if (r0 != r1) goto L_0x0033
                java.lang.String r0 = r3.path
                java.lang.String r1 = r4.path
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
                java.lang.String r0 = r3.title
                java.lang.String r1 = r4.title
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
                int r0 = r3.value
                int r1 = r4.value
                if (r0 != r1) goto L_0x0033
            L_0x002e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0032:
                return r0
            L_0x0033:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0032
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.core.d.a.C0387a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(196733);
            int i3 = this.key * 31;
            String str = this.path;
            int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
            String str2 = this.title;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i4 = ((hashCode + i2) * 31) + this.value;
            AppMethodBeat.o(196733);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(196732);
            String str = "FilterInfo(key=" + this.key + ", path=" + this.path + ", title=" + this.title + ", value=" + this.value + ")";
            AppMethodBeat.o(196732);
            return str;
        }

        public C0387a(int i2, String str, String str2, int i3) {
            p.h(str, "path");
            p.h(str2, "title");
            AppMethodBeat.i(196731);
            this.key = i2;
            this.path = str;
            this.title = str2;
            this.value = i3;
            AppMethodBeat.o(196731);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b hEO = new b();

        static {
            AppMethodBeat.i(196738);
            AppMethodBeat.o(196738);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(196737);
            a aVar = a.hEN;
            a.aEW();
            d.h(AnonymousClass1.hEP);
            x xVar = x.SXb;
            AppMethodBeat.o(196737);
            return xVar;
        }
    }

    public static final /* synthetic */ void aEW() {
        AppMethodBeat.i(196744);
        s.deleteDir(hEL);
        s.boN(hEL);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        AssetManager assets = context.getAssets();
        p.g(assets, "MMApplicationContext.getContext().assets");
        a(assets, ShareConstants.WEB_DIALOG_PARAM_FILTERS, hEL);
        AppMethodBeat.o(196744);
    }

    public static final /* synthetic */ String qN(int i2) {
        AppMethodBeat.i(196745);
        e.C0383e eVar = e.C0383e.hxP;
        if (i2 == e.C0383e.aCF()) {
            String str = hEL + "/lut.png";
            AppMethodBeat.o(196745);
            return str;
        }
        e.C0383e eVar2 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCG()) {
            String str2 = hEL + "/baixi.png";
            AppMethodBeat.o(196745);
            return str2;
        }
        e.C0383e eVar3 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCM()) {
            String str3 = hEL + "/huaijiu.png";
            AppMethodBeat.o(196745);
            return str3;
        }
        e.C0383e eVar4 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCH()) {
            String str4 = hEL + "/qiuri.jpg";
            AppMethodBeat.o(196745);
            return str4;
        }
        e.C0383e eVar5 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCI()) {
            String str5 = hEL + "/meishi.jpg";
            AppMethodBeat.o(196745);
            return str5;
        }
        e.C0383e eVar6 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCJ()) {
            String str6 = hEL + "/fanchaleng.jpg";
            AppMethodBeat.o(196745);
            return str6;
        }
        e.C0383e eVar7 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCL()) {
            String str7 = hEL + "/gangfeng.jpg";
            AppMethodBeat.o(196745);
            return str7;
        }
        e.C0383e eVar8 = e.C0383e.hxP;
        if (i2 == e.C0383e.aCK()) {
            String str8 = hEL + "/jiaojuan.jpg";
            AppMethodBeat.o(196745);
            return str8;
        }
        AppMethodBeat.o(196745);
        return "";
    }
}
