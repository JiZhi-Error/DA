package com.tencent.mm.plugin.expt.hellhound.a.a;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002J \u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020(H\u0002J \u0010)\u001a\u00020(2\u0006\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020 H\u0002J\"\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J\"\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0002J*\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020 H\u0002J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020 H\u0002J\b\u00101\u001a\u00020%H\u0002J\b\u00102\u001a\u00020%H\u0002J\"\u00103\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u00104\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0016J\u001a\u00105\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u00106\u001a\u00020\u000fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/HellSpeedChecker;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "pageName", "", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;Ljava/lang/String;)V", "BaseViewHolder_Class", "Ljava/lang/Class;", "Id_Field", "Ljava/lang/reflect/Field;", "MAX_SCROLL_SPEED", "", "TAG", "VALIDATE_DISTANCE", "", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "getTimeLineMethod", "Ljava/lang/reflect/Method;", "idField", "mFeedLastScrollY", "mFirstVisibleItem", "mLastFeedId", "mLastTimestamp", "mScrollState", "mSpeedOfScroll", "mVisibleItemCount", "getPageName", "()Ljava/lang/String;", "timeLineObject_Field", "_getBottomFeedView", "Landroid/view/View;", "listView", "Landroid/widget/AbsListView;", "visibleItemCount", "_monitorOneScreen", "", "firstPos", "_speedOk", "", "computeDistance", "getFeedId1", "view", "getFeedId2", "getFeedIdChat", "getFeedIdSns", "bottomView", "getY", "initChat", "initSns", "sendOnScroll", "firstVisibleItem", "sendOnScrollStateChanged", "scrollState", "plugin-expt_release"})
public final class d implements f {
    private final String TAG;
    private final String dMl;
    private int mScrollState;
    private int mVisibleItemCount;
    private long sBA;
    private String sBB;
    private final long sBO;
    private Class<?> sBP;
    private Field sBQ;
    private Field sBR;
    private Method sBS;
    private Field sBT;
    private final e sBU;
    private int sBg;
    private int sBv;
    private int sBy;
    private long sBz;

    public d(e eVar, String str) {
        AppMethodBeat.i(220796);
        this.sBU = eVar;
        this.dMl = str;
        this.TAG = "HABBYGE-MALI.HellSpeedChecker";
        this.sBO = 1000;
        this.sBy = -1;
        this.sBA = -1;
        this.sBB = "";
        this.sBv = -1;
        this.sBv = -1;
        this.mVisibleItemCount = 0;
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(MMApplicationContext.getContext());
            p.g(viewConfiguration, "ViewConfiguration.get(MM…tionContext.getContext())");
            this.sBg = viewConfiguration.getScaledTouchSlop();
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "init crash: %s", e2.getMessage());
        }
        String str2 = this.dMl;
        if (str2 == null) {
            AppMethodBeat.o(220796);
            return;
        }
        switch (str2.hashCode()) {
            case -824503318:
                if (str2.equals("ChattingUIFragment")) {
                    AppMethodBeat.o(220796);
                    return;
                }
                break;
            case 1437804045:
                if (str2.equals("SnsTimelineUI")) {
                    try {
                        this.sBP = Class.forName("com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder");
                        Class<?> cls = this.sBP;
                        this.sBQ = cls != null ? cls.getDeclaredField("timeLineObject") : null;
                        Field field = this.sBQ;
                        if (field != null) {
                            field.setAccessible(true);
                        }
                        Class<?> cls2 = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject");
                        p.g(cls2, "Class.forName(\"com.tence…protobuf.TimeLineObject\")");
                        this.sBR = cls2.getDeclaredField("Id");
                        Field field2 = this.sBR;
                        if (field2 != null) {
                            field2.setAccessible(true);
                        }
                    } catch (Exception e3) {
                        Log.printErrStackTrace(this.TAG, e3, "initSns crash-1: %s", e3.getMessage());
                    }
                    try {
                        Class<?> cls3 = Class.forName("com.tencent.mm.plugin.sns.storage.SnsInfo");
                        p.g(cls3, "Class.forName(\"com.tence…gin.sns.storage.SnsInfo\")");
                        this.sBS = cls3.getDeclaredMethod("getTimeLine", new Class[0]);
                        Method method = this.sBS;
                        if (method != null) {
                            method.setAccessible(true);
                        }
                        Class<?> cls4 = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject");
                        p.g(cls4, "Class.forName(\"com.tence…protobuf.TimeLineObject\")");
                        this.sBT = cls4.getDeclaredField("Id");
                        Field field3 = this.sBT;
                        if (field3 != null) {
                            field3.setAccessible(true);
                            AppMethodBeat.o(220796);
                            return;
                        }
                        AppMethodBeat.o(220796);
                        return;
                    } catch (Exception e4) {
                        Log.printErrStackTrace(this.TAG, e4, "initSns crash-2: %s", e4.getMessage());
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(220796);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.b.f
    public final void a(AbsListView absListView, int i2) {
        AppMethodBeat.i(220792);
        if (absListView == null) {
            AppMethodBeat.o(220792);
            return;
        }
        this.mScrollState = i2;
        switch (i2) {
            case 0:
                e eVar = this.sBU;
                if (eVar != null) {
                    eVar.b(absListView, this.sBv, this.mVisibleItemCount);
                    AppMethodBeat.o(220792);
                    return;
                }
                break;
        }
        AppMethodBeat.o(220792);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        if (r0 != null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0073, code lost:
        if ((!kotlin.g.b.p.j(r0, r10.sBB)) == false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
        r10.sBy = getY(r0);
        r10.sBA = java.lang.System.currentTimeMillis();
        r10.sBB = r0;
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009d, code lost:
        if (r0 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x010d, code lost:
        r0 = getY(r0);
        r1 = java.lang.Math.abs(r0 - r10.sBy);
        r2 = java.lang.System.currentTimeMillis();
        r4 = r2 - r10.sBA;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0125, code lost:
        if (r4 <= 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0129, code lost:
        if (r1 <= r10.sBg) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x012b, code lost:
        r10.sBz = (((long) r1) * 1000) / r4;
        r10.sBy = r0;
        r10.sBA = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013d, code lost:
        if (r10.sBz > r10.sBO) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0140, code lost:
        if (r0 != false) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0144, code lost:
        if (r10.mScrollState != 0) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0146, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0149, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x014b, code lost:
        r0 = false;
     */
    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.b.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.AbsListView r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.a.d.a(android.widget.AbsListView, int, int):void");
    }

    private final String dO(View view) {
        Object obj;
        String str;
        Object obj2;
        AppMethodBeat.i(220794);
        if (this.sBP == null) {
            AppMethodBeat.o(220794);
            return null;
        } else if (view.getTag() == null) {
            AppMethodBeat.o(220794);
            return null;
        } else {
            try {
                Class<?> cls = this.sBP;
                if (cls == null) {
                    p.hyc();
                }
                if (!cls.isInstance(view.getTag())) {
                    AppMethodBeat.o(220794);
                    return null;
                }
                Field field = this.sBQ;
                if (field == null || (obj = field.get(view.getTag())) == null) {
                    AppMethodBeat.o(220794);
                    return null;
                }
                try {
                    Field field2 = this.sBR;
                    if (field2 == null || (obj2 = field2.get(obj)) == null) {
                        AppMethodBeat.o(220794);
                        return null;
                    }
                    if (!(obj2 instanceof String)) {
                        obj2 = null;
                    }
                    str = (String) obj2;
                    AppMethodBeat.o(220794);
                    return str;
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.TAG, e2, "getFeedId1: %s", e2.getMessage());
                    str = null;
                }
            } catch (Exception e3) {
                AppMethodBeat.o(220794);
                return null;
            }
        }
    }

    private static int getY(View view) {
        AppMethodBeat.i(220795);
        int[] iArr = new int[2];
        for (int i2 = 0; i2 < 2; i2++) {
            iArr[i2] = -1;
        }
        view.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        AppMethodBeat.o(220795);
        return i3;
    }
}
