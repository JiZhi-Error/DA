package com.tencent.mm.plugin.multitask.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.crt;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b(\bf\u0018\u0000 d2\u00020\u0001:\u0001dJ\u001a\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000f2\u0006\u00103\u001a\u00020\u0013H&J\b\u00104\u001a\u000201H&J\u0012\u00104\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000fH&J\b\u00105\u001a\u00020\u0013H&J\b\u00106\u001a\u00020\u0013H&J\u0014\u00107\u001a\u0004\u0018\u00010\u000f2\b\u00102\u001a\u0004\u0018\u00010\u000fH&J\b\u00108\u001a\u000201H&J\u0012\u00109\u001a\u0002012\b\u0010:\u001a\u0004\u0018\u00010;H&J\b\u0010<\u001a\u00020=H&J\n\u0010>\u001a\u0004\u0018\u00010\tH&J\u0012\u0010?\u001a\u0004\u0018\u00010+2\u0006\u0010@\u001a\u00020\u001fH&J\u001a\u0010A\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000f2\u0006\u0010B\u001a\u00020\u0013H&J\b\u0010C\u001a\u00020\u0013H&J\b\u0010D\u001a\u00020\u0013H&J\b\u0010E\u001a\u00020\u0013H&J\b\u0010F\u001a\u00020\u0013H&J\u0018\u0010G\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020\u0013H&J\u001a\u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020\u001f2\b\u0010J\u001a\u0004\u0018\u00010+H&J\b\u0010K\u001a\u000201H&J\b\u0010L\u001a\u000201H&J\b\u0010M\u001a\u000201H&J\u0010\u0010N\u001a\u0002012\u0006\u0010O\u001a\u00020\u0013H&J\u0018\u0010N\u001a\u0002012\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u001fH&J\b\u0010Q\u001a\u000201H&J\b\u0010R\u001a\u000201H&J\u0012\u0010S\u001a\u0002012\b\u0010T\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020\u0013H&J\b\u0010W\u001a\u00020\u0013H&J\b\u0010X\u001a\u000201H&J\u001a\u0010Y\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000f2\u0006\u0010Z\u001a\u00020\u0013H&J\b\u0010[\u001a\u000201H&J\u0012\u0010\\\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000fH&J\b\u0010]\u001a\u000201H&J\u0012\u0010^\u001a\u0002012\b\u0010_\u001a\u0004\u0018\u00010+H&J\u0012\u0010`\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010+H&J\u0012\u0010b\u001a\u0002012\b\u0010c\u001a\u0004\u0018\u00010+H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0012\u0010\u0018\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0012\u0010\u0019\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0012\u0010\u001a\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0012\u0010\u001b\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u0004\u0018\u00010#X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0011R\u0014\u0010*\u001a\u0004\u0018\u00010+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u0004\u0018\u00010+X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-¨\u0006e"}, hxF = {"Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "", "commonMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "getCommonMultiTaskData", "()Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setCommonMultiTaskData", "(Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;)V", "currentMultiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getCurrentMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setCurrentMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "", "()Z", "isFromTaskBar", "()Ljava/lang/Boolean;", "isSupportAnimFromAddMultiTask", "isSupportExitToMultiTask", "isSupportLandScapeMode", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "isVisiableButtom", "isVisiableTop", "multiTaskItemPos", "", "getMultiTaskItemPos", "()I", "multiTaskReportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "getMultiTaskReportInfo", "()Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "setMultiTaskReportInfo", "(Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "ori_position", "", "getOri_position", "()Ljava/lang/String;", "position", "getPosition", "addCurrentMultiTaskInfoWithBlt", "", "bitmap", "forceUpdate", "addOrUpdateCurrentHistoryTaskInfo", "canAddCurrentMultiTask", "canSwipeToMultiTask", "checkBitmap", "fillMultiTaskInfo", "getCurrentMultiTaskInfoList", "onGetMultiTaskInfoListCallback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getHideUICDuration", "", "getHistoryMultiTaskInfo", "getMultiTaskItemPosition", "way", "handleCurrentHistoryTaskInfoOnClose", "ended", "hasCurrentMultiTaskInfo", "isDisableHistory", "isLandScape", "isSupportSwipeToHome", "onClose", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onEnterPage", "onExitPage", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "playSound", "removeCurrentHistoryTaskInfo", "setMultiTaskCommonInfo", "commonData", "setSwipeToMultiTaskEnable", "enable", "shouldCaptureOnClose", "showHome", "updateCurrentHistoryTaskInfo", "updateBitmapOnly", "updateCurrentMultiTaskInfoByTitle", "updateCurrentMultiTaskInfoWithBlt", "updateCurrentMultiTaskInfoWithoutBlt", "updateIcon", "icon", "updateNickname", "nickname", "updateTitle", "title", "Companion", "plugin-multitask_release"})
public interface b {
    public static final a Abw = a.Abx;

    String RK(int i2);

    void ah(Bitmap bitmap);

    Bitmap aj(Bitmap bitmap);

    boolean bPq();

    void bPu();

    MultiTaskInfo eqN();

    boolean eqP();

    String eqQ();

    boolean eqS();

    void eqT();

    Bitmap eqV();

    boolean eqW();

    boolean eqZ();

    String getPosition();

    crt hWn();

    void ic(boolean z);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper$Companion;", "", "()V", "WAY_BACK_PRESSED", "", "WAY_CLOSE_BTN", "WAY_MENU_BTN", "WAY_SWIPE_BACK", "WAY_UNKNOWN", "plugin-multitask_release"})
    public static final class a {
        static final /* synthetic */ a Abx = new a();

        static {
            AppMethodBeat.i(200579);
            AppMethodBeat.o(200579);
        }

        private a() {
        }
    }
}
