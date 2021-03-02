package com.tencent.mm.plugin.recordvideo.model.audio;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.af.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001>\b&\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010I\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010J\u001a\u00020\u0017J\u0006\u0010K\u001a\u00020*J\u0006\u0010L\u001a\u00020\u0017J\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0007H&J\b\u0010P\u001a\u00020\u0017H&J\u0006\u0010Q\u001a\u00020\u0017J\b\u0010R\u001a\u00020\u0017H&J\u0006\u0010S\u001a\u00020\u0017R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u001a\u00108\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010=\u001a\u00020>X\u0004¢\u0006\u0004\n\u0002\u0010?R\u001a\u0010@\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\u001a\u0010C\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\u001a\u0010F\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010,\"\u0004\bH\u0010.¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "MSG_LOAD_DATA", "", "MSG_PROCESS_IMG_DATA", "TAG", "", "getTAG", "()Ljava/lang/String;", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "callback", "Lkotlin/Function1;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cancel", "imageData", "Lcom/tencent/mm/protobuf/ByteString;", "getImageData", "()Ljava/util/LinkedList;", "imageDataTime", "", "getImageDataTime", "()[I", "setImageDataTime", "([I)V", "isLoading", "setLoading", "lastRequestId", "", "getLastRequestId", "()J", "setLastRequestId", "(J)V", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "scene", "getScene", "()I", "setScene", "(I)V", "taskHandler", "com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1;", "thumbHeight", "getThumbHeight", "setThumbHeight", "thumbWidth", "getThumbWidth", "setThumbWidth", "videoDuration", "getVideoDuration", "setVideoDuration", "buildImageData", "finishImageData", "getMusicRequestId", "loadMore", "nextBitmap", "Landroid/graphics/Bitmap;", FirebaseAnalytics.b.INDEX, "onFinishImageData", "onLoadData", "onPrepareImageData", "processImageData", "plugin-recordvideo_release"})
public abstract class a {
    final int BOP;
    final int BOQ = 1;
    final LinkedList<com.tencent.mm.bw.b> BOR = new LinkedList<>();
    int[] BOS = new int[0];
    public long BOT;
    private final b BOU;
    final String TAG = "MicroMsg.AbsGetRecommendAudioTask";
    public kotlin.g.a.b<? super LinkedList<clp>, x> callback;
    public boolean cancel;
    float dTj;
    final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> gZm;
    boolean isLoading;
    float latitude;
    long pLQ;
    public boolean qdn;
    int scene;
    int thumbHeight = h.CTRL_INDEX;
    int thumbWidth = h.CTRL_INDEX;

    public abstract Bitmap VB(int i2);

    public abstract void eJR();

    public abstract void eJS();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.model.audio.a$a  reason: collision with other inner class name */
    static final class C1648a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ a BOV;

        C1648a(a aVar) {
            this.BOV = aVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(75396);
            c.a aVar = (c.a) obj;
            this.BOV.isLoading = false;
            int i2 = aVar.errType;
            int i3 = aVar.errCode;
            Log.i(this.BOV.TAG, "LogStory: getRecommendMusic callback " + i2 + ' ' + i3 + ", " + aVar.errMsg);
            if (i2 == 0 && i3 == 0) {
                clm clm = (clm) aVar.iLC;
                this.BOV.BOT = clm.BPd;
                LinkedList<clp> linkedList = clm.MqJ;
                Log.i(this.BOV.TAG, "get audio list ".concat(String.valueOf(clm)));
                kotlin.g.a.b<? super LinkedList<clp>, x> bVar = this.BOV.callback;
                if (bVar != null) {
                    p.g(linkedList, "audioList");
                    bVar.invoke(linkedList);
                }
                Void r0 = com.tencent.mm.vending.c.a.QZL;
                AppMethodBeat.o(75396);
                return r0;
            }
            kotlin.g.a.b<? super LinkedList<clp>, x> bVar2 = this.BOV.callback;
            if (bVar2 != null) {
                bVar2.invoke(new LinkedList());
            }
            Void r02 = com.tencent.mm.vending.c.a.QZL;
            AppMethodBeat.o(75396);
            return r02;
        }
    }

    public a(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> bVar) {
        p.h(bVar, "lifeCycleKeeper");
        this.gZm = bVar;
        com.tencent.mm.plugin.recordvideo.model.a aVar = com.tencent.mm.plugin.recordvideo.model.a.BOO;
        this.BOU = new b(this, com.tencent.mm.plugin.recordvideo.model.a.eJP().getLooper());
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_music_story_thumb_size, h.CTRL_INDEX);
        this.thumbWidth = a2;
        this.thumbHeight = a2;
        Log.i(this.TAG, "AbsGetRecommendAudioTask thumbWidth " + this.thumbWidth + " thumbHeight " + this.thumbHeight + " thumbTarget " + a2);
    }

    /* access modifiers changed from: protected */
    public final void I(int[] iArr) {
        p.h(iArr, "<set-?>");
        this.BOS = iArr;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/recordvideo/model/audio/AbsGetRecommendAudioTask$taskHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-recordvideo_release"})
    public static final class b extends Handler {
        final /* synthetic */ a BOV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, Looper looper) {
            super(looper);
            this.BOV = aVar;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(75397);
            Integer valueOf = message != null ? Integer.valueOf(message.what) : null;
            int i2 = this.BOV.BOP;
            if (valueOf != null && valueOf.intValue() == i2) {
                this.BOV.eJR();
                a aVar = this.BOV;
                boolean z = true;
                while (true) {
                    if (aVar.thumbHeight > 0 && aVar.thumbWidth > 0) {
                        Bitmap createBitmap = Bitmap.createBitmap(aVar.thumbWidth, aVar.thumbHeight, Bitmap.Config.ARGB_8888);
                        aVar.BOR.clear();
                        int i3 = 0;
                        int length = aVar.BOS.length;
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < length) {
                            int i6 = i3 + 1;
                            Bitmap VB = aVar.VB(i3);
                            Canvas canvas = new Canvas(createBitmap);
                            if (VB == null) {
                                p.hyc();
                            }
                            canvas.drawBitmap(VB, (Rect) null, new Rect(0, 0, aVar.thumbWidth, aVar.thumbHeight), (Paint) null);
                            com.tencent.mm.bw.b bVar = new com.tencent.mm.bw.b(BitmapUtil.Bitmap2Bytes(createBitmap, 50));
                            aVar.BOR.add(bVar);
                            i5 += bVar.zy.length;
                            i4++;
                            i3 = i6;
                        }
                        Log.i(aVar.TAG, "imageData size:" + i5 + " thumbWidth:" + aVar.thumbWidth + " thumbHeight:" + aVar.thumbHeight);
                        aVar.thumbWidth /= 2;
                        aVar.thumbHeight /= 2;
                        if (i5 <= 102400) {
                            break;
                        }
                    } else {
                        Log.i(aVar.TAG, "get image data fail!");
                        z = false;
                    }
                }
                Log.i(aVar.TAG, "get image data fail!");
                z = false;
                if (!z) {
                    int i7 = 0;
                    aVar.BOR.clear();
                    byte[] Bitmap2Bytes = BitmapUtil.Bitmap2Bytes(Bitmap.createBitmap(h.CTRL_INDEX, h.CTRL_INDEX, Bitmap.Config.ARGB_8888), 50);
                    int length2 = aVar.BOS.length;
                    for (int i8 = 0; i8 < length2; i8++) {
                        com.tencent.mm.bw.b bVar2 = new com.tencent.mm.bw.b(Bitmap2Bytes);
                        aVar.BOR.add(bVar2);
                        i7 += bVar2.zy.length;
                    }
                    Log.i(aVar.TAG, "backup imageData size:".concat(String.valueOf(i7)));
                }
                a aVar2 = this.BOV;
                aVar2.eJS();
                if (aVar2.qdn) {
                    aVar2.cJk();
                }
                AppMethodBeat.o(75397);
                return;
            }
            int i9 = this.BOV.BOQ;
            if (valueOf == null) {
                AppMethodBeat.o(75397);
                return;
            }
            if (valueOf.intValue() == i9) {
                a aVar3 = this.BOV;
                Log.i(aVar3.TAG, "onLoadData: " + aVar3.isLoading + ' ' + aVar3.cancel);
                if (aVar3.isLoading || aVar3.cancel) {
                    AppMethodBeat.o(75397);
                    return;
                } else {
                    aVar3.isLoading = true;
                    new e(aVar3.BOR, aVar3.latitude, aVar3.dTj, aVar3.BOT, aVar3.pLQ, aVar3.scene, (byte) 0).aYH().aYI().a(aVar3.gZm).b(new C1648a(aVar3));
                }
            }
            AppMethodBeat.o(75397);
        }
    }

    public final void cJk() {
        this.BOU.obtainMessage(this.BOQ).sendToTarget();
    }

    public final void eJQ() {
        this.BOU.obtainMessage(this.BOP).sendToTarget();
    }
}
