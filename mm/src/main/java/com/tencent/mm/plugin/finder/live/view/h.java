package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;

public final class h extends c {
    private static final b uzG = new b();
    public static final a uzH = new a((byte) 0);
    private final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context2, com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        p.h(context2, "context");
        p.h(aVar, "pageAdapter");
        AppMethodBeat.i(247538);
        this.context = context2;
        AppMethodBeat.o(247538);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b implements c.a {
        b() {
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void a(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(247535);
            p.h(multiTaskInfo, "multiTaskInfo");
            AppMethodBeat.o(247535);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void b(MultiTaskInfo multiTaskInfo) {
            awe awe;
            AppMethodBeat.i(247536);
            p.h(multiTaskInfo, "multiTaskInfo");
            aws aws = new aws();
            try {
                aws.parseFrom(multiTaskInfo.field_data);
            } catch (Throwable th) {
                Log.e("FinderLiveMultiTaskHelper", "MegaVideoFloatBallInfo parse fail", th);
            }
            aws.key = multiTaskInfo.field_id;
            if (p.j(aws.key, "wedraw")) {
                AppMethodBeat.o(247536);
                return;
            }
            ArrayList<LiveConfig> arrayList = new ArrayList<>();
            LinkedList<FinderObject> linkedList = aws.LHu;
            p.g(linkedList, "data.allHistoryFinderObjectList");
            if (!linkedList.isEmpty()) {
                LinkedList<FinderObject> linkedList2 = aws.LHu;
                p.g(linkedList2, "data.allHistoryFinderObjectList");
                LinkedList<FinderObject> linkedList3 = linkedList2;
                ArrayList arrayList2 = new ArrayList(j.a(linkedList3, 10));
                for (T t : linkedList3) {
                    m mVar = m.vVH;
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList2.add(m.q(t));
                }
                arrayList.addAll(arrayList2);
            } else {
                LiveConfig aBR = new LiveConfig.a().qo(LiveConfig.hvU).zt(aws.liveId).Gd(aws.hwg).zu(aws.hwe).Gg(aws.hwd).Gh(aws.desc).Gl(aws.sessionBuffer).aBR();
                p.g(aBR, "builder.toWhere(LiveConf…                 .build()");
                arrayList.add(aBR);
            }
            FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
            if (aws.LHu.size() > 0) {
                finderLiveConfig.uis = android.support.v4.b.a.clamp(aws.LHt, 0, aws.LHu.size() - 1);
            }
            finderLiveConfig.ac(arrayList);
            finderLiveConfig.dLS = 1010;
            FinderObject finderObject = aws.tuO;
            finderLiveConfig.extFlag = (finderObject == null || (awe = finderObject.liveInfo) == null) ? 0 : awe.LGU;
            ((ad) g.af(ad.class)).a(MMApplicationContext.getContext(), aws.hwd, new a(aws, finderLiveConfig));
            AppMethodBeat.o(247536);
        }

        static final class a implements ad.a {
            final /* synthetic */ aws uzI;
            final /* synthetic */ FinderLiveConfig uzJ;

            a(aws aws, FinderLiveConfig finderLiveConfig) {
                this.uzI = aws;
                this.uzJ = finderLiveConfig;
            }

            @Override // com.tencent.mm.plugin.i.a.ad.a
            public final void mM(boolean z) {
                String str;
                awe awe;
                AppMethodBeat.i(247534);
                if (!z) {
                    ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(MMApplicationContext.getContext());
                    AppMethodBeat.o(247534);
                    return;
                }
                FinderObject finderObject = this.uzI.tuO;
                int i2 = (finderObject == null || (awe = finderObject.liveInfo) == null) ? 0 : awe.uBn;
                k kVar = k.vkd;
                FinderObject finderObject2 = this.uzI.tuO;
                long j2 = finderObject2 != null ? finderObject2.id : this.uzI.hwe;
                long j3 = this.uzI.liveId;
                FinderObject finderObject3 = this.uzI.tuO;
                if (finderObject3 == null || (str = finderObject3.username) == null) {
                    str = this.uzI.hwd;
                }
                kVar.a(j2, j3, str, (long) this.uzI.LHt, (long) i2, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, s.j.COMMENT_SCENE_PULLDOWN_MENU.scene);
                Intent intent = new Intent();
                intent.putExtra("KEY_MULTI_TASK_INFO", this.uzI.toByteArray());
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                com.tencent.mm.plugin.finder.utils.a.a(context, this.uzJ, (String) null, (String) null, intent, 12);
                AppMethodBeat.o(247534);
            }
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void c(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(247537);
            p.h(multiTaskInfo, "multiTaskInfo");
            if (p.j(multiTaskInfo.field_id, "wedraw")) {
                AppMethodBeat.o(247537);
            } else {
                AppMethodBeat.o(247537);
            }
        }
    }

    static {
        AppMethodBeat.i(247539);
        AppMethodBeat.o(247539);
    }
}
