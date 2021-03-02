package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.KeyEvent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserSettingDialogView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0006\t\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u001a\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0018J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController;", "", "uiModel", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;)V", "browserChooseDialogClickListener", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1;", "browserSettingDialogClickListener", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1;", "defaultBrowserIndex", "", "mBrowserChooseDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog;", "mBrowserCount", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mBrowserSettingDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog;", "mSessionId", "", "cancelChooseDialog", "", NativeProtocol.WEB_DIALOG_ACTION, "cancelSettingDialog", "finishUI", "resultCode", "data", "Landroid/content/Intent;", "initBrowserList", "onCreate", "showBrowserChooseDialog", "showBrowserChooseDialogInner", "showSettingDialog", "switchToChooseDialog", "Companion", "plugin-webview_release"})
public final class a {
    public static final C1977a Jlq = new C1977a((byte) 0);
    final List<f> Jli = new ArrayList();
    int Jlj;
    int Jlk = -1;
    private com.tencent.mm.plugin.webview.ui.tools.browser.view.b Jll;
    private com.tencent.mm.plugin.webview.ui.tools.browser.view.c Jlm;
    private final b Jln = new b(this);
    private final c Jlo = new c(this);
    final com.tencent.mm.plugin.webview.ui.tools.browser.model.a Jlp;
    long mSessionId;

    static {
        AppMethodBeat.i(210398);
        AppMethodBeat.o(210398);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$Companion;", "", "()V", "SHOW_DIALOG_DELAY_MS", "", "TAG", "", "plugin-webview_release"})
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.browser.a$a  reason: collision with other inner class name */
    public static final class C1977a {
        private C1977a() {
        }

        public /* synthetic */ C1977a(byte b2) {
            this();
        }
    }

    public a(com.tencent.mm.plugin.webview.ui.tools.browser.model.a aVar) {
        p.h(aVar, "uiModel");
        AppMethodBeat.i(210397);
        this.Jlp = aVar;
        AppMethodBeat.o(210397);
    }

    public static final /* synthetic */ void a(a aVar, Intent intent) {
        AppMethodBeat.i(210404);
        aVar.r(-1, intent);
        AppMethodBeat.o(210404);
    }

    public static final /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(210402);
        aVar.ggt();
        AppMethodBeat.o(210402);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserChooseDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "onBrowserItemClick", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "view", "Landroid/view/View;", "position", "", "browserItemInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "onCloseClick", "onMoreClick", "plugin-webview_release"})
    public static final class b implements com.tencent.mm.plugin.webview.ui.tools.browser.listener.a {
        final /* synthetic */ a Jlr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.Jlr = aVar;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.browser.listener.a
        public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a aVar) {
            AppMethodBeat.i(210379);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aVar != null ? aVar.hashCode() : 0);
            Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onCloseClick dialog: %s", objArr);
            if (aVar != null) {
                aVar.setOnDismissListener(new DialogInterface$OnDismissListenerC1979b(this));
            }
            if (aVar != null) {
                aVar.dismiss();
                AppMethodBeat.o(210379);
                return;
            }
            AppMethodBeat.o(210379);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.browser.a$b$b  reason: collision with other inner class name */
        static final class DialogInterface$OnDismissListenerC1979b implements DialogInterface.OnDismissListener {
            final /* synthetic */ b Jls;

            DialogInterface$OnDismissListenerC1979b(b bVar) {
                this.Jls = bVar;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(210377);
                a.a(this.Jls.Jlr, 4);
                AppMethodBeat.o(210377);
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.browser.listener.a
        public final void b(com.tencent.mm.plugin.webview.ui.tools.browser.view.a aVar) {
            AppMethodBeat.i(210380);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aVar != null ? aVar.hashCode() : 0);
            Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onMoreClick dialog: %s", objArr);
            if (aVar != null) {
                aVar.setOnDismissListener(new c(this));
            }
            if (aVar != null) {
                aVar.dismiss();
            }
            c.q(this.Jlr.mSessionId, 3, this.Jlr.Jlj);
            AppMethodBeat.o(210380);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
        static final class c implements DialogInterface.OnDismissListener {
            final /* synthetic */ b Jls;

            c(b bVar) {
                this.Jls = bVar;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(210378);
                a.h(this.Jls.Jlr);
                AppMethodBeat.o(210378);
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.browser.listener.b
        public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a aVar, int i2, f fVar) {
            String str;
            ResolveInfo resolveInfo;
            ResolveInfo resolveInfo2;
            ActivityInfo activityInfo;
            ResolveInfo resolveInfo3;
            ActivityInfo activityInfo2;
            ResolveInfo resolveInfo4 = null;
            AppMethodBeat.i(210381);
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(aVar != null ? aVar.hashCode() : 0);
            if (fVar == null || (resolveInfo3 = fVar.resolveInfo) == null || (activityInfo2 = resolveInfo3.activityInfo) == null) {
                str = null;
            } else {
                str = activityInfo2.packageName;
            }
            objArr[1] = str;
            objArr[2] = (fVar == null || (resolveInfo2 = fVar.resolveInfo) == null || (activityInfo = resolveInfo2.activityInfo) == null) ? null : activityInfo.name;
            Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserDialog onBrowserItemClick dialog: %s, packageName: %s, targetActivity: %s", objArr);
            if (aVar != null) {
                aVar.setOnDismissListener(new DialogInterface$OnDismissListenerC1978a(this));
            }
            if (aVar != null) {
                aVar.dismiss();
            }
            Context uIContext = this.Jlr.Jlp.getUIContext();
            Intent targetIntent = this.Jlr.Jlp.getTargetIntent();
            if (fVar != null) {
                resolveInfo = fVar.resolveInfo;
            } else {
                resolveInfo = null;
            }
            b.a(uIContext, targetIntent, resolveInfo);
            long j2 = this.Jlr.mSessionId;
            int i3 = this.Jlr.Jlj;
            if (fVar != null) {
                resolveInfo4 = fVar.resolveInfo;
            }
            c.a(j2, i2, i3, resolveInfo4);
            AppMethodBeat.o(210381);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.browser.a$b$a  reason: collision with other inner class name */
        static final class DialogInterface$OnDismissListenerC1978a implements DialogInterface.OnDismissListener {
            final /* synthetic */ b Jls;

            DialogInterface$OnDismissListenerC1978a(b bVar) {
                this.Jls = bVar;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(210376);
                a.a(this.Jls.Jlr, (Intent) null);
                AppMethodBeat.o(210376);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$browserSettingDialogClickListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "selectedInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "selectedPosition", "", "onBrowserItemClick", "", "dialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "view", "Landroid/view/View;", "position", "browserItemInfo", "onCancelClick", "onConfirmClick", "setSelectedBrowserInfo", "plugin-webview_release"})
    public static final class c implements com.tencent.mm.plugin.webview.ui.tools.browser.listener.c {
        final /* synthetic */ a Jlr;
        f Jlt;
        private int va = -1;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.Jlr = aVar;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.browser.listener.b
        public final void a(com.tencent.mm.plugin.webview.ui.tools.browser.view.a aVar, int i2, f fVar) {
            int i3;
            String str;
            ResolveInfo resolveInfo;
            ActivityInfo activityInfo;
            ResolveInfo resolveInfo2;
            ActivityInfo activityInfo2;
            String str2 = null;
            AppMethodBeat.i(210384);
            Object[] objArr = new Object[4];
            if (aVar != null) {
                i3 = aVar.hashCode();
            } else {
                i3 = 0;
            }
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = fVar != null ? Integer.valueOf(fVar.dUm) : null;
            if (fVar == null || (resolveInfo2 = fVar.resolveInfo) == null || (activityInfo2 = resolveInfo2.activityInfo) == null) {
                str = null;
            } else {
                str = activityInfo2.packageName;
            }
            objArr[2] = str;
            if (!(fVar == null || (resolveInfo = fVar.resolveInfo) == null || (activityInfo = resolveInfo.activityInfo) == null)) {
                str2 = activityInfo.name;
            }
            objArr[3] = str2;
            Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onBrowserItemClick dialog: %s, itemType: %s, packageName: %s, targetActivity: %s", objArr);
            this.Jlt = fVar;
            this.va = i2;
            AppMethodBeat.o(210384);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.browser.listener.c
        public final void c(com.tencent.mm.plugin.webview.ui.tools.browser.view.a aVar) {
            String str;
            ResolveInfo resolveInfo;
            ActivityInfo activityInfo;
            Integer num = null;
            AppMethodBeat.i(210385);
            Object[] objArr = new Object[2];
            f fVar = this.Jlt;
            if (fVar == null || (resolveInfo = fVar.resolveInfo) == null || (activityInfo = resolveInfo.activityInfo) == null) {
                str = null;
            } else {
                str = activityInfo.packageName;
            }
            objArr[0] = str;
            f fVar2 = this.Jlt;
            if (fVar2 != null) {
                num = Integer.valueOf(fVar2.dUm);
            }
            objArr[1] = num;
            Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onConfirmClick selected: %s, itemType: %s", objArr);
            if (this.Jlt == null) {
                Log.e("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog selectedInfo is null");
                AppMethodBeat.o(210385);
                return;
            }
            f fVar3 = this.Jlt;
            if (fVar3 == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.webview.ui.tools.browser.storage.a.a(fVar3);
            if (aVar != null) {
                aVar.setOnDismissListener(new b(this));
            }
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a(this.Jlr.mSessionId, this.Jlt, this.Jlr.Jlj, this.va);
            AppMethodBeat.o(210385);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
        static final class b implements DialogInterface.OnDismissListener {
            final /* synthetic */ c Jlu;

            b(c cVar) {
                this.Jlu = cVar;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                ResolveInfo resolveInfo;
                AppMethodBeat.i(210383);
                a aVar = this.Jlu.Jlr;
                Intent intent = new Intent();
                f fVar = this.Jlu.Jlt;
                if (fVar == null || fVar.dUm != 2) {
                    f fVar2 = this.Jlu.Jlt;
                    if (fVar2 != null && fVar2.dUm == 1) {
                        intent.putExtra("browser_setting_result", 1);
                        f fVar3 = this.Jlu.Jlt;
                        if (fVar3 != null) {
                            resolveInfo = fVar3.resolveInfo;
                        } else {
                            resolveInfo = null;
                        }
                        intent.putExtra("show_browser_resolve_info", resolveInfo);
                        intent.putExtra("show_browser_with_animation", true);
                    }
                } else {
                    p.g(intent.putExtra("browser_setting_result", 2), "putExtra(BrowserChooseUI…LT_UNSET_DEFAULT_BROWSER)");
                }
                a.a(aVar, intent);
                AppMethodBeat.o(210383);
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.browser.listener.c
        public final void d(com.tencent.mm.plugin.webview.ui.tools.browser.view.a aVar) {
            AppMethodBeat.i(210386);
            Log.i("MicroMsg.BrowserChooseController", "alvinluo BrowserSettingDialog onCancelClick");
            if (aVar != null) {
                aVar.setOnDismissListener(new DialogInterface$OnDismissListenerC1980a(this));
            }
            if (aVar != null) {
                aVar.dismiss();
                AppMethodBeat.o(210386);
                return;
            }
            AppMethodBeat.o(210386);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.browser.a$c$a  reason: collision with other inner class name */
        static final class DialogInterface$OnDismissListenerC1980a implements DialogInterface.OnDismissListener {
            final /* synthetic */ c Jlu;

            DialogInterface$OnDismissListenerC1980a(c cVar) {
                this.Jlu = cVar;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(210382);
                a.a(this.Jlu.Jlr);
                c.r(this.Jlu.Jlr.mSessionId, 3, this.Jlu.Jlr.Jlj);
                AppMethodBeat.o(210382);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showSettingDialog$1$1"})
    public static final class f implements DialogInterface.OnKeyListener {
        final /* synthetic */ a Jlr;
        final /* synthetic */ com.tencent.mm.plugin.webview.ui.tools.browser.view.c Jlx;

        f(com.tencent.mm.plugin.webview.ui.tools.browser.view.c cVar, a aVar) {
            this.Jlx = cVar;
            this.Jlr = aVar;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(210391);
            if (i2 == 4) {
                this.Jlx.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
                    /* class com.tencent.mm.plugin.webview.ui.tools.browser.a.f.AnonymousClass1 */
                    final /* synthetic */ f Jly;

                    {
                        this.Jly = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(210390);
                        a.a(this.Jly.Jlr);
                        c.r(this.Jly.Jlr.mSessionId, 5, this.Jly.Jlr.Jlj);
                        AppMethodBeat.o(210390);
                    }
                });
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                AppMethodBeat.o(210391);
                return true;
            }
            AppMethodBeat.o(210391);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showSettingDialog$1$2"})
    public static final class g implements DialogInterface.OnCancelListener {
        final /* synthetic */ a Jlr;

        g(a aVar) {
            this.Jlr = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(210392);
            a.d(this.Jlr);
            AppMethodBeat.o(210392);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ a Jlr;

        h(a aVar) {
            this.Jlr = aVar;
        }

        public final void run() {
            AppMethodBeat.i(210393);
            this.Jlr.Jlp.d(this.Jlr.Jlm);
            c.r(this.Jlr.mSessionId, 1, this.Jlr.Jlj);
            AppMethodBeat.o(210393);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ggt() {
        AppMethodBeat.i(210395);
        Log.i("MicroMsg.BrowserChooseController", "alvinluo showBrowserChooseDialog");
        com.tencent.mm.plugin.webview.ui.tools.browser.view.b bVar = new com.tencent.mm.plugin.webview.ui.tools.browser.view.b(this.Jlp.getUIContext());
        bVar.setOnKeyListener(new d(bVar, this));
        bVar.setOnCancelListener(new e(this));
        bVar.JlS = this.Jln;
        List<f> list = this.Jli;
        p.h(list, "list");
        bVar.Jli = list;
        this.Jll = bVar;
        this.Jlp.d(this.Jll);
        AppMethodBeat.o(210395);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showBrowserChooseDialogInner$1$1"})
    public static final class d implements DialogInterface.OnKeyListener {
        final /* synthetic */ a Jlr;
        final /* synthetic */ com.tencent.mm.plugin.webview.ui.tools.browser.view.b Jlv;

        d(com.tencent.mm.plugin.webview.ui.tools.browser.view.b bVar, a aVar) {
            this.Jlv = bVar;
            this.Jlr = aVar;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(210388);
            Log.i("MicroMsg.BrowserChooseController", "alvinluo browserChooseDialog keyCode: " + i2 + ", event: " + (keyEvent != null ? Integer.valueOf(keyEvent.getAction()) : null));
            if (i2 == 4) {
                this.Jlv.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
                    /* class com.tencent.mm.plugin.webview.ui.tools.browser.a.d.AnonymousClass1 */
                    final /* synthetic */ d Jlw;

                    {
                        this.Jlw = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(210387);
                        a.a(this.Jlw.Jlr, 6);
                        AppMethodBeat.o(210387);
                    }
                });
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                AppMethodBeat.o(210388);
                return true;
            }
            AppMethodBeat.o(210388);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController$showBrowserChooseDialogInner$1$2"})
    public static final class e implements DialogInterface.OnCancelListener {
        final /* synthetic */ a Jlr;

        e(a aVar) {
            this.Jlr = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(210389);
            a.a(this.Jlr, 5);
            AppMethodBeat.o(210389);
        }
    }

    /* access modifiers changed from: package-private */
    public final void r(int i2, Intent intent) {
        boolean z = false;
        AppMethodBeat.i(210396);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        if (intent == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.i("MicroMsg.BrowserChooseController", "alvinluo finishUI resultCode: %d, data == null: %b", objArr);
        this.Jlp.r(i2, intent);
        AppMethodBeat.o(210396);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ a Jlr;

        i(a aVar) {
            this.Jlr = aVar;
        }

        public final void run() {
            AppMethodBeat.i(210394);
            a.g(this.Jlr);
            AppMethodBeat.o(210394);
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(210399);
        com.tencent.f.h.RTc.n(new i(aVar), 100);
        AppMethodBeat.o(210399);
    }

    public static final /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(210400);
        aVar.r(0, null);
        c.r(aVar.mSessionId, 4, aVar.Jlj);
        AppMethodBeat.o(210400);
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(210401);
        Intent intent = new Intent();
        intent.putExtra("show_webview_menu", i2 != 5);
        aVar.r(0, intent);
        c.q(aVar.mSessionId, i2, aVar.Jlj);
        AppMethodBeat.o(210401);
    }

    public static final /* synthetic */ void h(a aVar) {
        AppMethodBeat.i(210403);
        Log.i("MicroMsg.BrowserChooseController", "alvinluo showSettingDialog");
        com.tencent.mm.plugin.webview.ui.tools.browser.view.c cVar = new com.tencent.mm.plugin.webview.ui.tools.browser.view.c(aVar.Jlp.getUIContext());
        cVar.setOnKeyListener(new f(cVar, aVar));
        cVar.setOnCancelListener(new g(aVar));
        c cVar2 = aVar.Jlo;
        f fVar = (f) j.L(aVar.Jli, aVar.Jlk);
        if (fVar == null) {
            fVar = new f(2);
        }
        cVar2.Jlt = fVar;
        c cVar3 = aVar.Jlo;
        cVar.Jml = cVar3;
        BrowserSettingDialogView browserSettingDialogView = cVar.Jmk;
        if (browserSettingDialogView != null) {
            browserSettingDialogView.setBrowserSettingDialogClickListener(cVar3);
        }
        cVar.bxP = aVar.Jlk;
        List<f> list = aVar.Jli;
        p.h(list, "list");
        cVar.Jli = list;
        aVar.Jlm = cVar;
        com.tencent.f.h.RTc.n(new h(aVar), 100);
        AppMethodBeat.o(210403);
    }
}
