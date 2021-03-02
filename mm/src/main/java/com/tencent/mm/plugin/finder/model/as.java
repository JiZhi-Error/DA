package com.tencent.mm.plugin.finder.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cq;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010%\u001a\u00020&2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(2\u0006\u0010*\u001a\u00020+J\u0014\u0010,\u001a\u00020&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020 J \u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u00042\b\b\u0002\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020&2\u0006\u00103\u001a\u00020\u0017H\u0002J\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u00108\u001a\u00020\u0004J\b\u00109\u001a\u00020&H\u0002J\u0006\u0010:\u001a\u00020&J,\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u00122\b\u00100\u001a\u0004\u0018\u00010?H\u0016J\u001c\u0010@\u001a\u00020&2\u0006\u00108\u001a\u00020\u00042\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0(J\u0006\u0010C\u001a\u00020&J\b\u0010D\u001a\u00020&H\u0002J\u0006\u0010E\u001a\u00020&J\b\u0010F\u001a\u00020&H\u0002J\b\u0010G\u001a\u00020&H\u0002J\u0006\u0010H\u001a\u00020&J\u0006\u0010I\u001a\u00020&R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0012XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000Rb\u0010\u001e\u001aV\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!`\"0\u001fj*\u0012\u0004\u0012\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fj\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!`\"`\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderMarkReadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ADD", "", "getADD", "()I", "READ", "getREAD", "REMOVE", "getREMOVE", "SAVE", "getSAVE", "SEND", "getSEND", "STOP", "getSTOP", "TAG", "", "getTAG", "()Ljava/lang/String;", "markReadItemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "getMarkReadItemList", "()Ljava/util/LinkedList;", "setMarkReadItemList", "(Ljava/util/LinkedList;)V", "startCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamMarkReadFeedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/model/StreamMarkReadStat;", "Lkotlin/collections/HashMap;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "addCrossFeedList", "", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "addMarReadItemList", "itemList", "containItems", "", "scene", "objectId", "fillMarkReadScene", "markReadStat", "commentScene", "fromCommentScene", "filterTabMarkReadItem", "getStreamMarkReadList", "tabType", "nextSend", "onFinish", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStreamCgiBack", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "read", "readFromFile", "save", "saveToFile", "send", "startTimer", "stopTimer", "plugin-finder_release"})
public final class as implements i {
    private static final int ADD = 0;
    private static final int STOP = 5;
    private static final String TAG = TAG;
    private static LinkedList<cmm> uOD = new LinkedList<>();
    private static final int uOE = 1;
    private static final int uOF = 2;
    private static final int uOG = 3;
    private static final int uOH = 4;
    private static final MMHandler uOI = new MMHandler(TAG, a.uOM);
    private static AtomicInteger uOJ = new AtomicInteger(0);
    private static HashMap<Integer, HashMap<Long, bq>> uOK = new HashMap<>();
    public static final as uOL;

    static {
        AppMethodBeat.i(178325);
        as asVar = new as();
        uOL = asVar;
        g.azz().a(3520, asVar);
        AppMethodBeat.o(178325);
    }

    private as() {
    }

    public static final /* synthetic */ void dkL() {
        AppMethodBeat.i(178328);
        dkJ();
        AppMethodBeat.o(178328);
    }

    public static String getTAG() {
        return TAG;
    }

    public static LinkedList<cmm> dkC() {
        return uOD;
    }

    public static int dkD() {
        return ADD;
    }

    public static int dkE() {
        return uOE;
    }

    public static int dkF() {
        return uOF;
    }

    public static int dkG() {
        return uOG;
    }

    public static int dkH() {
        return uOH;
    }

    public static int dkI() {
        return STOP;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class a implements MMHandler.Callback {
        public static final a uOM = new a();

        static {
            AppMethodBeat.i(178317);
            AppMethodBeat.o(178317);
        }

        a() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(178316);
            int i2 = message.what;
            as asVar = as.uOL;
            if (i2 != as.dkD()) {
                int i3 = message.what;
                as asVar2 = as.uOL;
                if (i3 == as.dkE()) {
                    as asVar3 = as.uOL;
                    if (as.dkC().size() > 0) {
                        as.a(as.uOL);
                        as asVar4 = as.uOL;
                        as.dkL();
                    }
                } else {
                    int i4 = message.what;
                    as asVar5 = as.uOL;
                    if (i4 != as.dkF()) {
                        int i5 = message.what;
                        as asVar6 = as.uOL;
                        if (i5 == as.dkG()) {
                            as asVar7 = as.uOL;
                            as.dkM();
                        } else {
                            int i6 = message.what;
                            as asVar8 = as.uOL;
                            if (i6 == as.dkH()) {
                                as asVar9 = as.uOL;
                                as.dkK();
                            } else {
                                int i7 = message.what;
                                as asVar10 = as.uOL;
                                if (i7 == as.dkI()) {
                                    as.a(as.uOL);
                                    as asVar11 = as.uOL;
                                    as.uOK = new HashMap();
                                }
                            }
                        }
                    } else if (message.obj instanceof LinkedList) {
                        as asVar12 = as.uOL;
                        LinkedList<cmm> dkC = as.dkC();
                        Object obj = message.obj;
                        if (obj == null) {
                            t tVar = new t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                            AppMethodBeat.o(178316);
                            throw tVar;
                        }
                        dkC.removeAll((LinkedList) obj);
                        as asVar13 = as.uOL;
                        as.dkK();
                    }
                }
            } else if (message.obj instanceof LinkedList) {
                Object obj2 = message.obj;
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type java.util.LinkedList<com.tencent.mm.protocal.protobuf.MarkReadStat>");
                    AppMethodBeat.o(178316);
                    throw tVar2;
                }
                int i8 = 0;
                for (cmm cmm : (LinkedList) obj2) {
                    as asVar14 = as.uOL;
                    if (!as.ag(cmm.scene, cmm.hFK)) {
                        i8++;
                        as asVar15 = as.uOL;
                        as.dkC().add(cmm);
                        as asVar16 = as.uOL;
                        as.a(cmm);
                        e.a aVar = e.vFX;
                        FinderItem Fy = e.a.Fy(cmm.hFK);
                        if (Fy != null) {
                            as asVar17 = as.uOL;
                            String tag = as.getTAG();
                            StringBuilder append = new StringBuilder("mark read scene:").append(cmm.scene).append(" subScene:").append(cmm.pHw).append(" commScene:").append(cmm.MrI).append(' ').append(d.zs(cmm.hFK)).append(" nickname:").append(Fy.getNickName()).append(" desc:");
                            y yVar = y.vXH;
                            Log.d(tag, append.append(y.awq(Fy.getDescription())).append(" expose:").append(cmm.MrJ).toString());
                        } else {
                            as asVar18 = as.uOL;
                            Log.d(as.getTAG(), "mark read " + d.zs(cmm.hFK));
                        }
                    } else {
                        e.a aVar2 = e.vFX;
                        FinderItem Fy2 = e.a.Fy(cmm.hFK);
                        if (Fy2 != null) {
                            as asVar19 = as.uOL;
                            String tag2 = as.getTAG();
                            StringBuilder append2 = new StringBuilder("contains read scene:").append(cmm.scene).append(" subScene:").append(cmm.pHw).append(" commScene:").append(cmm.MrI).append(' ').append(d.zs(cmm.hFK)).append(" nickname:").append(Fy2.getNickName()).append(" desc:");
                            y yVar2 = y.vXH;
                            Log.d(tag2, append2.append(y.awq(Fy2.getDescription())).append(" expose:").append(cmm.MrJ).toString());
                        } else {
                            as asVar20 = as.uOL;
                            Log.d(as.getTAG(), "contains read " + d.zs(cmm.hFK));
                        }
                    }
                }
                as asVar21 = as.uOL;
                int size = as.dkC().size();
                if (size > 1000 && 1000 <= size) {
                    int i9 = 1000;
                    while (true) {
                        as asVar22 = as.uOL;
                        as.dkC().removeFirst();
                        if (i9 == size) {
                            break;
                        }
                        i9++;
                    }
                }
                as asVar23 = as.uOL;
                String tag3 = as.getTAG();
                StringBuilder append3 = new StringBuilder("final add ").append(i8).append(' ').append(size).append(' ');
                as asVar24 = as.uOL;
                Log.i(tag3, append3.append(as.dkC().size()).toString());
                as asVar25 = as.uOL;
                as.dkK();
            }
            AppMethodBeat.o(178316);
            return false;
        }
    }

    private static void dkJ() {
        AppMethodBeat.i(178318);
        uOI.removeMessages(uOE);
        uOI.sendEmptyMessageDelayed(uOE, ((long) h.aqJ().getInt("FinderMarkReadReportIntervalSecond", 60)) * 1000);
        AppMethodBeat.o(178318);
    }

    public static void sy() {
        AppMethodBeat.i(178319);
        uOI.sendEmptyMessage(uOG);
        AppMethodBeat.o(178319);
    }

    public static void ar(LinkedList<cmm> linkedList) {
        AppMethodBeat.i(178320);
        p.h(linkedList, "itemList");
        Log.i(TAG, "addMarkReadItemList " + linkedList.size());
        Message obtainMessage = uOI.obtainMessage(ADD);
        obtainMessage.obj = linkedList;
        obtainMessage.sendToTarget();
        AppMethodBeat.o(178320);
    }

    public static void startTimer() {
        AppMethodBeat.i(248799);
        Log.i(TAG, "start success ".concat(String.valueOf(uOJ.incrementAndGet())));
        dkJ();
        AppMethodBeat.o(248799);
    }

    public static void stopTimer() {
        AppMethodBeat.i(178322);
        int decrementAndGet = uOJ.decrementAndGet();
        if (decrementAndGet == 0) {
            Log.i(TAG, "really stop");
            uOI.removeMessages(uOE);
            uOI.sendEmptyMessage(STOP);
            AppMethodBeat.o(178322);
            return;
        }
        Log.i(TAG, "not really stop ".concat(String.valueOf(decrementAndGet)));
        AppMethodBeat.o(178322);
    }

    public static boolean ag(int i2, long j2) {
        AppMethodBeat.i(178323);
        for (T t : uOD) {
            if (t.scene == i2 && t.hFK == j2) {
                AppMethodBeat.o(178323);
                return true;
            }
        }
        AppMethodBeat.o(178323);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(178324);
        Log.i(TAG, "onSceneEnd errType:" + i2 + " errCode:" + i3);
        if (qVar != null) {
            if ((qVar instanceof cq) && i2 == 0 && i3 == 0) {
                Message obtainMessage = uOI.obtainMessage(uOF);
                obtainMessage.obj = ((cq) qVar).twF;
                obtainMessage.sendToTarget();
            }
            AppMethodBeat.o(178324);
            return;
        }
        AppMethodBeat.o(178324);
    }

    public static void h(int i2, List<? extends FinderObject> list) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(248800);
        p.h(list, "feedList");
        switch (i2) {
            case 1:
                i3 = 18;
                break;
            case 2:
            default:
                AppMethodBeat.o(248800);
                return;
            case 3:
                i3 = 17;
                break;
            case 4:
                i3 = 20;
                break;
        }
        HashMap<Long, bq> hashMap = uOK.get(Integer.valueOf(i3));
        int size = hashMap != null ? hashMap.size() : 0;
        for (T t : list) {
            HashMap<Long, bq> hashMap2 = uOK.get(Integer.valueOf(i3));
            if (hashMap2 != null) {
                bq bqVar = hashMap2.get(Long.valueOf(t.id));
                if (bqVar != null) {
                    Log.i(TAG, "already in mark read map isRead:" + bqVar.uPa);
                } else {
                    p.g(hashMap2, "markReadMap");
                    hashMap2.put(Long.valueOf(t.id), new bq(t.id));
                }
            } else {
                Integer valueOf = Integer.valueOf(i3);
                HashMap<Long, bq> hashMap3 = new HashMap<>();
                hashMap3.put(Long.valueOf(t.id), new bq(t.id));
                uOK.put(valueOf, hashMap3);
            }
        }
        HashMap<Long, bq> hashMap4 = uOK.get(Integer.valueOf(i3));
        if (hashMap4 != null && hashMap4.size() > 50) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(hashMap4.values());
            j.sort(linkedList);
            HashMap<Integer, HashMap<Long, bq>> hashMap5 = uOK;
            Integer valueOf2 = Integer.valueOf(i3);
            HashMap<Long, bq> hashMap6 = new HashMap<>();
            List<bq> subList = linkedList.subList(0, 50);
            p.g(subList, "list.subList(0, 50)");
            for (bq bqVar2 : subList) {
                hashMap6.put(Long.valueOf(bqVar2.feedId), bqVar2);
            }
            hashMap5.put(valueOf2, hashMap6);
        }
        HashMap<Long, bq> hashMap7 = uOK.get(Integer.valueOf(i3));
        if (hashMap7 != null) {
            i4 = hashMap7.size();
        }
        Log.i(TAG, "onStreamCgiBack beforeSize:" + size + " afterSize:" + i4);
        AppMethodBeat.o(248800);
    }

    public static LinkedList<cmm> Jt(int i2) {
        int i3;
        cmm cmm;
        int i4 = 0;
        AppMethodBeat.i(248801);
        LinkedList<cmm> linkedList = new LinkedList<>();
        switch (i2) {
            case 1:
                i3 = 18;
                break;
            case 2:
            default:
                i3 = 0;
                break;
            case 3:
                i3 = 17;
                break;
            case 4:
                i3 = 20;
                break;
        }
        HashMap<Long, bq> hashMap = uOK.get(Integer.valueOf(i3));
        if (hashMap != null) {
            LinkedList linkedList2 = new LinkedList();
            p.g(hashMap, "markReadMap");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, bq> entry : hashMap.entrySet()) {
                if (entry.getValue().uPa) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                linkedList2.add(entry2.getValue());
            }
            j.sort(linkedList2);
            for (Object obj : linkedList2) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    j.hxH();
                }
                bq bqVar = (bq) obj;
                if (i4 >= 20 || bqVar == null || (cmm = bqVar.uPb) == null) {
                    i4 = i5;
                } else {
                    linkedList.add(cmm);
                    i4 = i5;
                }
            }
        }
        String str = TAG;
        StringBuilder append = new StringBuilder("getStreamMarkReadList ").append(i2).append(' ');
        LinkedList<cmm> linkedList3 = linkedList;
        ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
        Iterator<T> it = linkedList3.iterator();
        while (it.hasNext()) {
            arrayList.add(d.zs(it.next().hFK));
        }
        Log.i(str, append.append(arrayList).toString());
        AppMethodBeat.o(248801);
        return linkedList;
    }

    public static /* synthetic */ void a(cmm cmm, int i2) {
        AppMethodBeat.i(248803);
        a(cmm, i2, -1);
        AppMethodBeat.o(248803);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0072, code lost:
        if (r8 == 34) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.tencent.mm.protocal.protobuf.cmm r6, int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.model.as.a(com.tencent.mm.protocal.protobuf.cmm, int, int):void");
    }

    public static void a(List<? extends bo> list, bbn bbn) {
        AppMethodBeat.i(248804);
        p.h(bbn, "contextObj");
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (T t : list) {
                if (t.lT() != 0) {
                    if (!(t instanceof BaseFinderFeed)) {
                        y yVar = y.vXH;
                        if (!y.dCz().contains(Integer.valueOf(t.cxn()))) {
                        }
                    }
                    cmm cmm = new cmm();
                    cmm.hFK = t.lT();
                    a(cmm, bbn.tCE, bbn.tyh);
                    k kVar = k.vfA;
                    cmm.sessionBuffer = k.G(t.lT(), bbn.tCE);
                    linkedList.add(cmm);
                }
            }
        }
        ar(linkedList);
        if (bbn.tCE == 17 || bbn.tCE == 18) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderTabStreamUnreadVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class)).o(bbn.tCE, list);
            AppMethodBeat.o(248804);
            return;
        }
        if (bbn.tCE == 51) {
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ((FinderStreamCardVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class)).eH(linkedList);
        }
        AppMethodBeat.o(248804);
    }

    public static final /* synthetic */ void a(cmm cmm) {
        AppMethodBeat.i(248805);
        HashMap<Long, bq> hashMap = uOK.get(Integer.valueOf(cmm.MrI));
        if (hashMap != null) {
            bq bqVar = hashMap.get(Long.valueOf(cmm.hFK));
            if (bqVar != null) {
                bqVar.uPa = true;
                bqVar.uPb = cmm;
                AppMethodBeat.o(248805);
                return;
            }
            AppMethodBeat.o(248805);
            return;
        }
        AppMethodBeat.o(248805);
    }

    public static final /* synthetic */ void dkK() {
        AppMethodBeat.i(178326);
        aye aye = new aye();
        aye.LIs = uOD;
        byte[] byteArray = aye.toByteArray();
        StringBuilder sb = new StringBuilder();
        al alVar = al.waC;
        String sb2 = sb.append(al.dEF()).append("markread.info").toString();
        if (s.YS(sb2)) {
            s.deleteDir(sb2);
        }
        al alVar2 = al.waC;
        if (!s.YS(al.dEF())) {
            al alVar3 = al.waC;
            s.boN(al.dEF());
        }
        s.C(sb2, byteArray);
        Log.i(TAG, "saveToFile ".concat(String.valueOf(sb2)));
        AppMethodBeat.o(178326);
    }

    public static final /* synthetic */ void a(as asVar) {
        AppMethodBeat.i(178327);
        for (int i2 = 0; i2 < uOD.size(); i2 += 50) {
            LinkedList linkedList = new LinkedList();
            if (uOD.size() > i2 + 50) {
                linkedList.addAll(uOD.subList(i2, i2 + 50));
            } else {
                LinkedList<cmm> linkedList2 = uOD;
                linkedList.addAll(linkedList2.subList(i2, linkedList2.size()));
            }
            String str = TAG;
            StringBuilder append = new StringBuilder("start to send new cgi ").append(linkedList.size()).append(' ');
            LinkedList<cmm> linkedList3 = uOD;
            ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
            Iterator<T> it = linkedList3.iterator();
            while (it.hasNext()) {
                arrayList.add(d.zs(it.next().hFK));
            }
            Log.i(str, append.append(arrayList).toString());
            cq cqVar = new cq(linkedList);
            g.azz().a(3520, asVar);
            g.azz().b(cqVar);
        }
        AppMethodBeat.o(178327);
    }

    public static final /* synthetic */ void dkM() {
        AppMethodBeat.i(178329);
        StringBuilder sb = new StringBuilder();
        al alVar = al.waC;
        String sb2 = sb.append(al.dEF()).append("markread.info").toString();
        if (s.YS(sb2)) {
            byte[] aW = s.aW(sb2, 0, -1);
            aye aye = new aye();
            try {
                aye.parseFrom(aW);
                LinkedList<cmm> linkedList = aye.LIs;
                p.g(linkedList, "saveObj.readStats");
                uOD = linkedList;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "read", new Object[0]);
            }
            Log.i(TAG, "readFromFile ".concat(String.valueOf(sb2)));
        }
        AppMethodBeat.o(178329);
    }
}
