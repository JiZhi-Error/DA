package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\"\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0007J\u001c\u0010$\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aJ\u0016\u0010&\u001a\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0002J\u0016\u0010'\u001a\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH\u0002J\u0016\u0010(\u001a\u00020\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u001aH\u0002J\u001c\u0010)\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyReadFeedRecorder;", "", "()V", "TAG", "", "lastRspExposeStartListForLive", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "lastRspExposeStartListForLiveMore", "lastRspExposeStartListForVideo", "lastRspListForLive", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastRspListForLiveMore", "lastRspListForVideo", "lastRspReadListForLive", "lastRspReadListForLiveMore", "lastRspReadListForVideo", "lastUnReadList", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "clear", "", "getExposeStartList", "", "commentScene", "", "getLastRspList", "", "getReadList", "getReadListByCommentScene", "getTabType", "getUnreadList", "tabTypeField", "isNearbyCommentScene", "", "onItemExposeStart", "item", "onItemExposed", "list", "printLastRspList", "printReadList", "printUnreadList", "recordLastRsp", "plugin-finder_release"})
public final class c {
    private static final String TAG = TAG;
    private static final LinkedList<bo> uTa = new LinkedList<>();
    private static final LinkedList<cmm> uTb = new LinkedList<>();
    private static final LinkedList<cmm> uTc = new LinkedList<>();
    private static final LinkedList<bo> uTd = new LinkedList<>();
    private static final LinkedList<cmm> uTe = new LinkedList<>();
    private static final LinkedList<cmm> uTf = new LinkedList<>();
    private static final LinkedList<bo> uTg = new LinkedList<>();
    private static final LinkedList<cmm> uTh = new LinkedList<>();
    private static final LinkedList<cmm> uTi = new LinkedList<>();
    private static final LinkedList<bdv> uTj = new LinkedList<>();
    public static final c uTk = new c();

    static {
        AppMethodBeat.i(249348);
        AppMethodBeat.o(249348);
    }

    private c() {
    }

    public static void a(int i2, cmm cmm) {
        AppMethodBeat.i(249337);
        p.h(cmm, "item");
        JJ(i2).add(cmm);
        AppMethodBeat.o(249337);
    }

    public static void i(int i2, List<? extends cmm> list) {
        AppMethodBeat.i(249338);
        p.h(list, "list");
        for (T t : JK(i2)) {
            for (T t2 : list) {
                if (t.lT() == t2.hFK) {
                    Iterator<cmm> it = JI(i2).iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        if (it.next().hFK == t.lT()) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 < 0) {
                        if (t instanceof BaseFinderFeed) {
                            t2.sessionBuffer = t.getSessionBuffer();
                        }
                        JI(i2).add(t2);
                    }
                }
            }
        }
        AppMethodBeat.o(249338);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void j(int i2, List<? extends bo> list) {
        AppMethodBeat.i(249339);
        p.h(list, "list");
        Log.d(TAG, "recordLastRsp commentScene:" + i2 + " size:" + list.size());
        switch (i2) {
            case 15:
                uTf.clear();
                uTe.clear();
                uTd.clear();
                uTd.addAll(list);
                AppMethodBeat.o(249339);
                return;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case 94:
                uTc.clear();
                uTb.clear();
                uTa.clear();
                uTa.addAll(list);
                AppMethodBeat.o(249339);
                return;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                uTi.clear();
                uTh.clear();
                uTg.clear();
                uTg.addAll(list);
                break;
        }
        AppMethodBeat.o(249339);
    }

    public static List<cmm> JF(int i2) {
        AppMethodBeat.i(249340);
        List<cmm> JI = JI(i2);
        for (T t : JJ(i2)) {
            for (T t2 : JK(i2)) {
                if (t.hFK == t2.lT()) {
                    Iterator<cmm> it = JI.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        if (it.next().hFK == t.hFK) {
                            break;
                        }
                        i3++;
                    }
                    if (i3 < 0) {
                        int i4 = t.MrJ;
                        long aWA = cl.aWA();
                        t.MrJ = (int) (aWA - ((long) i4));
                        if (t2 instanceof BaseFinderFeed) {
                            t.sessionBuffer = t2.getSessionBuffer();
                        }
                        Log.d(TAG, "expose id:" + t.hFK + " expose[" + i4 + ", " + aWA + "] exposeTime:" + t.MrJ + " seesion:" + t.sessionBuffer + ' ');
                        JI.add(t);
                    }
                }
            }
        }
        AppMethodBeat.o(249340);
        return JI;
    }

    public static List<bdv> gb(int i2, int i3) {
        AppMethodBeat.i(249341);
        uTj.clear();
        for (T t : JK(i2)) {
            if (t instanceof BaseFinderFeed) {
                T t2 = t;
                Iterator<cmm> it = JI(i2).iterator();
                int i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i4 = -1;
                        break;
                    }
                    if (it.next().hFK == t.lT()) {
                        break;
                    }
                    i4++;
                }
                if (i4 < 0) {
                    bdv bdv = new bdv();
                    bdv.hFK = t2.feedObject.getFeedObject().id;
                    bdv.objectNonceId = t2.feedObject.getFeedObject().objectNonceId;
                    bdv.dLS = i3;
                    bdv.sessionBuffer = t2.feedObject.getFeedObject().sessionBuffer;
                    bdv.hFK = t2.feedObject.getId();
                    bdv.objectNonceId = t2.feedObject.getObjectNonceId();
                    uTj.add(bdv);
                }
            }
        }
        List<bo> JK = JK(i2);
        Log.d(TAG, "printLastRspList size:" + JK.size());
        if (BuildInfo.DEBUG) {
            for (T t3 : JK) {
                Log.d(TAG, "printLastRspList: " + t3.lT() + ' ' + t3.cxn());
            }
        }
        em(JI(i2));
        en(uTj);
        LinkedList<bdv> linkedList = uTj;
        AppMethodBeat.o(249341);
        return linkedList;
    }

    public static boolean JG(int i2) {
        switch (i2) {
            case 15:
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
            case 94:
                return true;
            default:
                return false;
        }
    }

    public static int JH(int i2) {
        switch (i2) {
            case 15:
                return 1002;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case 94:
            default:
                return 1001;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                return 1004;
        }
    }

    public static void clear() {
        AppMethodBeat.i(249342);
        uTa.clear();
        uTb.clear();
        uTc.clear();
        uTd.clear();
        uTe.clear();
        uTf.clear();
        uTg.clear();
        uTh.clear();
        uTi.clear();
        uTj.clear();
        AppMethodBeat.o(249342);
    }

    private static List<cmm> JI(int i2) {
        AppMethodBeat.i(249343);
        switch (i2) {
            case 15:
                LinkedList<cmm> linkedList = uTf;
                AppMethodBeat.o(249343);
                return linkedList;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case 94:
                LinkedList<cmm> linkedList2 = uTc;
                AppMethodBeat.o(249343);
                return linkedList2;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                LinkedList<cmm> linkedList3 = uTi;
                AppMethodBeat.o(249343);
                return linkedList3;
            default:
                LinkedList linkedList4 = new LinkedList();
                AppMethodBeat.o(249343);
                return linkedList4;
        }
    }

    private static List<cmm> JJ(int i2) {
        AppMethodBeat.i(249344);
        switch (i2) {
            case 15:
                LinkedList<cmm> linkedList = uTe;
                AppMethodBeat.o(249344);
                return linkedList;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case 94:
                LinkedList<cmm> linkedList2 = uTb;
                AppMethodBeat.o(249344);
                return linkedList2;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                LinkedList<cmm> linkedList3 = uTh;
                AppMethodBeat.o(249344);
                return linkedList3;
            default:
                LinkedList linkedList4 = new LinkedList();
                AppMethodBeat.o(249344);
                return linkedList4;
        }
    }

    private static List<bo> JK(int i2) {
        AppMethodBeat.i(249345);
        switch (i2) {
            case 15:
                LinkedList<bo> linkedList = uTd;
                AppMethodBeat.o(249345);
                return linkedList;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
            case 94:
                LinkedList<bo> linkedList2 = uTa;
                AppMethodBeat.o(249345);
                return linkedList2;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                LinkedList<bo> linkedList3 = uTg;
                AppMethodBeat.o(249345);
                return linkedList3;
            default:
                LinkedList linkedList4 = new LinkedList();
                AppMethodBeat.o(249345);
                return linkedList4;
        }
    }

    private static void em(List<? extends cmm> list) {
        AppMethodBeat.i(249346);
        Log.d(TAG, "printReadList size:" + list.size());
        if (BuildInfo.DEBUG) {
            for (T t : list) {
                Log.d(TAG, "printReadList: " + t.MrI + ' ' + t.hFK + ' ' + t.MrJ + ' ');
            }
        }
        AppMethodBeat.o(249346);
    }

    private static void en(List<? extends bdv> list) {
        AppMethodBeat.i(249347);
        Log.d(TAG, "printUnreadList size:" + list.size());
        if (BuildInfo.DEBUG) {
            for (T t : list) {
                Log.d(TAG, "printUnreadList: " + t.hFK + ' ' + t.dLS);
            }
        }
        AppMethodBeat.o(249347);
    }
}
