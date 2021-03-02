package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.gallery.picker.b.b;
import com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.x;

@com.tencent.mm.ui.base.a(16)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\u000fH\u0014J\b\u0010,\u001a\u00020-H\u0014J\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020-2\b\b\u0002\u00102\u001a\u000203H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0014\u0010\u0011R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\tR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R#\u0010\u001d\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001e\u0010\tR#\u0010 \u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b!\u0010\tR\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "coverRatio", "", "cropStyle", "", "getCropStyle", "()I", "cropStyle$delegate", "cropType", "getCropType", "cropType$delegate", DownloadInfo.FILENAME, "finishBtn", "getFinishBtn", "finishBtn$delegate", "imgPath", "processDialogRunnable", "Ljava/lang/Runnable;", "rotateBtn", "getRotateBtn", "rotateBtn$delegate", "rotateUndoBtn", "getRotateUndoBtn", "rotateUndoBtn$delegate", "roundCropLayout", "Lcom/tencent/mm/plugin/gallery/picker/view/WxMediaCropLayout;", "source", "tipDialog", "Landroid/app/Dialog;", "getCoverVisibilityRect", "Landroid/graphics/RectF;", "getDefaultVisibilityRect", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showProcessDialog", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderCropAvatarUI extends MMFinderUI {
    public static final a vJD = new a((byte) 0);
    private final String TAG = "Finder.FinderCropAvatarUI";
    private HashMap _$_findViewCache;
    private String dRr;
    private String fileName;
    private int source;
    private Dialog tipDialog;
    private final kotlin.f vJA = kotlin.g.ah(new e(this));
    private final kotlin.f vJB = kotlin.g.ah(new b(this));
    private final Runnable vJC = new l(this);
    private WxMediaCropLayout vJu;
    private final kotlin.f vJv = kotlin.g.ah(new c(this));
    private final kotlin.f vJw = kotlin.g.ah(new d(this));
    private final double vJx = 1.7777777777777777d;
    private final kotlin.f vJy = kotlin.g.ah(new n(this));
    private final kotlin.f vJz = kotlin.g.ah(new m(this));

    static {
        AppMethodBeat.i(167213);
        AppMethodBeat.o(167213);
    }

    private final int dzr() {
        AppMethodBeat.i(167214);
        int intValue = ((Number) this.vJv.getValue()).intValue();
        AppMethodBeat.o(167214);
        return intValue;
    }

    private final int dzs() {
        AppMethodBeat.i(252305);
        int intValue = ((Number) this.vJw.getValue()).intValue();
        AppMethodBeat.o(252305);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252308);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252308);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252307);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252307);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderCropAvatarUI() {
        AppMethodBeat.i(167218);
        AppMethodBeat.o(167218);
    }

    public static final /* synthetic */ WxMediaCropLayout f(FinderCropAvatarUI finderCropAvatarUI) {
        AppMethodBeat.i(167220);
        WxMediaCropLayout wxMediaCropLayout = finderCropAvatarUI.vJu;
        if (wxMediaCropLayout == null) {
            p.btv("roundCropLayout");
        }
        AppMethodBeat.o(167220);
        return wxMediaCropLayout;
    }

    public static final /* synthetic */ int i(FinderCropAvatarUI finderCropAvatarUI) {
        AppMethodBeat.i(252306);
        int dzs = finderCropAvatarUI.dzs();
        AppMethodBeat.o(252306);
        return dzs;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$Companion;", "", "()V", "SOURCE_AVATAR_CROP", "", "SOURCE_COVER_CROP", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167215);
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(201327616, 201327616);
        setLightNavigationbarIcon();
        View findViewById = findViewById(R.id.bic);
        findViewById.setPadding(0, 0, 0, au.aD(getContext()));
        findViewById.post(new f(this, findViewById));
        setActionbarColor(R.color.ac_);
        this.dRr = getIntent().getStringExtra("key_source_img_path");
        this.fileName = getIntent().getStringExtra("key_result_file_name");
        this.source = getIntent().getIntExtra("key_crop_source", 0);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.BW_0));
        initView();
        ((View) this.vJA.getValue()).setOnClickListener(new g(this));
        setBackBtn(new h(this));
        ((View) this.vJz.getValue()).setOnClickListener(new i(this));
        ((View) this.vJB.getValue()).setOnClickListener(new j(this));
        ((View) this.vJy.getValue()).setOnClickListener(new k(this));
        AppMethodBeat.o(167215);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ View uXn;
        final /* synthetic */ FinderCropAvatarUI vJE;

        f(FinderCropAvatarUI finderCropAvatarUI, View view) {
            this.vJE = finderCropAvatarUI;
            this.uXn = view;
        }

        public final void run() {
            AppMethodBeat.i(167201);
            this.uXn.setPadding(0, 0, 0, au.aD(this.vJE.getContext()));
            AppMethodBeat.o(167201);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ FinderCropAvatarUI vJE;

        g(FinderCropAvatarUI finderCropAvatarUI) {
            this.vJE = finderCropAvatarUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167204);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderCropAvatarUI.a(this.vJE);
            b.C1388b bVar2 = new b.C1388b();
            if (this.vJE.source == 1) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                bVar2.xkZ = com.tencent.mm.plugin.finder.storage.c.dqR();
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                bVar2.xkY = com.tencent.mm.plugin.finder.storage.c.dqU();
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                bVar2.maxWidth = com.tencent.mm.plugin.finder.storage.c.dqS();
                com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                bVar2.maxHeight = com.tencent.mm.plugin.finder.storage.c.dqT();
            } else if (this.vJE.source == 2) {
                com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                bVar2.xkY = com.tencent.mm.plugin.finder.storage.c.dqX();
                com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
                bVar2.maxWidth = com.tencent.mm.plugin.finder.storage.c.dqV();
                com.tencent.mm.plugin.finder.storage.c cVar7 = com.tencent.mm.plugin.finder.storage.c.vCb;
                bVar2.maxHeight = com.tencent.mm.plugin.finder.storage.c.dqW();
            }
            al alVar = al.waC;
            bVar2.ayU(al.dEA());
            String str = this.vJE.fileName;
            if (str == null) {
                str = "default_finder_crop_photo.tmp";
            }
            bVar2.filename = str;
            final String str2 = bVar2.xkX + bVar2.filename;
            String unused = this.vJE.TAG;
            new StringBuilder("resultPath=").append(str2).append(" size: ").append(s.boW(this.vJE.dRr) / 1024);
            com.tencent.e.f.h.hkS();
            WxMediaCropLayout.b currentCropInfo = FinderCropAvatarUI.f(this.vJE).getCurrentCropInfo();
            com.tencent.mm.plugin.gallery.picker.b.b bVar3 = new com.tencent.mm.plugin.gallery.picker.b.b(bVar2);
            String str3 = this.vJE.dRr;
            if (str3 == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.gallery.picker.b.b.a(bVar3, str3, 1, currentCropInfo.dRK(), currentCropInfo.iiw, currentCropInfo.rwL, currentCropInfo.viewRect, 0, new kotlin.g.a.m<Boolean, b.f, x>(this) {
                /* class com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI.g.AnonymousClass1 */
                final /* synthetic */ g vJF;

                {
                    this.vJF = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Boolean bool, b.f fVar) {
                    AppMethodBeat.i(167203);
                    boolean booleanValue = bool.booleanValue();
                    p.h(fVar, "result");
                    MMHandlerThread.removeRunnable(this.vJF.vJE.vJC);
                    Dialog dialog = this.vJF.vJE.tipDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    if (booleanValue) {
                        Intent intent = new Intent();
                        intent.putExtra("key_result_img_path", str2);
                        this.vJF.vJE.setResult(-1, intent);
                        this.vJF.vJE.finish();
                    } else {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI.g.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 vJH;

                            {
                                this.vJH = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(167202);
                                switch (FinderCropAvatarUI.i(this.vJH.vJF.vJE)) {
                                    case 0:
                                        com.tencent.mm.ui.base.h.n(this.vJH.vJF.vJE, R.string.cl4, 0);
                                        break;
                                    case 1:
                                        com.tencent.mm.ui.base.h.n(this.vJH.vJF.vJE, R.string.cl3, 0);
                                        break;
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(167202);
                                return xVar;
                            }
                        });
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(167203);
                    return xVar;
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167204);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class h implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderCropAvatarUI vJE;

        h(FinderCropAvatarUI finderCropAvatarUI) {
            this.vJE = finderCropAvatarUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167205);
            this.vJE.finish();
            AppMethodBeat.o(167205);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ FinderCropAvatarUI vJE;

        i(FinderCropAvatarUI finderCropAvatarUI) {
            this.vJE = finderCropAvatarUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167206);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderCropAvatarUI.f(this.vJE).getLayout().hba();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167206);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ FinderCropAvatarUI vJE;

        j(FinderCropAvatarUI finderCropAvatarUI) {
            this.vJE = finderCropAvatarUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167207);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vJE.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167207);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ FinderCropAvatarUI vJE;

        k(FinderCropAvatarUI finderCropAvatarUI) {
            this.vJE = finderCropAvatarUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167208);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderCropAvatarUI.f(this.vJE).getLayout().hbb();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCropAvatarUI$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167208);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class l implements Runnable {
        final /* synthetic */ FinderCropAvatarUI vJE;

        l(FinderCropAvatarUI finderCropAvatarUI) {
            this.vJE = finderCropAvatarUI;
        }

        public final void run() {
            AppMethodBeat.i(167210);
            Dialog dialog = this.vJE.tipDialog;
            if (dialog != null) {
                dialog.show();
                AppMethodBeat.o(167210);
                return;
            }
            FinderCropAvatarUI finderCropAvatarUI = this.vJE;
            finderCropAvatarUI.getString(R.string.zb);
            finderCropAvatarUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) finderCropAvatarUI, finderCropAvatarUI.getString(R.string.a06), false, (DialogInterface.OnCancelListener) a.vJI);
            AppMethodBeat.o(167210);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class a implements DialogInterface.OnCancelListener {
            public static final a vJI = new a();

            static {
                AppMethodBeat.i(167209);
                AppMethodBeat.o(167209);
            }

            a() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        float f2;
        AppMethodBeat.i(167216);
        View findViewById = findViewById(R.id.h9e);
        p.g(findViewById, "findViewById(R.id.round_crop)");
        this.vJu = (WxMediaCropLayout) findViewById;
        WxMediaCropLayout wxMediaCropLayout = this.vJu;
        if (wxMediaCropLayout == null) {
            p.btv("roundCropLayout");
        }
        wxMediaCropLayout.setShowBorder(false);
        if (dzr() == 0) {
            WxMediaCropLayout wxMediaCropLayout2 = this.vJu;
            if (wxMediaCropLayout2 == null) {
                p.btv("roundCropLayout");
            }
            wxMediaCropLayout2.a(dzt(), WxCropOperationLayout.j.CIRCLE);
        } else if (dzr() != 1) {
            WxMediaCropLayout wxMediaCropLayout3 = this.vJu;
            if (wxMediaCropLayout3 == null) {
                p.btv("roundCropLayout");
            }
            wxMediaCropLayout3.a(dzt(), WxCropOperationLayout.j.RECT_ADJUST);
        } else if (dzs() == 1) {
            WxMediaCropLayout wxMediaCropLayout4 = this.vJu;
            if (wxMediaCropLayout4 == null) {
                p.btv("roundCropLayout");
            }
            AppCompatActivity context = getContext();
            p.g(context, "context");
            float dimension = context.getResources().getDimension(R.dimen.ce);
            AppCompatActivity context2 = getContext();
            p.g(context2, "context");
            float dimension2 = context2.getResources().getDimension(R.dimen.ce);
            AppCompatActivity context3 = getContext();
            p.g(context3, "context");
            Resources resources = context3.getResources();
            p.g(resources, "context.resources");
            float f3 = ((float) resources.getDisplayMetrics().heightPixels) / 2.0f;
            AppCompatActivity context4 = getContext();
            p.g(context4, "context");
            Resources resources2 = context4.getResources();
            p.g(resources2, "context.resources");
            float f4 = ((float) resources2.getDisplayMetrics().widthPixels) - (dimension * 2.0f);
            float f5 = ((float) (this.vJx / 2.0d)) * f4;
            if (f3 >= f5 + dimension2) {
                dimension2 = f3 - f5;
                f2 = f3 + f5;
            } else {
                AppCompatActivity context5 = getContext();
                p.g(context5, "context");
                Resources resources3 = context5.getResources();
                p.g(resources3, "context.resources");
                f2 = ((float) resources3.getDisplayMetrics().heightPixels) - dimension2;
            }
            wxMediaCropLayout4.a(new RectF(dimension, dimension2, f4 + dimension, f2), WxCropOperationLayout.j.RECT_HARD);
        } else {
            WxMediaCropLayout wxMediaCropLayout5 = this.vJu;
            if (wxMediaCropLayout5 == null) {
                p.btv("roundCropLayout");
            }
            wxMediaCropLayout5.a(dzt(), WxCropOperationLayout.j.RECT_HARD);
        }
        WxMediaCropLayout wxMediaCropLayout6 = this.vJu;
        if (wxMediaCropLayout6 == null) {
            p.btv("roundCropLayout");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.dRr;
        if (str == null) {
            p.hyc();
        }
        WxMediaCropLayout.a(wxMediaCropLayout6, currentTimeMillis, str, true, (WxMediaCropLayout.c) null, (q) null, 24);
        AppMethodBeat.o(167216);
    }

    private final RectF dzt() {
        AppMethodBeat.i(167217);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        float dimension = ((float) resources.getDisplayMetrics().widthPixels) - context2.getResources().getDimension(R.dimen.cn);
        AppCompatActivity context3 = getContext();
        p.g(context3, "context");
        Resources resources2 = context3.getResources();
        p.g(resources2, "context.resources");
        float f2 = (((float) resources2.getDisplayMetrics().heightPixels) - dimension) / 2.0f;
        AppCompatActivity context4 = getContext();
        p.g(context4, "context");
        float dimension2 = context4.getResources().getDimension(R.dimen.ce);
        AppCompatActivity context5 = getContext();
        p.g(context5, "context");
        RectF rectF = new RectF(dimension2, f2, context5.getResources().getDimension(R.dimen.ce) + dimension, dimension + f2);
        AppMethodBeat.o(167217);
        return rectF;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_a;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderCropAvatarUI vJE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderCropAvatarUI finderCropAvatarUI) {
            super(0);
            this.vJE = finderCropAvatarUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(167199);
            Integer valueOf = Integer.valueOf(this.vJE.getIntent().getIntExtra("key_crop_style", 0));
            AppMethodBeat.o(167199);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderCropAvatarUI vJE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderCropAvatarUI finderCropAvatarUI) {
            super(0);
            this.vJE = finderCropAvatarUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(252304);
            Integer valueOf = Integer.valueOf(this.vJE.getIntent().getIntExtra("key_crop_type", 0));
            AppMethodBeat.o(252304);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderCropAvatarUI vJE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(FinderCropAvatarUI finderCropAvatarUI) {
            super(0);
            this.vJE = finderCropAvatarUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167212);
            View findViewById = this.vJE.findViewById(R.id.bii);
            AppMethodBeat.o(167212);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderCropAvatarUI vJE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(FinderCropAvatarUI finderCropAvatarUI) {
            super(0);
            this.vJE = finderCropAvatarUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167211);
            View findViewById = this.vJE.findViewById(R.id.bih);
            AppMethodBeat.o(167211);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderCropAvatarUI vJE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderCropAvatarUI finderCropAvatarUI) {
            super(0);
            this.vJE = finderCropAvatarUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167200);
            View findViewById = this.vJE.findViewById(R.id.bid);
            AppMethodBeat.o(167200);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderCropAvatarUI vJE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderCropAvatarUI finderCropAvatarUI) {
            super(0);
            this.vJE = finderCropAvatarUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167198);
            View findViewById = this.vJE.findViewById(R.id.bib);
            AppMethodBeat.o(167198);
            return findViewById;
        }
    }

    public static final /* synthetic */ void a(FinderCropAvatarUI finderCropAvatarUI) {
        AppMethodBeat.i(167219);
        MMHandlerThread.postToMainThreadDelayed(finderCropAvatarUI.vJC, 300);
        AppMethodBeat.o(167219);
    }
}
