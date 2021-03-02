package com.tencent.mm.plugin.brandservice.ui.b;

import android.graphics.Paint;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u0017R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/util/BizTimeLineViewUtil;", "", "()V", "bizTimeLineTitleBold", "", "getBizTimeLineTitleBold", "()Z", "bizTimeLineTitleBold$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "onlyShowStatData", "getOnlyShowStatData", "onlyShowStatData$delegate", "setTextViewBold", "", "textView", "Landroid/widget/TextView;", "width", "", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-brandservice_release"})
public final class d {
    private static final f iBW = g.ah(b.pMA);
    public static final f pMw = g.ah(c.pMB);
    private static final f pMx = g.ah(a.pMz);
    public static final d pMy = new d();

    public static boolean crj() {
        AppMethodBeat.i(195998);
        boolean booleanValue = ((Boolean) pMx.getValue()).booleanValue();
        AppMethodBeat.o(195998);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(7364);
        AppMethodBeat.o(7364);
    }

    private d() {
    }

    public static void c(MMNeat7extView mMNeat7extView) {
        TextPaint paint;
        TextPaint paint2;
        AppMethodBeat.i(7362);
        if (!(mMNeat7extView == null || (paint2 = mMNeat7extView.getPaint()) == null)) {
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        if (mMNeat7extView == null || (paint = mMNeat7extView.getPaint()) == null) {
            AppMethodBeat.o(7362);
            return;
        }
        paint.setStrokeWidth(0.8f);
        AppMethodBeat.o(7362);
    }

    public static void i(TextView textView) {
        TextPaint paint;
        TextPaint paint2;
        AppMethodBeat.i(7363);
        if (!(textView == null || (paint2 = textView.getPaint()) == null)) {
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        if (textView == null || (paint = textView.getPaint()) == null) {
            AppMethodBeat.o(7363);
            return;
        }
        paint.setStrokeWidth(0.8f);
        AppMethodBeat.o(7363);
    }

    public static final /* synthetic */ MultiProcessMMKV crk() {
        AppMethodBeat.i(195999);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(195999);
        return multiProcessMMKV;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final b pMA = new b();

        static {
            AppMethodBeat.i(195995);
            AppMethodBeat.o(195995);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(195994);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(195994);
            return singleMMKV;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Boolean> {
        public static final c pMB = new c();

        static {
            AppMethodBeat.i(195997);
            AppMethodBeat.o(195997);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(195996);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_only_show_stat_data, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195996);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Boolean> {
        public static final a pMz = new a();

        static {
            AppMethodBeat.i(195993);
            AppMethodBeat.o(195993);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(195992);
            d dVar = d.pMy;
            int decodeInt = d.crk().decodeInt("BizTimeLineTitleBold", -1);
            if (decodeInt >= 0) {
                z = decodeInt == 1;
            } else {
                z = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_show_bold_title, 0) == 1;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195992);
            return valueOf;
        }
    }
}
