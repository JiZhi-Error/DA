package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.cgi.bo;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.model.be;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract;", "", "()V", "PAGE_LIMIT", "", "getPAGE_LIMIT", "()I", "startNetSceneTime", "", "getStartNetSceneTime", "()J", "setStartNetSceneTime", "(J)V", "MsgPresenter", "MsgViewCallback", "plugin-finder_release"})
public final class FinderMsgContract {
    private static long uWm = SystemClock.uptimeMillis();
    private static final int uYm = 20;
    public static final FinderMsgContract uYn = new FinderMsgContract();

    static {
        AppMethodBeat.i(166566);
        AppMethodBeat.o(166566);
    }

    private FinderMsgContract() {
    }

    public static void ET(long j2) {
        uWm = j2;
    }

    public static long dlW() {
        return uWm;
    }

    public static int dlX() {
        return uYm;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0014\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u001e\u001a\u00020\u001fJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ&\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J,\u0010'\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100)2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010&\u001a\u00020%J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\u001fH\u0016J\u0006\u0010.\u001a\u00020\u001fJ,\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u000103H\u0016J\u0006\u00104\u001a\u00020\u001fJ\u0010\u00105\u001a\u00020\u001f2\b\b\u0002\u00106\u001a\u00020%J\u0014\u00107\u001a\u00020\u001f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "scene", "", "requestScene", "msgTypes", "", "(II[I)V", "TAG", "", "browseDuration", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getMsgTypes", "()[I", "msgUpdateListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter$msgUpdateListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter$msgUpdateListener$1;", "onVisibleTimeStamp", "getRequestScene", "()I", "getScene", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderMsgUIItemBrowseStruct;", "unreadMention", "viewCallback", "doScene", "", "getData", "loadMoreData", "mentionId", "limit", "needLoadingAnim", "", "isRefresh", "mergeData", "increment", "", ShareConstants.DEXMODE_RAW, "onAttach", "callback", "onDetach", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "requestRefresh", "needAnim", "sortMentionList", "plugin-finder_release"})
    public static final class MsgPresenter implements i, a<MsgViewCallback> {
        private final String TAG;
        final ArrayList<com.tencent.mm.plugin.finder.model.a> kgc;
        final int scene;
        final int tvu;
        private MsgViewCallback uYo;
        private long uYp;
        public long uYq;
        private final dc uYr;
        private final FinderMsgContract$MsgPresenter$msgUpdateListener$1 uYs;
        private final int[] uYt;

        public MsgPresenter(int i2, int i3, int[] iArr) {
            p.h(iArr, "msgTypes");
            AppMethodBeat.i(249887);
            this.scene = i2;
            this.tvu = i3;
            this.uYt = iArr;
            this.TAG = "Finder.FinderFinderMsgContract.MsgPresenter." + hashCode();
            this.kgc = new ArrayList<>();
            this.uYr = new dc();
            this.uYs = new FinderMsgContract$MsgPresenter$msgUpdateListener$1(this);
            AppMethodBeat.o(249887);
        }

        public /* synthetic */ MsgPresenter(int i2, int[] iArr) {
            this(1, i2, iArr);
            AppMethodBeat.i(166541);
            AppMethodBeat.o(166541);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(MsgViewCallback msgViewCallback) {
            AppMethodBeat.i(166534);
            a(msgViewCallback);
            AppMethodBeat.o(166534);
        }

        public final void a(MsgViewCallback msgViewCallback) {
            AppMethodBeat.i(166533);
            p.h(msgViewCallback, "callback");
            EventCenter.instance.add(this.uYs);
            this.uYo = msgViewCallback;
            Log.i(this.TAG, "onAttach " + this.tvu);
            g.azz().a(978, this);
            if (this.scene == 1) {
                dc dcVar = this.uYr;
                String cMD = ((c) g.af(c.class)).cMD();
                if (cMD == null) {
                    cMD = "";
                }
                dcVar.ok(cMD);
            }
            AppMethodBeat.o(166533);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            AppMethodBeat.i(166535);
            EventCenter.instance.removeListener(this.uYs);
            if (this.scene == 1) {
                this.uYr.bfK();
                k kVar = k.vfA;
                k.a(this.uYr);
            }
            this.uYo = null;
            Log.i(this.TAG, "onDetach " + this.tvu);
            g.azz().b(978, this);
            AppMethodBeat.o(166535);
        }

        public final void onStop() {
            AppMethodBeat.i(249883);
            this.uYr.iX(System.currentTimeMillis() - this.uYq);
            AppMethodBeat.o(249883);
        }

        public final int a(long j2, int i2, boolean z, boolean z2) {
            long j3;
            long longValue;
            AppMethodBeat.i(249884);
            MsgViewCallback msgViewCallback = this.uYo;
            if (msgViewCallback != null) {
                ArrayList arrayList = new ArrayList();
                e.a aVar = e.vGT;
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = e.a.a(j2, i2, this.uYt, this.scene).iterator();
                while (it.hasNext()) {
                    e.a aVar2 = e.vGT;
                    com.tencent.mm.plugin.finder.model.a b2 = e.a.b(it.next());
                    if (b2 != null) {
                        arrayList2.add(b2);
                    }
                }
                ArrayList<com.tencent.mm.plugin.finder.model.a> arrayList3 = arrayList2;
                Log.i(this.TAG, "loadMoreData mentionId:" + j2 + " limit:" + i2 + " list:" + arrayList3.size());
                arrayList.addAll(arrayList3);
                if (this.scene == 1) {
                    for (com.tencent.mm.plugin.finder.model.a aVar3 : arrayList3) {
                        if (aVar3.uNF.field_id < this.uYp || this.uYp == 0) {
                            switch (aVar3.uNF.field_type) {
                                case 1:
                                    dc dcVar = this.uYr;
                                    dcVar.iT(dcVar.aeX() + 1);
                                    break;
                                case 2:
                                    dc dcVar2 = this.uYr;
                                    dcVar2.iU(dcVar2.aeY() + 1);
                                    break;
                                case 3:
                                    dc dcVar3 = this.uYr;
                                    dcVar3.iV(dcVar3.aeZ() + 1);
                                    break;
                                case 5:
                                    dc dcVar4 = this.uYr;
                                    dcVar4.iW(dcVar4.afa() + 1);
                                    break;
                            }
                            dc dcVar5 = this.uYr;
                            dcVar5.iO(dcVar5.aeS() + 1);
                        } else {
                            switch (aVar3.uNF.field_type) {
                                case 1:
                                    dc dcVar6 = this.uYr;
                                    dcVar6.iP(dcVar6.aeT() + 1);
                                    break;
                                case 2:
                                    dc dcVar7 = this.uYr;
                                    dcVar7.iQ(dcVar7.aeU() + 1);
                                    break;
                                case 3:
                                    dc dcVar8 = this.uYr;
                                    dcVar8.iR(dcVar8.aeV() + 1);
                                    break;
                                case 5:
                                    dc dcVar9 = this.uYr;
                                    dcVar9.iS(dcVar9.aeW() + 1);
                                    break;
                            }
                            dc dcVar10 = this.uYr;
                            dcVar10.iN(dcVar10.aeR() + 1);
                        }
                        dc dcVar11 = this.uYr;
                        dcVar11.iM(dcVar11.aeQ() + 1);
                    }
                }
                ArrayList arrayList4 = arrayList;
                p.h(arrayList4, "msgList");
                z.d dVar = new z.d();
                dVar.SYE = msgViewCallback.uYz.kgc.size();
                if (z) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    FinderMsgContract finderMsgContract = FinderMsgContract.uYn;
                    long dlW = uptimeMillis - FinderMsgContract.dlW();
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (dlW >= com.tencent.mm.plugin.finder.storage.c.dty().value().longValue()) {
                        longValue = 0;
                    } else {
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        longValue = com.tencent.mm.plugin.finder.storage.c.dty().value().longValue() - dlW;
                    }
                    j3 = longValue;
                } else {
                    j3 = 0;
                }
                d.a(j3, new FinderMsgContract$MsgViewCallback$finishLoadMore$1(msgViewCallback, arrayList4, z2, dVar));
                int size = arrayList3.size();
                AppMethodBeat.o(249884);
                return size;
            }
            AppMethodBeat.o(249884);
            return -1;
        }

        public final void dlY() {
            RefreshLoadMoreLayout dcQ;
            AppMethodBeat.i(249885);
            MsgViewCallback msgViewCallback = this.uYo;
            if (msgViewCallback != null) {
                msgViewCallback.o(null, 0, false);
            }
            MsgViewCallback msgViewCallback2 = this.uYo;
            if (msgViewCallback2 == null || (dcQ = msgViewCallback2.dcQ()) == null) {
                AppMethodBeat.o(249885);
                return;
            }
            dcQ.DD(false);
            AppMethodBeat.o(249885);
        }

        public static /* synthetic */ void a(MsgPresenter msgPresenter, List list) {
            int i2;
            boolean z;
            AppMethodBeat.i(249886);
            ArrayList<com.tencent.mm.plugin.finder.model.a> arrayList = msgPresenter.kgc;
            p.h(list, "increment");
            p.h(arrayList, ShareConstants.DEXMODE_RAW);
            if (arrayList.isEmpty()) {
                arrayList.addAll(list);
            } else {
                if (arrayList.get(j.kq(arrayList)) instanceof bc) {
                    arrayList.remove(j.kq(arrayList));
                }
                for (com.tencent.mm.plugin.finder.model.a aVar : j.m(list)) {
                    int i3 = 0;
                    Iterator<com.tencent.mm.plugin.finder.model.a> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        com.tencent.mm.plugin.finder.model.a next = it.next();
                        if (next.uNF.field_id == aVar.uNF.field_id && next.uNF.field_createTime == aVar.uNF.field_createTime) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 == -1) {
                        if (aVar.uNF.field_type == 10 && !Util.isNullOrNil(aVar.uNF.field_clientMsgId)) {
                            int i4 = 0;
                            Iterator<com.tencent.mm.plugin.finder.model.a> it2 = arrayList.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    i4 = -1;
                                    break;
                                } else if (p.j(it2.next().uNF.field_clientMsgId, aVar.uNF.field_clientMsgId)) {
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (i4 >= 0) {
                                arrayList.remove(i4);
                                Log.i(msgPresenter.TAG, "remove same clientMsgId, " + aVar.uNF.field_clientMsgId);
                            }
                        }
                        arrayList.add(aVar);
                    } else {
                        arrayList.set(i3, aVar);
                    }
                }
                p.h(arrayList, ShareConstants.DEXMODE_RAW);
                j.a((List) arrayList, (Comparator) FinderMsgContract$MsgPresenter$sortMentionList$comparator$1.uYy);
            }
            Log.i(msgPresenter.TAG, "increment size " + list.size());
            if ((!list.isEmpty()) && msgPresenter.uYp > 0) {
                ArrayList<com.tencent.mm.plugin.finder.model.a> arrayList2 = arrayList;
                ListIterator<com.tencent.mm.plugin.finder.model.a> listIterator = arrayList2.listIterator(arrayList2.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        i2 = -1;
                        break;
                    }
                    if (listIterator.previous().uNF.field_id == msgPresenter.uYp) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        i2 = listIterator.nextIndex();
                        break;
                    }
                }
                Log.i(msgPresenter.TAG, "unread index " + i2 + ", raw size " + arrayList.size());
                if (i2 != -1) {
                    int i5 = 0;
                    if (i2 >= 0) {
                        while (true) {
                            arrayList.get(i5).uNG = false;
                            if (i5 == i2) {
                                break;
                            }
                            i5++;
                        }
                    }
                    if (i2 != j.kq(arrayList)) {
                        arrayList.get(i2).uNG = true;
                    }
                }
            }
            AppMethodBeat.o(249886);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(166540);
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("errType ").append(i2).append(", errCode ").append(i3).append(" errMsg ").append(str).append(" requestScene ");
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetMentionList");
                AppMethodBeat.o(166540);
                throw tVar;
            }
            Log.i(str2, append.append(((bo) qVar).tvu).toString());
            if (((bo) qVar).scene != this.scene || this.tvu != ((bo) qVar).tvu) {
                Log.w(this.TAG, "not my scene or type, ignore");
                AppMethodBeat.o(166540);
            } else if (i2 == 0 && i3 == 0) {
                LinkedList<ao> linkedList = ((bo) qVar).gZp;
                ao aoVar = (ao) j.kv(linkedList);
                long j2 = aoVar != null ? aoVar.field_id : 0;
                Log.i(this.TAG, "newUnreadMention " + j2 + ", unreadMention " + this.uYp);
                if (j2 > 0) {
                    if (this.uYp == 0) {
                        this.uYp = j2;
                    } else if (j2 < this.uYp) {
                        this.uYp = j2;
                    }
                }
                Log.i(this.TAG, "unreadMention " + this.uYp + " newMenList:" + linkedList.size());
                a(MAlarmHandler.NEXT_FIRE_INTERVAL, linkedList.size(), true, true);
                AppMethodBeat.o(166540);
            } else {
                MsgViewCallback msgViewCallback = this.uYo;
                if (msgViewCallback != null) {
                    FinderMsgContract$MsgPresenter$onSceneEnd$1$runnable$1 finderMsgContract$MsgPresenter$onSceneEnd$1$runnable$1 = new FinderMsgContract$MsgPresenter$onSceneEnd$1$runnable$1(this.kgc.isEmpty(), msgViewCallback);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    FinderMsgContract finderMsgContract = FinderMsgContract.uYn;
                    long dlW = uptimeMillis - FinderMsgContract.dlW();
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (dlW >= com.tencent.mm.plugin.finder.storage.c.dty().value().longValue()) {
                        finderMsgContract$MsgPresenter$onSceneEnd$1$runnable$1.run();
                        AppMethodBeat.o(166540);
                        return;
                    }
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    d.a(com.tencent.mm.plugin.finder.storage.c.dty().value().longValue() - dlW, finderMsgContract$MsgPresenter$onSceneEnd$1$runnable$1);
                    AppMethodBeat.o(166540);
                    return;
                }
                AppMethodBeat.o(166540);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001GB'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J$\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\b\u00100\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\b\u00102\u001a\u00020\u0002H\u0016J\u0006\u00103\u001a\u00020 J\u0006\u00104\u001a\u00020$J \u00105\u001a\u00020$2\u0006\u00106\u001a\u00020.2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J0\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J0\u0010A\u001a\u00020.2\u0006\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020.H\u0016J\u0010\u0010B\u001a\u00020$2\u0006\u0010>\u001a\u00020&H\u0016J \u0010C\u001a\u00020$2\b\u0010D\u001a\u0004\u0018\u00010\r2\u0006\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020.R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "msgView", "Landroid/view/View;", "presenter", "uiCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "contentView", "context", "curCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderFeedComment;", "currScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetDetail;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshTip", "Landroid/widget/TextView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "checkErrorCode", "", "errCode", "", "checkMegaVideoDetail", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "finishLoadMore", "msgList", "", "needLoadingAnim", "", "isRefresh", "getActivity", "getCommentDetail", "getPresenter", "getRefreshLoadMoreLayout", "initView", "jumpToMv", "isComment", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "commentId", "", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "showRefreshTip", "tip", "textColor", "clickable", "UICallbackListener", "plugin-finder_release"})
    public static final class MsgViewCallback implements com.tencent.mm.plugin.finder.presenter.base.c<MsgPresenter>, HeadFooterLayout.b {
        private final String TAG = ("Finder.FinderMsgContract.MsgViewCallback." + hashCode());
        private final View contentView;
        final MMActivity gte;
        private RecyclerView hak;
        public WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> tFp;
        private RefreshLoadMoreLayout tLS;
        private MMProcessBar tSY;
        private af tzB;
        private TextView uYA;
        private final UICallbackListener uYB;
        private cu uYC;
        final MsgPresenter uYz;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "", "onItemClick", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
        public interface UICallbackListener {
            void a(ao aoVar);
        }

        public MsgViewCallback(MMActivity mMActivity, View view, MsgPresenter msgPresenter, UICallbackListener uICallbackListener) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(view, "msgView");
            p.h(msgPresenter, "presenter");
            AppMethodBeat.i(166560);
            this.uYz = msgPresenter;
            this.gte = mMActivity;
            this.contentView = view;
            this.uYB = uICallbackListener;
            AppMethodBeat.o(166560);
        }

        public static final /* synthetic */ RecyclerView g(MsgViewCallback msgViewCallback) {
            AppMethodBeat.i(166562);
            RecyclerView recyclerView = msgViewCallback.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            AppMethodBeat.o(166562);
            return recyclerView;
        }

        public static final /* synthetic */ RefreshLoadMoreLayout h(MsgViewCallback msgViewCallback) {
            AppMethodBeat.i(249905);
            RefreshLoadMoreLayout refreshLoadMoreLayout = msgViewCallback.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(249905);
            return refreshLoadMoreLayout;
        }

        public static final /* synthetic */ TextView i(MsgViewCallback msgViewCallback) {
            AppMethodBeat.i(166565);
            TextView textView = msgViewCallback.uYA;
            if (textView == null) {
                p.btv("refreshTip");
            }
            AppMethodBeat.o(166565);
            return textView;
        }

        public final void initView() {
            MsgViewCallback msgViewCallback;
            f d2;
            AppMethodBeat.i(166557);
            View findViewById = this.contentView.findViewById(R.id.h7t);
            p.g(findViewById, "contentView.findViewById(R.id.rl_layout)");
            this.tLS = (RefreshLoadMoreLayout) findViewById;
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            refreshLoadMoreLayout.setLimitTopRequest(((int) context.getResources().getDimension(R.dimen.a5g)) - ((int) context2.getResources().getDimension(R.dimen.bx)));
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            if (refreshLoadMoreLayout2 == null) {
                p.btv("rlLayout");
            }
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            refreshLoadMoreLayout2.setRefreshTargetY(((int) context3.getResources().getDimension(R.dimen.cp)) - ((int) context4.getResources().getDimension(R.dimen.a5g)));
            RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
            if (refreshLoadMoreLayout3 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout3.setDamping(1.85f);
            View findViewById2 = this.contentView.findViewById(R.id.h7v);
            p.g(findViewById2, "contentView.findViewById…ar>(R.id.rl_loading_icon)");
            this.tSY = (MMProcessBar) findViewById2;
            RefreshLoadMoreLayout refreshLoadMoreLayout4 = this.tLS;
            if (refreshLoadMoreLayout4 == null) {
                p.btv("rlLayout");
            }
            this.hak = refreshLoadMoreLayout4.getRecyclerView();
            View findViewById3 = this.contentView.findViewById(R.id.fmu);
            p.g(findViewById3, "contentView.findViewById(R.id.msg_refresh_tip)");
            this.uYA = (TextView) findViewById3;
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            recyclerView.setLayoutManager(new LinearLayoutManager());
            TextView textView = this.uYA;
            if (textView == null) {
                p.btv("refreshTip");
            }
            textView.setOnClickListener(new FinderMsgContract$MsgViewCallback$initView$1(this));
            FinderMsgContract$MsgViewCallback$initView$2 finderMsgContract$MsgViewCallback$initView$2 = new FinderMsgContract$MsgViewCallback$initView$2(this);
            ArrayList<com.tencent.mm.plugin.finder.model.a> arrayList = this.uYz.kgc;
            if (arrayList != null) {
                if (this.uYz.scene == 1 && this.uYz.tvu == 1) {
                    ao aoVar = new ao();
                    aoVar.field_id = MAlarmHandler.NEXT_FIRE_INTERVAL;
                    aoVar.field_createTime = Integer.MAX_VALUE;
                    arrayList.add(0, new be(aoVar));
                }
                msgViewCallback = this;
            } else {
                arrayList = null;
                msgViewCallback = this;
            }
            msgViewCallback.tFp = new WxRecyclerAdapter<>(finderMsgContract$MsgViewCallback$initView$2, arrayList, true);
            WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.RrA = new FinderMsgContract$MsgViewCallback$initView$4(this);
            }
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (d2 = FinderReporterUIC.d(fH)) == null)) {
                RecyclerView recyclerView2 = this.hak;
                if (recyclerView2 == null) {
                    p.btv("recyclerView");
                }
                d2.m(recyclerView2);
            }
            RecyclerView recyclerView3 = this.hak;
            if (recyclerView3 == null) {
                p.btv("recyclerView");
            }
            recyclerView3.setAdapter(this.tFp);
            WxRecyclerAdapter<com.tencent.mm.plugin.finder.model.a> wxRecyclerAdapter2 = this.tFp;
            if (wxRecyclerAdapter2 != null) {
                wxRecyclerAdapter2.RqP = new FinderMsgContract$MsgViewCallback$initView$5(this);
            }
            RefreshLoadMoreLayout refreshLoadMoreLayout5 = this.tLS;
            if (refreshLoadMoreLayout5 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout5.setOverCallback(this);
            RefreshLoadMoreLayout refreshLoadMoreLayout6 = this.tLS;
            if (refreshLoadMoreLayout6 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout6.setActionCallback(new FinderMsgContract$MsgViewCallback$initView$6(this));
            d.a(d.aBx(), new FinderMsgContract$MsgViewCallback$initView$7(this));
            d.a(300, new FinderMsgContract$MsgViewCallback$initView$8(this));
            AppMethodBeat.o(166557);
        }

        public final RefreshLoadMoreLayout dcQ() {
            AppMethodBeat.i(249900);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(249900);
            return refreshLoadMoreLayout;
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final void ddr() {
            AppMethodBeat.i(249901);
            Log.i(this.TAG, "[onOverStop]");
            MMProcessBar mMProcessBar = this.tSY;
            if (mMProcessBar == null) {
                p.btv("rlProcessBar");
            }
            mMProcessBar.gYP();
            AppMethodBeat.o(249901);
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean u(int i2, int i3, boolean z) {
            AppMethodBeat.i(249902);
            Log.i(this.TAG, "[onOverStart] dy=".concat(String.valueOf(i2)));
            MMProcessBar mMProcessBar = this.tSY;
            if (mMProcessBar == null) {
                p.btv("rlProcessBar");
            }
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            mMProcessBar.rotate(((float) i2) / ((float) ((int) context.getResources().getDimension(R.dimen.ca))));
            AppMethodBeat.o(249902);
            return false;
        }

        @Override // com.tencent.mm.view.HeadFooterLayout.b
        public final boolean IJ(int i2) {
            AppMethodBeat.i(249903);
            Log.i(this.TAG, "[onOverEnd] dy=".concat(String.valueOf(i2)));
            AppMethodBeat.o(249903);
            return false;
        }

        public final void o(String str, int i2, boolean z) {
            AppMethodBeat.i(166559);
            d.h(new FinderMsgContract$MsgViewCallback$showRefreshTip$1(this, str, z, i2));
            AppMethodBeat.o(166559);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }

        public static final /* synthetic */ void a(MsgViewCallback msgViewCallback, ao aoVar) {
            AppMethodBeat.i(249904);
            if (msgViewCallback.uYC != null) {
                g.azz().a(msgViewCallback.uYC);
            }
            af afVar = msgViewCallback.tzB;
            if (afVar != null) {
                afVar.cancel();
            }
            long j2 = aoVar.field_refVideoObjectId;
            String str = aoVar.field_refVideoObjectNonceId;
            p.g(str, "mention.field_refVideoObjectNonceId");
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(msgViewCallback.gte);
            msgViewCallback.uYC = new cu(j2, "", str, fH != null ? fH.dIx() : null);
            g.azz().a(4195, new FinderMsgContract$MsgViewCallback$checkMegaVideoDetail$2(msgViewCallback, aoVar));
            g.azz().b(msgViewCallback.uYC);
            AppMethodBeat.o(249904);
        }

        public static final /* synthetic */ void b(MsgViewCallback msgViewCallback, ao aoVar) {
            int i2;
            AppMethodBeat.i(166561);
            y yVar = y.vXH;
            if (y.LC(msgViewCallback.uYz.scene)) {
                i2 = 7;
            } else {
                i2 = 5;
            }
            long j2 = aoVar.field_objectId;
            String str = aoVar.field_objectNonceId;
            int i3 = msgViewCallback.uYz.scene;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(msgViewCallback.gte);
            msgViewCallback.tzB = new af(j2, str, i2, i3, "", true, null, null, 0, null, false, false, null, fH != null ? fH.dIx() : null, 0, 24512);
            af afVar = msgViewCallback.tzB;
            if (afVar == null) {
                p.hyc();
            }
            afVar.aYI().b(new FinderMsgContract$MsgViewCallback$getCommentDetail$1(msgViewCallback, aoVar, i2));
            AppMethodBeat.o(166561);
        }

        public static final /* synthetic */ void a(MsgViewCallback msgViewCallback, boolean z, FinderObject finderObject, long j2) {
            String str;
            x xVar;
            String str2;
            String str3;
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
            FinderObjectDesc finderObjectDesc;
            axw axw15;
            axy axy15;
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            AppMethodBeat.i(249906);
            String str4 = null;
            FinderObjectDesc finderObjectDesc2 = finderObject.objectDesc;
            if (!(finderObjectDesc2 == null || (linkedList = finderObjectDesc2.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null)) {
                str4 = finderMedia.thumbUrl + finderMedia.thumb_url_token;
            }
            String str5 = str4;
            if (!(!(str5 == null || str5.length() == 0) || (finderObjectDesc = finderObject.objectDesc) == null || (axw15 = finderObjectDesc.mvInfo) == null || (axy15 = axw15.Aqo) == null)) {
                String str6 = axy15.Djf;
                if (str6 == null) {
                    str6 = "";
                }
                str4 = str6;
            }
            FinderContact finderContact = finderObject.contact;
            if (finderContact != null) {
                str = finderContact.nickname;
            } else {
                str = null;
            }
            css css = new css();
            long j3 = finderObject.id;
            String str7 = finderObject.objectNonceId;
            if (str4 == null || str == null || str7 == null) {
                xVar = null;
            } else {
                Intent intent = new Intent();
                intent.putExtra("key_mv_cover_url", str4);
                intent.putExtra("key_mv_feed_id", d.zs(j3));
                intent.putExtra("key_mv_nonce_id", str7);
                intent.putExtra("key_mv_poster", str);
                intent.putExtra("key_launch_mv_comment", z);
                intent.putExtra("key_refer_mv_comment_id", j2);
                intent.putExtra("key_need_update_music_ball_url", true);
                FinderObjectDesc finderObjectDesc3 = finderObject.objectDesc;
                if (finderObjectDesc3 == null || (axw14 = finderObjectDesc3.mvInfo) == null || (axy14 = axw14.Aqo) == null || (str2 = axy14.extraInfo) == null) {
                    str2 = "";
                }
                intent.putExtra("key_mv_extra_info", str2);
                FinderObjectDesc finderObjectDesc4 = finderObject.objectDesc;
                if (finderObjectDesc4 == null || (axw13 = finderObjectDesc4.mvInfo) == null || (axy13 = axw13.Aqo) == null || (str3 = axy13.identification) == null) {
                    str3 = "";
                }
                intent.putExtra("key_mv_identification", str3);
                FinderObjectDesc finderObjectDesc5 = finderObject.objectDesc;
                intent.putExtra("key_mv_music_duration", (finderObjectDesc5 == null || (axw12 = finderObjectDesc5.mvInfo) == null || (axy12 = axw12.Aqo) == null) ? 0 : axy12.duration);
                css.Ktn = d.zs(j3);
                css.Kto = str7;
                css.Ktp = str4;
                css.Ktq = str;
                FinderObjectDesc finderObjectDesc6 = finderObject.objectDesc;
                css.singerName = (finderObjectDesc6 == null || (axw11 = finderObjectDesc6.mvInfo) == null || (axy11 = axw11.Aqo) == null) ? null : axy11.lDR;
                FinderObjectDesc finderObjectDesc7 = finderObject.objectDesc;
                css.albumName = (finderObjectDesc7 == null || (axw10 = finderObjectDesc7.mvInfo) == null || (axy10 = axw10.Aqo) == null) ? null : axy10.albumName;
                FinderObjectDesc finderObjectDesc8 = finderObject.objectDesc;
                css.extraInfo = (finderObjectDesc8 == null || (axw9 = finderObjectDesc8.mvInfo) == null || (axy9 = axw9.Aqo) == null) ? null : axy9.extraInfo;
                FinderObjectDesc finderObjectDesc9 = finderObject.objectDesc;
                css.musicGenre = (finderObjectDesc9 == null || (axw8 = finderObjectDesc9.mvInfo) == null || (axy8 = axw8.Aqo) == null) ? null : axy8.LIi;
                FinderObjectDesc finderObjectDesc10 = finderObject.objectDesc;
                css.issueDate = (finderObjectDesc10 == null || (axw7 = finderObjectDesc10.mvInfo) == null || (axy7 = axw7.Aqo) == null) ? 0 : axy7.LIk;
                FinderObjectDesc finderObjectDesc11 = finderObject.objectDesc;
                css.identification = (finderObjectDesc11 == null || (axw6 = finderObjectDesc11.mvInfo) == null || (axy6 = axw6.Aqo) == null) ? null : axy6.lDR;
                FinderObjectDesc finderObjectDesc12 = finderObject.objectDesc;
                css.Alz = (finderObjectDesc12 == null || (axw5 = finderObjectDesc12.mvInfo) == null || (axy5 = axw5.Aqo) == null) ? 0 : axy5.duration;
                FinderObjectDesc finderObjectDesc13 = finderObject.objectDesc;
                css.BPc = (finderObjectDesc13 == null || (axw4 = finderObjectDesc13.mvInfo) == null || (axy4 = axw4.Aqo) == null) ? null : axy4.BPc;
                FinderObjectDesc finderObjectDesc14 = finderObject.objectDesc;
                css.songLyric = (finderObjectDesc14 == null || (axw3 = finderObjectDesc14.mvInfo) == null || (axy3 = axw3.Aqo) == null) ? null : axy3.LIh;
                FinderObjectDesc finderObjectDesc15 = finderObject.objectDesc;
                css.EsK = (finderObjectDesc15 == null || (axw2 = finderObjectDesc15.mvInfo) == null || (axy2 = axw2.Aqo) == null) ? null : axy2.Djf;
                css.jfz = str4;
                Log.i(msgViewCallback.TAG, "jump to musicMvMainUI");
                FinderObjectDesc finderObjectDesc16 = finderObject.objectDesc;
                if (!(finderObjectDesc16 == null || (axw = finderObjectDesc16.mvInfo) == null || (axy = axw.Aqo) == null)) {
                    ac acVar = ac.vER;
                    p.g(axy, "this");
                    ac.a(axy, d.zs(finderObject.id), css);
                }
                cst cst = new cst();
                com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
                cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                cst.MxI = 86;
                cst.MxJ = d.zs(finderObject.id);
                cst.scene = 5;
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                cst.Vkb = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(msgViewCallback.gte).get(FinderReporterUIC.class)).sGQ;
                intent.putExtra("key_mv_report_data", cst.toByteArray());
                String str8 = css.BPc;
                if (str8 == null) {
                    str8 = "";
                }
                intent.putExtra("key_mv_song_name", str8);
                String str9 = css.songLyric;
                if (str9 == null) {
                    str9 = "";
                }
                intent.putExtra("key_mv_song_lyric", str9);
                String str10 = css.singerName;
                if (str10 == null) {
                    str10 = "";
                }
                intent.putExtra("key_mv_singer_name", str10);
                String str11 = css.albumName;
                if (str11 == null) {
                    str11 = "";
                }
                intent.putExtra("key_mv_album_name", str11);
                String str12 = css.musicGenre;
                if (str12 == null) {
                    str12 = "";
                }
                intent.putExtra("key_mv_music_genre", str12);
                intent.putExtra("key_mv_issue_date", String.valueOf(css.issueDate));
                String str13 = css.EsK;
                if (str13 == null) {
                    str13 = "";
                }
                intent.putExtra("key_mv_album_cover_url", str13);
                String str14 = css.identification;
                if (str14 == null) {
                    str14 = "";
                }
                intent.putExtra("key_mv_identification", str14);
                String str15 = css.extraInfo;
                if (str15 == null) {
                    str15 = "";
                }
                intent.putExtra("key_mv_extra_info", str15);
                intent.putExtra("key_mv_music_duration", css.Alz);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.K(msgViewCallback.gte, intent);
                xVar = x.SXb;
            }
            if (xVar == null) {
                Log.i(msgViewCallback.TAG, "jump to musicMvMainUI error " + str4 + ' ' + str + ' ' + finderObject.id + ' ' + finderObject.objectNonceId);
                x xVar2 = x.SXb;
            }
            AppMethodBeat.o(249906);
        }

        public static final /* synthetic */ void a(MsgViewCallback msgViewCallback, int i2) {
            AppMethodBeat.i(249907);
            if (i2 == -8001) {
                h.n(msgViewCallback.gte, R.string.cmw, 0);
                AppMethodBeat.o(249907);
            } else if (i2 == -8002) {
                h.n(msgViewCallback.gte, R.string.cny, 0);
                AppMethodBeat.o(249907);
            } else {
                if (i2 == -8003) {
                    h.n(msgViewCallback.gte, R.string.d94, 0);
                }
                AppMethodBeat.o(249907);
            }
        }
    }
}
