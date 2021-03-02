package com.tencent.mm.sticker.loader;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerProcessTask;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "call", "", "onResult", "success", "", "uniqueId", "IPCStickerTask", "plugin-sticker_release"})
public final class f extends g {
    final String TAG = "MicroMsg.StickerProcessTask";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class b<T> implements d<ResultType> {
        final /* synthetic */ f NNS;

        b(f fVar) {
            this.NNS = fVar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(194230);
            Log.i(this.NNS.TAG, "result: ");
            this.NNS.dQ(((Bundle) obj).getBoolean("task_result"));
            AppMethodBeat.o(194230);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(StickerLoadInfo stickerLoadInfo) {
        super(stickerLoadInfo);
        p.h(stickerLoadInfo, "info");
        AppMethodBeat.i(105949);
        AppMethodBeat.o(105949);
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        AppMethodBeat.i(105946);
        Bundle bundle = new Bundle();
        bundle.putParcelable("load_info", this.NNU);
        h.a(MMApplicationContext.getPackageName(), bundle, a.class, new b(this));
        AppMethodBeat.o(105946);
    }

    @Override // com.tencent.mm.sticker.loader.g
    public final void dQ(boolean z) {
        AppMethodBeat.i(105947);
        Log.i(this.TAG, "onResult: " + this.NNU.Lb() + ' ' + z);
        super.dQ(z);
        AppMethodBeat.o(105947);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerProcessTask$IPCStickerTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Companion", "plugin-sticker_release"})
    public static final class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        public static final C2066a NNQ = new C2066a((byte) 0);
        private static final String TAG = TAG;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
        static final class b extends q implements kotlin.g.a.b<Boolean, x> {
            final /* synthetic */ Bundle NNR;
            final /* synthetic */ d kFf;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Bundle bundle, d dVar) {
                super(1);
                this.NNR = bundle;
                this.kFf = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(194227);
                this.NNR.putBoolean("task_result", bool.booleanValue());
                d dVar = this.kFf;
                if (dVar != null) {
                    dVar.bn(this.NNR);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(194227);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerProcessTask$IPCStickerTask$Companion;", "", "()V", "KEY_STICKER_LOAD_INFO", "", "KEY_TASK_RESULT", "TAG", "plugin-sticker_release"})
        /* renamed from: com.tencent.mm.sticker.loader.f$a$a  reason: collision with other inner class name */
        public static final class C2066a {
            private C2066a() {
            }

            public /* synthetic */ C2066a(byte b2) {
                this();
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(194228);
            Bundle bundle2 = bundle;
            p.h(bundle2, "data");
            Log.i(TAG, "invoke: ");
            StickerLoadInfo stickerLoadInfo = (StickerLoadInfo) bundle2.getParcelable("load_info");
            Bundle bundle3 = new Bundle();
            if (stickerLoadInfo != null) {
                e eVar = e.NNN;
                e.a(stickerLoadInfo, new b(bundle3, dVar));
                AppMethodBeat.o(194228);
                return;
            }
            bundle3.putBoolean("task_result", false);
            if (dVar != null) {
                dVar.bn(bundle3);
                AppMethodBeat.o(194228);
                return;
            }
            AppMethodBeat.o(194228);
        }

        static {
            AppMethodBeat.i(194229);
            AppMethodBeat.o(194229);
        }
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(260048);
        String Lb = this.NNU.Lb();
        AppMethodBeat.o(260048);
        return Lb;
    }
}
