package com.tencent.mm.plugin.sns.storage;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/sns/storage/FinderSnsLiveStatusSyncSaver;", "", "()V", "SAVE_WHAT", "", "TAG", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "clearTask", "", "save", "snsinfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "plugin-sns_release"})
public final class d {
    public static final int Emg = 1;
    public static final d Emh = new d();
    private static final String TAG = TAG;
    private static final f lhN = g.ah(a.Emi);

    public static MMHandler bkj() {
        AppMethodBeat.i(201810);
        MMHandler mMHandler = (MMHandler) lhN.getValue();
        AppMethodBeat.o(201810);
        return mMHandler;
    }

    static {
        AppMethodBeat.i(201811);
        AppMethodBeat.o(201811);
    }

    private d() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<MMHandler> {
        public static final a Emi = new a();

        static {
            AppMethodBeat.i(201809);
            AppMethodBeat.o(201809);
        }

        a() {
            super(0);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
        /* renamed from: com.tencent.mm.plugin.sns.storage.d$a$a  reason: collision with other inner class name */
        static final class C1729a implements MMHandler.Callback {
            public static final C1729a Emj = new C1729a();

            static {
                AppMethodBeat.i(201807);
                AppMethodBeat.o(201807);
            }

            C1729a() {
            }

            public final boolean handleMessage(Message message) {
                return true;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(201808);
            d dVar = d.Emh;
            MMHandler mMHandler = new MMHandler(d.TAG, C1729a.Emj);
            mMHandler.setLogging(false);
            AppMethodBeat.o(201808);
            return mMHandler;
        }
    }
}
