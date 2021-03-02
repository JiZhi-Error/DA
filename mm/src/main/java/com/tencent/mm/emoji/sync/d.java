package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.sync.b;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.m;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "", "()V", "designerCallback", "com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1;", "designerQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "finishCount", "", "taskCount", "destroy", "", "start", "Companion", "plugin-emojisdk_release"})
public final class d {
    private static final String TAG = TAG;
    private static d hcH;
    public static final a hcI = new a((byte) 0);
    final com.tencent.mm.loader.g.d<b> hcD = new com.tencent.mm.loader.g.d<>(new f(new com.tencent.mm.loader.g.a.a(Integer.MAX_VALUE), new g(1, (byte) 0), 1, "EmojiDesigner"));
    private int hcE;
    private int hcF;
    final b hcG = new b(this);

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ EmojiGroupInfo hcP;

        c(EmojiGroupInfo emojiGroupInfo) {
            this.hcP = emojiGroupInfo;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(200003);
            c.a aVar = (c.a) obj;
            int i2 = aVar.errType;
            int i3 = aVar.errCode;
            Log.i(d.TAG, "CgiGetEmotionDetail end: " + i2 + ", " + i3);
            GetEmotionDetailResponse getEmotionDetailResponse = (GetEmotionDetailResponse) aVar.iLC;
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                bj emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiStorageMgr();
                p.g(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
                m gCL = emojiStorageMgr.gCL();
                EmojiGroupInfo emojiGroupInfo = this.hcP;
                p.g(emojiGroupInfo, "groupInfo");
                gCL.a(emojiGroupInfo.hYf(), getEmotionDetailResponse, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(200003);
            return xVar;
        }
    }

    public d() {
        AppMethodBeat.i(183984);
        this.hcD.a(this.hcG);
        AppMethodBeat.o(183984);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/emoji/sync/EmojiPackSyncManager$designerCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
    public static final class b implements com.tencent.mm.loader.g.f<b> {
        final /* synthetic */ d hcO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(d dVar) {
            this.hcO = dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(b bVar, j jVar) {
            AppMethodBeat.i(183981);
            b bVar2 = bVar;
            p.h(bVar2, "task");
            p.h(jVar, "status");
            Log.i(d.TAG, "onLoaderFin: " + bVar2.gWW + ", " + jVar);
            this.hcO.hcF++;
            if (this.hcO.hcF >= this.hcO.hcE) {
                a aVar = d.hcI;
                Log.i(d.TAG, "onDesignerEnd: ");
                k kVar = k.gXr;
                k.getKV().putInt("designer_sync_time", (int) Util.nowSecond());
                d dVar = d.hcH;
                if (dVar != null) {
                    dVar.hcD.clean();
                    dVar.hcD.b(dVar.hcG);
                }
                d.hcH = null;
            }
            AppMethodBeat.o(183981);
        }
    }

    public final void start() {
        AppMethodBeat.i(183983);
        com.tencent.mm.emoji.b.j auL = com.tencent.mm.emoji.b.j.auL();
        p.g(auL, "EmojiStorageCache.getInstance()");
        ArrayList<EmojiGroupInfo> auP = auL.auP();
        ArrayList<Number> arrayList = new ArrayList();
        Iterator<EmojiGroupInfo> it = auP.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EmojiGroupInfo next = it.next();
            bj gCJ = bj.gCJ();
            p.g(gCJ, "EmojiStorageMgr.getInstance()");
            m gCL = gCJ.gCL();
            p.g(next, "groupInfo");
            com.tencent.mm.storage.emotion.l blt = gCL.blt(next.hYf());
            GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
            if ((blt != null ? blt.field_content : null) != null) {
                try {
                    getEmotionDetailResponse.parseFrom(blt.field_content);
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                }
            }
            if (getEmotionDetailResponse.EmotionDetail == null || getEmotionDetailResponse.EmotionDetail.PersonalDesigner == null) {
                Log.i(TAG, "start: GetEmotionDetail " + next.hYf());
                if (!p.j(next.hYf(), String.valueOf(EmojiGroupInfo.VkN))) {
                    String hYf = next.hYf();
                    p.g(hYf, "groupInfo.productID");
                    new com.tencent.mm.emoji.b.d(hYf).aYI().g(new c(next));
                } else {
                    continue;
                }
            } else {
                int i2 = getEmotionDetailResponse.EmotionDetail.PersonalDesigner.DesignerUin;
                if (!arrayList.contains(Integer.valueOf(i2))) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            if (arrayList.size() >= 50) {
                Log.i(TAG, "start: too many groups " + auP.size());
                break;
            }
        }
        this.hcE = arrayList.size();
        for (Number number : arrayList) {
            int intValue = number.intValue();
            Log.i(TAG, "checkStart: add task ".concat(String.valueOf(intValue)));
            this.hcD.c(new b(intValue));
        }
        AppMethodBeat.o(183983);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager$Companion;", "", "()V", "TAG", "", "runningSyncTask", "Lcom/tencent/mm/emoji/sync/EmojiPackSyncManager;", "checkPack", "", "productId", "checkStart", "onDesignerEnd", "plugin-emojisdk_release"})
    public static final class a {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", OpenSDKTool4Assistant.EXTRA_UIN, "", "invoke"})
        public static final class b extends q implements kotlin.g.a.b<Integer, x> {
            public static final b hcM = new b();

            static {
                AppMethodBeat.i(183978);
                AppMethodBeat.o(183978);
            }

            b() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(183977);
                int intValue = num.intValue();
                bg.a aVar = bg.a.Opu;
                bg aki = bg.a.aki(intValue);
                Log.i(d.TAG, "checkPack: checkDesigner " + intValue + ' ' + aki.LGy.size());
                if (aki.LGy.isEmpty()) {
                    new b.a(intValue).awg();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(183977);
                return xVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class c extends q implements kotlin.g.a.a<x> {
            public static final c hcN = new c();

            static {
                AppMethodBeat.i(183980);
                AppMethodBeat.o(183980);
            }

            c() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(183979);
                k kVar = k.gXr;
                long secondsToNow = Util.secondsToNow((long) k.getKV().getInt("designer_sync_time", 0));
                int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_designer_sync_interval, 0);
                Log.i(d.TAG, "checkStart: " + (secondsToNow / 3600) + ", " + a2);
                if (a2 > 0 && secondsToNow > ((long) a2) * 3600 && d.hcH == null) {
                    d.hcH = new d();
                    d dVar = d.hcH;
                    if (dVar != null) {
                        dVar.start();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(183979);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.emoji.sync.d$a$a  reason: collision with other inner class name */
        public static final class C0338a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ String hcJ;
            final /* synthetic */ kotlin.g.a.b hcK;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0338a(String str, kotlin.g.a.b bVar) {
                super(0);
                this.hcJ = str;
                this.hcK = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(183976);
                bj gCJ = bj.gCJ();
                p.g(gCJ, "EmojiStorageMgr.getInstance()");
                com.tencent.mm.storage.emotion.l blt = gCJ.gCL().blt(this.hcJ);
                GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
                if ((blt != null ? blt.field_content : null) != null) {
                    try {
                        getEmotionDetailResponse.parseFrom(blt.field_content);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(d.TAG, e2, "", new Object[0]);
                    }
                }
                if (getEmotionDetailResponse.EmotionDetail == null || getEmotionDetailResponse.EmotionDetail.PersonalDesigner == null) {
                    Log.i(d.TAG, "checkPack: getEmojiDetail");
                    new com.tencent.mm.emoji.b.d(this.hcJ).aYI().g(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                        /* class com.tencent.mm.emoji.sync.d.a.C0338a.AnonymousClass1 */
                        final /* synthetic */ C0338a hcL;

                        {
                            this.hcL = r1;
                        }

                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(Object obj) {
                            PersonalDesigner personalDesigner;
                            AppMethodBeat.i(183975);
                            c.a aVar = (c.a) obj;
                            int i2 = aVar.errType;
                            int i3 = aVar.errCode;
                            Log.i(d.TAG, "CgiGetEmotionDetail end: " + i2 + ", " + i3);
                            GetEmotionDetailResponse getEmotionDetailResponse = (GetEmotionDetailResponse) aVar.iLC;
                            if (i2 == 0 && i3 == 0) {
                                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                                p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                                bj emojiStorageMgr = ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiStorageMgr();
                                p.g(emojiStorageMgr, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
                                emojiStorageMgr.gCL().a(this.hcL.hcJ, getEmotionDetailResponse, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
                                EmotionDetail emotionDetail = getEmotionDetailResponse.EmotionDetail;
                                if (!(emotionDetail == null || (personalDesigner = emotionDetail.PersonalDesigner) == null)) {
                                    this.hcL.hcK.invoke(Integer.valueOf(personalDesigner.DesignerUin));
                                }
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(183975);
                            return xVar;
                        }
                    });
                } else {
                    this.hcK.invoke(Integer.valueOf(getEmotionDetailResponse.EmotionDetail.PersonalDesigner.DesignerUin));
                }
                x xVar = x.SXb;
                AppMethodBeat.o(183976);
                return xVar;
            }
        }
    }

    static {
        AppMethodBeat.i(183985);
        AppMethodBeat.o(183985);
    }
}
