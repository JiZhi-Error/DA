package com.tencent.mm.plugin.taskbar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abm;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.h;
import com.tencent.mm.plugin.taskbar.ui.section.g;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.s;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b,*\u0002\u00136\u0018\u0000 v2\u00020\u0001:\u0004vwxyB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002J\u001a\u0010E\u001a\u00020F2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010G\u001a\u0004\u0018\u00010HJ\b\u0010I\u001a\u00020FH\u0002J\u0006\u0010J\u001a\u00020FJ\u001e\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u00102\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010NJ\n\u0010O\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010P\u001a\u0004\u0018\u0001002\u0006\u0010Q\u001a\u00020\u0006J\u0006\u0010R\u001a\u00020\u0016J\u0006\u0010S\u001a\u00020FJ\u0006\u0010T\u001a\u00020FJ\u000e\u0010U\u001a\u00020F2\u0006\u0010V\u001a\u00020\u0006J\u0006\u0010W\u001a\u00020FJ\u0006\u0010X\u001a\u00020FJ\u0006\u0010Y\u001a\u00020FJ\u0006\u0010Z\u001a\u00020FJ\u000e\u0010[\u001a\u00020F2\u0006\u0010\\\u001a\u00020\u0016J\u000e\u0010]\u001a\u00020F2\u0006\u0010^\u001a\u000200J\u0016\u0010_\u001a\u00020F2\u0006\u0010\\\u001a\u00020\u00162\u0006\u0010`\u001a\u00020\u0016J\b\u0010a\u001a\u00020FH\u0002J\b\u0010b\u001a\u00020\u0016H\u0002J\u0016\u0010c\u001a\u00020F2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u0016J\u0006\u0010e\u001a\u00020FJ.\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020B2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u0016J&\u0010f\u001a\u00020F2\u0006\u0010k\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u0006J\u0016\u0010l\u001a\u00020F2\u0006\u0010g\u001a\u00020B2\u0006\u0010j\u001a\u00020\u0016J\u000e\u0010l\u001a\u00020F2\u0006\u0010k\u001a\u00020\u000eJ\u001e\u0010m\u001a\u00020F2\u0006\u0010g\u001a\u00020B2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u0016J\u0016\u0010m\u001a\u00020F2\u0006\u0010k\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020\u0006J\u000e\u0010m\u001a\u00020F2\u0006\u0010o\u001a\u00020\u0006J\u001e\u0010p\u001a\u00020F2\u0006\u0010q\u001a\u00020\u00162\u0006\u0010g\u001a\u00020B2\u0006\u0010d\u001a\u00020\u0006J\u0006\u0010r\u001a\u00020FJ\u000e\u0010s\u001a\u00020F2\u0006\u0010t\u001a\u00020\u0006J\u0006\u0010u\u001a\u00020FR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\b\u0012\u0004\u0012\u00020&0\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R*\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002000/j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000200`1X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u000206X\u0004¢\u0006\u0004\n\u0002\u00107R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010:\u001a\u0004\u0018\u00010;8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000¨\u0006z"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter;", "", "view", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;", "(Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;)V", "closePageType", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "getCollectionStorage", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "currentTabIndex", "exceedOtherData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "firstFeedShowInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$TaskBarFeedAppearInfo;", "homeTabChangedListener", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1;", "isTeenMode", "", "()Z", "setTeenMode", "(Z)V", "lastLiveCheckTimeSec", "", "lastStartTime", "liveCheckIntervalSec", "miniProgramOption", "getMiniProgramOption", "()I", "setMiniProgramOption", "(I)V", "myWeAppOnStorageChangeListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "sectionDataMyWeApp", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$AppBrandItem;", "getSectionDataMyWeApp", "()Ljava/util/ArrayList;", "setSectionDataMyWeApp", "(Ljava/util/ArrayList;)V", "sectionDataWeApp", "getSectionDataWeApp", "setSectionDataWeApp", "sectionViewModelMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "Lkotlin/collections/HashMap;", "taskBarOnStorageChangeListener", "taskBarReporter", "Lcom/tencent/mm/plugin/taskbar/report/TaskBarReporter;", "taskBarUpdateEventListener", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$taskBarUpdateEventListener$1", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$taskBarUpdateEventListener$1;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "getUsageStorage", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "viewDuration", "weAppOnStorageChangeListener", "canLaunchAppBrand", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "appInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaAppInfo;", "checkLaunchAppBrand", "", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$LaunchAppBrandPreCheckCallback;", "checkLiveState", "clearPendingShowInfo", "getAppIdList", "", "appBrandItems", "", "getLiveTaskInfo", "getViewModelBySectionType", "sectionType", "isOnMainTab", "onDestroy", "onDidAppear", "onDidClose", "reason", "onOpenHeader", "onPause", "onResume", "onStartToPull", "reloadData", "notify", "reloadOtherData", "viewModel", "reloadWeAppData", "isMy", "removeExceedData", "removeTimeoutData", "removeWeAppData", "pos", "reportOnFirstFeedShow", "reportOnItemAddDeleted", "appItem", "actionType", "actionChannel", "isMyWeApp", "multiTaskInfo", "reportOnItemAppear", "reportOnItemClicked", "isMyWeapp", "itemType", "reportOnItemManualAddDeleteMyWeApp", "insert", "reportTaskBarAppear", "reportTaskBarClose", "closeType", "updateTeenModeStatus", "Companion", "IView", "LaunchAppBrandPreCheckCallback", "TaskBarFeedAppearInfo", "plugin-taskbar_release"})
public final class d {
    public static final a FUM = new a((byte) 0);
    private int AfK;
    private ah FUA;
    ArrayList<b.a> FUB = new ArrayList<>();
    final HashMap<Integer, com.tencent.mm.plugin.taskbar.ui.section.g> FUC = ae.g(s.U(4, new com.tencent.mm.plugin.taskbar.ui.section.g(4, new int[]{2, 21, 22, 6, 4, 3})));
    long FUD;
    int FUE = 60;
    com.tencent.mm.plugin.taskbar.a.a FUF = new com.tencent.mm.plugin.taskbar.a.a();
    long FUG;
    ArrayList<C1800d> FUH = new ArrayList<>();
    final MStorage.IOnStorageChange FUI = new l(this);
    final MStorage.IOnStorageChange FUJ = new h(this);
    final g FUK = new g(this);
    b FUL;
    private ag VbC;
    ArrayList<b.a> VbD = new ArrayList<>();
    private final LinkedList<MultiTaskInfo> VbE = new LinkedList<>();
    int VbF;
    final MStorage.IOnStorageChange VbG = new j(this);
    final p VbH = new p(this);
    boolean iCn;
    final com.tencent.mm.plugin.teenmode.a.c kIM = new i(this);
    long mZq;
    int ocu;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;", "", "animateRemoveSection", "", "sectionType", "", "forceReloadData", "isHeaderOpen", "", "onDataUpdated", "onLiveStatusUpdated", "onTeenModeStatusChanged", "reloadDataIfNeed", "reloadOtherData", "plugin-taskbar_release"})
    public interface b {
        void axf(int i2);

        boolean esy();

        void fuO();

        void fuP();

        void fuQ();

        void fuR();

        void hWR();

        void hWS();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$LaunchAppBrandPreCheckCallback;", "", "onResult", "", "checkOk", "", "plugin-taskbar_release"})
    public interface c {
        void dQ(boolean z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$TaskBarFeedAppearInfo;", "", "()V", "contentId", "", "getContentId", "()Ljava/lang/String;", "setContentId", "(Ljava/lang/String;)V", "expType", "", "getExpType", "()I", "setExpType", "(I)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "pageType", "getPageType", "setPageType", "plugin-taskbar_release"})
    /* renamed from: com.tencent.mm.plugin.taskbar.ui.d$d  reason: collision with other inner class name */
    public static final class C1800d {
        MultiTaskInfo Agu;
        int FUN;
        String pFK;
        int pageType;
    }

    static {
        AppMethodBeat.i(238464);
        AppMethodBeat.o(238464);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "kotlin.jvm.PlatformType", "o2", "compare"})
    public static final class n<T> implements Comparator<MultiTaskInfo> {
        public static final n VbK = new n();

        static {
            AppMethodBeat.i(263583);
            AppMethodBeat.o(263583);
        }

        n() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(MultiTaskInfo multiTaskInfo, MultiTaskInfo multiTaskInfo2) {
            long j2 = multiTaskInfo2.field_updateTime - multiTaskInfo.field_updateTime;
            if (j2 == 0) {
                return 0;
            }
            return j2 > 0 ? 1 : -1;
        }
    }

    public d(b bVar) {
        AppMethodBeat.i(238463);
        this.FUL = bVar;
        this.FUK.alive();
        this.VbH.alive();
        ah fuW = fuW();
        if (fuW != null) {
            fuW.add(this.FUI);
        }
        ag hWZ = hWZ();
        if (hWZ != null) {
            hWZ.add(this.VbG);
        }
        com.tencent.mm.plugin.taskbar.h taskBarStorage = ((PluginTaskBar) com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).getTaskBarStorage();
        if (taskBarStorage != null) {
            taskBarStorage.add(this.FUJ);
        }
        ((com.tencent.mm.plugin.teenmode.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.kIM);
        AppMethodBeat.o(238463);
    }

    public static final /* synthetic */ boolean a(d dVar, LocalUsageInfo localUsageInfo, WxaAttributes.a aVar) {
        AppMethodBeat.i(238465);
        boolean a2 = dVar.a(localUsageInfo, aVar);
        AppMethodBeat.o(238465);
        return a2;
    }

    public static final /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(263594);
        dVar.hXa();
        AppMethodBeat.o(263594);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "TAG", "", "getTimeoutInMs", "plugin-taskbar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static long hXd() {
            AppMethodBeat.i(263578);
            long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_taskbar_recent_timeout, 3600L) * 1000;
            AppMethodBeat.o(263578);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    public final ah fuW() {
        AppMethodBeat.i(238457);
        if (this.FUA == null) {
            this.FUA = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccP();
        }
        ah ahVar = this.FUA;
        AppMethodBeat.o(238457);
        return ahVar;
    }

    /* access modifiers changed from: package-private */
    public final ag hWZ() {
        AppMethodBeat.i(263586);
        if (this.VbC == null) {
            this.VbC = com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccQ();
        }
        ag agVar = this.VbC;
        AppMethodBeat.o(263586);
        return agVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class l implements MStorage.IOnStorageChange {
        final /* synthetic */ d FUO;

        l(d dVar) {
            this.FUO = dVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(238456);
            com.tencent.f.h.RTc.aY(new Runnable(this) {
                /* class com.tencent.mm.plugin.taskbar.ui.d.l.AnonymousClass1 */
                final /* synthetic */ l FUV;

                {
                    this.FUV = r1;
                }

                public final void run() {
                    AppMethodBeat.i(238455);
                    Log.i("MicroMsg.TaskBarViewPresenter", "received weAppOnStorageChangeListener");
                    this.FUV.FUO.bq(true, false);
                    AppMethodBeat.o(238455);
                }
            });
            AppMethodBeat.o(238456);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class j implements MStorage.IOnStorageChange {
        final /* synthetic */ d FUO;

        j(d dVar) {
            this.FUO = dVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(263580);
            com.tencent.f.h.RTc.aY(new Runnable(this) {
                /* class com.tencent.mm.plugin.taskbar.ui.d.j.AnonymousClass1 */
                final /* synthetic */ j VbI;

                {
                    this.VbI = r1;
                }

                public final void run() {
                    AppMethodBeat.i(263579);
                    Log.i("MicroMsg.TaskBarViewPresenter", "received myWeAppOnStorageChangeListener");
                    this.VbI.FUO.bq(true, true);
                    AppMethodBeat.o(263579);
                }
            });
            AppMethodBeat.o(263580);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$taskBarUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/TaskBarDataUpdateEvent;", "callback", "", "event", "plugin-taskbar_release"})
    public static final class p extends IListener<abm> {
        final /* synthetic */ d FUO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(d dVar) {
            this.FUO = dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abm abm) {
            AppMethodBeat.i(263585);
            Log.i("MicroMsg.TaskBarViewPresenter", "received taskBarUpdateEventListener");
            this.FUO.FH(true);
            AppMethodBeat.o(263585);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class h implements MStorage.IOnStorageChange {
        final /* synthetic */ d FUO;

        h(d dVar) {
            this.FUO = dVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(238451);
            Log.i("MicroMsg.TaskBarViewPresenter", "received taskBarOnStorageChangeListener");
            this.FUO.FH(true);
            if (mStorageEventData.eventId == 5) {
                if (mStorageEventData.obj != null) {
                    Object obj = mStorageEventData.obj;
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.TaskBarStorage.TaskBarDeleteNotify");
                        AppMethodBeat.o(238451);
                        throw tVar;
                    }
                    h.b bVar = (h.b) obj;
                    if (bVar.FSf == 2 || bVar.FSf == 3) {
                        d dVar = this.FUO;
                        MultiTaskInfo multiTaskInfo = bVar.Agu;
                        if (multiTaskInfo == null) {
                            kotlin.g.b.p.btv("multiTaskInfo");
                        }
                        dVar.a(multiTaskInfo, 2, bVar.FSf);
                        AppMethodBeat.o(238451);
                        return;
                    }
                }
            } else if (mStorageEventData.eventId == 2) {
                d dVar2 = this.FUO;
                Object obj2 = mStorageEventData.obj;
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.model.MultiTaskInfo");
                    AppMethodBeat.o(238451);
                    throw tVar2;
                }
                dVar2.a((MultiTaskInfo) obj2, 1, 1);
            }
            AppMethodBeat.o(238451);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-taskbar_release"})
    public static final class g extends IListener<kt> {
        final /* synthetic */ d FUO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(d dVar) {
            this.FUO = dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kt ktVar) {
            kt.a aVar;
            b bVar;
            AppMethodBeat.i(238450);
            kt ktVar2 = ktVar;
            boolean fuX = this.FUO.fuX();
            if (!(ktVar2 == null || (aVar = ktVar2.dPO) == null)) {
                this.FUO.AfK = aVar.currentIndex;
                if (!fuX && this.FUO.fuX() && (bVar = this.FUO.FUL) != null) {
                    bVar.fuQ();
                }
            }
            AppMethodBeat.o(238450);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDataChanged"})
    static final class i implements com.tencent.mm.plugin.teenmode.a.c {
        final /* synthetic */ d FUO;

        i(d dVar) {
            this.FUO = dVar;
        }

        @Override // com.tencent.mm.plugin.teenmode.a.c
        public final void onDataChanged() {
            AppMethodBeat.i(238452);
            b bVar = this.FUO.FUL;
            if (bVar != null) {
                bVar.fuR();
                AppMethodBeat.o(238452);
                return;
            }
            AppMethodBeat.o(238452);
        }
    }

    public final boolean fuX() {
        return this.AfK == 0;
    }

    public final com.tencent.mm.plugin.taskbar.ui.section.g abG(int i2) {
        AppMethodBeat.i(238458);
        com.tencent.mm.plugin.taskbar.ui.section.g gVar = this.FUC.get(Integer.valueOf(i2));
        AppMethodBeat.o(238458);
        return gVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "wxaAttributes", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
    static final class e implements q.a {
        final /* synthetic */ d FUO;
        final /* synthetic */ c FUP;
        final /* synthetic */ LocalUsageInfo FUQ;

        e(d dVar, c cVar, LocalUsageInfo localUsageInfo) {
            this.FUO = dVar;
            this.FUP = cVar;
            this.FUQ = localUsageInfo;
        }

        @Override // com.tencent.mm.plugin.appbrand.service.q.a
        public final void b(WxaAttributes wxaAttributes) {
            AppMethodBeat.i(238448);
            if (!(wxaAttributes == null || this.FUP == null)) {
                c cVar = this.FUP;
                d dVar = this.FUO;
                LocalUsageInfo localUsageInfo = this.FUQ;
                WxaAttributes.a bAn = wxaAttributes.bAn();
                kotlin.g.b.p.g(bAn, "wxaAttributes.appInfo");
                cVar.dQ(d.a(dVar, localUsageInfo, bAn));
            }
            AppMethodBeat.o(238448);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(LocalUsageInfo localUsageInfo, WxaAttributes.a aVar) {
        if (aVar.serviceType != 0 && aVar.serviceType != 4) {
            return true;
        }
        if (this.ocu == 0) {
            return localUsageInfo.kWa;
        }
        if (this.ocu == 2) {
            return false;
        }
        return true;
    }

    public final void cau() {
        AppMethodBeat.i(238459);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        kotlin.g.b.p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        this.iCn = ((com.tencent.mm.plugin.teenmode.a.b) af).Vt();
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        kotlin.g.b.p.g(af2, "MMKernel.service(ITeenModeService::class.java)");
        this.ocu = ((com.tencent.mm.plugin.teenmode.a.b) af2).fvp();
        Log.i("MicroMsg.TaskBarView", "alvinluo updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", Boolean.valueOf(this.iCn), Integer.valueOf(this.ocu));
        AppMethodBeat.o(238459);
    }

    public final void T(int i2, boolean z) {
        AppMethodBeat.i(263587);
        if (z) {
            ag hWZ = hWZ();
            if (hWZ != null) {
                hWZ.bh(this.VbD.get(i2).ooj.username, this.VbD.get(i2).ooj.iOo);
                AppMethodBeat.o(263587);
                return;
            }
            AppMethodBeat.o(263587);
            return;
        }
        ah fuW = fuW();
        if (fuW != null) {
            fuW.bi(this.FUB.get(i2).ooj.username, this.FUB.get(i2).ooj.iOo);
            AppMethodBeat.o(263587);
            return;
        }
        AppMethodBeat.o(263587);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fe, code lost:
        if (r4 == true) goto L_0x0100;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bq(boolean r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 304
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.taskbar.ui.d.bq(boolean, boolean):void");
    }

    private final synchronized void hXa() {
        AppMethodBeat.i(263590);
        Log.i("MicroMsg.TaskBarViewPresenter", "removeExceedData %d", Integer.valueOf(this.VbE.size()));
        for (T t : this.VbE) {
            ((PluginTaskBar) com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(t);
            ((com.tencent.mm.plugin.taskbar.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(((MultiTaskInfo) t).field_id, false, 4);
            a(t, 2, 4);
        }
        this.VbE.clear();
        AppMethodBeat.o(263590);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean hXb() {
        boolean z;
        List<MultiTaskInfo> list;
        AppMethodBeat.i(263591);
        com.tencent.mm.plugin.taskbar.ui.section.g abG = abG(4);
        if (abG == null || (list = abG.FVH) == null) {
            AppMethodBeat.o(263591);
            z = false;
        } else {
            int size = list.size();
            long currentTimeMillis = System.currentTimeMillis();
            long hXd = a.hXd();
            Iterator<MultiTaskInfo> it = list.iterator();
            LinkedList linkedList = new LinkedList();
            while (it.hasNext()) {
                MultiTaskInfo next = it.next();
                Log.i("MicroMsg.TaskBarViewPresenter", "item[" + next.erh().title + ", " + next.field_id + "] time:" + next.field_updateTime + " now:" + currentTimeMillis + " limit:" + hXd);
                if (currentTimeMillis - next.field_updateTime > hXd) {
                    linkedList.add(next);
                    it.remove();
                }
            }
            com.tencent.f.h.RTc.aY(new o(linkedList, this));
            Log.i("MicroMsg.TaskBarViewPresenter", "remove Timeout Data done " + size + ' ' + list.size());
            if (size != list.size()) {
                z = true;
                AppMethodBeat.o(263591);
            } else {
                AppMethodBeat.o(263591);
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$removeTimeoutData$1$1"})
    public static final class o implements Runnable {
        final /* synthetic */ d FUO;
        final /* synthetic */ LinkedList VbL;

        o(LinkedList linkedList, d dVar) {
            this.VbL = linkedList;
            this.FUO = dVar;
        }

        public final void run() {
            AppMethodBeat.i(263584);
            Log.i("MicroMsg.TaskBarViewPresenter", "async remove timeout taskbar item");
            for (MultiTaskInfo multiTaskInfo : this.VbL) {
                this.FUO.a(multiTaskInfo, 2, 5);
                ((PluginTaskBar) com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(multiTaskInfo);
                ((com.tencent.mm.plugin.taskbar.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(multiTaskInfo.field_id, false, 5);
            }
            AppMethodBeat.o(263584);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ d FUO;

        k(d dVar) {
            this.FUO = dVar;
        }

        public final void run() {
            AppMethodBeat.i(263581);
            d.c(this.FUO);
            AppMethodBeat.o(263581);
        }
    }

    /* access modifiers changed from: package-private */
    public final MultiTaskInfo hXc() {
        List<MultiTaskInfo> list;
        T t;
        boolean z;
        AppMethodBeat.i(263592);
        com.tencent.mm.plugin.taskbar.ui.section.g abG = abG(4);
        if (abG == null || (list = abG.FVH) == null) {
            AppMethodBeat.o(263592);
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (((MultiTaskInfo) next).field_type == 21) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t2 = t;
        AppMethodBeat.o(263592);
        return t2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006 \u0005* \u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00070\u00032\u0006\u0010\b\u001a\u00020\u0006H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "", "", "intervalSec", "onBatchLiveStatusCallback"})
    static final class f implements aj.a {
        final /* synthetic */ d FUO;
        final /* synthetic */ HashMap FUR;
        final /* synthetic */ HashMap FUS;

        f(d dVar, HashMap hashMap, HashMap hashMap2) {
            this.FUO = dVar;
            this.FUR = hashMap;
            this.FUS = hashMap2;
        }

        @Override // com.tencent.mm.plugin.i.a.aj.a
        public final void e(Map<Long, Integer> map, int i2) {
            b bVar;
            byte[] bArr;
            FinderObject finderObject;
            awe awe;
            AppMethodBeat.i(238449);
            if (i2 > 0) {
                Log.i("MicroMsg.TaskBarViewPresenter", "new interval:".concat(String.valueOf(i2)));
                this.FUO.FUE = i2;
            }
            kotlin.g.b.p.g(map, "map");
            boolean z = false;
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if (value != null && value.intValue() == 2) {
                    aws aws = (aws) this.FUR.get(entry.getKey());
                    if (!(aws == null || (finderObject = aws.tuO) == null || (awe = finderObject.liveInfo) == null)) {
                        awe.liveStatus = 2;
                    }
                    MultiTaskInfo multiTaskInfo = (MultiTaskInfo) this.FUS.get(entry.getKey());
                    if (multiTaskInfo != null) {
                        StringBuilder sb = new StringBuilder("live end: ");
                        kotlin.g.b.p.g(multiTaskInfo, "taskInfo");
                        Log.i("MicroMsg.TaskBarViewPresenter", sb.append(multiTaskInfo.erh().nickname).toString());
                        if (aws == null || (bArr = aws.toByteArray()) == null) {
                            bArr = multiTaskInfo.field_data;
                        }
                        multiTaskInfo.field_data = bArr;
                        ((com.tencent.mm.plugin.taskbar.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(multiTaskInfo.field_id, true, 2);
                        z = true;
                    }
                }
            }
            if (!z || (bVar = this.FUO.FUL) == null) {
                AppMethodBeat.o(238449);
                return;
            }
            bVar.fuO();
            AppMethodBeat.o(238449);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class m implements Runnable {
        final /* synthetic */ d FUO;
        final /* synthetic */ boolean VbJ;

        m(d dVar, boolean z) {
            this.FUO = dVar;
            this.VbJ = z;
        }

        public final void run() {
            b bVar;
            AppMethodBeat.i(263582);
            Log.i("MicroMsg.TaskBarViewPresenter", "do reload data");
            this.FUO.bq(false, false);
            this.FUO.bq(false, true);
            com.tencent.mm.plugin.taskbar.ui.section.g gVar = (com.tencent.mm.plugin.taskbar.ui.section.g) this.FUO.FUC.get(4);
            if (gVar != null) {
                d dVar = this.FUO;
                kotlin.g.b.p.g(gVar, LocaleUtil.ITALIAN);
                dVar.a(gVar);
            }
            if (!this.VbJ || (bVar = this.FUO.FUL) == null) {
                AppMethodBeat.o(263582);
                return;
            }
            bVar.fuP();
            AppMethodBeat.o(263582);
        }
    }

    public final void FH(boolean z) {
        AppMethodBeat.i(263593);
        com.tencent.f.h.RTc.aY(new m(this, z));
        AppMethodBeat.o(263593);
    }

    public final void a(MultiTaskInfo multiTaskInfo, int i2, int i3) {
        AppMethodBeat.i(238462);
        kotlin.g.b.p.h(multiTaskInfo, "multiTaskInfo");
        Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAddDeleted type:%d,pos:%d", Integer.valueOf(multiTaskInfo.field_type), 0);
        this.FUF.a(i2, i3, com.tencent.mm.plugin.taskbar.a.a.Mm(multiTaskInfo.field_type), multiTaskInfo.field_id, ((int) (i2 == 2 ? cl.aWA() - multiTaskInfo.field_updateTime : 0)) / 1000);
        AppMethodBeat.o(238462);
    }

    public final synchronized void a(com.tencent.mm.plugin.taskbar.ui.section.g gVar) {
        b bVar;
        MultiTaskInfo multiTaskInfo;
        AppMethodBeat.i(263589);
        kotlin.g.b.p.h(gVar, "viewModel");
        int size = gVar.FVH.size();
        ArrayList arrayList = new ArrayList();
        g.a aVar = com.tencent.mm.plugin.taskbar.ui.section.g.FVL;
        ArrayList<Integer> hXe = g.a.hXe();
        this.VbE.clear();
        int[] iArr = gVar.FVJ;
        for (int i2 : iArr) {
            g.a aVar2 = com.tencent.mm.plugin.taskbar.ui.section.g.FVL;
            if (g.a.abK(i2) || hXe.contains(Integer.valueOf(i2))) {
                Log.i("MicroMsg.TaskBarViewPresenter", "type blocked ".concat(String.valueOf(i2)));
            } else {
                List<MultiTaskInfo> taskInfoByType = ((com.tencent.mm.plugin.taskbar.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.taskbar.d.class)).getTaskInfoByType(i2);
                int size2 = taskInfoByType.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    if (i3 <= 0) {
                        arrayList.add(taskInfoByType.get(i3));
                    } else {
                        this.VbE.add(taskInfoByType.get(i3));
                    }
                }
            }
        }
        MultiTaskInfo multiTaskInfo2 = null;
        int i4 = -1;
        int size3 = arrayList.size();
        int i5 = 0;
        while (i5 < size3) {
            if (((MultiTaskInfo) arrayList.get(i5)).field_type == 21) {
                multiTaskInfo = (MultiTaskInfo) arrayList.get(i5);
                i4 = i5;
            } else {
                multiTaskInfo = multiTaskInfo2;
            }
            i5++;
            multiTaskInfo2 = multiTaskInfo;
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.festival.a.a.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IFestiv…xportService::class.java)");
        MultiTaskInfo dqr = ((com.tencent.mm.plugin.festival.a.a) af).dqr();
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(dqr == null);
        Log.i("MicroMsg.TaskBarViewPresenter", "festivalMultiTaskInfo == null :%b", objArr);
        if (dqr != null) {
            if (multiTaskInfo2 == null) {
                Log.i("MicroMsg.TaskBarViewPresenter", "insert festivalMultiTaskInfo field_type:%d,field_id:%s", Integer.valueOf(dqr.field_type), dqr.field_id);
                arrayList.add(dqr);
            } else if (dqr.field_updateTime >= multiTaskInfo2.field_updateTime) {
                Log.i("MicroMsg.TaskBarViewPresenter", "replace with festival field_type:%d,field_id:%s", Integer.valueOf(dqr.field_type), dqr.field_id);
                this.VbE.add(multiTaskInfo2);
                arrayList.remove(i4);
                arrayList.add(dqr);
            } else {
                Log.i("MicroMsg.TaskBarViewPresenter", "festival replaced by live");
                this.VbE.add(dqr);
            }
        }
        kotlin.a.j.a((List) arrayList, (Comparator) n.VbK);
        ArrayList arrayList2 = arrayList;
        kotlin.g.b.p.h(arrayList2, "<set-?>");
        gVar.FVH = arrayList2;
        if (size > 0 && gVar.FVH.isEmpty() && (bVar = this.FUL) != null) {
            bVar.axf(gVar.FVr);
        }
        Log.i("MicroMsg.TaskBarViewPresenter", "reloadOtherData " + gVar.FVr + ' ' + size + ' ' + gVar.FVH.size());
        AppMethodBeat.o(263589);
    }
}
