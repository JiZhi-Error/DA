package com.tencent.mm.media.widget.b.a.b;

import android.hardware.camera2.CaptureResult;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\fJ\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u0010\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u0014\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010'2\u0006\u0010\u001b\u001a\u00020\u0005R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006)"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCaptureResult;", "", "result", "Landroid/hardware/camera2/CaptureResult;", "mCameraId", "", "mWCEffectResultList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "Lkotlin/collections/ArrayList;", "(Landroid/hardware/camera2/CaptureResult;Ljava/lang/String;Ljava/util/ArrayList;)V", "mCameraIDRef", "", "getMCameraIDRef", "()I", "setMCameraIDRef", "(I)V", "getMWCEffectResultList", "()Ljava/util/ArrayList;", "setMWCEffectResultList", "(Ljava/util/ArrayList;)V", "getResult", "()Landroid/hardware/camera2/CaptureResult;", "setResult", "(Landroid/hardware/camera2/CaptureResult;)V", "checkEffectSupported", "", "key", "stream", "getBooleanRet", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getByteRet", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "getIntRet", "(Ljava/lang/String;)Ljava/lang/Integer;", "getRetType", "getStringRet", "refKey", "Landroid/hardware/camera2/CaptureResult$Key;", "Companion", "plugin-mediaeditor_release"})
public final class b {
    private static final String TAG = TAG;
    private static final String ipi = ipi;
    public static final a ipj = new a((byte) 0);
    public int ioP;
    public CaptureResult ipg;
    public ArrayList<a> iph;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCaptureResult$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "WCCAMERA_EFFECT_HDRDetected", "getWCCAMERA_EFFECT_HDRDetected", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(CaptureResult captureResult, String str, ArrayList<a> arrayList) {
        int aPU;
        p.h(captureResult, "result");
        p.h(str, "mCameraId");
        AppMethodBeat.i(94207);
        this.ipg = captureResult;
        this.iph = arrayList;
        if (p.j(str, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            com.tencent.mm.media.widget.b.a.b bVar = com.tencent.mm.media.widget.b.a.b.iop;
            aPU = com.tencent.mm.media.widget.b.a.b.aPT();
        } else {
            com.tencent.mm.media.widget.b.a.b bVar2 = com.tencent.mm.media.widget.b.a.b.iop;
            aPU = com.tencent.mm.media.widget.b.a.b.aPU();
        }
        this.ioP = aPU;
        AppMethodBeat.o(94207);
    }

    static {
        AppMethodBeat.i(94208);
        AppMethodBeat.o(94208);
    }

    public final CaptureResult.Key<?> Hv(String str) {
        T t;
        boolean z;
        Integer num;
        AppMethodBeat.i(94206);
        p.h(str, "key");
        ArrayList<a> arrayList = this.iph;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (!p.j(t2.ioJ, str) || ((num = t2.ioK) != null && (num.intValue() & this.ioP) == 0)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                String str2 = t3.ipf;
                if (str2 != null) {
                    switch (str2.hashCode()) {
                        case -1808118735:
                            if (str2.equals("String")) {
                                String str3 = t3.ioN;
                                if (str3 == null) {
                                    p.hyc();
                                }
                                CaptureResult.Key<?> e2 = c.e(str3, String.class);
                                AppMethodBeat.o(94206);
                                return e2;
                            }
                            break;
                        case -672261858:
                            if (str2.equals(DownloadSetting.TYPE_INTEGER)) {
                                String str4 = t3.ioN;
                                if (str4 == null) {
                                    p.hyc();
                                }
                                CaptureResult.Key<?> e3 = c.e(str4, Integer.TYPE);
                                AppMethodBeat.o(94206);
                                return e3;
                            }
                            break;
                        case 2086184:
                            if (str2.equals("Byte")) {
                                String str5 = t3.ioN;
                                if (str5 == null) {
                                    p.hyc();
                                }
                                CaptureResult.Key<?> e4 = c.e(str5, Byte.TYPE);
                                AppMethodBeat.o(94206);
                                return e4;
                            }
                            break;
                        case 1729365000:
                            if (str2.equals("Boolean")) {
                                String str6 = t3.ioN;
                                if (str6 == null) {
                                    p.hyc();
                                }
                                CaptureResult.Key<?> e5 = c.e(str6, Boolean.TYPE);
                                AppMethodBeat.o(94206);
                                return e5;
                            }
                            break;
                    }
                }
                AppMethodBeat.o(94206);
                return null;
            }
        }
        AppMethodBeat.o(94206);
        return null;
    }
}
