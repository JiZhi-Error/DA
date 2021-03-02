package com.tencent.mm.media.widget.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.media.widget.b.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0-H\u0002JV\u0010.\u001a\u00020+2N\u0010/\u001aJ\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020#0\u001bj\b\u0012\u0004\u0012\u00020#`\u001d\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020'0\u001bj\b\u0012\u0004\u0012\u00020'`\u001d\u0012\u0004\u0012\u00020+00R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020#0\u001bj\b\u0012\u0004\u0012\u00020#`\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R*\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'0\u001bj\b\u0012\u0004\u0012\u00020'`\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!¨\u00061"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/WCCameraEffectUtil;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMContext", "()Landroid/content/Context;", "setMContext", "mHasInitHarderCodeClient", "", "mRequestTagValues", "Lorg/json/JSONArray;", "getMRequestTagValues", "()Lorg/json/JSONArray;", "setMRequestTagValues", "(Lorg/json/JSONArray;)V", "mResultTagValues", "getMResultTagValues", "setMResultTagValues", "mSessionTypeValues", "getMSessionTypeValues", "setMSessionTypeValues", "mSupportWCKeyRequests", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportWCKeyRequests", "()Ljava/util/ArrayList;", "setMSupportWCKeyRequests", "(Ljava/util/ArrayList;)V", "mSupportWCKeyResults", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportWCKeyResults", "setMSupportWCKeyResults", "mSupportWCKeySessionType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportWCKeySessionType", "setMSupportWCKeySessionType", "getParameters", "", "tagValuesAvaliable", "Lkotlin/Function0;", "requestParameters", "mSupportWCKeyAvailable", "Lkotlin/Function3;", "plugin-mediaeditor_release"})
public final class c {
    final String TAG = "MicroMsg.WCCameraEffectUtil";
    volatile boolean ioq;
    JSONArray ior;
    JSONArray ios;
    JSONArray iot;
    ArrayList<com.tencent.mm.media.widget.b.a.a.a> iou = new ArrayList<>();
    ArrayList<com.tencent.mm.media.widget.b.a.b.a> iov = new ArrayList<>();
    ArrayList<a> iow = new ArrayList<>();
    private Context mContext;

    public c(Context context) {
        p.h(context, "mContext");
        AppMethodBeat.i(94191);
        this.mContext = context;
        AppMethodBeat.o(94191);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ c iox;
        final /* synthetic */ kotlin.g.a.a ioy;

        public a(c cVar, kotlin.g.a.a aVar) {
            this.iox = cVar;
            this.ioy = aVar;
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.i(94189);
            HardCoderJNI.stopPerformance(0);
            String readServerAddr = HardCoderJNI.readServerAddr();
            HardCoderJNI.setCheckEnv(readServerAddr != null && !p.j(readServerAddr, ""));
            int initHardCoder = HardCoderJNI.initHardCoder(readServerAddr, 0, HardCoderJNI.CLIENT_SOCK, b.ioA, null);
            Log.i(this.iox.TAG, "Read remote persist.sys.hardcoder.name:" + readServerAddr + " initHardCoder:" + initHardCoder);
            c cVar = this.iox;
            if (initHardCoder != 0) {
                z = false;
            }
            cVar.ioq = z;
            if (this.iox.ioq) {
                WXHardCoderJNI.getParameters(2, new C0428a(this), new String[0]);
            }
            AppMethodBeat.o(94189);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "name", "", "<anonymous parameter 2>", "", "newThread"})
        static final class b implements HardCoderJNI.HCPerfManagerThread {
            public static final b ioA = new b();

            static {
                AppMethodBeat.i(94188);
                AppMethodBeat.o(94188);
            }

            b() {
            }

            @Override // com.tencent.mm.hardcoder.HardCoderJNI.HCPerfManagerThread
            public final Thread newThread(Runnable runnable, String str, int i2) {
                AppMethodBeat.i(94187);
                Thread thread = new Thread(runnable, str);
                AppMethodBeat.o(94187);
                return thread;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "type", "", "jsonParameters", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onGetParameters"})
        /* renamed from: com.tencent.mm.media.widget.b.a.c$a$a  reason: collision with other inner class name */
        static final class C0428a implements WXHardCoderJNI.GetParametersCallback {
            final /* synthetic */ a ioz;

            C0428a(a aVar) {
                this.ioz = aVar;
            }

            @Override // com.tencent.mm.hardcoder.WXHardCoderJNI.GetParametersCallback
            public final void onGetParameters(int i2, JSONObject jSONObject) {
                AppMethodBeat.i(94186);
                if (i2 == 2) {
                    this.ioz.iox.ior = jSONObject.optJSONArray("CameraRequestTags");
                    this.ioz.iox.ios = jSONObject.optJSONArray("CameraResultTags");
                    this.ioz.iox.iot = jSONObject.optJSONArray("CaptureSessionType");
                    this.ioz.ioy.invoke();
                }
                AppMethodBeat.o(94186);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.q ioB;
        final /* synthetic */ c iox;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, kotlin.g.a.q qVar) {
            super(0);
            this.iox = cVar;
            this.ioB = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(94190);
            Log.i(this.iox.TAG, "available request: tag value : " + String.valueOf(this.iox.ior) + ' ');
            Log.i(this.iox.TAG, "available result: tag value : " + String.valueOf(this.iox.ios) + ' ');
            Log.i(this.iox.TAG, "available sessionType: tag value : " + String.valueOf(this.iox.iot) + ' ');
            JSONArray jSONArray = this.iox.ior;
            int length = jSONArray != null ? jSONArray.length() : 0;
            for (int i2 = 0; i2 < length; i2++) {
                com.tencent.mm.media.widget.b.a.a.a aVar = new com.tencent.mm.media.widget.b.a.a.a();
                JSONArray jSONArray2 = this.iox.ior;
                if (jSONArray2 == null) {
                    p.hyc();
                }
                aVar.s(jSONArray2.optJSONObject(i2));
                new StringBuilder("this tag is { \nparentKey: ").append(aVar.ioJ).append(" , \nchildKey: ").append(aVar.ioL).append(",\nvendorTag: ").append(aVar.ioN).append(", \ndefaultValue: ").append(aVar.aEX).append(", \nsupportValue: ").append(aVar.aPV()).append(", \nstream: ").append(aVar.ioO).append(" ,\ncamera_id: ").append(aVar.ioK);
                this.iox.iou.add(aVar);
            }
            JSONArray jSONArray3 = this.iox.ios;
            int length2 = jSONArray3 != null ? jSONArray3.length() : 0;
            for (int i3 = 0; i3 < length2; i3++) {
                com.tencent.mm.media.widget.b.a.b.a aVar2 = new com.tencent.mm.media.widget.b.a.b.a();
                JSONArray jSONArray4 = this.iox.ios;
                if (jSONArray4 == null) {
                    p.hyc();
                }
                aVar2.t(jSONArray4.optJSONObject(i3));
                new StringBuilder("this tag is { \nparentKey: ").append(aVar2.ioJ).append(" , \nvendorTag: ").append(aVar2.ioN).append(", \nstream: ").append(aVar2.ioO).append(" ,\ncamera_id: ").append(aVar2.ioK);
                this.iox.iov.add(aVar2);
            }
            JSONArray jSONArray5 = this.iox.iot;
            int length3 = jSONArray5 != null ? jSONArray5.length() : 0;
            for (int i4 = 0; i4 < length3; i4++) {
                a aVar3 = new a();
                JSONArray jSONArray6 = this.iox.iot;
                if (jSONArray6 == null) {
                    p.hyc();
                }
                aVar3.u(jSONArray6.optJSONObject(i4));
                this.iox.iow.add(aVar3);
            }
            this.ioB.d(this.iox.iou, this.iox.iov, this.iox.iow);
            x xVar = x.SXb;
            AppMethodBeat.o(94190);
            return xVar;
        }
    }
}
