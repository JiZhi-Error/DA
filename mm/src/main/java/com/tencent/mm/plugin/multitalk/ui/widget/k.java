package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.d;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 52\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020\u001dJ\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u000fJ\u0016\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u000fJ\u0006\u0010,\u001a\u00020\nJ\u0006\u0010-\u001a\u00020\u001dJ\u001e\u0010.\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fJ\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\u001dJ\u0006\u00101\u001a\u00020\u001dJ\u0006\u00102\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0004¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic;", "", "mainUI", "Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "(Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;)V", "blackBoardProjector", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector;", "fileProjector", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenFileProjector;", "isOnline", "", "()Z", "setOnline", "(Z)V", "mCurrentAngle", "", "getMCurrentAngle", "()I", "setMCurrentAngle", "(I)V", "value", "Landroid/os/Bundle;", "mParams", "setMParams", "(Landroid/os/Bundle;)V", "getMainUI", "()Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkMainUI;", "setMainUI", "applyBottomOrLeftMargin", "", "checkOrientationChange", "context", "Landroid/content/Context;", "doFav", "path", "", "doSendTOFriend", "imgPath", "exitProjectScreen", "initView", "type", "inputScreenProjectInfo", NativeProtocol.WEB_DIALOG_PARAMS, "pageIndex", "isShown", "onBack", "onResume", "onScreenOnline", "onTimeSecondCallback", "onVideoGroupMemberChange", "refreshView", "stopScreenProjectSend", "isMini", "Companion", "plugin-multitalk_release"})
public final class k {
    public static final a zTz = new a((byte) 0);
    private boolean isOnline;
    private Bundle mParams;
    public MultiTalkMainUI zSH;
    public f zTw;
    public d zTx;
    public int zTy = -1;

    static {
        AppMethodBeat.i(239823);
        AppMethodBeat.o(239823);
    }

    public k(MultiTalkMainUI multiTalkMainUI) {
        p.h(multiTalkMainUI, "mainUI");
        AppMethodBeat.i(239822);
        this.zSH = multiTalkMainUI;
        AppMethodBeat.o(239822);
    }

    private final void ap(Bundle bundle) {
        AppMethodBeat.i(239815);
        this.mParams = bundle;
        ac.eom().zMB = bundle;
        AppMethodBeat.o(239815);
    }

    public final void Rs(int i2) {
        AppMethodBeat.i(239816);
        ViewGroup chG = this.zSH.chG();
        if (chG != null) {
            if (i2 == 2) {
                Context context = chG.getContext();
                p.g(context, "it.context");
                this.zTw = new f(context);
                f fVar = this.zTw;
                if (fVar != null) {
                    fVar.setVisibility(0);
                }
                chG.addView(this.zTw);
            } else {
                Context context2 = chG.getContext();
                p.g(context2, "it.context");
                this.zTx = new d(context2);
                d dVar = this.zTx;
                if (dVar != null) {
                    dVar.setVisibility(0);
                }
                chG.addView(this.zTx);
            }
            eoI();
            AppMethodBeat.o(239816);
            return;
        }
        AppMethodBeat.o(239816);
    }

    private final void eoI() {
        AppMethodBeat.i(239817);
        if (!(this.zSH.chG() == null || this.zSH.chG().findViewById(R.id.h9c) == null)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.zTy = a.gE(this.zSH);
            if (this.zTy == 0 || this.zTy == 180) {
                a.c(this.zSH, true);
                layoutParams.bottomMargin = a.gF(this.zSH);
            } else if (this.zTy == 270) {
                a.c(this.zSH, false);
                layoutParams.leftMargin = a.gF(this.zSH);
            } else if (this.zTy == 90) {
                a.c(this.zSH, false);
                layoutParams.rightMargin = a.gF(this.zSH);
            }
            View findViewById = this.zSH.chG().findViewById(R.id.h9c);
            p.g(findViewById, "mainUI.rootView.findViewById<View>(R.id.rootview)");
            findViewById.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(239817);
    }

    public final void refreshView() {
        AppMethodBeat.i(239818);
        if (this.zSH.chG() != null) {
            f fVar = this.zTw;
            if (fVar != null) {
                fVar.refreshView();
            }
            eoI();
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            eom.enx().onOrientationChange(a.gE(this.zSH));
            if (a.gE(this.zSH) == 90 || a.gE(this.zSH) == 270) {
                if (this.zTw != null) {
                    q eom2 = ac.eom();
                    p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
                    com.tencent.mm.plugin.multitalk.model.p.n(eom2.enn().zHD, 1, 3, 1);
                }
                if (this.zTx != null) {
                    q eom3 = ac.eom();
                    p.g(eom3, "SubCoreMultiTalk.getMultiTalkManager()");
                    com.tencent.mm.plugin.multitalk.model.p.n(eom3.enn().zHD, 2, 3, 1);
                }
            }
        }
        AppMethodBeat.o(239818);
    }

    public final boolean isShown() {
        AppMethodBeat.i(239819);
        if (this.zTw != null) {
            f fVar = this.zTw;
            if (fVar != null) {
                boolean bJw = fVar.bJw();
                AppMethodBeat.o(239819);
                return bJw;
            }
            AppMethodBeat.o(239819);
            return false;
        }
        d dVar = this.zTx;
        if (dVar != null) {
            boolean isShown = dVar.isShown();
            AppMethodBeat.o(239819);
            return isShown;
        }
        AppMethodBeat.o(239819);
        return false;
    }

    public final void aq(Bundle bundle) {
        AppMethodBeat.i(239820);
        p.h(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        ap(bundle);
        this.isOnline = true;
        f fVar = this.zTw;
        if (fVar != null) {
            fVar.aq(bundle);
            AppMethodBeat.o(239820);
            return;
        }
        AppMethodBeat.o(239820);
    }

    public final void emx() {
        AppMethodBeat.i(239821);
        this.isOnline = false;
        ViewGroup chG = this.zSH.chG();
        if (chG != null) {
            chG.removeView(this.zTw);
        }
        ViewGroup chG2 = this.zSH.chG();
        if (chG2 != null) {
            chG2.removeView(this.zTx);
        }
        f fVar = this.zTw;
        if (fVar != null) {
            fVar.epp();
        }
        d dVar = this.zTx;
        if (dVar != null) {
            dVar.epp();
        }
        this.zTw = null;
        this.zTx = null;
        ac.eom().yon = false;
        ap(null);
        AppMethodBeat.o(239821);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkScreenProjectUILogic$Companion;", "", "()V", "SCREEN_PROJECT_TYPE_BLACK_BOARD", "", "SCREEN_PROJECT_TYPE_FILE", "TAG", "", "checkOrientation", "context", "Landroid/content/Context;", "doExport", "", "bitmap", "Landroid/graphics/Bitmap;", "doFavExport", "doSendToFriendExport", "fillEventInfo", "", "favEvent", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "sourceType", "imagePath", "getNavigationBarMargin", "showSystemStatusBar", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "show", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int gE(Context context) {
            AppMethodBeat.i(239812);
            p.h(context, "context");
            Object systemService = context.getSystemService("window");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
                AppMethodBeat.o(239812);
                throw tVar;
            }
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            p.g(defaultDisplay, "(context.getSystemServic…owManager).defaultDisplay");
            switch (defaultDisplay.getRotation()) {
                case 0:
                    AppMethodBeat.o(239812);
                    return 0;
                case 1:
                    AppMethodBeat.o(239812);
                    return 90;
                case 2:
                    AppMethodBeat.o(239812);
                    return TXLiveConstants.RENDER_ROTATION_180;
                case 3:
                    AppMethodBeat.o(239812);
                    return 270;
                default:
                    AppMethodBeat.o(239812);
                    return 0;
            }
        }

        public static int gF(Context context) {
            AppMethodBeat.i(239813);
            p.h(context, "context");
            int i2 = 0;
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                i2 = Resources.getSystem().getDimensionPixelSize(identifier);
            }
            int aB = au.aB(context);
            if (aB != 0 && aB < i2) {
                i2 = aB;
            }
            AppMethodBeat.o(239813);
            return i2;
        }

        public static void c(Activity activity, boolean z) {
            AppMethodBeat.i(239814);
            p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (!z) {
                activity.getWindow().setFlags(1024, 1024);
                activity.getWindow().clearFlags(134217728);
                AppMethodBeat.o(239814);
                return;
            }
            activity.getWindow().clearFlags(1024);
            activity.getWindow().addFlags(134217728);
            AppMethodBeat.o(239814);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.k$a$a  reason: collision with other inner class name */
        public static final class RunnableC1495a implements Runnable {
            final /* synthetic */ Context $context;
            final /* synthetic */ Bitmap cKG;

            public RunnableC1495a(Bitmap bitmap, Context context) {
                this.cKG = bitmap;
                this.$context = context;
            }

            public final void run() {
                AppMethodBeat.i(239806);
                String exportImagePath = AndroidMediaUtil.getExportImagePath("jpg");
                boolean saveBitmapToImage = BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, exportImagePath, true);
                if (!saveBitmapToImage) {
                    Toast.makeText(this.$context, this.$context.getString(R.string.gao), 1).show();
                    AppMethodBeat.o(239806);
                    return;
                }
                if (saveBitmapToImage) {
                    AndroidMediaUtil.refreshMediaScannerAsync(exportImagePath, this.$context);
                    Toast.makeText(this.$context, this.$context.getString(R.string.gat, AndroidMediaUtil.getSysCameraDirPath()), 1).show();
                }
                AppMethodBeat.o(239806);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class b implements Runnable {
            final /* synthetic */ Context $context;

            public b(Context context) {
                this.$context = context;
            }

            public final void run() {
                AppMethodBeat.i(239807);
                Toast.makeText(this.$context, this.$context.getString(R.string.gao), 1).show();
                AppMethodBeat.o(239807);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class c implements Runnable {
            final /* synthetic */ Context $context;
            final /* synthetic */ Bitmap cKG;

            public c(Bitmap bitmap, Context context) {
                this.cKG = bitmap;
                this.$context = context;
            }

            public final void run() {
                AppMethodBeat.i(239808);
                String exportImagePath = AndroidMediaUtil.getExportImagePath("jpg");
                boolean saveBitmapToImage = BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, exportImagePath, true);
                if (!saveBitmapToImage) {
                    Toast.makeText(this.$context, this.$context.getString(R.string.gao), 1).show();
                    AppMethodBeat.o(239808);
                    return;
                }
                if (saveBitmapToImage) {
                    AndroidMediaUtil.refreshMediaScannerAsync(exportImagePath, this.$context);
                    ac.eom().aFS(exportImagePath);
                }
                AppMethodBeat.o(239808);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class d implements Runnable {
            final /* synthetic */ Context $context;

            public d(Context context) {
                this.$context = context;
            }

            public final void run() {
                AppMethodBeat.i(239809);
                Toast.makeText(this.$context, this.$context.getString(R.string.gao), 1).show();
                AppMethodBeat.o(239809);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class e implements Runnable {
            final /* synthetic */ Context $context;
            final /* synthetic */ Bitmap cKG;

            public e(Bitmap bitmap, Context context) {
                this.cKG = bitmap;
                this.$context = context;
            }

            public final void run() {
                AppMethodBeat.i(239810);
                String exportImagePath = AndroidMediaUtil.getExportImagePath("jpg");
                boolean saveBitmapToImage = BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, exportImagePath, true);
                if (!saveBitmapToImage) {
                    Toast.makeText(this.$context, this.$context.getString(R.string.gao), 1).show();
                    AppMethodBeat.o(239810);
                    return;
                }
                if (saveBitmapToImage) {
                    AndroidMediaUtil.refreshMediaScannerAsync(exportImagePath, this.$context);
                    ac.eom().aFY(exportImagePath);
                }
                AppMethodBeat.o(239810);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class f implements Runnable {
            final /* synthetic */ Context $context;

            public f(Context context) {
                this.$context = context;
            }

            public final void run() {
                AppMethodBeat.i(239811);
                Toast.makeText(this.$context, this.$context.getString(R.string.gao), 1).show();
                AppMethodBeat.o(239811);
            }
        }
    }
}
