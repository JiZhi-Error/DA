package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.bo;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.k;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract;", "", "()V", "PAGE_LIMIT", "", "getPAGE_LIMIT", "()I", "startNetSceneTime", "", "getStartNetSceneTime", "()J", "setStartNetSceneTime", "(J)V", "startNetSceneTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartNetSceneTimeList", "()Ljava/util/ArrayList;", FirebaseAnalytics.b.INDEX, "", "timeStamp", "NotifyPresenter", "NotifyViewCallback", "plugin-finder_release"})
public final class FinderNotifyContract {
    private static final ArrayList<Long> uYJ = new ArrayList<>();
    public static final FinderNotifyContract uYK = new FinderNotifyContract();
    private static final int uYm = 20;

    static {
        AppMethodBeat.i(249960);
        AppMethodBeat.o(249960);
    }

    private FinderNotifyContract() {
    }

    public static long JU(int i2) {
        Long l;
        AppMethodBeat.i(249958);
        ArrayList<Long> arrayList = uYJ;
        if (!(i2 >= 0 && i2 < arrayList.size())) {
            arrayList = null;
        }
        if (arrayList == null || (l = uYJ.get(i2)) == null) {
            AppMethodBeat.o(249958);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(249958);
        return longValue;
    }

    public static void ah(int i2, long j2) {
        AppMethodBeat.i(249959);
        ArrayList<Long> arrayList = uYJ;
        if (!(i2 >= 0 && i2 < arrayList.size())) {
            arrayList = null;
        }
        if (arrayList != null) {
            uYJ.set(i2, Long.valueOf(j2));
        }
        AppMethodBeat.o(249959);
    }

    public static int dlX() {
        return uYm;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B%\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010(\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0018\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u0005H\u0002J.\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001cJ&\u00105\u001a\u00020%2\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001cJ&\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u00101\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J&\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u00101\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0005H\u0002J\u001e\u00109\u001a\u00020%2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0;2\u0006\u0010(\u001a\u00020\u0005H\u0002J,\u0010<\u001a\u00020%2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0006\u0010>\u001a\u00020%J\u0006\u0010?\u001a\u00020%J\u0010\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\u0002H\u0016J\b\u0010B\u001a\u00020%H\u0016J\u0006\u0010C\u001a\u00020%J,\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010HH\u0016J\u0006\u0010I\u001a\u00020%J\u0018\u0010J\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0002H\u0002J\u0018\u0010L\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\b\b\u0002\u0010M\u001a\u00020\u001cJ\b\u0010N\u001a\u00020%H\u0002J \u0010O\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00052\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010QH\u0002J\u0018\u0010S\u001a\u00020%2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\"X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scene", "", "requestScenes", "", "msgTypes", "Ljava/util/ArrayList;", "(I[ILjava/util/ArrayList;)V", "TAG", "", "containerList", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getMsgTypes", "()Ljava/util/ArrayList;", "msgUpdateListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter$msgUpdateListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter$msgUpdateListener$1;", "onVisibleTimeStamp", "", "getRequestScenes", "()[I", "getScene", "()I", "showStatusList", "", "", "getShowStatusList", "()Ljava/util/List;", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderMsgUIItemBrowseStruct;", "unreadMentionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "viewCallbacks", "doScene", "", FirebaseAnalytics.b.INDEX, "getData", "tabIndex", "getIndexFromScene", "requestScene", "getShowStatus", "getTabData", "getTabTypes", "getUnreadMention", "getViewCallback", "loadDataAndRefresh", "mentionId", "limit", "needLoadingAnim", "isRefresh", "loadDataAndRefreshAll", "loadMsgFromDBWithIndex", "loadMsgFromDBWithTypes", "types", "mergeData", "increment", "", "mergeDataRaw", ShareConstants.DEXMODE_RAW, "onActivityCreate", "onActivityDestroy", "onAttach", "callback", "onDetach", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshEmpty", "viewCallbak", "requestRefresh", "needAnim", "setBrowserCount", "setLastMentionId", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "sortMentionList", "plugin-finder_release"})
    public static final class NotifyPresenter implements i, a<NotifyViewCallback> {
        private final String TAG;
        public final int scene;
        public final List<Boolean> uYL;
        private final ConcurrentHashMap<Integer, Long> uYM;
        private ArrayList<NotifyViewCallback> uYN;
        private final ArrayList<ArrayList<com.tencent.mm.plugin.finder.model.a>> uYO;
        public final FinderNotifyContract$NotifyPresenter$msgUpdateListener$1 uYP;
        final int[] uYQ;
        final ArrayList<int[]> uYR;
        public long uYq;
        public final dc uYr;

        private NotifyPresenter(int[] iArr, ArrayList<int[]> arrayList) {
            int i2 = 0;
            p.h(iArr, "requestScenes");
            p.h(arrayList, "msgTypes");
            AppMethodBeat.i(249928);
            this.scene = 1;
            this.uYQ = iArr;
            this.uYR = arrayList;
            this.TAG = "Finder.NotifyPresenter." + hashCode();
            this.uYL = new ArrayList();
            this.uYM = new ConcurrentHashMap<>();
            this.uYN = new ArrayList<>();
            this.uYO = new ArrayList<>();
            this.uYr = new dc();
            this.uYP = new FinderNotifyContract$NotifyPresenter$msgUpdateListener$1(this);
            int size = this.uYR.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.uYO.add(new ArrayList<>());
                this.uYL.add(Boolean.FALSE);
            }
            for (T t : this.uYO) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                Log.i(this.TAG, "init containerList: item[" + i2 + "]: " + t.hashCode());
                i2 = i4;
            }
            AppMethodBeat.o(249928);
        }

        public /* synthetic */ NotifyPresenter(int[] iArr, ArrayList arrayList, byte b2) {
            this(iArr, arrayList);
        }

        public static final /* synthetic */ NotifyViewCallback b(NotifyPresenter notifyPresenter, int i2) {
            AppMethodBeat.i(249931);
            NotifyViewCallback JY = notifyPresenter.JY(i2);
            AppMethodBeat.o(249931);
            return JY;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(NotifyViewCallback notifyViewCallback) {
            AppMethodBeat.i(249918);
            a(notifyViewCallback);
            AppMethodBeat.o(249918);
        }

        public final void onActivityDestroy() {
            AppMethodBeat.i(249916);
            EventCenter.instance.removeListener(this.uYP);
            if (this.scene == 1) {
                int i2 = 0;
                for (T t : this.uYN) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    List<Boolean> list = this.uYL;
                    if (!(i2 >= 0 && i2 < list.size())) {
                        list = null;
                    }
                    if (list != null ? list.get(i2).booleanValue() : false) {
                        long JZ = JZ(i2);
                        WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter = t2.tFp;
                        LongSparseArray<k> longSparseArray = wxRecyclerAdapter != null ? wxRecyclerAdapter.Rrx : null;
                        if (longSparseArray != null) {
                            d.b(longSparseArray, new FinderNotifyContract$NotifyPresenter$setBrowserCount$$inlined$forEachIndexed$lambda$1(JZ, this));
                            i2 = i3;
                        }
                    }
                    i2 = i3;
                }
                this.uYr.bfK();
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(this.uYr);
            }
            Log.i(this.TAG, "onDetach " + this.uYQ);
            g.azz().b(978, this);
            this.uYN.clear();
            AppMethodBeat.o(249916);
        }

        public final void a(NotifyViewCallback notifyViewCallback) {
            AppMethodBeat.i(249917);
            p.h(notifyViewCallback, "callback");
            this.uYN.add(notifyViewCallback);
            ArrayList<NotifyViewCallback> arrayList = this.uYN;
            if (arrayList.size() > 1) {
                j.a((List) arrayList, (Comparator) new FinderNotifyContract$NotifyPresenter$onAttach$$inlined$sortBy$1());
            }
            Log.i(this.TAG, "onAttach " + this.uYQ);
            AppMethodBeat.o(249917);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
        }

        public final ArrayList<com.tencent.mm.plugin.finder.model.a> JV(int i2) {
            ArrayList<com.tencent.mm.plugin.finder.model.a> arrayList;
            AppMethodBeat.i(249919);
            ArrayList<ArrayList<com.tencent.mm.plugin.finder.model.a>> arrayList2 = this.uYO;
            if (!(i2 >= 0 && i2 < this.uYO.size())) {
                arrayList2 = null;
            }
            if (arrayList2 == null || (arrayList = this.uYO.get(i2)) == null) {
                arrayList = new ArrayList<>();
            }
            AppMethodBeat.o(249919);
            return arrayList;
        }

        public final void JW(int i2) {
            AppMethodBeat.i(249920);
            g.azz().b(new bo(this.scene, this.uYQ[i2]));
            FinderNotifyContract finderNotifyContract = FinderNotifyContract.uYK;
            FinderNotifyContract.ah(i2, SystemClock.uptimeMillis());
            AppMethodBeat.o(249920);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(249921);
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetMentionList");
                AppMethodBeat.o(249921);
                throw tVar;
            }
            int i4 = ((bo) qVar).tvu;
            Log.i(this.TAG, "errType " + i2 + ", errCode " + i3 + " errMsg " + str + " requestScene " + i4);
            int JX = JX(i4);
            if (((bo) qVar).scene != this.scene || JX < 0) {
                Log.w(this.TAG, "not my scene or type, ignore");
                AppMethodBeat.o(249921);
            } else if (i2 == 0 && i3 == 0) {
                LinkedList<ao> linkedList = ((bo) qVar).gZp;
                Log.i(this.TAG, "onSceneEnd :" + linkedList.size() + " lastMentionId:" + c(JX, linkedList) + " index:" + JX);
                dc dcVar = this.uYr;
                dcVar.iL(dcVar.aeP() + ((long) linkedList.size()));
                a(MAlarmHandler.NEXT_FIRE_INTERVAL, linkedList.size(), JX, true, true);
                AppMethodBeat.o(249921);
            } else {
                NotifyViewCallback notifyViewCallback = this.uYN.get(JX);
                p.g(notifyViewCallback, "viewCallbacks[index]");
                FinderNotifyContract$NotifyPresenter$refreshEmpty$runnable$1 finderNotifyContract$NotifyPresenter$refreshEmpty$runnable$1 = new FinderNotifyContract$NotifyPresenter$refreshEmpty$runnable$1(this, JX, notifyViewCallback);
                long uptimeMillis = SystemClock.uptimeMillis();
                FinderNotifyContract finderNotifyContract = FinderNotifyContract.uYK;
                long JU = uptimeMillis - FinderNotifyContract.JU(JX);
                c cVar = c.vCb;
                if (JU >= c.dty().value().longValue()) {
                    finderNotifyContract$NotifyPresenter$refreshEmpty$runnable$1.run();
                    AppMethodBeat.o(249921);
                    return;
                }
                c cVar2 = c.vCb;
                d.a(c.dty().value().longValue() - JU, finderNotifyContract$NotifyPresenter$refreshEmpty$runnable$1);
                AppMethodBeat.o(249921);
            }
        }

        private final int JX(int i2) {
            int[] iArr = this.uYQ;
            int length = iArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5 = i4 + 1;
                if (i2 == iArr[i3]) {
                    return i4;
                }
                i3++;
                i4 = i5;
            }
            return -1;
        }

        private final long c(int i2, LinkedList<ao> linkedList) {
            ao aoVar;
            AppMethodBeat.i(249922);
            if (linkedList != null) {
                LinkedList<ao> linkedList2 = linkedList;
                ListIterator<ao> listIterator = linkedList2.listIterator(linkedList2.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        aoVar = null;
                        break;
                    }
                    ao previous = listIterator.previous();
                    int[] iArr = this.uYR.get(i2);
                    p.g(iArr, "msgTypes[index]");
                    if (e.contains(iArr, previous.field_type)) {
                        aoVar = previous;
                        break;
                    }
                }
                ao aoVar2 = aoVar;
                if (aoVar2 != null) {
                    if (this.uYM.containsKey(Integer.valueOf(i2))) {
                        Long l = this.uYM.get(Integer.valueOf(i2));
                        if (l != null && l.longValue() > aoVar2.field_id) {
                            this.uYM.put(Integer.valueOf(i2), Long.valueOf(aoVar2.field_id));
                        }
                    } else {
                        this.uYM.put(Integer.valueOf(i2), Long.valueOf(aoVar2.field_id));
                    }
                    long j2 = aoVar2.field_id;
                    AppMethodBeat.o(249922);
                    return j2;
                }
            }
            AppMethodBeat.o(249922);
            return -1;
        }

        public static /* synthetic */ void a(NotifyPresenter notifyPresenter, int i2) {
            AppMethodBeat.i(249924);
            notifyPresenter.am(i2, false);
            AppMethodBeat.o(249924);
        }

        public final void am(int i2, boolean z) {
            AppMethodBeat.i(249923);
            NotifyViewCallback JY = JY(i2);
            if (JY != null) {
                JY.o(null, 0, false);
            }
            Log.i(this.TAG, "requestRefresh " + i2 + ", " + z);
            if (!z) {
                JW(i2);
            }
            AppMethodBeat.o(249923);
        }

        public final void a(long j2, int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.i(249925);
            d.i(new FinderNotifyContract$NotifyPresenter$loadDataAndRefresh$1(this, j2, i3, i2, z, z2));
            AppMethodBeat.o(249925);
        }

        private final NotifyViewCallback JY(int i2) {
            AppMethodBeat.i(249926);
            ArrayList<NotifyViewCallback> arrayList = this.uYN;
            if (!(i2 >= 0 && i2 < arrayList.size())) {
                arrayList = null;
            }
            if (arrayList != null) {
                NotifyViewCallback notifyViewCallback = arrayList.get(i2);
                AppMethodBeat.o(249926);
                return notifyViewCallback;
            }
            AppMethodBeat.o(249926);
            return null;
        }

        private final long JZ(int i2) {
            AppMethodBeat.i(249927);
            Long l = this.uYM.get(Integer.valueOf(i2));
            if (l != null) {
                long longValue = l.longValue();
                AppMethodBeat.o(249927);
                return longValue;
            }
            AppMethodBeat.o(249927);
            return 0;
        }

        public static final /* synthetic */ ArrayList a(NotifyPresenter notifyPresenter, long j2, int i2, int i3) {
            int[] iArr;
            AppMethodBeat.i(249929);
            ArrayList arrayList = new ArrayList();
            e.a aVar = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
            ArrayList<int[]> arrayList2 = notifyPresenter.uYR;
            if (!(i2 >= 0 && i2 < arrayList2.size())) {
                arrayList2 = null;
            }
            if (arrayList2 == null || (iArr = notifyPresenter.uYR.get(i2)) == null) {
                iArr = new int[0];
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it = e.a.a(j2, i3, iArr, notifyPresenter.scene).iterator();
            while (it.hasNext()) {
                e.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
                com.tencent.mm.plugin.finder.model.a b2 = e.a.b(it.next());
                if (b2 != null) {
                    arrayList3.add(b2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            Log.i(notifyPresenter.TAG, "loadMoreData mentionId:" + j2 + " limit:" + i3 + " list:" + arrayList4.size());
            arrayList.addAll(arrayList4);
            AppMethodBeat.o(249929);
            return arrayList;
        }

        public static final /* synthetic */ void a(NotifyPresenter notifyPresenter, List list, int i2) {
            ArrayList<com.tencent.mm.plugin.finder.model.a> arrayList;
            int i3;
            boolean z;
            AppMethodBeat.i(249930);
            ArrayList<ArrayList<com.tencent.mm.plugin.finder.model.a>> arrayList2 = notifyPresenter.uYO;
            if (!(i2 >= 0 && i2 < notifyPresenter.uYO.size())) {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                arrayList = notifyPresenter.uYO.get(i2);
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                if (arrayList.isEmpty()) {
                    arrayList.addAll(list);
                } else {
                    if (arrayList.get(j.kq(arrayList)) instanceof bc) {
                        arrayList.remove(j.kq(arrayList));
                    }
                    for (com.tencent.mm.plugin.finder.model.a aVar : j.m(list)) {
                        int i4 = 0;
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i4 = -1;
                                break;
                            }
                            com.tencent.mm.plugin.finder.model.a aVar2 = (com.tencent.mm.plugin.finder.model.a) it.next();
                            if (aVar2.uNF.field_id == aVar.uNF.field_id && aVar2.uNF.field_createTime == aVar.uNF.field_createTime) {
                                break;
                            }
                            i4++;
                        }
                        if (i4 == -1) {
                            if (aVar.uNF.field_type == 10 && !Util.isNullOrNil(aVar.uNF.field_clientMsgId)) {
                                int i5 = 0;
                                Iterator it2 = arrayList.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        i5 = -1;
                                        break;
                                    } else if (p.j(((com.tencent.mm.plugin.finder.model.a) it2.next()).uNF.field_clientMsgId, aVar.uNF.field_clientMsgId)) {
                                        break;
                                    } else {
                                        i5++;
                                    }
                                }
                                if (i5 >= 0) {
                                    arrayList.remove(i5);
                                    Log.i(notifyPresenter.TAG, "remove same clientMsgId, " + aVar.uNF.field_clientMsgId);
                                }
                            }
                            arrayList.add(aVar);
                        } else {
                            arrayList.set(i4, aVar);
                        }
                    }
                    FinderNotifyContract$NotifyPresenter$sortMentionList$comparator$1 finderNotifyContract$NotifyPresenter$sortMentionList$comparator$1 = FinderNotifyContract$NotifyPresenter$sortMentionList$comparator$1.uYY;
                    if (arrayList != null) {
                        j.a((List) arrayList, (Comparator) finderNotifyContract$NotifyPresenter$sortMentionList$comparator$1);
                    }
                    Log.i(notifyPresenter.TAG, "increment size " + list.size());
                    if (!list.isEmpty()) {
                        long JZ = notifyPresenter.JZ(i2);
                        if (JZ > 0) {
                            ArrayList<com.tencent.mm.plugin.finder.model.a> arrayList3 = arrayList;
                            ListIterator listIterator = arrayList3.listIterator(arrayList3.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    i3 = -1;
                                    break;
                                }
                                if (((com.tencent.mm.plugin.finder.model.a) listIterator.previous()).uNF.field_id == JZ) {
                                    z = true;
                                    continue;
                                } else {
                                    z = false;
                                    continue;
                                }
                                if (z) {
                                    i3 = listIterator.nextIndex();
                                    break;
                                }
                            }
                            Log.i(notifyPresenter.TAG, "unread index " + i3 + ", raw size " + arrayList.size());
                            if (i3 != -1) {
                                int i6 = 0;
                                if (i3 >= 0) {
                                    while (true) {
                                        arrayList.get(i6).uNG = false;
                                        if (i6 == i3) {
                                            break;
                                        }
                                        i6++;
                                    }
                                }
                                if (i3 != j.kq(arrayList)) {
                                    arrayList.get(i3).uNG = true;
                                }
                            }
                        }
                    }
                }
            }
            Log.i(notifyPresenter.TAG, "mergeData after");
            AppMethodBeat.o(249930);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001VB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001eJ\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0002J$\u00101\u001a\u00020*2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0012032\u0006\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u001eJ\b\u00106\u001a\u00020\fH\u0002J\b\u00107\u001a\u00020\u0005H\u0016J\u0010\u00108\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0002J\b\u00109\u001a\u00020\u0002H\u0016J\b\u0010:\u001a\u0004\u0018\u00010$J(\u0010;\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0012H\u0002J\u0006\u0010@\u001a\u00020*J\b\u0010A\u001a\u00020*H\u0002J\u0006\u0010B\u001a\u00020*J \u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J0\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0016J0\u0010O\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0016J\u0010\u0010P\u001a\u00020*2\u0006\u0010L\u001a\u00020\fH\u0016J\u0006\u0010Q\u001a\u00020*J \u0010R\u001a\u00020*2\b\u0010S\u001a\u0004\u0018\u00010\u000f2\u0006\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u001eR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eXD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "notifyView", "Landroid/view/View;", "presenter", "uiCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "tabIndex", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;I)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "contentView", "context", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "currScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetDetail;", "isEnableRefresh", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshTip", "Landroid/widget/TextView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTabIndex", "()I", "autoRefresh", "", "isRefreshAll", "checkErrorCode", "errCode", "checkMegaVideoDetail", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "finishLoadMore", "msgList", "", "needLoadingAnim", "isRefresh", "getActiveIndex", "getActivity", "getCommentDetail", "getPresenter", "getRefreshLoadMoreLayout", "handleOnMentionClick", "position", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "msg", "initAndRefreshAll", "initRefreshLayout", "initView", "jumpToMv", "isComment", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "commentId", "", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refresh", "showRefreshTip", "tipsContent", "textColor", "clickable", "UICallbackListener", "plugin-finder_release"})
    public static final class NotifyViewCallback implements com.tencent.mm.plugin.finder.presenter.base.c<NotifyPresenter>, HeadFooterLayout.b {
        public final String TAG = ("Finder.NotifyViewCallback." + hashCode());
        public final View contentView;
        public final MMActivity gte;
        public RecyclerView hak;
        public WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> tFp;
        public RefreshLoadMoreLayout tLS;
        public MMProcessBar tSY;
        private af tzB;
        public TextView uYA;
        private cu uYC;
        public final boolean uYZ = true;
        public final NotifyPresenter uZa;
        private final UICallbackListener uZb;
        public final int uZc;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "", "onItemClick", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
        public interface UICallbackListener {
            void a(ao aoVar);
        }

        public NotifyViewCallback(MMActivity mMActivity, View view, NotifyPresenter notifyPresenter, UICallbackListener uICallbackListener, int i2) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(view, "notifyView");
            p.h(notifyPresenter, "presenter");
            AppMethodBeat.i(249953);
            this.uZc = i2;
            this.uZa = notifyPresenter;
            this.gte = mMActivity;
            this.contentView = view;
            this.uZb = uICallbackListener;
            AppMethodBeat.o(249953);
        }

        public static final /* synthetic */ RecyclerView h(NotifyViewCallback notifyViewCallback) {
            AppMethodBeat.i(249955);
            RecyclerView recyclerView = notifyViewCallback.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            AppMethodBeat.o(249955);
            return recyclerView;
        }

        public final void o(String str, int i2, boolean z) {
            AppMethodBeat.i(249949);
            d.h(new FinderNotifyContract$NotifyViewCallback$showRefreshTip$1(this, str, z, i2));
            AppMethodBeat.o(249949);
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final void ddr() {
            AppMethodBeat.i(249950);
            Log.i(this.TAG, "[onOverStop]");
            MMProcessBar mMProcessBar = this.tSY;
            if (mMProcessBar != null) {
                mMProcessBar.gYP();
                AppMethodBeat.o(249950);
                return;
            }
            AppMethodBeat.o(249950);
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean u(int i2, int i3, boolean z) {
            AppMethodBeat.i(249951);
            Log.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(i2)));
            MMProcessBar mMProcessBar = this.tSY;
            if (mMProcessBar != null) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                mMProcessBar.rotate(((float) i2) / ((float) ((int) context.getResources().getDimension(R.dimen.ca))));
            }
            AppMethodBeat.o(249951);
            return false;
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean IJ(int i2) {
            AppMethodBeat.i(249952);
            Log.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(i2)));
            AppMethodBeat.o(249952);
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }

        public static final /* synthetic */ void a(NotifyViewCallback notifyViewCallback, ao aoVar, int i2, h hVar, com.tencent.mm.plugin.finder.model.a aVar) {
            int i3;
            int i4;
            int i5;
            f aYI;
            int i6;
            int i7;
            AppMethodBeat.i(249954);
            if (!(notifyViewCallback.uZa.scene == 1 && notifyViewCallback.uZa.uYQ[notifyViewCallback.uZc] == 1 && i2 == 0)) {
                if (aoVar.field_type == 1) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    int i8 = aoVar.field_type;
                    int i9 = notifyViewCallback.uZc + 1;
                    if (aoVar.isOverlap()) {
                        i7 = 1;
                    } else {
                        i7 = 0;
                    }
                    com.tencent.mm.plugin.finder.report.k.a(i8, i9, i7, aoVar.dym(), aVar.uNF.field_objectId);
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.fz(notifyViewCallback.gte);
                    AppMethodBeat.o(249954);
                    return;
                } else if (aoVar.field_type == 10 || aoVar.field_type == 11) {
                    if (aoVar.field_type == 11 && !Util.isNullOrNil(aoVar.field_username)) {
                        Intent intent = new Intent();
                        intent.putExtra("finder_username", aoVar.field_username);
                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                        Context context = hVar.getContext();
                        p.g(context, "holder.context");
                        FinderReporterUIC.a.a(context, intent, 0, 9, false, 64);
                        com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Context context2 = hVar.getContext();
                        p.g(context2, "holder.context");
                        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
                        AppMethodBeat.o(249954);
                        return;
                    }
                } else if (aoVar.field_type == 2 && (aoVar.field_extFlag & 16) > 0) {
                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                    int i10 = aoVar.field_type;
                    if (aoVar.isOverlap()) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    com.tencent.mm.plugin.finder.report.k.d(i10, i6, aoVar.dym(), aVar.uNF.field_objectId);
                    af afVar = notifyViewCallback.tzB;
                    if (afVar != null) {
                        afVar.cancel();
                    }
                    if (notifyViewCallback.uYC != null) {
                        g.azz().a(notifyViewCallback.uYC);
                    }
                    long j2 = aoVar.field_refVideoObjectId;
                    String str = aoVar.field_refVideoObjectNonceId;
                    p.g(str, "mention.field_refVideoObjectNonceId");
                    FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(notifyViewCallback.gte);
                    notifyViewCallback.uYC = new cu(j2, "", str, fH != null ? fH.dIx() : null);
                    g.azz().a(4195, new FinderNotifyContract$NotifyViewCallback$checkMegaVideoDetail$2(notifyViewCallback, aoVar));
                    g.azz().b(notifyViewCallback.uYC);
                    AppMethodBeat.o(249954);
                    return;
                } else if (aoVar.field_type != 4) {
                    com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
                    int i11 = aoVar.field_type;
                    int i12 = notifyViewCallback.uZc + 1;
                    if (aoVar.isOverlap()) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    com.tencent.mm.plugin.finder.report.k.a(i11, i12, i4, aoVar.dym(), aVar.uNF.field_objectId);
                    af afVar2 = notifyViewCallback.tzB;
                    if (afVar2 != null) {
                        afVar2.cancel();
                    }
                    y yVar = y.vXH;
                    if (y.LC(notifyViewCallback.uZa.scene)) {
                        i5 = 7;
                    } else {
                        i5 = 5;
                    }
                    long j3 = aoVar.field_objectId;
                    String str2 = aoVar.field_objectNonceId;
                    int i13 = notifyViewCallback.uZa.scene;
                    FinderReporterUIC.a aVar6 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH2 = FinderReporterUIC.a.fH(notifyViewCallback.gte);
                    notifyViewCallback.tzB = new af(j3, str2, i5, i13, "", true, null, null, 0, null, false, false, null, fH2 != null ? fH2.dIx() : null, 0, 24512);
                    af afVar3 = notifyViewCallback.tzB;
                    if (afVar3 == null || (aYI = afVar3.aYI()) == null) {
                        AppMethodBeat.o(249954);
                        return;
                    }
                    aYI.b(new FinderNotifyContract$NotifyViewCallback$getCommentDetail$1(notifyViewCallback, aoVar, i5));
                    AppMethodBeat.o(249954);
                    return;
                } else {
                    com.tencent.mm.plugin.finder.report.k kVar4 = com.tencent.mm.plugin.finder.report.k.vfA;
                    int i14 = aoVar.field_type;
                    int i15 = notifyViewCallback.uZc + 1;
                    if (aoVar.isOverlap()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    com.tencent.mm.plugin.finder.report.k.a(i14, i15, i3, aoVar.dym(), aVar.uNF.field_objectId);
                    azp azp = aoVar.field_notify;
                    if (azp != null) {
                        switch (azp.subType) {
                            case 1:
                                ((r) g.af(r.class)).a(notifyViewCallback.gte, azp.LJu, "", 0, 0, azp.link, new AppBrandStatObject());
                                AppMethodBeat.o(249954);
                                return;
                            case 2:
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", azp.link);
                                com.tencent.mm.br.c.b(notifyViewCallback.gte, "webview", ".ui.tools.WebViewUI", intent2);
                                break;
                        }
                        AppMethodBeat.o(249954);
                        return;
                    }
                }
            }
            AppMethodBeat.o(249954);
        }

        public static final /* synthetic */ void a(NotifyViewCallback notifyViewCallback, boolean z, FinderObject finderObject, long j2) {
            String str;
            String str2;
            String str3;
            int i2;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            axw axw;
            axy axy;
            axw axw2;
            axy axy2;
            axw axw3;
            axy axy3;
            axw axw4;
            axy axy4;
            axw axw5;
            axy axy5;
            axw axw6;
            axy axy6;
            axw axw7;
            axy axy7;
            axw axw8;
            axy axy8;
            axw axw9;
            axy axy9;
            axw axw10;
            axy axy10;
            axw axw11;
            axy axy11;
            axw axw12;
            axy axy12;
            axw axw13;
            axy axy13;
            axw axw14;
            axy axy14;
            LinkedList<FinderMedia> linkedList;
            int i3 = 0;
            String str12 = null;
            AppMethodBeat.i(249956);
            FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
            FinderMedia finderMedia = (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null) ? null : (FinderMedia) j.kt(linkedList);
            String str13 = finderMedia != null ? finderMedia.thumbUrl + finderMedia.thumb_url_token : "";
            Intent intent = new Intent();
            intent.putExtra("key_mv_finder_obj", finderObject.toByteArray());
            intent.putExtra("key_launch_mv_comment", z);
            intent.putExtra("key_mv_feed_id", d.zs(finderObject.id));
            intent.putExtra("key_mv_nonce_id", finderObject.objectNonceId);
            intent.putExtra("key_refer_mv_comment_id", j2);
            intent.putExtra("key_mv_cover_url", str13);
            FinderContact finderContact = finderObject.contact;
            if (finderContact != null) {
                str = finderContact.nickname;
            } else {
                str = null;
            }
            intent.putExtra("key_mv_poster", str);
            FinderObjectDesc finderObjectDesc2 = finderObject.objectDesc;
            if (finderObjectDesc2 == null || (axw14 = finderObjectDesc2.mvInfo) == null || (axy14 = axw14.Aqo) == null || (str2 = axy14.extraInfo) == null) {
                str2 = "";
            }
            intent.putExtra("key_mv_extra_info", str2);
            FinderObjectDesc finderObjectDesc3 = finderObject.objectDesc;
            if (finderObjectDesc3 == null || (axw13 = finderObjectDesc3.mvInfo) == null || (axy13 = axw13.Aqo) == null || (str3 = axy13.identification) == null) {
                str3 = "";
            }
            intent.putExtra("key_mv_identification", str3);
            FinderObjectDesc finderObjectDesc4 = finderObject.objectDesc;
            if (finderObjectDesc4 == null || (axw12 = finderObjectDesc4.mvInfo) == null || (axy12 = axw12.Aqo) == null) {
                i2 = 0;
            } else {
                i2 = axy12.duration;
            }
            intent.putExtra("key_mv_music_duration", i2);
            css css = new css();
            css.Ktn = d.zs(finderObject.id);
            css.Kto = finderObject.objectNonceId;
            css.Ktp = str13;
            FinderContact finderContact2 = finderObject.contact;
            if (finderContact2 != null) {
                str4 = finderContact2.nickname;
            } else {
                str4 = null;
            }
            css.Ktq = str4;
            FinderObjectDesc finderObjectDesc5 = finderObject.objectDesc;
            if (finderObjectDesc5 == null || (axw11 = finderObjectDesc5.mvInfo) == null || (axy11 = axw11.Aqo) == null) {
                str5 = null;
            } else {
                str5 = axy11.lDR;
            }
            css.singerName = str5;
            FinderObjectDesc finderObjectDesc6 = finderObject.objectDesc;
            if (finderObjectDesc6 == null || (axw10 = finderObjectDesc6.mvInfo) == null || (axy10 = axw10.Aqo) == null) {
                str6 = null;
            } else {
                str6 = axy10.albumName;
            }
            css.albumName = str6;
            FinderObjectDesc finderObjectDesc7 = finderObject.objectDesc;
            if (finderObjectDesc7 == null || (axw9 = finderObjectDesc7.mvInfo) == null || (axy9 = axw9.Aqo) == null) {
                str7 = null;
            } else {
                str7 = axy9.extraInfo;
            }
            css.extraInfo = str7;
            FinderObjectDesc finderObjectDesc8 = finderObject.objectDesc;
            if (finderObjectDesc8 == null || (axw8 = finderObjectDesc8.mvInfo) == null || (axy8 = axw8.Aqo) == null) {
                str8 = null;
            } else {
                str8 = axy8.LIi;
            }
            css.musicGenre = str8;
            FinderObjectDesc finderObjectDesc9 = finderObject.objectDesc;
            css.issueDate = (finderObjectDesc9 == null || (axw7 = finderObjectDesc9.mvInfo) == null || (axy7 = axw7.Aqo) == null) ? 0 : axy7.LIk;
            FinderObjectDesc finderObjectDesc10 = finderObject.objectDesc;
            if (finderObjectDesc10 == null || (axw6 = finderObjectDesc10.mvInfo) == null || (axy6 = axw6.Aqo) == null) {
                str9 = null;
            } else {
                str9 = axy6.identification;
            }
            css.identification = str9;
            FinderObjectDesc finderObjectDesc11 = finderObject.objectDesc;
            if (!(finderObjectDesc11 == null || (axw5 = finderObjectDesc11.mvInfo) == null || (axy5 = axw5.Aqo) == null)) {
                i3 = axy5.duration;
            }
            css.Alz = i3;
            FinderObjectDesc finderObjectDesc12 = finderObject.objectDesc;
            if (finderObjectDesc12 == null || (axw4 = finderObjectDesc12.mvInfo) == null || (axy4 = axw4.Aqo) == null) {
                str10 = null;
            } else {
                str10 = axy4.BPc;
            }
            css.BPc = str10;
            FinderObjectDesc finderObjectDesc13 = finderObject.objectDesc;
            if (finderObjectDesc13 == null || (axw3 = finderObjectDesc13.mvInfo) == null || (axy3 = axw3.Aqo) == null) {
                str11 = null;
            } else {
                str11 = axy3.LIh;
            }
            css.songLyric = str11;
            FinderObjectDesc finderObjectDesc14 = finderObject.objectDesc;
            if (!(finderObjectDesc14 == null || (axw2 = finderObjectDesc14.mvInfo) == null || (axy2 = axw2.Aqo) == null)) {
                str12 = axy2.Djf;
            }
            css.EsK = str12;
            css.jfz = str13;
            FinderObjectDesc finderObjectDesc15 = finderObject.objectDesc;
            if (!(finderObjectDesc15 == null || (axw = finderObjectDesc15.mvInfo) == null || (axy = axw.Aqo) == null)) {
                ac acVar = ac.vER;
                p.g(axy, "this");
                ac.a(axy, d.zs(finderObject.id), css);
            }
            Log.i(notifyViewCallback.TAG, "jump to musicMvMainUI");
            cst cst = new cst();
            com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
            cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
            cst.MxI = 86;
            cst.MxJ = d.zs(finderObject.id);
            cst.scene = 15;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            cst.Vkb = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(notifyViewCallback.gte).get(FinderReporterUIC.class)).sGQ;
            intent.putExtra("key_mv_report_data", cst.toByteArray());
            String str14 = css.BPc;
            if (str14 == null) {
                str14 = "";
            }
            intent.putExtra("key_mv_song_name", str14);
            String str15 = css.songLyric;
            if (str15 == null) {
                str15 = "";
            }
            intent.putExtra("key_mv_song_lyric", str15);
            String str16 = css.singerName;
            if (str16 == null) {
                str16 = "";
            }
            intent.putExtra("key_mv_singer_name", str16);
            String str17 = css.albumName;
            if (str17 == null) {
                str17 = "";
            }
            intent.putExtra("key_mv_album_name", str17);
            String str18 = css.musicGenre;
            if (str18 == null) {
                str18 = "";
            }
            intent.putExtra("key_mv_music_genre", str18);
            intent.putExtra("key_mv_issue_date", String.valueOf(css.issueDate));
            String str19 = css.EsK;
            if (str19 == null) {
                str19 = "";
            }
            intent.putExtra("key_mv_album_cover_url", str19);
            String str20 = css.identification;
            if (str20 == null) {
                str20 = "";
            }
            intent.putExtra("key_mv_identification", str20);
            String str21 = css.extraInfo;
            if (str21 == null) {
                str21 = "";
            }
            intent.putExtra("key_mv_extra_info", str21);
            intent.putExtra("key_mv_music_duration", css.Alz);
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.K(notifyViewCallback.gte, intent);
            AppMethodBeat.o(249956);
        }

        public static final /* synthetic */ void a(NotifyViewCallback notifyViewCallback, int i2) {
            AppMethodBeat.i(249957);
            if (i2 == -8001) {
                com.tencent.mm.ui.base.h.n(notifyViewCallback.gte, R.string.cmw, 0);
                AppMethodBeat.o(249957);
            } else if (i2 == -8002) {
                com.tencent.mm.ui.base.h.n(notifyViewCallback.gte, R.string.cny, 0);
                AppMethodBeat.o(249957);
            } else {
                if (i2 == -8003) {
                    com.tencent.mm.ui.base.h.n(notifyViewCallback.gte, R.string.d94, 0);
                }
                AppMethodBeat.o(249957);
            }
        }
    }
}
