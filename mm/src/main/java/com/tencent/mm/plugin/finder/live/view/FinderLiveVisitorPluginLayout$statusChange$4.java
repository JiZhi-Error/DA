package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.ap;
import com.tencent.mm.protocal.protobuf.asu;
import kotlin.g.a.a;
import kotlin.g.a.r;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class FinderLiveVisitorPluginLayout$statusChange$4 implements Runnable {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$statusChange$4(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    public final void run() {
        AppMethodBeat.i(260859);
        s finderLiveAssistant = this.this$0.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.d(new r<Integer, Integer, String, asu, x>(this) {
                /* class com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout$statusChange$4.AnonymousClass1 */
                final /* synthetic */ FinderLiveVisitorPluginLayout$statusChange$4 this$0;

                {
                    this.this$0 = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.r
                public final /* synthetic */ x invoke(Integer num, Integer num2, String str, asu asu) {
                    AppMethodBeat.i(260857);
                    invoke(num.intValue(), num2.intValue(), str, asu);
                    x xVar = x.SXb;
                    AppMethodBeat.o(260857);
                    return xVar;
                }

                public final void invoke(final int i2, final int i3, String str, asu asu) {
                    AppMethodBeat.i(260858);
                    d.h(new a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout$statusChange$4.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 this$0;

                        {
                            this.this$0 = r2;
                        }

                        @Override // kotlin.g.a.a
                        public final void invoke() {
                            ap apVar;
                            AppMethodBeat.i(260856);
                            ap apVar2 = this.this$0.this$0.this$0.memberListPlugin;
                            if (apVar2 == null) {
                                AppMethodBeat.o(260856);
                            } else if (apVar2.hwr.getVisibility() == 0 && i3 == 0 && i2 == 0 && (apVar = this.this$0.this$0.this$0.memberListPlugin) != null) {
                                apVar.nw(true);
                                AppMethodBeat.o(260856);
                            } else {
                                AppMethodBeat.o(260856);
                            }
                        }
                    });
                    AppMethodBeat.o(260858);
                }
            });
            AppMethodBeat.o(260859);
            return;
        }
        AppMethodBeat.o(260859);
    }
}
