package com.tencent.mm.plugin.multitask.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView;
import com.tencent.mm.plugin.multitask.c.c;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.e.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskFloatBallView;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0004\u0001\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020_2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020\rH\u0016J\u0014\u0010d\u001a\u0004\u0018\u00010\"2\b\u0010e\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010d\u001a\u0004\u0018\u00010\"2\b\u0010e\u001a\u0004\u0018\u00010\"2\u0006\u0010f\u001a\u00020\rH\u0002J\b\u0010g\u001a\u00020_H\u0002J\b\u0010h\u001a\u00020_H\u0002J\b\u0010i\u001a\u00020_H\u0002J\b\u0010j\u001a\u00020_H\u0002J\b\u0010k\u001a\u00020_H\u0002J\b\u0010l\u001a\u00020_H\u0002J\b\u0010m\u001a\u00020_H\u0002J\n\u0010n\u001a\u0004\u0018\u00010\"H\u0002J\u0006\u0010o\u001a\u00020\rJ\u0006\u0010p\u001a\u00020_J\b\u0010f\u001a\u00020\rH\u0016J\u0018\u0010q\u001a\u00020\r2\u0006\u0010r\u001a\u0002042\u0006\u0010s\u001a\u00020\rH\u0016J\u001a\u0010t\u001a\u00020_2\u0006\u0010u\u001a\u0002042\b\u0010v\u001a\u0004\u0018\u00010AH\u0016J\b\u0010w\u001a\u00020_H\u0016J\u0018\u0010x\u001a\u00020_2\u0006\u0010y\u001a\u00020\r2\u0006\u0010z\u001a\u000204H\u0016J*\u0010{\u001a\u00020_2\b\u0010e\u001a\u0004\u0018\u00010\"2\u0006\u0010|\u001a\u00020\r2\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\rH\u0002J\b\u0010\u001a\u00020_H\u0016J\t\u0010\u0001\u001a\u00020_H\u0016J\t\u0010\u0001\u001a\u00020_H\u0016J\u0012\u0010\u0001\u001a\u00020_2\u0007\u0010\u0001\u001a\u00020\rH\u0016J\u0012\u0010\u0001\u001a\u00020_2\u0007\u0010\u0001\u001a\u000204H\u0016J\t\u0010\u0001\u001a\u00020_H\u0014J\u001b\u0010\u0001\u001a\u00020_2\b\u0010e\u001a\u0004\u0018\u00010\"2\u0006\u0010|\u001a\u00020\rH\u0002J\u0015\u0010\u0001\u001a\u00020_2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020_2\u0007\u0010\u0001\u001a\u00020\rH\u0016J\u0014\u0010\u0001\u001a\u00020_2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0001\u001a\u00020_H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000fR*\u0010'\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r@VX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r@TX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R*\u0010.\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\r@TX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b.\u0010(\"\u0004\b/\u0010*R\u001a\u00100\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u00109\u001a\u0004\u0018\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010$R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010B\u001a\u0004\u0018\u00010A2\b\u0010&\u001a\u0004\u0018\u00010A@TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010\u0005R(\u0010J\u001a\u0004\u0018\u00010A2\b\u0010&\u001a\u0004\u0018\u00010A@TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010D\"\u0004\bL\u0010FR\u000e\u0010M\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0015\"\u0004\bV\u0010\u0017R\u001c\u0010W\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010$\"\u0004\bY\u0010ZR\u001c\u0010[\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0015\"\u0004\b]\u0010\u0017¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "baseMultiTaskSwipeBackAnimWrapper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "getBaseMultiTaskSwipeBackAnimWrapper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "setBaseMultiTaskSwipeBackAnimWrapper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;)V", "canSwipeBackToMultiTask", "", "getCanSwipeBackToMultiTask", "()Z", "setCanSwipeBackToMultiTask", "(Z)V", "enterTransformationListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getEnterTransformationListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setEnterTransformationListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "floatBallTransformationListener", "getFloatBallTransformationListener", "setFloatBallTransformationListener", "floatIndicatorController", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "getFloatIndicatorController", "()Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "setFloatIndicatorController", "(Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "<set-?>", "isFromTaskBar", "()Ljava/lang/Boolean;", "setFromTaskBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isVisiableButtom", "setVisiableButtom", "isVisiableTop", "setVisiableTop", "mIsLandScape", "getMIsLandScape", "setMIsLandScape", "multiTaskItemPos", "", "getMultiTaskItemPos", "()I", "setMultiTaskItemPos", "(I)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "multiTaskUIManager", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "getMultiTaskUIManager", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "setMultiTaskUIManager", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;)V", "", "ori_position", "getOri_position", "()Ljava/lang/String;", "setOri_position", "(Ljava/lang/String;)V", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "position", "getPosition", "setPosition", "readEnded", "swipeAheadMultiTaskListener", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "getSwipeAheadMultiTaskListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "setSwipeAheadMultiTaskListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;)V", "swipeBackTransformationListener", "getSwipeBackTransformationListener", "setSwipeBackTransformationListener", "swipeBlt", "getSwipeBlt", "setSwipeBlt", "(Landroid/graphics/Bitmap;)V", "transformListener", "getTransformListener", "setTransformListener", "addOrUpdateCurrentHistoryTaskInfo", "", "beforeOnMenuEnterOrSwipebackToMultiTask", "onMenuFloatBallSelectCallback", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "canSwipeToMultiTask", "checkBitmap", "bitmap", "isLandScape", "createEnterTransformationListener", "createFloatBallTransformationListener", "createMultiTaskEnterAndBackAnimation", "createMultiTaskUIManager", "createSwipeAheadToMultiTaskListener", "createSwipeBackTransformationListener", "finishPage", "getHistoryBitmapOnClose", "initData", "initReportData", "onClose", "way", "ended", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "onMultiTaskAnimDone", "forceUpdate", "needUpdateInfo", "needShowTip", "onMultiTaskPanelClicked", "onMultiTaskPanelDelete", "onMultiTaskPanelHide", "onMultiTaskPanelShow", "anim", "onOrientationChange", "orientation", "onSwipePageAddToMultiTask", "restoreCurrentBallWhenNonPassiveClose", "setMultiTaskCommonInfo", "commonData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setSwipeToMultiTaskEnable", "enable", "setTransformationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showHome", "Companion", "OnMenuMultiTaskSelectCallback", "plugin-multitask_release"})
public class c extends a implements com.tencent.mm.plugin.multitask.c.d {
    public static final a AbQ = new a((byte) 0);
    public com.tencent.mm.plugin.multitask.a.a Aak;
    private com.tencent.mm.plugin.multitask.c.c AbA;
    private com.tencent.mm.plugin.multitask.c.e AbB;
    protected com.tencent.mm.plugin.multitask.animation.swipeahead.b AbC;
    private com.tencent.mm.plugin.multitask.animation.c.a.b AbD;
    com.tencent.mm.plugin.multitask.c.c AbF;
    private String AbG;
    private Boolean AbH;
    private Boolean AbI;
    public Boolean AbJ;
    private int AbK;
    Bitmap AbL;
    boolean AbM;
    com.tencent.mm.plugin.multitask.ui.c AbN;
    boolean AbO;
    private boolean AbP;
    com.tencent.mm.plugin.multitask.c.c Aby;
    private com.tencent.mm.plugin.multitask.c.c Abz;
    private String lcm;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "", "proceed", "", "plugin-multitask_release"})
    public interface b {
        void proceed();
    }

    static {
        AppMethodBeat.i(200615);
        AppMethodBeat.o(200615);
    }

    public c(byte b2) {
        this();
    }

    private /* synthetic */ c() {
        this((com.tencent.mm.plugin.multitask.a.a) null);
    }

    public c(com.tencent.mm.plugin.multitask.a.a aVar) {
        this.Aak = aVar;
        this.AbH = Boolean.FALSE;
        this.AbI = Boolean.FALSE;
        this.AbJ = Boolean.FALSE;
        this.AbK = -1;
    }

    public static final /* synthetic */ Bitmap a(c cVar, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(200617);
        Bitmap e2 = cVar.e(bitmap, z);
        AppMethodBeat.o(200617);
        return e2;
    }

    public static final /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(200619);
        cVar.ere();
        AppMethodBeat.o(200619);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final String getPosition() {
        return this.lcm;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final String eqQ() {
        return this.AbG;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final int eqR() {
        return this.AbK;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public void G(int i2, String str) {
        Activity activity;
        crt crt;
        crr crr;
        Integer num;
        com.tencent.mm.plugin.multitask.a.a aVar;
        com.tencent.mm.plugin.multitask.ui.b bVar;
        MultiTaskFloatBallView multiTaskFloatBallView;
        String str2 = null;
        AppMethodBeat.i(200600);
        super.G(i2, str);
        this.Aby = new d(this);
        this.Abz = new f(this);
        this.AbA = new C1515c(this);
        this.AbB = new e(this);
        com.tencent.mm.plugin.multitask.ui.c cVar = new com.tencent.mm.plugin.multitask.ui.c();
        cVar.AcA = this.Aak;
        c cVar2 = this;
        if (!(!cVar.ciY() || (bVar = cVar.Acz) == null || bVar.Acl == null || cVar2 == null || (multiTaskFloatBallView = bVar.Acl) == null)) {
            multiTaskFloatBallView.a(cVar2);
        }
        this.AbN = cVar;
        bCt();
        if (dki() && eqZ() && (aVar = this.Aak) != null) {
            aVar.a(this);
        }
        com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
        if (aVar2 != null) {
            aVar2.RE(i2);
        }
        erd();
        com.tencent.mm.plugin.multitask.a.a aVar3 = this.Aak;
        if (aVar3 == null || (activity = aVar3.getActivity()) == null) {
            AppMethodBeat.o(200600);
            return;
        }
        SecDataUIC.a aVar4 = SecDataUIC.CWq;
        SecDataUIC gU = SecDataUIC.a.gU(activity);
        if (gU != null) {
            crt = (crt) gU.f(5, crt.class);
        } else {
            crt = null;
        }
        if (crt != null) {
            crt crt2 = this.Abr;
            if (crt2 != null) {
                MultiTaskInfo multiTaskInfo = this.Abp;
                if (multiTaskInfo != null) {
                    num = Integer.valueOf(multiTaskInfo.field_type);
                } else {
                    num = null;
                }
                crt2.dUm = num.intValue();
            }
            crt crt3 = this.Abr;
            if (crt3 != null) {
                MultiTaskInfo multiTaskInfo2 = this.Abp;
                if (multiTaskInfo2 != null) {
                    str2 = multiTaskInfo2.field_id;
                }
                crt3.MwM = str2;
            }
            crt crt4 = this.Abr;
            if (crt4 != null) {
                crt4.sGQ = crt.sGQ;
            }
            crt crt5 = this.Abr;
            if (!(crt5 == null || (crr = crt5.MwN) == null)) {
                crr.MwI = cl.aWA();
            }
            Log.i("MicroMsg.PageMultiTaskHelper", "secdata multitask scene enter contextId: %s", crt.sGQ);
        }
        AppMethodBeat.o(200600);
    }

    private boolean bCt() {
        Intent intent;
        byte[] byteArrayExtra;
        AppMethodBeat.i(200601);
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        if (!(aVar == null || (intent = aVar.getIntent()) == null || (byteArrayExtra = intent.getByteArrayExtra("key_multi_task_common_info")) == null)) {
            ach ach = new ach();
            try {
                ach.parseFrom(byteArrayExtra);
            } catch (Exception e2) {
            }
            a(ach);
            crq crq = ach.LmQ;
            if (crq != null && !Util.isNullOrNil(crq.lcm) && !Util.isNullOrNil(crq.MwC)) {
                AppMethodBeat.o(200601);
                return true;
            }
        }
        AppMethodBeat.o(200601);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public boolean O(int i2, boolean z) {
        c cVar;
        boolean z2;
        Bitmap bitmap = null;
        boolean z3 = true;
        boolean z4 = false;
        AppMethodBeat.i(200602);
        Log.i("MicroMsg.PageMultiTaskHelper", "onClose, way:%d, ended", Integer.valueOf(i2), Boolean.valueOf(z));
        com.tencent.mm.plugin.multitask.ui.c cVar2 = this.AbN;
        if (cVar2 != null) {
            com.tencent.mm.plugin.multitask.ui.b bVar = cVar2.Acz;
            if (bVar != null) {
                MultiTaskFloatBallView multiTaskFloatBallView = bVar.Acl;
                if (multiTaskFloatBallView != null) {
                    com.tencent.mm.plugin.multitask.animation.b.b bVar2 = multiTaskFloatBallView.Aco;
                    if (bVar2 == null) {
                        z2 = false;
                    } else if (bVar2.chI() || bVar2.chJ()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                Log.i("MicroMsg.PageMultiTaskHelper", "onClose, is Animation!");
                AppMethodBeat.o(200602);
                return true;
            }
        }
        this.AbP = z;
        boolean eqW = eqW();
        if (!eqZ() || !eqW) {
            if (!bPt()) {
                if (eqW) {
                    Bitmap hWo = hWo();
                    ah(hWo);
                    d(hWo, this.AbP);
                } else {
                    if (this.AbP || !erb()) {
                        z3 = false;
                    }
                    if (z3) {
                        bitmap = hWo();
                    }
                    d(bitmap, this.AbP);
                }
            } else if (eqW) {
                com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
                if (aVar != null) {
                    bitmap = aVar.getBitmap();
                }
                ah(aj(bitmap));
            }
            AppMethodBeat.o(200602);
            return false;
        }
        erd();
        Log.i("MicroMsg.PageMultiTaskHelper", "onClose, isSupportSwipeToMultiTask:" + bPp() + ", isSupportExitToMultiTask:" + bPs());
        if (this.AbD == null || (!bPp() && !bPs())) {
            com.tencent.mm.plugin.multitask.c.c cVar3 = this.Abz;
            if (cVar3 != null) {
                cVar3.RL(0);
            }
        } else {
            com.tencent.mm.plugin.multitask.animation.c.a.b bVar3 = this.AbD;
            if (bVar3 != null) {
                bVar3.RG(i2);
            }
        }
        if (!bPt()) {
            if (eqW) {
                com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
                if (aVar2 != null) {
                    bitmap = aVar2.getBitmap();
                }
                bitmap = aj(bitmap);
                cVar = this;
            } else {
                if (!this.AbP && erb()) {
                    z4 = true;
                }
                if (z4) {
                    com.tencent.mm.plugin.multitask.a.a aVar3 = this.Aak;
                    if (aVar3 != null) {
                        bitmap = aVar3.getBitmap();
                    }
                    bitmap = aj(bitmap);
                    cVar = this;
                } else {
                    cVar = this;
                }
            }
            cVar.d(bitmap, this.AbP);
        }
        AppMethodBeat.o(200602);
        return true;
    }

    private final Bitmap hWo() {
        AppMethodBeat.i(259531);
        if (this.AbL != null) {
            Bitmap bitmap = this.AbL;
            AppMethodBeat.o(259531);
            return bitmap;
        }
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        Bitmap aj = aj(aVar != null ? aVar.getBitmap() : null);
        AppMethodBeat.o(259531);
        return aj;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final void a(ach ach) {
        String str;
        String str2;
        Boolean bool;
        Boolean bool2;
        int i2;
        boolean z;
        crt crt;
        fho fho;
        crr crr;
        Integer num;
        crt crt2;
        com.tencent.mm.plugin.multitask.a.a aVar;
        Activity activity;
        crq crq;
        crq crq2;
        crq crq3;
        crq crq4;
        crq crq5;
        String str3 = null;
        AppMethodBeat.i(200603);
        if (ach == null || (crq5 = ach.LmQ) == null) {
            str = null;
        } else {
            str = crq5.lcm;
        }
        this.lcm = str;
        if (ach == null || (crq4 = ach.LmQ) == null) {
            str2 = null;
        } else {
            str2 = crq4.AbG;
        }
        this.AbG = str2;
        if (ach == null || (crq3 = ach.LmQ) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(crq3.MwF);
        }
        this.AbH = bool;
        if (ach == null || (crq2 = ach.LmQ) == null) {
            bool2 = null;
        } else {
            bool2 = Boolean.valueOf(crq2.MwG);
        }
        this.AbI = bool2;
        if (ach == null || (crq = ach.LmQ) == null) {
            i2 = -1;
        } else {
            i2 = crq.MwH;
        }
        this.AbK = i2;
        if (ach != null) {
            z = ach.LmR;
        } else {
            z = false;
        }
        this.AbJ = Boolean.valueOf(z);
        this.Abq = ach;
        Log.i("MicroMsg.PageMultiTaskHelper", "commoninfo position: " + this.lcm + ",ori_position: " + this.AbG + ", itemPos:" + this.AbK + ", fromTaskBar:" + this.AbJ);
        if (eqZ()) {
            com.tencent.mm.ac.d.a(eqU(), new j(this));
            if (!(!bPr() || (aVar = this.Aak) == null || (activity = aVar.getActivity()) == null)) {
                activity.setRequestedOrientation(1);
            }
        }
        if (ach == null && (crt2 = this.Abr) != null) {
            crt2.sGQ = "";
        }
        if (ach != null) {
            if (!Util.isNullOrNil(ach.sGQ)) {
                crt crt3 = this.Abr;
                if (crt3 != null) {
                    crt3.sGQ = ach.sGQ;
                }
                crt crt4 = this.Abr;
                if (crt4 != null) {
                    MultiTaskInfo multiTaskInfo = this.Abp;
                    if (multiTaskInfo != null) {
                        num = Integer.valueOf(multiTaskInfo.field_type);
                    } else {
                        num = null;
                    }
                    crt4.dUm = num.intValue();
                }
                crt crt5 = this.Abr;
                if (crt5 != null) {
                    MultiTaskInfo multiTaskInfo2 = this.Abp;
                    if (multiTaskInfo2 != null) {
                        str3 = multiTaskInfo2.field_id;
                    }
                    crt5.MwM = str3;
                }
                crt crt6 = this.Abr;
                if (!(crt6 == null || (crr = crt6.MwN) == null)) {
                    crr.MwI = cl.aWA();
                }
                Log.i("MicroMsg.PageMultiTaskHelper", "secdata multitask scene enter contextId: %s", ach.sGQ);
            }
            crq crq6 = ach.LmQ;
            if (crq6 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis < crq6.Jrc || (crt = this.Abr) == null || (fho = crt.VjZ) == null) {
                    AppMethodBeat.o(200603);
                    return;
                }
                fho.VjX = currentTimeMillis - crq6.Jrc;
                AppMethodBeat.o(200603);
                return;
            }
            AppMethodBeat.o(200603);
            return;
        }
        AppMethodBeat.o(200603);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void eqT() {
        AppMethodBeat.i(200604);
        Log.i("MicroMsg.PageMultiTaskHelper", "showHome");
        d.b.a((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class), 1);
        com.tencent.mm.ac.d.a(50, new k(this));
        AppMethodBeat.o(200604);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final Bitmap eqV() {
        String str;
        crq crq;
        AppMethodBeat.i(200605);
        if (MMApplicationContext.isMainProcess()) {
            com.tencent.mm.plugin.multitask.h hVar = com.tencent.mm.plugin.multitask.h.zZn;
            str = com.tencent.mm.plugin.multitask.h.eqA();
            com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
        } else {
            com.tencent.mm.plugin.multitask.f.a aVar2 = com.tencent.mm.plugin.multitask.f.a.AgJ;
            ach ach = this.Abq;
            str = (ach == null || (crq = ach.LmQ) == null) ? null : crq.MwE;
        }
        Bitmap aGR = com.tencent.mm.plugin.multitask.f.a.aGR(str);
        AppMethodBeat.o(200605);
        return aGR;
    }

    public void a(b bVar) {
        AppMethodBeat.i(200606);
        if (bVar != null) {
            bVar.proceed();
            AppMethodBeat.o(200606);
            return;
        }
        AppMethodBeat.o(200606);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$onMenuMultiTaskSelected$1", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "proceed", "", "plugin-multitask_release"})
    public static final class h implements b {
        final /* synthetic */ c AbR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(c cVar) {
            this.AbR = cVar;
        }

        @Override // com.tencent.mm.plugin.multitask.b.c.b
        public final void proceed() {
            com.tencent.mm.plugin.multitask.a.a aVar;
            AppMethodBeat.i(200596);
            if (!this.AbR.eqO()) {
                com.tencent.mm.plugin.multitask.c.c cVar = this.AbR.Aby;
                if (cVar != null) {
                    cVar.RL(0);
                    AppMethodBeat.o(200596);
                    return;
                }
                AppMethodBeat.o(200596);
                return;
            }
            Point multiTaskFloatBallPosition = ((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskFloatBallPosition();
            if (multiTaskFloatBallPosition == null || (aVar = this.AbR.Aak) == null) {
                AppMethodBeat.o(200596);
                return;
            }
            com.tencent.mm.plugin.multitask.animation.b.a aVar2 = com.tencent.mm.plugin.multitask.animation.b.a.zZV;
            com.tencent.mm.plugin.multitask.c.c cVar2 = this.AbR.Aby;
            p.h(aVar, "pageAdapter");
            com.tencent.mm.plugin.multitask.animation.b.a.a(aVar, multiTaskFloatBallPosition, null, true, -1.0f, cVar2);
            AppMethodBeat.o(200596);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public void dkj() {
        AppMethodBeat.i(200608);
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        ai(aj(aVar != null ? aVar.getBitmap() : null));
        AppMethodBeat.o(200608);
    }

    private final void erd() {
        FloatMultiTaskIndicatorView floatMultiTaskIndicatorView;
        com.tencent.mm.plugin.multitask.animation.c.a.b bVar;
        com.tencent.mm.plugin.multitask.animation.c.a.b bVar2;
        Activity activity = null;
        AppMethodBeat.i(200609);
        if (!eqZ() || !eqW()) {
            if (bPp() && this.AbC == null) {
                com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
                if (aVar != null) {
                    this.AbC = new com.tencent.mm.plugin.multitask.animation.swipeahead.b(aVar, this.AbB);
                }
                com.tencent.mm.plugin.multitask.animation.swipeahead.b bVar3 = this.AbC;
                if (bVar3 != null) {
                    bVar3.start();
                }
                com.tencent.mm.plugin.multitask.animation.swipeahead.b bVar4 = this.AbC;
                if (!(bVar4 == null || (floatMultiTaskIndicatorView = bVar4.Aaj) == null)) {
                    floatMultiTaskIndicatorView.eqI();
                    AppMethodBeat.o(200609);
                    return;
                }
            }
        } else if (bPp() || bPs()) {
            com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
            if ((aVar2 != null ? aVar2.getActivity() : null) instanceof MMActivity) {
                if (this.AbD == null) {
                    this.AbD = new com.tencent.mm.plugin.multitask.animation.c.b.b();
                    com.tencent.mm.plugin.multitask.a.a aVar3 = this.Aak;
                    if (!(aVar3 == null || (bVar2 = this.AbD) == null)) {
                        bVar2.a(aVar3, this, this.Abz);
                    }
                }
                this.AbO = bPp();
                AppMethodBeat.o(200609);
                return;
            }
            com.tencent.mm.plugin.multitask.a.a aVar4 = this.Aak;
            if (aVar4 != null) {
                activity = aVar4.getActivity();
            }
            if (activity instanceof MMFragmentActivity) {
                if (this.AbD == null) {
                    this.AbD = new com.tencent.mm.plugin.multitask.animation.c.c.b();
                    com.tencent.mm.plugin.multitask.a.a aVar5 = this.Aak;
                    if (!(aVar5 == null || (bVar = this.AbD) == null)) {
                        bVar.a(aVar5, this, this.Abz);
                    }
                }
                this.AbO = bPp();
            }
            AppMethodBeat.o(200609);
            return;
        }
        AppMethodBeat.o(200609);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createFloatBallTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
    public static final class d implements com.tencent.mm.plugin.multitask.c.c {
        final /* synthetic */ c AbR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(c cVar) {
            this.AbR = cVar;
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void a(Bitmap bitmap, boolean z, int i2) {
            AppMethodBeat.i(200585);
            Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation start, isSwipeBack:" + z + ", way:" + i2);
            com.tencent.mm.plugin.multitask.ui.c cVar = this.AbR.AbN;
            if (cVar != null) {
                cVar.a(this.AbR.Abp, null);
            }
            com.tencent.mm.plugin.multitask.c.c cVar2 = this.AbR.AbF;
            if (cVar2 != null) {
                c.a.a(cVar2, bitmap, z, 4);
            }
            this.AbR.AbM = this.AbR.eqP();
            AppMethodBeat.o(200585);
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void g(Bitmap bitmap, int i2) {
            AppMethodBeat.i(200586);
            Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation end ,way:".concat(String.valueOf(i2)));
            MMHandlerThread.postToMainThreadDelayed(new a(this, bitmap), 150);
            AppMethodBeat.o(200586);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ d AbS;
            final /* synthetic */ Bitmap cKG;

            a(d dVar, Bitmap bitmap) {
                this.AbS = dVar;
                this.cKG = bitmap;
            }

            public final void run() {
                boolean z;
                AppMethodBeat.i(200584);
                com.tencent.mm.plugin.multitask.ui.c cVar = this.AbS.AbR.AbN;
                if (cVar != null) {
                    if (p.j(this.AbS.AbR.AbJ, Boolean.FALSE) || this.AbS.AbR.AbJ == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cVar.e(z, p.j(this.AbS.AbR.AbJ, Boolean.TRUE), new AnimatorListenerAdapter(this) {
                        /* class com.tencent.mm.plugin.multitask.b.c.d.a.AnonymousClass1 */
                        final /* synthetic */ a AbT;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.AbT = r1;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(200582);
                            p.h(animator, "animation");
                            c.a(this.AbT.AbS.AbR, c.a(this.AbT.AbS.AbR, this.AbT.cKG, this.AbT.AbS.AbR.AbM), true, true, true);
                            com.tencent.mm.plugin.multitask.c.c cVar = this.AbT.AbS.AbR.AbF;
                            if (cVar != null) {
                                c.a.a(cVar, this.AbT.cKG);
                                AppMethodBeat.o(200582);
                                return;
                            }
                            AppMethodBeat.o(200582);
                        }

                        public final void onAnimationCancel(Animator animator) {
                            AppMethodBeat.i(200583);
                            c.a(this.AbT.AbS.AbR, c.a(this.AbT.AbS.AbR, this.AbT.cKG, this.AbT.AbS.AbR.AbM), true, true, true);
                            com.tencent.mm.plugin.multitask.c.c cVar = this.AbT.AbS.AbR.AbF;
                            if (cVar != null) {
                                cVar.RL(0);
                                AppMethodBeat.o(200583);
                                return;
                            }
                            AppMethodBeat.o(200583);
                        }
                    });
                    AppMethodBeat.o(200584);
                    return;
                }
                AppMethodBeat.o(200584);
            }
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void RL(int i2) {
            Bitmap bitmap;
            AppMethodBeat.i(200587);
            Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation cancel, way:".concat(String.valueOf(i2)));
            c cVar = this.AbR;
            c cVar2 = this.AbR;
            com.tencent.mm.plugin.multitask.a.a aVar = this.AbR.Aak;
            if (aVar != null) {
                bitmap = aVar.getBitmap();
            } else {
                bitmap = null;
            }
            c.b(cVar, c.a(cVar2, bitmap, this.AbR.eqP()), true);
            com.tencent.mm.plugin.multitask.ui.c cVar3 = this.AbR.AbN;
            if (cVar3 != null) {
                cVar3.e(false, false, null);
            }
            com.tencent.mm.plugin.multitask.a.a aVar2 = this.AbR.Aak;
            if (aVar2 != null) {
                aVar2.a(true, this.AbR);
                AppMethodBeat.o(200587);
                return;
            }
            AppMethodBeat.o(200587);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeBackTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
    public static final class f implements com.tencent.mm.plugin.multitask.c.c {
        final /* synthetic */ c AbR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(c cVar) {
            this.AbR = cVar;
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void RL(int i2) {
            AppMethodBeat.i(200592);
            Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack animation cancel, way:".concat(String.valueOf(i2)));
            d.b.a((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class), 2);
            c cVar = this.AbR;
            com.tencent.mm.plugin.multitask.a.a aVar = this.AbR.Aak;
            Bitmap a2 = c.a(cVar, aVar != null ? aVar.getBitmap() : null, this.AbR.eqP());
            c.b(this.AbR, a2, i2 == 4);
            this.AbR.d(a2, this.AbR.AbP);
            com.tencent.mm.plugin.multitask.a.a aVar2 = this.AbR.Aak;
            if (aVar2 != null) {
                aVar2.a(true, this.AbR);
            }
            com.tencent.mm.plugin.multitask.a.a aVar3 = this.AbR.Aak;
            if (aVar3 != null) {
                aVar3.sj(true);
                AppMethodBeat.o(200592);
                return;
            }
            AppMethodBeat.o(200592);
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void g(Bitmap bitmap, int i2) {
            boolean z;
            AppMethodBeat.i(200593);
            Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack animation end, way:".concat(String.valueOf(i2)));
            d.b.a((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class), 2);
            Bitmap a2 = c.a(this.AbR, bitmap, this.AbR.AbM);
            this.AbR.d(a2, this.AbR.AbP);
            c cVar = this.AbR;
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            c.a(cVar, a2, z, false, false);
            com.tencent.mm.plugin.multitask.a.a aVar = this.AbR.Aak;
            if (aVar != null) {
                aVar.sj(true);
                AppMethodBeat.o(200593);
                return;
            }
            AppMethodBeat.o(200593);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeBackTransformationListener$1$onAnimationStart$1", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "proceed", "", "plugin-multitask_release"})
        public static final class a implements b {
            final /* synthetic */ f AbU;
            final /* synthetic */ boolean AbV;
            final /* synthetic */ int Abd;
            final /* synthetic */ Bitmap cKG;

            a(f fVar, boolean z, Bitmap bitmap, int i2) {
                this.AbU = fVar;
                this.AbV = z;
                this.cKG = bitmap;
                this.Abd = i2;
            }

            @Override // com.tencent.mm.plugin.multitask.b.c.b
            public final void proceed() {
                AppMethodBeat.i(200591);
                this.AbU.AbR.bPu();
                this.AbU.AbR.AbM = this.AbU.AbR.eqP();
                if (this.AbV) {
                    this.AbU.AbR.v(new RunnableC1516a(this));
                    StringBuilder sb = new StringBuilder("auto hideUIC,id:");
                    MultiTaskInfo multiTaskInfo = this.AbU.AbR.Abp;
                    Log.i("MicroMsg.PageMultiTaskHelper", sb.append(multiTaskInfo != null ? multiTaskInfo.field_id : null).toString());
                    com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
                    ((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).sendMultiTaskEvent(0, com.tencent.mm.plugin.multitask.g.eqx(), 1048576);
                } else {
                    c.b(this.AbU.AbR, c.a(this.AbU.AbR, this.cKG, this.AbU.AbR.eqP()), this.Abd == 4);
                }
                com.tencent.mm.plugin.multitask.a.a aVar = this.AbU.AbR.Aak;
                if (aVar != null) {
                    aVar.sj(false);
                    AppMethodBeat.o(200591);
                    return;
                }
                AppMethodBeat.o(200591);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.multitask.b.c$f$a$a  reason: collision with other inner class name */
            static final class RunnableC1516a implements Runnable {
                final /* synthetic */ a AbW;

                RunnableC1516a(a aVar) {
                    this.AbW = aVar;
                }

                public final void run() {
                    AppMethodBeat.i(200590);
                    c.b(this.AbW.AbU.AbR, c.a(this.AbW.AbU.AbR, this.AbW.cKG, this.AbW.AbU.AbR.eqP()), false);
                    AppMethodBeat.o(200590);
                }
            }
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void a(Bitmap bitmap, boolean z, int i2) {
            AppMethodBeat.i(200594);
            Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack start, isSwipeBack:" + z + " ,way:" + i2);
            this.AbR.a(new a(this, z, bitmap, i2));
            AppMethodBeat.o(200594);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createEnterTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.b.c$c  reason: collision with other inner class name */
    public static final class C1515c implements com.tencent.mm.plugin.multitask.c.c {
        final /* synthetic */ c AbR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1515c(c cVar) {
            this.AbR = cVar;
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void RL(int i2) {
            View contentView;
            AppMethodBeat.i(200580);
            Log.i("MicroMsg.PageMultiTaskHelper", "enterTransformation animation cancel, way:".concat(String.valueOf(i2)));
            this.AbR.AbO = true;
            com.tencent.mm.plugin.multitask.a.a aVar = this.AbR.Aak;
            if (aVar == null || (contentView = aVar.getContentView()) == null) {
                AppMethodBeat.o(200580);
                return;
            }
            contentView.setVisibility(0);
            AppMethodBeat.o(200580);
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void g(Bitmap bitmap, int i2) {
            View contentView;
            AppMethodBeat.i(200581);
            Log.i("MicroMsg.PageMultiTaskHelper", "enterTransformation animation end, way:".concat(String.valueOf(i2)));
            this.AbR.AbO = true;
            com.tencent.mm.plugin.multitask.a.a aVar = this.AbR.Aak;
            if (aVar == null || (contentView = aVar.getContentView()) == null) {
                AppMethodBeat.o(200581);
                return;
            }
            contentView.setVisibility(0);
            AppMethodBeat.o(200581);
        }

        @Override // com.tencent.mm.plugin.multitask.c.c
        public final void a(Bitmap bitmap, boolean z, int i2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeAheadToMultiTaskListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "setFloatBallAlpha", "", "alpha", "", "swipePageToMultiTask", "", "lastPosXWhenSwipeReleased", "tryCapture", "", "plugin-multitask_release"})
    public static final class e implements com.tencent.mm.plugin.multitask.c.e {
        final /* synthetic */ c AbR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(c cVar) {
            this.AbR = cVar;
        }

        @Override // com.tencent.mm.plugin.multitask.c.e
        public final int bz(float f2) {
            com.tencent.mm.plugin.multitask.a.a aVar;
            crp crp;
            crp crp2;
            long j2 = 2;
            AppMethodBeat.i(200588);
            if (!this.AbR.eqZ() || !this.AbR.eqW()) {
                this.AbR.bPu();
                this.AbR.dkk();
                crt crt = this.AbR.Abr;
                if (!(crt == null || (crp2 = crt.MwO) == null)) {
                    crp2.MwA = 2;
                }
                crt crt2 = this.AbR.Abr;
                if (!(crt2 == null || (crp = crt2.MwO) == null)) {
                    if (this.AbR.eqW()) {
                        j2 = 1;
                    }
                    crp.jii = j2;
                }
                Point multiTaskFloatBallPosition = ((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskFloatBallPosition();
                if (!(multiTaskFloatBallPosition == null || (aVar = this.AbR.Aak) == null)) {
                    com.tencent.mm.plugin.multitask.animation.b.a aVar2 = com.tencent.mm.plugin.multitask.animation.b.a.zZV;
                    Bitmap bitmap = this.AbR.AbL;
                    com.tencent.mm.plugin.multitask.c.c cVar = this.AbR.Aby;
                    p.h(aVar, "pageAdapter");
                    com.tencent.mm.plugin.multitask.animation.b.a.a(aVar, multiTaskFloatBallPosition, bitmap, false, f2, cVar);
                }
                AppMethodBeat.o(200588);
                return 3;
            }
            AppMethodBeat.o(200588);
            return 1;
        }

        @Override // com.tencent.mm.plugin.multitask.c.e
        public final boolean erf() {
            Bitmap bitmap;
            AppMethodBeat.i(200589);
            com.tencent.mm.plugin.multitask.a.a aVar = this.AbR.Aak;
            if (aVar != null) {
                Boolean.valueOf(aVar.bPp());
            }
            c cVar = this.AbR;
            com.tencent.mm.plugin.multitask.a.a aVar2 = this.AbR.Aak;
            if (aVar2 != null) {
                bitmap = aVar2.getBitmap();
            } else {
                bitmap = null;
            }
            cVar.AbL = bitmap;
            AppMethodBeat.o(200589);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final Bitmap aj(Bitmap bitmap) {
        AppMethodBeat.i(200610);
        Bitmap e2 = e(bitmap, eqP());
        AppMethodBeat.o(200610);
        return e2;
    }

    private final Bitmap e(Bitmap bitmap, boolean z) {
        cru erh;
        cru erh2;
        cru erh3;
        AppMethodBeat.i(200611);
        if (!bPr()) {
            MultiTaskInfo multiTaskInfo = this.Abp;
            if (!(multiTaskInfo == null || (erh3 = multiTaskInfo.erh()) == null)) {
                erh3.xlQ = 0;
            }
            AppMethodBeat.o(200611);
            return bitmap;
        }
        if (bitmap != null) {
            if (z) {
                MultiTaskInfo multiTaskInfo2 = this.Abp;
                if (!(multiTaskInfo2 == null || (erh2 = multiTaskInfo2.erh()) == null)) {
                    erh2.xlQ = 90;
                }
                com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
                if (aVar != null) {
                    Bitmap ag = aVar.ag(bitmap);
                    AppMethodBeat.o(200611);
                    return ag;
                }
                AppMethodBeat.o(200611);
                return null;
            }
            MultiTaskInfo multiTaskInfo3 = this.Abp;
            if (!(multiTaskInfo3 == null || (erh = multiTaskInfo3.erh()) == null)) {
                erh.xlQ = 0;
            }
        }
        AppMethodBeat.o(200611);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean eqP() {
        Activity activity;
        Resources resources;
        Configuration configuration;
        AppMethodBeat.i(200612);
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        if (aVar == null || (activity = aVar.getActivity()) == null || (resources = activity.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            AppMethodBeat.o(200612);
            return false;
        }
        AppMethodBeat.o(200612);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$onMultiTaskAnimDone$1", "Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "onTipCancel", "", "onTipHide", "onTipShow", "plugin-multitask_release"})
    public static final class i implements b.a {
        final /* synthetic */ c AbR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(c cVar) {
            this.AbR = cVar;
        }

        @Override // com.tencent.mm.plugin.multitask.e.b.a
        public final void erg() {
            AppMethodBeat.i(200597);
            c.b(this.AbR);
            AppMethodBeat.o(200597);
        }
    }

    private final void ere() {
        AppMethodBeat.i(200613);
        Log.i("MicroMsg.PageMultiTaskHelper", "finishPage");
        com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
        if ((aVar != null ? aVar.getActivity() : null) instanceof MMActivity) {
            MMHandlerThread.postToMainThreadDelayed(new g(this), 200);
        }
        com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
        if (aVar2 != null) {
            aVar2.a(false, this);
            AppMethodBeat.o(200613);
            return;
        }
        AppMethodBeat.o(200613);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ c AbR;

        g(c cVar) {
            this.AbR = cVar;
        }

        public final void run() {
            com.tencent.mm.plugin.multitask.a.a aVar;
            View contentView;
            AppMethodBeat.i(200595);
            if (this.AbR.Aak != null) {
                com.tencent.mm.plugin.multitask.a.a aVar2 = this.AbR.Aak;
                if (!((aVar2 != null ? aVar2.getContentView() : null) == null || (aVar = this.AbR.Aak) == null || (contentView = aVar.getContentView()) == null)) {
                    contentView.setVisibility(0);
                    AppMethodBeat.o(200595);
                    return;
                }
            }
            AppMethodBeat.o(200595);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.c.d
    public final void onOrientationChange(int i2) {
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean eqS() {
        return this.AbO;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void dkk() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c AbR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(c cVar) {
            super(0);
            this.AbR = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(200598);
            StringBuilder sb = new StringBuilder("auto hideUIC, id:");
            MultiTaskInfo multiTaskInfo = this.AbR.Abp;
            Log.i("MicroMsg.PageMultiTaskHelper", sb.append(multiTaskInfo != null ? multiTaskInfo.field_id : null).toString());
            com.tencent.mm.plugin.multitask.g gVar = com.tencent.mm.plugin.multitask.g.zZj;
            ((com.tencent.mm.plugin.multitask.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).sendMultiTaskEvent(0, com.tencent.mm.plugin.multitask.g.eqx(), 1048576);
            x xVar = x.SXb;
            AppMethodBeat.o(200598);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c AbR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(c cVar) {
            super(0);
            this.AbR = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(200599);
            com.tencent.mm.plugin.multitask.a.a aVar = this.AbR.Aak;
            if (aVar != null) {
                aVar.a(false, this.AbR);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(200599);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public void ib(boolean z) {
        crp crp;
        crp crp2;
        AppMethodBeat.i(200607);
        crt crt = this.Abr;
        if (!(crt == null || (crp2 = crt.MwO) == null)) {
            crp2.MwA = 1;
        }
        if (eqZ()) {
            if (eqW()) {
                Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, has info, type: %d", 1);
                crt crt2 = this.Abr;
                if (!(crt2 == null || (crp = crt2.MwO) == null)) {
                    crp.jii = 1;
                }
                O(4, false);
                AppMethodBeat.o(200607);
                return;
            }
            if (z) {
                com.tencent.mm.plugin.multitask.c.c cVar = this.Aby;
                if (cVar != null) {
                    cVar.RL(0);
                }
                Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, has not info, type: %d", 1);
            }
            AppMethodBeat.o(200607);
        } else if (z) {
            Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, enter multiTask, type: %d", 1);
            a(new h(this));
            AppMethodBeat.o(200607);
        } else {
            Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, do nothing");
            AppMethodBeat.o(200607);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean eqZ() {
        String str;
        crq crq;
        AppMethodBeat.i(200614);
        if (Util.isNullOrNil(this.lcm)) {
            ach ach = this.Abq;
            if (ach == null || (crq = ach.LmQ) == null) {
                str = null;
            } else {
                str = crq.MwC;
            }
            if (Util.isNullOrNil(str) && Util.isNullOrNil(this.AbG)) {
                AppMethodBeat.o(200614);
                return false;
            }
        }
        AppMethodBeat.o(200614);
        return true;
    }

    public static final /* synthetic */ void a(c cVar, Bitmap bitmap, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(200616);
        Log.i("MicroMsg.PageMultiTaskHelper", "onMultiTaskAnimDone, forceUpdate:" + z + ", needUpdateInfo:" + z2 + ", needShowTip:" + z3);
        if (z2) {
            cVar.b(bitmap, z);
        }
        if (z3) {
            com.tencent.mm.plugin.multitask.e.b bVar = com.tencent.mm.plugin.multitask.e.b.Acc;
            com.tencent.mm.plugin.multitask.a.a aVar = cVar.Aak;
            com.tencent.mm.plugin.multitask.e.b.a(aVar != null ? aVar.getActivity() : null, new i(cVar));
            AppMethodBeat.o(200616);
            return;
        }
        cVar.ere();
        AppMethodBeat.o(200616);
    }

    public static final /* synthetic */ void b(c cVar, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(200618);
        cVar.b(bitmap, z);
        AppMethodBeat.o(200618);
    }
}
