package com.tencent.mm.plugin.multitask.b;

import android.graphics.Bitmap;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 m2\u00020\u0001:\u0001mB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00122\u0006\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u000207H\u0016J\u0012\u0010:\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010;\u001a\u00020\u0016H\u0016J\b\u0010<\u001a\u00020\u0016H\u0016J\u0014\u0010=\u001a\u0004\u0018\u00010\u00122\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010>\u001a\u000207H\u0016J\u0012\u0010?\u001a\u0002072\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020CH\u0016J\n\u0010D\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010E\u001a\u0004\u0018\u00010\u00042\u0006\u0010F\u001a\u00020\"H\u0016J\u001a\u0010G\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00122\u0006\u0010H\u001a\u00020\u0016H\u0016J\b\u0010I\u001a\u00020\u0016H\u0016J\b\u0010J\u001a\u00020\u0016H\u0016J\b\u0010K\u001a\u00020\u0016H\u0016J\b\u0010L\u001a\u00020\u0016H\u0016J\u0018\u0010M\u001a\u00020\u00162\u0006\u0010F\u001a\u00020\"2\u0006\u0010H\u001a\u00020\u0016H\u0016J\u001a\u0010N\u001a\u0002072\u0006\u0010O\u001a\u00020\"2\b\u0010P\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010Q\u001a\u000207H\u0016J\b\u0010R\u001a\u000207H\u0016J\b\u0010S\u001a\u000207H\u0016J\u0010\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020\u0016H\u0016J\u0018\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\"H\u0016J\b\u0010W\u001a\u000207H\u0016J\b\u0010X\u001a\u000207H\u0016J\u0010\u0010Y\u001a\u0002072\u0006\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\\\u001a\u0002072\b\u0010]\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010^\u001a\u0002072\u0006\u0010_\u001a\u00020\u0016H\u0016J\b\u0010`\u001a\u00020\u0016H\u0016J\b\u0010a\u001a\u000207H\u0016J\u001a\u0010b\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00122\u0006\u0010c\u001a\u00020\u0016H\u0016J\b\u0010d\u001a\u000207H\u0016J\u0012\u0010e\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010f\u001a\u000207H\u0016J\u0012\u0010g\u001a\u0002072\b\u0010h\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010i\u001a\u0002072\b\u0010j\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010k\u001a\u0002072\b\u0010l\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u0016\u0010 \u001a\u0004\u0018\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0019R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010$R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0014R\u0016\u00101\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b5\u00103¨\u0006n"}, hxF = {"Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "()V", "THREAD_LOOP_TAG", "", "commonMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "getCommonMultiTaskData", "()Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setCommonMultiTaskData", "(Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "currentMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getCurrentMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setCurrentMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "", "()Z", "isFromTaskBar", "()Ljava/lang/Boolean;", "isSupportAnimFromAddMultiTask", "isSupportExitToMultiTask", "isSupportLandScapeMode", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "isVisiableButtom", "isVisiableTop", "minusScreenType", "", "getMinusScreenType", "()I", "setMinusScreenType", "(I)V", "multiTaskItemPos", "getMultiTaskItemPos", "multiTaskReportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "getMultiTaskReportInfo", "()Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "setMultiTaskReportInfo", "(Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "ori_position", "getOri_position", "()Ljava/lang/String;", "position", "getPosition", "addCurrentMultiTaskInfoWithBlt", "", "bitmap", "forceUpdate", "addOrUpdateCurrentHistoryTaskInfo", "canAddCurrentMultiTask", "canSwipeToMultiTask", "checkBitmap", "fillMultiTaskInfo", "getCurrentMultiTaskInfoList", "onGetMultiTaskInfoListCallback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getHideUICDuration", "", "getHistoryMultiTaskInfo", "getMultiTaskItemPosition", "way", "handleCurrentHistoryTaskInfoOnClose", "ended", "hasCurrentMultiTaskInfo", "isDisableHistory", "isLandScape", "isSupportSwipeToHome", "onClose", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onEnterPage", "onExitPage", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "playSound", "removeCurrentHistoryTaskInfo", "runTask", "runnable", "Ljava/lang/Runnable;", "setMultiTaskCommonInfo", "commonData", "setSwipeToMultiTaskEnable", "enable", "shouldCaptureOnClose", "showHome", "updateCurrentHistoryTaskInfo", "updateBitmapOnly", "updateCurrentMultiTaskInfoByTitle", "updateCurrentMultiTaskInfoWithBlt", "updateCurrentMultiTaskInfoWithoutBlt", "updateIcon", "icon", "updateNickname", "nickname", "updateTitle", "title", "Companion", "plugin-multitask_release"})
public class a implements b {
    public static final C1514a Abu = new C1514a((byte) 0);
    public MultiTaskInfo Abp;
    protected ach Abq;
    crt Abr;
    private final String Abs = "MultiTasklLoopTag";
    private int Abt;

    static {
        AppMethodBeat.i(200578);
        AppMethodBeat.o(200578);
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public final MultiTaskInfo eqN() {
        return this.Abp;
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public final crt hWn() {
        return this.Abr;
    }

    public void G(int i2, String str) {
        fho fho;
        AppMethodBeat.i(200561);
        this.Abp = new MultiTaskInfo();
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (multiTaskInfo != null) {
            multiTaskInfo.field_updateTime = cl.aWA();
        }
        MultiTaskInfo multiTaskInfo2 = this.Abp;
        if (multiTaskInfo2 != null) {
            multiTaskInfo2.field_id = str;
        }
        MultiTaskInfo multiTaskInfo3 = this.Abp;
        if (multiTaskInfo3 != null) {
            multiTaskInfo3.field_type = i2;
        }
        this.Abt = i2;
        this.Abr = new crt();
        crt crt = this.Abr;
        if (crt != null) {
            crt.MwO = new crp();
        }
        crt crt2 = this.Abr;
        if (crt2 != null) {
            crt2.MwN = new crr();
        }
        crt crt3 = this.Abr;
        if (crt3 != null) {
            crt3.MwP = new crs();
        }
        crt crt4 = this.Abr;
        if (crt4 != null) {
            crt4.VjZ = new fho();
        }
        crt crt5 = this.Abr;
        if (crt5 == null || (fho = crt5.VjZ) == null) {
            AppMethodBeat.o(200561);
            return;
        }
        fho.VjY = true;
        AppMethodBeat.o(200561);
    }

    public boolean O(int i2, boolean z) {
        return false;
    }

    public boolean bPp() {
        return false;
    }

    public boolean bPs() {
        return false;
    }

    public boolean eqO() {
        return true;
    }

    public boolean bPr() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public boolean eqP() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public Bitmap aj(Bitmap bitmap) {
        return null;
    }

    public void a(ach ach) {
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public String getPosition() {
        return null;
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public String eqQ() {
        return null;
    }

    public int eqR() {
        return -1;
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public boolean eqS() {
        return false;
    }

    public void bCA() {
        String str;
        crr crr;
        AppMethodBeat.i(200562);
        Object[] objArr = new Object[1];
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (multiTaskInfo != null) {
            str = multiTaskInfo.field_id;
        } else {
            str = null;
        }
        objArr[0] = str;
        Log.i("MicroMsg.AbsMultiTaskHelper", "onEnterPage, type:", objArr);
        crt crt = this.Abr;
        if (crt == null || (crr = crt.MwN) == null) {
            AppMethodBeat.o(200562);
            return;
        }
        crr.MwI = cl.aWA();
        AppMethodBeat.o(200562);
    }

    public void aGj() {
        String str;
        crr crr;
        AppMethodBeat.i(200563);
        Object[] objArr = new Object[1];
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (multiTaskInfo != null) {
            str = multiTaskInfo.field_id;
        } else {
            str = null;
        }
        objArr[0] = str;
        Log.i("MicroMsg.AbsMultiTaskHelper", "onExitPage, type:", objArr);
        crt crt = this.Abr;
        if (!(crt == null || (crr = crt.MwN) == null || cl.aWA() < crr.MwI)) {
            crr.duration += cl.aWA() - crr.MwI;
        }
        if (eqZ() && eqW()) {
            v(new b(this));
        }
        AppMethodBeat.o(200563);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a Abv;

        b(a aVar) {
            this.Abv = aVar;
        }

        public final void run() {
            AppMethodBeat.i(200557);
            ((d) g.ah(d.class)).reportMultiTaskInfo(2, this.Abv.Abr);
            AppMethodBeat.o(200557);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public void eqT() {
    }

    public long eqU() {
        return 500;
    }

    public static void a(com.tencent.mm.plugin.multitask.c.a aVar) {
        AppMethodBeat.i(200564);
        ((d) g.ah(d.class)).getMultiTaskInfoList(aVar);
        AppMethodBeat.o(200564);
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public Bitmap eqV() {
        return null;
    }

    public final void b(Bitmap bitmap, boolean z) {
        crp crp;
        crp crp2;
        byte[] bArr;
        crp crp3;
        AppMethodBeat.i(200566);
        Log.i("MicroMsg.AbsMultiTaskHelper", "addCurrentMultiTaskInfoWithBlt, forceUpdate:".concat(String.valueOf(z)));
        if (!eqW()) {
            crt crt = this.Abr;
            if (!(crt == null || (crp3 = crt.MwO) == null)) {
                crp3.jii = 2;
            }
            MultiTaskInfo multiTaskInfo = this.Abp;
            if (multiTaskInfo != null) {
                d dVar = (d) g.ah(d.class);
                String str = multiTaskInfo.field_id;
                p.g(str, "it.field_id");
                int i2 = multiTaskInfo.field_type;
                cru erh = multiTaskInfo.erh();
                p.g(erh, "it.showData");
                MultiTaskInfo multiTaskInfo2 = this.Abp;
                if (multiTaskInfo2 != null) {
                    bArr = multiTaskInfo2.field_data;
                } else {
                    bArr = null;
                }
                dVar.addTaskInfoByBitmap(str, i2, erh, bitmap, bArr, this.Abr);
                AppMethodBeat.o(200566);
                return;
            }
            AppMethodBeat.o(200566);
        } else if (!z) {
            crt crt2 = this.Abr;
            if (!(crt2 == null || (crp2 = crt2.MwO) == null)) {
                crp2.jii = 1;
            }
            ah(bitmap);
            AppMethodBeat.o(200566);
        } else {
            crt crt3 = this.Abr;
            if (!(crt3 == null || (crp = crt3.MwO) == null)) {
                crp.jii = 1;
            }
            MultiTaskInfo multiTaskInfo3 = this.Abp;
            if (multiTaskInfo3 != null) {
                String str2 = multiTaskInfo3.field_id;
                p.g(str2, "it.field_id");
                int i3 = multiTaskInfo3.field_type;
                cru erh2 = multiTaskInfo3.erh();
                p.g(erh2, "it.showData");
                ((d) g.ah(d.class)).addTaskInfoByBitmap(str2, i3, erh2, bitmap, multiTaskInfo3.field_data, this.Abr);
                AppMethodBeat.o(200566);
                return;
            }
            AppMethodBeat.o(200566);
        }
    }

    public boolean dki() {
        return false;
    }

    public void eqX() {
        MultiTaskInfo multiTaskInfo;
        AppMethodBeat.i(200567);
        if (!eqW() || (multiTaskInfo = this.Abp) == null) {
            AppMethodBeat.o(200567);
            return;
        }
        String str = multiTaskInfo.field_id;
        p.g(str, "it.field_id");
        int i2 = multiTaskInfo.field_type;
        cru erh = multiTaskInfo.erh();
        p.g(erh, "it.showData");
        ((d) g.ah(d.class)).updateTaskInfoByBitmap(str, i2, erh, null, multiTaskInfo.field_data);
        AppMethodBeat.o(200567);
    }

    private void eqY() {
        MultiTaskInfo multiTaskInfo;
        AppMethodBeat.i(200568);
        if (!eqW() || (multiTaskInfo = this.Abp) == null) {
            AppMethodBeat.o(200568);
            return;
        }
        String str = multiTaskInfo.field_id;
        p.g(str, "it.field_id");
        int i2 = multiTaskInfo.field_type;
        cru erh = multiTaskInfo.erh();
        p.g(erh, "it.showData");
        ((d) g.ah(d.class)).updateTaskInfoByTitle(str, i2, erh, multiTaskInfo.field_data);
        AppMethodBeat.o(200568);
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public void ah(Bitmap bitmap) {
        MultiTaskInfo multiTaskInfo;
        AppMethodBeat.i(200569);
        if (!eqW() || (multiTaskInfo = this.Abp) == null) {
            AppMethodBeat.o(200569);
            return;
        }
        String str = multiTaskInfo.field_id;
        p.g(str, "it.field_id");
        int i2 = multiTaskInfo.field_type;
        cru erh = multiTaskInfo.erh();
        p.g(erh, "it.showData");
        ((d) g.ah(d.class)).updateTaskInfoByBitmap(str, i2, erh, bitmap, multiTaskInfo.field_data);
        AppMethodBeat.o(200569);
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public void ic(boolean z) {
        AppMethodBeat.i(200570);
        ib(z);
        AppMethodBeat.o(200570);
    }

    public void ib(boolean z) {
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public void bPu() {
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public boolean bPq() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public boolean eqZ() {
        return false;
    }

    public boolean bPt() {
        return false;
    }

    public boolean erb() {
        return true;
    }

    public void dkj() {
        AppMethodBeat.i(200571);
        ai(null);
        AppMethodBeat.o(200571);
    }

    public void ai(Bitmap bitmap) {
        AppMethodBeat.i(200572);
        if (bPt()) {
            AppMethodBeat.o(200572);
            return;
        }
        Log.i("MicroMsg.AbsMultiTaskHelper", "add or update taskInfo");
        MultiTaskInfo era = era();
        if (era != null) {
            ((com.tencent.mm.plugin.taskbar.d) g.ah(com.tencent.mm.plugin.taskbar.d.class)).addOrUpdateTaskInfoByBitmap(era.field_id, era.field_type, era.erh(), bitmap, era.field_data);
            AppMethodBeat.o(200572);
            return;
        }
        AppMethodBeat.o(200572);
    }

    public final void c(Bitmap bitmap, boolean z) {
        AppMethodBeat.i(200574);
        if (bPt()) {
            AppMethodBeat.o(200574);
            return;
        }
        Log.i("MicroMsg.AbsMultiTaskHelper", "updateCurrentHistoryTaskInfo");
        MultiTaskInfo era = era();
        if (era != null) {
            ((com.tencent.mm.plugin.taskbar.d) g.ah(com.tencent.mm.plugin.taskbar.d.class)).updateTaskInfoByBitmap(era.field_id, era.field_type, era.erh(), bitmap, era.field_data, z);
            AppMethodBeat.o(200574);
            return;
        }
        AppMethodBeat.o(200574);
    }

    public final void erc() {
        AppMethodBeat.i(200575);
        if (bPt()) {
            AppMethodBeat.o(200575);
            return;
        }
        MultiTaskInfo era = era();
        if (era != null) {
            ((com.tencent.mm.plugin.taskbar.d) g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(era.field_id, true, 2);
            AppMethodBeat.o(200575);
            return;
        }
        AppMethodBeat.o(200575);
    }

    public void d(Bitmap bitmap, boolean z) {
        AppMethodBeat.i(200576);
        if (bPt()) {
            AppMethodBeat.o(200576);
        } else if (z) {
            Log.i("MicroMsg.AbsMultiTaskHelper", "ended, remove historyTaskInfo");
            erc();
            AppMethodBeat.o(200576);
        } else {
            Log.i("MicroMsg.AbsMultiTaskHelper", "not ended update historyTaskInfo");
            c(bitmap, false);
            AppMethodBeat.o(200576);
        }
    }

    public final void v(Runnable runnable) {
        AppMethodBeat.i(200577);
        p.h(runnable, "runnable");
        h.RTc.e(runnable, this.Abs);
        AppMethodBeat.o(200577);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.b.a$a  reason: collision with other inner class name */
    public static final class C1514a {
        private C1514a() {
        }

        public /* synthetic */ C1514a(byte b2) {
            this();
        }
    }

    public final void aCM(String str) {
        cru erh;
        AppMethodBeat.i(200558);
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (!(multiTaskInfo == null || (erh = multiTaskInfo.erh()) == null)) {
            erh.title = str;
        }
        eqY();
        AppMethodBeat.o(200558);
    }

    public final void agS(String str) {
        cru erh;
        AppMethodBeat.i(200559);
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (!(multiTaskInfo == null || (erh = multiTaskInfo.erh()) == null)) {
            erh.MwR = str;
        }
        eqY();
        AppMethodBeat.o(200559);
    }

    public final void aGL(String str) {
        cru erh;
        AppMethodBeat.i(200560);
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (!(multiTaskInfo == null || (erh = multiTaskInfo.erh()) == null)) {
            erh.nickname = str;
        }
        eqY();
        AppMethodBeat.o(200560);
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public final boolean eqW() {
        AppMethodBeat.i(200565);
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (multiTaskInfo != null) {
            boolean hasTaskInfo = ((d) g.ah(d.class)).hasTaskInfo(multiTaskInfo);
            AppMethodBeat.o(200565);
            return hasTaskInfo;
        }
        AppMethodBeat.o(200565);
        return false;
    }

    public MultiTaskInfo era() {
        return this.Abp;
    }

    @Override // com.tencent.mm.plugin.multitask.b.b
    public final String RK(int i2) {
        AppMethodBeat.i(200573);
        MultiTaskInfo multiTaskInfo = this.Abp;
        if (multiTaskInfo != null) {
            String str = multiTaskInfo.field_id;
            p.g(str, "it.field_id");
            String multiTaskItemPosition = ((d) g.ah(d.class)).getMultiTaskItemPosition(str, eqR(), i2);
            AppMethodBeat.o(200573);
            return multiTaskItemPosition;
        }
        AppMethodBeat.o(200573);
        return "";
    }
}
