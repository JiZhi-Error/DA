package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.f;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.b;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveLogoAnim;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.d;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0018\u0018\u0000 N2\u00020\u0001:\u0001NB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u000207H\u0002J\b\u0010:\u001a\u000207H\u0002J\b\u0010;\u001a\u000207H\u0002J\b\u0010<\u001a\u000207H\u0002J\u001a\u0010=\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010>\u001a\u000207J\b\u0010?\u001a\u000207H\u0002J\u000e\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020\u000eJ\u0010\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u000207H\u0002J\u0010\u0010D\u001a\u0002072\b\b\u0002\u0010E\u001a\u00020\tJ\u0010\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020\u000eH\u0002J\b\u0010H\u001a\u000207H\u0002J\b\u0010I\u001a\u000207H\u0002J\u001a\u0010J\u001a\u0002072\b\b\u0002\u0010E\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\tJ\u0012\u0010L\u001a\u0002072\b\b\u0002\u0010E\u001a\u00020\tH\u0002J\b\u00105\u001a\u000207H\u0002J\u0012\u00105\u001a\u0002072\b\b\u0002\u0010E\u001a\u00020\tH\u0002J\u0006\u0010M\u001a\u000207R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\t8BX\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\t8BX\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u000e\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u0004\u0018\u00010\t8BX\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b-\u0010\u0012R\u001a\u0010.\u001a\u0004\u0018\u00010\t8BX\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b/\u0010\u0012R\u000e\u00100\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customerBgDrawable", "Landroid/graphics/drawable/Drawable;", "desc", "", "descColor", "descH", "getDescH", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "descMarginBottom", "descMarginLeft", "descMarginRight", "descMarginTop", "descTextBold", "", "descTextSize", "descW", "getDescW", "logoAnimAutoPlay", "logoAnimation", "Lorg/libpag/PAGView;", "logoAnimationFile", "logoColor", "logoDesc", "Landroid/widget/TextView;", "logoImage", "Landroid/widget/ImageView;", "logoImgId", "logoMarginBottom", "logoMarginLeft", "logoMarginRight", "logoMarginTop", "logoStyle", "logoViewH", "getLogoViewH", "logoViewW", "getLogoViewW", "mode", "pngAnimation", "Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim;", "showLogoAnim", "showLogoImg", "showPngAnim", "checkState", "", "hideAnim", "hideDesc", "hideImage", "hidePngAnim", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initAttribute", "playAnim", "setBackground", "setText", "text", "setVisibility", "visibility", "showAnim", "colorId", "showDebugLog", "msg", "showDesc", "showImage", "showLogo", "imageId", "showPagAnim", "stopAnim", "Companion", "plugin-finder_release"})
public final class FinderLiveOnliveWidget extends LinearLayout {
    private static final String TAG = TAG;
    public static final a wnW = new a((byte) 0);
    private String desc;
    private int mode;
    private TextView wnA;
    private Integer wnB = 0;
    private Integer wnC = 0;
    private int wnD;
    private int wnE;
    private int wnF;
    private int wnG;
    private int wnH;
    private boolean wnI;
    private boolean wnJ;
    private boolean wnK;
    private boolean wnL;
    private int wnM;
    private Integer wnN = 0;
    private Integer wnO = 0;
    private int wnP;
    private int wnQ;
    private int wnR;
    private int wnS;
    private int wnT;
    private int wnU = d.e(getContext(), 10.0f);
    private boolean wnV;
    private int wnu = 3;
    private Drawable wnv;
    private String wnw;
    private PAGView wnx;
    private FinderLiveLogoAnim wny;
    private ImageView wnz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget$Companion;", "", "()V", "DEFAULT_RED_ANIMATION_FILE", "", "DEFAULT_WHITE_ANIMATION_FILE", "LOGO_ANIM", "", "LOGO_IMAGE", "LOGO_PNG_ANIM", "MODE_CARD_ONLIVE", "MODE_FINISH_STAGGERED_GRID_MASK", "MODE_FINISH_TIME_LINE_MASK", "MODE_NONE", "MODE_ONLIVE_LIGHT_RED", "MODE_ONLIVE_RED", "TAG", "getTAG", "()Ljava/lang/String;", "isEnabled", "", "loadPagLib", "", "tryLoadLibrary", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean isEnabled() {
            AppMethodBeat.i(254865);
            com.tencent.mm.plugin.expansions.d dVar = com.tencent.mm.plugin.expansions.d.rNG;
            boolean aoc = com.tencent.mm.plugin.expansions.d.aoc("xlab");
            AppMethodBeat.o(254865);
            return aoc;
        }
    }

    static {
        AppMethodBeat.i(254883);
        Log.i(TAG, "tryLoadLibrary pag start " + ChannelUtil.isGPVersion());
        if (!ChannelUtil.isGPVersion() || a.isEnabled()) {
            if (!g.aAc()) {
                Log.e(TAG, "loadPagLib account is not ready");
            } else {
                h.INSTANCE.n(1279, 200, 1);
                com.tencent.mm.plugin.expansions.d dVar = com.tencent.mm.plugin.expansions.d.rNG;
                com.tencent.mm.plugin.expansions.d.aoa("pag");
                h.INSTANCE.n(1279, 201, 1);
            }
        }
        Log.i(TAG, "tryLoadLibrary pag end");
        AppMethodBeat.o(254883);
    }

    private final Integer getLogoViewW() {
        AppMethodBeat.i(254866);
        Integer num = this.wnB;
        if ((num != null && num.intValue() == 0) || this.wnB == null) {
            AppMethodBeat.o(254866);
            return -1;
        }
        Integer num2 = this.wnB;
        AppMethodBeat.o(254866);
        return num2;
    }

    private final Integer getLogoViewH() {
        AppMethodBeat.i(254867);
        Integer num = this.wnC;
        if ((num != null && num.intValue() == 0) || this.wnC == null) {
            AppMethodBeat.o(254867);
            return -1;
        }
        Integer num2 = this.wnC;
        AppMethodBeat.o(254867);
        return num2;
    }

    private final Integer getDescW() {
        AppMethodBeat.i(254868);
        Integer num = this.wnN;
        if ((num != null && num.intValue() == 0) || this.wnN == null) {
            AppMethodBeat.o(254868);
            return -2;
        }
        Integer num2 = this.wnN;
        AppMethodBeat.o(254868);
        return num2;
    }

    private final Integer getDescH() {
        AppMethodBeat.i(254869);
        Integer num = this.wnO;
        if ((num != null && num.intValue() == 0) || this.wnO == null) {
            AppMethodBeat.o(254869);
            return -2;
        }
        Integer num2 = this.wnO;
        AppMethodBeat.o(254869);
        return num2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveOnliveWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254881);
        b(attributeSet, 0);
        init();
        AppMethodBeat.o(254881);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveOnliveWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254882);
        b(attributeSet, i2);
        init();
        AppMethodBeat.o(254882);
    }

    public final void setVisibility(int i2) {
        FinderLiveLogoAnim finderLiveLogoAnim;
        PAGView pAGView;
        PAGView pAGView2;
        AppMethodBeat.i(254870);
        super.setVisibility(i2);
        if (i2 != 0) {
            if (this.wnI && (pAGView2 = this.wnx) != null) {
                pAGView2.stop();
            }
            if (this.wnK) {
                FinderLiveLogoAnim finderLiveLogoAnim2 = this.wny;
                if (finderLiveLogoAnim2 != null) {
                    finderLiveLogoAnim2.cEA();
                    AppMethodBeat.o(254870);
                    return;
                }
                AppMethodBeat.o(254870);
                return;
            }
        } else if (this.wnJ) {
            if (this.wnI && (pAGView = this.wnx) != null) {
                pAGView.play();
            }
            if (this.wnK && (finderLiveLogoAnim = this.wny) != null) {
                finderLiveLogoAnim.bWT();
                AppMethodBeat.o(254870);
                return;
            }
        }
        AppMethodBeat.o(254870);
    }

    private final void b(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(254871);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.a.FinderLiveOnliveWidget, i2, 0);
            this.mode = obtainStyledAttributes.getInt(16, 0);
            switch (this.mode) {
                case 1:
                    Context context = getContext();
                    p.g(context, "context");
                    this.wnv = context.getResources().getDrawable(R.drawable.a15, null);
                    this.wnH = getResources().getColor(R.color.am);
                    Context context2 = getContext();
                    p.g(context2, "context");
                    this.wnB = Integer.valueOf(context2.getResources().getDimensionPixelOffset(R.dimen.c5));
                    Context context3 = getContext();
                    p.g(context3, "context");
                    this.wnC = Integer.valueOf(context3.getResources().getDimensionPixelOffset(R.dimen.c5));
                    Context context4 = getContext();
                    p.g(context4, "context");
                    this.wnT = context4.getResources().getColor(R.color.am);
                    this.wnU = d.e(getContext(), 10.0f);
                    this.wnP = d.e(getContext(), 2.0f);
                    Context context5 = getContext();
                    p.g(context5, "context");
                    this.desc = context5.getResources().getString(R.string.d47);
                    this.wnV = false;
                    break;
                case 2:
                    Context context6 = getContext();
                    p.g(context6, "context");
                    this.wnv = context6.getResources().getDrawable(R.drawable.a0x, null);
                    this.wnH = getResources().getColor(R.color.q5);
                    Context context7 = getContext();
                    p.g(context7, "context");
                    this.wnB = Integer.valueOf(context7.getResources().getDimensionPixelOffset(R.dimen.c5));
                    Context context8 = getContext();
                    p.g(context8, "context");
                    this.wnC = Integer.valueOf(context8.getResources().getDimensionPixelOffset(R.dimen.c5));
                    Context context9 = getContext();
                    p.g(context9, "context");
                    this.wnT = context9.getResources().getColor(R.color.q5);
                    this.wnU = d.e(getContext(), 10.0f);
                    this.wnP = d.e(getContext(), 2.0f);
                    Context context10 = getContext();
                    p.g(context10, "context");
                    this.desc = context10.getResources().getString(R.string.d47);
                    this.wnV = false;
                    break;
                case 3:
                    this.wnv = null;
                    this.wnH = getResources().getColor(R.color.am);
                    Context context11 = getContext();
                    p.g(context11, "context");
                    this.wnB = Integer.valueOf(context11.getResources().getDimensionPixelOffset(R.dimen.ce));
                    Context context12 = getContext();
                    p.g(context12, "context");
                    this.wnC = Integer.valueOf(context12.getResources().getDimensionPixelOffset(R.dimen.ce));
                    Context context13 = getContext();
                    p.g(context13, "context");
                    this.wnT = context13.getResources().getColor(R.color.am);
                    this.wnU = d.e(getContext(), 17.0f);
                    this.wnP = d.e(getContext(), 4.0f);
                    Context context14 = getContext();
                    p.g(context14, "context");
                    this.desc = context14.getResources().getString(R.string.cs3);
                    this.wnV = true;
                    break;
                case 4:
                    this.wnv = null;
                    this.wnH = getResources().getColor(R.color.am);
                    Context context15 = getContext();
                    p.g(context15, "context");
                    this.wnB = Integer.valueOf(context15.getResources().getDimensionPixelOffset(R.dimen.cc));
                    Context context16 = getContext();
                    p.g(context16, "context");
                    this.wnC = Integer.valueOf(context16.getResources().getDimensionPixelOffset(R.dimen.cc));
                    Context context17 = getContext();
                    p.g(context17, "context");
                    this.wnT = context17.getResources().getColor(R.color.am);
                    this.wnU = d.e(getContext(), 15.0f);
                    this.wnP = d.e(getContext(), 4.0f);
                    Context context18 = getContext();
                    p.g(context18, "context");
                    this.desc = context18.getResources().getString(R.string.cs3);
                    this.wnV = true;
                    break;
                case 5:
                    this.wnv = null;
                    this.wnH = getResources().getColor(R.color.q5);
                    Context context19 = getContext();
                    p.g(context19, "context");
                    this.wnB = Integer.valueOf(context19.getResources().getDimensionPixelOffset(R.dimen.ct));
                    Context context20 = getContext();
                    p.g(context20, "context");
                    this.wnC = Integer.valueOf(context20.getResources().getDimensionPixelOffset(R.dimen.ct));
                    this.desc = "";
                    break;
            }
            this.wnu = obtainStyledAttributes.getInt(17, 3);
            if (this.wnu == 1) {
                this.wnI = true;
                this.wnK = false;
                this.wnL = false;
                this.wnJ = obtainStyledAttributes.getBoolean(10, false);
                this.wnw = obtainStyledAttributes.getString(0);
            } else if (this.wnu == 2) {
                this.wnI = false;
                this.wnK = true;
                this.wnL = false;
                this.wnJ = obtainStyledAttributes.getBoolean(10, false);
            } else {
                this.wnI = false;
                this.wnK = false;
                this.wnL = true;
                this.wnM = obtainStyledAttributes.getResourceId(13, 0);
            }
            if (obtainStyledAttributes.hasValue(11)) {
                this.wnH = obtainStyledAttributes.getColor(11, getResources().getColor(R.color.am));
            }
            if (obtainStyledAttributes.hasValue(18)) {
                this.wnB = Integer.valueOf((int) obtainStyledAttributes.getDimension(18, 0.0f));
            }
            if (obtainStyledAttributes.hasValue(12)) {
                this.wnC = Integer.valueOf((int) obtainStyledAttributes.getDimension(12, 0.0f));
            }
            if (obtainStyledAttributes.hasValue(14)) {
                this.wnD = (int) obtainStyledAttributes.getDimension(14, 0.0f);
            }
            if (obtainStyledAttributes.hasValue(15)) {
                this.wnF = (int) obtainStyledAttributes.getDimension(15, 0.0f);
            }
            if (obtainStyledAttributes.hasValue(6)) {
                this.desc = obtainStyledAttributes.getString(6);
            }
            if (obtainStyledAttributes.hasValue(9)) {
                this.wnN = Integer.valueOf((int) obtainStyledAttributes.getDimension(9, 0.0f));
            }
            if (obtainStyledAttributes.hasValue(3)) {
                this.wnO = Integer.valueOf((int) obtainStyledAttributes.getDimension(3, 0.0f));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                this.wnP = (int) obtainStyledAttributes.getDimension(4, 0.0f);
            }
            if (obtainStyledAttributes.hasValue(5)) {
                this.wnR = (int) obtainStyledAttributes.getDimension(5, 0.0f);
            }
            if (obtainStyledAttributes.hasValue(2)) {
                this.wnT = obtainStyledAttributes.getColor(2, this.wnH);
            }
            if (obtainStyledAttributes.hasValue(8)) {
                this.wnU = (int) obtainStyledAttributes.getDimension(8, 0.0f);
            }
            if (obtainStyledAttributes.hasValue(7)) {
                this.wnV = obtainStyledAttributes.getBoolean(7, false);
            }
            if (obtainStyledAttributes.hasValue(1)) {
                this.wnv = obtainStyledAttributes.getDrawable(1);
            }
            obtainStyledAttributes.recycle();
            if (BuildInfo.DEBUG) {
                Log.i(TAG, "[initAttribute],mode:" + this.mode + ",logoStyle:" + this.wnu + ",logoAnimationFile:" + this.wnw + ",logoColor:" + this.wnH + ",logoViewW:" + getLogoViewW() + ",logoViewH:" + getLogoViewH() + ',' + "logoMarginLeft:" + this.wnD + ",logoMarginRight:" + this.wnF + ",logoAnimAutoPlay" + this.wnJ + ",\\n text:" + this.desc + ",descW:" + getDescW() + ",descH:" + getDescH() + ",descMarginLeft:" + this.wnP + ",descMarginRight:" + this.wnR + ",descColor:" + this.wnT + ",descTextSize:" + this.wnU);
            }
        }
        AppMethodBeat.o(254871);
    }

    private final void init() {
        int dGT;
        FinderLiveLogoAnim finderLiveLogoAnim;
        PAGView pAGView;
        AppMethodBeat.i(254872);
        setOrientation(0);
        diX();
        if (this.mode != 0) {
            setBackground(this.wnv);
        }
        if (this.wnI) {
            if (!a.isEnabled()) {
                Log.i(TAG, "showAnim fail,pag not ready!");
            } else {
                if (this.wnx == null) {
                    this.wnx = new PAGView(getContext());
                }
                Integer logoViewW = getLogoViewW();
                if (logoViewW == null) {
                    p.hyc();
                }
                int intValue = logoViewW.intValue();
                Integer logoViewH = getLogoViewH();
                if (logoViewH == null) {
                    p.hyc();
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(intValue, logoViewH.intValue());
                layoutParams.setMargins(this.wnD, this.wnE, this.wnF, this.wnG);
                if (this.wnE == 0) {
                    layoutParams.gravity = 16;
                }
                PAGView pAGView2 = this.wnx;
                if (pAGView2 != null) {
                    pAGView2.setLayoutParams(layoutParams);
                }
                if (!Util.isNullOrNil(this.wnw)) {
                    PAGView pAGView3 = this.wnx;
                    if (pAGView3 != null) {
                        Context context = getContext();
                        p.g(context, "context");
                        pAGView3.setFile(PAGFile.Load(context.getAssets(), this.wnw));
                    }
                } else if (this.wnH == getResources().getColor(R.color.q5)) {
                    PAGView pAGView4 = this.wnx;
                    if (pAGView4 != null) {
                        Context context2 = getContext();
                        p.g(context2, "context");
                        pAGView4.setFile(PAGFile.Load(context2.getAssets(), "finder_live_logo_amin_red.pag"));
                    }
                } else {
                    PAGView pAGView5 = this.wnx;
                    if (pAGView5 != null) {
                        Context context3 = getContext();
                        p.g(context3, "context");
                        pAGView5.setFile(PAGFile.Load(context3.getAssets(), "finder_live_logo_amin_white.pag"));
                    }
                }
                addView(this.wnx, 0);
                PAGView pAGView6 = this.wnx;
                if (pAGView6 != null) {
                    pAGView6.setRepeatCount(-1);
                }
                if (this.wnJ && (pAGView = this.wnx) != null) {
                    pAGView.play();
                }
                Log.i(TAG, "showAnim auto play:" + this.wnJ);
            }
        }
        if (this.wnK) {
            switch (this.mode) {
                case 5:
                    FinderLiveLogoAnim.a aVar = FinderLiveLogoAnim.wnt;
                    dGT = FinderLiveLogoAnim.dGT();
                    break;
                default:
                    if (this.wnH != getResources().getColor(R.color.q5)) {
                        FinderLiveLogoAnim.a aVar2 = FinderLiveLogoAnim.wnt;
                        dGT = FinderLiveLogoAnim.dGS();
                        break;
                    } else {
                        FinderLiveLogoAnim.a aVar3 = FinderLiveLogoAnim.wnt;
                        dGT = FinderLiveLogoAnim.dGR();
                        break;
                    }
            }
            if (this.wny == null) {
                Context context4 = getContext();
                p.g(context4, "context");
                this.wny = new FinderLiveLogoAnim(context4, dGT);
            }
            Integer logoViewW2 = getLogoViewW();
            if (logoViewW2 == null) {
                p.hyc();
            }
            int intValue2 = logoViewW2.intValue();
            Integer logoViewH2 = getLogoViewH();
            if (logoViewH2 == null) {
                p.hyc();
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(intValue2, logoViewH2.intValue());
            layoutParams2.setMargins(this.wnD, this.wnE, this.wnF, this.wnG);
            if (this.wnE == 0) {
                layoutParams2.gravity = 16;
            }
            FinderLiveLogoAnim finderLiveLogoAnim2 = this.wny;
            if (finderLiveLogoAnim2 != null) {
                finderLiveLogoAnim2.setLayoutParams(layoutParams2);
            }
            addView(this.wny, 0);
            if (this.wnJ && (finderLiveLogoAnim = this.wny) != null) {
                finderLiveLogoAnim.bWT();
            }
            Log.i(TAG, "showPngAnim auto play:" + this.wnJ + ",pngAnimType:" + dGT);
        }
        dGU();
        dGV();
        AppMethodBeat.o(254872);
    }

    private final void diX() {
        AppMethodBeat.i(254873);
        if (!this.wnI && !this.wnK && !this.wnL && this.wnM == 0) {
            Exception exc = new Exception("neither amin or logo been set");
            AppMethodBeat.o(254873);
            throw exc;
        } else if ((this.wnI || this.wnI) && (this.wnL || this.wnM != 0)) {
            Exception exc2 = new Exception("either amin or logo been set");
            AppMethodBeat.o(254873);
            throw exc2;
        } else {
            AppMethodBeat.o(254873);
        }
    }

    private final void dGU() {
        AppMethodBeat.i(254874);
        if (!this.wnL) {
            AppMethodBeat.o(254874);
            return;
        }
        if (this.wnz == null) {
            this.wnz = new ImageView(getContext());
        }
        if (this.wnM != 0) {
            ImageView imageView = this.wnz;
            if (imageView != null) {
                Context context = getContext();
                p.g(context, "context");
                imageView.setImageDrawable(f.c(context.getResources(), this.wnM, null));
            }
        } else {
            ImageView imageView2 = this.wnz;
            if (imageView2 != null) {
                imageView2.setImageDrawable(ar.m(getContext(), R.raw.finder_live_logo, this.wnH));
            }
        }
        Integer logoViewW = getLogoViewW();
        if (logoViewW == null) {
            p.hyc();
        }
        int intValue = logoViewW.intValue();
        Integer logoViewH = getLogoViewH();
        if (logoViewH == null) {
            p.hyc();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(intValue, logoViewH.intValue());
        layoutParams.setMargins(this.wnD, this.wnE, this.wnF, this.wnG);
        if (this.wnE == 0) {
            layoutParams.gravity = 16;
        }
        ImageView imageView3 = this.wnz;
        if (imageView3 != null) {
            imageView3.setLayoutParams(layoutParams);
        }
        addView(this.wnz, 0);
        Log.i(TAG, "showImage logoImgId:" + this.wnM);
        AppMethodBeat.o(254874);
    }

    private final void dGV() {
        AppMethodBeat.i(254875);
        String str = this.desc;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(254875);
            return;
        }
        if (this.wnA == null) {
            this.wnA = new TextView(getContext());
        }
        Integer descW = getDescW();
        if (descW == null) {
            p.hyc();
        }
        int intValue = descW.intValue();
        Integer descH = getDescH();
        if (descH == null) {
            p.hyc();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(intValue, descH.intValue());
        layoutParams.setMargins(this.wnP, this.wnQ, this.wnR, this.wnS);
        if (this.wnE == 0) {
            layoutParams.gravity = 16;
        }
        TextView textView = this.wnA;
        if (textView != null) {
            textView.setLayoutParams(layoutParams);
        }
        TextView textView2 = this.wnA;
        if (textView2 != null) {
            textView2.setText(this.desc);
        }
        TextView textView3 = this.wnA;
        if (textView3 != null) {
            textView3.setGravity(16);
        }
        TextView textView4 = this.wnA;
        if (textView4 != null) {
            textView4.setTextSize(0, (float) this.wnU);
        }
        TextView textView5 = this.wnA;
        if (textView5 != null) {
            textView5.setTextColor(this.wnT);
        }
        TextView textView6 = this.wnA;
        if (textView6 != null) {
            textView6.setIncludeFontPadding(false);
        }
        if (this.wnV) {
            TextView textView7 = this.wnA;
            ao.a(textView7 != null ? textView7.getPaint() : null, 0.8f);
        }
        int childCount = getChildCount();
        if (childCount >= 0 && 1 >= childCount) {
            addView(this.wnA, getChildCount());
            Log.i(TAG, "showDesc desc:" + this.desc);
            AppMethodBeat.o(254875);
            return;
        }
        Log.i(TAG, "showDesc fail,childCount:" + getChildCount() + ", desc:" + this.desc);
        AppMethodBeat.o(254875);
    }

    public final void dGW() {
        FinderLiveLogoAnim finderLiveLogoAnim;
        AppMethodBeat.i(254876);
        if (this.wnu == 1) {
            PAGView pAGView = this.wnx;
            if (pAGView != null) {
                pAGView.play();
                AppMethodBeat.o(254876);
                return;
            }
            AppMethodBeat.o(254876);
        } else if (this.wnu != 2 || (finderLiveLogoAnim = this.wny) == null) {
            AppMethodBeat.o(254876);
        } else {
            finderLiveLogoAnim.bWT();
            AppMethodBeat.o(254876);
        }
    }

    public final void cEA() {
        AppMethodBeat.i(254877);
        PAGView pAGView = this.wnx;
        if (pAGView != null) {
            pAGView.stop();
        }
        FinderLiveLogoAnim finderLiveLogoAnim = this.wny;
        if (finderLiveLogoAnim != null) {
            finderLiveLogoAnim.cEA();
            AppMethodBeat.o(254877);
            return;
        }
        AppMethodBeat.o(254877);
    }

    public final void setText(String str) {
        AppMethodBeat.i(254879);
        p.h(str, "text");
        if (p.j(this.desc, str)) {
            awR("same text:" + str + '!');
            AppMethodBeat.o(254879);
            return;
        }
        if (indexOfChild(this.wnA) != -1) {
            removeView(this.wnA);
            Log.i(TAG, "hideDesc");
        }
        this.desc = str;
        dGV();
        AppMethodBeat.o(254879);
    }

    private static void awR(String str) {
        AppMethodBeat.i(254880);
        y yVar = y.vXH;
        if (y.dCM()) {
            Log.d(TAG, str);
        }
        AppMethodBeat.o(254880);
    }

    public static /* synthetic */ void a(FinderLiveOnliveWidget finderLiveOnliveWidget) {
        AppMethodBeat.i(254878);
        if (!finderLiveOnliveWidget.wnL || R.color.am != finderLiveOnliveWidget.wnH) {
            if (finderLiveOnliveWidget.indexOfChild(finderLiveOnliveWidget.wnx) != -1) {
                PAGView pAGView = finderLiveOnliveWidget.wnx;
                if (pAGView != null) {
                    pAGView.stop();
                }
                finderLiveOnliveWidget.removeView(finderLiveOnliveWidget.wnx);
                Log.i(TAG, "hideAnim");
            }
            finderLiveOnliveWidget.wnI = false;
            if (finderLiveOnliveWidget.indexOfChild(finderLiveOnliveWidget.wny) != -1) {
                FinderLiveLogoAnim finderLiveLogoAnim = finderLiveOnliveWidget.wny;
                if (finderLiveLogoAnim != null) {
                    finderLiveLogoAnim.cEA();
                }
                finderLiveOnliveWidget.removeView(finderLiveOnliveWidget.wny);
                Log.i(TAG, "hidePngAnim");
            }
            finderLiveOnliveWidget.wnK = false;
            if (finderLiveOnliveWidget.indexOfChild(finderLiveOnliveWidget.wnz) != -1) {
                finderLiveOnliveWidget.removeView(finderLiveOnliveWidget.wnz);
                Log.i(TAG, "hideImage");
            }
            finderLiveOnliveWidget.wnL = false;
            finderLiveOnliveWidget.wnL = true;
            Context context = finderLiveOnliveWidget.getContext();
            p.g(context, "context");
            finderLiveOnliveWidget.wnH = context.getResources().getColor(R.color.am);
            finderLiveOnliveWidget.diX();
            finderLiveOnliveWidget.dGU();
            AppMethodBeat.o(254878);
            return;
        }
        awR("same logo img!");
        AppMethodBeat.o(254878);
    }
}
