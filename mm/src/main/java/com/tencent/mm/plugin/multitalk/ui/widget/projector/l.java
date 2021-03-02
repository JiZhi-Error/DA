package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 £\u00012\u00020\u00012\u00020\u0002:\u0002£\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u00020rH\u0002J\u0010\u0010t\u001a\u00020r2\u0006\u0010u\u001a\u00020\u001eH\u0002J\b\u0010v\u001a\u00020rH\u0014J\b\u0010w\u001a\u00020rH\u0002J\b\u0010x\u001a\u00020rH\u0016J\b\u0010y\u001a\u00020rH\u0002J\u0010\u0010z\u001a\u0004\u0018\u00010{2\u0006\u0010|\u001a\u00020?J\b\u0010}\u001a\u00020,H\u0016J\b\u0010~\u001a\u00020\u001eH\u0016J\b\u0010\u001a\u00020\u001eH\u0016J\t\u0010\u0001\u001a\u00020,H\u0016J\u0007\u0010\u0001\u001a\u00020rJ\t\u0010\u0001\u001a\u00020rH\u0016J\t\u0010\u0001\u001a\u00020rH\u0016J\u0007\u0010\u0001\u001a\u00020rJ\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&J\u001c\u0010\u0001\u001a\u0004\u0018\u00010?2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001eJ\u0013\u0010\u0001\u001a\u0004\u0018\u00010?2\b\u0010\u0001\u001a\u00030\u0001J\t\u0010\u0001\u001a\u00020\u001eH\u0016J\t\u0010\u0001\u001a\u00020,H&J\u0007\u0010\u0001\u001a\u00020rJ\t\u0010\u0001\u001a\u00020rH&J\u001e\u0010\u0001\u001a\u00020r2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020,H\u0016J\u0007\u0010\u0001\u001a\u00020\u001eJ\u0007\u0010\u0001\u001a\u00020rJ\u0007\u0010\u0001\u001a\u00020rJ\u0007\u0010\u0001\u001a\u00020rJ\t\u0010\u0001\u001a\u00020rH\u0016J\t\u0010\u0001\u001a\u00020rH\u0002J\t\u0010\u0001\u001a\u00020,H\u0016J\u0012\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020\u001eH\u0016J\u0010\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020\u001eJ\u001f\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010¡\u0001\u001a\u00020r2\t\b\u0002\u0010¢\u0001\u001a\u00020\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010$\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010'\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R$\u0010)\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R\u000e\u0010=\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000f\"\u0004\bF\u0010\u0011R\u001c\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010h\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000f\"\u0004\bj\u0010\u0011R\u001c\u0010k\u001a\u0004\u0018\u00010lX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p¨\u0006¤\u0001"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "getAvatarLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "setAvatarLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;)V", "avatarRoot", "Landroid/widget/FrameLayout;", "getAvatarRoot", "()Landroid/widget/FrameLayout;", "setAvatarRoot", "(Landroid/widget/FrameLayout;)V", "bottomRoot", "getBottomRoot", "setBottomRoot", "bottomUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "getBottomUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "setBottomUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;)V", "fpsTimer", "Ljava/util/Timer;", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "isDoodleLayoutOn", "setDoodleLayoutOn", "isLockGenerateBitmap", "setLockGenerateBitmap", "value", "isReadyNotAllowClick", "setReadyNotAllowClick", "isScreenProjectSending", "setScreenProjectSending", "mCurrentPageHeight", "", "getMCurrentPageHeight", "()I", "setMCurrentPageHeight", "(I)V", "mCurrentPageWidth", "getMCurrentPageWidth", "setMCurrentPageWidth", "mCurrentScale", "", "getMCurrentScale", "()F", "setMCurrentScale", "(F)V", "mEditLayout", "getMEditLayout", "setMEditLayout", "mFps", "mRawBitmap", "Landroid/graphics/Bitmap;", "getMRawBitmap", "()Landroid/graphics/Bitmap;", "setMRawBitmap", "(Landroid/graphics/Bitmap;)V", "mReadyLayout", "getMReadyLayout", "setMReadyLayout", "mScreenReportData", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;", "getMScreenReportData", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;", "setMScreenReportData", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;)V", "mStartTimes", "", "getMStartTimes", "()J", "setMStartTimes", "(J)V", "multiTalkStrokeContext", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "getMultiTalkStrokeContext", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "setMultiTalkStrokeContext", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;)V", "readyUI", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "getReadyUI", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "setReadyUI", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;)V", "screenFuncConfig", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "getScreenFuncConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setScreenFuncConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "sendData", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "timer", "topRoot", "getTopRoot", "setTopRoot", "topUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "getTopUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "setTopUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;)V", "applyAvatarLayout", "", "applyBottomUI", "applyEditorLayout", "isFullScreen", "applyReaderUI", "applyReadyLayout", "applyThumbnailUI", "applyTopUI", "bitmapToByteArray", "", "bm", "checkCallerState", "checkCurrentInAvatarLayout", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "clearScreen", "closeReaderRenderer", "dismissProjectScreen", "enterScreenDoodle", "getBackgroundView", "Landroid/view/View;", "getBitmap", "view", "ignoreBg", "getBitmapShot", "getCurrentStatus", "getLayoutId", "getRenderBitmap", "initView", "inputScreenProjectInfo", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "pageIndex", "isShow", "onBack", "onTimeSecondCallback", "onVideoGroupMemberChange", "refreshView", "reportScreenProject", "responeScreenClick", "showReaderContent", "show", "showStrokeContent", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "stopScreenProjectSend", "isMini", "Companion", "plugin-multitalk_release"})
public abstract class l extends RelativeLayout implements a {
    public static final a zXp = new a((byte) 0);
    private Timer dfh;
    private int hDX;
    private float zVJ;
    private int zVK;
    private int zVL;
    private e zWU;
    s zWV;
    private long zWW;
    private FrameLayout zWX;
    private FrameLayout zWY;
    private FrameLayout zWZ;
    private FrameLayout zXa;
    private FrameLayout zXb;
    b zXc;
    private k zXd;
    private r zXe;
    private j zXf;
    private p zXg;
    Bitmap zXh;
    private boolean zXi;
    boolean zXj;
    private boolean zXk;
    private boolean zXl = true;
    private Timer zXm;
    private MMHandler zXn;
    volatile boolean zXo;

    public abstract View getBackgroundView();

    public abstract int getLayoutId();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Context context) {
        super(context);
        p.h(context, "context");
    }

    /* access modifiers changed from: protected */
    public final e getScreenFuncConfig() {
        return this.zWU;
    }

    /* access modifiers changed from: protected */
    public final void setScreenFuncConfig(e eVar) {
        this.zWU = eVar;
    }

    /* access modifiers changed from: protected */
    public final int getMCurrentPageWidth() {
        return this.zVK;
    }

    /* access modifiers changed from: protected */
    public final void setMCurrentPageWidth(int i2) {
        this.zVK = i2;
    }

    /* access modifiers changed from: protected */
    public final int getMCurrentPageHeight() {
        return this.zVL;
    }

    /* access modifiers changed from: protected */
    public final void setMCurrentPageHeight(int i2) {
        this.zVL = i2;
    }

    /* access modifiers changed from: protected */
    public final s getMScreenReportData() {
        return this.zWV;
    }

    /* access modifiers changed from: protected */
    public final void setMScreenReportData(s sVar) {
        this.zWV = sVar;
    }

    /* access modifiers changed from: protected */
    public final long getMStartTimes() {
        return this.zWW;
    }

    /* access modifiers changed from: protected */
    public final void setMStartTimes(long j2) {
        this.zWW = j2;
    }

    /* access modifiers changed from: protected */
    public final FrameLayout getMReadyLayout() {
        return this.zWX;
    }

    /* access modifiers changed from: protected */
    public final void setMReadyLayout(FrameLayout frameLayout) {
        this.zWX = frameLayout;
    }

    /* access modifiers changed from: protected */
    public final FrameLayout getMEditLayout() {
        return this.zWY;
    }

    /* access modifiers changed from: protected */
    public final void setMEditLayout(FrameLayout frameLayout) {
        this.zWY = frameLayout;
    }

    /* access modifiers changed from: protected */
    public final FrameLayout getTopRoot() {
        return this.zWZ;
    }

    /* access modifiers changed from: protected */
    public final void setTopRoot(FrameLayout frameLayout) {
        this.zWZ = frameLayout;
    }

    /* access modifiers changed from: protected */
    public final FrameLayout getBottomRoot() {
        return this.zXa;
    }

    /* access modifiers changed from: protected */
    public final void setBottomRoot(FrameLayout frameLayout) {
        this.zXa = frameLayout;
    }

    /* access modifiers changed from: protected */
    public final FrameLayout getAvatarRoot() {
        return this.zXb;
    }

    /* access modifiers changed from: protected */
    public final void setAvatarRoot(FrameLayout frameLayout) {
        this.zXb = frameLayout;
    }

    /* access modifiers changed from: protected */
    public final b getMultiTalkStrokeContext() {
        return this.zXc;
    }

    /* access modifiers changed from: protected */
    public final void setMultiTalkStrokeContext(b bVar) {
        this.zXc = bVar;
    }

    /* access modifiers changed from: protected */
    public final k getBottomUiLayout() {
        return this.zXd;
    }

    /* access modifiers changed from: protected */
    public final void setBottomUiLayout(k kVar) {
        this.zXd = kVar;
    }

    /* access modifiers changed from: protected */
    public final r getReadyUI() {
        return this.zXe;
    }

    /* access modifiers changed from: protected */
    public final void setReadyUI(r rVar) {
        this.zXe = rVar;
    }

    /* access modifiers changed from: protected */
    public final j getAvatarLayout() {
        return this.zXf;
    }

    /* access modifiers changed from: protected */
    public final void setAvatarLayout(j jVar) {
        this.zXf = jVar;
    }

    /* access modifiers changed from: protected */
    public final p getTopUiLayout() {
        return this.zXg;
    }

    /* access modifiers changed from: protected */
    public final void setTopUiLayout(p pVar) {
        this.zXg = pVar;
    }

    /* access modifiers changed from: protected */
    public final Bitmap getMRawBitmap() {
        return this.zXh;
    }

    /* access modifiers changed from: protected */
    public final void setMRawBitmap(Bitmap bitmap) {
        this.zXh = bitmap;
    }

    public final void setScreenProjectSending(boolean z) {
        this.zXi = z;
        ac.eom().zMz = z;
    }

    public final void setDoodleLayoutOn(boolean z) {
        this.zXj = z;
    }

    public final void setAvatarLayoutOn(boolean z) {
        this.zXk = z;
    }

    public final void setReadyNotAllowClick(boolean z) {
        boolean z2;
        boolean z3 = true;
        this.zXl = z;
        b bVar = this.zXc;
        if (bVar != null) {
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.plugin.multitalk.ui.a.b bVar2 = bVar.zVO;
            if (bVar2 != null) {
                bVar2.setDrawingEnable(z2);
            }
        }
        k kVar = this.zXd;
        if (kVar != null) {
            if (z) {
                z3 = false;
            }
            kVar.zWR = z3;
        }
    }

    /* access modifiers changed from: protected */
    public final float getMCurrentScale() {
        return this.zVJ;
    }

    /* access modifiers changed from: protected */
    public final void setMCurrentScale(float f2) {
        this.zVJ = f2;
    }

    public final void eaa() {
        i iVar;
        j jVar = this.zXf;
        if (jVar != null && (iVar = jVar.zWE) != null) {
            iVar.eaa();
        }
    }

    public void sd(boolean z) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator startDelay;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator alpha;
        FrameLayout frameLayout;
        View view;
        TextView textView;
        int i2 = 8;
        this.zWW = Util.currentTicks();
        FrameLayout frameLayout2 = this.zWY;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(z ? 0 : 8);
        }
        p pVar = this.zXg;
        if (!(pVar == null || (textView = pVar.qCm) == null)) {
            textView.setVisibility(0);
        }
        k kVar = this.zXd;
        if (!(kVar == null || (view = kVar.zWH) == null)) {
            if (z) {
                i2 = 0;
            }
            view.setVisibility(i2);
        }
        b bVar = this.zXc;
        if (!(bVar == null || (frameLayout = this.zWY) == null)) {
            frameLayout.addView(bVar.zVI);
        }
        FrameLayout frameLayout3 = this.zWX;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        FrameLayout frameLayout4 = this.zWX;
        if (frameLayout4 != null) {
            frameLayout4.clearAnimation();
        }
        FrameLayout frameLayout5 = this.zWX;
        if (frameLayout5 != null && (animate = frameLayout5.animate()) != null && (startDelay = animate.setStartDelay(3000)) != null && (duration = startDelay.setDuration(150)) != null && (alpha = duration.alpha(0.0f)) != null) {
            alpha.start();
        }
    }

    public final void epB() {
        b bVar = this.zXc;
        if (bVar != null) {
            bVar.show();
        }
        if (!this.zXi && !this.zXl) {
            a.b.a(this, a.c.START_PROJECTOR);
            p pVar = this.zXg;
            if (pVar != null) {
                pVar.eoD();
            }
        }
    }

    public final void sh(boolean z) {
        setScreenProjectSending(false);
        MMHandler mMHandler = this.zXn;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        MMHandler mMHandler2 = this.zXn;
        if (mMHandler2 != null) {
            mMHandler2.quitSafely();
        }
        this.zXn = null;
        Timer timer = this.dfh;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = this.zXm;
        if (timer2 != null) {
            timer2.cancel();
        }
        this.zXm = null;
        this.dfh = null;
        if (z) {
            ac.eom();
            q.Rj(102);
        } else {
            ac.eom();
            q.Rj(103);
        }
        ac.eom().emx();
    }

    public void aq(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public final void setLockGenerateBitmap(boolean z) {
        this.zXo = z;
    }

    public final void getRenderBitmap() {
        if (this.dfh == null) {
            c cVar = new c(this);
            this.zXm = new Timer();
            Timer timer = this.zXm;
            if (timer != null) {
                timer.schedule(cVar, 1000, 1000);
            }
            this.dfh = new Timer();
            this.zXn = new MMHandler("screen_project");
            Timer timer2 = this.dfh;
            if (timer2 != null) {
                timer2.schedule(new b(this), 0, 1000 / ((long) com.tencent.mm.plugin.multitalk.d.e.eqc()));
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$getRenderBitmap$task$1", "Ljava/util/TimerTask;", "run", "", "plugin-multitalk_release"})
    public static final class c extends TimerTask {
        final /* synthetic */ l zXq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(l lVar) {
            this.zXq = lVar;
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(240025);
            s mScreenReportData = this.zXq.getMScreenReportData();
            if (mScreenReportData != null) {
                s mScreenReportData2 = this.zXq.getMScreenReportData();
                if (mScreenReportData2 != null) {
                    i2 = mScreenReportData2.zYj;
                } else {
                    i2 = 0;
                }
                mScreenReportData.zYj = (i2 + this.zXq.hDX) / 2;
                AppMethodBeat.o(240025);
                return;
            }
            AppMethodBeat.o(240025);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$getRenderBitmap$1", "Ljava/util/TimerTask;", "run", "", "plugin-multitalk_release"})
    public static final class b extends TimerTask {
        final /* synthetic */ l zXq;

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.projector.l$b$b  reason: collision with other inner class name */
        static final class C1498b extends kotlin.g.b.q implements kotlin.g.a.b<Bitmap, x> {
            final /* synthetic */ b zXr;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1498b(b bVar) {
                super(1);
                this.zXr = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Bitmap bitmap) {
                AppMethodBeat.i(240023);
                final Bitmap bitmap2 = bitmap;
                p.h(bitmap2, LocaleUtil.ITALIAN);
                this.zXr.zXq.setLockGenerateBitmap(true);
                MMHandler mMHandler = this.zXr.zXq.zXn;
                if (mMHandler != null) {
                    mMHandler.post(new Runnable(this) {
                        /* class com.tencent.mm.plugin.multitalk.ui.widget.projector.l.b.C1498b.AnonymousClass1 */
                        final /* synthetic */ C1498b zXt;

                        {
                            this.zXt = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(240022);
                            byte[] ab = l.ab(bitmap2);
                            if (ab != null) {
                                this.zXt.zXr.zXq.setLockGenerateBitmap(false);
                                q eom = ac.eom();
                                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                                eom.enx().rQ(false);
                                this.zXt.zXr.zXq.hDX++;
                                q eom2 = ac.eom();
                                p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
                                eom2.enx().a(ab, (long) ab.length, bitmap2.getHeight(), bitmap2.getWidth(), 4);
                                AppMethodBeat.o(240022);
                                return;
                            }
                            AppMethodBeat.o(240022);
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(240023);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(l lVar) {
            this.zXq = lVar;
        }

        public final void run() {
            AppMethodBeat.i(240024);
            if (!ac.eom().zMA) {
                z.f fVar = new z.f();
                fVar.SYG = (T) new C1498b(this);
                h.RTc.aV(new a(this, fVar));
            }
            AppMethodBeat.o(240024);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ b zXr;
            final /* synthetic */ z.f zXs;

            a(b bVar, z.f fVar) {
                this.zXr = bVar;
                this.zXs = fVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
                if (r0.getHeight() != r7) goto L_0x00aa;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 331
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.projector.l.b.a.run():void");
            }
        }
    }

    private Bitmap ev(View view) {
        long j2;
        long j3 = 0;
        p.h(view, "view");
        int measuredWidth = view.getMeasuredWidth() - (view.getMeasuredWidth() % 4);
        int measuredHeight = view.getMeasuredHeight() - (view.getMeasuredHeight() % 4);
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        long currentTicks = Util.currentTicks();
        if (createBitmap == null || createBitmap.isRecycled()) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawPaint(new Paint());
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        view.draw(canvas);
        long ticksToNow = Util.ticksToNow(currentTicks);
        s sVar = this.zWV;
        if (sVar != null) {
            s sVar2 = this.zWV;
            if (sVar2 != null) {
                j2 = sVar2.zYi;
            } else {
                j2 = 0;
            }
            sVar.zYi = (j2 + ticksToNow) / 2;
        }
        long currentTicks2 = Util.currentTicks();
        b bVar = this.zXc;
        if (bVar != null) {
            bVar.t(canvas);
        }
        long ticksToNow2 = Util.ticksToNow(currentTicks2);
        s sVar3 = this.zWV;
        if (sVar3 != null) {
            s sVar4 = this.zWV;
            if (sVar4 != null) {
                j3 = sVar4.zYh;
            }
            sVar3.zYh = (ticksToNow2 + j3) / 2;
        }
        if (measuredWidth > measuredHeight) {
            return BitmapUtil.rotate(createBitmap, 90.0f);
        }
        return createBitmap;
    }

    public static byte[] ab(Bitmap bitmap) {
        p.h(bitmap, "bm");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bitmap.getWidth() * bitmap.getHeight() * 4);
        BitmapUtil.rotate(bitmap, -90.0f, false).copyPixelsToBuffer(allocateDirect);
        return allocateDirect.array();
    }

    public void epp() {
        s sVar = this.zWV;
        if (sVar != null) {
            sVar.cCv = Util.ticksToNow(this.zWW);
        }
        epq();
        j jVar = this.zXf;
        if (jVar != null) {
            jVar.zWE.release();
        }
        setVisibility(8);
        Timer timer = this.zXm;
        if (timer != null) {
            timer.cancel();
        }
        this.zXm = null;
        Timer timer2 = this.dfh;
        if (timer2 != null) {
            timer2.cancel();
        }
        this.dfh = null;
        FrameLayout frameLayout = this.zWX;
        if (frameLayout != null) {
            frameLayout.clearAnimation();
        }
        MMHandler mMHandler = this.zXn;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        MMHandler mMHandler2 = this.zXn;
        if (mMHandler2 != null) {
            mMHandler2.quitSafely();
        }
        this.zXn = null;
        r rVar = this.zXe;
        if (rVar != null) {
            rVar.timerHandler.stopTimer();
            TextView textView = rVar.hSr;
            if (textView != null) {
                textView.setScaleX(1.0f);
            }
            TextView textView2 = rVar.hSr;
            if (textView2 != null) {
                textView2.setScaleY(1.0f);
            }
            rVar.hSs = rVar.hSo;
            rVar.timerHandler.quitSafely();
        }
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        eom.enw();
        t.Rk(103);
        s sVar2 = this.zWV;
        if (sVar2 != null) {
            com.tencent.mm.plugin.multitalk.d.f fVar = com.tencent.mm.plugin.multitalk.d.f.zZd;
            com.tencent.mm.plugin.multitalk.d.f.a(sVar2.gCr, sVar2.fileSize, sVar2.fileName, sVar2.zYf, sVar2.cCv, sVar2.errorCode, sVar2.zYg, sVar2.zYh, sVar2.zYi, sVar2.zYj);
        }
        this.zWV = null;
    }

    public final boolean bJw() {
        return getVisibility() == 0;
    }

    public final void epk() {
        b bVar = this.zXc;
        if (bVar != null) {
            bVar.epk();
        }
    }

    public void epq() {
    }

    public int epr() {
        int i2 = 0;
        FrameLayout frameLayout = this.zWZ;
        if ((frameLayout == null || frameLayout.getVisibility() != 0) ? false : true) {
            i2 = 4;
        }
        FrameLayout frameLayout2 = this.zWZ;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(i2);
        }
        FrameLayout frameLayout3 = this.zXa;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(i2);
        }
        FrameLayout frameLayout4 = this.zWX;
        if (frameLayout4 != null) {
            frameLayout4.setVisibility(i2);
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void ept() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0307  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void refreshView() {
        /*
        // Method dump skipped, instructions count: 1008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.projector.l.refreshView():void");
    }

    public void eps() {
    }

    private void epC() {
        b bVar = this.zXc;
        if (bVar == null) {
            return;
        }
        if (bVar.zVQ) {
            com.tencent.mm.plugin.multitalk.ui.a.b bVar2 = bVar.zVO;
            if (bVar2 != null) {
                bVar2.setVisibility(0);
            }
            bVar.epj();
            bVar.zVQ = false;
            return;
        }
        bVar.epj();
        com.tencent.mm.plugin.multitalk.ui.a.b bVar3 = bVar.zVO;
        if (bVar3 != null) {
            bVar3.setVisibility(0);
        }
        bVar.zVQ = true;
    }

    public final void onBack() {
        Resources resources;
        Integer num = null;
        if (this.zXi) {
            d.a aVar = new d.a(getContext());
            Context context = getContext();
            p.g(context, "context");
            Resources resources2 = context.getResources();
            aVar.boo(resources2 != null ? resources2.getString(R.string.gf0) : null);
            d.a c2 = aVar.aoV(R.string.gez).c(new d(this));
            Context context2 = getContext();
            if (!(context2 == null || (resources = context2.getResources()) == null)) {
                num = Integer.valueOf(resources.getColor(R.color.Red));
            }
            if (num == null) {
                p.hyc();
            }
            c2.aoX(num.intValue());
            aVar.aoW(R.string.sz).d(e.zXu);
            aVar.hbn().show();
            return;
        }
        ac.eom().emx();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
    static final class d implements DialogInterface.OnClickListener {
        final /* synthetic */ l zXq;

        d(l lVar) {
            this.zXq = lVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(240026);
            this.zXq.sh(false);
            dialogInterface.dismiss();
            AppMethodBeat.o(240026);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
    static final class e implements DialogInterface.OnClickListener {
        public static final e zXu = new e();

        static {
            AppMethodBeat.i(240028);
            AppMethodBeat.o(240028);
        }

        e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(240027);
            dialogInterface.dismiss();
            AppMethodBeat.o(240027);
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public void a(a.c cVar, Bundle bundle) {
        Bitmap ev;
        Bitmap ev2;
        Bitmap ev3;
        boolean z;
        j jVar;
        com.tencent.mm.plugin.multitalk.ui.a.b bVar;
        com.tencent.mm.plugin.multitalk.ui.a.a multiTalkEditPhotoWrapper;
        com.tencent.mm.view.l lVar;
        j jVar2;
        com.tencent.mm.plugin.multitalk.ui.a.b bVar2;
        com.tencent.mm.plugin.multitalk.ui.a.a multiTalkEditPhotoWrapper2;
        com.tencent.mm.view.l lVar2;
        com.tencent.mm.view.b.b bVar3 = null;
        p.h(cVar, "status");
        Log.printInfoStack("MicroMsg.MultiTalkScreenProjectorView", "statusChange %s and param is %s", cVar, bundle);
        switch (m.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                Log.printInfoStack("MicroMsg.MultiTalkScreenProjectorView", "startScreenProjectSend", new Object[0]);
                getRenderBitmap();
                ac.eom();
                q.Rj(101);
                setScreenProjectSending(true);
                return;
            case 2:
                sh(false);
                return;
            case 3:
                this.zXj = true;
                FrameLayout frameLayout = this.zWZ;
                if (frameLayout != null) {
                    frameLayout.setVisibility(4);
                }
                b bVar4 = this.zXc;
                if (!(bVar4 == null || (bVar2 = bVar4.zVO) == null || (multiTalkEditPhotoWrapper2 = bVar2.getMultiTalkEditPhotoWrapper()) == null || (lVar2 = multiTalkEditPhotoWrapper2.zQo) == null)) {
                    bVar3 = (com.tencent.mm.view.b.b) lVar2.getBaseBoardView();
                }
                if (bVar3 == null) {
                    throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.board.MultiTalkBoardView");
                }
                bVar3.setEnableToResponseSlid(true);
                epC();
                if ((epf() == 90 || epf() == 270) && (jVar2 = this.zXf) != null) {
                    jVar2.epz();
                    return;
                }
                return;
            case 4:
                b bVar5 = this.zXc;
                if (!(bVar5 == null || (bVar = bVar5.zVO) == null || (multiTalkEditPhotoWrapper = bVar.getMultiTalkEditPhotoWrapper()) == null || (lVar = multiTalkEditPhotoWrapper.zQo) == null)) {
                    bVar3 = (com.tencent.mm.view.b.b) lVar.getBaseBoardView();
                }
                if (bVar3 == null) {
                    throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.board.MultiTalkBoardView");
                }
                bVar3.setEnableToResponseSlid(false);
                this.zXj = false;
                FrameLayout frameLayout2 = this.zWZ;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(0);
                }
                epC();
                if ((epf() == 90 || epf() == 270) && (jVar = this.zXf) != null) {
                    jVar.epz();
                    return;
                }
                return;
            case 5:
                if (bundle != null) {
                    ac.eom().rK(bundle.getBoolean("mic_mute_status"));
                    return;
                }
                return;
            case 6:
                epk();
                return;
            case 7:
                sh(false);
                return;
            case 8:
                if (bundle != null) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("avatar_available_speaker");
                    j jVar3 = this.zXf;
                    if (jVar3 != null) {
                        if (stringArrayList == null) {
                            p.hyc();
                        }
                        z = jVar3.aD(stringArrayList);
                    } else {
                        z = false;
                    }
                    this.zXk = z;
                    return;
                }
                return;
            case 9:
                this.zXk = false;
                return;
            case 10:
                if (!this.zXj && !this.zXl) {
                    h.RTc.aV(new f(this));
                    return;
                }
                return;
            case 11:
                this.zXo = false;
                return;
            case 12:
                FrameLayout frameLayout3 = this.zWX;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(8);
                }
                setReadyNotAllowClick(false);
                return;
            case 13:
                View backgroundView = getBackgroundView();
                if (backgroundView != null && (ev3 = ev(backgroundView)) != null) {
                    k.a aVar = k.zTz;
                    Context context = getContext();
                    p.h(ev3, "bitmap");
                    if (context != null) {
                        k.a.RunnableC1495a aVar2 = new k.a.RunnableC1495a(ev3, context);
                        k.a.b bVar6 = new k.a.b(context);
                        if (context instanceof Activity) {
                            com.tencent.mm.platformtools.p.a(context, aVar2, bVar6);
                            return;
                        } else {
                            bVar6.run();
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 14:
                View backgroundView2 = getBackgroundView();
                if (backgroundView2 != null && (ev2 = ev(backgroundView2)) != null) {
                    k.a aVar3 = k.zTz;
                    Context context2 = getContext();
                    p.h(ev2, "bitmap");
                    if (context2 != null) {
                        k.a.c cVar2 = new k.a.c(ev2, context2);
                        k.a.d dVar = new k.a.d(context2);
                        if (context2 instanceof Activity) {
                            com.tencent.mm.platformtools.p.a(context2, cVar2, dVar);
                            return;
                        } else {
                            dVar.run();
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 15:
                View backgroundView3 = getBackgroundView();
                if (backgroundView3 != null && (ev = ev(backgroundView3)) != null) {
                    k.a aVar4 = k.zTz;
                    Context context3 = getContext();
                    p.h(ev, "bitmap");
                    if (context3 != null) {
                        k.a.e eVar = new k.a.e(ev, context3);
                        k.a.f fVar = new k.a.f(context3);
                        if (context3 instanceof Activity) {
                            com.tencent.mm.platformtools.p.a(context3, eVar, fVar);
                            return;
                        } else {
                            fVar.run();
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ l zXq;

        f(l lVar) {
            this.zXq = lVar;
        }

        public final void run() {
            AppMethodBeat.i(240029);
            this.zXq.epr();
            AppMethodBeat.o(240029);
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public boolean getCurrentStatus() {
        return this.zXi;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final boolean epg() {
        return this.zXj;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final boolean eph() {
        return this.zXk;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final int epf() {
        k.a aVar = k.zTz;
        Context context = getContext();
        p.g(context, "context");
        return k.a.gE(context);
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.a
    public final int epi() {
        return 1;
    }
}
