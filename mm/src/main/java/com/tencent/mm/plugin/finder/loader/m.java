package com.tencent.mm.plugin.finder.loader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.c.b;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.c.b;
import com.tencent.mm.loader.e.c.c;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u00101\u001a\u00020\f2\u0006\u00102\u001a\u000203R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u000e\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u000e\u0010!\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0007R\u001d\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderLoader;", "", "()V", "avatar", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getAvatar", "()Lcom/tencent/mm/loader/Loader;", "avatarLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "avatarOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "avatarWithoutDefaultOption", "bigAvatarOption", "blurImageLoaderConfiguration", "blurInstance", "getBlurInstance", "coverOption", "darkTimelineOption", "defaultAvatar", "kotlin.jvm.PlatformType", "getDefaultAvatar", "()Landroid/graphics/Bitmap;", "defaultOption", "defaultRoundAvatar", "getDefaultRoundAvatar", "halfImageLoaderConfiguration", "halfRectInstance", "getHalfRectInstance", "imageLoaderConfiguration", "instance", "getInstance", "liveShoppingOption", "msgThumbOption", "previewAvatar", "getPreviewAvatar", "previewAvatarConfiguration", "getPreviewAvatarConfiguration", "()Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "rectAvatar", "getRectAvatar", "rectAvatarConfiguration", "rectAvatarOption", "timelineOption", "wxAvatar", "getWxAvatar", "wxAvatarLoaderConfiguration", "wxAvatarOption", "getOption", "type", "Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "LoaderType", "plugin-finder_release"})
public final class m {
    private static final e USo;
    private static final Bitmap pqA;
    private static final e uIB;
    private static final e uIC;
    private static final e uID;
    private static final e uIE;
    private static final e uIF;
    private static final e uIG;
    private static final Bitmap uIH;
    private static final e uII;
    private static final e uIJ;
    private static final e uIK;
    private static final e uIL;
    private static final d<o, Bitmap> uIM = new com.tencent.mm.loader.c.a().a(new h()).a(new f()).a(new com.tencent.mm.loader.e.a()).a(new com.tencent.mm.loader.b.b.a()).b(new c()).b(uIB).aJE();
    private static final d<o, Bitmap> uIN = new com.tencent.mm.loader.c.a().a(new h()).a(new j()).a(new com.tencent.mm.loader.e.a()).a(new com.tencent.mm.loader.b.b.a()).b(uII).b(new c()).b(new c(0.5f).aJY()).aJE();
    private static final d<o, Bitmap> uIO = new com.tencent.mm.loader.c.a().a(new h()).a(new j()).a(new com.tencent.mm.loader.e.a()).a(new com.tencent.mm.loader.b.b.a()).b(uIK).b(new c(0.1f).aJY()).aJE();
    private static final d<o, Bitmap> uIP = new com.tencent.mm.loader.c.a().a(new h()).a(new j()).a(new com.tencent.mm.loader.e.a()).a(new com.tencent.mm.loader.b.b.a()).b(uII).b(new c()).aJE();
    private static final d<o, Bitmap> uIQ = new com.tencent.mm.loader.c.a().a(new h()).a(new j()).a(new com.tencent.mm.loader.e.a()).a(new com.tencent.mm.loader.b.b.a()).b(new c()).b(uIB).aJE();
    private static final d<o, Bitmap> uIR;
    private static final d<o, Bitmap> uIS;
    private static final com.tencent.mm.loader.d<o> uIT = com.tencent.mm.loader.e.a(uIM);
    private static final com.tencent.mm.loader.d<o> uIU = com.tencent.mm.loader.e.a(uIS);
    private static final com.tencent.mm.loader.d<o> uIV = com.tencent.mm.loader.e.a(uIN);
    private static final com.tencent.mm.loader.d<o> uIW = com.tencent.mm.loader.e.a(uIO);
    private static final com.tencent.mm.loader.d<o> uIX = com.tencent.mm.loader.e.a(uIP);
    private static final com.tencent.mm.loader.d<o> uIY = com.tencent.mm.loader.e.a(uIQ);
    private static final com.tencent.mm.loader.d<o> uIZ = com.tencent.mm.loader.e.a(uIR);
    public static final m uJa = new m();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderLoader$LoaderType;", "", "(Ljava/lang/String;I)V", "TIMELINE", "DARK_TIMELINE", "FEED_DETAIL", "AVATAR", "RECT_AVATAR", "WX_AVATAR", "AVATAR_WITHOUT_DEFAULT", "MSG_THUMB", "DEFAULT", "BIG_AVATAR", "PROFILE_COVER", "LIVE_SHOPPING_DEFAULT", "plugin-finder_release"})
    public enum a {
        TIMELINE,
        DARK_TIMELINE,
        FEED_DETAIL,
        AVATAR,
        RECT_AVATAR,
        WX_AVATAR,
        AVATAR_WITHOUT_DEFAULT,
        MSG_THUMB,
        DEFAULT,
        BIG_AVATAR,
        PROFILE_COVER,
        LIVE_SHOPPING_DEFAULT;

        static {
            AppMethodBeat.i(166324);
            AppMethodBeat.o(166324);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(166326);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(166326);
            return aVar;
        }
    }

    static {
        AppMethodBeat.i(166329);
        e.a aVar = new e.a();
        aVar.hZJ = true;
        aVar.hZI = true;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar.hZN = com.tencent.mm.plugin.finder.storage.c.dqO();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar.hZM = com.tencent.mm.plugin.finder.storage.c.dqP();
        uIB = aVar.aJT();
        e.a aVar2 = new e.a();
        aVar2.hZJ = true;
        aVar2.hZI = true;
        aVar2.hZR = R.color.BW_97;
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar2.hZN = com.tencent.mm.plugin.finder.storage.c.dqO();
        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar2.hZM = com.tencent.mm.plugin.finder.storage.c.dqP();
        uIC = aVar2.b(new AlphaAnimation(0.0f, 1.0f)).aJT();
        e.a aVar3 = new e.a();
        aVar3.hZJ = true;
        aVar3.hZI = true;
        aVar3.hZR = R.color.w;
        com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar3.hZN = com.tencent.mm.plugin.finder.storage.c.dqO();
        com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar3.hZM = com.tencent.mm.plugin.finder.storage.c.dqP();
        uID = aVar3.b(new AlphaAnimation(0.0f, 1.0f)).aJT();
        e.a aVar4 = new e.a();
        aVar4.hZJ = true;
        aVar4.hZI = true;
        aVar4.hZR = R.color.BW_97;
        com.tencent.mm.plugin.finder.storage.c cVar7 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar4.hZN = com.tencent.mm.plugin.finder.storage.c.dqS();
        com.tencent.mm.plugin.finder.storage.c cVar8 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar4.hZM = com.tencent.mm.plugin.finder.storage.c.dqT();
        uIE = aVar4.aJT();
        e.a aVar5 = new e.a();
        aVar5.hZJ = true;
        aVar5.hZI = true;
        aVar5.hZR = R.color.BW_97;
        com.tencent.mm.plugin.finder.storage.c cVar9 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar5.hZN = com.tencent.mm.plugin.finder.storage.c.dqV();
        com.tencent.mm.plugin.finder.storage.c cVar10 = com.tencent.mm.plugin.finder.storage.c.vCb;
        aVar5.hZM = com.tencent.mm.plugin.finder.storage.c.dqW();
        uIF = aVar5.aJT();
        e.a aVar6 = new e.a();
        aVar6.hZJ = true;
        aVar6.hZI = true;
        aVar6.hZR = R.color.BW_97;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        if (resources == null) {
            p.hyc();
        }
        aVar6.hZM = resources.getDimensionPixelSize(R.dimen.cs);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        Resources resources2 = context2.getResources();
        if (resources2 == null) {
            p.hyc();
        }
        aVar6.hZN = resources2.getDimensionPixelSize(R.dimen.cs);
        uIG = aVar6.aJT();
        Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getContext().getResources(), R.raw.default_avatar);
        pqA = decodeResource;
        uIH = BitmapUtil.getRoundedCornerBitmap(decodeResource, false, ((float) pqA.getWidth()) * 0.5f);
        e.a aVar7 = new e.a();
        aVar7.hZJ = true;
        aVar7.hZI = true;
        e.a w = aVar7.w(new BitmapDrawable(uIH));
        w.hZN = 132;
        w.hZM = 132;
        uII = w.aJT();
        e.a aVar8 = new e.a();
        aVar8.hZJ = true;
        aVar8.hZI = true;
        e.a w2 = aVar8.w(new BitmapDrawable(pqA));
        w2.hZN = 132;
        w2.hZM = 132;
        uIJ = w2.aJT();
        e.a aVar9 = new e.a();
        aVar9.hZJ = true;
        aVar9.hZI = true;
        Drawable drawable = MMApplicationContext.getContext().getResources().getDrawable(R.drawable.bca);
        p.g(drawable, "MMApplicationContext.get….drawable.default_avatar)");
        e.a w3 = aVar9.w(drawable);
        com.tencent.mm.plugin.finder.storage.c cVar11 = com.tencent.mm.plugin.finder.storage.c.vCb;
        w3.hZN = com.tencent.mm.plugin.finder.storage.c.dqS();
        com.tencent.mm.plugin.finder.storage.c cVar12 = com.tencent.mm.plugin.finder.storage.c.vCb;
        w3.hZM = com.tencent.mm.plugin.finder.storage.c.dqS();
        uIK = w3.aJT();
        e.a aVar10 = new e.a();
        aVar10.hZJ = true;
        aVar10.hZI = true;
        aVar10.hZR = R.color.BW_97;
        aVar10.hZN = 132;
        aVar10.hZM = 132;
        uIL = aVar10.aJT();
        b b2 = new com.tencent.mm.loader.c.a().a(new h()).a(new f()).a(new com.tencent.mm.loader.e.a()).a(new com.tencent.mm.loader.b.b.a()).b(new c());
        d dVar = new d(Integer.valueOf((int) R.color.ab));
        dVar.iaK = b.EnumC0403b.DOWNLOADED;
        uIR = b2.b(dVar).b(uIB).aJE();
        com.tencent.mm.loader.c.b a2 = new com.tencent.mm.loader.c.a().a(new h());
        o oVar = o.vTw;
        uIS = a2.a(new f(o.dBk())).a(new com.tencent.mm.loader.e.a()).a(new com.tencent.mm.loader.b.b.a()).b(new c()).b(uIB).aJE();
        e.a aVar11 = new e.a();
        aVar11.hZJ = true;
        aVar11.hZI = true;
        Drawable drawable2 = MMApplicationContext.getContext().getResources().getDrawable(R.drawable.cvp);
        p.g(drawable2, "MMApplicationContext.get…er_live_shopping_default)");
        e.a w4 = aVar11.w(drawable2);
        w4.hZN = 132;
        w4.hZM = 132;
        USo = w4.aJT();
        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e eVar2 = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e eVar3 = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e eVar4 = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e eVar5 = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e eVar6 = com.tencent.mm.loader.e.hXU;
        com.tencent.mm.loader.e eVar7 = com.tencent.mm.loader.e.hXU;
        AppMethodBeat.o(166329);
    }

    private m() {
    }

    public static com.tencent.mm.loader.d<o> djY() {
        return uIT;
    }

    public static com.tencent.mm.loader.d<o> djZ() {
        return uIU;
    }

    public static com.tencent.mm.loader.d<o> dka() {
        return uIV;
    }

    public static com.tencent.mm.loader.d<o> dkb() {
        return uIW;
    }

    public static com.tencent.mm.loader.d<o> dkc() {
        return uIX;
    }

    public static com.tencent.mm.loader.d<o> dkd() {
        return uIY;
    }

    public static com.tencent.mm.loader.d<o> dke() {
        return uIZ;
    }

    public static e a(a aVar) {
        AppMethodBeat.i(166328);
        p.h(aVar, "type");
        switch (n.$EnumSwitchMapping$0[aVar.ordinal()]) {
            case 1:
                e eVar = uIC;
                AppMethodBeat.o(166328);
                return eVar;
            case 2:
                e eVar2 = uID;
                AppMethodBeat.o(166328);
                return eVar2;
            case 3:
                e eVar3 = uIC;
                AppMethodBeat.o(166328);
                return eVar3;
            case 4:
                e eVar4 = uII;
                AppMethodBeat.o(166328);
                return eVar4;
            case 5:
                e eVar5 = uIJ;
                AppMethodBeat.o(166328);
                return eVar5;
            case 6:
                e eVar6 = uIL;
                AppMethodBeat.o(166328);
                return eVar6;
            case 7:
                e eVar7 = uIG;
                AppMethodBeat.o(166328);
                return eVar7;
            case 8:
                e eVar8 = uIE;
                AppMethodBeat.o(166328);
                return eVar8;
            case 9:
                e eVar9 = uIF;
                AppMethodBeat.o(166328);
                return eVar9;
            case 10:
                e eVar10 = uIK;
                AppMethodBeat.o(166328);
                return eVar10;
            case 11:
                e eVar11 = USo;
                AppMethodBeat.o(166328);
                return eVar11;
            default:
                e eVar12 = uIB;
                AppMethodBeat.o(166328);
                return eVar12;
        }
    }
}
